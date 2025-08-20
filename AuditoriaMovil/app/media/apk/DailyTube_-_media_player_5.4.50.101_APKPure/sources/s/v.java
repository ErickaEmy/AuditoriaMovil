package s;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.c5;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.v;
import d.s;
import hw.a;
import hw.d;
import hw.ej;
import hw.mg;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import t.a;
import t.n3;
import wz.hw;
import wz.i4;
import wz.j;
import wz.oz;
/* loaded from: classes.dex */
public class v extends s.gv implements v.y, LayoutInflater.Factory2 {

    /* renamed from: ap  reason: collision with root package name */
    public xc f13412ap;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13413b;

    /* renamed from: c  reason: collision with root package name */
    public z f13414c;

    /* renamed from: co  reason: collision with root package name */
    public s.y f13415co;

    /* renamed from: ct  reason: collision with root package name */
    public boolean f13416ct;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f13417d;

    /* renamed from: d0  reason: collision with root package name */
    public t.n3 f13418d0;

    /* renamed from: dm  reason: collision with root package name */
    public boolean f13419dm;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13420e;

    /* renamed from: eb  reason: collision with root package name */
    public boolean f13421eb;

    /* renamed from: ej  reason: collision with root package name */
    public Runnable f13422ej;

    /* renamed from: en  reason: collision with root package name */
    public boolean f13423en;

    /* renamed from: f  reason: collision with root package name */
    public final Context f13424f;

    /* renamed from: f3  reason: collision with root package name */
    public i4 f13425f3;

    /* renamed from: f7  reason: collision with root package name */
    public boolean f13426f7;

    /* renamed from: fh  reason: collision with root package name */
    public ActionBarContextView f13427fh;

    /* renamed from: g  reason: collision with root package name */
    public s.s f13428g;

    /* renamed from: g3  reason: collision with root package name */
    public Rect f13429g3;

    /* renamed from: j  reason: collision with root package name */
    public View f13430j;

    /* renamed from: j5  reason: collision with root package name */
    public boolean f13431j5;

    /* renamed from: jz  reason: collision with root package name */
    public boolean f13432jz;

    /* renamed from: k  reason: collision with root package name */
    public boolean f13433k;

    /* renamed from: kp  reason: collision with root package name */
    public final Runnable f13434kp;

    /* renamed from: lc  reason: collision with root package name */
    public int f13435lc;

    /* renamed from: m  reason: collision with root package name */
    public Rect f13436m;

    /* renamed from: n  reason: collision with root package name */
    public fb f13437n;

    /* renamed from: nf  reason: collision with root package name */
    public int f13438nf;

    /* renamed from: o  reason: collision with root package name */
    public TextView f13439o;

    /* renamed from: o4  reason: collision with root package name */
    public boolean f13440o4;

    /* renamed from: oz  reason: collision with root package name */
    public boolean f13441oz;

    /* renamed from: p  reason: collision with root package name */
    public final s.zn f13442p;

    /* renamed from: q9  reason: collision with root package name */
    public boolean f13443q9;

    /* renamed from: qn  reason: collision with root package name */
    public ViewGroup f13444qn;

    /* renamed from: r  reason: collision with root package name */
    public CharSequence f13445r;

    /* renamed from: ra  reason: collision with root package name */
    public boolean f13446ra;

    /* renamed from: rb  reason: collision with root package name */
    public boolean f13447rb;

    /* renamed from: rs  reason: collision with root package name */
    public boolean f13448rs;

    /* renamed from: s  reason: collision with root package name */
    public final Object f13449s;

    /* renamed from: s8  reason: collision with root package name */
    public xc f13450s8;

    /* renamed from: t  reason: collision with root package name */
    public Window f13451t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f13452u;

    /* renamed from: u0  reason: collision with root package name */
    public s.c5 f13453u0;

    /* renamed from: ut  reason: collision with root package name */
    public boolean f13454ut;

    /* renamed from: w  reason: collision with root package name */
    public tl f13455w;

    /* renamed from: x  reason: collision with root package name */
    public mg f13456x;

    /* renamed from: xg  reason: collision with root package name */
    public co f13457xg;

    /* renamed from: y5  reason: collision with root package name */
    public co[] f13458y5;

    /* renamed from: yc  reason: collision with root package name */
    public int f13459yc;

    /* renamed from: yg  reason: collision with root package name */
    public boolean f13460yg;

    /* renamed from: z  reason: collision with root package name */
    public MenuInflater f13461z;

    /* renamed from: bk  reason: collision with root package name */
    public static final z.s<String, Integer> f13407bk = new z.s<>();

    /* renamed from: y4  reason: collision with root package name */
    public static final boolean f13411y4 = false;

    /* renamed from: tg  reason: collision with root package name */
    public static final int[] f13410tg = {16842836};

    /* renamed from: pz  reason: collision with root package name */
    public static final boolean f13409pz = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: pq  reason: collision with root package name */
    public static final boolean f13408pq = true;

    /* loaded from: classes.dex */
    public class a implements s.n3 {
        public a() {
        }
    }

    /* loaded from: classes.dex */
    public static class c5 {
        public static void n3(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            int i = configuration.densityDpi;
            int i5 = configuration2.densityDpi;
            if (i != i5) {
                configuration3.densityDpi = i5;
            }
        }

        public static Context y(@NonNull Context context, @NonNull Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }
    }

    /* loaded from: classes.dex */
    public static final class co {

        /* renamed from: a  reason: collision with root package name */
        public int f13462a;

        /* renamed from: c5  reason: collision with root package name */
        public View f13463c5;

        /* renamed from: co  reason: collision with root package name */
        public Bundle f13464co;

        /* renamed from: f  reason: collision with root package name */
        public androidx.appcompat.view.menu.zn f13465f;

        /* renamed from: fb  reason: collision with root package name */
        public ViewGroup f13466fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f13467gv;

        /* renamed from: i9  reason: collision with root package name */
        public androidx.appcompat.view.menu.v f13468i9;

        /* renamed from: mt  reason: collision with root package name */
        public boolean f13469mt;

        /* renamed from: n3  reason: collision with root package name */
        public int f13470n3;

        /* renamed from: p  reason: collision with root package name */
        public boolean f13471p;

        /* renamed from: s  reason: collision with root package name */
        public View f13472s;

        /* renamed from: t  reason: collision with root package name */
        public Context f13473t;

        /* renamed from: tl  reason: collision with root package name */
        public boolean f13474tl;

        /* renamed from: v  reason: collision with root package name */
        public int f13475v;

        /* renamed from: w  reason: collision with root package name */
        public boolean f13476w;

        /* renamed from: wz  reason: collision with root package name */
        public boolean f13477wz;

        /* renamed from: xc  reason: collision with root package name */
        public boolean f13478xc;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f13479zn;

        public co(int i) {
            this.y = i;
        }

        public void gv(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R$attr.y, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(R$attr.f651ta, typedValue, true);
            int i5 = typedValue.resourceId;
            if (i5 != 0) {
                newTheme.applyStyle(i5, true);
            } else {
                newTheme.applyStyle(R$style.f804n3, true);
            }
            t.gv gvVar = new t.gv(context, 0);
            gvVar.getTheme().setTo(newTheme);
            this.f13473t = gvVar;
            TypedArray obtainStyledAttributes = gvVar.obtainStyledAttributes(R$styleable.f899tg);
            this.f13470n3 = obtainStyledAttributes.getResourceId(R$styleable.f818cr, 0);
            this.f13462a = obtainStyledAttributes.getResourceId(R$styleable.f881pq, 0);
            obtainStyledAttributes.recycle();
        }

        public boolean n3() {
            if (this.f13472s == null) {
                return false;
            }
            if (this.f13463c5 == null && this.f13465f.y().getCount() <= 0) {
                return false;
            }
            return true;
        }

        public androidx.appcompat.view.menu.i9 y(c5.y yVar) {
            if (this.f13468i9 == null) {
                return null;
            }
            if (this.f13465f == null) {
                androidx.appcompat.view.menu.zn znVar = new androidx.appcompat.view.menu.zn(this.f13473t, R$layout.f777i9);
                this.f13465f = znVar;
                znVar.gv(yVar);
                this.f13468i9.n3(this.f13465f);
            }
            return this.f13465f.i9(this.f13466fb);
        }

        public void zn(androidx.appcompat.view.menu.v vVar) {
            androidx.appcompat.view.menu.zn znVar;
            androidx.appcompat.view.menu.v vVar2 = this.f13468i9;
            if (vVar == vVar2) {
                return;
            }
            if (vVar2 != null) {
                vVar2.vl(this.f13465f);
            }
            this.f13468i9 = vVar;
            if (vVar != null && (znVar = this.f13465f) != null) {
                vVar.n3(znVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public static void y(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class fb implements c5.y {
        public fb() {
        }

        @Override // androidx.appcompat.view.menu.c5.y
        public void n3(@NonNull androidx.appcompat.view.menu.v vVar, boolean z2) {
            v.this.hw(vVar);
        }

        @Override // androidx.appcompat.view.menu.c5.y
        public boolean zn(@NonNull androidx.appcompat.view.menu.v vVar) {
            Window.Callback eb2 = v.this.eb();
            if (eb2 != null) {
                eb2.onMenuOpened(108, vVar);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class gv implements Runnable {

        /* loaded from: classes.dex */
        public class y extends d {
            public y() {
            }

            @Override // hw.ta
            public void n3(View view) {
                v.this.f13427fh.setAlpha(1.0f);
                v.this.f13456x.s(null);
                v.this.f13456x = null;
            }

            @Override // hw.d, hw.ta
            public void zn(View view) {
                v.this.f13427fh.setVisibility(0);
            }
        }

        public gv() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v vVar = v.this;
            vVar.f13417d.showAtLocation(vVar.f13427fh, 55, 0, 0);
            v.this.f7();
            if (v.this.ad()) {
                v.this.f13427fh.setAlpha(0.0f);
                v vVar2 = v.this;
                vVar2.f13456x = hw.i4.v(vVar2.f13427fh).n3(1.0f);
                v.this.f13456x.s(new y());
                return;
            }
            v.this.f13427fh.setAlpha(1.0f);
            v.this.f13427fh.setVisibility(0);
        }
    }

    /* loaded from: classes.dex */
    public static class i9 {
        public static boolean y(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    /* loaded from: classes.dex */
    public class mt extends ContentFrameLayout {
        public mt(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!v.this.q9(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                return false;
            }
            return true;
        }

        public final boolean n3(int i, int i5) {
            if (i >= -5 && i5 >= -5 && i <= getWidth() + 5 && i5 <= getHeight() + 5) {
                return false;
            }
            return true;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && n3((int) motionEvent.getX(), (int) motionEvent.getY())) {
                v.this.qn(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(c5.y.gv(getContext(), i));
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements hw.w {
        public n3() {
        }

        @Override // hw.w
        public ej y(View view, ej ejVar) {
            int tl2 = ejVar.tl();
            int oa2 = v.this.oa(ejVar, null);
            if (tl2 != oa2) {
                ejVar = ejVar.p(ejVar.f(), oa2, ejVar.t(), ejVar.i9());
            }
            return hw.i4.dm(view, ejVar);
        }
    }

    /* loaded from: classes.dex */
    public static class p {
        public static void y(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* loaded from: classes.dex */
    public class s implements n3.y {
        public n3.y y;

        /* loaded from: classes.dex */
        public class y extends d {
            public y() {
            }

            @Override // hw.ta
            public void n3(View view) {
                v.this.f13427fh.setVisibility(8);
                v vVar = v.this;
                PopupWindow popupWindow = vVar.f13417d;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (vVar.f13427fh.getParent() instanceof View) {
                    hw.i4.yg((View) v.this.f13427fh.getParent());
                }
                v.this.f13427fh.f();
                v.this.f13456x.s(null);
                v vVar2 = v.this;
                vVar2.f13456x = null;
                hw.i4.yg(vVar2.f13444qn);
            }
        }

        public s(n3.y yVar) {
            this.y = yVar;
        }

        @Override // t.n3.y
        public boolean gv(t.n3 n3Var, MenuItem menuItem) {
            return this.y.gv(n3Var, menuItem);
        }

        @Override // t.n3.y
        public boolean n3(t.n3 n3Var, Menu menu) {
            return this.y.n3(n3Var, menu);
        }

        @Override // t.n3.y
        public boolean y(t.n3 n3Var, Menu menu) {
            hw.i4.yg(v.this.f13444qn);
            return this.y.y(n3Var, menu);
        }

        @Override // t.n3.y
        public void zn(t.n3 n3Var) {
            this.y.zn(n3Var);
            v vVar = v.this;
            if (vVar.f13417d != null) {
                vVar.f13451t.getDecorView().removeCallbacks(v.this.f13422ej);
            }
            v vVar2 = v.this;
            if (vVar2.f13427fh != null) {
                vVar2.f7();
                v vVar3 = v.this;
                vVar3.f13456x = hw.i4.v(vVar3.f13427fh).n3(0.0f);
                v.this.f13456x.s(new y());
            }
            v vVar4 = v.this;
            s.zn znVar = vVar4.f13442p;
            if (znVar != null) {
                znVar.onSupportActionModeFinished(vVar4.f13418d0);
            }
            v vVar5 = v.this;
            vVar5.f13418d0 = null;
            hw.i4.yg(vVar5.f13444qn);
        }
    }

    /* loaded from: classes.dex */
    public static class t {
        public static void y(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            int i = configuration.colorMode & 3;
            int i5 = configuration2.colorMode;
            if (i != (i5 & 3)) {
                configuration3.colorMode |= i5 & 3;
            }
            int i6 = configuration.colorMode & 12;
            int i8 = configuration2.colorMode;
            if (i6 != (i8 & 12)) {
                configuration3.colorMode |= i8 & 12;
            }
        }
    }

    /* renamed from: s.v$v  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0210v extends d {
        public C0210v() {
        }

        @Override // hw.ta
        public void n3(View view) {
            v.this.f13427fh.setAlpha(1.0f);
            v.this.f13456x.s(null);
            v.this.f13456x = null;
        }

        @Override // hw.d, hw.ta
        public void zn(View view) {
            v.this.f13427fh.setVisibility(0);
            v.this.f13427fh.sendAccessibilityEvent(32);
            if (v.this.f13427fh.getParent() instanceof View) {
                hw.i4.yg((View) v.this.f13427fh.getParent());
            }
        }
    }

    /* loaded from: classes.dex */
    public class w extends xc {

        /* renamed from: zn  reason: collision with root package name */
        public final s.tl f13483zn;

        public w(@NonNull s.tl tlVar) {
            super();
            this.f13483zn = tlVar;
        }

        @Override // s.v.xc
        public void gv() {
            v.this.a8();
        }

        @Override // s.v.xc
        public IntentFilter n3() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // s.v.xc
        public int zn() {
            if (this.f13483zn.gv()) {
                return 2;
            }
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public class wz extends xc {

        /* renamed from: zn  reason: collision with root package name */
        public final PowerManager f13485zn;

        public wz(@NonNull Context context) {
            super();
            this.f13485zn = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // s.v.xc
        public void gv() {
            v.this.a8();
        }

        @Override // s.v.xc
        public IntentFilter n3() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // s.v.xc
        public int zn() {
            if (i9.y(this.f13485zn)) {
                return 2;
            }
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public abstract class xc {
        public BroadcastReceiver y;

        /* loaded from: classes.dex */
        public class y extends BroadcastReceiver {
            public y() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                xc.this.gv();
            }
        }

        public xc() {
        }

        public abstract void gv();

        @Nullable
        public abstract IntentFilter n3();

        public void v() {
            y();
            IntentFilter n32 = n3();
            if (n32 != null && n32.countActions() != 0) {
                if (this.y == null) {
                    this.y = new y();
                }
                v.this.f13424f.registerReceiver(this.y, n32);
            }
        }

        public void y() {
            BroadcastReceiver broadcastReceiver = this.y;
            if (broadcastReceiver != null) {
                try {
                    v.this.f13424f.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.y = null;
            }
        }

        public abstract int zn();
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v vVar = v.this;
            if ((vVar.f13459yc & 1) != 0) {
                vVar.k(0);
            }
            v vVar2 = v.this;
            if ((vVar2.f13459yc & 4096) != 0) {
                vVar2.k(108);
            }
            v vVar3 = v.this;
            vVar3.f13460yg = false;
            vVar3.f13459yc = 0;
        }
    }

    /* loaded from: classes.dex */
    public final class z implements c5.y {
        public z() {
        }

        @Override // androidx.appcompat.view.menu.c5.y
        public void n3(@NonNull androidx.appcompat.view.menu.v vVar, boolean z2) {
            boolean z3;
            androidx.appcompat.view.menu.v mg2 = vVar.mg();
            if (mg2 != vVar) {
                z3 = true;
            } else {
                z3 = false;
            }
            v vVar2 = v.this;
            if (z3) {
                vVar = mg2;
            }
            co u2 = vVar2.u(vVar);
            if (u2 != null) {
                if (z3) {
                    v.this.vl(u2.y, u2, mg2);
                    v.this.o(u2, true);
                    return;
                }
                v.this.o(u2, z2);
            }
        }

        @Override // androidx.appcompat.view.menu.c5.y
        public boolean zn(@NonNull androidx.appcompat.view.menu.v vVar) {
            Window.Callback eb2;
            if (vVar == vVar.mg()) {
                v vVar2 = v.this;
                if (vVar2.f13443q9 && (eb2 = vVar2.eb()) != null && !v.this.f13421eb) {
                    eb2.onMenuOpened(108, vVar);
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    public v(Activity activity, s.zn znVar) {
        this(activity, null, znVar, activity);
    }

    @NonNull
    public static Configuration y5(@NonNull Configuration configuration, @Nullable Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f4 = configuration.fontScale;
            float f6 = configuration2.fontScale;
            if (f4 != f6) {
                configuration3.fontScale = f6;
            }
            int i = configuration.mcc;
            int i5 = configuration2.mcc;
            if (i != i5) {
                configuration3.mcc = i5;
            }
            int i6 = configuration.mnc;
            int i8 = configuration2.mnc;
            if (i6 != i8) {
                configuration3.mnc = i8;
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                f.y(configuration, configuration2, configuration3);
            } else if (!vl.zn.y(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i11 = configuration.touchscreen;
            int i12 = configuration2.touchscreen;
            if (i11 != i12) {
                configuration3.touchscreen = i12;
            }
            int i13 = configuration.keyboard;
            int i14 = configuration2.keyboard;
            if (i13 != i14) {
                configuration3.keyboard = i14;
            }
            int i15 = configuration.keyboardHidden;
            int i16 = configuration2.keyboardHidden;
            if (i15 != i16) {
                configuration3.keyboardHidden = i16;
            }
            int i17 = configuration.navigation;
            int i18 = configuration2.navigation;
            if (i17 != i18) {
                configuration3.navigation = i18;
            }
            int i19 = configuration.navigationHidden;
            int i20 = configuration2.navigationHidden;
            if (i19 != i20) {
                configuration3.navigationHidden = i20;
            }
            int i21 = configuration.orientation;
            int i22 = configuration2.orientation;
            if (i21 != i22) {
                configuration3.orientation = i22;
            }
            int i23 = configuration.screenLayout & 15;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 15)) {
                configuration3.screenLayout |= i24 & 15;
            }
            int i25 = configuration.screenLayout & 192;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 192)) {
                configuration3.screenLayout |= i26 & 192;
            }
            int i27 = configuration.screenLayout & 48;
            int i28 = configuration2.screenLayout;
            if (i27 != (i28 & 48)) {
                configuration3.screenLayout |= i28 & 48;
            }
            int i29 = configuration.screenLayout & 768;
            int i30 = configuration2.screenLayout;
            if (i29 != (i30 & 768)) {
                configuration3.screenLayout |= i30 & 768;
            }
            if (i10 >= 26) {
                t.y(configuration, configuration2, configuration3);
            }
            int i31 = configuration.uiMode & 15;
            int i32 = configuration2.uiMode;
            if (i31 != (i32 & 15)) {
                configuration3.uiMode |= i32 & 15;
            }
            int i33 = configuration.uiMode & 48;
            int i34 = configuration2.uiMode;
            if (i33 != (i34 & 48)) {
                configuration3.uiMode |= i34 & 48;
            }
            int i35 = configuration.screenWidthDp;
            int i36 = configuration2.screenWidthDp;
            if (i35 != i36) {
                configuration3.screenWidthDp = i36;
            }
            int i37 = configuration.screenHeightDp;
            int i38 = configuration2.screenHeightDp;
            if (i37 != i38) {
                configuration3.screenHeightDp = i38;
            }
            int i39 = configuration.smallestScreenWidthDp;
            int i40 = configuration2.smallestScreenWidthDp;
            if (i39 != i40) {
                configuration3.smallestScreenWidthDp = i40;
            }
            c5.n3(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    @Override // s.gv
    @NonNull
    public Context a(@NonNull Context context) {
        this.f13416ct = true;
        int yc2 = yc(context, yt());
        Configuration configuration = null;
        if (f13408pq && (context instanceof ContextThemeWrapper)) {
            try {
                p.y((ContextThemeWrapper) context, j(context, yc2, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof t.gv) {
            try {
                ((t.gv) context).y(j(context, yc2, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f13409pz) {
            return super.a(context);
        }
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = 0.0f;
        Configuration configuration3 = c5.y(context, configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = y5(configuration3, configuration4);
        }
        Configuration j2 = j(context, yc2, configuration);
        t.gv gvVar = new t.gv(context, R$style.f805zn);
        gvVar.y(j2);
        try {
            if (context.getTheme() != null) {
                s.a.y(gvVar.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.a(gvVar);
    }

    public boolean a8() {
        return x(true);
    }

    public final boolean ad() {
        ViewGroup viewGroup;
        if (this.f13431j5 && (viewGroup = this.f13444qn) != null && hw.i4.q9(viewGroup)) {
            return true;
        }
        return false;
    }

    public final boolean ap() {
        int i;
        boolean z2;
        if (!this.f13420e && (this.f13449s instanceof Activity)) {
            PackageManager packageManager = this.f13424f.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 29) {
                    i = 269221888;
                } else if (i5 >= 24) {
                    i = 786432;
                } else {
                    i = 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f13424f, this.f13449s.getClass()), i);
                if (activityInfo != null && (activityInfo.configChanges & 512) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f13446ra = z2;
            } catch (PackageManager.NameNotFoundException unused) {
                this.f13446ra = false;
            }
        }
        this.f13420e = true;
        return this.f13446ra;
    }

    public final void b() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f13444qn.findViewById(16908290);
        View decorView = this.f13451t.getDecorView();
        contentFrameLayout.y(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f13424f.obtainStyledAttributes(R$styleable.f899tg);
        obtainStyledAttributes.getValue(R$styleable.f843gq, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R$styleable.f910vp, contentFrameLayout.getMinWidthMinor());
        int i = R$styleable.f886qj;
        if (obtainStyledAttributes.hasValue(i)) {
            obtainStyledAttributes.getValue(i, contentFrameLayout.getFixedWidthMajor());
        }
        int i5 = R$styleable.f859l;
        if (obtainStyledAttributes.hasValue(i5)) {
            obtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedWidthMinor());
        }
        int i6 = R$styleable.f821cy;
        if (obtainStyledAttributes.hasValue(i6)) {
            obtainStyledAttributes.getValue(i6, contentFrameLayout.getFixedHeightMajor());
        }
        int i8 = R$styleable.f887qk;
        if (obtainStyledAttributes.hasValue(i8)) {
            obtainStyledAttributes.getValue(i8, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public void bk(int i) {
        s.y xc2;
        if (i == 108 && (xc2 = xc()) != null) {
            xc2.s(true);
        }
    }

    @Override // s.gv
    public View c5(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        boolean z2;
        if (this.f13428g == null) {
            String string = this.f13424f.obtainStyledAttributes(R$styleable.f899tg).getString(R$styleable.f876o0);
            if (string == null) {
                this.f13428g = new s.s();
            } else {
                try {
                    this.f13428g = (s.s) Class.forName(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable unused) {
                    this.f13428g = new s.s();
                }
            }
        }
        boolean z3 = f13411y4;
        boolean z4 = false;
        if (z3) {
            if (this.f13453u0 == null) {
                this.f13453u0 = new s.c5();
            }
            if (this.f13453u0.y(attributeSet)) {
                z2 = true;
            } else {
                if (attributeSet instanceof XmlPullParser) {
                    if (((XmlPullParser) attributeSet).getDepth() > 1) {
                        z4 = true;
                    }
                } else {
                    z4 = cy((ViewParent) view);
                }
                z2 = z4;
            }
        } else {
            z2 = false;
        }
        return this.f13428g.p(view, str, context, attributeSet, z2, z3, true, j.n3());
    }

    @Override // s.gv
    public void co(Bundle bundle) {
        String str;
        this.f13416ct = true;
        x(false);
        jz();
        Object obj = this.f13449s;
        if (obj instanceof Activity) {
            try {
                str = rz.s.zn((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                s.y pq2 = pq();
                if (pq2 == null) {
                    this.f13447rb = true;
                } else {
                    pq2.p(true);
                }
            }
            s.gv.zn(this);
        }
        this.f13440o4 = true;
    }

    public final boolean cr(co coVar, int i, KeyEvent keyEvent, int i5) {
        androidx.appcompat.view.menu.v vVar;
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((coVar.f13474tl || o0(coVar, keyEvent)) && (vVar = coVar.f13468i9) != null) {
            z2 = vVar.performShortcut(i, keyEvent, i5);
        }
        if (z2 && (i5 & 1) == 0 && this.f13425f3 == null) {
            o(coVar, true);
        }
        return z2;
    }

    public final xc ct(@NonNull Context context) {
        if (this.f13450s8 == null) {
            this.f13450s8 = new w(s.tl.y(context));
        }
        return this.f13450s8;
    }

    public final boolean cy(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f13451t.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || hw.i4.ut((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    @Override // s.gv
    public void d(Toolbar toolbar) {
        if (!(this.f13449s instanceof Activity)) {
            return;
        }
        s.y xc2 = xc();
        if (!(xc2 instanceof s.wz)) {
            this.f13461z = null;
            if (xc2 != null) {
                xc2.tl();
            }
            if (toolbar != null) {
                s.f fVar = new s.f(toolbar, rs(), this.f13455w);
                this.f13415co = fVar;
                this.f13451t.setCallback(fVar.n());
            } else {
                this.f13415co = null;
                this.f13451t.setCallback(this.f13455w);
            }
            p();
            return;
        }
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    public final xc dm(@NonNull Context context) {
        if (this.f13412ap == null) {
            this.f13412ap = new wz(context);
        }
        return this.f13412ap;
    }

    public final boolean e(co coVar) {
        Resources.Theme theme;
        Context context = this.f13424f;
        int i = coVar.y;
        if ((i == 0 || i == 108) && this.f13425f3 != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(R$attr.f625a, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(R$attr.f636fb, typedValue, true);
            } else {
                theme2.resolveAttribute(R$attr.f636fb, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                t.gv gvVar = new t.gv(context, 0);
                gvVar.getTheme().setTo(theme);
                context = gvVar;
            }
        }
        androidx.appcompat.view.menu.v vVar = new androidx.appcompat.view.menu.v(context);
        vVar.qn(this);
        coVar.zn(vVar);
        return true;
    }

    public final Window.Callback eb() {
        return this.f13451t.getCallback();
    }

    @Override // s.gv
    public final void ej(CharSequence charSequence) {
        this.f13445r = charSequence;
        i4 i4Var = this.f13425f3;
        if (i4Var != null) {
            i4Var.setWindowTitle(charSequence);
        } else if (pq() != null) {
            pq().x4(charSequence);
        } else {
            TextView textView = this.f13439o;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public final void en() {
        if (!this.f13431j5) {
            this.f13444qn = oz();
            CharSequence rs2 = rs();
            if (!TextUtils.isEmpty(rs2)) {
                i4 i4Var = this.f13425f3;
                if (i4Var != null) {
                    i4Var.setWindowTitle(rs2);
                } else if (pq() != null) {
                    pq().x4(rs2);
                } else {
                    TextView textView = this.f13439o;
                    if (textView != null) {
                        textView.setText(rs2);
                    }
                }
            }
            b();
            tg(this.f13444qn);
            this.f13431j5 = true;
            co o42 = o4(0, false);
            if (!this.f13421eb) {
                if (o42 == null || o42.f13468i9 == null) {
                    s8(108);
                }
            }
        }
    }

    @Override // s.gv
    public void f3() {
        this.f13448rs = true;
        a8();
    }

    public void f7() {
        mg mgVar = this.f13456x;
        if (mgVar != null) {
            mgVar.zn();
        }
    }

    @Override // s.gv
    public boolean fh(int i) {
        int wf2 = wf(i);
        if (this.f13432jz && wf2 == 108) {
            return false;
        }
        if (this.f13443q9 && wf2 == 1) {
            this.f13443q9 = false;
        }
        if (wf2 != 1) {
            if (wf2 != 2) {
                if (wf2 != 5) {
                    if (wf2 != 10) {
                        if (wf2 != 108) {
                            if (wf2 != 109) {
                                return this.f13451t.requestFeature(wf2);
                            }
                            qj();
                            this.f13433k = true;
                            return true;
                        }
                        qj();
                        this.f13443q9 = true;
                        return true;
                    }
                    qj();
                    this.f13426f7 = true;
                    return true;
                }
                qj();
                this.f13454ut = true;
                return true;
            }
            qj();
            this.f13441oz = true;
            return true;
        }
        qj();
        this.f13432jz = true;
        return true;
    }

    public boolean g(int i, KeyEvent keyEvent) {
        if (i != 4) {
            if (i == 82) {
                u0(0, keyEvent);
                return true;
            }
        } else {
            boolean z2 = this.f13419dm;
            this.f13419dm = false;
            co o42 = o4(0, false);
            if (o42 != null && o42.f13478xc) {
                if (!z2) {
                    o(o42, true);
                }
                return true;
            } else if (kp()) {
                return true;
            }
        }
        return false;
    }

    public final boolean g3(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            co o42 = o4(i, true);
            if (!o42.f13478xc) {
                return o0(o42, keyEvent);
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean gq(int r7, boolean r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f13424f
            r1 = 0
            android.content.res.Configuration r0 = r6.j(r0, r7, r1)
            boolean r2 = r6.ap()
            android.content.Context r3 = r6.f13424f
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.uiMode
            r3 = r3 & 48
            int r0 = r0.uiMode
            r0 = r0 & 48
            r4 = 1
            if (r3 == r0) goto L47
            if (r8 == 0) goto L47
            if (r2 != 0) goto L47
            boolean r8 = r6.f13416ct
            if (r8 == 0) goto L47
            boolean r8 = s.v.f13409pz
            if (r8 != 0) goto L30
            boolean r8 = r6.f13440o4
            if (r8 == 0) goto L47
        L30:
            java.lang.Object r8 = r6.f13449s
            boolean r5 = r8 instanceof android.app.Activity
            if (r5 == 0) goto L47
            android.app.Activity r8 = (android.app.Activity) r8
            boolean r8 = r8.isChild()
            if (r8 != 0) goto L47
            java.lang.Object r8 = r6.f13449s
            android.app.Activity r8 = (android.app.Activity) r8
            rz.n3.x4(r8)
            r8 = 1
            goto L48
        L47:
            r8 = 0
        L48:
            if (r8 != 0) goto L50
            if (r3 == r0) goto L50
            r6.vp(r0, r2, r1)
            goto L51
        L50:
            r4 = r8
        L51:
            if (r4 == 0) goto L5e
            java.lang.Object r8 = r6.f13449s
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatActivity
            if (r0 == 0) goto L5e
            androidx.appcompat.app.AppCompatActivity r8 = (androidx.appcompat.app.AppCompatActivity) r8
            r8.onNightModeChanged(r7)
        L5e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: s.v.gq(int, boolean):boolean");
    }

    @Override // s.gv
    public void gv(View view, ViewGroup.LayoutParams layoutParams) {
        en();
        ((ViewGroup) this.f13444qn.findViewById(16908290)).addView(view, layoutParams);
        this.f13455w.y().onContentChanged();
    }

    public void hw(@NonNull androidx.appcompat.view.menu.v vVar) {
        if (this.f13452u) {
            return;
        }
        this.f13452u = true;
        this.f13425f3.t();
        Window.Callback eb2 = eb();
        if (eb2 != null && !this.f13421eb) {
            eb2.onPanelClosed(108, vVar);
        }
        this.f13452u = false;
    }

    @Override // s.gv
    @Nullable
    public <T extends View> T i9(int i) {
        en();
        return (T) this.f13451t.findViewById(i);
    }

    @NonNull
    public final Configuration j(@NonNull Context context, int i, @Nullable Configuration configuration) {
        int i5;
        if (i != 1) {
            if (i != 2) {
                i5 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
            } else {
                i5 = 32;
            }
        } else {
            i5 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i5 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    public final void j5() {
        xc xcVar = this.f13450s8;
        if (xcVar != null) {
            xcVar.y();
        }
        xc xcVar2 = this.f13412ap;
        if (xcVar2 != null) {
            xcVar2.y();
        }
    }

    public final void jz() {
        if (this.f13451t == null) {
            Object obj = this.f13449s;
            if (obj instanceof Activity) {
                k5(((Activity) obj).getWindow());
            }
        }
        if (this.f13451t != null) {
            return;
        }
        throw new IllegalStateException("We have not been given a Window");
    }

    public void k(int i) {
        co o42;
        co o43 = o4(i, true);
        if (o43.f13468i9 != null) {
            Bundle bundle = new Bundle();
            o43.f13468i9.j5(bundle);
            if (bundle.size() > 0) {
                o43.f13464co = bundle;
            }
            o43.f13468i9.xg();
            o43.f13468i9.clear();
        }
        o43.f13469mt = true;
        o43.f13471p = true;
        if ((i == 108 || i == 0) && this.f13425f3 != null && (o42 = o4(0, false)) != null) {
            o42.f13474tl = false;
            o0(o42, null);
        }
    }

    public final void k5(@NonNull Window window) {
        if (this.f13451t == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof tl)) {
                tl tlVar = new tl(callback);
                this.f13455w = tlVar;
                window.setCallback(tlVar);
                hw r2 = hw.r(this.f13424f, null, f13410tg);
                Drawable s2 = r2.s(0);
                if (s2 != null) {
                    window.setBackgroundDrawable(s2);
                }
                r2.i4();
                this.f13451t = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public boolean kp() {
        t.n3 n3Var = this.f13418d0;
        if (n3Var != null) {
            n3Var.zn();
            return true;
        }
        s.y xc2 = xc();
        if (xc2 != null && xc2.fb()) {
            return true;
        }
        return false;
    }

    @Nullable
    public final AppCompatActivity l() {
        for (Context context = this.f13424f; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    public final void lc() {
        en();
        if (this.f13443q9 && this.f13415co == null) {
            Object obj = this.f13449s;
            if (obj instanceof Activity) {
                this.f13415co = new s.wz((Activity) this.f13449s, this.f13433k);
            } else if (obj instanceof Dialog) {
                this.f13415co = new s.wz((Dialog) this.f13449s);
            }
            s.y yVar = this.f13415co;
            if (yVar != null) {
                yVar.p(this.f13447rb);
            }
        }
    }

    public boolean m(int i, KeyEvent keyEvent) {
        s.y xc2 = xc();
        if (xc2 != null && xc2.wz(i, keyEvent)) {
            return true;
        }
        co coVar = this.f13457xg;
        if (coVar != null && cr(coVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            co coVar2 = this.f13457xg;
            if (coVar2 != null) {
                coVar2.f13477wz = true;
            }
            return true;
        }
        if (this.f13457xg == null) {
            co o42 = o4(0, true);
            o0(o42, keyEvent);
            boolean cr2 = cr(o42, keyEvent.getKeyCode(), keyEvent, 1);
            o42.f13474tl = false;
            if (cr2) {
                return true;
            }
        }
        return false;
    }

    @Override // s.gv
    public void mg(View view) {
        en();
        ViewGroup viewGroup = (ViewGroup) this.f13444qn.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f13455w.y().onContentChanged();
    }

    @Override // s.gv
    public void mt(Configuration configuration) {
        s.y xc2;
        if (this.f13443q9 && this.f13431j5 && (xc2 = xc()) != null) {
            xc2.t(configuration);
        }
        wz.c5.n3().fb(this.f13424f);
        x(false);
    }

    @Override // s.gv
    public void n() {
        this.f13448rs = false;
        s.y xc2 = xc();
        if (xc2 != null) {
            xc2.co(false);
        }
    }

    @Override // androidx.appcompat.view.menu.v.y
    public void n3(@NonNull androidx.appcompat.view.menu.v vVar) {
        xb(true);
    }

    public final boolean nf(co coVar) {
        View view = coVar.f13463c5;
        if (view != null) {
            coVar.f13472s = view;
            return true;
        } else if (coVar.f13468i9 == null) {
            return false;
        } else {
            if (this.f13414c == null) {
                this.f13414c = new z();
            }
            View view2 = (View) coVar.y(this.f13414c);
            coVar.f13472s = view2;
            if (view2 != null) {
                return true;
            }
            return false;
        }
    }

    public void o(co coVar, boolean z2) {
        ViewGroup viewGroup;
        i4 i4Var;
        if (z2 && coVar.y == 0 && (i4Var = this.f13425f3) != null && i4Var.v()) {
            hw(coVar.f13468i9);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f13424f.getSystemService("window");
        if (windowManager != null && coVar.f13478xc && (viewGroup = coVar.f13466fb) != null) {
            windowManager.removeView(viewGroup);
            if (z2) {
                vl(coVar.y, coVar, null);
            }
        }
        coVar.f13474tl = false;
        coVar.f13477wz = false;
        coVar.f13478xc = false;
        coVar.f13472s = null;
        coVar.f13471p = true;
        if (this.f13457xg == coVar) {
            this.f13457xg = null;
        }
    }

    public final boolean o0(co coVar, KeyEvent keyEvent) {
        boolean z2;
        i4 i4Var;
        int i;
        boolean z3;
        i4 i4Var2;
        i4 i4Var3;
        if (this.f13421eb) {
            return false;
        }
        if (coVar.f13474tl) {
            return true;
        }
        co coVar2 = this.f13457xg;
        if (coVar2 != null && coVar2 != coVar) {
            o(coVar2, false);
        }
        Window.Callback eb2 = eb();
        if (eb2 != null) {
            coVar.f13463c5 = eb2.onCreatePanelView(coVar.y);
        }
        int i5 = coVar.y;
        if (i5 != 0 && i5 != 108) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2 && (i4Var3 = this.f13425f3) != null) {
            i4Var3.a();
        }
        if (coVar.f13463c5 == null && (!z2 || !(pq() instanceof s.f))) {
            androidx.appcompat.view.menu.v vVar = coVar.f13468i9;
            if (vVar == null || coVar.f13469mt) {
                if (vVar == null && (!e(coVar) || coVar.f13468i9 == null)) {
                    return false;
                }
                if (z2 && this.f13425f3 != null) {
                    if (this.f13437n == null) {
                        this.f13437n = new fb();
                    }
                    this.f13425f3.gv(coVar.f13468i9, this.f13437n);
                }
                coVar.f13468i9.xg();
                if (!eb2.onCreatePanelMenu(coVar.y, coVar.f13468i9)) {
                    coVar.zn(null);
                    if (z2 && (i4Var = this.f13425f3) != null) {
                        i4Var.gv(null, this.f13437n);
                    }
                    return false;
                }
                coVar.f13469mt = false;
            }
            coVar.f13468i9.xg();
            Bundle bundle = coVar.f13464co;
            if (bundle != null) {
                coVar.f13468i9.hw(bundle);
                coVar.f13464co = null;
            }
            if (!eb2.onPreparePanel(0, coVar.f13463c5, coVar.f13468i9)) {
                if (z2 && (i4Var2 = this.f13425f3) != null) {
                    i4Var2.gv(null, this.f13437n);
                }
                coVar.f13468i9.y5();
                return false;
            }
            if (keyEvent != null) {
                i = keyEvent.getDeviceId();
            } else {
                i = -1;
            }
            if (KeyCharacterMap.load(i).getKeyboardType() != 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            coVar.f13476w = z3;
            coVar.f13468i9.setQwertyMode(z3);
            coVar.f13468i9.y5();
        }
        coVar.f13474tl = true;
        coVar.f13477wz = false;
        this.f13457xg = coVar;
        return true;
    }

    public co o4(int i, boolean z2) {
        co[] coVarArr = this.f13458y5;
        if (coVarArr == null || coVarArr.length <= i) {
            co[] coVarArr2 = new co[i + 1];
            if (coVarArr != null) {
                System.arraycopy(coVarArr, 0, coVarArr2, 0, coVarArr.length);
            }
            this.f13458y5 = coVarArr2;
            coVarArr = coVarArr2;
        }
        co coVar = coVarArr[i];
        if (coVar == null) {
            co coVar2 = new co(i);
            coVarArr[i] = coVar2;
            return coVar2;
        }
        return coVar;
    }

    public final int oa(@Nullable ej ejVar, @Nullable Rect rect) {
        int i;
        boolean z2;
        int f4;
        int t2;
        boolean z3;
        int i5 = 0;
        if (ejVar != null) {
            i = ejVar.tl();
        } else if (rect != null) {
            i = rect.top;
        } else {
            i = 0;
        }
        ActionBarContextView actionBarContextView = this.f13427fh;
        if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f13427fh.getLayoutParams();
            boolean z4 = true;
            if (this.f13427fh.isShown()) {
                if (this.f13429g3 == null) {
                    this.f13429g3 = new Rect();
                    this.f13436m = new Rect();
                }
                Rect rect2 = this.f13429g3;
                Rect rect3 = this.f13436m;
                if (ejVar == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(ejVar.f(), ejVar.tl(), ejVar.t(), ejVar.i9());
                }
                oz.y(this.f13444qn, rect2, rect3);
                int i6 = rect2.top;
                int i8 = rect2.left;
                int i10 = rect2.right;
                ej b2 = hw.i4.b(this.f13444qn);
                if (b2 == null) {
                    f4 = 0;
                } else {
                    f4 = b2.f();
                }
                if (b2 == null) {
                    t2 = 0;
                } else {
                    t2 = b2.t();
                }
                if (marginLayoutParams.topMargin == i6 && marginLayoutParams.leftMargin == i8 && marginLayoutParams.rightMargin == i10) {
                    z3 = false;
                } else {
                    marginLayoutParams.topMargin = i6;
                    marginLayoutParams.leftMargin = i8;
                    marginLayoutParams.rightMargin = i10;
                    z3 = true;
                }
                if (i6 > 0 && this.f13430j == null) {
                    View view = new View(this.f13424f);
                    this.f13430j = view;
                    view.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = f4;
                    layoutParams.rightMargin = t2;
                    this.f13444qn.addView(this.f13430j, -1, layoutParams);
                } else {
                    View view2 = this.f13430j;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i11 = marginLayoutParams2.height;
                        int i12 = marginLayoutParams.topMargin;
                        if (i11 != i12 || marginLayoutParams2.leftMargin != f4 || marginLayoutParams2.rightMargin != t2) {
                            marginLayoutParams2.height = i12;
                            marginLayoutParams2.leftMargin = f4;
                            marginLayoutParams2.rightMargin = t2;
                            this.f13430j.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                View view3 = this.f13430j;
                if (view3 == null) {
                    z4 = false;
                }
                if (z4 && view3.getVisibility() != 0) {
                    w9(this.f13430j);
                }
                if (!this.f13426f7 && z4) {
                    i = 0;
                }
                z2 = z4;
                z4 = z3;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z2 = false;
                z4 = false;
            }
            if (z4) {
                this.f13427fh.setLayoutParams(marginLayoutParams);
            }
        } else {
            z2 = false;
        }
        View view4 = this.f13430j;
        if (view4 != null) {
            if (!z2) {
                i5 = 8;
            }
            view4.setVisibility(i5);
        }
        return i;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return c5(view, str, context, attributeSet);
    }

    public final ViewGroup oz() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f13424f.obtainStyledAttributes(R$styleable.f899tg);
        int i = R$styleable.f920xb;
        if (obtainStyledAttributes.hasValue(i)) {
            if (obtainStyledAttributes.getBoolean(R$styleable.f878oa, false)) {
                fh(1);
            } else if (obtainStyledAttributes.getBoolean(i, false)) {
                fh(108);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.f914wf, false)) {
                fh(109);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.f809ad, false)) {
                fh(10);
            }
            this.f13423en = obtainStyledAttributes.getBoolean(R$styleable.f882pz, false);
            obtainStyledAttributes.recycle();
            jz();
            this.f13451t.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f13424f);
            if (!this.f13432jz) {
                if (this.f13423en) {
                    viewGroup = (ViewGroup) from.inflate(R$layout.f771a, (ViewGroup) null);
                    this.f13433k = false;
                    this.f13443q9 = false;
                } else if (this.f13443q9) {
                    TypedValue typedValue = new TypedValue();
                    this.f13424f.getTheme().resolveAttribute(R$attr.f625a, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new t.gv(this.f13424f, typedValue.resourceId);
                    } else {
                        context = this.f13424f;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R$layout.f785w, (ViewGroup) null);
                    i4 i4Var = (i4) viewGroup.findViewById(R$id.f762w);
                    this.f13425f3 = i4Var;
                    i4Var.setWindowCallback(eb());
                    if (this.f13433k) {
                        this.f13425f3.s(109);
                    }
                    if (this.f13441oz) {
                        this.f13425f3.s(2);
                    }
                    if (this.f13454ut) {
                        this.f13425f3.s(5);
                    }
                } else {
                    viewGroup = null;
                }
            } else {
                viewGroup = this.f13426f7 ? (ViewGroup) from.inflate(R$layout.f787xc, (ViewGroup) null) : (ViewGroup) from.inflate(R$layout.f786wz, (ViewGroup) null);
            }
            if (viewGroup != null) {
                hw.i4.ad(viewGroup, new n3());
                if (this.f13425f3 == null) {
                    this.f13439o = (TextView) viewGroup.findViewById(R$id.f747k5);
                }
                oz.zn(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.f751n3);
                ViewGroup viewGroup2 = (ViewGroup) this.f13451t.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.f13451t.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new zn());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f13443q9 + ", windowActionBarOverlay: " + this.f13433k + ", android:windowIsFloating: " + this.f13423en + ", windowActionModeOverlay: " + this.f13426f7 + ", windowNoTitle: " + this.f13432jz + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    @Override // s.gv
    public void p() {
        s.y xc2 = xc();
        if (xc2 != null && xc2.f()) {
            return;
        }
        s8(0);
    }

    public final s.y pq() {
        return this.f13415co;
    }

    public final void pz(co coVar, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (!coVar.f13478xc && !this.f13421eb) {
            if (coVar.y == 0 && (this.f13424f.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
            Window.Callback eb2 = eb();
            if (eb2 != null && !eb2.onMenuOpened(coVar.y, coVar.f13468i9)) {
                o(coVar, true);
                return;
            }
            WindowManager windowManager = (WindowManager) this.f13424f.getSystemService("window");
            if (windowManager == null || !o0(coVar, keyEvent)) {
                return;
            }
            ViewGroup viewGroup = coVar.f13466fb;
            if (viewGroup != null && !coVar.f13471p) {
                View view = coVar.f13463c5;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                    coVar.f13477wz = false;
                    WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i, -2, coVar.f13467gv, coVar.f13475v, 1002, 8519680, -3);
                    layoutParams2.gravity = coVar.f13479zn;
                    layoutParams2.windowAnimations = coVar.f13462a;
                    windowManager.addView(coVar.f13466fb, layoutParams2);
                    coVar.f13478xc = true;
                }
            } else {
                if (viewGroup == null) {
                    if (!ra(coVar) || coVar.f13466fb == null) {
                        return;
                    }
                } else if (coVar.f13471p && viewGroup.getChildCount() > 0) {
                    coVar.f13466fb.removeAllViews();
                }
                if (nf(coVar) && coVar.n3()) {
                    ViewGroup.LayoutParams layoutParams3 = coVar.f13472s.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                    }
                    coVar.f13466fb.setBackgroundResource(coVar.f13470n3);
                    ViewParent parent = coVar.f13472s.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(coVar.f13472s);
                    }
                    coVar.f13466fb.addView(coVar.f13472s, layoutParams3);
                    if (!coVar.f13472s.hasFocus()) {
                        coVar.f13472s.requestFocus();
                    }
                } else {
                    coVar.f13471p = true;
                    return;
                }
            }
            i = -2;
            coVar.f13477wz = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i, -2, coVar.f13467gv, coVar.f13475v, 1002, 8519680, -3);
            layoutParams22.gravity = coVar.f13479zn;
            layoutParams22.windowAnimations = coVar.f13462a;
            windowManager.addView(coVar.f13466fb, layoutParams22);
            coVar.f13478xc = true;
        }
    }

    public boolean q9(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f13449s;
        if (((obj instanceof a.y) || (obj instanceof s.a)) && (decorView = this.f13451t.getDecorView()) != null && hw.a.gv(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f13455w.y().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            return rb(keyCode, keyEvent);
        }
        return g(keyCode, keyEvent);
    }

    public final void qj() {
        if (!this.f13431j5) {
            return;
        }
        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public t.n3 qk(@androidx.annotation.NonNull t.n3.y r8) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.v.qk(t.n3$y):t.n3");
    }

    public void qn(int i) {
        o(o4(i, true), true);
    }

    @Override // s.gv
    public void r(Bundle bundle) {
        en();
    }

    public final boolean ra(co coVar) {
        coVar.gv(xg());
        coVar.f13466fb = new mt(coVar.f13473t);
        coVar.f13479zn = 81;
        return true;
    }

    public boolean rb(int i, KeyEvent keyEvent) {
        boolean z2 = true;
        if (i != 4) {
            if (i == 82) {
                g3(0, keyEvent);
                return true;
            }
        } else {
            if ((keyEvent.getFlags() & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                z2 = false;
            }
            this.f13419dm = z2;
        }
        return false;
    }

    public final CharSequence rs() {
        Object obj = this.f13449s;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.f13445r;
    }

    @Override // s.gv
    public void rz(int i) {
        en();
        ViewGroup viewGroup = (ViewGroup) this.f13444qn.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f13424f).inflate(i, viewGroup);
        this.f13455w.y().onContentChanged();
    }

    public final void s8(int i) {
        this.f13459yc = (1 << i) | this.f13459yc;
        if (!this.f13460yg) {
            hw.i4.nf(this.f13451t.getDecorView(), this.f13434kp);
            this.f13460yg = true;
        }
    }

    @Override // s.gv
    public final s.n3 t() {
        return new a();
    }

    @Override // s.gv
    public void ta(View view, ViewGroup.LayoutParams layoutParams) {
        en();
        ViewGroup viewGroup = (ViewGroup) this.f13444qn.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f13455w.y().onContentChanged();
    }

    @Override // s.gv
    public int tl() {
        return this.f13435lc;
    }

    public co u(Menu menu) {
        int i;
        co[] coVarArr = this.f13458y5;
        if (coVarArr != null) {
            i = coVarArr.length;
        } else {
            i = 0;
        }
        for (int i5 = 0; i5 < i; i5++) {
            co coVar = coVarArr[i5];
            if (coVar != null && coVar.f13468i9 == menu) {
                return coVar;
            }
        }
        return null;
    }

    public final boolean u0(int i, KeyEvent keyEvent) {
        boolean z2;
        i4 i4Var;
        if (this.f13418d0 != null) {
            return false;
        }
        boolean z3 = true;
        co o42 = o4(i, true);
        if (i == 0 && (i4Var = this.f13425f3) != null && i4Var.y() && !ViewConfiguration.get(this.f13424f).hasPermanentMenuKey()) {
            if (!this.f13425f3.v()) {
                if (!this.f13421eb && o0(o42, keyEvent)) {
                    z3 = this.f13425f3.zn();
                }
                z3 = false;
            } else {
                z3 = this.f13425f3.n3();
            }
        } else {
            boolean z4 = o42.f13478xc;
            if (!z4 && !o42.f13477wz) {
                if (o42.f13474tl) {
                    if (o42.f13469mt) {
                        o42.f13474tl = false;
                        z2 = o0(o42, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        pz(o42, keyEvent);
                    }
                }
                z3 = false;
            } else {
                o(o42, true);
                z3 = z4;
            }
        }
        if (z3) {
            AudioManager audioManager = (AudioManager) this.f13424f.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z3;
    }

    @Override // s.gv
    public t.n3 ud(@NonNull n3.y yVar) {
        s.zn znVar;
        if (yVar != null) {
            t.n3 n3Var = this.f13418d0;
            if (n3Var != null) {
                n3Var.zn();
            }
            s sVar = new s(yVar);
            s.y xc2 = xc();
            if (xc2 != null) {
                t.n3 i42 = xc2.i4(sVar);
                this.f13418d0 = i42;
                if (i42 != null && (znVar = this.f13442p) != null) {
                    znVar.onSupportActionModeStarted(i42);
                }
            }
            if (this.f13418d0 == null) {
                this.f13418d0 = qk(sVar);
            }
            return this.f13418d0;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public void ut() {
        androidx.appcompat.view.menu.v vVar;
        i4 i4Var = this.f13425f3;
        if (i4Var != null) {
            i4Var.t();
        }
        if (this.f13417d != null) {
            this.f13451t.getDecorView().removeCallbacks(this.f13422ej);
            if (this.f13417d.isShowing()) {
                try {
                    this.f13417d.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f13417d = null;
        }
        f7();
        co o42 = o4(0, false);
        if (o42 != null && (vVar = o42.f13468i9) != null) {
            vVar.close();
        }
    }

    public void vl(int i, co coVar, Menu menu) {
        if (menu == null) {
            if (coVar == null && i >= 0) {
                co[] coVarArr = this.f13458y5;
                if (i < coVarArr.length) {
                    coVar = coVarArr[i];
                }
            }
            if (coVar != null) {
                menu = coVar.f13468i9;
            }
        }
        if ((coVar == null || coVar.f13478xc) && !this.f13421eb) {
            this.f13455w.y().onPanelClosed(i, menu);
        }
    }

    public final void vp(int i, boolean z2, @Nullable Configuration configuration) {
        Resources resources = this.f13424f.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 26) {
            s.i9.y(resources);
        }
        int i6 = this.f13438nf;
        if (i6 != 0) {
            this.f13424f.setTheme(i6);
            if (i5 >= 23) {
                this.f13424f.getTheme().applyStyle(this.f13438nf, true);
            }
        }
        if (z2) {
            Object obj = this.f13449s;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof y5.co) {
                    if (((y5.co) activity).getLifecycle().n3().y(v.zn.STARTED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (this.f13448rs) {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    @Override // s.gv
    public void w() {
        LayoutInflater from = LayoutInflater.from(this.f13424f);
        if (from.getFactory() == null) {
            hw.fb.y(from, this);
        } else {
            boolean z2 = from.getFactory2() instanceof v;
        }
    }

    public final void w9(View view) {
        int zn2;
        if ((hw.i4.hw(view) & 8192) != 0) {
            zn2 = mg.y.zn(this.f13424f, R$color.f668n3);
        } else {
            zn2 = mg.y.zn(this.f13424f, R$color.y);
        }
        view.setBackgroundColor(zn2);
    }

    public final int wf(int i) {
        if (i == 8) {
            return 108;
        }
        if (i == 9) {
            return 109;
        }
        return i;
    }

    @Override // s.gv
    public MenuInflater wz() {
        Context context;
        if (this.f13461z == null) {
            lc();
            s.y yVar = this.f13415co;
            if (yVar != null) {
                context = yVar.i9();
            } else {
                context = this.f13424f;
            }
            this.f13461z = new t.fb(context);
        }
        return this.f13461z;
    }

    public final boolean x(boolean z2) {
        if (this.f13421eb) {
            return false;
        }
        int yt2 = yt();
        boolean gq2 = gq(yc(this.f13424f, yt2), z2);
        if (yt2 == 0) {
            ct(this.f13424f).v();
        } else {
            xc xcVar = this.f13450s8;
            if (xcVar != null) {
                xcVar.y();
            }
        }
        if (yt2 == 3) {
            dm(this.f13424f).v();
        } else {
            xc xcVar2 = this.f13412ap;
            if (xcVar2 != null) {
                xcVar2.y();
            }
        }
        return gq2;
    }

    @Override // s.gv
    public void x4() {
        s.y xc2 = xc();
        if (xc2 != null) {
            xc2.co(true);
        }
    }

    public final void xb(boolean z2) {
        i4 i4Var = this.f13425f3;
        if (i4Var != null && i4Var.y() && (!ViewConfiguration.get(this.f13424f).hasPermanentMenuKey() || this.f13425f3.fb())) {
            Window.Callback eb2 = eb();
            if (this.f13425f3.v() && z2) {
                this.f13425f3.n3();
                if (!this.f13421eb) {
                    eb2.onPanelClosed(108, o4(0, true).f13468i9);
                    return;
                }
                return;
            } else if (eb2 != null && !this.f13421eb) {
                if (this.f13460yg && (this.f13459yc & 1) != 0) {
                    this.f13451t.getDecorView().removeCallbacks(this.f13434kp);
                    this.f13434kp.run();
                }
                co o42 = o4(0, true);
                androidx.appcompat.view.menu.v vVar = o42.f13468i9;
                if (vVar != null && !o42.f13469mt && eb2.onPreparePanel(0, o42.f13463c5, vVar)) {
                    eb2.onMenuOpened(108, o42.f13468i9);
                    this.f13425f3.zn();
                    return;
                }
                return;
            } else {
                return;
            }
        }
        co o43 = o4(0, true);
        o43.f13471p = true;
        o(o43, false);
        pz(o43, null);
    }

    @Override // s.gv
    public s.y xc() {
        lc();
        return this.f13415co;
    }

    public final Context xg() {
        Context context;
        s.y xc2 = xc();
        if (xc2 != null) {
            context = xc2.i9();
        } else {
            context = null;
        }
        if (context == null) {
            return this.f13424f;
        }
        return context;
    }

    @Override // androidx.appcompat.view.menu.v.y
    public boolean y(@NonNull androidx.appcompat.view.menu.v vVar, @NonNull MenuItem menuItem) {
        co u2;
        Window.Callback eb2 = eb();
        if (eb2 != null && !this.f13421eb && (u2 = u(vVar.mg())) != null) {
            return eb2.onMenuItemSelected(u2.y, menuItem);
        }
        return false;
    }

    public void y4(int i) {
        if (i == 108) {
            s.y xc2 = xc();
            if (xc2 != null) {
                xc2.s(false);
            }
        } else if (i == 0) {
            co o42 = o4(i, true);
            if (o42.f13478xc) {
                o(o42, false);
            }
        }
    }

    public int yc(@NonNull Context context, int i) {
        if (i == -100) {
            return -1;
        }
        if (i != -1) {
            if (i != 0) {
                if (i != 1 && i != 2) {
                    if (i == 3) {
                        return dm(context).zn();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            } else {
                return ct(context).zn();
            }
        }
        return i;
    }

    public boolean yg() {
        return this.f13413b;
    }

    public final int yt() {
        int i = this.f13435lc;
        if (i == -100) {
            return s.gv.f();
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    @Override // s.gv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f13449s
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            s.gv.c(r3)
        L9:
            boolean r0 = r3.f13460yg
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f13451t
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f13434kp
            r0.removeCallbacks(r1)
        L18:
            r0 = 0
            r3.f13448rs = r0
            r0 = 1
            r3.f13421eb = r0
            int r0 = r3.f13435lc
            r1 = -100
            if (r0 == r1) goto L48
            java.lang.Object r0 = r3.f13449s
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L48
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L48
            z.s<java.lang.String, java.lang.Integer> r0 = s.v.f13407bk
            java.lang.Object r1 = r3.f13449s
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f13435lc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L57
        L48:
            z.s<java.lang.String, java.lang.Integer> r0 = s.v.f13407bk
            java.lang.Object r1 = r3.f13449s
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L57:
            s.y r0 = r3.f13415co
            if (r0 == 0) goto L5e
            r0.tl()
        L5e:
            r3.j5()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s.v.z():void");
    }

    @Override // s.gv
    public void z6(int i) {
        this.f13438nf = i;
    }

    public v(Dialog dialog, s.zn znVar) {
        this(dialog.getContext(), dialog.getWindow(), znVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public v(Context context, Window window, s.zn znVar, Object obj) {
        z.s<String, Integer> sVar;
        Integer num;
        AppCompatActivity l2;
        this.f13413b = true;
        this.f13435lc = -100;
        this.f13434kp = new y();
        this.f13424f = context;
        this.f13442p = znVar;
        this.f13449s = obj;
        if (this.f13435lc == -100 && (obj instanceof Dialog) && (l2 = l()) != null) {
            this.f13435lc = l2.getDelegate().tl();
        }
        if (this.f13435lc == -100 && (num = (sVar = f13407bk).get(obj.getClass().getName())) != null) {
            this.f13435lc = num.intValue();
            sVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            k5(window);
        }
        wz.c5.s();
    }

    /* loaded from: classes.dex */
    public class tl extends WindowCallbackWrapper {
        public tl(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!v.this.q9(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                return false;
            }
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (!super.dispatchKeyShortcutEvent(keyEvent) && !v.this.m(keyEvent.getKeyCode(), keyEvent)) {
                return false;
            }
            return true;
        }

        public final ActionMode n3(ActionMode.Callback callback) {
            a.y yVar = new a.y(v.this.f13424f, callback);
            t.n3 ud2 = v.this.ud(yVar);
            if (ud2 != null) {
                return yVar.v(ud2);
            }
            return null;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i == 0 && !(menu instanceof androidx.appcompat.view.menu.v)) {
                return false;
            }
            return super.onCreatePanelMenu(i, menu);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            v.this.bk(i);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            v.this.y4(i);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.v vVar;
            if (menu instanceof androidx.appcompat.view.menu.v) {
                vVar = (androidx.appcompat.view.menu.v) menu;
            } else {
                vVar = null;
            }
            if (i == 0 && vVar == null) {
                return false;
            }
            if (vVar != null) {
                vVar.jz(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (vVar != null) {
                vVar.jz(false);
            }
            return onPreparePanel;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            androidx.appcompat.view.menu.v vVar;
            co o42 = v.this.o4(0, true);
            if (o42 != null && (vVar = o42.f13468i9) != null) {
                super.onProvideKeyboardShortcuts(list, vVar, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (v.this.yg()) {
                return n3(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (v.this.yg() && i == 0) {
                return n3(callback);
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
        }
    }

    /* loaded from: classes.dex */
    public class zn implements ContentFrameLayout.y {
        public zn() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.y
        public void onDetachedFromWindow() {
            v.this.ut();
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.y
        public void y() {
        }
    }

    @Override // s.gv
    public void i4(Bundle bundle) {
    }

    public void tg(ViewGroup viewGroup) {
    }
}
