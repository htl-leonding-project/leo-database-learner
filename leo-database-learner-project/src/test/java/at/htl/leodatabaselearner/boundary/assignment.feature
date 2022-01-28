Feature: Assignment Management Endpoint
  An user of the Endpoint is able to get all Assignments and to add an Assignment.

  Background:
    * url baseUrl

    Scenario: Get all Assignments
      Given path "assignment/get_all"
      When method GET
      Then status 200
      * print response

      Scenario: Add assignment
        Given path "assignment/add_assignment"
        And request
        """
        {
  "student": {
    "firstName": "Sabrina",
    "lastName": "Haus",
    "password": "ADMIN",
    "classname": "test"
  },
  "exPackage": {
    "name": "Datamodel 1",
    "datamodel": {
      "name": "Hundeschule1",
      "person": {
        "firstName": "Sarah",
        "lastName": "Feichtinger",
        "role": "ADMIN"
      },
      "comment": "Das Modell zeigt eine Hundeschule mit den jeweiligen Attributen."
    }
  }
}

        """
        When method POST
        * print response
