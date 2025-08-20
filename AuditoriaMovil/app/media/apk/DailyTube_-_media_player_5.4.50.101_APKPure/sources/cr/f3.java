package cr;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class f3 {

    /* renamed from: n3  reason: collision with root package name */
    public static final Property<View, Float> f6765n3;
    public static final mg y;

    /* renamed from: zn  reason: collision with root package name */
    public static final Property<View, Rect> f6766zn;

    /* loaded from: classes.dex */
    public class n3 extends Property<View, Rect> {
        public n3(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(View view, Rect rect) {
            hw.i4.tg(view, rect);
        }

        @Override // android.util.Property
        /* renamed from: y */
        public Rect get(View view) {
            return hw.i4.i4(view);
        }
    }

    /* loaded from: classes.dex */
    public class y extends Property<View, Float> {
        public y(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(View view, Float f4) {
            f3.fb(view, f4.floatValue());
        }

        @Override // android.util.Property
        /* renamed from: y */
        public Float get(View view) {
            return Float.valueOf(f3.zn(view));
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            y = new rz();
        } else if (i >= 23) {
            y = new fh();
        } else if (i >= 22) {
            y = new d0();
        } else {
            y = new c();
        }
        f6765n3 = new y(Float.class, "translationAlpha");
        f6766zn = new n3(Rect.class, "clipBounds");
    }

    public static void a(@NonNull View view, int i, int i5, int i6, int i8) {
        y.v(view, i, i5, i6, i8);
    }

    public static void c5(@NonNull View view, @NonNull Matrix matrix) {
        y.s(view, matrix);
    }

    public static void fb(@NonNull View view, float f4) {
        y.a(view, f4);
    }

    public static z6 gv(@NonNull View view) {
        return new d(view);
    }

    public static void i9(@NonNull View view, @NonNull Matrix matrix) {
        y.c5(view, matrix);
    }

    public static i4 n3(@NonNull View view) {
        return new x4(view);
    }

    public static void s(@NonNull View view, int i) {
        y.fb(view, i);
    }

    public static void v(@NonNull View view) {
        y.gv(view);
    }

    public static void y(@NonNull View view) {
        y.y(view);
    }

    public static float zn(@NonNull View view) {
        return y.zn(view);
    }
}
