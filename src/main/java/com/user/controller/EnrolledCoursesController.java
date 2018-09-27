package com.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.dao.CoursesSemesterDAO;
import com.user.dao.EnrollACourseDAO;
import com.user.model.EnrollACourse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/enrolledCourses")
public class EnrolledCoursesController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CoursesSemesterDAO coursesSemesterDAO;
    private EnrollACourseDAO enrollACourseDAO;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        coursesSemesterDAO = new CoursesSemesterDAO();
        enrollACourseDAO = new EnrollACourseDAO();
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int idStudent=  Integer.parseInt(request.getParameter("idStudent"));
        HttpSession session = request.getSession();

        List<EnrollACourse> enrollACourses = enrollACourseDAO.getEnrollACourseStudent(idStudent);
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(enrollACourses);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
       /* out.print(jsonString);
        out.flush();*/
        response.getWriter().write(jsonString);
    }
}
