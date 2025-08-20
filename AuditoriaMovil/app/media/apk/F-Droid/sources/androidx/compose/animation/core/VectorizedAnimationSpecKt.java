package androidx.compose.animation.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: VectorizedAnimationSpec.kt */
/* loaded from: classes.dex */
public abstract class VectorizedAnimationSpecKt {
    public static final /* synthetic */ Animations access$createSpringAnimations(AnimationVector animationVector, float f, float f2) {
        return createSpringAnimations(animationVector, f, f2);
    }

    public static final AnimationVector getValueFromMillis(VectorizedAnimationSpec vectorizedAnimationSpec, long j, AnimationVector start, AnimationVector end, AnimationVector startVelocity) {
        Intrinsics.checkNotNullParameter(vectorizedAnimationSpec, "<this>");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(startVelocity, "startVelocity");
        return vectorizedAnimationSpec.getValueFromNanos(j * 1000000, start, end, startVelocity);
    }

    public static final long clampPlayTime(VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, long j) {
        long coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(j - vectorizedDurationBasedAnimationSpec.getDelayMillis(), 0L, vectorizedDurationBasedAnimationSpec.getDurationMillis());
        return coerceIn;
    }

    public static final Animations createSpringAnimations(AnimationVector animationVector, float f, float f2) {
        if (animationVector != null) {
            return new Animations(animationVector, f, f2) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt$createSpringAnimations$1
                private final List anims;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IntRange until;
                    int collectionSizeOrDefault;
                    until = RangesKt___RangesKt.until(0, animationVector.getSize$animation_core_release());
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it = until.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new FloatSpringSpec(f, f2, animationVector.get$animation_core_release(((IntIterator) it).nextInt())));
                    }
                    this.anims = arrayList;
                }

                @Override // androidx.compose.animation.core.Animations
                public FloatSpringSpec get(int i) {
                    return (FloatSpringSpec) this.anims.get(i);
                }
            };
        }
        return new Animations(f, f2) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt$createSpringAnimations$2
            private final FloatSpringSpec anim;

            @Override // androidx.compose.animation.core.Animations
            public FloatSpringSpec get(int i) {
                return this.anim;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.anim = new FloatSpringSpec(f, f2, 0.0f, 4, null);
            }
        };
    }
}
