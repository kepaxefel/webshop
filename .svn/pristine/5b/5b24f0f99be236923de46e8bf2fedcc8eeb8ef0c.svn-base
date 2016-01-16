package com.shop.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.shop.domains.Section;
import com.shop.managers.ProductsManagerInterface;

public class MenuFilter implements Filter {
	private ProductsManagerInterface productsManager;

	public MenuFilter(ProductsManagerInterface productsManager) {
		this.productsManager = productsManager;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
			
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		chain.doFilter(request, response);
		String url = ((HttpServletRequest)request).getRequestURL().toString();
		if(!url.contains("adminpanel")){
			List <Section> sections = productsManager.getSections();
			request.setAttribute("sections", sections);
		}
	}

	@Override
	public void destroy() {
				
	}

}
