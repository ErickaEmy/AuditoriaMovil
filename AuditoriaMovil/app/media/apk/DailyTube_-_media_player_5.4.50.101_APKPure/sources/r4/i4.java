package r4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m1.ne;
import v5.j5;
/* loaded from: classes.dex */
public final class i4 {

    /* renamed from: n3  reason: collision with root package name */
    public final long f13069n3;
    public final long y;

    /* renamed from: zn  reason: collision with root package name */
    public static final i4 f13068zn = new i4(0, -9223372036854775807L);

    /* renamed from: gv  reason: collision with root package name */
    public static final Pattern f13067gv = Pattern.compile("npt[:=]([.\\d]+|now)\\s?-\\s?([.\\d]+)?");

    public i4(long j2, long j4) {
        this.y = j2;
        this.f13069n3 = j4;
    }

    public static i4 gv(String str) throws ne {
        boolean z2;
        long parseFloat;
        long parseFloat2;
        Matcher matcher = f13067gv.matcher(str);
        com.google.android.exoplayer2.source.rtsp.s.y(matcher.matches(), str);
        boolean z3 = true;
        String group = matcher.group(1);
        if (group != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        com.google.android.exoplayer2.source.rtsp.s.y(z2, str);
        if (((String) j5.i9(group)).equals("now")) {
            parseFloat = 0;
        } else {
            parseFloat = Float.parseFloat(group) * 1000.0f;
        }
        String group2 = matcher.group(2);
        if (group2 != null) {
            try {
                parseFloat2 = Float.parseFloat(group2) * 1000.0f;
                if (parseFloat2 < parseFloat) {
                    z3 = false;
                }
                com.google.android.exoplayer2.source.rtsp.s.y(z3, str);
            } catch (NumberFormatException e2) {
                throw ne.v(group2, e2);
            }
        } else {
            parseFloat2 = -9223372036854775807L;
        }
        return new i4(parseFloat, parseFloat2);
    }

    public static String n3(long j2) {
        return j5.rz("npt=%.3f-", Double.valueOf(j2 / 1000.0d));
    }

    public long y() {
        return this.f13069n3 - this.y;
    }

    public boolean zn() {
        if (this.f13069n3 == -9223372036854775807L) {
            return true;
        }
        return false;
    }
}
