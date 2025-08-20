package hx;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import com.google.android.material.R$styleable;
/* loaded from: classes.dex */
public class f {

    /* renamed from: tl  reason: collision with root package name */
    public static final hx.zn f9008tl = new c5(0.5f);

    /* renamed from: a  reason: collision with root package name */
    public hx.zn f9009a;

    /* renamed from: c5  reason: collision with root package name */
    public a f9010c5;

    /* renamed from: f  reason: collision with root package name */
    public a f9011f;

    /* renamed from: fb  reason: collision with root package name */
    public hx.zn f9012fb;

    /* renamed from: gv  reason: collision with root package name */
    public gv f9013gv;

    /* renamed from: i9  reason: collision with root package name */
    public a f9014i9;

    /* renamed from: n3  reason: collision with root package name */
    public gv f9015n3;

    /* renamed from: s  reason: collision with root package name */
    public hx.zn f9016s;

    /* renamed from: t  reason: collision with root package name */
    public a f9017t;

    /* renamed from: v  reason: collision with root package name */
    public hx.zn f9018v;
    public gv y;

    /* renamed from: zn  reason: collision with root package name */
    public gv f9019zn;

    /* loaded from: classes.dex */
    public interface zn {
        @NonNull
        hx.zn y(@NonNull hx.zn znVar);
    }

    @NonNull
    public static n3 a(@NonNull Context context, AttributeSet attributeSet, int i, int i5, int i6) {
        return fb(context, attributeSet, i, i5, new hx.y(i6));
    }

    @NonNull
    public static n3 fb(@NonNull Context context, AttributeSet attributeSet, int i, int i5, @NonNull hx.zn znVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.sg, i, i5);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.lm, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.q4, 0);
        obtainStyledAttributes.recycle();
        return gv(context, resourceId, resourceId2, znVar);
    }

    @NonNull
    public static n3 gv(Context context, int i, int i5, @NonNull hx.zn znVar) {
        if (i5 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i5;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.f5178ha);
        try {
            int i6 = obtainStyledAttributes.getInt(R$styleable.f5223mv, 0);
            int i8 = obtainStyledAttributes.getInt(R$styleable.f5175h3, i6);
            int i10 = obtainStyledAttributes.getInt(R$styleable.f5179hd, i6);
            int i11 = obtainStyledAttributes.getInt(R$styleable.f5228n6, i6);
            int i12 = obtainStyledAttributes.getInt(R$styleable.f5314y3, i6);
            hx.zn tl2 = tl(obtainStyledAttributes, R$styleable.f5280tp, znVar);
            hx.zn tl3 = tl(obtainStyledAttributes, R$styleable.f5180ho, tl2);
            hx.zn tl4 = tl(obtainStyledAttributes, R$styleable.f5144dj, tl2);
            hx.zn tl5 = tl(obtainStyledAttributes, R$styleable.f5326zl, tl2);
            return new n3().c(i8, tl3).mg(i10, tl4).x4(i11, tl5).mt(i12, tl(obtainStyledAttributes, R$styleable.f5162f5, tl2));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static n3 n3(Context context, int i, int i5) {
        return zn(context, i, i5, 0);
    }

    @NonNull
    public static hx.zn tl(TypedArray typedArray, int i, @NonNull hx.zn znVar) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return znVar;
        }
        int i5 = peekValue.type;
        if (i5 == 5) {
            return new hx.y(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        if (i5 == 6) {
            return new c5(peekValue.getFraction(1.0f, 1.0f));
        }
        return znVar;
    }

    @NonNull
    public static n3 v(@NonNull Context context, AttributeSet attributeSet, int i, int i5) {
        return a(context, attributeSet, i, i5, 0);
    }

    @NonNull
    public static n3 y() {
        return new n3();
    }

    @NonNull
    public static n3 zn(Context context, int i, int i5, int i6) {
        return gv(context, i, i5, new hx.y(i6));
    }

    @NonNull
    public gv c5() {
        return this.f9013gv;
    }

    @NonNull
    public gv co() {
        return this.f9015n3;
    }

    @NonNull
    public gv f() {
        return this.f9019zn;
    }

    @NonNull
    public f f3(@NonNull hx.zn znVar) {
        return x4().w(znVar).tl();
    }

    @NonNull
    public f i4(float f4) {
        return x4().xc(f4).tl();
    }

    @NonNull
    public hx.zn i9() {
        return this.f9016s;
    }

    @NonNull
    public hx.zn mt() {
        return this.f9018v;
    }

    @NonNull
    public f n(@NonNull zn znVar) {
        return x4().rz(znVar.y(mt())).z6(znVar.y(z())).r(znVar.y(i9())).n(znVar.y(t())).tl();
    }

    @NonNull
    public gv p() {
        return this.y;
    }

    public boolean r(@NonNull RectF rectF) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (this.f9017t.getClass().equals(a.class) && this.f9014i9.getClass().equals(a.class) && this.f9010c5.getClass().equals(a.class) && this.f9011f.getClass().equals(a.class)) {
            z2 = true;
        } else {
            z2 = false;
        }
        float y2 = this.f9018v.y(rectF);
        if (this.f9009a.y(rectF) == y2 && this.f9016s.y(rectF) == y2 && this.f9012fb.y(rectF) == y2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((this.f9015n3 instanceof i9) && (this.y instanceof i9) && (this.f9019zn instanceof i9) && (this.f9013gv instanceof i9)) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z2 || !z3 || !z4) {
            return false;
        }
        return true;
    }

    @NonNull
    public a s() {
        return this.f9011f;
    }

    @NonNull
    public hx.zn t() {
        return this.f9012fb;
    }

    @NonNull
    public a w() {
        return this.f9010c5;
    }

    @NonNull
    public a wz() {
        return this.f9017t;
    }

    @NonNull
    public n3 x4() {
        return new n3(this);
    }

    @NonNull
    public a xc() {
        return this.f9014i9;
    }

    @NonNull
    public hx.zn z() {
        return this.f9009a;
    }

    public f(@NonNull n3 n3Var) {
        this.y = n3Var.y;
        this.f9015n3 = n3Var.f9026n3;
        this.f9019zn = n3Var.f9030zn;
        this.f9013gv = n3Var.f9024gv;
        this.f9018v = n3Var.f9029v;
        this.f9009a = n3Var.f9020a;
        this.f9012fb = n3Var.f9023fb;
        this.f9016s = n3Var.f9027s;
        this.f9010c5 = n3Var.f9021c5;
        this.f9014i9 = n3Var.f9025i9;
        this.f9011f = n3Var.f9022f;
        this.f9017t = n3Var.f9028t;
    }

    /* loaded from: classes.dex */
    public static final class n3 {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public hx.zn f9020a;
        @NonNull

        /* renamed from: c5  reason: collision with root package name */
        public a f9021c5;
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        public a f9022f;
        @NonNull

        /* renamed from: fb  reason: collision with root package name */
        public hx.zn f9023fb;
        @NonNull

        /* renamed from: gv  reason: collision with root package name */
        public gv f9024gv;
        @NonNull

        /* renamed from: i9  reason: collision with root package name */
        public a f9025i9;
        @NonNull

        /* renamed from: n3  reason: collision with root package name */
        public gv f9026n3;
        @NonNull

        /* renamed from: s  reason: collision with root package name */
        public hx.zn f9027s;
        @NonNull

        /* renamed from: t  reason: collision with root package name */
        public a f9028t;
        @NonNull

        /* renamed from: v  reason: collision with root package name */
        public hx.zn f9029v;
        @NonNull
        public gv y;
        @NonNull

        /* renamed from: zn  reason: collision with root package name */
        public gv f9030zn;

        public n3() {
            this.y = s.n3();
            this.f9026n3 = s.n3();
            this.f9030zn = s.n3();
            this.f9024gv = s.n3();
            this.f9029v = new hx.y(0.0f);
            this.f9020a = new hx.y(0.0f);
            this.f9023fb = new hx.y(0.0f);
            this.f9027s = new hx.y(0.0f);
            this.f9021c5 = s.zn();
            this.f9025i9 = s.zn();
            this.f9022f = s.zn();
            this.f9028t = s.zn();
        }

        public static float wz(gv gvVar) {
            if (gvVar instanceof i9) {
                return ((i9) gvVar).y;
            }
            if (gvVar instanceof v) {
                return ((v) gvVar).y;
            }
            return -1.0f;
        }

        @NonNull
        public n3 c(int i, @NonNull hx.zn znVar) {
            return d0(s.y(i)).rz(znVar);
        }

        @NonNull
        public n3 co(@NonNull gv gvVar) {
            this.f9024gv = gvVar;
            float wz2 = wz(gvVar);
            if (wz2 != -1.0f) {
                z(wz2);
            }
            return this;
        }

        @NonNull
        public n3 d(float f4) {
            this.f9020a = new hx.y(f4);
            return this;
        }

        @NonNull
        public n3 d0(@NonNull gv gvVar) {
            this.y = gvVar;
            float wz2 = wz(gvVar);
            if (wz2 != -1.0f) {
                fh(wz2);
            }
            return this;
        }

        @NonNull
        public n3 f3(float f4) {
            this.f9023fb = new hx.y(f4);
            return this;
        }

        @NonNull
        public n3 fh(float f4) {
            this.f9029v = new hx.y(f4);
            return this;
        }

        @NonNull
        public n3 i4(@NonNull gv gvVar) {
            this.f9030zn = gvVar;
            float wz2 = wz(gvVar);
            if (wz2 != -1.0f) {
                f3(wz2);
            }
            return this;
        }

        @NonNull
        public n3 mg(int i, @NonNull hx.zn znVar) {
            return ta(s.y(i)).z6(znVar);
        }

        @NonNull
        public n3 mt(int i, @NonNull hx.zn znVar) {
            return co(s.y(i)).r(znVar);
        }

        @NonNull
        public n3 n(@NonNull hx.zn znVar) {
            this.f9023fb = znVar;
            return this;
        }

        @NonNull
        public n3 p(@NonNull gv gvVar) {
            return d0(gvVar).ta(gvVar).i4(gvVar).co(gvVar);
        }

        @NonNull
        public n3 r(@NonNull hx.zn znVar) {
            this.f9027s = znVar;
            return this;
        }

        @NonNull
        public n3 rz(@NonNull hx.zn znVar) {
            this.f9029v = znVar;
            return this;
        }

        @NonNull
        public n3 ta(@NonNull gv gvVar) {
            this.f9026n3 = gvVar;
            float wz2 = wz(gvVar);
            if (wz2 != -1.0f) {
                d(wz2);
            }
            return this;
        }

        @NonNull
        public f tl() {
            return new f(this);
        }

        @NonNull
        public n3 w(@NonNull hx.zn znVar) {
            return rz(znVar).z6(znVar).n(znVar).r(znVar);
        }

        @NonNull
        public n3 x4(int i, @NonNull hx.zn znVar) {
            return i4(s.y(i)).n(znVar);
        }

        @NonNull
        public n3 xc(float f4) {
            return fh(f4).d(f4).f3(f4).z(f4);
        }

        @NonNull
        public n3 z(float f4) {
            this.f9027s = new hx.y(f4);
            return this;
        }

        @NonNull
        public n3 z6(@NonNull hx.zn znVar) {
            this.f9020a = znVar;
            return this;
        }

        public n3(@NonNull f fVar) {
            this.y = s.n3();
            this.f9026n3 = s.n3();
            this.f9030zn = s.n3();
            this.f9024gv = s.n3();
            this.f9029v = new hx.y(0.0f);
            this.f9020a = new hx.y(0.0f);
            this.f9023fb = new hx.y(0.0f);
            this.f9027s = new hx.y(0.0f);
            this.f9021c5 = s.zn();
            this.f9025i9 = s.zn();
            this.f9022f = s.zn();
            this.f9028t = s.zn();
            this.y = fVar.y;
            this.f9026n3 = fVar.f9015n3;
            this.f9030zn = fVar.f9019zn;
            this.f9024gv = fVar.f9013gv;
            this.f9029v = fVar.f9018v;
            this.f9020a = fVar.f9009a;
            this.f9023fb = fVar.f9012fb;
            this.f9027s = fVar.f9016s;
            this.f9021c5 = fVar.f9010c5;
            this.f9025i9 = fVar.f9014i9;
            this.f9022f = fVar.f9011f;
            this.f9028t = fVar.f9017t;
        }
    }

    public f() {
        this.y = s.n3();
        this.f9015n3 = s.n3();
        this.f9019zn = s.n3();
        this.f9013gv = s.n3();
        this.f9018v = new hx.y(0.0f);
        this.f9009a = new hx.y(0.0f);
        this.f9012fb = new hx.y(0.0f);
        this.f9016s = new hx.y(0.0f);
        this.f9010c5 = s.zn();
        this.f9014i9 = s.zn();
        this.f9011f = s.zn();
        this.f9017t = s.zn();
    }
}
