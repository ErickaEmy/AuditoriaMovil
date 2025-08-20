package e4;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import m1.m;
import v5.k5;
/* loaded from: classes.dex */
public final class c5 implements mt {

    /* renamed from: a  reason: collision with root package name */
    public int f7462a;

    /* renamed from: c5  reason: collision with root package name */
    public int f7463c5;

    /* renamed from: fb  reason: collision with root package name */
    public int f7465fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f7466gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f7467i9;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f7468n3;

    /* renamed from: s  reason: collision with root package name */
    public int f7469s;

    /* renamed from: t  reason: collision with root package name */
    public int f7470t;

    /* renamed from: v  reason: collision with root package name */
    public int f7472v;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f7474zn;

    /* renamed from: xc  reason: collision with root package name */
    public static final int[] f7461xc = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};

    /* renamed from: w  reason: collision with root package name */
    public static final y f7460w = new y(new y.InterfaceC0088y() { // from class: e4.fb
        @Override // e4.c5.y.InterfaceC0088y
        public final Constructor y() {
            Constructor v2;
            v2 = c5.v();
            return v2;
        }
    });

    /* renamed from: p  reason: collision with root package name */
    public static final y f7459p = new y(new y.InterfaceC0088y() { // from class: e4.s
        @Override // e4.c5.y.InterfaceC0088y
        public final Constructor y() {
            Constructor a2;
            a2 = c5.a();
            return a2;
        }
    });

    /* renamed from: f  reason: collision with root package name */
    public int f7464f = 1;

    /* renamed from: wz  reason: collision with root package name */
    public int f7473wz = 112800;

    /* renamed from: tl  reason: collision with root package name */
    public z0.x4<m> f7471tl = z0.x4.j5();

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final AtomicBoolean f7475n3 = new AtomicBoolean(false);
        public final InterfaceC0088y y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public Constructor<? extends t> f7476zn;

        /* renamed from: e4.c5$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0088y {
            @Nullable
            Constructor<? extends t> y() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException;
        }

        public y(InterfaceC0088y interfaceC0088y) {
            this.y = interfaceC0088y;
        }

        @Nullable
        public final Constructor<? extends t> n3() {
            synchronized (this.f7475n3) {
                if (this.f7475n3.get()) {
                    return this.f7476zn;
                }
                try {
                    return this.y.y();
                } catch (ClassNotFoundException unused) {
                    this.f7475n3.set(true);
                    return this.f7476zn;
                } catch (Exception e2) {
                    throw new RuntimeException("Error instantiating extension", e2);
                }
            }
        }

        @Nullable
        public t y(Object... objArr) {
            Constructor<? extends t> n32 = n3();
            if (n32 == null) {
                return null;
            }
            try {
                return n32.newInstance(objArr);
            } catch (Exception e2) {
                throw new IllegalStateException("Unexpected error creating extractor", e2);
            }
        }
    }

    public static Constructor<? extends t> a() throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(t.class).getConstructor(null);
    }

    @Nullable
    public static Constructor<? extends t> v() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (!Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
            return null;
        }
        return Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(t.class).getConstructor(Integer.TYPE);
    }

    @Override // e4.mt
    public synchronized t[] createExtractors() {
        return y(Uri.EMPTY, new HashMap());
    }

    public final void gv(int i, List<t> list) {
        int i5 = 2;
        switch (i) {
            case 0:
                list.add(new y3.n3());
                return;
            case 1:
                list.add(new y3.v());
                return;
            case 2:
                int i6 = this.f7466gv | (this.f7468n3 ? 1 : 0);
                if (!this.f7474zn) {
                    i5 = 0;
                }
                list.add(new y3.s(i5 | i6));
                return;
            case 3:
                int i8 = this.f7472v | (this.f7468n3 ? 1 : 0);
                if (!this.f7474zn) {
                    i5 = 0;
                }
                list.add(new ku.n3(i5 | i8));
                return;
            case 4:
                t y2 = f7460w.y(Integer.valueOf(this.f7462a));
                if (y2 != null) {
                    list.add(y2);
                    return;
                } else {
                    list.add(new tq.gv(this.f7462a));
                    return;
                }
            case 5:
                list.add(new qx.zn());
                return;
            case 6:
                list.add(new sc.v(this.f7465fb));
                return;
            case 7:
                int i10 = this.f7467i9 | (this.f7468n3 ? 1 : 0);
                if (!this.f7474zn) {
                    i5 = 0;
                }
                list.add(new x1.a(i5 | i10));
                return;
            case 8:
                list.add(new ha.fb(this.f7463c5));
                list.add(new ha.f(this.f7469s));
                return;
            case 9:
                list.add(new mv.gv());
                return;
            case 10:
                list.add(new y3.d0());
                return;
            case 11:
                list.add(new y3.ej(this.f7464f, new k5(0L), new y3.i9(this.f7470t, this.f7471tl), this.f7473wz));
                return;
            case 12:
                list.add(new n6.n3());
                return;
            case 13:
            default:
                return;
            case 14:
                list.add(new p0.y());
                return;
            case 15:
                t y7 = f7459p.y(new Object[0]);
                if (y7 != null) {
                    list.add(y7);
                    return;
                }
                return;
            case 16:
                list.add(new ek.n3());
                return;
        }
    }

    @Override // e4.mt
    public synchronized t[] y(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        try {
            int[] iArr = f7461xc;
            arrayList = new ArrayList(iArr.length);
            int n32 = v5.tl.n3(map);
            if (n32 != -1) {
                gv(n32, arrayList);
            }
            int zn2 = v5.tl.zn(uri);
            if (zn2 != -1 && zn2 != n32) {
                gv(zn2, arrayList);
            }
            for (int i : iArr) {
                if (i != n32 && i != zn2) {
                    gv(i, arrayList);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (t[]) arrayList.toArray(new t[arrayList.size()]);
    }
}
