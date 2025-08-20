package androidx.compose.runtime;
/* compiled from: SnapshotMutationPolicy.kt */
/* loaded from: classes.dex */
public interface SnapshotMutationPolicy {

    /* compiled from: SnapshotMutationPolicy.kt */
    /* renamed from: androidx.compose.runtime.SnapshotMutationPolicy$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static Object $default$merge(SnapshotMutationPolicy snapshotMutationPolicy, Object obj, Object obj2, Object obj3) {
            return null;
        }
    }

    boolean equivalent(Object obj, Object obj2);

    Object merge(Object obj, Object obj2, Object obj3);
}
