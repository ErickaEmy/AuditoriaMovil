package androidx.compose.runtime;
/* compiled from: SnapshotIntState.kt */
/* loaded from: classes.dex */
public interface MutableIntState extends IntState, MutableState {
    @Override // androidx.compose.runtime.IntState
    int getIntValue();

    @Override // androidx.compose.runtime.State
    Integer getValue();

    void setIntValue(int i);

    void setValue(int i);

    /* compiled from: SnapshotIntState.kt */
    /* renamed from: androidx.compose.runtime.MutableIntState$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
    }
}
