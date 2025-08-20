package nd;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import yk.mg;
/* loaded from: classes.dex */
public class a extends n3 {
    public a(mg mgVar, v vVar) {
        super(mgVar, vVar);
    }

    @Override // nd.n3, i3.v
    public void gv(RectF rectF, Matrix matrix, boolean z2) {
        super.gv(rectF, matrix, z2);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // nd.n3
    public void z(Canvas canvas, Matrix matrix, int i) {
    }
}
