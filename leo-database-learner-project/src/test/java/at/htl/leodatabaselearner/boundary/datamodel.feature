Feature: Student Management Endpoint
  An user of the Endpoint is able to create a Student, get all Students, get a special Student by his Id and get all Students per Class.

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
