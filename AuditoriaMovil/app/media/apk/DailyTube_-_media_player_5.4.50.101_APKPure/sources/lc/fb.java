package lc;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.v;
import androidx.lifecycle.wz;
import androidx.savedstate.SavedStateRegistry;
import java.util.UUID;
import y5.b;
import y5.co;
import y5.k5;
/* loaded from: classes.dex */
public final class fb implements co, k5, androidx.lifecycle.gv, g.y {

    /* renamed from: co  reason: collision with root package name */
    public s f10287co;

    /* renamed from: f  reason: collision with root package name */
    public final androidx.savedstate.y f10288f;

    /* renamed from: fb  reason: collision with root package name */
    public Bundle f10289fb;

    /* renamed from: p  reason: collision with root package name */
    public v.zn f10290p;

    /* renamed from: s  reason: collision with root package name */
    public final androidx.lifecycle.fb f10291s;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public final UUID f10292t;

    /* renamed from: v  reason: collision with root package name */
    public final androidx.navigation.gv f10293v;

    /* renamed from: w  reason: collision with root package name */
    public v.zn f10294w;
    public final Context y;

    /* renamed from: z  reason: collision with root package name */
    public wz.n3 f10295z;

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[v.n3.values().length];
            y = iArr;
            try {
                iArr[v.n3.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[v.n3.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[v.n3.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[v.n3.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                y[v.n3.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                y[v.n3.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                y[v.n3.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public fb(@NonNull Context context, @NonNull androidx.navigation.gv gvVar, @Nullable Bundle bundle, @Nullable co coVar, @Nullable s sVar) {
        this(context, gvVar, bundle, coVar, sVar, UUID.randomUUID(), null);
    }

    @NonNull
    public static v.zn gv(@NonNull v.n3 n3Var) {
        switch (y.y[n3Var.ordinal()]) {
            case 1:
            case 2:
                return v.zn.CREATED;
            case 3:
            case 4:
                return v.zn.STARTED;
            case 5:
                return v.zn.RESUMED;
            case 6:
                return v.zn.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + n3Var);
        }
    }

    public void a(@Nullable Bundle bundle) {
        this.f10289fb = bundle;
    }

    public void c5(@NonNull v.zn znVar) {
        this.f10290p = znVar;
        i9();
    }

    @Override // androidx.lifecycle.gv
    @NonNull
    public wz.n3 getDefaultViewModelProviderFactory() {
        if (this.f10295z == null) {
            this.f10295z = new androidx.lifecycle.t((Application) this.y.getApplicationContext(), this, this.f10289fb);
        }
        return this.f10295z;
    }

    @Override // y5.co
    @NonNull
    public androidx.lifecycle.v getLifecycle() {
        return this.f10291s;
    }

    @Override // g.y
    @NonNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.f10288f.n3();
    }

    @Override // y5.k5
    @NonNull
    public b getViewModelStore() {
        s sVar = this.f10287co;
        if (sVar != null) {
            return sVar.g6(this.f10292t);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    public void i9() {
        if (this.f10294w.ordinal() < this.f10290p.ordinal()) {
            this.f10291s.xc(this.f10294w);
        } else {
            this.f10291s.xc(this.f10290p);
        }
    }

    @NonNull
    public androidx.navigation.gv n3() {
        return this.f10293v;
    }

    public void s(@NonNull Bundle bundle) {
        this.f10288f.gv(bundle);
    }

    public void v(@NonNull v.n3 n3Var) {
        this.f10294w = gv(n3Var);
        i9();
    }

    @Nullable
    public Bundle y() {
        return this.f10289fb;
    }

    @NonNull
    public v.zn zn() {
        return this.f10290p;
    }

    public fb(@NonNull Context context, @NonNull androidx.navigation.gv gvVar, @Nullable Bundle bundle, @Nullable co coVar, @Nullable s sVar, @NonNull UUID uuid, @Nullable Bundle bundle2) {
        this.f10291s = new androidx.lifecycle.fb(this);
        androidx.savedstate.y y2 = androidx.savedstate.y.y(this);
        this.f10288f = y2;
        this.f10294w = v.zn.CREATED;
        this.f10290p = v.zn.RESUMED;
        this.y = context;
        this.f10292t = uuid;
        this.f10293v = gvVar;
        this.f10289fb = bundle;
        this.f10287co = sVar;
        y2.zn(bundle2);
        if (coVar != null) {
            this.f10294w = coVar.getLifecycle().n3();
        }
    }
}
