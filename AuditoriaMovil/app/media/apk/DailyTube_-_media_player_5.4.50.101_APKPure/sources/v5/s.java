package v5;
/* loaded from: classes.dex */
public class s {

    /* renamed from: n3  reason: collision with root package name */
    public boolean f14393n3;
    public final v y;

    public s() {
        this(v.y);
    }

    public synchronized boolean a() {
        if (this.f14393n3) {
            return false;
        }
        this.f14393n3 = true;
        notifyAll();
        return true;
    }

    public synchronized boolean gv() {
        boolean z2;
        z2 = this.f14393n3;
        this.f14393n3 = false;
        return z2;
    }

    public synchronized boolean n3(long j2) throws InterruptedException {
        if (j2 <= 0) {
            return this.f14393n3;
        }
        long elapsedRealtime = this.y.elapsedRealtime();
        long j4 = j2 + elapsedRealtime;
        if (j4 < elapsedRealtime) {
            y();
        } else {
            while (!this.f14393n3 && elapsedRealtime < j4) {
                wait(j4 - elapsedRealtime);
                elapsedRealtime = this.y.elapsedRealtime();
            }
        }
        return this.f14393n3;
    }

    public synchronized boolean v() {
        return this.f14393n3;
    }

    public synchronized void y() throws InterruptedException {
        while (!this.f14393n3) {
            wait();
        }
    }

    public synchronized void zn() {
        boolean z2 = false;
        while (!this.f14393n3) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public s(v vVar) {
        this.y = vVar;
    }
}
