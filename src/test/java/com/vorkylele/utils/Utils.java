package com.vorkylele.utils;

import org.assertj.core.api.SoftAssertions;

public class Utils {

    private static ThreadLocal<SoftAssertions> softAssertions = ThreadLocal.withInitial(SoftAssertions::new);

    public static SoftAssertions getSoftAssert() {
        return softAssertions.get();
    }

    public static void removeSoftAssert() {
        softAssertions.remove();
    }
}
