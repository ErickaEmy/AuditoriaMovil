package z6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.s;
import d.v;
import k5.fb;
/* loaded from: classes.dex */
public class gv {

    /* renamed from: n3  reason: collision with root package name */
    public static final z.a<String, Typeface> f15661n3;
    public static final i9 y;

    /* loaded from: classes.dex */
    public static class y extends fb.zn {
        @Nullable
        public s.v y;

        public y(@Nullable s.v vVar) {
            this.y = vVar;
        }

        @Override // k5.fb.zn
        public void n3(@NonNull Typeface typeface) {
            s.v vVar = this.y;
            if (vVar != null) {
                vVar.fb(typeface);
            }
        }

        @Override // k5.fb.zn
        public void y(int i) {
            s.v vVar = this.y;
            if (vVar != null) {
                vVar.a(i);
            }
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            y = new c5();
        } else if (i >= 28) {
            y = new s();
        } else if (i >= 26) {
            y = new fb();
        } else if (i >= 24 && a.i9()) {
            y = new a();
        } else {
            y = new v();
        }
        f15661n3 = new z.a<>(16);
    }

    @Nullable
    public static Typeface a(@NonNull Resources resources, int i, @Nullable String str, int i5, int i6) {
        return f15661n3.get(v(resources, i, str, i5, i6));
    }

    public static Typeface fb(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }

    @Nullable
    public static Typeface gv(@NonNull Context context, @NonNull Resources resources, int i, String str, int i5, int i6) {
        Typeface gv2 = y.gv(context, resources, i, str, i6);
        if (gv2 != null) {
            f15661n3.put(v(resources, i, str, i5, i6), gv2);
        }
        return gv2;
    }

    @Nullable
    public static Typeface n3(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull fb.n3[] n3VarArr, int i) {
        return y.n3(context, cancellationSignal, n3VarArr, i);
    }

    public static String v(Resources resources, int i, String str, int i5, int i6) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i5 + '-' + i + '-' + i6;
    }

    @NonNull
    public static Typeface y(@NonNull Context context, @Nullable Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @Nullable
    public static Typeface zn(@NonNull Context context, @NonNull v.n3 n3Var, @NonNull Resources resources, int i, @Nullable String str, int i5, int i6, @Nullable s.v vVar, @Nullable Handler handler, boolean z2) {
        Typeface y2;
        boolean z3;
        int i8;
        if (n3Var instanceof v.C0078v) {
            v.C0078v c0078v = (v.C0078v) n3Var;
            Typeface fb2 = fb(c0078v.zn());
            if (fb2 != null) {
                if (vVar != null) {
                    vVar.gv(fb2, handler);
                }
                return fb2;
            }
            if (!z2 ? vVar == null : c0078v.y() == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2) {
                i8 = c0078v.gv();
            } else {
                i8 = -1;
            }
            y2 = k5.fb.y(context, c0078v.n3(), i6, z3, i8, s.v.v(handler), new y(vVar));
        } else {
            y2 = y.y(context, (v.zn) n3Var, resources, i6);
            if (vVar != null) {
                if (y2 != null) {
                    vVar.gv(y2, handler);
                } else {
                    vVar.zn(-3, handler);
                }
            }
        }
        if (y2 != null) {
            f15661n3.put(v(resources, i, str, i5, i6), y2);
        }
        return y2;
    }
}
