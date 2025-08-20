package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(xb.n3 n3Var) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.y = (IconCompat) n3Var.x4(remoteActionCompat.y, 1);
        remoteActionCompat.f2305n3 = n3Var.t(remoteActionCompat.f2305n3, 2);
        remoteActionCompat.f2307zn = n3Var.t(remoteActionCompat.f2307zn, 3);
        remoteActionCompat.f2304gv = (PendingIntent) n3Var.mt(remoteActionCompat.f2304gv, 4);
        remoteActionCompat.f2306v = n3Var.s(remoteActionCompat.f2306v, 5);
        remoteActionCompat.f2303a = n3Var.s(remoteActionCompat.f2303a, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, xb.n3 n3Var) {
        n3Var.f3(false, false);
        n3Var.k5(remoteActionCompat.y, 1);
        n3Var.mg(remoteActionCompat.f2305n3, 2);
        n3Var.mg(remoteActionCompat.f2307zn, 3);
        n3Var.ej(remoteActionCompat.f2304gv, 4);
        n3Var.c(remoteActionCompat.f2306v, 5);
        n3Var.c(remoteActionCompat.f2303a, 6);
    }
}
