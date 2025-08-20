package androidx.compose.runtime;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
public final class SlotWriter$groupSlots$1 implements Iterator, KMappedMarker {
    final /* synthetic */ int $end;
    private int current;
    final /* synthetic */ SlotWriter this$0;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.current < this.$end;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SlotWriter$groupSlots$1(int i, int i2, SlotWriter slotWriter) {
        this.$end = i2;
        this.this$0 = slotWriter;
        this.current = i;
    }

    @Override // java.util.Iterator
    public Object next() {
        int dataIndexToDataAddress;
        if (hasNext()) {
            Object[] objArr = this.this$0.slots;
            SlotWriter slotWriter = this.this$0;
            int i = this.current;
            this.current = i + 1;
            dataIndexToDataAddress = slotWriter.dataIndexToDataAddress(i);
            return objArr[dataIndexToDataAddress];
        }
        return null;
    }
}
