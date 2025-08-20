package androidx.compose.ui.layout;
/* compiled from: PinnableContainer.kt */
/* loaded from: classes.dex */
public interface PinnableContainer {

    /* compiled from: PinnableContainer.kt */
    /* loaded from: classes.dex */
    public interface PinnedHandle {
        void release();
    }

    PinnedHandle pin();
}
