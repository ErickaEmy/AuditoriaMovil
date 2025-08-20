package androidx.work.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.impl.y;
import bk.a;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import le.f;
import le.p;
import le.v;
import le.wz;
import le.z;
import rb.i4;
import rb.x4;
import u0.fb;
import u0.s;
/* loaded from: classes.dex */
public abstract class WorkDatabase extends i4 {
    public static final long y = TimeUnit.DAYS.toMillis(1);

    /* loaded from: classes.dex */
    public class n3 extends i4.n3 {
        @Override // rb.i4.n3
        public void zn(@NonNull fb fbVar) {
            super.zn(fbVar);
            fbVar.fb();
            try {
                fbVar.execSQL(WorkDatabase.v());
                fbVar.d0();
            } finally {
                fbVar.z6();
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements s.zn {
        public final /* synthetic */ Context y;

        public y(Context context) {
            this.y = context;
        }

        @Override // u0.s.zn
        @NonNull
        public s y(@NonNull s.n3 n3Var) {
            s.n3.y y = s.n3.y(this.y);
            y.zn(n3Var.f14020n3).n3(n3Var.f14022zn).gv(true);
            return new a().y(y.y());
        }
    }

    public static long gv() {
        return System.currentTimeMillis() - y;
    }

    @NonNull
    public static String v() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + gv() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    @NonNull
    public static WorkDatabase y(@NonNull Context context, @NonNull Executor executor, boolean z2) {
        i4.y y2;
        if (z2) {
            y2 = x4.zn(context, WorkDatabase.class).zn();
        } else {
            y2 = x4.y(context, WorkDatabase.class, gq.s.gv());
            y2.fb(new y(context));
        }
        return (WorkDatabase) y2.s(executor).y(zn()).n3(androidx.work.impl.y.y).n3(new y.s(context, 2, 3)).n3(androidx.work.impl.y.f3769n3).n3(androidx.work.impl.y.f3771zn).n3(new y.s(context, 5, 6)).n3(androidx.work.impl.y.f3768gv).n3(androidx.work.impl.y.f3770v).n3(androidx.work.impl.y.f3766a).n3(new y.c5(context)).n3(new y.s(context, 10, 11)).n3(androidx.work.impl.y.f3767fb).v().gv();
    }

    public static i4.n3 zn() {
        return new n3();
    }

    @NonNull
    public abstract f c5();

    @NonNull
    public abstract p f();

    @NonNull
    public abstract v fb();

    @NonNull
    public abstract wz i9();

    @NonNull
    public abstract le.n3 n3();

    @NonNull
    public abstract le.s s();

    @NonNull
    public abstract z t();
}
