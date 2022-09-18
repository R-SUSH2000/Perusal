package com.feedback.DAO;

public class Userfeedback {

	String gender;
	String amount;
	String userInterface;
	String issuesolution;
	String suggestion; 
	String emailID;
	
	public void displayAll()
	{
		System.out.println("gender="+this.gender);
		System.out.println("amount="+this.amount);
		System.out.println("userInterface="+this.userInterface);
		System.out.println("issuesolution="+this.issuesolution);
		System.out.println("suggestion="+this.suggestion);
		System.out.println("emailID="+this.emailID);
	}
	
	public Userfeedback (String gender,String amount ,String userInterface, String issuesolution ,String suggestion ,String emailID)
	{
		this.gender=gender;
		this.amount=amount;
		this.userInterface=userInterface;
		this.suggestion=suggestion;
		this.issuesolution=issuesolution;
		this.emailID=emailID;
	}
	
	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public void setUserInterface(String userInterface) {
		this.userInterface = userInterface;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getUserInterface() {
		return userInterface;
	}

	public void setUserinterface(String userinterface) {
		this.userInterface = userinterface;
	}

	public String getIssuesolution() {
		return issuesolution;
	}

	public void setIssuesolution(String issuesolution) {
		this.issuesolution = issuesolution;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Userfeedback() {
		super();
	}

}