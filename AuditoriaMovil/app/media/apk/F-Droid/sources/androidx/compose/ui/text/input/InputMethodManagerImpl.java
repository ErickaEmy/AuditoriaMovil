package androidx.compose.ui.text.input;

import android.view.View;
import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.platform.coreshims.SoftwareKeyboardControllerCompat;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InputMethodManager.kt */
/* loaded from: classes.dex */
public final class InputMethodManagerImpl implements InputMethodManager {
    private final Lazy imm$delegate;
    private final SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat;
    private final View view;

    public InputMethodManagerImpl(View view) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: androidx.compose.ui.text.input.InputMethodManagerImpl$imm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final android.view.inputmethod.InputMethodManager invoke() {
                View view2;
                view2 = InputMethodManagerImpl.this.view;
                Object systemService = view2.getContext().getSystemService("input_method");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                return (android.view.inputmethod.InputMethodManager) systemService;
            }
        });
        this.imm$delegate = lazy;
        this.softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
    }

    private final android.view.inputmethod.InputMethodManager getImm() {
        return (android.view.inputmethod.InputMethodManager) this.imm$delegate.getValue();
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void restartInput() {
        getImm().restartInput(this.view);
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void showSoftInput() {
        this.softwareKeyboardControllerCompat.show();
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void hideSoftInput() {
        this.softwareKeyboardControllerCompat.hide();
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void updateExtractedText(int i, ExtractedText extractedText) {
        Intrinsics.checkNotNullParameter(extractedText, "extractedText");
        getImm().updateExtractedText(this.view, i, extractedText);
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void updateSelection(int i, int i2, int i3, int i4) {
        getImm().updateSelection(this.view, i, i2, i3, i4);
    }
}
