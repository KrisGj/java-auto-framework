package testsuite;

import framework.Config;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.Google;

public class DummyTest extends Config {

    Google google;

    @BeforeMethod
    public void init() {
        google = new Google(driver);
    }

    @Test
    public void googleTest() {
        google.enterAndSubmitSearch("Twitter");
        google.selectSearchResult("http://twitter.com/");
    }
}
