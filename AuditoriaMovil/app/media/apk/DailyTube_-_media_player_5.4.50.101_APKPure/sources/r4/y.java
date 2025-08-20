package r4;

import androidx.annotation.Nullable;
import java.util.HashMap;
import m1.ne;
import v5.j5;
import z0.f3;
/* loaded from: classes.dex */
public final class y {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final String f13123a;

    /* renamed from: c5  reason: collision with root package name */
    public final z0.f3<String, String> f13124c5;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final String f13125fb;

    /* renamed from: gv  reason: collision with root package name */
    public final int f13126gv;

    /* renamed from: i9  reason: collision with root package name */
    public final zn f13127i9;

    /* renamed from: n3  reason: collision with root package name */
    public final int f13128n3;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public final String f13129s;

    /* renamed from: v  reason: collision with root package name */
    public final int f13130v;
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f13131zn;

    /* loaded from: classes.dex */
    public static final class n3 {
        @Nullable

        /* renamed from: c5  reason: collision with root package name */
        public String f13133c5;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public String f13134fb;

        /* renamed from: gv  reason: collision with root package name */
        public final int f13135gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f13136n3;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public String f13137s;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final String f13139zn;

        /* renamed from: v  reason: collision with root package name */
        public final HashMap<String, String> f13138v = new HashMap<>();

        /* renamed from: a  reason: collision with root package name */
        public int f13132a = -1;

        public n3(String str, int i, String str2, int i5) {
            this.y = str;
            this.f13136n3 = i;
            this.f13139zn = str2;
            this.f13135gv = i5;
        }

        public static String f(int i, String str, int i5, int i6) {
            return j5.rz("%d %s/%d/%d", Integer.valueOf(i), str, Integer.valueOf(i5), Integer.valueOf(i6));
        }

        public static String t(int i) {
            boolean z2;
            if (i < 96) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.y(z2);
            if (i != 0) {
                if (i != 8) {
                    if (i != 10) {
                        if (i == 11) {
                            return f(11, "L16", 44100, 1);
                        }
                        throw new IllegalStateException("Unsupported static paylod type " + i);
                    }
                    return f(10, "L16", 44100, 2);
                }
                return f(8, "PCMA", 8000, 1);
            }
            return f(0, "PCMU", 8000, 1);
        }

        public n3 c5(String str, String str2) {
            this.f13138v.put(str, str2);
            return this;
        }

        public y i9() {
            zn y;
            try {
                if (this.f13138v.containsKey("rtpmap")) {
                    y = zn.y((String) j5.i9(this.f13138v.get("rtpmap")));
                } else {
                    y = zn.y(t(this.f13135gv));
                }
                return new y(this, z0.f3.s(this.f13138v), y);
            } catch (ne e2) {
                throw new IllegalStateException(e2);
            }
        }

        public n3 tl(int i) {
            this.f13132a = i;
            return this;
        }

        public n3 w(String str) {
            this.f13134fb = str;
            return this;
        }

        public n3 wz(String str) {
            this.f13137s = str;
            return this;
        }

        public n3 xc(String str) {
            this.f13133c5 = str;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: gv  reason: collision with root package name */
        public final int f13140gv;

        /* renamed from: n3  reason: collision with root package name */
        public final String f13141n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f13142zn;

        public zn(int i, String str, int i5, int i6) {
            this.y = i;
            this.f13141n3 = str;
            this.f13142zn = i5;
            this.f13140gv = i6;
        }

        public static zn y(String str) throws ne {
            boolean z2;
            boolean z3;
            int i;
            String[] ix2 = j5.ix(str, " ");
            if (ix2.length == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.y(z2);
            int s2 = com.google.android.exoplayer2.source.rtsp.s.s(ix2[0]);
            String[] ro2 = j5.ro(ix2[1].trim(), "/");
            if (ro2.length >= 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            v5.y.y(z3);
            int s3 = com.google.android.exoplayer2.source.rtsp.s.s(ro2[1]);
            if (ro2.length == 3) {
                i = com.google.android.exoplayer2.source.rtsp.s.s(ro2[2]);
            } else {
                i = -1;
            }
            return new zn(s2, ro2[0], s3, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || zn.class != obj.getClass()) {
                return false;
            }
            zn znVar = (zn) obj;
            if (this.y == znVar.y && this.f13141n3.equals(znVar.f13141n3) && this.f13142zn == znVar.f13142zn && this.f13140gv == znVar.f13140gv) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((((217 + this.y) * 31) + this.f13141n3.hashCode()) * 31) + this.f13142zn) * 31) + this.f13140gv;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y.class != obj.getClass()) {
            return false;
        }
        y yVar = (y) obj;
        if (this.y.equals(yVar.y) && this.f13128n3 == yVar.f13128n3 && this.f13131zn.equals(yVar.f13131zn) && this.f13126gv == yVar.f13126gv && this.f13130v == yVar.f13130v && this.f13124c5.equals(yVar.f13124c5) && this.f13127i9.equals(yVar.f13127i9) && j5.zn(this.f13123a, yVar.f13123a) && j5.zn(this.f13125fb, yVar.f13125fb) && j5.zn(this.f13129s, yVar.f13129s)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = (((((((((((((217 + this.y.hashCode()) * 31) + this.f13128n3) * 31) + this.f13131zn.hashCode()) * 31) + this.f13126gv) * 31) + this.f13130v) * 31) + this.f13124c5.hashCode()) * 31) + this.f13127i9.hashCode()) * 31;
        String str = this.f13123a;
        int i = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = (hashCode3 + hashCode) * 31;
        String str2 = this.f13125fb;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        String str3 = this.f13129s;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return i6 + i;
    }

    public z0.f3<String, String> y() {
        boolean z2;
        String str = this.f13124c5.get("fmtp");
        if (str == null) {
            return z0.f3.x4();
        }
        String[] ix2 = j5.ix(str, " ");
        if (ix2.length == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.n3(z2, str);
        String[] split = ix2[1].split(";\\s?", 0);
        f3.y yVar = new f3.y();
        for (String str2 : split) {
            String[] ix3 = j5.ix(str2, "=");
            yVar.gv(ix3[0], ix3[1]);
        }
        return yVar.n3();
    }

    public y(n3 n3Var, z0.f3<String, String> f3Var, zn znVar) {
        this.y = n3Var.y;
        this.f13128n3 = n3Var.f13136n3;
        this.f13131zn = n3Var.f13139zn;
        this.f13126gv = n3Var.f13135gv;
        this.f13123a = n3Var.f13134fb;
        this.f13125fb = n3Var.f13137s;
        this.f13130v = n3Var.f13132a;
        this.f13129s = n3Var.f13133c5;
        this.f13124c5 = f3Var;
        this.f13127i9 = znVar;
    }
}
