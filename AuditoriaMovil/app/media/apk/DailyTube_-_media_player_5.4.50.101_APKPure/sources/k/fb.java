package k;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.databinding.library.baseAdapters.R$id;
/* loaded from: classes.dex */
public class fb {

    /* loaded from: classes.dex */
    public interface gv {
        void onTextChanged(CharSequence charSequence, int i, int i5, int i6);
    }

    /* loaded from: classes.dex */
    public interface n3 {
        void afterTextChanged(Editable editable);
    }

    /* loaded from: classes.dex */
    public class y implements TextWatcher {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ q9.v f9561fb;

        /* renamed from: s  reason: collision with root package name */
        public final /* synthetic */ n3 f9562s;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ gv f9563v;
        public final /* synthetic */ zn y;

        public y(zn znVar, gv gvVar, q9.v vVar, n3 n3Var) {
            this.f9561fb = vVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            n3 n3Var = this.f9562s;
            if (n3Var != null) {
                n3Var.afterTextChanged(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i5, int i6) {
            zn znVar = this.y;
            if (znVar != null) {
                znVar.beforeTextChanged(charSequence, i, i5, i6);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i5, int i6) {
            gv gvVar = this.f9563v;
            if (gvVar != null) {
                gvVar.onTextChanged(charSequence, i, i5, i6);
            }
            q9.v vVar = this.f9561fb;
            if (vVar != null) {
                vVar.y();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        void beforeTextChanged(CharSequence charSequence, int i, int i5, int i6);
    }

    public static void gv(TextView textView, CharSequence charSequence) {
        CharSequence text = textView.getText();
        if (charSequence != text) {
            if (charSequence != null || text.length() != 0) {
                if (charSequence instanceof Spanned) {
                    if (charSequence.equals(text)) {
                        return;
                    }
                } else if (!n3(charSequence, text)) {
                    return;
                }
                textView.setText(charSequence);
            }
        }
    }

    public static boolean n3(CharSequence charSequence, CharSequence charSequence2) {
        boolean z2;
        boolean z3;
        if (charSequence == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (charSequence2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 != z3) {
            return true;
        }
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        if (length != charSequence2.length()) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static void v(TextView textView, zn znVar, gv gvVar, n3 n3Var, q9.v vVar) {
        y yVar;
        if (znVar == null && n3Var == null && gvVar == null && vVar == null) {
            yVar = null;
        } else {
            yVar = new y(znVar, gvVar, vVar, n3Var);
        }
        TextWatcher textWatcher = (TextWatcher) k.gv.y(textView, yVar, R$id.textWatcher);
        if (textWatcher != null) {
            textView.removeTextChangedListener(textWatcher);
        }
        if (yVar != null) {
            textView.addTextChangedListener(yVar);
        }
    }

    public static String y(TextView textView) {
        return textView.getText().toString();
    }

    public static void zn(TextView textView, int i) {
        InputFilter[] filters = textView.getFilters();
        if (filters != null) {
            int i5 = 0;
            while (true) {
                if (i5 < filters.length) {
                    InputFilter inputFilter = filters[i5];
                    if (inputFilter instanceof InputFilter.LengthFilter) {
                        if (((InputFilter.LengthFilter) inputFilter).getMax() != i) {
                            filters[i5] = new InputFilter.LengthFilter(i);
                        }
                    } else {
                        i5++;
                    }
                } else {
                    int length = filters.length;
                    InputFilter[] inputFilterArr = new InputFilter[length + 1];
                    System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
                    inputFilterArr[length] = new InputFilter.LengthFilter(i);
                    filters = inputFilterArr;
                    break;
                }
            }
        } else {
            filters = new InputFilter[]{new InputFilter.LengthFilter(i)};
        }
        textView.setFilters(filters);
    }
}
