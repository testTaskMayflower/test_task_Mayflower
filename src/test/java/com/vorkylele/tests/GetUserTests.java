package com.vorkylele.tests;

import com.vorkylele.utils.BaseTest;
import io.qameta.allure.Epic;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.vorkylele.api.assertions.user.UserAssertions.checkUserGetResponse;
import static com.vorkylele.api.templates.user.UserBody.getCreateUserBody;
import static com.vorkylele.steps.UserSteps.createUser;
import static com.vorkylele.steps.UserSteps.getUser;
import static com.vorkylele.utils.DataGenerator.*;

@Epic("Get User")
@Execution(ExecutionMode.SAME_THREAD)
public class GetUserTests extends BaseTest {

    @Test
    @DisplayName("Get user list when there is at least one user")
    void getUserListWithOneUser() {
        String username = generateUsername();
        String email = generateEmail();
        String password = generatePassword();

        createUser(getCreateUserBody(username, email, password));

        Response response = getUser();

        checkUserGetResponse(response, username, email, password);
    }
}
