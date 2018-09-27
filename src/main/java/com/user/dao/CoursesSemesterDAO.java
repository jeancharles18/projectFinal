package com.user.dao;
import com.user.model.CoursesSemester;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoursesSemesterDAO {

    Map<Integer,CoursesSemester> coursesSemesterBd = new HashMap<>();

    {
        coursesSemesterBd.put(1,new CoursesSemester(1, 2018, 1,1,"jCharles") );
        coursesSemesterBd.put(2,new CoursesSemester(2, 2018, 1,2,"mWoods") );
        coursesSemesterBd.put(3,new CoursesSemester(3, 2018, 1,3,"aChelsea") );
        coursesSemesterBd.put(4,new CoursesSemester(4, 2018, 1,4,"Charles") );
        coursesSemesterBd.put(5,new CoursesSemester(3, 2018, 1,5,"Paul") );
        coursesSemesterBd.put(6,new CoursesSemester(6, 2018, 1,6,"Lee") );
        coursesSemesterBd.put(7,new CoursesSemester(7, 2018, 1,7,"Peter") );
        coursesSemesterBd.put(8,new CoursesSemester(8, 2018, 2,8,"John") );
    }


    public int getCourseIdByProfessorId(String sid){
        System.out.println("get course by prof id"+sid);
        List<CoursesSemester> courses = getAllCoursesSemester();
        boolean found = false;
        for(CoursesSemester c : courses){
            if(found)
                break;

            if(c.getIdProfessor().equals(sid)) {
                found = true;
                return c.getIdCourse();
            }
        }

        return 0;
    }








    public void addCoursesSemester(CoursesSemester coursesSemester){

        coursesSemesterBd.put(coursesSemester.getidCoursesSemester(),coursesSemester);
    }

    public void deleteCoursesSemester(int idCoursesSemester){
        coursesSemesterBd.remove(idCoursesSemester);
    }

    public void updateCoursesSemester(CoursesSemester coursesSemester){
        coursesSemesterBd.put(coursesSemester.getidCoursesSemester(),coursesSemester);
    }



    public List<CoursesSemester> getAllCoursesSemester(){
        ArrayList<CoursesSemester> list=new ArrayList<>(coursesSemesterBd.values());
        list.sort((CoursesSemester o1, CoursesSemester o2)->o1.getYear()  - o2.getYear());
        return list;
    }

    public CoursesSemester getCoursesSemesterById(int idCoursesSemester){
        return coursesSemesterBd.get(idCoursesSemester);
    }









}
