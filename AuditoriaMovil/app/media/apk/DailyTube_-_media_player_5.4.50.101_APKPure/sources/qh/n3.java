package qh;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import m1.s;
import v5.j5;
/* loaded from: classes.dex */
public final class n3 implements m1.s {

    /* renamed from: c  reason: collision with root package name */
    public final int f12863c;

    /* renamed from: co  reason: collision with root package name */
    public final int f12864co;

    /* renamed from: d  reason: collision with root package name */
    public final float f12865d;

    /* renamed from: d0  reason: collision with root package name */
    public final float f12866d0;

    /* renamed from: f  reason: collision with root package name */
    public final float f12867f;

    /* renamed from: f3  reason: collision with root package name */
    public final boolean f12868f3;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final Layout.Alignment f12869fb;

    /* renamed from: fh  reason: collision with root package name */
    public final int f12870fh;

    /* renamed from: n  reason: collision with root package name */
    public final int f12871n;

    /* renamed from: p  reason: collision with root package name */
    public final float f12872p;

    /* renamed from: r  reason: collision with root package name */
    public final float f12873r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public final Bitmap f12874s;

    /* renamed from: t  reason: collision with root package name */
    public final int f12875t;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final Layout.Alignment f12876v;

    /* renamed from: w  reason: collision with root package name */
    public final int f12877w;
    @Nullable
    public final CharSequence y;

    /* renamed from: z  reason: collision with root package name */
    public final float f12878z;

    /* renamed from: ej  reason: collision with root package name */
    public static final n3 f12847ej = new C0187n3().xc("").y();

    /* renamed from: x  reason: collision with root package name */
    public static final String f12860x = j5.g3(0);

    /* renamed from: b  reason: collision with root package name */
    public static final String f12844b = j5.g3(1);

    /* renamed from: j5  reason: collision with root package name */
    public static final String f12851j5 = j5.g3(2);

    /* renamed from: qn  reason: collision with root package name */
    public static final String f12857qn = j5.g3(3);

    /* renamed from: o  reason: collision with root package name */
    public static final String f12854o = j5.g3(4);

    /* renamed from: j  reason: collision with root package name */
    public static final String f12850j = j5.g3(5);

    /* renamed from: oz  reason: collision with root package name */
    public static final String f12855oz = j5.g3(6);

    /* renamed from: ut  reason: collision with root package name */
    public static final String f12859ut = j5.g3(7);

    /* renamed from: q9  reason: collision with root package name */
    public static final String f12856q9 = j5.g3(8);

    /* renamed from: k  reason: collision with root package name */
    public static final String f12853k = j5.g3(9);

    /* renamed from: f7  reason: collision with root package name */
    public static final String f12849f7 = j5.g3(10);

    /* renamed from: en  reason: collision with root package name */
    public static final String f12848en = j5.g3(11);

    /* renamed from: jz  reason: collision with root package name */
    public static final String f12852jz = j5.g3(12);

    /* renamed from: u  reason: collision with root package name */
    public static final String f12858u = j5.g3(13);

    /* renamed from: y5  reason: collision with root package name */
    public static final String f12862y5 = j5.g3(14);

    /* renamed from: xg  reason: collision with root package name */
    public static final String f12861xg = j5.g3(15);

    /* renamed from: dm  reason: collision with root package name */
    public static final String f12846dm = j5.g3(16);

    /* renamed from: ct  reason: collision with root package name */
    public static final s.y<n3> f12845ct = new s.y() { // from class: qh.y
        @Override // m1.s.y
        public final m1.s fromBundle(Bundle bundle) {
            n3 zn2;
            zn2 = n3.zn(bundle);
            return zn2;
        }
    };

    /* renamed from: qh.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0187n3 {

        /* renamed from: a  reason: collision with root package name */
        public int f12879a;

        /* renamed from: c5  reason: collision with root package name */
        public int f12880c5;

        /* renamed from: f  reason: collision with root package name */
        public float f12881f;

        /* renamed from: fb  reason: collision with root package name */
        public int f12882fb;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public Layout.Alignment f12883gv;

        /* renamed from: i9  reason: collision with root package name */
        public int f12884i9;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public Bitmap f12885n3;

        /* renamed from: p  reason: collision with root package name */
        public float f12886p;

        /* renamed from: s  reason: collision with root package name */
        public float f12887s;

        /* renamed from: t  reason: collision with root package name */
        public float f12888t;

        /* renamed from: tl  reason: collision with root package name */
        public float f12889tl;

        /* renamed from: v  reason: collision with root package name */
        public float f12890v;

        /* renamed from: w  reason: collision with root package name */
        public int f12891w;

        /* renamed from: wz  reason: collision with root package name */
        public boolean f12892wz;

        /* renamed from: xc  reason: collision with root package name */
        public int f12893xc;
        @Nullable
        public CharSequence y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public Layout.Alignment f12894zn;

        public C0187n3 a(Bitmap bitmap) {
            this.f12885n3 = bitmap;
            return this;
        }

        public C0187n3 c5(int i) {
            this.f12882fb = i;
            return this;
        }

        public C0187n3 co(int i) {
            this.f12893xc = i;
            this.f12892wz = true;
            return this;
        }

        public C0187n3 f(float f4) {
            this.f12887s = f4;
            return this;
        }

        public C0187n3 fb(float f4) {
            this.f12889tl = f4;
            return this;
        }

        public int gv() {
            return this.f12880c5;
        }

        public C0187n3 i9(@Nullable Layout.Alignment alignment) {
            this.f12883gv = alignment;
            return this;
        }

        public C0187n3 mt(int i) {
            this.f12891w = i;
            return this;
        }

        public C0187n3 n3() {
            this.f12892wz = false;
            return this;
        }

        public C0187n3 p(float f4, int i) {
            this.f12881f = f4;
            this.f12884i9 = i;
            return this;
        }

        public C0187n3 s(float f4, int i) {
            this.f12890v = f4;
            this.f12879a = i;
            return this;
        }

        public C0187n3 t(int i) {
            this.f12880c5 = i;
            return this;
        }

        public C0187n3 tl(float f4) {
            this.f12886p = f4;
            return this;
        }

        @Nullable
        public CharSequence v() {
            return this.y;
        }

        public C0187n3 w(@Nullable Layout.Alignment alignment) {
            this.f12894zn = alignment;
            return this;
        }

        public C0187n3 wz(float f4) {
            this.f12888t = f4;
            return this;
        }

        public C0187n3 xc(CharSequence charSequence) {
            this.y = charSequence;
            return this;
        }

        public n3 y() {
            return new n3(this.y, this.f12894zn, this.f12883gv, this.f12885n3, this.f12890v, this.f12879a, this.f12882fb, this.f12887s, this.f12880c5, this.f12884i9, this.f12881f, this.f12888t, this.f12889tl, this.f12892wz, this.f12893xc, this.f12891w, this.f12886p);
        }

        public int zn() {
            return this.f12882fb;
        }

        public C0187n3() {
            this.f12890v = -3.4028235E38f;
            this.f12879a = Integer.MIN_VALUE;
            this.f12882fb = Integer.MIN_VALUE;
            this.f12887s = -3.4028235E38f;
            this.f12880c5 = Integer.MIN_VALUE;
            this.f12884i9 = Integer.MIN_VALUE;
            this.f12881f = -3.4028235E38f;
            this.f12888t = -3.4028235E38f;
            this.f12889tl = -3.4028235E38f;
            this.f12893xc = -16777216;
            this.f12891w = Integer.MIN_VALUE;
        }

        public C0187n3(n3 n3Var) {
            this.y = n3Var.y;
            this.f12885n3 = n3Var.f12874s;
            this.f12894zn = n3Var.f12876v;
            this.f12883gv = n3Var.f12869fb;
            this.f12890v = n3Var.f12867f;
            this.f12879a = n3Var.f12875t;
            this.f12882fb = n3Var.f12877w;
            this.f12887s = n3Var.f12872p;
            this.f12880c5 = n3Var.f12864co;
            this.f12884i9 = n3Var.f12863c;
            this.f12881f = n3Var.f12866d0;
            this.f12888t = n3Var.f12878z;
            this.f12889tl = n3Var.f12873r;
            this.f12892wz = n3Var.f12868f3;
            this.f12893xc = n3Var.f12871n;
            this.f12891w = n3Var.f12870fh;
            this.f12886p = n3Var.f12865d;
        }
    }

    public static final n3 zn(Bundle bundle) {
        C0187n3 c0187n3 = new C0187n3();
        CharSequence charSequence = bundle.getCharSequence(f12860x);
        if (charSequence != null) {
            c0187n3.xc(charSequence);
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(f12844b);
        if (alignment != null) {
            c0187n3.w(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(f12851j5);
        if (alignment2 != null) {
            c0187n3.i9(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(f12857qn);
        if (bitmap != null) {
            c0187n3.a(bitmap);
        }
        String str = f12854o;
        if (bundle.containsKey(str)) {
            String str2 = f12850j;
            if (bundle.containsKey(str2)) {
                c0187n3.s(bundle.getFloat(str), bundle.getInt(str2));
            }
        }
        String str3 = f12855oz;
        if (bundle.containsKey(str3)) {
            c0187n3.c5(bundle.getInt(str3));
        }
        String str4 = f12859ut;
        if (bundle.containsKey(str4)) {
            c0187n3.f(bundle.getFloat(str4));
        }
        String str5 = f12856q9;
        if (bundle.containsKey(str5)) {
            c0187n3.t(bundle.getInt(str5));
        }
        String str6 = f12849f7;
        if (bundle.containsKey(str6)) {
            String str7 = f12853k;
            if (bundle.containsKey(str7)) {
                c0187n3.p(bundle.getFloat(str6), bundle.getInt(str7));
            }
        }
        String str8 = f12848en;
        if (bundle.containsKey(str8)) {
            c0187n3.wz(bundle.getFloat(str8));
        }
        String str9 = f12852jz;
        if (bundle.containsKey(str9)) {
            c0187n3.fb(bundle.getFloat(str9));
        }
        String str10 = f12858u;
        if (bundle.containsKey(str10)) {
            c0187n3.co(bundle.getInt(str10));
        }
        if (!bundle.getBoolean(f12862y5, false)) {
            c0187n3.n3();
        }
        String str11 = f12861xg;
        if (bundle.containsKey(str11)) {
            c0187n3.mt(bundle.getInt(str11));
        }
        String str12 = f12846dm;
        if (bundle.containsKey(str12)) {
            c0187n3.tl(bundle.getFloat(str12));
        }
        return c0187n3.y();
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || n3.class != obj.getClass()) {
            return false;
        }
        n3 n3Var = (n3) obj;
        if (TextUtils.equals(this.y, n3Var.y) && this.f12876v == n3Var.f12876v && this.f12869fb == n3Var.f12869fb && ((bitmap = this.f12874s) != null ? !((bitmap2 = n3Var.f12874s) == null || !bitmap.sameAs(bitmap2)) : n3Var.f12874s == null) && this.f12867f == n3Var.f12867f && this.f12875t == n3Var.f12875t && this.f12877w == n3Var.f12877w && this.f12872p == n3Var.f12872p && this.f12864co == n3Var.f12864co && this.f12878z == n3Var.f12878z && this.f12873r == n3Var.f12873r && this.f12868f3 == n3Var.f12868f3 && this.f12871n == n3Var.f12871n && this.f12863c == n3Var.f12863c && this.f12866d0 == n3Var.f12866d0 && this.f12870fh == n3Var.f12870fh && this.f12865d == n3Var.f12865d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return w0.f.n3(this.y, this.f12876v, this.f12869fb, this.f12874s, Float.valueOf(this.f12867f), Integer.valueOf(this.f12875t), Integer.valueOf(this.f12877w), Float.valueOf(this.f12872p), Integer.valueOf(this.f12864co), Float.valueOf(this.f12878z), Float.valueOf(this.f12873r), Boolean.valueOf(this.f12868f3), Integer.valueOf(this.f12871n), Integer.valueOf(this.f12863c), Float.valueOf(this.f12866d0), Integer.valueOf(this.f12870fh), Float.valueOf(this.f12865d));
    }

    public C0187n3 n3() {
        return new C0187n3();
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(f12860x, this.y);
        bundle.putSerializable(f12844b, this.f12876v);
        bundle.putSerializable(f12851j5, this.f12869fb);
        bundle.putParcelable(f12857qn, this.f12874s);
        bundle.putFloat(f12854o, this.f12867f);
        bundle.putInt(f12850j, this.f12875t);
        bundle.putInt(f12855oz, this.f12877w);
        bundle.putFloat(f12859ut, this.f12872p);
        bundle.putInt(f12856q9, this.f12864co);
        bundle.putInt(f12853k, this.f12863c);
        bundle.putFloat(f12849f7, this.f12866d0);
        bundle.putFloat(f12848en, this.f12878z);
        bundle.putFloat(f12852jz, this.f12873r);
        bundle.putBoolean(f12862y5, this.f12868f3);
        bundle.putInt(f12858u, this.f12871n);
        bundle.putInt(f12861xg, this.f12870fh);
        bundle.putFloat(f12846dm, this.f12865d);
        return bundle;
    }

    public n3(@Nullable CharSequence charSequence, @Nullable Layout.Alignment alignment, @Nullable Layout.Alignment alignment2, @Nullable Bitmap bitmap, float f4, int i, int i5, float f6, int i6, int i8, float f9, float f10, float f11, boolean z2, int i10, int i11, float f12) {
        if (charSequence == null) {
            v5.y.v(bitmap);
        } else {
            v5.y.y(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.y = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.y = charSequence.toString();
        } else {
            this.y = null;
        }
        this.f12876v = alignment;
        this.f12869fb = alignment2;
        this.f12874s = bitmap;
        this.f12867f = f4;
        this.f12875t = i;
        this.f12877w = i5;
        this.f12872p = f6;
        this.f12864co = i6;
        this.f12878z = f10;
        this.f12873r = f11;
        this.f12868f3 = z2;
        this.f12871n = i10;
        this.f12863c = i8;
        this.f12866d0 = f9;
        this.f12870fh = i11;
        this.f12865d = f12;
    }
}
