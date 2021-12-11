Feature: Verifying Adactin Details

  Scenario Outline: Verifying adactin with valid credentials
    Given user is on adactin page
    When user should enter "<username>" and "<password>" click login
    And user should search hotels "<Location>","<Hotels>","<Room Type>", "<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>"and "<Children per Room>"
    And user should select hotel and click continue
    And user should book a hotel have to enter "<First Name>","<Last Name>","<Billing Address>","<Credit Card No.>","<Credit Card Type>","<Expiry month>", "<Expiry year>"and "<CVV Number>" to book a hotel
    Then user should get the order id

    Examples: 
      | username     | password | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room | First Name | Last Name | Billing Address | Credit Card No.  | Credit Card Type | Expiry month | Expiry year | CVV Number |
      | Abcdefghi123 | VT0R80   | Sydney   | Hotel Creek | Double    | 2 - Two         | 16/11/2021    | 17/11/2021     | 2 - Two         | 2- Two            | Venkatesh  | M         | Thoraipakkam    | 1234123412341234 | VISA             | May          |        2022 |        123 |
      | Abcdefghi123 | VT0R80   | syd      | Hotel Creek | Double    | 2 - Two         | 16/11/2021    | 17/11/2021     | 2 - Two         | 2- Two            | Venkatesh  | M         | Thoraipakkam    | 1234123412341234 | VISA             | May          |        2022 |        123 |
