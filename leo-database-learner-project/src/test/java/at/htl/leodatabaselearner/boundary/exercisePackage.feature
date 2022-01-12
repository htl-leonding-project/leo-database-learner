Feature: Student Management Endpoint
  An user of the Endpoint is able to create a Student, get all Students, get a special Student by his Id and get all Students per Class.

  Background:
    * url baseUrl

    Scenario: Get all ExercisePackages
      Given path "exercisePackage/get_all"
      When method GET
      * print response

      Scenario: Add exercisePackage
        Given path "exercisePackage/add_exercisePackage"
        When method POST
        * print response
