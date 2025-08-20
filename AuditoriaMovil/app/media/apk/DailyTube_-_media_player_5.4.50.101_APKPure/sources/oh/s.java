package oh;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import qh.c5;
import v5.j5;
/* loaded from: classes.dex */
public final class s implements c5 {

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, String> f12306f;

    /* renamed from: fb  reason: collision with root package name */
    public final Map<String, fb> f12307fb;

    /* renamed from: s  reason: collision with root package name */
    public final Map<String, v> f12308s;

    /* renamed from: v  reason: collision with root package name */
    public final long[] f12309v;
    public final gv y;

    public s(gv gvVar, Map<String, fb> map, Map<String, v> map2, Map<String, String> map3) {
        Map<String, fb> emptyMap;
        this.y = gvVar;
        this.f12308s = map2;
        this.f12306f = map3;
        if (map != null) {
            emptyMap = Collections.unmodifiableMap(map);
        } else {
            emptyMap = Collections.emptyMap();
        }
        this.f12307fb = emptyMap;
        this.f12309v = gvVar.i9();
    }

    @Override // qh.c5
    public int gv() {
        return this.f12309v.length;
    }

    @Override // qh.c5
    public List<qh.n3> n3(long j2) {
        return this.y.s(j2, this.f12307fb, this.f12308s, this.f12306f);
    }

    @Override // qh.c5
    public int y(long j2) {
        int v2 = j5.v(this.f12309v, j2, false, false);
        if (v2 >= this.f12309v.length) {
            return -1;
        }
        return v2;
    }

    @Override // qh.c5
    public long zn(int i) {
        return this.f12309v[i];
    }
}
