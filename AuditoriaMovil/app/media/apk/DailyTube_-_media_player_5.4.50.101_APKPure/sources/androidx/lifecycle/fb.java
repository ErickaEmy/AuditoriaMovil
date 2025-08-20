package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import y5.co;
import y5.mt;
/* loaded from: classes.dex */
public class fb extends v {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2621a;

    /* renamed from: c5  reason: collision with root package name */
    public final boolean f2622c5;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f2623fb;

    /* renamed from: gv  reason: collision with root package name */
    public final WeakReference<co> f2624gv;

    /* renamed from: n3  reason: collision with root package name */
    public w.y<mt, y> f2625n3;

    /* renamed from: s  reason: collision with root package name */
    public ArrayList<v.zn> f2626s;

    /* renamed from: v  reason: collision with root package name */
    public int f2627v;

    /* renamed from: zn  reason: collision with root package name */
    public v.zn f2628zn;

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: n3  reason: collision with root package name */
        public a f2629n3;
        public v.zn y;

        public y(mt mtVar, v.zn znVar) {
            this.f2629n3 = s.a(mtVar);
            this.y = znVar;
        }

        public void y(co coVar, v.n3 n3Var) {
            v.zn gv2 = n3Var.gv();
            this.y = fb.f(this.y, gv2);
            this.f2629n3.onStateChanged(coVar, n3Var);
            this.y = gv2;
        }
    }

    public fb(@NonNull co coVar) {
        this(coVar, true);
    }

    public static v.zn f(@NonNull v.zn znVar, @Nullable v.zn znVar2) {
        if (znVar2 != null && znVar2.compareTo(znVar) < 0) {
            return znVar2;
        }
        return znVar;
    }

    @SuppressLint({"RestrictedApi"})
    public final void a(String str) {
        if (this.f2622c5 && !xc.y.a().zn()) {
            throw new IllegalStateException("Method " + str + " must be called on the main thread");
        }
    }

    public final boolean c5() {
        if (this.f2625n3.size() == 0) {
            return true;
        }
        v.zn znVar = this.f2625n3.y().getValue().y;
        v.zn znVar2 = this.f2625n3.gv().getValue().y;
        if (znVar == znVar2 && this.f2628zn == znVar2) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void fb(co coVar) {
        w.n3<mt, y>.gv zn2 = this.f2625n3.zn();
        while (zn2.hasNext() && !this.f2623fb) {
            Map.Entry next = zn2.next();
            y yVar = (y) next.getValue();
            while (yVar.y.compareTo(this.f2628zn) < 0 && !this.f2623fb && this.f2625n3.contains(next.getKey())) {
                wz(yVar.y);
                v.n3 v2 = v.n3.v(yVar.y);
                if (v2 != null) {
                    yVar.y(coVar, v2);
                    tl();
                } else {
                    throw new IllegalStateException("no event up from " + yVar.y);
                }
            }
        }
    }

    public final void gv(co coVar) {
        Iterator<Map.Entry<mt, y>> descendingIterator = this.f2625n3.descendingIterator();
        while (descendingIterator.hasNext() && !this.f2623fb) {
            Map.Entry<mt, y> next = descendingIterator.next();
            y value = next.getValue();
            while (value.y.compareTo(this.f2628zn) > 0 && !this.f2623fb && this.f2625n3.contains(next.getKey())) {
                v.n3 y2 = v.n3.y(value.y);
                if (y2 != null) {
                    wz(y2.gv());
                    value.y(coVar, y2);
                    tl();
                } else {
                    throw new IllegalStateException("no event down from " + value.y);
                }
            }
        }
    }

    @Deprecated
    public void i9(@NonNull v.zn znVar) {
        a("markState");
        xc(znVar);
    }

    @Override // androidx.lifecycle.v
    @NonNull
    public v.zn n3() {
        return this.f2628zn;
    }

    public void s(@NonNull v.n3 n3Var) {
        a("handleLifecycleEvent");
        t(n3Var.gv());
    }

    public final void t(v.zn znVar) {
        if (this.f2628zn == znVar) {
            return;
        }
        this.f2628zn = znVar;
        if (!this.f2621a && this.f2627v == 0) {
            this.f2621a = true;
            w();
            this.f2621a = false;
            return;
        }
        this.f2623fb = true;
    }

    public final void tl() {
        ArrayList<v.zn> arrayList = this.f2626s;
        arrayList.remove(arrayList.size() - 1);
    }

    public final v.zn v(mt mtVar) {
        v.zn znVar;
        ArrayList<v.zn> arrayList;
        Map.Entry<mt, y> c52 = this.f2625n3.c5(mtVar);
        v.zn znVar2 = null;
        if (c52 != null) {
            znVar = c52.getValue().y;
        } else {
            znVar = null;
        }
        if (!this.f2626s.isEmpty()) {
            znVar2 = this.f2626s.get(arrayList.size() - 1);
        }
        return f(f(this.f2628zn, znVar), znVar2);
    }

    public final void w() {
        co coVar = this.f2624gv.get();
        if (coVar != null) {
            while (!c5()) {
                this.f2623fb = false;
                if (this.f2628zn.compareTo(this.f2625n3.y().getValue().y) < 0) {
                    gv(coVar);
                }
                Map.Entry<mt, y> gv2 = this.f2625n3.gv();
                if (!this.f2623fb && gv2 != null && this.f2628zn.compareTo(gv2.getValue().y) > 0) {
                    fb(coVar);
                }
            }
            this.f2623fb = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    public final void wz(v.zn znVar) {
        this.f2626s.add(znVar);
    }

    public void xc(@NonNull v.zn znVar) {
        a("setCurrentState");
        t(znVar);
    }

    @Override // androidx.lifecycle.v
    public void y(@NonNull mt mtVar) {
        co coVar;
        boolean z2;
        a("addObserver");
        v.zn znVar = this.f2628zn;
        v.zn znVar2 = v.zn.DESTROYED;
        if (znVar != znVar2) {
            znVar2 = v.zn.INITIALIZED;
        }
        y yVar = new y(mtVar, znVar2);
        if (this.f2625n3.a(mtVar, yVar) != null || (coVar = this.f2624gv.get()) == null) {
            return;
        }
        if (this.f2627v == 0 && !this.f2621a) {
            z2 = false;
        } else {
            z2 = true;
        }
        v.zn v2 = v(mtVar);
        this.f2627v++;
        while (yVar.y.compareTo(v2) < 0 && this.f2625n3.contains(mtVar)) {
            wz(yVar.y);
            v.n3 v3 = v.n3.v(yVar.y);
            if (v3 != null) {
                yVar.y(coVar, v3);
                tl();
                v2 = v(mtVar);
            } else {
                throw new IllegalStateException("no event up from " + yVar.y);
            }
        }
        if (!z2) {
            w();
        }
        this.f2627v--;
    }

    @Override // androidx.lifecycle.v
    public void zn(@NonNull mt mtVar) {
        a("removeObserver");
        this.f2625n3.fb(mtVar);
    }

    public fb(@NonNull co coVar, boolean z2) {
        this.f2625n3 = new w.y<>();
        this.f2627v = 0;
        this.f2621a = false;
        this.f2623fb = false;
        this.f2626s = new ArrayList<>();
        this.f2624gv = new WeakReference<>(coVar);
        this.f2628zn = v.zn.INITIALIZED;
        this.f2622c5 = z2;
    }
}
