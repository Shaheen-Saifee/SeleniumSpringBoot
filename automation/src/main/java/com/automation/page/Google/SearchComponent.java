package com.automation.page.Google;

import com.automation.kelvin.annotation.page;
import com.automation.page.base.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@page
public class SearchComponent extends Base {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name="btnK")
    private List<WebElement> searchButtons;

    @Override
    public Boolean isAt() {
       return this.wait.until(driver->searchBox.isDisplayed());
    }

    public void search(String keyword) throws InterruptedException {
        this.searchBox.click();
        Thread.sleep(3000);
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchButtons.stream().filter(e-> e.isDisplayed()&&e.isEnabled()).findFirst().ifPresent(e->e.click());

    }
}
