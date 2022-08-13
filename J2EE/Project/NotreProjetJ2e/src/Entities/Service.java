package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

@Path("/shop")
public class Service {
	private Repertoire dao = new Repertoire();
	@Path("/test")
	@GET 
	@Produces(MediaType.TEXT_PLAIN)
	public String testService()
	{	
		return "test";
	}
	
	@Path("/hello")
	@GET 
	@Produces(MediaType.TEXT_PLAIN)
	public String hello()
	{	
		return "Hello World ";
	}
	
	
	
	@Path("/getAllProducts")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts(){
		return dao.getAllProducts();
	}

	
	@Path("/insertOrder")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public void createOrder(Order order) {
		 dao.insertOrder(order);
	}
	
	
	@Path("/userOrders/{id}")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getUserOrder(@PathParam("id") int id){
		return dao.userOrders(id);
	}
	
	@Path("/cancelOrder/{id}")
	@DELETE
	public void deleteOrder(@PathParam("id") int id) {
		dao.cancelOrder(id);
	}
	

	
	
	@Path("/getSingleProduct/{id}")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("id") int id){
		return dao.getSingleProduct(id);
	}
	
	@Path("/userLogin/{email}/{password}")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("email") String email,@PathParam("password") String password){
		return dao.userLogin(email, password);
	}
}
