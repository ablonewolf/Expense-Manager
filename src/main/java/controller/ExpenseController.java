package controller;

import java.io.IOException;

import java.sql.Date;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ExpenseDao;
import model.ExpenseModel;

@WebServlet("/ExpenseADD")

public class ExpenseController extends HttpServlet {
	
	private static final long serialVersionUID =1L;

	public ExpenseController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse ) {
		try {
			httpServletResponse.getWriter().append("Served at: ").append(httpServletRequest.getContextPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An IO Exception Occured in doGet method");
		}
	}
	
	protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String category = httpServletRequest.getParameter("category");
		String expenseDate = httpServletRequest.getParameter("dateExpense");
//		System.out.println(expenseDate);
		String expenseName = httpServletRequest.getParameter("expenseName");
		String description = httpServletRequest.getParameter("description");
		String expenseAmount = httpServletRequest.getParameter("amount");
		String payementType = httpServletRequest.getParameter("paymenttype");
		
		if(category!="" && expenseDate!="" && expenseName!="" && description!="" && expenseAmount!="" && payementType!="")
		{
			Date date = Date.valueOf(expenseDate);
			System.out.println(date);
			int amount = Integer.parseInt(expenseAmount);
			
			ExpenseDao expenseDao = new ExpenseDao();
			ExpenseModel expenseModel = new ExpenseModel(category, date, expenseName, description, amount, payementType);
			expenseDao.getDatabaseConnection();
			expenseDao.createExpenseTable();
			expenseDao.enterExpense(expenseModel);
//			ResultSet resultSet = expenseDao.getExpenses();
			try {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/expenseview.jsp");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("An IO Exception occured in the doPost method" + e);
			}
		}
		else {
			try {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("An IO Exception occured in the doPost method: " + e);
			}
		}
		
	}

}
