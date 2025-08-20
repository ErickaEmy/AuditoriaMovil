package ls;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m1.br;
import m1.gf;
import m1.hy;
import m1.kp;
import m1.mh;
import m1.o0;
import m1.qk;
import m1.uo;
import m1.v1;
import m1.xc;
import v5.j5;
import wn.d0;
import zo.c;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: mt  reason: collision with root package name */
    public static final MediaMetadataCompat f10366mt;

    /* renamed from: a  reason: collision with root package name */
    public v[] f10367a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public uo f10368c5;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Bundle f10369f;

    /* renamed from: fb  reason: collision with root package name */
    public Map<String, v> f10370fb;

    /* renamed from: gv  reason: collision with root package name */
    public final ArrayList<zn> f10371gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public Pair<Integer, CharSequence> f10372i9;

    /* renamed from: n3  reason: collision with root package name */
    public final Looper f10373n3;

    /* renamed from: p  reason: collision with root package name */
    public boolean f10374p;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public s f10375s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public f f10376t;

    /* renamed from: tl  reason: collision with root package name */
    public long f10377tl;

    /* renamed from: v  reason: collision with root package name */
    public final ArrayList<zn> f10378v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f10379w;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f10380wz;

    /* renamed from: xc  reason: collision with root package name */
    public boolean f10381xc;
    public final MediaSessionCompat y;

    /* renamed from: zn  reason: collision with root package name */
    public final gv f10382zn;

    /* loaded from: classes.dex */
    public static final class a implements s {

        /* renamed from: n3  reason: collision with root package name */
        public final String f10383n3;
        public final MediaControllerCompat y;

        public a(MediaControllerCompat mediaControllerCompat, @Nullable String str) {
            this.y = mediaControllerCompat;
            this.f10383n3 = str == null ? "" : str;
        }

        @Override // ls.y.s
        public MediaMetadataCompat n3(uo uoVar) {
            long j2;
            if (uoVar.b().r()) {
                return y.f10366mt;
            }
            MediaMetadataCompat.n3 n3Var = new MediaMetadataCompat.n3();
            if (uoVar.i9()) {
                n3Var.zn("android.media.metadata.ADVERTISEMENT", 1L);
            }
            if (!uoVar.a8() && uoVar.getDuration() != -9223372036854775807L) {
                j2 = uoVar.getDuration();
            } else {
                j2 = -1;
            }
            n3Var.zn("android.media.metadata.DURATION", j2);
            long zn2 = this.y.zn().zn();
            if (zn2 != -1) {
                List<MediaSessionCompat.QueueItem> gv2 = this.y.gv();
                int i = 0;
                while (true) {
                    if (gv2 == null || i >= gv2.size()) {
                        break;
                    }
                    MediaSessionCompat.QueueItem queueItem = gv2.get(i);
                    if (queueItem.gv() == zn2) {
                        MediaDescriptionCompat zn3 = queueItem.zn();
                        Bundle zn4 = zn3.zn();
                        if (zn4 != null) {
                            for (String str : zn4.keySet()) {
                                Object obj = zn4.get(str);
                                if (obj instanceof String) {
                                    n3Var.v(this.f10383n3 + str, (String) obj);
                                } else if (obj instanceof CharSequence) {
                                    n3Var.a(this.f10383n3 + str, (CharSequence) obj);
                                } else if (obj instanceof Long) {
                                    n3Var.zn(this.f10383n3 + str, ((Long) obj).longValue());
                                } else if (obj instanceof Integer) {
                                    n3Var.zn(this.f10383n3 + str, ((Integer) obj).intValue());
                                } else if (obj instanceof Bitmap) {
                                    n3Var.n3(this.f10383n3 + str, (Bitmap) obj);
                                } else if (obj instanceof RatingCompat) {
                                    n3Var.gv(this.f10383n3 + str, (RatingCompat) obj);
                                }
                            }
                        }
                        CharSequence f4 = zn3.f();
                        if (f4 != null) {
                            String valueOf = String.valueOf(f4);
                            n3Var.v("android.media.metadata.TITLE", valueOf);
                            n3Var.v("android.media.metadata.DISPLAY_TITLE", valueOf);
                        }
                        CharSequence i92 = zn3.i9();
                        if (i92 != null) {
                            n3Var.v("android.media.metadata.DISPLAY_SUBTITLE", String.valueOf(i92));
                        }
                        CharSequence n32 = zn3.n3();
                        if (n32 != null) {
                            n3Var.v("android.media.metadata.DISPLAY_DESCRIPTION", String.valueOf(n32));
                        }
                        Bitmap gv3 = zn3.gv();
                        if (gv3 != null) {
                            n3Var.n3("android.media.metadata.DISPLAY_ICON", gv3);
                        }
                        Uri v2 = zn3.v();
                        if (v2 != null) {
                            n3Var.v("android.media.metadata.DISPLAY_ICON_URI", String.valueOf(v2));
                        }
                        String s2 = zn3.s();
                        if (s2 != null) {
                            n3Var.v("android.media.metadata.MEDIA_ID", s2);
                        }
                        Uri c52 = zn3.c5();
                        if (c52 != null) {
                            n3Var.v("android.media.metadata.MEDIA_URI", String.valueOf(c52));
                        }
                    } else {
                        i++;
                    }
                }
            }
            return n3Var.y();
        }

        @Override // ls.y.s
        public /* synthetic */ boolean y(MediaMetadataCompat mediaMetadataCompat, MediaMetadataCompat mediaMetadataCompat2) {
            return ls.n3.y(this, mediaMetadataCompat, mediaMetadataCompat2);
        }
    }

    /* loaded from: classes.dex */
    public interface c5 extends zn {
    }

    /* loaded from: classes.dex */
    public interface f extends zn {
        void a(uo uoVar);

        long fb(uo uoVar);

        void gv(uo uoVar);

        void n3(uo uoVar);

        void s(uo uoVar, long j2);

        void v(uo uoVar);

        long y(@Nullable uo uoVar);
    }

    /* loaded from: classes.dex */
    public interface fb {
    }

    /* loaded from: classes.dex */
    public class gv extends MediaSessionCompat.n3 implements uo.gv {

        /* renamed from: t  reason: collision with root package name */
        public int f10385t;

        /* renamed from: w  reason: collision with root package name */
        public int f10386w;

        public gv() {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void a8(Uri uri, @Nullable Bundle bundle) {
            if (!y.this.fh(131072L)) {
                return;
            }
            y.w(y.this);
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void b(MediaDescriptionCompat mediaDescriptionCompat) {
            if (!y.this.n()) {
                return;
            }
            y.s(y.this);
            uo unused = y.this.f10368c5;
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void c() {
            if (y.this.f3(2L)) {
                y.this.f10368c5.pause();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void d(Uri uri, @Nullable Bundle bundle) {
            if (!y.this.fh(8192L)) {
                return;
            }
            y.w(y.this);
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void ej(String str, @Nullable Bundle bundle) {
            if (!y.this.fh(32768L)) {
                return;
            }
            y.w(y.this);
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void en() {
            if (y.this.f3(1L)) {
                y.this.f10368c5.stop();
                if (y.this.f10379w) {
                    y.this.f10368c5.t();
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void f7(long j2) {
            if (y.this.rz(4096L)) {
                y.this.f10376t.s(y.this.f10368c5, j2);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void fb(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (!y.this.n()) {
                return;
            }
            y.s(y.this);
            uo unused = y.this.f10368c5;
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void fh() {
            if (y.this.f3(4L)) {
                if (y.this.f10368c5.n3() == 1) {
                    y.w(y.this);
                    y.this.f10368c5.prepare();
                } else if (y.this.f10368c5.n3() == 4) {
                    y yVar = y.this;
                    yVar.ud(yVar.f10368c5, y.this.f10368c5.kp(), -9223372036854775807L);
                }
                ((uo) v5.y.v(y.this.f10368c5)).play();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void hw(boolean z2) {
            if (!y.this.c()) {
                return;
            }
            y.i9(y.this);
            uo unused = y.this.f10368c5;
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void j(RatingCompat ratingCompat, @Nullable Bundle bundle) {
            if (!y.this.d0()) {
                return;
            }
            y.a(y.this);
            uo unused = y.this.f10368c5;
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void j5(float f4) {
            if (y.this.f3(4194304L) && f4 > 0.0f) {
                y.this.f10368c5.zn(y.this.f10368c5.v().gv(f4));
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void k() {
            if (y.this.rz(16L)) {
                y.this.f10376t.v(y.this.f10368c5);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void k5() {
            if (y.this.f3(8L)) {
                y.this.f10368c5.tg();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void mg(String str, @Nullable Bundle bundle) {
            if (!y.this.fh(1024L)) {
                return;
            }
            y.w(y.this);
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void mt() {
            if (y.this.f3(64L)) {
                y.this.f10368c5.y4();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public boolean n(Intent intent) {
            if (!y.this.i4()) {
                return super.n(intent);
            }
            y.tl(y.this);
            uo unused = y.this.f10368c5;
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void o(RatingCompat ratingCompat) {
            if (!y.this.d0()) {
                return;
            }
            y.a(y.this);
            uo unused = y.this.f10368c5;
            throw null;
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onAvailableCommandsChanged(uo.n3 n3Var) {
            mh.zn(this, n3Var);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onCues(List list) {
            mh.gv(this, list);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onDeviceInfoChanged(xc xcVar) {
            mh.a(this, xcVar);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z2) {
            mh.fb(this, i, z2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
            if (r7.f10385t == r2) goto L16;
         */
        @Override // m1.uo.gv
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onEvents(m1.uo r8, m1.uo.zn r9) {
            /*
                r7 = this;
                r0 = 11
                boolean r0 = r9.y(r0)
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L28
                int r0 = r7.f10385t
                int r3 = r8.kp()
                if (r0 == r3) goto L25
                ls.y r0 = ls.y.this
                ls.y$f r0 = ls.y.t(r0)
                if (r0 == 0) goto L23
                ls.y r0 = ls.y.this
                ls.y$f r0 = ls.y.t(r0)
                r0.n3(r8)
            L23:
                r0 = 1
                goto L26
            L25:
                r0 = 0
            L26:
                r3 = 1
                goto L2a
            L28:
                r0 = 0
                r3 = 0
            L2a:
                boolean r2 = r9.y(r2)
                if (r2 == 0) goto L5b
                m1.hy r0 = r8.b()
                int r0 = r0.z()
                int r2 = r8.kp()
                ls.y r4 = ls.y.this
                ls.y$f r4 = ls.y.t(r4)
                if (r4 == 0) goto L4f
                ls.y r2 = ls.y.this
                ls.y$f r2 = ls.y.t(r2)
                r2.a(r8)
            L4d:
                r3 = 1
                goto L58
            L4f:
                int r4 = r7.f10386w
                if (r4 != r0) goto L4d
                int r4 = r7.f10385t
                if (r4 == r2) goto L58
                goto L4d
            L58:
                r7.f10386w = r0
                r0 = 1
            L5b:
                int r8 = r8.kp()
                r7.f10385t = r8
                r8 = 8
                r2 = 12
                r4 = 4
                r5 = 5
                r6 = 7
                int[] r8 = new int[]{r4, r5, r6, r8, r2}
                boolean r8 = r9.n3(r8)
                if (r8 == 0) goto L73
                r3 = 1
            L73:
                r8 = 9
                int[] r8 = new int[]{r8}
                boolean r8 = r9.n3(r8)
                if (r8 == 0) goto L85
                ls.y r8 = ls.y.this
                r8.z6()
                goto L86
            L85:
                r1 = r3
            L86:
                if (r1 == 0) goto L8d
                ls.y r8 = ls.y.this
                r8.d()
            L8d:
                if (r0 == 0) goto L94
                ls.y r8 = ls.y.this
                r8.ta()
            L94:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ls.y.gv.onEvents(m1.uo, m1.uo$zn):void");
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onIsLoadingChanged(boolean z2) {
            mh.c5(this, z2);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onIsPlayingChanged(boolean z2) {
            mh.i9(this, z2);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onLoadingChanged(boolean z2) {
            mh.f(this, z2);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onMediaItemTransition(o0 o0Var, int i) {
            mh.tl(this, o0Var, i);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onMediaMetadataChanged(qk qkVar) {
            mh.wz(this, qkVar);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onMetadata(Metadata metadata) {
            mh.xc(this, metadata);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z2, int i) {
            mh.w(this, z2, i);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onPlaybackParametersChanged(br brVar) {
            mh.p(this, brVar);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onPlaybackStateChanged(int i) {
            mh.mt(this, i);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            mh.co(this, i);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onPlayerError(gf gfVar) {
            mh.z(this, gfVar);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onPlayerErrorChanged(gf gfVar) {
            mh.r(this, gfVar);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onPlayerStateChanged(boolean z2, int i) {
            mh.x4(this, z2, i);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onPositionDiscontinuity(int i) {
            mh.f3(this, i);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onRenderedFirstFrame() {
            mh.c(this);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onRepeatModeChanged(int i) {
            mh.d0(this, i);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onSeekProcessed() {
            mh.mg(this);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z2) {
            mh.ta(this, z2);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z2) {
            mh.d(this, z2);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onSurfaceSizeChanged(int i, int i5) {
            mh.z6(this, i, i5);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onTimelineChanged(hy hyVar, int i) {
            mh.ej(this, hyVar, i);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onTrackSelectionParametersChanged(c cVar) {
            mh.ud(this, cVar);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onTracksChanged(v1 v1Var) {
            mh.a8(this, v1Var);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onVideoSizeChanged(d0 d0Var) {
            mh.x(this, d0Var);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onVolumeChanged(float f4) {
            mh.b(this, f4);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void oz(int i) {
            if (y.this.f3(262144L)) {
                int i5 = 1;
                if (i != 1) {
                    i5 = 2;
                    if (i != 2 && i != 3) {
                        i5 = 0;
                    }
                }
                y.this.f10368c5.gv(i5);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void p(String str, @Nullable Bundle bundle) {
            if (y.this.f10368c5 != null && y.this.f10370fb.containsKey(str)) {
                ((v) y.this.f10370fb.get(str)).y(y.this.f10368c5, str, bundle);
                y.this.d();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void q9() {
            if (y.this.rz(32L)) {
                y.this.f10376t.gv(y.this.f10368c5);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void ta(String str, @Nullable Bundle bundle) {
            if (!y.this.fh(2048L)) {
                return;
            }
            y.w(y.this);
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void ud(String str, @Nullable Bundle bundle) {
            if (!y.this.fh(65536L)) {
                return;
            }
            y.w(y.this);
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void ut(int i) {
            if (y.this.f3(2097152L)) {
                boolean z2 = true;
                if (i != 1 && i != 2) {
                    z2 = false;
                }
                y.this.f10368c5.ut(z2);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void vl(long j2) {
            if (y.this.f3(256L)) {
                y yVar = y.this;
                yVar.ud(yVar.f10368c5, y.this.f10368c5.kp(), j2);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void w(String str, @Nullable Bundle bundle, @Nullable ResultReceiver resultReceiver) {
            if (y.this.f10368c5 != null) {
                for (int i = 0; i < y.this.f10371gv.size(); i++) {
                    if (((zn) y.this.f10371gv.get(i)).zn(y.this.f10368c5, str, bundle, resultReceiver)) {
                        return;
                    }
                }
                for (int i5 = 0; i5 < y.this.f10378v.size() && !((zn) y.this.f10378v.get(i5)).zn(y.this.f10368c5, str, bundle, resultReceiver); i5++) {
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void z6() {
            if (!y.this.fh(16384L)) {
                return;
            }
            y.w(y.this);
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.n3
        public void zn(MediaDescriptionCompat mediaDescriptionCompat) {
            if (!y.this.n()) {
                return;
            }
            y.s(y.this);
            uo unused = y.this.f10368c5;
            throw null;
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onCues(qh.a aVar) {
            mh.v(this, aVar);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onPositionDiscontinuity(uo.v vVar, uo.v vVar2, int i) {
            mh.n(this, vVar, vVar2, i);
        }
    }

    /* loaded from: classes.dex */
    public interface i9 extends zn {
    }

    /* loaded from: classes.dex */
    public interface n3 extends zn {
    }

    /* loaded from: classes.dex */
    public interface s {
        MediaMetadataCompat n3(uo uoVar);

        boolean y(MediaMetadataCompat mediaMetadataCompat, MediaMetadataCompat mediaMetadataCompat2);
    }

    /* loaded from: classes.dex */
    public interface t extends zn {
    }

    /* loaded from: classes.dex */
    public interface v {
        @Nullable
        PlaybackStateCompat.CustomAction n3(uo uoVar);

        void y(uo uoVar, String str, @Nullable Bundle bundle);
    }

    /* loaded from: classes.dex */
    public interface zn {
        boolean zn(uo uoVar, String str, @Nullable Bundle bundle, @Nullable ResultReceiver resultReceiver);
    }

    static {
        kp.y("goog.exo.mediasession");
        f10366mt = new MediaMetadataCompat.n3().y();
    }

    public y(MediaSessionCompat mediaSessionCompat) {
        this.y = mediaSessionCompat;
        Looper j52 = j5.j5();
        this.f10373n3 = j52;
        gv gvVar = new gv();
        this.f10382zn = gvVar;
        this.f10371gv = new ArrayList<>();
        this.f10378v = new ArrayList<>();
        this.f10367a = new v[0];
        this.f10370fb = Collections.emptyMap();
        this.f10375s = new a(mediaSessionCompat.n3(), null);
        this.f10377tl = 2360143L;
        mediaSessionCompat.c5(3);
        mediaSessionCompat.s(gvVar, new Handler(j52));
        this.f10379w = true;
    }

    public static /* synthetic */ t a(y yVar) {
        yVar.getClass();
        return null;
    }

    public static /* synthetic */ n3 i9(y yVar) {
        yVar.getClass();
        return null;
    }

    public static /* synthetic */ i9 s(y yVar) {
        yVar.getClass();
        return null;
    }

    public static /* synthetic */ fb tl(y yVar) {
        yVar.getClass();
        return null;
    }

    public static /* synthetic */ c5 w(y yVar) {
        yVar.getClass();
        return null;
    }

    public void a8(@Nullable uo uoVar) {
        boolean z2;
        if (uoVar != null && uoVar.k5() != this.f10373n3) {
            z2 = false;
        } else {
            z2 = true;
        }
        v5.y.y(z2);
        uo uoVar2 = this.f10368c5;
        if (uoVar2 != null) {
            uoVar2.e(this.f10382zn);
        }
        this.f10368c5 = uoVar;
        if (uoVar != null) {
            uoVar.g(this.f10382zn);
        }
        d();
        ta();
    }

    public final void b(@Nullable zn znVar) {
        if (znVar != null) {
            this.f10371gv.remove(znVar);
        }
    }

    public final boolean c() {
        return false;
    }

    public final void d() {
        v[] vVarArr;
        int i;
        long j2;
        float f4;
        PlaybackStateCompat.gv gvVar = new PlaybackStateCompat.gv();
        uo uoVar = this.f10368c5;
        int i5 = 0;
        if (uoVar == null) {
            gvVar.zn(x4()).c5(0, 0L, 0.0f, SystemClock.elapsedRealtime());
            this.y.wz(0);
            this.y.xc(0);
            this.y.t(gvVar.n3());
            return;
        }
        HashMap hashMap = new HashMap();
        for (v vVar : this.f10367a) {
            PlaybackStateCompat.CustomAction n32 = vVar.n3(uoVar);
            if (n32 != null) {
                hashMap.put(n32.n3(), vVar);
                gvVar.y(n32);
            }
        }
        this.f10370fb = Collections.unmodifiableMap(hashMap);
        Bundle bundle = new Bundle();
        if (uoVar.a() == null && this.f10372i9 == null) {
            i = mg(uoVar.n3(), uoVar.oz());
        } else {
            i = 7;
        }
        Pair<Integer, CharSequence> pair = this.f10372i9;
        if (pair != null) {
            gvVar.a(((Integer) pair.first).intValue(), (CharSequence) this.f10372i9.second);
            Bundle bundle2 = this.f10369f;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
        }
        f fVar = this.f10376t;
        if (fVar != null) {
            j2 = fVar.y(uoVar);
        } else {
            j2 = -1;
        }
        float f6 = uoVar.v().y;
        bundle.putFloat("EXO_SPEED", f6);
        if (uoVar.isPlaying()) {
            f4 = f6;
        } else {
            f4 = 0.0f;
        }
        o0 tl2 = uoVar.tl();
        if (tl2 != null && !"".equals(tl2.y)) {
            bundle.putString("androidx.media.PlaybackStateCompat.Extras.KEY_MEDIA_ID", tl2.y);
        }
        gvVar.zn(x4() | r(uoVar)).gv(j2).v(uoVar.s8()).c5(i, uoVar.getCurrentPosition(), f4, SystemClock.elapsedRealtime()).fb(bundle);
        int c52 = uoVar.c5();
        MediaSessionCompat mediaSessionCompat = this.y;
        if (c52 == 1) {
            i5 = 1;
        } else if (c52 == 2) {
            i5 = 2;
        }
        mediaSessionCompat.wz(i5);
        this.y.xc(uoVar.u0() ? 1 : 0);
        this.y.t(gvVar.n3());
    }

    public final boolean d0() {
        return false;
    }

    public final void ej(@Nullable zn znVar) {
        if (znVar != null && !this.f10371gv.contains(znVar)) {
            this.f10371gv.add(znVar);
        }
    }

    public final boolean f3(long j2) {
        if (this.f10368c5 != null && ((j2 & this.f10377tl) != 0 || this.f10381xc)) {
            return true;
        }
        return false;
    }

    public final boolean fh(long j2) {
        return false;
    }

    public final boolean i4() {
        return false;
    }

    public final int mg(int i, boolean z2) {
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    return this.f10374p ? 1 : 0;
                }
                return 1;
            } else if (!z2) {
                return 2;
            } else {
                return 3;
            }
        } else if (!z2) {
            return 2;
        } else {
            return 6;
        }
    }

    public final boolean n() {
        return false;
    }

    public final long r(uo uoVar) {
        long j2;
        boolean z62 = uoVar.z6(5);
        boolean z63 = uoVar.z6(11);
        boolean z64 = uoVar.z6(12);
        if (!uoVar.b().r()) {
            uoVar.i9();
        }
        if (z62) {
            j2 = 6554375;
        } else {
            j2 = 6554119;
        }
        if (z64) {
            j2 |= 64;
        }
        if (z63) {
            j2 |= 8;
        }
        long j4 = this.f10377tl & j2;
        f fVar = this.f10376t;
        if (fVar != null) {
            return j4 | (fVar.fb(uoVar) & 4144);
        }
        return j4;
    }

    public final boolean rz(long j2) {
        f fVar;
        uo uoVar = this.f10368c5;
        if (uoVar != null && (fVar = this.f10376t) != null && ((j2 & fVar.fb(uoVar)) != 0 || this.f10381xc)) {
            return true;
        }
        return false;
    }

    public final void ta() {
        MediaMetadataCompat mediaMetadataCompat;
        MediaMetadataCompat n32;
        uo uoVar;
        s sVar = this.f10375s;
        if (sVar != null && (uoVar = this.f10368c5) != null) {
            mediaMetadataCompat = sVar.n3(uoVar);
        } else {
            mediaMetadataCompat = f10366mt;
        }
        s sVar2 = this.f10375s;
        if (this.f10380wz && sVar2 != null && (n32 = this.y.n3().n3()) != null && sVar2.y(n32, mediaMetadataCompat)) {
            return;
        }
        this.y.f(mediaMetadataCompat);
    }

    public final void ud(uo uoVar, int i, long j2) {
        uoVar.o(i, j2);
    }

    public void x(@Nullable f fVar) {
        f fVar2 = this.f10376t;
        if (fVar2 != fVar) {
            b(fVar2);
            this.f10376t = fVar;
            ej(fVar);
        }
    }

    public final long x4() {
        return 0L;
    }

    public final void z6() {
        uo uoVar;
        f fVar = this.f10376t;
        if (fVar != null && (uoVar = this.f10368c5) != null) {
            fVar.a(uoVar);
        }
    }
}
