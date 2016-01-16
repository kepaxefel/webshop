package com.shop.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.shop.domains.User;
import com.shop.exception.NotEqualPasswords;
import com.shop.forms.UserForm;
import com.shop.managers.UsersManagerInterface;

@Controller
public class UsersController {

	@Autowired
   	UsersManagerInterface usersManager;
	
	@Autowired
	MessageDigestPasswordEncoder passwordEncoder;

	@RequestMapping(value = "adminpanel/getusers", method = RequestMethod.GET)	
	public String getUsers(Model model){
		List<User> users = usersManager.getUsers();
		model.addAttribute("users", users);	 
		return ("userslist");
	}
	
	@RequestMapping(value = "adminpanel/deleteuser", method = RequestMethod.GET)
	public String deleteUser(Model model, @RequestParam(value="id", required=true) int id){
		usersManager.deleteUser(id);
		String message = "Пользователь с ID " + Integer.toString(id) + " удален";
		model.addAttribute("message", message);
		model.addAttribute("link", "getusers");
		return ("message");
	}	
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser (Model model, @ModelAttribute("userForm") UserForm userForm) {
		boolean gender = userForm.getGender().equals("m");
		if (!userForm.getPassOne().equals(userForm.getPassTwo())) {
			throw new NotEqualPasswords();
		}
		
		String passwordHash = passwordEncoder.encodePassword(userForm.getPassOne(), null);
		
		User user = new User(userForm.getName(), userForm.getSurname(), userForm.getLogin(), passwordHash,
				userForm.getEmail(), userForm.getNumber(), gender, "USER");
		usersManager.addUser(user);
		return ("index");		
	}
}
