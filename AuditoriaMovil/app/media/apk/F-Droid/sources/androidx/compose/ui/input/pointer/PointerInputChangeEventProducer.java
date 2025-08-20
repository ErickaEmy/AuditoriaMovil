package androidx.compose.ui.input.pointer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PointerInputEventProcessor.kt */
/* loaded from: classes.dex */
final class PointerInputChangeEventProducer {
    private final Map previousPointerInputData = new LinkedHashMap();

    public final InternalPointerEvent produce(PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator) {
        long j;
        boolean down;
        long mo1224screenToLocalMKHz9U;
        Intrinsics.checkNotNullParameter(pointerInputEvent, "pointerInputEvent");
        Intrinsics.checkNotNullParameter(positionCalculator, "positionCalculator");
        LinkedHashMap linkedHashMap = new LinkedHashMap(pointerInputEvent.getPointers().size());
        List pointers = pointerInputEvent.getPointers();
        int size = pointers.size();
        for (int i = 0; i < size; i++) {
            PointerInputEventData pointerInputEventData = (PointerInputEventData) pointers.get(i);
            PointerInputData pointerInputData = (PointerInputData) this.previousPointerInputData.get(PointerId.m1185boximpl(pointerInputEventData.m1201getIdJ3iCeTQ()));
            if (pointerInputData == null) {
                j = pointerInputEventData.getUptime();
                mo1224screenToLocalMKHz9U = pointerInputEventData.m1202getPositionF1C5BW0();
                down = false;
            } else {
                long uptime = pointerInputData.getUptime();
                j = uptime;
                down = pointerInputData.getDown();
                mo1224screenToLocalMKHz9U = positionCalculator.mo1224screenToLocalMKHz9U(pointerInputData.m1200getPositionOnScreenF1C5BW0());
            }
            linkedHashMap.put(PointerId.m1185boximpl(pointerInputEventData.m1201getIdJ3iCeTQ()), new PointerInputChange(pointerInputEventData.m1201getIdJ3iCeTQ(), pointerInputEventData.getUptime(), pointerInputEventData.m1202getPositionF1C5BW0(), pointerInputEventData.getDown(), pointerInputEventData.getPressure(), j, mo1224screenToLocalMKHz9U, down, false, pointerInputEventData.m1205getTypeT8wyACA(), pointerInputEventData.getHistorical(), pointerInputEventData.m1204getScrollDeltaF1C5BW0(), (DefaultConstructorMarker) null));
            if (pointerInputEventData.getDown()) {
                this.previousPointerInputData.put(PointerId.m1185boximpl(pointerInputEventData.m1201getIdJ3iCeTQ()), new PointerInputData(pointerInputEventData.getUptime(), pointerInputEventData.m1203getPositionOnScreenF1C5BW0(), pointerInputEventData.getDown(), pointerInputEventData.m1205getTypeT8wyACA(), null));
            } else {
                this.previousPointerInputData.remove(PointerId.m1185boximpl(pointerInputEventData.m1201getIdJ3iCeTQ()));
            }
        }
        return new InternalPointerEvent(linkedHashMap, pointerInputEvent);
    }

    public final void clear() {
        this.previousPointerInputData.clear();
    }

    /* compiled from: PointerInputEventProcessor.kt */
    /* loaded from: classes.dex */
    private static final class PointerInputData {
        private final boolean down;
        private final long positionOnScreen;
        private final int type;
        private final long uptime;

        public /* synthetic */ PointerInputData(long j, long j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, z, i);
        }

        public final boolean getDown() {
            return this.down;
        }

        /* renamed from: getPositionOnScreen-F1C5BW0  reason: not valid java name */
        public final long m1200getPositionOnScreenF1C5BW0() {
            return this.positionOnScreen;
        }

        public final long getUptime() {
            return this.uptime;
        }

        private PointerInputData(long j, long j2, boolean z, int i) {
            this.uptime = j;
            this.positionOnScreen = j2;
            this.down = z;
            this.type = i;
        }
    }
}
