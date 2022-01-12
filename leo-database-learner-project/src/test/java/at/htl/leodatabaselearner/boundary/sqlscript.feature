Feature: SqlScript Management Endpoint
  An user of the Endpoint is able to get all SqlScripts, get a special SqlScript by its Id and get all SqlScripts.

  Background:
    * url baseUrl

    Scenario: Get all SqlScripts
      Given path "sqlscript/get_all"
      When method GET
      * print response

    Scenario: Get SqlScript by id
      Given path "sqlscript/getbyid/{id}"
      When method GET
      * print response

      Scenario: Add SqlScript
        Given path "sqlscript/add_sqlscript"
        When method POST
        * print response
