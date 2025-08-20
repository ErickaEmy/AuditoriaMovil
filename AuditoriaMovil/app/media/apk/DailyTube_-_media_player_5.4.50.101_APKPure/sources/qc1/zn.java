package qc1;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: n3  reason: collision with root package name */
    public static final String[] f12804n3;
    public static final y y = new y();

    /* renamed from: zn  reason: collision with root package name */
    public static final DateFormat[] f12805zn;

    /* loaded from: classes.dex */
    public static final class y extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        /* renamed from: y */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(lc1.n3.f10301a);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f12804n3 = strArr;
        f12805zn = new DateFormat[strArr.length];
    }

    public static final String n3(Date toHttpDateString) {
        Intrinsics.checkNotNullParameter(toHttpDateString, "$this$toHttpDateString");
        String format = y.get().format(toHttpDateString);
        Intrinsics.checkNotNullExpressionValue(format, "STANDARD_DATE_FORMAT.get().format(this)");
        return format;
    }

    public static final Date y(String toHttpDateOrNull) {
        Intrinsics.checkNotNullParameter(toHttpDateOrNull, "$this$toHttpDateOrNull");
        if (toHttpDateOrNull.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = y.get().parse(toHttpDateOrNull, parsePosition);
        if (parsePosition.getIndex() == toHttpDateOrNull.length()) {
            return parse;
        }
        String[] strArr = f12804n3;
        synchronized (strArr) {
            try {
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    DateFormat[] dateFormatArr = f12805zn;
                    DateFormat dateFormat = dateFormatArr[i];
                    if (dateFormat == null) {
                        dateFormat = new SimpleDateFormat(f12804n3[i], Locale.US);
                        dateFormat.setTimeZone(lc1.n3.f10301a);
                        dateFormatArr[i] = dateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date parse2 = dateFormat.parse(toHttpDateOrNull, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return parse2;
                    }
                }
                Unit unit = Unit.INSTANCE;
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
