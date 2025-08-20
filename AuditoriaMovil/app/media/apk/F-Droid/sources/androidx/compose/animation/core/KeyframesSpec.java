package androidx.compose.animation.core;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnimationSpec.kt */
/* loaded from: classes.dex */
public final class KeyframesSpec implements DurationBasedAnimationSpec {
    private final KeyframesSpecConfig config;

    public KeyframesSpec(KeyframesSpecConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    /* compiled from: AnimationSpec.kt */
    /* loaded from: classes.dex */
    public static final class KeyframesSpecConfig {
        private int delayMillis;
        private int durationMillis = 300;
        private final Map keyframes = new LinkedHashMap();

        public final int getDelayMillis() {
            return this.delayMillis;
        }

        public final int getDurationMillis() {
            return this.durationMillis;
        }

        public final Map getKeyframes$animation_core_release() {
            return this.keyframes;
        }

        public final void setDurationMillis(int i) {
            this.durationMillis = i;
        }

        public final KeyframeEntity at(Object obj, int i) {
            KeyframeEntity keyframeEntity = new KeyframeEntity(obj, null, 2, null);
            this.keyframes.put(Integer.valueOf(i), keyframeEntity);
            return keyframeEntity;
        }

        public final void with(KeyframeEntity keyframeEntity, Easing easing) {
            Intrinsics.checkNotNullParameter(keyframeEntity, "<this>");
            Intrinsics.checkNotNullParameter(easing, "easing");
            keyframeEntity.setEasing$animation_core_release(easing);
        }

        public boolean equals(Object obj) {
            if (obj instanceof KeyframesSpecConfig) {
                KeyframesSpecConfig keyframesSpecConfig = (KeyframesSpecConfig) obj;
                if (this.delayMillis == keyframesSpecConfig.delayMillis && this.durationMillis == keyframesSpecConfig.durationMillis && Intrinsics.areEqual(this.keyframes, keyframesSpecConfig.keyframes)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.durationMillis * 31) + this.delayMillis) * 31) + this.keyframes.hashCode();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof KeyframesSpec) && Intrinsics.areEqual(this.config, ((KeyframesSpec) obj).config);
    }

    public int hashCode() {
        return this.config.hashCode();
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public VectorizedKeyframesSpec vectorize(TwoWayConverter converter) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(converter, "converter");
        Map keyframes$animation_core_release = this.config.getKeyframes$animation_core_release();
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(keyframes$animation_core_release.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        for (Map.Entry entry : keyframes$animation_core_release.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((KeyframeEntity) entry.getValue()).toPair$animation_core_release(converter.getConvertToVector()));
        }
        return new VectorizedKeyframesSpec(linkedHashMap, this.config.getDurationMillis(), this.config.getDelayMillis());
    }

    /* compiled from: AnimationSpec.kt */
    /* loaded from: classes.dex */
    public static final class KeyframeEntity {
        private Easing easing;
        private final Object value;

        public final void setEasing$animation_core_release(Easing easing) {
            Intrinsics.checkNotNullParameter(easing, "<set-?>");
            this.easing = easing;
        }

        public KeyframeEntity(Object obj, Easing easing) {
            Intrinsics.checkNotNullParameter(easing, "easing");
            this.value = obj;
            this.easing = easing;
        }

        public /* synthetic */ KeyframeEntity(Object obj, Easing easing, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? EasingKt.getLinearEasing() : easing);
        }

        public final Pair toPair$animation_core_release(Function1 convertToVector) {
            Intrinsics.checkNotNullParameter(convertToVector, "convertToVector");
            return TuplesKt.to(convertToVector.invoke(this.value), this.easing);
        }

        public boolean equals(Object obj) {
            if (obj instanceof KeyframeEntity) {
                KeyframeEntity keyframeEntity = (KeyframeEntity) obj;
                if (Intrinsics.areEqual(keyframeEntity.value, this.value) && Intrinsics.areEqual(keyframeEntity.easing, this.easing)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.value;
            return ((obj != null ? obj.hashCode() : 0) * 31) + this.easing.hashCode();
        }
    }
}
