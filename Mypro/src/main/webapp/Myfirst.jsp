<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=new java.util.Date() %></h1>
<%
int number=Integer.parseInt(request.getParameter("name"));
if(number%2==0)
{
	

%>


<h1 style="color: green;">
Even

</h1>
<%
}else{
	

%>
<h1 style="color: red"> odd</h1>

<% } %>

</body>
</html>