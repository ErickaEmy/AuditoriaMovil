package ur;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import hw.ej;
import hw.i4;
import hw.w;
/* loaded from: classes.dex */
public class f {

    /* loaded from: classes.dex */
    public static class y implements w {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ gv f14089n3;
        public final /* synthetic */ zn y;

        public y(zn znVar, gv gvVar) {
            this.y = znVar;
            this.f14089n3 = gvVar;
        }

        @Override // hw.w
        public ej y(View view, ej ejVar) {
            return this.y.y(view, ejVar, new gv(this.f14089n3));
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        ej y(View view, ej ejVar, gv gvVar);
    }

    public static void a(@NonNull View view) {
        if (i4.ut(view)) {
            i4.yg(view);
        } else {
            view.addOnAttachStateChangeListener(new n3());
        }
    }

    public static boolean gv(View view) {
        if (i4.ta(view) == 1) {
            return true;
        }
        return false;
    }

    public static float n3(@NonNull Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static PorterDuff.Mode v(int i, PorterDuff.Mode mode) {
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

    public static void y(@NonNull View view, @NonNull zn znVar) {
        i4.ad(view, new y(znVar, new gv(i4.a8(view), view.getPaddingTop(), i4.ud(view), view.getPaddingBottom())));
        a(view);
    }

    public static float zn(@NonNull View view) {
        float f4 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f4 += i4.n((View) parent);
        }
        return f4;
    }

    /* loaded from: classes.dex */
    public static class gv {

        /* renamed from: gv  reason: collision with root package name */
        public int f14086gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f14087n3;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f14088zn;

        public gv(int i, int i5, int i6, int i8) {
            this.y = i;
            this.f14087n3 = i5;
            this.f14088zn = i6;
            this.f14086gv = i8;
        }

        public gv(@NonNull gv gvVar) {
            this.y = gvVar.y;
            this.f14087n3 = gvVar.f14087n3;
            this.f14088zn = gvVar.f14088zn;
            this.f14086gv = gvVar.f14086gv;
        }
    }

    /* loaded from: classes.dex */
    public static class n3 implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            view.removeOnAttachStateChangeListener(this);
            i4.yg(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
