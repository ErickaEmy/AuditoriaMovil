package cr;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class n extends mg {

    /* renamed from: v  reason: collision with root package name */
    public static boolean f6777v = true;

    @Override // cr.mg
    @SuppressLint({"NewApi"})
    public void a(@NonNull View view, float f4) {
        if (f6777v) {
            try {
                view.setTransitionAlpha(f4);
                return;
            } catch (NoSuchMethodError unused) {
                f6777v = false;
            }
        }
        view.setAlpha(f4);
    }

    @Override // cr.mg
    @SuppressLint({"NewApi"})
    public float zn(@NonNull View view) {
        if (f6777v) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f6777v = false;
            }
        }
        return view.getAlpha();
    }

    @Override // cr.mg
    public void gv(@NonNull View view) {
    }

    @Override // cr.mg
    public void y(@NonNull View view) {
    }
}
