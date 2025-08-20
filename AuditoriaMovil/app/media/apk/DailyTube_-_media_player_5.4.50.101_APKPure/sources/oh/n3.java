package oh;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.regex.Pattern;
import z0.c;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final int f12304n3;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f12305zn;

    /* renamed from: gv  reason: collision with root package name */
    public static final Pattern f12301gv = Pattern.compile("\\s+");

    /* renamed from: v  reason: collision with root package name */
    public static final c<String> f12303v = c.j5("auto", "none");

    /* renamed from: a  reason: collision with root package name */
    public static final c<String> f12299a = c.o("dot", "sesame", "circle");

    /* renamed from: fb  reason: collision with root package name */
    public static final c<String> f12300fb = c.j5("filled", "open");

    /* renamed from: s  reason: collision with root package name */
    public static final c<String> f12302s = c.o("after", "before", "outside");

    public n3(int i, int i5, int i6) {
        this.y = i;
        this.f12304n3 = i5;
        this.f12305zn = i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ed, code lost:
        if (r9.equals("dot") != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static oh.n3 n3(z0.c<java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oh.n3.n3(z0.c):oh.n3");
    }

    @Nullable
    public static n3 y(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String v2 = w0.zn.v(str.trim());
        if (v2.isEmpty()) {
            return null;
        }
        return n3(c.ta(TextUtils.split(v2, f12301gv)));
    }
}
