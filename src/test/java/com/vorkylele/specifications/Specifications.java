package com.vorkylele.specifications;


import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.vorkylele.config.ConfigSingle.config;

/**
 * <h3>API specifications</h3>
 *
 * @author A.Vikhlyantsev
 */

public class Specifications {

    private static final AllureRestAssured FILTER = new AllureRestAssured()
            .setRequestTemplate("request.ftl")
            .setResponseTemplate("response.ftl");

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(config.getBaseUriProperties())
                .addFilter(FILTER)
                .build();
    }
}
