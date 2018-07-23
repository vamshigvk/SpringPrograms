<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<div align="center"><h1>Enter Details</h1>
<form:form action="registerAssociate" method="post" modelAttribute="associate">

<table>
<tr>
<td>Enter associateId:</td><td><form:input path="associateID"/></td>
</tr>
<tr>
<td>Enter FirstName:</td><td><form:input path="firstName"/></td>
</tr>
<tr>
<td>Enter LastName:</td><td><form:input path="lastName"/></td>
</tr>
<tr>
<td>Enter PAN No:</td><td><form:input path="pancard"/></td>
</tr>
<tr>
<td>Enter emailID:</td><td><form:input path="emailId"/></td>
</tr>
<tr>
<td>Enter Department:</td><td><form:input path="department"/></td>
</tr>
<tr>
<td>Enter Designation:</td><td><form:input path="designation"/></td>
</tr>
<tr>
<td>Enter BasicSalary:</td><td><form:input path="salary.basicSalary"/></td>
</tr>
<tr>
<td>Enter AccountNumber:</td><td><form:input path="bankDetails.accountNumber"/></td>
</tr>
<tr>
<td>Enter BankName:</td><td><form:input path="bankDetails.bankName"/></td>
</tr>
<tr>
<td>Enter IFSC Code:</td><td><form:input path="bankDetails.ifscCode"/></td>
</tr>
<tr>
<td>Enter YearlyInvestmentUnder80C</td><td><form:input path="yearlyInvestmentUnder80C"/></td>
</tr>
<tr>
<!-- -->
<tr>
<td>Enter CompanyPF:</td><td><form:input path="salary.companyPf"/></td>
</tr>
<tr>
<td>Enter conveyenceAllowance:</td><td><form:input path="salary.conveyenceAllowance"/></td>
</tr>
<tr>
<td>Enter epf:</td><td><form:input path="salary.epf"/></td>
</tr>
<tr>
<td>Enter gratuity:</td><td><form:input path="salary.gratuity"/></td>
</tr>
<tr>
<td>Enter grossSalary:</td><td><form:input path="salary.grossSalary"/></td>
</tr>
<tr>
<td>Enter hra:</td><td><form:input path="salary.hra"/></td>
</tr>
<tr>
<td>Enter monthlyTax:</td><td><form:input path="salary.monthlyTax"/></td>
</tr>
<tr>
<td>Enter netSalary:</td><td><form:input path="salary.netSalary"/></td>
</tr>
<tr>
<td>Enter otherAllowance:</td><td><form:input path="salary.otherAllowance"/></td>
</tr>
<tr>
<td>Enter personalAllowance:</td><td><form:input path="salary.personalAllowance"/></td>
</tr><!--  -->
 -->
<td><input type="submit" value="submit"/></td>
</tr>
</table>
</form:form>
</div>
</body>
</html>