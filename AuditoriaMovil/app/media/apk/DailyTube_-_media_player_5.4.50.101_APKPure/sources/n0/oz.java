package n0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import j0.zn;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class oz {

    /* renamed from: zn  reason: collision with root package name */
    public static final zn f11801zn = new zn("SplitInstallInfoProvider");

    /* renamed from: n3  reason: collision with root package name */
    public final String f11802n3;
    public final Context y;

    public oz(Context context) {
        this.y = context;
        this.f11802n3 = context.getPackageName();
    }

    public static boolean a(String str) {
        if (!str.startsWith("config.") && !str.contains(".config.")) {
            return false;
        }
        return true;
    }

    public static String n3(String str) {
        if (str.startsWith("config.")) {
            return "";
        }
        return str.split("\\.config\\.", 2)[0];
    }

    public static boolean v(String str) {
        return str.startsWith("config.");
    }

    @Nullable
    public final Bundle fb() {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = this.y.getPackageManager().getApplicationInfo(this.f11802n3, NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                return bundle;
            }
            f11801zn.y("App has no applicationInfo or metaData", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            f11801zn.v("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }

    @Nullable
    public final Set gv() {
        k5 y = y();
        if (y == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Set s2 = s();
        s2.add("");
        Set zn2 = zn();
        zn2.add("");
        for (Map.Entry entry : y.y(zn2).entrySet()) {
            if (s2.containsAll((Collection) entry.getValue())) {
                hashSet.add((String) entry.getKey());
            }
        }
        return hashSet;
    }

    public final Set s() {
        HashSet hashSet = new HashSet();
        Bundle fb2 = fb();
        if (fb2 != null) {
            String string = fb2.getString("com.android.dynamic.apk.fused.modules");
            if (string != null && !string.isEmpty()) {
                Collections.addAll(hashSet, string.split(",", -1));
                hashSet.remove("");
                hashSet.remove("base");
            } else {
                f11801zn.y("App has no fused modules.", new Object[0]);
            }
        }
        String[] strArr = null;
        try {
            PackageInfo packageInfo = this.y.getPackageManager().getPackageInfo(this.f11802n3, 0);
            if (packageInfo != null) {
                strArr = packageInfo.splitNames;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            f11801zn.v("App is not found in PackageManager", new Object[0]);
        }
        if (strArr != null) {
            f11801zn.y("Adding splits from package manager: %s", Arrays.toString(strArr));
            Collections.addAll(hashSet, strArr);
        } else {
            f11801zn.y("No splits are found or app cannot be found in package manager.", new Object[0]);
        }
        o y = j.y();
        if (y != null) {
            hashSet.addAll(y.zza());
        }
        return hashSet;
    }

    @Nullable
    public final k5 y() {
        Bundle fb2 = fb();
        if (fb2 == null) {
            f11801zn.v("No metadata found in Context.", new Object[0]);
            return null;
        }
        int i = fb2.getInt("com.android.vending.splits");
        if (i == 0) {
            f11801zn.v("No metadata found in AndroidManifest.", new Object[0]);
            return null;
        }
        try {
            k5 y = mg.y(this.y.getResources().getXml(i), new x());
            if (y == null) {
                f11801zn.v("Can't parse languages metadata.", new Object[0]);
            }
            return y;
        } catch (Resources.NotFoundException unused) {
            f11801zn.v("Resource with languages metadata doesn't exist.", new Object[0]);
            return null;
        }
    }

    public final Set zn() {
        HashSet hashSet = new HashSet();
        for (String str : s()) {
            if (!a(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }
}
