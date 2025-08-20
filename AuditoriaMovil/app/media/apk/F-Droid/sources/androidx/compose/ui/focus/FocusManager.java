package androidx.compose.ui.focus;
/* compiled from: FocusManager.kt */
/* loaded from: classes.dex */
public interface FocusManager {
    void clearFocus(boolean z);

    /* renamed from: moveFocus-3ESFkO8  reason: not valid java name */
    boolean mo663moveFocus3ESFkO8(int i);

    /* compiled from: FocusManager.kt */
    /* renamed from: androidx.compose.ui.focus.FocusManager$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static /* synthetic */ void clearFocus$default(FocusManager focusManager, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearFocus");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            focusManager.clearFocus(z);
        }
    }
}
