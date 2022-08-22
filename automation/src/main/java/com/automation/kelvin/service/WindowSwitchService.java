package com.automation.kelvin.service;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WindowSwitchService {

    @Autowired
    private ApplicationContext ctx;

    public void switchWindowByTitle(final String title){
        WebDriver driver=this.ctx.getBean(WebDriver.class);
        driver.getWindowHandles()
                .stream()
                .map(handle->driver.switchTo().window(handle).getTitle())
                .filter(Title->Title.startsWith(title))
                .findFirst()
                .orElseThrow(()-> {
                    throw new RuntimeException("Title not found");
                });
    }

    public void switchWindowByIndex(final int index)
    {
        WebDriver driver=this.ctx.getBean(WebDriver.class);
        String[] handles = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(handles[index]);

    }


}
