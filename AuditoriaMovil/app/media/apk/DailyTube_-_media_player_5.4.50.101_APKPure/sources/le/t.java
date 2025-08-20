package le;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import rb.c;
import rb.i4;
/* loaded from: classes.dex */
public final class t implements f {

    /* renamed from: n3  reason: collision with root package name */
    public final rb.f<i9> f10327n3;
    public final i4 y;

    /* loaded from: classes.dex */
    public class y extends rb.f<i9> {
        public y(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // rb.f
        /* renamed from: y */
        public void bind(u0.f fVar, i9 i9Var) {
            String str = i9Var.y;
            if (str == null) {
                fVar.pz(1);
            } else {
                fVar.xg(1, str);
            }
            String str2 = i9Var.f10316n3;
            if (str2 == null) {
                fVar.pz(2);
            } else {
                fVar.xg(2, str2);
            }
        }
    }

    public t(i4 i4Var) {
        this.y = i4Var;
        this.f10327n3 = new y(i4Var);
    }

    @Override // le.f
    public List<String> n3(String str) {
        c s2 = c.s("SELECT name FROM workname WHERE work_spec_id=?", 1);
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

    @Override // le.f
    public void y(i9 i9Var) {
        this.y.assertNotSuspendingTransaction();
        this.y.beginTransaction();
        try {
            this.f10327n3.insert((rb.f<i9>) i9Var);
            this.y.setTransactionSuccessful();
        } finally {
            this.y.endTransaction();
        }
    }
}
