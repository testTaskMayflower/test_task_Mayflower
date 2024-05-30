package com.vorkylele.steps;

import com.vorkylele.api.dto.user.create.request.CreateUserRequestDto;
import io.restassured.response.Response;


import com.vorkylele.api.dto.user.create.response.CreateUserResponseDto;
import com.vorkylele.api.dto.user.get.response.GetUserResponseDto;

import static com.vorkylele.api.assertions.user.UserAssertions.checkBaseUserGetResponse;
import static com.vorkylele.api.assertions.user.UserAssertions.checkBaseUserCreateResponse;
import static com.vorkylele.config.EndPoints.CREATE_USER;
import static com.vorkylele.config.EndPoints.GET_USER;
import static com.vorkylele.specifications.Specifications.requestSpecification;
import static io.restassured.RestAssured.given;

public class UserSteps {

    public static CreateUserResponseDto createUser(CreateUserRequestDto body) {
        Response response = given()
                .spec(requestSpecification())
                .basePath(CREATE_USER)
                .body(body)
                .post();

        checkBaseUserCreateResponse(response);
        return response.then().extract().as(CreateUserResponseDto.class);
    }


    public static GetUserResponseDto getUser() {
        Response response = given()
                .spec(requestSpecification())
                .basePath(GET_USER)
                .get();

        checkBaseUserGetResponse(response);
        return response.then().extract().as(GetUserResponseDto.class);
    }
}
