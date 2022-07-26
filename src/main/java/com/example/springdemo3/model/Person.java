package com.example.springdemo3.model;

import org.springframework.data.annotation.Id;

public class Person {
    @Id
    private int personId;
    private String name;
    private String city;
    private String college;




    public Person(int personId,String name,String city,String college){
        super();
        this.personId=personId;
        this.name=name;
        this.city=city;
        this.college=college;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }


}
