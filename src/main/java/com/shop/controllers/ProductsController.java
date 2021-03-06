package com.shop.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.shop.domains.Order;
import com.shop.domains.Product;
import com.shop.domains.Section;
import com.shop.domains.User;
import com.shop.exception.NotAuthorized;
import com.shop.forms.ProductForm;
import com.shop.forms.SectionForm;
import com.shop.managers.OrdersManagerInterface;
import com.shop.managers.ProductsManagerInterface;

@Controller
@Scope("session")
public class ProductsController {
	
	@Autowired
   	ProductsManagerInterface productsManager;
	
	@Autowired
	OrdersManagerInterface ordersManager;
	
	private List <Product> products = new ArrayList<>();	
	
	public List <String> getSections(){
		List <Section> parts = productsManager.getSections();
		List <String> partsList = new ArrayList<>();
		for(Section section : parts){
			partsList.add(section.getLink());
		}
		return partsList;
	}

	@RequestMapping(value = "adminpanel/addproduct", method = RequestMethod.GET)
	public String getAddedProduct(Model model, @ModelAttribute("productForm") ProductForm productForm) {		
        model.addAttribute("partsList", getSections());        
		return ("addproduct");
	} 
	
	@RequestMapping(value = "adminpanel/saveproduct", method = RequestMethod.POST)
	public String saveProduct (Model model,@ModelAttribute("productForm") ProductForm productForm) throws IOException{
		Product product = new Product(productForm.getProductsName(), productForm.getProductsPart(), productForm.getCost());
		product.setImage(productForm.getImage().getBytes());
		productsManager.addEntity(product);
		String message = ("Товар " + productForm.getProductsName() + " успешно добавлен");
		model.addAttribute("message", message);
		model.addAttribute("link", "addproduct");
		return ("message");
	}
	
	@RequestMapping(value = "adminpanel/editproduct", method = RequestMethod.GET)
	public String editProduct (Model model, @RequestParam(value="id", required=true) int id){
		model.addAttribute("partsList", getSections());
		model.addAttribute("productAttribute", productsManager.getProduct(id));		
		return ("editproduct");
	}
	
	@RequestMapping(value = "adminpanel/saveeditproduct", method = RequestMethod.POST)
	public String saveEditProduct (Model model,@ModelAttribute("productAttribute") ProductForm productForm) throws IOException{
		Product product = new Product(productForm.getProductsName(), productForm.getProductsPart(), productForm.getCost(), productForm.getId());
		product.setImage(productForm.getImage().getBytes());
		productsManager.editProduct(product);
		String message = ("Товар " + productForm.getProductsName() + " успешно изменен");
		model.addAttribute("message", message);
		model.addAttribute("link", "getproducts");
		return ("message");
	}
	
	@RequestMapping(value = "adminpanel/getproducts", method = RequestMethod.GET)	
	public String getProducts(Model model) {
		String[] columnNames = {"Наименование", "Отдел", "Цена", "Изображение", "Удаление"};
		List<Product> products = productsManager.getProducts();			
		model.addAttribute("columnNames", columnNames);
		model.addAttribute("products", products);
		return("productslist");
	}
	
	@RequestMapping(value = "adminpanel/deleteproduct", method = RequestMethod.GET)
	public String deleteUser(Model model, @RequestParam(value="id", required=true) int id){
		productsManager.deleteProduct(id);
		String message = ("Продукт с ID " + Integer.toString(id) + " удален");
		model.addAttribute("message", message);
		model.addAttribute("link","getproducts");
		return ("message");
	}
	
	@RequestMapping(value = "/buyproduct", method = RequestMethod.GET)
	public String buyProduct(Model model, @RequestParam(value="id", required=true) int id, HttpServletRequest request){
		Product product = productsManager.getProduct(id);
		if(request.isUserInRole("USER")) products.add(product);
		else throw new NotAuthorized();
		return ("redirect:" + request.getHeader("Referer"));		
	}
	
	@RequestMapping(value = "/getbuyproducts", method = RequestMethod.GET)
	public String getBuyProduct(Model model) {			
		double sum = 0;
		for(Product product : products){
			sum =  Double.parseDouble(product.getCost()) + sum; 
		}
		model.addAttribute("buyProducts", products);
		model.addAttribute("sum", sum);
		return ("cart");  
	}
	
	@RequestMapping(value = "/cleancart", method = RequestMethod.GET)
	public String cleancart(Model model) {
		products.clear();
		model.addAttribute("buyProducts", products);
		return ("cart");
	}
	
	@RequestMapping(value = "/saveorder", method = RequestMethod.GET)
	public String saveOrder(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = (User)auth.getPrincipal();

		for (Product product : products){
			Order order = new Order(product.getProductsName(), product.getProductsPart(), product.getCost(),
					currentUser.getId());
			ordersManager.addOrder(order);	
		}
		products.clear();
		model.addAttribute("message", "Спасибо за покупку! Наш менеджер свяжется с Вами!");
		model.addAttribute("link", "/" );
		return ("message");
	}
	
	@RequestMapping(value = "adminpanel/getorders", method = RequestMethod.GET)
	public String getOrders(Model model){
		String[] columnNames = {"ID", "Наименование", "Отдел", "Цена", "Имя", "Фамилия", "Телефон", "Дата", "Удалить"};
		List<Order> orders = ordersManager.getOrders();
		model.addAttribute("columnNames", columnNames);
		model.addAttribute("orders", orders);
		return ("orders");
	}
	
	@RequestMapping(value = "adminpanel/deleteorder", method = RequestMethod.GET)
	public String deleteOrder(Model model, @RequestParam(value="id", required=true) int id){
		ordersManager.deleteOrder(id);
		String message = ("Заказ с ID " + Integer.toString(id) + " удален");
		model.addAttribute("message", message);
		model.addAttribute("link", "getorders");
		return ("message");
	}
	
	@RequestMapping(value = "adminpanel/sections", method = RequestMethod.GET)
	public String getSections (Model model){		
        List <Section> sections = productsManager.getSections();
		model.addAttribute("sections", sections);        
		return ("sections");
	} 
	
	@RequestMapping(value = "adminpanel/addsection", method = RequestMethod.GET)
	public String addSection(Model model, @ModelAttribute("sectionForm") SectionForm sectionForm) {		
        model.addAttribute("partsList", getSections());        
		return ("addsection");
	}
	
	@RequestMapping(value = "adminpanel/savesection", method = RequestMethod.POST)
	public String saveSection (Model model,@ModelAttribute("sectionForm") SectionForm sectionForm) throws IOException{
		Section section = new Section(sectionForm.getSection(), sectionForm.getLink());
		productsManager.addEntity(section);
		String message = ("Отдел " + sectionForm.getSection() + " успешно добавлен");
		model.addAttribute("message", message);
		model.addAttribute("link", "addsection");
		return ("message");
	}
	
	@RequestMapping(value = "adminpanel/deletesection", method = RequestMethod.GET)
	public String deleteSection(Model model, @RequestParam(value="id", required=true) int id){
		productsManager.deleteSection(id);
		String message = ("Отдел с ID " + Integer.toString(id) + " удален");
		model.addAttribute("message", message);
		model.addAttribute("link", "sections");
		return ("message");
	}
	
	@RequestMapping(value = "adminpanel/editsection", method = RequestMethod.GET)
	public String editSection (Model model, @RequestParam(value="id", required=true) int id){
		model.addAttribute("partsList", getSections());
		model.addAttribute("sectionForm", productsManager.getSection(id));		
		return ("sectionedit");
	}
	
	@RequestMapping(value = "adminpanel/saveeditsection", method = RequestMethod.POST)
	public String saveEditSection (Model model,@ModelAttribute("sectionForm") SectionForm sectionForm) throws IOException{
		Section section = new Section(sectionForm.getSection(), sectionForm.getLink(), sectionForm.getId());
		productsManager.editSection(section);
		String message = ("Отдел " + sectionForm.getSection() + " успешно изменен");
		model.addAttribute("message", message);
		model.addAttribute("link", "sections");
		return ("message");
	}	
}
