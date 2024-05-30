package com.vorkylele.tests;

import com.vorkylele.api.dto.user.get.response.GetUserResponseDto;
import com.vorkylele.utils.BaseTest;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.vorkylele.api.assertions.user.UserAssertions.checkUserGetResponse;
import static com.vorkylele.steps.UserSteps.getUser;

@Epic("Get User")
@Execution(ExecutionMode.SAME_THREAD) // Тесты выполняются изолированные от других. Так как требуется удаление всех тестовых данных
public class GetUserTests extends BaseTest {

    @Test
    @DisplayName("Get user list when there is at least one user")
    void getUserListWithOneUser() {
        //todo: предварительно удалить всех тестовых юзеров -> добавить пользователя
        GetUserResponseDto response = getUser();

        checkUserGetResponse(response);
    }

    //todo: Расширить тестовый класс для проверок с другими приритетными проверками
}
