package jh;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.NonNull;
import com.google.android.material.R$attr;
import pv.n3;
/* loaded from: classes.dex */
public class y {

    /* renamed from: gv  reason: collision with root package name */
    public final float f9456gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f9457n3;
    public final boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f9458zn;

    public y(@NonNull Context context) {
        this.y = n3.n3(context, R$attr.di, false);
        this.f9457n3 = td.y.n3(context, R$attr.dl, 0);
        this.f9458zn = td.y.n3(context, R$attr.uh, 0);
        this.f9456gv = context.getResources().getDisplayMetrics().density;
    }

    public boolean gv() {
        return this.y;
    }

    public int n3(int i, float f4) {
        float y = y(f4);
        return z6.y.a(td.y.fb(z6.y.a(i, 255), this.f9457n3, y), Color.alpha(i));
    }

    public final boolean v(int i) {
        if (z6.y.a(i, 255) == this.f9458zn) {
            return true;
        }
        return false;
    }

    public float y(float f4) {
        float f6 = this.f9456gv;
        if (f6 <= 0.0f || f4 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f4 / f6)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int zn(int i, float f4) {
        if (this.y && v(i)) {
            return n3(i, f4);
        }
        return i;
    }
}
