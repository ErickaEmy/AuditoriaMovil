package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.WorkerParameters;
import gq.c5;
import gq.n3;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import l.f;
/* loaded from: classes.dex */
public class SystemJobService extends JobService implements n3 {

    /* renamed from: fb  reason: collision with root package name */
    public static final String f3730fb = f.a("SystemJobService");

    /* renamed from: v  reason: collision with root package name */
    public final Map<String, JobParameters> f3731v = new HashMap();
    public c5 y;

    @Nullable
    public static String y(@NonNull JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras != null && extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // gq.n3
    public void gv(@NonNull String str, boolean z2) {
        JobParameters remove;
        f.zn().y(f3730fb, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.f3731v) {
            remove = this.f3731v.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z2);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            c5 xc2 = c5.xc(getApplicationContext());
            this.y = xc2;
            xc2.p().zn(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                f.zn().s(f3730fb, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        c5 c5Var = this.y;
        if (c5Var != null) {
            c5Var.p().c5(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(@NonNull JobParameters jobParameters) {
        WorkerParameters.y yVar;
        if (this.y == null) {
            f.zn().y(f3730fb, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        String y = y(jobParameters);
        if (TextUtils.isEmpty(y)) {
            f.zn().n3(f3730fb, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.f3731v) {
            try {
                if (this.f3731v.containsKey(y)) {
                    f.zn().y(f3730fb, String.format("Job is already being executed by SystemJobService: %s", y), new Throwable[0]);
                    return false;
                }
                f.zn().y(f3730fb, String.format("onStartJob for %s", y), new Throwable[0]);
                this.f3731v.put(y, jobParameters);
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    yVar = new WorkerParameters.y();
                    if (jobParameters.getTriggeredContentUris() != null) {
                        yVar.f3687n3 = Arrays.asList(jobParameters.getTriggeredContentUris());
                    }
                    if (jobParameters.getTriggeredContentAuthorities() != null) {
                        yVar.y = Arrays.asList(jobParameters.getTriggeredContentAuthorities());
                    }
                    if (i >= 28) {
                        yVar.f3688zn = jobParameters.getNetwork();
                    }
                } else {
                    yVar = null;
                }
                this.y.c(y, yVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(@NonNull JobParameters jobParameters) {
        if (this.y == null) {
            f.zn().y(f3730fb, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String y = y(jobParameters);
        if (TextUtils.isEmpty(y)) {
            f.zn().n3(f3730fb, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        f.zn().y(f3730fb, String.format("onStopJob for %s", y), new Throwable[0]);
        synchronized (this.f3731v) {
            this.f3731v.remove(y);
        }
        this.y.fh(y);
        return !this.y.p().a(y);
    }
}
