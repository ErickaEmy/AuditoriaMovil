package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.rtsp.fb;
import java.io.IOException;
import java.util.Map;
import kx.j;
import kx.o;
import kx.p;
import v5.j5;
/* loaded from: classes.dex */
public final class t implements y {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public t f4652n3;
    public final j y;

    public t(long j2) {
        this.y = new j(2000, d1.a.gv(j2));
    }

    public void a(t tVar) {
        boolean z2;
        if (this != tVar) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        this.f4652n3 = tVar;
    }

    @Override // kx.tl
    public void close() {
        this.y.close();
        t tVar = this.f4652n3;
        if (tVar != null) {
            tVar.close();
        }
    }

    @Override // kx.tl
    public /* synthetic */ Map fb() {
        return kx.t.y(this);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.y
    public int gv() {
        int gv2 = this.y.gv();
        if (gv2 == -1) {
            return -1;
        }
        return gv2;
    }

    @Override // kx.tl
    public void i9(o oVar) {
        this.y.i9(oVar);
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        return this.y.n3();
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) throws IOException {
        try {
            return this.y.read(bArr, i, i5);
        } catch (j.y e2) {
            if (e2.reason == 2002) {
                return -1;
            }
            throw e2;
        }
    }

    @Override // com.google.android.exoplayer2.source.rtsp.y
    @Nullable
    public fb.n3 tl() {
        return null;
    }

    @Override // kx.tl
    public long y(p pVar) throws IOException {
        return this.y.y(pVar);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.y
    public String zn() {
        boolean z2;
        int gv2 = gv();
        if (gv2 != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        return j5.rz("RTP/AVP;unicast;client_port=%d-%d", Integer.valueOf(gv2), Integer.valueOf(gv2 + 1));
    }
}
