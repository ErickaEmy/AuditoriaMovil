package p7;

import af.i4;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
import kx.j5;
import kx.p;
import kx.ta;
import m1.m;
/* loaded from: classes.dex */
public abstract class a implements ta.v {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final Object f12441a;

    /* renamed from: c5  reason: collision with root package name */
    public final j5 f12442c5;

    /* renamed from: fb  reason: collision with root package name */
    public final long f12443fb;

    /* renamed from: gv  reason: collision with root package name */
    public final m f12444gv;

    /* renamed from: n3  reason: collision with root package name */
    public final p f12445n3;

    /* renamed from: s  reason: collision with root package name */
    public final long f12446s;

    /* renamed from: v  reason: collision with root package name */
    public final int f12447v;
    public final long y = i4.y();

    /* renamed from: zn  reason: collision with root package name */
    public final int f12448zn;

    public a(kx.tl tlVar, p pVar, int i, m mVar, int i5, @Nullable Object obj, long j2, long j4) {
        this.f12442c5 = new j5(tlVar);
        this.f12445n3 = (p) v5.y.v(pVar);
        this.f12448zn = i;
        this.f12444gv = mVar;
        this.f12447v = i5;
        this.f12441a = obj;
        this.f12443fb = j2;
        this.f12446s = j4;
    }

    public final Map<String, List<String>> gv() {
        return this.f12442c5.mt();
    }

    public final Uri v() {
        return this.f12442c5.c5();
    }

    public final long y() {
        return this.f12442c5.a();
    }

    public final long zn() {
        return this.f12446s - this.f12443fb;
    }
}
