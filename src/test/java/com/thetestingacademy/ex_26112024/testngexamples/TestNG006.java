package com.thetestingacademy.ex_26112024.testngexamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG006 {
    @Parameters("browser")
    @Test
        void demo1(String value){
        System.out.println("Browser is "+value);
        //Open the Browser and select dadadada
    }
}
