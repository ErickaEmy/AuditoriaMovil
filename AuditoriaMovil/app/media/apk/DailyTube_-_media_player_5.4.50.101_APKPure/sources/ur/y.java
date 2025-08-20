package ur;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.uv.v7.R;
import hw.i4;
import pv.y;
import ur.fb;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: u  reason: collision with root package name */
    public static final boolean f14115u = false;
    @NonNull

    /* renamed from: y5  reason: collision with root package name */
    public static final Paint f14116y5 = null;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final RectF f14117a;

    /* renamed from: a8  reason: collision with root package name */
    public TimeInterpolator f14118a8;

    /* renamed from: b  reason: collision with root package name */
    public float f14119b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14120c;

    /* renamed from: co  reason: collision with root package name */
    public Typeface f14122co;

    /* renamed from: d  reason: collision with root package name */
    public int[] f14123d;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f14124d0;
    @NonNull

    /* renamed from: ej  reason: collision with root package name */
    public final TextPaint f14125ej;

    /* renamed from: en  reason: collision with root package name */
    public CharSequence f14126en;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f14127f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public CharSequence f14128f3;

    /* renamed from: f7  reason: collision with root package name */
    public float f14129f7;
    @Nullable

    /* renamed from: fh  reason: collision with root package name */
    public Bitmap f14131fh;
    @NonNull

    /* renamed from: gv  reason: collision with root package name */
    public final Rect f14132gv;

    /* renamed from: hw  reason: collision with root package name */
    public float f14133hw;

    /* renamed from: i4  reason: collision with root package name */
    public pv.y f14134i4;

    /* renamed from: j  reason: collision with root package name */
    public float f14136j;

    /* renamed from: j5  reason: collision with root package name */
    public float f14137j5;

    /* renamed from: k  reason: collision with root package name */
    public float f14139k;

    /* renamed from: k5  reason: collision with root package name */
    public float f14140k5;

    /* renamed from: mg  reason: collision with root package name */
    public float f14141mg;

    /* renamed from: mt  reason: collision with root package name */
    public float f14142mt;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public CharSequence f14143n;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f14144n3;

    /* renamed from: o  reason: collision with root package name */
    public ColorStateList f14145o;

    /* renamed from: oz  reason: collision with root package name */
    public float f14146oz;

    /* renamed from: p  reason: collision with root package name */
    public float f14147p;

    /* renamed from: q9  reason: collision with root package name */
    public float f14148q9;

    /* renamed from: qn  reason: collision with root package name */
    public float f14149qn;

    /* renamed from: r  reason: collision with root package name */
    public Typeface f14150r;

    /* renamed from: rz  reason: collision with root package name */
    public Paint f14151rz;

    /* renamed from: t  reason: collision with root package name */
    public ColorStateList f14153t;

    /* renamed from: ta  reason: collision with root package name */
    public float f14154ta;

    /* renamed from: tl  reason: collision with root package name */
    public float f14155tl;
    @NonNull

    /* renamed from: ud  reason: collision with root package name */
    public final TextPaint f14156ud;

    /* renamed from: ut  reason: collision with root package name */
    public StaticLayout f14157ut;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public final Rect f14158v;

    /* renamed from: vl  reason: collision with root package name */
    public ColorStateList f14159vl;

    /* renamed from: w  reason: collision with root package name */
    public float f14160w;

    /* renamed from: wz  reason: collision with root package name */
    public float f14161wz;

    /* renamed from: x  reason: collision with root package name */
    public TimeInterpolator f14162x;

    /* renamed from: x4  reason: collision with root package name */
    public pv.y f14163x4;

    /* renamed from: xc  reason: collision with root package name */
    public float f14164xc;
    public final View y;

    /* renamed from: yt  reason: collision with root package name */
    public float f14165yt;

    /* renamed from: z  reason: collision with root package name */
    public Typeface f14166z;

    /* renamed from: z6  reason: collision with root package name */
    public boolean f14167z6;

    /* renamed from: zn  reason: collision with root package name */
    public float f14168zn;

    /* renamed from: fb  reason: collision with root package name */
    public int f14130fb = 16;

    /* renamed from: s  reason: collision with root package name */
    public int f14152s = 16;

    /* renamed from: c5  reason: collision with root package name */
    public float f14121c5 = 15.0f;

    /* renamed from: i9  reason: collision with root package name */
    public float f14135i9 = 15.0f;

    /* renamed from: jz  reason: collision with root package name */
    public int f14138jz = 1;

    /* renamed from: ur.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0229y implements y.InterfaceC0181y {
        public C0229y() {
        }

        @Override // pv.y.InterfaceC0181y
        public void y(Typeface typeface) {
            y.this.k5(typeface);
        }
    }

    public y(View view) {
        this.y = view;
        TextPaint textPaint = new TextPaint(129);
        this.f14125ej = textPaint;
        this.f14156ud = new TextPaint(textPaint);
        this.f14158v = new Rect();
        this.f14132gv = new Rect();
        this.f14117a = new RectF();
    }

    public static boolean c(float f4, float f6) {
        if (Math.abs(f4 - f6) < 0.001f) {
            return true;
        }
        return false;
    }

    public static boolean d(@NonNull Rect rect, int i, int i5, int i6, int i8) {
        if (rect.left == i && rect.top == i5 && rect.right == i6 && rect.bottom == i8) {
            return true;
        }
        return false;
    }

    public static float rz(float f4, float f6, float f9, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f9 = timeInterpolator.getInterpolation(f9);
        }
        return y6.y.y(f4, f6, f9);
    }

    public static int y(int i, int i5, float f4) {
        float f6 = 1.0f - f4;
        return Color.argb((int) ((Color.alpha(i) * f6) + (Color.alpha(i5) * f4)), (int) ((Color.red(i) * f6) + (Color.red(i5) * f4)), (int) ((Color.green(i) * f6) + (Color.green(i5) * f4)), (int) ((Color.blue(i) * f6) + (Color.blue(i5) * f4)));
    }

    public final void a(float f4) {
        n(f4);
        this.f14147p = rz(this.f14164xc, this.f14160w, f4, this.f14118a8);
        this.f14142mt = rz(this.f14155tl, this.f14161wz, f4, this.f14118a8);
        q9(rz(this.f14121c5, this.f14135i9, f4, this.f14162x));
        TimeInterpolator timeInterpolator = y6.y.f15325n3;
        a8(1.0f - rz(0.0f, 1.0f, 1.0f - f4, timeInterpolator));
        j5(rz(1.0f, 0.0f, f4, timeInterpolator));
        if (this.f14153t != this.f14127f) {
            this.f14125ej.setColor(y(z(), mt(), f4));
        } else {
            this.f14125ej.setColor(mt());
        }
        float f6 = this.f14136j;
        float f9 = this.f14146oz;
        if (f6 != f9) {
            this.f14125ej.setLetterSpacing(rz(f9, f6, f4, timeInterpolator));
        } else {
            this.f14125ej.setLetterSpacing(f6);
        }
        this.f14125ej.setShadowLayer(rz(this.f14133hw, this.f14119b, f4, null), rz(this.f14137j5, this.f14140k5, f4, null), rz(this.f14149qn, this.f14165yt, f4, null), y(co(this.f14145o), co(this.f14159vl), f4));
        i4.lc(this.y);
    }

    public final void a8(float f4) {
        this.f14148q9 = f4;
        i4.lc(this.y);
    }

    public void b(int i) {
        if (this.f14152s != i) {
            this.f14152s = i;
            ta();
        }
    }

    public final StaticLayout c5(int i, float f4, boolean z2) {
        StaticLayout staticLayout;
        try {
            staticLayout = fb.zn(this.f14128f3, this.f14125ej, (int) f4).v(TextUtils.TruncateAt.END).fb(z2).gv(Layout.Alignment.ALIGN_NORMAL).a(false).s(i).y();
        } catch (fb.y e2) {
            Log.e("CollapsingTextHelper", e2.getCause().getMessage(), e2);
            staticLayout = null;
        }
        return (StaticLayout) vl.s.fb(staticLayout);
    }

    public final int co(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f14123d;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public final boolean d0() {
        if (i4.ta(this.y) == 1) {
            return true;
        }
        return false;
    }

    public void ej(@NonNull Rect rect) {
        z6(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void en(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.f14128f3, charSequence)) {
            this.f14128f3 = charSequence;
            this.f14143n = null;
            s();
            ta();
        }
    }

    public final void f(@NonNull Canvas canvas, float f4, float f6) {
        int alpha = this.f14125ej.getAlpha();
        canvas.translate(f4, f6);
        float f9 = alpha;
        this.f14125ej.setAlpha((int) (this.f14139k * f9));
        this.f14157ut.draw(canvas);
        this.f14125ej.setAlpha((int) (this.f14148q9 * f9));
        int lineBaseline = this.f14157ut.getLineBaseline(0);
        CharSequence charSequence = this.f14126en;
        float f10 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f10, this.f14125ej);
        String trim = this.f14126en.toString().trim();
        if (trim.endsWith("…")) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.f14125ej.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f14157ut.getLineEnd(0), str.length()), 0.0f, f10, (Paint) this.f14125ej);
    }

    public final void f3(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f14121c5);
        textPaint.setTypeface(this.f14166z);
        textPaint.setLetterSpacing(this.f14146oz);
    }

    public final boolean f7(int[] iArr) {
        this.f14123d = iArr;
        if (fh()) {
            ta();
            return true;
        }
        return false;
    }

    public final void fb(float f4) {
        boolean z2;
        float f6;
        boolean z3;
        if (this.f14128f3 == null) {
            return;
        }
        float width = this.f14158v.width();
        float width2 = this.f14132gv.width();
        boolean z4 = false;
        int i = 1;
        if (c(f4, this.f14135i9)) {
            f6 = this.f14135i9;
            this.f14141mg = 1.0f;
            Typeface typeface = this.f14150r;
            Typeface typeface2 = this.f14122co;
            if (typeface != typeface2) {
                this.f14150r = typeface2;
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            float f9 = this.f14121c5;
            Typeface typeface3 = this.f14150r;
            Typeface typeface4 = this.f14166z;
            if (typeface3 != typeface4) {
                this.f14150r = typeface4;
                z2 = true;
            } else {
                z2 = false;
            }
            if (c(f4, f9)) {
                this.f14141mg = 1.0f;
            } else {
                this.f14141mg = f4 / this.f14121c5;
            }
            float f10 = this.f14135i9 / this.f14121c5;
            if (width2 * f10 > width) {
                width = Math.min(width / f10, width2);
            } else {
                width = width2;
            }
            f6 = f9;
            z3 = z2;
        }
        if (width > 0.0f) {
            if (this.f14154ta == f6 && !this.f14167z6 && !z3) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.f14154ta = f6;
            this.f14167z6 = false;
        }
        if (this.f14143n == null || z3) {
            this.f14125ej.setTextSize(this.f14154ta);
            this.f14125ej.setTypeface(this.f14150r);
            TextPaint textPaint = this.f14125ej;
            if (this.f14141mg != 1.0f) {
                z4 = true;
            }
            textPaint.setLinearText(z4);
            this.f14120c = v(this.f14128f3);
            if (y5()) {
                i = this.f14138jz;
            }
            StaticLayout c52 = c5(i, width, this.f14120c);
            this.f14157ut = c52;
            this.f14143n = c52.getText();
        }
    }

    public final boolean fh() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f14153t;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f14127f) != null && colorStateList.isStateful())) {
            return true;
        }
        return false;
    }

    public final void gv() {
        a(this.f14168zn);
    }

    public void hw(@NonNull Rect rect) {
        vl(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void i4(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f14135i9);
        textPaint.setTypeface(this.f14122co);
        textPaint.setLetterSpacing(this.f14136j);
    }

    public void i9(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (this.f14143n != null && this.f14144n3) {
            boolean z2 = false;
            float lineLeft = (this.f14147p + this.f14157ut.getLineLeft(0)) - (this.f14129f7 * 2.0f);
            this.f14125ej.setTextSize(this.f14154ta);
            float f4 = this.f14147p;
            float f6 = this.f14142mt;
            if (this.f14124d0 && this.f14131fh != null) {
                z2 = true;
            }
            float f9 = this.f14141mg;
            if (f9 != 1.0f) {
                canvas.scale(f9, f9, f4, f6);
            }
            if (z2) {
                canvas.drawBitmap(this.f14131fh, f4, f6, this.f14151rz);
                canvas.restoreToCount(save);
                return;
            }
            if (y5()) {
                f(canvas, lineLeft, f6);
            } else {
                canvas.translate(f4, f6);
                this.f14157ut.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    public void j(float f4) {
        if (this.f14121c5 != f4) {
            this.f14121c5 = f4;
            ta();
        }
    }

    public final void j5(float f4) {
        this.f14139k = f4;
        i4.lc(this.y);
    }

    public void jz(TimeInterpolator timeInterpolator) {
        this.f14162x = timeInterpolator;
        ta();
    }

    public void k(TimeInterpolator timeInterpolator) {
        this.f14118a8 = timeInterpolator;
        ta();
    }

    public void k5(Typeface typeface) {
        if (yt(typeface)) {
            ta();
        }
    }

    public void mg() {
        boolean z2;
        if (this.f14158v.width() > 0 && this.f14158v.height() > 0 && this.f14132gv.width() > 0 && this.f14132gv.height() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f14144n3 = z2;
    }

    public int mt() {
        return co(this.f14153t);
    }

    public final void n(float f4) {
        this.f14117a.left = rz(this.f14132gv.left, this.f14158v.left, f4, this.f14118a8);
        this.f14117a.top = rz(this.f14155tl, this.f14161wz, f4, this.f14118a8);
        this.f14117a.right = rz(this.f14132gv.right, this.f14158v.right, f4, this.f14118a8);
        this.f14117a.bottom = rz(this.f14132gv.bottom, this.f14158v.bottom, f4, this.f14118a8);
    }

    public final void n3() {
        float f4;
        float f6;
        float f9;
        StaticLayout staticLayout;
        float f10 = this.f14154ta;
        fb(this.f14135i9);
        CharSequence charSequence = this.f14143n;
        if (charSequence != null && (staticLayout = this.f14157ut) != null) {
            this.f14126en = TextUtils.ellipsize(charSequence, this.f14125ej, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.f14126en;
        float f11 = 0.0f;
        if (charSequence2 != null) {
            f4 = this.f14125ej.measureText(charSequence2, 0, charSequence2.length());
        } else {
            f4 = 0.0f;
        }
        int n32 = hw.v.n3(this.f14152s, this.f14120c ? 1 : 0);
        int i = n32 & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
        if (i != 48) {
            if (i != 80) {
                this.f14161wz = this.f14158v.centerY() - ((this.f14125ej.descent() - this.f14125ej.ascent()) / 2.0f);
            } else {
                this.f14161wz = this.f14158v.bottom + this.f14125ej.ascent();
            }
        } else {
            this.f14161wz = this.f14158v.top;
        }
        int i5 = n32 & 8388615;
        if (i5 != 1) {
            if (i5 != 5) {
                this.f14160w = this.f14158v.left;
            } else {
                this.f14160w = this.f14158v.right - f4;
            }
        } else {
            this.f14160w = this.f14158v.centerX() - (f4 / 2.0f);
        }
        fb(this.f14121c5);
        StaticLayout staticLayout2 = this.f14157ut;
        if (staticLayout2 != null) {
            f6 = staticLayout2.getHeight();
        } else {
            f6 = 0.0f;
        }
        CharSequence charSequence3 = this.f14143n;
        if (charSequence3 != null) {
            f9 = this.f14125ej.measureText(charSequence3, 0, charSequence3.length());
        } else {
            f9 = 0.0f;
        }
        StaticLayout staticLayout3 = this.f14157ut;
        if (staticLayout3 != null && this.f14138jz > 1 && !this.f14120c) {
            f9 = staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.f14157ut;
        if (staticLayout4 != null) {
            f11 = staticLayout4.getLineLeft(0);
        }
        this.f14129f7 = f11;
        int n33 = hw.v.n3(this.f14130fb, this.f14120c ? 1 : 0);
        int i6 = n33 & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
        if (i6 != 48) {
            if (i6 != 80) {
                this.f14155tl = this.f14132gv.centerY() - (f6 / 2.0f);
            } else {
                this.f14155tl = (this.f14132gv.bottom - f6) + this.f14125ej.descent();
            }
        } else {
            this.f14155tl = this.f14132gv.top;
        }
        int i8 = n33 & 8388615;
        if (i8 != 1) {
            if (i8 != 5) {
                this.f14164xc = this.f14132gv.left;
            } else {
                this.f14164xc = this.f14132gv.right - f9;
            }
        } else {
            this.f14164xc = this.f14132gv.centerX() - (f9 / 2.0f);
        }
        s();
        q9(f10);
    }

    public void o(int i) {
        if (this.f14130fb != i) {
            this.f14130fb = i;
            ta();
        }
    }

    public final boolean oz(Typeface typeface) {
        pv.y yVar = this.f14163x4;
        if (yVar != null) {
            yVar.zn();
        }
        if (this.f14166z != typeface) {
            this.f14166z = typeface;
            return true;
        }
        return false;
    }

    public final float p(@NonNull RectF rectF, int i, int i5) {
        if (i5 != 17 && (i5 & 7) != 1) {
            if ((i5 & 8388613) != 8388613 && (i5 & 5) != 5) {
                if (this.f14120c) {
                    return this.f14158v.right;
                }
                return rectF.left + zn();
            } else if (this.f14120c) {
                return rectF.left + zn();
            } else {
                return this.f14158v.right;
            }
        }
        return (i / 2.0f) + (zn() / 2.0f);
    }

    public final void q9(float f4) {
        boolean z2;
        fb(f4);
        if (f14115u && this.f14141mg != 1.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f14124d0 = z2;
        if (z2) {
            t();
        }
        i4.lc(this.y);
    }

    public void qn(ColorStateList colorStateList) {
        if (this.f14127f != colorStateList) {
            this.f14127f = colorStateList;
            ta();
        }
    }

    public float r() {
        f3(this.f14156ud);
        return -this.f14156ud.ascent();
    }

    public final void s() {
        Bitmap bitmap = this.f14131fh;
        if (bitmap != null) {
            bitmap.recycle();
            this.f14131fh = null;
        }
    }

    public final void t() {
        if (this.f14131fh == null && !this.f14132gv.isEmpty() && !TextUtils.isEmpty(this.f14143n)) {
            a(0.0f);
            int width = this.f14157ut.getWidth();
            int height = this.f14157ut.getHeight();
            if (width > 0 && height > 0) {
                this.f14131fh = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f14157ut.draw(new Canvas(this.f14131fh));
                if (this.f14151rz == null) {
                    this.f14151rz = new Paint(3);
                }
            }
        }
    }

    public void ta() {
        if (this.y.getHeight() > 0 && this.y.getWidth() > 0) {
            n3();
            gv();
        }
    }

    public void tl(@NonNull RectF rectF, int i, int i5) {
        this.f14120c = v(this.f14128f3);
        rectF.left = w(i, i5);
        rectF.top = this.f14158v.top;
        rectF.right = p(rectF, i, i5);
        rectF.bottom = this.f14158v.top + xc();
    }

    public void u(Typeface typeface) {
        boolean yt2 = yt(typeface);
        boolean oz2 = oz(typeface);
        if (yt2 || oz2) {
            ta();
        }
    }

    public void ud(int i) {
        pv.gv gvVar = new pv.gv(this.y.getContext(), i);
        ColorStateList colorStateList = gvVar.y;
        if (colorStateList != null) {
            this.f14153t = colorStateList;
        }
        float f4 = gvVar.f12651wz;
        if (f4 != 0.0f) {
            this.f14135i9 = f4;
        }
        ColorStateList colorStateList2 = gvVar.f12642gv;
        if (colorStateList2 != null) {
            this.f14159vl = colorStateList2;
        }
        this.f14140k5 = gvVar.f12639c5;
        this.f14165yt = gvVar.f12643i9;
        this.f14119b = gvVar.f12640f;
        this.f14136j = gvVar.f12648tl;
        pv.y yVar = this.f14134i4;
        if (yVar != null) {
            yVar.zn();
        }
        this.f14134i4 = new pv.y(new C0229y(), gvVar.v());
        gvVar.s(this.y.getContext(), this.f14134i4);
        ta();
    }

    public void ut(float f4) {
        float y = a8.y.y(f4, 0.0f, 1.0f);
        if (y != this.f14168zn) {
            this.f14168zn = y;
            gv();
        }
    }

    public final boolean v(@NonNull CharSequence charSequence) {
        yt.gv gvVar;
        if (d0()) {
            gvVar = yt.v.f15479gv;
        } else {
            gvVar = yt.v.f15482zn;
        }
        return gvVar.y(charSequence, 0, charSequence.length());
    }

    public void vl(int i, int i5, int i6, int i8) {
        if (!d(this.f14132gv, i, i5, i6, i8)) {
            this.f14132gv.set(i, i5, i6, i8);
            this.f14167z6 = true;
            mg();
        }
    }

    public final float w(int i, int i5) {
        if (i5 != 17 && (i5 & 7) != 1) {
            if ((i5 & 8388613) != 8388613 && (i5 & 5) != 5) {
                if (this.f14120c) {
                    return this.f14158v.right - zn();
                }
                return this.f14158v.left;
            } else if (this.f14120c) {
                return this.f14158v.left;
            } else {
                return this.f14158v.right - zn();
            }
        }
        return (i / 2.0f) - (zn() / 2.0f);
    }

    public ColorStateList wz() {
        return this.f14153t;
    }

    public void x(ColorStateList colorStateList) {
        if (this.f14153t != colorStateList) {
            this.f14153t = colorStateList;
            ta();
        }
    }

    public float x4() {
        return this.f14168zn;
    }

    public float xc() {
        i4(this.f14156ud);
        return -this.f14156ud.ascent();
    }

    public final boolean y5() {
        if (this.f14138jz > 1 && !this.f14120c && !this.f14124d0) {
            return true;
        }
        return false;
    }

    public final boolean yt(Typeface typeface) {
        pv.y yVar = this.f14134i4;
        if (yVar != null) {
            yVar.zn();
        }
        if (this.f14122co != typeface) {
            this.f14122co = typeface;
            return true;
        }
        return false;
    }

    public final int z() {
        return co(this.f14127f);
    }

    public void z6(int i, int i5, int i6, int i8) {
        if (!d(this.f14158v, i, i5, i6, i8)) {
            this.f14158v.set(i, i5, i6, i8);
            this.f14167z6 = true;
            mg();
        }
    }

    public float zn() {
        if (this.f14128f3 == null) {
            return 0.0f;
        }
        i4(this.f14156ud);
        TextPaint textPaint = this.f14156ud;
        CharSequence charSequence = this.f14128f3;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }
}
