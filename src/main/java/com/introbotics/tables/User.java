package com.introbotics.tables;

public class User {
    
    private int user_id;
    private String name;
    private String role;

    public User() {

    }

    public User(int user_id, String name, String role) {
        this.user_id = user_id;
        this.name = name;
        this.role = role;
    }

    public void setUserID(int ID) {
        this.user_id = ID;
    }

    public int getUserID() {
        return this.user_id;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getName() {
        return name;
    }

    public void setRole(String Role) {
        this.role = Role;
    }

    public String getRole() {
        return role;
    }

    public String toString() {
        return "User: " +
                "userID = " + this.user_id +
                ", name = " + this.name +
                ", role = " + this.role;
    }
}
