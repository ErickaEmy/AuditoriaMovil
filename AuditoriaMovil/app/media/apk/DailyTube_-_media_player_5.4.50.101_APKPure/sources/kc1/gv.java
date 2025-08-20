package kc1;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public final class gv {

    /* renamed from: w  reason: collision with root package name */
    public static final n3 f9766w = new n3(null);

    /* renamed from: wz  reason: collision with root package name */
    public static final gv f9767wz = new y().gv().y();

    /* renamed from: xc  reason: collision with root package name */
    public static final gv f9768xc = new y().v().zn(Integer.MAX_VALUE, TimeUnit.SECONDS).y();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f9769a;

    /* renamed from: c5  reason: collision with root package name */
    public final int f9770c5;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f9771f;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f9772fb;

    /* renamed from: gv  reason: collision with root package name */
    public final int f9773gv;

    /* renamed from: i9  reason: collision with root package name */
    public final boolean f9774i9;

    /* renamed from: n3  reason: collision with root package name */
    public final boolean f9775n3;

    /* renamed from: s  reason: collision with root package name */
    public final int f9776s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f9777t;

    /* renamed from: tl  reason: collision with root package name */
    public String f9778tl;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f9779v;
    public final boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f9780zn;

    /* loaded from: classes.dex */
    public static final class n3 {
        public n3() {
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00e2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final kc1.gv n3(kc1.z r32) {
            /*
                Method dump skipped, instructions count: 419
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kc1.gv.n3.n3(kc1.z):kc1.gv");
        }

        public final int y(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (StringsKt.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9781a;

        /* renamed from: fb  reason: collision with root package name */
        public boolean f9782fb;

        /* renamed from: n3  reason: collision with root package name */
        public boolean f9784n3;

        /* renamed from: s  reason: collision with root package name */
        public boolean f9785s;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public int f9787zn = -1;

        /* renamed from: gv  reason: collision with root package name */
        public int f9783gv = -1;

        /* renamed from: v  reason: collision with root package name */
        public int f9786v = -1;

        public final y gv() {
            this.y = true;
            return this;
        }

        public final int n3(long j2) {
            if (j2 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) j2;
        }

        public final y v() {
            this.f9781a = true;
            return this;
        }

        public final gv y() {
            return new gv(this.y, this.f9784n3, this.f9787zn, -1, false, false, false, this.f9783gv, this.f9786v, this.f9781a, this.f9782fb, this.f9785s, null, null);
        }

        public final y zn(int i, TimeUnit timeUnit) {
            boolean z2;
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            if (i >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.f9783gv = n3(timeUnit.toSeconds(i));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i).toString());
        }
    }

    public gv(boolean z2, boolean z3, int i, int i5, boolean z4, boolean z5, boolean z7, int i6, int i8, boolean z8, boolean z9, boolean z10, String str) {
        this.y = z2;
        this.f9775n3 = z3;
        this.f9780zn = i;
        this.f9773gv = i5;
        this.f9779v = z4;
        this.f9769a = z5;
        this.f9772fb = z7;
        this.f9776s = i6;
        this.f9770c5 = i8;
        this.f9774i9 = z8;
        this.f9771f = z9;
        this.f9777t = z10;
        this.f9778tl = str;
    }

    public final boolean a() {
        return this.f9772fb;
    }

    public final boolean c5() {
        return this.f9774i9;
    }

    public final boolean fb() {
        return this.y;
    }

    public final int gv() {
        return this.f9776s;
    }

    public final boolean n3() {
        return this.f9769a;
    }

    public final boolean s() {
        return this.f9775n3;
    }

    public String toString() {
        String str = this.f9778tl;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            if (this.y) {
                sb.append("no-cache, ");
            }
            if (this.f9775n3) {
                sb.append("no-store, ");
            }
            if (this.f9780zn != -1) {
                sb.append("max-age=");
                sb.append(this.f9780zn);
                sb.append(", ");
            }
            if (this.f9773gv != -1) {
                sb.append("s-maxage=");
                sb.append(this.f9773gv);
                sb.append(", ");
            }
            if (this.f9779v) {
                sb.append("private, ");
            }
            if (this.f9769a) {
                sb.append("public, ");
            }
            if (this.f9772fb) {
                sb.append("must-revalidate, ");
            }
            if (this.f9776s != -1) {
                sb.append("max-stale=");
                sb.append(this.f9776s);
                sb.append(", ");
            }
            if (this.f9770c5 != -1) {
                sb.append("min-fresh=");
                sb.append(this.f9770c5);
                sb.append(", ");
            }
            if (this.f9774i9) {
                sb.append("only-if-cached, ");
            }
            if (this.f9771f) {
                sb.append("no-transform, ");
            }
            if (this.f9777t) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                return "";
            }
            sb.delete(sb.length() - 2, sb.length());
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            this.f9778tl = sb2;
            return sb2;
        }
        return str;
    }

    public final int v() {
        return this.f9770c5;
    }

    public final boolean y() {
        return this.f9779v;
    }

    public final int zn() {
        return this.f9780zn;
    }

    public /* synthetic */ gv(boolean z2, boolean z3, int i, int i5, boolean z4, boolean z5, boolean z7, int i6, int i8, boolean z8, boolean z9, boolean z10, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, z3, i, i5, z4, z5, z7, i6, i8, z8, z9, z10, str);
    }
}
