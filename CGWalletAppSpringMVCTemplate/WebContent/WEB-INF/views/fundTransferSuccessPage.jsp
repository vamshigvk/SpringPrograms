<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h2>Welcome ${customer.name} bro</h2></br>
	<h2>Your MobileNumber is:- ${customer.mobileNo }</h2></br>
	<h2>FundTransfer successful..</h2></br></br>
	<h2>Updated balance in your account is:- ${customer.wallet.balance}</h2></br>
	<a href="/mypaymentapp">HomePage</a></br>
	<hr>
	<button onclick="window.close()">Exit Application</button>
</div>
</body>
</html>