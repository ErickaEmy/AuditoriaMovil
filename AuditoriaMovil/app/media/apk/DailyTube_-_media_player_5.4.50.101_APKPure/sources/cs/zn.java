package cs;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
/* loaded from: classes.dex */
public class zn {
    public final WorkDatabase y;

    public zn(@NonNull WorkDatabase workDatabase) {
        this.y = workDatabase;
    }

    public static void y(@NonNull Context context, @NonNull u0.fb fbVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i5 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            fbVar.fb();
            try {
                fbVar.fh("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i)});
                fbVar.fh("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i5)});
                sharedPreferences.edit().clear().apply();
                fbVar.d0();
            } finally {
                fbVar.z6();
            }
        }
    }

    public int gv(int i, int i5) {
        synchronized (zn.class) {
            int zn2 = zn("next_job_scheduler_id");
            if (zn2 >= i && zn2 <= i5) {
                i = zn2;
            }
            v("next_job_scheduler_id", i + 1);
        }
        return i;
    }

    public int n3() {
        int zn2;
        synchronized (zn.class) {
            zn2 = zn("next_alarm_manager_id");
        }
        return zn2;
    }

    public final void v(String str, int i) {
        this.y.fb().y(new le.gv(str, i));
    }

    public final int zn(String str) {
        int i;
        this.y.beginTransaction();
        try {
            Long n32 = this.y.fb().n3(str);
            int i5 = 0;
            if (n32 != null) {
                i = n32.intValue();
            } else {
                i = 0;
            }
            if (i != Integer.MAX_VALUE) {
                i5 = i + 1;
            }
            v(str, i5);
            this.y.setTransactionSuccessful();
            this.y.endTransaction();
            return i;
        } catch (Throwable th) {
            this.y.endTransaction();
            throw th;
        }
    }
}
