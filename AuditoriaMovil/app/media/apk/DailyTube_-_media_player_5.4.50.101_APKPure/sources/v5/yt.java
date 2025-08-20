package v5;

import android.os.Trace;
/* loaded from: classes.dex */
public final class yt {
    public static void gv() {
        Trace.endSection();
    }

    public static void n3(String str) {
        Trace.beginSection(str);
    }

    public static void y(String str) {
        if (j5.y >= 18) {
            n3(str);
        }
    }

    public static void zn() {
        if (j5.y >= 18) {
            gv();
        }
    }
}
