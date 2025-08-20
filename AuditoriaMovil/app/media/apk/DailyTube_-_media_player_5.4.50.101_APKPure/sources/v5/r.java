package v5;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.net.UnknownHostException;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: n3  reason: collision with root package name */
    public static int f14386n3 = 0;

    /* renamed from: zn  reason: collision with root package name */
    public static boolean f14387zn = true;
    public static final Object y = new Object();

    /* renamed from: gv  reason: collision with root package name */
    public static y f14385gv = y.y;

    public static void a(String str, String str2) {
        synchronized (y) {
            try {
                if (f14386n3 <= 1) {
                    f14385gv.zn(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c5(String str, String str2) {
        synchronized (y) {
            try {
                if (f14386n3 <= 2) {
                    f14385gv.w(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void fb(String str, String str2, @Nullable Throwable th) {
        a(str, y(str2, th));
    }

    public static void gv(String str, String str2, @Nullable Throwable th) {
        zn(str, y(str2, th));
    }

    public static void i9(String str, String str2, @Nullable Throwable th) {
        c5(str, y(str2, th));
    }

    public static void n3(String str, String str2) {
        synchronized (y) {
            try {
                if (f14386n3 == 0) {
                    f14385gv.n3(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean s(@Nullable Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    @Nullable
    public static String v(@Nullable Throwable th) {
        synchronized (y) {
            try {
                if (th == null) {
                    return null;
                }
                if (s(th)) {
                    return "UnknownHostException (no network)";
                }
                if (!f14387zn) {
                    return th.getMessage();
                }
                return Log.getStackTraceString(th).trim().replace("\t", "    ");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String y(String str, @Nullable Throwable th) {
        String v2 = v(th);
        if (!TextUtils.isEmpty(v2)) {
            return str + "\n  " + v2.replace("\n", "\n  ") + '\n';
        }
        return str;
    }

    public static void zn(String str, String str2) {
        synchronized (y) {
            try {
                if (f14386n3 <= 3) {
                    f14385gv.y(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface y {
        public static final y y = new C0236y();

        void n3(String str, String str2);

        void w(String str, String str2);

        void y(String str, String str2);

        void zn(String str, String str2);

        /* renamed from: v5.r$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0236y implements y {
            @Override // v5.r.y
            public void w(String str, String str2) {
                Log.w(str, str2);
            }

            @Override // v5.r.y
            public void y(String str, String str2) {
                Log.e(str, str2);
            }

            @Override // v5.r.y
            public void n3(String str, String str2) {
            }

            @Override // v5.r.y
            public void zn(String str, String str2) {
            }
        }
    }
}
