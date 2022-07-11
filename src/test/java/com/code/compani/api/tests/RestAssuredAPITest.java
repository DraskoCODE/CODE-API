package com.code.compani.api.tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import models.Book;
import models.Books;
import models.Comment;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredAPITest {

    @Test
    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET);
        // Print the status and message body of the response received from the server
        //System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

        if(!response.getBody().asString().equals("")) {
            System.out.println("Response is not empty");
        }

    }

    @Test
    public void JsonToJavaClass() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET);
        // Print the status and message body of the response received from the server
        //System.out.println("Status received => " + response.getStatusLine());
        //System.out.println("Response=>" + response.prettyPrint());

        Books books = response.getBody().as(Books.class);
        System.out.println("Response is not empty");

    }

}
