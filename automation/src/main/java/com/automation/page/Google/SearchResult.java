package com.automation.page.Google;

import com.automation.page.base.Base;
import com.automation.kelvin.annotation.page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@page
public class SearchResult extends Base {

    @FindBy(id="res")
    private List<WebElement> results;

    public int getCount()
    {
        return this.results.size();
    }

    @Override
    public Boolean isAt() {
        return this.wait.until((d)-> !this.results.isEmpty());
    }
}
