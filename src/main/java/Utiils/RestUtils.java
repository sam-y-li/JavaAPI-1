package Utiils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RestUtils {

    private static final String file = "data.properties";
    public static Properties prop;

    public RequestSpecification Request;
    RequestSpecBuilder builder;

    RestUtils() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RequestSpecification getRequestSpecification() {
        builder = new RequestSpecBuilder();
        builder.setBaseUri(prop.getProperty("BaseURL"));
        builder.setContentType(ContentType.JSON);
        builder.setRelaxedHTTPSValidation();
        builder.addHeader("X-Risk-Token", prop.getProperty("APIKey"));
        Request = given()
                .spec(builder.build());
        return Request;
    }

}
