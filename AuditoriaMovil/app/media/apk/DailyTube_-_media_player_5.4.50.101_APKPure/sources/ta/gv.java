package ta;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import ta.zn;
import vl.s;
/* loaded from: classes.dex */
public class gv {

    /* renamed from: n3  reason: collision with root package name */
    public static volatile List<y> f13920n3;
    public static volatile zn<?> y;

    public static List<y> a(Context context) {
        Bundle bundle;
        String string;
        if (f13920n3 == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("androidx.core.content.pm.SHORTCUT_LISTENER");
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, NotificationCompat.FLAG_HIGH_PRIORITY)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && (bundle = activityInfo.metaData) != null && (string = bundle.getString("androidx.core.content.pm.shortcut_listener_impl")) != null) {
                    try {
                        arrayList.add((y) Class.forName(string, false, gv.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context));
                    } catch (Exception unused) {
                    }
                }
            }
            if (f13920n3 == null) {
                f13920n3 = arrayList;
            }
        }
        return f13920n3;
    }

    public static void c5(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        }
        fb(context).zn();
        for (y yVar : a(context)) {
            yVar.y();
        }
    }

    @NonNull
    public static List<n3> f(@NonNull List<n3> list, int i) {
        Objects.requireNonNull(list);
        if (Build.VERSION.SDK_INT > 32) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        for (n3 n3Var : list) {
            if (n3Var.fb(i)) {
                arrayList.remove(n3Var);
            }
        }
        return arrayList;
    }

    public static zn<?> fb(Context context) {
        if (y == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    y = (zn) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, gv.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
                } catch (Exception unused) {
                }
            }
            if (y == null) {
                y = new zn.y();
            }
        }
        return y;
    }

    public static void gv(@NonNull Context context, @NonNull List<String> list, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).disableShortcuts(list, charSequence);
        }
        fb(context).gv(list);
        for (y yVar : a(context)) {
            yVar.zn(list);
        }
    }

    public static void i9(@NonNull Context context, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(list);
        }
        fb(context).gv(list);
        for (y yVar : a(context)) {
            yVar.zn(list);
        }
    }

    public static boolean n3(@NonNull Context context, @NonNull n3 n3Var) {
        Bitmap decodeStream;
        IconCompat fb2;
        IconCompat iconCompat = n3Var.f13923c5;
        if (iconCompat == null) {
            return false;
        }
        int i = iconCompat.y;
        if (i != 6 && i != 4) {
            return true;
        }
        InputStream p2 = iconCompat.p(context);
        if (p2 == null || (decodeStream = BitmapFactory.decodeStream(p2)) == null) {
            return false;
        }
        if (i == 6) {
            fb2 = IconCompat.gv(decodeStream);
        } else {
            fb2 = IconCompat.fb(decodeStream);
        }
        n3Var.f13923c5 = fb2;
        return true;
    }

    @NonNull
    public static List<n3> s(@NonNull Context context, int i) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            return n3.n3(context, ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getShortcuts(i));
        }
        if (i5 >= 25) {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
            ArrayList arrayList = new ArrayList();
            if ((i & 1) != 0) {
                arrayList.addAll(shortcutManager.getManifestShortcuts());
            }
            if ((i & 2) != 0) {
                arrayList.addAll(shortcutManager.getDynamicShortcuts());
            }
            if ((i & 4) != 0) {
                arrayList.addAll(shortcutManager.getPinnedShortcuts());
            }
            return n3.n3(context, arrayList);
        }
        if ((i & 2) != 0) {
            try {
                return fb(context).n3();
            } catch (Exception unused) {
            }
        }
        return Collections.emptyList();
    }

    public static int v(@NonNull Context context) {
        s.fb(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
        }
        return 5;
    }

    public static boolean y(@NonNull Context context, @NonNull List<n3> list) {
        List<n3> f4 = f(list, 1);
        int i = Build.VERSION.SDK_INT;
        if (i <= 29) {
            zn(context, f4);
        }
        if (i >= 25) {
            ArrayList arrayList = new ArrayList();
            for (n3 n3Var : f4) {
                arrayList.add(n3Var.s());
            }
            if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).addDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        fb(context).y(f4);
        for (y yVar : a(context)) {
            yVar.n3(list);
        }
        return true;
    }

    public static void zn(@NonNull Context context, @NonNull List<n3> list) {
        for (n3 n3Var : new ArrayList(list)) {
            if (!n3(context, n3Var)) {
                list.remove(n3Var);
            }
        }
    }
}
