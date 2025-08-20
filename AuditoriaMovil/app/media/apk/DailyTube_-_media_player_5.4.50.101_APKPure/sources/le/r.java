package le;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import rb.c;
import rb.i4;
/* loaded from: classes.dex */
public final class r implements z {

    /* renamed from: n3  reason: collision with root package name */
    public final rb.f<co> f10326n3;
    public final i4 y;

    /* loaded from: classes.dex */
    public class y extends rb.f<co> {
        public y(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // rb.f
        /* renamed from: y */
        public void bind(u0.f fVar, co coVar) {
            String str = coVar.y;
            if (str == null) {
                fVar.pz(1);
            } else {
                fVar.xg(1, str);
            }
            String str2 = coVar.f10313n3;
            if (str2 == null) {
                fVar.pz(2);
            } else {
                fVar.xg(2, str2);
            }
        }
    }

    public r(i4 i4Var) {
        this.y = i4Var;
        this.f10326n3 = new y(i4Var);
    }

    @Override // le.z
    public void n3(co coVar) {
        this.y.assertNotSuspendingTransaction();
        this.y.beginTransaction();
        try {
            this.f10326n3.insert((rb.f<co>) coVar);
            this.y.setTransactionSuccessful();
        } finally {
            this.y.endTransaction();
        }
    }

    @Override // le.z
    public List<String> y(String str) {
        c s2 = c.s("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
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
}
