<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <title>Welcome</title>
    <link href="/resources/css/styleWelcome.css" rel="stylesheet" type="text/css"/>





    <style>
        <%@include file="../../resources/css/styleWelcome.css"%>
    </style>

</head>

<body>

<h1> Welcome student ${user} </h1>
<div id="contain">




<form action="coursesEnroll">
    <input type="submit" value="Enroll" />
    <input type="hidden"    value="${user}" name="idStudent" id="idStudent1"/>

</form>


<form action="student" method="post">

    <input type="submit"  value="Verify your grade" />
    <input type="hidden"    value="${user}" name="idStudent" id="idStudent"/>

</form>


    <form action="logout" >
        <input type="submit" value="Logout" />
    </form>

</div>
</body>
</html>
