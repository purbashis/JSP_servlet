<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
<%=new java.util.Date() %>
</h1>

<%
String name=request.getParameter("name");
int roll=Integer.parseInt(request.getParameter("roll"));
int id=Integer.parseInt(request.getParameter("id"));
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tree","root","123456789");
Statement stmt=con.createStatement();
int i = stmt.executeUpdate("insert into fruit (id ,name,roll)values(' "+id+" ',' "+name+" ',' "+roll+" ')");
if(i>0)
{
	%>
	<h1 style="color:blue;"> Data stored</h1>
	
	
	<% 
}





%>



</body>
</html>