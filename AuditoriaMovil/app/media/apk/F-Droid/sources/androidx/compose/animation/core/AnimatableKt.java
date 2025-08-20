package androidx.compose.animation.core;

import kotlin.jvm.internal.FloatCompanionObject;
/* compiled from: Animatable.kt */
/* loaded from: classes.dex */
public abstract class AnimatableKt {
    public static /* synthetic */ Animatable Animatable$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.01f;
        }
        return Animatable(f, f2);
    }

    public static final Animatable Animatable(float f, float f2) {
        return new Animatable(Float.valueOf(f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(f2), null, 8, null);
    }
}
