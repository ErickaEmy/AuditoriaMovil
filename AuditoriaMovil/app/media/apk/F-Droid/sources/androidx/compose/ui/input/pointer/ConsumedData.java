package androidx.compose.ui.input.pointer;
/* compiled from: PointerEvent.kt */
/* loaded from: classes.dex */
public final class ConsumedData {
    private boolean downChange;
    private boolean positionChange;

    public final boolean getDownChange() {
        return this.downChange;
    }

    public final boolean getPositionChange() {
        return this.positionChange;
    }

    public final void setDownChange(boolean z) {
        this.downChange = z;
    }

    public final void setPositionChange(boolean z) {
        this.positionChange = z;
    }

    public ConsumedData(boolean z, boolean z2) {
        this.positionChange = z;
        this.downChange = z2;
    }
}
