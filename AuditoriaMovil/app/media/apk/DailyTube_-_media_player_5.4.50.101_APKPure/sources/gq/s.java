package gq;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import l.f;
/* loaded from: classes.dex */
public class s {
    public static final String y = f.a("WrkDbPathHelper");

    /* renamed from: n3  reason: collision with root package name */
    public static final String[] f8410n3 = {"-journal", "-shm", "-wal"};

    @NonNull
    public static Map<File, File> a(@NonNull Context context) {
        File n32;
        File y2;
        String[] strArr;
        HashMap hashMap = new HashMap();
        if (Build.VERSION.SDK_INT >= 23) {
            hashMap.put(n3(context), y(context));
            for (String str : f8410n3) {
                hashMap.put(new File(n32.getPath() + str), new File(y2.getPath() + str));
            }
        }
        return hashMap;
    }

    @NonNull
    public static String gv() {
        return "androidx.work.workdb";
    }

    @NonNull
    public static File n3(@NonNull Context context) {
        return context.getDatabasePath("androidx.work.workdb");
    }

    public static void v(@NonNull Context context) {
        String format;
        File n32 = n3(context);
        if (Build.VERSION.SDK_INT >= 23 && n32.exists()) {
            f.zn().y(y, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            Map<File, File> a2 = a(context);
            for (File file : a2.keySet()) {
                File file2 = a2.get(file);
                if (file.exists() && file2 != null) {
                    if (file2.exists()) {
                        f.zn().s(y, String.format("Over-writing contents of %s", file2), new Throwable[0]);
                    }
                    if (file.renameTo(file2)) {
                        format = String.format("Migrated %s to %s", file, file2);
                    } else {
                        format = String.format("Renaming %s to %s failed", file, file2);
                    }
                    f.zn().y(y, format, new Throwable[0]);
                }
            }
        }
    }

    @NonNull
    public static File y(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return n3(context);
        }
        return zn(context, "androidx.work.workdb");
    }

    public static File zn(@NonNull Context context, @NonNull String str) {
        return new File(context.getNoBackupFilesDir(), str);
    }
}
