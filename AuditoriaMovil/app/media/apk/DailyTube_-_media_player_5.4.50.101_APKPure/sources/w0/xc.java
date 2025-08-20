package w0;
/* loaded from: classes.dex */
public final class xc {
    public static void a(boolean z2, String str, int i) {
        if (z2) {
            return;
        }
        throw new IllegalArgumentException(co.n3(str, Integer.valueOf(i)));
    }

    public static void c5(boolean z2, String str, long j2) {
        if (z2) {
            return;
        }
        throw new IllegalArgumentException(co.n3(str, Long.valueOf(j2)));
    }

    public static void co(boolean z2) {
        if (z2) {
            return;
        }
        throw new IllegalStateException();
    }

    public static void f(boolean z2, String str, Object obj, Object obj2) {
        if (z2) {
            return;
        }
        throw new IllegalArgumentException(co.n3(str, obj, obj2));
    }

    public static void fb(boolean z2, String str, int i, int i5) {
        if (z2) {
            return;
        }
        throw new IllegalArgumentException(co.n3(str, Integer.valueOf(i), Integer.valueOf(i5)));
    }

    public static void gv(boolean z2) {
        if (z2) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void i9(boolean z2, String str, Object obj) {
        if (z2) {
            return;
        }
        throw new IllegalArgumentException(co.n3(str, obj));
    }

    public static void mt(int i, int i5, int i6) {
        if (i >= 0 && i5 >= i && i5 <= i6) {
            return;
        }
        throw new IndexOutOfBoundsException(zn(i, i5, i6));
    }

    public static String n3(int i, int i5, String str) {
        if (i < 0) {
            return co.n3("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i5 >= 0) {
            return co.n3("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i5));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i5);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int p(int i, int i5, String str) {
        if (i >= 0 && i <= i5) {
            return i;
        }
        throw new IndexOutOfBoundsException(n3(i, i5, str));
    }

    public static void r(boolean z2, String str, int i) {
        if (z2) {
            return;
        }
        throw new IllegalStateException(co.n3(str, Integer.valueOf(i)));
    }

    public static void s(boolean z2, String str, int i, Object obj) {
        if (z2) {
            return;
        }
        throw new IllegalArgumentException(co.n3(str, Integer.valueOf(i), obj));
    }

    public static int t(int i, int i5) {
        return tl(i, i5, "index");
    }

    public static int tl(int i, int i5, String str) {
        if (i >= 0 && i < i5) {
            return i;
        }
        throw new IndexOutOfBoundsException(y(i, i5, str));
    }

    public static void v(boolean z2, Object obj) {
        if (z2) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static int w(int i, int i5) {
        return p(i, i5, "index");
    }

    public static <T> T wz(T t2) {
        t2.getClass();
        return t2;
    }

    public static void x4(boolean z2, String str, Object obj) {
        if (z2) {
            return;
        }
        throw new IllegalStateException(co.n3(str, obj));
    }

    public static <T> T xc(T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static String y(int i, int i5, String str) {
        if (i < 0) {
            return co.n3("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i5 >= 0) {
            return co.n3("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i5));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i5);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void z(boolean z2, Object obj) {
        if (z2) {
            return;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }

    public static String zn(int i, int i5, int i6) {
        if (i >= 0 && i <= i6) {
            if (i5 >= 0 && i5 <= i6) {
                return co.n3("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i));
            }
            return n3(i5, i6, "end index");
        }
        return n3(i, i6, "start index");
    }
}
