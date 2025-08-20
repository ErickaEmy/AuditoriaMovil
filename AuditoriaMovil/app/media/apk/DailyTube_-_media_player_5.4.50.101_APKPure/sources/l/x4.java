package l;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
/* loaded from: classes.dex */
public abstract class x4 {
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public le.w f10230n3;
    @NonNull
    public UUID y;
    @NonNull

    /* renamed from: zn  reason: collision with root package name */
    public Set<String> f10231zn;

    /* loaded from: classes.dex */
    public static abstract class y<B extends y<?, ?>, W extends x4> {

        /* renamed from: gv  reason: collision with root package name */
        public Set<String> f10232gv = new HashSet();

        /* renamed from: n3  reason: collision with root package name */
        public UUID f10233n3 = UUID.randomUUID();

        /* renamed from: v  reason: collision with root package name */
        public Class<? extends ListenableWorker> f10234v;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public le.w f10235zn;

        public y(@NonNull Class<? extends ListenableWorker> cls) {
            this.f10234v = cls;
            this.f10235zn = new le.w(this.f10233n3.toString(), cls.getName());
            y(cls.getName());
        }

        @NonNull
        public final B a(@NonNull androidx.work.n3 n3Var) {
            this.f10235zn.f10343v = n3Var;
            return gv();
        }

        @NonNull
        public abstract B gv();

        @NonNull
        public final W n3() {
            boolean z2;
            W zn2 = zn();
            n3 n3Var = this.f10235zn.f10336i9;
            int i = Build.VERSION.SDK_INT;
            if ((i < 24 || !n3Var.v()) && !n3Var.a() && !n3Var.fb() && (i < 23 || !n3Var.s())) {
                z2 = false;
            } else {
                z2 = true;
            }
            le.w wVar = this.f10235zn;
            if (wVar.f10339p) {
                if (!z2) {
                    if (wVar.f10334fb > 0) {
                        throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                    }
                } else {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
            }
            this.f10233n3 = UUID.randomUUID();
            le.w wVar2 = new le.w(this.f10235zn);
            this.f10235zn = wVar2;
            wVar2.y = this.f10233n3.toString();
            return zn2;
        }

        @NonNull
        public final B v(@NonNull n3 n3Var) {
            this.f10235zn.f10336i9 = n3Var;
            return gv();
        }

        @NonNull
        public final B y(@NonNull String str) {
            this.f10232gv.add(str);
            return gv();
        }

        @NonNull
        public abstract W zn();
    }

    public x4(@NonNull UUID uuid, @NonNull le.w wVar, @NonNull Set<String> set) {
        this.y = uuid;
        this.f10230n3 = wVar;
        this.f10231zn = set;
    }

    @NonNull
    public Set<String> n3() {
        return this.f10231zn;
    }

    @NonNull
    public String y() {
        return this.y.toString();
    }

    @NonNull
    public le.w zn() {
        return this.f10230n3;
    }
}
