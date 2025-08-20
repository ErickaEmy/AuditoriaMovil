package mt;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import n3.zn;
/* loaded from: classes.dex */
public final class c5 {

    /* renamed from: gv  reason: collision with root package name */
    public final ComponentName f11526gv;

    /* renamed from: n3  reason: collision with root package name */
    public final n3.n3 f11527n3;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final PendingIntent f11528v;
    public final Object y = new Object();

    /* renamed from: zn  reason: collision with root package name */
    public final n3.y f11529zn;

    /* loaded from: classes.dex */
    public class y extends zn.y {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ i9 f11531v;
        public final Handler y = new Handler(Looper.getMainLooper());

        public y(i9 i9Var) {
            this.f11531v = i9Var;
        }

        @Override // n3.zn
        public void onGreatestScrollPercentageIncreased(final int i, final Bundle bundle) {
            Handler handler = this.y;
            final i9 i9Var = this.f11531v;
            handler.post(new Runnable() { // from class: mt.fb
                @Override // java.lang.Runnable
                public final void run() {
                    i9.this.onGreatestScrollPercentageIncreased(i, bundle);
                }
            });
        }

        @Override // n3.zn
        public void onSessionEnded(final boolean z2, final Bundle bundle) {
            Handler handler = this.y;
            final i9 i9Var = this.f11531v;
            handler.post(new Runnable() { // from class: mt.a
                @Override // java.lang.Runnable
                public final void run() {
                    i9.this.onSessionEnded(z2, bundle);
                }
            });
        }

        @Override // n3.zn
        public void onVerticalScrollEvent(final boolean z2, final Bundle bundle) {
            Handler handler = this.y;
            final i9 i9Var = this.f11531v;
            handler.post(new Runnable() { // from class: mt.s
                @Override // java.lang.Runnable
                public final void run() {
                    i9.this.onVerticalScrollEvent(z2, bundle);
                }
            });
        }
    }

    public c5(n3.n3 n3Var, n3.y yVar, ComponentName componentName, @Nullable PendingIntent pendingIntent) {
        this.f11527n3 = n3Var;
        this.f11529zn = yVar;
        this.f11526gv = componentName;
        this.f11528v = pendingIntent;
    }

    public ComponentName a() {
        return this.f11526gv;
    }

    public boolean c5(@Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list) {
        try {
            return this.f11527n3.le(this.f11529zn, uri, n3(bundle), list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean f(@NonNull Uri uri) {
        return t(uri, null, new Bundle());
    }

    @Nullable
    public PendingIntent fb() {
        return this.f11528v;
    }

    @Nullable
    public final Bundle gv(@Nullable Uri uri) {
        Bundle bundle = new Bundle();
        if (uri != null) {
            bundle.putParcelable("target_origin", uri);
        }
        if (this.f11528v != null) {
            y(bundle);
        }
        if (bundle.isEmpty()) {
            return null;
        }
        return bundle;
    }

    public int i9(@NonNull String str, @Nullable Bundle bundle) {
        int t2;
        Bundle n32 = n3(bundle);
        synchronized (this.y) {
            try {
                try {
                    t2 = this.f11527n3.t(this.f11529zn, str, n32);
                } catch (RemoteException unused) {
                    return -2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t2;
    }

    public final Bundle n3(@Nullable Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        y(bundle2);
        return bundle2;
    }

    public boolean s(@NonNull Bundle bundle) throws RemoteException {
        try {
            return this.f11527n3.qj(this.f11529zn, bundle);
        } catch (SecurityException e2) {
            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e2);
        }
    }

    public boolean t(@NonNull Uri uri, @Nullable Uri uri2, @NonNull Bundle bundle) {
        try {
            Bundle gv2 = gv(uri2);
            if (gv2 != null) {
                bundle.putAll(gv2);
                return this.f11527n3.wz(this.f11529zn, uri, bundle);
            }
            return this.f11527n3.i2(this.f11529zn, uri);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean tl(@NonNull i9 i9Var, @NonNull Bundle bundle) throws RemoteException {
        try {
            return this.f11527n3.i4(this.f11529zn, zn(i9Var).asBinder(), bundle);
        } catch (SecurityException e2) {
            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e2);
        }
    }

    public IBinder v() {
        return this.f11529zn.asBinder();
    }

    public final void y(Bundle bundle) {
        PendingIntent pendingIntent = this.f11528v;
        if (pendingIntent != null) {
            bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
        }
    }

    public final zn.y zn(@NonNull i9 i9Var) {
        return new y(i9Var);
    }
}
