Feature: Assignment Management Endpoint
  An user of the Endpoint is able to get all Assignments and to add an Assignment.

  Background:
    * url baseUrl

    Scenario: Get all Assignments
      Given path "assignment/get_all"
      When method GET
      * print response

      Scenario: Add assignment
        Given path "assignment/add_assignment"
        When method POST
        * print response
