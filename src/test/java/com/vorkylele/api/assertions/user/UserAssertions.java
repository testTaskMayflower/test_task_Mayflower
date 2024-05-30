package com.vorkylele.api.assertions.user;

import com.vorkylele.api.dto.user.create.response.CreateUserResponseDto;
import com.vorkylele.api.dto.user.get.response.GetUserResponseDto;
import io.restassured.response.Response;

/**
 * <h3>Checks for user tests</h3>
 *
 * @author A.Vikhlyantsev
 */


public class UserAssertions {

    public static void checkBaseUserCreateResponse(Response response) { //todo: Сделать базовую проверку для ответа запросов связанных с User
        //todo: Проверка кода ответа
        //todo: Проверка схемы
    }

    public static void checkBaseUserGetResponse(Response response) { //todo: Сделать базовую проверку для ответа запросов связанных с User
        //todo: Проверка кода ответа
        //todo: Проверка схемы
    }

    public static void checkUserCreateResponse(CreateUserResponseDto response) { //todo: Сделать универсальную проверку для ответа запросов связанных с Create User
        //todo: Проверка тела ответа через softAssertions или AssertAll
    }

    public static void checkUserGetResponse(GetUserResponseDto response) { //todo: Сделать универсальную проверку для ответа запросов связанных с Get User
        //todo: Проверка тела ответа через softAssertions или AssertAll
    }
}
