package com.user.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.user.dao.CoursesSemesterDAO;
import com.user.dao.EnrollACourseDAO;
import com.user.model.EnrollACourse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/coursesEnroll")
public class EnrollCoursesController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CoursesSemesterDAO coursesSemesterDAO;
    private EnrollACourseDAO enrollACourseDAO;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        coursesSemesterDAO = new CoursesSemesterDAO();
        enrollACourseDAO = new EnrollACourseDAO();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("coursesSemester",coursesSemesterDAO.getAllCoursesSemester());
        int idStudent=  Integer.parseInt(request.getParameter("idStudent"));
        HttpSession session = request.getSession();

        if(enrollACourseDAO.checkCourseEnrollStudent(idStudent)){

            List<EnrollACourse> enrollACourses = enrollACourseDAO.getEnrollACourseStudent(idStudent);
            session.setAttribute("enrollACourses", enrollACourses);
            session.setAttribute("enrollACoursesList",mapper.writeValueAsString(enrollACourses));
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("WEB-INF/views/coursesEnroll.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String jSonString = request.getParameter("enrollACourse");
        EnrollACourse enrollACourse = mapper.readValue(request.getParameter("enrollACourse"),EnrollACourse.class);
        enrollACourse.setIdEnrollACourse(enrollACourseDAO.enrollACourseId());

        if(!enrollACourseDAO.numberCourse(enrollACourse.getIdStudent(),enrollACourse.getYear(),enrollACourse.getSemester()))  {

            enrollACourseDAO.addEnrollACourse(enrollACourse);
            System.out.println(enrollACourseDAO.numberCourse(enrollACourse.getIdStudent(),enrollACourse.getYear(),enrollACourse.getSemester()));

        }


        PrintWriter out =response.getWriter();
        try{
            out.print(mapper.writeValueAsString(enrollACourse));
        }catch (JsonGenerationException e) {
            e.printStackTrace();
        }
    }
}
