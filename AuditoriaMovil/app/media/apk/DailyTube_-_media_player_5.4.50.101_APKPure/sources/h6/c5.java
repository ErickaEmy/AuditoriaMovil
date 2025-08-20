package h6;

import android.animation.Animator;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public abstract class c5<T extends Animator> {

    /* renamed from: n3  reason: collision with root package name */
    public final float[] f8720n3;
    public i9 y;

    /* renamed from: zn  reason: collision with root package name */
    public final int[] f8721zn;

    public c5(int i) {
        this.f8720n3 = new float[i * 2];
        this.f8721zn = new int[i];
    }

    public abstract void a();

    public abstract void fb();

    public abstract void gv(@NonNull o0.n3 n3Var);

    public float n3(int i, int i5, int i6) {
        return (i - i5) / i6;
    }

    public abstract void s();

    public void v(@NonNull i9 i9Var) {
        this.y = i9Var;
    }

    public abstract void y();

    public abstract void zn();
}
