package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InternalPointerEvent.android.kt */
/* loaded from: classes.dex */
public final class InternalPointerEvent {
    private final Map changes;
    private final PointerInputEvent pointerInputEvent;
    private boolean suppressMovementConsumption;

    public final Map getChanges() {
        return this.changes;
    }

    public final boolean getSuppressMovementConsumption() {
        return this.suppressMovementConsumption;
    }

    public InternalPointerEvent(Map changes, PointerInputEvent pointerInputEvent) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(pointerInputEvent, "pointerInputEvent");
        this.changes = changes;
        this.pointerInputEvent = pointerInputEvent;
    }

    public final MotionEvent getMotionEvent() {
        return this.pointerInputEvent.getMotionEvent();
    }

    /* renamed from: issuesEnterExitEvent-0FcD4WY  reason: not valid java name */
    public final boolean m1164issuesEnterExitEvent0FcD4WY(long j) {
        Object obj;
        List pointers = this.pointerInputEvent.getPointers();
        int size = pointers.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = pointers.get(i);
            if (PointerId.m1188equalsimpl0(((PointerInputEventData) obj).m1201getIdJ3iCeTQ(), j)) {
                break;
            }
            i++;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        if (pointerInputEventData != null) {
            return pointerInputEventData.getIssuesEnterExit();
        }
        return false;
    }
}
