package oa;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
import cs.zn;
import gq.c5;
import l.f;
import le.fb;
import le.s;
/* loaded from: classes.dex */
public class y {
    public static final String y = f.a("Alarms");

    public static void gv(@NonNull Context context, @NonNull String str, int i, long j2) {
        int i5;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (Build.VERSION.SDK_INT >= 23) {
            i5 = 201326592;
        } else {
            i5 = 134217728;
        }
        PendingIntent service = PendingIntent.getService(context, i, androidx.work.impl.background.systemalarm.y.n3(context, str), i5);
        if (alarmManager != null) {
            alarmManager.setExact(0, j2, service);
        }
    }

    public static void n3(@NonNull Context context, @NonNull String str, int i) {
        int i5;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent n32 = androidx.work.impl.background.systemalarm.y.n3(context, str);
        if (Build.VERSION.SDK_INT >= 23) {
            i5 = 603979776;
        } else {
            i5 = 536870912;
        }
        PendingIntent service = PendingIntent.getService(context, i, n32, i5);
        if (service != null && alarmManager != null) {
            f.zn().y(y, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i)), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    public static void y(@NonNull Context context, @NonNull c5 c5Var, @NonNull String str) {
        s s2 = c5Var.co().s();
        fb y2 = s2.y(str);
        if (y2 != null) {
            n3(context, str, y2.f10314n3);
            f.zn().y(y, String.format("Removing SystemIdInfo for workSpecId (%s)", str), new Throwable[0]);
            s2.gv(str);
        }
    }

    public static void zn(@NonNull Context context, @NonNull c5 c5Var, @NonNull String str, long j2) {
        WorkDatabase co2 = c5Var.co();
        s s2 = co2.s();
        fb y2 = s2.y(str);
        if (y2 != null) {
            n3(context, str, y2.f10314n3);
            gv(context, str, y2.f10314n3, j2);
            return;
        }
        int n32 = new zn(co2).n3();
        s2.n3(new fb(str, n32));
        gv(context, str, n32, j2);
    }
}
