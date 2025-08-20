package nd;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bv.i9;
import java.util.Collections;
import java.util.List;
import wm.w;
import yk.mg;
/* loaded from: classes.dex */
public class fb extends n3 {

    /* renamed from: mg  reason: collision with root package name */
    public final i3.gv f11936mg;

    /* renamed from: ta  reason: collision with root package name */
    public final zn f11937ta;

    public fb(mg mgVar, v vVar, zn znVar, yk.s sVar) {
        super(mgVar, vVar);
        this.f11937ta = znVar;
        i3.gv gvVar = new i3.gv(mgVar, this, new w("__container", vVar.wz(), false), sVar);
        this.f11936mg = gvVar;
        gvVar.n3(Collections.emptyList(), Collections.emptyList());
    }

    @Override // nd.n3
    public void ej(ne.v vVar, int i, List<ne.v> list, ne.v vVar2) {
        this.f11936mg.zn(vVar, i, list, vVar2);
    }

    @Override // nd.n3
    @Nullable
    public i9 f3() {
        i9 f32 = super.f3();
        if (f32 != null) {
            return f32;
        }
        return this.f11937ta.f3();
    }

    @Override // nd.n3, i3.v
    public void gv(RectF rectF, Matrix matrix, boolean z2) {
        super.gv(rectF, matrix, z2);
        this.f11936mg.gv(rectF, this.f11969xc, z2);
    }

    @Override // nd.n3
    @Nullable
    public wm.y x4() {
        wm.y x42 = super.x4();
        if (x42 != null) {
            return x42;
        }
        return this.f11937ta.x4();
    }

    @Override // nd.n3
    public void z(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.f11936mg.fb(canvas, matrix, i);
    }
}
