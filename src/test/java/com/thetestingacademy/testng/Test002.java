package com.thetestingacademy.testng;

import org.testng.annotations.*;

public class Test002 {
    @BeforeSuite
            void demo1()
    {
        System.out.println("BeforeSuite");
    }
   @BeforeTest
    void demo2()
    {
        System.out.println("BeforeTest");
    }
    @BeforeClass
    void demo3()
    {
        System.out.println("BeforeClass");
    }
    @BeforeMethod
    void demo4()
    {
        System.out.println("BeforeSuite");
    }
    @Test
    void demo5()
    {
        System.out.println("Test");
    }
    @AfterMethod
    void demo6()
    {
        System.out.println("AfterMethod");
    }
    @AfterClass
    void demo7()
    {
        System.out.println("Afterclass");
    }
    @AfterTest
    void demo8()
    {
        System.out.println("Aftertest");
    }
    @AfterSuite
    void demo9()
    {
        System.out.println("AfterSuite");
    }
}
