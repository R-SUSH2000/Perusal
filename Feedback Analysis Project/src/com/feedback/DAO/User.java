package com.feedback.DAO;

import java.io.Serializable;

public class User implements Serializable{
	
	private String loginId;
	private String name;
	private String password;
    private String role; 
    private String emailID;
    
    
    public User(String emailID,String pass) {
    	this.emailID=emailID;
    	this.password=pass;

    }
    public User(String loginId, String name, String password, String role, String emailID) {
    	this.loginId=loginId;
    	this.name=name;
    	this.password=password;
    	this.role=role;
    	this.emailID=emailID;	
	}
    
    public void display() {
    	System.out.println(loginId);
    	System.out.println(name);
    	System.out.println(password);
    	System.out.println(role);
    	System.out.println(emailID);
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public User(){
    	super();
    }
   

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}