package cs;

import androidx.work.WorkerParameters;
/* loaded from: classes.dex */
public class s implements Runnable {

    /* renamed from: fb  reason: collision with root package name */
    public WorkerParameters.y f6868fb;

    /* renamed from: v  reason: collision with root package name */
    public String f6869v;
    public gq.c5 y;

    public s(gq.c5 c5Var, String str, WorkerParameters.y yVar) {
        this.y = c5Var;
        this.f6869v = str;
        this.f6868fb = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.y.p().f(this.f6869v, this.f6868fb);
    }
}
