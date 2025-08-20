package i7;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public interface gv {

    /* renamed from: i7.gv$gv  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0112gv extends Property<gv, Integer> {
        public static final Property<gv, Integer> y = new C0112gv("circularRevealScrimColor");

        public C0112gv(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(@NonNull gv gvVar, @NonNull Integer num) {
            gvVar.setCircularRevealScrimColor(num.intValue());
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: y */
        public Integer get(@NonNull gv gvVar) {
            return Integer.valueOf(gvVar.getCircularRevealScrimColor());
        }
    }

    /* loaded from: classes.dex */
    public static class n3 implements TypeEvaluator<v> {

        /* renamed from: n3  reason: collision with root package name */
        public static final TypeEvaluator<v> f9116n3 = new n3();
        public final v y = new v();

        @Override // android.animation.TypeEvaluator
        @NonNull
        /* renamed from: y */
        public v evaluate(float f4, @NonNull v vVar, @NonNull v vVar2) {
            this.y.y(s6.y.zn(vVar.y, vVar2.y, f4), s6.y.zn(vVar.f9117n3, vVar2.f9117n3, f4), s6.y.zn(vVar.f9118zn, vVar2.f9118zn, f4));
            return this.y;
        }
    }

    /* loaded from: classes.dex */
    public static class v {

        /* renamed from: n3  reason: collision with root package name */
        public float f9117n3;
        public float y;

        /* renamed from: zn  reason: collision with root package name */
        public float f9118zn;

        public void y(float f4, float f6, float f9) {
            this.y = f4;
            this.f9117n3 = f6;
            this.f9118zn = f9;
        }

        public v() {
        }

        public v(float f4, float f6, float f9) {
            this.y = f4;
            this.f9117n3 = f6;
            this.f9118zn = f9;
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends Property<gv, v> {
        public static final Property<gv, v> y = new zn("circularReveal");

        public zn(String str) {
            super(v.class, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(@NonNull gv gvVar, @Nullable v vVar) {
            gvVar.setRevealInfo(vVar);
        }

        @Override // android.util.Property
        @Nullable
        /* renamed from: y */
        public v get(@NonNull gv gvVar) {
            return gvVar.getRevealInfo();
        }
    }

    int getCircularRevealScrimColor();

    @Nullable
    v getRevealInfo();

    void n3();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(@Nullable v vVar);

    void y();
}
