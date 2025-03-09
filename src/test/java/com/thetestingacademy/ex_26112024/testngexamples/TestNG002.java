package com.thetestingacademy.ex_26112024.testngexamples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG002 {
    @BeforeTest
    public void gettoken()
    {
        System.out.println("1");
    }
    @BeforeTest
    public void getbookingid()
    {
        System.out.println("2");
    }
    @Test
    public void t3()
    {
        System.out.println("3");
    }

}
