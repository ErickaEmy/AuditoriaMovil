package androidx.compose.foundation.text;

import android.view.KeyEvent;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextFieldKeyInput.android.kt */
/* loaded from: classes.dex */
public abstract class TextFieldKeyInput_androidKt {
    /* renamed from: isTypedEvent-ZmokQxo  reason: not valid java name */
    public static final boolean m343isTypedEventZmokQxo(KeyEvent isTypedEvent) {
        Intrinsics.checkNotNullParameter(isTypedEvent, "$this$isTypedEvent");
        return isTypedEvent.getAction() == 0 && !Character.isISOControl(isTypedEvent.getUnicodeChar());
    }
}
