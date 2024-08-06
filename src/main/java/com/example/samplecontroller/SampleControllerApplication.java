package com.example.samplecontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SampleControllerApplication {

	public static void main(String[] args) {

//				String input1 = "{\"state\":1,\"cmd\":1}";
//				String input2 = "{\"cmd\":1,\"state\":1}";
//
//				ObjectMapper o=new ObjectMapper();
//				Map<String,Object> m1=o.readValue(input1, Map.class);
		SpringApplication.run(SampleControllerApplication.class, args);


	}

}
