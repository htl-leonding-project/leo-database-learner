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
        And request
        """
        {
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
        """
        When method POST
        * print response
