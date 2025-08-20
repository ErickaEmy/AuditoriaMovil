package androidx.compose.ui.input.key;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: KeyEvent.android.kt */
/* loaded from: classes.dex */
public abstract class KeyEvent_androidKt {
    /* renamed from: getKey-ZmokQxo  reason: not valid java name */
    public static final long m1143getKeyZmokQxo(android.view.KeyEvent key) {
        Intrinsics.checkNotNullParameter(key, "$this$key");
        return Key_androidKt.Key(key.getKeyCode());
    }

    /* renamed from: getUtf16CodePoint-ZmokQxo  reason: not valid java name */
    public static final int m1145getUtf16CodePointZmokQxo(android.view.KeyEvent utf16CodePoint) {
        Intrinsics.checkNotNullParameter(utf16CodePoint, "$this$utf16CodePoint");
        return utf16CodePoint.getUnicodeChar();
    }

    /* renamed from: getType-ZmokQxo  reason: not valid java name */
    public static final int m1144getTypeZmokQxo(android.view.KeyEvent type) {
        Intrinsics.checkNotNullParameter(type, "$this$type");
        int action = type.getAction();
        if (action != 0) {
            if (action == 1) {
                return KeyEventType.Companion.m1141getKeyUpCS__XNY();
            }
            return KeyEventType.Companion.m1142getUnknownCS__XNY();
        }
        return KeyEventType.Companion.m1140getKeyDownCS__XNY();
    }

    /* renamed from: isAltPressed-ZmokQxo  reason: not valid java name */
    public static final boolean m1146isAltPressedZmokQxo(android.view.KeyEvent isAltPressed) {
        Intrinsics.checkNotNullParameter(isAltPressed, "$this$isAltPressed");
        return isAltPressed.isAltPressed();
    }

    /* renamed from: isCtrlPressed-ZmokQxo  reason: not valid java name */
    public static final boolean m1147isCtrlPressedZmokQxo(android.view.KeyEvent isCtrlPressed) {
        Intrinsics.checkNotNullParameter(isCtrlPressed, "$this$isCtrlPressed");
        return isCtrlPressed.isCtrlPressed();
    }

    /* renamed from: isShiftPressed-ZmokQxo  reason: not valid java name */
    public static final boolean m1148isShiftPressedZmokQxo(android.view.KeyEvent isShiftPressed) {
        Intrinsics.checkNotNullParameter(isShiftPressed, "$this$isShiftPressed");
        return isShiftPressed.isShiftPressed();
    }
}
