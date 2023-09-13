package com.engfabiorogerio.projetojsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engfabiorogerio.projetojsp.dao.ClienteDAO;
import com.engfabiorogerio.projetojsp.model.Cliente;


@WebServlet(name = "ClienteCreateAndFind", urlPatterns = { "/CreateAndFind" })
public class ClienteCreateAndSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ClienteCreateAndSelect() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = new Cliente();
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNascimento(request.getParameter("nascimento"));
		cliente.setSituacao(request.getParameter("situacao"));
		
		ClienteDAO.create(cliente);
	}

}
