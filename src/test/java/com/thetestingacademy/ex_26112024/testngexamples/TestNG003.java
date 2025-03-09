package com.thetestingacademy.ex_26112024.testngexamples;

import org.apache.log.Priority;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG003 {
    @Test(priority =0)
    public void gettoken()
    {
        System.out.println("1");
    }
    @Test(priority =3)
    public void getbookingid()
    {
        System.out.println("2");
    }
    @Test(priority =2)
    public void t3()
    {
        System.out.println("3");
    }

}
