package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.y;
/* loaded from: classes.dex */
public final class f implements y.InterfaceC0052y {
    public final long y;

    public f(long j2) {
        this.y = j2;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.y.InterfaceC0052y
    public /* synthetic */ y.InterfaceC0052y n3() {
        return r4.n3.y(this);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.y.InterfaceC0052y
    public y y(int i) {
        i9 i9Var = new i9(this.y);
        i9Var.y(r4.c5.y(i * 2));
        return i9Var;
    }
}
