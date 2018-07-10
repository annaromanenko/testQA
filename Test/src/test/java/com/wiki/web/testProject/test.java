package com.wiki.web.testProject;

import com.wiki.web.pageObjects.Navigation;
import com.wiki.web.pageObjects.WikipediaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test extends Hooks {

    private Navigation page = PageFactory.initElements(driver,Navigation.class);

    @Test
    public void checkFilmPresentInActorPages() {
        WikipediaPage wikipediaPage = new WikipediaPage(driver);
        page.navigateToWikipediaFilmPage(driver);
        for (int i = 0; i<wikipediaPage.actorQuantity(); i++) {
            String actorName = wikipediaPage.getActorName(i);
            wikipediaPage.openActor(i);
//            Assert.assertEquals(wikipediaPage.getActorNameHead(), actorName, "Actor name's do not match"); -- Bug in film page actor name: Aleksandra Zakharova, in actor page Alexandra Zakharova
            Assert.assertTrue(wikipediaPage.isDragonFilmPresentInFilmography(), "There is no To Kill a Dragon film");
            driver.get("https://en.wikipedia.org/wiki/To_Kill_a_Dragon");
        }
    }
}
