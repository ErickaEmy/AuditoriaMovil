package mn;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.ui.R$string;
import java.util.Locale;
import m1.m;
import v5.j5;
import v5.n;
/* loaded from: classes.dex */
public class v implements xc {
    public final Resources y;

    public v(Resources resources) {
        this.y = (Resources) v5.y.v(resources);
    }

    public static int c5(m mVar) {
        int f4 = n.f(mVar.f10948f3);
        if (f4 != -1) {
            return f4;
        }
        if (n.wz(mVar.f10942co) != null) {
            return 2;
        }
        if (n.zn(mVar.f10942co) != null) {
            return 1;
        }
        if (mVar.f10943d != -1 || mVar.f10945ej != -1) {
            return 2;
        }
        if (mVar.f10958oz == -1 && mVar.f10966ut == -1) {
            return -1;
        }
        return 1;
    }

    public final String a(m mVar) {
        Locale locale;
        String str = mVar.f10950fb;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        if (j5.y >= 21) {
            locale = Locale.forLanguageTag(str);
        } else {
            locale = new Locale(str);
        }
        Locale qn2 = j5.qn();
        String displayName = locale.getDisplayName(qn2);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int offsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, offsetByCodePoints).toUpperCase(qn2) + displayName.substring(offsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    public final String fb(m mVar) {
        int i = mVar.f10943d;
        int i5 = mVar.f10945ej;
        if (i != -1 && i5 != -1) {
            return this.y.getString(R$string.p4, Integer.valueOf(i), Integer.valueOf(i5));
        }
        return "";
    }

    public final String gv(m mVar) {
        if (TextUtils.isEmpty(mVar.f10967v)) {
            return "";
        }
        return mVar.f10967v;
    }

    public final String i9(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                if (TextUtils.isEmpty(str)) {
                    str = str2;
                } else {
                    str = this.y.getString(R$string.pn, str, str2);
                }
            }
        }
        return str;
    }

    public final String n3(m mVar) {
        int i = mVar.f10958oz;
        if (i != -1 && i >= 1) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 6 && i != 7) {
                        if (i != 8) {
                            return this.y.getString(R$string.zk);
                        }
                        return this.y.getString(R$string.zy);
                    }
                    return this.y.getString(R$string.zj);
                }
                return this.y.getString(R$string.zb);
            }
            return this.y.getString(R$string.p3);
        }
        return "";
    }

    public final String s(m mVar) {
        String str;
        if ((mVar.f10947f & 2) != 0) {
            str = this.y.getString(R$string.mt);
        } else {
            str = "";
        }
        if ((mVar.f10947f & 4) != 0) {
            str = i9(str, this.y.getString(R$string.p8));
        }
        if ((mVar.f10947f & 8) != 0) {
            str = i9(str, this.y.getString(R$string.p7));
        }
        if ((mVar.f10947f & 1088) != 0) {
            return i9(str, this.y.getString(R$string.co));
        }
        return str;
    }

    public final String v(m mVar) {
        String i92 = i9(a(mVar), s(mVar));
        if (TextUtils.isEmpty(i92)) {
            return gv(mVar);
        }
        return i92;
    }

    @Override // mn.xc
    public String y(m mVar) {
        String v2;
        int c52 = c5(mVar);
        if (c52 == 2) {
            v2 = i9(s(mVar), fb(mVar), zn(mVar));
        } else if (c52 == 1) {
            v2 = i9(v(mVar), n3(mVar), zn(mVar));
        } else {
            v2 = v(mVar);
        }
        if (v2.length() == 0) {
            return this.y.getString(R$string.zu);
        }
        return v2;
    }

    public final String zn(m mVar) {
        int i = mVar.f10959p;
        if (i == -1) {
            return "";
        }
        return this.y.getString(R$string.p2, Float.valueOf(i / 1000000.0f));
    }
}
