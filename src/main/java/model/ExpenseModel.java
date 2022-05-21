package model;

import java.sql.Date;

public class ExpenseModel {
	private String category;
	private Date dateExpense;
	private String expenseName;
	private String description;
	private int amount;
	private String paymentType;
	
	
	public ExpenseModel(String category, Date dateExpense, String expenseName, String description, int amount,
			String paymentType) {
		this.category = category;
		this.dateExpense = dateExpense;
		this.expenseName = expenseName;
		this.description = description;
		this.amount = amount;
		this.paymentType = paymentType;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Date getDateExpense() {
		return dateExpense;
	}


	public void setDateExpense(Date dateExpense) {
		this.dateExpense = dateExpense;
	}


	public String getExpenseName() {
		return expenseName;
	}


	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
	
	
}
