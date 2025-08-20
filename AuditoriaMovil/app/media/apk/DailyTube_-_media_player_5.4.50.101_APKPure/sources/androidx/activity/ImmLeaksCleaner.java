package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.lifecycle.a;
import androidx.lifecycle.v;
import java.lang.reflect.Field;
import y5.co;
/* loaded from: classes.dex */
final class ImmLeaksCleaner implements a {

    /* renamed from: f  reason: collision with root package name */
    public static Field f591f;

    /* renamed from: fb  reason: collision with root package name */
    public static Field f592fb;

    /* renamed from: s  reason: collision with root package name */
    public static Field f593s;

    /* renamed from: v  reason: collision with root package name */
    public static int f594v;
    public Activity y;

    public ImmLeaksCleaner(Activity activity) {
        this.y = activity;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void y() {
        try {
            f594v = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f593s = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f591f = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f592fb = declaredField3;
            declaredField3.setAccessible(true);
            f594v = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.a
    public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
        if (n3Var != v.n3.ON_DESTROY) {
            return;
        }
        if (f594v == 0) {
            y();
        }
        if (f594v == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.y.getSystemService("input_method");
            try {
                Object obj = f592fb.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            try {
                                View view = (View) f593s.get(inputMethodManager);
                                if (view == null) {
                                    return;
                                }
                                if (view.isAttachedToWindow()) {
                                    return;
                                }
                                try {
                                    f591f.set(inputMethodManager, null);
                                    inputMethodManager.isActive();
                                } catch (IllegalAccessException unused) {
                                }
                            } catch (ClassCastException unused2) {
                            }
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
