package androidx.compose.ui.unit;
/* compiled from: Density.kt */
/* loaded from: classes.dex */
public abstract class DensityKt {
    public static /* synthetic */ Density Density$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        return Density(f, f2);
    }

    public static final Density Density(float f, float f2) {
        return new DensityImpl(f, f2);
    }
}
