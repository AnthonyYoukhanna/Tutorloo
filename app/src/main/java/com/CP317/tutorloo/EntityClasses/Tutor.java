package com.CP317.tutorloo.EntityClasses;

public class Tutor extends User {

    private double hourlyRate;
    private String courses[];
    private String program;
    private int year_of_study;
    private String biography;

    //-----------hourly rate accessor and mutator---------
    public void setHourlyRate(double hourlyRate) {
        hourlyRate = this.hourlyRate;
    }

    public double getHourlyRate() {
        return this.hourlyRate;
    }
    //--------------------------------------------------


    //ADD course accessor and mutator!!
//    public void setCourses(String[] courses) {
//        courses[] = this.courses;
//    }

    //-----------program accessor and mutator---------
    public void setProgram(String program) {
        program = this.program;
    }

    public String getProgram() {
        return this.program;
    }
    //-----------------------------------------------

    //-----------year of study accessor and mutator---------

    public void setYear_of_study(int year_of_study) {
        year_of_study = this.year_of_study;
    }

    public int getYear_of_study() {
        return this.year_of_study;
    }

    //---------------------------------------------

    //-----------Bio accessor and mutator---------
    public void setBiography(String biography) {
        biography = this.biography;
    }

    public String getBiography() {
        return this.biography;
    }
    //--------------------------------------------
//    private void UpdateTutorProfile(int userid) {
//
//    }

}
