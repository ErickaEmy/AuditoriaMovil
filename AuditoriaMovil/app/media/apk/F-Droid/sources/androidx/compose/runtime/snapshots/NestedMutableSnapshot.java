package androidx.compose.runtime.snapshots;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public final class NestedMutableSnapshot extends MutableSnapshot {
    private boolean deactivated;
    private final MutableSnapshot parent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedMutableSnapshot(int i, SnapshotIdSet invalid, Function1 function1, Function1 function12, MutableSnapshot parent) {
        super(i, invalid, function1, function12);
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.parent = parent;
        parent.mo627nestedActivated$runtime_release(this);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release()) {
            return;
        }
        super.dispose();
        deactivate();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0076 A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:13:0x002e, B:15:0x0033, B:18:0x003a, B:22:0x0054, B:24:0x005c, B:29:0x006e, B:31:0x0076, B:32:0x007b, B:27:0x0062, B:28:0x006b), top: B:40:0x002e }] */
    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            r7 = this;
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent
            boolean r0 = r0.getApplied$runtime_release()
            if (r0 != 0) goto Lbf
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent
            boolean r0 = r0.getDisposed$runtime_release()
            if (r0 == 0) goto L12
            goto Lbf
        L12:
            androidx.compose.runtime.collection.IdentityArraySet r0 = r7.getModified$runtime_release()
            int r1 = r7.getId()
            r2 = 0
            if (r0 == 0) goto L28
            androidx.compose.runtime.snapshots.MutableSnapshot r3 = r7.parent
            androidx.compose.runtime.snapshots.SnapshotIdSet r4 = r3.getInvalid$runtime_release()
            java.util.Map r3 = androidx.compose.runtime.snapshots.SnapshotKt.access$optimisticMerges(r3, r7, r4)
            goto L29
        L28:
            r3 = r2
        L29:
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r4)
            androidx.compose.runtime.snapshots.SnapshotKt.access$validateOpen(r7)     // Catch: java.lang.Throwable -> L60
            if (r0 == 0) goto L6b
            int r5 = r0.size()     // Catch: java.lang.Throwable -> L60
            if (r5 != 0) goto L3a
            goto L6b
        L3a:
            androidx.compose.runtime.snapshots.MutableSnapshot r5 = r7.parent     // Catch: java.lang.Throwable -> L60
            int r5 = r5.getId()     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.MutableSnapshot r6 = r7.parent     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r6.getInvalid$runtime_release()     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.SnapshotApplyResult r3 = r7.innerApplyLocked$runtime_release(r5, r3, r6)     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r5 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE     // Catch: java.lang.Throwable -> L60
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r5)     // Catch: java.lang.Throwable -> L60
            if (r5 != 0) goto L54
            monitor-exit(r4)
            return r3
        L54:
            androidx.compose.runtime.snapshots.MutableSnapshot r3 = r7.parent     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.collection.IdentityArraySet r3 = r3.getModified$runtime_release()     // Catch: java.lang.Throwable -> L60
            if (r3 == 0) goto L62
            r3.addAll(r0)     // Catch: java.lang.Throwable -> L60
            goto L6e
        L60:
            r0 = move-exception
            goto Lbd
        L62:
            androidx.compose.runtime.snapshots.MutableSnapshot r3 = r7.parent     // Catch: java.lang.Throwable -> L60
            r3.setModified(r0)     // Catch: java.lang.Throwable -> L60
            r7.setModified(r2)     // Catch: java.lang.Throwable -> L60
            goto L6e
        L6b:
            r7.closeAndReleasePinning$runtime_release()     // Catch: java.lang.Throwable -> L60
        L6e:
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch: java.lang.Throwable -> L60
            int r0 = r0.getId()     // Catch: java.lang.Throwable -> L60
            if (r0 >= r1) goto L7b
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch: java.lang.Throwable -> L60
            r0.advance$runtime_release()     // Catch: java.lang.Throwable -> L60
        L7b:
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r0.getInvalid$runtime_release()     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.clear(r1)     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r7.getPreviousIds$runtime_release()     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.andNot(r3)     // Catch: java.lang.Throwable -> L60
            r0.setInvalid$runtime_release(r2)     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch: java.lang.Throwable -> L60
            r0.recordPrevious$runtime_release(r1)     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch: java.lang.Throwable -> L60
            int r1 = r7.takeoverPinnedSnapshot$runtime_release()     // Catch: java.lang.Throwable -> L60
            r0.recordPreviousPinnedSnapshot$runtime_release(r1)     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.SnapshotIdSet r1 = r7.getPreviousIds$runtime_release()     // Catch: java.lang.Throwable -> L60
            r0.recordPreviousList$runtime_release(r1)     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch: java.lang.Throwable -> L60
            int[] r1 = r7.getPreviousPinnedSnapshots$runtime_release()     // Catch: java.lang.Throwable -> L60
            r0.recordPreviousPinnedSnapshots$runtime_release(r1)     // Catch: java.lang.Throwable -> L60
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L60
            monitor-exit(r4)
            r0 = 1
            r7.setApplied$runtime_release(r0)
            r7.deactivate()
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r0 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE
            return r0
        Lbd:
            monitor-exit(r4)
            throw r0
        Lbf:
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure r0 = new androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure
            r0.<init>(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.NestedMutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    private final void deactivate() {
        if (this.deactivated) {
            return;
        }
        this.deactivated = true;
        this.parent.mo628nestedDeactivated$runtime_release(this);
    }
}
