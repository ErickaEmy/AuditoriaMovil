package androidx.compose.material;
/* compiled from: Scaffold.kt */
/* loaded from: classes.dex */
public final class FabPlacement {
    private final int height;
    private final boolean isDocked;
    private final int left;
    private final int width;

    public final int getHeight() {
        return this.height;
    }

    public final int getLeft() {
        return this.left;
    }

    public FabPlacement(boolean z, int i, int i2, int i3) {
        this.isDocked = z;
        this.left = i;
        this.width = i2;
        this.height = i3;
    }
}
