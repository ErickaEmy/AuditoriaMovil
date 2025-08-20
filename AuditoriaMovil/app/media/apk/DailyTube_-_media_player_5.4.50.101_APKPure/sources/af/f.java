package af;

import af.mg;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m1.hy;
import m1.o0;
/* loaded from: classes.dex */
public final class f extends fb<v> {

    /* renamed from: o  reason: collision with root package name */
    public static final o0 f159o = new o0.zn().s(Uri.EMPTY).y();

    /* renamed from: b  reason: collision with root package name */
    public boolean f160b;

    /* renamed from: c  reason: collision with root package name */
    public final List<v> f161c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<v> f162d;

    /* renamed from: d0  reason: collision with root package name */
    public final IdentityHashMap<d0, v> f163d0;

    /* renamed from: ej  reason: collision with root package name */
    public final boolean f164ej;

    /* renamed from: f3  reason: collision with root package name */
    public final Set<gv> f165f3;

    /* renamed from: fh  reason: collision with root package name */
    public final Map<Object, v> f166fh;

    /* renamed from: j5  reason: collision with root package name */
    public Set<gv> f167j5;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public Handler f168n;

    /* renamed from: qn  reason: collision with root package name */
    public u f169qn;

    /* renamed from: r  reason: collision with root package name */
    public final List<v> f170r;

    /* renamed from: x  reason: collision with root package name */
    public final boolean f171x;

    /* loaded from: classes.dex */
    public static final class a<T> {

        /* renamed from: n3  reason: collision with root package name */
        public final T f172n3;
        public final int y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public final gv f173zn;

        public a(int i, T t2, @Nullable gv gvVar) {
            this.y = i;
            this.f172n3 = t2;
            this.f173zn = gvVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: n3  reason: collision with root package name */
        public final Runnable f174n3;
        public final Handler y;

        public gv(Handler handler, Runnable runnable) {
            this.y = handler;
            this.f174n3 = runnable;
        }

        public void y() {
            this.y.post(this.f174n3);
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 extends m1.y {

        /* renamed from: c  reason: collision with root package name */
        public final Object[] f175c;

        /* renamed from: co  reason: collision with root package name */
        public final int f176co;

        /* renamed from: d0  reason: collision with root package name */
        public final HashMap<Object, Integer> f177d0;

        /* renamed from: f3  reason: collision with root package name */
        public final int[] f178f3;

        /* renamed from: n  reason: collision with root package name */
        public final hy[] f179n;

        /* renamed from: r  reason: collision with root package name */
        public final int[] f180r;

        /* renamed from: z  reason: collision with root package name */
        public final int f181z;

        public n3(Collection<v> collection, u uVar, boolean z2) {
            super(z2, uVar);
            int size = collection.size();
            this.f180r = new int[size];
            this.f178f3 = new int[size];
            this.f179n = new hy[size];
            this.f175c = new Object[size];
            this.f177d0 = new HashMap<>();
            int i = 0;
            int i5 = 0;
            int i6 = 0;
            for (v vVar : collection) {
                this.f179n[i6] = vVar.y.vp();
                this.f178f3[i6] = i;
                this.f180r[i6] = i5;
                i += this.f179n[i6].z();
                i5 += this.f179n[i6].tl();
                Object[] objArr = this.f175c;
                Object obj = vVar.f184n3;
                objArr[i6] = obj;
                this.f177d0.put(obj, Integer.valueOf(i6));
                i6++;
            }
            this.f176co = i;
            this.f181z = i5;
        }

        @Override // m1.y
        public hy ej(int i) {
            return this.f179n[i];
        }

        @Override // m1.y
        public int f3(int i) {
            return v5.j5.s(this.f180r, i + 1, false, false);
        }

        @Override // m1.y
        public Object fh(int i) {
            return this.f175c[i];
        }

        @Override // m1.y
        public int i4(Object obj) {
            Integer num = this.f177d0.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // m1.y
        public int mg(int i) {
            return this.f180r[i];
        }

        @Override // m1.y
        public int n(int i) {
            return v5.j5.s(this.f178f3, i + 1, false, false);
        }

        @Override // m1.y
        public int ta(int i) {
            return this.f178f3[i];
        }

        @Override // m1.hy
        public int tl() {
            return this.f181z;
        }

        @Override // m1.hy
        public int z() {
            return this.f176co;
        }
    }

    /* loaded from: classes.dex */
    public static final class v {

        /* renamed from: a  reason: collision with root package name */
        public boolean f182a;

        /* renamed from: gv  reason: collision with root package name */
        public int f183gv;

        /* renamed from: v  reason: collision with root package name */
        public int f185v;
        public final n y;

        /* renamed from: zn  reason: collision with root package name */
        public final List<mg.n3> f186zn = new ArrayList();

        /* renamed from: n3  reason: collision with root package name */
        public final Object f184n3 = new Object();

        public v(mg mgVar, boolean z2) {
            this.y = new n(mgVar, z2);
        }

        public void y(int i, int i5) {
            this.f183gv = i;
            this.f185v = i5;
            this.f182a = false;
            this.f186zn.clear();
        }
    }

    public f(boolean z2, u uVar, mg... mgVarArr) {
        this(z2, false, uVar, mgVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cs(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                l((Set) v5.j5.i9(message.obj));
                            } else {
                                throw new IllegalStateException();
                            }
                        } else {
                            fc();
                        }
                    } else {
                        a aVar = (a) v5.j5.i9(message.obj);
                        this.f169qn = (u) aVar.f172n3;
                        gf(aVar.f173zn);
                    }
                } else {
                    a aVar2 = (a) v5.j5.i9(message.obj);
                    u uVar = this.f169qn;
                    int i5 = aVar2.y;
                    u co2 = uVar.co(i5, i5 + 1);
                    this.f169qn = co2;
                    this.f169qn = co2.f3(((Integer) aVar2.f172n3).intValue(), 1);
                    yk(aVar2.y, ((Integer) aVar2.f172n3).intValue());
                    gf(aVar2.f173zn);
                }
            } else {
                a aVar3 = (a) v5.j5.i9(message.obj);
                int i6 = aVar3.y;
                int intValue = ((Integer) aVar3.f172n3).intValue();
                if (i6 == 0 && intValue == this.f169qn.getLength()) {
                    this.f169qn = this.f169qn.x4();
                } else {
                    this.f169qn = this.f169qn.co(i6, intValue);
                }
                for (int i8 = intValue - 1; i8 >= i6; i8--) {
                    ne(i8);
                }
                gf(aVar3.f173zn);
            }
        } else {
            a aVar4 = (a) v5.j5.i9(message.obj);
            this.f169qn = this.f169qn.f3(aVar4.y, ((Collection) aVar4.f172n3).size());
            wf(aVar4.y, (Collection) aVar4.f172n3);
            gf(aVar4.f173zn);
        }
        return true;
    }

    public static Object vp(Object obj) {
        return m1.y.c(obj);
    }

    public static Object w2(Object obj) {
        return m1.y.d0(obj);
    }

    public static Object x5(v vVar, Object obj) {
        return m1.y.rz(vVar.f184n3, obj);
    }

    public final void ad(int i, Collection<mg> collection, @Nullable Handler handler, @Nullable Runnable runnable) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (handler == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (runnable == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 != z3) {
            z4 = false;
        }
        v5.y.y(z4);
        Handler handler2 = this.f168n;
        for (mg mgVar : collection) {
            v5.y.v(mgVar);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (mg mgVar2 : collection) {
            arrayList.add(new v(mgVar2, this.f171x));
        }
        this.f170r.addAll(i, arrayList);
        if (handler2 != null && !collection.isEmpty()) {
            handler2.obtainMessage(0, new a(i, arrayList, qk(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    @Override // af.fb, af.y
    public synchronized void ap() {
        try {
            super.ap();
            this.f161c.clear();
            this.f162d.clear();
            this.f166fh.clear();
            this.f169qn = this.f169qn.x4();
            Handler handler = this.f168n;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f168n = null;
            }
            this.f160b = false;
            this.f167j5.clear();
            l(this.f165f3);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void bv(v vVar, hy hyVar) {
        int z2;
        if (vVar.f183gv + 1 < this.f161c.size() && (z2 = hyVar.z() - (this.f161c.get(vVar.f183gv + 1).f185v - vVar.f185v)) != 0) {
            cy(vVar.f183gv + 1, 0, z2);
        }
        nd();
    }

    @Override // af.mg
    public o0 c() {
        return f159o;
    }

    public final void cr(int i, v vVar) {
        if (i > 0) {
            v vVar2 = this.f161c.get(i - 1);
            vVar.y(i, vVar2.f185v + vVar2.y.vp().z());
        } else {
            vVar.y(i, 0);
        }
        cy(i, 1, vVar.y.vp().z());
        this.f161c.add(i, vVar);
        this.f166fh.put(vVar.f184n3, vVar);
        bk(vVar, vVar.y);
        if (ra() && this.f163d0.isEmpty()) {
            this.f162d.add(vVar);
        } else {
            yc(vVar);
        }
    }

    public final void cy(int i, int i5, int i6) {
        while (i < this.f161c.size()) {
            v vVar = this.f161c.get(i);
            vVar.f183gv += i5;
            vVar.f185v += i6;
            i++;
        }
    }

    @Override // af.fb, af.y
    public synchronized void e(@Nullable kx.o oVar) {
        try {
            super.e(oVar);
            this.f168n = new Handler(new Handler.Callback() { // from class: af.i9
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    boolean cs2;
                    cs2 = f.this.cs(message);
                    return cs2;
                }
            });
            if (this.f170r.isEmpty()) {
                fc();
            } else {
                this.f169qn = this.f169qn.f3(0, this.f170r.size());
                wf(0, this.f170r);
                nd();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // af.fb, af.y
    public void eb() {
        super.eb();
        this.f162d.clear();
    }

    @Override // af.mg
    public d0 f7(mg.n3 n3Var, kx.n3 n3Var2, long j2) {
        Object w22 = w2(n3Var.y);
        mg.n3 zn2 = n3Var.zn(vp(n3Var.y));
        v vVar = this.f166fh.get(w22);
        if (vVar == null) {
            vVar = new v(new zn(), this.f171x);
            vVar.f182a = true;
            bk(vVar, vVar.y);
        }
        gq(vVar);
        vVar.f186zn.add(zn2);
        f3 f72 = vVar.y.f7(zn2, n3Var2, j2);
        this.f163d0.put(f72, vVar);
        qj();
        return f72;
    }

    public final void fc() {
        this.f160b = false;
        Set<gv> set = this.f167j5;
        this.f167j5 = new HashSet();
        s8(new n3(this.f161c, this.f169qn, this.f164ej));
        q5().obtainMessage(5, set).sendToTarget();
    }

    public final void gf(@Nullable gv gvVar) {
        if (!this.f160b) {
            q5().obtainMessage(4).sendToTarget();
            this.f160b = true;
        }
        if (gvVar != null) {
            this.f167j5.add(gvVar);
        }
    }

    public final void gq(v vVar) {
        this.f162d.add(vVar);
        kp(vVar);
    }

    public final void i2(int i, int i5, @Nullable Handler handler, @Nullable Runnable runnable) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (handler == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (runnable == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 == z3) {
            z4 = true;
        }
        v5.y.y(z4);
        Handler handler2 = this.f168n;
        List<v> list = this.f170r;
        list.add(i5, list.remove(i));
        if (handler2 != null) {
            handler2.obtainMessage(2, new a(i, Integer.valueOf(i5), qk(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    @Override // af.fb
    /* renamed from: i3 */
    public void u0(v vVar, mg mgVar, hy hyVar) {
        bv(vVar, hyVar);
    }

    public synchronized void ix(int i, int i5) {
        i2(i, i5, null, null);
    }

    public synchronized mg j3(int i, Handler handler, Runnable runnable) {
        mg w92;
        w92 = w9(i);
        wm(i, i + 1, handler, runnable);
        return w92;
    }

    @Override // af.y, af.mg
    public synchronized hy k() {
        u uVar;
        try {
            if (this.f169qn.getLength() != this.f170r.size()) {
                uVar = this.f169qn.x4().f3(0, this.f170r.size());
            } else {
                uVar = this.f169qn;
            }
        } catch (Throwable th) {
            throw th;
        }
        return new n3(this.f170r, uVar, this.f164ej);
    }

    public final synchronized void l(Set<gv> set) {
        try {
            for (gv gvVar : set) {
                gvVar.y();
            }
            this.f165f3.removeAll(set);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // af.fb
    /* renamed from: le */
    public int m(v vVar, int i) {
        return i + vVar.f185v;
    }

    public synchronized int mp() {
        return this.f170r.size();
    }

    public final void nd() {
        gf(null);
    }

    public final void ne(int i) {
        v remove = this.f161c.remove(i);
        this.f166fh.remove(remove.f184n3);
        cy(i, -1, -remove.y.vp().z());
        remove.f182a = true;
        ro(remove);
    }

    public synchronized void o0(int i, Collection<mg> collection) {
        ad(i, collection, null, null);
    }

    @Override // af.fb
    @Nullable
    /* renamed from: oa */
    public mg.n3 rb(v vVar, mg.n3 n3Var) {
        for (int i = 0; i < vVar.f186zn.size(); i++) {
            if (vVar.f186zn.get(i).f238gv == n3Var.f238gv) {
                return n3Var.zn(x5(vVar, n3Var.y));
            }
        }
        return null;
    }

    public synchronized void pq(int i, mg mgVar) {
        ad(i, Collections.singletonList(mgVar), null, null);
    }

    public synchronized void q(int i, int i5) {
        wm(i, i5, null, null);
    }

    public final Handler q5() {
        return (Handler) v5.y.v(this.f168n);
    }

    @Override // af.y, af.mg
    public boolean q9() {
        return false;
    }

    public final void qj() {
        Iterator<v> it = this.f162d.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next.f186zn.isEmpty()) {
                yc(next);
                it.remove();
            }
        }
    }

    @Nullable
    public final gv qk(@Nullable Handler handler, @Nullable Runnable runnable) {
        if (handler != null && runnable != null) {
            gv gvVar = new gv(handler, runnable);
            this.f165f3.add(gvVar);
            return gvVar;
        }
        return null;
    }

    public final void ro(v vVar) {
        if (vVar.f182a && vVar.f186zn.isEmpty()) {
            this.f162d.remove(vVar);
            y4(vVar);
        }
    }

    @Override // af.mg
    public void u(d0 d0Var) {
        v vVar = (v) v5.y.v(this.f163d0.remove(d0Var));
        vVar.y.u(d0Var);
        vVar.f186zn.remove(((f3) d0Var).y);
        if (!this.f163d0.isEmpty()) {
            qj();
        }
        ro(vVar);
    }

    public synchronized mg vn(int i) {
        mg w92;
        w92 = w9(i);
        wm(i, i + 1, null, null);
        return w92;
    }

    public synchronized mg w9(int i) {
        return this.f170r.get(i).y;
    }

    public final void wf(int i, Collection<v> collection) {
        for (v vVar : collection) {
            cr(i, vVar);
            i++;
        }
    }

    public final void wm(int i, int i5, @Nullable Handler handler, @Nullable Runnable runnable) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (handler == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (runnable == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 == z3) {
            z4 = true;
        }
        v5.y.y(z4);
        Handler handler2 = this.f168n;
        v5.j5.w2(this.f170r, i, i5);
        if (handler2 != null) {
            handler2.obtainMessage(1, new a(i, Integer.valueOf(i5), qk(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    public synchronized void xb(Collection<mg> collection) {
        ad(this.f170r.size(), collection, null, null);
    }

    public final void yk(int i, int i5) {
        int min = Math.min(i, i5);
        int max = Math.max(i, i5);
        int i6 = this.f161c.get(min).f185v;
        List<v> list = this.f161c;
        list.add(i5, list.remove(i));
        while (min <= max) {
            v vVar = this.f161c.get(min);
            vVar.f183gv = min;
            vVar.f185v = i6;
            i6 += vVar.y.vp().z();
            min++;
        }
    }

    public f(boolean z2, boolean z3, u uVar, mg... mgVarArr) {
        for (mg mgVar : mgVarArr) {
            v5.y.v(mgVar);
        }
        this.f169qn = uVar.getLength() > 0 ? uVar.x4() : uVar;
        this.f163d0 = new IdentityHashMap<>();
        this.f166fh = new HashMap();
        this.f170r = new ArrayList();
        this.f161c = new ArrayList();
        this.f167j5 = new HashSet();
        this.f165f3 = new HashSet();
        this.f162d = new HashSet();
        this.f164ej = z2;
        this.f171x = z3;
        xb(Arrays.asList(mgVarArr));
    }

    /* loaded from: classes.dex */
    public static final class zn extends af.y {
        public zn() {
        }

        @Override // af.mg
        public o0 c() {
            return f.f159o;
        }

        @Override // af.mg
        public d0 f7(mg.n3 n3Var, kx.n3 n3Var2, long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // af.y
        public void ap() {
        }

        @Override // af.mg
        public void ut() {
        }

        @Override // af.y
        public void e(@Nullable kx.o oVar) {
        }

        @Override // af.mg
        public void u(d0 d0Var) {
        }
    }

    @Override // af.fb, af.y
    public void lc() {
    }
}
