package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
/* compiled from: KeyMapping.kt */
/* loaded from: classes.dex */
public abstract class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }

    public static final KeyMapping commonKeyMapping(final Function1 shortcutModifier) {
        Intrinsics.checkNotNullParameter(shortcutModifier, "shortcutModifier");
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo290mapZmokQxo(KeyEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (((Boolean) Function1.this.invoke(androidx.compose.ui.input.key.KeyEvent.m1132boximpl(event))).booleanValue() && KeyEvent_androidKt.m1148isShiftPressedZmokQxo(event)) {
                    if (Key.m1118equalsimpl0(KeyEvent_androidKt.m1143getKeyZmokQxo(event), MappedKeys.INSTANCE.m324getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                } else if (((Boolean) Function1.this.invoke(androidx.compose.ui.input.key.KeyEvent.m1132boximpl(event))).booleanValue()) {
                    long m1143getKeyZmokQxo = KeyEvent_androidKt.m1143getKeyZmokQxo(event);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m304getCEK5gGoQ()) || Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m314getInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m321getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m322getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m301getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m323getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m324getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                } else if (KeyEvent_androidKt.m1147isCtrlPressedZmokQxo(event)) {
                    return null;
                } else {
                    if (KeyEvent_androidKt.m1148isShiftPressedZmokQxo(event)) {
                        long m1143getKeyZmokQxo2 = KeyEvent_androidKt.m1143getKeyZmokQxo(event);
                        MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                        if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m309getDirectionLeftEK5gGoQ())) {
                            return KeyCommand.SELECT_LEFT_CHAR;
                        }
                        if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m310getDirectionRightEK5gGoQ())) {
                            return KeyCommand.SELECT_RIGHT_CHAR;
                        }
                        if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m311getDirectionUpEK5gGoQ())) {
                            return KeyCommand.SELECT_UP;
                        }
                        if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m308getDirectionDownEK5gGoQ())) {
                            return KeyCommand.SELECT_DOWN;
                        }
                        if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m318getPageUpEK5gGoQ())) {
                            return KeyCommand.SELECT_PAGE_UP;
                        }
                        if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m317getPageDownEK5gGoQ())) {
                            return KeyCommand.SELECT_PAGE_DOWN;
                        }
                        if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m316getMoveHomeEK5gGoQ())) {
                            return KeyCommand.SELECT_LINE_START;
                        }
                        if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m315getMoveEndEK5gGoQ())) {
                            return KeyCommand.SELECT_LINE_END;
                        }
                        if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m314getInsertEK5gGoQ())) {
                            return KeyCommand.PASTE;
                        }
                        return null;
                    }
                    long m1143getKeyZmokQxo3 = KeyEvent_androidKt.m1143getKeyZmokQxo(event);
                    MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m309getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.LEFT_CHAR;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m310getDirectionRightEK5gGoQ())) {
                        return KeyCommand.RIGHT_CHAR;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m311getDirectionUpEK5gGoQ())) {
                        return KeyCommand.UP;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m308getDirectionDownEK5gGoQ())) {
                        return KeyCommand.DOWN;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m318getPageUpEK5gGoQ())) {
                        return KeyCommand.PAGE_UP;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m317getPageDownEK5gGoQ())) {
                        return KeyCommand.PAGE_DOWN;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m316getMoveHomeEK5gGoQ())) {
                        return KeyCommand.LINE_START;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m315getMoveEndEK5gGoQ())) {
                        return KeyCommand.LINE_END;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m312getEnterEK5gGoQ())) {
                        return KeyCommand.NEW_LINE;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m303getBackspaceEK5gGoQ())) {
                        return KeyCommand.DELETE_PREV_CHAR;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m307getDeleteEK5gGoQ())) {
                        return KeyCommand.DELETE_NEXT_CHAR;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m319getPasteEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m306getCutEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m305getCopyEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m320getTabEK5gGoQ())) {
                        return KeyCommand.TAB;
                    }
                    return null;
                }
            }
        };
    }

    static {
        final KeyMapping commonKeyMapping = commonKeyMapping(new PropertyReference1Impl() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.m1147isCtrlPressedZmokQxo(((androidx.compose.ui.input.key.KeyEvent) obj).m1137unboximpl()));
            }
        });
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo290mapZmokQxo(KeyEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.m1148isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m1147isCtrlPressedZmokQxo(event)) {
                    long m1143getKeyZmokQxo = KeyEvent_androidKt.m1143getKeyZmokQxo(event);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m309getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m310getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m311getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo, mappedKeys.m308getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyEvent_androidKt.m1147isCtrlPressedZmokQxo(event)) {
                    long m1143getKeyZmokQxo2 = KeyEvent_androidKt.m1143getKeyZmokQxo(event);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m309getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.LEFT_WORD;
                    } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m310getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.RIGHT_WORD;
                    } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m311getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m308getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m313getHEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m307getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m303getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo2, mappedKeys2.m302getBackslashEK5gGoQ())) {
                        keyCommand = KeyCommand.DESELECT;
                    }
                } else if (KeyEvent_androidKt.m1148isShiftPressedZmokQxo(event)) {
                    long m1143getKeyZmokQxo3 = KeyEvent_androidKt.m1143getKeyZmokQxo(event);
                    MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m316getMoveHomeEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_LEFT;
                    } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo3, mappedKeys3.m315getMoveEndEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                    }
                } else if (KeyEvent_androidKt.m1146isAltPressedZmokQxo(event)) {
                    long m1143getKeyZmokQxo4 = KeyEvent_androidKt.m1143getKeyZmokQxo(event);
                    MappedKeys mappedKeys4 = MappedKeys.INSTANCE;
                    if (Key.m1118equalsimpl0(m1143getKeyZmokQxo4, mappedKeys4.m303getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                    } else if (Key.m1118equalsimpl0(m1143getKeyZmokQxo4, mappedKeys4.m307getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_TO_LINE_END;
                    }
                }
                return keyCommand == null ? KeyMapping.this.mo290mapZmokQxo(event) : keyCommand;
            }
        };
    }
}
