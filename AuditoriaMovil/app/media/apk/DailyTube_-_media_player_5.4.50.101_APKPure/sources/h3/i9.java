package h3;

import h3.f3;
import h3.n3;
import h3.t;
import java.io.IOException;
import v5.j5;
import v5.n;
/* loaded from: classes.dex */
public final class i9 implements t.n3 {

    /* renamed from: n3  reason: collision with root package name */
    public int f8436n3;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f8437zn;

    public i9 n3() {
        this.f8436n3 = 2;
        return this;
    }

    @Override // h3.t.n3
    public t y(t.y yVar) throws IOException {
        int i;
        int i5 = j5.y;
        if (i5 >= 23 && ((i = this.f8436n3) == 1 || (i == 0 && i5 >= 31))) {
            int f4 = n.f(yVar.f8453zn.f10948f3);
            v5.r.a("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + j5.s8(f4));
            return new n3.C0103n3(f4, this.f8437zn).y(yVar);
        }
        return new f3.n3().y(yVar);
    }

    public i9 zn() {
        this.f8436n3 = 1;
        return this;
    }
}
