package b;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: gv  reason: collision with root package name */
    public static final int f3828gv;

    /* renamed from: n3  reason: collision with root package name */
    public static final int f3829n3;

    /* renamed from: v  reason: collision with root package name */
    public static final int f3830v;
    public static final y y = new y();

    /* renamed from: zn  reason: collision with root package name */
    public static final int f3831zn;

    /* renamed from: b.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0035y {
        public static final C0035y y = new C0035y();

        public final int y(int i) {
            return SdkExtensions.getExtensionVersion(i);
        }
    }

    static {
        int i;
        int i5;
        int i6;
        int i8 = Build.VERSION.SDK_INT;
        int i10 = 0;
        if (i8 >= 30) {
            i = C0035y.y.y(30);
        } else {
            i = 0;
        }
        f3829n3 = i;
        if (i8 >= 30) {
            i5 = C0035y.y.y(31);
        } else {
            i5 = 0;
        }
        f3831zn = i5;
        if (i8 >= 30) {
            i6 = C0035y.y.y(33);
        } else {
            i6 = 0;
        }
        f3828gv = i6;
        if (i8 >= 30) {
            i10 = C0035y.y.y(1000000);
        }
        f3830v = i10;
    }

    public static final boolean n3() {
        int i = Build.VERSION.SDK_INT;
        if (i < 31) {
            if (i >= 30) {
                String CODENAME = Build.VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(CODENAME, "CODENAME");
                if (y("S", CODENAME)) {
                }
            }
            return false;
        }
        return true;
    }

    public static final boolean y(String codename, String buildCodename) {
        Intrinsics.checkNotNullParameter(codename, "codename");
        Intrinsics.checkNotNullParameter(buildCodename, "buildCodename");
        if (Intrinsics.areEqual("REL", buildCodename)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = buildCodename.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = codename.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.compareTo(upperCase2) < 0) {
            return false;
        }
        return true;
    }

    public static final boolean zn() {
        int i = Build.VERSION.SDK_INT;
        if (i < 34) {
            if (i >= 33) {
                String CODENAME = Build.VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(CODENAME, "CODENAME");
                if (y("UpsideDownCake", CODENAME)) {
                }
            }
            return false;
        }
        return true;
    }
}
