package com.example.springdemo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class HelloWorldController {




    @RequestMapping
    public  String helloworld (){

        return "Hello world from spring boot";
    }

    @GetMapping()
    public String GetUsers(){
        return  " HTTP GET request was sent ";
    }

    @PutMapping()
    public String PutUsers(){
        return  " HTTP PUT  new request was sent ";
    }

    @DeleteMapping()
    public String DeleteUsers(){
        return  " HTTP Delete request was sent ";
    }
    @PostMapping()
    public String PostUsers(){
        return  " HTTP POST request was sent ";
    }


    @RequestMapping("/goodbye")
        public String goodbye () {
            return "Goodbye from Spring boot";
        }


}
