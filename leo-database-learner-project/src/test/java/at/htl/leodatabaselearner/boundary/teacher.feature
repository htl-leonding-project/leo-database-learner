Feature: Teacher Management Endpoint
  An user of the Endpoint is able to get all Teachers, get a special Teacher by its Id and get all Teachers.

  Background:
    * url baseUrl

    Scenario: Get all Teachers
      Given path "teacher/get_all"
      When method GET
      * print response

    Scenario: Get teacher by id
      Given path "teacher/getbyid/{id}"
      When method GET
      * print response

      Scenario: Add teacher
        Given path "teacher/add_teacher"
        When method POST
        * print response
