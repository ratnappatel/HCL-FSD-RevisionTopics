package com.gl.ods.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import com.gl.ods.config.SpringConfig;
import com.gl.ods.model.Product;
import com.gl.ods.model.User;
import com.gl.ods.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
@Controller
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private LoginServiceImpl service;
   
   private RequestDispatcher rd;
   
    public LoginServlet() {
    	ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
		service=ctx.getBean(LoginServiceImpl.class);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session;
		String id=request.getParameter("uid");
		String password=request.getParameter("password");
		int uid=Integer.parseInt(id);
		User u=service.authenticate(uid, password);
		if(u.getType().equals("A"))
		{
			session=request.getSession();
			session.setAttribute("name", u.getName());
			
			List<Product> prds=service.getAllProduct();
			session.setAttribute("prds", prds);
			
			out.println("<h1>Welcome  "+u.getName()+"</h1>");
			rd=request.getRequestDispatcher("productList.jsp");
			rd.include(request, response);
		}
		else if(u.getType().equals("U"))
		{
			session=request.getSession();
			session.setAttribute("name",u.getName());
			
			rd=request.getRequestDispatcher("userPage.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.println("<font color=red>Login Id or Password is Incorrect Please TRY Again");
			rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}	
		
	}

}
