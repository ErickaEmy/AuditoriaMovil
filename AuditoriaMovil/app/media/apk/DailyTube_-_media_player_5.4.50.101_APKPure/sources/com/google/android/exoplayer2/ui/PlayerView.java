package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.zn;
import java.util.ArrayList;
import java.util.List;
import m1.br;
import m1.gf;
import m1.hy;
import m1.mh;
import m1.o0;
import m1.qk;
import m1.uo;
import m1.v1;
import m1.xc;
import v5.j5;
import v5.t;
import wn.d0;
import z0.x4;
import zo.c;
@Deprecated
/* loaded from: classes.dex */
public class PlayerView extends FrameLayout {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f4716b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4717c;
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public final TextView f4718co;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public Drawable f4719d;
    @Nullable

    /* renamed from: d0  reason: collision with root package name */
    public zn.v f4720d0;

    /* renamed from: ej  reason: collision with root package name */
    public int f4721ej;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4722f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public final FrameLayout f4723f3;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final View f4724fb;

    /* renamed from: fh  reason: collision with root package name */
    public boolean f4725fh;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4726j;

    /* renamed from: j5  reason: collision with root package name */
    public int f4727j5;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public uo f4728n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f4729o;

    /* renamed from: oz  reason: collision with root package name */
    public int f4730oz;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public final View f4731p;

    /* renamed from: qn  reason: collision with root package name */
    public boolean f4732qn;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public final FrameLayout f4733r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public final View f4734s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public final ImageView f4735t;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final AspectRatioFrameLayout f4736v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public final SubtitleView f4737w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f4738x;
    public final y y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public final zn f4739z;

    /* loaded from: classes.dex */
    public final class y implements uo.gv, View.OnLayoutChangeListener, View.OnClickListener, zn.v {
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public Object f4741v;
        public final hy.n3 y = new hy.n3();

        public y() {
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onAvailableCommandsChanged(uo.n3 n3Var) {
            mh.zn(this, n3Var);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerView.this.z6();
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

        @Override // m1.uo.gv
        public /* synthetic */ void onEvents(uo uoVar, uo.zn znVar) {
            mh.s(this, uoVar, znVar);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onIsLoadingChanged(boolean z2) {
            mh.c5(this, z2);
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onIsPlayingChanged(boolean z2) {
            mh.i9(this, z2);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i5, int i6, int i8, int i10, int i11, int i12, int i13) {
            PlayerView.xc((TextureView) view, PlayerView.this.f4730oz);
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
        public void onPlayWhenReadyChanged(boolean z2, int i) {
            PlayerView.this.ud();
            PlayerView.this.x();
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onPlaybackParametersChanged(br brVar) {
            mh.p(this, brVar);
        }

        @Override // m1.uo.gv
        public void onPlaybackStateChanged(int i) {
            PlayerView.this.ud();
            PlayerView.this.b();
            PlayerView.this.x();
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
        public void onRenderedFirstFrame() {
            if (PlayerView.this.f4724fb != null) {
                PlayerView.this.f4724fb.setVisibility(4);
            }
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
        public void onTracksChanged(v1 v1Var) {
            uo uoVar = (uo) v5.y.v(PlayerView.this.f4728n);
            hy b2 = uoVar.b();
            if (b2.r()) {
                this.f4741v = null;
            } else if (!uoVar.d0().zn()) {
                this.f4741v = b2.f(uoVar.en(), this.y, true).f10831v;
            } else {
                Object obj = this.f4741v;
                if (obj != null) {
                    int a2 = b2.a(obj);
                    if (a2 != -1) {
                        if (uoVar.kp() == b2.i9(a2, this.y).f10828fb) {
                            return;
                        }
                    }
                    this.f4741v = null;
                }
            }
            PlayerView.this.k5(false);
        }

        @Override // m1.uo.gv
        public void onVideoSizeChanged(d0 d0Var) {
            PlayerView.this.ej();
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onVolumeChanged(float f4) {
            mh.b(this, f4);
        }

        @Override // com.google.android.exoplayer2.ui.zn.v
        public void y(int i) {
            PlayerView.this.a8();
        }

        @Override // m1.uo.gv
        public void onCues(qh.a aVar) {
            if (PlayerView.this.f4737w != null) {
                PlayerView.this.f4737w.setCues(aVar.y);
            }
        }

        @Override // m1.uo.gv
        public void onPositionDiscontinuity(uo.v vVar, uo.v vVar2, int i) {
            if (PlayerView.this.i4() && PlayerView.this.f4729o) {
                PlayerView.this.r();
            }
        }
    }

    public PlayerView(Context context) {
        this(context, null);
    }

    public static void d(uo uoVar, @Nullable PlayerView playerView, @Nullable PlayerView playerView2) {
        if (playerView == playerView2) {
            return;
        }
        if (playerView2 != null) {
            playerView2.setPlayer(uoVar);
        }
        if (playerView != null) {
            playerView.setPlayer(null);
        }
    }

    public static void fh(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    public static void mt(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(j5.ut(context, resources, R$drawable.il));
        imageView.setBackgroundColor(resources.getColor(R$color.xa, null));
    }

    public static void p(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(j5.ut(context, resources, R$drawable.il));
        imageView.setBackgroundColor(resources.getColor(R$color.xa));
    }

    public static void xc(TextureView textureView, int i) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i != 0) {
            float f4 = width / 2.0f;
            float f6 = height / 2.0f;
            matrix.postRotate(i, f4, f6);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f4, f6);
        }
        textureView.setTransform(matrix);
    }

    public final void a8() {
        zn znVar = this.f4739z;
        String str = null;
        if (znVar != null && this.f4717c) {
            if (znVar.getVisibility() == 0) {
                if (this.f4726j) {
                    str = getResources().getString(R$string.q5);
                }
                setContentDescription(str);
                return;
            }
            setContentDescription(getResources().getString(R$string.pg));
            return;
        }
        setContentDescription(null);
    }

    public final void b() {
        TextView textView = this.f4718co;
        if (textView != null) {
            CharSequence charSequence = this.f4716b;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f4718co.setVisibility(0);
                return;
            }
            uo uoVar = this.f4728n;
            if (uoVar != null) {
                uoVar.a();
            }
            this.f4718co.setVisibility(8);
        }
    }

    public final boolean c(qk qkVar) {
        byte[] bArr = qkVar.f11201z;
        if (bArr == null) {
            return false;
        }
        return d0(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    public boolean co(KeyEvent keyEvent) {
        if (vl() && this.f4739z.d0(keyEvent)) {
            return true;
        }
        return false;
    }

    public final boolean d0(@Nullable Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                n(this.f4736v, intrinsicWidth / intrinsicHeight);
                this.f4735t.setImageDrawable(drawable);
                this.f4735t.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        uo uoVar = this.f4728n;
        if (uoVar != null && uoVar.i9()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean x42 = x4(keyEvent.getKeyCode());
        if (x42 && vl() && !this.f4739z.ud()) {
            f3(true);
            return true;
        } else if (!co(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            if (x42 && vl()) {
                f3(true);
            }
            return false;
        } else {
            f3(true);
            return true;
        }
    }

    public final void ej() {
        d0 d0Var;
        float f4;
        uo uoVar = this.f4728n;
        if (uoVar != null) {
            d0Var = uoVar.u();
        } else {
            d0Var = d0.f14575f;
        }
        int i = d0Var.y;
        int i5 = d0Var.f14582v;
        int i6 = d0Var.f14580fb;
        float f6 = 0.0f;
        if (i5 != 0 && i != 0) {
            f4 = (i * d0Var.f14581s) / i5;
        } else {
            f4 = 0.0f;
        }
        View view = this.f4734s;
        if (view instanceof TextureView) {
            if (f4 > 0.0f && (i6 == 90 || i6 == 270)) {
                f4 = 1.0f / f4;
            }
            if (this.f4730oz != 0) {
                view.removeOnLayoutChangeListener(this.y);
            }
            this.f4730oz = i6;
            if (i6 != 0) {
                this.f4734s.addOnLayoutChangeListener(this.y);
            }
            xc((TextureView) this.f4734s, this.f4730oz);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f4736v;
        if (!this.f4722f) {
            f6 = f4;
        }
        n(aspectRatioFrameLayout, f6);
    }

    public final void f3(boolean z2) {
        boolean z3;
        if ((!i4() || !this.f4729o) && vl()) {
            if (this.f4739z.ud() && this.f4739z.getShowTimeoutMs() <= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean rz2 = rz();
            if (z2 || z3 || rz2) {
                ta(rz2);
            }
        }
    }

    public List<mn.y> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f4723f3;
        if (frameLayout != null) {
            arrayList.add(new mn.y(frameLayout, 4, "Transparent overlay does not impact viewability"));
        }
        zn znVar = this.f4739z;
        if (znVar != null) {
            arrayList.add(new mn.y(znVar, 1));
        }
        return x4.d(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) v5.y.i9(this.f4733r, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f4732qn;
    }

    public boolean getControllerHideOnTouch() {
        return this.f4726j;
    }

    public int getControllerShowTimeoutMs() {
        return this.f4727j5;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f4719d;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f4723f3;
    }

    @Nullable
    public uo getPlayer() {
        return this.f4728n;
    }

    public int getResizeMode() {
        v5.y.c5(this.f4736v);
        return this.f4736v.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f4737w;
    }

    public boolean getUseArtwork() {
        return this.f4725fh;
    }

    public boolean getUseController() {
        return this.f4717c;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.f4734s;
    }

    public final boolean i4() {
        uo uoVar = this.f4728n;
        if (uoVar != null && uoVar.i9() && this.f4728n.oz()) {
            return true;
        }
        return false;
    }

    public final void k5(boolean z2) {
        uo uoVar = this.f4728n;
        if (uoVar != null && uoVar.z6(30) && !uoVar.d0().zn()) {
            if (z2 && !this.f4738x) {
                w();
            }
            if (uoVar.d0().gv(2)) {
                z();
                return;
            }
            w();
            if (yt() && (c(uoVar.pz()) || d0(this.f4719d))) {
                return;
            }
            z();
        } else if (!this.f4738x) {
            z();
            w();
        }
    }

    public void mg() {
        ta(rz());
    }

    public void n(@Nullable AspectRatioFrameLayout aspectRatioFrameLayout, float f4) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f4);
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (vl() && this.f4728n != null) {
            f3(true);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        z6();
        return super.performClick();
    }

    public void r() {
        zn znVar = this.f4739z;
        if (znVar != null) {
            znVar.d();
        }
    }

    public final boolean rz() {
        uo uoVar = this.f4728n;
        if (uoVar == null) {
            return true;
        }
        int n32 = uoVar.n3();
        if (this.f4732qn && (n32 == 1 || n32 == 4 || !this.f4728n.oz())) {
            return true;
        }
        return false;
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.n3 n3Var) {
        v5.y.c5(this.f4736v);
        this.f4736v.setAspectRatioListener(n3Var);
    }

    public void setControllerAutoShow(boolean z2) {
        this.f4732qn = z2;
    }

    public void setControllerHideDuringAds(boolean z2) {
        this.f4729o = z2;
    }

    public void setControllerHideOnTouch(boolean z2) {
        v5.y.c5(this.f4739z);
        this.f4726j = z2;
        a8();
    }

    public void setControllerShowTimeoutMs(int i) {
        v5.y.c5(this.f4739z);
        this.f4727j5 = i;
        if (this.f4739z.ud()) {
            mg();
        }
    }

    public void setControllerVisibilityListener(@Nullable zn.v vVar) {
        v5.y.c5(this.f4739z);
        zn.v vVar2 = this.f4720d0;
        if (vVar2 == vVar) {
            return;
        }
        if (vVar2 != null) {
            this.f4739z.a8(vVar2);
        }
        this.f4720d0 = vVar;
        if (vVar != null) {
            this.f4739z.n(vVar);
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        boolean z2;
        if (this.f4718co != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        this.f4716b = charSequence;
        b();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f4719d != drawable) {
            this.f4719d = drawable;
            k5(false);
        }
    }

    public void setErrorMessageProvider(@Nullable t<? super gf> tVar) {
        if (tVar != null) {
            b();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z2) {
        if (this.f4738x != z2) {
            this.f4738x = z2;
            k5(false);
        }
    }

    public void setPlayer(@Nullable uo uoVar) {
        boolean z2;
        boolean z3;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        if (uoVar != null && uoVar.k5() != Looper.getMainLooper()) {
            z3 = false;
        } else {
            z3 = true;
        }
        v5.y.y(z3);
        uo uoVar2 = this.f4728n;
        if (uoVar2 == uoVar) {
            return;
        }
        if (uoVar2 != null) {
            uoVar2.e(this.y);
            if (uoVar2.z6(27)) {
                View view = this.f4734s;
                if (view instanceof TextureView) {
                    uoVar2.jz((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    uoVar2.g3((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.f4737w;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f4728n = uoVar;
        if (vl()) {
            this.f4739z.setPlayer(uoVar);
        }
        ud();
        b();
        k5(true);
        if (uoVar != null) {
            if (uoVar.z6(27)) {
                View view2 = this.f4734s;
                if (view2 instanceof TextureView) {
                    uoVar.hw((TextureView) view2);
                } else if (view2 instanceof SurfaceView) {
                    uoVar.p((SurfaceView) view2);
                }
                ej();
            }
            if (this.f4737w != null && uoVar.z6(28)) {
                this.f4737w.setCues(uoVar.mg().y);
            }
            uoVar.g(this.y);
            f3(false);
            return;
        }
        r();
    }

    public void setRepeatToggleModes(int i) {
        v5.y.c5(this.f4739z);
        this.f4739z.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        v5.y.c5(this.f4736v);
        this.f4736v.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.f4721ej != i) {
            this.f4721ej = i;
            ud();
        }
    }

    public void setShowFastForwardButton(boolean z2) {
        v5.y.c5(this.f4739z);
        this.f4739z.setShowFastForwardButton(z2);
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        v5.y.c5(this.f4739z);
        this.f4739z.setShowMultiWindowTimeBar(z2);
    }

    public void setShowNextButton(boolean z2) {
        v5.y.c5(this.f4739z);
        this.f4739z.setShowNextButton(z2);
    }

    public void setShowPreviousButton(boolean z2) {
        v5.y.c5(this.f4739z);
        this.f4739z.setShowPreviousButton(z2);
    }

    public void setShowRewindButton(boolean z2) {
        v5.y.c5(this.f4739z);
        this.f4739z.setShowRewindButton(z2);
    }

    public void setShowShuffleButton(boolean z2) {
        v5.y.c5(this.f4739z);
        this.f4739z.setShowShuffleButton(z2);
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.f4724fb;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setUseArtwork(boolean z2) {
        boolean z3;
        if (z2 && this.f4735t == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        v5.y.fb(z3);
        if (this.f4725fh != z2) {
            this.f4725fh = z2;
            k5(false);
        }
    }

    public void setUseController(boolean z2) {
        boolean z3;
        boolean z4 = true;
        if (z2 && this.f4739z == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        v5.y.fb(z3);
        if (!z2 && !hasOnClickListeners()) {
            z4 = false;
        }
        setClickable(z4);
        if (this.f4717c == z2) {
            return;
        }
        this.f4717c = z2;
        if (vl()) {
            this.f4739z.setPlayer(this.f4728n);
        } else {
            zn znVar = this.f4739z;
            if (znVar != null) {
                znVar.d();
                this.f4739z.setPlayer(null);
            }
        }
        a8();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.f4734s;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    public final void ta(boolean z2) {
        int i;
        if (!vl()) {
            return;
        }
        zn znVar = this.f4739z;
        if (z2) {
            i = 0;
        } else {
            i = this.f4727j5;
        }
        znVar.setShowTimeoutMs(i);
        this.f4739z.hw();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r4.f4728n.oz() == false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ud() {
        /*
            r4 = this;
            android.view.View r0 = r4.f4731p
            if (r0 == 0) goto L2b
            m1.uo r0 = r4.f4728n
            r1 = 0
            if (r0 == 0) goto L20
            int r0 = r0.n3()
            r2 = 2
            if (r0 != r2) goto L20
            int r0 = r4.f4721ej
            r3 = 1
            if (r0 == r2) goto L21
            if (r0 != r3) goto L20
            m1.uo r0 = r4.f4728n
            boolean r0 = r0.oz()
            if (r0 == 0) goto L20
            goto L21
        L20:
            r3 = 0
        L21:
            android.view.View r0 = r4.f4731p
            if (r3 == 0) goto L26
            goto L28
        L26:
            r1 = 8
        L28:
            r0.setVisibility(r1)
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerView.ud():void");
    }

    public final boolean vl() {
        if (this.f4717c) {
            v5.y.c5(this.f4739z);
            return true;
        }
        return false;
    }

    public final void w() {
        View view = this.f4724fb;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void x() {
        if (i4() && this.f4729o) {
            r();
        } else {
            f3(false);
        }
    }

    @SuppressLint({"InlinedApi"})
    public final boolean x4(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    public final boolean yt() {
        if (this.f4725fh) {
            v5.y.c5(this.f4735t);
            return true;
        }
        return false;
    }

    public final void z() {
        ImageView imageView = this.f4735t;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.f4735t.setVisibility(4);
        }
    }

    public final void z6() {
        if (vl() && this.f4728n != null) {
            if (!this.f4739z.ud()) {
                f3(true);
            } else if (this.f4726j) {
                this.f4739z.d();
            }
        }
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        int i8;
        boolean z4;
        int i10;
        int i11;
        boolean z5;
        boolean z7;
        int i12;
        boolean z8;
        boolean z9;
        boolean z10;
        y yVar = new y();
        this.y = yVar;
        if (isInEditMode()) {
            this.f4736v = null;
            this.f4724fb = null;
            this.f4734s = null;
            this.f4722f = false;
            this.f4735t = null;
            this.f4737w = null;
            this.f4731p = null;
            this.f4718co = null;
            this.f4739z = null;
            this.f4733r = null;
            this.f4723f3 = null;
            ImageView imageView = new ImageView(context);
            if (j5.y >= 23) {
                mt(context, getResources(), imageView);
            } else {
                p(context, getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i13 = R$layout.bb;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.f4764ej, i, 0);
            try {
                int i14 = R$styleable.f4785qn;
                boolean hasValue = obtainStyledAttributes.hasValue(i14);
                int color = obtainStyledAttributes.getColor(i14, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.f4801yt, i13);
                boolean z11 = obtainStyledAttributes.getBoolean(R$styleable.f4773j, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.f4757a8, 0);
                boolean z12 = obtainStyledAttributes.getBoolean(R$styleable.f4782oz, true);
                int i15 = obtainStyledAttributes.getInt(R$styleable.f4781o, 1);
                int i16 = obtainStyledAttributes.getInt(R$styleable.f4795vl, 0);
                int i17 = obtainStyledAttributes.getInt(R$styleable.f4774j5, 5000);
                boolean z13 = obtainStyledAttributes.getBoolean(R$styleable.f4758b, true);
                boolean z14 = obtainStyledAttributes.getBoolean(R$styleable.f4792ud, true);
                int integer = obtainStyledAttributes.getInteger(R$styleable.f4770hw, 0);
                this.f4738x = obtainStyledAttributes.getBoolean(R$styleable.f4776k5, this.f4738x);
                boolean z15 = obtainStyledAttributes.getBoolean(R$styleable.f4798x, true);
                obtainStyledAttributes.recycle();
                i13 = resourceId;
                z4 = z13;
                i5 = i17;
                z3 = z15;
                i8 = i16;
                z2 = z14;
                i6 = integer;
                z8 = z12;
                i12 = resourceId2;
                z7 = z11;
                z5 = hasValue;
                i11 = color;
                i10 = i15;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i5 = 5000;
            i6 = 0;
            z2 = true;
            z3 = true;
            i8 = 0;
            z4 = true;
            i10 = 1;
            i11 = 0;
            z5 = false;
            z7 = true;
            i12 = 0;
            z8 = true;
        }
        LayoutInflater.from(context).inflate(i13, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R$id.exo_content_frame);
        this.f4736v = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            fh(aspectRatioFrameLayout, i8);
        }
        View findViewById = findViewById(R$id.exo_shutter);
        this.f4724fb = findViewById;
        if (findViewById != null && z5) {
            findViewById.setBackgroundColor(i11);
        }
        if (aspectRatioFrameLayout != null && i10 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i10 == 2) {
                this.f4734s = new TextureView(context);
            } else if (i10 == 3) {
                try {
                    int i18 = gk.t.f8309n;
                    this.f4734s = (View) gk.t.class.getConstructor(Context.class).newInstance(context);
                    z10 = true;
                    this.f4734s.setLayoutParams(layoutParams);
                    this.f4734s.setOnClickListener(yVar);
                    this.f4734s.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f4734s, 0);
                    z9 = z10;
                } catch (Exception e2) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e2);
                }
            } else if (i10 != 4) {
                this.f4734s = new SurfaceView(context);
            } else {
                try {
                    this.f4734s = (View) Class.forName("wn.c5").getConstructor(Context.class).newInstance(context);
                } catch (Exception e3) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e3);
                }
            }
            z10 = false;
            this.f4734s.setLayoutParams(layoutParams);
            this.f4734s.setOnClickListener(yVar);
            this.f4734s.setClickable(false);
            aspectRatioFrameLayout.addView(this.f4734s, 0);
            z9 = z10;
        } else {
            this.f4734s = null;
            z9 = false;
        }
        this.f4722f = z9;
        this.f4733r = (FrameLayout) findViewById(R$id.exo_ad_overlay);
        this.f4723f3 = (FrameLayout) findViewById(R$id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_artwork);
        this.f4735t = imageView2;
        this.f4725fh = z7 && imageView2 != null;
        if (i12 != 0) {
            this.f4719d = mg.y.v(getContext(), i12);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.exo_subtitles);
        this.f4737w = subtitleView;
        if (subtitleView != null) {
            subtitleView.v();
            subtitleView.a();
        }
        View findViewById2 = findViewById(R$id.exo_buffering);
        this.f4731p = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.f4721ej = i6;
        TextView textView = (TextView) findViewById(R$id.exo_error_message);
        this.f4718co = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i19 = R$id.exo_controller;
        zn znVar = (zn) findViewById(i19);
        View findViewById3 = findViewById(R$id.exo_controller_placeholder);
        if (znVar != null) {
            this.f4739z = znVar;
        } else if (findViewById3 != null) {
            zn znVar2 = new zn(context, null, 0, attributeSet);
            this.f4739z = znVar2;
            znVar2.setId(i19);
            znVar2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(znVar2, indexOfChild);
        } else {
            this.f4739z = null;
        }
        zn znVar3 = this.f4739z;
        this.f4727j5 = znVar3 != null ? i5 : 0;
        this.f4726j = z4;
        this.f4732qn = z2;
        this.f4729o = z3;
        this.f4717c = z8 && znVar3 != null;
        if (znVar3 != null) {
            znVar3.d();
            this.f4739z.n(yVar);
        }
        if (z8) {
            setClickable(true);
        }
        a8();
    }
}
