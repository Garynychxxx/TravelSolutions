package com.travelsolution.page;

import com.travelsolution.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TutByHomePage extends BasePage {


    public static final String HOMEPAGE_URL = "https://www.tut.by/";


    @FindBy(xpath = "//a[@class='enter']")
    private WebElement preSingInButton;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@class='button auth__enter']")
    private WebElement singInButton;

    public TutByHomePage  (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void singIn (String login, String password){

        preSingInButton.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        singInButton.click();
        new WebDriverWait(driver,WAIT_TIME_OUT);
        if (!driver.getCurrentUrl().equals(HOMEPAGE_URL)){
            driver.close();
            singIn(login,password);
        }
    }

    public BasePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIME_OUT);
        return this;
    }

    public Boolean checkCurrentPage() {
        return driver.getCurrentUrl().equals(HOMEPAGE_URL);
    }
}
