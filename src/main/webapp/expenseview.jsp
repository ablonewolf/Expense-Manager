<%@page import="java.sql.ResultSet"%>
<%@page import="dao.ExpenseDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	ExpenseDao expenseDao = new ExpenseDao();
	ResultSet resultSet = expenseDao.getExpenses();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Table</title>
</head>
<body>

<jsp:include page="header.html"/>
<br>
<br>
<hr>
<h2 align="center">Your current Expenses are listed below</h2>
<div align="center">
	<table border="1" cellspacing="1" cellpadding="3" >
		<tr>

		</tr>
		<tr>
			<td><b>Name</b></td>
			<td><b>Category</b></td>
			<td><b>Date</b></td>
			<td><b>Description</b></td>
			<td><b>Amount</b></td>
			<td><b>Payment Type</b>
		</tr>
		<%

			while (resultSet.next()) {
		%>
		<tr>
			<td><%=resultSet.getString("expenseName")%></td>
			<td><%=resultSet.getString("category")%></td>
			<td><%=resultSet.getString("dateExpense")%></td>
			<td><%=resultSet.getString("description")%></td>
			<td><%=resultSet.getString("amount")%></td>
			<td><%=resultSet.getString("paymenttype")%>

		</tr>

		<%
		}
		%>
	</table>

</div>
<br>
<br>
<hr>
<jsp:include page="footer.jsp"/>

</body>
</html>