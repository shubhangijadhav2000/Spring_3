package com.example.springdemo3.model;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="user")
public class Person {

    private String name;
    private String city;
    private String college;



    public Person(String name,String city,String college){
        super();
        this.name=name;
        this.city=city;
        this.college=college;
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
