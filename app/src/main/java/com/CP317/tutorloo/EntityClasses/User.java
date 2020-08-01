package com.CP317.tutorloo.EntityClasses;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    private String password;
    private int userID;

    //-----first name accessor and mutators-------
    public String getfirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        firstName = this.firstName;
    }

    //-------------------------------------------


    //-----last name accessor and mutators-------
    public String getlastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        lastName = this.lastName;
    }
    //--------------------------------------------


    //-----Email accessor and mutators-------
    public String email() {
        return this.email;
    }

    public void setEmail(String email) {
        email = this.email;
    }

    public String getdob() {
        return this.dob;
    }

    //---------------------------------------

    //-----Password accessor and mutators-------

    public void setPassword(String password) {
        password = this.password;
    }

    public String getPassword() {
        return this.password;
    }
    //----------------------------------------


    //-----User ID accessor and mutators-------
    public void setUserID(int userID) {
        userID = this.userID;
    }

    public int getUserID() {
        return this.userID;
    }

}





