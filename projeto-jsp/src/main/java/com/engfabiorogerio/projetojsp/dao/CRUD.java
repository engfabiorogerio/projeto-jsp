package com.engfabiorogerio.projetojsp.dao;

import java.util.List;

import com.engfabiorogerio.projetojsp.model.Cliente;
import com.mysql.cj.xdevapi.Client;

public interface CRUD {

	public static void  create(Cliente cliente) {};
	public static void delete(int clienteId) {};
	public static List<Cliente> find(String pesquisa) {return null;}
	public static Client findByPk(int clientId) {return null;}
	public static void update(Cliente cliente) {};
	
}
