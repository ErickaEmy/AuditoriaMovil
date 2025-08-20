package le;

import rb.i4;
import rb.z6;
/* loaded from: classes.dex */
public final class xc implements wz {

    /* renamed from: gv  reason: collision with root package name */
    public final z6 f10357gv;

    /* renamed from: n3  reason: collision with root package name */
    public final rb.f<tl> f10358n3;
    public final i4 y;

    /* renamed from: zn  reason: collision with root package name */
    public final z6 f10359zn;

    /* loaded from: classes.dex */
    public class n3 extends z6 {
        public n3(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    /* loaded from: classes.dex */
    public class y extends rb.f<tl> {
        public y(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        @Override // rb.f
        /* renamed from: y */
        public void bind(u0.f fVar, tl tlVar) {
            String str = tlVar.y;
            if (str == null) {
                fVar.pz(1);
            } else {
                fVar.xg(1, str);
            }
            byte[] f4 = androidx.work.n3.f(tlVar.f10328n3);
            if (f4 == null) {
                fVar.pz(2);
            } else {
                fVar.yg(2, f4);
            }
        }
    }

    /* loaded from: classes.dex */
    public class zn extends z6 {
        public zn(i4 i4Var) {
            super(i4Var);
        }

        @Override // rb.z6
        public String createQuery() {
            return "DELETE FROM WorkProgress";
        }
    }

    public xc(i4 i4Var) {
        this.y = i4Var;
        this.f10358n3 = new y(i4Var);
        this.f10359zn = new n3(i4Var);
        this.f10357gv = new zn(i4Var);
    }

    @Override // le.wz
    public void delete(String str) {
        this.y.assertNotSuspendingTransaction();
        u0.f acquire = this.f10359zn.acquire();
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
            this.f10359zn.release(acquire);
        }
    }

    @Override // le.wz
    public void n3(tl tlVar) {
        this.y.assertNotSuspendingTransaction();
        this.y.beginTransaction();
        try {
            this.f10358n3.insert((rb.f<tl>) tlVar);
            this.y.setTransactionSuccessful();
        } finally {
            this.y.endTransaction();
        }
    }

    @Override // le.wz
    public void y() {
        this.y.assertNotSuspendingTransaction();
        u0.f acquire = this.f10357gv.acquire();
        this.y.beginTransaction();
        try {
            acquire.xc();
            this.y.setTransactionSuccessful();
        } finally {
            this.y.endTransaction();
            this.f10357gv.release(acquire);
        }
    }
}
