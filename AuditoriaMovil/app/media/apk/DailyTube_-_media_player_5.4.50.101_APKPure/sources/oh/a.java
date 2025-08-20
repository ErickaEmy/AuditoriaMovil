package oh;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Map;
import v5.j5;
import v5.r;
/* loaded from: classes.dex */
public final class a {
    @Nullable
    public static fb a(@Nullable fb fbVar, @Nullable String[] strArr, Map<String, fb> map) {
        int i = 0;
        if (fbVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                fb fbVar2 = new fb();
                int length = strArr.length;
                while (i < length) {
                    fbVar2.y(map.get(strArr[i]));
                    i++;
                }
                return fbVar2;
            }
        } else if (strArr != null && strArr.length == 1) {
            return fbVar.y(map.get(strArr[0]));
        } else {
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    fbVar.y(map.get(strArr[i]));
                    i++;
                }
            }
        }
        return fbVar;
    }

    @Nullable
    public static gv gv(@Nullable gv gvVar, Map<String, fb> map) {
        while (gvVar != null) {
            fb a2 = a(gvVar.f12287a, gvVar.t(), map);
            if (a2 != null && a2.i9() == 1) {
                return gvVar;
            }
            gvVar = gvVar.f12292i9;
        }
        return null;
    }

    public static String n3(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    @Nullable
    public static gv v(gv gvVar, Map<String, fb> map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gvVar);
        while (!arrayDeque.isEmpty()) {
            gv gvVar2 = (gv) arrayDeque.pop();
            fb a2 = a(gvVar2.f12287a, gvVar2.t(), map);
            if (a2 != null && a2.i9() == 3) {
                return gvVar2;
            }
            for (int fb2 = gvVar2.fb() - 1; fb2 >= 0; fb2--) {
                arrayDeque.push(gvVar2.a(fb2));
            }
        }
        return null;
    }

    public static void y(Spannable spannable, int i, int i5, fb fbVar, @Nullable gv gvVar, Map<String, fb> map, int i6) {
        gv v2;
        int i8;
        fb a2;
        int i10;
        if (fbVar.t() != -1) {
            spannable.setSpan(new StyleSpan(fbVar.t()), i, i5, 33);
        }
        if (fbVar.co()) {
            spannable.setSpan(new StrikethroughSpan(), i, i5, 33);
        }
        if (fbVar.z()) {
            spannable.setSpan(new UnderlineSpan(), i, i5, 33);
        }
        if (fbVar.p()) {
            xp.gv.y(spannable, new ForegroundColorSpan(fbVar.zn()), i, i5, 33);
        }
        if (fbVar.w()) {
            xp.gv.y(spannable, new BackgroundColorSpan(fbVar.n3()), i, i5, 33);
        }
        if (fbVar.gv() != null) {
            xp.gv.y(spannable, new TypefaceSpan(fbVar.gv()), i, i5, 33);
        }
        if (fbVar.xc() != null) {
            n3 n3Var = (n3) v5.y.v(fbVar.xc());
            int i11 = n3Var.y;
            if (i11 == -1) {
                if (i6 != 2 && i6 != 1) {
                    i11 = 1;
                } else {
                    i11 = 3;
                }
                i10 = 1;
            } else {
                i10 = n3Var.f12304n3;
            }
            int i12 = n3Var.f12305zn;
            if (i12 == -2) {
                i12 = 1;
            }
            xp.gv.y(spannable, new xp.v(i11, i10, i12), i, i5, 33);
        }
        int i92 = fbVar.i9();
        if (i92 != 2) {
            if (i92 == 3 || i92 == 4) {
                spannable.setSpan(new y(), i, i5, 33);
            }
        } else {
            gv gv2 = gv(gvVar, map);
            if (gv2 != null && (v2 = v(gv2, map)) != null) {
                if (v2.fb() == 1 && v2.a(0).f12293n3 != null) {
                    String str = (String) j5.i9(v2.a(0).f12293n3);
                    fb a3 = a(v2.f12287a, v2.t(), map);
                    if (a3 != null) {
                        i8 = a3.c5();
                    } else {
                        i8 = -1;
                    }
                    if (i8 == -1 && (a2 = a(gv2.f12287a, gv2.t(), map)) != null) {
                        i8 = a2.c5();
                    }
                    spannable.setSpan(new xp.zn(str, i8), i, i5, 33);
                } else {
                    r.a("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                }
            }
        }
        if (fbVar.wz()) {
            xp.gv.y(spannable, new xp.y(), i, i5, 33);
        }
        int a4 = fbVar.a();
        if (a4 != 1) {
            if (a4 != 2) {
                if (a4 == 3) {
                    xp.gv.y(spannable, new RelativeSizeSpan(fbVar.v() / 100.0f), i, i5, 33);
                    return;
                }
                return;
            }
            xp.gv.y(spannable, new RelativeSizeSpan(fbVar.v()), i, i5, 33);
            return;
        }
        xp.gv.y(spannable, new AbsoluteSizeSpan((int) fbVar.v(), true), i, i5, 33);
    }

    public static void zn(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != '\n') {
            spannableStringBuilder.append('\n');
        }
    }
}
