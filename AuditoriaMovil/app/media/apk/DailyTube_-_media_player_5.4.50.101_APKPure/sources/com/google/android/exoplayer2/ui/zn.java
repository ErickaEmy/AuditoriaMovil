package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.ui.v;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
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
import v5.d;
import v5.j5;
import wn.d0;
import zo.c;
/* loaded from: classes.dex */
public class zn extends FrameLayout {

    /* renamed from: ap  reason: collision with root package name */
    public boolean f4885ap;

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f4886b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final com.google.android.exoplayer2.ui.v f4887c;
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public final ImageView f4888co;

    /* renamed from: ct  reason: collision with root package name */
    public boolean f4889ct;

    /* renamed from: d  reason: collision with root package name */
    public final hy.n3 f4890d;

    /* renamed from: d0  reason: collision with root package name */
    public final StringBuilder f4891d0;

    /* renamed from: dm  reason: collision with root package name */
    public boolean f4892dm;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4893e;

    /* renamed from: eb  reason: collision with root package name */
    public int f4894eb;

    /* renamed from: ej  reason: collision with root package name */
    public final hy.gv f4895ej;

    /* renamed from: en  reason: collision with root package name */
    public final float f4896en;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final View f4897f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public final TextView f4898f3;

    /* renamed from: f7  reason: collision with root package name */
    public final float f4899f7;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final View f4900fb;

    /* renamed from: fh  reason: collision with root package name */
    public final Formatter f4901fh;

    /* renamed from: g  reason: collision with root package name */
    public long f4902g;

    /* renamed from: g3  reason: collision with root package name */
    public boolean[] f4903g3;

    /* renamed from: j  reason: collision with root package name */
    public final String f4904j;

    /* renamed from: j5  reason: collision with root package name */
    public final Drawable f4905j5;

    /* renamed from: jz  reason: collision with root package name */
    public final String f4906jz;

    /* renamed from: k  reason: collision with root package name */
    public final Drawable f4907k;

    /* renamed from: kp  reason: collision with root package name */
    public boolean[] f4908kp;

    /* renamed from: lc  reason: collision with root package name */
    public int f4909lc;

    /* renamed from: m  reason: collision with root package name */
    public long f4910m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public final TextView f4911n;

    /* renamed from: nf  reason: collision with root package name */
    public boolean f4912nf;

    /* renamed from: o  reason: collision with root package name */
    public final Drawable f4913o;

    /* renamed from: o4  reason: collision with root package name */
    public boolean f4914o4;

    /* renamed from: oz  reason: collision with root package name */
    public final String f4915oz;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public final View f4916p;

    /* renamed from: q9  reason: collision with root package name */
    public final Drawable f4917q9;

    /* renamed from: qn  reason: collision with root package name */
    public final Drawable f4918qn;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public final View f4919r;

    /* renamed from: ra  reason: collision with root package name */
    public boolean f4920ra;

    /* renamed from: rb  reason: collision with root package name */
    public long[] f4921rb;

    /* renamed from: rs  reason: collision with root package name */
    public int f4922rs;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public final View f4923s;

    /* renamed from: s8  reason: collision with root package name */
    public boolean f4924s8;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public final View f4925t;

    /* renamed from: u  reason: collision with root package name */
    public final String f4926u;

    /* renamed from: u0  reason: collision with root package name */
    public long f4927u0;

    /* renamed from: ut  reason: collision with root package name */
    public final String f4928ut;

    /* renamed from: v  reason: collision with root package name */
    public final CopyOnWriteArrayList<v> f4929v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public final View f4930w;

    /* renamed from: x  reason: collision with root package name */
    public final Runnable f4931x;

    /* renamed from: xg  reason: collision with root package name */
    public boolean f4932xg;
    public final View$OnClickListenerC0055zn y;
    @Nullable

    /* renamed from: y5  reason: collision with root package name */
    public uo f4933y5;

    /* renamed from: yc  reason: collision with root package name */
    public long[] f4934yc;

    /* renamed from: yg  reason: collision with root package name */
    public long f4935yg;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public final ImageView f4936z;

    /* loaded from: classes.dex */
    public interface gv {
    }

    /* loaded from: classes.dex */
    public static final class n3 {
        public static boolean y(View view) {
            return view.isAccessibilityFocused();
        }
    }

    /* loaded from: classes.dex */
    public interface v {
        void y(int i);
    }

    /* renamed from: com.google.android.exoplayer2.ui.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class View$OnClickListenerC0055zn implements uo.gv, v.y, View.OnClickListener {
        public View$OnClickListenerC0055zn() {
        }

        @Override // com.google.android.exoplayer2.ui.v.y
        public void fb(com.google.android.exoplayer2.ui.v vVar, long j2) {
            zn.this.f4914o4 = true;
            if (zn.this.f4911n != null) {
                zn.this.f4911n.setText(j5.eb(zn.this.f4891d0, zn.this.f4901fh, j2));
            }
        }

        @Override // m1.uo.gv
        public /* synthetic */ void onAvailableCommandsChanged(uo.n3 n3Var) {
            mh.zn(this, n3Var);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            uo uoVar = zn.this.f4933y5;
            if (uoVar == null) {
                return;
            }
            if (zn.this.f4923s == view) {
                uoVar.vl();
            } else if (zn.this.f4900fb == view) {
                uoVar.f3();
            } else if (zn.this.f4930w == view) {
                if (uoVar.n3() != 4) {
                    uoVar.y4();
                }
            } else if (zn.this.f4916p == view) {
                uoVar.tg();
            } else if (zn.this.f4897f == view) {
                zn.this.rz(uoVar);
            } else if (zn.this.f4925t == view) {
                zn.this.fh(uoVar);
            } else if (zn.this.f4888co == view) {
                uoVar.gv(d.y(uoVar.c5(), zn.this.f4909lc));
            } else if (zn.this.f4936z == view) {
                uoVar.ut(!uoVar.u0());
            }
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
        public void onEvents(uo uoVar, uo.zn znVar) {
            if (znVar.n3(4, 5)) {
                zn.this.j();
            }
            if (znVar.n3(4, 5, 7)) {
                zn.this.oz();
            }
            if (znVar.y(8)) {
                zn.this.ut();
            }
            if (znVar.y(9)) {
                zn.this.q9();
            }
            if (znVar.n3(8, 9, 11, 0, 13)) {
                zn.this.o();
            }
            if (znVar.n3(11, 0)) {
                zn.this.k();
            }
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

        @Override // com.google.android.exoplayer2.ui.v.y
        public void y(com.google.android.exoplayer2.ui.v vVar, long j2) {
            if (zn.this.f4911n != null) {
                zn.this.f4911n.setText(j5.eb(zn.this.f4891d0, zn.this.f4901fh, j2));
            }
        }

        @Override // com.google.android.exoplayer2.ui.v.y
        public void zn(com.google.android.exoplayer2.ui.v vVar, long j2, boolean z2) {
            zn.this.f4914o4 = false;
            if (!z2 && zn.this.f4933y5 != null) {
                zn znVar = zn.this;
                znVar.yt(znVar.f4933y5, j2);
            }
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

    static {
        kp.y("goog.exo.ui");
    }

    public zn(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int i5 = R$layout.ba;
        this.f4922rs = 5000;
        this.f4894eb = 200;
        this.f4935yg = -9223372036854775807L;
        this.f4912nf = true;
        this.f4920ra = true;
        this.f4893e = true;
        this.f4924s8 = true;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.f4766f3, i, 0);
            try {
                this.f4922rs = obtainStyledAttributes.getInt(R$styleable.f4762d, this.f4922rs);
                i5 = obtainStyledAttributes.getResourceId(R$styleable.f4779n, i5);
                this.f4909lc = ta(obtainStyledAttributes, this.f4909lc);
                this.f4912nf = obtainStyledAttributes.getBoolean(R$styleable.f4777mg, this.f4912nf);
                this.f4920ra = obtainStyledAttributes.getBoolean(R$styleable.f4763d0, this.f4920ra);
                this.f4893e = obtainStyledAttributes.getBoolean(R$styleable.f4787rz, this.f4893e);
                this.f4924s8 = obtainStyledAttributes.getBoolean(R$styleable.f4768fh, this.f4924s8);
                this.f4885ap = obtainStyledAttributes.getBoolean(R$styleable.f4790ta, this.f4885ap);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R$styleable.f4803z6, this.f4894eb));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f4929v = new CopyOnWriteArrayList<>();
        this.f4890d = new hy.n3();
        this.f4895ej = new hy.gv();
        StringBuilder sb = new StringBuilder();
        this.f4891d0 = sb;
        this.f4901fh = new Formatter(sb, Locale.getDefault());
        this.f4934yc = new long[0];
        this.f4908kp = new boolean[0];
        this.f4921rb = new long[0];
        this.f4903g3 = new boolean[0];
        View$OnClickListenerC0055zn view$OnClickListenerC0055zn = new View$OnClickListenerC0055zn();
        this.y = view$OnClickListenerC0055zn;
        this.f4931x = new Runnable() { // from class: mn.fb
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.exoplayer2.ui.zn.this.oz();
            }
        };
        this.f4886b = new Runnable() { // from class: mn.s
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.exoplayer2.ui.zn.this.d();
            }
        };
        LayoutInflater.from(context).inflate(i5, this);
        setDescendantFocusability(262144);
        int i6 = R$id.exo_progress;
        com.google.android.exoplayer2.ui.v vVar = (com.google.android.exoplayer2.ui.v) findViewById(i6);
        View findViewById = findViewById(R$id.exo_progress_placeholder);
        if (vVar != null) {
            this.f4887c = vVar;
        } else if (findViewById != null) {
            com.google.android.exoplayer2.ui.n3 n3Var = new com.google.android.exoplayer2.ui.n3(context, null, 0, attributeSet2);
            n3Var.setId(i6);
            n3Var.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(n3Var, indexOfChild);
            this.f4887c = n3Var;
        } else {
            this.f4887c = null;
        }
        this.f4898f3 = (TextView) findViewById(R$id.exo_duration);
        this.f4911n = (TextView) findViewById(R$id.exo_position);
        com.google.android.exoplayer2.ui.v vVar2 = this.f4887c;
        if (vVar2 != null) {
            vVar2.y(view$OnClickListenerC0055zn);
        }
        View findViewById2 = findViewById(R$id.exo_play);
        this.f4897f = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(view$OnClickListenerC0055zn);
        }
        View findViewById3 = findViewById(R$id.exo_pause);
        this.f4925t = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(view$OnClickListenerC0055zn);
        }
        View findViewById4 = findViewById(R$id.exo_prev);
        this.f4900fb = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(view$OnClickListenerC0055zn);
        }
        View findViewById5 = findViewById(R$id.exo_next);
        this.f4923s = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(view$OnClickListenerC0055zn);
        }
        View findViewById6 = findViewById(R$id.exo_rew);
        this.f4916p = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(view$OnClickListenerC0055zn);
        }
        View findViewById7 = findViewById(R$id.exo_ffwd);
        this.f4930w = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(view$OnClickListenerC0055zn);
        }
        ImageView imageView = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f4888co = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(view$OnClickListenerC0055zn);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f4936z = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(view$OnClickListenerC0055zn);
        }
        View findViewById8 = findViewById(R$id.exo_vr);
        this.f4919r = findViewById8;
        setShowVrButton(false);
        qn(false, false, findViewById8);
        Resources resources = context.getResources();
        this.f4899f7 = resources.getInteger(R$integer.n3) / 100.0f;
        this.f4896en = resources.getInteger(R$integer.x) / 100.0f;
        this.f4905j5 = j5.ut(context, resources, R$drawable.iy);
        this.f4918qn = j5.ut(context, resources, R$drawable.iu);
        this.f4913o = j5.ut(context, resources, R$drawable.ij);
        this.f4917q9 = j5.ut(context, resources, R$drawable.ix);
        this.f4907k = j5.ut(context, resources, R$drawable.ih);
        this.f4904j = resources.getString(R$string.pb);
        this.f4915oz = resources.getString(R$string.pk);
        this.f4928ut = resources.getString(R$string.pa);
        this.f4906jz = resources.getString(R$string.tl);
        this.f4926u = resources.getString(R$string.ph);
        this.f4902g = -9223372036854775807L;
        this.f4927u0 = -9223372036854775807L;
    }

    public static boolean c(hy hyVar, hy.gv gvVar) {
        if (hyVar.z() > 100) {
            return false;
        }
        int z2 = hyVar.z();
        for (int i = 0; i < z2; i++) {
            if (hyVar.mt(i, gvVar).f10805c == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    @SuppressLint({"InlinedApi"})
    public static boolean ej(int i) {
        return i == 90 || i == 89 || i == 85 || i == 79 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    public static int ta(TypedArray typedArray, int i) {
        return typedArray.getInt(R$styleable.f4759c, i);
    }

    public void a8(v vVar) {
        this.f4929v.remove(vVar);
    }

    public final void b() {
        View view;
        View view2;
        boolean vl2 = vl();
        if (!vl2 && (view2 = this.f4897f) != null) {
            view2.requestFocus();
        } else if (vl2 && (view = this.f4925t) != null) {
            view.requestFocus();
        }
    }

    public void d() {
        if (ud()) {
            setVisibility(8);
            Iterator<v> it = this.f4929v.iterator();
            while (it.hasNext()) {
                it.next().y(getVisibility());
            }
            removeCallbacks(this.f4931x);
            removeCallbacks(this.f4886b);
            this.f4935yg = -9223372036854775807L;
        }
    }

    public boolean d0(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        uo uoVar = this.f4933y5;
        if (uoVar != null && ej(keyCode)) {
            if (keyEvent.getAction() == 0) {
                if (keyCode == 90) {
                    if (uoVar.n3() != 4) {
                        uoVar.y4();
                        return true;
                    }
                    return true;
                } else if (keyCode == 89) {
                    uoVar.tg();
                    return true;
                } else if (keyEvent.getRepeatCount() == 0) {
                    if (keyCode != 79 && keyCode != 85) {
                        if (keyCode != 87) {
                            if (keyCode != 88) {
                                if (keyCode != 126) {
                                    if (keyCode == 127) {
                                        fh(uoVar);
                                        return true;
                                    }
                                    return true;
                                }
                                rz(uoVar);
                                return true;
                            }
                            uoVar.f3();
                            return true;
                        }
                        uoVar.vl();
                        return true;
                    }
                    mg(uoVar);
                    return true;
                } else {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!d0(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f4886b);
        } else if (motionEvent.getAction() == 1) {
            z6();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void fh(uo uoVar) {
        uoVar.pause();
    }

    @Nullable
    public uo getPlayer() {
        return this.f4933y5;
    }

    public int getRepeatToggleModes() {
        return this.f4909lc;
    }

    public boolean getShowShuffleButton() {
        return this.f4885ap;
    }

    public int getShowTimeoutMs() {
        return this.f4922rs;
    }

    public boolean getShowVrButton() {
        View view = this.f4919r;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void hw() {
        if (!ud()) {
            setVisibility(0);
            Iterator<v> it = this.f4929v.iterator();
            while (it.hasNext()) {
                it.next().y(getVisibility());
            }
            j5();
            b();
            x();
        }
        z6();
    }

    public final void j() {
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        if (ud() && this.f4932xg) {
            boolean vl2 = vl();
            View view = this.f4897f;
            int i5 = 8;
            boolean z5 = true;
            if (view != null) {
                if (vl2 && view.isFocused()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (j5.y < 21) {
                    z3 = z2;
                } else if (vl2 && n3.y(this.f4897f)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                View view2 = this.f4897f;
                if (vl2) {
                    i = 8;
                } else {
                    i = 0;
                }
                view2.setVisibility(i);
            } else {
                z2 = false;
                z3 = false;
            }
            View view3 = this.f4925t;
            if (view3 != null) {
                if (!vl2 && view3.isFocused()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                z2 |= z4;
                if (j5.y < 21) {
                    z5 = z2;
                } else if (vl2 || !n3.y(this.f4925t)) {
                    z5 = false;
                }
                z3 |= z5;
                View view4 = this.f4925t;
                if (vl2) {
                    i5 = 0;
                }
                view4.setVisibility(i5);
            }
            if (z2) {
                b();
            }
            if (z3) {
                x();
            }
        }
    }

    public final void j5() {
        j();
        o();
        ut();
        q9();
        k();
    }

    public final void k() {
        boolean z2;
        int i;
        int i5;
        int i6;
        hy.gv gvVar;
        int length;
        uo uoVar = this.f4933y5;
        if (uoVar == null) {
            return;
        }
        boolean z3 = true;
        if (this.f4892dm && c(uoVar.b(), this.f4895ej)) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f4889ct = z2;
        long j2 = 0;
        this.f4910m = 0L;
        hy b2 = uoVar.b();
        if (!b2.r()) {
            int kp2 = uoVar.kp();
            boolean z4 = this.f4889ct;
            if (z4) {
                i5 = 0;
            } else {
                i5 = kp2;
            }
            if (z4) {
                i6 = b2.z() - 1;
            } else {
                i6 = kp2;
            }
            long j4 = 0;
            i = 0;
            while (true) {
                if (i5 > i6) {
                    break;
                }
                if (i5 == kp2) {
                    this.f4910m = j5.gf(j4);
                }
                b2.mt(i5, this.f4895ej);
                hy.gv gvVar2 = this.f4895ej;
                if (gvVar2.f10805c == -9223372036854775807L) {
                    v5.y.fb(this.f4889ct ^ z3);
                    break;
                }
                int i8 = gvVar2.f10808d0;
                while (true) {
                    gvVar = this.f4895ej;
                    if (i8 <= gvVar.f10812fh) {
                        b2.i9(i8, this.f4890d);
                        int a2 = this.f4890d.a();
                        for (int mt2 = this.f4890d.mt(); mt2 < a2; mt2++) {
                            long c52 = this.f4890d.c5(mt2);
                            if (c52 == Long.MIN_VALUE) {
                                long j6 = this.f4890d.f10829s;
                                if (j6 != -9223372036854775807L) {
                                    c52 = j6;
                                }
                            }
                            long p2 = c52 + this.f4890d.p();
                            if (p2 >= 0) {
                                long[] jArr = this.f4934yc;
                                if (i == jArr.length) {
                                    if (jArr.length == 0) {
                                        length = 1;
                                    } else {
                                        length = jArr.length * 2;
                                    }
                                    this.f4934yc = Arrays.copyOf(jArr, length);
                                    this.f4908kp = Arrays.copyOf(this.f4908kp, length);
                                }
                                this.f4934yc[i] = j5.gf(j4 + p2);
                                this.f4908kp[i] = this.f4890d.co(mt2);
                                i++;
                            }
                        }
                        i8++;
                    }
                }
                j4 += gvVar.f10805c;
                i5++;
                z3 = true;
            }
            j2 = j4;
        } else {
            i = 0;
        }
        long gf = j5.gf(j2);
        TextView textView = this.f4898f3;
        if (textView != null) {
            textView.setText(j5.eb(this.f4891d0, this.f4901fh, gf));
        }
        com.google.android.exoplayer2.ui.v vVar = this.f4887c;
        if (vVar != null) {
            vVar.setDuration(gf);
            int length2 = this.f4921rb.length;
            int i10 = i + length2;
            long[] jArr2 = this.f4934yc;
            if (i10 > jArr2.length) {
                this.f4934yc = Arrays.copyOf(jArr2, i10);
                this.f4908kp = Arrays.copyOf(this.f4908kp, i10);
            }
            System.arraycopy(this.f4921rb, 0, this.f4934yc, i, length2);
            System.arraycopy(this.f4903g3, 0, this.f4908kp, i, length2);
            this.f4887c.n3(this.f4934yc, this.f4908kp, i10);
        }
        oz();
    }

    public final void k5(uo uoVar, int i, long j2) {
        uoVar.o(i, j2);
    }

    public final void mg(uo uoVar) {
        int n32 = uoVar.n3();
        if (n32 != 1 && n32 != 4 && uoVar.oz()) {
            fh(uoVar);
        } else {
            rz(uoVar);
        }
    }

    public void n(v vVar) {
        v5.y.v(vVar);
        this.f4929v.add(vVar);
    }

    public final void o() {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        if (ud() && this.f4932xg) {
            uo uoVar = this.f4933y5;
            if (uoVar != null) {
                z2 = uoVar.z6(5);
                z4 = uoVar.z6(7);
                z5 = uoVar.z6(11);
                z7 = uoVar.z6(12);
                z3 = uoVar.z6(9);
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                z7 = false;
            }
            qn(this.f4893e, z4, this.f4900fb);
            qn(this.f4912nf, z5, this.f4916p);
            qn(this.f4920ra, z7, this.f4930w);
            qn(this.f4924s8, z3, this.f4923s);
            com.google.android.exoplayer2.ui.v vVar = this.f4887c;
            if (vVar != null) {
                vVar.setEnabled(z2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4932xg = true;
        long j2 = this.f4935yg;
        if (j2 != -9223372036854775807L) {
            long uptimeMillis = j2 - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                d();
            } else {
                postDelayed(this.f4886b, uptimeMillis);
            }
        } else if (ud()) {
            z6();
        }
        j5();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4932xg = false;
        removeCallbacks(this.f4931x);
        removeCallbacks(this.f4886b);
    }

    public final void oz() {
        long j2;
        long j4;
        boolean z2;
        int n32;
        long j6;
        if (ud() && this.f4932xg) {
            uo uoVar = this.f4933y5;
            if (uoVar != null) {
                j2 = this.f4910m + uoVar.ra();
                j4 = this.f4910m + uoVar.bk();
            } else {
                j2 = 0;
                j4 = 0;
            }
            if (j2 != this.f4902g) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f4902g = j2;
            this.f4927u0 = j4;
            TextView textView = this.f4911n;
            if (textView != null && !this.f4914o4 && z2) {
                textView.setText(j5.eb(this.f4891d0, this.f4901fh, j2));
            }
            com.google.android.exoplayer2.ui.v vVar = this.f4887c;
            if (vVar != null) {
                vVar.setPosition(j2);
                this.f4887c.setBufferedPosition(j4);
            }
            removeCallbacks(this.f4931x);
            if (uoVar == null) {
                n32 = 1;
            } else {
                n32 = uoVar.n3();
            }
            long j7 = 1000;
            if (uoVar != null && uoVar.isPlaying()) {
                com.google.android.exoplayer2.ui.v vVar2 = this.f4887c;
                if (vVar2 != null) {
                    j6 = vVar2.getPreferredUpdateDelay();
                } else {
                    j6 = 1000;
                }
                long min = Math.min(j6, 1000 - (j2 % 1000));
                float f4 = uoVar.v().y;
                if (f4 > 0.0f) {
                    j7 = ((float) min) / f4;
                }
                postDelayed(this.f4931x, j5.mt(j7, this.f4894eb, 1000L));
            } else if (n32 != 4 && n32 != 1) {
                postDelayed(this.f4931x, 1000L);
            }
        }
    }

    public final void q9() {
        ImageView imageView;
        Drawable drawable;
        String str;
        if (ud() && this.f4932xg && (imageView = this.f4936z) != null) {
            uo uoVar = this.f4933y5;
            if (!this.f4885ap) {
                qn(false, false, imageView);
            } else if (uoVar == null) {
                qn(true, false, imageView);
                this.f4936z.setImageDrawable(this.f4907k);
                this.f4936z.setContentDescription(this.f4926u);
            } else {
                qn(true, true, imageView);
                ImageView imageView2 = this.f4936z;
                if (uoVar.u0()) {
                    drawable = this.f4917q9;
                } else {
                    drawable = this.f4907k;
                }
                imageView2.setImageDrawable(drawable);
                ImageView imageView3 = this.f4936z;
                if (uoVar.u0()) {
                    str = this.f4906jz;
                } else {
                    str = this.f4926u;
                }
                imageView3.setContentDescription(str);
            }
        }
    }

    public final void qn(boolean z2, boolean z3, @Nullable View view) {
        float f4;
        int i;
        if (view == null) {
            return;
        }
        view.setEnabled(z3);
        if (z3) {
            f4 = this.f4899f7;
        } else {
            f4 = this.f4896en;
        }
        view.setAlpha(f4);
        if (z2) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
    }

    public final void rz(uo uoVar) {
        int n32 = uoVar.n3();
        if (n32 == 1) {
            uoVar.prepare();
        } else if (n32 == 4) {
            k5(uoVar, uoVar.kp(), -9223372036854775807L);
        }
        uoVar.play();
    }

    public void setPlayer(@Nullable uo uoVar) {
        boolean z2;
        boolean z3 = false;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        v5.y.y((uoVar == null || uoVar.k5() == Looper.getMainLooper()) ? true : true);
        uo uoVar2 = this.f4933y5;
        if (uoVar2 == uoVar) {
            return;
        }
        if (uoVar2 != null) {
            uoVar2.e(this.y);
        }
        this.f4933y5 = uoVar;
        if (uoVar != null) {
            uoVar.g(this.y);
        }
        j5();
    }

    public void setProgressUpdateListener(@Nullable gv gvVar) {
    }

    public void setRepeatToggleModes(int i) {
        this.f4909lc = i;
        uo uoVar = this.f4933y5;
        if (uoVar != null) {
            int c52 = uoVar.c5();
            if (i == 0 && c52 != 0) {
                this.f4933y5.gv(0);
            } else if (i == 1 && c52 == 2) {
                this.f4933y5.gv(1);
            } else if (i == 2 && c52 == 1) {
                this.f4933y5.gv(2);
            }
        }
        ut();
    }

    public void setShowFastForwardButton(boolean z2) {
        this.f4920ra = z2;
        o();
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        this.f4892dm = z2;
        k();
    }

    public void setShowNextButton(boolean z2) {
        this.f4924s8 = z2;
        o();
    }

    public void setShowPreviousButton(boolean z2) {
        this.f4893e = z2;
        o();
    }

    public void setShowRewindButton(boolean z2) {
        this.f4912nf = z2;
        o();
    }

    public void setShowShuffleButton(boolean z2) {
        this.f4885ap = z2;
        q9();
    }

    public void setShowTimeoutMs(int i) {
        this.f4922rs = i;
        if (ud()) {
            z6();
        }
    }

    public void setShowVrButton(boolean z2) {
        int i;
        View view = this.f4919r;
        if (view != null) {
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.f4894eb = j5.p(i, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        boolean z2;
        View view = this.f4919r;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            boolean showVrButton = getShowVrButton();
            if (onClickListener != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            qn(showVrButton, z2, this.f4919r);
        }
    }

    public boolean ud() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void ut() {
        ImageView imageView;
        if (ud() && this.f4932xg && (imageView = this.f4888co) != null) {
            if (this.f4909lc == 0) {
                qn(false, false, imageView);
                return;
            }
            uo uoVar = this.f4933y5;
            if (uoVar == null) {
                qn(true, false, imageView);
                this.f4888co.setImageDrawable(this.f4905j5);
                this.f4888co.setContentDescription(this.f4904j);
                return;
            }
            qn(true, true, imageView);
            int c52 = uoVar.c5();
            if (c52 != 0) {
                if (c52 != 1) {
                    if (c52 == 2) {
                        this.f4888co.setImageDrawable(this.f4913o);
                        this.f4888co.setContentDescription(this.f4928ut);
                    }
                } else {
                    this.f4888co.setImageDrawable(this.f4918qn);
                    this.f4888co.setContentDescription(this.f4915oz);
                }
            } else {
                this.f4888co.setImageDrawable(this.f4905j5);
                this.f4888co.setContentDescription(this.f4904j);
            }
            this.f4888co.setVisibility(0);
        }
    }

    public final boolean vl() {
        uo uoVar = this.f4933y5;
        if (uoVar != null && uoVar.n3() != 4 && this.f4933y5.n3() != 1 && this.f4933y5.oz()) {
            return true;
        }
        return false;
    }

    public final void x() {
        View view;
        View view2;
        boolean vl2 = vl();
        if (!vl2 && (view2 = this.f4897f) != null) {
            view2.sendAccessibilityEvent(8);
        } else if (vl2 && (view = this.f4925t) != null) {
            view.sendAccessibilityEvent(8);
        }
    }

    public final void yt(uo uoVar, long j2) {
        int kp2;
        hy b2 = uoVar.b();
        if (this.f4889ct && !b2.r()) {
            int z2 = b2.z();
            kp2 = 0;
            while (true) {
                long a2 = b2.mt(kp2, this.f4895ej).a();
                if (j2 < a2) {
                    break;
                } else if (kp2 == z2 - 1) {
                    j2 = a2;
                    break;
                } else {
                    j2 -= a2;
                    kp2++;
                }
            }
        } else {
            kp2 = uoVar.kp();
        }
        k5(uoVar, kp2, j2);
        oz();
    }

    public final void z6() {
        removeCallbacks(this.f4886b);
        if (this.f4922rs > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = this.f4922rs;
            this.f4935yg = uptimeMillis + i;
            if (this.f4932xg) {
                postDelayed(this.f4886b, i);
                return;
            }
            return;
        }
        this.f4935yg = -9223372036854775807L;
    }
}
