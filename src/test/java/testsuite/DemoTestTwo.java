package testsuite;

import framework.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DemoRegistrationPage;

public class DemoTestTwo extends BaseTest {

    @Test
    public void createUserTwo() {

        DemoRegistrationPage demoRegistrationPage = new DemoRegistrationPage();
        demoRegistrationPage.navigateToRegistration();
        demoRegistrationPage.enterFirstAndLastName();
        demoRegistrationPage.enterAddress("1626 Bedford Avenue, Brooklyn, NY 11225");
        demoRegistrationPage.enterEmailAddress();
        demoRegistrationPage.enterPhoneNumber();
        demoRegistrationPage.selectGender(DemoRegistrationPage.Gender.MALE);
        demoRegistrationPage.selectHobby(DemoRegistrationPage.Hobby.HOCKEY);
        demoRegistrationPage.selectSkill("Java");
        demoRegistrationPage.selectCountry("Japan");
        demoRegistrationPage.enterDateOfBirth("1970", "January", "1");
        demoRegistrationPage.enterPassword("Password2020");
        demoRegistrationPage.submitInformation();

        Assert.assertTrue(demoRegistrationPage.isUsersTablePresent());
    }
}
