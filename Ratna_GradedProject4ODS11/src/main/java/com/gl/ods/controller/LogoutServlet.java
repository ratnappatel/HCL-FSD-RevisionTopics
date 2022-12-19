package com.gl.ods.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
@Controller
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
    {
    	HttpSession session=request.getSession(false);
    	session.invalidate();
    	RequestDispatcher rd=request.getRequestDispatcher("index.html");
    	rd.forward(request, response);
    }

}
