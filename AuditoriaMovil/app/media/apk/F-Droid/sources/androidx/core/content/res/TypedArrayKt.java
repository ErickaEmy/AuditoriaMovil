package androidx.core.content.res;

import android.content.res.TypedArray;
/* compiled from: TypedArray.kt */
/* loaded from: classes.dex */
public abstract class TypedArrayKt {
    private static final void checkAttribute(TypedArray typedArray, int i) {
        if (!typedArray.hasValue(i)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final int getColorOrThrow(TypedArray typedArray, int i) {
        checkAttribute(typedArray, i);
        return typedArray.getColor(i, 0);
    }

    public static final int getResourceIdOrThrow(TypedArray typedArray, int i) {
        checkAttribute(typedArray, i);
        return typedArray.getResourceId(i, 0);
    }
}
