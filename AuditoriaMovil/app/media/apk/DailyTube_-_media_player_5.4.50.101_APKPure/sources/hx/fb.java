package hx;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import hx.f;
import hx.t;
import hx.tl;
import java.util.BitSet;
/* loaded from: classes.dex */
public class fb extends Drawable implements ej.a, wz {

    /* renamed from: j  reason: collision with root package name */
    public static final Paint f9031j = new Paint(1);

    /* renamed from: o  reason: collision with root package name */
    public static final String f9032o = "fb";
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public PorterDuffColorFilter f9033b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f9034c;

    /* renamed from: co  reason: collision with root package name */
    public final RectF f9035co;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final t.n3 f9036d;

    /* renamed from: d0  reason: collision with root package name */
    public final Paint f9037d0;

    /* renamed from: ej  reason: collision with root package name */
    public final t f9038ej;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9039f;

    /* renamed from: f3  reason: collision with root package name */
    public final Region f9040f3;

    /* renamed from: fb  reason: collision with root package name */
    public final tl.fb[] f9041fb;

    /* renamed from: fh  reason: collision with root package name */
    public final os.y f9042fh;
    @NonNull

    /* renamed from: j5  reason: collision with root package name */
    public final RectF f9043j5;

    /* renamed from: n  reason: collision with root package name */
    public f f9044n;

    /* renamed from: p  reason: collision with root package name */
    public final Path f9045p;

    /* renamed from: qn  reason: collision with root package name */
    public boolean f9046qn;

    /* renamed from: r  reason: collision with root package name */
    public final Region f9047r;

    /* renamed from: s  reason: collision with root package name */
    public final BitSet f9048s;

    /* renamed from: t  reason: collision with root package name */
    public final Matrix f9049t;

    /* renamed from: v  reason: collision with root package name */
    public final tl.fb[] f9050v;

    /* renamed from: w  reason: collision with root package name */
    public final Path f9051w;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    public PorterDuffColorFilter f9052x;
    public zn y;

    /* renamed from: z  reason: collision with root package name */
    public final RectF f9053z;

    /* loaded from: classes.dex */
    public class n3 implements f.zn {
        public final /* synthetic */ float y;

        public n3(float f4) {
            this.y = f4;
        }

        @Override // hx.f.zn
        @NonNull
        public hx.zn y(@NonNull hx.zn znVar) {
            if (!(znVar instanceof c5)) {
                return new hx.n3(this.y, znVar);
            }
            return znVar;
        }
    }

    /* loaded from: classes.dex */
    public class y implements t.n3 {
        public y() {
        }

        @Override // hx.t.n3
        public void n3(@NonNull tl tlVar, Matrix matrix, int i) {
            fb.this.f9048s.set(i, tlVar.v());
            fb.this.f9050v[i] = tlVar.a(matrix);
        }

        @Override // hx.t.n3
        public void y(@NonNull tl tlVar, Matrix matrix, int i) {
            fb.this.f9048s.set(i + 4, tlVar.v());
            fb.this.f9041fb[i] = tlVar.a(matrix);
        }
    }

    public /* synthetic */ fb(zn znVar, y yVar) {
        this(znVar);
    }

    public static int qn(int i, int i5) {
        return (i * (i5 + (i5 >>> 7))) >>> 8;
    }

    @NonNull
    public static fb tl(Context context, float f4) {
        int zn2 = td.y.zn(context, R$attr.uh, fb.class.getSimpleName());
        fb fbVar = new fb();
        fbVar.k5(context);
        fbVar.k(ColorStateList.valueOf(zn2));
        fbVar.q9(f4);
        return fbVar;
    }

    @Nullable
    public final PorterDuffColorFilter a(@NonNull Paint paint, boolean z2) {
        int color;
        int t2;
        if (z2 && (t2 = t((color = paint.getColor()))) != color) {
            return new PorterDuffColorFilter(t2, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    public final boolean a8() {
        zn znVar = this.y;
        int i = znVar.f9064p;
        if (i != 1 && znVar.f9062mt > 0 && (i == 2 || j())) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        Paint.Style style = this.y.f9072x4;
        if ((style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f9037d0.getStrokeWidth() > 0.0f) {
            return true;
        }
        return false;
    }

    public int c() {
        zn znVar = this.y;
        return (int) (znVar.f9057co * Math.sin(Math.toRadians(znVar.f9074z)));
    }

    public final void c5() {
        f n2 = rz().n(new n3(-mg()));
        this.f9044n = n2;
        this.f9038ej.gv(n2, this.y.f9058f, x4(), this.f9045p);
    }

    public float co() {
        return this.y.y.i9().y(r());
    }

    public void ct(float f4) {
        this.y.f9067t = f4;
        invalidateSelf();
    }

    public float d() {
        return this.y.y.mt().y(r());
    }

    public int d0() {
        zn znVar = this.y;
        return (int) (znVar.f9057co * Math.cos(Math.toRadians(znVar.f9074z)));
    }

    public void dm(@Nullable ColorStateList colorStateList) {
        zn znVar = this.y;
        if (znVar.f9069v != colorStateList) {
            znVar.f9069v = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f9034c.setColorFilter(this.f9052x);
        int alpha = this.f9034c.getAlpha();
        this.f9034c.setAlpha(qn(alpha, this.y.f9068tl));
        this.f9037d0.setColorFilter(this.f9033b);
        this.f9037d0.setStrokeWidth(this.y.f9067t);
        int alpha2 = this.f9037d0.getAlpha();
        this.f9037d0.setAlpha(qn(alpha2, this.y.f9068tl));
        if (this.f9039f) {
            c5();
            fb(r(), this.f9051w);
            this.f9039f = false;
        }
        j5(canvas);
        if (x()) {
            xc(canvas);
        }
        if (b()) {
            mt(canvas);
        }
        this.f9034c.setAlpha(alpha);
        this.f9037d0.setAlpha(alpha2);
    }

    public final void eb() {
        float ud2 = ud();
        this.y.f9062mt = (int) Math.ceil(0.75f * ud2);
        this.y.f9057co = (int) Math.ceil(ud2 * 0.25f);
        rs();
        yt();
    }

    public float ej() {
        return this.y.f9070w;
    }

    public void en(int i, int i5, int i6, int i8) {
        zn znVar = this.y;
        if (znVar.f9056c5 == null) {
            znVar.f9056c5 = new Rect();
        }
        this.y.f9056c5.set(i, i5, i6, i8);
        invalidateSelf();
    }

    @NonNull
    public final PorterDuffColorFilter f(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z2) {
        if (colorStateList != null && mode != null) {
            return i9(colorStateList, mode, z2);
        }
        return a(paint, z2);
    }

    @Nullable
    public ColorStateList f3() {
        return this.y.f9060gv;
    }

    public void f7(float f4) {
        zn znVar = this.y;
        if (znVar.f9058f != f4) {
            znVar.f9058f = f4;
            this.f9039f = true;
            invalidateSelf();
        }
    }

    public final void fb(@NonNull RectF rectF, @NonNull Path path) {
        s(rectF, path);
        if (this.y.f9061i9 != 1.0f) {
            this.f9049t.reset();
            Matrix matrix = this.f9049t;
            float f4 = this.y.f9061i9;
            matrix.setScale(f4, f4, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f9049t);
        }
        path.computeBounds(this.f9043j5, true);
    }

    public int fh() {
        return this.y.f9062mt;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.y;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.y.f9064p == 2) {
            return;
        }
        if (hw()) {
            outline.setRoundRect(getBounds(), d() * this.y.f9058f);
            return;
        }
        fb(r(), this.f9051w);
        if (this.f9051w.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f9051w);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.y.f9056c5;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f9047r.set(getBounds());
        fb(r(), this.f9051w);
        this.f9040f3.setPath(this.f9051w, this.f9047r);
        this.f9047r.op(this.f9040f3, Region.Op.DIFFERENCE);
        return this.f9047r;
    }

    public boolean hw() {
        return this.y.y.r(r());
    }

    public float i4() {
        return this.y.f9073xc;
    }

    @NonNull
    public final PorterDuffColorFilter i9(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z2) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z2) {
            colorForState = t(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f9039f = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        if (!super.isStateful() && (((colorStateList = this.y.f9059fb) == null || !colorStateList.isStateful()) && (((colorStateList2 = this.y.f9055a) == null || !colorStateList2.isStateful()) && (((colorStateList3 = this.y.f9069v) == null || !colorStateList3.isStateful()) && ((colorStateList4 = this.y.f9060gv) == null || !colorStateList4.isStateful()))))) {
            return false;
        }
        return true;
    }

    public boolean j() {
        int i = Build.VERSION.SDK_INT;
        if (!hw() && !this.f9051w.isConvex() && i < 29) {
            return true;
        }
        return false;
    }

    public final void j5(@NonNull Canvas canvas) {
        if (!a8()) {
            return;
        }
        canvas.save();
        o(canvas);
        if (!this.f9046qn) {
            wz(canvas);
            canvas.restore();
            return;
        }
        int width = (int) (this.f9043j5.width() - getBounds().width());
        int height = (int) (this.f9043j5.height() - getBounds().height());
        if (width >= 0 && height >= 0) {
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.f9043j5.width()) + (this.y.f9062mt * 2) + width, ((int) this.f9043j5.height()) + (this.y.f9062mt * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f4 = (getBounds().left - this.y.f9062mt) - width;
            float f6 = (getBounds().top - this.y.f9062mt) - height;
            canvas2.translate(-f4, -f6);
            wz(canvas2);
            canvas.drawBitmap(createBitmap, f4, f6, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
            return;
        }
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    public void jz(Paint.Style style) {
        this.y.f9072x4 = style;
        yt();
    }

    public void k(@Nullable ColorStateList colorStateList) {
        zn znVar = this.y;
        if (znVar.f9060gv != colorStateList) {
            znVar.f9060gv = colorStateList;
            onStateChange(getState());
        }
    }

    public void k5(Context context) {
        this.y.f9063n3 = new jh.y(context);
        eb();
    }

    public final float mg() {
        if (b()) {
            return this.f9037d0.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public final void mt(@NonNull Canvas canvas) {
        p(canvas, this.f9037d0, this.f9045p, this.f9044n, x4());
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.y = new zn(this.y);
        return this;
    }

    public float n() {
        return this.y.f9071wz;
    }

    public final void o(@NonNull Canvas canvas) {
        canvas.translate(c(), d0());
    }

    public final boolean o4(int[] iArr) {
        boolean z2;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.y.f9060gv != null && color2 != (colorForState2 = this.y.f9060gv.getColorForState(iArr, (color2 = this.f9034c.getColor())))) {
            this.f9034c.setColor(colorForState2);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.y.f9069v != null && color != (colorForState = this.y.f9069v.getColorForState(iArr, (color = this.f9037d0.getColor())))) {
            this.f9037d0.setColor(colorForState);
            return true;
        }
        return z2;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f9039f = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, ur.s.n3
    public boolean onStateChange(int[] iArr) {
        boolean z2;
        boolean o42 = o4(iArr);
        boolean rs2 = rs();
        if (!o42 && !rs2) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    public void oz(float f4) {
        setShapeAppearanceModel(this.y.y.i4(f4));
    }

    public final void p(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull f fVar, @NonNull RectF rectF) {
        if (fVar.r(rectF)) {
            float y2 = fVar.z().y(rectF) * this.y.f9058f;
            canvas.drawRoundRect(rectF, y2, y2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    public void q9(float f4) {
        zn znVar = this.y;
        if (znVar.f9073xc != f4) {
            znVar.f9073xc = f4;
            eb();
        }
    }

    @NonNull
    public RectF r() {
        this.f9035co.set(getBounds());
        return this.f9035co;
    }

    public final boolean rs() {
        PorterDuffColorFilter porterDuffColorFilter = this.f9052x;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f9033b;
        zn znVar = this.y;
        this.f9052x = f(znVar.f9059fb, znVar.f9066s, this.f9034c, true);
        zn znVar2 = this.y;
        this.f9033b = f(znVar2.f9055a, znVar2.f9066s, this.f9037d0, false);
        zn znVar3 = this.y;
        if (znVar3.f9065r) {
            this.f9042fh.gv(znVar3.f9059fb.getColorForState(getState(), 0));
        }
        if (!vl.zn.y(porterDuffColorFilter, this.f9052x) || !vl.zn.y(porterDuffColorFilter2, this.f9033b)) {
            return true;
        }
        return false;
    }

    @NonNull
    public f rz() {
        return this.y.y;
    }

    public final void s(@NonNull RectF rectF, @NonNull Path path) {
        t tVar = this.f9038ej;
        zn znVar = this.y;
        tVar.v(znVar.y, znVar.f9058f, rectF, this.f9036d, path);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        zn znVar = this.y;
        if (znVar.f9068tl != i) {
            znVar.f9068tl = i;
            yt();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.y.f9075zn = colorFilter;
        yt();
    }

    @Override // hx.wz
    public void setShapeAppearanceModel(@NonNull f fVar) {
        this.y.y = fVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.y.f9059fb = colorStateList;
        rs();
        yt();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        zn znVar = this.y;
        if (znVar.f9066s != mode) {
            znVar.f9066s = mode;
            rs();
            yt();
        }
    }

    public int t(int i) {
        float ud2 = ud() + n();
        jh.y yVar = this.y.f9063n3;
        if (yVar != null) {
            return yVar.zn(i, ud2);
        }
        return i;
    }

    @Nullable
    public ColorStateList ta() {
        return this.y.f9059fb;
    }

    public void u(float f4) {
        zn znVar = this.y;
        if (znVar.f9071wz != f4) {
            znVar.f9071wz = f4;
            eb();
        }
    }

    public float ud() {
        return i4() + ej();
    }

    public void ut(@NonNull hx.zn znVar) {
        setShapeAppearanceModel(this.y.y.f3(znVar));
    }

    public boolean vl() {
        jh.y yVar = this.y.f9063n3;
        if (yVar != null && yVar.gv()) {
            return true;
        }
        return false;
    }

    public void w(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        p(canvas, paint, path, this.y.y, rectF);
    }

    public final void wz(@NonNull Canvas canvas) {
        if (this.f9048s.cardinality() > 0) {
            Log.w(f9032o, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.y.f9057co != 0) {
            canvas.drawPath(this.f9051w, this.f9042fh.zn());
        }
        for (int i = 0; i < 4; i++) {
            this.f9050v[i].n3(this.f9042fh, this.y.f9062mt, canvas);
            this.f9041fb[i].n3(this.f9042fh, this.y.f9062mt, canvas);
        }
        if (this.f9046qn) {
            int c2 = c();
            int d02 = d0();
            canvas.translate(-c2, -d02);
            canvas.drawPath(this.f9051w, f9031j);
            canvas.translate(c2, d02);
        }
    }

    public final boolean x() {
        Paint.Style style = this.y.f9072x4;
        if (style != Paint.Style.FILL_AND_STROKE && style != Paint.Style.FILL) {
            return false;
        }
        return true;
    }

    @NonNull
    public final RectF x4() {
        this.f9053z.set(r());
        float mg2 = mg();
        this.f9053z.inset(mg2, mg2);
        return this.f9053z;
    }

    public final void xc(@NonNull Canvas canvas) {
        p(canvas, this.f9034c, this.f9051w, this.y.y, r());
    }

    public void xg(float f4, @Nullable ColorStateList colorStateList) {
        ct(f4);
        dm(colorStateList);
    }

    public void y5(float f4, int i) {
        ct(f4);
        dm(ColorStateList.valueOf(i));
    }

    public final void yt() {
        super.invalidateSelf();
    }

    public float z() {
        return this.y.y.t().y(r());
    }

    public float z6() {
        return this.y.y.z().y(r());
    }

    public fb() {
        this(new f());
    }

    public fb(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i5) {
        this(f.v(context, attributeSet, i, i5).tl());
    }

    public fb(@NonNull f fVar) {
        this(new zn(fVar, null));
    }

    public fb(@NonNull zn znVar) {
        this.f9050v = new tl.fb[4];
        this.f9041fb = new tl.fb[4];
        this.f9048s = new BitSet(8);
        this.f9049t = new Matrix();
        this.f9051w = new Path();
        this.f9045p = new Path();
        this.f9035co = new RectF();
        this.f9053z = new RectF();
        this.f9047r = new Region();
        this.f9040f3 = new Region();
        Paint paint = new Paint(1);
        this.f9034c = paint;
        Paint paint2 = new Paint(1);
        this.f9037d0 = paint2;
        this.f9042fh = new os.y();
        this.f9038ej = Looper.getMainLooper().getThread() == Thread.currentThread() ? t.f() : new t();
        this.f9043j5 = new RectF();
        this.f9046qn = true;
        this.y = znVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = f9031j;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        rs();
        o4(getState());
        this.f9036d = new y();
    }

    /* loaded from: classes.dex */
    public static final class zn extends Drawable.ConstantState {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public ColorStateList f9055a;
        @Nullable

        /* renamed from: c5  reason: collision with root package name */
        public Rect f9056c5;

        /* renamed from: co  reason: collision with root package name */
        public int f9057co;

        /* renamed from: f  reason: collision with root package name */
        public float f9058f;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public ColorStateList f9059fb;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public ColorStateList f9060gv;

        /* renamed from: i9  reason: collision with root package name */
        public float f9061i9;

        /* renamed from: mt  reason: collision with root package name */
        public int f9062mt;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public jh.y f9063n3;

        /* renamed from: p  reason: collision with root package name */
        public int f9064p;

        /* renamed from: r  reason: collision with root package name */
        public boolean f9065r;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public PorterDuff.Mode f9066s;

        /* renamed from: t  reason: collision with root package name */
        public float f9067t;

        /* renamed from: tl  reason: collision with root package name */
        public int f9068tl;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public ColorStateList f9069v;

        /* renamed from: w  reason: collision with root package name */
        public float f9070w;

        /* renamed from: wz  reason: collision with root package name */
        public float f9071wz;

        /* renamed from: x4  reason: collision with root package name */
        public Paint.Style f9072x4;

        /* renamed from: xc  reason: collision with root package name */
        public float f9073xc;
        @NonNull
        public f y;

        /* renamed from: z  reason: collision with root package name */
        public int f9074z;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public ColorFilter f9075zn;

        public zn(f fVar, jh.y yVar) {
            this.f9066s = PorterDuff.Mode.SRC_IN;
            this.f9061i9 = 1.0f;
            this.f9058f = 1.0f;
            this.f9068tl = 255;
            this.f9072x4 = Paint.Style.FILL_AND_STROKE;
            this.y = fVar;
            this.f9063n3 = yVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            fb fbVar = new fb(this, null);
            fbVar.f9039f = true;
            return fbVar;
        }

        public zn(@NonNull zn znVar) {
            this.f9066s = PorterDuff.Mode.SRC_IN;
            this.f9061i9 = 1.0f;
            this.f9058f = 1.0f;
            this.f9068tl = 255;
            this.f9072x4 = Paint.Style.FILL_AND_STROKE;
            this.y = znVar.y;
            this.f9063n3 = znVar.f9063n3;
            this.f9067t = znVar.f9067t;
            this.f9075zn = znVar.f9075zn;
            this.f9060gv = znVar.f9060gv;
            this.f9069v = znVar.f9069v;
            this.f9066s = znVar.f9066s;
            this.f9059fb = znVar.f9059fb;
            this.f9068tl = znVar.f9068tl;
            this.f9061i9 = znVar.f9061i9;
            this.f9057co = znVar.f9057co;
            this.f9064p = znVar.f9064p;
            this.f9065r = znVar.f9065r;
            this.f9058f = znVar.f9058f;
            this.f9071wz = znVar.f9071wz;
            this.f9073xc = znVar.f9073xc;
            this.f9070w = znVar.f9070w;
            this.f9062mt = znVar.f9062mt;
            this.f9074z = znVar.f9074z;
            this.f9055a = znVar.f9055a;
            this.f9072x4 = znVar.f9072x4;
            if (znVar.f9056c5 != null) {
                this.f9056c5 = new Rect(znVar.f9056c5);
            }
        }
    }
}
