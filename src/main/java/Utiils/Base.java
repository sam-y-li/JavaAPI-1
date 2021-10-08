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

    public Response post(String endpoint, String body) {
        Request = restUtils.getRequestSpecification();
        Request.body(body);
        return Request.post(endpoint);
    }

    public Response put(String endpoint) {
        Request = restUtils.getRequestSpecification();
        return Request.put(endpoint);
    }

    public Response delete(String endpoint) {
        Request = restUtils.getRequestSpecification();
        return Request.delete(endpoint);
    }



}



