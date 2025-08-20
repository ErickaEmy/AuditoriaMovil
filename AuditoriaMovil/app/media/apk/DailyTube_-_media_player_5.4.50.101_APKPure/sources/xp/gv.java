package xp;

import android.text.Spannable;
/* loaded from: classes.dex */
public final class gv {
    public static void y(Spannable spannable, Object obj, int i, int i5, int i6) {
        Object[] spans;
        for (Object obj2 : spannable.getSpans(i, i5, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i && spannable.getSpanEnd(obj2) == i5 && spannable.getSpanFlags(obj2) == i6) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i, i5, i6);
    }
}
