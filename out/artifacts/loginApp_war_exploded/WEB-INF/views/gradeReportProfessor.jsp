<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Grade Report</title>
    <link href="/resources/css/gradeReport.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/resources/js/gradeScript.js"></script>



    <script>
        <%@include file="../../resources/js/gradeScript.js"%>    </script>
    <style>
        <%@include file="../../resources/css/gradeReport.css"%>
    </style>




</head>
<body>

<header>
    <div class="barCourse">
        <h3>Course ${courseName}</h3>
        <p>Good afternoon professor ${professorFullName}!</p>
        <form action="logout">
            <button id="logout" name="logoutBtn">Logout</button></form>
    </div>
</header>
<div id="content">
    <div id="tableStudents">

        <table id="tabStudent">
            <thead>
            <caption>Students</caption>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Surename</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="student">

                <tr id="${student.idStudent}">
                    <td > <c:out value="${student.idStudent}"/> </td>
                    <td><c:out value="${student.firstNameStudent}"/></td>
                    <td><c:out value="${student.lastNameStudent}"/></td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>

    <div id="inputGradeForm" >

        <fieldset>
            <input type="text" id="yearCurrent1" name="yearCurrent1" value="${selectedYear}" readonly/> <label>Year</label> <br/>
            <input type="text" id="semCurrent" name="semCurrent" value="${selectedSemester}" readonly/> <label>Semester </label><br/>
            <input type="text" id="studCurrent" name="studCurrent" value="Student Id" readonly/>  <label>Id Student </label><br/>
             <input type="text" id="idCurrent" name="idCurrent" value="${selectedCourse}" readonly/><label>Id Course</label> <br/>
            <input type="text" id="idProfCurrent" name="idProfCurrent"  value="${professorFullName}" readonly/> <label> Id Professor</label> <br/>
            <input type="text" id="gradeCurrent" name="gradeCurrent" placeholder="Grade in procent" pattern="(?<=^| )\d+(\.\d+)?(?=$| )"/> <label>Grade </label><br/>
            <input type="text" id="letterGrade" name="letterGrade" value="" readonly size="3"/> <label>Letter Grade </label> <br/>

            <div>
                <input id="btnClick" type="submit" value="Submit"  height="35"/>
                <img id="loader" src="/loading.gif" alt="loading animation" width="50" height="30"/>
            </div>
        </fieldset>


    </div>

</div>
<div id="tableGrade">
    <table id="tableGraded">
        <thead>
        <caption>Graded Students</caption>
        <tr>
            <th>year</th>
            <th>semester</th>
            <th>idStudent</th>
            <th>idCourse</th>
            <th>idProfessor</th>
            <th>grade</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${gradeReports}" var="gradeReport">
            <tr>
                <td><c:out value="${gradeReport.year}" /></td>
                <td><c:out value="${gradeReport.semester}" /></td>
                <td><c:out value="${gradeReport.idStudent}" /></td>
                <td><c:out value="${gradeReport.idCourse}" /></td>
                <td><c:out value="${gradeReport.idProfessor}" /></td>
                <td><c:out value="${gradeReport.grade}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
