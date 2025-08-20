package androidx.compose.runtime;

import java.util.Collection;
import java.util.Set;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SnapshotFlow.kt */
/* loaded from: classes.dex */
public abstract /* synthetic */ class SnapshotStateKt__SnapshotFlowKt {
    public static final State collectAsState(StateFlow stateFlow, CoroutineContext coroutineContext, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(stateFlow, "<this>");
        composer.startReplaceableGroup(-1439883919);
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1439883919, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:44)");
        }
        State collectAsState = SnapshotStateKt.collectAsState(stateFlow, stateFlow.getValue(), coroutineContext2, composer, 520, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return collectAsState;
    }

    public static final State collectAsState(Flow flow, Object obj, CoroutineContext coroutineContext, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        composer.startReplaceableGroup(-606625098);
        if ((i2 & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-606625098, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:58)");
        }
        int i3 = i >> 3;
        State produceState = SnapshotStateKt.produceState(obj, flow, coroutineContext2, new SnapshotStateKt__SnapshotFlowKt$collectAsState$1(coroutineContext2, flow, null), composer, (i3 & 8) | 4672 | (i3 & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return produceState;
    }

    public static final Flow snapshotFlow(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return FlowKt.flow(new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(block, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean intersects$SnapshotStateKt__SnapshotFlowKt(Set set, Set set2) {
        if (set.size() < set2.size()) {
            Set<Object> set3 = set;
            if (!(set3 instanceof Collection) || !set3.isEmpty()) {
                for (Object obj : set3) {
                    if (set2.contains(obj)) {
                        return true;
                    }
                }
            }
        } else {
            Set<Object> set4 = set2;
            if (!(set4 instanceof Collection) || !set4.isEmpty()) {
                for (Object obj2 : set4) {
                    if (set.contains(obj2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
