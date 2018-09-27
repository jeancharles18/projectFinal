package com.user.controller;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.user.dao.*;
import com.user.model.GradeReport;
import com.user.model.Professor;
import com.user.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;


@WebServlet("/professor")
public class ProfessorController extends HttpServlet {


    private static final long serialVersionUID = 1L;

    private ProfessorDao professorDao;
    private EnrollACourseDAO enrollACourseDAO;
    private GradeReportDAO gradeReportDAO;
    private StudentDAO studentDAO;
    private CourseDAO courseDao;
    private CoursesSemesterDAO coursSemesterDao;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        enrollACourseDAO = new EnrollACourseDAO();
        professorDao = new ProfessorDao();
        gradeReportDAO = new GradeReportDAO();
        studentDAO = new StudentDAO();
        courseDao = new CourseDAO();
        coursSemesterDao = new CoursesSemesterDAO();
    }

    private void part1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String jsonSting = request.getParameter("gradeReport");
        GradeReport gradeReport = mapper.readValue(request.getParameter("gradeReport"), GradeReport.class);
        gradeReport.setIdGradeReport(gradeReportDAO.gradeReportId());
        gradeReportDAO.addGradeReport(gradeReport);


        PrintWriter out =response.getWriter();
        try{
            out.print(mapper.writeValueAsString(gradeReport));
        }catch (JsonGenerationException e) {
            e.printStackTrace();
        }


    }


    public void part2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int yearCur=Integer.parseInt(request.getParameter("yearCurrent1"));
        int semCur=Integer.parseInt(request.getParameter("semCurrent"));
        int idStud=Integer.parseInt(request.getParameter("studCurrent"));
        int idC=Integer.parseInt(request.getParameter("idCurrent"));
        String idProf=request.getParameter("idProfCurrent");
        double grade= Double.parseDouble(request.getParameter("gradeCurrent"));
        request.setAttribute("gradeReports", gradeReportDAO.getAllStudentForCourse(yearCur,semCur,idStud,idC,idProf));
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("WEB-INF/views/gradeReportProfessor.jsp");
        requestDispatcher.forward(request,response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int yearCurrent=Integer.parseInt(request.getParameter("yearCurrent"));
        int semesterCurrent=Integer.parseInt(request.getParameter("semesterCurrent"));
        HttpSession session = request.getSession();

        Cookie cookie = new Cookie("selectedYear", "yearCurrent");
        cookie.setMaxAge(30 * 60 * 60 * 24);
        response.addCookie(cookie);
        Cookie cookie1 = new Cookie("selectedSemester", "semesterCurrent");
        cookie1.setMaxAge(30 * 60 * 60 * 24);
        response.addCookie(cookie1);




       // String prof = request.getCookies();
        String idProfessor = session.getAttribute("professorName").toString();
        List<Integer> enroledStudentsIds = enrollACourseDAO.getAllStudentEnrollACourse(yearCurrent,semesterCurrent,idProfessor);
//        System.out.println(Arrays.toString(enroledStudentsIds.toArray()));
        List<Student> students = studentDAO.getStudentsWithIds(enroledStudentsIds);



        Integer courseId = coursSemesterDao.getCourseIdByProfessorId(idProfessor);

        String courseName = courseDao.getCourseNameById(courseId);
//        System.out.println("Course Name: "+courseName);
        Professor prof = professorDao.getProfessorById(idProfessor);

        session.setAttribute("selectedCourse", courseId);
        session.setAttribute("selectedSemester", semesterCurrent);
        session.setAttribute("professorId", idProfessor);
        session.setAttribute("selectedYear",yearCurrent );
        request.setAttribute("professorFullName", prof.getFirstNameProfessor()+" "+prof.getLastNameProfessor());
        session.setAttribute("students", students);
//        request.setAttribute("studentList", mapper.writeValueAsString(students));
        session.setAttribute("courseName", courseName);

        RequestDispatcher requestDispatcher= request.getRequestDispatcher("WEB-INF/views/gradeReportProfessor.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        TODO: get from cookies profId and put to professor id.4
        HttpSession session = request.getSession();
        String strName = session.getAttribute("professorName").toString();
        request.setAttribute("prof", strName);
        request.getRequestDispatcher("WEB-INF/views/professor.jsp").forward(request,response);

    }

}
