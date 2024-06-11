package com.vorkylele.tests;

import com.vorkylele.utils.BaseTest;
import io.qameta.allure.Epic;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.vorkylele.api.assertions.user.UserAssertions.checkDuplicateUserCreateResponse;
import static com.vorkylele.api.assertions.user.UserAssertions.checkUserCreateResponse;
import static com.vorkylele.api.templates.user.UserBody.getCreateUserBody;
import static com.vorkylele.steps.UserSteps.createUser;
import static com.vorkylele.utils.DataGenerator.generateEmail;
import static com.vorkylele.utils.DataGenerator.generatePassword;
import static com.vorkylele.utils.DataGenerator.generateUsername;

@Epic("Create User")
public class CreateUserTests extends BaseTest {

    @DisplayName("Check create user with valid data")
    @ParameterizedTest(name = "Create user with username: {0}, email: {1}, password: {2}")
    @MethodSource("provideUserData")
    void createUserWithValidData(String username, String email, String password) {
        Response response = createUser(getCreateUserBody(username, email, password));

        checkUserCreateResponse(response, username, email, password);
    }

    static Stream<Arguments> provideUserData() {
        return Stream.of(
                Arguments.of(generateUsername(), generateEmail(), generatePassword()),
                Arguments.of(generateUsername(), generateEmail(), generatePassword()),
                Arguments.of(generateUsername(), generateEmail(), generatePassword())
        );
    }

    @Test
    @DisplayName("Check create duplicate user by username and email")
    void createDuplicateUser() {
        String username = generateUsername();
        String email = generateEmail();
        String password = generatePassword();

        createUser(getCreateUserBody(username, email, password));
        Response response = createUser(getCreateUserBody(username, email, password));

        checkDuplicateUserCreateResponse(response, "userAndEmail");
    }

    @Test
    @DisplayName("Check create duplicate user by username")
    void createDuplicateUserByUsername() {
        String username = generateUsername();
        String email = generateEmail();
        String password = generatePassword();

        createUser(getCreateUserBody(username, email, password));
        Response response = createUser(getCreateUserBody(username, "2" +email, password));

        checkDuplicateUserCreateResponse(response, "user");
    }

    @Test
    @DisplayName("Check create duplicate user by email")
    void createDuplicateUserByEmail() {
        String username = generateUsername();
        String email = generateEmail();
        String password = generatePassword();

        createUser(getCreateUserBody(username, email, password));
        Response response = createUser(getCreateUserBody("2" + username, email, password));

        checkDuplicateUserCreateResponse(response, "email");
    }
}
