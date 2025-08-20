package androidx.work.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import le.a;
import le.c5;
import le.f;
import le.mt;
import le.n3;
import le.p;
import le.r;
import le.s;
import le.t;
import le.v;
import le.wz;
import le.xc;
import le.z;
import le.zn;
import m.v;
import rb.i4;
import rb.n;
import u0.fb;
import u0.s;
/* loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: c5  reason: collision with root package name */
    public volatile v f3689c5;

    /* renamed from: fb  reason: collision with root package name */
    public volatile f f3690fb;

    /* renamed from: gv  reason: collision with root package name */
    public volatile z f3691gv;

    /* renamed from: n3  reason: collision with root package name */
    public volatile p f3692n3;

    /* renamed from: s  reason: collision with root package name */
    public volatile wz f3693s;

    /* renamed from: v  reason: collision with root package name */
    public volatile s f3694v;

    /* renamed from: zn  reason: collision with root package name */
    public volatile n3 f3695zn;

    @Override // androidx.work.impl.WorkDatabase
    public f c5() {
        f fVar;
        if (this.f3690fb != null) {
            return this.f3690fb;
        }
        synchronized (this) {
            try {
                if (this.f3690fb == null) {
                    this.f3690fb = new t(this);
                }
                fVar = this.f3690fb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    @Override // rb.i4
    public void clearAllTables() {
        super.assertNotMainThread();
        fb writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
            writableDatabase.execSQL("DELETE FROM `Dependency`");
            writableDatabase.execSQL("DELETE FROM `WorkSpec`");
            writableDatabase.execSQL("DELETE FROM `WorkTag`");
            writableDatabase.execSQL("DELETE FROM `SystemIdInfo`");
            writableDatabase.execSQL("DELETE FROM `WorkName`");
            writableDatabase.execSQL("DELETE FROM `WorkProgress`");
            writableDatabase.execSQL("DELETE FROM `Preference`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.rb("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.xb()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // rb.i4
    public rb.p createInvalidationTracker() {
        return new rb.p(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // rb.i4
    public u0.s createOpenHelper(rb.s sVar) {
        return sVar.f13258zn.y(s.n3.y(sVar.y).zn(sVar.f13249n3).n3(new n(sVar, new y(12), "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6")).y());
    }

    @Override // androidx.work.impl.WorkDatabase
    public p f() {
        p pVar;
        if (this.f3692n3 != null) {
            return this.f3692n3;
        }
        synchronized (this) {
            try {
                if (this.f3692n3 == null) {
                    this.f3692n3 = new mt(this);
                }
                pVar = this.f3692n3;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public v fb() {
        v vVar;
        if (this.f3689c5 != null) {
            return this.f3689c5;
        }
        synchronized (this) {
            try {
                if (this.f3689c5 == null) {
                    this.f3689c5 = new a(this);
                }
                vVar = this.f3689c5;
            } catch (Throwable th) {
                throw th;
            }
        }
        return vVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public wz i9() {
        wz wzVar;
        if (this.f3693s != null) {
            return this.f3693s;
        }
        synchronized (this) {
            try {
                if (this.f3693s == null) {
                    this.f3693s = new xc(this);
                }
                wzVar = this.f3693s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wzVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public n3 n3() {
        n3 n3Var;
        if (this.f3695zn != null) {
            return this.f3695zn;
        }
        synchronized (this) {
            try {
                if (this.f3695zn == null) {
                    this.f3695zn = new zn(this);
                }
                n3Var = this.f3695zn;
            } catch (Throwable th) {
                throw th;
            }
        }
        return n3Var;
    }

    @Override // androidx.work.impl.WorkDatabase
    public le.s s() {
        le.s sVar;
        if (this.f3694v != null) {
            return this.f3694v;
        }
        synchronized (this) {
            try {
                if (this.f3694v == null) {
                    this.f3694v = new c5(this);
                }
                sVar = this.f3694v;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public z t() {
        z zVar;
        if (this.f3691gv != null) {
            return this.f3691gv;
        }
        synchronized (this) {
            try {
                if (this.f3691gv == null) {
                    this.f3691gv = new r(this);
                }
                zVar = this.f3691gv;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zVar;
    }

    /* loaded from: classes.dex */
    public class y extends n.n3 {
        public y(int i) {
            super(i);
        }

        @Override // rb.n.n3
        public void createAllTables(fb fbVar) {
            fbVar.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            fbVar.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            fbVar.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            fbVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            fbVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            fbVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
            fbVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            fbVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            fbVar.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            fbVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            fbVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            fbVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            fbVar.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            fbVar.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            fbVar.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
        }

        @Override // rb.n.n3
        public void dropAllTables(fb fbVar) {
            fbVar.execSQL("DROP TABLE IF EXISTS `Dependency`");
            fbVar.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
            fbVar.execSQL("DROP TABLE IF EXISTS `WorkTag`");
            fbVar.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
            fbVar.execSQL("DROP TABLE IF EXISTS `WorkName`");
            fbVar.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
            fbVar.execSQL("DROP TABLE IF EXISTS `Preference`");
            if (((i4) WorkDatabase_Impl.this).mCallbacks != null) {
                int size = ((i4) WorkDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((i4.n3) ((i4) WorkDatabase_Impl.this).mCallbacks.get(i)).n3(fbVar);
                }
            }
        }

        @Override // rb.n.n3
        public void onCreate(fb fbVar) {
            if (((i4) WorkDatabase_Impl.this).mCallbacks != null) {
                int size = ((i4) WorkDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((i4.n3) ((i4) WorkDatabase_Impl.this).mCallbacks.get(i)).y(fbVar);
                }
            }
        }

        @Override // rb.n.n3
        public void onOpen(fb fbVar) {
            ((i4) WorkDatabase_Impl.this).mDatabase = fbVar;
            fbVar.execSQL("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.internalInitInvalidationTracker(fbVar);
            if (((i4) WorkDatabase_Impl.this).mCallbacks != null) {
                int size = ((i4) WorkDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((i4.n3) ((i4) WorkDatabase_Impl.this).mCallbacks.get(i)).zn(fbVar);
                }
            }
        }

        @Override // rb.n.n3
        public void onPreMigrate(fb fbVar) {
            m.n3.y(fbVar);
        }

        @Override // rb.n.n3
        public n.zn onValidateSchema(fb fbVar) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("work_spec_id", new v.y("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap.put("prerequisite_id", new v.y("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new v.zn("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            hashSet.add(new v.zn("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new v.C0151v("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
            hashSet2.add(new v.C0151v("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
            m.v vVar = new m.v("Dependency", hashMap, hashSet, hashSet2);
            m.v y = m.v.y(fbVar, "Dependency");
            if (!vVar.equals(y)) {
                return new n.zn(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + vVar + "\n Found:\n" + y);
            }
            HashMap hashMap2 = new HashMap(25);
            hashMap2.put("id", new v.y("id", "TEXT", true, 1, null, 1));
            hashMap2.put("state", new v.y("state", "INTEGER", true, 0, null, 1));
            hashMap2.put("worker_class_name", new v.y("worker_class_name", "TEXT", true, 0, null, 1));
            hashMap2.put("input_merger_class_name", new v.y("input_merger_class_name", "TEXT", false, 0, null, 1));
            hashMap2.put("input", new v.y("input", "BLOB", true, 0, null, 1));
            hashMap2.put("output", new v.y("output", "BLOB", true, 0, null, 1));
            hashMap2.put("initial_delay", new v.y("initial_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("interval_duration", new v.y("interval_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("flex_duration", new v.y("flex_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("run_attempt_count", new v.y("run_attempt_count", "INTEGER", true, 0, null, 1));
            hashMap2.put("backoff_policy", new v.y("backoff_policy", "INTEGER", true, 0, null, 1));
            hashMap2.put("backoff_delay_duration", new v.y("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("period_start_time", new v.y("period_start_time", "INTEGER", true, 0, null, 1));
            hashMap2.put("minimum_retention_duration", new v.y("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("schedule_requested_at", new v.y("schedule_requested_at", "INTEGER", true, 0, null, 1));
            hashMap2.put("run_in_foreground", new v.y("run_in_foreground", "INTEGER", true, 0, null, 1));
            hashMap2.put("out_of_quota_policy", new v.y("out_of_quota_policy", "INTEGER", true, 0, null, 1));
            hashMap2.put("required_network_type", new v.y("required_network_type", "INTEGER", false, 0, null, 1));
            hashMap2.put("requires_charging", new v.y("requires_charging", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_device_idle", new v.y("requires_device_idle", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_battery_not_low", new v.y("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_storage_not_low", new v.y("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            hashMap2.put("trigger_content_update_delay", new v.y("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("trigger_max_content_delay", new v.y("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("content_uri_triggers", new v.y("content_uri_triggers", "BLOB", false, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new v.C0151v("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
            hashSet4.add(new v.C0151v("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
            m.v vVar2 = new m.v("WorkSpec", hashMap2, hashSet3, hashSet4);
            m.v y2 = m.v.y(fbVar, "WorkSpec");
            if (!vVar2.equals(y2)) {
                return new n.zn(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + vVar2 + "\n Found:\n" + y2);
            }
            HashMap hashMap3 = new HashMap(2);
            hashMap3.put("tag", new v.y("tag", "TEXT", true, 1, null, 1));
            hashMap3.put("work_spec_id", new v.y("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new v.zn("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new v.C0151v("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
            m.v vVar3 = new m.v("WorkTag", hashMap3, hashSet5, hashSet6);
            m.v y7 = m.v.y(fbVar, "WorkTag");
            if (!vVar3.equals(y7)) {
                return new n.zn(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + vVar3 + "\n Found:\n" + y7);
            }
            HashMap hashMap4 = new HashMap(2);
            hashMap4.put("work_spec_id", new v.y("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap4.put("system_id", new v.y("system_id", "INTEGER", true, 0, null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new v.zn("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            m.v vVar4 = new m.v("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
            m.v y8 = m.v.y(fbVar, "SystemIdInfo");
            if (!vVar4.equals(y8)) {
                return new n.zn(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + vVar4 + "\n Found:\n" + y8);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put("name", new v.y("name", "TEXT", true, 1, null, 1));
            hashMap5.put("work_spec_id", new v.y("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new v.zn("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new v.C0151v("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
            m.v vVar5 = new m.v("WorkName", hashMap5, hashSet8, hashSet9);
            m.v y9 = m.v.y(fbVar, "WorkName");
            if (!vVar5.equals(y9)) {
                return new n.zn(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + vVar5 + "\n Found:\n" + y9);
            }
            HashMap hashMap6 = new HashMap(2);
            hashMap6.put("work_spec_id", new v.y("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap6.put("progress", new v.y("progress", "BLOB", true, 0, null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new v.zn("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            m.v vVar6 = new m.v("WorkProgress", hashMap6, hashSet10, new HashSet(0));
            m.v y10 = m.v.y(fbVar, "WorkProgress");
            if (!vVar6.equals(y10)) {
                return new n.zn(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + vVar6 + "\n Found:\n" + y10);
            }
            HashMap hashMap7 = new HashMap(2);
            hashMap7.put("key", new v.y("key", "TEXT", true, 1, null, 1));
            hashMap7.put("long_value", new v.y("long_value", "INTEGER", false, 0, null, 1));
            m.v vVar7 = new m.v("Preference", hashMap7, new HashSet(0), new HashSet(0));
            m.v y11 = m.v.y(fbVar, "Preference");
            if (!vVar7.equals(y11)) {
                return new n.zn(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + vVar7 + "\n Found:\n" + y11);
            }
            return new n.zn(true, null);
        }

        @Override // rb.n.n3
        public void onPostMigrate(fb fbVar) {
        }
    }
}
