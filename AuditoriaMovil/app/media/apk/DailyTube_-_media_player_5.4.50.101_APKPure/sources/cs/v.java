package cs;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
/* loaded from: classes.dex */
public class v {
    public final WorkDatabase y;

    public v(@NonNull WorkDatabase workDatabase) {
        this.y = workDatabase;
    }

    public static void n3(@NonNull Context context, @NonNull u0.fb fbVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j2 = 0;
            long j4 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
            if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                j2 = 1;
            }
            fbVar.fb();
            try {
                fbVar.fh("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j4)});
                fbVar.fh("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j2)});
                sharedPreferences.edit().clear().apply();
                fbVar.d0();
            } finally {
                fbVar.z6();
            }
        }
    }

    public boolean y() {
        Long n32 = this.y.fb().n3("reschedule_needed");
        if (n32 != null && n32.longValue() == 1) {
            return true;
        }
        return false;
    }

    public void zn(boolean z2) {
        this.y.fb().y(new le.gv("reschedule_needed", z2));
    }
}
