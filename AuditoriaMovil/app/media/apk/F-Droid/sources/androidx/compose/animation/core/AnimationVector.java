package androidx.compose.animation.core;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: AnimationVectors.kt */
/* loaded from: classes.dex */
public abstract class AnimationVector {
    private AnimationVector() {
    }

    public /* synthetic */ AnimationVector(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract float get$animation_core_release(int i);

    public abstract int getSize$animation_core_release();

    public abstract AnimationVector newVector$animation_core_release();

    public abstract void reset$animation_core_release();

    public abstract void set$animation_core_release(int i, float f);
}
