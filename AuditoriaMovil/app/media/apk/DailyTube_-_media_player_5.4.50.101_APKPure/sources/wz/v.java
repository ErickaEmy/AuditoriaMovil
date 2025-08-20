package wz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
/* loaded from: classes.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public yt f14822a;

    /* renamed from: gv  reason: collision with root package name */
    public yt f14823gv;

    /* renamed from: v  reason: collision with root package name */
    public yt f14825v;
    @NonNull
    public final View y;

    /* renamed from: zn  reason: collision with root package name */
    public int f14826zn = -1;

    /* renamed from: n3  reason: collision with root package name */
    public final c5 f14824n3 = c5.n3();

    public v(@NonNull View view) {
        this.y = view;
    }

    public void a(Drawable drawable) {
        this.f14826zn = -1;
        s(null);
        n3();
    }

    public void c5(ColorStateList colorStateList) {
        if (this.f14825v == null) {
            this.f14825v = new yt();
        }
        yt ytVar = this.f14825v;
        ytVar.y = colorStateList;
        ytVar.f14851gv = true;
        n3();
    }

    public final boolean f() {
        int i = Build.VERSION.SDK_INT;
        if (i > 21) {
            if (this.f14823gv == null) {
                return false;
            }
            return true;
        } else if (i != 21) {
            return false;
        } else {
            return true;
        }
    }

    public void fb(int i) {
        ColorStateList colorStateList;
        this.f14826zn = i;
        c5 c5Var = this.f14824n3;
        if (c5Var != null) {
            colorStateList = c5Var.a(this.y.getContext(), i);
        } else {
            colorStateList = null;
        }
        s(colorStateList);
        n3();
    }

    public PorterDuff.Mode gv() {
        yt ytVar = this.f14825v;
        if (ytVar != null) {
            return ytVar.f14852n3;
        }
        return null;
    }

    public void i9(PorterDuff.Mode mode) {
        if (this.f14825v == null) {
            this.f14825v = new yt();
        }
        yt ytVar = this.f14825v;
        ytVar.f14852n3 = mode;
        ytVar.f14853zn = true;
        n3();
    }

    public void n3() {
        Drawable background = this.y.getBackground();
        if (background != null) {
            if (f() && y(background)) {
                return;
            }
            yt ytVar = this.f14825v;
            if (ytVar != null) {
                c5.c5(background, ytVar, this.y.getDrawableState());
                return;
            }
            yt ytVar2 = this.f14823gv;
            if (ytVar2 != null) {
                c5.c5(background, ytVar2, this.y.getDrawableState());
            }
        }
    }

    public void s(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f14823gv == null) {
                this.f14823gv = new yt();
            }
            yt ytVar = this.f14823gv;
            ytVar.y = colorStateList;
            ytVar.f14851gv = true;
        } else {
            this.f14823gv = null;
        }
        n3();
    }

    public void v(@Nullable AttributeSet attributeSet, int i) {
        Context context = this.y.getContext();
        int[] iArr = R$styleable.f808a9;
        hw x42 = hw.x4(context, attributeSet, iArr, i, 0);
        View view = this.y;
        hw.i4.kp(view, view.getContext(), iArr, attributeSet, x42.mt(), i, 0);
        try {
            int i5 = R$styleable.f837f8;
            if (x42.co(i5)) {
                this.f14826zn = x42.wz(i5, -1);
                ColorStateList a2 = this.f14824n3.a(this.y.getContext(), this.f14826zn);
                if (a2 != null) {
                    s(a2);
                }
            }
            int i6 = R$styleable.f827dx;
            if (x42.co(i6)) {
                hw.i4.bk(this.y, x42.zn(i6));
            }
            int i8 = R$styleable.f863ls;
            if (x42.co(i8)) {
                hw.i4.y4(this.y, n.v(x42.f(i8, -1), null));
            }
            x42.i4();
        } catch (Throwable th) {
            x42.i4();
            throw th;
        }
    }

    public final boolean y(@NonNull Drawable drawable) {
        if (this.f14822a == null) {
            this.f14822a = new yt();
        }
        yt ytVar = this.f14822a;
        ytVar.y();
        ColorStateList r2 = hw.i4.r(this.y);
        if (r2 != null) {
            ytVar.f14851gv = true;
            ytVar.y = r2;
        }
        PorterDuff.Mode x42 = hw.i4.x4(this.y);
        if (x42 != null) {
            ytVar.f14853zn = true;
            ytVar.f14852n3 = x42;
        }
        if (!ytVar.f14851gv && !ytVar.f14853zn) {
            return false;
        }
        c5.c5(drawable, ytVar, this.y.getDrawableState());
        return true;
    }

    public ColorStateList zn() {
        yt ytVar = this.f14825v;
        if (ytVar != null) {
            return ytVar.y;
        }
        return null;
    }
}
