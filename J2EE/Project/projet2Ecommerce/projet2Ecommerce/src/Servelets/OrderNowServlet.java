package Servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Cart;
import Entities.Order;
import Entities.Product;
import Entities.User;
import Entities.calcul;
import Entities.principale;





@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            User auth = (User) request.getSession().getAttribute("auth");

            if (auth != null) {
                String productId = request.getParameter("id");
                int productQuantity = Integer.parseInt(request.getParameter("quantity"));
                
                if (productQuantity <= 0) {
                	productQuantity = 1;
                }
                calcul ca= new calcul();
                principale pd = new principale();
                Order orderModel = new Order();
                orderModel.setPid(Integer.parseInt(productId));
                orderModel.setOrderId(Integer.parseInt(productId));
                orderModel.setUid(auth.getId());
                orderModel.setQunatity(productQuantity);
                orderModel.setDate(formatter.format(date));
                  orderModel.setCategory(pd.getProductById(Integer.parseInt(productId)).getCategory());
                orderModel.setName(pd.getProductById(Integer.parseInt(productId)).getName());
                orderModel.setPrice(pd.getProductById(Integer.parseInt(productId)).getPrice());
                boolean result = ca.insertOrder(orderModel);
                if (result) {
                    ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
                    if (cart_list != null) {
                        for (Cart c : cart_list) {
                            if (c.getId() == Integer.parseInt(productId)) {
                                cart_list.remove(cart_list.indexOf(c));
                                break;
                            }
                        }
                    }
                    response.sendRedirect("orders.jsp");
                } else {
                    out.println("order failed");
                }
            } else {
                response.sendRedirect("login.jsp");
            }

        } 
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
