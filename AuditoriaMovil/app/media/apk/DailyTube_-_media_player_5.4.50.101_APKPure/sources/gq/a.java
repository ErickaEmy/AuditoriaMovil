package gq;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.List;
import l.f;
import le.p;
import le.w;
/* loaded from: classes.dex */
public class a {
    public static final String y = f.a("Schedulers");

    public static void n3(@NonNull androidx.work.y yVar, @NonNull WorkDatabase workDatabase, List<v> list) {
        if (list != null && list.size() != 0) {
            p f4 = workDatabase.f();
            workDatabase.beginTransaction();
            try {
                List<w> wz2 = f4.wz(yVar.s());
                List<w> i92 = f4.i9(200);
                if (wz2 != null && wz2.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (w wVar : wz2) {
                        f4.t(wVar.y, currentTimeMillis);
                    }
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (wz2 != null && wz2.size() > 0) {
                    w[] wVarArr = (w[]) wz2.toArray(new w[wz2.size()]);
                    for (v vVar : list) {
                        if (vVar.zn()) {
                            vVar.y(wVarArr);
                        }
                    }
                }
                if (i92 != null && i92.size() > 0) {
                    w[] wVarArr2 = (w[]) i92.toArray(new w[i92.size()]);
                    for (v vVar2 : list) {
                        if (!vVar2.zn()) {
                            vVar2.y(wVarArr2);
                        }
                    }
                }
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    @NonNull
    public static v y(@NonNull Context context, @NonNull c5 c5Var) {
        if (Build.VERSION.SDK_INT >= 23) {
            w9.n3 n3Var = new w9.n3(context, c5Var);
            cs.gv.y(context, SystemJobService.class, true);
            f.zn().y(y, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return n3Var;
        }
        v zn2 = zn(context);
        if (zn2 == null) {
            oa.n3 n3Var2 = new oa.n3(context);
            cs.gv.y(context, SystemAlarmService.class, true);
            f.zn().y(y, "Created SystemAlarmScheduler", new Throwable[0]);
            return n3Var2;
        }
        return zn2;
    }

    @Nullable
    public static v zn(@NonNull Context context) {
        try {
            v vVar = (v) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(context);
            f.zn().y(y, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
            return vVar;
        } catch (Throwable th) {
            f.zn().y(y, "Unable to create GCM Scheduler", th);
            return null;
        }
    }
}
