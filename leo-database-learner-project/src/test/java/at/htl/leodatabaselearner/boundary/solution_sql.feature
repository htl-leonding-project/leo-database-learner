Feature: SolutionSql Management Endpoint
  An user of the Endpoint is able to get the solutionSql resultset.

  Background:
    * url baseUrl

    Scenario: Get solutionSql resultset
      Given path "result/{id}"
      When method GET
      * print response

