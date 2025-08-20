package kx;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import m1.kp;
/* loaded from: classes.dex */
public final class p {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public final long f10068a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public final String f10069c5;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final Object f10070f;

    /* renamed from: fb  reason: collision with root package name */
    public final long f10071fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final byte[] f10072gv;

    /* renamed from: i9  reason: collision with root package name */
    public final int f10073i9;

    /* renamed from: n3  reason: collision with root package name */
    public final long f10074n3;

    /* renamed from: s  reason: collision with root package name */
    public final long f10075s;

    /* renamed from: v  reason: collision with root package name */
    public final Map<String, String> f10076v;
    public final Uri y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f10077zn;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a  reason: collision with root package name */
        public long f10078a;

        /* renamed from: c5  reason: collision with root package name */
        public int f10079c5;

        /* renamed from: fb  reason: collision with root package name */
        public long f10080fb;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public byte[] f10081gv;
        @Nullable

        /* renamed from: i9  reason: collision with root package name */
        public Object f10082i9;

        /* renamed from: n3  reason: collision with root package name */
        public long f10083n3;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public String f10084s;

        /* renamed from: v  reason: collision with root package name */
        public Map<String, String> f10085v;
        @Nullable
        public Uri y;

        /* renamed from: zn  reason: collision with root package name */
        public int f10086zn;

        public n3 a(@Nullable String str) {
            this.f10084s = str;
            return this;
        }

        public n3 c5(Uri uri) {
            this.y = uri;
            return this;
        }

        public n3 f(long j2) {
            this.f10083n3 = j2;
            return this;
        }

        public n3 fb(long j2) {
            this.f10080fb = j2;
            return this;
        }

        public n3 gv(int i) {
            this.f10086zn = i;
            return this;
        }

        public n3 i9(String str) {
            this.y = Uri.parse(str);
            return this;
        }

        public n3 n3(int i) {
            this.f10079c5 = i;
            return this;
        }

        public n3 s(long j2) {
            this.f10078a = j2;
            return this;
        }

        public n3 v(Map<String, String> map) {
            this.f10085v = map;
            return this;
        }

        public p y() {
            v5.y.i9(this.y, "The uri must be set.");
            return new p(this.y, this.f10083n3, this.f10086zn, this.f10081gv, this.f10085v, this.f10078a, this.f10080fb, this.f10084s, this.f10079c5, this.f10082i9);
        }

        public n3 zn(@Nullable byte[] bArr) {
            this.f10081gv = bArr;
            return this;
        }

        public n3() {
            this.f10086zn = 1;
            this.f10085v = Collections.emptyMap();
            this.f10080fb = -1L;
        }

        public n3(p pVar) {
            this.y = pVar.y;
            this.f10083n3 = pVar.f10074n3;
            this.f10086zn = pVar.f10077zn;
            this.f10081gv = pVar.f10072gv;
            this.f10085v = pVar.f10076v;
            this.f10078a = pVar.f10071fb;
            this.f10080fb = pVar.f10075s;
            this.f10084s = pVar.f10069c5;
            this.f10079c5 = pVar.f10073i9;
            this.f10082i9 = pVar.f10070f;
        }
    }

    static {
        kp.y("goog.exo.datasource");
    }

    public static String zn(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return "HEAD";
                }
                throw new IllegalStateException();
            }
            return "POST";
        }
        return "GET";
    }

    public p a(long j2, long j4) {
        if (j2 == 0 && this.f10075s == j4) {
            return this;
        }
        return new p(this.y, this.f10074n3, this.f10077zn, this.f10072gv, this.f10076v, this.f10071fb + j2, j4, this.f10069c5, this.f10073i9, this.f10070f);
    }

    public p fb(Uri uri) {
        return new p(uri, this.f10074n3, this.f10077zn, this.f10072gv, this.f10076v, this.f10071fb, this.f10075s, this.f10069c5, this.f10073i9, this.f10070f);
    }

    public boolean gv(int i) {
        if ((this.f10073i9 & i) == i) {
            return true;
        }
        return false;
    }

    public final String n3() {
        return zn(this.f10077zn);
    }

    public String toString() {
        return "DataSpec[" + n3() + " " + this.y + ", " + this.f10071fb + ", " + this.f10075s + ", " + this.f10069c5 + ", " + this.f10073i9 + "]";
    }

    public p v(long j2) {
        long j4 = this.f10075s;
        long j6 = -1;
        if (j4 != -1) {
            j6 = j4 - j2;
        }
        return a(j2, j6);
    }

    public n3 y() {
        return new n3();
    }

    public p(Uri uri) {
        this(uri, 0L, -1L);
    }

    public p(Uri uri, long j2, long j4) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j2, j4, null, 0, null);
    }

    public p(Uri uri, long j2, int i, @Nullable byte[] bArr, Map<String, String> map, long j4, long j6, @Nullable String str, int i5, @Nullable Object obj) {
        byte[] bArr2 = bArr;
        long j7 = j2 + j4;
        boolean z2 = false;
        v5.y.y(j7 >= 0);
        v5.y.y(j4 >= 0);
        v5.y.y((j6 > 0 || j6 == -1) ? true : true);
        this.y = uri;
        this.f10074n3 = j2;
        this.f10077zn = i;
        this.f10072gv = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f10076v = Collections.unmodifiableMap(new HashMap(map));
        this.f10071fb = j4;
        this.f10068a = j7;
        this.f10075s = j6;
        this.f10069c5 = str;
        this.f10073i9 = i5;
        this.f10070f = obj;
    }
}
