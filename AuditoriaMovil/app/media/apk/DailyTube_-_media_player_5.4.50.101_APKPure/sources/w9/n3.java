package w9;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import cs.zn;
import gq.c5;
import gq.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import l.f;
import l.xc;
import l.z;
import le.fb;
import le.p;
import le.w;
/* loaded from: classes.dex */
public class n3 implements v {

    /* renamed from: f  reason: collision with root package name */
    public static final String f14533f = f.a("SystemJobScheduler");

    /* renamed from: fb  reason: collision with root package name */
    public final c5 f14534fb;

    /* renamed from: s  reason: collision with root package name */
    public final y f14535s;

    /* renamed from: v  reason: collision with root package name */
    public final JobScheduler f14536v;
    public final Context y;

    public n3(@NonNull Context context, @NonNull c5 c5Var) {
        this(context, c5Var, (JobScheduler) context.getSystemService("jobscheduler"), new y(context));
    }

    @Nullable
    public static List<JobInfo> a(@NonNull Context context, @NonNull JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            f.zn().n3(f14533f, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    @Nullable
    public static String fb(@NonNull JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras != null) {
            try {
                if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                    return extras.getString("EXTRA_WORK_SPEC_ID");
                }
                return null;
            } catch (NullPointerException unused) {
                return null;
            }
        }
        return null;
    }

    public static void gv(@NonNull JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            f.zn().n3(f14533f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    public static void n3(@NonNull Context context) {
        List<JobInfo> a2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (a2 = a(context, jobScheduler)) != null && !a2.isEmpty()) {
            for (JobInfo jobInfo : a2) {
                gv(jobScheduler, jobInfo.getId());
            }
        }
    }

    public static boolean s(@NonNull Context context, @NonNull c5 c5Var) {
        int i;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> a2 = a(context, jobScheduler);
        List<String> zn2 = c5Var.co().s().zn();
        boolean z2 = false;
        if (a2 != null) {
            i = a2.size();
        } else {
            i = 0;
        }
        HashSet hashSet = new HashSet(i);
        if (a2 != null && !a2.isEmpty()) {
            for (JobInfo jobInfo : a2) {
                String fb2 = fb(jobInfo);
                if (!TextUtils.isEmpty(fb2)) {
                    hashSet.add(fb2);
                } else {
                    gv(jobScheduler, jobInfo.getId());
                }
            }
        }
        Iterator<String> it = zn2.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!hashSet.contains(it.next())) {
                    f.zn().y(f14533f, "Reconciling jobs", new Throwable[0]);
                    z2 = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z2) {
            WorkDatabase co2 = c5Var.co();
            co2.beginTransaction();
            try {
                p f4 = co2.f();
                for (String str : zn2) {
                    f4.t(str, -1L);
                }
                co2.setTransactionSuccessful();
                co2.endTransaction();
            } catch (Throwable th) {
                co2.endTransaction();
                throw th;
            }
        }
        return z2;
    }

    @Nullable
    public static List<Integer> v(@NonNull Context context, @NonNull JobScheduler jobScheduler, @NonNull String str) {
        List<JobInfo> a2 = a(context, jobScheduler);
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : a2) {
            if (str.equals(fb(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    public void c5(w wVar, int i) {
        int i5;
        JobInfo y = this.f14535s.y(wVar, i);
        f zn2 = f.zn();
        String str = f14533f;
        zn2.y(str, String.format("Scheduling work ID %s Job ID %s", wVar.y, Integer.valueOf(i)), new Throwable[0]);
        try {
            if (this.f14536v.schedule(y) == 0) {
                f.zn().s(str, String.format("Unable to schedule work ID %s", wVar.y), new Throwable[0]);
                if (wVar.f10339p && wVar.f10337mt == xc.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    wVar.f10339p = false;
                    f.zn().y(str, String.format("Scheduling a non-expedited job (work ID %s)", wVar.y), new Throwable[0]);
                    c5(wVar, i);
                }
            }
        } catch (IllegalStateException e2) {
            List<JobInfo> a2 = a(this.y, this.f14536v);
            if (a2 != null) {
                i5 = a2.size();
            } else {
                i5 = 0;
            }
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(i5), Integer.valueOf(this.f14534fb.co().f().n3().size()), Integer.valueOf(this.f14534fb.tl().s()));
            f.zn().n3(f14533f, format, new Throwable[0]);
            throw new IllegalStateException(format, e2);
        } catch (Throwable th) {
            f.zn().n3(f14533f, String.format("Unable to schedule %s", wVar), th);
        }
    }

    @Override // gq.v
    public void cancel(@NonNull String str) {
        List<Integer> v2 = v(this.y, this.f14536v, str);
        if (v2 != null && !v2.isEmpty()) {
            for (Integer num : v2) {
                gv(this.f14536v, num.intValue());
            }
            this.f14534fb.co().s().gv(str);
        }
    }

    @Override // gq.v
    public void y(@NonNull w... wVarArr) {
        int gv2;
        List<Integer> v2;
        int gv3;
        WorkDatabase co2 = this.f14534fb.co();
        zn znVar = new zn(co2);
        for (w wVar : wVarArr) {
            co2.beginTransaction();
            try {
                w a2 = co2.f().a(wVar.y);
                if (a2 == null) {
                    f.zn().s(f14533f, "Skipping scheduling " + wVar.y + " because it's no longer in the DB", new Throwable[0]);
                    co2.setTransactionSuccessful();
                } else if (a2.f10338n3 != z.y.ENQUEUED) {
                    f.zn().s(f14533f, "Skipping scheduling " + wVar.y + " because it is no longer enqueued", new Throwable[0]);
                    co2.setTransactionSuccessful();
                } else {
                    fb y = co2.s().y(wVar.y);
                    if (y != null) {
                        gv2 = y.f10314n3;
                    } else {
                        gv2 = znVar.gv(this.f14534fb.tl().c5(), this.f14534fb.tl().fb());
                    }
                    if (y == null) {
                        this.f14534fb.co().s().n3(new fb(wVar.y, gv2));
                    }
                    c5(wVar, gv2);
                    if (Build.VERSION.SDK_INT == 23 && (v2 = v(this.y, this.f14536v, wVar.y)) != null) {
                        int indexOf = v2.indexOf(Integer.valueOf(gv2));
                        if (indexOf >= 0) {
                            v2.remove(indexOf);
                        }
                        if (!v2.isEmpty()) {
                            gv3 = v2.get(0).intValue();
                        } else {
                            gv3 = znVar.gv(this.f14534fb.tl().c5(), this.f14534fb.tl().fb());
                        }
                        c5(wVar, gv3);
                    }
                    co2.setTransactionSuccessful();
                }
            } finally {
                co2.endTransaction();
            }
        }
    }

    @Override // gq.v
    public boolean zn() {
        return true;
    }

    public n3(Context context, c5 c5Var, JobScheduler jobScheduler, y yVar) {
        this.y = context;
        this.f14534fb = c5Var;
        this.f14536v = jobScheduler;
        this.f14535s = yVar;
    }
}
