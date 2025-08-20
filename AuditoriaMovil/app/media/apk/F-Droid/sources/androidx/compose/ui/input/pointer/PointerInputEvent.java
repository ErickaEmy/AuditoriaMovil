package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PointerInputEvent.android.kt */
/* loaded from: classes.dex */
public final class PointerInputEvent {
    private final MotionEvent motionEvent;
    private final List pointers;
    private final long uptime;

    public final MotionEvent getMotionEvent() {
        return this.motionEvent;
    }

    public final List getPointers() {
        return this.pointers;
    }

    public PointerInputEvent(long j, List pointers, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(pointers, "pointers");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        this.uptime = j;
        this.pointers = pointers;
        this.motionEvent = motionEvent;
    }
}
