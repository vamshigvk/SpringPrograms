
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>getBalanceSuccessPage</title>
</head>
<body>
<div align="center">
	<h2>Name:${customer.name} bro</h2></br>
	<h2>MobileNumber :- ${customer.mobileNo }</h2></br>
	<h2>Balance in your account is:- ${customer.wallet.balance}</h2></br>
	<hr>
	<a href="/mypaymentapp">HomePage</a>
	</br>
	<hr>
	<button onclick="window.close()">Exit Application</button>
</div>
</body>
</html>