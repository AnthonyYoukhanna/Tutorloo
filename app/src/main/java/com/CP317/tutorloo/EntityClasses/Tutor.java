package com.CP317.tutorloo.EntityClasses;

public class Tutor extends User {

    private int hourlyRate;
    private String course;
    private String program;
    private int year_of_study;
    private String biography;

    //-----------hourly rate accessor and mutator---------
    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHourlyRate() {
        return this.hourlyRate;
    }
    //--------------------------------------------------


    //--------- course accessor and mutator------------
    public void setCourses(String course) {
        this.course = course;
    }
    public String getCourse() {
        return this.course;
    }
    //-----------------------------------------------


    //-----------program accessor and mutator---------
    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram() {
        return this.program;
    }
    //-----------------------------------------------



    //-----------year of study accessor and mutator---------

    public void setYear_of_study(int year_of_study) {
        this.year_of_study = year_of_study;
    }

    public int getYear_of_study() {
        return this.year_of_study;
    }

    //---------------------------------------------



    //-----------Bio accessor and mutator---------
    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getBiography() {
        return this.biography;
    }
    //--------------------------------------------


}
