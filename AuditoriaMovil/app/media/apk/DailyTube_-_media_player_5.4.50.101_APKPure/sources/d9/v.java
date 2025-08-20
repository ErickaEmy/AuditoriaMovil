package d9;

import android.media.AudioAttributes;
import android.os.Bundle;
import androidx.annotation.Nullable;
import m1.s;
import v5.j5;
/* loaded from: classes.dex */
public final class v implements m1.s {

    /* renamed from: f  reason: collision with root package name */
    public final int f7206f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f7207fb;

    /* renamed from: s  reason: collision with root package name */
    public final int f7208s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public gv f7209t;

    /* renamed from: v  reason: collision with root package name */
    public final int f7210v;
    public final int y;

    /* renamed from: w  reason: collision with root package name */
    public static final v f7204w = new C0081v().y();

    /* renamed from: p  reason: collision with root package name */
    public static final String f7202p = j5.g3(0);

    /* renamed from: co  reason: collision with root package name */
    public static final String f7199co = j5.g3(1);

    /* renamed from: z  reason: collision with root package name */
    public static final String f7205z = j5.g3(2);

    /* renamed from: r  reason: collision with root package name */
    public static final String f7203r = j5.g3(3);

    /* renamed from: f3  reason: collision with root package name */
    public static final String f7200f3 = j5.g3(4);

    /* renamed from: n  reason: collision with root package name */
    public static final s.y<v> f7201n = new s.y() { // from class: d9.gv
        @Override // m1.s.y
        public final m1.s fromBundle(Bundle bundle) {
            v zn2;
            zn2 = v.zn(bundle);
            return zn2;
        }
    };

    /* loaded from: classes.dex */
    public static final class gv {
        public final AudioAttributes y;

        public gv(v vVar) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(vVar.y).setFlags(vVar.f7210v).setUsage(vVar.f7207fb);
            int i = j5.y;
            if (i >= 29) {
                n3.y(usage, vVar.f7208s);
            }
            if (i >= 32) {
                zn.y(usage, vVar.f7206f);
            }
            this.y = usage.build();
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {
        public static void y(AudioAttributes.Builder builder, int i) {
            builder.setAllowedCapturePolicy(i);
        }
    }

    /* renamed from: d9.v$v  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0081v {

        /* renamed from: n3  reason: collision with root package name */
        public int f7212n3;

        /* renamed from: v  reason: collision with root package name */
        public int f7213v;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f7214zn = 1;

        /* renamed from: gv  reason: collision with root package name */
        public int f7211gv = 1;

        public C0081v a(int i) {
            this.f7214zn = i;
            return this;
        }

        public C0081v gv(int i) {
            this.f7212n3 = i;
            return this;
        }

        public C0081v n3(int i) {
            this.f7211gv = i;
            return this;
        }

        public C0081v v(int i) {
            this.f7213v = i;
            return this;
        }

        public v y() {
            return new v(this.y, this.f7212n3, this.f7214zn, this.f7211gv, this.f7213v);
        }

        public C0081v zn(int i) {
            this.y = i;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {
        public static void y(AudioAttributes.Builder builder, int i) {
            builder.setSpatializationBehavior(i);
        }
    }

    public static /* synthetic */ v zn(Bundle bundle) {
        C0081v c0081v = new C0081v();
        String str = f7202p;
        if (bundle.containsKey(str)) {
            c0081v.zn(bundle.getInt(str));
        }
        String str2 = f7199co;
        if (bundle.containsKey(str2)) {
            c0081v.gv(bundle.getInt(str2));
        }
        String str3 = f7205z;
        if (bundle.containsKey(str3)) {
            c0081v.a(bundle.getInt(str3));
        }
        String str4 = f7203r;
        if (bundle.containsKey(str4)) {
            c0081v.n3(bundle.getInt(str4));
        }
        String str5 = f7200f3;
        if (bundle.containsKey(str5)) {
            c0081v.v(bundle.getInt(str5));
        }
        return c0081v.y();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v.class != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        if (this.y == vVar.y && this.f7210v == vVar.f7210v && this.f7207fb == vVar.f7207fb && this.f7208s == vVar.f7208s && this.f7206f == vVar.f7206f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.y) * 31) + this.f7210v) * 31) + this.f7207fb) * 31) + this.f7208s) * 31) + this.f7206f;
    }

    public gv n3() {
        if (this.f7209t == null) {
            this.f7209t = new gv();
        }
        return this.f7209t;
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(f7202p, this.y);
        bundle.putInt(f7199co, this.f7210v);
        bundle.putInt(f7205z, this.f7207fb);
        bundle.putInt(f7203r, this.f7208s);
        bundle.putInt(f7200f3, this.f7206f);
        return bundle;
    }

    public v(int i, int i5, int i6, int i8, int i10) {
        this.y = i;
        this.f7210v = i5;
        this.f7207fb = i6;
        this.f7208s = i8;
        this.f7206f = i10;
    }
}
