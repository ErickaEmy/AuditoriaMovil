package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextSelectionMouseDetector.kt */
/* loaded from: classes.dex */
final class ClicksCounter {
    private int clicks;
    private PointerInputChange prevClick;
    private final ViewConfiguration viewConfiguration;

    public final int getClicks() {
        return this.clicks;
    }

    public ClicksCounter(ViewConfiguration viewConfiguration) {
        Intrinsics.checkNotNullParameter(viewConfiguration, "viewConfiguration");
        this.viewConfiguration = viewConfiguration;
    }

    public final void update(PointerEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        PointerInputChange pointerInputChange = this.prevClick;
        PointerInputChange pointerInputChange2 = (PointerInputChange) event.getChanges().get(0);
        if (pointerInputChange != null && timeIsTolerable(pointerInputChange, pointerInputChange2) && positionIsTolerable(pointerInputChange, pointerInputChange2)) {
            this.clicks++;
        } else {
            this.clicks = 1;
        }
        this.prevClick = pointerInputChange2;
    }

    public final boolean timeIsTolerable(PointerInputChange prevClick, PointerInputChange newClick) {
        Intrinsics.checkNotNullParameter(prevClick, "prevClick");
        Intrinsics.checkNotNullParameter(newClick, "newClick");
        return newClick.getUptimeMillis() - prevClick.getUptimeMillis() < this.viewConfiguration.getDoubleTapTimeoutMillis();
    }

    public final boolean positionIsTolerable(PointerInputChange prevClick, PointerInputChange newClick) {
        Intrinsics.checkNotNullParameter(prevClick, "prevClick");
        Intrinsics.checkNotNullParameter(newClick, "newClick");
        return ((double) Offset.m707getDistanceimpl(Offset.m713minusMKHz9U(newClick.m1196getPositionF1C5BW0(), prevClick.m1196getPositionF1C5BW0()))) < 100.0d;
    }
}
