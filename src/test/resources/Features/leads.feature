Feature: Lead functionality

  @lead @datatable
  Scenario: lead_creation_TC04

    When user click on new lead and fill the mandatory fields and click on save
      | Modi      | BJP      |
      | Gandhi    | Congress |
      | Kejriwal  | AAP      |

    And click on logout


  @lead @excel
  Scenario: lead_creation_TC05

    When user click on new lead and fill the mandatory fields from excel and click on save

    And click on logout