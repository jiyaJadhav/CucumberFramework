package com.vtiger.pages;

import com.vtiger.utilities.commonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class leadpage extends commonMethods {

    public leadpage() {

        PageFactory.initElements(driver, this);
    }

    public void enterLastName(String lastname) {

        WebElement tb_lastname =
                driver.findElement(By.name("lastname"));

        tb_lastname.clear();
        tb_lastname.sendKeys(lastname);
    }

    public void enterCompany(String company) {

        WebElement tb_company =
                driver.findElement(By.name("company"));

        tb_company.clear();
        tb_company.sendKeys(company);
    }

    public void clickSave() {

        WebElement btn_save =
                driver.findElement(
                        By.xpath("//input[@title='Save [Alt+S]']"));

        btn_save.click();
    }

    public void createLead(String lastname, String company) {

        enterLastName(lastname);

        enterCompany(company);

        clickSave();
    }

    public boolean isLeadSaved() {

        try {

            return driver.getCurrentUrl()
                    .contains("DetailView");

        } catch (Exception e) {

            return false;
        }
    }
}