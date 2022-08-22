package com.automation.kelvin.service;

import com.automation.kelvin.annotation.page;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

@Lazy
@Service
public class ScreenshotService {

    @Autowired
    private ApplicationContext ctx;

    @Value("${screenshot.path}")
    private String path;

    public void takeScreenShot(String name) throws IOException {
       File sourceFile =  this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
       FileCopyUtils.copy(sourceFile, new File(String.valueOf(this.path+name)));

            }
}
