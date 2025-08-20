package p5;

import java.util.List;
import qh.c5;
import qh.s;
import v5.rz;
/* loaded from: classes.dex */
public final class y extends s {

    /* renamed from: xc  reason: collision with root package name */
    public final n3 f12433xc;

    public y(List<byte[]> list) {
        super("DvbDecoder");
        rz rzVar = new rz(list.get(0));
        this.f12433xc = new n3(rzVar.yt(), rzVar.yt());
    }

    @Override // qh.s
    public c5 c(byte[] bArr, int i, boolean z2) {
        if (z2) {
            this.f12433xc.mt();
        }
        return new zn(this.f12433xc.n3(bArr, i));
    }
}
