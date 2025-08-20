package zo;

import af.rs;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import m1.s;
import v5.j5;
import z0.x4;
/* loaded from: classes.dex */
public class c implements m1.s {

    /* renamed from: ap  reason: collision with root package name */
    public static final String f15677ap;

    /* renamed from: bk  reason: collision with root package name */
    public static final String f15678bk;

    /* renamed from: ct  reason: collision with root package name */
    public static final String f15679ct;

    /* renamed from: dm  reason: collision with root package name */
    public static final String f15680dm;

    /* renamed from: e  reason: collision with root package name */
    public static final String f15681e;

    /* renamed from: eb  reason: collision with root package name */
    public static final String f15682eb;

    /* renamed from: en  reason: collision with root package name */
    public static final String f15683en;

    /* renamed from: f7  reason: collision with root package name */
    public static final String f15684f7;

    /* renamed from: g  reason: collision with root package name */
    public static final String f15685g;

    /* renamed from: g3  reason: collision with root package name */
    public static final String f15686g3;

    /* renamed from: jz  reason: collision with root package name */
    public static final String f15687jz;
    @Deprecated

    /* renamed from: k  reason: collision with root package name */
    public static final c f15688k;

    /* renamed from: kp  reason: collision with root package name */
    public static final String f15689kp;

    /* renamed from: lc  reason: collision with root package name */
    public static final String f15690lc;

    /* renamed from: m  reason: collision with root package name */
    public static final String f15691m;

    /* renamed from: nf  reason: collision with root package name */
    public static final String f15692nf;

    /* renamed from: o4  reason: collision with root package name */
    public static final String f15693o4;

    /* renamed from: q9  reason: collision with root package name */
    public static final c f15694q9;

    /* renamed from: ra  reason: collision with root package name */
    public static final String f15695ra;

    /* renamed from: rb  reason: collision with root package name */
    public static final String f15696rb;

    /* renamed from: rs  reason: collision with root package name */
    public static final String f15697rs;

    /* renamed from: s8  reason: collision with root package name */
    public static final String f15698s8;

    /* renamed from: u  reason: collision with root package name */
    public static final String f15699u;

    /* renamed from: u0  reason: collision with root package name */
    public static final String f15700u0;

    /* renamed from: xg  reason: collision with root package name */
    public static final String f15701xg;
    @Deprecated

    /* renamed from: y4  reason: collision with root package name */
    public static final s.y<c> f15702y4;

    /* renamed from: y5  reason: collision with root package name */
    public static final String f15703y5;

    /* renamed from: yc  reason: collision with root package name */
    public static final String f15704yc;

    /* renamed from: yg  reason: collision with root package name */
    public static final String f15705yg;

    /* renamed from: b  reason: collision with root package name */
    public final int f15706b;

    /* renamed from: c  reason: collision with root package name */
    public final z0.x4<String> f15707c;

    /* renamed from: co  reason: collision with root package name */
    public final int f15708co;

    /* renamed from: d  reason: collision with root package name */
    public final int f15709d;

    /* renamed from: d0  reason: collision with root package name */
    public final int f15710d0;

    /* renamed from: ej  reason: collision with root package name */
    public final z0.x4<String> f15711ej;

    /* renamed from: f  reason: collision with root package name */
    public final int f15712f;

    /* renamed from: f3  reason: collision with root package name */
    public final z0.x4<String> f15713f3;

    /* renamed from: fb  reason: collision with root package name */
    public final int f15714fb;

    /* renamed from: fh  reason: collision with root package name */
    public final int f15715fh;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f15716j;

    /* renamed from: j5  reason: collision with root package name */
    public final int f15717j5;

    /* renamed from: n  reason: collision with root package name */
    public final int f15718n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f15719o;

    /* renamed from: oz  reason: collision with root package name */
    public final z0.f3<rs, f3> f15720oz;

    /* renamed from: p  reason: collision with root package name */
    public final int f15721p;

    /* renamed from: qn  reason: collision with root package name */
    public final boolean f15722qn;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f15723r;

    /* renamed from: s  reason: collision with root package name */
    public final int f15724s;

    /* renamed from: t  reason: collision with root package name */
    public final int f15725t;

    /* renamed from: ut  reason: collision with root package name */
    public final z0.c<Integer> f15726ut;

    /* renamed from: v  reason: collision with root package name */
    public final int f15727v;

    /* renamed from: w  reason: collision with root package name */
    public final int f15728w;

    /* renamed from: x  reason: collision with root package name */
    public final z0.x4<String> f15729x;
    public final int y;

    /* renamed from: z  reason: collision with root package name */
    public final int f15730z;

    static {
        c d02 = new y().d0();
        f15694q9 = d02;
        f15688k = d02;
        f15684f7 = j5.g3(1);
        f15683en = j5.g3(2);
        f15687jz = j5.g3(3);
        f15699u = j5.g3(4);
        f15703y5 = j5.g3(5);
        f15701xg = j5.g3(6);
        f15680dm = j5.g3(7);
        f15679ct = j5.g3(8);
        f15693o4 = j5.g3(9);
        f15697rs = j5.g3(10);
        f15682eb = j5.g3(11);
        f15690lc = j5.g3(12);
        f15692nf = j5.g3(13);
        f15695ra = j5.g3(14);
        f15681e = j5.g3(15);
        f15698s8 = j5.g3(16);
        f15677ap = j5.g3(17);
        f15705yg = j5.g3(18);
        f15704yc = j5.g3(19);
        f15689kp = j5.g3(20);
        f15696rb = j5.g3(21);
        f15686g3 = j5.g3(22);
        f15691m = j5.g3(23);
        f15685g = j5.g3(24);
        f15700u0 = j5.g3(25);
        f15678bk = j5.g3(26);
        f15702y4 = new s.y() { // from class: zo.n
            @Override // m1.s.y
            public final m1.s fromBundle(Bundle bundle) {
                return c.fh(bundle);
            }
        };
    }

    public c(y yVar) {
        this.y = yVar.y;
        this.f15727v = yVar.f15743n3;
        this.f15714fb = yVar.f15755zn;
        this.f15724s = yVar.f15738gv;
        this.f15712f = yVar.f15749v;
        this.f15725t = yVar.f15731a;
        this.f15728w = yVar.f15737fb;
        this.f15721p = yVar.f15746s;
        this.f15708co = yVar.f15733c5;
        this.f15730z = yVar.f15740i9;
        this.f15723r = yVar.f15735f;
        this.f15713f3 = yVar.f15747t;
        this.f15718n = yVar.f15748tl;
        this.f15707c = yVar.f15751wz;
        this.f15710d0 = yVar.f15753xc;
        this.f15715fh = yVar.f15750w;
        this.f15709d = yVar.f15744p;
        this.f15711ej = yVar.f15741mt;
        this.f15729x = yVar.f15734co;
        this.f15706b = yVar.f15754z;
        this.f15717j5 = yVar.f15745r;
        this.f15722qn = yVar.f15752x4;
        this.f15719o = yVar.f15739i4;
        this.f15716j = yVar.f15736f3;
        this.f15720oz = z0.f3.s(yVar.f15742n);
        this.f15726ut = z0.c.x4(yVar.f15732c);
    }

    public static c fh(Bundle bundle) {
        return new y(bundle).d0();
    }

    public y d0() {
        return new y(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.y == cVar.y && this.f15727v == cVar.f15727v && this.f15714fb == cVar.f15714fb && this.f15724s == cVar.f15724s && this.f15712f == cVar.f15712f && this.f15725t == cVar.f15725t && this.f15728w == cVar.f15728w && this.f15721p == cVar.f15721p && this.f15723r == cVar.f15723r && this.f15708co == cVar.f15708co && this.f15730z == cVar.f15730z && this.f15713f3.equals(cVar.f15713f3) && this.f15718n == cVar.f15718n && this.f15707c.equals(cVar.f15707c) && this.f15710d0 == cVar.f15710d0 && this.f15715fh == cVar.f15715fh && this.f15709d == cVar.f15709d && this.f15711ej.equals(cVar.f15711ej) && this.f15729x.equals(cVar.f15729x) && this.f15706b == cVar.f15706b && this.f15717j5 == cVar.f15717j5 && this.f15722qn == cVar.f15722qn && this.f15719o == cVar.f15719o && this.f15716j == cVar.f15716j && this.f15720oz.equals(cVar.f15720oz) && this.f15726ut.equals(cVar.f15726ut)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.y + 31) * 31) + this.f15727v) * 31) + this.f15714fb) * 31) + this.f15724s) * 31) + this.f15712f) * 31) + this.f15725t) * 31) + this.f15728w) * 31) + this.f15721p) * 31) + (this.f15723r ? 1 : 0)) * 31) + this.f15708co) * 31) + this.f15730z) * 31) + this.f15713f3.hashCode()) * 31) + this.f15718n) * 31) + this.f15707c.hashCode()) * 31) + this.f15710d0) * 31) + this.f15715fh) * 31) + this.f15709d) * 31) + this.f15711ej.hashCode()) * 31) + this.f15729x.hashCode()) * 31) + this.f15706b) * 31) + this.f15717j5) * 31) + (this.f15722qn ? 1 : 0)) * 31) + (this.f15719o ? 1 : 0)) * 31) + (this.f15716j ? 1 : 0)) * 31) + this.f15720oz.hashCode()) * 31) + this.f15726ut.hashCode();
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(f15701xg, this.y);
        bundle.putInt(f15680dm, this.f15727v);
        bundle.putInt(f15679ct, this.f15714fb);
        bundle.putInt(f15693o4, this.f15724s);
        bundle.putInt(f15697rs, this.f15712f);
        bundle.putInt(f15682eb, this.f15725t);
        bundle.putInt(f15690lc, this.f15728w);
        bundle.putInt(f15692nf, this.f15721p);
        bundle.putInt(f15695ra, this.f15708co);
        bundle.putInt(f15681e, this.f15730z);
        bundle.putBoolean(f15698s8, this.f15723r);
        bundle.putStringArray(f15677ap, (String[]) this.f15713f3.toArray(new String[0]));
        bundle.putInt(f15700u0, this.f15718n);
        bundle.putStringArray(f15684f7, (String[]) this.f15707c.toArray(new String[0]));
        bundle.putInt(f15683en, this.f15710d0);
        bundle.putInt(f15705yg, this.f15715fh);
        bundle.putInt(f15704yc, this.f15709d);
        bundle.putStringArray(f15689kp, (String[]) this.f15711ej.toArray(new String[0]));
        bundle.putStringArray(f15687jz, (String[]) this.f15729x.toArray(new String[0]));
        bundle.putInt(f15699u, this.f15706b);
        bundle.putInt(f15678bk, this.f15717j5);
        bundle.putBoolean(f15703y5, this.f15722qn);
        bundle.putBoolean(f15696rb, this.f15719o);
        bundle.putBoolean(f15686g3, this.f15716j);
        bundle.putParcelableArrayList(f15691m, v5.gv.gv(this.f15720oz.values()));
        bundle.putIntArray(f15685g, d1.a.wz(this.f15726ut));
        return bundle;
    }

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: a  reason: collision with root package name */
        public int f15731a;

        /* renamed from: c  reason: collision with root package name */
        public HashSet<Integer> f15732c;

        /* renamed from: c5  reason: collision with root package name */
        public int f15733c5;

        /* renamed from: co  reason: collision with root package name */
        public z0.x4<String> f15734co;

        /* renamed from: f  reason: collision with root package name */
        public boolean f15735f;

        /* renamed from: f3  reason: collision with root package name */
        public boolean f15736f3;

        /* renamed from: fb  reason: collision with root package name */
        public int f15737fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f15738gv;

        /* renamed from: i4  reason: collision with root package name */
        public boolean f15739i4;

        /* renamed from: i9  reason: collision with root package name */
        public int f15740i9;

        /* renamed from: mt  reason: collision with root package name */
        public z0.x4<String> f15741mt;

        /* renamed from: n  reason: collision with root package name */
        public HashMap<rs, f3> f15742n;

        /* renamed from: n3  reason: collision with root package name */
        public int f15743n3;

        /* renamed from: p  reason: collision with root package name */
        public int f15744p;

        /* renamed from: r  reason: collision with root package name */
        public int f15745r;

        /* renamed from: s  reason: collision with root package name */
        public int f15746s;

        /* renamed from: t  reason: collision with root package name */
        public z0.x4<String> f15747t;

        /* renamed from: tl  reason: collision with root package name */
        public int f15748tl;

        /* renamed from: v  reason: collision with root package name */
        public int f15749v;

        /* renamed from: w  reason: collision with root package name */
        public int f15750w;

        /* renamed from: wz  reason: collision with root package name */
        public z0.x4<String> f15751wz;

        /* renamed from: x4  reason: collision with root package name */
        public boolean f15752x4;

        /* renamed from: xc  reason: collision with root package name */
        public int f15753xc;
        public int y;

        /* renamed from: z  reason: collision with root package name */
        public int f15754z;

        /* renamed from: zn  reason: collision with root package name */
        public int f15755zn;

        @Deprecated
        public y() {
            this.y = Integer.MAX_VALUE;
            this.f15743n3 = Integer.MAX_VALUE;
            this.f15755zn = Integer.MAX_VALUE;
            this.f15738gv = Integer.MAX_VALUE;
            this.f15733c5 = Integer.MAX_VALUE;
            this.f15740i9 = Integer.MAX_VALUE;
            this.f15735f = true;
            this.f15747t = z0.x4.j5();
            this.f15748tl = 0;
            this.f15751wz = z0.x4.j5();
            this.f15753xc = 0;
            this.f15750w = Integer.MAX_VALUE;
            this.f15744p = Integer.MAX_VALUE;
            this.f15741mt = z0.x4.j5();
            this.f15734co = z0.x4.j5();
            this.f15754z = 0;
            this.f15745r = 0;
            this.f15752x4 = false;
            this.f15739i4 = false;
            this.f15736f3 = false;
            this.f15742n = new HashMap<>();
            this.f15732c = new HashSet<>();
        }

        public static z0.x4<String> rz(String[] strArr) {
            x4.y x42 = z0.x4.x4();
            for (String str : (String[]) v5.y.v(strArr)) {
                x42.y(j5.ad((String) v5.y.v(str)));
            }
            return x42.s();
        }

        public y a8(@Nullable String str) {
            if (str == null) {
                return x(new String[0]);
            }
            return x(str);
        }

        public y b(Context context) {
            if (j5.y >= 19) {
                k5(context);
            }
            return this;
        }

        public y d(int i) {
            this.f15744p = i;
            return this;
        }

        public c d0() {
            return new c(this);
        }

        public y ej(int i) {
            this.f15755zn = i;
            return this;
        }

        public final void fh(c cVar) {
            this.y = cVar.y;
            this.f15743n3 = cVar.f15727v;
            this.f15755zn = cVar.f15714fb;
            this.f15738gv = cVar.f15724s;
            this.f15749v = cVar.f15712f;
            this.f15731a = cVar.f15725t;
            this.f15737fb = cVar.f15728w;
            this.f15746s = cVar.f15721p;
            this.f15733c5 = cVar.f15708co;
            this.f15740i9 = cVar.f15730z;
            this.f15735f = cVar.f15723r;
            this.f15747t = cVar.f15713f3;
            this.f15748tl = cVar.f15718n;
            this.f15751wz = cVar.f15707c;
            this.f15753xc = cVar.f15710d0;
            this.f15750w = cVar.f15715fh;
            this.f15744p = cVar.f15709d;
            this.f15741mt = cVar.f15711ej;
            this.f15734co = cVar.f15729x;
            this.f15754z = cVar.f15706b;
            this.f15745r = cVar.f15717j5;
            this.f15752x4 = cVar.f15722qn;
            this.f15739i4 = cVar.f15719o;
            this.f15736f3 = cVar.f15716j;
            this.f15732c = new HashSet<>(cVar.f15726ut);
            this.f15742n = new HashMap<>(cVar.f15720oz);
        }

        public y hw(int i, int i5, boolean z2) {
            this.f15733c5 = i;
            this.f15740i9 = i5;
            this.f15735f = z2;
            return this;
        }

        public y j5(Context context, boolean z2) {
            Point vl2 = j5.vl(context);
            return hw(vl2.x, vl2.y, z2);
        }

        public final void k5(Context context) {
            CaptioningManager captioningManager;
            if ((j5.y >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f15754z = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f15734co = z0.x4.o(j5.en(locale));
                }
            }
        }

        public y mg(c cVar) {
            fh(cVar);
            return this;
        }

        @Deprecated
        public y ta(Set<Integer> set) {
            this.f15732c.clear();
            this.f15732c.addAll(set);
            return this;
        }

        public y ud(int i, int i5) {
            this.y = i;
            this.f15743n3 = i5;
            return this;
        }

        public y vl(String... strArr) {
            this.f15747t = z0.x4.ud(strArr);
            return this;
        }

        public y x(String... strArr) {
            this.f15741mt = z0.x4.ud(strArr);
            return this;
        }

        public y yt(@Nullable String str) {
            if (str == null) {
                return vl(new String[0]);
            }
            return vl(str);
        }

        public y z6(int i) {
            this.f15738gv = i;
            return this;
        }

        public y(Context context) {
            this();
            b(context);
            j5(context, true);
        }

        public y(c cVar) {
            fh(cVar);
        }

        public y(Bundle bundle) {
            z0.x4 n32;
            String str = c.f15701xg;
            c cVar = c.f15694q9;
            this.y = bundle.getInt(str, cVar.y);
            this.f15743n3 = bundle.getInt(c.f15680dm, cVar.f15727v);
            this.f15755zn = bundle.getInt(c.f15679ct, cVar.f15714fb);
            this.f15738gv = bundle.getInt(c.f15693o4, cVar.f15724s);
            this.f15749v = bundle.getInt(c.f15697rs, cVar.f15712f);
            this.f15731a = bundle.getInt(c.f15682eb, cVar.f15725t);
            this.f15737fb = bundle.getInt(c.f15690lc, cVar.f15728w);
            this.f15746s = bundle.getInt(c.f15692nf, cVar.f15721p);
            this.f15733c5 = bundle.getInt(c.f15695ra, cVar.f15708co);
            this.f15740i9 = bundle.getInt(c.f15681e, cVar.f15730z);
            this.f15735f = bundle.getBoolean(c.f15698s8, cVar.f15723r);
            this.f15747t = z0.x4.ud((String[]) w0.c5.y(bundle.getStringArray(c.f15677ap), new String[0]));
            this.f15748tl = bundle.getInt(c.f15700u0, cVar.f15718n);
            this.f15751wz = rz((String[]) w0.c5.y(bundle.getStringArray(c.f15684f7), new String[0]));
            this.f15753xc = bundle.getInt(c.f15683en, cVar.f15710d0);
            this.f15750w = bundle.getInt(c.f15705yg, cVar.f15715fh);
            this.f15744p = bundle.getInt(c.f15704yc, cVar.f15709d);
            this.f15741mt = z0.x4.ud((String[]) w0.c5.y(bundle.getStringArray(c.f15689kp), new String[0]));
            this.f15734co = rz((String[]) w0.c5.y(bundle.getStringArray(c.f15687jz), new String[0]));
            this.f15754z = bundle.getInt(c.f15699u, cVar.f15706b);
            this.f15745r = bundle.getInt(c.f15678bk, cVar.f15717j5);
            this.f15752x4 = bundle.getBoolean(c.f15703y5, cVar.f15722qn);
            this.f15739i4 = bundle.getBoolean(c.f15696rb, cVar.f15719o);
            this.f15736f3 = bundle.getBoolean(c.f15686g3, cVar.f15716j);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(c.f15691m);
            if (parcelableArrayList == null) {
                n32 = z0.x4.j5();
            } else {
                n32 = v5.gv.n3(f3.f15758f, parcelableArrayList);
            }
            this.f15742n = new HashMap<>();
            for (int i = 0; i < n32.size(); i++) {
                f3 f3Var = (f3) n32.get(i);
                this.f15742n.put(f3Var.y, f3Var);
            }
            int[] iArr = (int[]) w0.c5.y(bundle.getIntArray(c.f15685g), new int[0]);
            this.f15732c = new HashSet<>();
            for (int i5 : iArr) {
                this.f15732c.add(Integer.valueOf(i5));
            }
        }
    }
}
