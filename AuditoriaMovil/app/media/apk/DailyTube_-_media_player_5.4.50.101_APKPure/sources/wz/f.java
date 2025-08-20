package wz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
/* loaded from: classes.dex */
public class f {

    /* renamed from: gv  reason: collision with root package name */
    public yt f14709gv;

    /* renamed from: n3  reason: collision with root package name */
    public yt f14710n3;
    @NonNull
    public final ImageView y;

    /* renamed from: zn  reason: collision with root package name */
    public yt f14711zn;

    public f(@NonNull ImageView imageView) {
        this.y = imageView;
    }

    public void a(AttributeSet attributeSet, int i) {
        int wz2;
        Context context = this.y.getContext();
        int[] iArr = R$styleable.f888qn;
        hw x42 = hw.x4(context, attributeSet, iArr, i, 0);
        ImageView imageView = this.y;
        hw.i4.kp(imageView, imageView.getContext(), iArr, attributeSet, x42.mt(), i, 0);
        try {
            Drawable drawable = this.y.getDrawable();
            if (drawable == null && (wz2 = x42.wz(R$styleable.f875o, -1)) != -1 && (drawable = c5.y.gv(this.y.getContext(), wz2)) != null) {
                this.y.setImageDrawable(drawable);
            }
            if (drawable != null) {
                n.n3(drawable);
            }
            int i5 = R$styleable.f851j;
            if (x42.co(i5)) {
                j.c5.zn(this.y, x42.zn(i5));
            }
            int i6 = R$styleable.f879oz;
            if (x42.co(i6)) {
                j.c5.gv(this.y, n.v(x42.f(i6, -1), null));
            }
            x42.i4();
        } catch (Throwable th) {
            x42.i4();
            throw th;
        }
    }

    public void c5(PorterDuff.Mode mode) {
        if (this.f14711zn == null) {
            this.f14711zn = new yt();
        }
        yt ytVar = this.f14711zn;
        ytVar.f14852n3 = mode;
        ytVar.f14853zn = true;
        n3();
    }

    public void fb(int i) {
        if (i != 0) {
            Drawable gv2 = c5.y.gv(this.y.getContext(), i);
            if (gv2 != null) {
                n.n3(gv2);
            }
            this.y.setImageDrawable(gv2);
        } else {
            this.y.setImageDrawable(null);
        }
        n3();
    }

    public PorterDuff.Mode gv() {
        yt ytVar = this.f14711zn;
        if (ytVar != null) {
            return ytVar.f14852n3;
        }
        return null;
    }

    public final boolean i9() {
        int i = Build.VERSION.SDK_INT;
        if (i > 21) {
            if (this.f14710n3 == null) {
                return false;
            }
            return true;
        } else if (i != 21) {
            return false;
        } else {
            return true;
        }
    }

    public void n3() {
        Drawable drawable = this.y.getDrawable();
        if (drawable != null) {
            n.n3(drawable);
        }
        if (drawable != null) {
            if (i9() && y(drawable)) {
                return;
            }
            yt ytVar = this.f14711zn;
            if (ytVar != null) {
                c5.c5(drawable, ytVar, this.y.getDrawableState());
                return;
            }
            yt ytVar2 = this.f14710n3;
            if (ytVar2 != null) {
                c5.c5(drawable, ytVar2, this.y.getDrawableState());
            }
        }
    }

    public void s(ColorStateList colorStateList) {
        if (this.f14711zn == null) {
            this.f14711zn = new yt();
        }
        yt ytVar = this.f14711zn;
        ytVar.y = colorStateList;
        ytVar.f14851gv = true;
        n3();
    }

    public boolean v() {
        if (this.y.getBackground() instanceof RippleDrawable) {
            return false;
        }
        return true;
    }

    public final boolean y(@NonNull Drawable drawable) {
        if (this.f14709gv == null) {
            this.f14709gv = new yt();
        }
        yt ytVar = this.f14709gv;
        ytVar.y();
        ColorStateList y = j.c5.y(this.y);
        if (y != null) {
            ytVar.f14851gv = true;
            ytVar.y = y;
        }
        PorterDuff.Mode n32 = j.c5.n3(this.y);
        if (n32 != null) {
            ytVar.f14853zn = true;
            ytVar.f14852n3 = n32;
        }
        if (!ytVar.f14851gv && !ytVar.f14853zn) {
            return false;
        }
        c5.c5(drawable, ytVar, this.y.getDrawableState());
        return true;
    }

    public ColorStateList zn() {
        yt ytVar = this.f14711zn;
        if (ytVar != null) {
            return ytVar.y;
        }
        return null;
    }
}
