package com.vorkylele.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import static com.vorkylele.utils.Utils.removeSoftAssert;

@DisplayName("Test Configuration")
public class BaseTest {

    @DisplayName("Configuration before the test class")
    @BeforeAll
    public static void beforeClass() {

    }

    @DisplayName("Configuration after the test")
    @AfterEach
    public void afterTest() {
        removeSoftAssert();
    }
}
