package com.hcl.pojo;

import java.util.Date;


public class Todo {

	private int id;
	private String title;
	private String desc;
	private Date created;
	private String assignedTo;
	public Todo() {
		// TODO Auto-generated constructor stub
	}
	public Todo(int id, String title, String desc, Date created, String assignedTo) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.created = created;
		this.assignedTo = assignedTo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", desc=" + desc + ", created=" + created + ", assignedTo="
				+ assignedTo + "]\n";
	}
	
}
