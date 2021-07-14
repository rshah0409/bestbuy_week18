package com.bestbuy.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TestBase {

    @BeforeClass
    public static void init() {


        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
     //   RestAssured.basePath = "/products";
    }

    }


