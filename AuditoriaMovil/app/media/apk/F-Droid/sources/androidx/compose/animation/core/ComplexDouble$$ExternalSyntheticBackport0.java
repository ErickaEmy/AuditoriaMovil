package androidx.compose.animation.core;
/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public abstract /* synthetic */ class ComplexDouble$$ExternalSyntheticBackport0 {
    public static /* synthetic */ int m(double d) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }
}
