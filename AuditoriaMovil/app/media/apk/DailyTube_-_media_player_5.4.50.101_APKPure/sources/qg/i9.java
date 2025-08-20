package qg;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class i9 {

    /* renamed from: zn  reason: collision with root package name */
    public static final i9 f12818zn = new i9(null, null);
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final TimeZone f12819n3;
    @Nullable
    public final Long y;

    public i9(@Nullable Long l2, @Nullable TimeZone timeZone) {
        this.y = l2;
        this.f12819n3 = timeZone;
    }

    public static i9 zn() {
        return f12818zn;
    }

    public Calendar n3(@Nullable TimeZone timeZone) {
        Calendar calendar;
        if (timeZone == null) {
            calendar = Calendar.getInstance();
        } else {
            calendar = Calendar.getInstance(timeZone);
        }
        Long l2 = this.y;
        if (l2 != null) {
            calendar.setTimeInMillis(l2.longValue());
        }
        return calendar;
    }

    public Calendar y() {
        return n3(this.f12819n3);
    }
}
