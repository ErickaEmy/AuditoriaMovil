package androidx.compose.ui.text.input;

import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.functions.Function1;
/* compiled from: TextInputService.kt */
/* loaded from: classes.dex */
public interface PlatformTextInputService {
    void hideSoftwareKeyboard();

    void notifyFocusedRect(Rect rect);

    void showSoftwareKeyboard();

    void startInput(TextFieldValue textFieldValue, ImeOptions imeOptions, Function1 function1, Function1 function12);

    void stopInput();

    void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2);
}
