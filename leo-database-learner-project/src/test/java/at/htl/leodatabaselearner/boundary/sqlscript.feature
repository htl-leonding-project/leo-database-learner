Feature: SqlScript Management Endpoint
  An user of the Endpoint is able to get all SqlScripts, get a special SqlScript by its Id and get all SqlScripts.

  Background:
    * url baseUrl

  Scenario: Get all SqlScripts
    Given path "sqlscript/get_all"
    When method GET
    * print response

  Scenario: Get SqlScript by id 3
    Given path "sqlscript/getbyid"
      #ID 3
    And path 3
    When method GET
    Then match response contains {"createScript": "CREATE TABLE DOGSCHOOL(id number not null, name varchar2(255), location varchar2(255), zip number ","dropScript": "DROP TABLE DOGSCHOOL;","id": 3,"insertScript": "INSERT INTO DOGSCHOOL(id, name, location, zip) VALUES (1, 'Hundeschule Mayr', 'Leonding', 4060)"}
    * print response

  Scenario: Add SqlScript
    Given path "sqlscript/add_sqlscript"
    And request
        """
        {
          "datamodel": {
          "name": "Hundeschule",
          "person": {
            "firstName": "Marah",
              "lastName": "Steigersdorfer",
              "role": "ADMIN"
            },
          "comment": "Das Modell zeigt eine Hundeschule mit den jeweiligen Attributen."
          },
          "createScript": "CREATE TABLE DOGSCHOOL(id number not null, name varchar2(255), location varchar2(255), zip number ",
          "dropScript": "DROP TABLE DOGSCHOOL;",
          "insertScript": "INSERT INTO DOGSCHOOL(id, name, location, zip) VALUES (1, 'Hundeschule Mayr', 'Leonding', 4060)"
        }
        """
    When method POST
    * print response
