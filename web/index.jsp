<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
    <title>Login</title>

    <style>
        <%@include file="/resources/css/styleLogin.css"%>
    </style>
</head>
<body>
<div id="contain" >

   <form action="login" method="post">
       <%-- --%>
          <input type="text" name="username" value="${cookie.user.value}"  placeholder="Enter you Username" /> <br/>
          <input type="password" name="password" placeholder="Enter you Password" /> <br/>

          <input type="submit" value="Login"/> <br/>

       <label> Remember me </label> <input type="checkbox"    <c:if test="${cookie.containsKey('user')}">checked </c:if>  name="remember" value="yes"/>
           <label>jCharles</label><br/>

   </form>

   <span id="idError"> ${error} </span>
</div>

</body>
</html>
