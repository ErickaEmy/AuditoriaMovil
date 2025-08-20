package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.gv;
import java.util.HashMap;
import java.util.Map;
import l.f;
import le.w;
/* loaded from: classes.dex */
public class y implements gq.n3 {

    /* renamed from: s  reason: collision with root package name */
    public static final String f3718s = f.a("CommandHandler");
    public final Context y;

    /* renamed from: v  reason: collision with root package name */
    public final Map<String, gq.n3> f3720v = new HashMap();

    /* renamed from: fb  reason: collision with root package name */
    public final Object f3719fb = new Object();

    public y(@NonNull Context context) {
        this.y = context;
    }

    public static Intent a(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent fb(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent n3(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent v(@NonNull Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    public static boolean wz(@Nullable Bundle bundle, @NonNull String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    public static Intent y(@NonNull Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    public static Intent zn(@NonNull Context context, @NonNull String str, boolean z2) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z2);
        return intent;
    }

    public final void c5(@NonNull Intent intent, int i, @NonNull gv gvVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.f3719fb) {
            try {
                String string = extras.getString("KEY_WORKSPEC_ID");
                f zn2 = f.zn();
                String str = f3718s;
                zn2.y(str, String.format("Handing delay met for %s", string), new Throwable[0]);
                if (!this.f3720v.containsKey(string)) {
                    zn znVar = new zn(this.y, i, string, gvVar);
                    this.f3720v.put(string, znVar);
                    znVar.a();
                } else {
                    f.zn().y(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string), new Throwable[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(@NonNull Intent intent, int i, @NonNull gv gvVar) {
        f.zn().y(f3718s, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i)), new Throwable[0]);
        gvVar.fb().i4();
    }

    @Override // gq.n3
    public void gv(@NonNull String str, boolean z2) {
        synchronized (this.f3719fb) {
            try {
                gq.n3 remove = this.f3720v.remove(str);
                if (remove != null) {
                    remove.gv(str, z2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i9(@NonNull Intent intent, int i) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z2 = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        f.zn().y(f3718s, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i)), new Throwable[0]);
        gv(string, z2);
    }

    public final void s(@NonNull Intent intent, int i, @NonNull gv gvVar) {
        f.zn().y(f3718s, String.format("Handling constraints changed %s", intent), new Throwable[0]);
        new n3(this.y, i, gvVar).y();
    }

    public final void t(@NonNull Intent intent, int i, @NonNull gv gvVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        f zn2 = f.zn();
        String str = f3718s;
        zn2.y(str, String.format("Handling schedule work for %s", string), new Throwable[0]);
        WorkDatabase co2 = gvVar.fb().co();
        co2.beginTransaction();
        try {
            w a2 = co2.f().a(string);
            if (a2 == null) {
                f zn3 = f.zn();
                zn3.s(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
            } else if (a2.f10338n3.y()) {
                f zn4 = f.zn();
                zn4.s(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
            } else {
                long y = a2.y();
                if (!a2.n3()) {
                    f.zn().y(str, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(y)), new Throwable[0]);
                    oa.y.zn(this.y, gvVar.fb(), string, y);
                } else {
                    f.zn().y(str, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(y)), new Throwable[0]);
                    oa.y.zn(this.y, gvVar.fb(), string, y);
                    gvVar.f(new gv.n3(gvVar, y(this.y), i));
                }
                co2.setTransactionSuccessful();
            }
        } finally {
            co2.endTransaction();
        }
    }

    public final void tl(@NonNull Intent intent, @NonNull gv gvVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        f.zn().y(f3718s, String.format("Handing stopWork work for %s", string), new Throwable[0]);
        gvVar.fb().fh(string);
        oa.y.y(this.y, gvVar.fb(), string);
        gvVar.gv(string, false);
    }

    public void w(@NonNull Intent intent, int i, @NonNull gv gvVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            s(intent, i, gvVar);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            f(intent, i, gvVar);
        } else if (!wz(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            f.zn().n3(f3718s, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
        } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            t(intent, i, gvVar);
        } else if ("ACTION_DELAY_MET".equals(action)) {
            c5(intent, i, gvVar);
        } else if ("ACTION_STOP_WORK".equals(action)) {
            tl(intent, gvVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            i9(intent, i);
        } else {
            f.zn().s(f3718s, String.format("Ignoring intent %s", intent), new Throwable[0]);
        }
    }

    public boolean xc() {
        boolean z2;
        synchronized (this.f3719fb) {
            z2 = !this.f3720v.isEmpty();
        }
        return z2;
    }
}
