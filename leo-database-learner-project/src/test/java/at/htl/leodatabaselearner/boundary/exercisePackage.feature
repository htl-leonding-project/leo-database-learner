Feature: ExercisePackage Management Endpoint
  An user of the Endpoint is able to get all ExercisePackages and to add an exercisePackage.

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
