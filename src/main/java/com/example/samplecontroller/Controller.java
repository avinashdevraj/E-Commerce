package com.example.samplecontroller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This controller support rest api(http) request
// /pay is end point to loand here on this controller
@RestController
@RequestMapping("/pay")
public class Controller {

    @GetMapping("/payment/{name}/{val}")
    public String payment(@PathVariable("name") String name,@PathVariable("val") int val){
        return val+" % success "+name;
    }
    @GetMapping("/order")
    public String order(){
        return "processing";
    }

    @GetMapping("/say/{name}/{val}")
    public String say(@PathVariable String name,@PathVariable int val){
        System.out.println("Hello "+name+" "+val);
        return val+" % success "+name;
    }
}
