package com.thetestingacademy.ex_26112024.testngexamples;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG001 {
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that true==true")
    @Test
    public void testcase01(){
        Assert.assertEquals(true,true);
    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that true!=false")
    public void testcase02(){
        Assert.assertEquals(true,true);
    }
}
