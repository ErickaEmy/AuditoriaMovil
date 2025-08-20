package mt;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import n3.y;
/* loaded from: classes.dex */
public class zn {

    /* renamed from: n3  reason: collision with root package name */
    public final ComponentName f11552n3;
    public final n3.n3 y;

    /* renamed from: zn  reason: collision with root package name */
    public final Context f11553zn;

    /* loaded from: classes.dex */
    public class n3 extends y.AbstractBinderC0162y {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ mt.n3 f11555v;
        public Handler y = new Handler(Looper.getMainLooper());

        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: fb  reason: collision with root package name */
            public final /* synthetic */ Bundle f11556fb;

            /* renamed from: v  reason: collision with root package name */
            public final /* synthetic */ int f11558v;
            public final /* synthetic */ int y;

            public a(int i, int i5, Bundle bundle) {
                this.y = i;
                this.f11558v = i5;
                this.f11556fb = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                n3.this.f11555v.onActivityResized(this.y, this.f11558v, this.f11556fb);
            }
        }

        /* loaded from: classes.dex */
        public class gv implements Runnable {

            /* renamed from: v  reason: collision with root package name */
            public final /* synthetic */ Bundle f11560v;
            public final /* synthetic */ String y;

            public gv(String str, Bundle bundle) {
                this.y = str;
                this.f11560v = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                n3.this.f11555v.onPostMessage(this.y, this.f11560v);
            }
        }

        /* renamed from: mt.zn$n3$n3  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0157n3 implements Runnable {

            /* renamed from: v  reason: collision with root package name */
            public final /* synthetic */ Bundle f11562v;
            public final /* synthetic */ String y;

            public RunnableC0157n3(String str, Bundle bundle) {
                this.y = str;
                this.f11562v = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                n3.this.f11555v.extraCallback(this.y, this.f11562v);
            }
        }

        /* loaded from: classes.dex */
        public class v implements Runnable {

            /* renamed from: fb  reason: collision with root package name */
            public final /* synthetic */ boolean f11564fb;

            /* renamed from: s  reason: collision with root package name */
            public final /* synthetic */ Bundle f11565s;

            /* renamed from: v  reason: collision with root package name */
            public final /* synthetic */ Uri f11566v;
            public final /* synthetic */ int y;

            public v(int i, Uri uri, boolean z2, Bundle bundle) {
                this.y = i;
                this.f11566v = uri;
                this.f11564fb = z2;
                this.f11565s = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                n3.this.f11555v.onRelationshipValidationResult(this.y, this.f11566v, this.f11564fb, this.f11565s);
            }
        }

        /* loaded from: classes.dex */
        public class y implements Runnable {

            /* renamed from: v  reason: collision with root package name */
            public final /* synthetic */ Bundle f11568v;
            public final /* synthetic */ int y;

            public y(int i, Bundle bundle) {
                this.y = i;
                this.f11568v = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                n3.this.f11555v.onNavigationEvent(this.y, this.f11568v);
            }
        }

        /* renamed from: mt.zn$n3$zn  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0158zn implements Runnable {
            public final /* synthetic */ Bundle y;

            public RunnableC0158zn(Bundle bundle) {
                this.y = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                n3.this.f11555v.onMessageChannelReady(this.y);
            }
        }

        public n3(mt.n3 n3Var) {
            this.f11555v = n3Var;
        }

        @Override // n3.y
        public void cs(Bundle bundle) throws RemoteException {
            if (this.f11555v == null) {
                return;
            }
            this.y.post(new RunnableC0158zn(bundle));
        }

        @Override // n3.y
        public void gq(int i, int i5, @Nullable Bundle bundle) throws RemoteException {
            if (this.f11555v == null) {
                return;
            }
            this.y.post(new a(i, i5, bundle));
        }

        @Override // n3.y
        public void ix(int i, Uri uri, boolean z2, @Nullable Bundle bundle) throws RemoteException {
            if (this.f11555v == null) {
                return;
            }
            this.y.post(new v(i, uri, z2, bundle));
        }

        @Override // n3.y
        public void j(String str, Bundle bundle) throws RemoteException {
            if (this.f11555v == null) {
                return;
            }
            this.y.post(new RunnableC0157n3(str, bundle));
        }

        @Override // n3.y
        public void q5(String str, Bundle bundle) throws RemoteException {
            if (this.f11555v == null) {
                return;
            }
            this.y.post(new gv(str, bundle));
        }

        @Override // n3.y
        public void w2(int i, Bundle bundle) {
            if (this.f11555v == null) {
                return;
            }
            this.y.post(new y(i, bundle));
        }

        @Override // n3.y
        public Bundle x4(@NonNull String str, @Nullable Bundle bundle) throws RemoteException {
            mt.n3 n3Var = this.f11555v;
            if (n3Var == null) {
                return null;
            }
            return n3Var.extraCallbackWithResult(str, bundle);
        }
    }

    public zn(n3.n3 n3Var, ComponentName componentName, Context context) {
        this.y = n3Var;
        this.f11552n3 = componentName;
        this.f11553zn = context;
    }

    public static boolean n3(@NonNull Context context, @NonNull String str) {
        if (str == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            return y(applicationContext, str, new y(applicationContext));
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static boolean y(@NonNull Context context, @Nullable String str, @NonNull v vVar) {
        vVar.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, vVar, 33);
    }

    public boolean a(long j2) {
        try {
            return this.y.wf(j2);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Nullable
    public c5 gv(@Nullable mt.n3 n3Var) {
        return v(n3Var, null);
    }

    @Nullable
    public final c5 v(@Nullable mt.n3 n3Var, @Nullable PendingIntent pendingIntent) {
        boolean lc2;
        y.AbstractBinderC0162y zn2 = zn(n3Var);
        try {
            if (pendingIntent != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                lc2 = this.y.c(zn2, bundle);
            } else {
                lc2 = this.y.lc(zn2);
            }
            if (!lc2) {
                return null;
            }
            return new c5(this.y, zn2, this.f11552n3, pendingIntent);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final y.AbstractBinderC0162y zn(@Nullable mt.n3 n3Var) {
        return new n3(n3Var);
    }

    /* loaded from: classes.dex */
    public class y extends v {
        public final /* synthetic */ Context y;

        public y(Context context) {
            this.y = context;
        }

        @Override // mt.v
        public final void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull zn znVar) {
            znVar.a(0L);
            this.y.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
