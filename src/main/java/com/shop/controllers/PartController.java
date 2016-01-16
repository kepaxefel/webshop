package com.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.forms.UserForm;
import com.shop.managers.ProductsManagerInterface;
import com.shop.managers.UsersManagerInterface;

@Controller
public class PartController {
	
	@Autowired
   	ProductsManagerInterface productsManager;
	
	@Autowired
	UsersManagerInterface usersManager;	
	
	@RequestMapping(value = "/products/{section}")
	public String getSection(@PathVariable("section") String section, Model model) {
		model.addAttribute("products", productsManager.getPartOfProducts(section));
		return "products";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)	
	public String getRegistration(Model model, @ModelAttribute("userForm") UserForm userForm){
		return ("registration");
	}	
}
