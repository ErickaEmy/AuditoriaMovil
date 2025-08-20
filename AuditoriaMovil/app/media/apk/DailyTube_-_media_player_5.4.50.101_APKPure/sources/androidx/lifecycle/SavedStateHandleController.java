package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.v;
import androidx.savedstate.SavedStateRegistry;
import y5.b;
import y5.co;
import y5.k5;
import y5.ta;
import y5.ud;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SavedStateHandleController implements a {

    /* renamed from: fb  reason: collision with root package name */
    public final ta f2602fb;

    /* renamed from: v  reason: collision with root package name */
    public boolean f2603v;
    public final String y;

    /* loaded from: classes.dex */
    public static final class y implements SavedStateRegistry.y {
        @Override // androidx.savedstate.SavedStateRegistry.y
        public void y(@NonNull g.y yVar) {
            if (yVar instanceof k5) {
                b viewModelStore = ((k5) yVar).getViewModelStore();
                SavedStateRegistry savedStateRegistry = yVar.getSavedStateRegistry();
                for (String str : viewModelStore.zn()) {
                    SavedStateHandleController.y(viewModelStore.n3(str), savedStateRegistry, yVar.getLifecycle());
                }
                if (!viewModelStore.zn().isEmpty()) {
                    savedStateRegistry.v(y.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    public SavedStateHandleController(String str, ta taVar) {
        this.y = str;
        this.f2602fb = taVar;
    }

    public static void a(final SavedStateRegistry savedStateRegistry, final v vVar) {
        v.zn n32 = vVar.n3();
        if (n32 != v.zn.INITIALIZED && !n32.y(v.zn.STARTED)) {
            vVar.y(new a() { // from class: androidx.lifecycle.SavedStateHandleController.1
                @Override // androidx.lifecycle.a
                public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
                    if (n3Var == v.n3.ON_START) {
                        v.this.zn(this);
                        savedStateRegistry.v(y.class);
                    }
                }
            });
        } else {
            savedStateRegistry.v(y.class);
        }
    }

    public static void y(ud udVar, SavedStateRegistry savedStateRegistry, v vVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) udVar.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.v()) {
            savedStateHandleController.n3(savedStateRegistry, vVar);
            a(savedStateRegistry, vVar);
        }
    }

    public static SavedStateHandleController zn(SavedStateRegistry savedStateRegistry, v vVar, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, ta.y(savedStateRegistry.y(str), bundle));
        savedStateHandleController.n3(savedStateRegistry, vVar);
        a(savedStateRegistry, vVar);
        return savedStateHandleController;
    }

    public ta gv() {
        return this.f2602fb;
    }

    public void n3(SavedStateRegistry savedStateRegistry, v vVar) {
        if (!this.f2603v) {
            this.f2603v = true;
            vVar.y(this);
            savedStateRegistry.gv(this.y, this.f2602fb.v());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    @Override // androidx.lifecycle.a
    public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
        if (n3Var == v.n3.ON_DESTROY) {
            this.f2603v = false;
            coVar.getLifecycle().zn(this);
        }
    }

    public boolean v() {
        return this.f2603v;
    }
}
