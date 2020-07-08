package testsuite;

import framework.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.Google;

public class DummyTest extends TestBase {

    Google google;

    @BeforeMethod
    public void init() {
        google = new Google(driver);
    }

    @Test
    public void googleTest() {
        google.enterAndSubmitSearch("Twitter");
        google.selectSearchResult("Twitter. It's what's happening.");
    }
}
