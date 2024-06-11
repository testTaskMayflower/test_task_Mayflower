package com.vorkylele.api.dto.user.create.response.partial;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vorkylele.api.dto.user.create.request.CreateUserRequestDto;
import com.vorkylele.steps.UserSteps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h3>Deserialization part of the response body {@link UserSteps#createUser(CreateUserRequestDto)}</h3>
 *
 * @author A.Vikhlyantsev
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsPartialDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;
}
