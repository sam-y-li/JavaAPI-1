package Utiils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {

    public RequestSpecification Request;
    RestUtils restUtils = new RestUtils();

    public Response get(String endpoint) {
        Request = restUtils.getRequestSpecification();
        return Request.get(endpoint);
    }

}



