package le;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import l.z;
import le.w;
import rb.c;
import rb.i4;
import rb.z6;
/* loaded from: classes.dex */
public final class mt implements p {

    /* renamed from: a  reason: collision with root package name */
    public final z6 f10317a;

    /* renamed from: c5  reason: collision with root package name */
    public final z6 f10318c5;

    /* renamed from: fb  reason: collision with root package name */
    public final z6 f10319fb;

    /* renamed from: gv  reason: collision with root package name */
    public final z6 f10320gv;

    /* renamed from: i9  reason: collision with root package name */
    public final z6 f10321i9;

    /* renamed from: n3  reason: collision with root package name */
    public final rb.f<w> f10322n3;

    /* renamed from: s  reason: collision with root package name */
    public final z6 f10323s;

    /* renamed from: v  reason: collision with root package name */
    public final z6 f10324v;
    public final i4 y;

    /* renamed from: zn  reason: collision with root package name */
    public final z6 f10325zn;

    /* loaded from: classes.dex */
    public class a extends z6 {
        public a(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    /* loaded from: classes.dex */
    public class c5 extends z6 {
        public c5(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    /* loaded from: classes.dex */
    public class fb extends z6 {
        public fb(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    /* loaded from: classes.dex */
    public class gv extends z6 {
        public gv(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends z6 {
        public n3(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    /* loaded from: classes.dex */
    public class s extends z6 {
        public s(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    /* loaded from: classes.dex */
    public class v extends z6 {
        public v(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    /* loaded from: classes.dex */
    public class y extends rb.f<w> {
        public y(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // rb.f
        /* renamed from: y */
        public void bind(u0.f fVar, w wVar) {
            String str = wVar.y;
            if (str == null) {
                fVar.pz(1);
            } else {
                fVar.xg(1, str);
            }
            fVar.e(2, x4.i9(wVar.f10338n3));
            String str2 = wVar.f10347zn;
            if (str2 == null) {
                fVar.pz(3);
            } else {
                fVar.xg(3, str2);
            }
            String str3 = wVar.f10335gv;
            if (str3 == null) {
                fVar.pz(4);
            } else {
                fVar.xg(4, str3);
            }
            byte[] f4 = androidx.work.n3.f(wVar.f10343v);
            if (f4 == null) {
                fVar.pz(5);
            } else {
                fVar.yg(5, f4);
            }
            byte[] f6 = androidx.work.n3.f(wVar.f10331a);
            if (f6 == null) {
                fVar.pz(6);
            } else {
                fVar.yg(6, f6);
            }
            fVar.e(7, wVar.f10334fb);
            fVar.e(8, wVar.f10340s);
            fVar.e(9, wVar.f10332c5);
            fVar.e(10, wVar.f10333f);
            fVar.e(11, x4.y(wVar.f10341t));
            fVar.e(12, wVar.f10342tl);
            fVar.e(13, wVar.f10345wz);
            fVar.e(14, wVar.f10346xc);
            fVar.e(15, wVar.f10344w);
            fVar.e(16, wVar.f10339p ? 1L : 0L);
            fVar.e(17, x4.c5(wVar.f10337mt));
            l.n3 n3Var = wVar.f10336i9;
            if (n3Var != null) {
                fVar.e(18, x4.s(n3Var.n3()));
                fVar.e(19, n3Var.fb() ? 1L : 0L);
                fVar.e(20, n3Var.s() ? 1L : 0L);
                fVar.e(21, n3Var.a() ? 1L : 0L);
                fVar.e(22, n3Var.c5() ? 1L : 0L);
                fVar.e(23, n3Var.zn());
                fVar.e(24, n3Var.gv());
                byte[] zn2 = x4.zn(n3Var.y());
                if (zn2 == null) {
                    fVar.pz(25);
                    return;
                } else {
                    fVar.yg(25, zn2);
                    return;
                }
            }
            fVar.pz(18);
            fVar.pz(19);
            fVar.pz(20);
            fVar.pz(21);
            fVar.pz(22);
            fVar.pz(23);
            fVar.pz(24);
            fVar.pz(25);
        }
    }

    /* loaded from: classes.dex */
    public class zn extends z6 {
        public zn(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    public mt(i4 i4Var) {
        this.y = i4Var;
        this.f10322n3 = new y(i4Var);
        this.f10325zn = new n3(i4Var);
        this.f10320gv = new zn(i4Var);
        this.f10324v = new gv(i4Var);
        this.f10317a = new v(i4Var);
        this.f10319fb = new a(i4Var);
        this.f10323s = new fb(i4Var);
        this.f10318c5 = new s(i4Var);
        this.f10321i9 = new c5(i4Var);
    }

    @Override // le.p
    public w a(String str) {
        c cVar;
        int v2;
        int v3;
        int v4;
        int v6;
        int v7;
        int v8;
        int v9;
        int v10;
        int v11;
        int v12;
        int v13;
        int v14;
        int v15;
        int v16;
        w wVar;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        c s2 = c.s("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str == null) {
            s2.pz(1);
        } else {
            s2.xg(1, str);
        }
        this.y.assertNotSuspendingTransaction();
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            v2 = m.y.v(n32, "required_network_type");
            v3 = m.y.v(n32, "requires_charging");
            v4 = m.y.v(n32, "requires_device_idle");
            v6 = m.y.v(n32, "requires_battery_not_low");
            v7 = m.y.v(n32, "requires_storage_not_low");
            v8 = m.y.v(n32, "trigger_content_update_delay");
            v9 = m.y.v(n32, "trigger_max_content_delay");
            v10 = m.y.v(n32, "content_uri_triggers");
            v11 = m.y.v(n32, "id");
            v12 = m.y.v(n32, "state");
            v13 = m.y.v(n32, "worker_class_name");
            v14 = m.y.v(n32, "input_merger_class_name");
            v15 = m.y.v(n32, "input");
            v16 = m.y.v(n32, "output");
            cVar = s2;
        } catch (Throwable th) {
            th = th;
            cVar = s2;
        }
        try {
            int v17 = m.y.v(n32, "initial_delay");
            int v18 = m.y.v(n32, "interval_duration");
            int v19 = m.y.v(n32, "flex_duration");
            int v20 = m.y.v(n32, "run_attempt_count");
            int v21 = m.y.v(n32, "backoff_policy");
            int v22 = m.y.v(n32, "backoff_delay_duration");
            int v23 = m.y.v(n32, "period_start_time");
            int v24 = m.y.v(n32, "minimum_retention_duration");
            int v25 = m.y.v(n32, "schedule_requested_at");
            int v26 = m.y.v(n32, "run_in_foreground");
            int v27 = m.y.v(n32, "out_of_quota_policy");
            if (n32.moveToFirst()) {
                String string = n32.getString(v11);
                String string2 = n32.getString(v13);
                l.n3 n3Var = new l.n3();
                n3Var.f(x4.v(n32.getInt(v2)));
                if (n32.getInt(v3) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                n3Var.tl(z2);
                if (n32.getInt(v4) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                n3Var.wz(z3);
                if (n32.getInt(v6) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                n3Var.t(z4);
                if (n32.getInt(v7) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                n3Var.xc(z5);
                n3Var.w(n32.getLong(v8));
                n3Var.p(n32.getLong(v9));
                n3Var.i9(x4.n3(n32.getBlob(v10)));
                w wVar2 = new w(string, string2);
                wVar2.f10338n3 = x4.fb(n32.getInt(v12));
                wVar2.f10335gv = n32.getString(v14);
                wVar2.f10343v = androidx.work.n3.fb(n32.getBlob(v15));
                wVar2.f10331a = androidx.work.n3.fb(n32.getBlob(v16));
                wVar2.f10334fb = n32.getLong(v17);
                wVar2.f10340s = n32.getLong(v18);
                wVar2.f10332c5 = n32.getLong(v19);
                wVar2.f10333f = n32.getInt(v20);
                wVar2.f10341t = x4.gv(n32.getInt(v21));
                wVar2.f10342tl = n32.getLong(v22);
                wVar2.f10345wz = n32.getLong(v23);
                wVar2.f10346xc = n32.getLong(v24);
                wVar2.f10344w = n32.getLong(v25);
                if (n32.getInt(v26) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                wVar2.f10339p = z7;
                wVar2.f10337mt = x4.a(n32.getInt(v27));
                wVar2.f10336i9 = n3Var;
                wVar = wVar2;
            } else {
                wVar = null;
            }
            n32.close();
            cVar.release();
            return wVar;
        } catch (Throwable th2) {
            th = th2;
            n32.close();
            cVar.release();
            throw th;
        }
    }

    @Override // le.p
    public List<androidx.work.n3> c5(String str) {
        c s2 = c.s("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            s2.pz(1);
        } else {
            s2.xg(1, str);
        }
        this.y.assertNotSuspendingTransaction();
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            ArrayList arrayList = new ArrayList(n32.getCount());
            while (n32.moveToNext()) {
                arrayList.add(androidx.work.n3.fb(n32.getBlob(0)));
            }
            return arrayList;
        } finally {
            n32.close();
            s2.release();
        }
    }

    @Override // le.p
    public int co(String str) {
        this.y.assertNotSuspendingTransaction();
        u0.f acquire = this.f10317a.acquire();
        if (str == null) {
            acquire.pz(1);
        } else {
            acquire.xg(1, str);
        }
        this.y.beginTransaction();
        try {
            int xc2 = acquire.xc();
            this.y.setTransactionSuccessful();
            return xc2;
        } finally {
            this.y.endTransaction();
            this.f10317a.release(acquire);
        }
    }

    @Override // le.p
    public void delete(String str) {
        this.y.assertNotSuspendingTransaction();
        u0.f acquire = this.f10325zn.acquire();
        if (str == null) {
            acquire.pz(1);
        } else {
            acquire.xg(1, str);
        }
        this.y.beginTransaction();
        try {
            acquire.xc();
            this.y.setTransactionSuccessful();
        } finally {
            this.y.endTransaction();
            this.f10325zn.release(acquire);
        }
    }

    @Override // le.p
    public int f() {
        this.y.assertNotSuspendingTransaction();
        u0.f acquire = this.f10318c5.acquire();
        this.y.beginTransaction();
        try {
            int xc2 = acquire.xc();
            this.y.setTransactionSuccessful();
            return xc2;
        } finally {
            this.y.endTransaction();
            this.f10318c5.release(acquire);
        }
    }

    @Override // le.p
    public int fb(z.y yVar, String... strArr) {
        this.y.assertNotSuspendingTransaction();
        StringBuilder n32 = m.gv.n3();
        n32.append("UPDATE workspec SET state=");
        n32.append("?");
        n32.append(" WHERE id IN (");
        m.gv.y(n32, strArr.length);
        n32.append(")");
        u0.f compileStatement = this.y.compileStatement(n32.toString());
        compileStatement.e(1, x4.i9(yVar));
        int i = 2;
        for (String str : strArr) {
            if (str == null) {
                compileStatement.pz(i);
            } else {
                compileStatement.xg(i, str);
            }
            i++;
        }
        this.y.beginTransaction();
        try {
            int xc2 = compileStatement.xc();
            this.y.setTransactionSuccessful();
            return xc2;
        } finally {
            this.y.endTransaction();
        }
    }

    @Override // le.p
    public List<String> gv(String str) {
        c s2 = c.s("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            s2.pz(1);
        } else {
            s2.xg(1, str);
        }
        this.y.assertNotSuspendingTransaction();
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            ArrayList arrayList = new ArrayList(n32.getCount());
            while (n32.moveToNext()) {
                arrayList.add(n32.getString(0));
            }
            return arrayList;
        } finally {
            n32.close();
            s2.release();
        }
    }

    @Override // le.p
    public List<w> i9(int i) {
        c cVar;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        c s2 = c.s("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        s2.e(1, i);
        this.y.assertNotSuspendingTransaction();
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            int v2 = m.y.v(n32, "required_network_type");
            int v3 = m.y.v(n32, "requires_charging");
            int v4 = m.y.v(n32, "requires_device_idle");
            int v6 = m.y.v(n32, "requires_battery_not_low");
            int v7 = m.y.v(n32, "requires_storage_not_low");
            int v8 = m.y.v(n32, "trigger_content_update_delay");
            int v9 = m.y.v(n32, "trigger_max_content_delay");
            int v10 = m.y.v(n32, "content_uri_triggers");
            int v11 = m.y.v(n32, "id");
            int v12 = m.y.v(n32, "state");
            int v13 = m.y.v(n32, "worker_class_name");
            int v14 = m.y.v(n32, "input_merger_class_name");
            int v15 = m.y.v(n32, "input");
            int v16 = m.y.v(n32, "output");
            cVar = s2;
            try {
                int v17 = m.y.v(n32, "initial_delay");
                int v18 = m.y.v(n32, "interval_duration");
                int v19 = m.y.v(n32, "flex_duration");
                int v20 = m.y.v(n32, "run_attempt_count");
                int v21 = m.y.v(n32, "backoff_policy");
                int v22 = m.y.v(n32, "backoff_delay_duration");
                int v23 = m.y.v(n32, "period_start_time");
                int v24 = m.y.v(n32, "minimum_retention_duration");
                int v25 = m.y.v(n32, "schedule_requested_at");
                int v26 = m.y.v(n32, "run_in_foreground");
                int v27 = m.y.v(n32, "out_of_quota_policy");
                int i5 = v16;
                ArrayList arrayList = new ArrayList(n32.getCount());
                while (n32.moveToNext()) {
                    String string = n32.getString(v11);
                    int i6 = v11;
                    String string2 = n32.getString(v13);
                    int i8 = v13;
                    l.n3 n3Var = new l.n3();
                    int i10 = v2;
                    n3Var.f(x4.v(n32.getInt(v2)));
                    if (n32.getInt(v3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    n3Var.tl(z2);
                    if (n32.getInt(v4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    n3Var.wz(z3);
                    if (n32.getInt(v6) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    n3Var.t(z4);
                    if (n32.getInt(v7) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    n3Var.xc(z5);
                    int i11 = v3;
                    int i12 = v4;
                    n3Var.w(n32.getLong(v8));
                    n3Var.p(n32.getLong(v9));
                    n3Var.i9(x4.n3(n32.getBlob(v10)));
                    w wVar = new w(string, string2);
                    wVar.f10338n3 = x4.fb(n32.getInt(v12));
                    wVar.f10335gv = n32.getString(v14);
                    wVar.f10343v = androidx.work.n3.fb(n32.getBlob(v15));
                    int i13 = i5;
                    wVar.f10331a = androidx.work.n3.fb(n32.getBlob(i13));
                    i5 = i13;
                    int i14 = v17;
                    wVar.f10334fb = n32.getLong(i14);
                    int i15 = v14;
                    int i16 = v18;
                    wVar.f10340s = n32.getLong(i16);
                    int i17 = v6;
                    int i18 = v19;
                    wVar.f10332c5 = n32.getLong(i18);
                    int i19 = v20;
                    wVar.f10333f = n32.getInt(i19);
                    int i20 = v21;
                    wVar.f10341t = x4.gv(n32.getInt(i20));
                    v19 = i18;
                    int i21 = v22;
                    wVar.f10342tl = n32.getLong(i21);
                    int i22 = v23;
                    wVar.f10345wz = n32.getLong(i22);
                    v23 = i22;
                    int i23 = v24;
                    wVar.f10346xc = n32.getLong(i23);
                    int i24 = v25;
                    wVar.f10344w = n32.getLong(i24);
                    int i25 = v26;
                    if (n32.getInt(i25) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    wVar.f10339p = z7;
                    int i26 = v27;
                    wVar.f10337mt = x4.a(n32.getInt(i26));
                    wVar.f10336i9 = n3Var;
                    arrayList.add(wVar);
                    v27 = i26;
                    v3 = i11;
                    v14 = i15;
                    v17 = i14;
                    v18 = i16;
                    v20 = i19;
                    v25 = i24;
                    v11 = i6;
                    v13 = i8;
                    v2 = i10;
                    v26 = i25;
                    v24 = i23;
                    v4 = i12;
                    v22 = i21;
                    v6 = i17;
                    v21 = i20;
                }
                n32.close();
                cVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                n32.close();
                cVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = s2;
        }
    }

    @Override // le.p
    public int mt(String str) {
        this.y.assertNotSuspendingTransaction();
        u0.f acquire = this.f10319fb.acquire();
        if (str == null) {
            acquire.pz(1);
        } else {
            acquire.xg(1, str);
        }
        this.y.beginTransaction();
        try {
            int xc2 = acquire.xc();
            this.y.setTransactionSuccessful();
            return xc2;
        } finally {
            this.y.endTransaction();
            this.f10319fb.release(acquire);
        }
    }

    @Override // le.p
    public List<w> n3() {
        c cVar;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        c s2 = c.s("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.y.assertNotSuspendingTransaction();
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            int v2 = m.y.v(n32, "required_network_type");
            int v3 = m.y.v(n32, "requires_charging");
            int v4 = m.y.v(n32, "requires_device_idle");
            int v6 = m.y.v(n32, "requires_battery_not_low");
            int v7 = m.y.v(n32, "requires_storage_not_low");
            int v8 = m.y.v(n32, "trigger_content_update_delay");
            int v9 = m.y.v(n32, "trigger_max_content_delay");
            int v10 = m.y.v(n32, "content_uri_triggers");
            int v11 = m.y.v(n32, "id");
            int v12 = m.y.v(n32, "state");
            int v13 = m.y.v(n32, "worker_class_name");
            int v14 = m.y.v(n32, "input_merger_class_name");
            int v15 = m.y.v(n32, "input");
            int v16 = m.y.v(n32, "output");
            cVar = s2;
            try {
                int v17 = m.y.v(n32, "initial_delay");
                int v18 = m.y.v(n32, "interval_duration");
                int v19 = m.y.v(n32, "flex_duration");
                int v20 = m.y.v(n32, "run_attempt_count");
                int v21 = m.y.v(n32, "backoff_policy");
                int v22 = m.y.v(n32, "backoff_delay_duration");
                int v23 = m.y.v(n32, "period_start_time");
                int v24 = m.y.v(n32, "minimum_retention_duration");
                int v25 = m.y.v(n32, "schedule_requested_at");
                int v26 = m.y.v(n32, "run_in_foreground");
                int v27 = m.y.v(n32, "out_of_quota_policy");
                int i = v16;
                ArrayList arrayList = new ArrayList(n32.getCount());
                while (n32.moveToNext()) {
                    String string = n32.getString(v11);
                    int i5 = v11;
                    String string2 = n32.getString(v13);
                    int i6 = v13;
                    l.n3 n3Var = new l.n3();
                    int i8 = v2;
                    n3Var.f(x4.v(n32.getInt(v2)));
                    if (n32.getInt(v3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    n3Var.tl(z2);
                    if (n32.getInt(v4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    n3Var.wz(z3);
                    if (n32.getInt(v6) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    n3Var.t(z4);
                    if (n32.getInt(v7) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    n3Var.xc(z5);
                    int i10 = v3;
                    int i11 = v4;
                    n3Var.w(n32.getLong(v8));
                    n3Var.p(n32.getLong(v9));
                    n3Var.i9(x4.n3(n32.getBlob(v10)));
                    w wVar = new w(string, string2);
                    wVar.f10338n3 = x4.fb(n32.getInt(v12));
                    wVar.f10335gv = n32.getString(v14);
                    wVar.f10343v = androidx.work.n3.fb(n32.getBlob(v15));
                    int i12 = i;
                    wVar.f10331a = androidx.work.n3.fb(n32.getBlob(i12));
                    i = i12;
                    int i13 = v17;
                    wVar.f10334fb = n32.getLong(i13);
                    int i14 = v15;
                    int i15 = v18;
                    wVar.f10340s = n32.getLong(i15);
                    int i16 = v6;
                    int i17 = v19;
                    wVar.f10332c5 = n32.getLong(i17);
                    int i18 = v20;
                    wVar.f10333f = n32.getInt(i18);
                    int i19 = v21;
                    wVar.f10341t = x4.gv(n32.getInt(i19));
                    v19 = i17;
                    int i20 = v22;
                    wVar.f10342tl = n32.getLong(i20);
                    int i21 = v23;
                    wVar.f10345wz = n32.getLong(i21);
                    v23 = i21;
                    int i22 = v24;
                    wVar.f10346xc = n32.getLong(i22);
                    int i23 = v25;
                    wVar.f10344w = n32.getLong(i23);
                    int i24 = v26;
                    if (n32.getInt(i24) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    wVar.f10339p = z7;
                    int i25 = v27;
                    wVar.f10337mt = x4.a(n32.getInt(i25));
                    wVar.f10336i9 = n3Var;
                    arrayList.add(wVar);
                    v27 = i25;
                    v3 = i10;
                    v15 = i14;
                    v17 = i13;
                    v18 = i15;
                    v20 = i18;
                    v25 = i23;
                    v11 = i5;
                    v13 = i6;
                    v2 = i8;
                    v26 = i24;
                    v24 = i22;
                    v4 = i11;
                    v22 = i20;
                    v6 = i16;
                    v21 = i19;
                }
                n32.close();
                cVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                n32.close();
                cVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = s2;
        }
    }

    @Override // le.p
    public boolean p() {
        boolean z2 = false;
        c s2 = c.s("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.y.assertNotSuspendingTransaction();
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            if (n32.moveToFirst()) {
                if (n32.getInt(0) != 0) {
                    z2 = true;
                }
            }
            return z2;
        } finally {
            n32.close();
            s2.release();
        }
    }

    @Override // le.p
    public List<String> s(String str) {
        c s2 = c.s("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            s2.pz(1);
        } else {
            s2.xg(1, str);
        }
        this.y.assertNotSuspendingTransaction();
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            ArrayList arrayList = new ArrayList(n32.getCount());
            while (n32.moveToNext()) {
                arrayList.add(n32.getString(0));
            }
            return arrayList;
        } finally {
            n32.close();
            s2.release();
        }
    }

    @Override // le.p
    public int t(String str, long j2) {
        this.y.assertNotSuspendingTransaction();
        u0.f acquire = this.f10323s.acquire();
        acquire.e(1, j2);
        if (str == null) {
            acquire.pz(2);
        } else {
            acquire.xg(2, str);
        }
        this.y.beginTransaction();
        try {
            int xc2 = acquire.xc();
            this.y.setTransactionSuccessful();
            return xc2;
        } finally {
            this.y.endTransaction();
            this.f10323s.release(acquire);
        }
    }

    @Override // le.p
    public List<w.n3> tl(String str) {
        c s2 = c.s("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            s2.pz(1);
        } else {
            s2.xg(1, str);
        }
        this.y.assertNotSuspendingTransaction();
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            int v2 = m.y.v(n32, "id");
            int v3 = m.y.v(n32, "state");
            ArrayList arrayList = new ArrayList(n32.getCount());
            while (n32.moveToNext()) {
                w.n3 n3Var = new w.n3();
                n3Var.y = n32.getString(v2);
                n3Var.f10348n3 = x4.fb(n32.getInt(v3));
                arrayList.add(n3Var);
            }
            return arrayList;
        } finally {
            n32.close();
            s2.release();
        }
    }

    @Override // le.p
    public z.y v(String str) {
        c s2 = c.s("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            s2.pz(1);
        } else {
            s2.xg(1, str);
        }
        this.y.assertNotSuspendingTransaction();
        z.y yVar = null;
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            if (n32.moveToFirst()) {
                yVar = x4.fb(n32.getInt(0));
            }
            return yVar;
        } finally {
            n32.close();
            s2.release();
        }
    }

    @Override // le.p
    public List<w> w() {
        c cVar;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        c s2 = c.s("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.y.assertNotSuspendingTransaction();
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            int v2 = m.y.v(n32, "required_network_type");
            int v3 = m.y.v(n32, "requires_charging");
            int v4 = m.y.v(n32, "requires_device_idle");
            int v6 = m.y.v(n32, "requires_battery_not_low");
            int v7 = m.y.v(n32, "requires_storage_not_low");
            int v8 = m.y.v(n32, "trigger_content_update_delay");
            int v9 = m.y.v(n32, "trigger_max_content_delay");
            int v10 = m.y.v(n32, "content_uri_triggers");
            int v11 = m.y.v(n32, "id");
            int v12 = m.y.v(n32, "state");
            int v13 = m.y.v(n32, "worker_class_name");
            int v14 = m.y.v(n32, "input_merger_class_name");
            int v15 = m.y.v(n32, "input");
            int v16 = m.y.v(n32, "output");
            cVar = s2;
            try {
                int v17 = m.y.v(n32, "initial_delay");
                int v18 = m.y.v(n32, "interval_duration");
                int v19 = m.y.v(n32, "flex_duration");
                int v20 = m.y.v(n32, "run_attempt_count");
                int v21 = m.y.v(n32, "backoff_policy");
                int v22 = m.y.v(n32, "backoff_delay_duration");
                int v23 = m.y.v(n32, "period_start_time");
                int v24 = m.y.v(n32, "minimum_retention_duration");
                int v25 = m.y.v(n32, "schedule_requested_at");
                int v26 = m.y.v(n32, "run_in_foreground");
                int v27 = m.y.v(n32, "out_of_quota_policy");
                int i = v16;
                ArrayList arrayList = new ArrayList(n32.getCount());
                while (n32.moveToNext()) {
                    String string = n32.getString(v11);
                    int i5 = v11;
                    String string2 = n32.getString(v13);
                    int i6 = v13;
                    l.n3 n3Var = new l.n3();
                    int i8 = v2;
                    n3Var.f(x4.v(n32.getInt(v2)));
                    if (n32.getInt(v3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    n3Var.tl(z2);
                    if (n32.getInt(v4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    n3Var.wz(z3);
                    if (n32.getInt(v6) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    n3Var.t(z4);
                    if (n32.getInt(v7) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    n3Var.xc(z5);
                    int i10 = v3;
                    int i11 = v4;
                    n3Var.w(n32.getLong(v8));
                    n3Var.p(n32.getLong(v9));
                    n3Var.i9(x4.n3(n32.getBlob(v10)));
                    w wVar = new w(string, string2);
                    wVar.f10338n3 = x4.fb(n32.getInt(v12));
                    wVar.f10335gv = n32.getString(v14);
                    wVar.f10343v = androidx.work.n3.fb(n32.getBlob(v15));
                    int i12 = i;
                    wVar.f10331a = androidx.work.n3.fb(n32.getBlob(i12));
                    i = i12;
                    int i13 = v17;
                    wVar.f10334fb = n32.getLong(i13);
                    int i14 = v15;
                    int i15 = v18;
                    wVar.f10340s = n32.getLong(i15);
                    int i16 = v6;
                    int i17 = v19;
                    wVar.f10332c5 = n32.getLong(i17);
                    int i18 = v20;
                    wVar.f10333f = n32.getInt(i18);
                    int i19 = v21;
                    wVar.f10341t = x4.gv(n32.getInt(i19));
                    v19 = i17;
                    int i20 = v22;
                    wVar.f10342tl = n32.getLong(i20);
                    int i21 = v23;
                    wVar.f10345wz = n32.getLong(i21);
                    v23 = i21;
                    int i22 = v24;
                    wVar.f10346xc = n32.getLong(i22);
                    int i23 = v25;
                    wVar.f10344w = n32.getLong(i23);
                    int i24 = v26;
                    if (n32.getInt(i24) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    wVar.f10339p = z7;
                    int i25 = v27;
                    wVar.f10337mt = x4.a(n32.getInt(i25));
                    wVar.f10336i9 = n3Var;
                    arrayList.add(wVar);
                    v27 = i25;
                    v3 = i10;
                    v15 = i14;
                    v17 = i13;
                    v18 = i15;
                    v20 = i18;
                    v25 = i23;
                    v11 = i5;
                    v13 = i6;
                    v2 = i8;
                    v26 = i24;
                    v24 = i22;
                    v4 = i11;
                    v22 = i20;
                    v6 = i16;
                    v21 = i19;
                }
                n32.close();
                cVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                n32.close();
                cVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = s2;
        }
    }

    @Override // le.p
    public List<w> wz(int i) {
        c cVar;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        c s2 = c.s("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        s2.e(1, i);
        this.y.assertNotSuspendingTransaction();
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            int v2 = m.y.v(n32, "required_network_type");
            int v3 = m.y.v(n32, "requires_charging");
            int v4 = m.y.v(n32, "requires_device_idle");
            int v6 = m.y.v(n32, "requires_battery_not_low");
            int v7 = m.y.v(n32, "requires_storage_not_low");
            int v8 = m.y.v(n32, "trigger_content_update_delay");
            int v9 = m.y.v(n32, "trigger_max_content_delay");
            int v10 = m.y.v(n32, "content_uri_triggers");
            int v11 = m.y.v(n32, "id");
            int v12 = m.y.v(n32, "state");
            int v13 = m.y.v(n32, "worker_class_name");
            int v14 = m.y.v(n32, "input_merger_class_name");
            int v15 = m.y.v(n32, "input");
            int v16 = m.y.v(n32, "output");
            cVar = s2;
            try {
                int v17 = m.y.v(n32, "initial_delay");
                int v18 = m.y.v(n32, "interval_duration");
                int v19 = m.y.v(n32, "flex_duration");
                int v20 = m.y.v(n32, "run_attempt_count");
                int v21 = m.y.v(n32, "backoff_policy");
                int v22 = m.y.v(n32, "backoff_delay_duration");
                int v23 = m.y.v(n32, "period_start_time");
                int v24 = m.y.v(n32, "minimum_retention_duration");
                int v25 = m.y.v(n32, "schedule_requested_at");
                int v26 = m.y.v(n32, "run_in_foreground");
                int v27 = m.y.v(n32, "out_of_quota_policy");
                int i5 = v16;
                ArrayList arrayList = new ArrayList(n32.getCount());
                while (n32.moveToNext()) {
                    String string = n32.getString(v11);
                    int i6 = v11;
                    String string2 = n32.getString(v13);
                    int i8 = v13;
                    l.n3 n3Var = new l.n3();
                    int i10 = v2;
                    n3Var.f(x4.v(n32.getInt(v2)));
                    if (n32.getInt(v3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    n3Var.tl(z2);
                    if (n32.getInt(v4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    n3Var.wz(z3);
                    if (n32.getInt(v6) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    n3Var.t(z4);
                    if (n32.getInt(v7) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    n3Var.xc(z5);
                    int i11 = v3;
                    int i12 = v4;
                    n3Var.w(n32.getLong(v8));
                    n3Var.p(n32.getLong(v9));
                    n3Var.i9(x4.n3(n32.getBlob(v10)));
                    w wVar = new w(string, string2);
                    wVar.f10338n3 = x4.fb(n32.getInt(v12));
                    wVar.f10335gv = n32.getString(v14);
                    wVar.f10343v = androidx.work.n3.fb(n32.getBlob(v15));
                    int i13 = i5;
                    wVar.f10331a = androidx.work.n3.fb(n32.getBlob(i13));
                    i5 = i13;
                    int i14 = v17;
                    wVar.f10334fb = n32.getLong(i14);
                    int i15 = v14;
                    int i16 = v18;
                    wVar.f10340s = n32.getLong(i16);
                    int i17 = v6;
                    int i18 = v19;
                    wVar.f10332c5 = n32.getLong(i18);
                    int i19 = v20;
                    wVar.f10333f = n32.getInt(i19);
                    int i20 = v21;
                    wVar.f10341t = x4.gv(n32.getInt(i20));
                    v19 = i18;
                    int i21 = v22;
                    wVar.f10342tl = n32.getLong(i21);
                    int i22 = v23;
                    wVar.f10345wz = n32.getLong(i22);
                    v23 = i22;
                    int i23 = v24;
                    wVar.f10346xc = n32.getLong(i23);
                    int i24 = v25;
                    wVar.f10344w = n32.getLong(i24);
                    int i25 = v26;
                    if (n32.getInt(i25) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    wVar.f10339p = z7;
                    int i26 = v27;
                    wVar.f10337mt = x4.a(n32.getInt(i26));
                    wVar.f10336i9 = n3Var;
                    arrayList.add(wVar);
                    v27 = i26;
                    v3 = i11;
                    v14 = i15;
                    v17 = i14;
                    v18 = i16;
                    v20 = i19;
                    v25 = i24;
                    v11 = i6;
                    v13 = i8;
                    v2 = i10;
                    v26 = i25;
                    v24 = i23;
                    v4 = i12;
                    v22 = i21;
                    v6 = i17;
                    v21 = i20;
                }
                n32.close();
                cVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                n32.close();
                cVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = s2;
        }
    }

    @Override // le.p
    public void xc(String str, androidx.work.n3 n3Var) {
        this.y.assertNotSuspendingTransaction();
        u0.f acquire = this.f10320gv.acquire();
        byte[] f4 = androidx.work.n3.f(n3Var);
        if (f4 == null) {
            acquire.pz(1);
        } else {
            acquire.yg(1, f4);
        }
        if (str == null) {
            acquire.pz(2);
        } else {
            acquire.xg(2, str);
        }
        this.y.beginTransaction();
        try {
            acquire.xc();
            this.y.setTransactionSuccessful();
        } finally {
            this.y.endTransaction();
            this.f10320gv.release(acquire);
        }
    }

    @Override // le.p
    public List<w> y(long j2) {
        c cVar;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        c s2 = c.s("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        s2.e(1, j2);
        this.y.assertNotSuspendingTransaction();
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            int v2 = m.y.v(n32, "required_network_type");
            int v3 = m.y.v(n32, "requires_charging");
            int v4 = m.y.v(n32, "requires_device_idle");
            int v6 = m.y.v(n32, "requires_battery_not_low");
            int v7 = m.y.v(n32, "requires_storage_not_low");
            int v8 = m.y.v(n32, "trigger_content_update_delay");
            int v9 = m.y.v(n32, "trigger_max_content_delay");
            int v10 = m.y.v(n32, "content_uri_triggers");
            int v11 = m.y.v(n32, "id");
            int v12 = m.y.v(n32, "state");
            int v13 = m.y.v(n32, "worker_class_name");
            int v14 = m.y.v(n32, "input_merger_class_name");
            int v15 = m.y.v(n32, "input");
            int v16 = m.y.v(n32, "output");
            cVar = s2;
            try {
                int v17 = m.y.v(n32, "initial_delay");
                int v18 = m.y.v(n32, "interval_duration");
                int v19 = m.y.v(n32, "flex_duration");
                int v20 = m.y.v(n32, "run_attempt_count");
                int v21 = m.y.v(n32, "backoff_policy");
                int v22 = m.y.v(n32, "backoff_delay_duration");
                int v23 = m.y.v(n32, "period_start_time");
                int v24 = m.y.v(n32, "minimum_retention_duration");
                int v25 = m.y.v(n32, "schedule_requested_at");
                int v26 = m.y.v(n32, "run_in_foreground");
                int v27 = m.y.v(n32, "out_of_quota_policy");
                int i = v16;
                ArrayList arrayList = new ArrayList(n32.getCount());
                while (n32.moveToNext()) {
                    String string = n32.getString(v11);
                    int i5 = v11;
                    String string2 = n32.getString(v13);
                    int i6 = v13;
                    l.n3 n3Var = new l.n3();
                    int i8 = v2;
                    n3Var.f(x4.v(n32.getInt(v2)));
                    if (n32.getInt(v3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    n3Var.tl(z2);
                    if (n32.getInt(v4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    n3Var.wz(z3);
                    if (n32.getInt(v6) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    n3Var.t(z4);
                    if (n32.getInt(v7) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    n3Var.xc(z5);
                    int i10 = v3;
                    int i11 = v4;
                    n3Var.w(n32.getLong(v8));
                    n3Var.p(n32.getLong(v9));
                    n3Var.i9(x4.n3(n32.getBlob(v10)));
                    w wVar = new w(string, string2);
                    wVar.f10338n3 = x4.fb(n32.getInt(v12));
                    wVar.f10335gv = n32.getString(v14);
                    wVar.f10343v = androidx.work.n3.fb(n32.getBlob(v15));
                    int i12 = i;
                    wVar.f10331a = androidx.work.n3.fb(n32.getBlob(i12));
                    int i13 = v17;
                    i = i12;
                    wVar.f10334fb = n32.getLong(i13);
                    int i14 = v14;
                    int i15 = v18;
                    wVar.f10340s = n32.getLong(i15);
                    int i16 = v6;
                    int i17 = v19;
                    wVar.f10332c5 = n32.getLong(i17);
                    int i18 = v20;
                    wVar.f10333f = n32.getInt(i18);
                    int i19 = v21;
                    wVar.f10341t = x4.gv(n32.getInt(i19));
                    v19 = i17;
                    int i20 = v22;
                    wVar.f10342tl = n32.getLong(i20);
                    int i21 = v23;
                    wVar.f10345wz = n32.getLong(i21);
                    v23 = i21;
                    int i22 = v24;
                    wVar.f10346xc = n32.getLong(i22);
                    int i23 = v25;
                    wVar.f10344w = n32.getLong(i23);
                    int i24 = v26;
                    if (n32.getInt(i24) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    wVar.f10339p = z7;
                    int i25 = v27;
                    wVar.f10337mt = x4.a(n32.getInt(i25));
                    wVar.f10336i9 = n3Var;
                    arrayList.add(wVar);
                    v3 = i10;
                    v27 = i25;
                    v14 = i14;
                    v17 = i13;
                    v18 = i15;
                    v20 = i18;
                    v25 = i23;
                    v11 = i5;
                    v13 = i6;
                    v2 = i8;
                    v26 = i24;
                    v24 = i22;
                    v4 = i11;
                    v22 = i20;
                    v6 = i16;
                    v21 = i19;
                }
                n32.close();
                cVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                n32.close();
                cVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = s2;
        }
    }

    @Override // le.p
    public void z(String str, long j2) {
        this.y.assertNotSuspendingTransaction();
        u0.f acquire = this.f10324v.acquire();
        acquire.e(1, j2);
        if (str == null) {
            acquire.pz(2);
        } else {
            acquire.xg(2, str);
        }
        this.y.beginTransaction();
        try {
            acquire.xc();
            this.y.setTransactionSuccessful();
        } finally {
            this.y.endTransaction();
            this.f10324v.release(acquire);
        }
    }

    @Override // le.p
    public void zn(w wVar) {
        this.y.assertNotSuspendingTransaction();
        this.y.beginTransaction();
        try {
            this.f10322n3.insert((rb.f<w>) wVar);
            this.y.setTransactionSuccessful();
        } finally {
            this.y.endTransaction();
        }
    }
}
