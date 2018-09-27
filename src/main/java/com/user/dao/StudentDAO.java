package com.user.dao;
import com.user.model.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDAO {

    static Map<Integer,Student> studentsBd = new HashMap<>();


    public static Map<Integer, Student> getStudentsBd() {
        return studentsBd;
    }

    public static void setStudentsBd(Map<Integer, Student> studentsBd) {
        StudentDAO.studentsBd = studentsBd;
    }

    {
        studentsBd.put(100,new Student(100,"Jean","Charles"));
        studentsBd.put(101,new Student(101,"Ion","Carl"));
        studentsBd.put(102,new Student(102,"Peter","Jacques"));
        studentsBd.put(103,new Student(103,"Lee","Georges"));
        studentsBd.put(104,new Student(104,"Lu","Bush"));
        studentsBd.put(105,new Student(105,"Charles","Obama"));
        studentsBd.put(106,new Student(106,"Pierre","Linda"));
        studentsBd.put(107,new Student(107,"John","Joseph"));
        studentsBd.put(108,new Student(108,"Paul","Charles"));
        studentsBd.put(109,new Student(109,"Nadia","Paul"));
        studentsBd.put(110,new Student(110,"Marlyn","Peterson"));
        for (int i = 1; i < 10;i++){
            String midleName = " "+Character.toString((char)(65+i))+".";
            studentsBd.put(100*i,new Student(100*i,"Jean"+midleName,"Charles"));
            studentsBd.put(101*i,new Student(101*i,"Ion"+midleName,"Carl"));
            studentsBd.put(102*i,new Student(102*i,"Peter"+midleName,"Jacques"));
            studentsBd.put(103*i,new Student(103*i,"Lee"+midleName,"Georges"));
            studentsBd.put(104*i,new Student(104*i,"Lu"+midleName,"Bush"));
            studentsBd.put(105*i,new Student(105*i,"Charles"+midleName,"Obama"));
            studentsBd.put(106*i,new Student(106*i,"Pierre"+midleName,"Linda"));
            studentsBd.put(107*i,new Student(107*i,"John"+midleName,"Joseph"));
            studentsBd.put(108*i,new Student(108*i,"Paul"+midleName,"Charles"));
            studentsBd.put(109*i,new Student(109*i,"Nadia"+midleName,"Paul"));
            studentsBd.put(110*i,new Student(110*i,"Marlyn"+midleName,"Peterson"));
        }

    }



    public int studId() {
        return studentsBd.size()+100;
    }

    public void addStudents(Student student){

        studentsBd.put(student.getIdStudent(),student);
    }

    public void deleteStudent(int studentId){
        studentsBd.remove(studentId);
    }

    public void updateStudent(Student student){
        studentsBd.put(student.getIdStudent(),student);
    }


    public List<Student> getAllStudents(){
        return new ArrayList<>(studentsBd.values());
    }

    public Student getStudentById(int studentId){
        return studentsBd.get(studentId);
    }


    public List<Student> getStudentsWithIds(List<Integer> ids){
        List<Student> stList = new ArrayList<>();
        for (Integer id:ids) {

            Student st = getStudentById(id);

            if (!(st.getFirstNameStudent()==null || st.getFirstNameStudent().isEmpty())){
                stList.add(st);
            }
        }
        return stList;
    }



}
