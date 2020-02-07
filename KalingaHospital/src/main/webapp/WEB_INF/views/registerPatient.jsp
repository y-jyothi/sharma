<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/insertPatients" method="post">
		<table>
			<tr>
				<td>Enter Patient ID:</td>
				<td><input type="number" id="patientId" name="patientId"></td>
			</tr>

			<tr>
				<td>Enter Patient Name:</td>
				<td><input type="text" id="patientName" name="patientName"></td>
			</tr>

			<tr>
				<td>Enter bill amount:</td>
				<td><input type="text" id="billAmount" name="billAmount"></td>
			</tr>





		</table>
		<label for="doctorName" class="control-label"> SELECT DOCTOR:</label>
		<table class="table table-striped">

			<tr class="success">


				<td><select name="doctorName">
						<c:forEach var="str2" items="${doctors}">
							<option value="${str2.doctorName}">${str2.doctorName}</option>
						</c:forEach>
				</select></td>

			</tr>
			<tr>
				<td><input type="submit" value="insert" /></td>
			</tr>

		</table>
	</form>

	<a href="/getform">back to home</a>
</body>
</html>