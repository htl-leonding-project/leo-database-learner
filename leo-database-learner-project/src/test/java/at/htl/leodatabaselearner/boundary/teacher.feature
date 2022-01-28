Feature: Teacher Management Endpoint
  An user of the Endpoint is able to get all Teachers, get a special Teacher by its Id and get all Teachers.

  Background:
    * url baseUrl

  Scenario: Get all Teachers
    Given path "teacher/get_all"
    When method GET
    * print response

  Scenario: Get teacher by id 2
    Given path "teacher/getbyid"
      #ID 2
    And path 2
    When method GET
    Then status 200
    Then match response contains {"firstName": "madschi", "id": 2, "lastName": "stei", "password": "#notnull"}
    * print response

  Scenario: Add teacher
    Given path "teacher/add_teacher"
    And request
        """
        {
          "firstName": "Ben",
          "lastName": "Müller",
          "password": "1234"
        }
        """
        When method POST
        * print response
