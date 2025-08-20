package androidx.compose.runtime.snapshots;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
/* compiled from: SnapshotStateObserver.kt */
/* loaded from: classes.dex */
public final class SnapshotStateObserver {
    private final Function2 applyObserver;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final MutableVector observedScopeMaps;
    private final Function1 onChangedExecutor;
    private final AtomicReference pendingChanges;
    private final Function1 readObserver;
    private boolean sendingNotifications;

    public SnapshotStateObserver(Function1 onChangedExecutor) {
        Intrinsics.checkNotNullParameter(onChangedExecutor, "onChangedExecutor");
        this.onChangedExecutor = onChangedExecutor;
        this.pendingChanges = new AtomicReference(null);
        this.applyObserver = new Function2() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Set) obj, (Snapshot) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(Set applied, Snapshot snapshot) {
                boolean drainChanges;
                Intrinsics.checkNotNullParameter(applied, "applied");
                Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
                SnapshotStateObserver.this.addChanges(applied);
                drainChanges = SnapshotStateObserver.this.drainChanges();
                if (drainChanges) {
                    SnapshotStateObserver.this.sendNotifications();
                }
            }
        };
        this.readObserver = new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m634invoke(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m634invoke(Object state) {
                boolean z;
                MutableVector mutableVector;
                SnapshotStateObserver.ObservedScopeMap observedScopeMap;
                Intrinsics.checkNotNullParameter(state, "state");
                z = SnapshotStateObserver.this.isPaused;
                if (z) {
                    return;
                }
                mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                synchronized (mutableVector) {
                    observedScopeMap = snapshotStateObserver.currentMap;
                    Intrinsics.checkNotNull(observedScopeMap);
                    observedScopeMap.recordRead(state);
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
        this.observedScopeMaps = new MutableVector(new ObservedScopeMap[16], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set removeChanges = removeChanges();
            if (removeChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMaps) {
                try {
                    MutableVector mutableVector = this.observedScopeMaps;
                    int size = mutableVector.getSize();
                    if (size > 0) {
                        Object[] content = mutableVector.getContent();
                        int i = 0;
                        do {
                            if (!((ObservedScopeMap) content[i]).recordInvalidation(removeChanges) && !z2) {
                                z2 = false;
                                i++;
                            }
                            z2 = true;
                            i++;
                        } while (i < size);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$sendNotifications$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m635invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m635invoke() {
                MutableVector mutableVector;
                boolean z;
                boolean drainChanges;
                MutableVector mutableVector2;
                do {
                    mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (mutableVector) {
                        try {
                            z = snapshotStateObserver.sendingNotifications;
                            if (!z) {
                                snapshotStateObserver.sendingNotifications = true;
                                mutableVector2 = snapshotStateObserver.observedScopeMaps;
                                int size = mutableVector2.getSize();
                                if (size <= 0) {
                                    snapshotStateObserver.sendingNotifications = false;
                                } else {
                                    Object[] content = mutableVector2.getContent();
                                    int i = 0;
                                    do {
                                        ((SnapshotStateObserver.ObservedScopeMap) content[i]).notifyInvalidatedScopes();
                                        i++;
                                    } while (i < size);
                                    snapshotStateObserver.sendingNotifications = false;
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    drainChanges = SnapshotStateObserver.this.drainChanges();
                } while (drainChanges);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SnapshotStateObserver.kt */
    /* loaded from: classes.dex */
    public static final class ObservedScopeMap {
        private Object currentScope;
        private IdentityArrayIntMap currentScopeReads;
        private int currentToken;
        private final IdentityScopeMap dependencyToDerivedStates;
        private int deriveStateScopeCount;
        private final DerivedStateObserver derivedStateObserver;
        private final IdentityArraySet invalidated;
        private final Function1 onChanged;
        private final HashMap recordedDerivedStateValues;
        private final IdentityArrayMap scopeToValues;
        private final MutableVector statesToReread;
        private final IdentityScopeMap valueToScopes;

        public final Function1 getOnChanged() {
            return this.onChanged;
        }

        public final void notifyInvalidatedScopes() {
            IdentityArraySet identityArraySet = this.invalidated;
            Function1 function1 = this.onChanged;
            Object[] values = identityArraySet.getValues();
            int size = identityArraySet.size();
            for (int i = 0; i < size; i++) {
                Object obj = values[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                function1.invoke(obj);
            }
            identityArraySet.clear();
        }

        public final void removeScopeIf(Function1 predicate) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            IdentityArrayMap identityArrayMap = this.scopeToValues;
            int size = identityArrayMap.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = identityArrayMap.getKeys()[i2];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                IdentityArrayIntMap identityArrayIntMap = (IdentityArrayIntMap) identityArrayMap.getValues()[i2];
                Boolean bool = (Boolean) predicate.invoke(obj);
                if (bool.booleanValue()) {
                    Object[] keys = identityArrayIntMap.getKeys();
                    int[] values = identityArrayIntMap.getValues();
                    int size2 = identityArrayIntMap.getSize();
                    for (int i3 = 0; i3 < size2; i3++) {
                        Object obj2 = keys[i3];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Any");
                        int i4 = values[i3];
                        removeObservation(obj, obj2);
                    }
                }
                if (!bool.booleanValue()) {
                    if (i != i2) {
                        identityArrayMap.getKeys()[i] = obj;
                        identityArrayMap.getValues()[i] = identityArrayMap.getValues()[i2];
                    }
                    i++;
                }
            }
            if (identityArrayMap.getSize() > i) {
                int size3 = identityArrayMap.getSize();
                for (int i5 = i; i5 < size3; i5++) {
                    identityArrayMap.getKeys()[i5] = null;
                    identityArrayMap.getValues()[i5] = null;
                }
                identityArrayMap.size = i;
            }
        }

        private final void clearObsoleteStateReads(Object obj) {
            int i = this.currentToken;
            IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
            if (identityArrayIntMap != null) {
                Object[] keys = identityArrayIntMap.getKeys();
                int[] values = identityArrayIntMap.getValues();
                int size = identityArrayIntMap.getSize();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    Object obj2 = keys[i3];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Any");
                    int i4 = values[i3];
                    boolean z = i4 != i;
                    if (z) {
                        removeObservation(obj, obj2);
                    }
                    if (!z) {
                        if (i2 != i3) {
                            keys[i2] = obj2;
                            values[i2] = i4;
                        }
                        i2++;
                    }
                }
                for (int i5 = i2; i5 < size; i5++) {
                    keys[i5] = null;
                }
                identityArrayIntMap.size = i2;
            }
        }

        public ObservedScopeMap(Function1 onChanged) {
            Intrinsics.checkNotNullParameter(onChanged, "onChanged");
            this.onChanged = onChanged;
            this.currentToken = -1;
            this.valueToScopes = new IdentityScopeMap();
            this.scopeToValues = new IdentityArrayMap(0, 1, null);
            this.invalidated = new IdentityArraySet();
            this.statesToReread = new MutableVector(new DerivedState[16], 0);
            this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
                @Override // androidx.compose.runtime.DerivedStateObserver
                public void start(DerivedState derivedState) {
                    int i;
                    Intrinsics.checkNotNullParameter(derivedState, "derivedState");
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = SnapshotStateObserver.ObservedScopeMap.this;
                    i = observedScopeMap.deriveStateScopeCount;
                    observedScopeMap.deriveStateScopeCount = i + 1;
                }

                @Override // androidx.compose.runtime.DerivedStateObserver
                public void done(DerivedState derivedState) {
                    int i;
                    Intrinsics.checkNotNullParameter(derivedState, "derivedState");
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = SnapshotStateObserver.ObservedScopeMap.this;
                    i = observedScopeMap.deriveStateScopeCount;
                    observedScopeMap.deriveStateScopeCount = i - 1;
                }
            };
            this.dependencyToDerivedStates = new IdentityScopeMap();
            this.recordedDerivedStateValues = new HashMap();
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00f1, code lost:
            r9 = r2.find(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0032, code lost:
            r14 = r2.find(r13);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean recordInvalidation(java.util.Set r20) {
            /*
                Method dump skipped, instructions count: 422
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.recordInvalidation(java.util.Set):boolean");
        }

        public final void recordRead(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Object obj = this.currentScope;
            Intrinsics.checkNotNull(obj);
            int i = this.currentToken;
            IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
            if (identityArrayIntMap == null) {
                identityArrayIntMap = new IdentityArrayIntMap();
                this.currentScopeReads = identityArrayIntMap;
                this.scopeToValues.set(obj, identityArrayIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(value, i, obj, identityArrayIntMap);
        }

        private final void recordRead(Object obj, int i, Object obj2, IdentityArrayIntMap identityArrayIntMap) {
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int add = identityArrayIntMap.add(obj, i);
            if ((obj instanceof DerivedState) && add != i) {
                DerivedState.Record currentRecord = ((DerivedState) obj).getCurrentRecord();
                this.recordedDerivedStateValues.put(obj, currentRecord.getCurrentValue());
                Object[] dependencies = currentRecord.getDependencies();
                IdentityScopeMap identityScopeMap = this.dependencyToDerivedStates;
                identityScopeMap.removeScope(obj);
                for (Object obj3 : dependencies) {
                    if (obj3 == null) {
                        break;
                    }
                    identityScopeMap.add(obj3, obj);
                }
            }
            if (add == -1) {
                this.valueToScopes.add(obj, obj2);
            }
        }

        public final void observe(Object scope, Function1 readObserver, Function0 block) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(readObserver, "readObserver");
            Intrinsics.checkNotNullParameter(block, "block");
            Object obj = this.currentScope;
            IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
            int i = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = (IdentityArrayIntMap) this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver derivedStateObserver = this.derivedStateObserver;
            MutableVector derivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                derivedStateObservers.add(derivedStateObserver);
                Snapshot.Companion.observe(readObserver, null, block);
                derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                Object obj2 = this.currentScope;
                Intrinsics.checkNotNull(obj2);
                clearObsoleteStateReads(obj2);
                this.currentScope = obj;
                this.currentScopeReads = identityArrayIntMap;
                this.currentToken = i;
            } catch (Throwable th) {
                derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                throw th;
            }
        }

        private final void removeObservation(Object obj, Object obj2) {
            this.valueToScopes.remove(obj2, obj);
            if (!(obj2 instanceof DerivedState) || this.valueToScopes.contains(obj2)) {
                return;
            }
            this.dependencyToDerivedStates.removeScope(obj2);
            this.recordedDerivedStateValues.remove(obj2);
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        public final void rereadDerivedState(DerivedState derivedState) {
            int find;
            IdentityArraySet scopeSetAt;
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            IdentityArrayMap identityArrayMap = this.scopeToValues;
            int id = SnapshotKt.currentSnapshot().getId();
            IdentityScopeMap identityScopeMap = this.valueToScopes;
            find = identityScopeMap.find(derivedState);
            if (find >= 0) {
                scopeSetAt = identityScopeMap.scopeSetAt(find);
                Object[] values = scopeSetAt.getValues();
                int size = scopeSetAt.size();
                for (int i = 0; i < size; i++) {
                    Object obj = values[i];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    IdentityArrayIntMap identityArrayIntMap = (IdentityArrayIntMap) identityArrayMap.get(obj);
                    if (identityArrayIntMap == null) {
                        identityArrayIntMap = new IdentityArrayIntMap();
                        identityArrayMap.set(obj, identityArrayIntMap);
                        Unit unit = Unit.INSTANCE;
                    }
                    recordRead(derivedState, id, obj, identityArrayIntMap);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addChanges(Set set) {
        Object obj;
        List listOf;
        Set plus;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                plus = set;
            } else if (obj instanceof Set) {
                plus = CollectionsKt__CollectionsKt.listOf((Object[]) new Set[]{obj, set});
            } else if (!(obj instanceof List)) {
                report();
                throw new KotlinNothingValueException();
            } else {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(set);
                plus = CollectionsKt___CollectionsKt.plus((Collection) obj, (Iterable) listOf);
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, plus));
    }

    private final Set removeChanges() {
        Object obj;
        Object obj2;
        Set set;
        do {
            obj = this.pendingChanges.get();
            obj2 = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else if (obj instanceof List) {
                List list = (List) obj;
                Set set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    obj2 = list.get(1);
                } else if (list.size() > 2) {
                    obj2 = list.subList(1, list.size());
                }
                set = set2;
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, obj2));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        ((ObservedScopeMap) content[i]).clear();
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void clearIf(Function1 predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        ((ObservedScopeMap) content[i]).removeScopeIf(predicate);
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void observeReads(Object scope, Function1 onValueChangedForScope, Function0 block) {
        ObservedScopeMap ensureMap;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onValueChangedForScope, "onValueChangedForScope");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (this.observedScopeMaps) {
            ensureMap = ensureMap(onValueChangedForScope);
        }
        boolean z = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        try {
            this.isPaused = false;
            this.currentMap = ensureMap;
            ensureMap.observe(scope, this.readObserver, block);
        } finally {
            this.currentMap = observedScopeMap;
            this.isPaused = z;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    private final ObservedScopeMap ensureMap(Function1 function1) {
        ObservedScopeMap observedScopeMap;
        MutableVector mutableVector = this.observedScopeMaps;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                observedScopeMap = content[i];
                if (((ObservedScopeMap) observedScopeMap).getOnChanged() == function1) {
                    break;
                }
                i++;
            } while (i < size);
            observedScopeMap = null;
        } else {
            observedScopeMap = null;
        }
        ObservedScopeMap observedScopeMap2 = observedScopeMap;
        if (observedScopeMap2 == null) {
            Intrinsics.checkNotNull(function1, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
            ObservedScopeMap observedScopeMap3 = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1));
            this.observedScopeMaps.add(observedScopeMap3);
            return observedScopeMap3;
        }
        return observedScopeMap2;
    }
}
