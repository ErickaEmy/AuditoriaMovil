package m1;

import java.util.HashSet;
/* loaded from: classes.dex */
public final class kp {
    public static final HashSet<String> y = new HashSet<>();

    /* renamed from: n3  reason: collision with root package name */
    public static String f10895n3 = "goog.exo.core";

    public static synchronized String n3() {
        String str;
        synchronized (kp.class) {
            str = f10895n3;
        }
        return str;
    }

    public static synchronized void y(String str) {
        synchronized (kp.class) {
            if (y.add(str)) {
                f10895n3 += ", " + str;
            }
        }
    }
}
