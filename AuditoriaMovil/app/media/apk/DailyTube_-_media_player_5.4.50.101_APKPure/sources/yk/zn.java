package yk;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.xc;
/* loaded from: classes.dex */
public class zn {

    /* renamed from: a  reason: collision with root package name */
    public static int f15468a = 0;

    /* renamed from: c5  reason: collision with root package name */
    public static gf.v f15469c5 = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile gf.fb f15470f = null;

    /* renamed from: fb  reason: collision with root package name */
    public static int f15471fb = 0;

    /* renamed from: gv  reason: collision with root package name */
    public static String[] f15472gv = null;

    /* renamed from: i9  reason: collision with root package name */
    public static volatile gf.s f15473i9 = null;

    /* renamed from: n3  reason: collision with root package name */
    public static boolean f15474n3 = true;

    /* renamed from: s  reason: collision with root package name */
    public static gf.a f15475s = null;

    /* renamed from: v  reason: collision with root package name */
    public static long[] f15476v = null;
    public static boolean y = false;

    /* renamed from: zn  reason: collision with root package name */
    public static boolean f15477zn = true;

    @Nullable
    public static gf.fb gv(@NonNull Context context) {
        if (!f15474n3) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        gf.fb fbVar = f15470f;
        if (fbVar == null) {
            synchronized (gf.fb.class) {
                try {
                    fbVar = f15470f;
                    if (fbVar == null) {
                        gf.v vVar = f15469c5;
                        if (vVar == null) {
                            vVar = new y(applicationContext);
                        }
                        fbVar = new gf.fb(vVar);
                        f15470f = fbVar;
                    }
                } finally {
                }
            }
        }
        return fbVar;
    }

    public static float n3(String str) {
        int i = f15471fb;
        if (i > 0) {
            f15471fb = i - 1;
            return 0.0f;
        } else if (!y) {
            return 0.0f;
        } else {
            int i5 = f15468a - 1;
            f15468a = i5;
            if (i5 != -1) {
                if (str.equals(f15472gv[i5])) {
                    xc.n3();
                    return ((float) (System.nanoTime() - f15476v[f15468a])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f15472gv[f15468a] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
    }

    @NonNull
    public static gf.s v(@NonNull Context context) {
        gf.s sVar = f15473i9;
        if (sVar == null) {
            synchronized (gf.s.class) {
                try {
                    sVar = f15473i9;
                    if (sVar == null) {
                        gf.fb gv2 = gv(context);
                        gf.a aVar = f15475s;
                        if (aVar == null) {
                            aVar = new gf.n3();
                        }
                        sVar = new gf.s(gv2, aVar);
                        f15473i9 = sVar;
                    }
                } finally {
                }
            }
        }
        return sVar;
    }

    public static void y(String str) {
        if (!y) {
            return;
        }
        int i = f15468a;
        if (i == 20) {
            f15471fb++;
            return;
        }
        f15472gv[i] = str;
        f15476v[i] = System.nanoTime();
        xc.y(str);
        f15468a++;
    }

    public static boolean zn() {
        return f15477zn;
    }
}
