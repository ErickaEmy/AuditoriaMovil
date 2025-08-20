package o0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.f;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import z6.zn;
/* loaded from: classes.dex */
public class s extends o0.fb {

    /* renamed from: r  reason: collision with root package name */
    public static final PorterDuff.Mode f12060r = PorterDuff.Mode.SRC_IN;

    /* renamed from: co  reason: collision with root package name */
    public final Matrix f12061co;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12062f;

    /* renamed from: fb  reason: collision with root package name */
    public PorterDuffColorFilter f12063fb;

    /* renamed from: p  reason: collision with root package name */
    public final float[] f12064p;

    /* renamed from: s  reason: collision with root package name */
    public ColorFilter f12065s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f12066t;

    /* renamed from: v  reason: collision with root package name */
    public C0171s f12067v;

    /* renamed from: w  reason: collision with root package name */
    public Drawable.ConstantState f12068w;

    /* renamed from: z  reason: collision with root package name */
    public final Rect f12069z;

    /* loaded from: classes.dex */
    public static abstract class a extends v {

        /* renamed from: gv  reason: collision with root package name */
        public int f12070gv;

        /* renamed from: n3  reason: collision with root package name */
        public String f12071n3;
        public zn.n3[] y;

        /* renamed from: zn  reason: collision with root package name */
        public int f12072zn;

        public a() {
            super();
        }

        public zn.n3[] getPathData() {
            return this.y;
        }

        public String getPathName() {
            return this.f12071n3;
        }

        public void gv(Path path) {
            path.reset();
            zn.n3[] n3VarArr = this.y;
            if (n3VarArr != null) {
                zn.n3.v(n3VarArr, path);
            }
        }

        public void setPathData(zn.n3[] n3VarArr) {
            if (!z6.zn.n3(this.y, n3VarArr)) {
                this.y = z6.zn.a(n3VarArr);
            } else {
                z6.zn.i9(this.y, n3VarArr);
            }
        }

        public boolean zn() {
            return false;
        }

        public a(a aVar) {
            super();
            this.f12071n3 = aVar.f12071n3;
            this.f12070gv = aVar.f12070gv;
            this.y = z6.zn.a(aVar.y);
        }
    }

    /* loaded from: classes.dex */
    public static class n3 extends a {
        public n3() {
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f12071n3 = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.y = z6.zn.gv(string2);
            }
            this.f12072zn = f.fb(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public void v(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (!f.i9(xmlPullParser, "pathData")) {
                return;
            }
            TypedArray f4 = f.f(resources, theme, attributeSet, o0.y.f12128gv);
            a(f4, xmlPullParser);
            f4.recycle();
        }

        @Override // o0.s.a
        public boolean zn() {
            return true;
        }

        public n3(n3 n3Var) {
            super(n3Var);
        }
    }

    /* renamed from: o0.s$s  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0171s extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f12101a;

        /* renamed from: c5  reason: collision with root package name */
        public int f12102c5;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12103f;

        /* renamed from: fb  reason: collision with root package name */
        public ColorStateList f12104fb;

        /* renamed from: gv  reason: collision with root package name */
        public PorterDuff.Mode f12105gv;

        /* renamed from: i9  reason: collision with root package name */
        public boolean f12106i9;

        /* renamed from: n3  reason: collision with root package name */
        public fb f12107n3;

        /* renamed from: s  reason: collision with root package name */
        public PorterDuff.Mode f12108s;

        /* renamed from: t  reason: collision with root package name */
        public Paint f12109t;

        /* renamed from: v  reason: collision with root package name */
        public boolean f12110v;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public ColorStateList f12111zn;

        public C0171s(C0171s c0171s) {
            this.f12105gv = s.f12060r;
            if (c0171s != null) {
                this.y = c0171s.y;
                fb fbVar = new fb(c0171s.f12107n3);
                this.f12107n3 = fbVar;
                if (c0171s.f12107n3.f12084v != null) {
                    fbVar.f12084v = new Paint(c0171s.f12107n3.f12084v);
                }
                if (c0171s.f12107n3.f12078gv != null) {
                    this.f12107n3.f12078gv = new Paint(c0171s.f12107n3.f12078gv);
                }
                this.f12111zn = c0171s.f12111zn;
                this.f12105gv = c0171s.f12105gv;
                this.f12110v = c0171s.f12110v;
            }
        }

        public boolean a() {
            if (this.f12107n3.getRootAlpha() < 255) {
                return true;
            }
            return false;
        }

        public void c5() {
            this.f12104fb = this.f12111zn;
            this.f12108s = this.f12105gv;
            this.f12102c5 = this.f12107n3.getRootAlpha();
            this.f12106i9 = this.f12110v;
            this.f12103f = false;
        }

        public boolean fb() {
            return this.f12107n3.a();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.y;
        }

        public void gv(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f12101a, (Rect) null, rect, v(colorFilter));
        }

        public void i9(int i, int i5) {
            this.f12101a.eraseColor(0);
            this.f12107n3.n3(new Canvas(this.f12101a), i, i5, null);
        }

        public boolean n3() {
            if (!this.f12103f && this.f12104fb == this.f12111zn && this.f12108s == this.f12105gv && this.f12106i9 == this.f12110v && this.f12102c5 == this.f12107n3.getRootAlpha()) {
                return true;
            }
            return false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new s(this);
        }

        public boolean s(int[] iArr) {
            boolean fb2 = this.f12107n3.fb(iArr);
            this.f12103f |= fb2;
            return fb2;
        }

        public Paint v(ColorFilter colorFilter) {
            if (!a() && colorFilter == null) {
                return null;
            }
            if (this.f12109t == null) {
                Paint paint = new Paint();
                this.f12109t = paint;
                paint.setFilterBitmap(true);
            }
            this.f12109t.setAlpha(this.f12107n3.getRootAlpha());
            this.f12109t.setColorFilter(colorFilter);
            return this.f12109t;
        }

        public boolean y(int i, int i5) {
            if (i == this.f12101a.getWidth() && i5 == this.f12101a.getHeight()) {
                return true;
            }
            return false;
        }

        public void zn(int i, int i5) {
            if (this.f12101a == null || !y(i, i5)) {
                this.f12101a = Bitmap.createBitmap(i, i5, Bitmap.Config.ARGB_8888);
                this.f12103f = true;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new s(this);
        }

        public C0171s() {
            this.f12105gv = s.f12060r;
            this.f12107n3 = new fb();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class v {
        public v() {
        }

        public boolean n3(int[] iArr) {
            return false;
        }

        public boolean y() {
            return false;
        }
    }

    public s() {
        this.f12066t = true;
        this.f12064p = new float[9];
        this.f12061co = new Matrix();
        this.f12069z = new Rect();
        this.f12067v = new C0171s();
    }

    public static PorterDuff.Mode fb(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    @Nullable
    public static s n3(@NonNull Resources resources, int i, @Nullable Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            s sVar = new s();
            sVar.y = d.s.v(resources, i, theme);
            sVar.f12068w = new c5(sVar.y.getConstantState());
            return sVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return zn(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static int y(int i, float f4) {
        return (i & 16777215) | (((int) (Color.alpha(i) * f4)) << 24);
    }

    public static s zn(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        s sVar = new s();
        sVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return sVar;
    }

    public final boolean a() {
        if (isAutoMirrored() && ej.y.a(this) == 1) {
            return true;
        }
        return false;
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public final void c5(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        C0171s c0171s = this.f12067v;
        fb fbVar = c0171s.f12107n3;
        c0171s.f12105gv = fb(f.fb(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList zn2 = f.zn(typedArray, xmlPullParser, theme, "tint", 1);
        if (zn2 != null) {
            c0171s.f12111zn = zn2;
        }
        c0171s.f12110v = f.y(typedArray, xmlPullParser, "autoMirrored", 5, c0171s.f12110v);
        fbVar.f12076f = f.a(typedArray, xmlPullParser, "viewportWidth", 7, fbVar.f12076f);
        float a2 = f.a(typedArray, xmlPullParser, "viewportHeight", 8, fbVar.f12082t);
        fbVar.f12082t = a2;
        if (fbVar.f12076f > 0.0f) {
            if (a2 > 0.0f) {
                fbVar.f12075c5 = typedArray.getDimension(3, fbVar.f12075c5);
                float dimension = typedArray.getDimension(2, fbVar.f12079i9);
                fbVar.f12079i9 = dimension;
                if (fbVar.f12075c5 > 0.0f) {
                    if (dimension > 0.0f) {
                        fbVar.setAlpha(f.a(typedArray, xmlPullParser, "alpha", 4, fbVar.getAlpha()));
                        String string = typedArray.getString(0);
                        if (string != null) {
                            fbVar.f12086wz = string;
                            fbVar.f12085w.put(string, fbVar);
                            return;
                        }
                        return;
                    }
                    throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
                }
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            }
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.y;
        if (drawable != null) {
            ej.y.n3(drawable);
            return false;
        }
        return false;
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f12069z);
        if (this.f12069z.width() > 0 && this.f12069z.height() > 0) {
            ColorFilter colorFilter = this.f12065s;
            if (colorFilter == null) {
                colorFilter = this.f12063fb;
            }
            canvas.getMatrix(this.f12061co);
            this.f12061co.getValues(this.f12064p);
            float abs = Math.abs(this.f12064p[0]);
            float abs2 = Math.abs(this.f12064p[4]);
            float abs3 = Math.abs(this.f12064p[1]);
            float abs4 = Math.abs(this.f12064p[3]);
            if (abs3 != 0.0f || abs4 != 0.0f) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (this.f12069z.width() * abs));
            int min2 = Math.min(2048, (int) (this.f12069z.height() * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f12069z;
                canvas.translate(rect.left, rect.top);
                if (a()) {
                    canvas.translate(this.f12069z.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f12069z.offsetTo(0, 0);
                this.f12067v.zn(min, min2);
                if (!this.f12066t) {
                    this.f12067v.i9(min, min2);
                } else if (!this.f12067v.n3()) {
                    this.f12067v.i9(min, min2);
                    this.f12067v.c5();
                }
                this.f12067v.gv(canvas, colorFilter, this.f12069z);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return ej.y.gv(drawable);
        }
        return this.f12067v.f12107n3.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f12067v.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return ej.y.v(drawable);
        }
        return this.f12065s;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.y != null && Build.VERSION.SDK_INT >= 24) {
            return new c5(this.y.getConstantState());
        }
        this.f12067v.y = getChangingConfigurations();
        return this.f12067v;
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f12067v.f12107n3.f12079i9;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f12067v.f12107n3.f12075c5;
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public Object gv(String str) {
        return this.f12067v.f12107n3.f12085w.get(str);
    }

    public PorterDuffColorFilter i9(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return ej.y.s(drawable);
        }
        return this.f12067v.f12110v;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        C0171s c0171s;
        ColorStateList colorStateList;
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful() && ((c0171s = this.f12067v) == null || (!c0171s.fb() && ((colorStateList = this.f12067v.f12111zn) == null || !colorStateList.isStateful())))) {
            return false;
        }
        return true;
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f12062f && super.mutate() == this) {
            this.f12067v = new C0171s(this.f12067v);
            this.f12062f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z2;
        PorterDuff.Mode mode;
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        C0171s c0171s = this.f12067v;
        ColorStateList colorStateList = c0171s.f12111zn;
        if (colorStateList != null && (mode = c0171s.f12105gv) != null) {
            this.f12063fb = i9(this.f12063fb, colorStateList, mode);
            invalidateSelf();
            z2 = true;
        } else {
            z2 = false;
        }
        if (c0171s.fb() && c0171s.s(iArr)) {
            invalidateSelf();
            return true;
        }
        return z2;
    }

    public void s(boolean z2) {
        this.f12066t = z2;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f12067v.f12107n3.getRootAlpha() != i) {
            this.f12067v.f12107n3.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        Drawable drawable = this.y;
        if (drawable != null) {
            ej.y.i9(drawable, z2);
        } else {
            this.f12067v.f12110v = z2;
        }
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z2) {
        super.setFilterBitmap(z2);
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f4, float f6) {
        super.setHotspot(f4, f6);
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i5, int i6, int i8) {
        super.setHotspotBounds(i, i5, i6, i8);
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        Drawable drawable = this.y;
        if (drawable != null) {
            ej.y.wz(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.y;
        if (drawable != null) {
            ej.y.xc(drawable, colorStateList);
            return;
        }
        C0171s c0171s = this.f12067v;
        if (c0171s.f12111zn != colorStateList) {
            c0171s.f12111zn = colorStateList;
            this.f12063fb = i9(this.f12063fb, colorStateList, c0171s.f12105gv);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.y;
        if (drawable != null) {
            ej.y.w(drawable, mode);
            return;
        }
        C0171s c0171s = this.f12067v;
        if (c0171s.f12105gv != mode) {
            c0171s.f12105gv = mode;
            this.f12063fb = i9(this.f12063fb, c0171s.f12111zn, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.setVisible(z2, z3);
        }
        return super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public final void v(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C0171s c0171s = this.f12067v;
        fb fbVar = c0171s.f12107n3;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fbVar.f12081s);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                gv gvVar = (gv) arrayDeque.peek();
                if ("path".equals(name)) {
                    zn znVar = new zn();
                    znVar.fb(resources, attributeSet, theme, xmlPullParser);
                    gvVar.f12095n3.add(znVar);
                    if (znVar.getPathName() != null) {
                        fbVar.f12085w.put(znVar.getPathName(), znVar);
                    }
                    c0171s.y = znVar.f12070gv | c0171s.y;
                    z2 = false;
                } else if ("clip-path".equals(name)) {
                    n3 n3Var = new n3();
                    n3Var.v(resources, attributeSet, theme, xmlPullParser);
                    gvVar.f12095n3.add(n3Var);
                    if (n3Var.getPathName() != null) {
                        fbVar.f12085w.put(n3Var.getPathName(), n3Var);
                    }
                    c0171s.y = n3Var.f12070gv | c0171s.y;
                } else if ("group".equals(name)) {
                    gv gvVar2 = new gv();
                    gvVar2.zn(resources, attributeSet, theme, xmlPullParser);
                    gvVar.f12095n3.add(gvVar2);
                    arrayDeque.push(gvVar2);
                    if (gvVar2.getGroupName() != null) {
                        fbVar.f12085w.put(gvVar2.getGroupName(), gvVar2);
                    }
                    c0171s.y = gvVar2.f12091f | c0171s.y;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (!z2) {
            return;
        }
        throw new XmlPullParserException("no path defined");
    }

    /* loaded from: classes.dex */
    public static class c5 extends Drawable.ConstantState {
        public final Drawable.ConstantState y;

        public c5(Drawable.ConstantState constantState) {
            this.y = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.y.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.y.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            s sVar = new s();
            sVar.y = (VectorDrawable) this.y.newDrawable();
            return sVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            s sVar = new s();
            sVar.y = (VectorDrawable) this.y.newDrawable(resources);
            return sVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            s sVar = new s();
            sVar.y = (VectorDrawable) this.y.newDrawable(resources, theme);
            return sVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f12065s = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.y;
        if (drawable != null) {
            ej.y.fb(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0171s c0171s = this.f12067v;
        c0171s.f12107n3 = new fb();
        TypedArray f4 = f.f(resources, theme, attributeSet, o0.y.y);
        c5(f4, xmlPullParser, theme);
        f4.recycle();
        c0171s.y = getChangingConfigurations();
        c0171s.f12103f = true;
        v(resources, xmlPullParser, attributeSet, theme);
        this.f12063fb = i9(this.f12063fb, c0171s.f12111zn, c0171s.f12105gv);
    }

    /* loaded from: classes.dex */
    public static class zn extends a {

        /* renamed from: a  reason: collision with root package name */
        public d.gv f12112a;

        /* renamed from: c5  reason: collision with root package name */
        public float f12113c5;

        /* renamed from: f  reason: collision with root package name */
        public float f12114f;

        /* renamed from: fb  reason: collision with root package name */
        public float f12115fb;

        /* renamed from: i9  reason: collision with root package name */
        public float f12116i9;

        /* renamed from: s  reason: collision with root package name */
        public d.gv f12117s;

        /* renamed from: t  reason: collision with root package name */
        public float f12118t;

        /* renamed from: tl  reason: collision with root package name */
        public float f12119tl;

        /* renamed from: v  reason: collision with root package name */
        public int[] f12120v;

        /* renamed from: w  reason: collision with root package name */
        public float f12121w;

        /* renamed from: wz  reason: collision with root package name */
        public Paint.Cap f12122wz;

        /* renamed from: xc  reason: collision with root package name */
        public Paint.Join f12123xc;

        public zn() {
            this.f12113c5 = 1.0f;
            this.f12116i9 = 1.0f;
            this.f12118t = 1.0f;
            this.f12122wz = Paint.Cap.BUTT;
            this.f12123xc = Paint.Join.MITER;
            this.f12121w = 4.0f;
        }

        public final Paint.Join a(int i, Paint.Join join) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return join;
                    }
                    return Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        public void fb(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray f4 = f.f(resources, theme, attributeSet, o0.y.f12134zn);
            s(f4, xmlPullParser, theme);
            f4.recycle();
        }

        public float getFillAlpha() {
            return this.f12116i9;
        }

        public int getFillColor() {
            return this.f12117s.v();
        }

        public float getStrokeAlpha() {
            return this.f12113c5;
        }

        public int getStrokeColor() {
            return this.f12112a.v();
        }

        public float getStrokeWidth() {
            return this.f12115fb;
        }

        public float getTrimPathEnd() {
            return this.f12118t;
        }

        public float getTrimPathOffset() {
            return this.f12119tl;
        }

        public float getTrimPathStart() {
            return this.f12114f;
        }

        @Override // o0.s.v
        public boolean n3(int[] iArr) {
            return this.f12112a.i9(iArr) | this.f12117s.i9(iArr);
        }

        public final void s(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f12120v = null;
            if (!f.i9(xmlPullParser, "pathData")) {
                return;
            }
            String string = typedArray.getString(0);
            if (string != null) {
                this.f12071n3 = string;
            }
            String string2 = typedArray.getString(2);
            if (string2 != null) {
                this.y = z6.zn.gv(string2);
            }
            this.f12117s = f.v(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
            this.f12116i9 = f.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f12116i9);
            this.f12122wz = v(f.fb(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f12122wz);
            this.f12123xc = a(f.fb(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f12123xc);
            this.f12121w = f.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f12121w);
            this.f12112a = f.v(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
            this.f12113c5 = f.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f12113c5);
            this.f12115fb = f.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f12115fb);
            this.f12118t = f.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f12118t);
            this.f12119tl = f.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f12119tl);
            this.f12114f = f.a(typedArray, xmlPullParser, "trimPathStart", 5, this.f12114f);
            this.f12072zn = f.fb(typedArray, xmlPullParser, "fillType", 13, this.f12072zn);
        }

        public void setFillAlpha(float f4) {
            this.f12116i9 = f4;
        }

        public void setFillColor(int i) {
            this.f12117s.f(i);
        }

        public void setStrokeAlpha(float f4) {
            this.f12113c5 = f4;
        }

        public void setStrokeColor(int i) {
            this.f12112a.f(i);
        }

        public void setStrokeWidth(float f4) {
            this.f12115fb = f4;
        }

        public void setTrimPathEnd(float f4) {
            this.f12118t = f4;
        }

        public void setTrimPathOffset(float f4) {
            this.f12119tl = f4;
        }

        public void setTrimPathStart(float f4) {
            this.f12114f = f4;
        }

        public final Paint.Cap v(int i, Paint.Cap cap) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return cap;
                    }
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        @Override // o0.s.v
        public boolean y() {
            if (!this.f12117s.c5() && !this.f12112a.c5()) {
                return false;
            }
            return true;
        }

        public zn(zn znVar) {
            super(znVar);
            this.f12113c5 = 1.0f;
            this.f12116i9 = 1.0f;
            this.f12118t = 1.0f;
            this.f12122wz = Paint.Cap.BUTT;
            this.f12123xc = Paint.Join.MITER;
            this.f12121w = 4.0f;
            this.f12120v = znVar.f12120v;
            this.f12112a = znVar.f12112a;
            this.f12115fb = znVar.f12115fb;
            this.f12113c5 = znVar.f12113c5;
            this.f12117s = znVar.f12117s;
            this.f12072zn = znVar.f12072zn;
            this.f12116i9 = znVar.f12116i9;
            this.f12114f = znVar.f12114f;
            this.f12118t = znVar.f12118t;
            this.f12119tl = znVar.f12119tl;
            this.f12122wz = znVar.f12122wz;
            this.f12123xc = znVar.f12123xc;
            this.f12121w = znVar.f12121w;
        }
    }

    public s(@NonNull C0171s c0171s) {
        this.f12066t = true;
        this.f12064p = new float[9];
        this.f12061co = new Matrix();
        this.f12069z = new Rect();
        this.f12067v = c0171s;
        this.f12063fb = i9(this.f12063fb, c0171s.f12111zn, c0171s.f12105gv);
    }

    /* loaded from: classes.dex */
    public static class fb {

        /* renamed from: p  reason: collision with root package name */
        public static final Matrix f12073p = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        public PathMeasure f12074a;

        /* renamed from: c5  reason: collision with root package name */
        public float f12075c5;

        /* renamed from: f  reason: collision with root package name */
        public float f12076f;

        /* renamed from: fb  reason: collision with root package name */
        public int f12077fb;

        /* renamed from: gv  reason: collision with root package name */
        public Paint f12078gv;

        /* renamed from: i9  reason: collision with root package name */
        public float f12079i9;

        /* renamed from: n3  reason: collision with root package name */
        public final Path f12080n3;

        /* renamed from: s  reason: collision with root package name */
        public final gv f12081s;

        /* renamed from: t  reason: collision with root package name */
        public float f12082t;

        /* renamed from: tl  reason: collision with root package name */
        public int f12083tl;

        /* renamed from: v  reason: collision with root package name */
        public Paint f12084v;

        /* renamed from: w  reason: collision with root package name */
        public final z.y<String, Object> f12085w;

        /* renamed from: wz  reason: collision with root package name */
        public String f12086wz;

        /* renamed from: xc  reason: collision with root package name */
        public Boolean f12087xc;
        public final Path y;

        /* renamed from: zn  reason: collision with root package name */
        public final Matrix f12088zn;

        public fb() {
            this.f12088zn = new Matrix();
            this.f12075c5 = 0.0f;
            this.f12079i9 = 0.0f;
            this.f12076f = 0.0f;
            this.f12082t = 0.0f;
            this.f12083tl = 255;
            this.f12086wz = null;
            this.f12087xc = null;
            this.f12085w = new z.y<>();
            this.f12081s = new gv();
            this.y = new Path();
            this.f12080n3 = new Path();
        }

        public static float y(float f4, float f6, float f9, float f10) {
            return (f4 * f10) - (f6 * f9);
        }

        public boolean a() {
            if (this.f12087xc == null) {
                this.f12087xc = Boolean.valueOf(this.f12081s.y());
            }
            return this.f12087xc.booleanValue();
        }

        public boolean fb(int[] iArr) {
            return this.f12081s.n3(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f12083tl;
        }

        public final void gv(gv gvVar, a aVar, Canvas canvas, int i, int i5, ColorFilter colorFilter) {
            Path.FillType fillType;
            Path.FillType fillType2;
            float f4 = i / this.f12076f;
            float f6 = i5 / this.f12082t;
            float min = Math.min(f4, f6);
            Matrix matrix = gvVar.y;
            this.f12088zn.set(matrix);
            this.f12088zn.postScale(f4, f6);
            float v2 = v(matrix);
            if (v2 == 0.0f) {
                return;
            }
            aVar.gv(this.y);
            Path path = this.y;
            this.f12080n3.reset();
            if (aVar.zn()) {
                Path path2 = this.f12080n3;
                if (aVar.f12072zn == 0) {
                    fillType2 = Path.FillType.WINDING;
                } else {
                    fillType2 = Path.FillType.EVEN_ODD;
                }
                path2.setFillType(fillType2);
                this.f12080n3.addPath(path, this.f12088zn);
                canvas.clipPath(this.f12080n3);
                return;
            }
            zn znVar = (zn) aVar;
            float f9 = znVar.f12114f;
            if (f9 != 0.0f || znVar.f12118t != 1.0f) {
                float f10 = znVar.f12119tl;
                float f11 = (f9 + f10) % 1.0f;
                float f12 = (znVar.f12118t + f10) % 1.0f;
                if (this.f12074a == null) {
                    this.f12074a = new PathMeasure();
                }
                this.f12074a.setPath(this.y, false);
                float length = this.f12074a.getLength();
                float f13 = f11 * length;
                float f14 = f12 * length;
                path.reset();
                if (f13 > f14) {
                    this.f12074a.getSegment(f13, length, path, true);
                    this.f12074a.getSegment(0.0f, f14, path, true);
                } else {
                    this.f12074a.getSegment(f13, f14, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f12080n3.addPath(path, this.f12088zn);
            if (znVar.f12117s.t()) {
                d.gv gvVar2 = znVar.f12117s;
                if (this.f12084v == null) {
                    Paint paint = new Paint(1);
                    this.f12084v = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f12084v;
                if (gvVar2.s()) {
                    Shader a2 = gvVar2.a();
                    a2.setLocalMatrix(this.f12088zn);
                    paint2.setShader(a2);
                    paint2.setAlpha(Math.round(znVar.f12116i9 * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(s.y(gvVar2.v(), znVar.f12116i9));
                }
                paint2.setColorFilter(colorFilter);
                Path path3 = this.f12080n3;
                if (znVar.f12072zn == 0) {
                    fillType = Path.FillType.WINDING;
                } else {
                    fillType = Path.FillType.EVEN_ODD;
                }
                path3.setFillType(fillType);
                canvas.drawPath(this.f12080n3, paint2);
            }
            if (znVar.f12112a.t()) {
                d.gv gvVar3 = znVar.f12112a;
                if (this.f12078gv == null) {
                    Paint paint3 = new Paint(1);
                    this.f12078gv = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f12078gv;
                Paint.Join join = znVar.f12123xc;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = znVar.f12122wz;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(znVar.f12121w);
                if (gvVar3.s()) {
                    Shader a3 = gvVar3.a();
                    a3.setLocalMatrix(this.f12088zn);
                    paint4.setShader(a3);
                    paint4.setAlpha(Math.round(znVar.f12113c5 * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(s.y(gvVar3.v(), znVar.f12113c5));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(znVar.f12115fb * min * v2);
                canvas.drawPath(this.f12080n3, paint4);
            }
        }

        public void n3(Canvas canvas, int i, int i5, ColorFilter colorFilter) {
            zn(this.f12081s, f12073p, canvas, i, i5, colorFilter);
        }

        public void setAlpha(float f4) {
            setRootAlpha((int) (f4 * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.f12083tl = i;
        }

        public final float v(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float y = y(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max <= 0.0f) {
                return 0.0f;
            }
            return Math.abs(y) / max;
        }

        public final void zn(gv gvVar, Matrix matrix, Canvas canvas, int i, int i5, ColorFilter colorFilter) {
            gvVar.y.set(matrix);
            gvVar.y.preConcat(gvVar.f12094i9);
            canvas.save();
            for (int i6 = 0; i6 < gvVar.f12095n3.size(); i6++) {
                v vVar = gvVar.f12095n3.get(i6);
                if (vVar instanceof gv) {
                    zn((gv) vVar, gvVar.y, canvas, i, i5, colorFilter);
                } else if (vVar instanceof a) {
                    gv(gvVar, (a) vVar, canvas, i, i5, colorFilter);
                }
            }
            canvas.restore();
        }

        public fb(fb fbVar) {
            this.f12088zn = new Matrix();
            this.f12075c5 = 0.0f;
            this.f12079i9 = 0.0f;
            this.f12076f = 0.0f;
            this.f12082t = 0.0f;
            this.f12083tl = 255;
            this.f12086wz = null;
            this.f12087xc = null;
            z.y<String, Object> yVar = new z.y<>();
            this.f12085w = yVar;
            this.f12081s = new gv(fbVar.f12081s, yVar);
            this.y = new Path(fbVar.y);
            this.f12080n3 = new Path(fbVar.f12080n3);
            this.f12075c5 = fbVar.f12075c5;
            this.f12079i9 = fbVar.f12079i9;
            this.f12076f = fbVar.f12076f;
            this.f12082t = fbVar.f12082t;
            this.f12077fb = fbVar.f12077fb;
            this.f12083tl = fbVar.f12083tl;
            this.f12086wz = fbVar.f12086wz;
            String str = fbVar.f12086wz;
            if (str != null) {
                yVar.put(str, this);
            }
            this.f12087xc = fbVar.f12087xc;
        }
    }

    /* loaded from: classes.dex */
    public static class gv extends v {

        /* renamed from: a  reason: collision with root package name */
        public float f12089a;

        /* renamed from: c5  reason: collision with root package name */
        public float f12090c5;

        /* renamed from: f  reason: collision with root package name */
        public int f12091f;

        /* renamed from: fb  reason: collision with root package name */
        public float f12092fb;

        /* renamed from: gv  reason: collision with root package name */
        public float f12093gv;

        /* renamed from: i9  reason: collision with root package name */
        public final Matrix f12094i9;

        /* renamed from: n3  reason: collision with root package name */
        public final ArrayList<v> f12095n3;

        /* renamed from: s  reason: collision with root package name */
        public float f12096s;

        /* renamed from: t  reason: collision with root package name */
        public int[] f12097t;

        /* renamed from: tl  reason: collision with root package name */
        public String f12098tl;

        /* renamed from: v  reason: collision with root package name */
        public float f12099v;
        public final Matrix y;

        /* renamed from: zn  reason: collision with root package name */
        public float f12100zn;

        public gv(gv gvVar, z.y<String, Object> yVar) {
            super();
            a n3Var;
            this.y = new Matrix();
            this.f12095n3 = new ArrayList<>();
            this.f12100zn = 0.0f;
            this.f12093gv = 0.0f;
            this.f12099v = 0.0f;
            this.f12089a = 1.0f;
            this.f12092fb = 1.0f;
            this.f12096s = 0.0f;
            this.f12090c5 = 0.0f;
            Matrix matrix = new Matrix();
            this.f12094i9 = matrix;
            this.f12098tl = null;
            this.f12100zn = gvVar.f12100zn;
            this.f12093gv = gvVar.f12093gv;
            this.f12099v = gvVar.f12099v;
            this.f12089a = gvVar.f12089a;
            this.f12092fb = gvVar.f12092fb;
            this.f12096s = gvVar.f12096s;
            this.f12090c5 = gvVar.f12090c5;
            this.f12097t = gvVar.f12097t;
            String str = gvVar.f12098tl;
            this.f12098tl = str;
            this.f12091f = gvVar.f12091f;
            if (str != null) {
                yVar.put(str, this);
            }
            matrix.set(gvVar.f12094i9);
            ArrayList<v> arrayList = gvVar.f12095n3;
            for (int i = 0; i < arrayList.size(); i++) {
                v vVar = arrayList.get(i);
                if (vVar instanceof gv) {
                    this.f12095n3.add(new gv((gv) vVar, yVar));
                } else {
                    if (vVar instanceof zn) {
                        n3Var = new zn((zn) vVar);
                    } else if (vVar instanceof n3) {
                        n3Var = new n3((n3) vVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f12095n3.add(n3Var);
                    String str2 = n3Var.f12071n3;
                    if (str2 != null) {
                        yVar.put(str2, n3Var);
                    }
                }
            }
        }

        public String getGroupName() {
            return this.f12098tl;
        }

        public Matrix getLocalMatrix() {
            return this.f12094i9;
        }

        public float getPivotX() {
            return this.f12093gv;
        }

        public float getPivotY() {
            return this.f12099v;
        }

        public float getRotation() {
            return this.f12100zn;
        }

        public float getScaleX() {
            return this.f12089a;
        }

        public float getScaleY() {
            return this.f12092fb;
        }

        public float getTranslateX() {
            return this.f12096s;
        }

        public float getTranslateY() {
            return this.f12090c5;
        }

        public final void gv() {
            this.f12094i9.reset();
            this.f12094i9.postTranslate(-this.f12093gv, -this.f12099v);
            this.f12094i9.postScale(this.f12089a, this.f12092fb);
            this.f12094i9.postRotate(this.f12100zn, 0.0f, 0.0f);
            this.f12094i9.postTranslate(this.f12096s + this.f12093gv, this.f12090c5 + this.f12099v);
        }

        @Override // o0.s.v
        public boolean n3(int[] iArr) {
            boolean z2 = false;
            for (int i = 0; i < this.f12095n3.size(); i++) {
                z2 |= this.f12095n3.get(i).n3(iArr);
            }
            return z2;
        }

        public void setPivotX(float f4) {
            if (f4 != this.f12093gv) {
                this.f12093gv = f4;
                gv();
            }
        }

        public void setPivotY(float f4) {
            if (f4 != this.f12099v) {
                this.f12099v = f4;
                gv();
            }
        }

        public void setRotation(float f4) {
            if (f4 != this.f12100zn) {
                this.f12100zn = f4;
                gv();
            }
        }

        public void setScaleX(float f4) {
            if (f4 != this.f12089a) {
                this.f12089a = f4;
                gv();
            }
        }

        public void setScaleY(float f4) {
            if (f4 != this.f12092fb) {
                this.f12092fb = f4;
                gv();
            }
        }

        public void setTranslateX(float f4) {
            if (f4 != this.f12096s) {
                this.f12096s = f4;
                gv();
            }
        }

        public void setTranslateY(float f4) {
            if (f4 != this.f12090c5) {
                this.f12090c5 = f4;
                gv();
            }
        }

        public final void v(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f12097t = null;
            this.f12100zn = f.a(typedArray, xmlPullParser, "rotation", 5, this.f12100zn);
            this.f12093gv = typedArray.getFloat(1, this.f12093gv);
            this.f12099v = typedArray.getFloat(2, this.f12099v);
            this.f12089a = f.a(typedArray, xmlPullParser, "scaleX", 3, this.f12089a);
            this.f12092fb = f.a(typedArray, xmlPullParser, "scaleY", 4, this.f12092fb);
            this.f12096s = f.a(typedArray, xmlPullParser, "translateX", 6, this.f12096s);
            this.f12090c5 = f.a(typedArray, xmlPullParser, "translateY", 7, this.f12090c5);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f12098tl = string;
            }
            gv();
        }

        @Override // o0.s.v
        public boolean y() {
            for (int i = 0; i < this.f12095n3.size(); i++) {
                if (this.f12095n3.get(i).y()) {
                    return true;
                }
            }
            return false;
        }

        public void zn(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray f4 = f.f(resources, theme, attributeSet, o0.y.f12130n3);
            v(f4, xmlPullParser);
            f4.recycle();
        }

        public gv() {
            super();
            this.y = new Matrix();
            this.f12095n3 = new ArrayList<>();
            this.f12100zn = 0.0f;
            this.f12093gv = 0.0f;
            this.f12099v = 0.0f;
            this.f12089a = 1.0f;
            this.f12092fb = 1.0f;
            this.f12096s = 0.0f;
            this.f12090c5 = 0.0f;
            this.f12094i9 = new Matrix();
            this.f12098tl = null;
        }
    }
}
