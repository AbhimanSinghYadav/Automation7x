package com.thetestingacademy.ex_30112024;

import io.qameta.allure.Description;


import org.testng.Assert;


import org.testng.annotations.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Verfication002 {
    @Description("Verify that asserj is working fine")
    @Test
    public void test_verify_assertj(){
        String name="pramod";
        assertThat(name).isEqualTo("pramod").isNotEmpty().isNotNull();
        List<String> names= Arrays.asList("john","jane","doe");
        assertThat(names).isNotNull();
        LocalDate date=LocalDate.now();
        assertThat(date)
                .isAfterOrEqualTo(LocalDate.of(2021,1,1))
                  .isBeforeOrEqualTo(LocalDate.of(2021,1,1))
        .isBetween(
                LocalDate.of(2023,1,1),
                 LocalDate.of(2023,1,31));
        File file=new File("Testdata.json");
        assertThat(file).exists().isFile().canRead();
        Map<String,Integer> ages=new HashMap<>();
        ages.put("John",25);
        ages.put("Karan",30);
        assertThat(ages).hasSameClassAs(2);
    }
}