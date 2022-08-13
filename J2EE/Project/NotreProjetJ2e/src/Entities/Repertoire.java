package Entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

public class Repertoire {
	@PersistenceContext(unitName="sirine")
	private EntityManagerFactory emf; 
	
	public Repertoire() {
		emf = Persistence.createEntityManagerFactory("sirine");
	}
		
	
	public User userLogin(String email, String password) {
		User user = null;
		 List<User> book = new ArrayList<>();
		 
	     EntityManager em = emf.createEntityManager();
		 book= em.createQuery("From User",User.class).getResultList();
		 for(User u :book)
		 {
			 if( u.getEmail().equals(email) && u.getPassword().equals(password))
			 {
				 user=u;
			 }
		 }
		 return user;
	}
	
	public List<Product> getAllProducts() {
        List<Product> book = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
		book= em.createQuery("From Product",Product.class).getResultList();
        
        return book;
    }
	 public Product getSingleProduct(int id) {
	     EntityManager em = emf.createEntityManager();
	     return em.find(Product.class,id);
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
	
	public List<Order> userOrders(int id) {	 
		  List<Order> list2 = new ArrayList<>();
		  List<Order> listFinale = new ArrayList<>();
		  List<Order> list = new ArrayList<>();
		  EntityManager em = emf.createEntityManager();
		  list= em.createQuery("From Order",Order.class).getResultList();
		  for (Order o: list)
		  {
			  if (o.getUid()==id)
			  {
				  listFinale.add(o);
			  }
		  }
		  for (Order o: listFinale)
		  {
			  Order order = new Order();
			  int pId=o.getPid();
			//  ProductDao pdao = new ProductDao();
			//  Product product= em.find(Product.class,pId);
			  Product productt=getSingleProduct(pId);
			  order.setOrderId(o.getOrderId());
              order.setName(productt.getName());
              order.setCategory(productt.getCategory());
              order.setPrice(productt.getPrice()*o.getQunatity());
              order.setQunatity(o.getQunatity());
              order.setDate(o.getDate());
              list2.add(order);
		  }
		   
		   
		return list2;
	}
	 public void cancelOrder(int id) {
		  EntityManager em = emf.createEntityManager();
		  EntityTransaction tx = em.getTransaction();
		   tx.begin();
	        em.remove(em.find(Order.class,id));
	        tx.commit();
	 }
	}
	


   
    

