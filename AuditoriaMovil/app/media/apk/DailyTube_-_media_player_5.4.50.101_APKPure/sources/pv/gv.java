package pv;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$styleable;
import d.s;
/* loaded from: classes.dex */
public class gv {

    /* renamed from: a  reason: collision with root package name */
    public final int f12638a;

    /* renamed from: c5  reason: collision with root package name */
    public final float f12639c5;

    /* renamed from: f  reason: collision with root package name */
    public final float f12640f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f12641fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final ColorStateList f12642gv;

    /* renamed from: i9  reason: collision with root package name */
    public final float f12643i9;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final ColorStateList f12644n3;

    /* renamed from: p  reason: collision with root package name */
    public Typeface f12645p;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f12646s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f12647t;

    /* renamed from: tl  reason: collision with root package name */
    public final float f12648tl;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final String f12649v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f12650w;

    /* renamed from: wz  reason: collision with root package name */
    public float f12651wz;

    /* renamed from: xc  reason: collision with root package name */
    public final int f12652xc;
    @Nullable
    public final ColorStateList y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final ColorStateList f12653zn;

    /* loaded from: classes.dex */
    public class n3 extends a {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ a f12654n3;
        public final /* synthetic */ TextPaint y;

        public n3(TextPaint textPaint, a aVar) {
            this.y = textPaint;
            this.f12654n3 = aVar;
        }

        @Override // pv.a
        public void n3(@NonNull Typeface typeface, boolean z2) {
            gv.this.t(this.y, typeface);
            this.f12654n3.n3(typeface, z2);
        }

        @Override // pv.a
        public void y(int i) {
            this.f12654n3.y(i);
        }
    }

    /* loaded from: classes.dex */
    public class y extends s.v {
        public final /* synthetic */ a y;

        public y(a aVar) {
            this.y = aVar;
        }

        @Override // d.s.v
        public void c5(@NonNull Typeface typeface) {
            gv gvVar = gv.this;
            gvVar.f12645p = Typeface.create(typeface, gvVar.f12638a);
            gv.this.f12650w = true;
            this.y.n3(gv.this.f12645p, false);
        }

        @Override // d.s.v
        public void s(int i) {
            gv.this.f12650w = true;
            this.y.y(i);
        }
    }

    public gv(@NonNull Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.f5234nr);
        this.f12651wz = obtainStyledAttributes.getDimension(R$styleable.f5242os, 0.0f);
        this.y = zn.y(context, obtainStyledAttributes, R$styleable.f5123bm);
        this.f12644n3 = zn.y(context, obtainStyledAttributes, R$styleable.f5152e7);
        this.f12653zn = zn.y(context, obtainStyledAttributes, R$styleable.A);
        this.f12638a = obtainStyledAttributes.getInt(R$styleable.f5198jn, 0);
        this.f12641fb = obtainStyledAttributes.getInt(R$styleable.f5183hx, 1);
        int v2 = zn.v(obtainStyledAttributes, R$styleable.G, R$styleable.F);
        this.f12652xc = obtainStyledAttributes.getResourceId(v2, 0);
        this.f12649v = obtainStyledAttributes.getString(v2);
        this.f12646s = obtainStyledAttributes.getBoolean(R$styleable.H, false);
        this.f12642gv = zn.y(context, obtainStyledAttributes, R$styleable.B);
        this.f12639c5 = obtainStyledAttributes.getFloat(R$styleable.C, 0.0f);
        this.f12643i9 = obtainStyledAttributes.getFloat(R$styleable.D, 0.0f);
        this.f12640f = obtainStyledAttributes.getFloat(R$styleable.E, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, R$styleable.or);
        int i5 = R$styleable.i5;
        this.f12647t = obtainStyledAttributes2.hasValue(i5);
        this.f12648tl = obtainStyledAttributes2.getFloat(i5, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    @NonNull
    public Typeface a(@NonNull Context context) {
        if (this.f12650w) {
            return this.f12645p;
        }
        if (!context.isRestricted()) {
            try {
                Typeface a2 = s.a(context, this.f12652xc);
                this.f12645p = a2;
                if (a2 != null) {
                    this.f12645p = Typeface.create(a2, this.f12638a);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException | Exception unused) {
            }
        }
        gv();
        this.f12650w = true;
        return this.f12645p;
    }

    public final boolean c5(Context context) {
        return v.y();
    }

    public void f(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull a aVar) {
        if (c5(context)) {
            t(textPaint, a(context));
        } else {
            fb(context, textPaint, aVar);
        }
    }

    public void fb(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull a aVar) {
        t(textPaint, v());
        s(context, new n3(textPaint, aVar));
    }

    public final void gv() {
        String str;
        if (this.f12645p == null && (str = this.f12649v) != null) {
            this.f12645p = Typeface.create(str, this.f12638a);
        }
        if (this.f12645p == null) {
            int i = this.f12641fb;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        this.f12645p = Typeface.DEFAULT;
                    } else {
                        this.f12645p = Typeface.MONOSPACE;
                    }
                } else {
                    this.f12645p = Typeface.SERIF;
                }
            } else {
                this.f12645p = Typeface.SANS_SERIF;
            }
            this.f12645p = Typeface.create(this.f12645p, this.f12638a);
        }
    }

    public void i9(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull a aVar) {
        int i;
        int i5;
        f(context, textPaint, aVar);
        ColorStateList colorStateList = this.y;
        if (colorStateList != null) {
            i = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i = -16777216;
        }
        textPaint.setColor(i);
        float f4 = this.f12640f;
        float f6 = this.f12639c5;
        float f9 = this.f12643i9;
        ColorStateList colorStateList2 = this.f12642gv;
        if (colorStateList2 != null) {
            i5 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i5 = 0;
        }
        textPaint.setShadowLayer(f4, f6, f9, i5);
    }

    public void s(@NonNull Context context, @NonNull a aVar) {
        if (c5(context)) {
            a(context);
        } else {
            gv();
        }
        int i = this.f12652xc;
        if (i == 0) {
            this.f12650w = true;
        }
        if (this.f12650w) {
            aVar.n3(this.f12645p, true);
            return;
        }
        try {
            s.s(context, i, new y(aVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f12650w = true;
            aVar.y(1);
        } catch (Exception unused2) {
            this.f12650w = true;
            aVar.y(-3);
        }
    }

    public void t(@NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        boolean z2;
        float f4;
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.f12638a;
        if ((i & 1) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        textPaint.setFakeBoldText(z2);
        if ((i & 2) != 0) {
            f4 = -0.25f;
        } else {
            f4 = 0.0f;
        }
        textPaint.setTextSkewX(f4);
        textPaint.setTextSize(this.f12651wz);
        if (this.f12647t) {
            textPaint.setLetterSpacing(this.f12648tl);
        }
    }

    public Typeface v() {
        gv();
        return this.f12645p;
    }
}
