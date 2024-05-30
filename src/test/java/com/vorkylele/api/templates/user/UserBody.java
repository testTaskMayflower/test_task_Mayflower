package com.vorkylele.api.templates.user;

import com.vorkylele.api.dto.user.create.request.CreateUserRequestDto;
import com.vorkylele.steps.UserSteps;

/**
 * <h3>Prepared body template to send in a method request {@link UserSteps#createUser(CreateUserRequestDto)}}</h3>
 *
 * @author A.Vikhlyantsev
 */


public class UserBody {

    public static CreateUserRequestDto getCreateUserBody(String username, String email, String password) {
        return CreateUserRequestDto.builder()
                .username(username)
                .email(email)
                .password(password)
                .build();
    }
}
