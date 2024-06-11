package com.vorkylele.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class WorkWithData {

    public static Long generateCurrentFormattedDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        return dateTime.toEpochSecond(ZoneOffset.UTC);
    }
}
