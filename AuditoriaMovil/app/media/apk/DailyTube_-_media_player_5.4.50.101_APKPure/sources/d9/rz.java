package d9;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import d9.f3;
import d9.fb;
import d9.mg;
import d9.x4;
import fj.u0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import m1.br;
import m1.co;
import m1.m;
import v5.j5;
/* loaded from: classes.dex */
public final class rz implements x4 {

    /* renamed from: ct  reason: collision with root package name */
    public static final Object f7098ct = new Object();

    /* renamed from: dm  reason: collision with root package name */
    public static boolean f7099dm;
    @Nullable

    /* renamed from: o4  reason: collision with root package name */
    public static ExecutorService f7100o4;

    /* renamed from: rs  reason: collision with root package name */
    public static int f7101rs;

    /* renamed from: a  reason: collision with root package name */
    public final d9.fb[] f7102a;

    /* renamed from: a8  reason: collision with root package name */
    public long f7103a8;

    /* renamed from: b  reason: collision with root package name */
    public d9.fb[] f7104b;

    /* renamed from: c  reason: collision with root package name */
    public br f7105c;

    /* renamed from: c5  reason: collision with root package name */
    public final f3 f7106c5;
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public x4.zn f7107co;

    /* renamed from: d  reason: collision with root package name */
    public long f7108d;
    @Nullable

    /* renamed from: d0  reason: collision with root package name */
    public ByteBuffer f7109d0;

    /* renamed from: ej  reason: collision with root package name */
    public boolean f7110ej;
    @Nullable

    /* renamed from: en  reason: collision with root package name */
    public gv f7111en;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f7112f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public f f7113f3;

    /* renamed from: f7  reason: collision with root package name */
    public n f7114f7;

    /* renamed from: fb  reason: collision with root package name */
    public final d9.fb[] f7115fb;

    /* renamed from: fh  reason: collision with root package name */
    public int f7116fh;

    /* renamed from: gv  reason: collision with root package name */
    public final d0 f7117gv;
    @Nullable

    /* renamed from: hw  reason: collision with root package name */
    public ByteBuffer f7118hw;

    /* renamed from: i4  reason: collision with root package name */
    public d9.v f7119i4;

    /* renamed from: i9  reason: collision with root package name */
    public final ArrayDeque<f> f7120i9;

    /* renamed from: j  reason: collision with root package name */
    public boolean f7121j;

    /* renamed from: j5  reason: collision with root package name */
    public byte[] f7122j5;

    /* renamed from: jz  reason: collision with root package name */
    public boolean f7123jz;

    /* renamed from: k  reason: collision with root package name */
    public int f7124k;

    /* renamed from: k5  reason: collision with root package name */
    public ByteBuffer[] f7125k5;

    /* renamed from: mg  reason: collision with root package name */
    public long f7126mg;
    @Nullable

    /* renamed from: mt  reason: collision with root package name */
    public u0 f7127mt;

    /* renamed from: n  reason: collision with root package name */
    public f f7128n;

    /* renamed from: n3  reason: collision with root package name */
    public final d9.s f7129n3;

    /* renamed from: o  reason: collision with root package name */
    public int f7130o;

    /* renamed from: oz  reason: collision with root package name */
    public boolean f7131oz;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public final co.y f7132p;

    /* renamed from: q9  reason: collision with root package name */
    public boolean f7133q9;

    /* renamed from: qn  reason: collision with root package name */
    public int f7134qn;

    /* renamed from: r  reason: collision with root package name */
    public s f7135r;

    /* renamed from: rz  reason: collision with root package name */
    public long f7136rz;

    /* renamed from: s  reason: collision with root package name */
    public final v5.s f7137s;

    /* renamed from: t  reason: collision with root package name */
    public final int f7138t;

    /* renamed from: ta  reason: collision with root package name */
    public long f7139ta;

    /* renamed from: tl  reason: collision with root package name */
    public wz f7140tl;

    /* renamed from: u  reason: collision with root package name */
    public long f7141u;

    /* renamed from: ud  reason: collision with root package name */
    public boolean f7142ud;

    /* renamed from: ut  reason: collision with root package name */
    public boolean f7143ut;

    /* renamed from: v  reason: collision with root package name */
    public final vl f7144v;

    /* renamed from: vl  reason: collision with root package name */
    public int f7145vl;

    /* renamed from: w  reason: collision with root package name */
    public final a f7146w;

    /* renamed from: wz  reason: collision with root package name */
    public final t<x4.n3> f7147wz;

    /* renamed from: x  reason: collision with root package name */
    public float f7148x;
    @Nullable

    /* renamed from: x4  reason: collision with root package name */
    public AudioTrack f7149x4;

    /* renamed from: xc  reason: collision with root package name */
    public final t<x4.v> f7150xc;

    /* renamed from: xg  reason: collision with root package name */
    public boolean f7151xg;
    public final d9.a y;

    /* renamed from: y5  reason: collision with root package name */
    public boolean f7152y5;
    @Nullable

    /* renamed from: yt  reason: collision with root package name */
    public ByteBuffer f7153yt;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public s f7154z;

    /* renamed from: z6  reason: collision with root package name */
    public int f7155z6;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean f7156zn;

    /* loaded from: classes.dex */
    public interface a {
        public static final a y = new mg.y().fb();

        int y(int i, int i5, int i6, int i8, int i10, int i11, double d2);
    }

    /* loaded from: classes.dex */
    public static class c5 implements v {

        /* renamed from: n3  reason: collision with root package name */
        public final b f7157n3;
        public final d9.fb[] y;

        /* renamed from: zn  reason: collision with root package name */
        public final yt f7158zn;

        public c5(d9.fb... fbVarArr) {
            this(fbVarArr, new b(), new yt());
        }

        @Override // d9.s
        public long gv() {
            return this.f7157n3.w();
        }

        @Override // d9.s
        public br n3(br brVar) {
            this.f7158zn.gv(brVar.y);
            this.f7158zn.zn(brVar.f10585v);
            return brVar;
        }

        @Override // d9.s
        public boolean v(boolean z2) {
            this.f7157n3.x4(z2);
            return z2;
        }

        @Override // d9.s
        public long y(long j2) {
            return this.f7158zn.n3(j2);
        }

        @Override // d9.s
        public d9.fb[] zn() {
            return this.y;
        }

        public c5(d9.fb[] fbVarArr, b bVar, yt ytVar) {
            d9.fb[] fbVarArr2 = new d9.fb[fbVarArr.length + 2];
            this.y = fbVarArr2;
            System.arraycopy(fbVarArr, 0, fbVarArr2, 0, fbVarArr.length);
            this.f7157n3 = bVar;
            this.f7158zn = ytVar;
            fbVarArr2[fbVarArr.length] = bVar;
            fbVarArr2[fbVarArr.length + 1] = ytVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: gv  reason: collision with root package name */
        public final long f7159gv;

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f7160n3;
        public final br y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f7161zn;

        public f(br brVar, boolean z2, long j2, long j4) {
            this.y = brVar;
            this.f7160n3 = z2;
            this.f7161zn = j2;
            this.f7159gv = j4;
        }
    }

    /* loaded from: classes.dex */
    public static final class fb {
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public co.y f7163fb;

        /* renamed from: gv  reason: collision with root package name */
        public boolean f7164gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public d9.s f7165n3;

        /* renamed from: v  reason: collision with root package name */
        public int f7166v;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f7167zn;
        public d9.a y = d9.a.f6966zn;

        /* renamed from: a  reason: collision with root package name */
        public a f7162a = a.y;

        public rz a() {
            if (this.f7165n3 == null) {
                this.f7165n3 = new c5(new d9.fb[0]);
            }
            return new rz(this);
        }

        public fb c5(boolean z2) {
            this.f7164gv = z2;
            return this;
        }

        public fb f(int i) {
            this.f7166v = i;
            return this;
        }

        public fb fb(d9.a aVar) {
            v5.y.v(aVar);
            this.y = aVar;
            return this;
        }

        public fb i9(boolean z2) {
            this.f7167zn = z2;
            return this;
        }

        public fb s(d9.s sVar) {
            v5.y.v(sVar);
            this.f7165n3 = sVar;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class gv {
        public final AudioDeviceInfo y;

        public gv(AudioDeviceInfo audioDeviceInfo) {
            this.y = audioDeviceInfo;
        }
    }

    /* loaded from: classes.dex */
    public static final class i9 extends RuntimeException {
        public i9(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {
        public static void y(AudioTrack audioTrack, @Nullable gv gvVar) {
            AudioDeviceInfo audioDeviceInfo;
            if (gvVar == null) {
                audioDeviceInfo = null;
            } else {
                audioDeviceInfo = gvVar.y;
            }
            audioTrack.setPreferredDevice(audioDeviceInfo);
        }
    }

    /* loaded from: classes.dex */
    public static final class s {

        /* renamed from: a  reason: collision with root package name */
        public final int f7168a;

        /* renamed from: c5  reason: collision with root package name */
        public final d9.fb[] f7169c5;

        /* renamed from: fb  reason: collision with root package name */
        public final int f7170fb;

        /* renamed from: gv  reason: collision with root package name */
        public final int f7171gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f7172n3;

        /* renamed from: s  reason: collision with root package name */
        public final int f7173s;

        /* renamed from: v  reason: collision with root package name */
        public final int f7174v;
        public final m y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f7175zn;

        public s(m mVar, int i, int i5, int i6, int i8, int i10, int i11, int i12, d9.fb[] fbVarArr) {
            this.y = mVar;
            this.f7172n3 = i;
            this.f7175zn = i5;
            this.f7171gv = i6;
            this.f7174v = i8;
            this.f7168a = i10;
            this.f7170fb = i11;
            this.f7173s = i12;
            this.f7169c5 = fbVarArr;
        }

        public static AudioAttributes c5(d9.v vVar, boolean z2) {
            if (z2) {
                return i9();
            }
            return vVar.n3().y;
        }

        public static AudioAttributes i9() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public final AudioTrack a(boolean z2, d9.v vVar, int i) {
            AudioFormat k52 = rz.k5(this.f7174v, this.f7168a, this.f7170fb);
            AudioAttributes c52 = c5(vVar, z2);
            boolean z3 = true;
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(c52).setAudioFormat(k52).setTransferMode(1).setBufferSizeInBytes(this.f7173s).setSessionId(i);
            if (this.f7175zn != 1) {
                z3 = false;
            }
            return sessionId.setOffloadedPlayback(z3).build();
        }

        public long f(long j2) {
            return (j2 * 1000000) / this.y.f10966ut;
        }

        public final AudioTrack fb(d9.v vVar, int i) {
            int rs2 = j5.rs(vVar.f7207fb);
            if (i == 0) {
                return new AudioTrack(rs2, this.f7174v, this.f7168a, this.f7170fb, this.f7173s, 1);
            }
            return new AudioTrack(rs2, this.f7174v, this.f7168a, this.f7170fb, this.f7173s, 1, i);
        }

        public final AudioTrack gv(boolean z2, d9.v vVar, int i) {
            int i5 = j5.y;
            if (i5 >= 29) {
                return a(z2, vVar, i);
            }
            if (i5 >= 21) {
                return v(z2, vVar, i);
            }
            return fb(vVar, i);
        }

        public boolean n3(s sVar) {
            if (sVar.f7175zn == this.f7175zn && sVar.f7170fb == this.f7170fb && sVar.f7174v == this.f7174v && sVar.f7168a == this.f7168a && sVar.f7171gv == this.f7171gv) {
                return true;
            }
            return false;
        }

        public long s(long j2) {
            return (j2 * 1000000) / this.f7174v;
        }

        public boolean t() {
            if (this.f7175zn == 1) {
                return true;
            }
            return false;
        }

        public final AudioTrack v(boolean z2, d9.v vVar, int i) {
            return new AudioTrack(c5(vVar, z2), rz.k5(this.f7174v, this.f7168a, this.f7170fb), this.f7173s, 1, i);
        }

        public AudioTrack y(boolean z2, d9.v vVar, int i) throws x4.n3 {
            try {
                AudioTrack gv2 = gv(z2, vVar, i);
                int state = gv2.getState();
                if (state == 1) {
                    return gv2;
                }
                try {
                    gv2.release();
                } catch (Exception unused) {
                }
                throw new x4.n3(state, this.f7174v, this.f7168a, this.f7173s, this.y, t(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e2) {
                throw new x4.n3(0, this.f7174v, this.f7168a, this.f7173s, this.y, t(), e2);
            }
        }

        public s zn(int i) {
            return new s(this.y, this.f7172n3, this.f7175zn, this.f7171gv, this.f7174v, this.f7168a, this.f7170fb, i, this.f7169c5);
        }
    }

    /* loaded from: classes.dex */
    public static final class t<T extends Exception> {
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public T f7176n3;
        public final long y;

        /* renamed from: zn  reason: collision with root package name */
        public long f7177zn;

        public t(long j2) {
            this.y = j2;
        }

        public void n3(T t2) throws Exception {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f7176n3 == null) {
                this.f7176n3 = t2;
                this.f7177zn = this.y + elapsedRealtime;
            }
            if (elapsedRealtime >= this.f7177zn) {
                T t3 = this.f7176n3;
                if (t3 != t2) {
                    t3.addSuppressed(t2);
                }
                T t4 = this.f7176n3;
                y();
                throw t4;
            }
        }

        public void y() {
            this.f7176n3 = null;
        }
    }

    /* loaded from: classes.dex */
    public final class tl implements f3.y {
        public tl() {
        }

        @Override // d9.f3.y
        public void fb(long j2) {
            if (rz.this.f7107co != null) {
                rz.this.f7107co.fb(j2);
            }
        }

        @Override // d9.f3.y
        public void gv(long j2, long j4, long j6, long j7) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j2 + ", " + j4 + ", " + j6 + ", " + j7 + ", " + rz.this.j() + ", " + rz.this.oz();
            if (!rz.f7099dm) {
                v5.r.c5("DefaultAudioSink", str);
                return;
            }
            throw new i9(str);
        }

        @Override // d9.f3.y
        public void n3(long j2) {
            v5.r.c5("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j2);
        }

        @Override // d9.f3.y
        public void y(int i, long j2) {
            if (rz.this.f7107co != null) {
                rz.this.f7107co.n(i, j2, SystemClock.elapsedRealtime() - rz.this.f7141u);
            }
        }

        @Override // d9.f3.y
        public void zn(long j2, long j4, long j6, long j7) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j2 + ", " + j4 + ", " + j6 + ", " + j7 + ", " + rz.this.j() + ", " + rz.this.oz();
            if (!rz.f7099dm) {
                v5.r.c5("DefaultAudioSink", str);
                return;
            }
            throw new i9(str);
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface v extends d9.s {
    }

    /* loaded from: classes.dex */
    public final class wz {

        /* renamed from: n3  reason: collision with root package name */
        public final AudioTrack.StreamEventCallback f7178n3;
        public final Handler y = new Handler(Looper.myLooper());

        /* loaded from: classes.dex */
        public class y extends AudioTrack.StreamEventCallback {
            public final /* synthetic */ rz y;

            public y(rz rzVar) {
                this.y = rzVar;
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i) {
                if (audioTrack.equals(rz.this.f7149x4) && rz.this.f7107co != null && rz.this.f7143ut) {
                    rz.this.f7107co.rz();
                }
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(AudioTrack audioTrack) {
                if (audioTrack.equals(rz.this.f7149x4) && rz.this.f7107co != null && rz.this.f7143ut) {
                    rz.this.f7107co.rz();
                }
            }
        }

        public wz() {
            this.f7178n3 = new y(rz.this);
        }

        public void n3(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f7178n3);
            this.y.removeCallbacksAndMessages(null);
        }

        public void y(AudioTrack audioTrack) {
            Handler handler = this.y;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new n7.wz(handler), this.f7178n3);
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {
        public static void y(AudioTrack audioTrack, u0 u0Var) {
            LogSessionId y = u0Var.y();
            if (!y.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                audioTrack.setLogSessionId(y);
            }
        }
    }

    public static void dm(final AudioTrack audioTrack, final v5.s sVar) {
        sVar.gv();
        synchronized (f7098ct) {
            try {
                if (f7100o4 == null) {
                    f7100o4 = j5.wf("ExoPlayer:AudioTrackReleaseThread");
                }
                f7101rs++;
                f7100o4.execute(new Runnable() { // from class: d9.fh
                    @Override // java.lang.Runnable
                    public final void run() {
                        rz.en(audioTrack, sVar);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void en(AudioTrack audioTrack, v5.s sVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            sVar.a();
            synchronized (f7098ct) {
                try {
                    int i = f7101rs - 1;
                    f7101rs = i;
                    if (i == 0) {
                        f7100o4.shutdown();
                        f7100o4 = null;
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            sVar.a();
            synchronized (f7098ct) {
                try {
                    int i5 = f7101rs - 1;
                    f7101rs = i5;
                    if (i5 == 0) {
                        f7100o4.shutdown();
                        f7100o4 = null;
                    }
                    throw th;
                } finally {
                }
            }
        }
    }

    public static boolean f7(AudioTrack audioTrack) {
        if (j5.y >= 29 && audioTrack.isOffloadedPlayback()) {
            return true;
        }
        return false;
    }

    public static int hw(int i, ByteBuffer byteBuffer) {
        switch (i) {
            case 5:
            case 6:
            case 18:
                return d9.n3.v(byteBuffer);
            case 7:
            case 8:
                return ta.v(byteBuffer);
            case 9:
                int tl2 = ud.tl(j5.ud(byteBuffer, byteBuffer.position()));
                if (tl2 != -1) {
                    return tl2;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            case 19:
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i);
            case 14:
                int n32 = d9.n3.n3(byteBuffer);
                if (n32 == -1) {
                    return 0;
                }
                return d9.n3.c5(byteBuffer, n32) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return d9.zn.zn(byteBuffer);
            case 20:
                return a8.fb(byteBuffer);
        }
    }

    public static AudioFormat k5(int i, int i5, int i6) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i5).setEncoding(i6).build();
    }

    public static void lc(AudioTrack audioTrack, float f4) {
        audioTrack.setVolume(f4);
    }

    public static void nf(AudioTrack audioTrack, float f4) {
        audioTrack.setStereoVolume(f4, f4);
    }

    public static boolean q9(int i) {
        if ((j5.y >= 24 && i == -6) || i == -32) {
            return true;
        }
        return false;
    }

    public static int vl(int i, int i5, int i6) {
        boolean z2;
        int minBufferSize = AudioTrack.getMinBufferSize(i, i5, i6);
        if (minBufferSize != -2) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        return minBufferSize;
    }

    public static int yc(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    @Override // d9.x4
    public boolean a() {
        if (k() && (!this.f7121j || i9())) {
            return false;
        }
        return true;
    }

    public final AudioTrack a8() throws x4.n3 {
        try {
            return ud((s) v5.y.v(this.f7135r));
        } catch (x4.n3 e2) {
            s sVar = this.f7135r;
            if (sVar.f7173s > 1000000) {
                s zn2 = sVar.zn(1000000);
                try {
                    AudioTrack ud2 = ud(zn2);
                    this.f7135r = zn2;
                    return ud2;
                } catch (x4.n3 e3) {
                    e2.addSuppressed(e3);
                    jz();
                    throw e2;
                }
            }
            jz();
            throw e2;
        }
    }

    public final boolean ap(m mVar, d9.v vVar) {
        int a2;
        int z62;
        int qn2;
        boolean z2;
        boolean z3;
        if (j5.y < 29 || this.f7138t == 0 || (a2 = v5.n.a((String) v5.y.v(mVar.f10948f3), mVar.f10942co)) == 0 || (z62 = j5.z6(mVar.f10958oz)) == 0 || (qn2 = qn(k5(mVar.f10966ut, z62, a2), vVar.n3().y)) == 0) {
            return false;
        }
        if (qn2 != 1) {
            if (qn2 == 2) {
                return true;
            }
            throw new IllegalStateException();
        }
        if (mVar.f10955k == 0 && mVar.f10949f7 == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (this.f7138t == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 && z3) {
            return false;
        }
        return true;
    }

    public final void b() {
        int i = 0;
        while (true) {
            d9.fb[] fbVarArr = this.f7104b;
            if (i < fbVarArr.length) {
                d9.fb fbVar = fbVarArr[i];
                fbVar.flush();
                this.f7125k5[i] = fbVar.fb();
                i++;
            } else {
                return;
            }
        }
    }

    @Override // d9.x4
    public void c() {
        boolean z2;
        if (j5.y >= 21) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        v5.y.fb(this.f7133q9);
        if (!this.f7123jz) {
            this.f7123jz = true;
            flush();
        }
    }

    @Override // d9.x4
    public void c5(@Nullable AudioDeviceInfo audioDeviceInfo) {
        gv gvVar;
        if (audioDeviceInfo == null) {
            gvVar = null;
        } else {
            gvVar = new gv(audioDeviceInfo);
        }
        this.f7111en = gvVar;
        AudioTrack audioTrack = this.f7149x4;
        if (audioTrack != null) {
            n3.y(audioTrack, gvVar);
        }
    }

    @Override // d9.x4
    public void co() throws x4.v {
        if (!this.f7121j && k() && x()) {
            u();
            this.f7121j = true;
        }
    }

    public final void ct() {
        this.f7136rz = 0L;
        this.f7126mg = 0L;
        this.f7139ta = 0L;
        this.f7108d = 0L;
        this.f7151xg = false;
        this.f7155z6 = 0;
        this.f7128n = new f(yt(), o(), 0L, 0L);
        this.f7103a8 = 0L;
        this.f7113f3 = null;
        this.f7120i9.clear();
        this.f7153yt = null;
        this.f7145vl = 0;
        this.f7118hw = null;
        this.f7131oz = false;
        this.f7121j = false;
        this.f7130o = -1;
        this.f7109d0 = null;
        this.f7116fh = 0;
        this.f7144v.wz();
        b();
    }

    public final void d(long j2) {
        br brVar;
        boolean z2;
        if (e()) {
            brVar = this.f7129n3.n3(yt());
        } else {
            brVar = br.f10581s;
        }
        br brVar2 = brVar;
        if (e()) {
            z2 = this.f7129n3.v(o());
        } else {
            z2 = false;
        }
        this.f7120i9.add(new f(brVar2, z2, Math.max(0L, j2), this.f7135r.s(oz())));
        ra();
        x4.zn znVar = this.f7107co;
        if (znVar != null) {
            znVar.onSkipSilenceEnabledChanged(z2);
        }
    }

    @Override // d9.x4
    public void d0(x4.zn znVar) {
        this.f7107co = znVar;
    }

    public final boolean e() {
        if (!this.f7123jz && "audio/raw".equals(this.f7135r.y.f10948f3) && !s8(this.f7135r.y.f10960q9)) {
            return true;
        }
        return false;
    }

    public final void eb() {
        if (k()) {
            if (j5.y >= 21) {
                lc(this.f7149x4, this.f7148x);
            } else {
                nf(this.f7149x4, this.f7148x);
            }
        }
    }

    public final long ej(long j2) {
        return j2 + this.f7135r.s(this.f7129n3.gv());
    }

    @Override // d9.x4
    public void f(int i) {
        boolean z2;
        if (this.f7124k != i) {
            this.f7124k = i;
            if (i != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f7133q9 = z2;
            flush();
        }
    }

    @Override // d9.x4
    public void f3() {
        this.f7110ej = true;
    }

    @Override // d9.x4
    public void flush() {
        if (k()) {
            ct();
            if (this.f7106c5.c5()) {
                this.f7149x4.pause();
            }
            if (f7(this.f7149x4)) {
                ((wz) v5.y.v(this.f7140tl)).n3(this.f7149x4);
            }
            if (j5.y < 21 && !this.f7133q9) {
                this.f7124k = 0;
            }
            s sVar = this.f7154z;
            if (sVar != null) {
                this.f7135r = sVar;
                this.f7154z = null;
            }
            this.f7106c5.p();
            dm(this.f7149x4, this.f7137s);
            this.f7149x4 = null;
        }
        this.f7150xc.y();
        this.f7147wz.y();
    }

    @Override // d9.x4
    public /* synthetic */ void i4(long j2) {
        r.y(this, j2);
    }

    @Override // d9.x4
    public boolean i9() {
        if (k() && this.f7106c5.s(oz())) {
            return true;
        }
        return false;
    }

    public final long j() {
        s sVar = this.f7135r;
        if (sVar.f7175zn == 0) {
            return this.f7136rz / sVar.f7172n3;
        }
        return this.f7126mg;
    }

    public final f j5() {
        f fVar = this.f7113f3;
        if (fVar == null) {
            if (!this.f7120i9.isEmpty()) {
                return this.f7120i9.getLast();
            }
            return this.f7128n;
        }
        return fVar;
    }

    public final void jz() {
        if (!this.f7135r.t()) {
            return;
        }
        this.f7152y5 = true;
    }

    public final boolean k() {
        if (this.f7149x4 != null) {
            return true;
        }
        return false;
    }

    public final int kp(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j2) {
        if (j5.y >= 26) {
            return audioTrack.write(byteBuffer, i, 1, j2 * 1000);
        }
        if (this.f7109d0 == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.f7109d0 = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.f7109d0.putInt(1431633921);
        }
        if (this.f7116fh == 0) {
            this.f7109d0.putInt(4, i);
            this.f7109d0.putLong(8, j2 * 1000);
            this.f7109d0.position(0);
            this.f7116fh = i;
        }
        int remaining = this.f7109d0.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.f7109d0, remaining, 1);
            if (write < 0) {
                this.f7116fh = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int yc2 = yc(audioTrack, byteBuffer, i);
        if (yc2 < 0) {
            this.f7116fh = 0;
            return yc2;
        }
        this.f7116fh -= yc2;
        return yc2;
    }

    @Override // d9.x4
    public void mt() {
        boolean z2;
        if (j5.y < 25) {
            flush();
            return;
        }
        this.f7150xc.y();
        this.f7147wz.y();
        if (!k()) {
            return;
        }
        ct();
        if (this.f7106c5.c5()) {
            this.f7149x4.pause();
        }
        this.f7149x4.flush();
        this.f7106c5.p();
        f3 f3Var = this.f7106c5;
        AudioTrack audioTrack = this.f7149x4;
        s sVar = this.f7135r;
        if (sVar.f7175zn == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        f3Var.co(audioTrack, z2, sVar.f7170fb, sVar.f7171gv, sVar.f7173s);
        this.f7142ud = true;
    }

    @Override // d9.x4
    public boolean n3(m mVar) {
        if (wz(mVar) != 0) {
            return true;
        }
        return false;
    }

    public boolean o() {
        return j5().f7160n3;
    }

    public final void o4(br brVar, boolean z2) {
        f j52 = j5();
        if (!brVar.equals(j52.y) || z2 != j52.f7160n3) {
            f fVar = new f(brVar, z2, -9223372036854775807L, -9223372036854775807L);
            if (k()) {
                this.f7113f3 = fVar;
            } else {
                this.f7128n = fVar;
            }
        }
    }

    public final long oz() {
        s sVar = this.f7135r;
        if (sVar.f7175zn == 0) {
            return this.f7139ta / sVar.f7171gv;
        }
        return this.f7108d;
    }

    @Override // d9.x4
    public void p(d9.v vVar) {
        if (this.f7119i4.equals(vVar)) {
            return;
        }
        this.f7119i4 = vVar;
        if (this.f7123jz) {
            return;
        }
        flush();
    }

    @Override // d9.x4
    public void pause() {
        this.f7143ut = false;
        if (k() && this.f7106c5.w()) {
            this.f7149x4.pause();
        }
    }

    @Override // d9.x4
    public void play() {
        this.f7143ut = true;
        if (k()) {
            this.f7106c5.r();
            this.f7149x4.play();
        }
    }

    @SuppressLint({"InlinedApi"})
    public final int qn(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        int i = j5.y;
        if (i >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return 0;
        }
        if (i == 30 && j5.f14361gv.startsWith("Pixel")) {
            return 2;
        }
        return 1;
    }

    @Override // d9.x4
    public long r(boolean z2) {
        if (k() && !this.f7142ud) {
            return ej(z6(Math.min(this.f7106c5.gv(z2), this.f7135r.s(oz()))));
        }
        return Long.MIN_VALUE;
    }

    public final void ra() {
        d9.fb[] fbVarArr = this.f7135r.f7169c5;
        ArrayList arrayList = new ArrayList();
        for (d9.fb fbVar : fbVarArr) {
            if (fbVar.isActive()) {
                arrayList.add(fbVar);
            } else {
                fbVar.flush();
            }
        }
        int size = arrayList.size();
        this.f7104b = (d9.fb[]) arrayList.toArray(new d9.fb[size]);
        this.f7125k5 = new ByteBuffer[size];
        b();
    }

    public final void rs(br brVar) {
        if (k()) {
            try {
                this.f7149x4.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(brVar.y).setPitch(brVar.f10585v).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                v5.r.i9("DefaultAudioSink", "Failed to set playback params", e2);
            }
            brVar = new br(this.f7149x4.getPlaybackParams().getSpeed(), this.f7149x4.getPlaybackParams().getPitch());
            this.f7106c5.z(brVar.y);
        }
        this.f7105c = brVar;
    }

    @Override // d9.x4
    public void s(boolean z2) {
        o4(yt(), z2);
    }

    public final boolean s8(int i) {
        if (this.f7156zn && j5.g(i)) {
            return true;
        }
        return false;
    }

    @Override // d9.x4
    public void setVolume(float f4) {
        if (this.f7148x != f4) {
            this.f7148x = f4;
            eb();
        }
    }

    @Override // d9.x4
    public void tl() {
        if (this.f7123jz) {
            this.f7123jz = false;
            flush();
        }
    }

    public final void u() {
        if (!this.f7131oz) {
            this.f7131oz = true;
            this.f7106c5.fb(oz());
            this.f7149x4.stop();
            this.f7116fh = 0;
        }
    }

    public final AudioTrack ud(s sVar) throws x4.n3 {
        try {
            AudioTrack y2 = sVar.y(this.f7123jz, this.f7119i4, this.f7124k);
            co.y yVar = this.f7132p;
            if (yVar != null) {
                yVar.c(f7(y2));
            }
            return y2;
        } catch (x4.n3 e2) {
            x4.zn znVar = this.f7107co;
            if (znVar != null) {
                znVar.gv(e2);
            }
            throw e2;
        }
    }

    public final boolean ut() throws x4.n3 {
        boolean z2;
        u0 u0Var;
        if (!this.f7137s.v()) {
            return false;
        }
        AudioTrack a82 = a8();
        this.f7149x4 = a82;
        if (f7(a82)) {
            xg(this.f7149x4);
            if (this.f7138t != 3) {
                AudioTrack audioTrack = this.f7149x4;
                m mVar = this.f7135r.y;
                audioTrack.setOffloadDelayPadding(mVar.f10955k, mVar.f10949f7);
            }
        }
        int i = j5.y;
        if (i >= 31 && (u0Var = this.f7127mt) != null) {
            zn.y(this.f7149x4, u0Var);
        }
        this.f7124k = this.f7149x4.getAudioSessionId();
        f3 f3Var = this.f7106c5;
        AudioTrack audioTrack2 = this.f7149x4;
        s sVar = this.f7135r;
        if (sVar.f7175zn == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        f3Var.co(audioTrack2, z2, sVar.f7170fb, sVar.f7171gv, sVar.f7173s);
        eb();
        int i5 = this.f7114f7.y;
        if (i5 != 0) {
            this.f7149x4.attachAuxEffect(i5);
            this.f7149x4.setAuxEffectSendLevel(this.f7114f7.f7085n3);
        }
        gv gvVar = this.f7111en;
        if (gvVar != null && i >= 23) {
            n3.y(this.f7149x4, gvVar);
        }
        this.f7142ud = true;
        return true;
    }

    @Override // d9.x4
    public br v() {
        if (this.f7112f) {
            return this.f7105c;
        }
        return yt();
    }

    @Override // d9.x4
    public boolean w(ByteBuffer byteBuffer, long j2, int i) throws x4.n3, x4.v {
        boolean z2;
        boolean z3;
        ByteBuffer byteBuffer2 = this.f7153yt;
        if (byteBuffer2 != null && byteBuffer != byteBuffer2) {
            z2 = false;
        } else {
            z2 = true;
        }
        v5.y.y(z2);
        if (this.f7154z != null) {
            if (!x()) {
                return false;
            }
            if (!this.f7154z.n3(this.f7135r)) {
                u();
                if (i9()) {
                    return false;
                }
                flush();
            } else {
                this.f7135r = this.f7154z;
                this.f7154z = null;
                if (f7(this.f7149x4) && this.f7138t != 3) {
                    if (this.f7149x4.getPlayState() == 3) {
                        this.f7149x4.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack = this.f7149x4;
                    m mVar = this.f7135r.y;
                    audioTrack.setOffloadDelayPadding(mVar.f10955k, mVar.f10949f7);
                    this.f7151xg = true;
                }
            }
            d(j2);
        }
        if (!k()) {
            try {
                if (!ut()) {
                    return false;
                }
            } catch (x4.n3 e2) {
                if (!e2.isRecoverable) {
                    this.f7147wz.n3(e2);
                    return false;
                }
                throw e2;
            }
        }
        this.f7147wz.y();
        if (this.f7142ud) {
            this.f7103a8 = Math.max(0L, j2);
            this.f7110ej = false;
            this.f7142ud = false;
            if (this.f7112f && j5.y >= 23) {
                rs(this.f7105c);
            }
            d(j2);
            if (this.f7143ut) {
                play();
            }
        }
        if (!this.f7106c5.f(oz())) {
            return false;
        }
        if (this.f7153yt == null) {
            if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                z3 = true;
            } else {
                z3 = false;
            }
            v5.y.y(z3);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            s sVar = this.f7135r;
            if (sVar.f7175zn != 0 && this.f7155z6 == 0) {
                int hw2 = hw(sVar.f7170fb, byteBuffer);
                this.f7155z6 = hw2;
                if (hw2 == 0) {
                    return true;
                }
            }
            if (this.f7113f3 != null) {
                if (!x()) {
                    return false;
                }
                d(j2);
                this.f7113f3 = null;
            }
            long f4 = this.f7103a8 + this.f7135r.f(j() - this.f7144v.tl());
            if (!this.f7110ej && Math.abs(f4 - j2) > 200000) {
                x4.zn znVar = this.f7107co;
                if (znVar != null) {
                    znVar.gv(new x4.gv(j2, f4));
                }
                this.f7110ej = true;
            }
            if (this.f7110ej) {
                if (!x()) {
                    return false;
                }
                long j4 = j2 - f4;
                this.f7103a8 += j4;
                this.f7110ej = false;
                d(j2);
                x4.zn znVar2 = this.f7107co;
                if (znVar2 != null && j4 != 0) {
                    znVar2.fh();
                }
            }
            if (this.f7135r.f7175zn == 0) {
                this.f7136rz += byteBuffer.remaining();
            } else {
                this.f7126mg += this.f7155z6 * i;
            }
            this.f7153yt = byteBuffer;
            this.f7145vl = i;
        }
        y5(j2);
        if (!this.f7153yt.hasRemaining()) {
            this.f7153yt = null;
            this.f7145vl = 0;
            return true;
        } else if (!this.f7106c5.i9(oz())) {
            return false;
        } else {
            v5.r.c5("DefaultAudioSink", "Resetting stalled audio track");
            flush();
            return true;
        }
    }

    @Override // d9.x4
    public int wz(m mVar) {
        if ("audio/raw".equals(mVar.f10948f3)) {
            if (!j5.u0(mVar.f10960q9)) {
                v5.r.c5("DefaultAudioSink", "Invalid PCM encoding: " + mVar.f10960q9);
                return 0;
            }
            int i = mVar.f10960q9;
            if (i == 2 || (this.f7156zn && i == 4)) {
                return 2;
            }
            return 1;
        } else if ((this.f7152y5 || !ap(mVar, this.f7119i4)) && !this.y.s(mVar)) {
            return 0;
        } else {
            return 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x() throws d9.x4.v {
        /*
            r9 = this;
            int r0 = r9.f7130o
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto Lb
            r9.f7130o = r2
        L9:
            r0 = 1
            goto Lc
        Lb:
            r0 = 0
        Lc:
            int r4 = r9.f7130o
            d9.fb[] r5 = r9.f7104b
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.i9()
        L1f:
            r9.y5(r7)
            boolean r0 = r4.a()
            if (r0 != 0) goto L29
            return r2
        L29:
            int r0 = r9.f7130o
            int r0 = r0 + r1
            r9.f7130o = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.f7118hw
            if (r0 == 0) goto L3b
            r9.yg(r0, r7)
            java.nio.ByteBuffer r0 = r9.f7118hw
            if (r0 == 0) goto L3b
            return r2
        L3b:
            r9.f7130o = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d9.rz.x():boolean");
    }

    @Override // d9.x4
    public void x4(m mVar, int i, @Nullable int[] iArr) throws x4.y {
        d9.fb[] fbVarArr;
        int i5;
        int intValue;
        int i6;
        int i8;
        int i10;
        int i11;
        int i12;
        double d2;
        int i13;
        int i14;
        int i15;
        int i16;
        int y2;
        d9.fb[] fbVarArr2;
        int[] iArr2;
        if ("audio/raw".equals(mVar.f10948f3)) {
            v5.y.y(j5.u0(mVar.f10960q9));
            i8 = j5.ct(mVar.f10960q9, mVar.f10958oz);
            if (s8(mVar.f10960q9)) {
                fbVarArr2 = this.f7115fb;
            } else {
                fbVarArr2 = this.f7102a;
            }
            this.f7144v.xc(mVar.f10955k, mVar.f10949f7);
            if (j5.y < 21 && mVar.f10958oz == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i17 = 0; i17 < 6; i17++) {
                    iArr2[i17] = i17;
                }
            } else {
                iArr2 = iArr;
            }
            this.f7117gv.tl(iArr2);
            fb.y yVar = new fb.y(mVar.f10966ut, mVar.f10958oz, mVar.f10960q9);
            for (d9.fb fbVar : fbVarArr2) {
                try {
                    fb.y s2 = fbVar.s(yVar);
                    if (fbVar.isActive()) {
                        yVar = s2;
                    }
                } catch (fb.n3 e2) {
                    throw new x4.y(e2, mVar);
                }
            }
            int i18 = yVar.f7039zn;
            int i19 = yVar.y;
            int z62 = j5.z6(yVar.f7038n3);
            fbVarArr = fbVarArr2;
            i10 = j5.ct(i18, yVar.f7038n3);
            i6 = i18;
            i5 = i19;
            intValue = z62;
            i11 = 0;
        } else {
            d9.fb[] fbVarArr3 = new d9.fb[0];
            int i20 = mVar.f10966ut;
            if (ap(mVar, this.f7119i4)) {
                fbVarArr = fbVarArr3;
                i5 = i20;
                i6 = v5.n.a((String) v5.y.v(mVar.f10948f3), mVar.f10942co);
                intValue = j5.z6(mVar.f10958oz);
                i8 = -1;
                i10 = -1;
                i11 = 1;
            } else {
                Pair<Integer, Integer> a2 = this.y.a(mVar);
                if (a2 != null) {
                    int intValue2 = ((Integer) a2.first).intValue();
                    fbVarArr = fbVarArr3;
                    i5 = i20;
                    intValue = ((Integer) a2.second).intValue();
                    i6 = intValue2;
                    i8 = -1;
                    i10 = -1;
                    i11 = 2;
                } else {
                    throw new x4.y("Unable to configure passthrough for: " + mVar, mVar);
                }
            }
        }
        if (i6 != 0) {
            if (intValue != 0) {
                if (i != 0) {
                    y2 = i;
                    i13 = i6;
                    i14 = intValue;
                    i15 = i10;
                    i16 = i5;
                } else {
                    a aVar = this.f7146w;
                    int vl2 = vl(i5, intValue, i6);
                    if (i10 != -1) {
                        i12 = i10;
                    } else {
                        i12 = 1;
                    }
                    int i21 = mVar.f10959p;
                    if (this.f7112f) {
                        d2 = 8.0d;
                    } else {
                        d2 = 1.0d;
                    }
                    i13 = i6;
                    i14 = intValue;
                    i15 = i10;
                    i16 = i5;
                    y2 = aVar.y(vl2, i6, i11, i12, i5, i21, d2);
                }
                this.f7152y5 = false;
                s sVar = new s(mVar, i8, i11, i15, i16, i14, i13, y2, fbVarArr);
                if (k()) {
                    this.f7154z = sVar;
                    return;
                } else {
                    this.f7135r = sVar;
                    return;
                }
            }
            throw new x4.y("Invalid output channel config (mode=" + i11 + ") for: " + mVar, mVar);
        }
        throw new x4.y("Invalid output encoding (mode=" + i11 + ") for: " + mVar, mVar);
    }

    @Override // d9.x4
    public void xc(@Nullable u0 u0Var) {
        this.f7127mt = u0Var;
    }

    public final void xg(AudioTrack audioTrack) {
        if (this.f7140tl == null) {
            this.f7140tl = new wz();
        }
        this.f7140tl.y(audioTrack);
    }

    @Override // d9.x4
    public void y() {
        flush();
        for (d9.fb fbVar : this.f7102a) {
            fbVar.y();
        }
        for (d9.fb fbVar2 : this.f7115fb) {
            fbVar2.y();
        }
        this.f7143ut = false;
        this.f7152y5 = false;
    }

    public final void y5(long j2) throws x4.v {
        ByteBuffer byteBuffer;
        int length = this.f7104b.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.f7125k5[i - 1];
            } else {
                byteBuffer = this.f7153yt;
                if (byteBuffer == null) {
                    byteBuffer = d9.fb.y;
                }
            }
            if (i == length) {
                yg(byteBuffer, j2);
            } else {
                d9.fb fbVar = this.f7104b[i];
                if (i > this.f7130o) {
                    fbVar.c5(byteBuffer);
                }
                ByteBuffer fb2 = fbVar.fb();
                this.f7125k5[i] = fb2;
                if (fb2.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            }
            i--;
        }
    }

    public final void yg(ByteBuffer byteBuffer, long j2) throws x4.v {
        int yc2;
        boolean z2;
        x4.zn znVar;
        boolean z3;
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        ByteBuffer byteBuffer2 = this.f7118hw;
        boolean z4 = true;
        if (byteBuffer2 != null) {
            if (byteBuffer2 == byteBuffer) {
                z3 = true;
            } else {
                z3 = false;
            }
            v5.y.y(z3);
        } else {
            this.f7118hw = byteBuffer;
            if (j5.y < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.f7122j5;
                if (bArr == null || bArr.length < remaining) {
                    this.f7122j5 = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.f7122j5, 0, remaining);
                byteBuffer.position(position);
                this.f7134qn = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (j5.y < 21) {
            int zn2 = this.f7106c5.zn(this.f7139ta);
            if (zn2 > 0) {
                yc2 = this.f7149x4.write(this.f7122j5, this.f7134qn, Math.min(remaining2, zn2));
                if (yc2 > 0) {
                    this.f7134qn += yc2;
                    byteBuffer.position(byteBuffer.position() + yc2);
                }
            } else {
                yc2 = 0;
            }
        } else if (this.f7123jz) {
            if (j2 != -9223372036854775807L) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            yc2 = kp(this.f7149x4, byteBuffer, remaining2, j2);
        } else {
            yc2 = yc(this.f7149x4, byteBuffer, remaining2);
        }
        this.f7141u = SystemClock.elapsedRealtime();
        if (yc2 < 0) {
            x4.v vVar = new x4.v(yc2, this.f7135r.y, (!q9(yc2) || this.f7108d <= 0) ? false : false);
            x4.zn znVar2 = this.f7107co;
            if (znVar2 != null) {
                znVar2.gv(vVar);
            }
            if (!vVar.isRecoverable) {
                this.f7150xc.n3(vVar);
                return;
            }
            throw vVar;
        }
        this.f7150xc.y();
        if (f7(this.f7149x4)) {
            if (this.f7108d > 0) {
                this.f7151xg = false;
            }
            if (this.f7143ut && (znVar = this.f7107co) != null && yc2 < remaining2 && !this.f7151xg) {
                znVar.t();
            }
        }
        int i = this.f7135r.f7175zn;
        if (i == 0) {
            this.f7139ta += yc2;
        }
        if (yc2 == remaining2) {
            if (i != 0) {
                if (byteBuffer != this.f7153yt) {
                    z4 = false;
                }
                v5.y.fb(z4);
                this.f7108d += this.f7155z6 * this.f7145vl;
            }
            this.f7118hw = null;
        }
    }

    public final br yt() {
        return j5().y;
    }

    @Override // d9.x4
    public void z(n nVar) {
        if (this.f7114f7.equals(nVar)) {
            return;
        }
        int i = nVar.y;
        float f4 = nVar.f7085n3;
        AudioTrack audioTrack = this.f7149x4;
        if (audioTrack != null) {
            if (this.f7114f7.y != i) {
                audioTrack.attachAuxEffect(i);
            }
            if (i != 0) {
                this.f7149x4.setAuxEffectSendLevel(f4);
            }
        }
        this.f7114f7 = nVar;
    }

    public final long z6(long j2) {
        while (!this.f7120i9.isEmpty() && j2 >= this.f7120i9.getFirst().f7159gv) {
            this.f7128n = this.f7120i9.remove();
        }
        f fVar = this.f7128n;
        long j4 = j2 - fVar.f7159gv;
        if (fVar.y.equals(br.f10581s)) {
            return this.f7128n.f7161zn + j4;
        }
        if (this.f7120i9.isEmpty()) {
            return this.f7128n.f7161zn + this.f7129n3.y(j4);
        }
        f first = this.f7120i9.getFirst();
        return first.f7161zn - j5.u(first.f7159gv - j2, this.f7128n.y.y);
    }

    @Override // d9.x4
    public void zn(br brVar) {
        br brVar2 = new br(j5.w(brVar.y, 0.1f, 8.0f), j5.w(brVar.f10585v, 0.1f, 8.0f));
        if (this.f7112f && j5.y >= 23) {
            rs(brVar2);
        } else {
            o4(brVar2, o());
        }
    }

    @Deprecated
    public rz(@Nullable d9.a aVar, v vVar, boolean z2, boolean z3, int i) {
        this(new fb().fb((d9.a) w0.c5.y(aVar, d9.a.f6966zn)).s(vVar).i9(z2).c5(z3).f(i));
    }

    public rz(fb fbVar) {
        this.y = fbVar.y;
        d9.s sVar = fbVar.f7165n3;
        this.f7129n3 = sVar;
        int i = j5.y;
        this.f7156zn = i >= 21 && fbVar.f7167zn;
        this.f7112f = i >= 23 && fbVar.f7164gv;
        this.f7138t = i >= 29 ? fbVar.f7166v : 0;
        this.f7146w = fbVar.f7162a;
        v5.s sVar2 = new v5.s(v5.v.y);
        this.f7137s = sVar2;
        sVar2.a();
        this.f7106c5 = new f3(new tl());
        d0 d0Var = new d0();
        this.f7117gv = d0Var;
        vl vlVar = new vl();
        this.f7144v = vlVar;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new x(), d0Var, vlVar);
        Collections.addAll(arrayList, sVar.zn());
        this.f7102a = (d9.fb[]) arrayList.toArray(new d9.fb[0]);
        this.f7115fb = new d9.fb[]{new d()};
        this.f7148x = 1.0f;
        this.f7119i4 = d9.v.f7204w;
        this.f7124k = 0;
        this.f7114f7 = new n(0, 0.0f);
        br brVar = br.f10581s;
        this.f7128n = new f(brVar, false, 0L, 0L);
        this.f7105c = brVar;
        this.f7130o = -1;
        this.f7104b = new d9.fb[0];
        this.f7125k5 = new ByteBuffer[0];
        this.f7120i9 = new ArrayDeque<>();
        this.f7147wz = new t<>(100L);
        this.f7150xc = new t<>(100L);
        this.f7132p = fbVar.f7163fb;
    }
}
