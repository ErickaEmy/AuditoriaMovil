package androidx.compose.runtime.snapshots;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Snapshot.kt */
/* loaded from: classes.dex */
public abstract class SnapshotApplyResult {
    private SnapshotApplyResult() {
    }

    public /* synthetic */ SnapshotApplyResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: Snapshot.kt */
    /* loaded from: classes.dex */
    public static final class Success extends SnapshotApplyResult {
        public static final Success INSTANCE = new Success();

        private Success() {
            super(null);
        }
    }

    /* compiled from: Snapshot.kt */
    /* loaded from: classes.dex */
    public static final class Failure extends SnapshotApplyResult {
        private final Snapshot snapshot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(Snapshot snapshot) {
            super(null);
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            this.snapshot = snapshot;
        }
    }
}
