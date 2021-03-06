package com.shop.managers;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shop.domains.Product;
import com.shop.domains.Section;

@Repository
@Transactional
@EnableCaching
public class ProductsManager implements ProductsManagerInterface{
	
	
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public <T> void addEntity(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);		
	}

	@Override
	public List<Product> getProducts(){		
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Product> products = session.createCriteria(Product.class).list();			 
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getPartOfProducts(String productsPart) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Product.class)
				.add(Restrictions.like("productsPart", productsPart));
		List <Product> partofProd = cr.list();
		return partofProd;		
	}

	@Override
	public Product getProduct(int id){
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		return product;
	}

	@Override
	public void deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);				
		session.delete(product);
	}

	@Override
	public void editProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		Product existingProduct = (Product)session.get(Product.class, product.getId());
		existingProduct.setProductsName(product.getProductsName());
		existingProduct.setProductsPart(product.getProductsPart());
		existingProduct.setCost(product.getCost());
		if (product.getImage().length > 0) existingProduct.setImage(product.getImage());
		session.save(existingProduct);	
	}
	
	@Override
	@Cacheable("sections")
	public List <Section> getSections() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Section> sections = session.createCriteria(Section.class).list();
		return sections;
	}	

	@Override
	public void deleteSection(int id) {
		Session session = sessionFactory.getCurrentSession();
		Section section = (Section) session.get(Section.class, id);				
		session.delete(section);		
	}

	@Override
	public void editSection(Section section) {
		Session session = sessionFactory.getCurrentSession();
		Section existingSection = (Section)session.get(Section.class, section.getId());
		existingSection.setSection(section.getSection());
		existingSection.setLink(section.getLink());
		session.save(existingSection);			
	}

	@Override
	public Section getSection(int id) {
		Session session = sessionFactory.getCurrentSession();
		Section section = (Section) session.get(Section.class, id);
		return section;
	}		
	
	/*@Override
	public void addSection(Section section) {
		Session session = sessionFactory.getCurrentSession();
		session.save(section);		
	}*/
	
	/*@Override
	public void addProduct(Product product){
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
	}*/
}