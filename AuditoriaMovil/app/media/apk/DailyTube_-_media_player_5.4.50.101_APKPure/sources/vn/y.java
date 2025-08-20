package vn;

import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import uo.zn;
/* loaded from: classes.dex */
public abstract class y<K, A> {
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public zn<A> f14478v;

    /* renamed from: zn  reason: collision with root package name */
    public final gv<K> f14479zn;
    public final List<n3> y = new ArrayList(1);

    /* renamed from: n3  reason: collision with root package name */
    public boolean f14476n3 = false;

    /* renamed from: gv  reason: collision with root package name */
    public float f14475gv = 0.0f;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public A f14473a = null;

    /* renamed from: fb  reason: collision with root package name */
    public float f14474fb = -1.0f;

    /* renamed from: s  reason: collision with root package name */
    public float f14477s = -1.0f;

    /* loaded from: classes.dex */
    public interface n3 {
        void y();
    }

    public y(List<? extends uo.y<K>> list) {
        this.f14479zn = xc(list);
    }

    public static <T> gv<T> xc(List<? extends uo.y<T>> list) {
        if (list.isEmpty()) {
            return new zn((y) null);
        }
        if (list.size() == 1) {
            return new a(list);
        }
        return new v(list);
    }

    public float a() {
        return this.f14475gv;
    }

    public abstract A c5(uo.y<K> yVar, float f4);

    public void f() {
        for (int i = 0; i < this.y.size(); i++) {
            this.y.get(i).y();
        }
    }

    public final float fb() {
        if (this.f14474fb == -1.0f) {
            this.f14474fb = this.f14479zn.gv();
        }
        return this.f14474fb;
    }

    public float gv() {
        uo.y<K> n32 = n3();
        if (n32 != null && !n32.c5()) {
            return n32.gv.getInterpolation(v());
        }
        return 0.0f;
    }

    public A i9(uo.y<K> yVar, float f4, float f6, float f9) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public uo.y<K> n3() {
        yk.zn.y("BaseKeyframeAnimation#getCurrentKeyframe");
        uo.y<K> n32 = this.f14479zn.n3();
        yk.zn.n3("BaseKeyframeAnimation#getCurrentKeyframe");
        return n32;
    }

    public A s() {
        A c52;
        float v2 = v();
        if (this.f14478v == null && this.f14479zn.y(v2)) {
            return this.f14473a;
        }
        uo.y<K> n32 = n3();
        Interpolator interpolator = n32.v;
        if (interpolator != null && n32.a != null) {
            c52 = i9(n32, v2, interpolator.getInterpolation(v2), n32.a.getInterpolation(v2));
        } else {
            c52 = c5(n32, gv());
        }
        this.f14473a = c52;
        return c52;
    }

    public void t() {
        this.f14476n3 = true;
    }

    public void tl(float f4) {
        if (this.f14479zn.isEmpty()) {
            return;
        }
        if (f4 < fb()) {
            f4 = fb();
        } else if (f4 > zn()) {
            f4 = zn();
        }
        if (f4 == this.f14475gv) {
            return;
        }
        this.f14475gv = f4;
        if (this.f14479zn.zn(f4)) {
            f();
        }
    }

    public float v() {
        if (this.f14476n3) {
            return 0.0f;
        }
        uo.y<K> n32 = n3();
        if (n32.c5()) {
            return 0.0f;
        }
        return (this.f14475gv - n32.a()) / (n32.zn() - n32.a());
    }

    public void wz(@Nullable zn<A> znVar) {
        zn<A> znVar2 = this.f14478v;
        if (znVar2 != null) {
            znVar2.zn(null);
        }
        this.f14478v = znVar;
        if (znVar != null) {
            znVar.zn(this);
        }
    }

    public void y(n3 n3Var) {
        this.y.add(n3Var);
    }

    public float zn() {
        if (this.f14477s == -1.0f) {
            this.f14477s = this.f14479zn.v();
        }
        return this.f14477s;
    }
}
