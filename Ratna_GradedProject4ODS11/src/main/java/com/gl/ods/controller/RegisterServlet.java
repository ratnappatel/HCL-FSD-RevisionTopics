package com.gl.ods.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gl.ods.model.User;
import com.gl.ods.service.LoginServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
@Controller
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Autowired
	private LoginServiceImpl service;
	private User u;
	RequestDispatcher rd;
	
    public RegisterServlet() {
     
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		int uid=Integer.parseInt(id);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		u=new User(uid, name, email, password, "U");
		
		int ra=service.registerUser(u);
		if(ra>0)
		{
			out.println("Registration Successful.Now Login to Your ACCOUNT ");
			rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		
	
	}

}
