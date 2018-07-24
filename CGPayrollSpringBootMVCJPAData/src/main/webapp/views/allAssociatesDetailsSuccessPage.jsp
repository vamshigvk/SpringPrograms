<!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html>
 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${not empty associate}">
    <c:forEach items="${associate}" var="associate">
       ${associate}</br></br>
</c:forEach>
</c:if>

<hr>
<div align="center">
	<a href="/CGPayrollSpringMVC">HomePage</a>
	</br>
	<hr>
	<button onclick="window.close()">Exit Application</button>
</div>
</body>
</html>