package cr;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class c extends n {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6724a = true;

    /* renamed from: fb  reason: collision with root package name */
    public static boolean f6725fb = true;

    @Override // cr.mg
    @SuppressLint({"NewApi"})
    public void c5(@NonNull View view, @NonNull Matrix matrix) {
        if (f6725fb) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f6725fb = false;
            }
        }
    }

    @Override // cr.mg
    @SuppressLint({"NewApi"})
    public void s(@NonNull View view, @NonNull Matrix matrix) {
        if (f6724a) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f6724a = false;
            }
        }
    }
}
