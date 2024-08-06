package com.example.samplecontroller;

import com.example.samplecontroller.controllers.ProductController;
import com.example.samplecontroller.exceptions.ProductNotFoundException;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SampleTest {

    @Autowired
    private ProductController productController;

    @Test
    public void test1(){
        //3'A->Arrange-Act-Assert

        int i=1+1;

        assert i==2;
    }

    @Test
    public void test2(){
        //3'A->Arrange-Act-Assert

        int i=2*2;

        //assert i==4;

        Assertions.assertEquals(5,i);
        Assertions.assertThrows(ProductNotFoundException.class,()->);

    }




}
//Arrange build the function
//Act call the required function.
//assert-check fun output against expected output.
//in assereEquals(7,y) first value is Expected value and the 2nd one is actual value.