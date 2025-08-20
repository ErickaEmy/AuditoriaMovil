package androidx.compose.material;
/* compiled from: AnchoredDraggable.kt */
/* loaded from: classes.dex */
public interface AnchoredDragScope {
    void dragTo(float f, float f2);

    /* compiled from: AnchoredDraggable.kt */
    /* renamed from: androidx.compose.material.AnchoredDragScope$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static /* synthetic */ void dragTo$default(AnchoredDragScope anchoredDragScope, float f, float f2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dragTo");
            }
            if ((i & 2) != 0) {
                f2 = 0.0f;
            }
            anchoredDragScope.dragTo(f, f2);
        }
    }
}
