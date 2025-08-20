package cr;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class fh extends d0 {

    /* renamed from: c5  reason: collision with root package name */
    public static boolean f6767c5 = true;

    @Override // cr.mg
    @SuppressLint({"NewApi"})
    public void fb(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.fb(view, i);
        } else if (f6767c5) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                f6767c5 = false;
            }
        }
    }
}
