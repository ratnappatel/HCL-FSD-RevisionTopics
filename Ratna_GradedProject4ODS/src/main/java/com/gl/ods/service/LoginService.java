package com.gl.ods.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gl.ods.dao.DBConnection;
import com.gl.ods.model.Product;
import com.gl.ods.model.User;

public class LoginService {
	
	private Connection con;
	private PreparedStatement pre;
	private ResultSet res;
	private Statement stat;
	List<Product> prds;
	public LoginService() {
		con=DBConnection.getConnection();
		prds=new ArrayList<Product>();
	}
	public String[] authenticate(int id,String password)
	{
		String r[]=new String[2];
		try 
		{
			String query="select type,name from user_details where id=? and password=?";
			pre=con.prepareStatement(query);
			pre.setInt(1, id);
			pre.setString(2, password);
			
			res=pre.executeQuery();
			if(res.next())
			{
				r[0]=res.getString("type");
				r[1]=res.getString("name");
				
			}
			else
			{
				r[0]="missing";
				r[1]="missing";
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public List<Product> getAllProduct()
	{
		String query="select * from products";
		try 
		{
			stat=con.createStatement();
			res=stat.executeQuery(query);
			while(res.next()) {
				Product p=new Product();
				p.setId(res.getInt("productid"));
				p.setName(res.getString("product_name"));
				p.setCategory(res.getString("category"));
				p.setQty(res.getInt("quantity"));
				p.setPrice(res.getFloat("price"));
				p.setBuyingPrice(res.getFloat("buyingprice"));
				prds.add(p);
				p=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prds;
	}

	public int registerUser(User u)
	{
		int ra=0;
		try 
		{
			String query="insert into user_details value(?,?,?,?,?)";
			pre=con.prepareStatement(query);
			pre.setInt(1, u.getId());
			pre.setString(2, u.getName());
			pre.setString(3, u.getEmail());
			pre.setString(4,u.getPassword());
			pre.setNString(5, u.getType());
			
			ra=pre.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ra;
	}
}
