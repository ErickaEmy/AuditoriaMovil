package wz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
/* loaded from: classes.dex */
public class x {
    public static final ThreadLocal<TypedValue> y = new ThreadLocal<>();

    /* renamed from: n3  reason: collision with root package name */
    public static final int[] f14835n3 = {-16842910};

    /* renamed from: zn  reason: collision with root package name */
    public static final int[] f14838zn = {16842908};

    /* renamed from: gv  reason: collision with root package name */
    public static final int[] f14833gv = {16843518};

    /* renamed from: v  reason: collision with root package name */
    public static final int[] f14837v = {16842919};

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f14830a = {16842912};

    /* renamed from: fb  reason: collision with root package name */
    public static final int[] f14832fb = {16842913};

    /* renamed from: s  reason: collision with root package name */
    public static final int[] f14836s = {-16842919, -16842908};

    /* renamed from: c5  reason: collision with root package name */
    public static final int[] f14831c5 = new int[0];

    /* renamed from: i9  reason: collision with root package name */
    public static final int[] f14834i9 = new int[1];

    public static TypedValue a() {
        ThreadLocal<TypedValue> threadLocal = y;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    public static int gv(@NonNull Context context, int i, float f4) {
        int zn2 = zn(context, i);
        return z6.y.a(zn2, Math.round(Color.alpha(zn2) * f4));
    }

    public static int n3(@NonNull Context context, int i) {
        ColorStateList v2 = v(context, i);
        if (v2 != null && v2.isStateful()) {
            return v2.getColorForState(f14835n3, v2.getDefaultColor());
        }
        TypedValue a2 = a();
        context.getTheme().resolveAttribute(16842803, a2, true);
        return gv(context, i, a2.getFloat());
    }

    @Nullable
    public static ColorStateList v(@NonNull Context context, int i) {
        int[] iArr = f14834i9;
        iArr[0] = i;
        hw r2 = hw.r(context, null, iArr);
        try {
            return r2.zn(0);
        } finally {
            r2.i4();
        }
    }

    public static void y(@NonNull View view, @NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R$styleable.f899tg);
        try {
            if (!obtainStyledAttributes.hasValue(R$styleable.f920xb)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int zn(@NonNull Context context, int i) {
        int[] iArr = f14834i9;
        iArr[0] = i;
        hw r2 = hw.r(context, null, iArr);
        try {
            return r2.n3(0, 0);
        } finally {
            r2.i4();
        }
    }
}
