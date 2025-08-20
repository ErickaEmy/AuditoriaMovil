package w9;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.work.impl.background.systemjob.SystemJobService;
import l.f;
import l.t;
import l.zn;
import le.w;
/* loaded from: classes.dex */
public class y {

    /* renamed from: n3  reason: collision with root package name */
    public static final String f14537n3 = f.a("SystemJobInfoConverter");
    public final ComponentName y;

    /* renamed from: w9.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0244y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[t.values().length];
            y = iArr;
            try {
                iArr[t.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[t.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[t.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[t.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                y[t.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public y(@NonNull Context context) {
        this.y = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    public static void gv(@NonNull JobInfo.Builder builder, @NonNull t tVar) {
        if (Build.VERSION.SDK_INT >= 30 && tVar == t.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        } else {
            builder.setRequiredNetworkType(zn(tVar));
        }
    }

    public static JobInfo.TriggerContentUri n3(zn.y yVar) {
        return new JobInfo.TriggerContentUri(yVar.y(), yVar.n3() ? 1 : 0);
    }

    public static int zn(t tVar) {
        int i = C0244y.y[tVar.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i != 4) {
            if (i == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        f.zn().y(f14537n3, String.format("API version too low. Cannot convert network type value %s", tVar), new Throwable[0]);
        return 1;
    }

    public JobInfo y(w wVar, int i) {
        boolean z2;
        int i5;
        l.n3 n3Var = wVar.f10336i9;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", wVar.y);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", wVar.gv());
        JobInfo.Builder extras = new JobInfo.Builder(i, this.y).setRequiresCharging(n3Var.fb()).setRequiresDeviceIdle(n3Var.s()).setExtras(persistableBundle);
        gv(extras, n3Var.n3());
        boolean z3 = false;
        if (!n3Var.s()) {
            if (wVar.f10341t == l.y.LINEAR) {
                i5 = 0;
            } else {
                i5 = 1;
            }
            extras.setBackoffCriteria(wVar.f10342tl, i5);
        }
        long max = Math.max(wVar.y() - System.currentTimeMillis(), 0L);
        int i6 = Build.VERSION.SDK_INT;
        if (i6 <= 28) {
            extras.setMinimumLatency(max);
        } else if (max > 0) {
            extras.setMinimumLatency(max);
        } else if (!wVar.f10339p) {
            extras.setImportantWhileForeground(true);
        }
        if (i6 >= 24 && n3Var.v()) {
            for (zn.y yVar : n3Var.y().n3()) {
                extras.addTriggerContentUri(n3(yVar));
            }
            extras.setTriggerContentUpdateDelay(n3Var.zn());
            extras.setTriggerContentMaxDelay(n3Var.gv());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(n3Var.a());
            extras.setRequiresStorageNotLow(n3Var.c5());
        }
        if (wVar.f10333f > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (max > 0) {
            z3 = true;
        }
        if (b.y.n3() && wVar.f10339p && !z2 && !z3) {
            extras.setExpedited(true);
        }
        return extras.build();
    }
}
