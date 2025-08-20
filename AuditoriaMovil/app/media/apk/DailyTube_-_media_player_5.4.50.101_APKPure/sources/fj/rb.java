package fj;

import af.mg;
import android.annotation.SuppressLint;
import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.gv;
import com.google.android.exoplayer2.drm.n3;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import d9.x4;
import fj.g3;
import fj.zn;
import h3.xc;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kx.c;
import kx.d0;
import kx.j;
import m1.br;
import m1.gf;
import m1.hy;
import m1.ne;
import m1.o0;
import m1.qk;
import m1.uo;
import m1.v1;
/* loaded from: classes.dex */
public final class rb implements zn, g3.y {

    /* renamed from: c  reason: collision with root package name */
    public int f8086c;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public String f8087c5;
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public m1.m f8088co;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f8089d0;

    /* renamed from: f  reason: collision with root package name */
    public int f8090f;

    /* renamed from: f3  reason: collision with root package name */
    public int f8091f3;

    /* renamed from: i4  reason: collision with root package name */
    public boolean f8094i4;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public PlaybackMetrics.Builder f8095i9;
    @Nullable

    /* renamed from: mt  reason: collision with root package name */
    public m1.m f8096mt;

    /* renamed from: n  reason: collision with root package name */
    public int f8097n;

    /* renamed from: n3  reason: collision with root package name */
    public final g3 f8098n3;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public n3 f8099p;

    /* renamed from: r  reason: collision with root package name */
    public boolean f8100r;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public n3 f8105w;
    @Nullable

    /* renamed from: wz  reason: collision with root package name */
    public gf f8106wz;

    /* renamed from: x4  reason: collision with root package name */
    public int f8107x4;
    @Nullable

    /* renamed from: xc  reason: collision with root package name */
    public n3 f8108xc;
    public final Context y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public m1.m f8109z;

    /* renamed from: zn  reason: collision with root package name */
    public final PlaybackSession f8110zn;

    /* renamed from: v  reason: collision with root package name */
    public final hy.gv f8104v = new hy.gv();

    /* renamed from: a  reason: collision with root package name */
    public final hy.n3 f8085a = new hy.n3();

    /* renamed from: s  reason: collision with root package name */
    public final HashMap<String, Long> f8101s = new HashMap<>();

    /* renamed from: fb  reason: collision with root package name */
    public final HashMap<String, Long> f8092fb = new HashMap<>();

    /* renamed from: gv  reason: collision with root package name */
    public final long f8093gv = SystemClock.elapsedRealtime();

    /* renamed from: t  reason: collision with root package name */
    public int f8102t = 0;

    /* renamed from: tl  reason: collision with root package name */
    public int f8103tl = 0;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final int f8111n3;
        public final m1.m y;

        /* renamed from: zn  reason: collision with root package name */
        public final String f8112zn;

        public n3(m1.m mVar, int i, String str) {
            this.y = mVar;
            this.f8111n3 = i;
            this.f8112zn = str;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final int f8113n3;
        public final int y;

        public y(int i, int i5) {
            this.y = i;
            this.f8113n3 = i5;
        }
    }

    public rb(Context context, PlaybackSession playbackSession) {
        this.y = context.getApplicationContext();
        this.f8110zn = playbackSession;
        kp kpVar = new kp();
        this.f8098n3 = kpVar;
        kpVar.a(this);
    }

    public static y ad(gf gfVar, Context context, boolean z2) {
        int i;
        boolean z3;
        int i5;
        if (gfVar.errorCode == 1001) {
            return new y(20, 0);
        }
        if (gfVar instanceof m1.p) {
            m1.p pVar = (m1.p) gfVar;
            if (pVar.type == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            i = pVar.rendererFormatSupport;
        } else {
            i = 0;
            z3 = false;
        }
        Throwable th = (Throwable) v5.y.v(gfVar.getCause());
        if (th instanceof IOException) {
            if (th instanceof d0.v) {
                return new y(5, ((d0.v) th).responseCode);
            }
            if (!(th instanceof d0.gv) && !(th instanceof ne)) {
                boolean z4 = th instanceof d0.zn;
                if (!z4 && !(th instanceof j.y)) {
                    if (gfVar.errorCode == 1002) {
                        return new y(21, 0);
                    }
                    if (th instanceof gv.y) {
                        Throwable th2 = (Throwable) v5.y.v(th.getCause());
                        int i6 = v5.j5.y;
                        if (i6 >= 21 && (th2 instanceof MediaDrm.MediaDrmStateException)) {
                            int k2 = v5.j5.k(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo());
                            return new y(o0(k2), k2);
                        } else if (i6 >= 23 && (th2 instanceof MediaDrmResetException)) {
                            return new y(27, 0);
                        } else {
                            if (i6 >= 18 && (th2 instanceof NotProvisionedException)) {
                                return new y(24, 0);
                            }
                            if (i6 >= 18 && (th2 instanceof DeniedByServerException)) {
                                return new y(29, 0);
                            }
                            if (th2 instanceof f8.fh) {
                                return new y(23, 0);
                            }
                            if (th2 instanceof n3.v) {
                                return new y(28, 0);
                            }
                            return new y(30, 0);
                        }
                    } else if ((th instanceof c.zn) && (th.getCause() instanceof FileNotFoundException)) {
                        Throwable cause = ((Throwable) v5.y.v(th.getCause())).getCause();
                        if (v5.j5.y >= 21 && (cause instanceof ErrnoException) && ((ErrnoException) cause).errno == OsConstants.EACCES) {
                            return new y(32, 0);
                        }
                        return new y(31, 0);
                    } else {
                        return new y(9, 0);
                    }
                } else if (NetworkTypeObserver.getInstance(context).getNetworkType() == 1) {
                    return new y(3, 0);
                } else {
                    Throwable cause2 = th.getCause();
                    if (cause2 instanceof UnknownHostException) {
                        return new y(6, 0);
                    }
                    if (cause2 instanceof SocketTimeoutException) {
                        return new y(7, 0);
                    }
                    if (z4 && ((d0.zn) th).type == 1) {
                        return new y(4, 0);
                    }
                    return new y(8, 0);
                }
            }
            if (z2) {
                i5 = 10;
            } else {
                i5 = 11;
            }
            return new y(i5, 0);
        } else if (z3 && (i == 0 || i == 1)) {
            return new y(35, 0);
        } else {
            if (z3 && i == 3) {
                return new y(15, 0);
            }
            if (z3 && i == 2) {
                return new y(23, 0);
            }
            if (th instanceof xc.n3) {
                return new y(13, v5.j5.k(((xc.n3) th).diagnosticInfo));
            }
            if (th instanceof h3.tl) {
                return new y(14, v5.j5.k(((h3.tl) th).diagnosticInfo));
            }
            if (th instanceof OutOfMemoryError) {
                return new y(14, 0);
            }
            if (th instanceof x4.n3) {
                return new y(17, ((x4.n3) th).audioTrackState);
            }
            if (th instanceof x4.v) {
                return new y(18, ((x4.v) th).errorCode);
            }
            if (v5.j5.y >= 16 && (th instanceof MediaCodec.CryptoException)) {
                int errorCode = ((MediaCodec.CryptoException) th).getErrorCode();
                return new y(o0(errorCode), errorCode);
            }
            return new y(22, 0);
        }
    }

    public static Pair<String, String> cy(String str) {
        String str2;
        String[] ro2 = v5.j5.ro(str, "-");
        String str3 = ro2[0];
        if (ro2.length >= 2) {
            str2 = ro2[1];
        } else {
            str2 = null;
        }
        return Pair.create(str3, str2);
    }

    public static int gq(int i) {
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i != 3) {
            return 1;
        }
        return 4;
    }

    public static int l(o0 o0Var) {
        o0.s sVar = o0Var.f11022v;
        if (sVar == null) {
            return 0;
        }
        int kp2 = v5.j5.kp(sVar.y, sVar.f11083n3);
        if (kp2 != 0) {
            if (kp2 != 1) {
                if (kp2 != 2) {
                    return 1;
                }
                return 4;
            }
            return 5;
        }
        return 3;
    }

    @SuppressLint({"SwitchIntDef"})
    public static int o0(int i) {
        switch (v5.j5.q9(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    @Nullable
    public static rb pq(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new rb(context, mediaMetricsManager.createPlaybackSession());
    }

    public static int qj(Context context) {
        switch (NetworkTypeObserver.getInstance(context).getNetworkType()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
            case 8:
            default:
                return 1;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
        }
    }

    public static int wf(DrmInitData drmInitData) {
        for (int i = 0; i < drmInitData.f4115s; i++) {
            UUID uuid = drmInitData.v(i).f4120v;
            if (uuid.equals(m1.c5.f10604gv)) {
                return 3;
            }
            if (uuid.equals(m1.c5.f10606v)) {
                return 2;
            }
            if (uuid.equals(m1.c5.f10607zn)) {
                return 6;
            }
        }
        return 1;
    }

    @Nullable
    public static DrmInitData xb(z0.x4<v1.y> x4Var) {
        DrmInitData drmInitData;
        z0.en<v1.y> it = x4Var.iterator();
        while (it.hasNext()) {
            v1.y next = it.next();
            for (int i = 0; i < next.y; i++) {
                if (next.fb(i) && (drmInitData = next.zn(i).f10944d0) != null) {
                    return drmInitData;
                }
            }
        }
        return null;
    }

    @Override // fj.g3.y
    public void a(zn.y yVar, String str) {
        mg.n3 n3Var = yVar.f8169gv;
        if (n3Var != null && n3Var.n3()) {
            return;
        }
        cr();
        this.f8087c5 = str;
        this.f8095i9 = new PlaybackMetrics.Builder().setPlayerName("ExoPlayerLib").setPlayerVersion("2.18.7");
        cs(yVar.f8171n3, yVar.f8169gv);
    }

    @Override // fj.zn
    public /* synthetic */ void a8(zn.y yVar) {
        fj.n3.ut(this, yVar);
    }

    @Override // fj.zn
    public /* synthetic */ void ap(zn.y yVar, qh.a aVar) {
        fj.n3.xc(this, yVar, aVar);
    }

    @Override // fj.zn
    public /* synthetic */ void b(zn.y yVar, Object obj, long j2) {
        fj.n3.en(this, yVar, obj, j2);
    }

    @Override // fj.zn
    public /* synthetic */ void bk(zn.y yVar) {
        fj.n3.c(this, yVar);
    }

    @Override // fj.zn
    public void c(zn.y yVar, af.i4 i4Var, af.c cVar, IOException iOException, boolean z2) {
        this.f8107x4 = cVar.y;
    }

    @Override // fj.zn
    public /* synthetic */ void c5(zn.y yVar, boolean z2) {
        fj.n3.dm(this, yVar, z2);
    }

    @Override // fj.zn
    public /* synthetic */ void co(zn.y yVar, v1 v1Var) {
        fj.n3.eb(this, yVar, v1Var);
    }

    public final void cr() {
        long longValue;
        long longValue2;
        int i;
        PlaybackMetrics.Builder builder = this.f8095i9;
        if (builder != null && this.f8089d0) {
            builder.setAudioUnderrunCount(this.f8086c);
            this.f8095i9.setVideoFramesDropped(this.f8091f3);
            this.f8095i9.setVideoFramesPlayed(this.f8097n);
            Long l2 = this.f8092fb.get(this.f8087c5);
            PlaybackMetrics.Builder builder2 = this.f8095i9;
            if (l2 == null) {
                longValue = 0;
            } else {
                longValue = l2.longValue();
            }
            builder2.setNetworkTransferDurationMillis(longValue);
            Long l3 = this.f8101s.get(this.f8087c5);
            PlaybackMetrics.Builder builder3 = this.f8095i9;
            if (l3 == null) {
                longValue2 = 0;
            } else {
                longValue2 = l3.longValue();
            }
            builder3.setNetworkBytesRead(longValue2);
            PlaybackMetrics.Builder builder4 = this.f8095i9;
            if (l3 != null && l3.longValue() > 0) {
                i = 1;
            } else {
                i = 0;
            }
            builder4.setStreamSource(i);
            this.f8110zn.reportPlaybackMetrics(this.f8095i9.build());
        }
        this.f8095i9 = null;
        this.f8087c5 = null;
        this.f8086c = 0;
        this.f8091f3 = 0;
        this.f8097n = 0;
        this.f8096mt = null;
        this.f8088co = null;
        this.f8109z = null;
        this.f8089d0 = false;
    }

    public final void cs(hy hyVar, @Nullable mg.n3 n3Var) {
        int a2;
        int i;
        PlaybackMetrics.Builder builder = this.f8095i9;
        if (n3Var == null || (a2 = hyVar.a(n3Var.y)) == -1) {
            return;
        }
        hyVar.i9(a2, this.f8085a);
        hyVar.mt(this.f8085a.f10828fb, this.f8104v);
        builder.setStreamType(l(this.f8104v.f10811fb));
        hy.gv gvVar = this.f8104v;
        if (gvVar.f10805c != -9223372036854775807L && !gvVar.f10810f3 && !gvVar.f10806co && !gvVar.s()) {
            builder.setMediaDurationMillis(this.f8104v.a());
        }
        if (this.f8104v.s()) {
            i = 2;
        } else {
            i = 1;
        }
        builder.setPlaybackType(i);
        this.f8089d0 = true;
    }

    @Override // fj.zn
    public /* synthetic */ void ct(zn.y yVar, int i, m1.m mVar) {
        fj.n3.co(this, yVar, i, mVar);
    }

    @Override // fj.zn
    public /* synthetic */ void d(zn.y yVar, uo.n3 n3Var) {
        fj.n3.t(this, yVar, n3Var);
    }

    @Override // fj.zn
    public /* synthetic */ void dm(zn.y yVar, String str) {
        fj.n3.s8(this, yVar, str);
    }

    @Override // fj.g3.y
    public void e(zn.y yVar, String str, boolean z2) {
        mg.n3 n3Var = yVar.f8169gv;
        if ((n3Var == null || !n3Var.n3()) && str.equals(this.f8087c5)) {
            cr();
        }
        this.f8092fb.remove(str);
        this.f8101s.remove(str);
    }

    @Override // fj.zn
    public /* synthetic */ void eb(zn.y yVar, int i, a9.v vVar) {
        fj.n3.w(this, yVar, i, vVar);
    }

    @Override // fj.zn
    public /* synthetic */ void ej(zn.y yVar, String str, long j2) {
        fj.n3.ra(this, yVar, str, j2);
    }

    @Override // fj.zn
    public /* synthetic */ void en(zn.y yVar, boolean z2) {
        fj.n3.xg(this, yVar, z2);
    }

    @Override // fj.zn
    public /* synthetic */ void f(zn.y yVar, int i) {
        fj.n3.k(this, yVar, i);
    }

    @Override // fj.zn
    public /* synthetic */ void f3(zn.y yVar) {
        fj.n3.u(this, yVar);
    }

    @Override // fj.zn
    public /* synthetic */ void f7(zn.y yVar, boolean z2) {
        fj.n3.b(this, yVar, z2);
    }

    @Override // fj.zn
    public /* synthetic */ void fb(zn.y yVar, Exception exc) {
        fj.n3.i9(this, yVar, exc);
    }

    @Override // fj.zn
    public /* synthetic */ void fh(zn.y yVar, Exception exc) {
        fj.n3.y(this, yVar, exc);
    }

    @Override // fj.zn
    public void g(zn.y yVar, af.c cVar) {
        if (yVar.f8169gv == null) {
            return;
        }
        n3 n3Var = new n3((m1.m) v5.y.v(cVar.f122zn), cVar.f119gv, this.f8098n3.v(yVar.f8171n3, (mg.n3) v5.y.v(yVar.f8169gv)));
        int i = cVar.f120n3;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.f8099p = n3Var;
                        return;
                    }
                    return;
                }
            } else {
                this.f8105w = n3Var;
                return;
            }
        }
        this.f8108xc = n3Var;
    }

    @Override // fj.zn
    public /* synthetic */ void g3(zn.y yVar, int i, long j2) {
        fj.n3.mg(this, yVar, i, j2);
    }

    @Override // fj.zn
    public /* synthetic */ void gv(zn.y yVar, String str, long j2) {
        fj.n3.n3(this, yVar, str, j2);
    }

    @Override // fj.zn
    public /* synthetic */ void hw(zn.y yVar) {
        fj.n3.rz(this, yVar);
    }

    @Override // fj.zn
    public /* synthetic */ void i4(zn.y yVar, int i, int i5, int i6, float f4) {
        fj.n3.g3(this, yVar, i, i5, i6, f4);
    }

    @Override // fj.zn
    public /* synthetic */ void i9(zn.y yVar) {
        fj.n3.n(this, yVar);
    }

    public final void ix(int i, long j2, @Nullable m1.m mVar, int i5) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j2 - this.f8093gv);
        if (mVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(gq(i5));
            String str = mVar.f10962r;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = mVar.f10948f3;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = mVar.f10942co;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i6 = mVar.f10959p;
            if (i6 != -1) {
                timeSinceCreatedMillis.setBitrate(i6);
            }
            int i8 = mVar.f10943d;
            if (i8 != -1) {
                timeSinceCreatedMillis.setWidth(i8);
            }
            int i10 = mVar.f10945ej;
            if (i10 != -1) {
                timeSinceCreatedMillis.setHeight(i10);
            }
            int i11 = mVar.f10958oz;
            if (i11 != -1) {
                timeSinceCreatedMillis.setChannelCount(i11);
            }
            int i12 = mVar.f10966ut;
            if (i12 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i12);
            }
            String str4 = mVar.f10950fb;
            if (str4 != null) {
                Pair<String, String> cy2 = cy(str4);
                timeSinceCreatedMillis.setLanguage((String) cy2.first);
                Object obj = cy2.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f4 = mVar.f10969x;
            if (f4 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f4);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.f8089d0 = true;
        this.f8110zn.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    @Override // fj.zn
    public /* synthetic */ void j5(zn.y yVar, String str, long j2, long j4) {
        fj.n3.e(this, yVar, str, j2, j4);
    }

    @Override // fj.zn
    public /* synthetic */ void jz(zn.y yVar, int i) {
        fj.n3.o(this, yVar, i);
    }

    @Override // fj.zn
    public /* synthetic */ void k(zn.y yVar, int i, int i5) {
        fj.n3.ct(this, yVar, i, i5);
    }

    @Override // fj.zn
    public /* synthetic */ void k5(zn.y yVar, int i) {
        fj.n3.qn(this, yVar, i);
    }

    @Override // fj.zn
    public /* synthetic */ void kp(zn.y yVar, boolean z2, int i) {
        fj.n3.hw(this, yVar, z2, i);
    }

    @Override // fj.zn
    public /* synthetic */ void lc(zn.y yVar, Metadata metadata) {
        fj.n3.vl(this, yVar, metadata);
    }

    public final void le(long j2, @Nullable m1.m mVar, int i) {
        int i5;
        if (v5.j5.zn(this.f8109z, mVar)) {
            return;
        }
        if (this.f8109z == null && i == 0) {
            i5 = 1;
        } else {
            i5 = i;
        }
        this.f8109z = mVar;
        ix(2, j2, mVar, i5);
    }

    @Override // fj.zn
    public /* synthetic */ void m(zn.y yVar, o0 o0Var, int i) {
        fj.n3.k5(this, yVar, o0Var, i);
    }

    @Override // fj.zn
    public /* synthetic */ void mg(zn.y yVar, boolean z2) {
        fj.n3.z6(this, yVar, z2);
    }

    public final void mp(uo uoVar, zn.n3 n3Var) {
        DrmInitData xb2;
        if (n3Var.y(0)) {
            zn.y zn2 = n3Var.zn(0);
            if (this.f8095i9 != null) {
                cs(zn2.f8171n3, zn2.f8169gv);
            }
        }
        if (n3Var.y(2) && this.f8095i9 != null && (xb2 = xb(uoVar.d0().n3())) != null) {
            ((PlaybackMetrics.Builder) v5.j5.i9(this.f8095i9)).setDrmType(wf(xb2));
        }
        if (n3Var.y(1011)) {
            this.f8086c++;
        }
    }

    @Override // fj.zn
    public void mt(zn.y yVar, wn.d0 d0Var) {
        n3 n3Var = this.f8108xc;
        if (n3Var != null) {
            m1.m mVar = n3Var.y;
            if (mVar.f10945ej == -1) {
                this.f8108xc = new n3(mVar.n3().s8(d0Var.y).o(d0Var.f14582v).z6(), n3Var.f8111n3, n3Var.f8112zn);
            }
        }
    }

    @Override // fj.zn
    public /* synthetic */ void n(zn.y yVar, int i) {
        fj.n3.jz(this, yVar, i);
    }

    @Override // fj.zn
    public /* synthetic */ void n3(zn.y yVar, int i, a9.v vVar) {
        fj.n3.p(this, yVar, i, vVar);
    }

    @Override // fj.zn
    public void nf(zn.y yVar, uo.v vVar, uo.v vVar2, int i) {
        if (i == 1) {
            this.f8100r = true;
        }
        this.f8090f = i;
    }

    @Override // fj.zn
    public /* synthetic */ void o(zn.y yVar, int i, boolean z2) {
        fj.n3.r(this, yVar, i, z2);
    }

    @Override // fj.zn
    public void o4(zn.y yVar, int i, long j2, long j4) {
        long longValue;
        mg.n3 n3Var = yVar.f8169gv;
        if (n3Var != null) {
            String v2 = this.f8098n3.v(yVar.f8171n3, (mg.n3) v5.y.v(n3Var));
            Long l2 = this.f8101s.get(v2);
            Long l3 = this.f8092fb.get(v2);
            HashMap<String, Long> hashMap = this.f8101s;
            long j6 = 0;
            if (l2 == null) {
                longValue = 0;
            } else {
                longValue = l2.longValue();
            }
            hashMap.put(v2, Long.valueOf(longValue + j2));
            HashMap<String, Long> hashMap2 = this.f8092fb;
            if (l3 != null) {
                j6 = l3.longValue();
            }
            hashMap2.put(v2, Long.valueOf(j6 + i));
        }
    }

    public final void oa(long j2) {
        int qj2 = qj(this.y);
        if (qj2 != this.f8103tl) {
            this.f8103tl = qj2;
            this.f8110zn.reportNetworkEvent(new NetworkEvent.Builder().setNetworkType(qj2).setTimeSinceCreatedMillis(j2 - this.f8093gv).build());
        }
    }

    @Override // fj.zn
    public /* synthetic */ void oz(zn.y yVar, Exception exc) {
        fj.n3.nf(this, yVar, exc);
    }

    @Override // fj.zn
    public /* synthetic */ void p(zn.y yVar, af.c cVar) {
        fj.n3.lc(this, yVar, cVar);
    }

    public final boolean pz(@Nullable n3 n3Var) {
        if (n3Var != null && n3Var.f8112zn.equals(this.f8098n3.y())) {
            return true;
        }
        return false;
    }

    public final void q5(long j2, @Nullable m1.m mVar, int i) {
        int i5;
        if (v5.j5.zn(this.f8088co, mVar)) {
            return;
        }
        if (this.f8088co == null && i == 0) {
            i5 = 1;
        } else {
            i5 = i;
        }
        this.f8088co = mVar;
        ix(0, j2, mVar, i5);
    }

    @Override // fj.zn
    public /* synthetic */ void q9(zn.y yVar, a9.v vVar) {
        fj.n3.v(this, yVar, vVar);
    }

    public LogSessionId qk() {
        return this.f8110zn.getSessionId();
    }

    @Override // fj.zn
    public /* synthetic */ void qn(zn.y yVar, String str, long j2, long j4) {
        fj.n3.zn(this, yVar, str, j2, j4);
    }

    @Override // fj.zn
    public /* synthetic */ void r(zn.y yVar, af.i4 i4Var, af.c cVar) {
        fj.n3.ud(this, yVar, i4Var, cVar);
    }

    @Override // fj.zn
    public /* synthetic */ void ra(zn.y yVar, long j2) {
        fj.n3.c5(this, yVar, j2);
    }

    @Override // fj.zn
    public void rb(uo uoVar, zn.n3 n3Var) {
        if (n3Var.gv() == 0) {
            return;
        }
        vp(n3Var);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        mp(uoVar, n3Var);
        w9(elapsedRealtime);
        x5(uoVar, n3Var, elapsedRealtime);
        oa(elapsedRealtime);
        w2(uoVar, n3Var, elapsedRealtime);
        if (n3Var.y(1028)) {
            this.f8098n3.n3(n3Var.zn(1028));
        }
    }

    public final void ro(long j2, @Nullable m1.m mVar, int i) {
        int i5;
        if (v5.j5.zn(this.f8096mt, mVar)) {
            return;
        }
        if (this.f8096mt == null && i == 0) {
            i5 = 1;
        } else {
            i5 = i;
        }
        this.f8096mt = mVar;
        ix(1, j2, mVar, i5);
    }

    @Override // fj.zn
    public /* synthetic */ void rs(zn.y yVar, String str) {
        fj.n3.gv(this, yVar, str);
    }

    @Override // fj.zn
    public /* synthetic */ void rz(zn.y yVar, m1.m mVar) {
        fj.n3.kp(this, yVar, mVar);
    }

    @Override // fj.zn
    public /* synthetic */ void s(zn.y yVar, List list) {
        fj.n3.wz(this, yVar, list);
    }

    @Override // fj.zn
    public /* synthetic */ void s8(zn.y yVar, int i, String str, long j2) {
        fj.n3.mt(this, yVar, i, str, j2);
    }

    @Override // fj.zn
    public /* synthetic */ void t(zn.y yVar, zo.c cVar) {
        fj.n3.rs(this, yVar, cVar);
    }

    @Override // fj.zn
    public /* synthetic */ void ta(zn.y yVar, m1.m mVar, a9.c5 c5Var) {
        fj.n3.s(this, yVar, mVar, c5Var);
    }

    @Override // fj.zn
    public /* synthetic */ void tg(zn.y yVar, a9.v vVar) {
        fj.n3.a(this, yVar, vVar);
    }

    @Override // fj.zn
    public /* synthetic */ void tl(zn.y yVar, boolean z2) {
        fj.n3.d(this, yVar, z2);
    }

    @Override // fj.zn
    public /* synthetic */ void u(zn.y yVar, qk qkVar) {
        fj.n3.yt(this, yVar, qkVar);
    }

    @Override // fj.zn
    public /* synthetic */ void u0(zn.y yVar, af.i4 i4Var, af.c cVar) {
        fj.n3.x(this, yVar, i4Var, cVar);
    }

    @Override // fj.zn
    public /* synthetic */ void ud(zn.y yVar, m1.m mVar) {
        fj.n3.fb(this, yVar, mVar);
    }

    @Override // fj.zn
    public /* synthetic */ void ut(zn.y yVar, a9.v vVar) {
        fj.n3.yg(this, yVar, vVar);
    }

    @Override // fj.zn
    public /* synthetic */ void v(zn.y yVar) {
        fj.n3.y5(this, yVar);
    }

    @Override // fj.zn
    public void vl(zn.y yVar, a9.v vVar) {
        this.f8091f3 += vVar.f79fb;
        this.f8097n += vVar.f85v;
    }

    public final void vp(zn.n3 n3Var) {
        for (int i = 0; i < n3Var.gv(); i++) {
            int n32 = n3Var.n3(i);
            zn.y zn2 = n3Var.zn(n32);
            if (n32 == 0) {
                this.f8098n3.zn(zn2);
            } else if (n32 == 11) {
                this.f8098n3.gv(zn2, this.f8090f);
            } else {
                this.f8098n3.s(zn2);
            }
        }
    }

    @Override // fj.zn
    public /* synthetic */ void w(zn.y yVar, float f4) {
        fj.n3.g(this, yVar, f4);
    }

    public final void w2(uo uoVar, zn.n3 n3Var, long j2) {
        if (uoVar.n3() != 2) {
            this.f8100r = false;
        }
        if (uoVar.a() == null) {
            this.f8094i4 = false;
        } else if (n3Var.y(10)) {
            this.f8094i4 = true;
        }
        int yk2 = yk(uoVar);
        if (this.f8102t != yk2) {
            this.f8102t = yk2;
            this.f8089d0 = true;
            this.f8110zn.reportPlaybackStateEvent(new PlaybackStateEvent.Builder().setState(this.f8102t).setTimeSinceCreatedMillis(j2 - this.f8093gv).build());
        }
    }

    public final void w9(long j2) {
        boolean z2;
        gf gfVar = this.f8106wz;
        if (gfVar == null) {
            return;
        }
        Context context = this.y;
        if (this.f8107x4 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        y ad2 = ad(gfVar, context, z2);
        this.f8110zn.reportPlaybackErrorEvent(new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(j2 - this.f8093gv).setErrorCode(ad2.y).setSubErrorCode(ad2.f8113n3).setException(gfVar).build());
        this.f8089d0 = true;
        this.f8106wz = null;
    }

    @Override // fj.zn
    public /* synthetic */ void wz(zn.y yVar, long j2, int i) {
        fj.n3.yc(this, yVar, j2, i);
    }

    @Override // fj.zn
    public /* synthetic */ void x(zn.y yVar, m1.m mVar, a9.c5 c5Var) {
        fj.n3.rb(this, yVar, mVar, c5Var);
    }

    @Override // fj.zn
    public /* synthetic */ void x4(zn.y yVar, Exception exc) {
        fj.n3.fh(this, yVar, exc);
    }

    public final void x5(uo uoVar, zn.n3 n3Var, long j2) {
        if (n3Var.y(2)) {
            v1 d02 = uoVar.d0();
            boolean gv2 = d02.gv(2);
            boolean gv3 = d02.gv(1);
            boolean gv4 = d02.gv(3);
            if (gv2 || gv3 || gv4) {
                if (!gv2) {
                    ro(j2, null, 0);
                }
                if (!gv3) {
                    q5(j2, null, 0);
                }
                if (!gv4) {
                    le(j2, null, 0);
                }
            }
        }
        if (pz(this.f8108xc)) {
            n3 n3Var2 = this.f8108xc;
            m1.m mVar = n3Var2.y;
            if (mVar.f10945ej != -1) {
                ro(j2, mVar, n3Var2.f8111n3);
                this.f8108xc = null;
            }
        }
        if (pz(this.f8105w)) {
            n3 n3Var3 = this.f8105w;
            q5(j2, n3Var3.y, n3Var3.f8111n3);
            this.f8105w = null;
        }
        if (pz(this.f8099p)) {
            n3 n3Var4 = this.f8099p;
            le(j2, n3Var4.y, n3Var4.f8111n3);
            this.f8099p = null;
        }
    }

    @Override // fj.zn
    public /* synthetic */ void xc(zn.y yVar, m1.xc xcVar) {
        fj.n3.z(this, yVar, xcVar);
    }

    @Override // fj.zn
    public /* synthetic */ void xg(zn.y yVar) {
        fj.n3.i4(this, yVar);
    }

    @Override // fj.zn
    public /* synthetic */ void y(zn.y yVar) {
        fj.n3.f3(this, yVar);
    }

    @Override // fj.zn
    public void y4(zn.y yVar, gf gfVar) {
        this.f8106wz = gfVar;
    }

    @Override // fj.zn
    public /* synthetic */ void y5(zn.y yVar, int i) {
        fj.n3.d0(this, yVar, i);
    }

    @Override // fj.zn
    public /* synthetic */ void yc(zn.y yVar, int i) {
        fj.n3.o4(this, yVar, i);
    }

    @Override // fj.zn
    public /* synthetic */ void yg(zn.y yVar, int i, long j2, long j4) {
        fj.n3.f(this, yVar, i, j2, j4);
    }

    public final int yk(uo uoVar) {
        int n32 = uoVar.n3();
        if (this.f8100r) {
            return 5;
        }
        if (this.f8094i4) {
            return 13;
        }
        if (n32 == 4) {
            return 11;
        }
        if (n32 == 2) {
            int i = this.f8102t;
            if (i == 0 || i == 2) {
                return 2;
            }
            if (!uoVar.oz()) {
                return 7;
            }
            if (uoVar.x() != 0) {
                return 10;
            }
            return 6;
        } else if (n32 == 3) {
            if (!uoVar.oz()) {
                return 4;
            }
            if (uoVar.x() == 0) {
                return 3;
            }
            return 9;
        } else if (n32 == 1 && this.f8102t != 0) {
            return 12;
        } else {
            return this.f8102t;
        }
    }

    @Override // fj.zn
    public /* synthetic */ void yt(zn.y yVar, br brVar) {
        fj.n3.j5(this, yVar, brVar);
    }

    @Override // fj.zn
    public /* synthetic */ void z(zn.y yVar, af.i4 i4Var, af.c cVar) {
        fj.n3.ej(this, yVar, i4Var, cVar);
    }

    @Override // fj.zn
    public /* synthetic */ void z6(zn.y yVar, gf gfVar) {
        fj.n3.oz(this, yVar, gfVar);
    }

    @Override // fj.zn
    public /* synthetic */ void zn(zn.y yVar, boolean z2, int i) {
        fj.n3.q9(this, yVar, z2, i);
    }

    @Override // fj.g3.y
    public void d0(zn.y yVar, String str) {
    }

    @Override // fj.g3.y
    public void j(zn.y yVar, String str, String str2) {
    }
}
