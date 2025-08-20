package androidx.compose.ui.graphics;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: Matrix.kt */
/* loaded from: classes.dex */
public abstract class MatrixKt {
    /* renamed from: isIdentity-58bKbWc  reason: not valid java name */
    public static final boolean m923isIdentity58bKbWc(float[] isIdentity) {
        Intrinsics.checkNotNullParameter(isIdentity, "$this$isIdentity");
        int i = 0;
        while (i < 4) {
            int i2 = 0;
            while (i2 < 4) {
                if (isIdentity[(i * 4) + i2] != (i == i2 ? 1.0f : 0.0f)) {
                    return false;
                }
                i2++;
            }
            i++;
        }
        return true;
    }
}
