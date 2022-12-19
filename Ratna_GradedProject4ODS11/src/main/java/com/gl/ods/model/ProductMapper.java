package com.gl.ods.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product> 
{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product p=new Product();
		p.setId(rs.getInt("productid"));
		p.setName(rs.getString("product_name"));
		p.setCategory(rs.getString("category"));
		p.setPrice(rs.getFloat("price"));
		p.setBuyingPrice(rs.getFloat("buyingPrice"));
		p.setQty(rs.getInt("quantity"));
		return p;
	}
	
}
