package com.automation.kelvin.config;

import com.automation.kelvin.annotation.ThreadScopeBean;
import com.automation.kelvin.annotation.LazyConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.net.MalformedURLException;
import java.net.URL;

@LazyConfiguration
public class WebDriverConfig {

    @ThreadScopeBean
    @ConditionalOnProperty(name="browser",havingValue = "firefox")
    public WebDriver firefoxDriver()
    {
        WebDriverManager.firefoxdriver().browserVersion("102.0.1").setup();
        return new FirefoxDriver();
    }
    @ThreadScopeBean
    @ConditionalOnProperty(name="browser",havingValue = "remote")
    public WebDriver remoteDriver() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-position=0,0");
        options.addArguments("--window-size=1840,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
       // options.addArguments("--headless");
        //options.addArguments("start-maximized");
        options.addArguments("--start-maximized");
        return new RemoteWebDriver(new URL("http://192.168.1.9:4444/"), options);

    }
    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver()
    {
        WebDriverManager.chromedriver().browserVersion("101.0.4951.41     ").setup();
        return  new ChromeDriver();
    }

}
