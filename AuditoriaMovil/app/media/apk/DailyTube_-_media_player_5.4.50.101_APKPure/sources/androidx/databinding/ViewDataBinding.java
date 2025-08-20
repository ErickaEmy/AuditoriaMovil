package androidx.databinding;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.a;
import androidx.databinding.gv;
import androidx.databinding.library.R$id;
import androidx.databinding.v;
import androidx.databinding.zn;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import y5.co;
import y5.fh;
import y5.mt;
/* loaded from: classes.dex */
public abstract class ViewDataBinding extends androidx.databinding.y implements wf.y {

    /* renamed from: x  reason: collision with root package name */
    public static final int f2388x = 8;

    /* renamed from: c  reason: collision with root package name */
    public co f2389c;

    /* renamed from: co  reason: collision with root package name */
    public Choreographer f2390co;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2391d;

    /* renamed from: d0  reason: collision with root package name */
    public OnStartListener f2392d0;

    /* renamed from: f  reason: collision with root package name */
    public q9.i9[] f2393f;

    /* renamed from: f3  reason: collision with root package name */
    public final q9.zn f2394f3;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f2395fb;

    /* renamed from: fh  reason: collision with root package name */
    public boolean f2396fh;

    /* renamed from: n  reason: collision with root package name */
    public ViewDataBinding f2397n;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2398p;

    /* renamed from: r  reason: collision with root package name */
    public Handler f2399r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f2400s;

    /* renamed from: t  reason: collision with root package name */
    public final View f2401t;

    /* renamed from: v  reason: collision with root package name */
    public final Runnable f2402v;

    /* renamed from: w  reason: collision with root package name */
    public androidx.databinding.zn<q9.s, ViewDataBinding, Void> f2403w;

    /* renamed from: z  reason: collision with root package name */
    public final Choreographer.FrameCallback f2404z;

    /* renamed from: ej  reason: collision with root package name */
    public static int f2380ej = Build.VERSION.SDK_INT;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f2379b = true;

    /* renamed from: j5  reason: collision with root package name */
    public static final q9.y f2382j5 = new y();

    /* renamed from: qn  reason: collision with root package name */
    public static final q9.y f2386qn = new n3();

    /* renamed from: o  reason: collision with root package name */
    public static final q9.y f2383o = new zn();

    /* renamed from: j  reason: collision with root package name */
    public static final q9.y f2381j = new gv();

    /* renamed from: oz  reason: collision with root package name */
    public static final zn.y<q9.s, ViewDataBinding, Void> f2384oz = new v();

    /* renamed from: ut  reason: collision with root package name */
    public static final ReferenceQueue<ViewDataBinding> f2387ut = new ReferenceQueue<>();

    /* renamed from: q9  reason: collision with root package name */
    public static final View.OnAttachStateChangeListener f2385q9 = new a();

    /* loaded from: classes.dex */
    public static class OnStartListener implements mt {
        public final WeakReference<ViewDataBinding> y;

        public /* synthetic */ OnStartListener(ViewDataBinding viewDataBinding, y yVar) {
            this(viewDataBinding);
        }

        @androidx.lifecycle.c5(v.n3.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = this.y.get();
            if (viewDataBinding != null) {
                viewDataBinding.u0();
            }
        }

        public OnStartListener(ViewDataBinding viewDataBinding) {
            this.y = new WeakReference<>(viewDataBinding);
        }
    }

    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        @TargetApi(19)
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.pz(view).f2402v.run();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: classes.dex */
    public static class c5 {

        /* renamed from: n3  reason: collision with root package name */
        public final int[][] f2405n3;
        public final String[][] y;

        /* renamed from: zn  reason: collision with root package name */
        public final int[][] f2406zn;

        public c5(int i) {
            this.y = new String[i];
            this.f2405n3 = new int[i];
            this.f2406zn = new int[i];
        }

        public void y(int i, String[] strArr, int[] iArr, int[] iArr2) {
            this.y[i] = strArr;
            this.f2405n3[i] = iArr;
            this.f2406zn[i] = iArr2;
        }
    }

    /* loaded from: classes.dex */
    public class fb implements Runnable {
        public fb() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                ViewDataBinding.this.f2395fb = false;
            }
            ViewDataBinding.ix();
            if (!ViewDataBinding.this.f2401t.isAttachedToWindow()) {
                ViewDataBinding.this.f2401t.removeOnAttachStateChangeListener(ViewDataBinding.f2385q9);
                ViewDataBinding.this.f2401t.addOnAttachStateChangeListener(ViewDataBinding.f2385q9);
                return;
            }
            ViewDataBinding.this.u0();
        }
    }

    /* loaded from: classes.dex */
    public class gv implements q9.y {
        @Override // q9.y
        public q9.i9 y(ViewDataBinding viewDataBinding, int i, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new i9(viewDataBinding, i, referenceQueue).a();
        }
    }

    /* loaded from: classes.dex */
    public static class i9 implements fh, q9.fb<LiveData<?>> {
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public WeakReference<co> f2407n3;
        public final q9.i9<LiveData<?>> y;

        public i9(ViewDataBinding viewDataBinding, int i, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.y = new q9.i9<>(viewDataBinding, i, this, referenceQueue);
        }

        public q9.i9<LiveData<?>> a() {
            return this.y;
        }

        @Override // q9.fb
        /* renamed from: fb */
        public void y(LiveData<?> liveData) {
            liveData.tl(this);
        }

        @Override // q9.fb
        /* renamed from: gv */
        public void zn(LiveData<?> liveData) {
            co v2 = v();
            if (v2 != null) {
                liveData.s(v2, this);
            }
        }

        @Override // q9.fb
        public void n3(@Nullable co coVar) {
            co v2 = v();
            LiveData<?> n32 = this.y.n3();
            if (n32 != null) {
                if (v2 != null) {
                    n32.tl(this);
                }
                if (coVar != null) {
                    n32.s(coVar, this);
                }
            }
            if (coVar != null) {
                this.f2407n3 = new WeakReference<>(coVar);
            }
        }

        @Override // y5.fh
        public void onChanged(@Nullable Object obj) {
            ViewDataBinding y = this.y.y();
            if (y != null) {
                q9.i9<LiveData<?>> i9Var = this.y;
                y.wf(i9Var.f12787n3, i9Var.n3(), 0);
            }
        }

        @Nullable
        public final co v() {
            WeakReference<co> weakReference = this.f2407n3;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements q9.y {
        @Override // q9.y
        public q9.i9 y(ViewDataBinding viewDataBinding, int i, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new f(viewDataBinding, i, referenceQueue).v();
        }
    }

    /* loaded from: classes.dex */
    public class s implements Choreographer.FrameCallback {
        public s() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            ViewDataBinding.this.f2402v.run();
        }
    }

    /* loaded from: classes.dex */
    public class v extends zn.y<q9.s, ViewDataBinding, Void> {
        @Override // androidx.databinding.zn.y
        /* renamed from: n3 */
        public void y(q9.s sVar, ViewDataBinding viewDataBinding, int i, Void r42) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        sVar.y(viewDataBinding);
                        return;
                    }
                    return;
                }
                sVar.n3(viewDataBinding);
            } else if (!sVar.zn(viewDataBinding)) {
                viewDataBinding.f2400s = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements q9.y {
        @Override // q9.y
        public q9.i9 y(ViewDataBinding viewDataBinding, int i, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new tl(viewDataBinding, i, referenceQueue).a();
        }
    }

    /* loaded from: classes.dex */
    public class zn implements q9.y {
        @Override // q9.y
        public q9.i9 y(ViewDataBinding viewDataBinding, int i, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new t(viewDataBinding, i, referenceQueue).v();
        }
    }

    public ViewDataBinding(q9.zn znVar, View view, int i) {
        this.f2402v = new fb();
        this.f2395fb = false;
        this.f2400s = false;
        this.f2394f3 = znVar;
        this.f2393f = new q9.i9[i];
        this.f2401t = view;
        if (Looper.myLooper() != null) {
            if (f2379b) {
                this.f2390co = Choreographer.getInstance();
                this.f2404z = new s();
                return;
            }
            this.f2404z = null;
            this.f2399r = new Handler(Looper.myLooper());
            return;
        }
        throw new IllegalStateException("DataBinding must be created in view's UI Thread");
    }

    public static int bk(String str, int i, c5 c5Var, int i5) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = c5Var.y[i5];
        int length = strArr.length;
        while (i < length) {
            if (TextUtils.equals(subSequence, strArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int cr() {
        return f2380ej;
    }

    public static void g(ViewDataBinding viewDataBinding) {
        viewDataBinding.g3();
    }

    public static <T extends ViewDataBinding> T gq(@NonNull LayoutInflater layoutInflater, int i, @Nullable ViewGroup viewGroup, boolean z2, @Nullable Object obj) {
        return (T) q9.gv.i9(layoutInflater, i, viewGroup, z2, kp(obj));
    }

    public static float i3(Float f4) {
        if (f4 == null) {
            return 0.0f;
        }
        return f4.floatValue();
    }

    public static void ix() {
        while (true) {
            Reference<? extends ViewDataBinding> poll = f2387ut.poll();
            if (poll != null) {
                if (poll instanceof q9.i9) {
                    ((q9.i9) poll).v();
                }
            } else {
                return;
            }
        }
    }

    public static long j3(Long l2) {
        if (l2 == null) {
            return 0L;
        }
        return l2.longValue();
    }

    public static q9.zn kp(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof q9.zn) {
            return (q9.zn) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    public static Object[] le(q9.zn znVar, View[] viewArr, int i, c5 c5Var, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i];
        for (View view : viewArr) {
            q5(znVar, view, objArr, c5Var, sparseIntArray, true);
        }
        return objArr;
    }

    public static Object[] mp(q9.zn znVar, View view, int i, c5 c5Var, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i];
        q5(znVar, view, objArr, c5Var, sparseIntArray, true);
        return objArr;
    }

    public static boolean ne(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static int o0(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getContext().getColor(i);
        }
        return view.getResources().getColor(i);
    }

    public static ViewDataBinding pz(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R$id.dataBinding);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0112 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void q5(q9.zn r16, android.view.View r17, java.lang.Object[] r18, androidx.databinding.ViewDataBinding.c5 r19, android.util.SparseIntArray r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.q5(q9.zn, android.view.View, java.lang.Object[], androidx.databinding.ViewDataBinding$c5, android.util.SparseIntArray, boolean):void");
    }

    public static int ro(String str, int i) {
        int length = str.length();
        int i5 = 0;
        while (i < length) {
            i5 = (i5 * 10) + (str.charAt(i) - '0');
            i++;
        }
        return i5;
    }

    public static int vn(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static boolean w9(String str, int i) {
        int length = str.length();
        if (length == i) {
            return false;
        }
        while (i < length) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static int y4(ViewGroup viewGroup, int i) {
        String str;
        String str2 = (String) viewGroup.getChildAt(i).getTag();
        String substring = str2.substring(0, str2.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i5 = i + 1; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt.getTag() instanceof String) {
                str = (String) childAt.getTag();
            } else {
                str = null;
            }
            if (str != null && str.startsWith(substring)) {
                if (str.length() == str2.length() && str.charAt(str.length() - 1) == '0') {
                    return i;
                }
                if (w9(str, length)) {
                    i = i5;
                }
            }
        }
        return i;
    }

    public static ViewDataBinding yg(Object obj, View view, int i) {
        return q9.gv.zn(kp(obj), view, i);
    }

    public boolean br(int i) {
        q9.i9 i9Var = this.f2393f[i];
        if (i9Var != null) {
            return i9Var.v();
        }
        return false;
    }

    public abstract boolean bv(int i, @Nullable Object obj);

    public abstract boolean cs(int i, Object obj, int i5);

    public abstract boolean cy();

    public void fc() {
        q9.i9[] i9VarArr;
        for (q9.i9 i9Var : this.f2393f) {
            if (i9Var != null) {
                i9Var.v();
            }
        }
    }

    public final void g3() {
        if (this.f2398p) {
            i2();
        } else if (!cy()) {
        } else {
            this.f2398p = true;
            this.f2400s = false;
            androidx.databinding.zn<q9.s, ViewDataBinding, Void> znVar = this.f2403w;
            if (znVar != null) {
                znVar.a(this, 1, null);
                if (this.f2400s) {
                    this.f2403w.a(this, 2, null);
                }
            }
            if (!this.f2400s) {
                rb();
                androidx.databinding.zn<q9.s, ViewDataBinding, Void> znVar2 = this.f2403w;
                if (znVar2 != null) {
                    znVar2.a(this, 3, null);
                }
            }
            this.f2398p = false;
        }
    }

    @Override // wf.y
    @NonNull
    public View getRoot() {
        return this.f2401t;
    }

    public void gf(View[] viewArr) {
        for (View view : viewArr) {
            view.setTag(R$id.dataBinding, this);
        }
    }

    public void i2() {
        ViewDataBinding viewDataBinding = this.f2397n;
        if (viewDataBinding != null) {
            viewDataBinding.i2();
            return;
        }
        co coVar = this.f2389c;
        if (coVar != null && !coVar.getLifecycle().n3().y(v.zn.STARTED)) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f2395fb) {
                    return;
                }
                this.f2395fb = true;
                if (f2379b) {
                    this.f2390co.postFrameCallback(this.f2404z);
                } else {
                    this.f2399r.post(this.f2402v);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean im(int i, androidx.databinding.gv gvVar) {
        return mh(i, gvVar, f2382j5);
    }

    public boolean mh(int i, Object obj, q9.y yVar) {
        if (obj == null) {
            return br(i);
        }
        q9.i9 i9Var = this.f2393f[i];
        if (i9Var == null) {
            yk(i, obj, yVar);
            return true;
        } else if (i9Var.n3() == obj) {
            return false;
        } else {
            br(i);
            yk(i, obj, yVar);
            return true;
        }
    }

    public void nd(View view) {
        view.setTag(R$id.dataBinding, this);
    }

    public abstract void oa();

    public void q(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.f2397n = this;
        }
    }

    public abstract void rb();

    public void s8(@NonNull q9.s sVar) {
        if (this.f2403w == null) {
            this.f2403w = new androidx.databinding.zn<>(f2384oz);
        }
        this.f2403w.n3(sVar);
    }

    public void tg() {
        rb();
    }

    public void u0() {
        ViewDataBinding viewDataBinding = this.f2397n;
        if (viewDataBinding == null) {
            g3();
        } else {
            viewDataBinding.u0();
        }
    }

    public boolean uo(int i, LiveData<?> liveData) {
        this.f2396fh = true;
        try {
            return mh(i, liveData, f2381j);
        } finally {
            this.f2396fh = false;
        }
    }

    public void wf(int i, Object obj, int i5) {
        if (!this.f2396fh && !this.f2391d && cs(i, obj, i5)) {
            i2();
        }
    }

    public void wm(@Nullable co coVar) {
        q9.i9[] i9VarArr;
        if (coVar instanceof Fragment) {
            Log.w("DataBinding", "Setting the fragment as the LifecycleOwner might cause memory leaks because views lives shorter than the Fragment. Consider using Fragment's view lifecycle");
        }
        co coVar2 = this.f2389c;
        if (coVar2 == coVar) {
            return;
        }
        if (coVar2 != null) {
            coVar2.getLifecycle().zn(this.f2392d0);
        }
        this.f2389c = coVar;
        if (coVar != null) {
            if (this.f2392d0 == null) {
                this.f2392d0 = new OnStartListener(this, null);
            }
            coVar.getLifecycle().y(this.f2392d0);
        }
        for (q9.i9 i9Var : this.f2393f) {
            if (i9Var != null) {
                i9Var.zn(coVar);
            }
        }
    }

    @Nullable
    public co xb() {
        return this.f2389c;
    }

    public void yk(int i, Object obj, q9.y yVar) {
        if (obj == null) {
            return;
        }
        q9.i9 i9Var = this.f2393f[i];
        if (i9Var == null) {
            i9Var = yVar.y(this, i, f2387ut);
            this.f2393f[i] = i9Var;
            co coVar = this.f2389c;
            if (coVar != null) {
                i9Var.zn(coVar);
            }
        }
        i9Var.gv(obj);
    }

    public ViewDataBinding(Object obj, View view, int i) {
        this(kp(obj), view, i);
    }

    /* loaded from: classes.dex */
    public static class f extends v.y implements q9.fb<androidx.databinding.v> {
        public final q9.i9<androidx.databinding.v> y;

        public f(ViewDataBinding viewDataBinding, int i, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.y = new q9.i9<>(viewDataBinding, i, this, referenceQueue);
        }

        @Override // q9.fb
        /* renamed from: a */
        public void y(androidx.databinding.v vVar) {
            vVar.s(this);
        }

        @Override // q9.fb
        /* renamed from: gv */
        public void zn(androidx.databinding.v vVar) {
            vVar.o0(this);
        }

        public q9.i9<androidx.databinding.v> v() {
            return this.y;
        }

        @Override // q9.fb
        public void n3(co coVar) {
        }
    }

    /* loaded from: classes.dex */
    public static class t extends a.y implements q9.fb<androidx.databinding.a> {
        public final q9.i9<androidx.databinding.a> y;

        public t(ViewDataBinding viewDataBinding, int i, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.y = new q9.i9<>(viewDataBinding, i, this, referenceQueue);
        }

        @Override // q9.fb
        /* renamed from: a */
        public void y(androidx.databinding.a aVar) {
            aVar.a(this);
        }

        @Override // q9.fb
        /* renamed from: gv */
        public void zn(androidx.databinding.a aVar) {
            aVar.gv(this);
        }

        public q9.i9<androidx.databinding.a> v() {
            return this.y;
        }

        @Override // q9.fb
        public void n3(co coVar) {
        }
    }

    /* loaded from: classes.dex */
    public static class tl extends gv.y implements q9.fb<androidx.databinding.gv> {
        public final q9.i9<androidx.databinding.gv> y;

        public tl(ViewDataBinding viewDataBinding, int i, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.y = new q9.i9<>(viewDataBinding, i, this, referenceQueue);
        }

        public q9.i9<androidx.databinding.gv> a() {
            return this.y;
        }

        @Override // q9.fb
        /* renamed from: fb */
        public void y(androidx.databinding.gv gvVar) {
            gvVar.r(this);
        }

        @Override // androidx.databinding.gv.y
        public void gv(androidx.databinding.gv gvVar, int i) {
            ViewDataBinding y = this.y.y();
            if (y == null || this.y.n3() != gvVar) {
                return;
            }
            y.wf(this.y.f12787n3, gvVar, i);
        }

        @Override // q9.fb
        /* renamed from: v */
        public void zn(androidx.databinding.gv gvVar) {
            gvVar.gv(this);
        }

        @Override // q9.fb
        public void n3(co coVar) {
        }
    }
}
