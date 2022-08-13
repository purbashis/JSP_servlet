<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.Random,java.util.ArrayList,java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style >

*{
margin:0px;
padding:0px;


}




</style>
</head>
<body style="background: #e2e2e2;">


<!-- 
What is jsp 
JAVA SERVER PAGE
WE can write html ,css, js aswell as java content or dynamic content .
 -->
<!-- 
Declarative tag 

(declaration of methods and variables)

 -->
 
 <%@include file="Header.jsp" %>
 
 
 
 
<%!
int a=50;
int b=10;
String c="i love india";
public int doSum()
{
	
	return a+b;
	
}


public String reverse()
{
	StringBuffer br=new StringBuffer(c);
	return br.reverse().toString();
}



%>
<!-- Scriptlet tag 


(Scripting tag)
Java source code



out-implicit obj in jsp
for using generate
-->

<%
out.println(a);
out.println("<br>");
out.println(b);	
out.println("<br>");
out.println("sum is"+doSum());
out.println("<br>");
out.println("reverse is :"+reverse());

		

%>


<!--  expression tag 
  printing
 -->

<h1>
Sum is : <%= doSum() %>
<br>
<%= c %>

</h1>

<h1>Random Number:


<% 
Random r=new Random();
int n=r.nextInt(100);

//out.println(n);

%>

<%=

n

%>
</h1>



</body>
</html>