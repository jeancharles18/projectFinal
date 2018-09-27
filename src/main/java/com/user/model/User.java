package com.user.model;

public class User {
    private int username;
    private  String password;

    public User(int username, String password){
        this.username=username;
        this.password=password;
    }

    public int getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getUsername() != user.getUsername()) return false;
        return getPassword() != null ? getPassword().equals(user.getPassword()) : user.getPassword() == null;
    }

    @Override
    public int hashCode() {
        int result = getUsername();
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }
}
