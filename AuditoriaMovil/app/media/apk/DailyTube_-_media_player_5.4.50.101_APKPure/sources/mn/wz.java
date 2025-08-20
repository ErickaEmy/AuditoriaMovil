package mn;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import qh.n3;
import w0.w;
/* loaded from: classes.dex */
public final class wz {
    public static void a(n3.C0187n3 c0187n3) {
        c0187n3.p(-3.4028235E38f, Integer.MIN_VALUE);
        if (c0187n3.v() instanceof Spanned) {
            if (!(c0187n3.v() instanceof Spannable)) {
                c0187n3.xc(SpannableString.valueOf(c0187n3.v()));
            }
            fb((Spannable) v5.y.v(c0187n3.v()), new w() { // from class: mn.tl
                @Override // w0.w
                public final boolean apply(Object obj) {
                    boolean gv2;
                    gv2 = wz.gv(obj);
                    return gv2;
                }
            });
        }
    }

    public static void fb(Spannable spannable, w<Object> wVar) {
        Object[] spans;
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (wVar.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static /* synthetic */ boolean gv(Object obj) {
        if (!(obj instanceof AbsoluteSizeSpan) && !(obj instanceof RelativeSizeSpan)) {
            return false;
        }
        return true;
    }

    public static float s(int i, float f4, int i5, int i6) {
        float f6;
        if (f4 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return f4;
            }
            f6 = i5;
        } else {
            f6 = i6;
        }
        return f4 * f6;
    }

    public static void v(n3.C0187n3 c0187n3) {
        c0187n3.n3();
        if (c0187n3.v() instanceof Spanned) {
            if (!(c0187n3.v() instanceof Spannable)) {
                c0187n3.xc(SpannableString.valueOf(c0187n3.v()));
            }
            fb((Spannable) v5.y.v(c0187n3.v()), new w() { // from class: mn.t
                @Override // w0.w
                public final boolean apply(Object obj) {
                    boolean zn2;
                    zn2 = wz.zn(obj);
                    return zn2;
                }
            });
        }
        a(c0187n3);
    }

    public static /* synthetic */ boolean zn(Object obj) {
        return !(obj instanceof xp.n3);
    }
}
