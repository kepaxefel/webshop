package com.shop.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import com.shop.exception.InvalidPassword;
import com.shop.exception.NotAuthorized;
import com.shop.exception.NotEqualPasswords;

@ControllerAdvice()
public class RestExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);
	        
    @ExceptionHandler(value = {InvalidPassword.class})
    @ResponseBody
    public ModelAndView errorPassword(InvalidPassword ex, WebRequest request) {
    	log.debug("----InvalidPasswordException----");
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("error", "Неверный пароль");
    	mav.setViewName("errorpage");
    	return mav;
 	 }
    
    @ExceptionHandler(value = {NotEqualPasswords.class})
    @ResponseBody
    public ModelAndView notEqualPass(NotEqualPasswords ex, WebRequest request) {
    	log.debug("----not equal pass----");
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("error", "Введенные пароли различны");
    	mav.setViewName("errorpage");
    	return mav;
 	 }
     
    @ExceptionHandler(value = {UsernameNotFoundException.class})
    @ResponseBody
    public ModelAndView usernameNotFoundException(UsernameNotFoundException ex, WebRequest request) {
    	log.debug("----InvalidPasswordException----");
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("error", "Пользователь с таким логином не найден");
    	mav.setViewName("errorpage");
    	return mav;
 	 }
    
    @ExceptionHandler(value = {NotAuthorized.class})
    @ResponseBody
    public ModelAndView notAuthorized(NotAuthorized ex, WebRequest request) {
    	log.debug("---- NotAuthorized ----");
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("error", "Чтобы совершить покупку, Вам необходимо авторизироваться!");
    	mav.setViewName("errorpage");
    	return mav;
 	 }
    
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ModelAndView getError(Exception exception, WebRequest request) {
    	log.debug("----Exception----");
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("error", exception);
    	mav.setViewName("errorpage");
    	return mav;
 	 }    
}
