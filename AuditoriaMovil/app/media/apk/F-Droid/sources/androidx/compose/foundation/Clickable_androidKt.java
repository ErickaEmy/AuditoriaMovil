package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Clickable.android.kt */
/* loaded from: classes.dex */
public abstract class Clickable_androidKt {
    private static final long TapIndicationDelay = ViewConfiguration.getTapTimeout();

    public static final long getTapIndicationDelay() {
        return TapIndicationDelay;
    }

    public static final boolean isComposeRootInScrollableContainer(CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode) {
        Intrinsics.checkNotNullParameter(compositionLocalConsumerModifierNode, "<this>");
        return isInScrollableViewGroup((View) CompositionLocalConsumerModifierNodeKt.currentValueOf(compositionLocalConsumerModifierNode, AndroidCompositionLocals_androidKt.getLocalView()));
    }

    private static final boolean isInScrollableViewGroup(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = viewGroup.getParent();
        }
        return false;
    }

    /* renamed from: isPress-ZmokQxo  reason: not valid java name */
    public static final boolean m103isPressZmokQxo(KeyEvent isPress) {
        Intrinsics.checkNotNullParameter(isPress, "$this$isPress");
        return KeyEventType.m1139equalsimpl0(KeyEvent_androidKt.m1144getTypeZmokQxo(isPress), KeyEventType.Companion.m1140getKeyDownCS__XNY()) && m102isEnterZmokQxo(isPress);
    }

    /* renamed from: isClick-ZmokQxo  reason: not valid java name */
    public static final boolean m101isClickZmokQxo(KeyEvent isClick) {
        Intrinsics.checkNotNullParameter(isClick, "$this$isClick");
        return KeyEventType.m1139equalsimpl0(KeyEvent_androidKt.m1144getTypeZmokQxo(isClick), KeyEventType.Companion.m1141getKeyUpCS__XNY()) && m102isEnterZmokQxo(isClick);
    }

    /* renamed from: isEnter-ZmokQxo  reason: not valid java name */
    private static final boolean m102isEnterZmokQxo(KeyEvent keyEvent) {
        int m1149getNativeKeyCodeYVgTNJs = Key_androidKt.m1149getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m1143getKeyZmokQxo(keyEvent));
        return m1149getNativeKeyCodeYVgTNJs == 23 || m1149getNativeKeyCodeYVgTNJs == 66 || m1149getNativeKeyCodeYVgTNJs == 160;
    }
}
