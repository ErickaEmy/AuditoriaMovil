package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidScrollable.android.kt */
/* loaded from: classes.dex */
public final class AndroidConfig implements ScrollConfig {
    public static final AndroidConfig INSTANCE = new AndroidConfig();

    private AndroidConfig() {
    }

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    /* renamed from: calculateMouseWheelScroll-8xgXZGE  reason: not valid java name */
    public long mo118calculateMouseWheelScroll8xgXZGE(Density calculateMouseWheelScroll, PointerEvent event, long j) {
        Intrinsics.checkNotNullParameter(calculateMouseWheelScroll, "$this$calculateMouseWheelScroll");
        Intrinsics.checkNotNullParameter(event, "event");
        List changes = event.getChanges();
        Offset m698boximpl = Offset.m698boximpl(Offset.Companion.m721getZeroF1C5BW0());
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            m698boximpl = Offset.m698boximpl(Offset.m714plusMKHz9U(m698boximpl.m718unboximpl(), ((PointerInputChange) changes.get(i)).m1198getScrollDeltaF1C5BW0()));
        }
        return Offset.m715timestuRUvjQ(m698boximpl.m718unboximpl(), -calculateMouseWheelScroll.mo155toPx0680j_4(Dp.m1897constructorimpl(64)));
    }
}
