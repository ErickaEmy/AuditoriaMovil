package org.acra.file;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.acra.ACRAConstants;
/* compiled from: CrashReportFileNameParser.kt */
/* loaded from: classes2.dex */
public final class CrashReportFileNameParser {
    public final boolean isSilent(String reportFileName) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(reportFileName, "reportFileName");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) reportFileName, (CharSequence) ACRAConstants.SILENT_SUFFIX, false, 2, (Object) null);
        return contains$default;
    }

    public final Calendar getTimestamp(String reportFileName) {
        String replace$default;
        String replace$default2;
        Intrinsics.checkNotNullParameter(reportFileName, "reportFileName");
        replace$default = StringsKt__StringsJVMKt.replace$default(reportFileName, ".stacktrace", "", false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, ACRAConstants.SILENT_SUFFIX, "", false, 4, (Object) null);
        Calendar calendar = Calendar.getInstance();
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ", Locale.ENGLISH).parse(replace$default2);
            Intrinsics.checkNotNull(parse);
            calendar.setTime(parse);
        } catch (ParseException unused) {
        }
        Intrinsics.checkNotNull(calendar);
        return calendar;
    }
}
