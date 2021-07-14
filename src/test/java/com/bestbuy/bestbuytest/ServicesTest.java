package com.bestbuy.bestbuytest;

import com.bestbuy.ServicePojo;
import com.bestbuy.StoresPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesTest extends TestBase {
    ServicePojo servicePojo = new ServicePojo();
    @Test
    public void getAllServices(){

        Response response =
                given()
                        .when()
                        .get("/services");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void getSingleServiceInfo() {
        RestAssured.basePath = "/services";
        Response response =
                given()
                        .pathParam( "id",7 )
                        .when()
                        .get("/{id}");
        response.prettyPrint();
    }
    @Test
    public void createNewServices(){


        servicePojo.setName( "Nail and Hair Care" );

        Response response =
                given()
                .header( "Content-Type","application/json" )
                .body( servicePojo )
                .when()
                .post("/services");
        response.then().statusCode( 201 );
        response.prettyPrint();
    }
    @Test
    public void updateStoreById(){
        RestAssured.basePath = "/services";
        servicePojo.setName( "Flying Lessons" );

        Response response =
                given()
                        .header( "Content-Type","application/json" )
                        .body(servicePojo)
                        .when()
                        .patch("/13");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void deleteStoreById(){
        RestAssured.basePath ="/services";
        Response response =
                given()
                        .pathParam( "id","10" )
                        .when()
                        .delete("/{id}");
        response.then().statusCode( 404 );
        response.prettyPrint();

    }

}
