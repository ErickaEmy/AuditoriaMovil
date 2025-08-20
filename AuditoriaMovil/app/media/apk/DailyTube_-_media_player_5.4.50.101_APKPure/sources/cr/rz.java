package cr;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class rz extends fh {
    @Override // cr.n, cr.mg
    public void a(@NonNull View view, float f4) {
        view.setTransitionAlpha(f4);
    }

    @Override // cr.c, cr.mg
    public void c5(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // cr.fh, cr.mg
    public void fb(@NonNull View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // cr.c, cr.mg
    public void s(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // cr.d0, cr.mg
    public void v(@NonNull View view, int i, int i5, int i6, int i8) {
        view.setLeftTopRightBottom(i, i5, i6, i8);
    }

    @Override // cr.n, cr.mg
    public float zn(@NonNull View view) {
        return view.getTransitionAlpha();
    }
}
