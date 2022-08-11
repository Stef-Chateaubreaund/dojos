<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>heheheh</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container"> <!-- Beginning of Container -->    
    <h3><c:out value="${dojo.name }"></c:out> onde eles estao </h3>
    
    <table class="table table-hover table-dark">
    <thead>
    <tr><td>First Name</td> <td>Last Name</td> <td>Age</td></tr>
    </thead>
    <tbody>
    
    <c:forEach var="ninja" items="${dojo.ninjas }">
    <tr>
    <td><c:out value="${ninja.firstName }"></c:out></td>
    <td><c:out value="${ninja.lastName }"></c:out></td>
    <td><c:out value="${ninja.age }"></c:out></td>
    </tr>
    </c:forEach>
    
    </tbody>
    </table>
    
    </div>

</body>
</html>