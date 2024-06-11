package com.vorkylele.api.assertions.user;

import com.vorkylele.api.dto.user.create.response.CreateUserInvalidResponseDto;
import com.vorkylele.api.dto.user.create.response.CreateUserResponseDto;
import com.vorkylele.api.dto.user.create.response.partial.UserDetailsPartialDto;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static com.vorkylele.utils.Utils.getSoftAssert;
import static com.vorkylele.utils.WorkWithData.generateCurrentFormattedDate;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * <h3>Checks for user tests</h3>
 *
 * @author A.Vikhlyantsev
 */

@Slf4j
public class UserAssertions {

    private static final String expectedSuccessMessage = "User Successully created";
    private static final String expectedDuplicateMessageByUser = "This username is taken. Try another.";
    private static final String expectedDuplicateMessageByEmail = "Email already exists";
    private static final String user = "user";
    private static final String email = "email";
    private static final String userAndEmail = "userAndEmail";

    @Step("Assert response user/create")
    public static void checkUserCreateResponse(Response response, String username, String email, String password) {
        log.info("Check Response user/create");
        assertThat(response.getStatusCode()).as("Code http-response invalid").isEqualTo(SC_OK);
        CreateUserResponseDto responseBody = response.as(CreateUserResponseDto.class);

        SoftAssertions softAssertions = getSoftAssert();

        softAssertions.assertThat(responseBody.getMessage())
                .as("Invalid message")
                .isEqualTo(expectedSuccessMessage);
        softAssertions.assertThat(responseBody.getSuccess())
                .as("Invalid success")
                .isEqualTo(true);
        checkDetails(responseBody.getDetails(), username, email, password, softAssertions);

        softAssertions.assertAll();

        log.info("Success check Response user/create");
    }

    @Step("Assert response user/create")
    public static void checkDuplicateUserCreateResponse(Response response, String error) {
        log.info("Check Response user/create");
        assertThat(response.getStatusCode()).as("Code http-response invalid").isEqualTo(SC_BAD_REQUEST);
        CreateUserInvalidResponseDto responseBody = response.as(CreateUserInvalidResponseDto.class);

        SoftAssertions softAssertions = getSoftAssert();

        softAssertions.assertThat(responseBody.getSuccess())
                .as("Invalid success")
                .isEqualTo(false);
        softAssertions.assertThat(responseBody.getListMessage().size())
                .as("Invalid size message")
                .isEqualTo(1);

        if (user.equals(error)) {
            softAssertions.assertThat(responseBody.getListMessage().get(0))
                    .as("Invalid message")
                    .isEqualTo(expectedDuplicateMessageByUser);
        }
        if (email.equals(error)) {
            softAssertions.assertThat(responseBody.getListMessage().get(0))
                    .as("Invalid message")
                    .isEqualTo(expectedDuplicateMessageByEmail);
        }
        if (userAndEmail.equals(error)) {
            softAssertions.assertThat(responseBody.getListMessage().get(0))
                    .as("Invalid message")
                    .matches(msg -> msg.equals(expectedDuplicateMessageByUser) || msg.equals(expectedDuplicateMessageByEmail));
        }

        softAssertions.assertAll();

        log.info("Success check Response user/create");
    }

    @Step("Assert details of body response")
    public static void checkDetails(UserDetailsPartialDto detailsBody, String username, String email, String password,
                                    SoftAssertions softAssertions) {
        softAssertions.assertThat(detailsBody.getId())
                .as("Id is Empty")
                .isNotNull();
        softAssertions.assertThat(detailsBody.getEmail())
                .as("Invalid email")
                .isEqualTo(email);
        softAssertions.assertThat(detailsBody.getPassword())
                .as("Invalid password")
                .isNotEqualTo(password);
        softAssertions.assertThat(detailsBody.getUsername())
                .as("Invalid username")
                .isEqualTo(username);

        Long actualAddedTime = generateCurrentFormattedDate(detailsBody.getCreatedAt());
        Long actualUpdateTime = generateCurrentFormattedDate(detailsBody.getUpdatedAt());
        Long expectedTime = System.currentTimeMillis() / 1000L;
        Long differenceAddTimeInSeconds = Math.abs(expectedTime - actualAddedTime);
        Long differenceUpdateTimeInSeconds = Math.abs(expectedTime - actualUpdateTime);

        softAssertions.assertThat(differenceAddTimeInSeconds)
                .as("Difference add time difference > 60 seconds = %s seconds", differenceAddTimeInSeconds)
                .isLessThanOrEqualTo(60);
        softAssertions.assertThat(differenceUpdateTimeInSeconds)
                .as("Difference update time difference > 60 seconds = %s seconds", differenceUpdateTimeInSeconds)
                .isLessThanOrEqualTo(60);
    }

    @Step("Assert response user/get")
    public static void checkUserGetResponse(Response response, String username, String email, String password) {
        log.info("Check Response user/get");

        assertThat(response.getStatusCode()).as("Code http-response invalid").isEqualTo(SC_OK);
        List<UserDetailsPartialDto> users = response.jsonPath().getList(".", UserDetailsPartialDto.class);
        assertThat(users.size()).as("Invalid size of users").isGreaterThanOrEqualTo(1);

        SoftAssertions softAssertions = getSoftAssert();
        checkDetails(users.get(users.size() - 1), username, email, password, softAssertions);
        softAssertions.assertAll();

        log.info("Success check Response user/get");
    }

}
