Feature: Question Management Endpoint
  An user of the Endpoint is able to get all Questions, get a special Question by its Id and get all Questions.

  Background:
    * url baseUrl

  Scenario: Get all Questions
    Given path "question/get_all"
    When method GET
    * print response

  Scenario: Get Question by id 8
    Given path "question/getbyid"
      #ID 8
    And path 8
    When method GET
    Then status 200
    Then match response contains {"id": 8,"exercisePackage": {"id": 7,"dataModel": {"comment": "comment1","id": 6,"name": "LeodatabaseLearner","owner": {"firstName": "vani","id": 7,"lastName": "prim","password": "#notnull"}},"name": "Datamodel 1"},"name": "1. Question","points": 2,"sql": "Select d from IT160205.DEPT d","text": "text01"}
    * print response

  Scenario: Add Question
    Given path "question/add_question"
    And request
    """
    {
  "name": "1. Question",
  "text": "Geben Sie alle Personen sortiert nach dem Nachnamen aus.",
  "sql": "Select p from Person p order by p.lastName",
  "points": 2,
  "localDate": "08-01-2020",
  "exercisePackage": {
    "name": "Datamodel 1",
    "datamodel": {
      "name": "Hundeschule1",
      "person": {
        "firstName": "Sarah",
        "lastName": "Feichtinger",
        "role": "ADMIN"
      },
      "comment": "Das Modell zeigt eine Hundeschule mit den jeweiligen Attributen."
    }
  }
}
    """
    When method POST
    * print response
