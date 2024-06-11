package com.vorkylele.steps;

import com.vorkylele.api.dto.user.create.request.CreateUserRequestDto;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static com.vorkylele.config.EndPoints.CREATE_USER;
import static com.vorkylele.config.EndPoints.GET_USER;
import static com.vorkylele.specifications.Specifications.requestSpecification;
import static io.restassured.RestAssured.given;

@Slf4j
public class UserSteps {

    @Step("Send user/create request")
    public static Response createUser(CreateUserRequestDto body) {
        log.info("Request generated");
        return given()
                .spec(requestSpecification())
                .basePath(CREATE_USER)
                .body(body)
                .post();
    }

    @Step("Send user/get request")
    public static Response getUser() {
        log.info("Request generated");
        return given()
                .spec(requestSpecification())
                .basePath(GET_USER)
                .get();
    }
}
