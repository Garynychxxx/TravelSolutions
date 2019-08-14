package com.travelsolution.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.travelsolution.page.TutByHomePage;
import com.travelsolution.page.TutByMailPage;

public class MailTest {

    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
    }

    @BeforeTest(alwaysRun = true)
    public void profileSetup() {

        driver.manage().window().maximize();
    }

    @BeforeClass(alwaysRun = true)
    public void appSetup() {
        driver.get(TutByHomePage.HOMEPAGE_URL);
    }

    @Test(groups = {"t1"})
    public void checkInputMails() {
        TutByHomePage tutByHomePage = new TutByHomePage(driver);
        tutByHomePage.singIn("test.account1111@tut.by", "toodifficultpassword");

        int countOfInputMails = new TutByMailPage(driver).openPage().getResultOfInputMail();
        Assert.assertTrue(countOfInputMails >= 0);
        System.out.println("Непрочитанных писем:"+ countOfInputMails);
    }

    @AfterClass(alwaysRun = true)
    public void closeUp() {
        driver.quit();
        driver = null;
    }
}
