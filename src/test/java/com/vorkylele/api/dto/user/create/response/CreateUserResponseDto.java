package com.vorkylele.api.dto.user.create.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vorkylele.api.dto.user.create.request.CreateUserRequestDto;
import com.vorkylele.api.dto.user.create.response.partial.UserDetailsPartialDto;
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
public class CreateUserResponseDto {

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("details")
    private UserDetailsPartialDto details;

    @JsonProperty("message")
    private String message;
}