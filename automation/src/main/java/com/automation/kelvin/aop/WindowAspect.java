package com.automation.kelvin.aop;

import com.automation.kelvin.annotation.Window;
import com.automation.kelvin.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private WindowSwitchService windowSwitchService;

    @Before("@target(window) && within(com.automation..*)")
    public void before(Window window){
        this.windowSwitchService.switchWindowByTitle(window.value());
    }

    @After("target(window) && within(com.automation..*)")
    public void after(Window window){
        this.windowSwitchService.switchWindowByIndex(0);
    }
}
