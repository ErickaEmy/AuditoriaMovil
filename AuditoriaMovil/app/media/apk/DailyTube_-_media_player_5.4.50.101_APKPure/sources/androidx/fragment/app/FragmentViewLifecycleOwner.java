package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.fb;
import androidx.lifecycle.gv;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import androidx.lifecycle.wz;
import androidx.savedstate.SavedStateRegistry;
import g.y;
import y5.b;
import y5.k5;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FragmentViewLifecycleOwner implements gv, y, k5 {
    private wz.n3 mDefaultFactory;
    private final Fragment mFragment;
    private fb mLifecycleRegistry;
    private androidx.savedstate.y mSavedStateRegistryController;
    private final b mViewModelStore;

    public FragmentViewLifecycleOwner(@NonNull Fragment fragment, @NonNull b bVar) {
        this.mFragment = fragment;
        this.mViewModelStore = bVar;
    }

    @Override // androidx.lifecycle.gv
    @NonNull
    public wz.n3 getDefaultViewModelProviderFactory() {
        Application application;
        wz.n3 defaultViewModelProviderFactory = this.mFragment.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.mFragment.mDefaultFactory)) {
            this.mDefaultFactory = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = this.mFragment.requireContext().getApplicationContext();
            while (true) {
                if (applicationContext instanceof ContextWrapper) {
                    if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                        break;
                    }
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                } else {
                    application = null;
                    break;
                }
            }
            this.mDefaultFactory = new t(application, this, this.mFragment.getArguments());
        }
        return this.mDefaultFactory;
    }

    @Override // y5.co
    @NonNull
    public v getLifecycle() {
        initialize();
        return this.mLifecycleRegistry;
    }

    @Override // g.y
    @NonNull
    public SavedStateRegistry getSavedStateRegistry() {
        initialize();
        return this.mSavedStateRegistryController.n3();
    }

    @Override // y5.k5
    @NonNull
    public b getViewModelStore() {
        initialize();
        return this.mViewModelStore;
    }

    public void handleLifecycleEvent(@NonNull v.n3 n3Var) {
        this.mLifecycleRegistry.s(n3Var);
    }

    public void initialize() {
        if (this.mLifecycleRegistry == null) {
            this.mLifecycleRegistry = new fb(this);
            this.mSavedStateRegistryController = androidx.savedstate.y.y(this);
        }
    }

    public boolean isInitialized() {
        if (this.mLifecycleRegistry != null) {
            return true;
        }
        return false;
    }

    public void performRestore(@Nullable Bundle bundle) {
        this.mSavedStateRegistryController.zn(bundle);
    }

    public void performSave(@NonNull Bundle bundle) {
        this.mSavedStateRegistryController.gv(bundle);
    }

    public void setCurrentState(@NonNull v.zn znVar) {
        this.mLifecycleRegistry.xc(znVar);
    }
}
