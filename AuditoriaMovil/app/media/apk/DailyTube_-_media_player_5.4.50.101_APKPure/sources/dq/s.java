package dq;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;
/* loaded from: classes.dex */
public final class s {

    /* renamed from: gv  reason: collision with root package name */
    public final String f7375gv;

    /* renamed from: n3  reason: collision with root package name */
    public final long[] f7376n3;

    /* renamed from: v  reason: collision with root package name */
    public final long f7377v;
    public final EventMessage[] y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f7378zn;

    public s(String str, String str2, long j2, long[] jArr, EventMessage[] eventMessageArr) {
        this.f7378zn = str;
        this.f7375gv = str2;
        this.f7377v = j2;
        this.f7376n3 = jArr;
        this.y = eventMessageArr;
    }

    public String y() {
        return this.f7378zn + "/" + this.f7375gv;
    }
}
