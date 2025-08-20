package j;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import hw.p;
/* loaded from: classes.dex */
public final class wz implements p {

    /* loaded from: classes.dex */
    public static final class y {
        public static CharSequence y(@NonNull Context context, @NonNull ClipData.Item item, int i) {
            if ((i & 1) != 0) {
                CharSequence coerceToText = item.coerceToText(context);
                if (coerceToText instanceof Spanned) {
                    return coerceToText.toString();
                }
                return coerceToText;
            }
            return item.coerceToStyledText(context);
        }
    }

    public static CharSequence n3(@NonNull Context context, @NonNull ClipData.Item item, int i) {
        return y.y(context, item, i);
    }

    public static void zn(@NonNull Editable editable, @NonNull CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    @Override // hw.p
    @Nullable
    public hw.zn y(@NonNull View view, @NonNull hw.zn znVar) {
        Log.isLoggable("ReceiveContent", 3);
        if (znVar.gv() == 2) {
            return znVar;
        }
        ClipData n32 = znVar.n3();
        int zn2 = znVar.zn();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z2 = false;
        for (int i = 0; i < n32.getItemCount(); i++) {
            CharSequence n33 = n3(context, n32.getItemAt(i), zn2);
            if (n33 != null) {
                if (!z2) {
                    zn(editable, n33);
                    z2 = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), n33);
                }
            }
        }
        return null;
    }
}
