package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.y;
import java.io.IOException;
import kx.w;
/* loaded from: classes.dex */
public final class tl implements y.InterfaceC0052y {
    public final long y;

    public tl(long j2) {
        this.y = j2;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.y.InterfaceC0052y
    public y.InterfaceC0052y n3() {
        return new f(this.y);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.y.InterfaceC0052y
    public y y(int i) throws IOException {
        int i5;
        t tVar = new t(this.y);
        t tVar2 = new t(this.y);
        boolean z2 = false;
        try {
            tVar.y(r4.c5.y(0));
            int gv2 = tVar.gv();
            if (gv2 % 2 == 0) {
                z2 = true;
            }
            if (z2) {
                i5 = gv2 + 1;
            } else {
                i5 = gv2 - 1;
            }
            tVar2.y(r4.c5.y(i5));
            if (z2) {
                tVar.a(tVar2);
                return tVar;
            }
            tVar2.a(tVar);
            return tVar2;
        } catch (IOException e2) {
            w.y(tVar);
            w.y(tVar2);
            throw e2;
        }
    }
}
