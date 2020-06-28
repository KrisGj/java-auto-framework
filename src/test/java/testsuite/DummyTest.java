package testsuite;

import framework.Config;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Google;

public class DummyTest extends Config {

    Google google;

    @BeforeTest
    public void init() {
        google = new Google(driver);
    }

    @Test
    public void googleTest() {

        google.enterAndSubmitSearch("Twitter");
        google.selectSearchResult("https://twitter.com/");
    }
}
