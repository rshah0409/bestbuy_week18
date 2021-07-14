package com.bestbuy.assertionandextraction;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasKey;

public class AssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response =
                given()
                        .when()
                        .get("/stores")
                        .then();
    }
    @Test
   // Verify the if the total is equal to 1561
    public void test001(){
        response.body( "total",equalTo(1561) );
    }
    @Test
    //Verify the if the stores of limit is equal to 10
    public void test002(){

        response.body( "limit", equalTo( 10 ));
    }
    @Test
    // Check the single ‘Name’ in the Array list (Burnsville)
    public void test003(){
        response.body( "data.name",hasItem( "Burnsville" ) );

    }
    @Test
    //Check the multiple ‘Names’ in the ArrayList (Burnsville,Maplewood,Inver Grove Heights)
    public void test004(){
        response.body( "data.name",hasItems( "Burnsville","Maplewood","Inver Grove Heights" ) );
    }
    @Test
    //Verify the storied inside storeservices of the third store of second services
    public void test005(){
        response.body( "data[1].services[1].storeservices",hasKey("storeId") );
    }
    @Test
    //Check hash map values ‘createdAt’ inside storeservices map where store name = Minnetonka
    public void test006(){
        response.body( "data[0].services[3]" ,hasKey( "createdAt" ));
    }
    @Test
    //Verify the state = MN of third store
    public void test007(){
        response.body( "data[2].state" ,equalTo( "MN" ));
    }
    @Test
    //Verify the name = Wes Des Moines of 9th store
    public void test008(){
        response.body( "data[8].name",equalTo( "West Des Moines" ) );

    }
    @Test
    //Verify the storeId = 23 for the 6th store
    public void test009(){

        response.body( "data[5].id",equalTo( 11 ) );
    }
    @Test
    //Verify the serviceId = 12 for the 7th store
    public void test010(){

        response.body( "data[6].services[7].storeservices.serviceId",equalTo( 12 ) );
    }



}
