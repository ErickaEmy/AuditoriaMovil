package ta1;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import db1.z;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
/* loaded from: classes.dex */
public final class zn {
    public static final zn y = new zn();

    /* renamed from: n3  reason: collision with root package name */
    public static final byte[] f13956n3 = {111, 102, 102, 105, 99, 105, 97, 108, 112, 107, 103};

    public static final n3 n3(Context context, String str, boolean z2) {
        ApplicationInfo applicationInfo;
        n3 n3Var;
        if (str == null || Intrinsics.areEqual("", str)) {
            return null;
        }
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null) {
                    applicationInfo = packageInfo.applicationInfo;
                } else {
                    applicationInfo = null;
                }
                if (applicationInfo == null) {
                    return null;
                }
                n3Var = new n3();
                n3Var.n3(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                n3Var.zn(packageInfo.firstInstallTime);
                n3Var.v(packageInfo.lastUpdateTime);
                n3Var.a(packageInfo.packageName);
                n3Var.fb(packageInfo.versionCode);
                n3Var.s(packageInfo.versionName);
                if (z2) {
                    n3Var.gv(packageInfo.applicationInfo.loadIcon(packageManager));
                }
            } catch (Exception unused) {
                return null;
            }
        }
        return n3Var;
    }

    public static final n3 y(Context context, String str) {
        return n3(context, str, false);
    }

    public final String a(byte[] bArr) {
        return z.y.n3(bArr);
    }

    public final Signature gv(Application application) {
        PackageManager packageManager;
        Object m28constructorimpl;
        Signature[] signatureArr;
        String packageName = application.getPackageName();
        if (packageName == null) {
            return null;
        }
        if (packageName.length() <= 0) {
            packageName = null;
        }
        if (packageName == null || (packageManager = application.getPackageManager()) == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            if (Build.VERSION.SDK_INT >= 28) {
                signatureArr = packageManager.getPackageInfo(packageName, 134217728).signingInfo.getApkContentsSigners();
            } else {
                signatureArr = packageManager.getPackageInfo(packageName, 64).signatures;
            }
            m28constructorimpl = Result.m28constructorimpl(signatureArr);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m32isFailureimpl(m28constructorimpl)) {
            m28constructorimpl = null;
        }
        Signature[] signatureArr2 = (Signature[]) m28constructorimpl;
        if (signatureArr2 == null) {
            return null;
        }
        return (Signature) ArraysKt.firstOrNull(signatureArr2);
    }

    public final String v(Context context) {
        String str;
        Application zn2;
        if (context != null && (zn2 = wa1.n3.zn(context)) != null) {
            str = zn2.getPackageName();
        } else {
            str = null;
        }
        n3 y2 = y(context, str);
        if (y2 == null) {
            return null;
        }
        return y2.y();
    }

    public final String zn(Application appContext) {
        byte[] byteArray;
        String a2;
        byte[] plus;
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Signature gv2 = gv(appContext);
        if (gv2 != null && (byteArray = gv2.toByteArray()) != null && (a2 = a(byteArray)) != null) {
            byte[] bytes = a2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            if (bytes != null && (plus = ArraysKt.plus(bytes, f13956n3)) != null) {
                return a(plus);
            }
        }
        return null;
    }
}
