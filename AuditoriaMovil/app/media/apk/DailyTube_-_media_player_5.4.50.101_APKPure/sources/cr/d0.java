package cr;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class d0 extends c {

    /* renamed from: s  reason: collision with root package name */
    public static boolean f6726s = true;

    @Override // cr.mg
    @SuppressLint({"NewApi"})
    public void v(@NonNull View view, int i, int i5, int i6, int i8) {
        if (f6726s) {
            try {
                view.setLeftTopRightBottom(i, i5, i6, i8);
            } catch (NoSuchMethodError unused) {
                f6726s = false;
            }
        }
    }
}
