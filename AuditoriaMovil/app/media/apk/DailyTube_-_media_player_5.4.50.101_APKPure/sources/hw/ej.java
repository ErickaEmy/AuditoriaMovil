package hw;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
/* loaded from: classes.dex */
public class ej {
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public static final ej f8938n3;
    public final t y;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: n3  reason: collision with root package name */
        public z6.n3[] f8939n3;
        public final ej y;

        public a() {
            this(new ej((ej) null));
        }

        public void a(@NonNull z6.n3 n3Var) {
            throw null;
        }

        public void gv(@NonNull z6.n3 n3Var) {
            throw null;
        }

        @NonNull
        public ej n3() {
            throw null;
        }

        public final void y() {
            z6.n3[] n3VarArr = this.f8939n3;
            if (n3VarArr != null) {
                z6.n3 n3Var = n3VarArr[tl.y(1)];
                z6.n3 n3Var2 = this.f8939n3[tl.y(2)];
                if (n3Var2 == null) {
                    n3Var2 = this.y.a(2);
                }
                if (n3Var == null) {
                    n3Var = this.y.a(1);
                }
                a(z6.n3.y(n3Var, n3Var2));
                z6.n3 n3Var3 = this.f8939n3[tl.y(16)];
                if (n3Var3 != null) {
                    v(n3Var3);
                }
                z6.n3 n3Var4 = this.f8939n3[tl.y(32)];
                if (n3Var4 != null) {
                    zn(n3Var4);
                }
                z6.n3 n3Var5 = this.f8939n3[tl.y(64)];
                if (n3Var5 != null) {
                    fb(n3Var5);
                }
            }
        }

        public a(@NonNull ej ejVar) {
            this.y = ejVar;
        }

        public void fb(@NonNull z6.n3 n3Var) {
        }

        public void v(@NonNull z6.n3 n3Var) {
        }

        public void zn(@NonNull z6.n3 n3Var) {
        }
    }

    /* loaded from: classes.dex */
    public static class c5 extends s {
        public c5(@NonNull ej ejVar, @NonNull WindowInsets windowInsets) {
            super(ejVar, windowInsets);
        }

        @Override // hw.ej.t
        @Nullable
        public hw.gv a() {
            return hw.gv.v(this.f8950zn.getDisplayCutout());
        }

        @Override // hw.ej.fb, hw.ej.t
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c5)) {
                return false;
            }
            c5 c5Var = (c5) obj;
            if (Objects.equals(this.f8950zn, c5Var.f8950zn) && Objects.equals(this.f8947fb, c5Var.f8947fb)) {
                return true;
            }
            return false;
        }

        @Override // hw.ej.t
        public int hashCode() {
            return this.f8950zn.hashCode();
        }

        @Override // hw.ej.t
        @NonNull
        public ej y() {
            return ej.i4(this.f8950zn.consumeDisplayCutout());
        }

        public c5(@NonNull ej ejVar, @NonNull c5 c5Var) {
            super(ejVar, c5Var);
        }
    }

    /* loaded from: classes.dex */
    public static class f extends i9 {
        @NonNull

        /* renamed from: p  reason: collision with root package name */
        public static final ej f8940p = ej.i4(WindowInsets.CONSUMED);

        public f(@NonNull ej ejVar, @NonNull WindowInsets windowInsets) {
            super(ejVar, windowInsets);
        }

        @Override // hw.ej.fb, hw.ej.t
        @NonNull
        public z6.n3 fb(int i) {
            return z6.n3.gv(this.f8950zn.getInsets(wz.y(i)));
        }

        public f(@NonNull ej ejVar, @NonNull f fVar) {
            super(ejVar, fVar);
        }

        @Override // hw.ej.fb, hw.ej.t
        public final void gv(@NonNull View view) {
        }
    }

    /* loaded from: classes.dex */
    public static class i9 extends c5 {

        /* renamed from: w  reason: collision with root package name */
        public z6.n3 f8952w;

        /* renamed from: wz  reason: collision with root package name */
        public z6.n3 f8953wz;

        /* renamed from: xc  reason: collision with root package name */
        public z6.n3 f8954xc;

        public i9(@NonNull ej ejVar, @NonNull WindowInsets windowInsets) {
            super(ejVar, windowInsets);
        }

        @Override // hw.ej.t
        @NonNull
        public z6.n3 i9() {
            if (this.f8953wz == null) {
                this.f8953wz = z6.n3.gv(this.f8950zn.getSystemGestureInsets());
            }
            return this.f8953wz;
        }

        @Override // hw.ej.t
        @NonNull
        public z6.n3 s() {
            if (this.f8954xc == null) {
                this.f8954xc = z6.n3.gv(this.f8950zn.getMandatorySystemGestureInsets());
            }
            return this.f8954xc;
        }

        @Override // hw.ej.t
        @NonNull
        public z6.n3 t() {
            if (this.f8952w == null) {
                this.f8952w = z6.n3.gv(this.f8950zn.getTappableElementInsets());
            }
            return this.f8952w;
        }

        @Override // hw.ej.fb, hw.ej.t
        @NonNull
        public ej tl(int i, int i5, int i6, int i8) {
            return ej.i4(this.f8950zn.inset(i, i5, i6, i8));
        }

        public i9(@NonNull ej ejVar, @NonNull i9 i9Var) {
            super(ejVar, i9Var);
        }

        @Override // hw.ej.s, hw.ej.t
        public void co(@Nullable z6.n3 n3Var) {
        }
    }

    /* loaded from: classes.dex */
    public static class s extends fb {

        /* renamed from: tl  reason: collision with root package name */
        public z6.n3 f8955tl;

        public s(@NonNull ej ejVar, @NonNull WindowInsets windowInsets) {
            super(ejVar, windowInsets);
        }

        @Override // hw.ej.t
        @NonNull
        public final z6.n3 c5() {
            if (this.f8955tl == null) {
                this.f8955tl = z6.n3.n3(this.f8950zn.getStableInsetLeft(), this.f8950zn.getStableInsetTop(), this.f8950zn.getStableInsetRight(), this.f8950zn.getStableInsetBottom());
            }
            return this.f8955tl;
        }

        @Override // hw.ej.t
        public void co(@Nullable z6.n3 n3Var) {
            this.f8955tl = n3Var;
        }

        @Override // hw.ej.t
        @NonNull
        public ej n3() {
            return ej.i4(this.f8950zn.consumeStableInsets());
        }

        @Override // hw.ej.t
        public boolean wz() {
            return this.f8950zn.isConsumed();
        }

        @Override // hw.ej.t
        @NonNull
        public ej zn() {
            return ej.i4(this.f8950zn.consumeSystemWindowInsets());
        }

        public s(@NonNull ej ejVar, @NonNull s sVar) {
            super(ejVar, sVar);
            this.f8955tl = sVar.f8955tl;
        }
    }

    /* loaded from: classes.dex */
    public static final class tl {
        public static int n3() {
            return 2;
        }

        public static int y(int i) {
            if (i != 1) {
                if (i == 2) {
                    return 1;
                }
                if (i == 4) {
                    return 2;
                }
                if (i != 8) {
                    if (i == 16) {
                        return 4;
                    }
                    if (i != 32) {
                        if (i != 64) {
                            if (i != 128) {
                                if (i == 256) {
                                    return 8;
                                }
                                throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
                            }
                            return 7;
                        }
                        return 6;
                    }
                    return 5;
                }
                return 3;
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static class v extends gv {
        public v() {
        }

        public v(@NonNull ej ejVar) {
            super(ejVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class wz {
        public static int y(int i) {
            int statusBars;
            int i5 = 0;
            for (int i6 = 1; i6 <= 256; i6 <<= 1) {
                if ((i & i6) != 0) {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 4) {
                                if (i6 != 8) {
                                    if (i6 != 16) {
                                        if (i6 != 32) {
                                            if (i6 != 64) {
                                                if (i6 == 128) {
                                                    statusBars = WindowInsets.Type.displayCutout();
                                                }
                                            } else {
                                                statusBars = WindowInsets.Type.tappableElement();
                                            }
                                        } else {
                                            statusBars = WindowInsets.Type.mandatorySystemGestures();
                                        }
                                    } else {
                                        statusBars = WindowInsets.Type.systemGestures();
                                    }
                                } else {
                                    statusBars = WindowInsets.Type.ime();
                                }
                            } else {
                                statusBars = WindowInsets.Type.captionBar();
                            }
                        } else {
                            statusBars = WindowInsets.Type.navigationBars();
                        }
                    } else {
                        statusBars = WindowInsets.Type.statusBars();
                    }
                    i5 |= statusBars;
                }
            }
            return i5;
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: gv  reason: collision with root package name */
        public static boolean f8957gv;

        /* renamed from: n3  reason: collision with root package name */
        public static Field f8958n3;
        public static Field y;

        /* renamed from: zn  reason: collision with root package name */
        public static Field f8959zn;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                y = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f8958n3 = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f8959zn = declaredField3;
                declaredField3.setAccessible(true);
                f8957gv = true;
            } catch (ReflectiveOperationException e2) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e2.getMessage(), e2);
            }
        }

        @Nullable
        public static ej y(@NonNull View view) {
            if (f8957gv && view.isAttachedToWindow()) {
                try {
                    Object obj = y.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f8958n3.get(obj);
                        Rect rect2 = (Rect) f8959zn.get(obj);
                        if (rect != null && rect2 != null) {
                            ej y2 = new n3().n3(z6.n3.zn(rect)).zn(z6.n3.zn(rect2)).y();
                            y2.z(y2);
                            y2.gv(view.getRootView());
                            return y2;
                        }
                    }
                } catch (IllegalAccessException e2) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e2.getMessage(), e2);
                }
            }
            return null;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f8938n3 = f.f8940p;
        } else {
            f8938n3 = t.f8956n3;
        }
    }

    public ej(@NonNull WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.y = new f(this, windowInsets);
        } else if (i >= 29) {
            this.y = new i9(this, windowInsets);
        } else if (i >= 28) {
            this.y = new c5(this, windowInsets);
        } else {
            this.y = new s(this, windowInsets);
        }
    }

    @NonNull
    public static ej f3(@NonNull WindowInsets windowInsets, @Nullable View view) {
        ej ejVar = new ej((WindowInsets) vl.s.fb(windowInsets));
        if (view != null && i4.ut(view)) {
            ejVar.z(i4.b(view));
            ejVar.gv(view.getRootView());
        }
        return ejVar;
    }

    @NonNull
    public static ej i4(@NonNull WindowInsets windowInsets) {
        return f3(windowInsets, null);
    }

    public static z6.n3 xc(@NonNull z6.n3 n3Var, int i, int i5, int i6, int i8) {
        int max = Math.max(0, n3Var.y - i);
        int max2 = Math.max(0, n3Var.f15664n3 - i5);
        int max3 = Math.max(0, n3Var.f15665zn - i6);
        int max4 = Math.max(0, n3Var.f15663gv - i8);
        if (max == i && max2 == i5 && max3 == i6 && max4 == i8) {
            return n3Var;
        }
        return z6.n3.n3(max, max2, max3, max4);
    }

    @NonNull
    public z6.n3 a(int i) {
        return this.y.fb(i);
    }

    @NonNull
    @Deprecated
    public z6.n3 c5() {
        return this.y.i9();
    }

    public void co(@NonNull z6.n3 n3Var) {
        this.y.p(n3Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ej)) {
            return false;
        }
        return vl.zn.y(this.y, ((ej) obj).y);
    }

    @Deprecated
    public int f() {
        return this.y.f().y;
    }

    @NonNull
    @Deprecated
    public z6.n3 fb() {
        return this.y.s();
    }

    public void gv(@NonNull View view) {
        this.y.gv(view);
    }

    public int hashCode() {
        t tVar = this.y;
        if (tVar == null) {
            return 0;
        }
        return tVar.hashCode();
    }

    @Deprecated
    public int i9() {
        return this.y.f().f15663gv;
    }

    public void mt(z6.n3[] n3VarArr) {
        this.y.w(n3VarArr);
    }

    @NonNull
    @Deprecated
    public ej n3() {
        return this.y.n3();
    }

    @NonNull
    @Deprecated
    public ej p(int i, int i5, int i6, int i8) {
        return new n3(this).zn(z6.n3.n3(i, i5, i6, i8)).y();
    }

    public void r(@Nullable z6.n3 n3Var) {
        this.y.co(n3Var);
    }

    @NonNull
    @Deprecated
    public z6.n3 s() {
        return this.y.c5();
    }

    @Deprecated
    public int t() {
        return this.y.f().f15665zn;
    }

    @Deprecated
    public int tl() {
        return this.y.f().f15664n3;
    }

    @Nullable
    public hw.gv v() {
        return this.y.a();
    }

    public boolean w() {
        return this.y.wz();
    }

    @NonNull
    public ej wz(int i, int i5, int i6, int i8) {
        return this.y.tl(i, i5, i6, i8);
    }

    @Nullable
    public WindowInsets x4() {
        t tVar = this.y;
        if (tVar instanceof fb) {
            return ((fb) tVar).f8950zn;
        }
        return null;
    }

    @NonNull
    @Deprecated
    public ej y() {
        return this.y.y();
    }

    public void z(@Nullable ej ejVar) {
        this.y.mt(ejVar);
    }

    @NonNull
    @Deprecated
    public ej zn() {
        return this.y.zn();
    }

    /* loaded from: classes.dex */
    public static class fb extends t {

        /* renamed from: c5  reason: collision with root package name */
        public static Method f8941c5;

        /* renamed from: f  reason: collision with root package name */
        public static Field f8942f;

        /* renamed from: i9  reason: collision with root package name */
        public static Class<?> f8943i9;

        /* renamed from: s  reason: collision with root package name */
        public static boolean f8944s;

        /* renamed from: t  reason: collision with root package name */
        public static Field f8945t;

        /* renamed from: a  reason: collision with root package name */
        public ej f8946a;

        /* renamed from: fb  reason: collision with root package name */
        public z6.n3 f8947fb;

        /* renamed from: gv  reason: collision with root package name */
        public z6.n3[] f8948gv;

        /* renamed from: v  reason: collision with root package name */
        public z6.n3 f8949v;
        @NonNull

        /* renamed from: zn  reason: collision with root package name */
        public final WindowInsets f8950zn;

        public fb(@NonNull ej ejVar, @NonNull WindowInsets windowInsets) {
            super(ejVar);
            this.f8950zn = windowInsets;
        }

        @SuppressLint({"PrivateApi"})
        private static void f3() {
            try {
                f8941c5 = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f8943i9 = cls;
                f8942f = cls.getDeclaredField("mVisibleInsets");
                f8945t = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f8942f.setAccessible(true);
                f8945t.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            f8944s = true;
        }

        @Nullable
        private z6.n3 i4(@NonNull View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f8944s) {
                    f3();
                }
                Method method = f8941c5;
                if (method != null && f8943i9 != null && f8942f != null) {
                    try {
                        Object invoke = method.invoke(view, null);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f8942f.get(f8945t.get(invoke));
                        if (rect == null) {
                            return null;
                        }
                        return z6.n3.zn(rect);
                    } catch (ReflectiveOperationException e2) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        private z6.n3 x4() {
            ej ejVar = this.f8946a;
            if (ejVar != null) {
                return ejVar.s();
            }
            return z6.n3.f15662v;
        }

        @NonNull
        @SuppressLint({"WrongConstant"})
        private z6.n3 z(int i, boolean z2) {
            z6.n3 n3Var = z6.n3.f15662v;
            for (int i5 = 1; i5 <= 256; i5 <<= 1) {
                if ((i & i5) != 0) {
                    n3Var = z6.n3.y(n3Var, r(i5, z2));
                }
            }
            return n3Var;
        }

        @Override // hw.ej.t
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f8947fb, ((fb) obj).f8947fb);
        }

        @Override // hw.ej.t
        @NonNull
        public final z6.n3 f() {
            if (this.f8949v == null) {
                this.f8949v = z6.n3.n3(this.f8950zn.getSystemWindowInsetLeft(), this.f8950zn.getSystemWindowInsetTop(), this.f8950zn.getSystemWindowInsetRight(), this.f8950zn.getSystemWindowInsetBottom());
            }
            return this.f8949v;
        }

        @Override // hw.ej.t
        @NonNull
        public z6.n3 fb(int i) {
            return z(i, false);
        }

        @Override // hw.ej.t
        public void gv(@NonNull View view) {
            z6.n3 i42 = i4(view);
            if (i42 == null) {
                i42 = z6.n3.f15662v;
            }
            p(i42);
        }

        @Override // hw.ej.t
        public void mt(@Nullable ej ejVar) {
            this.f8946a = ejVar;
        }

        @Override // hw.ej.t
        public void p(@NonNull z6.n3 n3Var) {
            this.f8947fb = n3Var;
        }

        @NonNull
        public z6.n3 r(int i, boolean z2) {
            int i5;
            hw.gv a2;
            if (i != 1) {
                z6.n3 n3Var = null;
                if (i != 2) {
                    if (i != 8) {
                        if (i != 16) {
                            if (i != 32) {
                                if (i != 64) {
                                    if (i != 128) {
                                        return z6.n3.f15662v;
                                    }
                                    ej ejVar = this.f8946a;
                                    if (ejVar != null) {
                                        a2 = ejVar.v();
                                    } else {
                                        a2 = a();
                                    }
                                    if (a2 != null) {
                                        return z6.n3.n3(a2.n3(), a2.gv(), a2.zn(), a2.y());
                                    }
                                    return z6.n3.f15662v;
                                }
                                return t();
                            }
                            return s();
                        }
                        return i9();
                    }
                    z6.n3[] n3VarArr = this.f8948gv;
                    if (n3VarArr != null) {
                        n3Var = n3VarArr[tl.y(8)];
                    }
                    if (n3Var != null) {
                        return n3Var;
                    }
                    z6.n3 f4 = f();
                    z6.n3 x42 = x4();
                    int i6 = f4.f15663gv;
                    if (i6 > x42.f15663gv) {
                        return z6.n3.n3(0, 0, 0, i6);
                    }
                    z6.n3 n3Var2 = this.f8947fb;
                    if (n3Var2 != null && !n3Var2.equals(z6.n3.f15662v) && (i5 = this.f8947fb.f15663gv) > x42.f15663gv) {
                        return z6.n3.n3(0, 0, 0, i5);
                    }
                    return z6.n3.f15662v;
                } else if (z2) {
                    z6.n3 x43 = x4();
                    z6.n3 c52 = c5();
                    return z6.n3.n3(Math.max(x43.y, c52.y), 0, Math.max(x43.f15665zn, c52.f15665zn), Math.max(x43.f15663gv, c52.f15663gv));
                } else {
                    z6.n3 f6 = f();
                    ej ejVar2 = this.f8946a;
                    if (ejVar2 != null) {
                        n3Var = ejVar2.s();
                    }
                    int i8 = f6.f15663gv;
                    if (n3Var != null) {
                        i8 = Math.min(i8, n3Var.f15663gv);
                    }
                    return z6.n3.n3(f6.y, 0, f6.f15665zn, i8);
                }
            } else if (z2) {
                return z6.n3.n3(0, Math.max(x4().f15664n3, f().f15664n3), 0, 0);
            } else {
                return z6.n3.n3(0, f().f15664n3, 0, 0);
            }
        }

        @Override // hw.ej.t
        @NonNull
        public ej tl(int i, int i5, int i6, int i8) {
            n3 n3Var = new n3(ej.i4(this.f8950zn));
            n3Var.zn(ej.xc(f(), i, i5, i6, i8));
            n3Var.n3(ej.xc(c5(), i, i5, i6, i8));
            return n3Var.y();
        }

        @Override // hw.ej.t
        public void v(@NonNull ej ejVar) {
            ejVar.z(this.f8946a);
            ejVar.co(this.f8947fb);
        }

        @Override // hw.ej.t
        public void w(z6.n3[] n3VarArr) {
            this.f8948gv = n3VarArr;
        }

        @Override // hw.ej.t
        public boolean xc() {
            return this.f8950zn.isRound();
        }

        public fb(@NonNull ej ejVar, @NonNull fb fbVar) {
            this(ejVar, new WindowInsets(fbVar.f8950zn));
        }
    }

    /* loaded from: classes.dex */
    public static class gv extends a {

        /* renamed from: zn  reason: collision with root package name */
        public final WindowInsets.Builder f8951zn;

        public gv() {
            this.f8951zn = new WindowInsets.Builder();
        }

        @Override // hw.ej.a
        public void a(@NonNull z6.n3 n3Var) {
            this.f8951zn.setSystemWindowInsets(n3Var.v());
        }

        @Override // hw.ej.a
        public void fb(@NonNull z6.n3 n3Var) {
            this.f8951zn.setTappableElementInsets(n3Var.v());
        }

        @Override // hw.ej.a
        public void gv(@NonNull z6.n3 n3Var) {
            this.f8951zn.setStableInsets(n3Var.v());
        }

        @Override // hw.ej.a
        @NonNull
        public ej n3() {
            y();
            ej i42 = ej.i4(this.f8951zn.build());
            i42.mt(this.f8939n3);
            return i42;
        }

        @Override // hw.ej.a
        public void v(@NonNull z6.n3 n3Var) {
            this.f8951zn.setSystemGestureInsets(n3Var.v());
        }

        @Override // hw.ej.a
        public void zn(@NonNull z6.n3 n3Var) {
            this.f8951zn.setMandatorySystemGestureInsets(n3Var.v());
        }

        public gv(@NonNull ej ejVar) {
            super(ejVar);
            WindowInsets.Builder builder;
            WindowInsets x42 = ejVar.x4();
            if (x42 != null) {
                builder = new WindowInsets.Builder(x42);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f8951zn = builder;
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends a {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f8960a;

        /* renamed from: fb  reason: collision with root package name */
        public static Constructor<WindowInsets> f8961fb;

        /* renamed from: s  reason: collision with root package name */
        public static boolean f8962s;

        /* renamed from: v  reason: collision with root package name */
        public static Field f8963v;

        /* renamed from: gv  reason: collision with root package name */
        public z6.n3 f8964gv;

        /* renamed from: zn  reason: collision with root package name */
        public WindowInsets f8965zn;

        public zn() {
            this.f8965zn = s();
        }

        @Nullable
        private static WindowInsets s() {
            if (!f8960a) {
                try {
                    f8963v = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f8960a = true;
            }
            Field field = f8963v;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f8962s) {
                try {
                    f8961fb = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                f8962s = true;
            }
            Constructor<WindowInsets> constructor = f8961fb;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException unused4) {
                }
            }
            return null;
        }

        @Override // hw.ej.a
        public void a(@NonNull z6.n3 n3Var) {
            WindowInsets windowInsets = this.f8965zn;
            if (windowInsets != null) {
                this.f8965zn = windowInsets.replaceSystemWindowInsets(n3Var.y, n3Var.f15664n3, n3Var.f15665zn, n3Var.f15663gv);
            }
        }

        @Override // hw.ej.a
        public void gv(@Nullable z6.n3 n3Var) {
            this.f8964gv = n3Var;
        }

        @Override // hw.ej.a
        @NonNull
        public ej n3() {
            y();
            ej i42 = ej.i4(this.f8965zn);
            i42.mt(this.f8939n3);
            i42.r(this.f8964gv);
            return i42;
        }

        public zn(@NonNull ej ejVar) {
            super(ejVar);
            this.f8965zn = ejVar.x4();
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {
        public final a y;

        public n3() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.y = new v();
            } else if (i >= 29) {
                this.y = new gv();
            } else {
                this.y = new zn();
            }
        }

        @NonNull
        @Deprecated
        public n3 n3(@NonNull z6.n3 n3Var) {
            this.y.gv(n3Var);
            return this;
        }

        @NonNull
        public ej y() {
            return this.y.n3();
        }

        @NonNull
        @Deprecated
        public n3 zn(@NonNull z6.n3 n3Var) {
            this.y.a(n3Var);
            return this;
        }

        public n3(@NonNull ej ejVar) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.y = new v(ejVar);
            } else if (i >= 29) {
                this.y = new gv(ejVar);
            } else {
                this.y = new zn(ejVar);
            }
        }
    }

    public ej(@Nullable ej ejVar) {
        if (ejVar != null) {
            t tVar = ejVar.y;
            int i = Build.VERSION.SDK_INT;
            if (i >= 30 && (tVar instanceof f)) {
                this.y = new f(this, (f) tVar);
            } else if (i >= 29 && (tVar instanceof i9)) {
                this.y = new i9(this, (i9) tVar);
            } else if (i >= 28 && (tVar instanceof c5)) {
                this.y = new c5(this, (c5) tVar);
            } else if (tVar instanceof s) {
                this.y = new s(this, (s) tVar);
            } else if (tVar instanceof fb) {
                this.y = new fb(this, (fb) tVar);
            } else {
                this.y = new t(this);
            }
            tVar.v(this);
            return;
        }
        this.y = new t(this);
    }

    /* loaded from: classes.dex */
    public static class t {
        @NonNull

        /* renamed from: n3  reason: collision with root package name */
        public static final ej f8956n3 = new n3().y().y().n3().zn();
        public final ej y;

        public t(@NonNull ej ejVar) {
            this.y = ejVar;
        }

        @Nullable
        public hw.gv a() {
            return null;
        }

        @NonNull
        public z6.n3 c5() {
            return z6.n3.f15662v;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof t)) {
                return false;
            }
            t tVar = (t) obj;
            if (xc() == tVar.xc() && wz() == tVar.wz() && vl.zn.y(f(), tVar.f()) && vl.zn.y(c5(), tVar.c5()) && vl.zn.y(a(), tVar.a())) {
                return true;
            }
            return false;
        }

        @NonNull
        public z6.n3 f() {
            return z6.n3.f15662v;
        }

        @NonNull
        public z6.n3 fb(int i) {
            return z6.n3.f15662v;
        }

        public int hashCode() {
            return vl.zn.n3(Boolean.valueOf(xc()), Boolean.valueOf(wz()), f(), c5(), a());
        }

        @NonNull
        public z6.n3 i9() {
            return f();
        }

        @NonNull
        public ej n3() {
            return this.y;
        }

        @NonNull
        public z6.n3 s() {
            return f();
        }

        @NonNull
        public z6.n3 t() {
            return f();
        }

        @NonNull
        public ej tl(int i, int i5, int i6, int i8) {
            return f8956n3;
        }

        public boolean wz() {
            return false;
        }

        public boolean xc() {
            return false;
        }

        @NonNull
        public ej y() {
            return this.y;
        }

        @NonNull
        public ej zn() {
            return this.y;
        }

        public void co(z6.n3 n3Var) {
        }

        public void gv(@NonNull View view) {
        }

        public void mt(@Nullable ej ejVar) {
        }

        public void p(@NonNull z6.n3 n3Var) {
        }

        public void v(@NonNull ej ejVar) {
        }

        public void w(z6.n3[] n3VarArr) {
        }
    }
}
