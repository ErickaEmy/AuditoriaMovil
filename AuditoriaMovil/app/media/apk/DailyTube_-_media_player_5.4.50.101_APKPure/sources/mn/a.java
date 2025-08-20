package mn;

import android.graphics.Color;
import v5.j5;
/* loaded from: classes.dex */
public final class a {
    public static String n3(int i) {
        return j5.rz("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(Color.alpha(i) / 255.0d));
    }

    public static String y(String str) {
        return "." + str + ",." + str + " *";
    }
}
