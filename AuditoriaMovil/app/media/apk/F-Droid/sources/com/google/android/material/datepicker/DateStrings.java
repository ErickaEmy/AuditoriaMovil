package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class DateStrings {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getYearMonth(long j) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = UtcDates.getYearMonthFormat(Locale.getDefault()).format(new Date(j));
            return format;
        }
        return DateUtils.formatDateTime(null, j, 8228);
    }

    static String getMonthDayOfWeekDay(long j) {
        return getMonthDayOfWeekDay(j, Locale.getDefault());
    }

    static String getMonthDayOfWeekDay(long j, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = UtcDates.getMonthWeekdayDayFormat(locale).format(new Date(j));
            return format;
        }
        return UtcDates.getFullFormat(locale).format(new Date(j));
    }

    static String getYearMonthDayOfWeekDay(long j) {
        return getYearMonthDayOfWeekDay(j, Locale.getDefault());
    }

    static String getYearMonthDayOfWeekDay(long j, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = UtcDates.getYearMonthWeekdayDayFormat(locale).format(new Date(j));
            return format;
        }
        return UtcDates.getFullFormat(locale).format(new Date(j));
    }

    static String getOptionalYearMonthDayOfWeekDay(long j) {
        if (isDateWithinCurrentYear(j)) {
            return getMonthDayOfWeekDay(j);
        }
        return getYearMonthDayOfWeekDay(j);
    }

    private static boolean isDateWithinCurrentYear(long j) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return todayCalendar.get(1) == utcCalendar.get(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getDayContentDescription(Context context, long j, boolean z, boolean z2, boolean z3) {
        String optionalYearMonthDayOfWeekDay = getOptionalYearMonthDayOfWeekDay(j);
        if (z) {
            optionalYearMonthDayOfWeekDay = String.format(context.getString(R$string.mtrl_picker_today_description), optionalYearMonthDayOfWeekDay);
        }
        if (z2) {
            return String.format(context.getString(R$string.mtrl_picker_start_date_description), optionalYearMonthDayOfWeekDay);
        }
        return z3 ? String.format(context.getString(R$string.mtrl_picker_end_date_description), optionalYearMonthDayOfWeekDay) : optionalYearMonthDayOfWeekDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getYearContentDescription(Context context, int i) {
        if (UtcDates.getTodayCalendar().get(1) == i) {
            return String.format(context.getString(R$string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i));
        }
        return String.format(context.getString(R$string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i));
    }
}
