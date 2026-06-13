package com.vtiger.pages;

import com.vtiger.utilities.commonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage extends commonMethods {

    public loginpage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "user_name")
    private WebElement tb_username;

    @FindBy(name = "user_password")
    private WebElement tb_password;

    @FindBy(name = "Login")
    private WebElement btn_login;

    @FindBy(xpath = "//div[contains(text(),'valid username and password')]")
    private WebElement errorMessage;

    public void enterUsername(String username) {

        tb_username.clear();
        tb_username.sendKeys(username);
    }

    public void enterPassword(String password) {

        tb_password.clear();
        tb_password.sendKeys(password);
    }

    public void clickLogin() {

        btn_login.click();
    }

    public boolean isLoginPageDisplayed() {

        try {

            return btn_login.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public String getErrorMessage() {

        try {

            return errorMessage.getText();

        } catch (Exception e) {

            return "";
        }
    }
}