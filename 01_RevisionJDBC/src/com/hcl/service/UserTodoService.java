package com.hcl.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hcl.dao.ToDoDaoImpl;
import com.hcl.dao.UserDAO;
import com.hcl.pojo.Todo;

public class UserTodoService {
	private UserDAO dao;
	public UserTodoService() {
		dao=new ToDoDaoImpl();
	}
	
	public List<Todo> getMyTasks(String assignedTo)
	{
		List<Todo> todos=new ArrayList<Todo>();
		try {
			ResultSet res=dao.getTodoAssignedTo(assignedTo);
		
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
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return todos;
	}

}
