package com.wiki.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WikipediaPage {
    private WebDriver driver;

    public WikipediaPage(WebDriver driver) {
        this.driver = driver;
    }

    private By castActor = By.xpath("//*[@id='mw-content-text']/div/ul[1]/li/a");
    private By actorNameHead = By.id("firstHeading");
    private By dragonMovie = By.xpath("//*[@class='mw-headline' and (contains(., 'filmography') or contains(., " +
            "'Filmography'))]/following::a[contains(., 'To Kill a Dragon')]");

    public int actorQuantity() {
        return driver.findElements(castActor).size();
    }

    public String getActorName(int actorNumber) {
        return driver.findElements(castActor).get(actorNumber).getText();
    }

    public void openActor(int actorNumber) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(castActor));
        driver.findElements(castActor).get(actorNumber).click();
    }

    public String getActorNameHead() {
        return driver.findElement(actorNameHead).getText();
    }

    public boolean isDragonMoviePresentInFilmography() {
        return driver.findElement(dragonMovie).isDisplayed();
    }
}


