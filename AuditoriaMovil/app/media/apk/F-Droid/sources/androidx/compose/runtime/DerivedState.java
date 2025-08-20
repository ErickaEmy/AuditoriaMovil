package androidx.compose.runtime;
/* compiled from: DerivedState.kt */
/* loaded from: classes.dex */
public interface DerivedState extends State {

    /* compiled from: DerivedState.kt */
    /* loaded from: classes.dex */
    public interface Record {
        Object getCurrentValue();

        Object[] getDependencies();
    }

    Record getCurrentRecord();

    SnapshotMutationPolicy getPolicy();
}
