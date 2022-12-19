package com.gl.ods.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.gl.ods.model.Product;
import com.gl.ods.model.ProductMapper;
import com.gl.ods.model.User;
import com.gl.ods.model.UserMapper;

@Component
public class LoginServiceImpl {
	
	JdbcTemplate template;
	
	public LoginServiceImpl(DataSource ds) {
		template=new JdbcTemplate(ds);
	}
	
	public User authenticate(int id,String password)
	{
		// Eliminating use of PreparedStatement/Statement/ Object
		return template.queryForObject("select * from user_details where id=? and password=?",new Object[] {id,password} ,new UserMapper());
	}
	
	public List<Product> getAllProduct()
	{
		return template.query("select * from products", new ProductMapper());
	}
	
	public int registerUser(User u)
	{
		return template.update("insert into user_details values(?,?,?,?,?)",u.getId(),u.getName(),u.getEmail(),u.getPassword(),u.getType());
	}
	
}
