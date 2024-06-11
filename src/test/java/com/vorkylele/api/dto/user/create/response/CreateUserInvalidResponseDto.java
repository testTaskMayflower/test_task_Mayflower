package com.vorkylele.api.dto.user.create.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vorkylele.api.dto.user.create.request.CreateUserRequestDto;
import com.vorkylele.steps.UserSteps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <h3>Deserialization of the method response body {@link UserSteps#createUser(CreateUserRequestDto)}</h3>
 *
 * @author A.Vikhlyantsev
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserInvalidResponseDto {

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("message")
    private List<String> listMessage;
}