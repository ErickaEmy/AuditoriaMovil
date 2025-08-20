package s;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
/* loaded from: classes.dex */
public class fb extends DialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new a(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(@NonNull Dialog dialog, int i) {
        if (dialog instanceof a) {
            a aVar = (a) dialog;
            if (i != 1 && i != 2) {
                if (i == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            aVar.gv(1);
            return;
        }
        super.setupDialog(dialog, i);
    }
}
