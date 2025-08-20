package e0;

import android.text.InputFilter;
import android.text.Spanned;
/* loaded from: classes.dex */
public class y implements InputFilter {
    public int y;

    public y(int i) {
        this.y = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i5, Spanned spanned, int i6, int i8) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i6, i8, charSequence.subSequence(i, i5).toString());
            if (Integer.parseInt(sb.toString()) <= this.y) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
