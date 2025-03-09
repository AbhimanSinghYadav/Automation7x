package com.thetestingacademy.ex_26112024.testngexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG005 {
    @Test
    public void serverStartedOK(){
        System.out.println("I will run first");
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods ="serverStartedOk")
    public void method1(){
        System.out.println("method1");
    }
}
