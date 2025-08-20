package f7;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import f7.n3;
import f7.y;
import hw.i4;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class n3<T extends n3<T>> implements y.n3 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7875a;

    /* renamed from: c5  reason: collision with root package name */
    public long f7876c5;

    /* renamed from: gv  reason: collision with root package name */
    public final Object f7879gv;

    /* renamed from: i9  reason: collision with root package name */
    public float f7880i9;

    /* renamed from: v  reason: collision with root package name */
    public final f7.zn f7884v;
    public float y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f7885zn;

    /* renamed from: tl  reason: collision with root package name */
    public static final mt f7869tl = new a("translationX");

    /* renamed from: wz  reason: collision with root package name */
    public static final mt f7871wz = new fb("translationY");

    /* renamed from: xc  reason: collision with root package name */
    public static final mt f7873xc = new s("translationZ");

    /* renamed from: w  reason: collision with root package name */
    public static final mt f7870w = new c5("scaleX");

    /* renamed from: p  reason: collision with root package name */
    public static final mt f7867p = new i9("scaleY");

    /* renamed from: mt  reason: collision with root package name */
    public static final mt f7865mt = new f("rotation");

    /* renamed from: co  reason: collision with root package name */
    public static final mt f7862co = new t("rotationX");

    /* renamed from: z  reason: collision with root package name */
    public static final mt f7874z = new tl("rotationY");

    /* renamed from: r  reason: collision with root package name */
    public static final mt f7868r = new wz("x");

    /* renamed from: x4  reason: collision with root package name */
    public static final mt f7872x4 = new y("y");

    /* renamed from: i4  reason: collision with root package name */
    public static final mt f7864i4 = new C0097n3("z");

    /* renamed from: f3  reason: collision with root package name */
    public static final mt f7863f3 = new zn("alpha");

    /* renamed from: n  reason: collision with root package name */
    public static final mt f7866n = new gv("scrollX");

    /* renamed from: c  reason: collision with root package name */
    public static final mt f7861c = new v("scrollY");

    /* renamed from: n3  reason: collision with root package name */
    public float f7881n3 = Float.MAX_VALUE;

    /* renamed from: fb  reason: collision with root package name */
    public float f7878fb = Float.MAX_VALUE;

    /* renamed from: s  reason: collision with root package name */
    public float f7882s = -Float.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<w> f7877f = new ArrayList<>();

    /* renamed from: t  reason: collision with root package name */
    public final ArrayList<p> f7883t = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class a extends mt {
        public a(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            view.setTranslationX(f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return view.getTranslationX();
        }
    }

    /* loaded from: classes.dex */
    public static class c5 extends mt {
        public c5(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            view.setScaleX(f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return view.getScaleX();
        }
    }

    /* loaded from: classes.dex */
    public static class f extends mt {
        public f(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            view.setRotation(f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return view.getRotation();
        }
    }

    /* loaded from: classes.dex */
    public static class fb extends mt {
        public fb(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            view.setTranslationY(f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return view.getTranslationY();
        }
    }

    /* loaded from: classes.dex */
    public static class gv extends mt {
        public gv(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            view.setScrollX((int) f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return view.getScrollX();
        }
    }

    /* loaded from: classes.dex */
    public static class i9 extends mt {
        public i9(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            view.setScaleY(f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return view.getScaleY();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class mt extends f7.zn<View> {
        public /* synthetic */ mt(String str, a aVar) {
            this(str);
        }

        public mt(String str) {
            super(str);
        }
    }

    /* renamed from: f7.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0097n3 extends mt {
        public C0097n3(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            i4.oa(view, f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return i4.j5(view);
        }
    }

    /* loaded from: classes.dex */
    public interface p {
        void y(n3 n3Var, float f4, float f6);
    }

    /* loaded from: classes.dex */
    public static class s extends mt {
        public s(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            i4.vp(view, f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return i4.vl(view);
        }
    }

    /* loaded from: classes.dex */
    public static class t extends mt {
        public t(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            view.setRotationX(f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return view.getRotationX();
        }
    }

    /* loaded from: classes.dex */
    public static class tl extends mt {
        public tl(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            view.setRotationY(f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return view.getRotationY();
        }
    }

    /* loaded from: classes.dex */
    public static class v extends mt {
        public v(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            view.setScrollY((int) f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return view.getScrollY();
        }
    }

    /* loaded from: classes.dex */
    public interface w {
        void y(n3 n3Var, boolean z2, float f4, float f6);
    }

    /* loaded from: classes.dex */
    public static class wz extends mt {
        public wz(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            view.setX(f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return view.getX();
        }
    }

    /* loaded from: classes.dex */
    public static class xc {

        /* renamed from: n3  reason: collision with root package name */
        public float f7886n3;
        public float y;
    }

    /* loaded from: classes.dex */
    public static class y extends mt {
        public y(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            view.setY(f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return view.getY();
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends mt {
        public zn(String str) {
            super(str, null);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(View view, float f4) {
            view.setAlpha(f4);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(View view) {
            return view.getAlpha();
        }
    }

    public <K> n3(K k2, f7.zn<K> znVar) {
        this.f7879gv = k2;
        this.f7884v = znVar;
        if (znVar != f7865mt && znVar != f7862co && znVar != f7874z) {
            if (znVar == f7863f3) {
                this.f7880i9 = 0.00390625f;
                return;
            } else if (znVar != f7870w && znVar != f7867p) {
                this.f7880i9 = 1.0f;
                return;
            } else {
                this.f7880i9 = 0.00390625f;
                return;
            }
        }
        this.f7880i9 = 0.1f;
    }

    public static <T> void fb(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public boolean a() {
        return this.f7875a;
    }

    public T c5(float f4) {
        this.f7881n3 = f4;
        this.f7885zn = true;
        return this;
    }

    public final void f() {
        if (!this.f7875a) {
            this.f7875a = true;
            if (!this.f7885zn) {
                this.f7881n3 = gv();
            }
            float f4 = this.f7881n3;
            if (f4 <= this.f7878fb && f4 >= this.f7882s) {
                f7.y.gv().y(this, 0L);
                return;
            }
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
    }

    public final float gv() {
        return this.f7884v.y(this.f7879gv);
    }

    public void i9() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.f7875a) {
                f();
                return;
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    public void n3() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.f7875a) {
                zn(true);
                return;
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    public void s(float f4) {
        this.f7884v.n3(this.f7879gv, f4);
        for (int i = 0; i < this.f7883t.size(); i++) {
            if (this.f7883t.get(i) != null) {
                this.f7883t.get(i).y(this, this.f7881n3, this.y);
            }
        }
        fb(this.f7883t);
    }

    public abstract boolean t(long j2);

    public float v() {
        return this.f7880i9 * 0.75f;
    }

    @Override // f7.y.n3
    public boolean y(long j2) {
        long j4 = this.f7876c5;
        if (j4 == 0) {
            this.f7876c5 = j2;
            s(this.f7881n3);
            return false;
        }
        this.f7876c5 = j2;
        boolean t2 = t(j2 - j4);
        float min = Math.min(this.f7881n3, this.f7878fb);
        this.f7881n3 = min;
        float max = Math.max(min, this.f7882s);
        this.f7881n3 = max;
        s(max);
        if (t2) {
            zn(false);
        }
        return t2;
    }

    public final void zn(boolean z2) {
        this.f7875a = false;
        f7.y.gv().fb(this);
        this.f7876c5 = 0L;
        this.f7885zn = false;
        for (int i = 0; i < this.f7877f.size(); i++) {
            if (this.f7877f.get(i) != null) {
                this.f7877f.get(i).y(this, z2, this.f7881n3, this.y);
            }
        }
        fb(this.f7877f);
    }
}
