package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes.dex */
public class PreJava9DateFormatProvider {
    public static DateFormat getUSDateFormat(int i) {
        return new SimpleDateFormat(y(i), Locale.US);
    }

    public static DateFormat getUSDateTimeFormat(int i, int i5) {
        return new SimpleDateFormat(n3(i) + " " + zn(i5), Locale.US);
    }

    public static String n3(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return "M/d/yy";
                    }
                    throw new IllegalArgumentException("Unknown DateFormat style: " + i);
                }
                return "MMM d, yyyy";
            }
            return "MMMM d, yyyy";
        }
        return "EEEE, MMMM d, yyyy";
    }

    public static String y(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return "M/d/yy";
                    }
                    throw new IllegalArgumentException("Unknown DateFormat style: " + i);
                }
                return "MMM d, y";
            }
            return "MMMM d, y";
        }
        return "EEEE, MMMM d, y";
    }

    public static String zn(int i) {
        if (i != 0 && i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return "h:mm a";
                }
                throw new IllegalArgumentException("Unknown DateFormat style: " + i);
            }
            return "h:mm:ss a";
        }
        return "h:mm:ss a z";
    }
}
