package com.vorkylele.api.dto.user.create.response;

import com.vorkylele.api.dto.user.create.request.CreateUserRequestDto;
import com.vorkylele.steps.UserSteps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h3>Deserialization of the method response body {@link UserSteps#createUser(CreateUserRequestDto)}</h3>
 *
 * @author A.Vikhlyantsev
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponseDto { //todo: Добавить поля согласно модели ответа
}