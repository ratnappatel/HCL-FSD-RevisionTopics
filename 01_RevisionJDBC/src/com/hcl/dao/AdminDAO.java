package com.hcl.dao;

import java.sql.ResultSet;

import com.hcl.pojo.Todo;

public interface AdminDAO {
	
	public void addTodo(Todo t1)throws Exception;
	public void updateTodo(Todo t1)throws Exception;
	public void deleteTodo(int id)throws Exception;
	public ResultSet getAllTodo()throws Exception;	
	public Todo getTodo(int id)throws Exception;

}
