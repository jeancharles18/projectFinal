package com.user.dao;

import com.user.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDao {

private List<Professor>  professorBd = new ArrayList<>();


    public List<Professor> getProfessorBd() {
        return professorBd;
    }

    {
        professorBd.add(new Professor("jean1","jean","charles"));
        professorBd.add(new Professor("chris2","chris","chrisner"));
        professorBd.add(new Professor("ion3","ion","ion"));
        professorBd.add(new Professor("jCharles","Jean","Charles"));
        professorBd.add(new Professor("jChris","Jean","Chrisner"));
        professorBd.add(new Professor("aChelsea","Alejandro","Chelsea"));
        professorBd.add(new Professor("mWoods","Michael","Woods"));
    }


   // Todo: add this method to project
    public Professor getProfessorById(String id){
        for (Professor prof: professorBd){
            if (prof.getIdProfessor().equals(id)){

                return prof;
            }
        }
        return null;
    }

    public void addProfessor(Professor professor){
        professorBd.add(professor);
    }

    public void deleteProfessor(String idProfessor, String name){

        for (Professor prof: professorBd){
            if (prof.getIdProfessor().equals(idProfessor) && prof.getFirstNameProfessor().equals(name)){

                professorBd.remove(prof);
            }
        }
    }

    public List<Professor> getAllProfessor(){
        return new ArrayList<>(professorBd);
    }

    public boolean checkProfessorExist(String idProfessor,String name){

        for (Professor prof: professorBd){
            if (prof.getIdProfessor().equals(idProfessor) && prof.getFirstNameProfessor().equals(name)){

                return true;
            }
        }
             return false;
    }
}
