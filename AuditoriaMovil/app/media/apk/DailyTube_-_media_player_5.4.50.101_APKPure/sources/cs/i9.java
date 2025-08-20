package cs;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class i9 {
    public static final String y = l.f.a("WakeLocks");

    /* renamed from: n3  reason: collision with root package name */
    public static final WeakHashMap<PowerManager.WakeLock, String> f6865n3 = new WeakHashMap<>();

    public static PowerManager.WakeLock n3(@NonNull Context context, @NonNull String str) {
        String str2 = "WorkManager: " + str;
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, str2);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = f6865n3;
        synchronized (weakHashMap) {
            weakHashMap.put(newWakeLock, str2);
        }
        return newWakeLock;
    }

    public static void y() {
        HashMap hashMap = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = f6865n3;
        synchronized (weakHashMap) {
            hashMap.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                l.f.zn().s(y, String.format("WakeLock held for %s", hashMap.get(wakeLock)), new Throwable[0]);
            }
        }
    }
}
