Feature: Question Management Endpoint
  An user of the Endpoint is able to get all Questions, get a special Question by its Id and get all Questions.

  Background:
    * url baseUrl

    Scenario: Get all Questions
      Given path "question/get_all"
      When method GET
      * print response

    Scenario: Get question by id
      Given path "question/getbyid/{id}"
      When method GET
      * print response

      Scenario: Add Question
        Given path "question/add_question"
        When method POST
        * print response
