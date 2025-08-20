package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import gq.c5;
import java.util.List;
import java.util.concurrent.TimeUnit;
import l.f;
import le.fb;
import le.p;
import le.s;
import le.w;
import le.z;
/* loaded from: classes.dex */
public class DiagnosticsWorker extends Worker {
    public static final String y = f.a("DiagnosticsWrkr");

    public DiagnosticsWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @NonNull
    public static String y(@NonNull w wVar, @Nullable String str, @Nullable Integer num, @NonNull String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", wVar.y, wVar.f10347zn, num, wVar.f10338n3.name(), str, str2);
    }

    @NonNull
    public static String zn(@NonNull le.f fVar, @NonNull z zVar, @NonNull s sVar, @NonNull List<w> list) {
        String str;
        Integer num;
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 23) {
            str = "Job Id";
        } else {
            str = "Alarm Id";
        }
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", str));
        for (w wVar : list) {
            fb y2 = sVar.y(wVar.y);
            if (y2 != null) {
                num = Integer.valueOf(y2.f10314n3);
            } else {
                num = null;
            }
            sb.append(y(wVar, TextUtils.join(",", fVar.n3(wVar.y)), num, TextUtils.join(",", zVar.y(wVar.y))));
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    @NonNull
    public ListenableWorker.y doWork() {
        WorkDatabase co2 = c5.xc(getApplicationContext()).co();
        p f4 = co2.f();
        le.f c52 = co2.c5();
        z t2 = co2.t();
        s s2 = co2.s();
        List<w> y2 = f4.y(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List<w> w4 = f4.w();
        List<w> i92 = f4.i9(200);
        if (y2 != null && !y2.isEmpty()) {
            f zn2 = f.zn();
            String str = y;
            zn2.gv(str, "Recently completed work:\n\n", new Throwable[0]);
            f.zn().gv(str, zn(c52, t2, s2, y2), new Throwable[0]);
        }
        if (w4 != null && !w4.isEmpty()) {
            f zn3 = f.zn();
            String str2 = y;
            zn3.gv(str2, "Running work:\n\n", new Throwable[0]);
            f.zn().gv(str2, zn(c52, t2, s2, w4), new Throwable[0]);
        }
        if (i92 != null && !i92.isEmpty()) {
            f zn4 = f.zn();
            String str3 = y;
            zn4.gv(str3, "Enqueued work:\n\n", new Throwable[0]);
            f.zn().gv(str3, zn(c52, t2, s2, i92), new Throwable[0]);
        }
        return ListenableWorker.y.zn();
    }
}
