<%--
  Created by IntelliJ IDEA.
  User: jeanc
  Date: 9/23/2018
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Professor Workspace</title>
    <style>
        <%@include file="/resources/css/professor-style.css"%>
    </style>
</head>
<body>

<%--TODO: remove autocompleted values from inputs.--%>
<form action="professor" method="post" >
    <h2>Select semester</h2>
    <input type="number" name="yearCurrent" id="currentYear" placeholder="Year" /> <br/>
    <input type="number" name="semesterCurrent" id="currentSemester" placeholder="Semester"/> <br/>
    <span id="insetOption"></span>
    <%--TODO: remove insert automaticaly complete professor id field--%>
    <input type="text" name="idProfessor" id="professorId" placeholder="Professor Id" readonly value="${prof}"/> <br/>
    <input type="submit" id="submit" text="Select"/> <br/>
</form>


</body>
</html>
