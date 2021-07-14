package com.bestbuy.bestbuytest;

import com.bestbuy.StoresPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresTest extends TestBase {

    @Test
    public void getAllstores(){
        Response response =
                given()
                        .when()
                        .get("/stores");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void getStoreById(){
        RestAssured.basePath = "/stores";
        Response response =
                given()
                        .pathParam( "id",12 )
                        .when()
                        .get("/{id}");
        response.prettyPrint();

    }
    @Test
    public void createNewStore(){
        RestAssured.basePath = "/stores";
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName( "Gap" );
        storesPojo.setType( "Clothing" );
        storesPojo.setAddress( "Piccadily" );
        storesPojo.setAddress2("");
        storesPojo.setCity( "London" );
        storesPojo.setState( "England" );
        storesPojo.setZip( "123456" );
        storesPojo.setLat( 23);
        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .body(storesPojo)
                        .when()
                        .post();
        response.then().statusCode( 201 );
        response.prettyPrint();


    }
    @Test
    public void updateStoreById(){
        RestAssured.basePath = "/stores";
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setZip( "789234" );

        Response response =
                given()
                        .header( "Content-Type","application/json" )
                        .body(storesPojo)
                        .when()
                        .patch("/14");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void deleteStoreById(){
        RestAssured.basePath="/stores";
        Response response =
                given()
                        .pathParam( "id","15" )
                        .when()
                        .delete("/{id}");
        response.then().statusCode( 404 );
        response.prettyPrint();


    }
}
