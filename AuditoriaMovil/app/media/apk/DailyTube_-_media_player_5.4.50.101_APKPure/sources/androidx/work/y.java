package androidx.work;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import l.i4;
import l.i9;
import l.mt;
import l.s;
/* loaded from: classes.dex */
public final class y {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final String f3774a;

    /* renamed from: c5  reason: collision with root package name */
    public final int f3775c5;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3776f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f3777fb;
    @NonNull

    /* renamed from: gv  reason: collision with root package name */
    public final i9 f3778gv;

    /* renamed from: i9  reason: collision with root package name */
    public final int f3779i9;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public final Executor f3780n3;

    /* renamed from: s  reason: collision with root package name */
    public final int f3781s;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public final mt f3782v;
    @NonNull
    public final Executor y;
    @NonNull

    /* renamed from: zn  reason: collision with root package name */
    public final i4 f3783zn;

    /* loaded from: classes.dex */
    public static final class n3 {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public String f3784a;

        /* renamed from: gv  reason: collision with root package name */
        public Executor f3787gv;

        /* renamed from: n3  reason: collision with root package name */
        public i4 f3789n3;

        /* renamed from: s  reason: collision with root package name */
        public int f3790s;

        /* renamed from: v  reason: collision with root package name */
        public mt f3791v;
        public Executor y;

        /* renamed from: zn  reason: collision with root package name */
        public i9 f3792zn;

        /* renamed from: fb  reason: collision with root package name */
        public int f3786fb = 4;

        /* renamed from: c5  reason: collision with root package name */
        public int f3785c5 = Integer.MAX_VALUE;

        /* renamed from: i9  reason: collision with root package name */
        public int f3788i9 = 20;

        @NonNull
        public y y() {
            return new y(this);
        }
    }

    /* renamed from: androidx.work.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ThreadFactoryC0032y implements ThreadFactory {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ boolean f3794v;
        public final AtomicInteger y = new AtomicInteger(0);

        public ThreadFactoryC0032y(boolean z2) {
            this.f3794v = z2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            String str;
            if (this.f3794v) {
                str = "WM.task-";
            } else {
                str = "androidx.work-";
            }
            return new Thread(runnable, str + this.y.incrementAndGet());
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        @NonNull
        y y();
    }

    public y(@NonNull n3 n3Var) {
        Executor executor = n3Var.y;
        if (executor == null) {
            this.y = y(false);
        } else {
            this.y = executor;
        }
        Executor executor2 = n3Var.f3787gv;
        if (executor2 == null) {
            this.f3776f = true;
            this.f3780n3 = y(true);
        } else {
            this.f3776f = false;
            this.f3780n3 = executor2;
        }
        i4 i4Var = n3Var.f3789n3;
        if (i4Var == null) {
            this.f3783zn = i4.zn();
        } else {
            this.f3783zn = i4Var;
        }
        i9 i9Var = n3Var.f3792zn;
        if (i9Var == null) {
            this.f3778gv = i9.zn();
        } else {
            this.f3778gv = i9Var;
        }
        mt mtVar = n3Var.f3791v;
        if (mtVar == null) {
            this.f3782v = new gq.y();
        } else {
            this.f3782v = mtVar;
        }
        this.f3777fb = n3Var.f3786fb;
        this.f3781s = n3Var.f3790s;
        this.f3775c5 = n3Var.f3785c5;
        this.f3779i9 = n3Var.f3788i9;
        this.f3774a = n3Var.f3784a;
    }

    @NonNull
    public i9 a() {
        return this.f3778gv;
    }

    public int c5() {
        return this.f3781s;
    }

    @NonNull
    public mt f() {
        return this.f3782v;
    }

    public int fb() {
        return this.f3775c5;
    }

    @Nullable
    public s gv() {
        return null;
    }

    public int i9() {
        return this.f3777fb;
    }

    @NonNull
    public final ThreadFactory n3(boolean z2) {
        return new ThreadFactoryC0032y(z2);
    }

    public int s() {
        if (Build.VERSION.SDK_INT == 23) {
            return this.f3779i9 / 2;
        }
        return this.f3779i9;
    }

    @NonNull
    public Executor t() {
        return this.f3780n3;
    }

    @NonNull
    public i4 tl() {
        return this.f3783zn;
    }

    @NonNull
    public Executor v() {
        return this.y;
    }

    @NonNull
    public final Executor y(boolean z2) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), n3(z2));
    }

    @Nullable
    public String zn() {
        return this.f3774a;
    }
}
