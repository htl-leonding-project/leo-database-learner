Feature: Student Management Endpoint
  An user of the Endpoint is able to create a Student, get all Students, get a special Student by his Id and get all Students per Class.

  Background:
    * url baseUrl

  Scenario: Get exerciseSql resultset
    Given path "sql/{id}"
    When method GET
    * print response

