# AccountService

Spring boot application that helps us view, create, modify, and delete, and view available slots. The following technologies and frameworks have been used

Java Spring Boot Spring Data JPA H2 Database Junit5 Maven

Setup Open terminal and clone the repository cd to the project root Run the following command: mvn clean install Run the project using any ide like intellij, sts or eclipse or use the following command: mvn boot run. The project runs on the port 8080 by default.

API documentation:

GET /accounts


[
  {
    "accountName": "string",
    "accountNumber": "string",
    "accountType": "string",
    "balanceDate": "string",
    "currency": "string",
    "openingBalance": 0
  }
]



Response Body

[
  {
    "accountNumber": "123456789",
    "accountName": "Savings1",
    "accountType": "Savings",
    "balanceDate": "19-09-2019",
    "currency": "INR",
    "openingBalance": 0
  }
]



GET /accounts/transactions


{
  "accountName": "string",
  "accountNumber": "string",
  "currency": "string",
  "transactions": [
    {
      "creditAmount": 0,
      "date": "string",
      "debitAmount": 0,
      "transactionNarrative": "string",
      "type": "string"
    }
  ]
}



Response
{
  "accountNumber": "1234",
  "accountName": "Savings",
  "currency": "INR",
  "transactions": [
    {
      "date": "01-Sep.-2019",
      "type": "Credit",
      "debitAmount": null,
      "creditAmount": 40000,
      "transactionNarrative": "Salary Credited"
    },
    {
      "date": "01-Sep.-2019",
      "type": "Credit",
      "debitAmount": null,
      "creditAmount": 2000,
      "transactionNarrative": "Interest Credited"
    },
    {
      "date": "01-Sep.-2019",
      "type": "Debit",
      "debitAmount": 1500,
      "creditAmount": null,
      "transactionNarrative": null
    },
    {
      "date": "01-Sep.-2019",
      "type": "Debit",
      "debitAmount": 120,
      "creditAmount": null,
      "transactionNarrative": null
    }
  ]
