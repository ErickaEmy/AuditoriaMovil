package mg;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import rz.v;
/* loaded from: classes.dex */
public final class zn {
    public static int n3(@NonNull Context context, @NonNull String str, int i, int i5, @Nullable String str2) {
        int n32;
        if (context.checkPermission(str, i, i5) == -1) {
            return -1;
        }
        String zn2 = v.zn(str);
        if (zn2 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i5);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (myUid == i5 && vl.zn.y(packageName, str2)) {
            n32 = v.y(context, i5, zn2, str2);
        } else {
            n32 = v.n3(context, zn2, str2);
        }
        if (n32 == 0) {
            return 0;
        }
        return -2;
    }

    public static int y(@NonNull Context context, @NonNull String str) {
        String str2;
        if (Binder.getCallingPid() == Process.myPid()) {
            str2 = context.getPackageName();
        } else {
            str2 = null;
        }
        return n3(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }

    public static int zn(@NonNull Context context, @NonNull String str) {
        return n3(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
