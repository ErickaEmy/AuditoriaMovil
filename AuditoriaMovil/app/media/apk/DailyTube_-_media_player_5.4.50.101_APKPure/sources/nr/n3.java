package nr;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class n3 {
    public static final boolean y = true;

    /* renamed from: n3  reason: collision with root package name */
    public static final int[] f12052n3 = {16842919};

    /* renamed from: zn  reason: collision with root package name */
    public static final int[] f12056zn = {16843623, 16842908};

    /* renamed from: gv  reason: collision with root package name */
    public static final int[] f12050gv = {16842908};

    /* renamed from: v  reason: collision with root package name */
    public static final int[] f12055v = {16843623};

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f12046a = {16842913, 16842919};

    /* renamed from: fb  reason: collision with root package name */
    public static final int[] f12049fb = {16842913, 16843623, 16842908};

    /* renamed from: s  reason: collision with root package name */
    public static final int[] f12053s = {16842913, 16842908};

    /* renamed from: c5  reason: collision with root package name */
    public static final int[] f12047c5 = {16842913, 16843623};

    /* renamed from: i9  reason: collision with root package name */
    public static final int[] f12051i9 = {16842913};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f12048f = {16842910, 16842919};

    /* renamed from: t  reason: collision with root package name */
    public static final String f12054t = n3.class.getSimpleName();

    @NonNull
    public static ColorStateList gv(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f12048f, 0)) != 0) {
                Log.w(f12054t, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    @TargetApi(21)
    public static int n3(int i) {
        return z6.y.a(i, Math.min(Color.alpha(i) * 2, 255));
    }

    public static boolean v(@NonNull int[] iArr) {
        boolean z2 = false;
        boolean z3 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z2 = true;
            } else if (i == 16842908 || i == 16842919 || i == 16843623) {
                z3 = true;
            }
        }
        if (!z2 || !z3) {
            return false;
        }
        return true;
    }

    @NonNull
    public static ColorStateList y(@Nullable ColorStateList colorStateList) {
        if (y) {
            return new ColorStateList(new int[][]{f12051i9, StateSet.NOTHING}, new int[]{zn(colorStateList, f12046a), zn(colorStateList, f12052n3)});
        }
        int[] iArr = f12046a;
        int[] iArr2 = f12049fb;
        int[] iArr3 = f12053s;
        int[] iArr4 = f12047c5;
        int[] iArr5 = f12052n3;
        int[] iArr6 = f12056zn;
        int[] iArr7 = f12050gv;
        int[] iArr8 = f12055v;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f12051i9, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{zn(colorStateList, iArr), zn(colorStateList, iArr2), zn(colorStateList, iArr3), zn(colorStateList, iArr4), 0, zn(colorStateList, iArr5), zn(colorStateList, iArr6), zn(colorStateList, iArr7), zn(colorStateList, iArr8), 0});
    }

    public static int zn(@Nullable ColorStateList colorStateList, int[] iArr) {
        int i;
        if (colorStateList != null) {
            i = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i = 0;
        }
        if (y) {
            return n3(i);
        }
        return i;
    }
}
