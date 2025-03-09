package com.thetestingacademy.ex_26112024.testngexamples.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGhardassert {
    @Test
    public void hardAssertExample() {
        Assert.assertTrue(false);
        System.out.println("this line will not be executed");
    }
    @Test
    public void softAssertExample(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(false);//this will not stop execution.
        System.out.println("This line will be executed");
        softAssert.assertAll();//This will report all collected errors.
    }
}
