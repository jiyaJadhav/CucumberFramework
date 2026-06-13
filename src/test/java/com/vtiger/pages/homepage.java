package com.vtiger.pages;

import com.vtiger.utilities.commonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage extends commonMethods {

    public homepage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Logout")
    private WebElement lnk_logout;

    @FindBy(linkText = "New Lead")
    private WebElement lnk_newLead;

    public boolean isHomePageDisplayed() {

        try {

            return lnk_logout.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isLogoutLinkDisplayed() {

        try {

            return lnk_logout.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public void logout() {

        lnk_logout.click();
    }

    public void clickNewLead() {

        lnk_newLead.click();
    }
}