package ur;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import wz.hw;
/* loaded from: classes.dex */
public final class i9 {
    public static final int[] y = {R$attr.f5086t};

    /* renamed from: n3  reason: collision with root package name */
    public static final int[] f14108n3 = {R$attr.tl};

    public static boolean a(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i, int i5, @NonNull int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i5);
        for (int i6 : iArr2) {
            if (obtainStyledAttributes.getResourceId(i6, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static hw c5(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i, int i5, int... iArr2) {
        n3(context, attributeSet, i, i5);
        gv(context, attributeSet, iArr, i, i5, iArr2);
        return hw.x4(context, attributeSet, iArr, i, i5);
    }

    public static boolean fb(@NonNull Context context, @NonNull int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i = 0; i < iArr.length; i++) {
            if (!obtainStyledAttributes.hasValue(i)) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static void gv(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i, int i5, @Nullable int... iArr2) {
        boolean z2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5150e1, i, i5);
        boolean z3 = false;
        if (!obtainStyledAttributes.getBoolean(R$styleable.h1, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 != null && iArr2.length != 0) {
            z2 = a(context, attributeSet, iArr, i, i5, iArr2);
        } else {
            if (obtainStyledAttributes.getResourceId(R$styleable.f5160f1, -1) != -1) {
                z3 = true;
            }
            z2 = z3;
        }
        obtainStyledAttributes.recycle();
        if (z2) {
            return;
        }
        throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    }

    public static void n3(@NonNull Context context, AttributeSet attributeSet, int i, int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5150e1, i, i5);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.f5170g1, false);
        obtainStyledAttributes.recycle();
        if (z2) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R$attr.co, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                zn(context);
            }
        }
        y(context);
    }

    @NonNull
    public static TypedArray s(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i, int i5, int... iArr2) {
        n3(context, attributeSet, i, i5);
        gv(context, attributeSet, iArr, i, i5, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i5);
    }

    public static void v(@NonNull Context context, @NonNull int[] iArr, String str) {
        if (fb(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    public static void y(@NonNull Context context) {
        v(context, y, "Theme.AppCompat");
    }

    public static void zn(@NonNull Context context) {
        v(context, f14108n3, "Theme.MaterialComponents");
    }
}
