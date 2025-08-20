package hw;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class xc {

    /* renamed from: n3  reason: collision with root package name */
    public int f8997n3;
    public int y;

    public xc(@NonNull ViewGroup viewGroup) {
    }

    public void gv(@NonNull View view) {
        v(view, 0);
    }

    public void n3(@NonNull View view, @NonNull View view2, int i) {
        zn(view, view2, i, 0);
    }

    public void v(@NonNull View view, int i) {
        if (i == 1) {
            this.f8997n3 = 0;
        } else {
            this.y = 0;
        }
    }

    public int y() {
        return this.y | this.f8997n3;
    }

    public void zn(@NonNull View view, @NonNull View view2, int i, int i5) {
        if (i5 == 1) {
            this.f8997n3 = i;
        } else {
            this.y = i;
        }
    }
}
