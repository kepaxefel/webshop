package com.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.forms.ProductForm;
import com.shop.managers.ProductsManagerInterface;


@Controller
public class AdminPanelController {
	
	@Autowired
	ProductsManagerInterface productsManager;

	@RequestMapping(value = "/adminpanel", method = RequestMethod.GET)
	public String getProducts(Model model, @ModelAttribute("productForm") ProductForm productForm) {
		return "adminpanel";
	}	
}
