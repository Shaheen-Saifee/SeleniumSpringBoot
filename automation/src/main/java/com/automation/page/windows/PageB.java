package com.automation.page.windows;

import com.automation.kelvin.annotation.Window;
import com.automation.kelvin.annotation.page;
import com.automation.page.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Window("Page B")
public class PageB extends Base {
    @FindBy(id ="area")
    private WebElement textArea;

    public void addToArea(final String textMsg){
        textArea.sendKeys(textMsg);
    }

    @Override
    public Boolean isAt() {
        return this.wait.until((d)->this.textArea.isDisplayed());
    }
}
