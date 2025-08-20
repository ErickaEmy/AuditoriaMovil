package com.google.android.exoplayer2.source.rtsp;

import af.d0;
import af.mg;
import af.r;
import af.y5;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.rtsp.a;
import com.google.android.exoplayer2.source.rtsp.y;
import java.io.IOException;
import javax.net.SocketFactory;
import kx.o;
import m1.hy;
import m1.kp;
import m1.o0;
import r4.i4;
import v5.j5;
/* loaded from: classes.dex */
public final class RtspMediaSource extends af.y {

    /* renamed from: co  reason: collision with root package name */
    public final y.InterfaceC0052y f4547co;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f4549d0;

    /* renamed from: f3  reason: collision with root package name */
    public final SocketFactory f4550f3;

    /* renamed from: fh  reason: collision with root package name */
    public boolean f4551fh;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f4552n;

    /* renamed from: p  reason: collision with root package name */
    public final o0 f4553p;

    /* renamed from: r  reason: collision with root package name */
    public final Uri f4554r;

    /* renamed from: z  reason: collision with root package name */
    public final String f4555z;

    /* renamed from: c  reason: collision with root package name */
    public long f4546c = -9223372036854775807L;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4548d = true;

    /* loaded from: classes.dex */
    public static final class gv extends zn {
        public gv(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends r {
        public n3(RtspMediaSource rtspMediaSource, hy hyVar) {
            super(hyVar);
        }

        @Override // af.r, m1.hy
        public hy.gv co(int i, hy.gv gvVar, long j2) {
            super.co(i, gvVar, j2);
            gvVar.f10810f3 = true;
            return gvVar;
        }

        @Override // af.r, m1.hy
        public hy.n3 f(int i, hy.n3 n3Var, boolean z2) {
            super.f(i, n3Var, z2);
            n3Var.f10830t = true;
            return n3Var;
        }
    }

    /* loaded from: classes.dex */
    public class y implements a.zn {
        public y() {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.a.zn
        public void n3(i4 i4Var) {
            RtspMediaSource.this.f4546c = j5.xb(i4Var.y());
            RtspMediaSource.this.f4549d0 = !i4Var.zn();
            RtspMediaSource.this.f4551fh = i4Var.zn();
            RtspMediaSource.this.f4548d = false;
            RtspMediaSource.this.m();
        }

        @Override // com.google.android.exoplayer2.source.rtsp.a.zn
        public void y() {
            RtspMediaSource.this.f4549d0 = false;
            RtspMediaSource.this.m();
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends IOException {
        public zn(String str) {
            super(str);
        }

        public zn(Throwable th) {
            super(th);
        }

        public zn(String str, Throwable th) {
            super(str, th);
        }
    }

    static {
        kp.y("goog.exo.rtsp");
    }

    public RtspMediaSource(o0 o0Var, y.InterfaceC0052y interfaceC0052y, String str, SocketFactory socketFactory, boolean z2) {
        this.f4553p = o0Var;
        this.f4547co = interfaceC0052y;
        this.f4555z = str;
        this.f4554r = ((o0.s) v5.y.v(o0Var.f11022v)).y;
        this.f4550f3 = socketFactory;
        this.f4552n = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        hy y5Var = new y5(this.f4546c, this.f4549d0, false, this.f4551fh, null, this.f4553p);
        if (this.f4548d) {
            y5Var = new n3(this, y5Var);
        }
        s8(y5Var);
    }

    @Override // af.y
    public void ap() {
    }

    @Override // af.mg
    public o0 c() {
        return this.f4553p;
    }

    @Override // af.y
    public void e(@Nullable o oVar) {
        m();
    }

    @Override // af.mg
    public d0 f7(mg.n3 n3Var, kx.n3 n3Var2, long j2) {
        return new a(n3Var2, this.f4547co, this.f4554r, new y(), this.f4555z, this.f4550f3, this.f4552n);
    }

    @Override // af.mg
    public void u(d0 d0Var) {
        ((a) d0Var).q9();
    }

    @Override // af.mg
    public void ut() {
    }

    /* loaded from: classes.dex */
    public static final class Factory implements mg.y {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f4556gv;

        /* renamed from: v  reason: collision with root package name */
        public boolean f4558v;
        public long y = 8000;

        /* renamed from: n3  reason: collision with root package name */
        public String f4557n3 = "ExoPlayerLib/2.18.7";

        /* renamed from: zn  reason: collision with root package name */
        public SocketFactory f4559zn = SocketFactory.getDefault();

        @Override // af.mg.y
        /* renamed from: gv */
        public RtspMediaSource n3(o0 o0Var) {
            y.InterfaceC0052y tlVar;
            v5.y.v(o0Var.f11022v);
            if (this.f4556gv) {
                tlVar = new f(this.y);
            } else {
                tlVar = new tl(this.y);
            }
            return new RtspMediaSource(o0Var, tlVar, this.f4557n3, this.f4559zn, this.f4558v);
        }

        @Override // af.mg.y
        /* renamed from: a */
        public Factory y(kx.mg mgVar) {
            return this;
        }

        @Override // af.mg.y
        /* renamed from: v */
        public Factory zn(f8.r rVar) {
            return this;
        }
    }
}
