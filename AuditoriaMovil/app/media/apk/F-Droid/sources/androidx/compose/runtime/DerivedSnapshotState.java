package androidx.compose.runtime;

import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DerivedState.kt */
/* loaded from: classes.dex */
public final class DerivedSnapshotState implements StateObject, DerivedState {
    private final Function0 calculation;
    private ResultRecord first;
    private final SnapshotMutationPolicy policy;

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.DerivedState
    public SnapshotMutationPolicy getPolicy() {
        return this.policy;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return StateObject.CC.$default$mergeRecords(this, stateRecord, stateRecord2, stateRecord3);
    }

    public DerivedSnapshotState(Function0 calculation, SnapshotMutationPolicy snapshotMutationPolicy) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        this.calculation = calculation;
        this.policy = snapshotMutationPolicy;
        this.first = new ResultRecord();
    }

    /* compiled from: DerivedState.kt */
    /* loaded from: classes.dex */
    public static final class ResultRecord extends StateRecord implements DerivedState.Record {
        private IdentityArrayMap _dependencies;
        private Object result = Unset;
        private int resultHash;
        private int validSnapshotId;
        private int validSnapshotWriteCount;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Object Unset = new Object();

        @Override // androidx.compose.runtime.DerivedState.Record
        public Object getCurrentValue() {
            return this.result;
        }

        public final Object getResult() {
            return this.result;
        }

        public final IdentityArrayMap get_dependencies() {
            return this._dependencies;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        public final void setValidSnapshotId(int i) {
            this.validSnapshotId = i;
        }

        public final void setValidSnapshotWriteCount(int i) {
            this.validSnapshotWriteCount = i;
        }

        public final void set_dependencies(IdentityArrayMap identityArrayMap) {
            this._dependencies = identityArrayMap;
        }

        /* compiled from: DerivedState.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ResultRecord resultRecord = (ResultRecord) value;
            this._dependencies = resultRecord._dependencies;
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new ResultRecord();
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public Object[] getDependencies() {
            Object[] keys;
            IdentityArrayMap identityArrayMap = this._dependencies;
            return (identityArrayMap == null || (keys = identityArrayMap.getKeys()) == null) ? new Object[0] : keys;
        }

        public final boolean isValid(DerivedState derivedState, Snapshot snapshot) {
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            synchronized (SnapshotKt.getLock()) {
                z = true;
                if (this.validSnapshotId == snapshot.getId()) {
                    if (this.validSnapshotWriteCount == snapshot.getWriteCount$runtime_release()) {
                        z2 = false;
                    }
                }
                z2 = true;
            }
            if (this.result == Unset || (z2 && this.resultHash != readableHash(derivedState, snapshot))) {
                z = false;
            }
            if (z && z2) {
                synchronized (SnapshotKt.getLock()) {
                    this.validSnapshotId = snapshot.getId();
                    this.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                    Unit unit = Unit.INSTANCE;
                }
            }
            return z;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[Catch: all -> 0x005e, TryCatch #1 {all -> 0x005e, blocks: (B:13:0x0030, B:15:0x0037, B:25:0x0076, B:18:0x0053, B:20:0x0057, B:24:0x0068, B:23:0x0060, B:26:0x0079), top: B:46:0x0030 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int readableHash(androidx.compose.runtime.DerivedState r10, androidx.compose.runtime.snapshots.Snapshot r11) {
            /*
                r9 = this;
                java.lang.String r0 = "derivedState"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                java.lang.String r0 = "snapshot"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
                monitor-enter(r0)
                androidx.compose.runtime.collection.IdentityArrayMap r1 = r9._dependencies     // Catch: java.lang.Throwable -> La7
                monitor-exit(r0)
                r0 = 7
                if (r1 == 0) goto La6
                androidx.compose.runtime.collection.MutableVector r2 = androidx.compose.runtime.SnapshotStateKt.derivedStateObservers()
                int r3 = r2.getSize()
                r4 = 0
                r5 = 1
                if (r3 <= 0) goto L30
                java.lang.Object[] r6 = r2.getContent()
                r7 = r4
            L26:
                r8 = r6[r7]
                androidx.compose.runtime.DerivedStateObserver r8 = (androidx.compose.runtime.DerivedStateObserver) r8
                r8.start(r10)
                int r7 = r7 + r5
                if (r7 < r3) goto L26
            L30:
                int r3 = r1.getSize()     // Catch: java.lang.Throwable -> L5e
                r6 = r4
            L35:
                if (r6 >= r3) goto L79
                java.lang.Object[] r7 = r1.getKeys()     // Catch: java.lang.Throwable -> L5e
                r7 = r7[r6]     // Catch: java.lang.Throwable -> L5e
                java.lang.String r8 = "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r8)     // Catch: java.lang.Throwable -> L5e
                java.lang.Object[] r8 = r1.getValues()     // Catch: java.lang.Throwable -> L5e
                r8 = r8[r6]     // Catch: java.lang.Throwable -> L5e
                java.lang.Number r8 = (java.lang.Number) r8     // Catch: java.lang.Throwable -> L5e
                int r8 = r8.intValue()     // Catch: java.lang.Throwable -> L5e
                androidx.compose.runtime.snapshots.StateObject r7 = (androidx.compose.runtime.snapshots.StateObject) r7     // Catch: java.lang.Throwable -> L5e
                if (r8 == r5) goto L53
                goto L76
            L53:
                boolean r8 = r7 instanceof androidx.compose.runtime.DerivedSnapshotState     // Catch: java.lang.Throwable -> L5e
                if (r8 == 0) goto L60
                androidx.compose.runtime.DerivedSnapshotState r7 = (androidx.compose.runtime.DerivedSnapshotState) r7     // Catch: java.lang.Throwable -> L5e
                androidx.compose.runtime.snapshots.StateRecord r7 = r7.current(r11)     // Catch: java.lang.Throwable -> L5e
                goto L68
            L5e:
                r11 = move-exception
                goto L90
            L60:
                androidx.compose.runtime.snapshots.StateRecord r7 = r7.getFirstStateRecord()     // Catch: java.lang.Throwable -> L5e
                androidx.compose.runtime.snapshots.StateRecord r7 = androidx.compose.runtime.snapshots.SnapshotKt.current(r7, r11)     // Catch: java.lang.Throwable -> L5e
            L68:
                int r0 = r0 * 31
                int r8 = androidx.compose.runtime.ActualJvm_jvmKt.identityHashCode(r7)     // Catch: java.lang.Throwable -> L5e
                int r0 = r0 + r8
                int r0 = r0 * 31
                int r7 = r7.getSnapshotId$runtime_release()     // Catch: java.lang.Throwable -> L5e
                int r0 = r0 + r7
            L76:
                int r6 = r6 + 1
                goto L35
            L79:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L5e
                int r11 = r2.getSize()
                if (r11 <= 0) goto La6
                java.lang.Object[] r1 = r2.getContent()
            L85:
                r2 = r1[r4]
                androidx.compose.runtime.DerivedStateObserver r2 = (androidx.compose.runtime.DerivedStateObserver) r2
                r2.done(r10)
                int r4 = r4 + r5
                if (r4 < r11) goto L85
                goto La6
            L90:
                int r0 = r2.getSize()
                if (r0 <= 0) goto La5
                java.lang.Object[] r1 = r2.getContent()
            L9a:
                r2 = r1[r4]
                androidx.compose.runtime.DerivedStateObserver r2 = (androidx.compose.runtime.DerivedStateObserver) r2
                r2.done(r10)
                int r4 = r4 + r5
                if (r4 >= r0) goto La5
                goto L9a
            La5:
                throw r11
            La6:
                return r0
            La7:
                r10 = move-exception
                monitor-exit(r0)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedSnapshotState.ResultRecord.readableHash(androidx.compose.runtime.DerivedState, androidx.compose.runtime.snapshots.Snapshot):int");
        }
    }

    public final StateRecord current(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[Catch: all -> 0x0038, TryCatch #2 {all -> 0x0038, blocks: (B:10:0x0023, B:12:0x0033, B:17:0x003d, B:19:0x0044, B:21:0x006f, B:22:0x0072, B:23:0x0075), top: B:82:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d A[Catch: all -> 0x0038, TryCatch #2 {all -> 0x0038, blocks: (B:10:0x0023, B:12:0x0033, B:17:0x003d, B:19:0x0044, B:21:0x006f, B:22:0x0072, B:23:0x0075), top: B:82:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.runtime.DerivedSnapshotState.ResultRecord currentRecord(androidx.compose.runtime.DerivedSnapshotState.ResultRecord r10, androidx.compose.runtime.snapshots.Snapshot r11, boolean r12, kotlin.jvm.functions.Function0 r13) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedSnapshotState.currentRecord(androidx.compose.runtime.DerivedSnapshotState$ResultRecord, androidx.compose.runtime.snapshots.Snapshot, boolean, kotlin.jvm.functions.Function0):androidx.compose.runtime.DerivedSnapshotState$ResultRecord");
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.first = (ResultRecord) value;
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        Snapshot.Companion companion = Snapshot.Companion;
        Function1 readObserver$runtime_release = companion.getCurrent().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), companion.getCurrent(), true, this.calculation).getResult();
    }

    private final String displayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        return resultRecord.isValid(this, Snapshot.Companion.getCurrent()) ? String.valueOf(resultRecord.getResult()) : "<Not calculated>";
    }

    @Override // androidx.compose.runtime.DerivedState
    public DerivedState.Record getCurrentRecord() {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), false, this.calculation);
    }

    public String toString() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }
}
