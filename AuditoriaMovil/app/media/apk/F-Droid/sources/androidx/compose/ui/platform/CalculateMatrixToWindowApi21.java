package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidComposeView.android.kt */
/* loaded from: classes.dex */
final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {
    private final int[] tmpLocation = new int[2];
    private final float[] tmpMatrix = Matrix.m911constructorimpl$default(null, 1, null);

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    /* renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo1424calculateMatrixToWindowEL8BTi8(View view, float[] matrix) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Matrix.m916resetimpl(matrix);
        m1427transformMatrixToWindowEL8BTi8(view, matrix);
    }

    /* renamed from: transformMatrixToWindow-EL8BTi8  reason: not valid java name */
    private final void m1427transformMatrixToWindowEL8BTi8(View view, float[] fArr) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m1427transformMatrixToWindowEL8BTi8((View) parent, fArr);
            m1426preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m1426preTranslate3XD1CNM(fArr, view.getLeft(), view.getTop());
        } else {
            int[] iArr = this.tmpLocation;
            view.getLocationInWindow(iArr);
            m1426preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m1426preTranslate3XD1CNM(fArr, iArr[0], iArr[1]);
        }
        android.graphics.Matrix viewMatrix = view.getMatrix();
        if (viewMatrix.isIdentity()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(viewMatrix, "viewMatrix");
        m1425preConcattUYjHk(fArr, viewMatrix);
    }

    /* renamed from: preConcat-tU-YjHk  reason: not valid java name */
    private final void m1425preConcattUYjHk(float[] fArr, android.graphics.Matrix matrix) {
        AndroidMatrixConversions_androidKt.m770setFromtUYjHk(this.tmpMatrix, matrix);
        AndroidComposeView_androidKt.m1422preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* renamed from: preTranslate-3XD1CNM  reason: not valid java name */
    private final void m1426preTranslate3XD1CNM(float[] fArr, float f, float f2) {
        Matrix.m916resetimpl(this.tmpMatrix);
        Matrix.m921translateimpl$default(this.tmpMatrix, f, f2, 0.0f, 4, null);
        AndroidComposeView_androidKt.m1422preTransformJiSxe2E(fArr, this.tmpMatrix);
    }
}
