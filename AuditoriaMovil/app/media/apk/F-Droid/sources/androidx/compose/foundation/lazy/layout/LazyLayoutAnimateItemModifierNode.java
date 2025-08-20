package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
/* compiled from: LazyLayoutAnimateItemModifierNode.kt */
/* loaded from: classes.dex */
public final class LazyLayoutAnimateItemModifierNode extends Modifier.Node {
    public static final Companion Companion = new Companion(null);
    private static final long NotInitialized = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private final MutableState isAnimationInProgress$delegate;
    private FiniteAnimationSpec placementAnimationSpec;
    private final MutableState placementDelta$delegate;
    private final Animatable placementDeltaAnimation;
    private long rawOffset;

    public final FiniteAnimationSpec getPlacementAnimationSpec() {
        return this.placementAnimationSpec;
    }

    /* renamed from: getRawOffset-nOcc-ac  reason: not valid java name */
    public final long m256getRawOffsetnOccac() {
        return this.rawOffset;
    }

    public final void setPlacementAnimationSpec(FiniteAnimationSpec finiteAnimationSpec) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "<set-?>");
        this.placementAnimationSpec = finiteAnimationSpec;
    }

    /* renamed from: setRawOffset--gyyYBs  reason: not valid java name */
    public final void m257setRawOffsetgyyYBs(long j) {
        this.rawOffset = j;
    }

    public LazyLayoutAnimateItemModifierNode(FiniteAnimationSpec placementAnimationSpec) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        Intrinsics.checkNotNullParameter(placementAnimationSpec, "placementAnimationSpec");
        this.placementAnimationSpec = placementAnimationSpec;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isAnimationInProgress$delegate = mutableStateOf$default;
        this.rawOffset = NotInitialized;
        IntOffset.Companion companion = IntOffset.Companion;
        this.placementDeltaAnimation = new Animatable(IntOffset.m1929boximpl(companion.m1942getZeronOccac()), VectorConvertersKt.getVectorConverter(companion), null, null, 12, null);
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m1929boximpl(companion.m1942getZeronOccac()), null, 2, null);
        this.placementDelta$delegate = mutableStateOf$default2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationInProgress(boolean z) {
        this.isAnimationInProgress$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setPlacementDelta--gyyYBs  reason: not valid java name */
    public final void m253setPlacementDeltagyyYBs(long j) {
        this.placementDelta$delegate.setValue(IntOffset.m1929boximpl(j));
    }

    public final void cancelAnimation() {
        if (isAnimationInProgress()) {
            BuildersKt.launch$default(getCoroutineScope(), null, null, new LazyLayoutAnimateItemModifierNode$cancelAnimation$1(this, null), 3, null);
        }
    }

    /* renamed from: animatePlacementDelta--gyyYBs  reason: not valid java name */
    public final void m254animatePlacementDeltagyyYBs(long j) {
        long m255getPlacementDeltanOccac = m255getPlacementDeltanOccac();
        long IntOffset = IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(m255getPlacementDeltanOccac) - IntOffset.m1937getXimpl(j), IntOffset.m1938getYimpl(m255getPlacementDeltanOccac) - IntOffset.m1938getYimpl(j));
        m253setPlacementDeltagyyYBs(IntOffset);
        setAnimationInProgress(true);
        BuildersKt.launch$default(getCoroutineScope(), null, null, new LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(this, IntOffset, null), 3, null);
    }

    /* renamed from: getPlacementDelta-nOcc-ac  reason: not valid java name */
    public final long m255getPlacementDeltanOccac() {
        return ((IntOffset) this.placementDelta$delegate.getValue()).m1941unboximpl();
    }

    public final boolean isAnimationInProgress() {
        return ((Boolean) this.isAnimationInProgress$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        m253setPlacementDeltagyyYBs(IntOffset.Companion.m1942getZeronOccac());
        setAnimationInProgress(false);
        this.rawOffset = NotInitialized;
    }

    /* compiled from: LazyLayoutAnimateItemModifierNode.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getNotInitialized-nOcc-ac  reason: not valid java name */
        public final long m258getNotInitializednOccac() {
            return LazyLayoutAnimateItemModifierNode.NotInitialized;
        }
    }
}
