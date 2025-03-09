package com.thetestingacademy.ex_30112024;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Verification001 {
    @Test
    public void test_verify(){
        String responseName="pramod";
        Assert.assertEquals("pramod",responseName);
    }
}
