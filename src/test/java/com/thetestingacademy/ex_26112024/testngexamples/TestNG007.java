package com.thetestingacademy.ex_26112024.testngexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG007 {
    @Test
    public void test001(){
        Assert.assertTrue(true);
    }
    @Test(enabled = false)
    public void test002(){
        Assert.assertTrue(false);
    }
    @Test(alwaysRun = true)
    public void test003(){
        Assert.assertTrue(true);
    }
}
