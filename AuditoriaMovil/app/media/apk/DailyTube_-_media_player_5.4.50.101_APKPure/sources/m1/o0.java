package m1;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import m1.o0;
import m1.s;
import z0.x4;
/* loaded from: classes.dex */
public final class o0 implements m1.s {

    /* renamed from: f  reason: collision with root package name */
    public final qk f11017f;
    @Nullable
    @Deprecated

    /* renamed from: fb  reason: collision with root package name */
    public final c5 f11018fb;

    /* renamed from: p  reason: collision with root package name */
    public final i9 f11019p;

    /* renamed from: s  reason: collision with root package name */
    public final fb f11020s;

    /* renamed from: t  reason: collision with root package name */
    public final gv f11021t;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final s f11022v;
    @Deprecated

    /* renamed from: w  reason: collision with root package name */
    public final v f11023w;
    public final String y;

    /* renamed from: co  reason: collision with root package name */
    public static final o0 f11011co = new zn().y();

    /* renamed from: z  reason: collision with root package name */
    public static final String f11016z = v5.j5.g3(0);

    /* renamed from: r  reason: collision with root package name */
    public static final String f11015r = v5.j5.g3(1);

    /* renamed from: f3  reason: collision with root package name */
    public static final String f11013f3 = v5.j5.g3(2);

    /* renamed from: n  reason: collision with root package name */
    public static final String f11014n = v5.j5.g3(3);

    /* renamed from: c  reason: collision with root package name */
    public static final String f11010c = v5.j5.g3(4);

    /* renamed from: d0  reason: collision with root package name */
    public static final s.y<o0> f11012d0 = new s.y() { // from class: m1.cr
        @Override // m1.s.y
        public final s fromBundle(Bundle bundle) {
            o0 zn2;
            zn2 = o0.zn(bundle);
            return zn2;
        }
    };

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f11024a;
        @Deprecated

        /* renamed from: c5  reason: collision with root package name */
        public final z0.x4<Integer> f11025c5;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f11026f;

        /* renamed from: fb  reason: collision with root package name */
        public final boolean f11027fb;
        @Deprecated

        /* renamed from: gv  reason: collision with root package name */
        public final z0.f3<String, String> f11028gv;

        /* renamed from: i9  reason: collision with root package name */
        public final z0.x4<Integer> f11029i9;
        @Deprecated

        /* renamed from: n3  reason: collision with root package name */
        public final UUID f11030n3;

        /* renamed from: s  reason: collision with root package name */
        public final boolean f11031s;

        /* renamed from: v  reason: collision with root package name */
        public final z0.f3<String, String> f11032v;
        public final UUID y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public final Uri f11033zn;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.y.equals(aVar.y) && v5.j5.zn(this.f11033zn, aVar.f11033zn) && v5.j5.zn(this.f11032v, aVar.f11032v) && this.f11024a == aVar.f11024a && this.f11031s == aVar.f11031s && this.f11027fb == aVar.f11027fb && this.f11029i9.equals(aVar.f11029i9) && Arrays.equals(this.f11026f, aVar.f11026f)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int hashCode = this.y.hashCode() * 31;
            Uri uri = this.f11033zn;
            if (uri != null) {
                i = uri.hashCode();
            } else {
                i = 0;
            }
            return ((((((((((((hashCode + i) * 31) + this.f11032v.hashCode()) * 31) + (this.f11024a ? 1 : 0)) * 31) + (this.f11031s ? 1 : 0)) * 31) + (this.f11027fb ? 1 : 0)) * 31) + this.f11029i9.hashCode()) * 31) + Arrays.hashCode(this.f11026f);
        }

        public y n3() {
            return new y();
        }

        @Nullable
        public byte[] zn() {
            byte[] bArr = this.f11026f;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        /* loaded from: classes.dex */
        public static final class y {

            /* renamed from: a  reason: collision with root package name */
            public boolean f11034a;

            /* renamed from: fb  reason: collision with root package name */
            public z0.x4<Integer> f11035fb;

            /* renamed from: gv  reason: collision with root package name */
            public boolean f11036gv;
            @Nullable

            /* renamed from: n3  reason: collision with root package name */
            public Uri f11037n3;
            @Nullable

            /* renamed from: s  reason: collision with root package name */
            public byte[] f11038s;

            /* renamed from: v  reason: collision with root package name */
            public boolean f11039v;
            @Nullable
            public UUID y;

            /* renamed from: zn  reason: collision with root package name */
            public z0.f3<String, String> f11040zn;

            public a c5() {
                return new a(this);
            }

            @Deprecated
            public y() {
                this.f11040zn = z0.f3.x4();
                this.f11035fb = z0.x4.j5();
            }

            public y(a aVar) {
                this.y = aVar.y;
                this.f11037n3 = aVar.f11033zn;
                this.f11040zn = aVar.f11032v;
                this.f11036gv = aVar.f11024a;
                this.f11039v = aVar.f11027fb;
                this.f11034a = aVar.f11031s;
                this.f11035fb = aVar.f11029i9;
                this.f11038s = aVar.f11026f;
            }
        }

        public a(y yVar) {
            v5.y.fb((yVar.f11034a && yVar.f11037n3 == null) ? false : true);
            UUID uuid = (UUID) v5.y.v(yVar.y);
            this.y = uuid;
            this.f11030n3 = uuid;
            this.f11033zn = yVar.f11037n3;
            this.f11028gv = yVar.f11040zn;
            this.f11032v = yVar.f11040zn;
            this.f11024a = yVar.f11036gv;
            this.f11031s = yVar.f11034a;
            this.f11027fb = yVar.f11039v;
            this.f11025c5 = yVar.f11035fb;
            this.f11029i9 = yVar.f11035fb;
            this.f11026f = yVar.f11038s != null ? Arrays.copyOf(yVar.f11038s, yVar.f11038s.length) : null;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static final class c5 extends s {
        public c5(Uri uri, @Nullable String str, @Nullable a aVar, @Nullable n3 n3Var, List<StreamKey> list, @Nullable String str2, z0.x4<t> x4Var, @Nullable Object obj) {
            super(uri, str, aVar, n3Var, list, str2, x4Var, obj);
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static final class f extends t {
        public f(t.y yVar) {
            super(yVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class fb implements m1.s {

        /* renamed from: f  reason: collision with root package name */
        public final float f11048f;

        /* renamed from: fb  reason: collision with root package name */
        public final long f11049fb;

        /* renamed from: s  reason: collision with root package name */
        public final float f11050s;

        /* renamed from: v  reason: collision with root package name */
        public final long f11051v;
        public final long y;

        /* renamed from: t  reason: collision with root package name */
        public static final fb f11045t = new y().a();

        /* renamed from: w  reason: collision with root package name */
        public static final String f11046w = v5.j5.g3(0);

        /* renamed from: p  reason: collision with root package name */
        public static final String f11043p = v5.j5.g3(1);

        /* renamed from: co  reason: collision with root package name */
        public static final String f11041co = v5.j5.g3(2);

        /* renamed from: z  reason: collision with root package name */
        public static final String f11047z = v5.j5.g3(3);

        /* renamed from: r  reason: collision with root package name */
        public static final String f11044r = v5.j5.g3(4);

        /* renamed from: f3  reason: collision with root package name */
        public static final s.y<fb> f11042f3 = new s.y() { // from class: m1.wf
            @Override // m1.s.y
            public final s fromBundle(Bundle bundle) {
                o0.fb zn2;
                zn2 = o0.fb.zn(bundle);
                return zn2;
            }
        };

        /* loaded from: classes.dex */
        public static final class y {

            /* renamed from: gv  reason: collision with root package name */
            public float f11052gv;

            /* renamed from: n3  reason: collision with root package name */
            public long f11053n3;

            /* renamed from: v  reason: collision with root package name */
            public float f11054v;
            public long y;

            /* renamed from: zn  reason: collision with root package name */
            public long f11055zn;

            public fb a() {
                return new fb(this);
            }

            public y c5(long j2) {
                this.f11053n3 = j2;
                return this;
            }

            public y f(long j2) {
                this.y = j2;
                return this;
            }

            public y fb(long j2) {
                this.f11055zn = j2;
                return this;
            }

            public y i9(float f4) {
                this.f11052gv = f4;
                return this;
            }

            public y s(float f4) {
                this.f11054v = f4;
                return this;
            }

            public y() {
                this.y = -9223372036854775807L;
                this.f11053n3 = -9223372036854775807L;
                this.f11055zn = -9223372036854775807L;
                this.f11052gv = -3.4028235E38f;
                this.f11054v = -3.4028235E38f;
            }

            public y(fb fbVar) {
                this.y = fbVar.y;
                this.f11053n3 = fbVar.f11051v;
                this.f11055zn = fbVar.f11049fb;
                this.f11052gv = fbVar.f11050s;
                this.f11054v = fbVar.f11048f;
            }
        }

        public static /* synthetic */ fb zn(Bundle bundle) {
            String str = f11046w;
            fb fbVar = f11045t;
            return new fb(bundle.getLong(str, fbVar.y), bundle.getLong(f11043p, fbVar.f11051v), bundle.getLong(f11041co, fbVar.f11049fb), bundle.getFloat(f11047z, fbVar.f11050s), bundle.getFloat(f11044r, fbVar.f11048f));
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof fb)) {
                return false;
            }
            fb fbVar = (fb) obj;
            if (this.y == fbVar.y && this.f11051v == fbVar.f11051v && this.f11049fb == fbVar.f11049fb && this.f11050s == fbVar.f11050s && this.f11048f == fbVar.f11048f) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            long j2 = this.y;
            long j4 = this.f11051v;
            long j6 = this.f11049fb;
            int i5 = ((((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31;
            float f4 = this.f11050s;
            int i6 = 0;
            if (f4 != 0.0f) {
                i = Float.floatToIntBits(f4);
            } else {
                i = 0;
            }
            int i8 = (i5 + i) * 31;
            float f6 = this.f11048f;
            if (f6 != 0.0f) {
                i6 = Float.floatToIntBits(f6);
            }
            return i8 + i6;
        }

        public y n3() {
            return new y();
        }

        @Override // m1.s
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            long j2 = this.y;
            fb fbVar = f11045t;
            if (j2 != fbVar.y) {
                bundle.putLong(f11046w, j2);
            }
            long j4 = this.f11051v;
            if (j4 != fbVar.f11051v) {
                bundle.putLong(f11043p, j4);
            }
            long j6 = this.f11049fb;
            if (j6 != fbVar.f11049fb) {
                bundle.putLong(f11041co, j6);
            }
            float f4 = this.f11050s;
            if (f4 != fbVar.f11050s) {
                bundle.putFloat(f11047z, f4);
            }
            float f6 = this.f11048f;
            if (f6 != fbVar.f11048f) {
                bundle.putFloat(f11044r, f6);
            }
            return bundle;
        }

        public fb(y yVar) {
            this(yVar.y, yVar.f11053n3, yVar.f11055zn, yVar.f11052gv, yVar.f11054v);
        }

        @Deprecated
        public fb(long j2, long j4, long j6, float f4, float f6) {
            this.y = j2;
            this.f11051v = j4;
            this.f11049fb = j6;
            this.f11050s = f4;
            this.f11048f = f6;
        }
    }

    /* loaded from: classes.dex */
    public static class gv implements m1.s {

        /* renamed from: f  reason: collision with root package name */
        public final boolean f11063f;

        /* renamed from: fb  reason: collision with root package name */
        public final boolean f11064fb;

        /* renamed from: s  reason: collision with root package name */
        public final boolean f11065s;

        /* renamed from: v  reason: collision with root package name */
        public final long f11066v;
        public final long y;

        /* renamed from: t  reason: collision with root package name */
        public static final gv f11060t = new y().a();

        /* renamed from: w  reason: collision with root package name */
        public static final String f11061w = v5.j5.g3(0);

        /* renamed from: p  reason: collision with root package name */
        public static final String f11058p = v5.j5.g3(1);

        /* renamed from: co  reason: collision with root package name */
        public static final String f11056co = v5.j5.g3(2);

        /* renamed from: z  reason: collision with root package name */
        public static final String f11062z = v5.j5.g3(3);

        /* renamed from: r  reason: collision with root package name */
        public static final String f11059r = v5.j5.g3(4);

        /* renamed from: f3  reason: collision with root package name */
        public static final s.y<v> f11057f3 = new s.y() { // from class: m1.xb
            @Override // m1.s.y
            public final s fromBundle(Bundle bundle) {
                o0.v zn2;
                zn2 = o0.gv.zn(bundle);
                return zn2;
            }
        };

        /* loaded from: classes.dex */
        public static final class y {

            /* renamed from: gv  reason: collision with root package name */
            public boolean f11067gv;

            /* renamed from: n3  reason: collision with root package name */
            public long f11068n3;

            /* renamed from: v  reason: collision with root package name */
            public boolean f11069v;
            public long y;

            /* renamed from: zn  reason: collision with root package name */
            public boolean f11070zn;

            public gv a() {
                return fb();
            }

            public y c5(boolean z2) {
                this.f11067gv = z2;
                return this;
            }

            public y f(long j2) {
                boolean z2;
                if (j2 >= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                v5.y.y(z2);
                this.y = j2;
                return this;
            }

            @Deprecated
            public v fb() {
                return new v(this);
            }

            public y i9(boolean z2) {
                this.f11070zn = z2;
                return this;
            }

            public y s(long j2) {
                boolean z2;
                if (j2 != Long.MIN_VALUE && j2 < 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                v5.y.y(z2);
                this.f11068n3 = j2;
                return this;
            }

            public y t(boolean z2) {
                this.f11069v = z2;
                return this;
            }

            public y() {
                this.f11068n3 = Long.MIN_VALUE;
            }

            public y(gv gvVar) {
                this.y = gvVar.y;
                this.f11068n3 = gvVar.f11066v;
                this.f11070zn = gvVar.f11064fb;
                this.f11067gv = gvVar.f11065s;
                this.f11069v = gvVar.f11063f;
            }
        }

        public static /* synthetic */ v zn(Bundle bundle) {
            y yVar = new y();
            String str = f11061w;
            gv gvVar = f11060t;
            return yVar.f(bundle.getLong(str, gvVar.y)).s(bundle.getLong(f11058p, gvVar.f11066v)).i9(bundle.getBoolean(f11056co, gvVar.f11064fb)).c5(bundle.getBoolean(f11062z, gvVar.f11065s)).t(bundle.getBoolean(f11059r, gvVar.f11063f)).fb();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof gv)) {
                return false;
            }
            gv gvVar = (gv) obj;
            if (this.y == gvVar.y && this.f11066v == gvVar.f11066v && this.f11064fb == gvVar.f11064fb && this.f11065s == gvVar.f11065s && this.f11063f == gvVar.f11063f) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j2 = this.y;
            long j4 = this.f11066v;
            return (((((((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.f11064fb ? 1 : 0)) * 31) + (this.f11065s ? 1 : 0)) * 31) + (this.f11063f ? 1 : 0);
        }

        public y n3() {
            return new y();
        }

        @Override // m1.s
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            long j2 = this.y;
            gv gvVar = f11060t;
            if (j2 != gvVar.y) {
                bundle.putLong(f11061w, j2);
            }
            long j4 = this.f11066v;
            if (j4 != gvVar.f11066v) {
                bundle.putLong(f11058p, j4);
            }
            boolean z2 = this.f11064fb;
            if (z2 != gvVar.f11064fb) {
                bundle.putBoolean(f11056co, z2);
            }
            boolean z3 = this.f11065s;
            if (z3 != gvVar.f11065s) {
                bundle.putBoolean(f11062z, z3);
            }
            boolean z4 = this.f11063f;
            if (z4 != gvVar.f11063f) {
                bundle.putBoolean(f11059r, z4);
            }
            return bundle;
        }

        public gv(y yVar) {
            this.y = yVar.y;
            this.f11066v = yVar.f11068n3;
            this.f11064fb = yVar.f11070zn;
            this.f11065s = yVar.f11067gv;
            this.f11063f = yVar.f11069v;
        }
    }

    /* loaded from: classes.dex */
    public static final class i9 implements m1.s {
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public final Bundle f11076fb;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public final String f11077v;
        @Nullable
        public final Uri y;

        /* renamed from: s  reason: collision with root package name */
        public static final i9 f11073s = new y().gv();

        /* renamed from: f  reason: collision with root package name */
        public static final String f11071f = v5.j5.g3(0);

        /* renamed from: t  reason: collision with root package name */
        public static final String f11074t = v5.j5.g3(1);

        /* renamed from: w  reason: collision with root package name */
        public static final String f11075w = v5.j5.g3(2);

        /* renamed from: p  reason: collision with root package name */
        public static final s.y<i9> f11072p = new s.y() { // from class: m1.ad
            @Override // m1.s.y
            public final s fromBundle(Bundle bundle) {
                o0.i9 n32;
                n32 = o0.i9.n3(bundle);
                return n32;
            }
        };

        /* loaded from: classes.dex */
        public static final class y {
            @Nullable

            /* renamed from: n3  reason: collision with root package name */
            public String f11078n3;
            @Nullable
            public Uri y;
            @Nullable

            /* renamed from: zn  reason: collision with root package name */
            public Bundle f11079zn;

            public y a(@Nullable Uri uri) {
                this.y = uri;
                return this;
            }

            public y fb(@Nullable String str) {
                this.f11078n3 = str;
                return this;
            }

            public i9 gv() {
                return new i9(this);
            }

            public y v(@Nullable Bundle bundle) {
                this.f11079zn = bundle;
                return this;
            }
        }

        public static /* synthetic */ i9 n3(Bundle bundle) {
            return new y().a((Uri) bundle.getParcelable(f11071f)).fb(bundle.getString(f11074t)).v(bundle.getBundle(f11075w)).gv();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i9)) {
                return false;
            }
            i9 i9Var = (i9) obj;
            if (v5.j5.zn(this.y, i9Var.y) && v5.j5.zn(this.f11077v, i9Var.f11077v)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            Uri uri = this.y;
            int i = 0;
            if (uri == null) {
                hashCode = 0;
            } else {
                hashCode = uri.hashCode();
            }
            int i5 = hashCode * 31;
            String str = this.f11077v;
            if (str != null) {
                i = str.hashCode();
            }
            return i5 + i;
        }

        @Override // m1.s
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            Uri uri = this.y;
            if (uri != null) {
                bundle.putParcelable(f11071f, uri);
            }
            String str = this.f11077v;
            if (str != null) {
                bundle.putString(f11074t, str);
            }
            Bundle bundle2 = this.f11076fb;
            if (bundle2 != null) {
                bundle.putBundle(f11075w, bundle2);
            }
            return bundle;
        }

        public i9(y yVar) {
            this.y = yVar.y;
            this.f11077v = yVar.f11078n3;
            this.f11076fb = yVar.f11079zn;
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {
    }

    /* loaded from: classes.dex */
    public static class s {

        /* renamed from: a  reason: collision with root package name */
        public final z0.x4<t> f11080a;
        @Deprecated

        /* renamed from: fb  reason: collision with root package name */
        public final List<f> f11081fb;

        /* renamed from: gv  reason: collision with root package name */
        public final List<StreamKey> f11082gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final String f11083n3;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public final Object f11084s;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public final String f11085v;
        public final Uri y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public final a f11086zn;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof s)) {
                return false;
            }
            s sVar = (s) obj;
            if (this.y.equals(sVar.y) && v5.j5.zn(this.f11083n3, sVar.f11083n3) && v5.j5.zn(this.f11086zn, sVar.f11086zn) && v5.j5.zn(null, null) && this.f11082gv.equals(sVar.f11082gv) && v5.j5.zn(this.f11085v, sVar.f11085v) && this.f11080a.equals(sVar.f11080a) && v5.j5.zn(this.f11084s, sVar.f11084s)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4 = this.y.hashCode() * 31;
            String str = this.f11083n3;
            int i = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i5 = (hashCode4 + hashCode) * 31;
            a aVar = this.f11086zn;
            if (aVar == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = aVar.hashCode();
            }
            int hashCode5 = (((i5 + hashCode2) * 961) + this.f11082gv.hashCode()) * 31;
            String str2 = this.f11085v;
            if (str2 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str2.hashCode();
            }
            int hashCode6 = (((hashCode5 + hashCode3) * 31) + this.f11080a.hashCode()) * 31;
            Object obj = this.f11084s;
            if (obj != null) {
                i = obj.hashCode();
            }
            return hashCode6 + i;
        }

        public s(Uri uri, @Nullable String str, @Nullable a aVar, @Nullable n3 n3Var, List<StreamKey> list, @Nullable String str2, z0.x4<t> x4Var, @Nullable Object obj) {
            this.y = uri;
            this.f11083n3 = str;
            this.f11086zn = aVar;
            this.f11082gv = list;
            this.f11085v = str2;
            this.f11080a = x4Var;
            x4.y x42 = z0.x4.x4();
            for (int i = 0; i < x4Var.size(); i++) {
                x42.y(x4Var.get(i).y().i9());
            }
            this.f11081fb = x42.s();
            this.f11084s = obj;
        }
    }

    /* loaded from: classes.dex */
    public static class t {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final String f11087a;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public final String f11088fb;

        /* renamed from: gv  reason: collision with root package name */
        public final int f11089gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final String f11090n3;

        /* renamed from: v  reason: collision with root package name */
        public final int f11091v;
        public final Uri y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public final String f11092zn;

        /* loaded from: classes.dex */
        public static final class y {
            @Nullable

            /* renamed from: a  reason: collision with root package name */
            public String f11093a;
            @Nullable

            /* renamed from: fb  reason: collision with root package name */
            public String f11094fb;

            /* renamed from: gv  reason: collision with root package name */
            public int f11095gv;
            @Nullable

            /* renamed from: n3  reason: collision with root package name */
            public String f11096n3;

            /* renamed from: v  reason: collision with root package name */
            public int f11097v;
            public Uri y;
            @Nullable

            /* renamed from: zn  reason: collision with root package name */
            public String f11098zn;

            public t c5() {
                return new t(this);
            }

            public y f(@Nullable String str) {
                this.f11093a = str;
                return this;
            }

            public final f i9() {
                return new f(this);
            }

            public y t(@Nullable String str) {
                this.f11098zn = str;
                return this;
            }

            public y tl(@Nullable String str) {
                this.f11096n3 = str;
                return this;
            }

            public y wz(int i) {
                this.f11097v = i;
                return this;
            }

            public y xc(int i) {
                this.f11095gv = i;
                return this;
            }

            public y(Uri uri) {
                this.y = uri;
            }

            public y(t tVar) {
                this.y = tVar.y;
                this.f11096n3 = tVar.f11090n3;
                this.f11098zn = tVar.f11092zn;
                this.f11095gv = tVar.f11089gv;
                this.f11097v = tVar.f11091v;
                this.f11093a = tVar.f11087a;
                this.f11094fb = tVar.f11088fb;
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof t)) {
                return false;
            }
            t tVar = (t) obj;
            if (this.y.equals(tVar.y) && v5.j5.zn(this.f11090n3, tVar.f11090n3) && v5.j5.zn(this.f11092zn, tVar.f11092zn) && this.f11089gv == tVar.f11089gv && this.f11091v == tVar.f11091v && v5.j5.zn(this.f11087a, tVar.f11087a) && v5.j5.zn(this.f11088fb, tVar.f11088fb)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4 = this.y.hashCode() * 31;
            String str = this.f11090n3;
            int i = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i5 = (hashCode4 + hashCode) * 31;
            String str2 = this.f11092zn;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i6 = (((((i5 + hashCode2) * 31) + this.f11089gv) * 31) + this.f11091v) * 31;
            String str3 = this.f11087a;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i8 = (i6 + hashCode3) * 31;
            String str4 = this.f11088fb;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return i8 + i;
        }

        public y y() {
            return new y();
        }

        public t(y yVar) {
            this.y = yVar.y;
            this.f11090n3 = yVar.f11096n3;
            this.f11092zn = yVar.f11098zn;
            this.f11089gv = yVar.f11095gv;
            this.f11091v = yVar.f11097v;
            this.f11087a = yVar.f11093a;
            this.f11088fb = yVar.f11094fb;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static final class v extends gv {

        /* renamed from: n  reason: collision with root package name */
        public static final v f11099n = new gv.y().fb();

        public v(gv.y yVar) {
            super(yVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: a  reason: collision with root package name */
        public List<StreamKey> f11100a;
        @Nullable

        /* renamed from: c5  reason: collision with root package name */
        public Object f11101c5;

        /* renamed from: f  reason: collision with root package name */
        public fb.y f11102f;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public String f11103fb;

        /* renamed from: gv  reason: collision with root package name */
        public gv.y f11104gv;
        @Nullable

        /* renamed from: i9  reason: collision with root package name */
        public qk f11105i9;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public Uri f11106n3;

        /* renamed from: s  reason: collision with root package name */
        public z0.x4<t> f11107s;

        /* renamed from: t  reason: collision with root package name */
        public i9 f11108t;

        /* renamed from: v  reason: collision with root package name */
        public a.y f11109v;
        @Nullable
        public String y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public String f11110zn;

        public zn a(List<t> list) {
            this.f11107s = z0.x4.d(list);
            return this;
        }

        public zn c5(@Nullable String str) {
            Uri parse;
            if (str == null) {
                parse = null;
            } else {
                parse = Uri.parse(str);
            }
            return s(parse);
        }

        public zn fb(@Nullable Object obj) {
            this.f11101c5 = obj;
            return this;
        }

        public zn gv(String str) {
            this.y = (String) v5.y.v(str);
            return this;
        }

        public zn n3(@Nullable String str) {
            this.f11103fb = str;
            return this;
        }

        public zn s(@Nullable Uri uri) {
            this.f11106n3 = uri;
            return this;
        }

        public zn v(@Nullable String str) {
            this.f11110zn = str;
            return this;
        }

        public o0 y() {
            boolean z2;
            c5 c5Var;
            if (this.f11109v.f11037n3 != null && this.f11109v.y == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            v5.y.fb(z2);
            Uri uri = this.f11106n3;
            a aVar = null;
            if (uri != null) {
                String str = this.f11110zn;
                if (this.f11109v.y != null) {
                    aVar = this.f11109v.c5();
                }
                c5Var = new c5(uri, str, aVar, null, this.f11100a, this.f11103fb, this.f11107s, this.f11101c5);
            } else {
                c5Var = null;
            }
            String str2 = this.y;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            v fb2 = this.f11104gv.fb();
            fb a2 = this.f11102f.a();
            qk qkVar = this.f11105i9;
            if (qkVar == null) {
                qkVar = qk.f11140dm;
            }
            return new o0(str3, fb2, c5Var, a2, qkVar, this.f11108t);
        }

        public zn zn(fb fbVar) {
            this.f11102f = fbVar.n3();
            return this;
        }

        public zn() {
            this.f11104gv = new gv.y();
            this.f11109v = new a.y();
            this.f11100a = Collections.emptyList();
            this.f11107s = z0.x4.j5();
            this.f11102f = new fb.y();
            this.f11108t = i9.f11073s;
        }

        public zn(o0 o0Var) {
            this();
            a.y yVar;
            this.f11104gv = o0Var.f11021t.n3();
            this.y = o0Var.y;
            this.f11105i9 = o0Var.f11017f;
            this.f11102f = o0Var.f11020s.n3();
            this.f11108t = o0Var.f11019p;
            s sVar = o0Var.f11022v;
            if (sVar != null) {
                this.f11103fb = sVar.f11085v;
                this.f11110zn = sVar.f11083n3;
                this.f11106n3 = sVar.y;
                this.f11100a = sVar.f11082gv;
                this.f11107s = sVar.f11080a;
                this.f11101c5 = sVar.f11084s;
                a aVar = sVar.f11086zn;
                if (aVar != null) {
                    yVar = aVar.n3();
                } else {
                    yVar = new a.y();
                }
                this.f11109v = yVar;
            }
        }
    }

    public static o0 gv(String str) {
        return new zn().c5(str).y();
    }

    public static o0 zn(Bundle bundle) {
        fb fromBundle;
        qk fromBundle2;
        v fromBundle3;
        i9 fromBundle4;
        String str = (String) v5.y.v(bundle.getString(f11016z, ""));
        Bundle bundle2 = bundle.getBundle(f11015r);
        if (bundle2 == null) {
            fromBundle = fb.f11045t;
        } else {
            fromBundle = fb.f11042f3.fromBundle(bundle2);
        }
        fb fbVar = fromBundle;
        Bundle bundle3 = bundle.getBundle(f11013f3);
        if (bundle3 == null) {
            fromBundle2 = qk.f11140dm;
        } else {
            fromBundle2 = qk.f11163vp.fromBundle(bundle3);
        }
        qk qkVar = fromBundle2;
        Bundle bundle4 = bundle.getBundle(f11014n);
        if (bundle4 == null) {
            fromBundle3 = v.f11099n;
        } else {
            fromBundle3 = gv.f11057f3.fromBundle(bundle4);
        }
        v vVar = fromBundle3;
        Bundle bundle5 = bundle.getBundle(f11010c);
        if (bundle5 == null) {
            fromBundle4 = i9.f11073s;
        } else {
            fromBundle4 = i9.f11072p.fromBundle(bundle5);
        }
        return new o0(str, vVar, null, fbVar, qkVar, fromBundle4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        if (v5.j5.zn(this.y, o0Var.y) && this.f11021t.equals(o0Var.f11021t) && v5.j5.zn(this.f11022v, o0Var.f11022v) && v5.j5.zn(this.f11020s, o0Var.f11020s) && v5.j5.zn(this.f11017f, o0Var.f11017f) && v5.j5.zn(this.f11019p, o0Var.f11019p)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int hashCode = this.y.hashCode() * 31;
        s sVar = this.f11022v;
        if (sVar != null) {
            i = sVar.hashCode();
        } else {
            i = 0;
        }
        return ((((((((hashCode + i) * 31) + this.f11020s.hashCode()) * 31) + this.f11021t.hashCode()) * 31) + this.f11017f.hashCode()) * 31) + this.f11019p.hashCode();
    }

    public zn n3() {
        return new zn();
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (!this.y.equals("")) {
            bundle.putString(f11016z, this.y);
        }
        if (!this.f11020s.equals(fb.f11045t)) {
            bundle.putBundle(f11015r, this.f11020s.toBundle());
        }
        if (!this.f11017f.equals(qk.f11140dm)) {
            bundle.putBundle(f11013f3, this.f11017f.toBundle());
        }
        if (!this.f11021t.equals(gv.f11060t)) {
            bundle.putBundle(f11014n, this.f11021t.toBundle());
        }
        if (!this.f11019p.equals(i9.f11073s)) {
            bundle.putBundle(f11010c, this.f11019p.toBundle());
        }
        return bundle;
    }

    public o0(String str, v vVar, @Nullable c5 c5Var, fb fbVar, qk qkVar, i9 i9Var) {
        this.y = str;
        this.f11022v = c5Var;
        this.f11018fb = c5Var;
        this.f11020s = fbVar;
        this.f11017f = qkVar;
        this.f11021t = vVar;
        this.f11023w = vVar;
        this.f11019p = i9Var;
    }
}
