Feature: Student Management Endpoint
  An user of the Endpoint is able to create a Student, get all Students, get a special Student by its Id and get all Students per Class.

  Background:
    * url baseUrl

  Scenario: Get all Students
    Given path "student/get_all"
    When method GET
    * print response

  Scenario: Get student by id 3
    Given path "student/getbyid"
      #ID 3
    And path 3
    When method GET
    Then match response contains {"firstName": "Bernd","id": 3,"lastName": "test","password": "#notnull","classname": "test"}
    * print response

  Scenario: Add student
    Given path "student/add_student"
    And request
        """
        {
          "firstName": "Sabrina",
          "lastName": "Haus",
          "password": "ADMIN",
          "classname": "test"
        }
        """
    When method POST
    * print response
