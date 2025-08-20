package androidx.compose.ui.text.input;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
/* compiled from: PlatformTextInputAdapter.android.kt */
/* loaded from: classes.dex */
public interface PlatformTextInputAdapter {
    InputConnection createInputConnection(EditorInfo editorInfo);
}
