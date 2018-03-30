package api.mal.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class BaseService {
    private final RequestSpecification specification;
    private Properties properties;

    public BaseService(Properties properties)
    {
        this.properties = properties;
        this.specification = new RequestSpecBuilder()
                        .setContentType(ContentType.JSON)
                        .setBaseUri(properties.getProperty("base_uri"))
                        .setBasePath(properties.getProperty("base_path"))
                        .addFilter(new ResponseLoggingFilter())
                        .addFilter(new RequestLoggingFilter())
                        .addQueryParam("api_key", properties.getProperty("api_key"))
                        .build();
    }

    protected RequestSpecification baseRequest() {
        return given().spec(specification);
    }
}
