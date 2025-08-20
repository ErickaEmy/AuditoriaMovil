package af;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class i4 {

    /* renamed from: s  reason: collision with root package name */
    public static final AtomicLong f250s = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public final long f251a;

    /* renamed from: fb  reason: collision with root package name */
    public final long f252fb;

    /* renamed from: gv  reason: collision with root package name */
    public final Map<String, List<String>> f253gv;

    /* renamed from: n3  reason: collision with root package name */
    public final kx.p f254n3;

    /* renamed from: v  reason: collision with root package name */
    public final long f255v;
    public final long y;

    /* renamed from: zn  reason: collision with root package name */
    public final Uri f256zn;

    public i4(long j2, kx.p pVar, long j4) {
        this(j2, pVar, pVar.y, Collections.emptyMap(), j4, 0L, 0L);
    }

    public static long y() {
        return f250s.getAndIncrement();
    }

    public i4(long j2, kx.p pVar, Uri uri, Map<String, List<String>> map, long j4, long j6, long j7) {
        this.y = j2;
        this.f254n3 = pVar;
        this.f256zn = uri;
        this.f253gv = map;
        this.f255v = j4;
        this.f251a = j6;
        this.f252fb = j7;
    }
}
