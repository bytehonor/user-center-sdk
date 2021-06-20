package com.bytehonor.sdk.oauth.bytehonor.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.lang.bytehonor.getter.IntegerGetter;
import com.bytehonor.sdk.lang.bytehonor.util.RandomUtils;

public class TimeSecretUtils {

    private static final Logger LOG = LoggerFactory.getLogger(TimeSecretUtils.class);

    private static final String BIT = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int LEN = BIT.length();

    public static String make32() {
        return make32(LocalDateTime.now());
    }

    public static String make32(LocalDateTime ldt) {
        Objects.requireNonNull(ldt, "ldt");
        int rand = RandomUtils.getInt(111, 678); // 3
        int year = ldt.getYear() - 2018; // 1
        int month = ldt.getMonthValue(); // 1
        int day = ldt.getDayOfMonth(); // 1
        int hour = ldt.getHour();// 1
        int minute = ldt.getMinute();// 1
        int second = ldt.getSecond(); // 1
        int sum = rand + year + month + day + hour + minute + second; // 3
        // s4 + 3 + s4 + 1 + 1 + 1 + s4 + 1 + 1 + 1 + s4 + 3 + s4
        return new StringBuilder().append(randstr(4)).append(sum).append(randstr(4)).append(toChar(second))
                .append(toChar(minute)).append(toChar(hour)).append(randstr(4)).append(toChar(day))
                .append(toChar(month)).append(toChar(year)).append(randstr(4)).append(rand).append(randstr(4))
                .toString();
    }

    private static String randstr(int len) {
        return RandomUtils.getString(4);
    }

    private static char toChar(int at) {
        if (at > LEN) {
            return '*';
        }
        return BIT.charAt(at);
    }

    private static int toInt(char c) {
        return BIT.indexOf(c);
    }

    public static LocalDateTime check32(String src) {
        if (src == null || 32 != src.length()) {
            return null;
        }

        int sum = IntegerGetter.optional(src.substring(4, 7), 0);
        int second = toInt(src.charAt(11));
        int minute = toInt(src.charAt(12));
        int hour = toInt(src.charAt(13));
        int day = toInt(src.charAt(18));
        int month = toInt(src.charAt(19));
        int year = toInt(src.charAt(20));
        int rand = IntegerGetter.optional(src.substring(25, 28), 0);
        LOG.debug("sum:{}, {} + {}-{}-{} {}:{}:{}", sum, rand, year, month, day, hour, minute, second);
        if (sum != (rand + second + minute + hour + day + month + year)) {
            return null;
        }
        return LocalDateTime.of(LocalDate.of(2018 + year, month, day), LocalTime.of(hour, minute, second));
    }
}
