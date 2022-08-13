package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class calcul {
	
	@PersistenceContext(unitName="ecommerce")
	private EntityManagerFactory emf; 
	
	public calcul()
	{
		emf = Persistence.createEntityManagerFactory("ecommerce");
	}
	 public double getTotalCartPrice(ArrayList<Cart> cartList) {
		 double sum = 0;
		 if (cartList.size() > 0) {
			 for (Cart item : cartList) {
				 EntityManager em = emf.createEntityManager();
			     Product product= em.find(Product.class,item.getId());
			     sum+=product.getPrice()*item.getQuantity();
			 }
		 }
		 return sum;
	 }
	 
	 
	 public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
		 List<Cart> book = new ArrayList<>();
		 if (cartList.size() > 0) {
			 for (Cart item : cartList) {
				 EntityManager em = emf.createEntityManager();
			     Product product= em.find(Product.class,item.getId());
			     Cart row = new Cart();
			     row.setId(product.getId());
                 row.setName(product.getName());
                 row.setCategory(product.getCategory());
                 row.setPrice(product.getPrice()*item.getQuantity());
                 row.setQuantity(item.getQuantity());
                 book.add(row);
				 
			 }
			 
		 }
		 return book;
	 }
	 public boolean insertOrder(Order model)
		{
			boolean result = false;
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(model);
			em.getTransaction().commit();
			result = true;
			return result;
		}


}
