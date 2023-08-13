package cc.messiah.cucumber.steps;

import cc.messiah.pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by Monika
 *
 * HomePageSteps
 */
public class HomePageSteps {
    HomePage homePage;
    @Given("^I am on the HomePage$")
    public void iAmOnHomePage() {
        homePage = new HomePage();
    }

    @When("^I enter Name \"([^\"]*)\"$")
    public void iEnterYourName(String arg0) throws Throwable {
        homePage.sendTextToYourNameField(arg0);
    }
    @And("^I enter Birthday \"([^\"]*)\"$")
    public void iEnterYourBirthday(String arg0) {
        homePage.sendTextToYourBirthdayField(arg0);
    }
    @And("^I clickOn the Submit button$")
    public void iClickOnSubmitButton() {
        homePage.clickOnSubmit();
    }
    @Then("^verify the welcome message displayed \"([^\"]*)\" \"([^\"]*)\"$")
    public void verifyTheWelcomeMessageDisplayed(String arg0, String arg1) throws Throwable {
        Assert.assertEquals("Hello "+arg0+"!", new HomePage().verifyTheText());
        LocalDate localDate = LocalDate.parse(arg1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        long age = ChronoUnit.YEARS.between(localDate,LocalDate.now());
        Assert.assertEquals("Your age is "+age, new HomePage().verifyTheAge());
    }
    @And("^I enter Birthday a future date$")
    public void iEnterFutureDateInYourBirthday() {
        LocalDateTime localDate = LocalDateTime.now().plusDays(1);
        homePage.sendTextToYourBirthdayField(localDate.format(DateTimeFormatter.ofPattern("ddMMyyyy")));
    }

    @Then("^verify the error message \"([^\"]*)\"$")
    public void verifyTheErrorMessage(String arg0) throws Throwable {
        Assert.assertEquals(arg0, new HomePage().verifyErrorText());
    }

}
