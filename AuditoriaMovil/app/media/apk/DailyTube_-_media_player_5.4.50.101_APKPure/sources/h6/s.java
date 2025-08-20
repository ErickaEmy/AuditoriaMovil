package h6;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import h6.n3;
/* loaded from: classes.dex */
public abstract class s<S extends n3> {

    /* renamed from: n3  reason: collision with root package name */
    public fb f8756n3;
    public S y;

    public s(S s2) {
        this.y = s2;
    }

    public void a(@NonNull fb fbVar) {
        this.f8756n3 = fbVar;
    }

    public void fb(@NonNull Canvas canvas, float f4) {
        this.y.v();
        y(canvas, f4);
    }

    public abstract int gv();

    public abstract void n3(@NonNull Canvas canvas, @NonNull Paint paint, float f4, float f6, int i);

    public abstract int v();

    public abstract void y(@NonNull Canvas canvas, float f4);

    public abstract void zn(@NonNull Canvas canvas, @NonNull Paint paint);
}
