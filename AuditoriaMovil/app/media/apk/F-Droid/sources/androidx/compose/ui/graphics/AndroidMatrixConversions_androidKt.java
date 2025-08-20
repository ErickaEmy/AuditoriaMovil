package androidx.compose.ui.graphics;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidMatrixConversions.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidMatrixConversions_androidKt {
    /* renamed from: setFrom-tU-YjHk  reason: not valid java name */
    public static final void m770setFromtUYjHk(float[] setFrom, android.graphics.Matrix matrix) {
        Intrinsics.checkNotNullParameter(setFrom, "$this$setFrom");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        matrix.getValues(setFrom);
        float f = setFrom[0];
        float f2 = setFrom[1];
        float f3 = setFrom[2];
        float f4 = setFrom[3];
        float f5 = setFrom[4];
        float f6 = setFrom[5];
        float f7 = setFrom[6];
        float f8 = setFrom[7];
        float f9 = setFrom[8];
        setFrom[0] = f;
        setFrom[1] = f4;
        setFrom[2] = 0.0f;
        setFrom[3] = f7;
        setFrom[4] = f2;
        setFrom[5] = f5;
        setFrom[6] = 0.0f;
        setFrom[7] = f8;
        setFrom[8] = 0.0f;
        setFrom[9] = 0.0f;
        setFrom[10] = 1.0f;
        setFrom[11] = 0.0f;
        setFrom[12] = f3;
        setFrom[13] = f6;
        setFrom[14] = 0.0f;
        setFrom[15] = f9;
    }

    /* renamed from: setFrom-EL8BTi8  reason: not valid java name */
    public static final void m769setFromEL8BTi8(android.graphics.Matrix setFrom, float[] matrix) {
        Intrinsics.checkNotNullParameter(setFrom, "$this$setFrom");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        float f = matrix[2];
        if (f == 0.0f) {
            float f2 = matrix[6];
            if (f2 == 0.0f && matrix[10] == 1.0f && matrix[14] == 0.0f) {
                float f3 = matrix[8];
                if (f3 == 0.0f && matrix[9] == 0.0f && matrix[11] == 0.0f) {
                    float f4 = matrix[0];
                    float f5 = matrix[1];
                    float f6 = matrix[3];
                    float f7 = matrix[4];
                    float f8 = matrix[5];
                    float f9 = matrix[7];
                    float f10 = matrix[12];
                    float f11 = matrix[13];
                    float f12 = matrix[15];
                    matrix[0] = f4;
                    matrix[1] = f7;
                    matrix[2] = f10;
                    matrix[3] = f5;
                    matrix[4] = f8;
                    matrix[5] = f11;
                    matrix[6] = f6;
                    matrix[7] = f9;
                    matrix[8] = f12;
                    setFrom.setValues(matrix);
                    matrix[0] = f4;
                    matrix[1] = f5;
                    matrix[2] = f;
                    matrix[3] = f6;
                    matrix[4] = f7;
                    matrix[5] = f8;
                    matrix[6] = f2;
                    matrix[7] = f9;
                    matrix[8] = f3;
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Android does not support arbitrary transforms".toString());
    }
}
