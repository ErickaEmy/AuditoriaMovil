package androidx.compose.ui.text.input;

import android.view.inputmethod.ExtractedText;
/* compiled from: InputMethodManager.kt */
/* loaded from: classes.dex */
public interface InputMethodManager {
    void hideSoftInput();

    void restartInput();

    void showSoftInput();

    void updateExtractedText(int i, ExtractedText extractedText);

    void updateSelection(int i, int i2, int i3, int i4);
}
