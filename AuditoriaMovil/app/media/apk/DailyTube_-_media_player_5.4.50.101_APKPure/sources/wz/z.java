package wz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import d.s;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public yt f14854a;
    @NonNull

    /* renamed from: c5  reason: collision with root package name */
    public final r f14855c5;

    /* renamed from: f  reason: collision with root package name */
    public int f14856f = -1;

    /* renamed from: fb  reason: collision with root package name */
    public yt f14857fb;

    /* renamed from: gv  reason: collision with root package name */
    public yt f14858gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f14859i9;

    /* renamed from: n3  reason: collision with root package name */
    public yt f14860n3;

    /* renamed from: s  reason: collision with root package name */
    public yt f14861s;

    /* renamed from: t  reason: collision with root package name */
    public Typeface f14862t;

    /* renamed from: tl  reason: collision with root package name */
    public boolean f14863tl;

    /* renamed from: v  reason: collision with root package name */
    public yt f14864v;
    @NonNull
    public final TextView y;

    /* renamed from: zn  reason: collision with root package name */
    public yt f14865zn;

    /* loaded from: classes.dex */
    public class n3 implements Runnable {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ int f14866fb;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Typeface f14868v;
        public final /* synthetic */ TextView y;

        public n3(TextView textView, Typeface typeface, int i) {
            this.y = textView;
            this.f14868v = typeface;
            this.f14866fb = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.y.setTypeface(this.f14868v, this.f14866fb);
        }
    }

    public z(@NonNull TextView textView) {
        this.y = textView;
        this.f14855c5 = new r(textView);
    }

    public static yt gv(Context context, c5 c5Var, int i) {
        ColorStateList a2 = c5Var.a(context, i);
        if (a2 != null) {
            yt ytVar = new yt();
            ytVar.f14851gv = true;
            ytVar.y = a2;
            return ytVar;
        }
        return null;
    }

    public int a() {
        return this.f14855c5.c5();
    }

    public final void c() {
        yt ytVar = this.f14861s;
        this.f14860n3 = ytVar;
        this.f14865zn = ytVar;
        this.f14858gv = ytVar;
        this.f14864v = ytVar;
        this.f14854a = ytVar;
        this.f14857fb = ytVar;
    }

    public int c5() {
        return this.f14855c5.t();
    }

    public void co(boolean z2) {
        this.y.setAllCaps(z2);
    }

    public void d0(int i, float f4) {
        if (!j.n3.f9315wz && !t()) {
            fh(i, f4);
        }
    }

    @Nullable
    public PorterDuff.Mode f() {
        yt ytVar = this.f14861s;
        if (ytVar != null) {
            return ytVar.f14852n3;
        }
        return null;
    }

    public void f3(@Nullable PorterDuff.Mode mode) {
        boolean z2;
        if (this.f14861s == null) {
            this.f14861s = new yt();
        }
        yt ytVar = this.f14861s;
        ytVar.f14852n3 = mode;
        if (mode != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        ytVar.f14853zn = z2;
        c();
    }

    public int fb() {
        return this.f14855c5.i9();
    }

    public final void fh(int i, float f4) {
        this.f14855c5.x4(i, f4);
    }

    public void i4(@Nullable ColorStateList colorStateList) {
        boolean z2;
        if (this.f14861s == null) {
            this.f14861s = new yt();
        }
        yt ytVar = this.f14861s;
        ytVar.y = colorStateList;
        if (colorStateList != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        ytVar.f14851gv = z2;
        c();
    }

    @Nullable
    public ColorStateList i9() {
        yt ytVar = this.f14861s;
        if (ytVar != null) {
            return ytVar.y;
        }
        return null;
    }

    public void mt(@NonNull TextView textView, @Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            o.y.a(editorInfo, textView.getText());
        }
    }

    public final void n(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 == null && drawable6 == null) {
            if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
                Drawable[] compoundDrawablesRelative = this.y.getCompoundDrawablesRelative();
                Drawable drawable7 = compoundDrawablesRelative[0];
                if (drawable7 == null && compoundDrawablesRelative[2] == null) {
                    Drawable[] compoundDrawables = this.y.getCompoundDrawables();
                    TextView textView = this.y;
                    if (drawable == null) {
                        drawable = compoundDrawables[0];
                    }
                    if (drawable2 == null) {
                        drawable2 = compoundDrawables[1];
                    }
                    if (drawable3 == null) {
                        drawable3 = compoundDrawables[2];
                    }
                    if (drawable4 == null) {
                        drawable4 = compoundDrawables[3];
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                    return;
                }
                TextView textView2 = this.y;
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative[1];
                }
                Drawable drawable8 = compoundDrawablesRelative[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.y.getCompoundDrawablesRelative();
        TextView textView3 = this.y;
        if (drawable5 == null) {
            drawable5 = compoundDrawablesRelative2[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawablesRelative2[1];
        }
        if (drawable6 == null) {
            drawable6 = compoundDrawablesRelative2[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawablesRelative2[3];
        }
        textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
    }

    public void n3() {
        if (this.f14860n3 != null || this.f14865zn != null || this.f14858gv != null || this.f14864v != null) {
            Drawable[] compoundDrawables = this.y.getCompoundDrawables();
            y(compoundDrawables[0], this.f14860n3);
            y(compoundDrawables[1], this.f14865zn);
            y(compoundDrawables[2], this.f14858gv);
            y(compoundDrawables[3], this.f14864v);
        }
        if (this.f14854a != null || this.f14857fb != null) {
            Drawable[] compoundDrawablesRelative = this.y.getCompoundDrawablesRelative();
            y(compoundDrawablesRelative[0], this.f14854a);
            y(compoundDrawablesRelative[2], this.f14857fb);
        }
    }

    public void p(Context context, int i) {
        String xc2;
        ColorStateList zn2;
        ColorStateList zn3;
        ColorStateList zn4;
        hw z2 = hw.z(context, i, R$styleable.p4);
        int i5 = R$styleable.xd;
        if (z2.co(i5)) {
            co(z2.y(i5, false));
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 23) {
            int i8 = R$styleable.st;
            if (z2.co(i8) && (zn4 = z2.zn(i8)) != null) {
                this.y.setTextColor(zn4);
            }
            int i10 = R$styleable.g6;
            if (z2.co(i10) && (zn3 = z2.zn(i10)) != null) {
                this.y.setLinkTextColor(zn3);
            }
            int i11 = R$styleable.el;
            if (z2.co(i11) && (zn2 = z2.zn(i11)) != null) {
                this.y.setHintTextColor(zn2);
            }
        }
        int i12 = R$styleable.ik;
        if (z2.co(i12) && z2.a(i12, -1) == 0) {
            this.y.setTextSize(0, 0.0f);
        }
        rz(context, z2);
        if (i6 >= 26) {
            int i13 = R$styleable.iv;
            if (z2.co(i13) && (xc2 = z2.xc(i13)) != null) {
                this.y.setFontVariationSettings(xc2);
            }
        }
        z2.i4();
        Typeface typeface = this.f14862t;
        if (typeface != null) {
            this.y.setTypeface(typeface, this.f14859i9);
        }
    }

    public void r(@NonNull int[] iArr, int i) throws IllegalArgumentException {
        this.f14855c5.co(iArr, i);
    }

    public final void rz(Context context, hw hwVar) {
        String xc2;
        boolean z2;
        boolean z3;
        this.f14859i9 = hwVar.f(R$styleable.r3, this.f14859i9);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            int f4 = hwVar.f(R$styleable.yz, -1);
            this.f14856f = f4;
            if (f4 != -1) {
                this.f14859i9 &= 2;
            }
        }
        int i5 = R$styleable.ky;
        boolean z4 = true;
        if (!hwVar.co(i5) && !hwVar.co(R$styleable.oj)) {
            int i6 = R$styleable.ni;
            if (hwVar.co(i6)) {
                this.f14863tl = false;
                int f6 = hwVar.f(i6, 1);
                if (f6 != 1) {
                    if (f6 != 2) {
                        if (f6 == 3) {
                            this.f14862t = Typeface.MONOSPACE;
                            return;
                        }
                        return;
                    }
                    this.f14862t = Typeface.SERIF;
                    return;
                }
                this.f14862t = Typeface.SANS_SERIF;
                return;
            }
            return;
        }
        this.f14862t = null;
        int i8 = R$styleable.oj;
        if (hwVar.co(i8)) {
            i5 = i8;
        }
        int i10 = this.f14856f;
        int i11 = this.f14859i9;
        if (!context.isRestricted()) {
            try {
                Typeface i92 = hwVar.i9(i5, this.f14859i9, new y(i10, i11, new WeakReference(this.y)));
                if (i92 != null) {
                    if (i >= 28 && this.f14856f != -1) {
                        Typeface create = Typeface.create(i92, 0);
                        int i12 = this.f14856f;
                        if ((this.f14859i9 & 2) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.f14862t = Typeface.create(create, i12, z3);
                    } else {
                        this.f14862t = i92;
                    }
                }
                if (this.f14862t == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f14863tl = z2;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f14862t == null && (xc2 = hwVar.xc(i5)) != null) {
            if (Build.VERSION.SDK_INT >= 28 && this.f14856f != -1) {
                Typeface create2 = Typeface.create(xc2, 0);
                int i13 = this.f14856f;
                if ((this.f14859i9 & 2) == 0) {
                    z4 = false;
                }
                this.f14862t = Typeface.create(create2, i13, z4);
                return;
            }
            this.f14862t = Typeface.create(xc2, this.f14859i9);
        }
    }

    public int[] s() {
        return this.f14855c5.f();
    }

    public boolean t() {
        return this.f14855c5.w();
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01cc  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void tl(@androidx.annotation.Nullable android.util.AttributeSet r24, int r25) {
        /*
            Method dump skipped, instructions count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: wz.z.tl(android.util.AttributeSet, int):void");
    }

    public int v() {
        return this.f14855c5.s();
    }

    public void w() {
        n3();
    }

    public void wz(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f14863tl) {
            this.f14862t = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                if (hw.i4.ut(textView)) {
                    textView.post(new n3(textView, typeface, this.f14859i9));
                } else {
                    textView.setTypeface(typeface, this.f14859i9);
                }
            }
        }
    }

    public void x4(int i) {
        this.f14855c5.z(i);
    }

    public void xc(boolean z2, int i, int i5, int i6, int i8) {
        if (!j.n3.f9315wz) {
            zn();
        }
    }

    public final void y(Drawable drawable, yt ytVar) {
        if (drawable != null && ytVar != null) {
            c5.c5(drawable, ytVar, this.y.getDrawableState());
        }
    }

    public void z(int i, int i5, int i6, int i8) throws IllegalArgumentException {
        this.f14855c5.mt(i, i5, i6, i8);
    }

    public void zn() {
        this.f14855c5.y();
    }

    /* loaded from: classes.dex */
    public class y extends s.v {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ int f14870n3;
        public final /* synthetic */ int y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ WeakReference f14871zn;

        public y(int i, int i5, WeakReference weakReference) {
            this.y = i;
            this.f14870n3 = i5;
            this.f14871zn = weakReference;
        }

        @Override // d.s.v
        public void c5(@NonNull Typeface typeface) {
            int i;
            boolean z2;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.y) != -1) {
                if ((this.f14870n3 & 2) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                typeface = Typeface.create(typeface, i, z2);
            }
            z.this.wz(this.f14871zn, typeface);
        }

        @Override // d.s.v
        public void s(int i) {
        }
    }
}
