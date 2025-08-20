package o;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import vl.s;
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public final class y {
    public static final String[] y = new String[0];

    /* renamed from: o.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0169y {
        public static void y(@NonNull EditorInfo editorInfo, CharSequence charSequence, int i) {
            editorInfo.setInitialSurroundingSubText(charSequence, i);
        }
    }

    public static void a(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            C0169y.y(editorInfo, charSequence, 0);
        } else {
            v(editorInfo, charSequence, 0);
        }
    }

    public static void fb(EditorInfo editorInfo, CharSequence charSequence, int i, int i5) {
        SpannableStringBuilder spannableStringBuilder;
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        if (charSequence != null) {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
        } else {
            spannableStringBuilder = null;
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", spannableStringBuilder);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i5);
    }

    public static void gv(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
    }

    public static boolean n3(CharSequence charSequence, int i, int i5) {
        if (i5 != 0) {
            if (i5 != 1) {
                return false;
            }
            return Character.isHighSurrogate(charSequence.charAt(i));
        }
        return Character.isLowSurrogate(charSequence.charAt(i));
    }

    public static void s(EditorInfo editorInfo, CharSequence charSequence, int i, int i5) {
        int i6;
        CharSequence subSequence;
        int i8 = i5 - i;
        if (i8 > 1024) {
            i6 = 0;
        } else {
            i6 = i8;
        }
        int i10 = 2048 - i6;
        int min = Math.min(charSequence.length() - i5, i10 - Math.min(i, (int) (i10 * 0.8d)));
        int min2 = Math.min(i, i10 - min);
        int i11 = i - min2;
        if (n3(charSequence, i11, 0)) {
            i11++;
            min2--;
        }
        if (n3(charSequence, (i5 + min) - 1, 1)) {
            min--;
        }
        int i12 = min2 + i6 + min;
        if (i6 != i8) {
            subSequence = TextUtils.concat(charSequence.subSequence(i11, i11 + min2), charSequence.subSequence(i5, min + i5));
        } else {
            subSequence = charSequence.subSequence(i11, i12 + i11);
        }
        fb(editorInfo, subSequence, min2, i6 + min2);
    }

    public static void v(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence, int i) {
        int i5;
        int i6;
        s.fb(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            C0169y.y(editorInfo, charSequence, i);
            return;
        }
        int i8 = editorInfo.initialSelStart;
        int i10 = editorInfo.initialSelEnd;
        if (i8 > i10) {
            i5 = i10 - i;
        } else {
            i5 = i8 - i;
        }
        if (i8 > i10) {
            i6 = i8 - i;
        } else {
            i6 = i10 - i;
        }
        int length = charSequence.length();
        if (i >= 0 && i5 >= 0 && i6 <= length) {
            if (zn(editorInfo.inputType)) {
                fb(editorInfo, null, 0, 0);
                return;
            } else if (length <= 2048) {
                fb(editorInfo, charSequence, i5, i6);
                return;
            } else {
                s(editorInfo, charSequence, i5, i6);
                return;
            }
        }
        fb(editorInfo, null, 0, 0);
    }

    @NonNull
    public static String[] y(@NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            if (strArr == null) {
                return y;
            }
            return strArr;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return y;
        }
        String[] stringArray = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        }
        if (stringArray == null) {
            return y;
        }
        return stringArray;
    }

    public static boolean zn(int i) {
        int i5 = i & 4095;
        if (i5 != 129 && i5 != 225 && i5 != 18) {
            return false;
        }
        return true;
    }
}
