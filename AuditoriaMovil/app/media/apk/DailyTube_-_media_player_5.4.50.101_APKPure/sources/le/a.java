package le;

import android.database.Cursor;
import rb.c;
import rb.i4;
/* loaded from: classes.dex */
public final class a implements v {

    /* renamed from: n3  reason: collision with root package name */
    public final rb.f<gv> f10310n3;
    public final i4 y;

    /* loaded from: classes.dex */
    public class y extends rb.f<gv> {
        public y(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        @Override // rb.f
        /* renamed from: y */
        public void bind(u0.f fVar, gv gvVar) {
            String str = gvVar.y;
            if (str == null) {
                fVar.pz(1);
            } else {
                fVar.xg(1, str);
            }
            Long l2 = gvVar.f10315n3;
            if (l2 == null) {
                fVar.pz(2);
            } else {
                fVar.e(2, l2.longValue());
            }
        }
    }

    public a(i4 i4Var) {
        this.y = i4Var;
        this.f10310n3 = new y(i4Var);
    }

    @Override // le.v
    public Long n3(String str) {
        c s2 = c.s("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            s2.pz(1);
        } else {
            s2.xg(1, str);
        }
        this.y.assertNotSuspendingTransaction();
        Long l2 = null;
        Cursor n32 = m.n3.n3(this.y, s2, false, null);
        try {
            if (n32.moveToFirst() && !n32.isNull(0)) {
                l2 = Long.valueOf(n32.getLong(0));
            }
            return l2;
        } finally {
            n32.close();
            s2.release();
        }
    }

    @Override // le.v
    public void y(gv gvVar) {
        this.y.assertNotSuspendingTransaction();
        this.y.beginTransaction();
        try {
            this.f10310n3.insert((rb.f<gv>) gvVar);
            this.y.setTransactionSuccessful();
        } finally {
            this.y.endTransaction();
        }
    }
}
