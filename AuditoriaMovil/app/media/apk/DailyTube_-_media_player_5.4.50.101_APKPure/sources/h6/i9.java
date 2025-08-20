package h6;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import h6.n3;
/* loaded from: classes.dex */
public final class i9<S extends n3> extends fb {

    /* renamed from: d  reason: collision with root package name */
    public c5<ObjectAnimator> f8749d;

    /* renamed from: fh  reason: collision with root package name */
    public s<S> f8750fh;

    public i9(@NonNull Context context, @NonNull n3 n3Var, @NonNull s<S> sVar, @NonNull c5<ObjectAnimator> c5Var) {
        super(context, n3Var);
        i4(sVar);
        x4(c5Var);
    }

    @NonNull
    public static i9<v> co(@NonNull Context context, @NonNull v vVar) {
        return new i9<>(context, vVar, new zn(vVar), new gv(vVar));
    }

    @Override // h6.fb
    public /* bridge */ /* synthetic */ boolean c5() {
        return super.c5();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f8750fh.fb(canvas, fb());
            this.f8750fh.zn(canvas, this.f8728n);
            int i = 0;
            while (true) {
                c5<ObjectAnimator> c5Var = this.f8749d;
                int[] iArr = c5Var.f8721zn;
                if (i < iArr.length) {
                    s<S> sVar = this.f8750fh;
                    Paint paint = this.f8728n;
                    float[] fArr = c5Var.f8720n3;
                    int i5 = i * 2;
                    sVar.n3(canvas, paint, fArr[i5], fArr[i5 + 1], iArr[i]);
                    i++;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }
    }

    @Override // h6.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f8750fh.gv();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f8750fh.v();
    }

    @Override // h6.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public void i4(@NonNull s<S> sVar) {
        this.f8750fh = sVar;
        sVar.a(this);
    }

    @Override // h6.fb
    public /* bridge */ /* synthetic */ boolean i9() {
        return super.i9();
    }

    @Override // h6.fb, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // h6.fb
    public /* bridge */ /* synthetic */ boolean mt(@NonNull o0.n3 n3Var) {
        return super.mt(n3Var);
    }

    @Override // h6.fb
    public boolean p(boolean z2, boolean z3, boolean z4) {
        boolean p2 = super.p(z2, z3, z4);
        if (!isRunning()) {
            this.f8749d.y();
        }
        float y = this.f8727fb.y(this.y.getContentResolver());
        if (z2 && (z4 || (Build.VERSION.SDK_INT <= 21 && y > 0.0f))) {
            this.f8749d.fb();
        }
        return p2;
    }

    @NonNull
    public s<S> r() {
        return this.f8750fh;
    }

    @Override // h6.fb
    public /* bridge */ /* synthetic */ boolean s() {
        return super.s();
    }

    @Override // h6.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // h6.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // h6.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3);
    }

    @Override // h6.fb, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // h6.fb, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // h6.fb
    public /* bridge */ /* synthetic */ void t(@NonNull o0.n3 n3Var) {
        super.t(n3Var);
    }

    @Override // h6.fb
    public /* bridge */ /* synthetic */ boolean w(boolean z2, boolean z3, boolean z4) {
        return super.w(z2, z3, z4);
    }

    public void x4(@NonNull c5<ObjectAnimator> c5Var) {
        this.f8749d = c5Var;
        c5Var.v(this);
    }

    @NonNull
    public c5<ObjectAnimator> z() {
        return this.f8749d;
    }
}
