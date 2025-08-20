package androidx.compose.animation.core;
/* compiled from: Animation.kt */
/* loaded from: classes.dex */
public interface Animation {
    long getDurationNanos();

    Object getTargetValue();

    TwoWayConverter getTypeConverter();

    Object getValueFromNanos(long j);

    AnimationVector getVelocityVectorFromNanos(long j);

    boolean isFinishedFromNanos(long j);

    boolean isInfinite();

    /* compiled from: Animation.kt */
    /* renamed from: androidx.compose.animation.core.Animation$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static boolean $default$isFinishedFromNanos(Animation animation, long j) {
            return j >= animation.getDurationNanos();
        }
    }
}
