package t;

import android.view.View;
import android.view.animation.Interpolator;
import hw.d;
import hw.mg;
import hw.ta;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class s {

    /* renamed from: gv  reason: collision with root package name */
    public ta f13907gv;

    /* renamed from: v  reason: collision with root package name */
    public boolean f13909v;

    /* renamed from: zn  reason: collision with root package name */
    public Interpolator f13910zn;

    /* renamed from: n3  reason: collision with root package name */
    public long f13908n3 = -1;

    /* renamed from: a  reason: collision with root package name */
    public final d f13906a = new y();
    public final ArrayList<mg> y = new ArrayList<>();

    /* loaded from: classes.dex */
    public class y extends d {

        /* renamed from: n3  reason: collision with root package name */
        public int f13911n3;
        public boolean y;

        public y() {
        }

        public void gv() {
            this.f13911n3 = 0;
            this.y = false;
            s.this.n3();
        }

        @Override // hw.ta
        public void n3(View view) {
            int i = this.f13911n3 + 1;
            this.f13911n3 = i;
            if (i == s.this.y.size()) {
                ta taVar = s.this.f13907gv;
                if (taVar != null) {
                    taVar.n3(null);
                }
                gv();
            }
        }

        @Override // hw.d, hw.ta
        public void zn(View view) {
            if (this.y) {
                return;
            }
            this.y = true;
            ta taVar = s.this.f13907gv;
            if (taVar != null) {
                taVar.zn(null);
            }
        }
    }

    public s a(Interpolator interpolator) {
        if (!this.f13909v) {
            this.f13910zn = interpolator;
        }
        return this;
    }

    public s fb(ta taVar) {
        if (!this.f13909v) {
            this.f13907gv = taVar;
        }
        return this;
    }

    public s gv(mg mgVar, mg mgVar2) {
        this.y.add(mgVar);
        mgVar2.i9(mgVar.gv());
        this.y.add(mgVar2);
        return this;
    }

    public void n3() {
        this.f13909v = false;
    }

    public void s() {
        if (this.f13909v) {
            return;
        }
        Iterator<mg> it = this.y.iterator();
        while (it.hasNext()) {
            mg next = it.next();
            long j2 = this.f13908n3;
            if (j2 >= 0) {
                next.a(j2);
            }
            Interpolator interpolator = this.f13910zn;
            if (interpolator != null) {
                next.fb(interpolator);
            }
            if (this.f13907gv != null) {
                next.s(this.f13906a);
            }
            next.t();
        }
        this.f13909v = true;
    }

    public s v(long j2) {
        if (!this.f13909v) {
            this.f13908n3 = j2;
        }
        return this;
    }

    public void y() {
        if (!this.f13909v) {
            return;
        }
        Iterator<mg> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().zn();
        }
        this.f13909v = false;
    }

    public s zn(mg mgVar) {
        if (!this.f13909v) {
            this.y.add(mgVar);
        }
        return this;
    }
}
