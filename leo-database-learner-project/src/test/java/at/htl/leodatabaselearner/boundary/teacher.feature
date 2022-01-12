Feature: Student Management Endpoint
  An user of the Endpoint is able to create a Student, get all Students, get a special Student by his Id and get all Students per Class.

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
