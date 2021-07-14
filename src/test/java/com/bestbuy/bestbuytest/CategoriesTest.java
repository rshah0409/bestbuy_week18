package com.bestbuy.bestbuytest;

import com.bestbuy.CategoriesPojo;
import com.bestbuy.ServicePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesTest extends TestBase {
    CategoriesPojo categoriesPojo = new CategoriesPojo();
    @Test
    public void getAllCategories(){
        Response response =
                given()
                        .when()
                        .get("/categories");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void getSingleCategoryInfo() {
        RestAssured.basePath = "/categories";
        Response response =
                given()
                        .pathParam( "id","pcmcat138100050024" )
                        .when()
                        .get("/{id}");
        response.prettyPrint();
    }
    @Test
    public void createNewServices(){
        categoriesPojo.setName( "Chocolate Factory" );
        categoriesPojo.setId( "29" );

        Response response =
                given()
                        .header( "Content-Type","application/json" )
                        .body( categoriesPojo )
                        .when()
                        .post("/categories");
        response.then().statusCode( 201 );
        response.prettyPrint();
    }
    @Test
    public void updateStoreById(){
        RestAssured.basePath = "/categories";
        categoriesPojo.setName( "Toys" );

        Response response =
                given()
                        .header( "Content-Type","application/json" )
                        .body(categoriesPojo)
                        .when()
                        .patch("/pcmcat138100050024");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void deleteStoreById(){
        RestAssured.basePath ="/categories";
        Response response =
                given()
                        .pathParam( "id","abcat0010000" )
                        .when()
                        .delete("/{id}");
        response.then().statusCode( 200 );
        response.prettyPrint();

    }

}


