package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class ISO8601Utils {
    public static final TimeZone y = TimeZone.getTimeZone("UTC");

    public static String format(Date date) {
        return format(date, false, y);
    }

    public static int gv(String str, int i, int i5) throws NumberFormatException {
        int i6;
        int i8;
        if (i >= 0 && i5 <= str.length() && i <= i5) {
            if (i < i5) {
                i8 = i + 1;
                int digit = Character.digit(str.charAt(i), 10);
                if (digit >= 0) {
                    i6 = -digit;
                } else {
                    throw new NumberFormatException("Invalid number: " + str.substring(i, i5));
                }
            } else {
                i6 = 0;
                i8 = i;
            }
            while (i8 < i5) {
                int i10 = i8 + 1;
                int digit2 = Character.digit(str.charAt(i8), 10);
                if (digit2 >= 0) {
                    i6 = (i6 * 10) - digit2;
                    i8 = i10;
                } else {
                    throw new NumberFormatException("Invalid number: " + str.substring(i, i5));
                }
            }
            return -i6;
        }
        throw new NumberFormatException(str);
    }

    public static int n3(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                i++;
            } else {
                return i;
            }
        }
        return str.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date parse(java.lang.String r19, java.text.ParsePosition r20) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 565
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static boolean y(String str, int i, char c2) {
        if (i < str.length() && str.charAt(i) == c2) {
            return true;
        }
        return false;
    }

    public static void zn(StringBuilder sb, int i, int i5) {
        String num = Integer.toString(i);
        for (int length = i5 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    public static String format(Date date, boolean z2) {
        return format(date, z2, y);
    }

    public static String format(Date date, boolean z2, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z2 ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        zn(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        zn(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        zn(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        zn(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        zn(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        zn(sb, gregorianCalendar.get(13), 2);
        if (z2) {
            sb.append('.');
            zn(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            sb.append(offset >= 0 ? '+' : '-');
            zn(sb, abs, 2);
            sb.append(':');
            zn(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }
}
