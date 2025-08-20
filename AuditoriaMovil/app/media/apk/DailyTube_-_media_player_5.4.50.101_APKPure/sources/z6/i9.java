package z6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.v;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import k5.fb;
/* loaded from: classes.dex */
public class i9 {
    @SuppressLint({"BanConcurrentHashMap"})
    public ConcurrentHashMap<Long, v.zn> y = new ConcurrentHashMap<>();

    /* loaded from: classes.dex */
    public interface n3<T> {
        int n3(T t2);

        boolean y(T t2);
    }

    /* loaded from: classes.dex */
    public class y implements n3<fb.n3> {
        public y() {
        }

        @Override // z6.i9.n3
        /* renamed from: gv */
        public boolean y(fb.n3 n3Var) {
            return n3Var.a();
        }

        @Override // z6.i9.n3
        /* renamed from: zn */
        public int n3(fb.n3 n3Var) {
            return n3Var.v();
        }
    }

    public static <T> T a(T[] tArr, int i, boolean z2, n3<T> n3Var) {
        int i5;
        T t2 = null;
        int i6 = Integer.MAX_VALUE;
        for (T t3 : tArr) {
            int abs = Math.abs(n3Var.n3(t3) - i) * 2;
            if (n3Var.y(t3) == z2) {
                i5 = 0;
            } else {
                i5 = 1;
            }
            int i8 = abs + i5;
            if (t2 == null || i6 > i8) {
                t2 = t3;
                i6 = i8;
            }
        }
        return t2;
    }

    public static <T> T v(T[] tArr, int i, n3<T> n3Var) {
        int i5;
        boolean z2;
        if ((i & 1) == 0) {
            i5 = 400;
        } else {
            i5 = 700;
        }
        if ((i & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        return (T) a(tArr, i5, z2, n3Var);
    }

    public fb.n3 fb(fb.n3[] n3VarArr, int i) {
        return (fb.n3) v(n3VarArr, i, new y());
    }

    @Nullable
    public Typeface gv(Context context, Resources resources, int i, String str, int i5) {
        File v2 = f.v(context);
        if (v2 == null) {
            return null;
        }
        try {
            if (!f.zn(v2, resources, i)) {
                return null;
            }
            return Typeface.createFromFile(v2.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            v2.delete();
        }
    }

    @Nullable
    public Typeface n3(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull fb.n3[] n3VarArr, int i) {
        throw null;
    }

    @Nullable
    public Typeface y(Context context, v.zn znVar, Resources resources, int i) {
        throw null;
    }

    public Typeface zn(Context context, InputStream inputStream) {
        File v2 = f.v(context);
        if (v2 == null) {
            return null;
        }
        try {
            if (!f.gv(v2, inputStream)) {
                return null;
            }
            return Typeface.createFromFile(v2.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            v2.delete();
        }
    }
}
