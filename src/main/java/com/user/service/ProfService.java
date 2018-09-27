package com.user.service;

import com.user.dao.ProfessorDao;
import com.user.model.Professor;
import com.user.model.User;

import java.util.Map;

public class ProfService {

    ProfessorDao bd = new ProfessorDao();

    public boolean check(String username, String password){
        for(Professor prof: bd.getProfessorBd()) {


            if (prof.getIdProfessor().equals(username) &&  prof.getIdProfessor().equals(password)){

                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "bd=" + bd +
                '}';
    }
}
