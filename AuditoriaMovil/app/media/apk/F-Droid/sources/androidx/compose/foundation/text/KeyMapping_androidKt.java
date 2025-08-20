package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: KeyMapping.android.kt */
/* loaded from: classes.dex */
public abstract class KeyMapping_androidKt {
    private static final KeyMapping platformDefaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMapping_androidKt$platformDefaultKeyMapping$1
        @Override // androidx.compose.foundation.text.KeyMapping
        /* renamed from: map-ZmokQxo */
        public KeyCommand mo290mapZmokQxo(KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            KeyCommand keyCommand = null;
            if (KeyEvent_androidKt.m1148isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m1146isAltPressedZmokQxo(event)) {
                long m1143getKeyZmokQxo = KeyEvent_androidKt.m1143getKeyZmokQxo(event);
                MappedKeys mappedKeys = MappedKeys.INSTANCE;
                if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m309getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_LEFT;
                } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m310getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m311getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_HOME;
                } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m308getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_END;
                }
            } else if (KeyEvent_androidKt.m1146isAltPressedZmokQxo(event)) {
                long m1143getKeyZmokQxo2 = KeyEvent_androidKt.m1143getKeyZmokQxo(event);
                MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m309getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_LEFT;
                } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m310getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_RIGHT;
                } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m311getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.HOME;
                } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m308getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.END;
                }
            }
            return keyCommand == null ? KeyMappingKt.getDefaultKeyMapping().mo290mapZmokQxo(event) : keyCommand;
        }
    };

    public static final KeyMapping getPlatformDefaultKeyMapping() {
        return platformDefaultKeyMapping;
    }
}
