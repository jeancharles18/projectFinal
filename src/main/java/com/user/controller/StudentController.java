package com.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.user.dao.GradeReportDAO;
import com.user.model.GradeReport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentController extends HttpServlet {
    GradeReportDAO bd;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        bd = new GradeReportDAO();
        }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idStudent=  Integer.parseInt(request.getParameter("idStudent"));
        HttpSession session = request.getSession();

        if (bd.checkStudent(idStudent)){
            session.setAttribute("user",idStudent);
            List<GradeReport>   reportStudents =bd.getStudentReport(idStudent);
            session.setAttribute("reportStudents", reportStudents);
            session.setAttribute("reportStudentList",mapper.writeValueAsString(reportStudents));
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("WEB-INF/views/gradeReportStudent.jsp");
            requestDispatcher.forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("WEB-INF/views/student.jsp");
        requestDispatcher.forward(request,response);


    }
}
