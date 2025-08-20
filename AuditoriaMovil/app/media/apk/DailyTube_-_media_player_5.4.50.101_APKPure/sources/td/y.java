package td;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import pv.n3;
/* loaded from: classes.dex */
public class y {
    public static int a(int i, int i5) {
        return z6.y.zn(i5, i);
    }

    public static int fb(int i, int i5, float f4) {
        return a(i, z6.y.a(i5, Math.round(Color.alpha(i5) * f4)));
    }

    public static int gv(@NonNull View view, int i) {
        return n3.gv(view, i);
    }

    public static int n3(@NonNull Context context, int i, int i5) {
        TypedValue y = n3.y(context, i);
        if (y != null) {
            return y.data;
        }
        return i5;
    }

    public static int s(@NonNull View view, int i, int i5, float f4) {
        return fb(gv(view, i), gv(view, i5), f4);
    }

    public static int v(@NonNull View view, int i, int i5) {
        return n3(view.getContext(), i, i5);
    }

    public static int y(int i, int i5) {
        return z6.y.a(i, (Color.alpha(i) * i5) / 255);
    }

    public static int zn(Context context, int i, String str) {
        return n3.zn(context, i, str);
    }
}
