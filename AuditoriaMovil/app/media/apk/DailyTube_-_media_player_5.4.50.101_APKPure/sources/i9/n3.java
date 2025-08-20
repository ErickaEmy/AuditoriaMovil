package i9;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class n3 extends Drawable implements Drawable.Callback {

    /* renamed from: co  reason: collision with root package name */
    public Runnable f9122co;

    /* renamed from: f3  reason: collision with root package name */
    public zn f9124f3;

    /* renamed from: fb  reason: collision with root package name */
    public Drawable f9125fb;

    /* renamed from: p  reason: collision with root package name */
    public boolean f9126p;

    /* renamed from: r  reason: collision with root package name */
    public long f9127r;

    /* renamed from: s  reason: collision with root package name */
    public Drawable f9128s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f9129t;

    /* renamed from: v  reason: collision with root package name */
    public Rect f9130v;
    public gv y;

    /* renamed from: z  reason: collision with root package name */
    public long f9132z;

    /* renamed from: f  reason: collision with root package name */
    public int f9123f = 255;

    /* renamed from: w  reason: collision with root package name */
    public int f9131w = -1;

    /* loaded from: classes.dex */
    public static abstract class gv extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public SparseArray<Drawable.ConstantState> f9133a;

        /* renamed from: c  reason: collision with root package name */
        public int f9134c;

        /* renamed from: c5  reason: collision with root package name */
        public boolean f9135c5;

        /* renamed from: co  reason: collision with root package name */
        public int f9136co;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f9137d;

        /* renamed from: d0  reason: collision with root package name */
        public int f9138d0;

        /* renamed from: ej  reason: collision with root package name */
        public boolean f9139ej;

        /* renamed from: f  reason: collision with root package name */
        public Rect f9140f;

        /* renamed from: f3  reason: collision with root package name */
        public boolean f9141f3;

        /* renamed from: fb  reason: collision with root package name */
        public Drawable[] f9142fb;

        /* renamed from: fh  reason: collision with root package name */
        public int f9143fh;

        /* renamed from: gv  reason: collision with root package name */
        public int f9144gv;

        /* renamed from: i4  reason: collision with root package name */
        public boolean f9145i4;

        /* renamed from: i9  reason: collision with root package name */
        public boolean f9146i9;

        /* renamed from: mg  reason: collision with root package name */
        public ColorFilter f9147mg;

        /* renamed from: mt  reason: collision with root package name */
        public boolean f9148mt;

        /* renamed from: n  reason: collision with root package name */
        public boolean f9149n;

        /* renamed from: n3  reason: collision with root package name */
        public Resources f9150n3;

        /* renamed from: p  reason: collision with root package name */
        public int f9151p;

        /* renamed from: r  reason: collision with root package name */
        public boolean f9152r;

        /* renamed from: rz  reason: collision with root package name */
        public boolean f9153rz;

        /* renamed from: s  reason: collision with root package name */
        public int f9154s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f9155t;

        /* renamed from: ta  reason: collision with root package name */
        public boolean f9156ta;

        /* renamed from: tl  reason: collision with root package name */
        public boolean f9157tl;

        /* renamed from: ud  reason: collision with root package name */
        public boolean f9158ud;

        /* renamed from: v  reason: collision with root package name */
        public int f9159v;

        /* renamed from: w  reason: collision with root package name */
        public int f9160w;

        /* renamed from: wz  reason: collision with root package name */
        public int f9161wz;

        /* renamed from: x4  reason: collision with root package name */
        public boolean f9162x4;

        /* renamed from: xc  reason: collision with root package name */
        public int f9163xc;
        public final n3 y;

        /* renamed from: z  reason: collision with root package name */
        public boolean f9164z;

        /* renamed from: z6  reason: collision with root package name */
        public PorterDuff.Mode f9165z6;

        /* renamed from: zn  reason: collision with root package name */
        public int f9166zn;

        public gv(gv gvVar, n3 n3Var, Resources resources) {
            Resources resources2;
            int i;
            this.f9141f3 = true;
            this.y = n3Var;
            if (resources != null) {
                resources2 = resources;
            } else if (gvVar != null) {
                resources2 = gvVar.f9150n3;
            } else {
                resources2 = null;
            }
            this.f9150n3 = resources2;
            if (gvVar != null) {
                i = gvVar.f9166zn;
            } else {
                i = 0;
            }
            int a2 = n3.a(resources, i);
            this.f9166zn = a2;
            if (gvVar != null) {
                this.f9144gv = gvVar.f9144gv;
                this.f9159v = gvVar.f9159v;
                this.f9162x4 = true;
                this.f9145i4 = true;
                this.f9135c5 = gvVar.f9135c5;
                this.f9155t = gvVar.f9155t;
                this.f9141f3 = gvVar.f9141f3;
                this.f9149n = gvVar.f9149n;
                this.f9134c = gvVar.f9134c;
                this.f9138d0 = gvVar.f9138d0;
                this.f9143fh = gvVar.f9143fh;
                this.f9153rz = gvVar.f9153rz;
                this.f9147mg = gvVar.f9147mg;
                this.f9156ta = gvVar.f9156ta;
                this.f9137d = gvVar.f9137d;
                this.f9165z6 = gvVar.f9165z6;
                this.f9139ej = gvVar.f9139ej;
                this.f9158ud = gvVar.f9158ud;
                if (gvVar.f9166zn == a2) {
                    if (gvVar.f9146i9) {
                        this.f9140f = gvVar.f9140f != null ? new Rect(gvVar.f9140f) : null;
                        this.f9146i9 = true;
                    }
                    if (gvVar.f9157tl) {
                        this.f9161wz = gvVar.f9161wz;
                        this.f9163xc = gvVar.f9163xc;
                        this.f9160w = gvVar.f9160w;
                        this.f9151p = gvVar.f9151p;
                        this.f9157tl = true;
                    }
                }
                if (gvVar.f9148mt) {
                    this.f9136co = gvVar.f9136co;
                    this.f9148mt = true;
                }
                if (gvVar.f9164z) {
                    this.f9152r = gvVar.f9152r;
                    this.f9164z = true;
                }
                Drawable[] drawableArr = gvVar.f9142fb;
                this.f9142fb = new Drawable[drawableArr.length];
                this.f9154s = gvVar.f9154s;
                SparseArray<Drawable.ConstantState> sparseArray = gvVar.f9133a;
                if (sparseArray != null) {
                    this.f9133a = sparseArray.clone();
                } else {
                    this.f9133a = new SparseArray<>(this.f9154s);
                }
                int i5 = this.f9154s;
                for (int i6 = 0; i6 < i5; i6++) {
                    Drawable drawable = drawableArr[i6];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.f9133a.put(i6, constantState);
                        } else {
                            this.f9142fb[i6] = drawableArr[i6];
                        }
                    }
                }
                return;
            }
            this.f9142fb = new Drawable[10];
            this.f9154s = 0;
        }

        public final int a() {
            return this.f9142fb.length;
        }

        public final int c5() {
            if (!this.f9157tl) {
                gv();
            }
            return this.f9163xc;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.f9154s;
            Drawable[] drawableArr = this.f9142fb;
            for (int i5 = 0; i5 < i; i5++) {
                Drawable drawable = drawableArr[i5];
                if (drawable != null) {
                    if (ej.y.n3(drawable)) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.f9133a.get(i5);
                    if (constantState != null && C0114n3.y(constantState)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final Drawable co(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                ej.y.tl(drawable, this.f9134c);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.y);
            return mutate;
        }

        public final int f() {
            if (!this.f9157tl) {
                gv();
            }
            return this.f9160w;
        }

        public final void f3(boolean z2) {
            this.f9135c5 = z2;
        }

        public final Drawable fb(int i) {
            int indexOfKey;
            Drawable drawable = this.f9142fb[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f9133a;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable co2 = co(this.f9133a.valueAt(indexOfKey).newDrawable(this.f9150n3));
            this.f9142fb[i] = co2;
            this.f9133a.removeAt(indexOfKey);
            if (this.f9133a.size() == 0) {
                this.f9133a = null;
            }
            return co2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f9144gv | this.f9159v;
        }

        public void gv() {
            this.f9157tl = true;
            v();
            int i = this.f9154s;
            Drawable[] drawableArr = this.f9142fb;
            this.f9163xc = -1;
            this.f9161wz = -1;
            this.f9151p = 0;
            this.f9160w = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Drawable drawable = drawableArr[i5];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f9161wz) {
                    this.f9161wz = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f9163xc) {
                    this.f9163xc = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f9160w) {
                    this.f9160w = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f9151p) {
                    this.f9151p = minimumHeight;
                }
            }
        }

        public final boolean i4(int i, int i5) {
            boolean z2;
            int i6 = this.f9154s;
            Drawable[] drawableArr = this.f9142fb;
            boolean z3 = false;
            for (int i8 = 0; i8 < i6; i8++) {
                Drawable drawable = drawableArr[i8];
                if (drawable != null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        z2 = ej.y.tl(drawable, i);
                    } else {
                        z2 = false;
                    }
                    if (i8 == i5) {
                        z3 = z2;
                    }
                }
            }
            this.f9134c = i;
            return z3;
        }

        public final int i9() {
            if (!this.f9157tl) {
                gv();
            }
            return this.f9151p;
        }

        public abstract void mt();

        public final void n(Resources resources) {
            if (resources != null) {
                this.f9150n3 = resources;
                int a2 = n3.a(resources, this.f9166zn);
                int i = this.f9166zn;
                this.f9166zn = a2;
                if (i != a2) {
                    this.f9157tl = false;
                    this.f9146i9 = false;
                }
            }
        }

        public final void n3(Resources.Theme theme) {
            if (theme != null) {
                v();
                int i = this.f9154s;
                Drawable[] drawableArr = this.f9142fb;
                for (int i5 = 0; i5 < i; i5++) {
                    Drawable drawable = drawableArr[i5];
                    if (drawable != null && ej.y.n3(drawable)) {
                        ej.y.y(drawableArr[i5], theme);
                        this.f9159v |= drawableArr[i5].getChangingConfigurations();
                    }
                }
                n(C0114n3.zn(theme));
            }
        }

        public final boolean p() {
            return this.f9155t;
        }

        public final void r(int i) {
            this.f9138d0 = i;
        }

        public final int s() {
            return this.f9154s;
        }

        public final Rect t() {
            Rect rect = null;
            if (this.f9135c5) {
                return null;
            }
            Rect rect2 = this.f9140f;
            if (rect2 == null && !this.f9146i9) {
                v();
                Rect rect3 = new Rect();
                int i = this.f9154s;
                Drawable[] drawableArr = this.f9142fb;
                for (int i5 = 0; i5 < i; i5++) {
                    if (drawableArr[i5].getPadding(rect3)) {
                        if (rect == null) {
                            rect = new Rect(0, 0, 0, 0);
                        }
                        int i6 = rect3.left;
                        if (i6 > rect.left) {
                            rect.left = i6;
                        }
                        int i8 = rect3.top;
                        if (i8 > rect.top) {
                            rect.top = i8;
                        }
                        int i10 = rect3.right;
                        if (i10 > rect.right) {
                            rect.right = i10;
                        }
                        int i11 = rect3.bottom;
                        if (i11 > rect.bottom) {
                            rect.bottom = i11;
                        }
                    }
                }
                this.f9146i9 = true;
                this.f9140f = rect;
                return rect;
            }
            return rect2;
        }

        public final int tl() {
            if (!this.f9157tl) {
                gv();
            }
            return this.f9161wz;
        }

        public final void v() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f9133a;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.f9142fb[this.f9133a.keyAt(i)] = co(this.f9133a.valueAt(i).newDrawable(this.f9150n3));
                }
                this.f9133a = null;
            }
        }

        public void w() {
            this.f9148mt = false;
            this.f9164z = false;
        }

        public final int wz() {
            int i;
            if (this.f9148mt) {
                return this.f9136co;
            }
            v();
            int i5 = this.f9154s;
            Drawable[] drawableArr = this.f9142fb;
            if (i5 > 0) {
                i = drawableArr[0].getOpacity();
            } else {
                i = -2;
            }
            for (int i6 = 1; i6 < i5; i6++) {
                i = Drawable.resolveOpacity(i, drawableArr[i6].getOpacity());
            }
            this.f9136co = i;
            this.f9148mt = true;
            return i;
        }

        public final void x4(int i) {
            this.f9143fh = i;
        }

        public void xc(int i, int i5) {
            Drawable[] drawableArr = new Drawable[i5];
            Drawable[] drawableArr2 = this.f9142fb;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i);
            }
            this.f9142fb = drawableArr;
        }

        public final int y(Drawable drawable) {
            int i = this.f9154s;
            if (i >= this.f9142fb.length) {
                xc(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.y);
            this.f9142fb[i] = drawable;
            this.f9154s++;
            this.f9159v = drawable.getChangingConfigurations() | this.f9159v;
            w();
            this.f9140f = null;
            this.f9146i9 = false;
            this.f9157tl = false;
            this.f9162x4 = false;
            return i;
        }

        public final void z(boolean z2) {
            this.f9155t = z2;
        }

        public boolean zn() {
            if (this.f9162x4) {
                return this.f9145i4;
            }
            v();
            this.f9162x4 = true;
            int i = this.f9154s;
            Drawable[] drawableArr = this.f9142fb;
            for (int i5 = 0; i5 < i; i5++) {
                if (drawableArr[i5].getConstantState() == null) {
                    this.f9145i4 = false;
                    return false;
                }
            }
            this.f9145i4 = true;
            return true;
        }
    }

    /* renamed from: i9.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0114n3 {
        public static void n3(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static boolean y(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static Resources zn(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n3.this.y(true);
            n3.this.invalidateSelf();
        }
    }

    public static int a(@Nullable Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(@NonNull Resources.Theme theme) {
        this.y.n3(theme);
    }

    public final void c5(Resources resources) {
        this.y.n(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.y.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.f9125fb;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f9128s;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean fb(int r10) {
        /*
            r9 = this;
            int r0 = r9.f9131w
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            i9.n3$gv r0 = r9.y
            int r0 = r0.f9143fh
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f9128s
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f9125fb
            if (r0 == 0) goto L29
            r9.f9128s = r0
            i9.n3$gv r0 = r9.y
            int r0 = r0.f9143fh
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f9127r = r0
            goto L35
        L29:
            r9.f9128s = r4
            r9.f9127r = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f9125fb
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            i9.n3$gv r0 = r9.y
            int r1 = r0.f9154s
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.fb(r10)
            r9.f9125fb = r0
            r9.f9131w = r10
            if (r0 == 0) goto L5a
            i9.n3$gv r10 = r9.y
            int r10 = r10.f9138d0
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f9132z = r2
        L51:
            r9.gv(r0)
            goto L5a
        L55:
            r9.f9125fb = r4
            r10 = -1
            r9.f9131w = r10
        L5a:
            long r0 = r9.f9132z
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.f9127r
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L79
        L67:
            java.lang.Runnable r0 = r9.f9122co
            if (r0 != 0) goto L73
            i9.n3$y r0 = new i9.n3$y
            r0.<init>()
            r9.f9122co = r0
            goto L76
        L73:
            r9.unscheduleSelf(r0)
        L76:
            r9.y(r10)
        L79:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.n3.fb(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f9123f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.y.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.y.zn()) {
            this.y.f9144gv = getChangingConfigurations();
            return this.y;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f9125fb;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@NonNull Rect rect) {
        Rect rect2 = this.f9130v;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.y.p()) {
            return this.y.c5();
        }
        Drawable drawable = this.f9125fb;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.y.p()) {
            return this.y.tl();
        }
        Drawable drawable = this.f9125fb;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.y.p()) {
            return this.y.i9();
        }
        Drawable drawable = this.f9125fb;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.y.p()) {
            return this.y.f();
        }
        Drawable drawable = this.f9125fb;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f9125fb;
        if (drawable != null && drawable.isVisible()) {
            return this.y.wz();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable = this.f9125fb;
        if (drawable != null) {
            C0114n3.n3(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        boolean padding;
        Rect t2 = this.y.t();
        if (t2 != null) {
            rect.set(t2);
            if ((t2.right | t2.left | t2.top | t2.bottom) != 0) {
                padding = true;
            } else {
                padding = false;
            }
        } else {
            Drawable drawable = this.f9125fb;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (v()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    public final void gv(Drawable drawable) {
        if (this.f9124f3 == null) {
            this.f9124f3 = new zn();
        }
        drawable.setCallback(this.f9124f3.n3(drawable.getCallback()));
        try {
            if (this.y.f9138d0 <= 0 && this.f9129t) {
                drawable.setAlpha(this.f9123f);
            }
            gv gvVar = this.y;
            if (gvVar.f9156ta) {
                drawable.setColorFilter(gvVar.f9147mg);
            } else {
                if (gvVar.f9139ej) {
                    ej.y.xc(drawable, gvVar.f9137d);
                }
                gv gvVar2 = this.y;
                if (gvVar2.f9158ud) {
                    ej.y.w(drawable, gvVar2.f9165z6);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.y.f9141f3);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                ej.y.tl(drawable, ej.y.a(this));
            }
            ej.y.i9(drawable, this.y.f9153rz);
            Rect rect = this.f9130v;
            if (rect != null) {
                ej.y.t(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            drawable.setCallback(this.f9124f3.y());
        } catch (Throwable th) {
            drawable.setCallback(this.f9124f3.y());
            throw th;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        gv gvVar = this.y;
        if (gvVar != null) {
            gvVar.w();
        }
        if (drawable == this.f9125fb && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.y.f9153rz;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z2;
        Drawable drawable = this.f9128s;
        boolean z3 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f9128s = null;
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable2 = this.f9125fb;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f9129t) {
                this.f9125fb.setAlpha(this.f9123f);
            }
        }
        if (this.f9127r != 0) {
            this.f9127r = 0L;
            z2 = true;
        }
        if (this.f9132z != 0) {
            this.f9132z = 0L;
        } else {
            z3 = z2;
        }
        if (z3) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f9126p && super.mutate() == this) {
            gv n32 = n3();
            n32.mt();
            s(n32);
            this.f9126p = true;
        }
        return this;
    }

    public gv n3() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f9128s;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f9125fb;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.y.i4(i, zn());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f9128s;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f9125fb;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f9128s;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f9125fb;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void s(gv gvVar) {
        this.y = gvVar;
        int i = this.f9131w;
        if (i >= 0) {
            Drawable fb2 = gvVar.fb(i);
            this.f9125fb = fb2;
            if (fb2 != null) {
                gv(fb2);
            }
        }
        this.f9128s = null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        if (drawable == this.f9125fb && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (!this.f9129t || this.f9123f != i) {
            this.f9129t = true;
            this.f9123f = i;
            Drawable drawable = this.f9125fb;
            if (drawable != null) {
                if (this.f9132z == 0) {
                    drawable.setAlpha(i);
                } else {
                    y(false);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        gv gvVar = this.y;
        if (gvVar.f9153rz != z2) {
            gvVar.f9153rz = z2;
            Drawable drawable = this.f9125fb;
            if (drawable != null) {
                ej.y.i9(drawable, z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        gv gvVar = this.y;
        gvVar.f9156ta = true;
        if (gvVar.f9147mg != colorFilter) {
            gvVar.f9147mg = colorFilter;
            Drawable drawable = this.f9125fb;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        gv gvVar = this.y;
        if (gvVar.f9141f3 != z2) {
            gvVar.f9141f3 = z2;
            Drawable drawable = this.f9125fb;
            if (drawable != null) {
                drawable.setDither(z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f4, float f6) {
        Drawable drawable = this.f9125fb;
        if (drawable != null) {
            ej.y.f(drawable, f4, f6);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i5, int i6, int i8) {
        Rect rect = this.f9130v;
        if (rect == null) {
            this.f9130v = new Rect(i, i5, i6, i8);
        } else {
            rect.set(i, i5, i6, i8);
        }
        Drawable drawable = this.f9125fb;
        if (drawable != null) {
            ej.y.t(drawable, i, i5, i6, i8);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        gv gvVar = this.y;
        gvVar.f9139ej = true;
        if (gvVar.f9137d != colorStateList) {
            gvVar.f9137d = colorStateList;
            ej.y.xc(this.f9125fb, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        gv gvVar = this.y;
        gvVar.f9158ud = true;
        if (gvVar.f9165z6 != mode) {
            gvVar.f9165z6 = mode;
            ej.y.w(this.f9125fb, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Drawable drawable = this.f9128s;
        if (drawable != null) {
            drawable.setVisible(z2, z3);
        }
        Drawable drawable2 = this.f9125fb;
        if (drawable2 != null) {
            drawable2.setVisible(z2, z3);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        if (drawable == this.f9125fb && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    public final boolean v() {
        if (isAutoMirrored() && ej.y.a(this) == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f9129t = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f9125fb
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L38
            long r9 = r13.f9132z
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f9123f
            r3.setAlpha(r9)
            r13.f9132z = r6
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            i9.n3$gv r9 = r13.y
            int r9 = r9.f9138d0
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f9123f
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.f9132z = r6
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f9128s
            if (r9 == 0) goto L65
            long r10 = r13.f9127r
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r8, r8)
            r0 = 0
            r13.f9128s = r0
            r13.f9127r = r6
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            i9.n3$gv r4 = r13.y
            int r4 = r4.f9143fh
            int r3 = r3 / r4
            int r4 = r13.f9123f
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.f9127r = r6
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            java.lang.Runnable r14 = r13.f9122co
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.n3.y(boolean):void");
    }

    public int zn() {
        return this.f9131w;
    }

    /* loaded from: classes.dex */
    public static class zn implements Drawable.Callback {
        public Drawable.Callback y;

        public zn n3(Drawable.Callback callback) {
            this.y = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
            Drawable.Callback callback = this.y;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            Drawable.Callback callback = this.y;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        public Drawable.Callback y() {
            Drawable.Callback callback = this.y;
            this.y = null;
            return callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
        }
    }
}
