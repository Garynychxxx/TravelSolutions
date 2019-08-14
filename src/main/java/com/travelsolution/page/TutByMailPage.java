package com.travelsolution.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TutByMailPage extends BasePage {

    private static final String MAILTUTBY_URL = "https://mail.tut.by/";

    @FindBy(xpath = "//span[@class='mail-NestedList-Item-Info-Link-Text']")
    private WebElement numberOfNotReadLetters;

    @FindBy(xpath = "//span[@class='mail-NestedList-Item-Info-Extras']")
    WebElement numberOfAllLetters;

    public TutByMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public TutByMailPage openPage() {
        driver.get(MAILTUTBY_URL);
        new WebDriverWait(driver, WAIT_TIME_OUT);

        return this;
    }
    public int getResultOfInputMail(){
        return Integer.parseInt(numberOfNotReadLetters.getText());
    }

    protected Boolean checkCurrentPage() {
        return driver.getCurrentUrl().equals(MAILTUTBY_URL);
    }
}
