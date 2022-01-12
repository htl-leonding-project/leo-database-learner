Feature: Evaluation Management Endpoint
  An user of the Endpoint is able to get all Evaluations.

  Background:
    * url baseUrl

    Scenario: Get all Evaluations
      Given path "evaluation/get_all"
      When method GET
      * print response
