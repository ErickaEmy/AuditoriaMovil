package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.WorkDatabase;
import b.y;
import cs.a;
import gq.c5;
import gq.s;
import java.util.List;
import java.util.concurrent.TimeUnit;
import l.f;
import l.z;
import le.p;
import le.w;
import le.wz;
import w9.n3;
/* loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {

    /* renamed from: fb  reason: collision with root package name */
    public int f3758fb = 0;

    /* renamed from: v  reason: collision with root package name */
    public final c5 f3759v;
    public final Context y;

    /* renamed from: s  reason: collision with root package name */
    public static final String f3757s = f.a("ForceStopRunnable");

    /* renamed from: f  reason: collision with root package name */
    public static final long f3756f = TimeUnit.DAYS.toMillis(3650);

    /* loaded from: classes.dex */
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        public static final String y = f.a("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, @Nullable Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                f.zn().fb(y, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.fb(context);
            }
        }
    }

    public ForceStopRunnable(@NonNull Context context, @NonNull c5 c5Var) {
        this.y = context.getApplicationContext();
        this.f3759v = c5Var;
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void fb(Context context) {
        int i;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (y.n3()) {
            i = 167772160;
        } else {
            i = 134217728;
        }
        PendingIntent gv2 = gv(context, i);
        long currentTimeMillis = System.currentTimeMillis() + f3756f;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, gv2);
        }
    }

    public static PendingIntent gv(Context context, int i) {
        return PendingIntent.getBroadcast(context, -1, zn(context), i);
    }

    public static Intent zn(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    public boolean a() {
        androidx.work.y tl2 = this.f3759v.tl();
        if (TextUtils.isEmpty(tl2.zn())) {
            f.zn().y(f3757s, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean n32 = a.n3(this.y, tl2);
        f.zn().y(f3757s, String.format("Is default app process = %s", Boolean.valueOf(n32)), new Throwable[0]);
        return n32;
    }

    public void c5(long j2) {
        try {
            Thread.sleep(j2);
        } catch (InterruptedException unused) {
        }
    }

    public void n3() {
        boolean y = y();
        if (s()) {
            f.zn().y(f3757s, "Rescheduling Workers.", new Throwable[0]);
            this.f3759v.i4();
            this.f3759v.w().zn(false);
        } else if (v()) {
            f.zn().y(f3757s, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f3759v.i4();
        } else if (y) {
            f.zn().y(f3757s, "Found unfinished work, scheduling it.", new Throwable[0]);
            gq.a.n3(this.f3759v.tl(), this.f3759v.co(), this.f3759v.mt());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        try {
            if (!a()) {
                return;
            }
            while (true) {
                s.v(this.y);
                f.zn().y(f3757s, "Performing cleanup operations.", new Throwable[0]);
                try {
                    n3();
                    return;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e2) {
                    i = this.f3758fb + 1;
                    this.f3758fb = i;
                    if (i < 3) {
                        f.zn().y(f3757s, String.format("Retrying after %s", Long.valueOf(i * 300)), e2);
                        c5(this.f3758fb * 300);
                    } else {
                        f.zn().n3(f3757s, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        this.f3759v.tl().gv();
                        throw illegalStateException;
                    }
                }
                f.zn().y(f3757s, String.format("Retrying after %s", Long.valueOf(i * 300)), e2);
                c5(this.f3758fb * 300);
            }
        } finally {
            this.f3759v.x4();
        }
    }

    public boolean s() {
        return this.f3759v.w().y();
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean v() {
        int i;
        try {
            if (y.n3()) {
                i = 570425344;
            } else {
                i = 536870912;
            }
            PendingIntent gv2 = gv(this.y, i);
            if (Build.VERSION.SDK_INT >= 30) {
                if (gv2 != null) {
                    gv2.cancel();
                }
                List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) this.y.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    for (int i5 = 0; i5 < historicalProcessExitReasons.size(); i5++) {
                        if (historicalProcessExitReasons.get(i5).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (gv2 == null) {
                fb(this.y);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e2) {
            e = e2;
            f.zn().s(f3757s, "Ignoring exception", e);
            return true;
        } catch (SecurityException e3) {
            e = e3;
            f.zn().s(f3757s, "Ignoring exception", e);
            return true;
        }
    }

    public boolean y() {
        boolean z2;
        boolean z3;
        if (Build.VERSION.SDK_INT >= 23) {
            z2 = n3.s(this.y, this.f3759v);
        } else {
            z2 = false;
        }
        WorkDatabase co2 = this.f3759v.co();
        p f4 = co2.f();
        wz i92 = co2.i9();
        co2.beginTransaction();
        try {
            List<w> w4 = f4.w();
            if (w4 != null && !w4.isEmpty()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                for (w wVar : w4) {
                    f4.fb(z.y.ENQUEUED, wVar.y);
                    f4.t(wVar.y, -1L);
                }
            }
            i92.y();
            co2.setTransactionSuccessful();
            co2.endTransaction();
            if (!z3 && !z2) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            co2.endTransaction();
            throw th;
        }
    }
}
