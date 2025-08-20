package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.WeakReference;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public abstract class SnapshotKt {
    private static final List applyObservers;
    private static final AtomicReference currentGlobalSnapshot;
    private static final SnapshotWeakSet extraStateObjects;
    private static final List globalWriteObservers;
    private static int nextSnapshotId;
    private static SnapshotIdSet openSnapshots;
    private static AtomicInt pendingApplyObserverCount;
    private static final SnapshotDoubleIndexHeap pinningTable;
    private static final Snapshot snapshotInitializer;
    private static final Function1 emptyLambda = new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$emptyLambda$1
        public final void invoke(SnapshotIdSet it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SnapshotIdSet) obj);
            return Unit.INSTANCE;
        }
    };
    private static final SnapshotThreadLocal threadSnapshot = new SnapshotThreadLocal();
    private static final Object lock = new Object();

    public static final Object getLock() {
        return lock;
    }

    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    public static final void checkAndOverwriteUnusedRecordsLocked() {
        Object obj;
        SnapshotWeakSet snapshotWeakSet = extraStateObjects;
        int size$runtime_release = snapshotWeakSet.getSize$runtime_release();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size$runtime_release) {
                break;
            }
            WeakReference weakReference = snapshotWeakSet.getValues$runtime_release()[i];
            if ((weakReference != null ? weakReference.get() : null) != null && !(!overwriteUnusedRecordsLocked((StateObject) obj))) {
                if (i2 != i) {
                    snapshotWeakSet.getValues$runtime_release()[i2] = weakReference;
                    snapshotWeakSet.getHashes$runtime_release()[i2] = snapshotWeakSet.getHashes$runtime_release()[i];
                }
                i2++;
            }
            i++;
        }
        for (int i3 = i2; i3 < size$runtime_release; i3++) {
            snapshotWeakSet.getValues$runtime_release()[i3] = null;
            snapshotWeakSet.getHashes$runtime_release()[i3] = 0;
        }
        if (i2 != size$runtime_release) {
            snapshotWeakSet.setSize$runtime_release(i2);
        }
    }

    public static final int trackPinning(int i, SnapshotIdSet invalid) {
        int add;
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        int lowest = invalid.lowest(i);
        synchronized (getLock()) {
            add = pinningTable.add(lowest);
        }
        return add;
    }

    public static final void releasePinningLocked(int i) {
        pinningTable.remove(i);
    }

    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = (Snapshot) threadSnapshot.get();
        if (snapshot == null) {
            Object obj = currentGlobalSnapshot.get();
            Intrinsics.checkNotNullExpressionValue(obj, "currentGlobalSnapshot.get()");
            return (Snapshot) obj;
        }
        return snapshot;
    }

    public static /* synthetic */ Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot snapshot, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return createTransparentSnapshotWithNoParentReadObserver(snapshot, function1, z);
    }

    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot snapshot, Function1 function1, boolean z) {
        boolean z2 = snapshot instanceof MutableSnapshot;
        if (z2 || snapshot == null) {
            return new TransparentObserverMutableSnapshot(z2 ? (MutableSnapshot) snapshot : null, function1, null, false, z);
        }
        return new TransparentObserverSnapshot(snapshot, function1, false, z);
    }

    public static /* synthetic */ Function1 mergedReadObserver$default(Function1 function1, Function1 function12, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return mergedReadObserver(function1, function12, z);
    }

    public static final Function1 mergedReadObserver(final Function1 function1, final Function1 function12, boolean z) {
        if (!z) {
            function12 = null;
        }
        if (function1 == null || function12 == null || Intrinsics.areEqual(function1, function12)) {
            return function1 == null ? function12 : function1;
        }
        return new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedReadObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m632invoke(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m632invoke(Object state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Function1.this.invoke(state);
                function12.invoke(state);
            }
        };
    }

    public static final Function1 mergedWriteObserver(final Function1 function1, final Function1 function12) {
        if (function1 == null || function12 == null || Intrinsics.areEqual(function1, function12)) {
            return function1 == null ? function12 : function1;
        }
        return new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedWriteObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m633invoke(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m633invoke(Object state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Function1.this.invoke(state);
                function12.invoke(state);
            }
        };
    }

    static {
        SnapshotIdSet.Companion companion = SnapshotIdSet.Companion;
        openSnapshots = companion.getEMPTY();
        nextSnapshotId = 1;
        pinningTable = new SnapshotDoubleIndexHeap();
        extraStateObjects = new SnapshotWeakSet();
        applyObservers = new ArrayList();
        globalWriteObservers = new ArrayList();
        int i = nextSnapshotId;
        nextSnapshotId = i + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(i, companion.getEMPTY());
        openSnapshots = openSnapshots.set(globalSnapshot.getId());
        AtomicReference atomicReference = new AtomicReference(globalSnapshot);
        currentGlobalSnapshot = atomicReference;
        Object obj = atomicReference.get();
        Intrinsics.checkNotNullExpressionValue(obj, "currentGlobalSnapshot.get()");
        snapshotInitializer = (Snapshot) obj;
        pendingApplyObserverCount = new AtomicInt(0);
    }

    public static final StateRecord newWritableRecord(StateRecord stateRecord, StateObject state, Snapshot snapshot) {
        StateRecord newWritableRecordLocked;
        Intrinsics.checkNotNullParameter(stateRecord, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        synchronized (getLock()) {
            newWritableRecordLocked = newWritableRecordLocked(stateRecord, state, snapshot);
        }
        return newWritableRecordLocked;
    }

    public static final Object takeNewGlobalSnapshot(Snapshot snapshot, Function1 function1) {
        Object invoke = function1.invoke(openSnapshots.clear(snapshot.getId()));
        synchronized (getLock()) {
            int i = nextSnapshotId;
            nextSnapshotId = i + 1;
            openSnapshots = openSnapshots.clear(snapshot.getId());
            currentGlobalSnapshot.set(new GlobalSnapshot(i, openSnapshots));
            snapshot.dispose();
            openSnapshots = openSnapshots.set(i);
            Unit unit = Unit.INSTANCE;
        }
        return invoke;
    }

    public static final Object advanceGlobalSnapshot(Function1 function1) {
        Object obj;
        IdentityArraySet modified$runtime_release;
        Object takeNewGlobalSnapshot;
        List mutableList;
        Snapshot snapshot = snapshotInitializer;
        Intrinsics.checkNotNull(snapshot, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        GlobalSnapshot globalSnapshot = (GlobalSnapshot) snapshot;
        synchronized (getLock()) {
            try {
                obj = currentGlobalSnapshot.get();
                Intrinsics.checkNotNullExpressionValue(obj, "currentGlobalSnapshot.get()");
                modified$runtime_release = ((GlobalSnapshot) obj).getModified$runtime_release();
                if (modified$runtime_release != null) {
                    pendingApplyObserverCount.add(1);
                }
                takeNewGlobalSnapshot = takeNewGlobalSnapshot((Snapshot) obj, function1);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (modified$runtime_release != null) {
            try {
                synchronized (getLock()) {
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) applyObservers);
                }
                int size = mutableList.size();
                for (int i = 0; i < size; i++) {
                    ((Function2) mutableList.get(i)).invoke(modified$runtime_release, obj);
                }
            } finally {
                pendingApplyObserverCount.add(-1);
            }
        }
        synchronized (getLock()) {
            try {
                checkAndOverwriteUnusedRecordsLocked();
                if (modified$runtime_release != null) {
                    Object[] values = modified$runtime_release.getValues();
                    int size2 = modified$runtime_release.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        Object obj2 = values[i2];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                        processForUnusedRecordsLocked((StateObject) obj2);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return takeNewGlobalSnapshot;
    }

    public static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$advanceGlobalSnapshot$3
            public final void invoke(SnapshotIdSet it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SnapshotIdSet) obj);
                return Unit.INSTANCE;
            }
        });
    }

    public static final Snapshot takeNewSnapshot(final Function1 function1) {
        return (Snapshot) advanceGlobalSnapshot(new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$takeNewSnapshot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Snapshot invoke(SnapshotIdSet invalid) {
                SnapshotIdSet snapshotIdSet;
                Intrinsics.checkNotNullParameter(invalid, "invalid");
                Snapshot snapshot = (Snapshot) Function1.this.invoke(invalid);
                synchronized (SnapshotKt.getLock()) {
                    snapshotIdSet = SnapshotKt.openSnapshots;
                    SnapshotKt.openSnapshots = snapshotIdSet.set(snapshot.getId());
                    Unit unit = Unit.INSTANCE;
                }
                return snapshot;
            }
        });
    }

    public static final void validateOpen(Snapshot snapshot) {
        if (!openSnapshots.get(snapshot.getId())) {
            throw new IllegalStateException("Snapshot is not open".toString());
        }
    }

    private static final boolean valid(int i, int i2, SnapshotIdSet snapshotIdSet) {
        return (i2 == 0 || i2 > i || snapshotIdSet.get(i2)) ? false : true;
    }

    private static final boolean valid(StateRecord stateRecord, int i, SnapshotIdSet snapshotIdSet) {
        return valid(i, stateRecord.getSnapshotId$runtime_release(), snapshotIdSet);
    }

    public static final StateRecord readable(StateRecord stateRecord, int i, SnapshotIdSet snapshotIdSet) {
        StateRecord stateRecord2 = null;
        while (stateRecord != null) {
            if (valid(stateRecord, i, snapshotIdSet) && (stateRecord2 == null || stateRecord2.getSnapshotId$runtime_release() < stateRecord.getSnapshotId$runtime_release())) {
                stateRecord2 = stateRecord;
            }
            stateRecord = stateRecord.getNext$runtime_release();
        }
        if (stateRecord2 != null) {
            return stateRecord2;
        }
        return null;
    }

    public static final StateRecord readable(StateRecord stateRecord, StateObject state) {
        StateRecord readable;
        Intrinsics.checkNotNullParameter(stateRecord, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot current = companion.getCurrent();
        Function1 readObserver$runtime_release = current.getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(state);
        }
        StateRecord readable2 = readable(stateRecord, current.getId(), current.getInvalid$runtime_release());
        if (readable2 == null) {
            synchronized (getLock()) {
                Snapshot current2 = companion.getCurrent();
                StateRecord firstStateRecord = state.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");
                readable = readable(firstStateRecord, current2.getId(), current2.getInvalid$runtime_release());
                if (readable == null) {
                    readError();
                    throw new KotlinNothingValueException();
                }
            }
            return readable;
        }
        return readable2;
    }

    public static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    }

    private static final StateRecord usedLocked(StateObject stateObject) {
        int lowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId) - 1;
        SnapshotIdSet empty = SnapshotIdSet.Companion.getEMPTY();
        StateRecord stateRecord = null;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
            if (firstStateRecord.getSnapshotId$runtime_release() == 0) {
                return firstStateRecord;
            }
            if (valid(firstStateRecord, lowestOrDefault, empty)) {
                if (stateRecord != null) {
                    return firstStateRecord.getSnapshotId$runtime_release() < stateRecord.getSnapshotId$runtime_release() ? firstStateRecord : stateRecord;
                }
                stateRecord = firstStateRecord;
            }
        }
        return null;
    }

    private static final boolean overwriteUnusedRecordsLocked(StateObject stateObject) {
        StateRecord stateRecord;
        int lowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId);
        StateRecord stateRecord2 = null;
        StateRecord stateRecord3 = null;
        int i = 0;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
            int snapshotId$runtime_release = firstStateRecord.getSnapshotId$runtime_release();
            if (snapshotId$runtime_release != 0) {
                if (snapshotId$runtime_release >= lowestOrDefault) {
                    i++;
                } else if (stateRecord2 == null) {
                    i++;
                    stateRecord2 = firstStateRecord;
                } else {
                    if (firstStateRecord.getSnapshotId$runtime_release() < stateRecord2.getSnapshotId$runtime_release()) {
                        stateRecord = stateRecord2;
                        stateRecord2 = firstStateRecord;
                    } else {
                        stateRecord = firstStateRecord;
                    }
                    if (stateRecord3 == null) {
                        stateRecord3 = stateObject.getFirstStateRecord();
                        StateRecord stateRecord4 = stateRecord3;
                        while (true) {
                            if (stateRecord3 == null) {
                                stateRecord3 = stateRecord4;
                                break;
                            } else if (stateRecord3.getSnapshotId$runtime_release() >= lowestOrDefault) {
                                break;
                            } else {
                                if (stateRecord4.getSnapshotId$runtime_release() < stateRecord3.getSnapshotId$runtime_release()) {
                                    stateRecord4 = stateRecord3;
                                }
                                stateRecord3 = stateRecord3.getNext$runtime_release();
                            }
                        }
                    }
                    stateRecord2.setSnapshotId$runtime_release(0);
                    stateRecord2.assign(stateRecord3);
                    stateRecord2 = stateRecord;
                }
            }
        }
        return i > 1;
    }

    public static final void processForUnusedRecordsLocked(StateObject stateObject) {
        if (overwriteUnusedRecordsLocked(stateObject)) {
            extraStateObjects.add(stateObject);
        }
    }

    public static final StateRecord writableRecord(StateRecord stateRecord, StateObject state, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(stateRecord, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        if (snapshot.getReadOnly()) {
            snapshot.mo630recordModified$runtime_release(state);
        }
        StateRecord readable = readable(stateRecord, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable == null) {
            readError();
            throw new KotlinNothingValueException();
        } else if (readable.getSnapshotId$runtime_release() == snapshot.getId()) {
            return readable;
        } else {
            StateRecord newWritableRecord = newWritableRecord(readable, state, snapshot);
            snapshot.mo630recordModified$runtime_release(state);
            return newWritableRecord;
        }
    }

    public static final StateRecord overwritableRecord(StateRecord stateRecord, StateObject state, Snapshot snapshot, StateRecord candidate) {
        StateRecord newOverwritableRecordLocked;
        Intrinsics.checkNotNullParameter(stateRecord, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        if (snapshot.getReadOnly()) {
            snapshot.mo630recordModified$runtime_release(state);
        }
        int id = snapshot.getId();
        if (candidate.getSnapshotId$runtime_release() == id) {
            return candidate;
        }
        synchronized (getLock()) {
            newOverwritableRecordLocked = newOverwritableRecordLocked(stateRecord, state);
        }
        newOverwritableRecordLocked.setSnapshotId$runtime_release(id);
        snapshot.mo630recordModified$runtime_release(state);
        return newOverwritableRecordLocked;
    }

    private static final StateRecord newWritableRecordLocked(StateRecord stateRecord, StateObject stateObject, Snapshot snapshot) {
        StateRecord newOverwritableRecordLocked = newOverwritableRecordLocked(stateRecord, stateObject);
        newOverwritableRecordLocked.assign(stateRecord);
        newOverwritableRecordLocked.setSnapshotId$runtime_release(snapshot.getId());
        return newOverwritableRecordLocked;
    }

    public static final StateRecord newOverwritableRecordLocked(StateRecord stateRecord, StateObject state) {
        Intrinsics.checkNotNullParameter(stateRecord, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        StateRecord usedLocked = usedLocked(state);
        if (usedLocked != null) {
            usedLocked.setSnapshotId$runtime_release(Integer.MAX_VALUE);
            return usedLocked;
        }
        StateRecord create = stateRecord.create();
        create.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        create.setNext$runtime_release(state.getFirstStateRecord());
        Intrinsics.checkNotNull(create, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked$lambda$15");
        state.prependStateRecord(create);
        Intrinsics.checkNotNull(create, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return create;
    }

    public static final void notifyWrite(Snapshot snapshot, StateObject state) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Intrinsics.checkNotNullParameter(state, "state");
        snapshot.setWriteCount$runtime_release(snapshot.getWriteCount$runtime_release() + 1);
        Function1 writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(state);
        }
    }

    public static final Map optimisticMerges(MutableSnapshot mutableSnapshot, MutableSnapshot mutableSnapshot2, SnapshotIdSet snapshotIdSet) {
        StateRecord readable;
        IdentityArraySet modified$runtime_release = mutableSnapshot2.getModified$runtime_release();
        int id = mutableSnapshot.getId();
        if (modified$runtime_release == null) {
            return null;
        }
        SnapshotIdSet or = mutableSnapshot2.getInvalid$runtime_release().set(mutableSnapshot2.getId()).or(mutableSnapshot2.getPreviousIds$runtime_release());
        Object[] values = modified$runtime_release.getValues();
        int size = modified$runtime_release.size();
        HashMap hashMap = null;
        for (int i = 0; i < size; i++) {
            Object obj = values[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            StateObject stateObject = (StateObject) obj;
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            StateRecord readable2 = readable(firstStateRecord, id, snapshotIdSet);
            if (readable2 != null && (readable = readable(firstStateRecord, id, or)) != null && !Intrinsics.areEqual(readable2, readable)) {
                StateRecord readable3 = readable(firstStateRecord, mutableSnapshot2.getId(), mutableSnapshot2.getInvalid$runtime_release());
                if (readable3 == null) {
                    readError();
                    throw new KotlinNothingValueException();
                }
                StateRecord mergeRecords = stateObject.mergeRecords(readable, readable2, readable3);
                if (mergeRecords == null) {
                    return null;
                }
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(readable2, mergeRecords);
                hashMap = hashMap;
            }
        }
        return hashMap;
    }

    public static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    }

    public static final StateRecord current(StateRecord r, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(r, "r");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        StateRecord readable = readable(r, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable != null) {
            return readable;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final StateRecord current(StateRecord r) {
        StateRecord readable;
        Intrinsics.checkNotNullParameter(r, "r");
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot current = companion.getCurrent();
        StateRecord readable2 = readable(r, current.getId(), current.getInvalid$runtime_release());
        if (readable2 == null) {
            synchronized (getLock()) {
                Snapshot current2 = companion.getCurrent();
                readable = readable(r, current2.getId(), current2.getInvalid$runtime_release());
            }
            if (readable != null) {
                return readable;
            }
            readError();
            throw new KotlinNothingValueException();
        }
        return readable2;
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet snapshotIdSet, int i, int i2) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "<this>");
        while (i < i2) {
            snapshotIdSet = snapshotIdSet.set(i);
            i++;
        }
        return snapshotIdSet;
    }
}
