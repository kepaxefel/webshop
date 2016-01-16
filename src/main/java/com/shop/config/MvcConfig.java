package com.shop.config;

import javax.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.shop.managers.ProductsManagerInterface;
import com.shop.service.MenuFilter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private ProductsManagerInterface productsManager;
	
	 @Override
	 public void addViewControllers(ViewControllerRegistry registry) {
		 registry.addViewController("/").setViewName("index");
	     registry.addViewController("/about").setViewName("about");
	     registry.addViewController("/contacts").setViewName("contacts");
	     registry.addViewController("/delivery").setViewName("delivery");
	 }
	 
	 @Bean
	 public FilterRegistrationBean shallowHeaderFilter() {
		 FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		 Filter menuFilter = new MenuFilter(productsManager);
	     registrationBean.setFilter(menuFilter);
	     registrationBean.addUrlPatterns("/*");	     
	     return registrationBean;
	 }
}
