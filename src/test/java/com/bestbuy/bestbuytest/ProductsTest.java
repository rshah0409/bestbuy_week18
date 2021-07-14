package com.bestbuy.bestbuytest;

import com.bestbuy.ProductsPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ProductsTest extends TestBase {
      Random random = new Random();

    @Test
    public void getAllProducts(){
        Response response =
        given()
                        .when()
                        .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void getProductsById(){

      RestAssured.basePath="/products";
        Response response =
                    given()
                            .pathParam("id", 48530)
                            .when()
                            .get("/{id}");

        response.then().statusCode( 200 );
        response.prettyPrint();


    }
    @Test
    public void createNewProduct(){
        ProductsPojo productspojo = new ProductsPojo();
        productspojo.setName("Cadburys");
        productspojo.setType("Milky Bar");
        productspojo.setPrice(20);
        productspojo.setShipping(500);
        productspojo.setUpc("Next Day");
        productspojo.setDescription("Chocolate");
        productspojo.setManufacturer("Dairy Milk");
        productspojo.setModel("Fun Size");
        productspojo.setUrl("cadbury@gmail.com");
        productspojo.setImage("Milky Bar");
         Response response =
               given()
                .header("Content-Type", "application/json")
                .body(productspojo)
                .when()
                .post();
        response.then().statusCode( 201 );
        response.prettyPrint();

    }
    @Test
    public void updateProductById(){
            ProductsPojo productsPojo = new ProductsPojo();
            productsPojo.setPrice( 7 );

            Response response =
                    given()
                    .header( "Content-Type","application/json" )
                            .body(productsPojo)
                            .when()
                            .patch("/48530");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void deleteProductById(){
        Response response =
                given()
                        .pathParam( "id","51958" )
                        .when()
                        .delete("/{id}");
        response.then().statusCode( 404 );
        response.prettyPrint();



    }


}
