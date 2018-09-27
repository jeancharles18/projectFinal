package com.user.dao;

import com.user.model.EnrollACourse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnrollACourseDAO {
    static Map<Integer,EnrollACourse> enrollACourseBd = new HashMap<>();
//    StudentDAO st;

    {
        enrollACourseBd.put(1, new EnrollACourse(1, 2018,1,100,1,"jean1"));
        enrollACourseBd.put(2, new EnrollACourse(2, 2018,1,101,2,"jean2"));
        enrollACourseBd.put(3, new EnrollACourse(3, 2018,1,103,2,"jean2"));
        enrollACourseBd.put(4, new EnrollACourse(4, 2018,1,104,1,"jean1"));
        enrollACourseBd.put(5, new EnrollACourse(5, 2018,1,105,2,"jean2"));
        enrollACourseBd.put(6, new EnrollACourse(6, 2018,1,106,2,"jean2"));
        enrollACourseBd.put(7, new EnrollACourse(7, 2018,2,100,2,"jean1"));
        enrollACourseBd.put(8, new EnrollACourse(8, 2018,2,101,3,"jean1"));
        enrollACourseBd.put(9, new EnrollACourse(9, 2018,2,103,2,"jean2"));
        enrollACourseBd.put(10, new EnrollACourse(10, 2018,1,100,4,"ion3"));
        enrollACourseBd.put(11, new EnrollACourse(11, 2018,2,100,5,"ion3"));

        enrollACourseBd.put(12, new EnrollACourse(12, 2018,2,101,6,"jean2"));

        for(int i = 1; i<10; i++) {
            enrollACourseBd.put(1000*i, new EnrollACourse(1000*i, 2018, 1, 100*i, 1, "jCharles"));
            enrollACourseBd.put(1001*i, new EnrollACourse(1001*i, 2018, 1, 101*i, 2, "aChelsea"));
            enrollACourseBd.put(1002*i, new EnrollACourse(1002*i, 2018, 1, 102*i, 3, "mWoods"));
            enrollACourseBd.put(1003*i, new EnrollACourse(1003*i, 2018, 2, 103*i, 1, "jCharles"));
            enrollACourseBd.put(1004*i, new EnrollACourse(1004*i, 2018, 2, 104*i, 2, "aChelsea"));
            enrollACourseBd.put(1005*i, new EnrollACourse(1005*i, 2018, 2, 105*i, 3, "mWoods"));
            enrollACourseBd.put(1006*i, new EnrollACourse(1006*i, 2018, 3, 106*i, 1, "jCharles"));
            enrollACourseBd.put(1007*i, new EnrollACourse(1007*i, 2018, 3, 107*i, 2, "aChelsea"));
            enrollACourseBd.put(1008*i, new EnrollACourse(1008*i, 2018, 3, 108*i, 3, "mWoods"));
            enrollACourseBd.put(1009*i, new EnrollACourse(1009*i, 2018, 4, 109*i, 2, "aChelsea"));
            enrollACourseBd.put(1010*i, new EnrollACourse(1010*i, 2018, 5, 110*i, 3, "mWoods"));
        }
    }






    public boolean numberCourse(int idStud, int yearCurrent, int semesterCurrent ){
       int count =0;

        for (Map.Entry<Integer,EnrollACourse> e : enrollACourseBd.entrySet()){
            if((e.getValue().getIdStudent()==idStud) && (e.getValue().getYear()==yearCurrent) && (e.getValue().getSemester()==semesterCurrent)){
               count++;
            }
        }

        if(count>=3){

            return true;
        }


        return false;
    }



    public List<Integer> getAllStudentEnrollACourse(int yearCurrent, int semesterCurrent,String idProf){
        List<Integer> list=new ArrayList<>();

        for (Map.Entry<Integer,EnrollACourse> e : enrollACourseBd.entrySet()){
            if(((e.getValue().getYear()==yearCurrent)
                    && (e.getValue().getSemester()==semesterCurrent) && (e.getValue().getIdProfessor().equals(idProf)))){
                list.add(e.getValue().getIdStudent());

                }
        }

        return list;
    }


    public int enrollACourseId() {
        return enrollACourseBd.size()+1;
    }

    public void addEnrollACourse(EnrollACourse EnrollACourse){

        enrollACourseBd.put(EnrollACourse.getIdCourse(),EnrollACourse);
    }

    public void deleteEnrollACourse(int EnrollACourseId){
        enrollACourseBd.remove(EnrollACourseId);
    }

    public void updateEnrollACourse(EnrollACourse EnrollACourse){
        enrollACourseBd.put(EnrollACourse.getIdCourse(),EnrollACourse);
    }


    public List<EnrollACourse> getAllEnrollACourse(){
        List<EnrollACourse> list =new ArrayList<>(enrollACourseBd.values());
        list.sort((EnrollACourse o1, EnrollACourse o2)->o1.getYear()  - o2.getYear());
        return list;
    }




    public List<EnrollACourse> getEnrollACourseStudent(int idStudent){
        List<EnrollACourse> list = new ArrayList<>();

        for (Map.Entry<Integer,EnrollACourse> e : enrollACourseBd.entrySet()){
            if(e.getValue().getIdStudent()==idStudent){
                list.add(e.getValue());
            }

        }

        return list;
    }





    public boolean checkCourseEnrollStudent(int idStudent){

        for (Map.Entry<Integer,EnrollACourse> e : enrollACourseBd.entrySet()){
            if(e.getValue().getIdStudent()==idStudent){
                return true;
            }

        }

        return false;
    }




}
