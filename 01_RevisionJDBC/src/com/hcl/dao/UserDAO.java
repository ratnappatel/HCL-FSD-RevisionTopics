package com.hcl.dao;

import java.sql.ResultSet;

public interface UserDAO {
	
	public ResultSet getTodoAssignedTo(String assignedTo)throws Exception;

}
