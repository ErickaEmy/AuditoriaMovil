package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PointerEvent.android.kt */
/* loaded from: classes.dex */
public final class PointerEvent {
    private final int buttons;
    private final List changes;
    private final InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;

    /* renamed from: getButtons-ry648PA  reason: not valid java name */
    public final int m1169getButtonsry648PA() {
        return this.buttons;
    }

    public final List getChanges() {
        return this.changes;
    }

    /* renamed from: getType-7fucELk  reason: not valid java name */
    public final int m1170getType7fucELk() {
        return this.type;
    }

    /* renamed from: setType-EhbLWgg$ui_release  reason: not valid java name */
    public final void m1171setTypeEhbLWgg$ui_release(int i) {
        this.type = i;
    }

    public PointerEvent(List changes, InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        this.changes = changes;
        this.internalPointerEvent = internalPointerEvent;
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        this.buttons = PointerButtons.m1167constructorimpl(motionEvent$ui_release != null ? motionEvent$ui_release.getButtonState() : 0);
        MotionEvent motionEvent$ui_release2 = getMotionEvent$ui_release();
        this.keyboardModifiers = PointerKeyboardModifiers.m1209constructorimpl(motionEvent$ui_release2 != null ? motionEvent$ui_release2.getMetaState() : 0);
        this.type = m1168calculatePointerEventType7fucELk();
    }

    public final MotionEvent getMotionEvent$ui_release() {
        InternalPointerEvent internalPointerEvent = this.internalPointerEvent;
        if (internalPointerEvent != null) {
            return internalPointerEvent.getMotionEvent();
        }
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PointerEvent(List changes) {
        this(changes, null);
        Intrinsics.checkNotNullParameter(changes, "changes");
    }

    /* renamed from: calculatePointerEventType-7fucELk  reason: not valid java name */
    private final int m1168calculatePointerEventType7fucELk() {
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        if (motionEvent$ui_release == null) {
            List list = this.changes;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                PointerInputChange pointerInputChange = (PointerInputChange) list.get(i);
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    return PointerEventType.Companion.m1180getRelease7fucELk();
                }
                if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
                    return PointerEventType.Companion.m1179getPress7fucELk();
                }
            }
            return PointerEventType.Companion.m1178getMove7fucELk();
        }
        int actionMasked = motionEvent$ui_release.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    switch (actionMasked) {
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            return PointerEventType.Companion.m1181getScroll7fucELk();
                        case 9:
                            return PointerEventType.Companion.m1176getEnter7fucELk();
                        case 10:
                            return PointerEventType.Companion.m1177getExit7fucELk();
                        default:
                            return PointerEventType.Companion.m1182getUnknown7fucELk();
                    }
                }
                return PointerEventType.Companion.m1178getMove7fucELk();
            }
            return PointerEventType.Companion.m1180getRelease7fucELk();
        }
        return PointerEventType.Companion.m1179getPress7fucELk();
    }
}
