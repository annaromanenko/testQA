package com.wiki.web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Navigation {

    private WebDriver driver;

    public WikipediaPage navigateToWikipediaFilmPage(WebDriver driver) {
        driver.get("https://en.wikipedia.org/wiki/To_Kill_a_Dragon");
        System.out.print("Opening wikipedia page");
        WikipediaPage wikipediaPage = PageFactory.initElements(this.driver, WikipediaPage.class);
        return wikipediaPage;
    }

    public Navigation(WebDriver driver) {
        this.driver = driver;
    }
}

