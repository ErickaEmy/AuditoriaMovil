package hw;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.R$id;
import hw.ej;
import hw.i4;
import hw.y;
import j5.zn;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class i4 {

    /* renamed from: v  reason: collision with root package name */
    public static ThreadLocal<Rect> f8971v;

    /* renamed from: zn  reason: collision with root package name */
    public static Field f8972zn;
    public static final AtomicInteger y = new AtomicInteger(1);

    /* renamed from: n3  reason: collision with root package name */
    public static WeakHashMap<View, mg> f8969n3 = null;

    /* renamed from: gv  reason: collision with root package name */
    public static boolean f8968gv = false;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f8966a = {R$id.f2117n3, R$id.f2138zn, R$id.f2131wz, R$id.f2116n, R$id.f2107fh, R$id.f2122rz, R$id.f2114mg, R$id.f2125ta, R$id.f2101d, R$id.f2137z6, R$id.f2108gv, R$id.f2128v, R$id.f2095a, R$id.f2106fb, R$id.f2123s, R$id.f2099c5, R$id.f2111i9, R$id.f2104f, R$id.f2124t, R$id.f2126tl, R$id.f2134xc, R$id.f2130w, R$id.f2119p, R$id.f2115mt, R$id.f2100co, R$id.f2136z, R$id.f2121r, R$id.f2133x4, R$id.f2110i4, R$id.f2105f3, R$id.f2098c, R$id.f2102d0};

    /* renamed from: fb  reason: collision with root package name */
    public static final hw.mt f8967fb = new hw.mt() { // from class: hw.x4
        @Override // hw.mt
        public final zn y(zn znVar) {
            zn jz2;
            jz2 = i4.jz(znVar);
            return jz2;
        }
    };

    /* renamed from: s  reason: collision with root package name */
    public static final v f8970s = new v();

    /* loaded from: classes.dex */
    public static abstract class a<T> {

        /* renamed from: gv  reason: collision with root package name */
        public final int f8973gv;

        /* renamed from: n3  reason: collision with root package name */
        public final Class<T> f8974n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f8975zn;

        public a(int i, Class<T> cls, int i5) {
            this(i, cls, 0, i5);
        }

        public T a(View view) {
            if (zn()) {
                return gv(view);
            }
            if (n3()) {
                T t2 = (T) view.getTag(this.y);
                if (this.f8974n3.isInstance(t2)) {
                    return t2;
                }
                return null;
            }
            return null;
        }

        public void fb(View view, T t2) {
            if (zn()) {
                v(view, t2);
            } else if (n3() && s(a(view), t2)) {
                i4.t(view);
                view.setTag(this.y, t2);
                i4.u(view, this.f8973gv);
            }
        }

        public abstract T gv(View view);

        public final boolean n3() {
            return true;
        }

        public abstract boolean s(T t2, T t3);

        public abstract void v(View view, T t2);

        public boolean y(Boolean bool, Boolean bool2) {
            boolean z2;
            boolean z3;
            if (bool != null && bool.booleanValue()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (bool2 != null && bool2.booleanValue()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 != z3) {
                return false;
            }
            return true;
        }

        public final boolean zn() {
            if (Build.VERSION.SDK_INT >= this.f8975zn) {
                return true;
            }
            return false;
        }

        public a(int i, Class<T> cls, int i5, int i6) {
            this.y = i;
            this.f8974n3 = cls;
            this.f8973gv = i5;
            this.f8975zn = i6;
        }
    }

    /* loaded from: classes.dex */
    public static class c5 {
        public static int a(View view) {
            return view.getPaddingStart();
        }

        public static void c5(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        public static void f(View view, int i, int i5, int i6, int i8) {
            view.setPaddingRelative(i, i5, i6, i8);
        }

        public static boolean fb(View view) {
            return view.isPaddingRelative();
        }

        public static int gv(View view) {
            return view.getLayoutDirection();
        }

        public static void i9(View view, int i) {
            view.setLayoutDirection(i);
        }

        public static Display n3(@NonNull View view) {
            return view.getDisplay();
        }

        public static void s(View view, int i) {
            view.setLabelFor(i);
        }

        public static int v(View view) {
            return view.getPaddingEnd();
        }

        public static int y() {
            return View.generateViewId();
        }

        public static int zn(View view) {
            return view.getLabelFor();
        }
    }

    /* loaded from: classes.dex */
    public static class co {
        public static void gv(View view, int i) {
            view.setImportantForContentCapture(i);
        }

        public static CharSequence n3(View view) {
            return view.getStateDescription();
        }

        public static void v(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        public static int y(View view) {
            return view.getImportantForContentCapture();
        }

        public static boolean zn(View view) {
            return view.isImportantForContentCapture();
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public static void a(View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        public static void fb(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }

        public static boolean gv(@NonNull View view) {
            return view.isLayoutDirectionResolved();
        }

        public static boolean n3(@NonNull View view) {
            return view.isAttachedToWindow();
        }

        public static void v(ViewParent viewParent, View view, View view2, int i) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i);
        }

        public static int y(View view) {
            return view.getAccessibilityLiveRegion();
        }

        public static boolean zn(@NonNull View view) {
            return view.isLaidOut();
        }
    }

    /* loaded from: classes.dex */
    public static class fb {
        public static boolean y(@NonNull View view) {
            return view.hasOnClickListeners();
        }
    }

    /* loaded from: classes.dex */
    public class gv extends a<Boolean> {
        public gv(int i, Class cls, int i5) {
            super(i, cls, i5);
        }

        @Override // hw.i4.a
        /* renamed from: c5 */
        public Boolean gv(View view) {
            return Boolean.valueOf(p.zn(view));
        }

        @Override // hw.i4.a
        /* renamed from: f */
        public boolean s(Boolean bool, Boolean bool2) {
            return !y(bool, bool2);
        }

        @Override // hw.i4.a
        /* renamed from: i9 */
        public void v(View view, Boolean bool) {
            p.fb(view, bool.booleanValue());
        }
    }

    /* renamed from: hw.i4$i4  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0108i4 {

        /* renamed from: gv  reason: collision with root package name */
        public static final ArrayList<WeakReference<View>> f8976gv = new ArrayList<>();

        /* renamed from: n3  reason: collision with root package name */
        public SparseArray<WeakReference<View>> f8977n3;
        @Nullable
        public WeakHashMap<View, Boolean> y;

        /* renamed from: zn  reason: collision with root package name */
        public WeakReference<KeyEvent> f8978zn;

        public static C0108i4 y(View view) {
            int i = R$id.f2112j5;
            C0108i4 c0108i4 = (C0108i4) view.getTag(i);
            if (c0108i4 == null) {
                C0108i4 c0108i42 = new C0108i4();
                view.setTag(i, c0108i42);
                return c0108i42;
            }
            return c0108i4;
        }

        public boolean a(KeyEvent keyEvent) {
            WeakReference<View> weakReference;
            int indexOfKey;
            WeakReference<KeyEvent> weakReference2 = this.f8978zn;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f8978zn = new WeakReference<>(keyEvent);
            SparseArray<WeakReference<View>> gv2 = gv();
            if (keyEvent.getAction() == 1 && (indexOfKey = gv2.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference = gv2.valueAt(indexOfKey);
                gv2.removeAt(indexOfKey);
            } else {
                weakReference = null;
            }
            if (weakReference == null) {
                weakReference = gv2.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = weakReference.get();
            if (view != null && i4.ut(view)) {
                v(view, keyEvent);
            }
            return true;
        }

        public final void fb() {
            WeakHashMap<View, Boolean> weakHashMap = this.y;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f8976gv;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.y == null) {
                        this.y = new WeakHashMap<>();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList<WeakReference<View>> arrayList2 = f8976gv;
                        View view = arrayList2.get(size).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.y.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.y.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final SparseArray<WeakReference<View>> gv() {
            if (this.f8977n3 == null) {
                this.f8977n3 = new SparseArray<>();
            }
            return this.f8977n3;
        }

        public boolean n3(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                fb();
            }
            View zn2 = zn(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (zn2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    gv().put(keyCode, new WeakReference<>(zn2));
                }
            }
            if (zn2 != null) {
                return true;
            }
            return false;
        }

        public final boolean v(@NonNull View view, @NonNull KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R$id.f2120qn);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((x4) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Nullable
        public final View zn(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.y;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View zn2 = zn(viewGroup.getChildAt(childCount), keyEvent);
                        if (zn2 != null) {
                            return zn2;
                        }
                    }
                }
                if (v(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class i9 {
        public static boolean n3(@NonNull View view) {
            return view.isInLayout();
        }

        public static Rect y(@NonNull View view) {
            return view.getClipBounds();
        }

        public static void zn(@NonNull View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    /* loaded from: classes.dex */
    public static class mt {
        public static void a(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }

        public static void gv(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i, int i5) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i5);
        }

        public static ContentCaptureSession n3(View view) {
            return view.getContentCaptureSession();
        }

        public static void v(View view, ContentCaptureSession contentCaptureSession) {
            view.setContentCaptureSession(contentCaptureSession);
        }

        public static View.AccessibilityDelegate y(View view) {
            return view.getAccessibilityDelegate();
        }

        public static List<Rect> zn(View view) {
            return view.getSystemGestureExclusionRects();
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends a<CharSequence> {
        public n3(int i, Class cls, int i5, int i6) {
            super(i, cls, i5, i6);
        }

        @Override // hw.i4.a
        /* renamed from: c5 */
        public CharSequence gv(View view) {
            return p.n3(view);
        }

        @Override // hw.i4.a
        /* renamed from: f */
        public boolean s(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }

        @Override // hw.i4.a
        /* renamed from: i9 */
        public void v(View view, CharSequence charSequence) {
            p.s(view, charSequence);
        }
    }

    /* loaded from: classes.dex */
    public static class p {
        public static <T> T a(View view, int i) {
            return (T) view.requireViewById(i);
        }

        public static void c5(View view, AutofillId autofillId) {
            view.setAutofillId(autofillId);
        }

        public static void fb(View view, boolean z2) {
            view.setAccessibilityHeading(z2);
        }

        public static boolean gv(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void i9(View view, boolean z2) {
            view.setScreenReaderFocusable(z2);
        }

        public static CharSequence n3(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static void s(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void v(@NonNull View view, @NonNull x4 x4Var) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            z.s sVar = (z.s) view.getTag(R$id.f2120qn);
            if (sVar != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) sVar.get(x4Var)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }

        public static void y(@NonNull View view, @NonNull final x4 x4Var) {
            int i = R$id.f2120qn;
            z.s sVar = (z.s) view.getTag(i);
            if (sVar == null) {
                sVar = new z.s();
                view.setTag(i, sVar);
            }
            Objects.requireNonNull(x4Var);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: hw.f3
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return i4.x4.this.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            sVar.put(x4Var, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static boolean zn(View view) {
            return view.isAccessibilityHeading();
        }
    }

    /* loaded from: classes.dex */
    public static final class r implements OnReceiveContentListener {
        @NonNull
        public final hw.p y;

        public r(@NonNull hw.p pVar) {
            this.y = pVar;
        }

        @Override // android.view.OnReceiveContentListener
        @Nullable
        public ContentInfo onReceiveContent(@NonNull View view, @NonNull ContentInfo contentInfo) {
            hw.zn fb2 = hw.zn.fb(contentInfo);
            hw.zn y = this.y.y(view, fb2);
            if (y == null) {
                return null;
            }
            if (y == fb2) {
                return contentInfo;
            }
            return y.a();
        }
    }

    /* loaded from: classes.dex */
    public static class s {
        public static ViewParent a(View view) {
            return view.getParentForAccessibility();
        }

        public static boolean c5(View view) {
            return view.hasTransientState();
        }

        public static void co(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        public static void f(View view) {
            view.postInvalidateOnAnimation();
        }

        public static int fb(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public static int gv(View view) {
            return view.getMinimumHeight();
        }

        public static boolean i9(View view, int i, Bundle bundle) {
            return view.performAccessibilityAction(i, bundle);
        }

        public static void mt(View view, boolean z2) {
            view.setHasTransientState(z2);
        }

        public static boolean n3(View view) {
            return view.getFitsSystemWindows();
        }

        public static void p(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public static boolean s(View view) {
            return view.hasOverlappingRendering();
        }

        public static void t(View view, int i, int i5, int i6, int i8) {
            view.postInvalidateOnAnimation(i, i5, i6, i8);
        }

        public static void tl(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public static int v(View view) {
            return view.getMinimumWidth();
        }

        public static void w(View view) {
            view.requestFitSystemWindows();
        }

        public static void wz(View view, Runnable runnable, long j2) {
            view.postOnAnimationDelayed(runnable, j2);
        }

        public static void xc(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public static AccessibilityNodeProvider y(View view) {
            return view.getAccessibilityNodeProvider();
        }

        public static int zn(View view) {
            return view.getImportantForAccessibility();
        }
    }

    /* loaded from: classes.dex */
    public static class t {
        public static WindowInsets n3(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static WindowInsets y(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static void zn(View view) {
            view.requestApplyInsets();
        }
    }

    /* loaded from: classes.dex */
    public static class tl {

        /* loaded from: classes.dex */
        public class y implements View.OnApplyWindowInsetsListener {

            /* renamed from: n3  reason: collision with root package name */
            public final /* synthetic */ View f8979n3;
            public ej y;

            /* renamed from: zn  reason: collision with root package name */
            public final /* synthetic */ hw.w f8980zn;

            public y(View view, hw.w wVar) {
                this.f8979n3 = view;
                this.f8980zn = wVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                ej f32 = ej.f3(windowInsets, view);
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    tl.y(windowInsets, this.f8979n3);
                    if (f32.equals(this.y)) {
                        return this.f8980zn.y(view, f32).x4();
                    }
                }
                this.y = f32;
                ej y = this.f8980zn.y(view, f32);
                if (i >= 30) {
                    return y.x4();
                }
                i4.yg(view);
                return y.x4();
            }
        }

        public static boolean a(View view, int i, int i5, int i6, int i8, int[] iArr) {
            return view.dispatchNestedScroll(i, i5, i6, i8, iArr);
        }

        public static void c(View view) {
            view.stopNestedScroll();
        }

        public static float c5(View view) {
            return view.getElevation();
        }

        public static void co(View view, float f4) {
            view.setElevation(f4);
        }

        public static String f(View view) {
            return view.getTransitionName();
        }

        public static void f3(@NonNull View view, float f4) {
            view.setZ(f4);
        }

        public static ColorStateList fb(View view) {
            return view.getBackgroundTintList();
        }

        public static boolean gv(@NonNull View view, float f4, float f6) {
            return view.dispatchNestedPreFling(f4, f6);
        }

        public static void i4(View view, float f4) {
            view.setTranslationZ(f4);
        }

        @Nullable
        public static ej i9(@NonNull View view) {
            return ej.y.y(view);
        }

        public static void mt(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static boolean n(View view, int i) {
            return view.startNestedScroll(i);
        }

        public static ej n3(@NonNull View view, @NonNull ej ejVar, @NonNull Rect rect) {
            WindowInsets x42 = ejVar.x4();
            if (x42 != null) {
                return ej.f3(view.computeSystemWindowInsets(x42, rect), view);
            }
            rect.setEmpty();
            return ejVar;
        }

        public static void p(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void r(@NonNull View view, @Nullable hw.w wVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R$id.f2097b, wVar);
            }
            if (wVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R$id.f2118o));
            } else {
                view.setOnApplyWindowInsetsListener(new y(view, wVar));
            }
        }

        public static PorterDuff.Mode s(View view) {
            return view.getBackgroundTintMode();
        }

        public static float t(View view) {
            return view.getTranslationZ();
        }

        public static float tl(@NonNull View view) {
            return view.getZ();
        }

        public static boolean v(View view, int i, int i5, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i, i5, iArr, iArr2);
        }

        public static boolean w(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static boolean wz(View view) {
            return view.hasNestedScrollingParent();
        }

        public static void x4(View view, String str) {
            view.setTransitionName(str);
        }

        public static boolean xc(View view) {
            return view.isImportantForAccessibility();
        }

        public static void y(@NonNull WindowInsets windowInsets, @NonNull View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R$id.f2118o);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static void z(View view, boolean z2) {
            view.setNestedScrollingEnabled(z2);
        }

        public static boolean zn(@NonNull View view, float f4, float f6, boolean z2) {
            return view.dispatchNestedFling(f4, f6, z2);
        }
    }

    /* loaded from: classes.dex */
    public static class w {
        public static boolean a(@NonNull View view) {
            return view.isFocusedByDefault();
        }

        public static View c5(@NonNull View view, View view2, int i) {
            return view.keyboardNavigationClusterSearch(view2, i);
        }

        public static void f(@NonNull View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        public static boolean fb(View view) {
            return view.isImportantForAutofill();
        }

        public static int gv(@NonNull View view) {
            return view.getNextClusterForwardId();
        }

        public static boolean i9(@NonNull View view) {
            return view.restoreDefaultFocus();
        }

        public static AutofillId n3(View view) {
            return view.getAutofillId();
        }

        public static boolean s(@NonNull View view) {
            return view.isKeyboardNavigationCluster();
        }

        public static void t(@NonNull View view, boolean z2) {
            view.setFocusedByDefault(z2);
        }

        public static void tl(View view, int i) {
            view.setImportantForAutofill(i);
        }

        public static boolean v(@NonNull View view) {
            return view.hasExplicitFocusable();
        }

        public static void w(@NonNull View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }

        public static void wz(@NonNull View view, boolean z2) {
            view.setKeyboardNavigationCluster(z2);
        }

        public static void xc(View view, int i) {
            view.setNextClusterForwardId(i);
        }

        public static void y(@NonNull View view, Collection<View> collection, int i) {
            view.addKeyboardNavigationClusters(collection, i);
        }

        public static int zn(View view) {
            return view.getImportantForAutofill();
        }
    }

    /* loaded from: classes.dex */
    public static class wz {
        public static void gv(@NonNull View view, int i, int i5) {
            view.setScrollIndicators(i, i5);
        }

        public static int n3(@NonNull View view) {
            return view.getScrollIndicators();
        }

        @Nullable
        public static ej y(@NonNull View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            ej i42 = ej.i4(rootWindowInsets);
            i42.z(i42);
            i42.gv(view.getRootView());
            return i42;
        }

        public static void zn(@NonNull View view, int i) {
            view.setScrollIndicators(i);
        }
    }

    /* loaded from: classes.dex */
    public interface x4 {
        boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent);
    }

    /* loaded from: classes.dex */
    public static class xc {
        public static void a(@NonNull View view, @NonNull View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }

        public static void gv(@NonNull View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        public static void n3(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        public static boolean v(@NonNull View view, @Nullable ClipData clipData, @NonNull View.DragShadowBuilder dragShadowBuilder, @Nullable Object obj, int i) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        }

        public static void y(@NonNull View view) {
            view.cancelDragAndDrop();
        }

        public static void zn(View view) {
            view.dispatchStartTemporaryDetach();
        }
    }

    /* loaded from: classes.dex */
    public class y extends a<Boolean> {
        public y(int i, Class cls, int i5) {
            super(i, cls, i5);
        }

        @Override // hw.i4.a
        /* renamed from: c5 */
        public Boolean gv(@NonNull View view) {
            return Boolean.valueOf(p.gv(view));
        }

        @Override // hw.i4.a
        /* renamed from: f */
        public boolean s(Boolean bool, Boolean bool2) {
            return !y(bool, bool2);
        }

        @Override // hw.i4.a
        /* renamed from: i9 */
        public void v(@NonNull View view, Boolean bool) {
            p.i9(view, bool.booleanValue());
        }
    }

    /* loaded from: classes.dex */
    public static final class z {
        @Nullable
        public static hw.zn n3(@NonNull View view, @NonNull hw.zn znVar) {
            ContentInfo a2 = znVar.a();
            ContentInfo performReceiveContent = view.performReceiveContent(a2);
            if (performReceiveContent == null) {
                return null;
            }
            if (performReceiveContent == a2) {
                return znVar;
            }
            return hw.zn.fb(performReceiveContent);
        }

        @Nullable
        public static String[] y(@NonNull View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static void zn(@NonNull View view, @Nullable String[] strArr, @Nullable hw.p pVar) {
            if (pVar == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new r(pVar));
            }
        }
    }

    /* loaded from: classes.dex */
    public class zn extends a<CharSequence> {
        public zn(int i, Class cls, int i5, int i6) {
            super(i, cls, i5, i6);
        }

        @Override // hw.i4.a
        /* renamed from: c5 */
        public CharSequence gv(View view) {
            return co.n3(view);
        }

        @Override // hw.i4.a
        /* renamed from: f */
        public boolean s(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }

        @Override // hw.i4.a
        /* renamed from: i9 */
        public void v(View view, CharSequence charSequence) {
            co.v(view, charSequence);
        }
    }

    public static void a(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            x5(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                x5((View) parent);
            }
        }
    }

    public static int a8(@NonNull View view) {
        return c5.a(view);
    }

    public static void ad(@NonNull View view, @Nullable hw.w wVar) {
        tl.r(view, wVar);
    }

    public static void ap(@NonNull View view, @NonNull zn.y yVar, @Nullable CharSequence charSequence, @Nullable j5.a aVar) {
        if (aVar == null && charSequence == null) {
            e(view, yVar.n3());
        } else {
            gv(view, yVar.y(charSequence, aVar));
        }
    }

    @Nullable
    public static ej b(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return wz.y(view);
        }
        return tl.i9(view);
    }

    public static void bk(@NonNull View view, @Nullable ColorStateList colorStateList) {
        boolean z2;
        int i = Build.VERSION.SDK_INT;
        tl.p(view, colorStateList);
        if (i == 21) {
            Drawable background = view.getBackground();
            if (tl.fb(view) == null && tl.s(view) == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (background != null && z2) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                s.p(view, background);
            }
        }
    }

    public static Rect c() {
        if (f8971v == null) {
            f8971v = new ThreadLocal<>();
        }
        Rect rect = f8971v.get();
        if (rect == null) {
            rect = new Rect();
            f8971v.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    @NonNull
    public static ej c5(@NonNull View view, @NonNull ej ejVar) {
        WindowInsets x42 = ejVar.x4();
        if (x42 != null) {
            WindowInsets y2 = t.y(view, x42);
            if (!y2.equals(x42)) {
                return ej.f3(y2, view);
            }
        }
        return ejVar;
    }

    public static List<zn.y> co(View view) {
        int i = R$id.f2103ej;
        ArrayList arrayList = (ArrayList) view.getTag(i);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(i, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    public static void cr(@NonNull View view, boolean z2) {
        s.mt(view, z2);
    }

    public static void ct(@NonNull View view, @NonNull j5.zn znVar) {
        view.onInitializeAccessibilityNodeInfo(znVar.w9());
    }

    public static void cy(@NonNull View view, int i, int i5, int i6, int i8) {
        c5.f(view, i, i5, i6, i8);
    }

    public static int d(@NonNull View view) {
        return s.gv(view);
    }

    public static hw.mt d0(@NonNull View view) {
        if (view instanceof hw.mt) {
            return (hw.mt) view;
        }
        return f8967fb;
    }

    @NonNull
    public static ej dm(@NonNull View view, @NonNull ej ejVar) {
        WindowInsets x42 = ejVar.x4();
        if (x42 != null) {
            WindowInsets n32 = t.n3(view, x42);
            if (!n32.equals(x42)) {
                return ej.f3(n32, view);
            }
        }
        return ejVar;
    }

    public static void e(@NonNull View view, int i) {
        s8(i, view);
        u(view, 0);
    }

    @Nullable
    public static hw.zn eb(@NonNull View view, @NonNull hw.zn znVar) {
        Log.isLoggable("ViewCompat", 3);
        if (Build.VERSION.SDK_INT >= 31) {
            return z.n3(view, znVar);
        }
        hw.p pVar = (hw.p) view.getTag(R$id.f2113k5);
        if (pVar != null) {
            hw.zn y2 = pVar.y(view, znVar);
            if (y2 == null) {
                return null;
            }
            return d0(view).y(y2);
        }
        return d0(view).y(znVar);
    }

    @Nullable
    public static String[] ej(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return z.y(view);
        }
        return (String[]) view.getTag(R$id.f2135yt);
    }

    public static boolean en(@NonNull View view) {
        Boolean a2 = rb().a(view);
        if (a2 != null && a2.booleanValue()) {
            return true;
        }
        return false;
    }

    public static boolean f(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return C0108i4.y(view).a(keyEvent);
    }

    @Nullable
    public static Display f3(@NonNull View view) {
        return c5.n3(view);
    }

    public static boolean f7(@NonNull View view) {
        return c5.fb(view);
    }

    public static void fb(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            x5(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                x5((View) parent);
            }
        }
    }

    public static boolean fh(@NonNull View view) {
        return s.n3(view);
    }

    public static void g(@NonNull View view, int i) {
        f.a(view, i);
    }

    public static void g3(@NonNull View view, @Nullable hw.y yVar) {
        View.AccessibilityDelegate gv2;
        if (yVar == null && (xc(view) instanceof y.C0110y)) {
            yVar = new hw.y();
        }
        xb(view);
        if (yVar == null) {
            gv2 = null;
        } else {
            gv2 = yVar.gv();
        }
        view.setAccessibilityDelegate(gv2);
    }

    public static void gq(@NonNull View view, @Nullable String str) {
        tl.x4(view, str);
    }

    public static void gv(@NonNull View view, @NonNull zn.y yVar) {
        t(view);
        s8(yVar.n3(), view);
        co(view).add(yVar);
        u(view, 0);
    }

    @Deprecated
    public static int hw(@NonNull View view) {
        return s.fb(view);
    }

    @Nullable
    public static Rect i4(@NonNull View view) {
        return i9.y(view);
    }

    public static boolean i9(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return C0108i4.y(view).n3(view, keyEvent);
    }

    public static boolean j(@NonNull View view) {
        return s.c5(view);
    }

    public static float j5(@NonNull View view) {
        return tl.tl(view);
    }

    public static boolean k(@NonNull View view) {
        return tl.w(view);
    }

    @Nullable
    public static CharSequence k5(@NonNull View view) {
        return w9().a(view);
    }

    public static void kp(@NonNull View view, @NonNull @SuppressLint({"ContextFirst"}) Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i, int i5) {
        if (Build.VERSION.SDK_INT >= 29) {
            mt.gv(view, context, iArr, attributeSet, typedArray, i, i5);
        }
    }

    public static void l(@NonNull View view, @Nullable CharSequence charSequence) {
        w9().fb(view, charSequence);
    }

    public static void lc(@NonNull View view) {
        s.f(view);
    }

    public static void m(@NonNull View view, boolean z2) {
        n3().fb(view, Boolean.valueOf(z2));
    }

    @SuppressLint({"InlinedApi"})
    public static int mg(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return w.zn(view);
        }
        return 0;
    }

    @Nullable
    public static CharSequence mt(@NonNull View view) {
        return o4().a(view);
    }

    public static float n(@NonNull View view) {
        return tl.c5(view);
    }

    public static a<Boolean> n3() {
        return new gv(R$id.f2096a8, Boolean.class, 28);
    }

    public static void nf(@NonNull View view, @NonNull Runnable runnable) {
        s.tl(view, runnable);
    }

    public static boolean o(@NonNull View view) {
        return s.s(view);
    }

    public static void o0(@NonNull View view, int i) {
        s.co(view, i);
    }

    public static a<CharSequence> o4() {
        return new n3(R$id.f2132x, CharSequence.class, 8, 28);
    }

    public static void oa(@NonNull View view, float f4) {
        tl.f3(view, f4);
    }

    public static boolean oz(@NonNull View view) {
        Boolean a2 = n3().a(view);
        if (a2 != null && a2.booleanValue()) {
            return true;
        }
        return false;
    }

    public static int p(@NonNull View view) {
        return f.y(view);
    }

    @Deprecated
    public static void pq(View view, boolean z2) {
        view.setFitsSystemWindows(z2);
    }

    public static void pz(@NonNull View view, float f4) {
        tl.co(view, f4);
    }

    public static boolean q9(@NonNull View view) {
        return f.zn(view);
    }

    public static void qj(@NonNull View view, int i, int i5) {
        if (Build.VERSION.SDK_INT >= 23) {
            wz.gv(view, i, i5);
        }
    }

    public static void qk(@NonNull View view, @Nullable hw.z zVar) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
            if (zVar != null) {
                obj = zVar.y();
            } else {
                obj = null;
            }
            xc.gv(view, (PointerIcon) obj);
        }
    }

    public static boolean qn(@NonNull View view) {
        return fb.y(view);
    }

    @Nullable
    public static ColorStateList r(@NonNull View view) {
        return tl.fb(view);
    }

    @SuppressLint({"LambdaLast"})
    public static void ra(@NonNull View view, @NonNull Runnable runnable, long j2) {
        s.wz(view, runnable, j2);
    }

    public static a<Boolean> rb() {
        return new y(R$id.f2129vl, Boolean.class, 28);
    }

    public static boolean rs(@NonNull View view, int i, @Nullable Bundle bundle) {
        return s.i9(view, i, bundle);
    }

    public static int rz(@NonNull View view) {
        return s.zn(view);
    }

    @NonNull
    public static ej s(@NonNull View view, @NonNull ej ejVar, @NonNull Rect rect) {
        return tl.n3(view, ejVar, rect);
    }

    public static void s8(int i, View view) {
        List<zn.y> co2 = co(view);
        for (int i5 = 0; i5 < co2.size(); i5++) {
            if (co2.get(i5).n3() == i) {
                co2.remove(i5);
                return;
            }
        }
    }

    public static void t(@NonNull View view) {
        hw.y wz2 = wz(view);
        if (wz2 == null) {
            wz2 = new hw.y();
        }
        g3(view, wz2);
    }

    public static int ta(@NonNull View view) {
        return c5.gv(view);
    }

    public static void tg(@NonNull View view, @Nullable Rect rect) {
        i9.zn(view, rect);
    }

    public static int tl() {
        return c5.y();
    }

    public static void u(View view, int i) {
        boolean z2;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        if (mt(view) != null && view.isShown() && view.getWindowVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i5 = 32;
        if (p(view) == 0 && !z2) {
            if (i == 32) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain);
                obtain.setEventType(32);
                f.fb(obtain, i);
                obtain.setSource(view);
                view.onPopulateAccessibilityEvent(obtain);
                obtain.getText().add(mt(view));
                accessibilityManager.sendAccessibilityEvent(obtain);
                return;
            } else if (view.getParent() != null) {
                try {
                    f.v(view.getParent(), view, view, i);
                    return;
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                    return;
                }
            } else {
                return;
            }
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
        if (!z2) {
            i5 = 2048;
        }
        obtain2.setEventType(i5);
        f.fb(obtain2, i);
        if (z2) {
            obtain2.getText().add(mt(view));
            xb(view);
        }
        view.sendAccessibilityEventUnchecked(obtain2);
    }

    public static void u0(@NonNull View view, @Nullable Drawable drawable) {
        s.p(view, drawable);
    }

    public static int ud(@NonNull View view) {
        return c5.v(view);
    }

    public static boolean ut(@NonNull View view) {
        return f.n3(view);
    }

    @NonNull
    public static mg v(@NonNull View view) {
        if (f8969n3 == null) {
            f8969n3 = new WeakHashMap<>();
        }
        mg mgVar = f8969n3.get(view);
        if (mgVar == null) {
            mg mgVar2 = new mg(view);
            f8969n3.put(view, mgVar2);
            return mgVar2;
        }
        return mgVar;
    }

    public static float vl(@NonNull View view) {
        return tl.t(view);
    }

    public static void vp(@NonNull View view, float f4) {
        tl.i4(view, f4);
    }

    @Nullable
    public static View.AccessibilityDelegate w(@NonNull View view) {
        if (f8968gv) {
            return null;
        }
        if (f8972zn == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f8972zn = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f8968gv = true;
                return null;
            }
        }
        try {
            Object obj = f8972zn.get(view);
            if (!(obj instanceof View.AccessibilityDelegate)) {
                return null;
            }
            return (View.AccessibilityDelegate) obj;
        } catch (Throwable unused2) {
            f8968gv = true;
            return null;
        }
    }

    public static void w2(@NonNull View view) {
        tl.c(view);
    }

    public static a<CharSequence> w9() {
        return new zn(R$id.f2109hw, CharSequence.class, 64, 30);
    }

    public static void wf(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            w.tl(view, i);
        }
    }

    @Nullable
    public static hw.y wz(@NonNull View view) {
        View.AccessibilityDelegate xc2 = xc(view);
        if (xc2 == null) {
            return null;
        }
        if (xc2 instanceof y.C0110y) {
            return ((y.C0110y) xc2).y;
        }
        return new hw.y(xc2);
    }

    @Nullable
    public static ViewParent x(@NonNull View view) {
        return s.a(view);
    }

    @Nullable
    public static PorterDuff.Mode x4(@NonNull View view) {
        return tl.s(view);
    }

    public static void x5(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void xb(View view) {
        if (rz(view) == 0) {
            o0(view, 1);
        }
    }

    @Nullable
    public static View.AccessibilityDelegate xc(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return mt.y(view);
        }
        return w(view);
    }

    public static void xg(@NonNull View view, int i) {
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
            return;
        }
        Rect c2 = c();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            c2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !c2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z2 = false;
        }
        fb(view, i);
        if (z2 && c2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(c2);
        }
    }

    public static void y4(@NonNull View view, @Nullable PorterDuff.Mode mode) {
        boolean z2;
        int i = Build.VERSION.SDK_INT;
        tl.mt(view, mode);
        if (i == 21) {
            Drawable background = view.getBackground();
            if (tl.fb(view) == null && tl.s(view) == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (background != null && z2) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                s.p(view, background);
            }
        }
    }

    public static void y5(@NonNull View view, int i) {
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
            return;
        }
        Rect c2 = c();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            c2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !c2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z2 = false;
        }
        a(view, i);
        if (z2 && c2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(c2);
        }
    }

    @NonNull
    public static <T extends View> T yc(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) p.a(view, i);
        }
        T t2 = (T) view.findViewById(i);
        if (t2 != null) {
            return t2;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    public static void yg(@NonNull View view) {
        t.zn(view);
    }

    @Nullable
    public static String yt(@NonNull View view) {
        return tl.f(view);
    }

    public static int z(View view, @NonNull CharSequence charSequence) {
        boolean z2;
        List<zn.y> co2 = co(view);
        for (int i = 0; i < co2.size(); i++) {
            if (TextUtils.equals(charSequence, co2.get(i).zn())) {
                return co2.get(i).n3();
            }
        }
        int i5 = 0;
        int i6 = -1;
        while (true) {
            int[] iArr = f8966a;
            if (i5 >= iArr.length || i6 != -1) {
                break;
            }
            int i8 = iArr[i5];
            boolean z3 = true;
            for (int i10 = 0; i10 < co2.size(); i10++) {
                if (co2.get(i10).n3() != i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 &= z2;
            }
            if (z3) {
                i6 = i8;
            }
            i5++;
        }
        return i6;
    }

    public static int z6(@NonNull View view) {
        return s.v(view);
    }

    public static int zn(@NonNull View view, @NonNull CharSequence charSequence, @NonNull j5.a aVar) {
        int z2 = z(view, charSequence);
        if (z2 != -1) {
            gv(view, new zn.y(z2, charSequence, aVar));
        }
        return z2;
    }

    /* loaded from: classes.dex */
    public static class v implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        public final WeakHashMap<View, Boolean> y = new WeakHashMap<>();

        public final void n3(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.y.entrySet()) {
                    y(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            n3(view);
        }

        public final void y(View view, boolean z2) {
            boolean z3;
            int i;
            if (view.isShown() && view.getWindowVisibility() == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 != z3) {
                if (z3) {
                    i = 16;
                } else {
                    i = 32;
                }
                i4.u(view, i);
                this.y.put(view, Boolean.valueOf(z3));
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static /* synthetic */ hw.zn jz(hw.zn znVar) {
        return znVar;
    }
}
