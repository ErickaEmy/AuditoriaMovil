package pv;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import wz.hw;
/* loaded from: classes.dex */
public class zn {
    @Nullable
    public static gv a(@NonNull Context context, @NonNull TypedArray typedArray, int i) {
        int resourceId;
        if (typedArray.hasValue(i) && (resourceId = typedArray.getResourceId(i, 0)) != 0) {
            return new gv(context, resourceId);
        }
        return null;
    }

    public static boolean fb(@NonNull Context context) {
        if (context.getResources().getConfiguration().fontScale >= 1.3f) {
            return true;
        }
        return false;
    }

    @Nullable
    public static Drawable gv(@NonNull Context context, @NonNull TypedArray typedArray, int i) {
        int resourceId;
        Drawable gv2;
        if (typedArray.hasValue(i) && (resourceId = typedArray.getResourceId(i, 0)) != 0 && (gv2 = c5.y.gv(context, resourceId)) != null) {
            return gv2;
        }
        return typedArray.getDrawable(i);
    }

    @Nullable
    public static ColorStateList n3(@NonNull Context context, @NonNull hw hwVar, int i) {
        int wz2;
        ColorStateList zn2;
        if (hwVar.co(i) && (wz2 = hwVar.wz(i, 0)) != 0 && (zn2 = c5.y.zn(context, wz2)) != null) {
            return zn2;
        }
        return hwVar.zn(i);
    }

    public static boolean s(@NonNull Context context) {
        if (context.getResources().getConfiguration().fontScale >= 2.0f) {
            return true;
        }
        return false;
    }

    public static int v(@NonNull TypedArray typedArray, int i, int i5) {
        if (typedArray.hasValue(i)) {
            return i;
        }
        return i5;
    }

    @Nullable
    public static ColorStateList y(@NonNull Context context, @NonNull TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList zn2;
        if (typedArray.hasValue(i) && (resourceId = typedArray.getResourceId(i, 0)) != 0 && (zn2 = c5.y.zn(context, resourceId)) != null) {
            return zn2;
        }
        return typedArray.getColorStateList(i);
    }

    public static int zn(@NonNull Context context, @NonNull TypedArray typedArray, int i, int i5) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(i, typedValue) && typedValue.type == 2) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i5);
            obtainStyledAttributes.recycle();
            return dimensionPixelSize;
        }
        return typedArray.getDimensionPixelSize(i, i5);
    }
}
