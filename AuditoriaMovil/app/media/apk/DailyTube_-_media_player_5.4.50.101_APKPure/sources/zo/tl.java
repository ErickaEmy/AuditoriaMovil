package zo;

import af.lc;
import af.mg;
import af.rs;
import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import m1.hk;
import m1.hy;
import m1.ic;
import m1.m;
import m1.s;
import v5.j5;
import z0.x4;
import z0.yt;
import zo.c;
import zo.co;
import zo.r;
import zo.tl;
import zo.y;
/* loaded from: classes.dex */
public class tl extends r {

    /* renamed from: f  reason: collision with root package name */
    public static final yt<Integer> f15777f = yt.y(new Comparator() { // from class: zo.gv
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int oz2;
            oz2 = tl.oz((Integer) obj, (Integer) obj2);
            return oz2;
        }
    });

    /* renamed from: t  reason: collision with root package name */
    public static final yt<Integer> f15778t = yt.y(new Comparator() { // from class: zo.v
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int ut2;
            ut2 = tl.ut((Integer) obj, (Integer) obj2);
            return ut2;
        }
    });

    /* renamed from: a  reason: collision with root package name */
    public final co.n3 f15779a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public a f15780c5;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f15781fb;

    /* renamed from: gv  reason: collision with root package name */
    public final Object f15782gv;

    /* renamed from: i9  reason: collision with root package name */
    public d9.v f15783i9;

    /* renamed from: s  reason: collision with root package name */
    public gv f15784s;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final Context f15785v;

    /* loaded from: classes.dex */
    public static class a {
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public Spatializer.OnSpatializerStateChangedListener f15786gv;

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f15787n3;
        public final Spatializer y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public Handler f15788zn;

        /* loaded from: classes.dex */
        public class y implements Spatializer.OnSpatializerStateChangedListener {
            public final /* synthetic */ tl y;

            public y(a aVar, tl tlVar) {
                this.y = tlVar;
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z2) {
                this.y.k();
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z2) {
                this.y.k();
            }
        }

        public a(Spatializer spatializer) {
            boolean z2;
            this.y = spatializer;
            if (spatializer.getImmersiveAudioLevel() != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f15787n3 = z2;
        }

        @Nullable
        public static a fb(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return null;
            }
            return new a(audioManager.getSpatializer());
        }

        public void a() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.f15786gv;
            if (onSpatializerStateChangedListener != null && this.f15788zn != null) {
                this.y.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
                ((Handler) j5.i9(this.f15788zn)).removeCallbacksAndMessages(null);
                this.f15788zn = null;
                this.f15786gv = null;
            }
        }

        public boolean gv() {
            return this.y.isEnabled();
        }

        public void n3(tl tlVar, Looper looper) {
            if (this.f15786gv == null && this.f15788zn == null) {
                this.f15786gv = new y(this, tlVar);
                Handler handler = new Handler(looper);
                this.f15788zn = handler;
                Spatializer spatializer = this.y;
                Objects.requireNonNull(handler);
                spatializer.addOnSpatializerStateChangedListener(new n7.wz(handler), this.f15786gv);
            }
        }

        public boolean v() {
            return this.f15787n3;
        }

        public boolean y(d9.v vVar, m mVar) {
            int i;
            if ("audio/eac3-joc".equals(mVar.f10948f3) && mVar.f10958oz == 16) {
                i = 12;
            } else {
                i = mVar.f10958oz;
            }
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(j5.z6(i));
            int i5 = mVar.f10966ut;
            if (i5 != -1) {
                channelMask.setSampleRate(i5);
            }
            return this.y.canBeSpatialized(vVar.n3().y, channelMask.build());
        }

        public boolean zn() {
            return this.y.isAvailable();
        }
    }

    /* loaded from: classes.dex */
    public static final class c5 extends s<c5> {

        /* renamed from: c  reason: collision with root package name */
        public final boolean f15789c;

        /* renamed from: co  reason: collision with root package name */
        public final int f15790co;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f15791d;

        /* renamed from: d0  reason: collision with root package name */
        public final int f15792d0;

        /* renamed from: ej  reason: collision with root package name */
        public final int f15793ej;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f15794f;

        /* renamed from: f3  reason: collision with root package name */
        public final int f15795f3;

        /* renamed from: fh  reason: collision with root package name */
        public final boolean f15796fh;

        /* renamed from: n  reason: collision with root package name */
        public final boolean f15797n;

        /* renamed from: p  reason: collision with root package name */
        public final boolean f15798p;

        /* renamed from: r  reason: collision with root package name */
        public final int f15799r;

        /* renamed from: t  reason: collision with root package name */
        public final gv f15800t;

        /* renamed from: w  reason: collision with root package name */
        public final boolean f15801w;

        /* renamed from: z  reason: collision with root package name */
        public final int f15802z;

        /* JADX WARN: Removed duplicated region for block: B:54:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x00c8 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public c5(int r5, af.rs r6, int r7, zo.tl.gv r8, int r9, int r10, boolean r11) {
            /*
                Method dump skipped, instructions count: 246
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: zo.tl.c5.<init>(int, af.rs, int, zo.tl$gv, int, int, boolean):void");
        }

        public static int a(c5 c5Var, c5 c5Var2) {
            yt t2;
            yt ytVar;
            if (c5Var.f15794f && c5Var.f15798p) {
                t2 = tl.f15777f;
            } else {
                t2 = tl.f15777f.t();
            }
            z0.wz i92 = z0.wz.i9();
            Integer valueOf = Integer.valueOf(c5Var.f15790co);
            Integer valueOf2 = Integer.valueOf(c5Var2.f15790co);
            if (!c5Var.f15800t.f15719o) {
                ytVar = tl.f15778t;
            } else {
                ytVar = tl.f15777f.t();
            }
            return i92.a(valueOf, valueOf2, ytVar).a(Integer.valueOf(c5Var.f15802z), Integer.valueOf(c5Var2.f15802z), t2).a(Integer.valueOf(c5Var.f15790co), Integer.valueOf(c5Var2.f15790co), t2).c5();
        }

        public static int fb(List<c5> list, List<c5> list2) {
            return z0.wz.i9().a((c5) Collections.max(list, new Comparator() { // from class: zo.w
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int v2;
                    v2 = tl.c5.v((tl.c5) obj, (tl.c5) obj2);
                    return v2;
                }
            }), (c5) Collections.max(list2, new Comparator() { // from class: zo.w
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int v2;
                    v2 = tl.c5.v((tl.c5) obj, (tl.c5) obj2);
                    return v2;
                }
            }), new Comparator() { // from class: zo.w
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int v2;
                    v2 = tl.c5.v((tl.c5) obj, (tl.c5) obj2);
                    return v2;
                }
            }).gv(list.size(), list2.size()).a((c5) Collections.max(list, new Comparator() { // from class: zo.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int a2;
                    a2 = tl.c5.a((tl.c5) obj, (tl.c5) obj2);
                    return a2;
                }
            }), (c5) Collections.max(list2, new Comparator() { // from class: zo.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int a2;
                    a2 = tl.c5.a((tl.c5) obj, (tl.c5) obj2);
                    return a2;
                }
            }), new Comparator() { // from class: zo.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int a2;
                    a2 = tl.c5.a((tl.c5) obj, (tl.c5) obj2);
                    return a2;
                }
            }).c5();
        }

        public static z0.x4<c5> s(int i, rs rsVar, gv gvVar, int[] iArr, int i5) {
            boolean z2;
            int a82 = tl.a8(rsVar, gvVar.f15708co, gvVar.f15730z, gvVar.f15723r);
            x4.y x42 = z0.x4.x4();
            for (int i6 = 0; i6 < rsVar.y; i6++) {
                int a2 = rsVar.zn(i6).a();
                if (a82 != Integer.MAX_VALUE && (a2 == -1 || a2 > a82)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                x42.y(new c5(i, rsVar, i6, gvVar, iArr[i6], i5, z2));
            }
            return x42.s();
        }

        public static int v(c5 c5Var, c5 c5Var2) {
            z0.wz fb2 = z0.wz.i9().fb(c5Var.f15798p, c5Var2.f15798p).gv(c5Var.f15795f3, c5Var2.f15795f3).fb(c5Var.f15797n, c5Var2.f15797n).fb(c5Var.f15794f, c5Var2.f15794f).fb(c5Var.f15801w, c5Var2.f15801w).a(Integer.valueOf(c5Var.f15799r), Integer.valueOf(c5Var2.f15799r), yt.v().t()).fb(c5Var.f15796fh, c5Var2.f15796fh).fb(c5Var.f15791d, c5Var2.f15791d);
            if (c5Var.f15796fh && c5Var.f15791d) {
                fb2 = fb2.gv(c5Var.f15793ej, c5Var2.f15793ej);
            }
            return fb2.c5();
        }

        public final int c5(int i, int i5) {
            if ((this.f15880s.f10947f & 16384) != 0 || !tl.j5(i, this.f15800t.f15840qj)) {
                return 0;
            }
            if (!this.f15794f && !this.f15800t.f15842tg) {
                return 0;
            }
            if (tl.j5(i, false) && this.f15801w && this.f15794f && this.f15880s.f10959p != -1) {
                gv gvVar = this.f15800t;
                if (!gvVar.f15716j && !gvVar.f15719o && (i & i5) != 0) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // zo.tl.s
        /* renamed from: f */
        public boolean n3(c5 c5Var) {
            if ((!this.f15789c && !j5.zn(this.f15880s.f10948f3, c5Var.f15880s.f10948f3)) || (!this.f15800t.f15832cr && (this.f15796fh != c5Var.f15796fh || this.f15791d != c5Var.f15791d))) {
                return false;
            }
            return true;
        }

        @Override // zo.tl.s
        public int y() {
            return this.f15792d0;
        }
    }

    /* loaded from: classes.dex */
    public static final class fb extends s<fb> implements Comparable<fb> {

        /* renamed from: co  reason: collision with root package name */
        public final int f15803co;

        /* renamed from: f  reason: collision with root package name */
        public final int f15804f;

        /* renamed from: f3  reason: collision with root package name */
        public final int f15805f3;

        /* renamed from: n  reason: collision with root package name */
        public final boolean f15806n;

        /* renamed from: p  reason: collision with root package name */
        public final boolean f15807p;

        /* renamed from: r  reason: collision with root package name */
        public final int f15808r;

        /* renamed from: t  reason: collision with root package name */
        public final boolean f15809t;

        /* renamed from: w  reason: collision with root package name */
        public final boolean f15810w;

        /* renamed from: z  reason: collision with root package name */
        public final int f15811z;

        public fb(int i, rs rsVar, int i5, gv gvVar, int i6, @Nullable String str) {
            super(i, rsVar, i5);
            boolean z2;
            boolean z3;
            z0.x4<String> x4Var;
            int i8;
            boolean z4;
            boolean z5;
            boolean z7;
            int i10 = 0;
            this.f15809t = tl.j5(i6, false);
            int i11 = this.f15880s.f10963s & (~gvVar.f15717j5);
            if ((i11 & 1) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f15810w = z2;
            if ((i11 & 2) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f15807p = z3;
            if (gvVar.f15729x.isEmpty()) {
                x4Var = z0.x4.o("");
            } else {
                x4Var = gvVar.f15729x;
            }
            int i12 = 0;
            while (true) {
                if (i12 < x4Var.size()) {
                    i8 = tl.ud(this.f15880s, x4Var.get(i12), gvVar.f15722qn);
                    if (i8 > 0) {
                        break;
                    }
                    i12++;
                } else {
                    i12 = Integer.MAX_VALUE;
                    i8 = 0;
                    break;
                }
            }
            this.f15803co = i12;
            this.f15811z = i8;
            int k52 = tl.k5(this.f15880s.f10947f, gvVar.f15706b);
            this.f15808r = k52;
            if ((this.f15880s.f10947f & 1088) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f15806n = z4;
            if (tl.f7(str) == null) {
                z5 = true;
            } else {
                z5 = false;
            }
            int ud2 = tl.ud(this.f15880s, str, z5);
            this.f15805f3 = ud2;
            if (i8 <= 0 && ((!gvVar.f15729x.isEmpty() || k52 <= 0) && !this.f15810w && (!this.f15807p || ud2 <= 0))) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (tl.j5(i6, gvVar.f15840qj) && z7) {
                i10 = 1;
            }
            this.f15804f = i10;
        }

        public static z0.x4<fb> v(int i, rs rsVar, gv gvVar, int[] iArr, @Nullable String str) {
            x4.y x42 = z0.x4.x4();
            for (int i5 = 0; i5 < rsVar.y; i5++) {
                x42.y(new fb(i, rsVar, i5, gvVar, iArr[i5], str));
            }
            return x42.s();
        }

        public static int zn(List<fb> list, List<fb> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        @Override // zo.tl.s
        /* renamed from: a */
        public boolean n3(fb fbVar) {
            return false;
        }

        @Override // java.lang.Comparable
        /* renamed from: gv */
        public int compareTo(fb fbVar) {
            yt t2;
            z0.wz fb2 = z0.wz.i9().fb(this.f15809t, fbVar.f15809t).a(Integer.valueOf(this.f15803co), Integer.valueOf(fbVar.f15803co), yt.v().t()).gv(this.f15811z, fbVar.f15811z).gv(this.f15808r, fbVar.f15808r).fb(this.f15810w, fbVar.f15810w);
            Boolean valueOf = Boolean.valueOf(this.f15807p);
            Boolean valueOf2 = Boolean.valueOf(fbVar.f15807p);
            if (this.f15811z == 0) {
                t2 = yt.v();
            } else {
                t2 = yt.v().t();
            }
            z0.wz gv2 = fb2.a(valueOf, valueOf2, t2).gv(this.f15805f3, fbVar.f15805f3);
            if (this.f15808r == 0) {
                gv2 = gv2.s(this.f15806n, fbVar.f15806n);
            }
            return gv2.c5();
        }

        @Override // zo.tl.s
        public int y() {
            return this.f15804f;
        }
    }

    /* loaded from: classes.dex */
    public static final class gv extends c implements m1.s {

        /* renamed from: bv  reason: collision with root package name */
        public static final s.y<gv> f15812bv;

        /* renamed from: cs  reason: collision with root package name */
        public static final String f15813cs;
        public static final String gf;

        /* renamed from: i2  reason: collision with root package name */
        public static final String f15814i2;

        /* renamed from: i3  reason: collision with root package name */
        public static final String f15815i3;

        /* renamed from: ix  reason: collision with root package name */
        public static final String f15816ix;

        /* renamed from: j3  reason: collision with root package name */
        public static final String f15817j3;

        /* renamed from: le  reason: collision with root package name */
        public static final String f15818le;

        /* renamed from: mp  reason: collision with root package name */
        public static final String f15819mp;

        /* renamed from: nd  reason: collision with root package name */
        public static final String f15820nd;

        /* renamed from: ne  reason: collision with root package name */
        public static final String f15821ne;

        /* renamed from: q  reason: collision with root package name */
        public static final String f15822q;

        /* renamed from: q5  reason: collision with root package name */
        public static final String f15823q5;

        /* renamed from: ro  reason: collision with root package name */
        public static final String f15824ro;

        /* renamed from: vn  reason: collision with root package name */
        public static final String f15825vn;
        @Deprecated

        /* renamed from: w2  reason: collision with root package name */
        public static final gv f15826w2;

        /* renamed from: w9  reason: collision with root package name */
        public static final gv f15827w9;

        /* renamed from: wm  reason: collision with root package name */
        public static final String f15828wm;

        /* renamed from: x5  reason: collision with root package name */
        public static final String f15829x5;

        /* renamed from: yk  reason: collision with root package name */
        public static final String f15830yk;

        /* renamed from: ad  reason: collision with root package name */
        public final boolean f15831ad;

        /* renamed from: cr  reason: collision with root package name */
        public final boolean f15832cr;

        /* renamed from: cy  reason: collision with root package name */
        public final boolean f15833cy;

        /* renamed from: gq  reason: collision with root package name */
        public final boolean f15834gq;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f15835l;

        /* renamed from: o0  reason: collision with root package name */
        public final boolean f15836o0;

        /* renamed from: oa  reason: collision with root package name */
        public final SparseBooleanArray f15837oa;

        /* renamed from: pq  reason: collision with root package name */
        public final boolean f15838pq;

        /* renamed from: pz  reason: collision with root package name */
        public final boolean f15839pz;

        /* renamed from: qj  reason: collision with root package name */
        public final boolean f15840qj;

        /* renamed from: qk  reason: collision with root package name */
        public final boolean f15841qk;

        /* renamed from: tg  reason: collision with root package name */
        public final boolean f15842tg;

        /* renamed from: vp  reason: collision with root package name */
        public final SparseArray<Map<lc, v>> f15843vp;

        /* renamed from: wf  reason: collision with root package name */
        public final boolean f15844wf;

        /* renamed from: xb  reason: collision with root package name */
        public final boolean f15845xb;

        static {
            gv d02 = new y().d0();
            f15827w9 = d02;
            f15826w2 = d02;
            f15829x5 = j5.g3(1000);
            f15823q5 = j5.g3(1001);
            f15819mp = j5.g3(1002);
            f15818le = j5.g3(1003);
            f15813cs = j5.g3(1004);
            f15824ro = j5.g3(1005);
            f15816ix = j5.g3(1006);
            f15830yk = j5.g3(1007);
            f15814i2 = j5.g3(1008);
            f15815i3 = j5.g3(1009);
            f15825vn = j5.g3(1010);
            f15817j3 = j5.g3(1011);
            f15821ne = j5.g3(1012);
            f15822q = j5.g3(1013);
            f15828wm = j5.g3(1014);
            f15820nd = j5.g3(1015);
            gf = j5.g3(1016);
            f15812bv = new s.y() { // from class: zo.wz
                @Override // m1.s.y
                public final m1.s fromBundle(Bundle bundle) {
                    tl.gv vl2;
                    vl2 = tl.gv.vl(bundle);
                    return vl2;
                }
            };
        }

        public static gv a8(Context context) {
            return new y(context).d0();
        }

        public static boolean d(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static boolean ej(java.util.Map<af.lc, zo.tl.v> r4, java.util.Map<af.lc, zo.tl.v> r5) {
            /*
                int r0 = r4.size()
                int r1 = r5.size()
                r2 = 0
                if (r1 == r0) goto Lc
                return r2
            Lc:
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L14:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L3b
                java.lang.Object r0 = r4.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getKey()
                af.lc r1 = (af.lc) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L3a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = v5.j5.zn(r0, r1)
                if (r0 != 0) goto L14
            L3a:
                return r2
            L3b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: zo.tl.gv.ej(java.util.Map, java.util.Map):boolean");
        }

        public static void hw(Bundle bundle, SparseArray<Map<lc, v>> sparseArray) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray2 = new SparseArray();
            for (int i = 0; i < sparseArray.size(); i++) {
                int keyAt = sparseArray.keyAt(i);
                for (Map.Entry<lc, v> entry : sparseArray.valueAt(i).entrySet()) {
                    v value = entry.getValue();
                    if (value != null) {
                        sparseArray2.put(arrayList2.size(), value);
                    }
                    arrayList2.add(entry.getKey());
                    arrayList.add(Integer.valueOf(keyAt));
                }
                bundle.putIntArray(f15825vn, d1.a.wz(arrayList));
                bundle.putParcelableArrayList(f15817j3, v5.gv.gv(arrayList2));
                bundle.putSparseParcelableArray(f15821ne, v5.gv.v(sparseArray2));
            }
        }

        public static /* synthetic */ gv vl(Bundle bundle) {
            return new y(bundle).d0();
        }

        public static int[] x(SparseBooleanArray sparseBooleanArray) {
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i = 0; i < sparseBooleanArray.size(); i++) {
                iArr[i] = sparseBooleanArray.keyAt(i);
            }
            return iArr;
        }

        public static boolean z6(SparseArray<Map<lc, v>> sparseArray, SparseArray<Map<lc, v>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (indexOfKey < 0 || !ej(sparseArray.valueAt(i), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        public boolean b(int i) {
            return this.f15837oa.get(i);
        }

        @Override // zo.c
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || gv.class != obj.getClass()) {
                return false;
            }
            gv gvVar = (gv) obj;
            if (super.equals(gvVar) && this.f15842tg == gvVar.f15842tg && this.f15839pz == gvVar.f15839pz && this.f15838pq == gvVar.f15838pq && this.f15832cr == gvVar.f15832cr && this.f15836o0 == gvVar.f15836o0 && this.f15845xb == gvVar.f15845xb && this.f15844wf == gvVar.f15844wf && this.f15831ad == gvVar.f15831ad && this.f15833cy == gvVar.f15833cy && this.f15841qk == gvVar.f15841qk && this.f15840qj == gvVar.f15840qj && this.f15835l == gvVar.f15835l && this.f15834gq == gvVar.f15834gq && d(this.f15837oa, gvVar.f15837oa) && z6(this.f15843vp, gvVar.f15843vp)) {
                return true;
            }
            return false;
        }

        @Override // zo.c
        public int hashCode() {
            return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.f15842tg ? 1 : 0)) * 31) + (this.f15839pz ? 1 : 0)) * 31) + (this.f15838pq ? 1 : 0)) * 31) + (this.f15832cr ? 1 : 0)) * 31) + (this.f15836o0 ? 1 : 0)) * 31) + (this.f15845xb ? 1 : 0)) * 31) + (this.f15844wf ? 1 : 0)) * 31) + (this.f15831ad ? 1 : 0)) * 31) + (this.f15833cy ? 1 : 0)) * 31) + (this.f15841qk ? 1 : 0)) * 31) + (this.f15840qj ? 1 : 0)) * 31) + (this.f15835l ? 1 : 0)) * 31) + (this.f15834gq ? 1 : 0);
        }

        @Nullable
        @Deprecated
        public v k5(int i, lc lcVar) {
            Map<lc, v> map = this.f15843vp.get(i);
            if (map != null) {
                return map.get(lcVar);
            }
            return null;
        }

        @Override // zo.c, m1.s
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(f15829x5, this.f15842tg);
            bundle.putBoolean(f15823q5, this.f15839pz);
            bundle.putBoolean(f15819mp, this.f15838pq);
            bundle.putBoolean(f15828wm, this.f15832cr);
            bundle.putBoolean(f15818le, this.f15836o0);
            bundle.putBoolean(f15813cs, this.f15845xb);
            bundle.putBoolean(f15824ro, this.f15844wf);
            bundle.putBoolean(f15816ix, this.f15831ad);
            bundle.putBoolean(f15820nd, this.f15833cy);
            bundle.putBoolean(gf, this.f15841qk);
            bundle.putBoolean(f15830yk, this.f15840qj);
            bundle.putBoolean(f15814i2, this.f15835l);
            bundle.putBoolean(f15815i3, this.f15834gq);
            hw(bundle, this.f15843vp);
            bundle.putIntArray(f15822q, x(this.f15837oa));
            return bundle;
        }

        @Override // zo.c
        /* renamed from: ud */
        public y d0() {
            return new y();
        }

        @Deprecated
        public boolean yt(int i, lc lcVar) {
            Map<lc, v> map = this.f15843vp.get(i);
            if (map != null && map.containsKey(lcVar)) {
                return true;
            }
            return false;
        }

        /* loaded from: classes.dex */
        public static final class y extends c.y {

            /* renamed from: a8  reason: collision with root package name */
            public boolean f15846a8;

            /* renamed from: b  reason: collision with root package name */
            public boolean f15847b;

            /* renamed from: d  reason: collision with root package name */
            public boolean f15848d;

            /* renamed from: d0  reason: collision with root package name */
            public boolean f15849d0;

            /* renamed from: ej  reason: collision with root package name */
            public boolean f15850ej;

            /* renamed from: fh  reason: collision with root package name */
            public boolean f15851fh;

            /* renamed from: k5  reason: collision with root package name */
            public boolean f15852k5;

            /* renamed from: mg  reason: collision with root package name */
            public boolean f15853mg;

            /* renamed from: rz  reason: collision with root package name */
            public boolean f15854rz;

            /* renamed from: ta  reason: collision with root package name */
            public boolean f15855ta;

            /* renamed from: ud  reason: collision with root package name */
            public boolean f15856ud;

            /* renamed from: vl  reason: collision with root package name */
            public final SparseBooleanArray f15857vl;

            /* renamed from: x  reason: collision with root package name */
            public boolean f15858x;

            /* renamed from: yt  reason: collision with root package name */
            public final SparseArray<Map<lc, v>> f15859yt;

            /* renamed from: z6  reason: collision with root package name */
            public boolean f15860z6;

            public static SparseArray<Map<lc, v>> rs(SparseArray<Map<lc, v>> sparseArray) {
                SparseArray<Map<lc, v>> sparseArray2 = new SparseArray<>();
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), new HashMap(sparseArray.valueAt(i)));
                }
                return sparseArray2;
            }

            @Override // zo.c.y
            /* renamed from: ad */
            public y vl(String... strArr) {
                super.vl(strArr);
                return this;
            }

            public y ap(boolean z2) {
                this.f15860z6 = z2;
                return this;
            }

            public y bk(boolean z2) {
                this.f15849d0 = z2;
                return this;
            }

            public y cr(@Nullable String str) {
                super.a8(str);
                return this;
            }

            public y cy(int i, boolean z2) {
                if (this.f15857vl.get(i) == z2) {
                    return this;
                }
                if (z2) {
                    this.f15857vl.put(i, true);
                } else {
                    this.f15857vl.delete(i);
                }
                return this;
            }

            public y e(boolean z2) {
                this.f15856ud = z2;
                return this;
            }

            public final void eb() {
                this.f15849d0 = true;
                this.f15851fh = false;
                this.f15854rz = true;
                this.f15853mg = false;
                this.f15855ta = true;
                this.f15848d = false;
                this.f15860z6 = false;
                this.f15850ej = false;
                this.f15856ud = false;
                this.f15846a8 = true;
                this.f15858x = true;
                this.f15847b = false;
                this.f15852k5 = true;
            }

            public y g(boolean z2) {
                this.f15855ta = z2;
                return this;
            }

            public y g3(boolean z2) {
                this.f15846a8 = z2;
                return this;
            }

            @Override // zo.c.y
            /* renamed from: gq */
            public y hw(int i, int i5, boolean z2) {
                super.hw(i, i5, z2);
                return this;
            }

            public y kp(boolean z2) {
                this.f15851fh = z2;
                return this;
            }

            public y l(boolean z2) {
                this.f15847b = z2;
                return this;
            }

            public final SparseBooleanArray lc(@Nullable int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int i : iArr) {
                    sparseBooleanArray.append(i, true);
                }
                return sparseBooleanArray;
            }

            @Deprecated
            public y m(Set<Integer> set) {
                super.ta(set);
                return this;
            }

            public y nf(c cVar) {
                super.mg(cVar);
                return this;
            }

            @Override // zo.c.y
            /* renamed from: o0 */
            public y x(String... strArr) {
                super.x(strArr);
                return this;
            }

            @Override // zo.c.y
            /* renamed from: o4 */
            public gv d0() {
                return new gv(this);
            }

            public y pq(int i, int i5) {
                super.ud(i, i5);
                return this;
            }

            public y pz(int i) {
                super.ej(i);
                return this;
            }

            public final void qj(Bundle bundle) {
                z0.x4 n32;
                SparseArray zn2;
                int[] intArray = bundle.getIntArray(gv.f15825vn);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(gv.f15817j3);
                if (parcelableArrayList == null) {
                    n32 = z0.x4.j5();
                } else {
                    n32 = v5.gv.n3(lc.f328t, parcelableArrayList);
                }
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(gv.f15821ne);
                if (sparseParcelableArray == null) {
                    zn2 = new SparseArray();
                } else {
                    zn2 = v5.gv.zn(v.f15883p, sparseParcelableArray);
                }
                if (intArray != null && intArray.length == n32.size()) {
                    for (int i = 0; i < intArray.length; i++) {
                        qk(intArray[i], (lc) n32.get(i), (v) zn2.get(i));
                    }
                }
            }

            @Deprecated
            public y qk(int i, lc lcVar, @Nullable v vVar) {
                Map<lc, v> map = this.f15859yt.get(i);
                if (map == null) {
                    map = new HashMap<>();
                    this.f15859yt.put(i, map);
                }
                if (map.containsKey(lcVar) && j5.zn(map.get(lcVar), vVar)) {
                    return this;
                }
                map.put(lcVar, vVar);
                return this;
            }

            public y ra(boolean z2) {
                this.f15850ej = z2;
                return this;
            }

            public y rb(boolean z2) {
                this.f15854rz = z2;
                return this;
            }

            public y s8(boolean z2) {
                this.f15848d = z2;
                return this;
            }

            public y tg(int i) {
                super.z6(i);
                return this;
            }

            public y u0(boolean z2) {
                this.f15858x = z2;
                return this;
            }

            @Override // zo.c.y
            /* renamed from: vp */
            public y j5(Context context, boolean z2) {
                super.j5(context, z2);
                return this;
            }

            public y wf(@Nullable String str) {
                super.yt(str);
                return this;
            }

            @Override // zo.c.y
            /* renamed from: xb */
            public y b(Context context) {
                super.b(context);
                return this;
            }

            public y y4(int i) {
                super.d(i);
                return this;
            }

            public y yc(boolean z2) {
                this.f15853mg = z2;
                return this;
            }

            public y yg(boolean z2) {
                this.f15852k5 = z2;
                return this;
            }

            @Deprecated
            public y() {
                this.f15859yt = new SparseArray<>();
                this.f15857vl = new SparseBooleanArray();
                eb();
            }

            public y(Context context) {
                super(context);
                this.f15859yt = new SparseArray<>();
                this.f15857vl = new SparseBooleanArray();
                eb();
            }

            public y(gv gvVar) {
                super(gvVar);
                this.f15849d0 = gvVar.f15842tg;
                this.f15851fh = gvVar.f15839pz;
                this.f15854rz = gvVar.f15838pq;
                this.f15853mg = gvVar.f15832cr;
                this.f15855ta = gvVar.f15836o0;
                this.f15848d = gvVar.f15845xb;
                this.f15860z6 = gvVar.f15844wf;
                this.f15850ej = gvVar.f15831ad;
                this.f15856ud = gvVar.f15833cy;
                this.f15846a8 = gvVar.f15841qk;
                this.f15858x = gvVar.f15840qj;
                this.f15847b = gvVar.f15835l;
                this.f15852k5 = gvVar.f15834gq;
                this.f15859yt = rs(gvVar.f15843vp);
                this.f15857vl = gvVar.f15837oa.clone();
            }

            public y(Bundle bundle) {
                super(bundle);
                eb();
                gv gvVar = gv.f15827w9;
                bk(bundle.getBoolean(gv.f15829x5, gvVar.f15842tg));
                kp(bundle.getBoolean(gv.f15823q5, gvVar.f15839pz));
                rb(bundle.getBoolean(gv.f15819mp, gvVar.f15838pq));
                yc(bundle.getBoolean(gv.f15828wm, gvVar.f15832cr));
                g(bundle.getBoolean(gv.f15818le, gvVar.f15836o0));
                s8(bundle.getBoolean(gv.f15813cs, gvVar.f15845xb));
                ap(bundle.getBoolean(gv.f15824ro, gvVar.f15844wf));
                ra(bundle.getBoolean(gv.f15816ix, gvVar.f15831ad));
                e(bundle.getBoolean(gv.f15820nd, gvVar.f15833cy));
                g3(bundle.getBoolean(gv.gf, gvVar.f15841qk));
                u0(bundle.getBoolean(gv.f15830yk, gvVar.f15840qj));
                l(bundle.getBoolean(gv.f15814i2, gvVar.f15835l));
                yg(bundle.getBoolean(gv.f15815i3, gvVar.f15834gq));
                this.f15859yt = new SparseArray<>();
                qj(bundle);
                this.f15857vl = lc(bundle.getIntArray(gv.f15822q));
            }
        }

        public gv(y yVar) {
            super(yVar);
            this.f15842tg = yVar.f15849d0;
            this.f15839pz = yVar.f15851fh;
            this.f15838pq = yVar.f15854rz;
            this.f15832cr = yVar.f15853mg;
            this.f15836o0 = yVar.f15855ta;
            this.f15845xb = yVar.f15848d;
            this.f15844wf = yVar.f15860z6;
            this.f15831ad = yVar.f15850ej;
            this.f15833cy = yVar.f15856ud;
            this.f15841qk = yVar.f15846a8;
            this.f15840qj = yVar.f15858x;
            this.f15835l = yVar.f15847b;
            this.f15834gq = yVar.f15852k5;
            this.f15843vp = yVar.f15859yt;
            this.f15837oa = yVar.f15857vl;
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 extends s<n3> implements Comparable<n3> {

        /* renamed from: b  reason: collision with root package name */
        public final int f15861b;

        /* renamed from: c  reason: collision with root package name */
        public final int f15862c;

        /* renamed from: co  reason: collision with root package name */
        public final boolean f15863co;

        /* renamed from: d  reason: collision with root package name */
        public final int f15864d;

        /* renamed from: d0  reason: collision with root package name */
        public final int f15865d0;

        /* renamed from: ej  reason: collision with root package name */
        public final int f15866ej;

        /* renamed from: f  reason: collision with root package name */
        public final int f15867f;

        /* renamed from: f3  reason: collision with root package name */
        public final int f15868f3;

        /* renamed from: fh  reason: collision with root package name */
        public final boolean f15869fh;

        /* renamed from: j5  reason: collision with root package name */
        public final boolean f15870j5;

        /* renamed from: n  reason: collision with root package name */
        public final boolean f15871n;

        /* renamed from: p  reason: collision with root package name */
        public final gv f15872p;

        /* renamed from: qn  reason: collision with root package name */
        public final boolean f15873qn;

        /* renamed from: r  reason: collision with root package name */
        public final int f15874r;

        /* renamed from: t  reason: collision with root package name */
        public final boolean f15875t;
        @Nullable

        /* renamed from: w  reason: collision with root package name */
        public final String f15876w;

        /* renamed from: x  reason: collision with root package name */
        public final int f15877x;

        /* renamed from: z  reason: collision with root package name */
        public final int f15878z;

        public n3(int i, rs rsVar, int i5, gv gvVar, int i6, boolean z2, w0.w<m> wVar) {
            super(i, rsVar, i5);
            int i8;
            int i10;
            boolean z3;
            boolean z4;
            boolean z5;
            int i11;
            boolean z7;
            this.f15872p = gvVar;
            this.f15876w = tl.f7(this.f15880s.f10950fb);
            this.f15863co = tl.j5(i6, false);
            int i12 = 0;
            while (true) {
                i8 = Integer.MAX_VALUE;
                if (i12 < gvVar.f15707c.size()) {
                    i10 = tl.ud(this.f15880s, gvVar.f15707c.get(i12), false);
                    if (i10 > 0) {
                        break;
                    }
                    i12++;
                } else {
                    i12 = Integer.MAX_VALUE;
                    i10 = 0;
                    break;
                }
            }
            this.f15874r = i12;
            this.f15878z = i10;
            this.f15868f3 = tl.k5(this.f15880s.f10947f, gvVar.f15710d0);
            m mVar = this.f15880s;
            int i13 = mVar.f10947f;
            if (i13 != 0 && (i13 & 1) == 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.f15871n = z3;
            if ((mVar.f10963s & 1) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f15869fh = z4;
            int i14 = mVar.f10958oz;
            this.f15864d = i14;
            this.f15866ej = mVar.f10966ut;
            int i15 = mVar.f10959p;
            this.f15877x = i15;
            if ((i15 == -1 || i15 <= gvVar.f15709d) && ((i14 == -1 || i14 <= gvVar.f15715fh) && wVar.apply(mVar))) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f15875t = z5;
            String[] lc2 = j5.lc();
            int i16 = 0;
            while (true) {
                if (i16 < lc2.length) {
                    i11 = tl.ud(this.f15880s, lc2[i16], false);
                    if (i11 > 0) {
                        break;
                    }
                    i16++;
                } else {
                    i16 = Integer.MAX_VALUE;
                    i11 = 0;
                    break;
                }
            }
            this.f15862c = i16;
            this.f15865d0 = i11;
            int i17 = 0;
            while (true) {
                if (i17 < gvVar.f15711ej.size()) {
                    String str = this.f15880s.f10948f3;
                    if (str != null && str.equals(gvVar.f15711ej.get(i17))) {
                        i8 = i17;
                        break;
                    }
                    i17++;
                } else {
                    break;
                }
            }
            this.f15861b = i8;
            if (hk.v(i6) == 128) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f15870j5 = z7;
            this.f15873qn = hk.fb(i6) == 64;
            this.f15867f = a(i6, z2);
        }

        public static z0.x4<n3> v(int i, rs rsVar, gv gvVar, int[] iArr, boolean z2, w0.w<m> wVar) {
            x4.y x42 = z0.x4.x4();
            for (int i5 = 0; i5 < rsVar.y; i5++) {
                x42.y(new n3(i, rsVar, i5, gvVar, iArr[i5], z2, wVar));
            }
            return x42.s();
        }

        public static int zn(List<n3> list, List<n3> list2) {
            return ((n3) Collections.max(list)).compareTo((n3) Collections.max(list2));
        }

        public final int a(int i, boolean z2) {
            if (!tl.j5(i, this.f15872p.f15840qj)) {
                return 0;
            }
            if (!this.f15875t && !this.f15872p.f15836o0) {
                return 0;
            }
            if (tl.j5(i, false) && this.f15875t && this.f15880s.f10959p != -1) {
                gv gvVar = this.f15872p;
                if (!gvVar.f15716j && !gvVar.f15719o && (gvVar.f15834gq || !z2)) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // zo.tl.s
        /* renamed from: fb */
        public boolean n3(n3 n3Var) {
            int i;
            String str;
            int i5;
            gv gvVar = this.f15872p;
            if ((gvVar.f15831ad || ((i5 = this.f15880s.f10958oz) != -1 && i5 == n3Var.f15880s.f10958oz)) && (gvVar.f15845xb || ((str = this.f15880s.f10948f3) != null && TextUtils.equals(str, n3Var.f15880s.f10948f3)))) {
                gv gvVar2 = this.f15872p;
                if ((gvVar2.f15844wf || ((i = this.f15880s.f10966ut) != -1 && i == n3Var.f15880s.f10966ut)) && (gvVar2.f15833cy || (this.f15870j5 == n3Var.f15870j5 && this.f15873qn == n3Var.f15873qn))) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.Comparable
        /* renamed from: gv */
        public int compareTo(n3 n3Var) {
            yt t2;
            yt ytVar;
            if (this.f15875t && this.f15863co) {
                t2 = tl.f15777f;
            } else {
                t2 = tl.f15777f.t();
            }
            z0.wz a2 = z0.wz.i9().fb(this.f15863co, n3Var.f15863co).a(Integer.valueOf(this.f15874r), Integer.valueOf(n3Var.f15874r), yt.v().t()).gv(this.f15878z, n3Var.f15878z).gv(this.f15868f3, n3Var.f15868f3).fb(this.f15869fh, n3Var.f15869fh).fb(this.f15871n, n3Var.f15871n).a(Integer.valueOf(this.f15862c), Integer.valueOf(n3Var.f15862c), yt.v().t()).gv(this.f15865d0, n3Var.f15865d0).fb(this.f15875t, n3Var.f15875t).a(Integer.valueOf(this.f15861b), Integer.valueOf(n3Var.f15861b), yt.v().t());
            Integer valueOf = Integer.valueOf(this.f15877x);
            Integer valueOf2 = Integer.valueOf(n3Var.f15877x);
            if (!this.f15872p.f15719o) {
                ytVar = tl.f15778t;
            } else {
                ytVar = tl.f15777f.t();
            }
            z0.wz a3 = a2.a(valueOf, valueOf2, ytVar).fb(this.f15870j5, n3Var.f15870j5).fb(this.f15873qn, n3Var.f15873qn).a(Integer.valueOf(this.f15864d), Integer.valueOf(n3Var.f15864d), t2).a(Integer.valueOf(this.f15866ej), Integer.valueOf(n3Var.f15866ej), t2);
            Integer valueOf3 = Integer.valueOf(this.f15877x);
            Integer valueOf4 = Integer.valueOf(n3Var.f15877x);
            if (!j5.zn(this.f15876w, n3Var.f15876w)) {
                t2 = tl.f15778t;
            }
            return a3.a(valueOf3, valueOf4, t2).c5();
        }

        @Override // zo.tl.s
        public int y() {
            return this.f15867f;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class s<T extends s<T>> {

        /* renamed from: fb  reason: collision with root package name */
        public final int f15879fb;

        /* renamed from: s  reason: collision with root package name */
        public final m f15880s;

        /* renamed from: v  reason: collision with root package name */
        public final rs f15881v;
        public final int y;

        /* loaded from: classes.dex */
        public interface y<T extends s<T>> {
            List<T> y(int i, rs rsVar, int[] iArr);
        }

        public s(int i, rs rsVar, int i5) {
            this.y = i;
            this.f15881v = rsVar;
            this.f15879fb = i5;
            this.f15880s = rsVar.zn(i5);
        }

        public abstract boolean n3(T t2);

        public abstract int y();
    }

    /* loaded from: classes.dex */
    public static final class v implements m1.s {

        /* renamed from: fb  reason: collision with root package name */
        public final int f15886fb;

        /* renamed from: s  reason: collision with root package name */
        public final int f15887s;

        /* renamed from: v  reason: collision with root package name */
        public final int[] f15888v;
        public final int y;

        /* renamed from: f  reason: collision with root package name */
        public static final String f15882f = j5.g3(0);

        /* renamed from: t  reason: collision with root package name */
        public static final String f15884t = j5.g3(1);

        /* renamed from: w  reason: collision with root package name */
        public static final String f15885w = j5.g3(2);

        /* renamed from: p  reason: collision with root package name */
        public static final s.y<v> f15883p = new s.y() { // from class: zo.xc
            @Override // m1.s.y
            public final m1.s fromBundle(Bundle bundle) {
                tl.v n32;
                n32 = tl.v.n3(bundle);
                return n32;
            }
        };

        public v(int i, int... iArr) {
            this(i, iArr, 0);
        }

        public static /* synthetic */ v n3(Bundle bundle) {
            boolean z2;
            int i = bundle.getInt(f15882f, -1);
            int[] intArray = bundle.getIntArray(f15884t);
            int i5 = bundle.getInt(f15885w, -1);
            if (i >= 0 && i5 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.y(z2);
            v5.y.v(intArray);
            return new v(i, intArray, i5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || v.class != obj.getClass()) {
                return false;
            }
            v vVar = (v) obj;
            if (this.y == vVar.y && Arrays.equals(this.f15888v, vVar.f15888v) && this.f15887s == vVar.f15887s) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.y * 31) + Arrays.hashCode(this.f15888v)) * 31) + this.f15887s;
        }

        @Override // m1.s
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(f15882f, this.y);
            bundle.putIntArray(f15884t, this.f15888v);
            bundle.putInt(f15885w, this.f15887s);
            return bundle;
        }

        public v(int i, int[] iArr, int i5) {
            this.y = i;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f15888v = copyOf;
            this.f15886fb = iArr.length;
            this.f15887s = i5;
            Arrays.sort(copyOf);
        }
    }

    /* loaded from: classes.dex */
    public static final class zn implements Comparable<zn> {

        /* renamed from: v  reason: collision with root package name */
        public final boolean f15889v;
        public final boolean y;

        public zn(m mVar, int i) {
            this.y = (mVar.f10963s & 1) != 0;
            this.f15889v = tl.j5(i, false);
        }

        @Override // java.lang.Comparable
        /* renamed from: y */
        public int compareTo(zn znVar) {
            return z0.wz.i9().fb(this.f15889v, znVar.f15889v).fb(this.y, znVar.y).c5();
        }
    }

    public tl(Context context) {
        this(context, new y.n3());
    }

    public static int a8(rs rsVar, int i, int i5, boolean z2) {
        int i6;
        int i8 = Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE && i5 != Integer.MAX_VALUE) {
            for (int i10 = 0; i10 < rsVar.y; i10++) {
                m zn2 = rsVar.zn(i10);
                int i11 = zn2.f10943d;
                if (i11 > 0 && (i6 = zn2.f10945ej) > 0) {
                    Point x2 = x(z2, i, i5, i11, i6);
                    int i12 = zn2.f10943d;
                    int i13 = zn2.f10945ej;
                    int i14 = i12 * i13;
                    if (i12 >= ((int) (x2.x * 0.98f)) && i13 >= ((int) (x2.y * 0.98f)) && i14 < i8) {
                        i8 = i14;
                    }
                }
            }
        }
        return i8;
    }

    public static void d(r.y yVar, c cVar, co.y[] yVarArr) {
        co.y yVar2;
        int gv2 = yVar.gv();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < gv2; i++) {
            ej(yVar.a(i), cVar, hashMap);
        }
        ej(yVar.s(), cVar, hashMap);
        for (int i5 = 0; i5 < gv2; i5++) {
            f3 f3Var = (f3) hashMap.get(Integer.valueOf(yVar.v(i5)));
            if (f3Var != null) {
                if (!f3Var.f15761v.isEmpty() && yVar.a(i5).zn(f3Var.y) != -1) {
                    yVar2 = new co.y(f3Var.y, d1.a.wz(f3Var.f15761v));
                } else {
                    yVar2 = null;
                }
                yVarArr[i5] = yVar2;
            }
        }
    }

    public static void ej(lc lcVar, c cVar, Map<Integer, f3> map) {
        f3 f3Var;
        for (int i = 0; i < lcVar.y; i++) {
            f3 f3Var2 = cVar.f15720oz.get(lcVar.n3(i));
            if (f3Var2 != null && ((f3Var = map.get(Integer.valueOf(f3Var2.n3()))) == null || (f3Var.f15761v.isEmpty() && !f3Var2.f15761v.isEmpty()))) {
                map.put(Integer.valueOf(f3Var2.n3()), f3Var2);
            }
        }
    }

    public static boolean en(int[][] iArr, lc lcVar, co coVar) {
        if (coVar == null) {
            return false;
        }
        int zn2 = lcVar.zn(coVar.xc());
        for (int i = 0; i < coVar.length(); i++) {
            if (hk.s(iArr[zn2][coVar.s(i)]) != 32) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static String f7(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static boolean hw(m mVar) {
        String str = mVar.f10948f3;
        if (str == null) {
            return false;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c2 = 0;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 1;
                    break;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public static /* synthetic */ List j(gv gvVar, int[] iArr, int i, rs rsVar, int[] iArr2) {
        return c5.s(i, rsVar, gvVar, iArr2, iArr[i]);
    }

    public static boolean j5(int i, boolean z2) {
        int a2 = hk.a(i);
        if (a2 != 4 && (!z2 || a2 != 3)) {
            return false;
        }
        return true;
    }

    public static int k5(int i, int i5) {
        if (i != 0 && i == i5) {
            return Integer.MAX_VALUE;
        }
        return Integer.bitCount(i & i5);
    }

    public static /* synthetic */ List o(gv gvVar, String str, int i, rs rsVar, int[] iArr) {
        return fb.v(i, rsVar, gvVar, iArr, str);
    }

    public static /* synthetic */ int oz(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            if (num2.intValue() != -1) {
                return -1;
            }
            return 0;
        } else if (num2.intValue() == -1) {
            return 1;
        } else {
            return num.intValue() - num2.intValue();
        }
    }

    public static void q9(r.y yVar, int[][][] iArr, ic[] icVarArr, co[] coVarArr) {
        boolean z2;
        boolean z3 = false;
        int i = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < yVar.gv(); i6++) {
            int v2 = yVar.v(i6);
            co coVar = coVarArr[i6];
            if ((v2 == 1 || v2 == 2) && coVar != null && en(iArr[i6], yVar.a(i6), coVar)) {
                if (v2 == 1) {
                    if (i5 != -1) {
                        z2 = false;
                        break;
                    }
                    i5 = i6;
                } else if (i != -1) {
                    z2 = false;
                    break;
                } else {
                    i = i6;
                }
            }
        }
        z2 = true;
        if (i5 != -1 && i != -1) {
            z3 = true;
        }
        if (z2 & z3) {
            ic icVar = new ic(true);
            icVarArr[i5] = icVar;
            icVarArr[i] = icVar;
        }
    }

    public static void ta(r.y yVar, gv gvVar, co.y[] yVarArr) {
        co.y yVar2;
        int gv2 = yVar.gv();
        for (int i = 0; i < gv2; i++) {
            lc a2 = yVar.a(i);
            if (gvVar.yt(i, a2)) {
                v k52 = gvVar.k5(i, a2);
                if (k52 != null && k52.f15888v.length != 0) {
                    yVar2 = new co.y(a2.n3(k52.y), k52.f15888v, k52.f15887s);
                } else {
                    yVar2 = null;
                }
                yVarArr[i] = yVar2;
            }
        }
    }

    public static int ud(m mVar, @Nullable String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(mVar.f10950fb)) {
            return 4;
        }
        String f72 = f7(str);
        String f73 = f7(mVar.f10950fb);
        if (f73 != null && f72 != null) {
            if (!f73.startsWith(f72) && !f72.startsWith(f73)) {
                if (!j5.ix(f73, "-")[0].equals(j5.ix(f72, "-")[0])) {
                    return 0;
                }
                return 2;
            }
            return 3;
        } else if (!z2 || f73 != null) {
            return 0;
        } else {
            return 1;
        }
    }

    public static /* synthetic */ int ut(Integer num, Integer num2) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x000c, code lost:
        if (r1 != r3) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Point x(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto Lf
            r3 = 0
            r0 = 1
            if (r6 <= r7) goto L8
            r1 = 1
            goto L9
        L8:
            r1 = 0
        L9:
            if (r4 <= r5) goto Lc
            r3 = 1
        Lc:
            if (r1 == r3) goto Lf
            goto L12
        Lf:
            r2 = r5
            r5 = r4
            r4 = r2
        L12:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L22
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = v5.j5.t(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L22:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = v5.j5.t(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zo.tl.x(boolean, int, int, int, int):android.graphics.Point");
    }

    public static int yt(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1851077871:
                if (str.equals("video/dolby-vision")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1662735862:
                if (str.equals("video/av01")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 5;
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 1;
            case 4:
                return 2;
            default:
                return 0;
        }
    }

    @Override // zo.fh
    /* renamed from: b */
    public gv v() {
        gv gvVar;
        synchronized (this.f15782gv) {
            gvVar = this.f15784s;
        }
        return gvVar;
    }

    @Nullable
    public Pair<co.y, Integer> ct(r.y yVar, int[][][] iArr, final int[] iArr2, final gv gvVar) throws m1.p {
        return dm(2, yVar, iArr, new s.y() { // from class: zo.a
            @Override // zo.tl.s.y
            public final List y(int i, rs rsVar, int[] iArr3) {
                List j2;
                j2 = tl.j(tl.gv.this, iArr2, i, rsVar, iArr3);
                return j2;
            }
        }, new Comparator() { // from class: zo.fb
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return tl.c5.fb((List) obj, (List) obj2);
            }
        });
    }

    @Nullable
    public final <T extends s<T>> Pair<co.y, Integer> dm(int i, r.y yVar, int[][][] iArr, s.y<T> yVar2, Comparator<List<T>> comparator) {
        int i5;
        RandomAccess randomAccess;
        r.y yVar3 = yVar;
        ArrayList arrayList = new ArrayList();
        int gv2 = yVar.gv();
        int i6 = 0;
        while (i6 < gv2) {
            if (i == yVar3.v(i6)) {
                lc a2 = yVar3.a(i6);
                for (int i8 = 0; i8 < a2.y; i8++) {
                    rs n32 = a2.n3(i8);
                    List<T> y2 = yVar2.y(i6, n32, iArr[i6][i8]);
                    boolean[] zArr = new boolean[n32.y];
                    int i10 = 0;
                    while (i10 < n32.y) {
                        T t2 = y2.get(i10);
                        int y7 = t2.y();
                        if (zArr[i10] || y7 == 0) {
                            i5 = gv2;
                        } else {
                            if (y7 == 1) {
                                randomAccess = z0.x4.o(t2);
                                i5 = gv2;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(t2);
                                int i11 = i10 + 1;
                                while (i11 < n32.y) {
                                    T t3 = y2.get(i11);
                                    int i12 = gv2;
                                    if (t3.y() == 2 && t2.n3(t3)) {
                                        arrayList2.add(t3);
                                        zArr[i11] = true;
                                    }
                                    i11++;
                                    gv2 = i12;
                                }
                                i5 = gv2;
                                randomAccess = arrayList2;
                            }
                            arrayList.add(randomAccess);
                        }
                        i10++;
                        gv2 = i5;
                    }
                }
            }
            i6++;
            yVar3 = yVar;
            gv2 = gv2;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i13 = 0; i13 < list.size(); i13++) {
            iArr2[i13] = ((s) list.get(i13)).f15879fb;
        }
        s sVar = (s) list.get(0);
        return Pair.create(new co.y(sVar.f15881v, iArr2), Integer.valueOf(sVar.y));
    }

    @Override // zo.fh
    public void i9() {
        a aVar;
        synchronized (this.f15782gv) {
            try {
                if (j5.y >= 32 && (aVar = this.f15780c5) != null) {
                    aVar.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        super.i9();
    }

    public co.y[] jz(r.y yVar, int[][][] iArr, int[] iArr2, gv gvVar) throws m1.p {
        String str;
        int gv2 = yVar.gv();
        co.y[] yVarArr = new co.y[gv2];
        Pair<co.y, Integer> ct2 = ct(yVar, iArr, iArr2, gvVar);
        if (ct2 != null) {
            yVarArr[((Integer) ct2.second).intValue()] = (co.y) ct2.first;
        }
        Pair<co.y, Integer> u2 = u(yVar, iArr, iArr2, gvVar);
        if (u2 != null) {
            yVarArr[((Integer) u2.second).intValue()] = (co.y) u2.first;
        }
        if (u2 == null) {
            str = null;
        } else {
            Object obj = u2.first;
            str = ((co.y) obj).y.zn(((co.y) obj).f15756n3[0]).f10950fb;
        }
        Pair<co.y, Integer> xg2 = xg(yVar, iArr, gvVar, str);
        if (xg2 != null) {
            yVarArr[((Integer) xg2.second).intValue()] = (co.y) xg2.first;
        }
        for (int i = 0; i < gv2; i++) {
            int v2 = yVar.v(i);
            if (v2 != 2 && v2 != 1 && v2 != 3) {
                yVarArr[i] = y5(v2, yVar.a(i), iArr[i], gvVar);
            }
        }
        return yVarArr;
    }

    public final void k() {
        boolean z2;
        a aVar;
        synchronized (this.f15782gv) {
            try {
                if (this.f15784s.f15841qk && !this.f15781fb && j5.y >= 32 && (aVar = this.f15780c5) != null && aVar.v()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            fb();
        }
    }

    @Override // zo.r
    public final Pair<ic[], co[]> mt(r.y yVar, int[][][] iArr, int[] iArr2, mg.n3 n3Var, hy hyVar) throws m1.p {
        gv gvVar;
        ic icVar;
        a aVar;
        synchronized (this.f15782gv) {
            try {
                gvVar = this.f15784s;
                if (gvVar.f15841qk && j5.y >= 32 && (aVar = this.f15780c5) != null) {
                    aVar.n3(this, (Looper) v5.y.c5(Looper.myLooper()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int gv2 = yVar.gv();
        co.y[] jz2 = jz(yVar, iArr, iArr2, gvVar);
        d(yVar, gvVar, jz2);
        ta(yVar, gvVar, jz2);
        for (int i = 0; i < gv2; i++) {
            int v2 = yVar.v(i);
            if (gvVar.b(i) || gvVar.f15726ut.contains(Integer.valueOf(v2))) {
                jz2[i] = null;
            }
        }
        co[] y2 = this.f15779a.y(jz2, gv(), n3Var, hyVar);
        ic[] icVarArr = new ic[gv2];
        for (int i5 = 0; i5 < gv2; i5++) {
            int v3 = yVar.v(i5);
            if (!gvVar.b(i5) && !gvVar.f15726ut.contains(Integer.valueOf(v3)) && (yVar.v(i5) == -2 || y2[i5] != null)) {
                icVar = ic.f10873n3;
            } else {
                icVar = null;
            }
            icVarArr[i5] = icVar;
        }
        if (gvVar.f15835l) {
            q9(yVar, iArr, icVarArr, y2);
        }
        return Pair.create(icVarArr, y2);
    }

    public void o4(gv.y yVar) {
        rs(yVar.d0());
    }

    public final /* synthetic */ List qn(gv gvVar, boolean z2, int i, rs rsVar, int[] iArr) {
        return n3.v(i, rsVar, gvVar, iArr, z2, new w0.w() { // from class: zo.t
            @Override // w0.w
            public final boolean apply(Object obj) {
                boolean vl2;
                vl2 = tl.this.vl((m) obj);
                return vl2;
            }
        });
    }

    public final void rs(gv gvVar) {
        boolean equals;
        v5.y.v(gvVar);
        synchronized (this.f15782gv) {
            equals = this.f15784s.equals(gvVar);
            this.f15784s = gvVar;
        }
        if (!equals) {
            if (gvVar.f15841qk && this.f15785v == null) {
                v5.r.c5("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            fb();
        }
    }

    @Override // zo.fh
    public boolean s() {
        return true;
    }

    @Override // zo.fh
    public void t(d9.v vVar) {
        boolean equals;
        synchronized (this.f15782gv) {
            equals = this.f15783i9.equals(vVar);
            this.f15783i9 = vVar;
        }
        if (!equals) {
            k();
        }
    }

    @Override // zo.fh
    public void tl(c cVar) {
        if (cVar instanceof gv) {
            rs((gv) cVar);
        }
        rs(new gv.y().nf(cVar).d0());
    }

    @Nullable
    public Pair<co.y, Integer> u(r.y yVar, int[][][] iArr, int[] iArr2, final gv gvVar) throws m1.p {
        final boolean z2 = false;
        int i = 0;
        while (true) {
            if (i < yVar.gv()) {
                if (2 == yVar.v(i) && yVar.a(i).y > 0) {
                    z2 = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return dm(1, yVar, iArr, new s.y() { // from class: zo.s
            @Override // zo.tl.s.y
            public final List y(int i5, rs rsVar, int[] iArr3) {
                List qn2;
                qn2 = tl.this.qn(gvVar, z2, i5, rsVar, iArr3);
                return qn2;
            }
        }, new Comparator() { // from class: zo.c5
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return tl.n3.zn((List) obj, (List) obj2);
            }
        });
    }

    public final boolean vl(m mVar) {
        boolean z2;
        a aVar;
        a aVar2;
        synchronized (this.f15782gv) {
            try {
                if (this.f15784s.f15841qk) {
                    if (!this.f15781fb) {
                        if (mVar.f10958oz > 2) {
                            if (hw(mVar)) {
                                if (j5.y >= 32 && (aVar2 = this.f15780c5) != null && aVar2.v()) {
                                }
                            }
                            if (j5.y < 32 || (aVar = this.f15780c5) == null || !aVar.v() || !this.f15780c5.zn() || !this.f15780c5.gv() || !this.f15780c5.y(this.f15783i9, mVar)) {
                                z2 = false;
                            }
                        }
                    }
                }
                z2 = true;
            } finally {
            }
        }
        return z2;
    }

    @Nullable
    public Pair<co.y, Integer> xg(r.y yVar, int[][][] iArr, final gv gvVar, @Nullable final String str) throws m1.p {
        return dm(3, yVar, iArr, new s.y() { // from class: zo.i9
            @Override // zo.tl.s.y
            public final List y(int i, rs rsVar, int[] iArr2) {
                List o2;
                o2 = tl.o(tl.gv.this, str, i, rsVar, iArr2);
                return o2;
            }
        }, new Comparator() { // from class: zo.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return tl.fb.zn((List) obj, (List) obj2);
            }
        });
    }

    @Nullable
    public co.y y5(int i, lc lcVar, int[][] iArr, gv gvVar) throws m1.p {
        rs rsVar = null;
        zn znVar = null;
        int i5 = 0;
        for (int i6 = 0; i6 < lcVar.y; i6++) {
            rs n32 = lcVar.n3(i6);
            int[] iArr2 = iArr[i6];
            for (int i8 = 0; i8 < n32.y; i8++) {
                if (j5(iArr2[i8], gvVar.f15840qj)) {
                    zn znVar2 = new zn(n32.zn(i8), iArr2[i8]);
                    if (znVar == null || znVar2.compareTo(znVar) > 0) {
                        rsVar = n32;
                        i5 = i8;
                        znVar = znVar2;
                    }
                }
            }
        }
        if (rsVar == null) {
            return null;
        }
        return new co.y(rsVar, i5);
    }

    public gv.y z6() {
        return v().d0();
    }

    public tl(Context context, co.n3 n3Var) {
        this(context, gv.a8(context), n3Var);
    }

    public tl(Context context, c cVar) {
        this(context, cVar, new y.n3());
    }

    @Deprecated
    public tl(c cVar, co.n3 n3Var) {
        this(cVar, n3Var, (Context) null);
    }

    public tl(Context context, c cVar, co.n3 n3Var) {
        this(cVar, n3Var, context);
    }

    public tl(c cVar, co.n3 n3Var, @Nullable Context context) {
        this.f15782gv = new Object();
        this.f15785v = context != null ? context.getApplicationContext() : null;
        this.f15779a = n3Var;
        if (cVar instanceof gv) {
            this.f15784s = (gv) cVar;
        } else {
            this.f15784s = (context == null ? gv.f15827w9 : gv.a8(context)).d0().nf(cVar).d0();
        }
        this.f15783i9 = d9.v.f7204w;
        boolean z2 = context != null && j5.tg(context);
        this.f15781fb = z2;
        if (!z2 && context != null && j5.y >= 32) {
            this.f15780c5 = a.fb(context);
        }
        if (this.f15784s.f15841qk && context == null) {
            v5.r.c5("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }
}
