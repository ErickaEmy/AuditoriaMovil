package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.workers.DiagnosticsWorker;
import l.f;
import l.r;
import l.tl;
/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    public static final String y = f.a("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull Context context, @Nullable Intent intent) {
        if (intent == null) {
            return;
        }
        f.zn().y(y, "Requesting diagnostics", new Throwable[0]);
        try {
            r.fb(context).gv(tl.gv(DiagnosticsWorker.class));
        } catch (IllegalStateException e2) {
            f.zn().n3(y, "WorkManager is not initialized", e2);
        }
    }
}
