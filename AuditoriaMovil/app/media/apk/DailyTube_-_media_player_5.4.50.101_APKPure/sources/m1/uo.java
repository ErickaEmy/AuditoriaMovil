package m1;

import android.os.Bundle;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.List;
import m1.s;
import m1.uo;
import v5.wz;
/* loaded from: classes.dex */
public interface uo {

    /* loaded from: classes.dex */
    public interface gv {
        void onAvailableCommandsChanged(n3 n3Var);

        @Deprecated
        void onCues(List<qh.n3> list);

        void onCues(qh.a aVar);

        void onDeviceInfoChanged(xc xcVar);

        void onDeviceVolumeChanged(int i, boolean z2);

        void onEvents(uo uoVar, zn znVar);

        void onIsLoadingChanged(boolean z2);

        void onIsPlayingChanged(boolean z2);

        @Deprecated
        void onLoadingChanged(boolean z2);

        void onMediaItemTransition(@Nullable o0 o0Var, int i);

        void onMediaMetadataChanged(qk qkVar);

        void onMetadata(Metadata metadata);

        void onPlayWhenReadyChanged(boolean z2, int i);

        void onPlaybackParametersChanged(br brVar);

        void onPlaybackStateChanged(int i);

        void onPlaybackSuppressionReasonChanged(int i);

        void onPlayerError(gf gfVar);

        void onPlayerErrorChanged(@Nullable gf gfVar);

        @Deprecated
        void onPlayerStateChanged(boolean z2, int i);

        @Deprecated
        void onPositionDiscontinuity(int i);

        void onPositionDiscontinuity(v vVar, v vVar2, int i);

        void onRenderedFirstFrame();

        void onRepeatModeChanged(int i);

        @Deprecated
        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z2);

        void onSkipSilenceEnabledChanged(boolean z2);

        void onSurfaceSizeChanged(int i, int i5);

        void onTimelineChanged(hy hyVar, int i);

        void onTrackSelectionParametersChanged(zo.c cVar);

        void onTracksChanged(v1 v1Var);

        void onVideoSizeChanged(wn.d0 d0Var);

        void onVolumeChanged(float f4);
    }

    /* loaded from: classes.dex */
    public static final class n3 implements s {
        public final v5.wz y;

        /* renamed from: v  reason: collision with root package name */
        public static final n3 f11261v = new y().v();

        /* renamed from: fb  reason: collision with root package name */
        public static final String f11259fb = v5.j5.g3(0);

        /* renamed from: s  reason: collision with root package name */
        public static final s.y<n3> f11260s = new s.y() { // from class: m1.im
            @Override // m1.s.y
            public final s fromBundle(Bundle bundle) {
                uo.n3 gv2;
                gv2 = uo.n3.gv(bundle);
                return gv2;
            }
        };

        /* loaded from: classes.dex */
        public static final class y {

            /* renamed from: n3  reason: collision with root package name */
            public static final int[] f11262n3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
            public final wz.n3 y = new wz.n3();

            public y gv(int i, boolean z2) {
                this.y.gv(i, z2);
                return this;
            }

            public y n3(n3 n3Var) {
                this.y.n3(n3Var.y);
                return this;
            }

            public n3 v() {
                return new n3(this.y.v());
            }

            public y y(int i) {
                this.y.y(i);
                return this;
            }

            public y zn(int... iArr) {
                this.y.zn(iArr);
                return this;
            }
        }

        public static n3 gv(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(f11259fb);
            if (integerArrayList == null) {
                return f11261v;
            }
            y yVar = new y();
            for (int i = 0; i < integerArrayList.size(); i++) {
                yVar.y(integerArrayList.get(i).intValue());
            }
            return yVar.v();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof n3)) {
                return false;
            }
            return this.y.equals(((n3) obj).y);
        }

        public int hashCode() {
            return this.y.hashCode();
        }

        @Override // m1.s
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < this.y.gv(); i++) {
                arrayList.add(Integer.valueOf(this.y.zn(i)));
            }
            bundle.putIntegerArrayList(f11259fb, arrayList);
            return bundle;
        }

        public boolean zn(int i) {
            return this.y.y(i);
        }

        public n3(v5.wz wzVar) {
            this.y = wzVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class v implements s {

        /* renamed from: co  reason: collision with root package name */
        public final int f11271co;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public final Object f11272f;

        /* renamed from: fb  reason: collision with root package name */
        public final int f11273fb;

        /* renamed from: p  reason: collision with root package name */
        public final long f11274p;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public final o0 f11275s;

        /* renamed from: t  reason: collision with root package name */
        public final int f11276t;
        @Deprecated

        /* renamed from: v  reason: collision with root package name */
        public final int f11277v;

        /* renamed from: w  reason: collision with root package name */
        public final long f11278w;
        @Nullable
        public final Object y;

        /* renamed from: z  reason: collision with root package name */
        public final int f11279z;

        /* renamed from: r  reason: collision with root package name */
        public static final String f11270r = v5.j5.g3(0);

        /* renamed from: f3  reason: collision with root package name */
        public static final String f11267f3 = v5.j5.g3(1);

        /* renamed from: n  reason: collision with root package name */
        public static final String f11269n = v5.j5.g3(2);

        /* renamed from: c  reason: collision with root package name */
        public static final String f11263c = v5.j5.g3(3);

        /* renamed from: d0  reason: collision with root package name */
        public static final String f11265d0 = v5.j5.g3(4);

        /* renamed from: fh  reason: collision with root package name */
        public static final String f11268fh = v5.j5.g3(5);

        /* renamed from: d  reason: collision with root package name */
        public static final String f11264d = v5.j5.g3(6);

        /* renamed from: ej  reason: collision with root package name */
        public static final s.y<v> f11266ej = new s.y() { // from class: m1.n7
            @Override // m1.s.y
            public final s fromBundle(Bundle bundle) {
                uo.v n32;
                n32 = uo.v.n3(bundle);
                return n32;
            }
        };

        public v(@Nullable Object obj, int i, @Nullable o0 o0Var, @Nullable Object obj2, int i5, long j2, long j4, int i6, int i8) {
            this.y = obj;
            this.f11277v = i;
            this.f11273fb = i;
            this.f11275s = o0Var;
            this.f11272f = obj2;
            this.f11276t = i5;
            this.f11278w = j2;
            this.f11274p = j4;
            this.f11271co = i6;
            this.f11279z = i8;
        }

        public static v n3(Bundle bundle) {
            o0 fromBundle;
            int i = bundle.getInt(f11270r, 0);
            Bundle bundle2 = bundle.getBundle(f11267f3);
            if (bundle2 == null) {
                fromBundle = null;
            } else {
                fromBundle = o0.f11012d0.fromBundle(bundle2);
            }
            return new v(null, i, fromBundle, null, bundle.getInt(f11269n, 0), bundle.getLong(f11263c, 0L), bundle.getLong(f11265d0, 0L), bundle.getInt(f11268fh, -1), bundle.getInt(f11264d, -1));
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || v.class != obj.getClass()) {
                return false;
            }
            v vVar = (v) obj;
            if (this.f11273fb == vVar.f11273fb && this.f11276t == vVar.f11276t && this.f11278w == vVar.f11278w && this.f11274p == vVar.f11274p && this.f11271co == vVar.f11271co && this.f11279z == vVar.f11279z && w0.f.y(this.y, vVar.y) && w0.f.y(this.f11272f, vVar.f11272f) && w0.f.y(this.f11275s, vVar.f11275s)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return w0.f.n3(this.y, Integer.valueOf(this.f11273fb), this.f11275s, this.f11272f, Integer.valueOf(this.f11276t), Long.valueOf(this.f11278w), Long.valueOf(this.f11274p), Integer.valueOf(this.f11271co), Integer.valueOf(this.f11279z));
        }

        @Override // m1.s
        public Bundle toBundle() {
            return zn(true, true);
        }

        public Bundle zn(boolean z2, boolean z3) {
            int i;
            long j2;
            int i5;
            Bundle bundle = new Bundle();
            String str = f11270r;
            int i6 = 0;
            if (z3) {
                i = this.f11273fb;
            } else {
                i = 0;
            }
            bundle.putInt(str, i);
            o0 o0Var = this.f11275s;
            if (o0Var != null && z2) {
                bundle.putBundle(f11267f3, o0Var.toBundle());
            }
            String str2 = f11269n;
            if (z3) {
                i6 = this.f11276t;
            }
            bundle.putInt(str2, i6);
            String str3 = f11263c;
            long j4 = 0;
            if (z2) {
                j2 = this.f11278w;
            } else {
                j2 = 0;
            }
            bundle.putLong(str3, j2);
            String str4 = f11265d0;
            if (z2) {
                j4 = this.f11274p;
            }
            bundle.putLong(str4, j4);
            String str5 = f11268fh;
            int i8 = -1;
            if (z2) {
                i5 = this.f11271co;
            } else {
                i5 = -1;
            }
            bundle.putInt(str5, i5);
            String str6 = f11264d;
            if (z2) {
                i8 = this.f11279z;
            }
            bundle.putInt(str6, i8);
            return bundle;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {
        public final v5.wz y;

        public zn(v5.wz wzVar) {
            this.y = wzVar;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zn)) {
                return false;
            }
            return this.y.equals(((zn) obj).y);
        }

        public int hashCode() {
            return this.y.hashCode();
        }

        public boolean n3(int... iArr) {
            return this.y.n3(iArr);
        }

        public boolean y(int i) {
            return this.y.y(i);
        }
    }

    @Nullable
    gf a();

    boolean a8();

    boolean ap();

    hy b();

    long bk();

    int c5();

    boolean cr();

    void ct(o0 o0Var);

    v1 d0();

    void e(gv gvVar);

    void eb(zo.c cVar);

    int en();

    long f();

    void f3();

    long f7();

    void fb(long j2);

    void g(gv gvVar);

    void g3(@Nullable SurfaceView surfaceView);

    long getCurrentPosition();

    long getDuration();

    float getVolume();

    void gv(int i);

    void hw(@Nullable TextureView textureView);

    boolean i9();

    boolean isPlaying();

    n3 j();

    void jz(@Nullable TextureView textureView);

    Looper k5();

    int kp();

    void lc(int i);

    @Deprecated
    boolean m();

    qh.a mg();

    void n(boolean z2);

    int n3();

    long nf();

    void o(int i, long j2);

    boolean oz();

    void p(@Nullable SurfaceView surfaceView);

    void pause();

    void play();

    long pq();

    void prepare();

    qk pz();

    @Deprecated
    void q9(boolean z2);

    void r(int i, int i5);

    long ra();

    void release();

    void rs();

    boolean rz();

    long s8();

    void setVolume(float f4);

    void stop();

    void t();

    int ta();

    void tg();

    @Nullable
    o0 tl();

    wn.d0 u();

    boolean u0();

    void ut(boolean z2);

    br v();

    void vl();

    void w(List<o0> list, boolean z2);

    int x();

    @Deprecated
    int x4();

    void xc();

    int xg();

    boolean y();

    void y4();

    boolean y5();

    zo.c yt();

    int z();

    boolean z6(int i);

    void zn(br brVar);
}
