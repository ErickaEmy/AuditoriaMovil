package androidx.compose.ui.text.input;

import android.view.KeyEvent;
import java.util.List;
/* compiled from: InputEventCallback2.android.kt */
/* loaded from: classes.dex */
public interface InputEventCallback2 {
    void onConnectionClosed(RecordingInputConnection recordingInputConnection);

    void onEditCommands(List list);

    /* renamed from: onImeAction-KlQnJC8  reason: not valid java name */
    void mo1693onImeActionKlQnJC8(int i);

    void onKeyEvent(KeyEvent keyEvent);
}
