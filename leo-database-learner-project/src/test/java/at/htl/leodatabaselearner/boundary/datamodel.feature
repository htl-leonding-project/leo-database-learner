Feature: DataModel Management Endpoint
  An user of the Endpoint is able to get all DataModels, get a special DataModel by its Id and to add a DataModel.

  Background:
    * url baseUrl

  Scenario: Get all Datamodels
    Given path "datamodel/get_all"
    When method GET
    * print response

  Scenario: Get datamodel by id 1
    Given path "datamodel/getbyid"
      #Id 1
    And path 1
    When method GET
    Then status 200
    Then match response contains {"comment": "comment1","id": 1,"name": "LeodatabaseLearner","owner": {"firstName": "vani","id": 4,"lastName": "prim","password": "#notnull"}}
    * print response

  Scenario: Add Datamodel
    Given path "datamodel/add_datamodel"
    And request
        """
        {
  "name": "Restaurant",
  "person": {
    "firstName": "Lisa",
    "lastName": "Gruber",
    "role": "STUDENT"
  },
  "comment": "Das Modell zeigt ein Restaurant mit seinen jeweiligen Attributen."
}
        """
    When method POST
    * print response
