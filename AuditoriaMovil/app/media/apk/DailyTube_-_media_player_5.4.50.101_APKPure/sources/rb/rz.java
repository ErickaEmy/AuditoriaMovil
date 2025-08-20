package rb;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import rb.p;
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class rz<T> extends LiveData<T> {

    /* renamed from: co  reason: collision with root package name */
    public final AtomicBoolean f13230co;

    /* renamed from: mt  reason: collision with root package name */
    public final AtomicBoolean f13231mt;

    /* renamed from: p  reason: collision with root package name */
    public final AtomicBoolean f13232p;

    /* renamed from: r  reason: collision with root package name */
    public final Runnable f13233r;

    /* renamed from: t  reason: collision with root package name */
    public final i4 f13234t;

    /* renamed from: tl  reason: collision with root package name */
    public final xc f13235tl;

    /* renamed from: w  reason: collision with root package name */
    public final p.zn f13236w;

    /* renamed from: wz  reason: collision with root package name */
    public final boolean f13237wz;

    /* renamed from: xc  reason: collision with root package name */
    public final Callable<T> f13238xc;

    /* renamed from: z  reason: collision with root package name */
    public final Runnable f13239z;

    /* loaded from: classes.dex */
    public static final class y extends p.zn {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ rz<T> f13240n3;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(String[] strArr, rz<T> rzVar) {
            super(strArr);
            this.f13240n3 = rzVar;
        }

        @Override // rb.p.zn
        public void zn(Set<String> tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            xc.y.a().n3(this.f13240n3.mt());
        }
    }

    public rz(i4 database, xc container, boolean z2, Callable<T> computeFunction, String[] tableNames) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(computeFunction, "computeFunction");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        this.f13234t = database;
        this.f13235tl = container;
        this.f13237wz = z2;
        this.f13238xc = computeFunction;
        this.f13236w = new y(tableNames, this);
        this.f13232p = new AtomicBoolean(true);
        this.f13231mt = new AtomicBoolean(false);
        this.f13230co = new AtomicBoolean(false);
        this.f13239z = new Runnable() { // from class: rb.d0
            @Override // java.lang.Runnable
            public final void run() {
                rz.r(rz.this);
            }
        };
        this.f13233r = new Runnable() { // from class: rb.fh
            @Override // java.lang.Runnable
            public final void run() {
                rz.z(rz.this);
            }
        };
    }

    public static final void r(rz this$0) {
        boolean z2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.f13230co.compareAndSet(false, true)) {
            this$0.f13234t.getInvalidationTracker().zn(this$0.f13236w);
        }
        do {
            if (this$0.f13231mt.compareAndSet(false, true)) {
                T t2 = null;
                z2 = false;
                while (this$0.f13232p.compareAndSet(true, false)) {
                    try {
                        try {
                            t2 = this$0.f13238xc.call();
                            z2 = true;
                        } catch (Exception e2) {
                            throw new RuntimeException("Exception while computing database live data.", e2);
                        }
                    } finally {
                        this$0.f13231mt.set(false);
                    }
                }
                if (z2) {
                    this$0.t(t2);
                }
            } else {
                z2 = false;
            }
            if (!z2) {
                return;
            }
        } while (this$0.f13232p.get());
    }

    public static final void z(rz this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean fb2 = this$0.fb();
        if (this$0.f13232p.compareAndSet(false, true) && fb2) {
            this$0.co().execute(this$0.f13239z);
        }
    }

    public final Executor co() {
        if (this.f13237wz) {
            return this.f13234t.getTransactionExecutor();
        }
        return this.f13234t.getQueryExecutor();
    }

    @Override // androidx.lifecycle.LiveData
    public void f() {
        super.f();
        xc xcVar = this.f13235tl;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        xcVar.zn(this);
    }

    @Override // androidx.lifecycle.LiveData
    public void i9() {
        super.i9();
        xc xcVar = this.f13235tl;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        xcVar.n3(this);
        co().execute(this.f13239z);
    }

    public final Runnable mt() {
        return this.f13233r;
    }
}
