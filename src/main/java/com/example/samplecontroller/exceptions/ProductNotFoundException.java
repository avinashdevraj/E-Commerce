package com.example.samplecontroller.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ProductNotFoundException extends Exception{
    private long productId;
    private String message;
    public ProductNotFoundException(long id,String message){
        super(message);
        this.productId = id;
        this.message = message;

        String s="javajavaEE";
        HashMap<Character,Integer> map=new HashMap<>();
        char[] ch=s.toCharArray();
//        s.chars().map(a->(char)(a)).filter(a->map.put((char)a,map.getOrDefault((char)a,0)+1));
        for(char c:ch){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        System.out.println(map);
        //map.entrySet().map(Map.Entry::getKey).filter(x->map.get(x)==1).findFirst


    }
}
