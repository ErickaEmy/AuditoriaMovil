package androidx.compose.runtime.snapshots;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public interface StateObject {

    /* compiled from: Snapshot.kt */
    /* renamed from: androidx.compose.runtime.snapshots.StateObject$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static StateRecord $default$mergeRecords(StateObject stateObject, StateRecord previous, StateRecord current, StateRecord applied) {
            Intrinsics.checkNotNullParameter(previous, "previous");
            Intrinsics.checkNotNullParameter(current, "current");
            Intrinsics.checkNotNullParameter(applied, "applied");
            return null;
        }
    }

    StateRecord getFirstStateRecord();

    StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3);

    void prependStateRecord(StateRecord stateRecord);
}
