package vp;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import l.f;
import l.mt;
import le.w;
/* loaded from: classes.dex */
public class y {

    /* renamed from: gv  reason: collision with root package name */
    public static final String f14488gv = f.a("DelayedWorkTracker");

    /* renamed from: n3  reason: collision with root package name */
    public final mt f14489n3;
    public final n3 y;

    /* renamed from: zn  reason: collision with root package name */
    public final Map<String, Runnable> f14490zn = new HashMap();

    /* renamed from: vp.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0239y implements Runnable {
        public final /* synthetic */ w y;

        public RunnableC0239y(w wVar) {
            this.y = wVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.zn().y(y.f14488gv, String.format("Scheduling work %s", this.y.y), new Throwable[0]);
            y.this.y.y(this.y);
        }
    }

    public y(@NonNull n3 n3Var, @NonNull mt mtVar) {
        this.y = n3Var;
        this.f14489n3 = mtVar;
    }

    public void n3(@NonNull String str) {
        Runnable remove = this.f14490zn.remove(str);
        if (remove != null) {
            this.f14489n3.y(remove);
        }
    }

    public void y(@NonNull w wVar) {
        Runnable remove = this.f14490zn.remove(wVar.y);
        if (remove != null) {
            this.f14489n3.y(remove);
        }
        RunnableC0239y runnableC0239y = new RunnableC0239y(wVar);
        this.f14490zn.put(wVar.y, runnableC0239y);
        long currentTimeMillis = System.currentTimeMillis();
        this.f14489n3.n3(wVar.y() - currentTimeMillis, runnableC0239y);
    }
}
