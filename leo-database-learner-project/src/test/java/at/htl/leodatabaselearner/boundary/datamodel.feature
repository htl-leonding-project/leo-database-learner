Feature: DataModel Management Endpoint
  An user of the Endpoint is able to get all DataModels, get a special DataModel by its Id and to add a DataModel.

  Background:
    * url baseUrl

    Scenario: Get all Datamodels
      Given path "datamodel/get_all"
      When method GET
      * print response

    Scenario: Get datamodel by id
      Given path "datamodel/getbyid/{id}"
      When method GET
      * print response

      Scenario: Add Datamodel
        Given path "datamodel/add_datamodel"
        When method POST
        * print response
