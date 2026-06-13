package com.vtiger.stepdefinations;

import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.homepage;
import com.vtiger.pages.leadpage;
import com.vtiger.utilities.ExcelUtils;
import com.vtiger.utilities.commonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.List;

public class leadSteps extends commonMethods {

    @When("user click on new lead and fill the mandatory fields and click on save")
    public void user_click_on_new_lead_and_fill_the_mandatory_fields_and_click_on_save(
            DataTable dataTable) {

        List<List<String>> data = dataTable.asLists();

        for (List<String> row : data) {

            homepage hp = new homepage();
            hp.clickNewLead();

            leadpage lp = new leadpage();
            lp.createLead(row.get(0), row.get(1));

            System.out.println("Lead Created : "
                    + row.get(0) + " | " + row.get(1));
        }
    }

    @When("user click on new lead and fill the mandatory fields from excel and click on save")
    public void user_click_on_new_lead_and_fill_the_mandatory_fields_from_excel_and_click_on_save()
            throws Exception {

        Recordset recordset = ExcelUtils.getData();

        while (recordset.next()) {

            String lastname = recordset.getField("lastname");
            String company = recordset.getField("company");

            homepage hp = new homepage();
            hp.clickNewLead();

            leadpage lp = new leadpage();
            lp.createLead(lastname, company);

            System.out.println(
                    "Lead Created : " + lastname + " | " + company);
        }

        recordset.close();
    }

    @When("click on logout")
    public void click_on_logout() {

        homepage hp = new homepage();
        hp.logout();
    }

    @When("close browser")
    public void close_browser() {

        closeBrowser();
    }
}