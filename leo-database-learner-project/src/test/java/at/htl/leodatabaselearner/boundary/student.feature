Feature: Student Management Endpoint
  An user of the Endpoint is able to create a Student, get all Students, get a special Student by his Id and get all Students per Class.

  Background:
    * url baseUrl

    Scenario: Get all Students
      Given path "student/get_all"
      When method GET
      Then status 200
      Then match response != {}
      * print response

  Scenario: Get Student by ID
    Given path "student/getbyid"
    # ID 3 (existierende ID)
    And path 3
    When method GET
    Then status 204
    And assert responseTime < 500
    Then match response == {}
    * print response

  Scenario: Get all Students
    Given path "add_student"
    When method POST
    * print response
