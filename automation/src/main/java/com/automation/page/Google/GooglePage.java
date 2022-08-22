package com.automation.page.Google;

import com.automation.kelvin.annotation.page;
import com.automation.page.base.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@page
public class GooglePage extends Base {

    private static final Logger logger = LoggerFactory.getLogger(GooglePage.class);

    @Autowired
    public SearchComponent searchComponent;

    @Autowired
    public SearchResult searchResult;

    @Value("${application.url}")
    private String url;

    public void goTo()
    {
        this.driver.get(url);
        logger.info("url has been launched");
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    @Override
    public Boolean isAt() {
        return this.searchComponent.isAt();
    }

    public void close(){
        this.driver.close();
    }
}
