package com.user.service;

import com.user.dao.UserDao;
import com.user.model.User;

import java.util.Map;

public class UserService {


UserDao bd = new UserDao();

        public boolean check(String username, String password){
        for(Map.Entry<String, User> entry :  bd.getBD().entrySet()) {
            String key = entry.getKey();
            User value = entry.getValue();
            int uname = Integer.parseInt(username);

            if (value.getUsername()==uname && value.getPassword().equals(password)){

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
