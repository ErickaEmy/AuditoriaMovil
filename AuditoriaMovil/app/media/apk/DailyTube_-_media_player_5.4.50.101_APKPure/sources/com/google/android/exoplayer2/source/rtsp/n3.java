package com.google.android.exoplayer2.source.rtsp;

import android.os.Handler;
import com.google.android.exoplayer2.source.rtsp.y;
import e4.d0;
import e4.wz;
import java.io.IOException;
import kx.ta;
import kx.w;
import r4.xc;
import v5.j5;
/* loaded from: classes.dex */
public final class n3 implements ta.v {

    /* renamed from: a  reason: collision with root package name */
    public final y.InterfaceC0052y f4634a;

    /* renamed from: fb  reason: collision with root package name */
    public r4.gv f4636fb;

    /* renamed from: gv  reason: collision with root package name */
    public final wz f4637gv;

    /* renamed from: i9  reason: collision with root package name */
    public volatile long f4638i9;

    /* renamed from: n3  reason: collision with root package name */
    public final xc f4639n3;

    /* renamed from: s  reason: collision with root package name */
    public volatile boolean f4640s;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final y f4642zn;

    /* renamed from: v  reason: collision with root package name */
    public final Handler f4641v = j5.i4();

    /* renamed from: c5  reason: collision with root package name */
    public volatile long f4635c5 = -9223372036854775807L;

    /* loaded from: classes.dex */
    public interface y {
        void y(String str, com.google.android.exoplayer2.source.rtsp.y yVar);
    }

    public n3(int i, xc xcVar, y yVar, wz wzVar, y.InterfaceC0052y interfaceC0052y) {
        this.y = i;
        this.f4639n3 = xcVar;
        this.f4642zn = yVar;
        this.f4637gv = wzVar;
        this.f4634a = interfaceC0052y;
    }

    public void a(int i) {
        if (!((r4.gv) v5.y.v(this.f4636fb)).gv()) {
            this.f4636fb.s(i);
        }
    }

    public void fb(long j2) {
        if (j2 != -9223372036854775807L && !((r4.gv) v5.y.v(this.f4636fb)).gv()) {
            this.f4636fb.c5(j2);
        }
    }

    public void gv() {
        ((r4.gv) v5.y.v(this.f4636fb)).fb();
    }

    @Override // kx.ta.v
    public void load() throws IOException {
        final com.google.android.exoplayer2.source.rtsp.y yVar = null;
        try {
            yVar = this.f4634a.y(this.y);
            final String zn2 = yVar.zn();
            this.f4641v.post(new Runnable() { // from class: r4.zn
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.exoplayer2.source.rtsp.n3.this.zn(zn2, yVar);
                }
            });
            e4.a aVar = new e4.a((kx.c5) v5.y.v(yVar), 0L, -1L);
            r4.gv gvVar = new r4.gv(this.f4639n3.y, this.y);
            this.f4636fb = gvVar;
            gvVar.zn(this.f4637gv);
            while (!this.f4640s) {
                if (this.f4635c5 != -9223372036854775807L) {
                    this.f4636fb.y(this.f4638i9, this.f4635c5);
                    this.f4635c5 = -9223372036854775807L;
                }
                if (this.f4636fb.v(aVar, new d0()) == -1) {
                    break;
                }
            }
            w.y(yVar);
        } catch (Throwable th) {
            w.y(yVar);
            throw th;
        }
    }

    @Override // kx.ta.v
    public void n3() {
        this.f4640s = true;
    }

    public void v(long j2, long j4) {
        this.f4635c5 = j2;
        this.f4638i9 = j4;
    }

    public final /* synthetic */ void zn(String str, com.google.android.exoplayer2.source.rtsp.y yVar) {
        this.f4642zn.y(str, yVar);
    }
}
