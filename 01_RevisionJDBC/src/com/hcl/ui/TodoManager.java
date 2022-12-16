package com.hcl.ui;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.hcl.pojo.Todo;
import com.hcl.service.AdminTodoService;
import com.hcl.service.UserTodoService;

public class TodoManager {
	
	private AdminTodoService aService;
	private UserTodoService  uService;
	private Scanner sc;
	
	public TodoManager()
	{
		sc=new Scanner(System.in);
		aService=new AdminTodoService();
		uService=new UserTodoService();
	}
	public Todo input()
	{
		Todo t1=new Todo();
		System.out.println("Enter Todo Id");
		t1.setId(sc.nextInt());
		System.out.println("Enter Todo Title");
		t1.setTitle(sc.next());
		System.out.println("Enter Todo Desc");
		t1.setDesc(sc.next());
		t1.setCreated(new Date());
		System.out.println("Enter Assigned To User Name");
		t1.setAssignedTo(sc.next());
		return t1;
	}
	
	public void adminMenu()
	{
		String choice="yes";
		int op=0;
		do
		{
			System.out.println("1. Add Task Details");
			System.out.println("2. Edit Task Details");
			System.out.println("3. Delete Task Details");
			System.out.println("4. Get Add Task Details");
			System.out.println("5. Get All Add Task Details");
			op=sc.nextInt();
			switch(op)
			{
				case 1:
				{
					aService.add(this.input());
					break;
				}
				case 5:
				{
					List<Todo> todos=aService.getAllTasks();
					System.out.println(todos);
				}
			}
			System.out.println("Would you like to continue(yes/no)");
			choice=sc.next();
		}while(choice.equalsIgnoreCase("yes"));
	}
	public void userMenu()
	{
		System.out.println("Enter User Name to See Tasks assigned ");
		String user=sc.next();
		List<Todo> todos=uService.getMyTasks(user);
		System.out.println(todos);
	}

	public static void main(String[] args) {
		TodoManager mgr=new TodoManager();
		String choice="yes";
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println("Are you User /Admin");
			String type=sc.next();
			if(type.equalsIgnoreCase("admin"))
				mgr.adminMenu();
			else
				mgr.userMenu();
			System.out.println("Would you like to Continue (yes/no)");
			choice=sc.next();
		}while(choice.equalsIgnoreCase("yes"));
	}

}
