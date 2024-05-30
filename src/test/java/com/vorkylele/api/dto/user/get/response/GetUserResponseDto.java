package com.vorkylele.api.dto.user.get.response;

import com.vorkylele.steps.UserSteps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h3>Deserialization of the method response body {@link UserSteps#getUser()}</h3>
 *
 * @author A.Vikhlyantsev
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponseDto { //todo: Добавить поля согласно модели ответа
}