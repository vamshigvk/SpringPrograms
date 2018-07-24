<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Balance</title>
<style>
.error{
	color:red;
	font-weight:bold;
}
</style>
</head>
<body>
<div align="center">
<h1>Balance Page</h1>
<h3>Enter your Mobile number:</h3>
<form action="balanceSuccessPage" method="post" >
		<input name="mobileNo" size="30"/>
		<input type="submit" value="Request Balance"/>
</form>
</div>
</body>
</html>