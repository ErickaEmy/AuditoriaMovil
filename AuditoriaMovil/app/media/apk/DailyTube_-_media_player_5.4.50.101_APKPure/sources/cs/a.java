package cs;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final String y = l.f.a("ProcessUtils");

    public static boolean n3(@NonNull Context context, @NonNull androidx.work.y yVar) {
        String y2 = y(context);
        if (!TextUtils.isEmpty(yVar.zn())) {
            return TextUtils.equals(y2, yVar.zn());
        }
        return TextUtils.equals(y2, context.getApplicationInfo().processName);
    }

    @Nullable
    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    public static String y(@NonNull Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, a.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (Throwable th) {
            l.f.zn().y(y, "Unable to check ActivityThread for processName", th);
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }
}
