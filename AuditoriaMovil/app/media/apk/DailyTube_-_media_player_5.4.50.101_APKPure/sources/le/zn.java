package le;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import rb.c;
import rb.i4;
/* loaded from: classes.dex */
public final class zn implements n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final rb.f<le.y> f10361n3;
    public final i4 y;

    /* loaded from: classes.dex */
    public class y extends rb.f<le.y> {
        public y(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        @Override // rb.f
        /* renamed from: y */
        public void bind(u0.f fVar, le.y yVar) {
            String str = yVar.y;
            if (str == null) {
                fVar.pz(1);
            } else {
                fVar.xg(1, str);
            }
            String str2 = yVar.f10360n3;
            if (str2 == null) {
                fVar.pz(2);
            } else {
                fVar.xg(2, str2);
            }
        }
    }

    public zn(i4 i4Var) {
        this.y = i4Var;
        this.f10361n3 = new y(i4Var);
    }

    @Override // le.n3
    public boolean gv(String str) {
        boolean z2 = true;
        c s2 = c.s("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            s2.pz(1);
        } else {
            s2.xg(1, str);
        }
        this.y.assertNotSuspendingTransaction();
        boolean z3 = false;
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            if (n32.moveToFirst()) {
                if (n32.getInt(0) == 0) {
                    z2 = false;
                }
                z3 = z2;
            }
            return z3;
        } finally {
            n32.close();
            s2.release();
        }
    }

    @Override // le.n3
    public boolean n3(String str) {
        boolean z2 = true;
        c s2 = c.s("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            s2.pz(1);
        } else {
            s2.xg(1, str);
        }
        this.y.assertNotSuspendingTransaction();
        boolean z3 = false;
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            if (n32.moveToFirst()) {
                if (n32.getInt(0) == 0) {
                    z2 = false;
                }
                z3 = z2;
            }
            return z3;
        } finally {
            n32.close();
            s2.release();
        }
    }

    @Override // le.n3
    public List<String> y(String str) {
        c s2 = c.s("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
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

    @Override // le.n3
    public void zn(le.y yVar) {
        this.y.assertNotSuspendingTransaction();
        this.y.beginTransaction();
        try {
            this.f10361n3.insert((rb.f<le.y>) yVar);
            this.y.setTransactionSuccessful();
        } finally {
            this.y.endTransaction();
        }
    }
}
