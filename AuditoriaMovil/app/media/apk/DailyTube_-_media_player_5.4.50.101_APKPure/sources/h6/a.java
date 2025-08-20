package h6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import h6.n3;
/* loaded from: classes.dex */
public final class a<S extends n3> extends fb {

    /* renamed from: j5  reason: collision with root package name */
    public static final f7.zn<a> f8714j5 = new y("indicatorLevel");

    /* renamed from: b  reason: collision with root package name */
    public boolean f8715b;

    /* renamed from: d  reason: collision with root package name */
    public final f7.v f8716d;

    /* renamed from: ej  reason: collision with root package name */
    public final f7.gv f8717ej;

    /* renamed from: fh  reason: collision with root package name */
    public s<S> f8718fh;

    /* renamed from: x  reason: collision with root package name */
    public float f8719x;

    /* loaded from: classes.dex */
    public static class y extends f7.zn<a> {
        public y(String str) {
            super(str);
        }

        @Override // f7.zn
        /* renamed from: gv */
        public void n3(a aVar, float f4) {
            aVar.n(f4 / 10000.0f);
        }

        @Override // f7.zn
        /* renamed from: zn */
        public float y(a aVar) {
            return aVar.i4() * 10000.0f;
        }
    }

    public a(@NonNull Context context, @NonNull n3 n3Var, @NonNull s<S> sVar) {
        super(context, n3Var);
        f3(sVar);
        f7.v vVar = new f7.v();
        this.f8716d = vVar;
        vVar.gv(1.0f);
        vVar.a(50.0f);
        f7.gv gvVar = new f7.gv(this, f8714j5);
        this.f8717ej = gvVar;
        gvVar.w(vVar);
        tl(1.0f);
    }

    @NonNull
    public static a<v> r(@NonNull Context context, @NonNull v vVar) {
        return new a<>(context, vVar, new zn(vVar));
    }

    public void c(float f4) {
        setLevel((int) (f4 * 10000.0f));
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
            this.f8718fh.fb(canvas, fb());
            this.f8718fh.zn(canvas, this.f8728n);
            this.f8718fh.n3(canvas, this.f8728n, 0.0f, i4(), td.y.y(this.f8733v.f8755zn[0], getAlpha()));
            canvas.restore();
        }
    }

    public void f3(@NonNull s<S> sVar) {
        this.f8718fh = sVar;
        sVar.a(this);
    }

    @Override // h6.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f8718fh.gv();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f8718fh.v();
    }

    @Override // h6.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public final float i4() {
        return this.f8719x;
    }

    @Override // h6.fb
    public /* bridge */ /* synthetic */ boolean i9() {
        return super.i9();
    }

    @Override // h6.fb, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f8717ej.n3();
        n(getLevel() / 10000.0f);
    }

    @Override // h6.fb
    public /* bridge */ /* synthetic */ boolean mt(@NonNull o0.n3 n3Var) {
        return super.mt(n3Var);
    }

    public final void n(float f4) {
        this.f8719x = f4;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        if (this.f8715b) {
            this.f8717ej.n3();
            n(i / 10000.0f);
            return true;
        }
        this.f8717ej.c5(i4() * 10000.0f);
        this.f8717ej.tl(i);
        return true;
    }

    @Override // h6.fb
    public boolean p(boolean z2, boolean z3, boolean z4) {
        boolean p2 = super.p(z2, z3, z4);
        float y2 = this.f8727fb.y(this.y.getContentResolver());
        if (y2 == 0.0f) {
            this.f8715b = true;
        } else {
            this.f8715b = false;
            this.f8716d.a(50.0f / y2);
        }
        return p2;
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

    @NonNull
    public s<S> x4() {
        return this.f8718fh;
    }
}
