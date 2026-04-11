package com.project.tests;

import com.project.base.baseTest;
import com.project.pages.GoogleSearchPage;
import org.testng.annotations.Test;

public class GoogleSearchTest extends baseTest {

    @Test
    public void googleSearch() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.googleSearchFunctionality();
    }
}
