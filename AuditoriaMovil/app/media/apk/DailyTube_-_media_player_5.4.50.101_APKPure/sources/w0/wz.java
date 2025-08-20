package w0;

import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class wz {
    public static final Logger y = Logger.getLogger(wz.class.getName());

    /* renamed from: n3  reason: collision with root package name */
    public static final tl f14524n3 = n3();

    public static boolean gv(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    public static tl n3() {
        return new n3((y) null);
    }

    public static String y(String str) {
        if (gv(str)) {
            return null;
        }
        return str;
    }

    public static String zn(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }
}
