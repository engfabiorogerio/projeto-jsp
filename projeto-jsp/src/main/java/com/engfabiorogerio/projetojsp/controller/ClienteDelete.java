package com.engfabiorogerio.projetojsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engfabiorogerio.projetojsp.dao.ClienteDAO;


@WebServlet("/ClienteDestroy")
public class ClienteDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ClienteDelete() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cliente = Integer.parseInt(request.getParameter("clienteId"));
		
		ClienteDAO.delete(cliente);
	
		ClienteCreateAndFind clienteCreateAndFind = new ClienteCreateAndFind();
		clienteCreateAndFind.doGet(request, response);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("lista.jsp");
		requestDispatcher.forward(request, response);
		
	
	}	

}
