package cs;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
import java.util.UUID;
import l.z;
import le.p;
/* loaded from: classes.dex */
public class t implements l.fb {

    /* renamed from: gv  reason: collision with root package name */
    public static final String f6870gv = l.f.a("WMFgUpdater");

    /* renamed from: n3  reason: collision with root package name */
    public final mp.y f6871n3;
    public final ix.y y;

    /* renamed from: zn  reason: collision with root package name */
    public final p f6872zn;

    /* loaded from: classes.dex */
    public class y implements Runnable {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ l.a f6874fb;

        /* renamed from: s  reason: collision with root package name */
        public final /* synthetic */ Context f6875s;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ UUID f6876v;
        public final /* synthetic */ ro.zn y;

        public y(ro.zn znVar, UUID uuid, l.a aVar, Context context) {
            this.y = znVar;
            this.f6876v = uuid;
            this.f6874fb = aVar;
            this.f6875s = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.y.isCancelled()) {
                    String uuid = this.f6876v.toString();
                    z.y v2 = t.this.f6872zn.v(uuid);
                    if (v2 != null && !v2.y()) {
                        t.this.f6871n3.n3(uuid, this.f6874fb);
                        this.f6875s.startService(androidx.work.impl.foreground.y.y(this.f6875s, uuid, this.f6874fb));
                    } else {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                }
                this.y.xc(null);
            } catch (Throwable th) {
                this.y.w(th);
            }
        }
    }

    public t(@NonNull WorkDatabase workDatabase, @NonNull mp.y yVar, @NonNull ix.y yVar2) {
        this.f6871n3 = yVar;
        this.y = yVar2;
        this.f6872zn = workDatabase.f();
    }

    @Override // l.fb
    @NonNull
    public f1.zn<Void> y(@NonNull Context context, @NonNull UUID uuid, @NonNull l.a aVar) {
        ro.zn co2 = ro.zn.co();
        this.y.n3(new y(co2, uuid, aVar, context));
        return co2;
    }
}
