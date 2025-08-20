package c5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.zn;
import java.util.WeakHashMap;
import wz.z6;
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class y {
    public static final ThreadLocal<TypedValue> y = new ThreadLocal<>();

    /* renamed from: n3  reason: collision with root package name */
    public static final WeakHashMap<Context, SparseArray<C0042y>> f3995n3 = new WeakHashMap<>(0);

    /* renamed from: zn  reason: collision with root package name */
    public static final Object f3996zn = new Object();

    /* renamed from: c5.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0042y {

        /* renamed from: n3  reason: collision with root package name */
        public final Configuration f3997n3;
        public final ColorStateList y;

        public C0042y(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration) {
            this.y = colorStateList;
            this.f3997n3 = configuration;
        }
    }

    @Nullable
    public static ColorStateList a(Context context, int i) {
        if (fb(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return zn.y(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    public static boolean fb(@NonNull Context context, int i) {
        Resources resources = context.getResources();
        TypedValue v2 = v();
        resources.getValue(i, v2, true);
        int i5 = v2.type;
        if (i5 >= 28 && i5 <= 31) {
            return true;
        }
        return false;
    }

    @Nullable
    public static Drawable gv(@NonNull Context context, int i) {
        return z6.s().i9(context, i);
    }

    @Nullable
    public static ColorStateList n3(@NonNull Context context, int i) {
        C0042y c0042y;
        synchronized (f3996zn) {
            try {
                SparseArray<C0042y> sparseArray = f3995n3.get(context);
                if (sparseArray != null && sparseArray.size() > 0 && (c0042y = sparseArray.get(i)) != null) {
                    if (c0042y.f3997n3.equals(context.getResources().getConfiguration())) {
                        return c0042y.y;
                    }
                    sparseArray.remove(i);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public static TypedValue v() {
        ThreadLocal<TypedValue> threadLocal = y;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    public static void y(@NonNull Context context, int i, @NonNull ColorStateList colorStateList) {
        synchronized (f3996zn) {
            try {
                WeakHashMap<Context, SparseArray<C0042y>> weakHashMap = f3995n3;
                SparseArray<C0042y> sparseArray = weakHashMap.get(context);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                    weakHashMap.put(context, sparseArray);
                }
                sparseArray.append(i, new C0042y(colorStateList, context.getResources().getConfiguration()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ColorStateList zn(@NonNull Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList n32 = n3(context, i);
        if (n32 != null) {
            return n32;
        }
        ColorStateList a2 = a(context, i);
        if (a2 != null) {
            y(context, i, a2);
            return a2;
        }
        return mg.y.gv(context, i);
    }
}
