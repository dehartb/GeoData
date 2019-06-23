<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<body>
		<h1>Maven + Spring MVC Web Project Example2</h1>
		
		<h2>Message : ${message}</h2>
		<h2>Counter : ${counter}</h2>
		
		<p>Click below button to get a simple HTML page</p>
		
		<form:form method = "GET" action = "/GeoData/staticPage">
		   <table>
		      <tr>
		         <td>
		            <input type = "submit" value = "Get HTML Page"/>
		         </td>
		      </tr>
		   </table>  
		</form:form>
	</body>
</html>