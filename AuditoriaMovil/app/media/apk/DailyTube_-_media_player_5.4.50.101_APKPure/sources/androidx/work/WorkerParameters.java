package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import l.fb;
import l.i4;
import l.p;
/* loaded from: classes.dex */
public final class WorkerParameters {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public Executor f3678a;
    @NonNull

    /* renamed from: c5  reason: collision with root package name */
    public p f3679c5;
    @NonNull

    /* renamed from: fb  reason: collision with root package name */
    public ix.y f3680fb;
    @NonNull

    /* renamed from: gv  reason: collision with root package name */
    public y f3681gv;
    @NonNull

    /* renamed from: i9  reason: collision with root package name */
    public fb f3682i9;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public n3 f3683n3;
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    public i4 f3684s;

    /* renamed from: v  reason: collision with root package name */
    public int f3685v;
    @NonNull
    public UUID y;
    @NonNull

    /* renamed from: zn  reason: collision with root package name */
    public Set<String> f3686zn;

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: zn  reason: collision with root package name */
        public Network f3688zn;
        @NonNull
        public List<String> y = Collections.emptyList();
        @NonNull

        /* renamed from: n3  reason: collision with root package name */
        public List<Uri> f3687n3 = Collections.emptyList();
    }

    public WorkerParameters(@NonNull UUID uuid, @NonNull n3 n3Var, @NonNull Collection<String> collection, @NonNull y yVar, int i, @NonNull Executor executor, @NonNull ix.y yVar2, @NonNull i4 i4Var, @NonNull p pVar, @NonNull fb fbVar) {
        this.y = uuid;
        this.f3683n3 = n3Var;
        this.f3686zn = new HashSet(collection);
        this.f3681gv = yVar;
        this.f3685v = i;
        this.f3678a = executor;
        this.f3680fb = yVar2;
        this.f3684s = i4Var;
        this.f3679c5 = pVar;
        this.f3682i9 = fbVar;
    }

    @NonNull
    public p a() {
        return this.f3679c5;
    }

    @NonNull
    public ix.y c5() {
        return this.f3680fb;
    }

    @NonNull
    public List<Uri> f() {
        return this.f3681gv.f3687n3;
    }

    public int fb() {
        return this.f3685v;
    }

    @NonNull
    public n3 gv() {
        return this.f3683n3;
    }

    @NonNull
    public List<String> i9() {
        return this.f3681gv.y;
    }

    @NonNull
    public fb n3() {
        return this.f3682i9;
    }

    @NonNull
    public Set<String> s() {
        return this.f3686zn;
    }

    @NonNull
    public i4 t() {
        return this.f3684s;
    }

    @Nullable
    public Network v() {
        return this.f3681gv.f3688zn;
    }

    @NonNull
    public Executor y() {
        return this.f3678a;
    }

    @NonNull
    public UUID zn() {
        return this.y;
    }
}
