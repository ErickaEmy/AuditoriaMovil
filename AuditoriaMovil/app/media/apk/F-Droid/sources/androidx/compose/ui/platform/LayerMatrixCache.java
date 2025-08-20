package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayerMatrixCache.android.kt */
/* loaded from: classes.dex */
public final class LayerMatrixCache {
    private Matrix androidMatrixCache;
    private final Function2 getMatrix;
    private float[] inverseMatrixCache;
    private boolean isDirty;
    private boolean isInverseDirty;
    private boolean isInverseValid;
    private float[] matrixCache;
    private Matrix previousAndroidMatrix;

    public final void invalidate() {
        this.isDirty = true;
        this.isInverseDirty = true;
    }

    public LayerMatrixCache(Function2 getMatrix) {
        Intrinsics.checkNotNullParameter(getMatrix, "getMatrix");
        this.getMatrix = getMatrix;
        this.isDirty = true;
        this.isInverseDirty = true;
        this.isInverseValid = true;
    }

    /* renamed from: calculateMatrix-GrdbGEg  reason: not valid java name */
    public final float[] m1446calculateMatrixGrdbGEg(Object obj) {
        float[] fArr = this.matrixCache;
        if (fArr == null) {
            fArr = androidx.compose.ui.graphics.Matrix.m911constructorimpl$default(null, 1, null);
            this.matrixCache = fArr;
        }
        if (this.isDirty) {
            Matrix matrix = this.androidMatrixCache;
            if (matrix == null) {
                matrix = new Matrix();
                this.androidMatrixCache = matrix;
            }
            this.getMatrix.invoke(obj, matrix);
            Matrix matrix2 = this.previousAndroidMatrix;
            if (matrix2 == null || !Intrinsics.areEqual(matrix, matrix2)) {
                AndroidMatrixConversions_androidKt.m770setFromtUYjHk(fArr, matrix);
                this.androidMatrixCache = matrix2;
                this.previousAndroidMatrix = matrix;
            }
            this.isDirty = false;
            return fArr;
        }
        return fArr;
    }

    /* renamed from: calculateInverseMatrix-bWbORWo  reason: not valid java name */
    public final float[] m1445calculateInverseMatrixbWbORWo(Object obj) {
        float[] fArr = this.inverseMatrixCache;
        if (fArr == null) {
            fArr = androidx.compose.ui.graphics.Matrix.m911constructorimpl$default(null, 1, null);
            this.inverseMatrixCache = fArr;
        }
        if (this.isInverseDirty) {
            this.isInverseValid = InvertMatrixKt.m1444invertToJiSxe2E(m1446calculateMatrixGrdbGEg(obj), fArr);
            this.isInverseDirty = false;
        }
        if (this.isInverseValid) {
            return fArr;
        }
        return null;
    }
}
