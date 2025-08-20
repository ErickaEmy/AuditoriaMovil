package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RecomposeScopeImpl.kt */
/* loaded from: classes.dex */
public final class RecomposeScopeImpl implements ScopeUpdateScope, RecomposeScope {
    public static final Companion Companion = new Companion(null);
    private Anchor anchor;
    private Function2 block;
    private int currentToken;
    private int flags;
    private RecomposeScopeOwner owner;
    private IdentityArrayMap trackedDependencies;
    private IdentityArrayIntMap trackedInstances;

    private final boolean getRereading() {
        return (this.flags & 32) != 0;
    }

    private final void setRereading(boolean z) {
        if (z) {
            this.flags |= 32;
        } else {
            this.flags &= -33;
        }
    }

    private final void setSkipped(boolean z) {
        if (z) {
            this.flags |= 16;
        } else {
            this.flags &= -17;
        }
    }

    public final void adoptedBy(RecomposeScopeOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
    }

    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final boolean getCanRecompose() {
        return this.block != null;
    }

    public final boolean getDefaultsInScope() {
        return (this.flags & 2) != 0;
    }

    public final boolean getDefaultsInvalid() {
        return (this.flags & 4) != 0;
    }

    public final boolean getRequiresRecompose() {
        return (this.flags & 8) != 0;
    }

    public final boolean getSkipped$runtime_release() {
        return (this.flags & 16) != 0;
    }

    public final boolean getUsed() {
        return (this.flags & 1) != 0;
    }

    public final boolean isConditional() {
        return this.trackedDependencies != null;
    }

    public final void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }

    public final void setDefaultsInScope(boolean z) {
        if (z) {
            this.flags |= 2;
        } else {
            this.flags &= -3;
        }
    }

    public final void setDefaultsInvalid(boolean z) {
        if (z) {
            this.flags |= 4;
        } else {
            this.flags &= -5;
        }
    }

    public final void setRequiresRecompose(boolean z) {
        if (z) {
            this.flags |= 8;
        } else {
            this.flags &= -9;
        }
    }

    public final void setUsed(boolean z) {
        if (z) {
            this.flags |= 1;
        } else {
            this.flags &= -2;
        }
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public void updateScope(Function2 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.block = block;
    }

    public RecomposeScopeImpl(RecomposeScopeOwner recomposeScopeOwner) {
        this.owner = recomposeScopeOwner;
    }

    public final boolean getValid() {
        Anchor anchor;
        return (this.owner == null || (anchor = this.anchor) == null || !anchor.getValid()) ? false : true;
    }

    public final void compose(Composer composer) {
        Unit unit;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Function2 function2 = this.block;
        if (function2 != null) {
            function2.invoke(composer, 1);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Invalid restart scope".toString());
        }
    }

    public final InvalidationResult invalidateForResult(Object obj) {
        InvalidationResult invalidate;
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        return (recomposeScopeOwner == null || (invalidate = recomposeScopeOwner.invalidate(this, obj)) == null) ? InvalidationResult.IGNORED : invalidate;
    }

    public final void release() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.recomposeScopeReleased(this);
        }
        this.owner = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
    }

    @Override // androidx.compose.runtime.RecomposeScope
    public void invalidate() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.invalidate(this, null);
        }
    }

    public final void start(int i) {
        this.currentToken = i;
        setSkipped(false);
    }

    public final void scopeSkipped() {
        setSkipped(true);
    }

    public final boolean recordRead(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (getRereading()) {
            return false;
        }
        IdentityArrayIntMap identityArrayIntMap = this.trackedInstances;
        if (identityArrayIntMap == null) {
            identityArrayIntMap = new IdentityArrayIntMap();
            this.trackedInstances = identityArrayIntMap;
        }
        if (identityArrayIntMap.add(instance, this.currentToken) == this.currentToken) {
            return true;
        }
        if (instance instanceof DerivedState) {
            IdentityArrayMap identityArrayMap = this.trackedDependencies;
            if (identityArrayMap == null) {
                identityArrayMap = new IdentityArrayMap(0, 1, null);
                this.trackedDependencies = identityArrayMap;
            }
            identityArrayMap.set(instance, ((DerivedState) instance).getCurrentRecord().getCurrentValue());
        }
        return false;
    }

    public final boolean isInvalidFor(IdentityArraySet identityArraySet) {
        IdentityArrayMap identityArrayMap;
        if (identityArraySet != null && (identityArrayMap = this.trackedDependencies) != null && identityArraySet.isNotEmpty()) {
            if (identityArraySet.isEmpty()) {
                return false;
            }
            for (Object obj : identityArraySet) {
                if (obj instanceof DerivedState) {
                    DerivedState derivedState = (DerivedState) obj;
                    SnapshotMutationPolicy policy = derivedState.getPolicy();
                    if (policy == null) {
                        policy = SnapshotStateKt.structuralEqualityPolicy();
                    }
                    if (!policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), identityArrayMap.get(derivedState))) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void rereadTrackedInstances() {
        IdentityArrayIntMap identityArrayIntMap;
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner == null || (identityArrayIntMap = this.trackedInstances) == null) {
            return;
        }
        setRereading(true);
        try {
            Object[] keys = identityArrayIntMap.getKeys();
            int[] values = identityArrayIntMap.getValues();
            int size = identityArrayIntMap.getSize();
            for (int i = 0; i < size; i++) {
                Object obj = keys[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
                int i2 = values[i];
                recomposeScopeOwner.recordReadOf(obj);
            }
        } finally {
            setRereading(false);
        }
    }

    public final Function1 end(final int i) {
        final IdentityArrayIntMap identityArrayIntMap = this.trackedInstances;
        if (identityArrayIntMap == null || getSkipped$runtime_release()) {
            return null;
        }
        Object[] keys = identityArrayIntMap.getKeys();
        int[] values = identityArrayIntMap.getValues();
        int size = identityArrayIntMap.getSize();
        for (int i2 = 0; i2 < size; i2++) {
            Intrinsics.checkNotNull(keys[i2], "null cannot be cast to non-null type kotlin.Any");
            if (values[i2] != i) {
                return new Function1() { // from class: androidx.compose.runtime.RecomposeScopeImpl$end$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Composition) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composition composition) {
                        int i3;
                        IdentityArrayIntMap identityArrayIntMap2;
                        IdentityArrayMap identityArrayMap;
                        Intrinsics.checkNotNullParameter(composition, "composition");
                        i3 = RecomposeScopeImpl.this.currentToken;
                        if (i3 == i) {
                            IdentityArrayIntMap identityArrayIntMap3 = identityArrayIntMap;
                            identityArrayIntMap2 = RecomposeScopeImpl.this.trackedInstances;
                            if (Intrinsics.areEqual(identityArrayIntMap3, identityArrayIntMap2) && (composition instanceof CompositionImpl)) {
                                IdentityArrayIntMap identityArrayIntMap4 = identityArrayIntMap;
                                int i4 = i;
                                RecomposeScopeImpl recomposeScopeImpl = RecomposeScopeImpl.this;
                                Object[] keys2 = identityArrayIntMap4.getKeys();
                                int[] values2 = identityArrayIntMap4.getValues();
                                int size2 = identityArrayIntMap4.getSize();
                                int i5 = 0;
                                for (int i6 = 0; i6 < size2; i6++) {
                                    Object obj = keys2[i6];
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
                                    int i7 = values2[i6];
                                    boolean z = i7 != i4;
                                    if (z) {
                                        CompositionImpl compositionImpl = (CompositionImpl) composition;
                                        compositionImpl.removeObservation$runtime_release(obj, recomposeScopeImpl);
                                        DerivedState derivedState = obj instanceof DerivedState ? (DerivedState) obj : null;
                                        if (derivedState != null) {
                                            compositionImpl.removeDerivedStateObservation$runtime_release(derivedState);
                                            identityArrayMap = recomposeScopeImpl.trackedDependencies;
                                            if (identityArrayMap != null) {
                                                identityArrayMap.remove(derivedState);
                                                if (identityArrayMap.getSize() == 0) {
                                                    recomposeScopeImpl.trackedDependencies = null;
                                                }
                                            }
                                        }
                                    }
                                    if (!z) {
                                        if (i5 != i6) {
                                            keys2[i5] = obj;
                                            values2[i5] = i7;
                                        }
                                        i5++;
                                    }
                                }
                                for (int i8 = i5; i8 < size2; i8++) {
                                    keys2[i8] = null;
                                }
                                identityArrayIntMap4.size = i5;
                                if (identityArrayIntMap.getSize() == 0) {
                                    RecomposeScopeImpl.this.trackedInstances = null;
                                }
                            }
                        }
                    }
                };
            }
        }
        return null;
    }

    /* compiled from: RecomposeScopeImpl.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void adoptAnchoredScopes$runtime_release(SlotWriter slots, List anchors, RecomposeScopeOwner newOwner) {
            Intrinsics.checkNotNullParameter(slots, "slots");
            Intrinsics.checkNotNullParameter(anchors, "anchors");
            Intrinsics.checkNotNullParameter(newOwner, "newOwner");
            if (!anchors.isEmpty()) {
                int size = anchors.size();
                for (int i = 0; i < size; i++) {
                    Object slot = slots.slot((Anchor) anchors.get(i), 0);
                    RecomposeScopeImpl recomposeScopeImpl = slot instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) slot : null;
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.adoptedBy(newOwner);
                    }
                }
            }
        }
    }
}
