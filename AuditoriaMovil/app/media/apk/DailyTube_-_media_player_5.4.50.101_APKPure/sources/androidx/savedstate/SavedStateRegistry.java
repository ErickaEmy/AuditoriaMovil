package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.a;
import androidx.lifecycle.v;
import androidx.savedstate.Recreator;
import java.util.Map;
import y5.co;
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: gv  reason: collision with root package name */
    public Recreator.y f3376gv;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public Bundle f3377n3;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f3379zn;
    public w.n3<String, n3> y = new w.n3<>();

    /* renamed from: v  reason: collision with root package name */
    public boolean f3378v = true;

    /* loaded from: classes.dex */
    public interface n3 {
        @NonNull
        Bundle saveState();
    }

    /* loaded from: classes.dex */
    public interface y {
        void y(@NonNull g.y yVar);
    }

    public void gv(@NonNull String str, @NonNull n3 n3Var) {
        if (this.y.a(str, n3Var) == null) {
            return;
        }
        throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
    }

    public void n3(@NonNull v vVar, @Nullable Bundle bundle) {
        if (!this.f3379zn) {
            if (bundle != null) {
                this.f3377n3 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            vVar.y(new a() { // from class: androidx.savedstate.SavedStateRegistry.1
                @Override // androidx.lifecycle.a
                public void onStateChanged(co coVar, v.n3 n3Var) {
                    if (n3Var == v.n3.ON_START) {
                        SavedStateRegistry.this.f3378v = true;
                    } else if (n3Var == v.n3.ON_STOP) {
                        SavedStateRegistry.this.f3378v = false;
                    }
                }
            });
            this.f3379zn = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    public void v(@NonNull Class<? extends y> cls) {
        if (this.f3378v) {
            if (this.f3376gv == null) {
                this.f3376gv = new Recreator.y(this);
            }
            try {
                cls.getDeclaredConstructor(null);
                this.f3376gv.y(cls.getName());
                return;
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    @Nullable
    public Bundle y(@NonNull String str) {
        if (this.f3379zn) {
            Bundle bundle = this.f3377n3;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f3377n3.remove(str);
            if (this.f3377n3.isEmpty()) {
                this.f3377n3 = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public void zn(@NonNull Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f3377n3;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        w.n3<String, n3>.gv zn2 = this.y.zn();
        while (zn2.hasNext()) {
            Map.Entry next = zn2.next();
            bundle2.putBundle((String) next.getKey(), ((n3) next.getValue()).saveState());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
