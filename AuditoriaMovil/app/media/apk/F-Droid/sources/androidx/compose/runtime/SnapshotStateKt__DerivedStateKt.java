package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DerivedState.kt */
/* loaded from: classes.dex */
public abstract /* synthetic */ class SnapshotStateKt__DerivedStateKt {
    private static final SnapshotThreadLocal calculationBlockNestedLevel = new SnapshotThreadLocal();
    private static final SnapshotThreadLocal derivedStateObservers = new SnapshotThreadLocal();

    public static final State derivedStateOf(Function0 calculation) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        return new DerivedSnapshotState(calculation, null);
    }

    public static final State derivedStateOf(SnapshotMutationPolicy policy, Function0 calculation) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        return new DerivedSnapshotState(calculation, policy);
    }

    public static final MutableVector derivedStateObservers() {
        SnapshotThreadLocal snapshotThreadLocal = derivedStateObservers;
        MutableVector mutableVector = (MutableVector) snapshotThreadLocal.get();
        if (mutableVector == null) {
            MutableVector mutableVector2 = new MutableVector(new DerivedStateObserver[0], 0);
            snapshotThreadLocal.set(mutableVector2);
            return mutableVector2;
        }
        return mutableVector;
    }
}
