package kx;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import kx.p;
import kx.ta;
/* loaded from: classes.dex */
public final class z6<T> implements ta.v {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public volatile T f10188a;

    /* renamed from: gv  reason: collision with root package name */
    public final j5 f10189gv;

    /* renamed from: n3  reason: collision with root package name */
    public final p f10190n3;

    /* renamed from: v  reason: collision with root package name */
    public final y<? extends T> f10191v;
    public final long y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f10192zn;

    /* loaded from: classes.dex */
    public interface y<T> {
        T y(Uri uri, InputStream inputStream) throws IOException;
    }

    public z6(tl tlVar, Uri uri, int i, y<? extends T> yVar) {
        this(tlVar, new p.n3().c5(uri).n3(1).y(), i, yVar);
    }

    @Nullable
    public final T gv() {
        return this.f10188a;
    }

    @Override // kx.ta.v
    public final void load() throws IOException {
        this.f10189gv.r();
        xc xcVar = new xc(this.f10189gv, this.f10190n3);
        try {
            xcVar.v();
            this.f10188a = this.f10191v.y((Uri) v5.y.v(this.f10189gv.n3()), xcVar);
        } finally {
            v5.j5.wz(xcVar);
        }
    }

    public Uri v() {
        return this.f10189gv.c5();
    }

    public long y() {
        return this.f10189gv.a();
    }

    public Map<String, List<String>> zn() {
        return this.f10189gv.mt();
    }

    public z6(tl tlVar, p pVar, int i, y<? extends T> yVar) {
        this.f10189gv = new j5(tlVar);
        this.f10190n3 = pVar;
        this.f10192zn = i;
        this.f10191v = yVar;
        this.y = af.i4.y();
    }

    @Override // kx.ta.v
    public final void n3() {
    }
}
