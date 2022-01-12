Feature: Student Management Endpoint
  An user of the Endpoint is able to create a Student, get all Students, get a special Student by his Id and get all Students per Class.

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
