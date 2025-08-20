package cs;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class gv {
    public static final String y = l.f.a("PackageManagerHelper");

    public static void y(@NonNull Context context, @NonNull Class<?> cls, boolean z2) {
        int i;
        Object obj;
        String str = "disabled";
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, cls.getName());
            if (z2) {
                i = 1;
            } else {
                i = 2;
            }
            packageManager.setComponentEnabledSetting(componentName, i, 1);
            l.f zn2 = l.f.zn();
            String str2 = y;
            String name = cls.getName();
            if (!z2) {
                obj = "disabled";
            } else {
                obj = "enabled";
            }
            zn2.y(str2, String.format("%s %s", name, obj), new Throwable[0]);
        } catch (Exception e2) {
            l.f zn3 = l.f.zn();
            String str3 = y;
            String name2 = cls.getName();
            if (z2) {
                str = "enabled";
            }
            zn3.y(str3, String.format("%s could not be %s", name2, str), e2);
        }
    }
}
