package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: KeyEventHelpers.android.kt */
/* loaded from: classes.dex */
public abstract class KeyEventHelpers_androidKt {
    public static final void showCharacterPalette() {
    }

    /* renamed from: cancelsTextSelection-ZmokQxo  reason: not valid java name */
    public static final boolean m289cancelsTextSelectionZmokQxo(KeyEvent cancelsTextSelection) {
        Intrinsics.checkNotNullParameter(cancelsTextSelection, "$this$cancelsTextSelection");
        return cancelsTextSelection.getKeyCode() == 4 && KeyEventType.m1139equalsimpl0(KeyEvent_androidKt.m1144getTypeZmokQxo(cancelsTextSelection), KeyEventType.Companion.m1141getKeyUpCS__XNY());
    }
}
