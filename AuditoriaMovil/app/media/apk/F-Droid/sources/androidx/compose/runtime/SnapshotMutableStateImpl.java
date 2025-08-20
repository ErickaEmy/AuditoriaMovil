package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SnapshotState.kt */
/* loaded from: classes.dex */
public abstract class SnapshotMutableStateImpl implements StateObject, SnapshotMutableState {
    private StateStateRecord next;
    private final SnapshotMutationPolicy policy;

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public SnapshotMutationPolicy getPolicy() {
        return this.policy;
    }

    public SnapshotMutableStateImpl(Object obj, SnapshotMutationPolicy policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        this.policy = policy;
        this.next = new StateStateRecord(obj);
    }

    @Override // androidx.compose.runtime.MutableState, androidx.compose.runtime.State
    public Object getValue() {
        return ((StateStateRecord) SnapshotKt.readable(this.next, this)).getValue();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.next = (StateStateRecord) value;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord mergeRecords(StateRecord previous, StateRecord current, StateRecord applied) {
        Intrinsics.checkNotNullParameter(previous, "previous");
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(applied, "applied");
        StateStateRecord stateStateRecord = (StateStateRecord) previous;
        StateStateRecord stateStateRecord2 = (StateStateRecord) current;
        StateStateRecord stateStateRecord3 = (StateStateRecord) applied;
        if (getPolicy().equivalent(stateStateRecord2.getValue(), stateStateRecord3.getValue())) {
            return current;
        }
        Object merge = getPolicy().merge(stateStateRecord.getValue(), stateStateRecord2.getValue(), stateStateRecord3.getValue());
        if (merge != null) {
            StateRecord create = stateStateRecord3.create();
            Intrinsics.checkNotNull(create, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl.mergeRecords$lambda$2>");
            ((StateStateRecord) create).setValue(merge);
            return create;
        }
        return null;
    }

    /* compiled from: SnapshotState.kt */
    /* loaded from: classes.dex */
    private static final class StateStateRecord extends StateRecord {
        private Object value;

        public final Object getValue() {
            return this.value;
        }

        public final void setValue(Object obj) {
            this.value = obj;
        }

        public StateStateRecord(Object obj) {
            this.value = obj;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = ((StateStateRecord) value).value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new StateStateRecord(this.value);
        }
    }

    @Override // androidx.compose.runtime.MutableState
    public void setValue(Object obj) {
        Snapshot current;
        StateStateRecord stateStateRecord = (StateStateRecord) SnapshotKt.current(this.next);
        if (getPolicy().equivalent(stateStateRecord.getValue(), obj)) {
            return;
        }
        StateStateRecord stateStateRecord2 = this.next;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            current = Snapshot.Companion.getCurrent();
            ((StateStateRecord) SnapshotKt.overwritableRecord(stateStateRecord2, this, current, stateStateRecord)).setValue(obj);
            Unit unit = Unit.INSTANCE;
        }
        SnapshotKt.notifyWrite(current, this);
    }

    public String toString() {
        return "MutableState(value=" + ((StateStateRecord) SnapshotKt.current(this.next)).getValue() + ")@" + hashCode();
    }
}
