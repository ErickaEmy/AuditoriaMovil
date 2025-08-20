package cs;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
import java.util.UUID;
import l.p;
import l.z;
import le.w;
/* loaded from: classes.dex */
public class tl implements p {

    /* renamed from: zn  reason: collision with root package name */
    public static final String f6877zn = l.f.a("WorkProgressUpdater");

    /* renamed from: n3  reason: collision with root package name */
    public final ix.y f6878n3;
    public final WorkDatabase y;

    /* loaded from: classes.dex */
    public class y implements Runnable {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ ro.zn f6879fb;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ androidx.work.n3 f6881v;
        public final /* synthetic */ UUID y;

        public y(UUID uuid, androidx.work.n3 n3Var, ro.zn znVar) {
            this.y = uuid;
            this.f6881v = n3Var;
            this.f6879fb = znVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w a2;
            String uuid = this.y.toString();
            l.f zn2 = l.f.zn();
            String str = tl.f6877zn;
            zn2.y(str, String.format("Updating progress for %s (%s)", this.y, this.f6881v), new Throwable[0]);
            tl.this.y.beginTransaction();
            try {
                a2 = tl.this.y.f().a(uuid);
            } finally {
                try {
                    return;
                } finally {
                }
            }
            if (a2 != null) {
                if (a2.f10338n3 == z.y.RUNNING) {
                    tl.this.y.i9().n3(new le.tl(uuid, this.f6881v));
                } else {
                    l.f.zn().s(str, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", uuid), new Throwable[0]);
                }
                this.f6879fb.xc(null);
                tl.this.y.setTransactionSuccessful();
                return;
            }
            throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
        }
    }

    public tl(@NonNull WorkDatabase workDatabase, @NonNull ix.y yVar) {
        this.y = workDatabase;
        this.f6878n3 = yVar;
    }

    @Override // l.p
    @NonNull
    public f1.zn<Void> y(@NonNull Context context, @NonNull UUID uuid, @NonNull androidx.work.n3 n3Var) {
        ro.zn co2 = ro.zn.co();
        this.f6878n3.n3(new y(uuid, n3Var, co2));
        return co2;
    }
}
