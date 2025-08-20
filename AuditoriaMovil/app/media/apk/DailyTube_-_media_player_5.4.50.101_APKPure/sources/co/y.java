package co;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class y implements zn {
    @Override // co.zn
    public float a(n3 n3Var) {
        return n3Var.a().getElevation();
    }

    @Override // co.zn
    public void f(n3 n3Var) {
        gv(n3Var, t(n3Var));
    }

    @Override // co.zn
    public void fb(n3 n3Var, float f4) {
        xc(n3Var).s(f4);
    }

    @Override // co.zn
    public void gv(n3 n3Var, float f4) {
        xc(n3Var).fb(f4, n3Var.zn(), n3Var.v());
        w(n3Var);
    }

    @Override // co.zn
    public void i9(n3 n3Var, Context context, ColorStateList colorStateList, float f4, float f6, float f9) {
        n3Var.n3(new gv(colorStateList, f4));
        View a2 = n3Var.a();
        a2.setClipToOutline(true);
        a2.setElevation(f6);
        gv(n3Var, f9);
    }

    @Override // co.zn
    public float n3(n3 n3Var) {
        return xc(n3Var).gv();
    }

    @Override // co.zn
    public ColorStateList s(n3 n3Var) {
        return xc(n3Var).n3();
    }

    @Override // co.zn
    public float t(n3 n3Var) {
        return xc(n3Var).zn();
    }

    @Override // co.zn
    public void tl(n3 n3Var, @Nullable ColorStateList colorStateList) {
        xc(n3Var).a(colorStateList);
    }

    @Override // co.zn
    public void v(n3 n3Var) {
        gv(n3Var, t(n3Var));
    }

    public void w(n3 n3Var) {
        if (!n3Var.zn()) {
            n3Var.y(0, 0, 0, 0);
            return;
        }
        float t2 = t(n3Var);
        float n32 = n3(n3Var);
        int ceil = (int) Math.ceil(v.y(t2, n32, n3Var.v()));
        int ceil2 = (int) Math.ceil(v.n3(t2, n32, n3Var.v()));
        n3Var.y(ceil, ceil2, ceil, ceil2);
    }

    @Override // co.zn
    public float wz(n3 n3Var) {
        return n3(n3Var) * 2.0f;
    }

    public final gv xc(n3 n3Var) {
        return (gv) n3Var.gv();
    }

    @Override // co.zn
    public float y(n3 n3Var) {
        return n3(n3Var) * 2.0f;
    }

    @Override // co.zn
    public void zn(n3 n3Var, float f4) {
        n3Var.a().setElevation(f4);
    }

    @Override // co.zn
    public void c5() {
    }
}
