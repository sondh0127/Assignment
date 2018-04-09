package com.oolt.assignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN);
    // now date: using for testing saving account
    public static LocalDate now;

    public static void changeNow(String now) {
        DateUtil.now = DateUtil.parse(now);
    }

    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

}

