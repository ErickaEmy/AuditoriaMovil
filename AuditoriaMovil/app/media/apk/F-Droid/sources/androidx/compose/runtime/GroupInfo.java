package androidx.compose.runtime;
/* compiled from: Composer.kt */
/* loaded from: classes.dex */
final class GroupInfo {
    private int nodeCount;
    private int nodeIndex;
    private int slotIndex;

    public final int getNodeCount() {
        return this.nodeCount;
    }

    public final int getNodeIndex() {
        return this.nodeIndex;
    }

    public final int getSlotIndex() {
        return this.slotIndex;
    }

    public final void setNodeCount(int i) {
        this.nodeCount = i;
    }

    public final void setNodeIndex(int i) {
        this.nodeIndex = i;
    }

    public final void setSlotIndex(int i) {
        this.slotIndex = i;
    }

    public GroupInfo(int i, int i2, int i3) {
        this.slotIndex = i;
        this.nodeIndex = i2;
        this.nodeCount = i3;
    }
}
