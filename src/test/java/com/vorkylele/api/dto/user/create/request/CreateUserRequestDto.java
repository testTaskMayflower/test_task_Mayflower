package com.vorkylele.api.dto.user.create.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vorkylele.steps.UserSteps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h3>Serialization of the method request body {@link UserSteps#createUser(CreateUserRequestDto)}</h3>
 *
 * @author A.Vikhlyantsev
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestDto {
    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;
}