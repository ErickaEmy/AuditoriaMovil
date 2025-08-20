package le;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import rb.c;
import rb.i4;
import rb.z6;
/* loaded from: classes.dex */
public final class c5 implements s {

    /* renamed from: n3  reason: collision with root package name */
    public final rb.f<fb> f10311n3;
    public final i4 y;

    /* renamed from: zn  reason: collision with root package name */
    public final z6 f10312zn;

    /* loaded from: classes.dex */
    public class n3 extends z6 {
        public n3(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    /* loaded from: classes.dex */
    public class y extends rb.f<fb> {
        public y(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }

        @Override // rb.f
        /* renamed from: y */
        public void bind(u0.f fVar, fb fbVar) {
            String str = fbVar.y;
            if (str == null) {
                fVar.pz(1);
            } else {
                fVar.xg(1, str);
            }
            fVar.e(2, fbVar.f10314n3);
        }
    }

    public c5(i4 i4Var) {
        this.y = i4Var;
        this.f10311n3 = new y(i4Var);
        this.f10312zn = new n3(i4Var);
    }

    @Override // le.s
    public void gv(String str) {
        this.y.assertNotSuspendingTransaction();
        u0.f acquire = this.f10312zn.acquire();
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
            this.f10312zn.release(acquire);
        }
    }

    @Override // le.s
    public void n3(fb fbVar) {
        this.y.assertNotSuspendingTransaction();
        this.y.beginTransaction();
        try {
            this.f10311n3.insert((rb.f<fb>) fbVar);
            this.y.setTransactionSuccessful();
        } finally {
            this.y.endTransaction();
        }
    }

    @Override // le.s
    public fb y(String str) {
        c s2 = c.s("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            s2.pz(1);
        } else {
            s2.xg(1, str);
        }
        this.y.assertNotSuspendingTransaction();
        fb fbVar = null;
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            int v2 = m.y.v(n32, "work_spec_id");
            int v3 = m.y.v(n32, "system_id");
            if (n32.moveToFirst()) {
                fbVar = new fb(n32.getString(v2), n32.getInt(v3));
            }
            return fbVar;
        } finally {
            n32.close();
            s2.release();
        }
    }

    @Override // le.s
    public List<String> zn() {
        c s2 = c.s("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
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
}
