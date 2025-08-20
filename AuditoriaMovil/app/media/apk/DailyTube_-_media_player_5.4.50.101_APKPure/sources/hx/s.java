package hx;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class s {
    public static void a(@NonNull View view, @NonNull fb fbVar) {
        if (fbVar.vl()) {
            fbVar.u(ur.f.zn(view));
        }
    }

    public static void gv(@NonNull View view, float f4) {
        Drawable background = view.getBackground();
        if (background instanceof fb) {
            ((fb) background).q9(f4);
        }
    }

    @NonNull
    public static gv n3() {
        return new i9();
    }

    public static void v(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof fb) {
            a(view, (fb) background);
        }
    }

    @NonNull
    public static gv y(int i) {
        if (i != 0) {
            if (i != 1) {
                return n3();
            }
            return new v();
        }
        return new i9();
    }

    @NonNull
    public static a zn() {
        return new a();
    }
}
