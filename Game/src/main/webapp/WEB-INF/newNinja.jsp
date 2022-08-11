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
<title>New Ninja</title>
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
    <h1>New Ninja</h1>
    
    <form:form action="/createninja" method="post" modelAttribute="ninja">
    <p >
        <p><form:label path="dojo">Dojo:</form:label></p>
        <p class="text-danger"><form:errors path="dojo"/></p>
        <form:select path="dojo">
        <c:forEach var="dojo" items="${dojos }">
        <form:option value="${dojo.id}">
        <c:out value="${dojo.name}"></c:out>
        </form:option>
        </c:forEach>
        </form:select>
    </p>
    <p >
        <p><form:label path="firstName">First Name:</form:label></p>
        <p class="text-danger"><form:errors path="firstName"/></p>
        <form:input path="firstName"/>
    </p>
      <p >
        <p><form:label path="lastName">Last Name:</form:label></p>
        <p class="text-danger"><form:errors path="lastName"/></p>
        <form:input path="lastName"/>
    </p>
        <p >
        <p><form:label path="age">Age:</form:label></p>
        <p class="text-danger"><form:errors path="age"/></p>
        <form:input type="number" path="age"/>
    </p>
    <input type="submit" class="btn btn-primary" value="Create"/>
</form:form> 
    </div>

</body>
</html>