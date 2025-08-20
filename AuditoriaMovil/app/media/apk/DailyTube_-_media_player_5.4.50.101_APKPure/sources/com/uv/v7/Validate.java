package com.uv.v7;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class Validate {
    private static final String DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified exclusive range of %s to %s";
    private static final String DEFAULT_FINITE_EX_MESSAGE = "The value is invalid: %f";
    private static final String DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified inclusive range of %s to %s";
    private static final String DEFAULT_IS_ASSIGNABLE_EX_MESSAGE = "Cannot assign a %s to a %s";
    private static final String DEFAULT_IS_INSTANCE_OF_EX_MESSAGE = "Expected type: %s, actual: %s";
    private static final String DEFAULT_IS_NULL_EX_MESSAGE = "The validated object is null";
    private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "The validated expression is false";
    private static final String DEFAULT_MATCHES_PATTERN_EX = "The string %s does not match the pattern %s";
    private static final String DEFAULT_NOT_BLANK_EX_MESSAGE = "The validated character sequence is blank";
    private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "The validated array is empty";
    private static final String DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence is empty";
    private static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "The validated collection is empty";
    private static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "The validated map is empty";
    private static final String DEFAULT_NOT_NAN_EX_MESSAGE = "The validated value is not a number";
    private static final String DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE = "The validated array contains null element at index: %d";
    private static final String DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE = "The validated collection contains null element at index: %d";
    private static final String DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE = "The validated array index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE = "The validated collection index is invalid: %d";
    private static final String DEFAULT_VALID_STATE_EX_MESSAGE = "The validated state is false";

    public static <T> void exclusiveBetween(T t2, T t3, Comparable<T> comparable) {
        if (comparable.compareTo(t2) <= 0 || comparable.compareTo(t3) >= 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, comparable, t2, t3));
        }
    }

    public static void finite(double d2) {
        finite(d2, DEFAULT_FINITE_EX_MESSAGE, Double.valueOf(d2));
    }

    public static <T> void inclusiveBetween(T t2, T t3, Comparable<T> comparable) {
        if (comparable.compareTo(t2) < 0 || comparable.compareTo(t3) > 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, comparable, t2, t3));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (cls.isAssignableFrom(cls2)) {
            return;
        }
        throw new IllegalArgumentException(String.format(DEFAULT_IS_ASSIGNABLE_EX_MESSAGE, cls2 == null ? "null" : cls2.getName(), cls.getName()));
    }

    public static void isInstanceOf(Class<?> cls, Object obj) {
        if (cls.isInstance(obj)) {
            return;
        }
        throw new IllegalArgumentException(String.format(DEFAULT_IS_INSTANCE_OF_EX_MESSAGE, cls.getName(), obj == null ? "null" : obj.getClass().getName()));
    }

    public static void isTrue(boolean z2, String str, long j2) {
        if (!z2) {
            throw new IllegalArgumentException(String.format(str, Long.valueOf(j2)));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(DEFAULT_MATCHES_PATTERN_EX, charSequence, str));
        }
    }

    public static <T> T[] notEmpty(T[] tArr, String str, Object... objArr) {
        if (tArr != null) {
            if (tArr.length != 0) {
                return tArr;
            }
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static void notNaN(double d2) {
        notNaN(d2, DEFAULT_NOT_NAN_EX_MESSAGE, new Object[0]);
    }

    public static <T> T notNull(T t2) {
        return (T) notNull(t2, DEFAULT_IS_NULL_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] validIndex(T[] tArr, int i, String str, Object... objArr) {
        notNull(tArr);
        if (i < 0 || i >= tArr.length) {
            throw new IndexOutOfBoundsException(String.format(str, objArr));
        }
        return tArr;
    }

    public static void validState(boolean z2) {
        if (!z2) {
            throw new IllegalStateException(DEFAULT_VALID_STATE_EX_MESSAGE);
        }
    }

    public static void finite(double d2, String str, Object... objArr) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isTrue(boolean z2, String str, double d2) {
        if (!z2) {
            throw new IllegalArgumentException(String.format(str, Double.valueOf(d2)));
        }
    }

    public static void notNaN(double d2, String str, Object... objArr) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T notNull(T t2, String str, Object... objArr) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static void validState(boolean z2, String str, Object... objArr) {
        if (!z2) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static <T> void exclusiveBetween(T t2, T t3, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t2) <= 0 || comparable.compareTo(t3) >= 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> void inclusiveBetween(T t2, T t3, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t2) < 0 || comparable.compareTo(t3) > 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isTrue(boolean z2, String str, Object... objArr) {
        if (!z2) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str, String str2, Object... objArr) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(str2, objArr));
        }
    }

    public static void isTrue(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException(DEFAULT_IS_TRUE_EX_MESSAGE);
        }
    }

    public static <T> T[] notEmpty(T[] tArr) {
        return (T[]) notEmpty(tArr, DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] validIndex(T[] tArr, int i) {
        return (T[]) validIndex(tArr, i, DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE, Integer.valueOf(i));
    }

    public static void exclusiveBetween(long j2, long j4, long j6) {
        if (j6 <= j2 || j6 >= j4) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, Long.valueOf(j6), Long.valueOf(j2), Long.valueOf(j4)));
        }
    }

    public static void inclusiveBetween(long j2, long j4, long j6) {
        if (j6 < j2 || j6 > j4) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, Long.valueOf(j6), Long.valueOf(j2), Long.valueOf(j4)));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2, String str, Object... objArr) {
        if (!cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj, String str, Object... objArr) {
        if (!cls.isInstance(obj)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends Collection<?>> T notEmpty(T t2, String str, Object... objArr) {
        if (t2 != null) {
            if (t2.isEmpty()) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
            return t2;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static <T extends Collection<?>> T validIndex(T t2, int i, String str, Object... objArr) {
        notNull(t2);
        if (i < 0 || i >= t2.size()) {
            throw new IndexOutOfBoundsException(String.format(str, objArr));
        }
        return t2;
    }

    public static void exclusiveBetween(long j2, long j4, long j6, String str) {
        if (j6 <= j2 || j6 >= j4) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void inclusiveBetween(long j2, long j4, long j6, String str) {
        if (j6 < j2 || j6 > j4) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void exclusiveBetween(double d2, double d3, double d4) {
        if (d4 <= d2 || d4 >= d3) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, Double.valueOf(d4), Double.valueOf(d2), Double.valueOf(d3)));
        }
    }

    public static void inclusiveBetween(double d2, double d3, double d4) {
        if (d4 < d2 || d4 > d3) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, Double.valueOf(d4), Double.valueOf(d2), Double.valueOf(d3)));
        }
    }

    public static void exclusiveBetween(double d2, double d3, double d4, String str) {
        if (d4 <= d2 || d4 >= d3) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void inclusiveBetween(double d2, double d3, double d4, String str) {
        if (d4 < d2 || d4 > d3) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T extends Collection<?>> T notEmpty(T t2) {
        return (T) notEmpty(t2, DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE, new Object[0]);
    }

    public static <T extends Collection<?>> T validIndex(T t2, int i) {
        return (T) validIndex(t2, i, DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE, Integer.valueOf(i));
    }

    public static <T extends Map<?, ?>> T notEmpty(T t2, String str, Object... objArr) {
        if (t2 != null) {
            if (t2.isEmpty()) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
            return t2;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static <T extends CharSequence> T validIndex(T t2, int i, String str, Object... objArr) {
        notNull(t2);
        if (i < 0 || i >= t2.length()) {
            throw new IndexOutOfBoundsException(String.format(str, objArr));
        }
        return t2;
    }

    public static <T extends Map<?, ?>> T notEmpty(T t2) {
        return (T) notEmpty(t2, DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE, new Object[0]);
    }

    public static <T extends CharSequence> T validIndex(T t2, int i) {
        return (T) validIndex(t2, i, DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE, Integer.valueOf(i));
    }

    public static <T extends CharSequence> T notEmpty(T t2, String str, Object... objArr) {
        if (t2 != null) {
            if (t2.length() != 0) {
                return t2;
            }
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static <T extends CharSequence> T notEmpty(T t2) {
        return (T) notEmpty(t2, DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE, new Object[0]);
    }
}
