package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

import model.ExpenseModel;

public class ExpenseDao {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/ProjectExpense";
	static final String USER = "root";
	static final String PASS = "";
	static final String JDBCDRIVER = "com.mysql.cj.jdbc.Driver";
	static Connection connection;

	
	public void loadDriver(String driver) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception e) {
			System.out.println("driver not loaded.");
		}
	}
	
	
	public Connection getDatabaseConnection() {
		loadDriver(JDBCDRIVER);
		try {
			System.out.println("Connecting to the  database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected!");
			return connection;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return null;
		} 
		
	}
	
	public void createExpenseTable() {
		connection = getDatabaseConnection();
		String sql = "";
		sql = "create table if not exists expenses (" + " id int NOT NULL AUTO_INCREMENT," + " category varchar(255), "
				+ "dateExpense date, expenseName varchar(255), description VARCHAR(255), amount INTEGER, paymenttype varchar(255), primary key (id)" + ")";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean enterExpense(ExpenseModel expenseModel) {
		connection = getDatabaseConnection();
		String sql = "insert into expenses (category, dateExpense, expenseName, description, amount, paymenttype) VALUES (?,?,?,?,?,?)";
		boolean result = false;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, expenseModel.getCategory());
			ps.setDate(2, expenseModel.getDateExpense());
			ps.setString(3, expenseModel.getExpenseName());
			ps.setString(4, expenseModel.getDescription());
			ps.setInt(5, expenseModel.getAmount());
			ps.setString(6, expenseModel.getPaymentType());
			ps.executeUpdate();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public ResultSet getExpenses() {
		connection = getDatabaseConnection();
		if(connection != null){
			   System.out.println("Successfully connected.");
			   String sql = "SELECT * FROM expenses";
			   ResultSet resultSet = null;
			   try {
					PreparedStatement ps = connection.prepareStatement(sql);
					resultSet = ps.executeQuery();
					
				} catch (SQLException e) {
					resultSet = null;
					e.printStackTrace();
				}
			   
				
			   return resultSet;
		}else{
			   System.out.println("Failed to connect.");
			   return null;
		}
	}
}
