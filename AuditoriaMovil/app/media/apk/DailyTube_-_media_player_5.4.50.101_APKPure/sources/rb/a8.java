package rb;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class a8 implements Executor {

    /* renamed from: fb  reason: collision with root package name */
    public Runnable f13148fb;

    /* renamed from: s  reason: collision with root package name */
    public final Object f13149s;

    /* renamed from: v  reason: collision with root package name */
    public final ArrayDeque<Runnable> f13150v;
    public final Executor y;

    public a8(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.y = executor;
        this.f13150v = new ArrayDeque<>();
        this.f13149s = new Object();
    }

    public static final void n3(Runnable command, a8 this$0) {
        Intrinsics.checkNotNullParameter(command, "$command");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            command.run();
        } finally {
            this$0.zn();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable command) {
        Intrinsics.checkNotNullParameter(command, "command");
        synchronized (this.f13149s) {
            try {
                this.f13150v.offer(new Runnable() { // from class: rb.ud
                    @Override // java.lang.Runnable
                    public final void run() {
                        a8.n3(command, this);
                    }
                });
                if (this.f13148fb == null) {
                    zn();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zn() {
        synchronized (this.f13149s) {
            try {
                Runnable poll = this.f13150v.poll();
                Runnable runnable = poll;
                this.f13148fb = runnable;
                if (poll != null) {
                    this.y.execute(runnable);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
