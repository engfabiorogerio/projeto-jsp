package com.engfabiorogerio.projetojsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.engfabiorogerio.projetojsp.db.MySqlConnection;
import com.engfabiorogerio.projetojsp.model.Cliente;


public class ClienteDAO implements CRUD {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void  create(Cliente cliente) {
		
		sql ="INSERT INTO clientes VALUES(null, ?, ?, ?, ?)";
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			preparedStatement.setString(4, cliente.getSituacao());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Dados inseridos no Banco de Dados");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	};
	
	public static void delete(int clienteId) {
		
		
		
	};
	
	public static List<Cliente> find(String pesquisa) {
		
		sql = String.format("SELECT * FROM clientes WHERE nome like '%s%%' OR cpf like '%s%%'", pesquisa, pesquisa);
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimnento"));
				cliente.setSituacao(resultSet.getString("situacao"));
				
				clientes.add(cliente);
				
			}
			
			System.out.println("Localizado");
			return clientes;
			
		} catch (SQLException e) {
			System.out.println("Não Localizado" + e.getMessage());			
			
			return null;
		}
				
		
		
	}
	
	
	public static Cliente findByPk(int clienteId) {
		
		return null;
		
	}
	public static void update(Cliente cliente) {
		
		
		
	};
	
}
