package l;

import android.util.Log;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: n3  reason: collision with root package name */
    public static final int f10200n3 = 20;
    public static f y;

    public f(int i) {
    }

    public static String a(@NonNull String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i = f10200n3;
        if (length >= i) {
            sb.append(str.substring(0, i));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public static synchronized void v(f fVar) {
        synchronized (f.class) {
            y = fVar;
        }
    }

    public static synchronized f zn() {
        f fVar;
        synchronized (f.class) {
            try {
                if (y == null) {
                    y = new y(3);
                }
                fVar = y;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public abstract void fb(String str, String str2, Throwable... thArr);

    public abstract void gv(String str, String str2, Throwable... thArr);

    public abstract void n3(String str, String str2, Throwable... thArr);

    public abstract void s(String str, String str2, Throwable... thArr);

    public abstract void y(String str, String str2, Throwable... thArr);

    /* loaded from: classes.dex */
    public static class y extends f {

        /* renamed from: zn  reason: collision with root package name */
        public int f10201zn;

        public y(int i) {
            super(i);
            this.f10201zn = i;
        }

        @Override // l.f
        public void n3(String str, String str2, Throwable... thArr) {
            if (this.f10201zn <= 6) {
                if (thArr != null && thArr.length >= 1) {
                    Log.e(str, str2, thArr[0]);
                } else {
                    Log.e(str, str2);
                }
            }
        }

        @Override // l.f
        public void s(String str, String str2, Throwable... thArr) {
            if (this.f10201zn <= 5) {
                if (thArr != null && thArr.length >= 1) {
                    Log.w(str, str2, thArr[0]);
                } else {
                    Log.w(str, str2);
                }
            }
        }

        @Override // l.f
        public void fb(String str, String str2, Throwable... thArr) {
        }

        @Override // l.f
        public void gv(String str, String str2, Throwable... thArr) {
        }

        @Override // l.f
        public void y(String str, String str2, Throwable... thArr) {
        }
    }
}
