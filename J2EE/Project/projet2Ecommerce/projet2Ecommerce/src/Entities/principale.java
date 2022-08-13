package Entities;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;




public class principale {
	public principale()
	{
	}

	private static String baseURL = "http://localhost:8080/NotreProjetJ2e/api/shop";
	
	static WebTarget getWebTarget() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		return client.target(baseURL);
	}
	
	public static void deleteOrder(int id) {
		WebTarget target = getWebTarget();
		String URL = "/cancelOrder/" + id;
		Response reponse = target.path(URL).request().delete(Response.class);
		System.out.println(reponse);
	}
	
	public static List<Product> getAllProducts(){
		List<Product> products = new ArrayList<>();
		WebTarget target = getWebTarget();
		products = target.path("/getAllProducts").request().accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Product>>() {});
		return products;
	}
	public void  createOrder(Order order) {
		WebTarget target = getWebTarget();
		Response reponse = target.path("/insertOrder").request().post(Entity.entity(order, MediaType.APPLICATION_JSON), Response.class);
		System.out.println(reponse);
		
	}
	
	
	public static List<Order> getAllUserOrder(int id){
		List<Order> orders = new ArrayList<>();
		WebTarget target = getWebTarget();
		String URL = "/userOrders/" + id;
		orders = target.path(URL).request().accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Order>>() {});
		return orders;
	}
	public Product getProductById(int id) {
		WebTarget target = getWebTarget();
		String URL = "/getSingleProduct/" + id;
		System.out.println(URL);
	    Product product = target.path(URL).request().accept(MediaType.APPLICATION_JSON).get(Product.class);
		return product;
	}
	public static User getUser( String email, String password) {
		WebTarget target = getWebTarget();
		String URL = "/userLogin/" + email +"/"+ password;
		System.out.println(URL);
	    User user = target.path(URL).request().accept(MediaType.APPLICATION_JSON).get(User.class);
		return user;
	}

}
