package com.automation;

import com.automation.kelvin.annotation.LazyAutowired;
import com.automation.kelvin.service.ScreenshotService;
import com.github.javafaker.Faker;
import com.automation.page.Google.GooglePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleTest2 extends SpringBaseTestNGTest {


    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenShotUtils;

    @LazyAutowired
    private Faker faker;

    @Test
    public void googleTest() throws IOException, InterruptedException {
       this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.searchComponent.search("Udemy");
        Assert.assertTrue(this.googlePage.searchResult.isAt());
        int totalCount = this.googlePage.searchResult.getCount();
        System.out.println(totalCount);
        Assert.assertTrue(totalCount>=1);
        screenShotUtils.takeScreenShot(String.valueOf(faker.name().firstName()+".png"));
        this.googlePage.close();

    }
}
