package com.user.dao;


import com.user.model.EnrollACourse;
import com.user.model.GradeReport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeReportDAO {
   static  Map<Integer,GradeReport>  gradeReportBd = new HashMap<>();

    private EnrollACourseDAO enrollACourseDAO ;
    List<EnrollACourse> list = new ArrayList<>();
  /*  public List<EnrollACourse> getAllStudentForCourse(int year, int semester, int idStudent, int idCourse, String idProfessor){
            for(Map.Entry<Integer, EnrollACourse> e :enrollACourseDAO.enrollACourseBd.entrySet()){

            if((e.getValue().getYear()==year)&&(e.getValue().getSemester()==semester) && (e.getValue().getIdStudent()==idStudent)
                    && (e.getValue().getIdCourse()==idCourse) && (e.getValue().getIdProfessor()==idProfessor)){
                  list.add(e.getValue());
            }

        }

       return list;
    }*/



    public List<EnrollACourse> getAllStudentForCourse(int year, int semester, int idStudent, int idCourse, String idProfessor){
        for(Map.Entry<Integer,EnrollACourse> e :   enrollACourseDAO.enrollACourseBd.entrySet()){

            if((e.getValue().getYear()==year)&&(e.getValue().getSemester()==semester) && (e.getValue().getIdStudent()==idStudent)
                    && (e.getValue().getIdCourse()==idCourse) && (e.getValue().getIdProfessor()==idProfessor)){
                list.add(e.getValue());
            }

        }

        return list;
    }







    {

        gradeReportBd.put(1, new GradeReport(1,2018,1,100,1,"jean1",80.0));
        gradeReportBd.put(2, new GradeReport(2,2018,1,101,1,"jean1",90.0));
        gradeReportBd.put(3, new GradeReport(3,2018,1,100,2,"jean2",70.0));
        gradeReportBd.put(4, new GradeReport(4,2018,1,101,2,"jean1",86.0));
        gradeReportBd.put(5, new GradeReport(5,2018,1,100,3,"ion3",83.0));
        gradeReportBd.put(6, new GradeReport(6,2018,1,101,3,"jean2",77.9));

    }




    public void addGradeReport( GradeReport gradeReport){
       gradeReportBd.put(gradeReport.getIdGradeReport(),gradeReport);
    }


    public int gradeReportId() {
        return gradeReportBd.size()+1;
    }

    public List<GradeReport> getStudentReport(int idStudent){
        List<GradeReport> list = new ArrayList<>();

        for (Map.Entry<Integer,GradeReport> e : gradeReportBd.entrySet()){
            if(e.getValue().getIdStudent()==idStudent){
                list.add(e.getValue());
            }

        }

        return list;
    }


    public boolean checkStudent(int idStudent){

        for (Map.Entry<Integer,GradeReport> e : gradeReportBd.entrySet()){
            if(e.getValue().getIdStudent()==idStudent){
                return true;
            }

        }

     return false;
    }



}
