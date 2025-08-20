package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
public final class Anchor {
    private int location;

    public final int getLocation$runtime_release() {
        return this.location;
    }

    public final boolean getValid() {
        return this.location != Integer.MIN_VALUE;
    }

    public final void setLocation$runtime_release(int i) {
        this.location = i;
    }

    public Anchor(int i) {
        this.location = i;
    }

    public final int toIndexFor(SlotTable slots) {
        Intrinsics.checkNotNullParameter(slots, "slots");
        return slots.anchorIndex(this);
    }

    public final int toIndexFor(SlotWriter writer) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        return writer.anchorIndex(this);
    }
}
