package com.study.hello.distributed.mybatis.framework.commons.util;

import com.study.hello.distributed.mybatis.framework.commons.exception.ApiInputException;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@UtilityClass
public class ApiUtils {

    /**
     * @param resource
     * @return
     */
    public static String forward(String resource) {
        return "forward:" + resource;
    }

    /**
     * @param resource
     * @return
     */
    public static String redirect(String resource) {
        return "redirect:" + resource;
    }

    /**
     * validate given id should not be null.
     *
     * @param id
     * @throws ApiInputException
     */
    public static void notNull(Long id) {
        if (id == null) {
            throw new ApiInputException("id is null");
        }
    }

    /**
     * validate given value should not be null.
     *
     * @param value
     * @throws ApiInputException
     */
    public static void notNull(Object value) {
        if (value == null) {
            throw new ApiInputException("value is null");
        }
    }

    /**
     * validate given value should not be empty.
     *
     * @param value
     * @throws ApiInputException
     */
    public static void notEmpty(String value) {
        if (value == null) {
            throw new ApiInputException("value is empty");
        }
    }

    /**
     * validate given value should not be blank.
     *
     * @param value
     * @throws ApiInputException
     */
    public static void notBlank(String value) {
        if (value == null) {
            throw new ApiInputException("value is blank");
        }
    }

    /**
     * parse int value; if failed then throws {@link ApiInputException}
     *
     * @param value
     * @return
     */
    public static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new ApiInputException("Invalid Integer value: " + value);
        }
    }

    /**
     * parse int value; if failed, then return default value.
     *
     * @param value
     * @param defaultValue
     * @return
     */
    public static int parseInt(String value, int defaultValue) {
        if (StringUtils.isNotEmpty(value)) {
            try {
                return Integer.parseInt(value);
            } catch (Exception e) {
                // do nothing
            }
        }
        return defaultValue;
    }

    /**
     * parse long value; if failed then throws {@link ApiInputException}
     *
     * @param value
     * @return
     */
    public static long parseLong(String value) {
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            throw new ApiInputException("Invalid Long value: " + value);
        }
    }

    /**
     * parse long value; if failed, then return default value.
     *
     * @param value
     * @param defaultValue
     * @return
     */
    public static long parseLong(String value, long defaultValue) {
        if (StringUtils.isNotEmpty(value)) {
            try {
                return Long.parseLong(value);
            } catch (Exception e) {
                // do nothing
            }
        }
        return defaultValue;
    }

    /**
     * parse OffsetDateTime value; if failed then throws {@link ApiInputException}
     *
     * @param value
     * @return
     */
    public static OffsetDateTime parseOffsetDateTime(String value) {
        try {
            return OffsetDateTime.parse(value);
        } catch (Exception e) {
            throw new ApiInputException("Invalid Long value: " + value);
        }
    }

    /**
     * parse OffsetDateTime value; if failed, then return default value.
     *
     * @param value
     * @param defaultValue
     * @return
     */
    public static OffsetDateTime parseOffsetDateTime(String value, OffsetDateTime defaultValue) {
        if (StringUtils.isNotEmpty(value)) {
            try {
                return OffsetDateTime.parse(value);
            } catch (Exception e) {
                // do nothing
            }
        }
        return defaultValue;
    }

    /**
     * parse LocalDateTime value; if failed then throws {@link ApiInputException}
     *
     * @param value
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String value) {
        try {
            return LocalDateTime.parse(value);
        } catch (Exception e) {
            throw new ApiInputException("Invalid Long value: " + value);
        }
    }

    /**
     * parse LocalDateTime value; if failed, then return default value.
     *
     * @param value
     * @param defaultValue
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String value, LocalDateTime defaultValue) {
        if (StringUtils.isNotEmpty(value)) {
            try {
                return LocalDateTime.parse(value);
            } catch (Exception e) {
                // do nothing
            }
        }
        return defaultValue;
    }

    /**
     * parse LocalDate value; if failed then throws {@link ApiInputException}
     *
     * @param value
     * @return
     */
    public static LocalDate parseLocalDate(String value) {
        try {
            return LocalDate.parse(value);
        } catch (Exception e) {
            throw new ApiInputException("Invalid Long value: " + value);
        }
    }

    /**
     * parse LocalDate value; if failed, then return default value.
     *
     * @param value
     * @param defaultValue
     * @return
     */
    public static LocalDate parseLocalDate(String value, LocalDate defaultValue) {
        if (StringUtils.isNotEmpty(value)) {
            try {
                return LocalDate.parse(value);
            } catch (Exception e) {
                // do nothing
            }
        }
        return defaultValue;
    }

    /**
     * parse LocalTime value; if failed then throws {@link ApiInputException}
     *
     * @param value
     * @return
     */
    public static LocalTime parseLocalTime(String value) {
        try {
            return LocalTime.parse(value);
        } catch (Exception e) {
            throw new ApiInputException("Invalid Long value: " + value);
        }
    }

    /**
     * parse LocalTime value; if failed, then return default value.
     *
     * @param value
     * @param defaultValue
     * @return
     */
    public static LocalTime parseLocalTime(String value, LocalTime defaultValue) {
        if (StringUtils.isNotEmpty(value)) {
            try {
                return LocalTime.parse(value);
            } catch (Exception e) {
                // do nothing
            }
        }
        return defaultValue;
    }

    /**
     * parse items separated by comma (,)
     *
     * @param items
     * @return
     * @throws ApiInputException
     */
    public static List<Long> parseIds(String items) {
        return toList(items, Long::valueOf);
    }


    /**
     * parse items separated by comma (,)
     *
     * @param items
     * @param itemFunc
     * @return
     * @throws ApiInputException
     */
    public static <T> List<T> toList(String items, Function<String, T> itemFunc) {
        List<T> valueList = new ArrayList<>();
        String[] itemList = items.split(",");
        for (String item : itemList) {
            try {
                valueList.add(itemFunc.apply(item));
            } catch (NumberFormatException e) {
                throw new ApiInputException("Invalid value: " + items, e);
            }
        }
        return valueList;
    }

    /**
     * 注意 separatorChar 和 escapeChar 不可以相同
     *
     * @param text
     * @param separatorChar
     * @param escapeChar
     * @return
     */
    public static List<String> split(String text, char separatorChar, char escapeChar) {
        return split(text, separatorChar, escapeChar, false);
    }

    /**
     * 注意 separatorChar 和 escapeChar 不可以相同
     *
     * @param text
     * @param separatorChar
     * @param escapeChar
     * @param reserveEscape
     * @return
     */
    public static List<String> split(String text, char separatorChar, char escapeChar, boolean reserveEscape) {
        if (separatorChar == escapeChar) {
            throw new ApiInputException("Same char between separateChar and escapeChar: " + separatorChar + " == " + escapeChar);
        }
        List<String> items = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int maxLen = text.length();
        while (index < maxLen) {
            char currChar = text.charAt(index);
            if (currChar == escapeChar) {
                if (index + 1 >= maxLen) {
                    throw new ApiInputException("Terminated at escape: " + text);
                }
                char nextChar = text.charAt(index + 1);
                if (reserveEscape) {
                    sb.append(currChar);
                }
                sb.append(nextChar);
                index += 2;
                if (index >= maxLen) {
                    items.add(sb.toString());
                    sb.setLength(0); // keep symantics, though unnecessary
                }
            } else if (currChar == separatorChar) {
                items.add(sb.toString());
                sb.setLength(0); // reset
                index += 1;
                if (index >= maxLen) {
                    items.add(""); // last empty element
                }
            } else {
                sb.append(currChar);
                index += 1;
                if (index >= maxLen) {
                    items.add(sb.toString());
                    sb.setLength(0); // keep symantics, though unnecessary
                }
            }
        }
        return items;
    }

}
