package cs;

import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
import java.util.LinkedList;
import java.util.UUID;
import l.wz;
import l.z;
import le.p;
/* loaded from: classes.dex */
public abstract class y implements Runnable {
    public final gq.zn y = new gq.zn();

    /* loaded from: classes.dex */
    public class n3 extends y {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ String f6889fb;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ gq.c5 f6890v;

        public n3(gq.c5 c5Var, String str) {
            this.f6890v = c5Var;
            this.f6889fb = str;
        }

        @Override // cs.y
        public void s() {
            WorkDatabase co2 = this.f6890v.co();
            co2.beginTransaction();
            try {
                for (String str : co2.f().s(this.f6889fb)) {
                    y(this.f6890v, str);
                }
                co2.setTransactionSuccessful();
                co2.endTransaction();
                fb(this.f6890v);
            } catch (Throwable th) {
                co2.endTransaction();
                throw th;
            }
        }
    }

    /* renamed from: cs.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0075y extends y {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ UUID f6891fb;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ gq.c5 f6892v;

        public C0075y(gq.c5 c5Var, UUID uuid) {
            this.f6892v = c5Var;
            this.f6891fb = uuid;
        }

        @Override // cs.y
        public void s() {
            WorkDatabase co2 = this.f6892v.co();
            co2.beginTransaction();
            try {
                y(this.f6892v, this.f6891fb.toString());
                co2.setTransactionSuccessful();
                co2.endTransaction();
                fb(this.f6892v);
            } catch (Throwable th) {
                co2.endTransaction();
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    public class zn extends y {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ String f6893fb;

        /* renamed from: s  reason: collision with root package name */
        public final /* synthetic */ boolean f6894s;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ gq.c5 f6895v;

        public zn(gq.c5 c5Var, String str, boolean z2) {
            this.f6895v = c5Var;
            this.f6893fb = str;
            this.f6894s = z2;
        }

        @Override // cs.y
        public void s() {
            WorkDatabase co2 = this.f6895v.co();
            co2.beginTransaction();
            try {
                for (String str : co2.f().gv(this.f6893fb)) {
                    y(this.f6895v, str);
                }
                co2.setTransactionSuccessful();
                co2.endTransaction();
                if (this.f6894s) {
                    fb(this.f6895v);
                }
            } catch (Throwable th) {
                co2.endTransaction();
                throw th;
            }
        }
    }

    public static y gv(@NonNull String str, @NonNull gq.c5 c5Var) {
        return new n3(c5Var, str);
    }

    public static y n3(@NonNull UUID uuid, @NonNull gq.c5 c5Var) {
        return new C0075y(c5Var, uuid);
    }

    public static y zn(@NonNull String str, @NonNull gq.c5 c5Var, boolean z2) {
        return new zn(c5Var, str, z2);
    }

    public final void a(WorkDatabase workDatabase, String str) {
        p f4 = workDatabase.f();
        le.n3 n32 = workDatabase.n3();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            z.y v2 = f4.v(str2);
            if (v2 != z.y.SUCCEEDED && v2 != z.y.FAILED) {
                f4.fb(z.y.CANCELLED, str2);
            }
            linkedList.addAll(n32.y(str2));
        }
    }

    public void fb(gq.c5 c5Var) {
        gq.a.n3(c5Var.tl(), c5Var.co(), c5Var.mt());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            s();
            this.y.y(l.wz.y);
        } catch (Throwable th) {
            this.y.y(new wz.n3.y(th));
        }
    }

    public abstract void s();

    public l.wz v() {
        return this.y;
    }

    public void y(gq.c5 c5Var, String str) {
        a(c5Var.co(), str);
        c5Var.p().t(str);
        for (gq.v vVar : c5Var.mt()) {
            vVar.cancel(str);
        }
    }
}
