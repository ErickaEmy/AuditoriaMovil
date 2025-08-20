package rb;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: tl  reason: collision with root package name */
    public static final y f13283tl = new y(null);

    /* renamed from: a  reason: collision with root package name */
    public final Executor f13284a;

    /* renamed from: c5  reason: collision with root package name */
    public u0.fb f13285c5;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f13286f;

    /* renamed from: fb  reason: collision with root package name */
    public int f13287fb;

    /* renamed from: gv  reason: collision with root package name */
    public final Object f13288gv;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f13289i9;

    /* renamed from: n3  reason: collision with root package name */
    public final Handler f13290n3;

    /* renamed from: s  reason: collision with root package name */
    public long f13291s;

    /* renamed from: t  reason: collision with root package name */
    public final Runnable f13292t;

    /* renamed from: v  reason: collision with root package name */
    public long f13293v;
    public u0.s y;

    /* renamed from: zn  reason: collision with root package name */
    public Runnable f13294zn;

    /* loaded from: classes.dex */
    public static final class y {
        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public y() {
        }
    }

    public zn(long j2, TimeUnit autoCloseTimeUnit, Executor autoCloseExecutor) {
        Intrinsics.checkNotNullParameter(autoCloseTimeUnit, "autoCloseTimeUnit");
        Intrinsics.checkNotNullParameter(autoCloseExecutor, "autoCloseExecutor");
        this.f13290n3 = new Handler(Looper.getMainLooper());
        this.f13288gv = new Object();
        this.f13293v = autoCloseTimeUnit.toMillis(j2);
        this.f13284a = autoCloseExecutor;
        this.f13291s = SystemClock.uptimeMillis();
        this.f13286f = new Runnable() { // from class: rb.y
            @Override // java.lang.Runnable
            public final void run() {
                zn.a(zn.this);
            }
        };
        this.f13292t = new Runnable() { // from class: rb.n3
            @Override // java.lang.Runnable
            public final void run() {
                zn.zn(zn.this);
            }
        };
    }

    public static final void a(zn this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f13284a.execute(this$0.f13292t);
    }

    public static final void zn(zn this$0) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.f13288gv) {
            try {
                if (SystemClock.uptimeMillis() - this$0.f13291s < this$0.f13293v) {
                    return;
                }
                if (this$0.f13287fb != 0) {
                    return;
                }
                Runnable runnable = this$0.f13294zn;
                if (runnable != null) {
                    runnable.run();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    u0.fb fbVar = this$0.f13285c5;
                    if (fbVar != null && fbVar.isOpen()) {
                        fbVar.close();
                    }
                    this$0.f13285c5 = null;
                    Unit unit2 = Unit.INSTANCE;
                    return;
                }
                throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final u0.s c5() {
        u0.s sVar = this.y;
        if (sVar != null) {
            return sVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("delegateOpenHelper");
        return null;
    }

    public final void f(u0.s delegateOpenHelper) {
        Intrinsics.checkNotNullParameter(delegateOpenHelper, "delegateOpenHelper");
        wz(delegateOpenHelper);
    }

    public final <V> V fb(Function1<? super u0.fb, ? extends V> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke(i9());
        } finally {
            v();
        }
    }

    public final void gv() throws IOException {
        synchronized (this.f13288gv) {
            try {
                this.f13289i9 = true;
                u0.fb fbVar = this.f13285c5;
                if (fbVar != null) {
                    fbVar.close();
                }
                this.f13285c5 = null;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final u0.fb i9() {
        synchronized (this.f13288gv) {
            this.f13290n3.removeCallbacks(this.f13286f);
            this.f13287fb++;
            if (!this.f13289i9) {
                u0.fb fbVar = this.f13285c5;
                if (fbVar != null && fbVar.isOpen()) {
                    return fbVar;
                }
                u0.fb writableDatabase = c5().getWritableDatabase();
                this.f13285c5 = writableDatabase;
                return writableDatabase;
            }
            throw new IllegalStateException("Attempting to open already closed database.");
        }
    }

    public final u0.fb s() {
        return this.f13285c5;
    }

    public final boolean t() {
        return !this.f13289i9;
    }

    public final void tl(Runnable onAutoClose) {
        Intrinsics.checkNotNullParameter(onAutoClose, "onAutoClose");
        this.f13294zn = onAutoClose;
    }

    public final void v() {
        synchronized (this.f13288gv) {
            try {
                int i = this.f13287fb;
                if (i > 0) {
                    int i5 = i - 1;
                    this.f13287fb = i5;
                    if (i5 == 0) {
                        if (this.f13285c5 == null) {
                            return;
                        }
                        this.f13290n3.postDelayed(this.f13286f, this.f13293v);
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void wz(u0.s sVar) {
        Intrinsics.checkNotNullParameter(sVar, "<set-?>");
        this.y = sVar;
    }
}
