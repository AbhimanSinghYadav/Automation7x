package com.thetestingacademy.ex_26112024.testngexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG004 {
    @Test(groups={"sanity","qa","preprod"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }
    @Test(groups={"qa","preprod","reg"})
    public void RegRun(){
        System.out.println("Reg");
        Assert.assertTrue(false);
    }
    @Test(groups={"dev"})
    public void SmokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }
}
