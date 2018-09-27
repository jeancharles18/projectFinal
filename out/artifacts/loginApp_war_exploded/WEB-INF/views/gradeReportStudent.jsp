<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report Student</title>

    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script>
        <%@include file="../../resources/js/myScript.js"%>
    </script>
    <script>
        <%@include file="../../resources/js/script_test.js"%>
    </script>
    <style>
        <%@include file="../../resources/css/style.css"%>
    </style>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

    <script type="text/javascript" charset="utf8" src=" https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" charset="utf8" src=" https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>


</head>
<body>

    <table id="tab_Report">
        <thead>
        <tr>
            <th> Year</th>
            <th> Semester</th>
            <th> Id Course</th>
            <th> Id Professor</th>
            <th> Grade</th>


        </tr>
        </thead>
        <tbody>

        <c:forEach items="${reportStudents}" var="student">

            <tr>
                <td> <c:out value="${student.year}"/> </td>
                <td> <c:out value="${student.semester}"/> </td>
                <td> <c:out value="${student.idCourse}"/> </td>
                <td> <c:out value="${student.idProfessor}"/> </td>
                <td> <c:out value="${student.grade}"/> </td>

            </tr>
        </c:forEach>

        </tbody>

    </table>


</body>
</html>
