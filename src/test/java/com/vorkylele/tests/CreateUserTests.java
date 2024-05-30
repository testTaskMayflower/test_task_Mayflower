package com.vorkylele.tests;

import com.vorkylele.api.dto.user.create.response.CreateUserResponseDto;
import com.vorkylele.utils.BaseTest;
import io.qameta.allure.Epic;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.vorkylele.api.assertions.user.UserAssertions.checkUserCreateResponse;
import static com.vorkylele.api.templates.user.UserBody.getCreateUserBody;
import static com.vorkylele.steps.UserSteps.createUser;

@Epic("Create User")
public class CreateUserTests extends BaseTest {

    @ParameterizedTest(name = "Create user with username: {0}, email: {1}, password: {2}")
    @CsvSource({
            "validUser, valid@example.com, ValidPassword",
            "ab, a@b.c, 12",
            "username1234567890, email1234567890@ex.com, password1234567890"
    })
    void createUserWithValidData(String username, String email, String password) {
        CreateUserResponseDto response = createUser(getCreateUserBody(username, email, password));

        checkUserCreateResponse(response);
    }

    //todo: Расширить тестовый класс для проверок с другими приритетными проверками
}
