package cc.messiah.pages;

import cc.messiah.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Monika
 *
 * HomePage
 */
public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//input[@id='inputName']")
    WebElement yourName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='inputBirthday']")
    WebElement yourBirthday;

    @CacheLookup
    @FindBy(xpath = "//button[@id='submitButton']")
    WebElement submit;

    @CacheLookup
    @FindBy(xpath = "//div[@class='content show']//h1[1]")
    WebElement verifyText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='content show']//h1[2]")
    WebElement verifyAge;

    @CacheLookup
    @FindBy(xpath = "//span[@id='help_name']")
    WebElement verifyNameHelpText;

    @CacheLookup
    @FindBy(xpath = "//span[@id='help_birthday']")
    WebElement getVerifyText;

    public void sendTextToYourNameField(String arg0){
        sendTextToElement(yourName,arg0);
        log.info("Enter yourName field :" + yourName + yourName.toString());
    }
    public void sendTextToYourBirthdayField(String arg0){
        sendTextToElement(yourBirthday,""+arg0);
        log.info("Enter yourBirthday field :" + yourBirthday + yourBirthday.toString());
    }
    public void clickOnSubmit(){
        submit.click();
    }
    public String verifyTheText() {
        log.info("verify the text :" + verifyText.toString());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getTextFromElement(verifyText);
    }
    public String verifyTheAge() {
        log.info("verifyAge the text :" + verifyAge.toString());
        return getTextFromElement(verifyAge);
    }
    public String verifyNameHelpText(){
        log.info("verifyNameHelpText :" + verifyNameHelpText.toString());
        return getTextFromElement(verifyNameHelpText);
    }
    public String verifyErrorText(){
        log.info("verifyErrorText :" + getVerifyText.toString());
        return getTextFromElement(getVerifyText);
    }

}
