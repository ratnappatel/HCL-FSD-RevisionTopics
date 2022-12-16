package com.hcl.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hcl.db.DBConnection;
import com.hcl.pojo.Todo;

public class ToDoDaoImpl implements UserDAO,AdminDAO {
	private Connection con;
	private Statement stat; //select query 
	private PreparedStatement pre; // any query in which we have to pass parameter 
	private ResultSet res;
	public ToDoDaoImpl() {
		con=DBConnection.getConnection();
	}

	@Override
	public void addTodo(Todo t1) throws Exception
	{
		pre=con.prepareStatement("insert into todos values(?,?,?,?,?)");
		
		pre.setInt(1, t1.getId());
		pre.setString(2,t1.getTitle());
		pre.setString(3, t1.getDesc());
		Date d=new Date(t1.getCreated().getTime());
		pre.setDate(4, d);
		pre.setString(5, t1.getAssignedTo());
		
		int ra=pre.executeUpdate();
		if(ra>0)
			System.out.println("Inserted Todo");
		else
			System.out.println("Could Not Insert.");
	}

	@Override
	public void updateTodo(Todo t1)throws Exception {
		pre=con.prepareStatement("update todos set title=?,desc=?,assignedto=? where id=?");
		pre.setString(1,t1.getTitle());
		pre.setString(2, t1.getDesc());
		pre.setString(3,t1.getAssignedTo());
		pre.setInt(4, t1.getId());
		
		int ra=pre.executeUpdate();
		if(ra>0)
			System.out.println("Todo details updated...");
		else
			System.out.println("Todo details could not be updated...");		
		
	}

	@Override
	public void deleteTodo(int id)throws Exception {
		pre=con.prepareStatement("delete from todos where id=?");
		pre.setInt(1, id);
		int ra=pre.executeUpdate();
		if(ra>0)
			System.out.println("Deleted........");
		else
			System.out.println("Not Deleted......");
		
	}

	@Override
	public ResultSet getAllTodo()throws Exception {
		stat=con.createStatement();
		res=stat.executeQuery("select * from todos");
		return res;
	}

	@Override
	public Todo getTodo(int id)throws Exception {
		Todo t1=new Todo();
		stat=con.createStatement();
		res=stat.executeQuery("select * from todos where id="+id);
		if(res.next())
		{
			t1.setId(res.getInt("id"));
			t1.setTitle(res.getString("title"));
			t1.setDesc(res.getString("desc"));
			t1.setAssignedTo(res.getString("assignedto"));
			t1.setCreated(res.getDate("created"));
		}
		return t1;
	}

	@Override
	public ResultSet getTodoAssignedTo(String assignedTo)throws Exception {
		stat=con.createStatement();
		res=stat.executeQuery("select * from todos where assignedto='"+assignedTo+"'");
		
		return res;
	}

}
