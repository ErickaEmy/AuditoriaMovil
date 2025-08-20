package yk;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class mg extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: b  reason: collision with root package name */
    public boolean f15355b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15356c;
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public j3.n3 f15357co;

    /* renamed from: ct  reason: collision with root package name */
    public boolean f15358ct;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public nd.zn f15359d;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f15360d0;

    /* renamed from: dm  reason: collision with root package name */
    public Matrix f15361dm;

    /* renamed from: ej  reason: collision with root package name */
    public int f15362ej;

    /* renamed from: en  reason: collision with root package name */
    public Rect f15363en;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15364f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public Map<String, Typeface> f15365f3;

    /* renamed from: f7  reason: collision with root package name */
    public Paint f15366f7;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f15367fb;

    /* renamed from: fh  reason: collision with root package name */
    public boolean f15368fh;

    /* renamed from: j  reason: collision with root package name */
    public final Matrix f15369j;

    /* renamed from: j5  reason: collision with root package name */
    public boolean f15370j5;

    /* renamed from: jz  reason: collision with root package name */
    public Rect f15371jz;

    /* renamed from: k  reason: collision with root package name */
    public RectF f15372k;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public String f15373n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f15374o;

    /* renamed from: oz  reason: collision with root package name */
    public Bitmap f15375oz;

    /* renamed from: p  reason: collision with root package name */
    public final ValueAnimator.AnimatorUpdateListener f15376p;

    /* renamed from: q9  reason: collision with root package name */
    public Rect f15377q9;

    /* renamed from: qn  reason: collision with root package name */
    public vl f15378qn;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public j3.y f15379r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f15380s;

    /* renamed from: t  reason: collision with root package name */
    public zn f15381t;

    /* renamed from: u  reason: collision with root package name */
    public RectF f15382u;

    /* renamed from: ut  reason: collision with root package name */
    public Canvas f15383ut;

    /* renamed from: v  reason: collision with root package name */
    public final br.v f15384v;

    /* renamed from: w  reason: collision with root package name */
    public final ArrayList<n3> f15385w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f15386x;

    /* renamed from: xg  reason: collision with root package name */
    public Matrix f15387xg;
    public s y;

    /* renamed from: y5  reason: collision with root package name */
    public RectF f15388y5;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public String f15389z;

    /* loaded from: classes.dex */
    public interface n3 {
        void y(s sVar);
    }

    /* loaded from: classes.dex */
    public class y implements ValueAnimator.AnimatorUpdateListener {
        public y() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (mg.this.f15359d != null) {
                mg.this.f15359d.b(mg.this.f15384v.t());
            }
        }
    }

    /* loaded from: classes.dex */
    public enum zn {
        NONE,
        PLAY,
        RESUME
    }

    public mg() {
        br.v vVar = new br.v();
        this.f15384v = vVar;
        this.f15367fb = true;
        this.f15380s = false;
        this.f15364f = false;
        this.f15381t = zn.NONE;
        this.f15385w = new ArrayList<>();
        y yVar = new y();
        this.f15376p = yVar;
        this.f15360d0 = false;
        this.f15368fh = true;
        this.f15362ej = 255;
        this.f15378qn = vl.AUTOMATIC;
        this.f15374o = false;
        this.f15369j = new Matrix();
        this.f15358ct = false;
        vVar.addUpdateListener(yVar);
    }

    public final j3.n3 a8() {
        j3.n3 n3Var = this.f15357co;
        if (n3Var != null && !n3Var.n3(z6())) {
            this.f15357co = null;
        }
        if (this.f15357co == null) {
            this.f15357co = new j3.n3(getCallback(), this.f15389z, null, this.y.i9());
        }
        return this.f15357co;
    }

    public void ad(final String str) {
        s sVar = this.y;
        if (sVar == null) {
            this.f15385w.add(new n3() { // from class: yk.x4
                @Override // yk.mg.n3
                public final void y(s sVar2) {
                    mg.this.o4(str, sVar2);
                }
            });
            return;
        }
        ne.s t2 = sVar.t(str);
        if (t2 != null) {
            wf((int) (t2.f12021n3 + t2.f12022zn));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void ap() {
        this.f15385w.clear();
        this.f15384v.co();
        if (!isVisible()) {
            this.f15381t = zn.NONE;
        }
    }

    @Nullable
    public ta b(String str) {
        s sVar = this.y;
        if (sVar == null) {
            return null;
        }
        return sVar.i9().get(str);
    }

    public void bk(String str) {
        this.f15373n = str;
        j3.y ej2 = ej();
        if (ej2 != null) {
            ej2.zn(str);
        }
    }

    public boolean c() {
        return this.f15356c;
    }

    public void co() {
        this.f15385w.clear();
        this.f15384v.cancel();
        if (!isVisible()) {
            this.f15381t = zn.NONE;
        }
    }

    public void cr(yk.n3 n3Var) {
        j3.n3 n3Var2 = this.f15357co;
        if (n3Var2 != null) {
            n3Var2.gv(n3Var);
        }
    }

    public void cs(float f4) {
        this.f15384v.d(f4);
    }

    public final /* synthetic */ void ct(int i, s sVar) {
        wf(i);
    }

    public void cy(final float f4) {
        s sVar = this.y;
        if (sVar == null) {
            this.f15385w.add(new n3() { // from class: yk.mt
                @Override // yk.mg.n3
                public final void y(s sVar2) {
                    mg.this.rs(f4, sVar2);
                }
            });
        } else {
            this.f15384v.rz(br.fb.c5(sVar.w(), this.y.a(), f4));
        }
    }

    public s d() {
        return this.y;
    }

    public void d0() {
        this.f15385w.clear();
        this.f15384v.f();
        if (!isVisible()) {
            this.f15381t = zn.NONE;
        }
    }

    public final /* synthetic */ void dm(int i, s sVar) {
        pz(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        yk.zn.y("Drawable#draw");
        if (this.f15364f) {
            try {
                if (this.f15374o) {
                    yc(canvas, this.f15359d);
                } else {
                    f3(canvas);
                }
            } catch (Throwable th) {
                br.gv.n3("Lottie crashed in draw!", th);
            }
        } else if (this.f15374o) {
            yc(canvas, this.f15359d);
        } else {
            f3(canvas);
        }
        this.f15358ct = false;
        yk.zn.n3("Drawable#draw");
    }

    public final /* synthetic */ void e(float f4, s sVar) {
        vp(f4);
    }

    public final /* synthetic */ void eb(int i, int i5, s sVar) {
        qk(i, i5);
    }

    public final j3.y ej() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f15379r == null) {
            j3.y yVar = new j3.y(getCallback(), null);
            this.f15379r = yVar;
            String str = this.f15373n;
            if (str != null) {
                yVar.zn(str);
            }
        }
        return this.f15379r;
    }

    public boolean en() {
        if (isVisible()) {
            return this.f15384v.isRunning();
        }
        zn znVar = this.f15381t;
        if (znVar != zn.PLAY && znVar != zn.RESUME) {
            return false;
        }
        return true;
    }

    public final void f3(Canvas canvas) {
        nd.zn znVar = this.f15359d;
        s sVar = this.y;
        if (znVar != null && sVar != null) {
            this.f15369j.reset();
            Rect bounds = getBounds();
            if (!bounds.isEmpty()) {
                this.f15369j.preScale(bounds.width() / sVar.n3().width(), bounds.height() / sVar.n3().height());
                this.f15369j.preTranslate(bounds.left, bounds.top);
            }
            znVar.fb(canvas, this.f15369j, this.f15362ej);
        }
    }

    public boolean f7() {
        br.v vVar = this.f15384v;
        if (vVar == null) {
            return false;
        }
        return vVar.isRunning();
    }

    public final void fh(int i, int i5) {
        Bitmap bitmap = this.f15375oz;
        if (bitmap != null && bitmap.getWidth() >= i && this.f15375oz.getHeight() >= i5) {
            if (this.f15375oz.getWidth() > i || this.f15375oz.getHeight() > i5) {
                Bitmap createBitmap = Bitmap.createBitmap(this.f15375oz, 0, 0, i, i5);
                this.f15375oz = createBitmap;
                this.f15383ut.setBitmap(createBitmap);
                this.f15358ct = true;
                return;
            }
            return;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(i, i5, Bitmap.Config.ARGB_8888);
        this.f15375oz = createBitmap2;
        this.f15383ut.setBitmap(createBitmap2);
        this.f15358ct = true;
    }

    public void g(boolean z2) {
        if (z2 != this.f15368fh) {
            this.f15368fh = z2;
            nd.zn znVar = this.f15359d;
            if (znVar != null) {
                znVar.vl(z2);
            }
            invalidateSelf();
        }
    }

    public final void g3(RectF rectF, float f4, float f6) {
        rectF.set(rectF.left * f4, rectF.top * f6, rectF.right * f4, rectF.bottom * f6);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f15362ej;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        s sVar = this.y;
        if (sVar == null) {
            return -1;
        }
        return sVar.n3().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        s sVar = this.y;
        if (sVar == null) {
            return -1;
        }
        return sVar.n3().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void gq(final String str) {
        s sVar = this.y;
        if (sVar == null) {
            this.f15385w.add(new n3() { // from class: yk.i4
                @Override // yk.mg.n3
                public final void y(s sVar2) {
                    mg.this.ra(str, sVar2);
                }
            });
            return;
        }
        ne.s t2 = sVar.t(str);
        if (t2 != null) {
            l((int) t2.f12021n3);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    @Nullable
    public yt hw() {
        s sVar = this.y;
        if (sVar != null) {
            return sVar.wz();
        }
        return null;
    }

    public boolean i2() {
        if (this.f15365f3 == null && this.y.zn().tl() > 0) {
            return true;
        }
        return false;
    }

    public final void i4(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f15358ct) {
            return;
        }
        this.f15358ct = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return f7();
    }

    @SuppressLint({"WrongConstant"})
    public int j() {
        return this.f15384v.getRepeatMode();
    }

    public float j5() {
        return this.f15384v.t();
    }

    public boolean jz() {
        return this.f15370j5;
    }

    public final boolean k() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        if (!(parent instanceof ViewGroup)) {
            return false;
        }
        return !((ViewGroup) parent).getClipChildren();
    }

    public boolean k5() {
        return this.f15360d0;
    }

    public List<ne.v> kp(ne.v vVar) {
        if (this.f15359d == null) {
            br.gv.zn("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f15359d.zn(vVar, 0, arrayList, new ne.v(new String[0]));
        return arrayList;
    }

    public void l(final int i) {
        if (this.y == null) {
            this.f15385w.add(new n3() { // from class: yk.rz
                @Override // yk.mg.n3
                public final void y(s sVar) {
                    mg.this.nf(i, sVar);
                }
            });
        } else {
            this.f15384v.ta(i);
        }
    }

    public final /* synthetic */ void lc(String str, s sVar) {
        qj(str);
    }

    public void le(boolean z2) {
        this.f15364f = z2;
    }

    public void m(boolean z2) {
        this.f15370j5 = z2;
    }

    @Nullable
    public Bitmap mg(String str) {
        j3.n3 a82 = a8();
        if (a82 != null) {
            return a82.y(str);
        }
        return null;
    }

    public void mp(int i) {
        this.f15384v.setRepeatMode(i);
    }

    public final void mt() {
        s sVar = this.y;
        if (sVar == null) {
            return;
        }
        nd.zn znVar = new nd.zn(this, bv.x4.n3(sVar), sVar.f(), sVar);
        this.f15359d = znVar;
        if (this.f15355b) {
            znVar.a8(true);
        }
        this.f15359d.vl(this.f15368fh);
    }

    public void n(boolean z2) {
        if (this.f15356c == z2) {
            return;
        }
        this.f15356c = z2;
        if (this.y != null) {
            mt();
        }
    }

    public final /* synthetic */ void nf(int i, s sVar) {
        l(i);
    }

    public int o() {
        return this.f15384v.getRepeatCount();
    }

    public void o0(@Nullable String str) {
        this.f15389z = str;
    }

    public final /* synthetic */ void o4(String str, s sVar) {
        ad(str);
    }

    public void oa(boolean z2) {
        if (this.f15355b == z2) {
            return;
        }
        this.f15355b = z2;
        nd.zn znVar = this.f15359d;
        if (znVar != null) {
            znVar.a8(z2);
        }
    }

    public float oz() {
        return this.f15384v.p();
    }

    public final boolean p() {
        if (!this.f15367fb && !this.f15380s) {
            return false;
        }
        return true;
    }

    public void pq(boolean z2) {
        this.f15380s = z2;
    }

    public void pz(final int i) {
        if (this.y == null) {
            this.f15385w.add(new n3() { // from class: yk.d0
                @Override // yk.mg.n3
                public final void y(s sVar) {
                    mg.this.dm(i, sVar);
                }
            });
        } else {
            this.f15384v.fh(i);
        }
    }

    public void q5(int i) {
        this.f15384v.setRepeatCount(i);
    }

    @Nullable
    public Typeface q9(ne.zn znVar) {
        Map<String, Typeface> map = this.f15365f3;
        if (map != null) {
            String y2 = znVar.y();
            if (map.containsKey(y2)) {
                return map.get(y2);
            }
            String n32 = znVar.n3();
            if (map.containsKey(n32)) {
                return map.get(n32);
            }
            String str = znVar.y() + "-" + znVar.zn();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        j3.y ej2 = ej();
        if (ej2 != null) {
            return ej2.n3(znVar);
        }
        return null;
    }

    public void qj(final String str) {
        s sVar = this.y;
        if (sVar == null) {
            this.f15385w.add(new n3() { // from class: yk.p
                @Override // yk.mg.n3
                public final void y(s sVar2) {
                    mg.this.lc(str, sVar2);
                }
            });
            return;
        }
        ne.s t2 = sVar.t(str);
        if (t2 != null) {
            int i = (int) t2.f12021n3;
            qk(i, ((int) t2.f12022zn) + i);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void qk(final int i, final int i5) {
        if (this.y == null) {
            this.f15385w.add(new n3() { // from class: yk.co
                @Override // yk.mg.n3
                public final void y(s sVar) {
                    mg.this.eb(i, i5, sVar);
                }
            });
        } else {
            this.f15384v.mg(i, i5 + 0.99f);
        }
    }

    public vl qn() {
        if (this.f15374o) {
            return vl.SOFTWARE;
        }
        return vl.HARDWARE;
    }

    public final void r() {
        s sVar = this.y;
        if (sVar == null) {
            return;
        }
        this.f15374o = this.f15378qn.gv(Build.VERSION.SDK_INT, sVar.p(), sVar.tl());
    }

    public final /* synthetic */ void ra(String str, s sVar) {
        gq(str);
    }

    public void rb() {
        float yt2;
        if (this.f15359d == null) {
            this.f15385w.add(new n3() { // from class: yk.r
                @Override // yk.mg.n3
                public final void y(s sVar) {
                    mg.this.xg(sVar);
                }
            });
            return;
        }
        r();
        if (p() || o() == 0) {
            if (isVisible()) {
                this.f15384v.n();
                this.f15381t = zn.NONE;
            } else {
                this.f15381t = zn.RESUME;
            }
        }
        if (!p()) {
            if (oz() < 0.0f) {
                yt2 = vl();
            } else {
                yt2 = yt();
            }
            pz((int) yt2);
            this.f15384v.f();
            if (!isVisible()) {
                this.f15381t = zn.NONE;
            }
        }
    }

    public void ro(Boolean bool) {
        this.f15367fb = bool.booleanValue();
    }

    public final /* synthetic */ void rs(float f4, s sVar) {
        cy(f4);
    }

    public final void rz() {
        if (this.f15383ut != null) {
            return;
        }
        this.f15383ut = new Canvas();
        this.f15388y5 = new RectF();
        this.f15387xg = new Matrix();
        this.f15361dm = new Matrix();
        this.f15377q9 = new Rect();
        this.f15372k = new RectF();
        this.f15366f7 = new i2.y();
        this.f15363en = new Rect();
        this.f15371jz = new Rect();
        this.f15382u = new RectF();
    }

    public final /* synthetic */ void s8(float f4, s sVar) {
        w2(f4);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f15362ej = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        br.gv.zn("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean isVisible = isVisible();
        boolean visible = super.setVisible(z2, z3);
        if (z2) {
            zn znVar = this.f15381t;
            if (znVar == zn.PLAY) {
                yg();
            } else if (znVar == zn.RESUME) {
                rb();
            }
        } else if (this.f15384v.isRunning()) {
            ap();
            this.f15381t = zn.RESUME;
        } else if (isVisible) {
            this.f15381t = zn.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        yg();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        d0();
    }

    public boolean ta() {
        return this.f15368fh;
    }

    public void tg(@Nullable Map<String, Typeface> map) {
        if (map == this.f15365f3) {
            return;
        }
        this.f15365f3 = map;
        invalidateSelf();
    }

    public final /* synthetic */ void u(ne.v vVar, Object obj, uo.zn znVar, s sVar) {
        w(vVar, obj, znVar);
    }

    public boolean u0(s sVar) {
        if (this.y == sVar) {
            return false;
        }
        this.f15358ct = true;
        z();
        this.y = sVar;
        mt();
        this.f15384v.d0(sVar);
        w2(this.f15384v.getAnimatedFraction());
        Iterator it = new ArrayList(this.f15385w).iterator();
        while (it.hasNext()) {
            n3 n3Var = (n3) it.next();
            if (n3Var != null) {
                n3Var.y(sVar);
            }
            it.remove();
        }
        this.f15385w.clear();
        sVar.x4(this.f15386x);
        r();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public int ud() {
        return (int) this.f15384v.tl();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    @Nullable
    public j5 ut() {
        return null;
    }

    public float vl() {
        return this.f15384v.w();
    }

    public void vp(final float f4) {
        s sVar = this.y;
        if (sVar == null) {
            this.f15385w.add(new n3() { // from class: yk.n
                @Override // yk.mg.n3
                public final void y(s sVar2) {
                    mg.this.e(f4, sVar2);
                }
            });
        } else {
            l((int) br.fb.c5(sVar.w(), this.y.a(), f4));
        }
    }

    public <T> void w(final ne.v vVar, final T t2, @Nullable final uo.zn<T> znVar) {
        nd.zn znVar2 = this.f15359d;
        if (znVar2 == null) {
            this.f15385w.add(new n3() { // from class: yk.z
                @Override // yk.mg.n3
                public final void y(s sVar) {
                    mg.this.u(vVar, t2, znVar, sVar);
                }
            });
            return;
        }
        boolean z2 = true;
        if (vVar == ne.v.f12023zn) {
            znVar2.a(t2, znVar);
        } else if (vVar.gv() != null) {
            vVar.gv().a(t2, znVar);
        } else {
            List<ne.v> kp2 = kp(vVar);
            for (int i = 0; i < kp2.size(); i++) {
                kp2.get(i).gv().a(t2, znVar);
            }
            z2 = true ^ kp2.isEmpty();
        }
        if (z2) {
            invalidateSelf();
            if (t2 == ud.f15442ta) {
                w2(j5());
            }
        }
    }

    public void w2(final float f4) {
        if (this.y == null) {
            this.f15385w.add(new n3() { // from class: yk.c
                @Override // yk.mg.n3
                public final void y(s sVar) {
                    mg.this.s8(f4, sVar);
                }
            });
            return;
        }
        yk.zn.y("Drawable#setProgress");
        this.f15384v.fh(this.y.s(f4));
        yk.zn.n3("Drawable#setProgress");
    }

    public void w9(boolean z2) {
        this.f15386x = z2;
        s sVar = this.y;
        if (sVar != null) {
            sVar.x4(z2);
        }
    }

    public void wf(final int i) {
        if (this.y == null) {
            this.f15385w.add(new n3() { // from class: yk.fh
                @Override // yk.mg.n3
                public final void y(s sVar) {
                    mg.this.ct(i, sVar);
                }
            });
        } else {
            this.f15384v.rz(i + 0.99f);
        }
    }

    @Nullable
    public String x() {
        return this.f15389z;
    }

    public final void x4(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void x5(vl vlVar) {
        this.f15378qn = vlVar;
        r();
    }

    public void xb(boolean z2) {
        this.f15360d0 = z2;
    }

    public final /* synthetic */ void xg(s sVar) {
        rb();
    }

    public void y4(yk.y yVar) {
        j3.y yVar2 = this.f15379r;
        if (yVar2 != null) {
            yVar2.gv(yVar);
        }
    }

    public final /* synthetic */ void y5(s sVar) {
        yg();
    }

    public final void yc(Canvas canvas, nd.zn znVar) {
        if (this.y != null && znVar != null) {
            rz();
            canvas.getMatrix(this.f15387xg);
            canvas.getClipBounds(this.f15377q9);
            x4(this.f15377q9, this.f15372k);
            this.f15387xg.mapRect(this.f15372k);
            i4(this.f15372k, this.f15377q9);
            if (this.f15368fh) {
                this.f15388y5.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
            } else {
                znVar.gv(this.f15388y5, null, false);
            }
            this.f15387xg.mapRect(this.f15388y5);
            Rect bounds = getBounds();
            float width = bounds.width() / getIntrinsicWidth();
            float height = bounds.height() / getIntrinsicHeight();
            g3(this.f15388y5, width, height);
            if (!k()) {
                RectF rectF = this.f15388y5;
                Rect rect = this.f15377q9;
                rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
            }
            int ceil = (int) Math.ceil(this.f15388y5.width());
            int ceil2 = (int) Math.ceil(this.f15388y5.height());
            if (ceil != 0 && ceil2 != 0) {
                fh(ceil, ceil2);
                if (this.f15358ct) {
                    this.f15369j.set(this.f15387xg);
                    this.f15369j.preScale(width, height);
                    Matrix matrix = this.f15369j;
                    RectF rectF2 = this.f15388y5;
                    matrix.postTranslate(-rectF2.left, -rectF2.top);
                    this.f15375oz.eraseColor(0);
                    znVar.fb(this.f15383ut, this.f15369j, this.f15362ej);
                    this.f15387xg.invert(this.f15361dm);
                    this.f15361dm.mapRect(this.f15382u, this.f15388y5);
                    i4(this.f15382u, this.f15371jz);
                }
                this.f15363en.set(0, 0, ceil, ceil2);
                canvas.drawBitmap(this.f15375oz, this.f15363en, this.f15371jz, this.f15366f7);
            }
        }
    }

    public void yg() {
        float yt2;
        if (this.f15359d == null) {
            this.f15385w.add(new n3() { // from class: yk.f3
                @Override // yk.mg.n3
                public final void y(s sVar) {
                    mg.this.y5(sVar);
                }
            });
            return;
        }
        r();
        if (p() || o() == 0) {
            if (isVisible()) {
                this.f15384v.z();
                this.f15381t = zn.NONE;
            } else {
                this.f15381t = zn.PLAY;
            }
        }
        if (!p()) {
            if (oz() < 0.0f) {
                yt2 = vl();
            } else {
                yt2 = yt();
            }
            pz((int) yt2);
            this.f15384v.f();
            if (!isVisible()) {
                this.f15381t = zn.NONE;
            }
        }
    }

    public void yk(boolean z2) {
        this.f15384v.z6(z2);
    }

    public float yt() {
        return this.f15384v.xc();
    }

    public void z() {
        if (this.f15384v.isRunning()) {
            this.f15384v.cancel();
            if (!isVisible()) {
                this.f15381t = zn.NONE;
            }
        }
        this.y = null;
        this.f15359d = null;
        this.f15357co = null;
        this.f15384v.i9();
        invalidateSelf();
    }

    @Nullable
    public final Context z6() {
        Drawable.Callback callback = getCallback();
        if (callback == null || !(callback instanceof View)) {
            return null;
        }
        return ((View) callback).getContext();
    }

    public void ix(j5 j5Var) {
    }
}
