package androidx.compose.runtime;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composition.kt */
/* loaded from: classes.dex */
public final class CompositionImpl implements ControlledComposition, RecomposeScopeOwner {
    private final CoroutineContext _recomposeContext;
    private final HashSet abandonSet;
    private final Applier applier;
    private final List changes;
    private Function2 composable;
    private final ComposerImpl composer;
    private final HashSet conditionallyInvalidatedScopes;
    private final IdentityScopeMap derivedStates;
    private boolean disposed;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private IdentityArrayMap invalidations;
    private final boolean isRoot;
    private final List lateChanges;
    private final Object lock;
    private final IdentityScopeMap observations;
    private final IdentityScopeMap observationsProcessed;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference pendingModifications;
    private final SlotTable slotTable;

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.pendingInvalidScopes = true;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List references) {
        Intrinsics.checkNotNullParameter(references, "references");
        int size = references.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual(((MovableContentStateReference) ((Pair) references.get(i)).getFirst()).getComposition$runtime_release(), this)) {
                break;
            } else {
                i++;
            }
        }
        ComposerKt.runtimeCheck(z);
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } finally {
        }
    }

    private final InvalidationResult invalidateChecked(RecomposeScopeImpl recomposeScopeImpl, Anchor anchor, Object obj) {
        synchronized (this.lock) {
            try {
                CompositionImpl compositionImpl = this.invalidationDelegate;
                if (compositionImpl == null || !this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                    compositionImpl = null;
                }
                if (compositionImpl == null) {
                    if (tryImminentInvalidation(recomposeScopeImpl, obj)) {
                        return InvalidationResult.IMMINENT;
                    } else if (obj != null) {
                        CompositionKt.addValue(this.invalidations, recomposeScopeImpl, obj);
                    } else {
                        this.invalidations.set(recomposeScopeImpl, null);
                    }
                }
                if (compositionImpl != null) {
                    return compositionImpl.invalidateChecked(recomposeScopeImpl, anchor, obj);
                }
                this.parent.invalidate$runtime_release(this);
                return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
            } finally {
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e) {
                        abandonChanges();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (!this.lateChanges.isEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e) {
                        abandonChanges();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e) {
                        abandonChanges();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2 content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                IdentityArrayMap takeInvalidations = takeInvalidations();
                try {
                    this.composer.composeContent$runtime_release(takeInvalidations, content);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    this.invalidations = takeInvalidations;
                    throw e;
                }
            }
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            } catch (Exception e2) {
                abandonChanges();
                throw e2;
            }
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            try {
                if (!this.disposed) {
                    this.disposed = true;
                    this.composable = ComposableSingletons$CompositionKt.INSTANCE.m601getLambda2$runtime_release();
                    List deferredChanges$runtime_release = this.composer.getDeferredChanges$runtime_release();
                    if (deferredChanges$runtime_release != null) {
                        applyChangesInLocked(deferredChanges$runtime_release);
                    }
                    boolean z = this.slotTable.getGroupsSize() > 0;
                    if (z || (true ^ this.abandonSet.isEmpty())) {
                        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                        if (z) {
                            this.applier.onBeginChanges();
                            SlotWriter openWriter = this.slotTable.openWriter();
                            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
                            Unit unit = Unit.INSTANCE;
                            openWriter.close();
                            this.applier.clear();
                            this.applier.onEndChanges();
                            rememberEventDispatcher.dispatchRememberObservers();
                        }
                        rememberEventDispatcher.dispatchAbandons();
                    }
                    this.composer.dispose$runtime_release();
                }
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = this.invalidations.getSize() > 0;
        }
        return z;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        Object[] slots;
        synchronized (this.lock) {
            try {
                for (Object obj : this.slotTable.getSlots()) {
                    RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.invalidate();
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        boolean recompose$runtime_release;
        synchronized (this.lock) {
            try {
                drainPendingModificationsForCompositionLocked();
                IdentityArrayMap takeInvalidations = takeInvalidations();
                try {
                    recompose$runtime_release = this.composer.recompose$runtime_release(takeInvalidations);
                    if (!recompose$runtime_release) {
                        drainPendingModificationsLocked();
                    }
                } catch (Exception e) {
                    this.invalidations = takeInvalidations;
                    throw e;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return recompose$runtime_release;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(Object value) {
        int find;
        IdentityArraySet scopeSetAt;
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            try {
                invalidateScopeOfLocked(value);
                IdentityScopeMap identityScopeMap = this.derivedStates;
                find = identityScopeMap.find(value);
                if (find >= 0) {
                    scopeSetAt = identityScopeMap.scopeSetAt(find);
                    Object[] values = scopeSetAt.getValues();
                    int size = scopeSetAt.size();
                    for (int i = 0; i < size; i++) {
                        Object obj = values[i];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                        invalidateScopeOfLocked((DerivedState) obj);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final HashSet addPendingInvalidationsLocked(HashSet hashSet, Object obj, boolean z) {
        int find;
        IdentityArraySet scopeSetAt;
        IdentityScopeMap identityScopeMap = this.observations;
        find = identityScopeMap.find(obj);
        if (find >= 0) {
            scopeSetAt = identityScopeMap.scopeSetAt(find);
            Object[] values = scopeSetAt.getValues();
            int size = scopeSetAt.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = values[i];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
                if (!this.observationsProcessed.remove(obj, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                    if (recomposeScopeImpl.isConditional() && !z) {
                        this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                    } else {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.add(recomposeScopeImpl);
                    }
                }
            }
        }
        return hashSet;
    }

    private final void invalidateScopeOfLocked(Object obj) {
        int find;
        IdentityArraySet scopeSetAt;
        IdentityScopeMap identityScopeMap = this.observations;
        find = identityScopeMap.find(obj);
        if (find >= 0) {
            scopeSetAt = identityScopeMap.scopeSetAt(find);
            Object[] values = scopeSetAt.getValues();
            int size = scopeSetAt.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = values[i];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
                if (recomposeScopeImpl.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                    this.observationsProcessed.add(obj, recomposeScopeImpl);
                }
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        IdentityScopeMap identityScopeMap = this.derivedStates;
        int[] valueOrder = identityScopeMap.getValueOrder();
        IdentityArraySet[] scopeSets = identityScopeMap.getScopeSets();
        Object[] values = identityScopeMap.getValues();
        int size = identityScopeMap.getSize();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = valueOrder[i];
            IdentityArraySet identityArraySet = scopeSets[i3];
            Intrinsics.checkNotNull(identityArraySet);
            Object[] values2 = identityArraySet.getValues();
            int size2 = identityArraySet.size();
            int i4 = 0;
            int i5 = 0;
            while (i4 < size2) {
                Object obj = values2[i4];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                IdentityArraySet[] identityArraySetArr = scopeSets;
                if (!(!this.observations.contains((DerivedState) obj))) {
                    if (i5 != i4) {
                        values2[i5] = obj;
                    }
                    i5++;
                }
                i4++;
                scopeSets = identityArraySetArr;
            }
            IdentityArraySet[] identityArraySetArr2 = scopeSets;
            for (int i6 = i5; i6 < size2; i6++) {
                values2[i6] = null;
            }
            identityArraySet.size = i5;
            if (identityArraySet.size() > 0) {
                if (i2 != i) {
                    int i7 = valueOrder[i2];
                    valueOrder[i2] = i3;
                    valueOrder[i] = i7;
                }
                i2++;
            }
            i++;
            scopeSets = identityArraySetArr2;
        }
        int size3 = identityScopeMap.getSize();
        for (int i8 = i2; i8 < size3; i8++) {
            values[valueOrder[i8]] = null;
        }
        identityScopeMap.setSize(i2);
        if (!this.conditionallyInvalidatedScopes.isEmpty()) {
            Iterator it = this.conditionallyInvalidatedScopes.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator()");
            while (it.hasNext()) {
                if (!((RecomposeScopeImpl) it.next()).isConditional()) {
                    it.remove();
                }
            }
        }
    }

    public CompositionImpl(CompositionContext parent, Applier applier, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(applier, "applier");
        this.parent = parent;
        this.applier = applier;
        this.pendingModifications = new AtomicReference(null);
        this.lock = new Object();
        HashSet hashSet = new HashSet();
        this.abandonSet = hashSet;
        SlotTable slotTable = new SlotTable();
        this.slotTable = slotTable;
        this.observations = new IdentityScopeMap();
        this.conditionallyInvalidatedScopes = new HashSet();
        this.derivedStates = new IdentityScopeMap();
        ArrayList arrayList = new ArrayList();
        this.changes = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.lateChanges = arrayList2;
        this.observationsProcessed = new IdentityScopeMap();
        this.invalidations = new IdentityArrayMap(0, 1, null);
        ComposerImpl composerImpl = new ComposerImpl(applier, parent, slotTable, hashSet, arrayList, arrayList2, this);
        parent.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = parent instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m600getLambda1$runtime_release();
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i & 4) != 0 ? null : coroutineContext);
    }

    private final void addPendingInvalidationsLocked(Set set, boolean z) {
        HashSet hashSet;
        int find;
        IdentityArraySet scopeSetAt;
        int i;
        boolean z2;
        int find2;
        IdentityArraySet scopeSetAt2;
        if (set instanceof IdentityArraySet) {
            IdentityArraySet identityArraySet = (IdentityArraySet) set;
            Object[] values = identityArraySet.getValues();
            int size = identityArraySet.size();
            hashSet = null;
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = values[i2];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                if (obj instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj).invalidateForResult(null);
                } else {
                    hashSet = addPendingInvalidationsLocked(hashSet, obj, z);
                    IdentityScopeMap identityScopeMap = this.derivedStates;
                    find2 = identityScopeMap.find(obj);
                    if (find2 >= 0) {
                        scopeSetAt2 = identityScopeMap.scopeSetAt(find2);
                        Object[] values2 = scopeSetAt2.getValues();
                        int size2 = scopeSetAt2.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            Object obj2 = values2[i3];
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            hashSet = addPendingInvalidationsLocked(hashSet, (DerivedState) obj2, z);
                        }
                    }
                }
            }
        } else {
            hashSet = null;
            for (Object obj3 : set) {
                if (obj3 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj3).invalidateForResult(null);
                } else {
                    HashSet addPendingInvalidationsLocked = addPendingInvalidationsLocked(hashSet, obj3, z);
                    IdentityScopeMap identityScopeMap2 = this.derivedStates;
                    find = identityScopeMap2.find(obj3);
                    if (find >= 0) {
                        scopeSetAt = identityScopeMap2.scopeSetAt(find);
                        Object[] values3 = scopeSetAt.getValues();
                        int size3 = scopeSetAt.size();
                        for (int i4 = 0; i4 < size3; i4++) {
                            Object obj4 = values3[i4];
                            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            addPendingInvalidationsLocked = addPendingInvalidationsLocked(addPendingInvalidationsLocked, (DerivedState) obj4, z);
                        }
                    }
                    hashSet = addPendingInvalidationsLocked;
                }
            }
        }
        if (z) {
            boolean z3 = true;
            if (!this.conditionallyInvalidatedScopes.isEmpty()) {
                IdentityScopeMap identityScopeMap3 = this.observations;
                int[] valueOrder = identityScopeMap3.getValueOrder();
                IdentityArraySet[] scopeSets = identityScopeMap3.getScopeSets();
                Object[] values4 = identityScopeMap3.getValues();
                int size4 = identityScopeMap3.getSize();
                int i5 = 0;
                int i6 = 0;
                while (i5 < size4) {
                    int i7 = valueOrder[i5];
                    IdentityArraySet identityArraySet2 = scopeSets[i7];
                    Intrinsics.checkNotNull(identityArraySet2);
                    Object[] values5 = identityArraySet2.getValues();
                    int size5 = identityArraySet2.size();
                    int i8 = 0;
                    int i9 = 0;
                    while (i8 < size5) {
                        Object obj5 = values5[i8];
                        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                        IdentityArraySet[] identityArraySetArr = scopeSets;
                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj5;
                        int i10 = size4;
                        if (this.conditionallyInvalidatedScopes.contains(recomposeScopeImpl)) {
                            i = i9;
                            z2 = true;
                        } else {
                            if (hashSet != null) {
                                z2 = true;
                                if (hashSet.contains(recomposeScopeImpl)) {
                                    i = i9;
                                }
                            } else {
                                z2 = true;
                            }
                            int i11 = i9;
                            if (i11 != i8) {
                                values5[i11] = obj5;
                            }
                            i9 = i11 + 1;
                            i8++;
                            scopeSets = identityArraySetArr;
                            z3 = z2;
                            size4 = i10;
                        }
                        i9 = i;
                        i8++;
                        scopeSets = identityArraySetArr;
                        z3 = z2;
                        size4 = i10;
                    }
                    IdentityArraySet[] identityArraySetArr2 = scopeSets;
                    int i12 = size4;
                    int i13 = i9;
                    boolean z4 = z3;
                    for (int i14 = i13; i14 < size5; i14++) {
                        values5[i14] = null;
                    }
                    identityArraySet2.size = i13;
                    if (identityArraySet2.size() > 0) {
                        if (i6 != i5) {
                            int i15 = valueOrder[i6];
                            valueOrder[i6] = i7;
                            valueOrder[i5] = i15;
                        }
                        i6++;
                    }
                    i5++;
                    scopeSets = identityArraySetArr2;
                    z3 = z4;
                    size4 = i12;
                }
                int size6 = identityScopeMap3.getSize();
                for (int i16 = i6; i16 < size6; i16++) {
                    values4[valueOrder[i16]] = null;
                }
                identityScopeMap3.setSize(i6);
                this.conditionallyInvalidatedScopes.clear();
                cleanUpDerivedStateObservations();
                return;
            }
        }
        if (hashSet != null) {
            IdentityScopeMap identityScopeMap4 = this.observations;
            int[] valueOrder2 = identityScopeMap4.getValueOrder();
            IdentityArraySet[] scopeSets2 = identityScopeMap4.getScopeSets();
            Object[] values6 = identityScopeMap4.getValues();
            int size7 = identityScopeMap4.getSize();
            int i17 = 0;
            int i18 = 0;
            while (i17 < size7) {
                int i19 = valueOrder2[i17];
                IdentityArraySet identityArraySet3 = scopeSets2[i19];
                Intrinsics.checkNotNull(identityArraySet3);
                Object[] values7 = identityArraySet3.getValues();
                int size8 = identityArraySet3.size();
                int i20 = 0;
                int i21 = 0;
                while (i20 < size8) {
                    Object obj6 = values7[i20];
                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    IdentityArraySet[] identityArraySetArr3 = scopeSets2;
                    if (!hashSet.contains((RecomposeScopeImpl) obj6)) {
                        if (i21 != i20) {
                            values7[i21] = obj6;
                        }
                        i21++;
                    }
                    i20++;
                    scopeSets2 = identityArraySetArr3;
                }
                IdentityArraySet[] identityArraySetArr4 = scopeSets2;
                for (int i22 = i21; i22 < size8; i22++) {
                    values7[i22] = null;
                }
                identityArraySet3.size = i21;
                if (identityArraySet3.size() > 0) {
                    if (i18 != i17) {
                        int i23 = valueOrder2[i18];
                        valueOrder2[i18] = i19;
                        valueOrder2[i17] = i23;
                    }
                    i18++;
                }
                i17++;
                scopeSets2 = identityArraySetArr4;
            }
            int size9 = identityScopeMap4.getSize();
            for (int i24 = i18; i24 < size9; i24++) {
                values6[valueOrder2[i24]] = null;
            }
            identityScopeMap4.setSize(i18);
            cleanUpDerivedStateObservations();
        }
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.isComposing$runtime_release();
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2 content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (!(!this.disposed)) {
            throw new IllegalStateException("The composition is disposed".toString());
        }
        this.composable = content;
        this.parent.composeInitial$runtime_release(this, content);
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object obj;
        Object obj2;
        AtomicReference atomicReference = this.pendingModifications;
        obj = CompositionKt.PendingApplyNoModifications;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            obj2 = CompositionKt.PendingApplyNoModifications;
            if (Intrinsics.areEqual(andSet, obj2)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            } else if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set) andSet, true);
            } else if (!(andSet instanceof Object[])) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            } else {
                for (Set set : (Set[]) andSet) {
                    addPendingInvalidationsLocked(set, true);
                }
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object obj;
        Object andSet = this.pendingModifications.getAndSet(null);
        obj = CompositionKt.PendingApplyNoModifications;
        if (Intrinsics.areEqual(andSet, obj)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
        } else if (!(andSet instanceof Object[])) {
            if (andSet == null) {
                ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
                throw new KotlinNothingValueException();
            } else {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
        } else {
            for (Set set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.Set[]] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set values) {
        Object obj;
        Set set;
        Object obj2;
        ?? plus;
        Intrinsics.checkNotNullParameter(values, "values");
        do {
            obj = this.pendingModifications.get();
            if (obj != null) {
                obj2 = CompositionKt.PendingApplyNoModifications;
                if (!Intrinsics.areEqual(obj, obj2)) {
                    if (obj instanceof Set) {
                        set = new Set[]{obj, values};
                    } else if (!(obj instanceof Object[])) {
                        throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                    } else {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                        plus = ArraysKt___ArraysJvmKt.plus((Set[]) obj, values);
                        set = plus;
                    }
                }
            }
            set = values;
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingModifications, obj, set));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000f  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean observesAnyOf(java.util.Set r3) {
        /*
            r2 = this;
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Iterator r3 = r3.iterator()
        L9:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L25
            java.lang.Object r0 = r3.next()
            androidx.compose.runtime.collection.IdentityScopeMap r1 = r2.observations
            boolean r1 = r1.contains(r0)
            if (r1 != 0) goto L23
            androidx.compose.runtime.collection.IdentityScopeMap r1 = r2.derivedStates
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L9
        L23:
            r3 = 1
            return r3
        L25:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.composer.prepareCompose$runtime_release(block);
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        Object[] dependencies;
        Intrinsics.checkNotNullParameter(value, "value");
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) == null) {
            return;
        }
        currentRecomposeScope$runtime_release.setUsed(true);
        if (currentRecomposeScope$runtime_release.recordRead(value)) {
            return;
        }
        this.observations.add(value, currentRecomposeScope$runtime_release);
        if (value instanceof DerivedState) {
            this.derivedStates.removeScope(value);
            for (Object obj : ((DerivedState) value).getCurrentRecord().getDependencies()) {
                if (obj == null) {
                    return;
                }
                this.derivedStates.add(obj, value);
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter openWriter = state.getSlotTable$runtime_release().openWriter();
        try {
            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
            Unit unit = Unit.INSTANCE;
            openWriter.close();
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th) {
            openWriter.close();
            throw th;
        }
    }

    private final void applyChangesInLocked(List list) {
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        try {
            if (!list.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:applyChanges");
                this.applier.onBeginChanges();
                SlotWriter openWriter = this.slotTable.openWriter();
                try {
                    Applier applier = this.applier;
                    int size = list.size();
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        ((Function3) list.get(i2)).invoke(applier, openWriter, rememberEventDispatcher);
                    }
                    list.clear();
                    Unit unit = Unit.INSTANCE;
                    openWriter.close();
                    this.applier.onEndChanges();
                    Trace trace = Trace.INSTANCE;
                    trace.endSection(beginSection);
                    rememberEventDispatcher.dispatchRememberObservers();
                    rememberEventDispatcher.dispatchSideEffects();
                    if (this.pendingInvalidScopes) {
                        Object beginSection2 = trace.beginSection("Compose:unobserve");
                        this.pendingInvalidScopes = false;
                        IdentityScopeMap identityScopeMap = this.observations;
                        int[] valueOrder = identityScopeMap.getValueOrder();
                        IdentityArraySet[] scopeSets = identityScopeMap.getScopeSets();
                        Object[] values = identityScopeMap.getValues();
                        int size2 = identityScopeMap.getSize();
                        int i3 = 0;
                        int i4 = 0;
                        while (i3 < size2) {
                            int i5 = valueOrder[i3];
                            IdentityArraySet identityArraySet = scopeSets[i5];
                            Intrinsics.checkNotNull(identityArraySet);
                            Object[] values2 = identityArraySet.getValues();
                            int size3 = identityArraySet.size();
                            int i6 = i;
                            while (i < size3) {
                                IdentityArraySet[] identityArraySetArr = scopeSets;
                                Object obj = values2[i];
                                int i7 = size2;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                if (!(!((RecomposeScopeImpl) obj).getValid())) {
                                    if (i6 != i) {
                                        values2[i6] = obj;
                                    }
                                    i6++;
                                }
                                i++;
                                scopeSets = identityArraySetArr;
                                size2 = i7;
                            }
                            IdentityArraySet[] identityArraySetArr2 = scopeSets;
                            int i8 = size2;
                            for (int i9 = i6; i9 < size3; i9++) {
                                values2[i9] = null;
                            }
                            identityArraySet.size = i6;
                            if (identityArraySet.size() > 0) {
                                if (i4 != i3) {
                                    int i10 = valueOrder[i4];
                                    valueOrder[i4] = i5;
                                    valueOrder[i3] = i10;
                                }
                                i4++;
                            }
                            i3++;
                            scopeSets = identityArraySetArr2;
                            size2 = i8;
                            i = 0;
                        }
                        int size4 = identityScopeMap.getSize();
                        for (int i11 = i4; i11 < size4; i11++) {
                            values[valueOrder[i11]] = null;
                        }
                        identityScopeMap.setSize(i4);
                        cleanUpDerivedStateObservations();
                        Unit unit2 = Unit.INSTANCE;
                        Trace.INSTANCE.endSection(beginSection2);
                    }
                    if (this.lateChanges.isEmpty()) {
                        rememberEventDispatcher.dispatchAbandons();
                    }
                } finally {
                    openWriter.close();
                }
            } else if (this.lateChanges.isEmpty()) {
                rememberEventDispatcher.dispatchAbandons();
            }
        } finally {
            if (this.lateChanges.isEmpty()) {
                rememberEventDispatcher.dispatchAbandons();
            }
        }
    }

    private final void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        this.abandonSet.clear();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public Object delegateInvalidations(ControlledComposition controlledComposition, int i, Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (controlledComposition != null && !Intrinsics.areEqual(controlledComposition, this) && i >= 0) {
            this.invalidationDelegate = (CompositionImpl) controlledComposition;
            this.invalidationDelegateGroup = i;
            try {
                return block.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return block.invoke();
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object obj) {
        CompositionImpl compositionImpl;
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!this.slotTable.ownsAnchor(anchor)) {
            synchronized (this.lock) {
                compositionImpl = this.invalidationDelegate;
            }
            if (compositionImpl != null && compositionImpl.tryImminentInvalidation(scope, obj)) {
                return InvalidationResult.IMMINENT;
            }
            return InvalidationResult.IGNORED;
        } else if (!scope.getCanRecompose()) {
            return InvalidationResult.IGNORED;
        } else {
            return invalidateChecked(scope, anchor, obj);
        }
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime_release(recomposeScopeImpl, obj);
    }

    public final void removeObservation$runtime_release(Object instance, RecomposeScopeImpl scope) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.observations.remove(instance, scope);
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.observations.contains(state)) {
            return;
        }
        this.derivedStates.removeScope(state);
    }

    private final IdentityArrayMap takeInvalidations() {
        IdentityArrayMap identityArrayMap = this.invalidations;
        this.invalidations = new IdentityArrayMap(0, 1, null);
        return identityArrayMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Composition.kt */
    /* loaded from: classes.dex */
    public static final class RememberEventDispatcher implements RememberManager {
        private final Set abandoning;
        private List deactivating;
        private final List forgetting;
        private List releasing;
        private final List remembering;
        private final List sideEffects;

        public RememberEventDispatcher(Set abandoning) {
            Intrinsics.checkNotNullParameter(abandoning, "abandoning");
            this.abandoning = abandoning;
            this.remembering = new ArrayList();
            this.forgetting = new ArrayList();
            this.sideEffects = new ArrayList();
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            int lastIndexOf = this.forgetting.lastIndexOf(instance);
            if (lastIndexOf >= 0) {
                this.forgetting.remove(lastIndexOf);
                this.abandoning.remove(instance);
                return;
            }
            this.remembering.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            int lastIndexOf = this.remembering.lastIndexOf(instance);
            if (lastIndexOf >= 0) {
                this.remembering.remove(lastIndexOf);
                this.abandoning.remove(instance);
                return;
            }
            this.forgetting.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void sideEffect(Function0 effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            this.sideEffects.add(effect);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void deactivating(ComposeNodeLifecycleCallback instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            List list = this.deactivating;
            if (list == null) {
                list = new ArrayList();
                this.deactivating = list;
            }
            list.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void releasing(ComposeNodeLifecycleCallback instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            List list = this.releasing;
            if (list == null) {
                list = new ArrayList();
                this.releasing = list;
            }
            list.add(instance);
        }

        public final void dispatchRememberObservers() {
            Object beginSection;
            List list = this.deactivating;
            if (list != null && !list.isEmpty()) {
                beginSection = Trace.INSTANCE.beginSection("Compose:deactivations");
                try {
                    for (int size = list.size() - 1; -1 < size; size--) {
                        ((ComposeNodeLifecycleCallback) list.get(size)).onDeactivate();
                    }
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection);
                    list.clear();
                } finally {
                }
            }
            if (!this.forgetting.isEmpty()) {
                beginSection = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    for (int size2 = this.forgetting.size() - 1; -1 < size2; size2--) {
                        RememberObserver rememberObserver = (RememberObserver) this.forgetting.get(size2);
                        if (!this.abandoning.contains(rememberObserver)) {
                            rememberObserver.onForgotten();
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection);
                } finally {
                }
            }
            if (!this.remembering.isEmpty()) {
                Object beginSection2 = Trace.INSTANCE.beginSection("Compose:onRemembered");
                try {
                    List list2 = this.remembering;
                    int size3 = list2.size();
                    for (int i = 0; i < size3; i++) {
                        RememberObserver rememberObserver2 = (RememberObserver) list2.get(i);
                        this.abandoning.remove(rememberObserver2);
                        rememberObserver2.onRemembered();
                    }
                    Unit unit3 = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection2);
                } finally {
                    Trace.INSTANCE.endSection(beginSection2);
                }
            }
            List list3 = this.releasing;
            if (list3 == null || list3.isEmpty()) {
                return;
            }
            beginSection = Trace.INSTANCE.beginSection("Compose:releases");
            try {
                for (int size4 = list3.size() - 1; -1 < size4; size4--) {
                    ((ComposeNodeLifecycleCallback) list3.get(size4)).onRelease();
                }
                Unit unit4 = Unit.INSTANCE;
                Trace.INSTANCE.endSection(beginSection);
                list3.clear();
            } finally {
                Trace.INSTANCE.endSection(beginSection);
            }
        }

        public final void dispatchSideEffects() {
            if (!this.sideEffects.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
                try {
                    List list = this.sideEffects;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        ((Function0) list.get(i)).invoke();
                    }
                    this.sideEffects.clear();
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection);
                } catch (Throwable th) {
                    Trace.INSTANCE.endSection(beginSection);
                    throw th;
                }
            }
        }

        public final void dispatchAbandons() {
            if (!this.abandoning.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:abandons");
                try {
                    Iterator it = this.abandoning.iterator();
                    while (it.hasNext()) {
                        it.remove();
                        ((RememberObserver) it.next()).onAbandoned();
                    }
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection);
                } catch (Throwable th) {
                    Trace.INSTANCE.endSection(beginSection);
                    throw th;
                }
            }
        }
    }
}
