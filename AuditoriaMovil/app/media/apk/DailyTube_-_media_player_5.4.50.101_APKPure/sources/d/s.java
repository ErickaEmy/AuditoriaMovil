package d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.s;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class s {
    public static final ThreadLocal<TypedValue> y = new ThreadLocal<>();

    /* renamed from: n3  reason: collision with root package name */
    public static final WeakHashMap<gv, SparseArray<zn>> f6917n3 = new WeakHashMap<>(0);

    /* renamed from: zn  reason: collision with root package name */
    public static final Object f6918zn = new Object();

    /* loaded from: classes.dex */
    public static final class a {

        /* loaded from: classes.dex */
        public static class n3 {
            public static void y(@NonNull Resources.Theme theme) {
                theme.rebase();
            }
        }

        /* loaded from: classes.dex */
        public static class y {

            /* renamed from: n3  reason: collision with root package name */
            public static Method f6919n3;
            public static final Object y = new Object();

            /* renamed from: zn  reason: collision with root package name */
            public static boolean f6920zn;

            @SuppressLint({"BanUncheckedReflection"})
            public static void y(@NonNull Resources.Theme theme) {
                synchronized (y) {
                    if (!f6920zn) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                            f6919n3 = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException unused) {
                        }
                        f6920zn = true;
                    }
                    Method method = f6919n3;
                    if (method != null) {
                        try {
                            method.invoke(theme, null);
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                            f6919n3 = null;
                        }
                    }
                }
            }
        }

        public static void y(@NonNull Resources.Theme theme) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                n3.y(theme);
            } else if (i >= 23) {
                y.y(theme);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: n3  reason: collision with root package name */
        public final Resources.Theme f6921n3;
        public final Resources y;

        public gv(@NonNull Resources resources, @Nullable Resources.Theme theme) {
            this.y = resources;
            this.f6921n3 = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || gv.class != obj.getClass()) {
                return false;
            }
            gv gvVar = (gv) obj;
            if (this.y.equals(gvVar.y) && vl.zn.y(this.f6921n3, gvVar.f6921n3)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return vl.zn.n3(this.y, this.f6921n3);
        }
    }

    /* loaded from: classes.dex */
    public static class n3 {
        @NonNull
        public static ColorStateList n3(@NonNull Resources resources, int i, @Nullable Resources.Theme theme) {
            return resources.getColorStateList(i, theme);
        }

        public static int y(Resources resources, int i, Resources.Theme theme) {
            return resources.getColor(i, theme);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class v {
        @NonNull
        public static Handler v(@Nullable Handler handler) {
            if (handler == null) {
                return new Handler(Looper.getMainLooper());
            }
            return handler;
        }

        /* renamed from: c5 */
        public abstract void fb(@NonNull Typeface typeface);

        public final void gv(@NonNull final Typeface typeface, @Nullable Handler handler) {
            v(handler).post(new Runnable() { // from class: d.c5
                @Override // java.lang.Runnable
                public final void run() {
                    s.v.this.fb(typeface);
                }
            });
        }

        /* renamed from: s */
        public abstract void a(int i);

        public final void zn(final int i, @Nullable Handler handler) {
            v(handler).post(new Runnable() { // from class: d.i9
                @Override // java.lang.Runnable
                public final void run() {
                    s.v.this.a(i);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static Drawable n3(Resources resources, int i, int i5, Resources.Theme theme) {
            return resources.getDrawableForDensity(i, i5, theme);
        }

        public static Drawable y(Resources resources, int i, Resources.Theme theme) {
            return resources.getDrawable(i, theme);
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: n3  reason: collision with root package name */
        public final Configuration f6922n3;
        public final ColorStateList y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f6923zn;

        public zn(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration, @Nullable Resources.Theme theme) {
            int hashCode;
            this.y = colorStateList;
            this.f6922n3 = configuration;
            if (theme == null) {
                hashCode = 0;
            } else {
                hashCode = theme.hashCode();
            }
            this.f6923zn = hashCode;
        }
    }

    @Nullable
    public static Typeface a(@NonNull Context context, int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return t(context, i, new TypedValue(), 0, null, null, false, false);
    }

    @NonNull
    public static TypedValue c5() {
        ThreadLocal<TypedValue> threadLocal = y;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    public static boolean f(@NonNull Resources resources, int i) {
        TypedValue c52 = c5();
        resources.getValue(i, c52, true);
        int i5 = c52.type;
        if (i5 >= 28 && i5 <= 31) {
            return true;
        }
        return false;
    }

    @Nullable
    public static Typeface fb(@NonNull Context context, int i, @NonNull TypedValue typedValue, int i5, @Nullable v vVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return t(context, i, typedValue, i5, vVar, null, true, false);
    }

    @Nullable
    public static ColorStateList gv(@NonNull Resources resources, int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        gv gvVar = new gv(resources, theme);
        ColorStateList n32 = n3(gvVar, i);
        if (n32 != null) {
            return n32;
        }
        ColorStateList i92 = i9(resources, i, theme);
        if (i92 != null) {
            y(gvVar, i, i92, theme);
            return i92;
        } else if (Build.VERSION.SDK_INT >= 23) {
            return n3.n3(resources, i, theme);
        } else {
            return resources.getColorStateList(i);
        }
    }

    @Nullable
    public static ColorStateList i9(Resources resources, int i, @Nullable Resources.Theme theme) {
        if (f(resources, i)) {
            return null;
        }
        try {
            return d.zn.y(resources, resources.getXml(i), theme);
        } catch (Exception e2) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (r2.f6923zn == r5.hashCode()) goto L17;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList n3(@androidx.annotation.NonNull d.s.gv r5, int r6) {
        /*
            java.lang.Object r0 = d.s.f6918zn
            monitor-enter(r0)
            java.util.WeakHashMap<d.s$gv, android.util.SparseArray<d.s$zn>> r1 = d.s.f6917n3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            d.s$zn r2 = (d.s.zn) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.f6922n3     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.y     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.f6921n3     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.f6923zn     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.f6923zn     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.y     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return r5
        L42:
            r1.remove(r6)     // Catch: java.lang.Throwable -> L32
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r5 = 0
            return r5
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d.s.n3(d.s$gv, int):android.content.res.ColorStateList");
    }

    public static void s(@NonNull Context context, int i, @NonNull v vVar, @Nullable Handler handler) throws Resources.NotFoundException {
        vl.s.fb(vVar);
        if (context.isRestricted()) {
            vVar.zn(-4, handler);
        } else {
            t(context, i, new TypedValue(), 0, vVar, handler, false, false);
        }
    }

    public static Typeface t(@NonNull Context context, int i, @NonNull TypedValue typedValue, int i5, @Nullable v vVar, @Nullable Handler handler, boolean z2, boolean z3) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface tl2 = tl(context, resources, typedValue, i, i5, vVar, handler, z2, z3);
        if (tl2 == null && vVar == null && !z3) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        return tl2;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface tl(@androidx.annotation.NonNull android.content.Context r16, android.content.res.Resources r17, @androidx.annotation.NonNull android.util.TypedValue r18, int r19, int r20, @androidx.annotation.Nullable d.s.v r21, @androidx.annotation.Nullable android.os.Handler r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.s.tl(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, d.s$v, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    @Nullable
    public static Drawable v(@NonNull Resources resources, int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return y.y(resources, i, theme);
    }

    public static void y(@NonNull gv gvVar, int i, @NonNull ColorStateList colorStateList, @Nullable Resources.Theme theme) {
        synchronized (f6918zn) {
            try {
                WeakHashMap<gv, SparseArray<zn>> weakHashMap = f6917n3;
                SparseArray<zn> sparseArray = weakHashMap.get(gvVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                    weakHashMap.put(gvVar, sparseArray);
                }
                sparseArray.append(i, new zn(colorStateList, gvVar.y.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int zn(@NonNull Resources resources, int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return n3.y(resources, i, theme);
        }
        return resources.getColor(i);
    }
}
