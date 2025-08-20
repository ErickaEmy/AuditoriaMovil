package m1;

import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;
import m1.uo;
/* loaded from: classes.dex */
public class u0 implements uo {
    public final uo y;

    /* loaded from: classes.dex */
    public static final class y implements uo.gv {

        /* renamed from: v  reason: collision with root package name */
        public final uo.gv f11258v;
        public final u0 y;

        public y(u0 u0Var, uo.gv gvVar) {
            this.y = u0Var;
            this.f11258v = gvVar;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof y)) {
                return false;
            }
            y yVar = (y) obj;
            if (!this.y.equals(yVar.y)) {
                return false;
            }
            return this.f11258v.equals(yVar.f11258v);
        }

        public int hashCode() {
            return (this.y.hashCode() * 31) + this.f11258v.hashCode();
        }

        @Override // m1.uo.gv
        public void onAvailableCommandsChanged(uo.n3 n3Var) {
            this.f11258v.onAvailableCommandsChanged(n3Var);
        }

        @Override // m1.uo.gv
        public void onCues(List<qh.n3> list) {
            this.f11258v.onCues(list);
        }

        @Override // m1.uo.gv
        public void onDeviceInfoChanged(xc xcVar) {
            this.f11258v.onDeviceInfoChanged(xcVar);
        }

        @Override // m1.uo.gv
        public void onDeviceVolumeChanged(int i, boolean z2) {
            this.f11258v.onDeviceVolumeChanged(i, z2);
        }

        @Override // m1.uo.gv
        public void onEvents(uo uoVar, uo.zn znVar) {
            this.f11258v.onEvents(this.y, znVar);
        }

        @Override // m1.uo.gv
        public void onIsLoadingChanged(boolean z2) {
            this.f11258v.onIsLoadingChanged(z2);
        }

        @Override // m1.uo.gv
        public void onIsPlayingChanged(boolean z2) {
            this.f11258v.onIsPlayingChanged(z2);
        }

        @Override // m1.uo.gv
        public void onLoadingChanged(boolean z2) {
            this.f11258v.onIsLoadingChanged(z2);
        }

        @Override // m1.uo.gv
        public void onMediaItemTransition(@Nullable o0 o0Var, int i) {
            this.f11258v.onMediaItemTransition(o0Var, i);
        }

        @Override // m1.uo.gv
        public void onMediaMetadataChanged(qk qkVar) {
            this.f11258v.onMediaMetadataChanged(qkVar);
        }

        @Override // m1.uo.gv
        public void onMetadata(Metadata metadata) {
            this.f11258v.onMetadata(metadata);
        }

        @Override // m1.uo.gv
        public void onPlayWhenReadyChanged(boolean z2, int i) {
            this.f11258v.onPlayWhenReadyChanged(z2, i);
        }

        @Override // m1.uo.gv
        public void onPlaybackParametersChanged(br brVar) {
            this.f11258v.onPlaybackParametersChanged(brVar);
        }

        @Override // m1.uo.gv
        public void onPlaybackStateChanged(int i) {
            this.f11258v.onPlaybackStateChanged(i);
        }

        @Override // m1.uo.gv
        public void onPlaybackSuppressionReasonChanged(int i) {
            this.f11258v.onPlaybackSuppressionReasonChanged(i);
        }

        @Override // m1.uo.gv
        public void onPlayerError(gf gfVar) {
            this.f11258v.onPlayerError(gfVar);
        }

        @Override // m1.uo.gv
        public void onPlayerErrorChanged(@Nullable gf gfVar) {
            this.f11258v.onPlayerErrorChanged(gfVar);
        }

        @Override // m1.uo.gv
        public void onPlayerStateChanged(boolean z2, int i) {
            this.f11258v.onPlayerStateChanged(z2, i);
        }

        @Override // m1.uo.gv
        public void onPositionDiscontinuity(int i) {
            this.f11258v.onPositionDiscontinuity(i);
        }

        @Override // m1.uo.gv
        public void onRenderedFirstFrame() {
            this.f11258v.onRenderedFirstFrame();
        }

        @Override // m1.uo.gv
        public void onRepeatModeChanged(int i) {
            this.f11258v.onRepeatModeChanged(i);
        }

        @Override // m1.uo.gv
        public void onSeekProcessed() {
            this.f11258v.onSeekProcessed();
        }

        @Override // m1.uo.gv
        public void onShuffleModeEnabledChanged(boolean z2) {
            this.f11258v.onShuffleModeEnabledChanged(z2);
        }

        @Override // m1.uo.gv
        public void onSkipSilenceEnabledChanged(boolean z2) {
            this.f11258v.onSkipSilenceEnabledChanged(z2);
        }

        @Override // m1.uo.gv
        public void onSurfaceSizeChanged(int i, int i5) {
            this.f11258v.onSurfaceSizeChanged(i, i5);
        }

        @Override // m1.uo.gv
        public void onTimelineChanged(hy hyVar, int i) {
            this.f11258v.onTimelineChanged(hyVar, i);
        }

        @Override // m1.uo.gv
        public void onTrackSelectionParametersChanged(zo.c cVar) {
            this.f11258v.onTrackSelectionParametersChanged(cVar);
        }

        @Override // m1.uo.gv
        public void onTracksChanged(v1 v1Var) {
            this.f11258v.onTracksChanged(v1Var);
        }

        @Override // m1.uo.gv
        public void onVideoSizeChanged(wn.d0 d0Var) {
            this.f11258v.onVideoSizeChanged(d0Var);
        }

        @Override // m1.uo.gv
        public void onVolumeChanged(float f4) {
            this.f11258v.onVolumeChanged(f4);
        }

        @Override // m1.uo.gv
        public void onCues(qh.a aVar) {
            this.f11258v.onCues(aVar);
        }

        @Override // m1.uo.gv
        public void onPositionDiscontinuity(uo.v vVar, uo.v vVar2, int i) {
            this.f11258v.onPositionDiscontinuity(vVar, vVar2, i);
        }
    }

    public u0(uo uoVar) {
        this.y = uoVar;
    }

    @Override // m1.uo
    @Nullable
    public gf a() {
        return this.y.a();
    }

    @Override // m1.uo
    public boolean a8() {
        return this.y.a8();
    }

    @Override // m1.uo
    public boolean ap() {
        return this.y.ap();
    }

    @Override // m1.uo
    public hy b() {
        return this.y.b();
    }

    @Override // m1.uo
    public long bk() {
        return this.y.bk();
    }

    @Override // m1.uo
    public int c5() {
        return this.y.c5();
    }

    @Override // m1.uo
    public boolean cr() {
        return this.y.cr();
    }

    @Override // m1.uo
    public v1 d0() {
        return this.y.d0();
    }

    @Override // m1.uo
    public void e(uo.gv gvVar) {
        this.y.e(new y(this, gvVar));
    }

    @Override // m1.uo
    public void eb(zo.c cVar) {
        this.y.eb(cVar);
    }

    @Override // m1.uo
    public int en() {
        return this.y.en();
    }

    @Override // m1.uo
    public long f() {
        return this.y.f();
    }

    @Override // m1.uo
    public void f3() {
        this.y.f3();
    }

    @Override // m1.uo
    public void fb(long j2) {
        this.y.fb(j2);
    }

    @Override // m1.uo
    public void g(uo.gv gvVar) {
        this.y.g(new y(this, gvVar));
    }

    @Override // m1.uo
    public void g3(@Nullable SurfaceView surfaceView) {
        this.y.g3(surfaceView);
    }

    @Override // m1.uo
    public long getCurrentPosition() {
        return this.y.getCurrentPosition();
    }

    @Override // m1.uo
    public long getDuration() {
        return this.y.getDuration();
    }

    @Override // m1.uo
    public float getVolume() {
        return this.y.getVolume();
    }

    @Override // m1.uo
    public void gv(int i) {
        this.y.gv(i);
    }

    @Override // m1.uo
    public void hw(@Nullable TextureView textureView) {
        this.y.hw(textureView);
    }

    @Override // m1.uo
    public boolean i9() {
        return this.y.i9();
    }

    @Override // m1.uo
    public boolean isPlaying() {
        return this.y.isPlaying();
    }

    @Override // m1.uo
    public void jz(@Nullable TextureView textureView) {
        this.y.jz(textureView);
    }

    @Override // m1.uo
    public Looper k5() {
        return this.y.k5();
    }

    @Override // m1.uo
    public int kp() {
        return this.y.kp();
    }

    @Override // m1.uo
    public void lc(int i) {
        this.y.lc(i);
    }

    @Override // m1.uo
    public qh.a mg() {
        return this.y.mg();
    }

    @Override // m1.uo
    public void n(boolean z2) {
        this.y.n(z2);
    }

    @Override // m1.uo
    public int n3() {
        return this.y.n3();
    }

    @Override // m1.uo
    public void o(int i, long j2) {
        this.y.o(i, j2);
    }

    @Override // m1.uo
    public boolean oz() {
        return this.y.oz();
    }

    @Override // m1.uo
    public void p(@Nullable SurfaceView surfaceView) {
        this.y.p(surfaceView);
    }

    @Override // m1.uo
    public void pause() {
        this.y.pause();
    }

    @Override // m1.uo
    public void play() {
        this.y.play();
    }

    @Override // m1.uo
    public void prepare() {
        this.y.prepare();
    }

    @Override // m1.uo
    public qk pz() {
        return this.y.pz();
    }

    @Override // m1.uo
    public long ra() {
        return this.y.ra();
    }

    @Override // m1.uo
    public void release() {
        this.y.release();
    }

    @Override // m1.uo
    public boolean rz() {
        return this.y.rz();
    }

    @Override // m1.uo
    public long s8() {
        return this.y.s8();
    }

    @Override // m1.uo
    public void stop() {
        this.y.stop();
    }

    @Override // m1.uo
    public void t() {
        this.y.t();
    }

    @Override // m1.uo
    public int ta() {
        return this.y.ta();
    }

    @Override // m1.uo
    public void tg() {
        this.y.tg();
    }

    @Override // m1.uo
    @Nullable
    public o0 tl() {
        return this.y.tl();
    }

    @Override // m1.uo
    public wn.d0 u() {
        return this.y.u();
    }

    @Override // m1.uo
    public boolean u0() {
        return this.y.u0();
    }

    @Override // m1.uo
    public void ut(boolean z2) {
        this.y.ut(z2);
    }

    @Override // m1.uo
    public br v() {
        return this.y.v();
    }

    @Override // m1.uo
    public void vl() {
        this.y.vl();
    }

    @Override // m1.uo
    public int x() {
        return this.y.x();
    }

    @Override // m1.uo
    @Deprecated
    public int x4() {
        return this.y.x4();
    }

    @Override // m1.uo
    public int xg() {
        return this.y.xg();
    }

    @Override // m1.uo
    public void y4() {
        this.y.y4();
    }

    @Override // m1.uo
    public boolean y5() {
        return this.y.y5();
    }

    @Override // m1.uo
    public zo.c yt() {
        return this.y.yt();
    }

    @Override // m1.uo
    public boolean z6(int i) {
        return this.y.z6(i);
    }

    @Override // m1.uo
    public void zn(br brVar) {
        this.y.zn(brVar);
    }
}
