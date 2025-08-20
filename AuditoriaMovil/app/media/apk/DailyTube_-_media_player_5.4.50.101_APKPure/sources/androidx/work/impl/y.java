package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class y {
    @NonNull
    public static g3.y y = new C0031y(1, 2);
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public static g3.y f3769n3 = new n3(3, 4);
    @NonNull

    /* renamed from: zn  reason: collision with root package name */
    public static g3.y f3771zn = new zn(4, 5);
    @NonNull

    /* renamed from: gv  reason: collision with root package name */
    public static g3.y f3768gv = new gv(6, 7);
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public static g3.y f3770v = new v(7, 8);
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static g3.y f3766a = new a(8, 9);
    @NonNull

    /* renamed from: fb  reason: collision with root package name */
    public static g3.y f3767fb = new fb(11, 12);

    /* loaded from: classes.dex */
    public class a extends g3.y {
        public a(int i, int i5) {
            super(i, i5);
        }

        @Override // g3.y
        public void migrate(@NonNull u0.fb fbVar) {
            fbVar.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes.dex */
    public static class c5 extends g3.y {
        public final Context y;

        public c5(@NonNull Context context) {
            super(9, 10);
            this.y = context;
        }

        @Override // g3.y
        public void migrate(@NonNull u0.fb fbVar) {
            fbVar.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            cs.v.n3(this.y, fbVar);
            cs.zn.y(this.y, fbVar);
        }
    }

    /* loaded from: classes.dex */
    public class fb extends g3.y {
        public fb(int i, int i5) {
            super(i, i5);
        }

        @Override // g3.y
        public void migrate(@NonNull u0.fb fbVar) {
            fbVar.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes.dex */
    public class gv extends g3.y {
        public gv(int i, int i5) {
            super(i, i5);
        }

        @Override // g3.y
        public void migrate(@NonNull u0.fb fbVar) {
            fbVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends g3.y {
        public n3(int i, int i5) {
            super(i, i5);
        }

        @Override // g3.y
        public void migrate(@NonNull u0.fb fbVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                fbVar.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class s extends g3.y {
        public final Context y;

        public s(@NonNull Context context, int i, int i5) {
            super(i, i5);
            this.y = context;
        }

        @Override // g3.y
        public void migrate(@NonNull u0.fb fbVar) {
            if (this.endVersion >= 10) {
                fbVar.fh("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
            } else {
                this.y.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
            }
        }
    }

    /* loaded from: classes.dex */
    public class v extends g3.y {
        public v(int i, int i5) {
            super(i, i5);
        }

        @Override // g3.y
        public void migrate(@NonNull u0.fb fbVar) {
            fbVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    /* renamed from: androidx.work.impl.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0031y extends g3.y {
        public C0031y(int i, int i5) {
            super(i, i5);
        }

        @Override // g3.y
        public void migrate(@NonNull u0.fb fbVar) {
            fbVar.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            fbVar.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            fbVar.execSQL("DROP TABLE IF EXISTS alarmInfo");
            fbVar.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    /* loaded from: classes.dex */
    public class zn extends g3.y {
        public zn(int i, int i5) {
            super(i, i5);
        }

        @Override // g3.y
        public void migrate(@NonNull u0.fb fbVar) {
            fbVar.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            fbVar.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }
}
