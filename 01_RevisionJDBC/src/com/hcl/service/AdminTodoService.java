package com.hcl.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hcl.dao.AdminDAO;
import com.hcl.dao.ToDoDaoImpl;
import com.hcl.pojo.Todo;

public class AdminTodoService {
	
	private AdminDAO dao;
	private ResultSet res;
	List<Todo> todos;
	public AdminTodoService() {
		dao=new ToDoDaoImpl();
		todos=new ArrayList<Todo>();
	}
	
	public void add(Todo t1)
	{
		try 
		{
			dao.addTodo(t1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Todo> getAllTasks()
	{
		try 
		{
			res=dao.getAllTodo();
			while(res.next())
			{
				Todo t1=new Todo();
				t1.setId(res.getInt("id"));
				t1.setTitle(res.getString("title"));
				t1.setDesc(res.getString("desc"));
				t1.setCreated(res.getDate("created"));
				t1.setAssignedTo(res.getString("assignedto"));
				todos.add(t1);
				t1=null;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return todos;
	}
}
