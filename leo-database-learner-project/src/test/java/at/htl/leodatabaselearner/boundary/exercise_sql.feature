Feature: ExerciseSql Management Endpoint
  An user of the Endpoint is able to get an exerciseSql resultset.

  Background:
    * url baseUrl

  Scenario: Get exerciseSql resultset
    Given path "sql/{id}"
    When method GET
    * print response

