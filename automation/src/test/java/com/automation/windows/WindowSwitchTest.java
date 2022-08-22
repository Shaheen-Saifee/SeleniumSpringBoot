package com.automation.windows;

import com.automation.SpringBaseTestNGTest;
import com.automation.kelvin.service.WindowSwitchService;
import com.automation.page.windows.MainPage;
import com.automation.page.windows.PageA;
import com.automation.page.windows.PageB;
import com.automation.page.windows.PageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowSwitchTest extends SpringBaseTestNGTest {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;

    @Autowired
    private PageB pageB;

    @Autowired
    private PageC pageC;

    @Autowired
    private WindowSwitchService windowSwitchService;

    @BeforeClass
    public void setUp(){
        this.mainPage.goTo();
        this.mainPage.launchAllWindows();
    }

    @Test
    public void switchTest(){
        this.pageA.addToArea("Hi Page A");
        this.pageB.addToArea("Hi Page B");
        this.pageC.addToArea("Hi Page c");
    }
}
