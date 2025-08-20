package hx;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class n3 implements zn {

    /* renamed from: n3  reason: collision with root package name */
    public final float f9076n3;
    public final zn y;

    public n3(float f4, @NonNull zn znVar) {
        while (znVar instanceof n3) {
            znVar = ((n3) znVar).y;
            f4 += ((n3) znVar).f9076n3;
        }
        this.y = znVar;
        this.f9076n3 = f4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n3)) {
            return false;
        }
        n3 n3Var = (n3) obj;
        if (this.y.equals(n3Var.y) && this.f9076n3 == n3Var.f9076n3) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.y, Float.valueOf(this.f9076n3)});
    }

    @Override // hx.zn
    public float y(@NonNull RectF rectF) {
        return Math.max(0.0f, this.y.y(rectF) + this.f9076n3);
    }
}
