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

import com.gl.ods.model.Product;
import com.gl.ods.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private LoginService service;
   
   private RequestDispatcher rd;
   
    public LoginServlet() {
      service=new LoginService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session;
		String id=request.getParameter("uid");
		String password=request.getParameter("password");
		int uid=Integer.parseInt(id);
		String r[]=service.authenticate(uid, password);
		if(r[0].equals("A"))
		{
			session=request.getSession();
			session.setAttribute("name", r[1]);
			
			List<Product> prds=service.getAllProduct();
			session.setAttribute("prds", prds);
			
			out.println("<h1>Welcome  "+r[1]+"</h1>");
			rd=request.getRequestDispatcher("productList.jsp");
			rd.include(request, response);
		}
		else if(r[0].equals("U"))
		{
			session=request.getSession();
			session.setAttribute("name", r[1]);
			
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
