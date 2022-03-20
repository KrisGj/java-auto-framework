package testsuite;

import framework.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DemoPage;

import utilities.DataGenerator;

public class TestGroupTwo extends BaseTest {

    @Test
    public void testTwo() {

        DemoPage demoPage = new DemoPage();

        demoPage.navigateToCategory("Elements");
        demoPage.navigateToSubcategory("Text Box");

        String email = DataGenerator.generateRandomEmail();

        demoPage.enterFullName("Johnny Silverhand");
        demoPage.enterEmail(email);
        demoPage.enterCurrentAddress("220 W Chicago Avenue, Chicago, IL 60654");
        demoPage.enterPermanentAddress("1626 Bedford Avenue, Brooklyn, NY 11225");
        demoPage.submitInformation();

        Assert.assertEquals(demoPage.getOutput(),
                "Name:Johnny Silverhand, Email:" + email + ", Current Address :220 W Chicago Avenue, Chicago, IL 60654, Permananet Address :1626 Bedford Avenue, Brooklyn, NY 11225",
                "The output does not match the provided input.");
    }
}
