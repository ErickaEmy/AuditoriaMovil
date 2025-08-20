package d9;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import fj.u0;
import java.nio.ByteBuffer;
import m1.br;
import m1.m;
/* loaded from: classes.dex */
public interface x4 {

    /* loaded from: classes.dex */
    public static final class gv extends Exception {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;

        public gv(long j2, long j4) {
            super("Unexpected audio track timestamp discontinuity: expected " + j4 + ", got " + j2);
            this.actualPresentationTimeUs = j2;
            this.expectedPresentationTimeUs = j4;
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 extends Exception {
        public final int audioTrackState;
        public final m format;
        public final boolean isRecoverable;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public n3(int r4, int r5, int r6, int r7, m1.m r8, boolean r9, @androidx.annotation.Nullable java.lang.Exception r10) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "AudioTrack init failed "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = " "
                r0.append(r1)
                java.lang.String r2 = "Config("
                r0.append(r2)
                r0.append(r5)
                java.lang.String r5 = ", "
                r0.append(r5)
                r0.append(r6)
                r0.append(r5)
                r0.append(r7)
                java.lang.String r5 = ")"
                r0.append(r5)
                r0.append(r1)
                r0.append(r8)
                if (r9 == 0) goto L38
                java.lang.String r5 = " (recoverable)"
                goto L3a
            L38:
                java.lang.String r5 = ""
            L3a:
                r0.append(r5)
                java.lang.String r5 = r0.toString()
                r3.<init>(r5, r10)
                r3.audioTrackState = r4
                r3.isRecoverable = r9
                r3.format = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d9.x4.n3.<init>(int, int, int, int, m1.m, boolean, java.lang.Exception):void");
        }
    }

    /* loaded from: classes.dex */
    public static final class v extends Exception {
        public final int errorCode;
        public final m format;
        public final boolean isRecoverable;

        public v(int i, m mVar, boolean z2) {
            super("AudioTrack write failed: " + i);
            this.isRecoverable = z2;
            this.errorCode = i;
            this.format = mVar;
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        void fb(long j2);

        void fh();

        void gv(Exception exc);

        void n(int i, long j2, long j4);

        void onSkipSilenceEnabledChanged(boolean z2);

        void rz();

        void t();
    }

    boolean a();

    void c();

    void c5(@Nullable AudioDeviceInfo audioDeviceInfo);

    void co() throws v;

    void d0(zn znVar);

    void f(int i);

    void f3();

    void flush();

    void i4(long j2);

    boolean i9();

    void mt();

    boolean n3(m mVar);

    void p(d9.v vVar);

    void pause();

    void play();

    long r(boolean z2);

    void s(boolean z2);

    void setVolume(float f4);

    void tl();

    br v();

    boolean w(ByteBuffer byteBuffer, long j2, int i) throws n3, v;

    int wz(m mVar);

    void x4(m mVar, int i, @Nullable int[] iArr) throws y;

    void xc(@Nullable u0 u0Var);

    void y();

    void z(n nVar);

    void zn(br brVar);

    /* loaded from: classes.dex */
    public static final class y extends Exception {
        public final m format;

        public y(Throwable th, m mVar) {
            super(th);
            this.format = mVar;
        }

        public y(String str, m mVar) {
            super(str);
            this.format = mVar;
        }
    }
}
