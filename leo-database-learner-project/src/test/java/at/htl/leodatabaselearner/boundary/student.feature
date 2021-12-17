Feature: Student Management Endpoint
  An user of the Endpoint is able to create a Student, get all Students, get a special Student by his Id and get all Students per Class.

  Background:
    * url baseUrl

    Scenario: Get all Students
      Given path "student/get_all"
      When method GET
      * print response

