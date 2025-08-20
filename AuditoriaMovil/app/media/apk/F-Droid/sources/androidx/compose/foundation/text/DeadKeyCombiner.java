package androidx.compose.foundation.text;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DeadKeyCombiner.android.kt */
/* loaded from: classes.dex */
public final class DeadKeyCombiner {
    private Integer deadKeyCode;

    /* renamed from: consume-ZmokQxo  reason: not valid java name */
    public final Integer m288consumeZmokQxo(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int m1145getUtf16CodePointZmokQxo = KeyEvent_androidKt.m1145getUtf16CodePointZmokQxo(event);
        if ((Integer.MIN_VALUE & m1145getUtf16CodePointZmokQxo) != 0) {
            this.deadKeyCode = Integer.valueOf(m1145getUtf16CodePointZmokQxo & Integer.MAX_VALUE);
            return null;
        }
        Integer num = this.deadKeyCode;
        if (num != null) {
            this.deadKeyCode = null;
            Integer valueOf = Integer.valueOf(KeyCharacterMap.getDeadChar(num.intValue(), m1145getUtf16CodePointZmokQxo));
            Integer num2 = valueOf.intValue() != 0 ? valueOf : null;
            return num2 == null ? Integer.valueOf(m1145getUtf16CodePointZmokQxo) : num2;
        }
        return Integer.valueOf(m1145getUtf16CodePointZmokQxo);
    }
}
