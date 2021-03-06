package com.shop.managers;

import java.util.List;
import com.shop.domains.Product;
import com.shop.domains.Section;

public interface ProductsManagerInterface {
	public <T> void addEntity(T entity);
	public List<Product> getProducts();
	public List <Product> getPartOfProducts(String productsPart);
	public Product getProduct(int id) ;
	public void deleteProduct(int id);
	public void editProduct(Product product);
	public List <Section> getSections();
	public void deleteSection(int id);
	public void editSection(Section section);
	public Section getSection(int id);
	
}
