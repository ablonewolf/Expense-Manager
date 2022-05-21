<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Manager</title>
</head>
<body>
<jsp:include page="header.html"/>
<br>
<br>
<hr>
<h2 align="center">Add your expense in the form below.</h2>
<div align="center">
<form action="ExpenseADD" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="expenseName"></td>
			</tr>
			<tr>
				<td>Category</td>
				<td>
					<select name="category">
						<option value="Transportation">Transportation</option>
					    <option value="Food and Beverage">Food</option>
					    <option value="Fees">Fees</option>
					    <option value="Bills">Bills</option>
					    <option value="Entertainment">Entertainment</option>
					    <option value="Medical">Medical Checkup and Medicine </option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Date</td>
				<td><input type="date" name="dateExpense"></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><input type="number" step="1" name="amount"></td>
			</tr>
			<tr>
				<td>Payment Type </td>
				<td>
				<select name="paymenttype">
						<option value="Cash">Cash</option>
					    <option value="Card">Card</option>
					    <option value="Mobile Banking">Mobile Banking</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Submit</td>
				<td><input type="submit" name="add" value="Add"></td>
			</tr>
		</table>
	</form>
</div>
<hr>
<jsp:include page="footer.jsp"/>
</body>
</html>