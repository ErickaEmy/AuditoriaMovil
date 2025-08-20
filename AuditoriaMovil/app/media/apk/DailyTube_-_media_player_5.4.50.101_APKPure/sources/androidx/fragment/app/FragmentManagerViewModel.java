package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.wz;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import y5.b;
import y5.ud;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FragmentManagerViewModel extends ud {
    private static final wz.n3 FACTORY = new wz.n3() { // from class: androidx.fragment.app.FragmentManagerViewModel.1
        @Override // androidx.lifecycle.wz.n3
        @NonNull
        public <T extends ud> T create(@NonNull Class<T> cls) {
            return new FragmentManagerViewModel(true);
        }
    };
    private final boolean mStateAutomaticallySaved;
    private final HashMap<String, Fragment> mRetainedFragments = new HashMap<>();
    private final HashMap<String, FragmentManagerViewModel> mChildNonConfigs = new HashMap<>();
    private final HashMap<String, b> mViewModelStores = new HashMap<>();
    private boolean mHasBeenCleared = false;
    private boolean mHasSavedSnapshot = false;
    private boolean mIsStateSaved = false;

    public FragmentManagerViewModel(boolean z2) {
        this.mStateAutomaticallySaved = z2;
    }

    @NonNull
    public static FragmentManagerViewModel getInstance(b bVar) {
        return (FragmentManagerViewModel) new wz(bVar, FACTORY).y(FragmentManagerViewModel.class);
    }

    public void addRetainedFragment(@NonNull Fragment fragment) {
        if (this.mIsStateSaved) {
            FragmentManager.isLoggingEnabled(2);
        } else if (this.mRetainedFragments.containsKey(fragment.mWho)) {
        } else {
            this.mRetainedFragments.put(fragment.mWho, fragment);
            FragmentManager.isLoggingEnabled(2);
        }
    }

    public void clearNonConfigState(@NonNull Fragment fragment) {
        FragmentManager.isLoggingEnabled(3);
        FragmentManagerViewModel fragmentManagerViewModel = this.mChildNonConfigs.get(fragment.mWho);
        if (fragmentManagerViewModel != null) {
            fragmentManagerViewModel.onCleared();
            this.mChildNonConfigs.remove(fragment.mWho);
        }
        b bVar = this.mViewModelStores.get(fragment.mWho);
        if (bVar != null) {
            bVar.y();
            this.mViewModelStores.remove(fragment.mWho);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FragmentManagerViewModel.class != obj.getClass()) {
            return false;
        }
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
        if (this.mRetainedFragments.equals(fragmentManagerViewModel.mRetainedFragments) && this.mChildNonConfigs.equals(fragmentManagerViewModel.mChildNonConfigs) && this.mViewModelStores.equals(fragmentManagerViewModel.mViewModelStores)) {
            return true;
        }
        return false;
    }

    @Nullable
    public Fragment findRetainedFragmentByWho(String str) {
        return this.mRetainedFragments.get(str);
    }

    @NonNull
    public FragmentManagerViewModel getChildNonConfig(@NonNull Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel = this.mChildNonConfigs.get(fragment.mWho);
        if (fragmentManagerViewModel == null) {
            FragmentManagerViewModel fragmentManagerViewModel2 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
            this.mChildNonConfigs.put(fragment.mWho, fragmentManagerViewModel2);
            return fragmentManagerViewModel2;
        }
        return fragmentManagerViewModel;
    }

    @NonNull
    public Collection<Fragment> getRetainedFragments() {
        return new ArrayList(this.mRetainedFragments.values());
    }

    @Nullable
    @Deprecated
    public FragmentManagerNonConfig getSnapshot() {
        if (this.mRetainedFragments.isEmpty() && this.mChildNonConfigs.isEmpty() && this.mViewModelStores.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, FragmentManagerViewModel> entry : this.mChildNonConfigs.entrySet()) {
            FragmentManagerNonConfig snapshot = entry.getValue().getSnapshot();
            if (snapshot != null) {
                hashMap.put(entry.getKey(), snapshot);
            }
        }
        this.mHasSavedSnapshot = true;
        if (this.mRetainedFragments.isEmpty() && hashMap.isEmpty() && this.mViewModelStores.isEmpty()) {
            return null;
        }
        return new FragmentManagerNonConfig(new ArrayList(this.mRetainedFragments.values()), hashMap, new HashMap(this.mViewModelStores));
    }

    @NonNull
    public b getViewModelStore(@NonNull Fragment fragment) {
        b bVar = this.mViewModelStores.get(fragment.mWho);
        if (bVar == null) {
            b bVar2 = new b();
            this.mViewModelStores.put(fragment.mWho, bVar2);
            return bVar2;
        }
        return bVar;
    }

    public int hashCode() {
        return (((this.mRetainedFragments.hashCode() * 31) + this.mChildNonConfigs.hashCode()) * 31) + this.mViewModelStores.hashCode();
    }

    public boolean isCleared() {
        return this.mHasBeenCleared;
    }

    @Override // y5.ud
    public void onCleared() {
        FragmentManager.isLoggingEnabled(3);
        this.mHasBeenCleared = true;
    }

    public void removeRetainedFragment(@NonNull Fragment fragment) {
        if (this.mIsStateSaved) {
            FragmentManager.isLoggingEnabled(2);
        } else if (this.mRetainedFragments.remove(fragment.mWho) != null) {
            FragmentManager.isLoggingEnabled(2);
        }
    }

    @Deprecated
    public void restoreFromSnapshot(@Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.mRetainedFragments.clear();
        this.mChildNonConfigs.clear();
        this.mViewModelStores.clear();
        if (fragmentManagerNonConfig != null) {
            Collection<Fragment> fragments = fragmentManagerNonConfig.getFragments();
            if (fragments != null) {
                for (Fragment fragment : fragments) {
                    if (fragment != null) {
                        this.mRetainedFragments.put(fragment.mWho, fragment);
                    }
                }
            }
            Map<String, FragmentManagerNonConfig> childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
            if (childNonConfigs != null) {
                for (Map.Entry<String, FragmentManagerNonConfig> entry : childNonConfigs.entrySet()) {
                    FragmentManagerViewModel fragmentManagerViewModel = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
                    fragmentManagerViewModel.restoreFromSnapshot(entry.getValue());
                    this.mChildNonConfigs.put(entry.getKey(), fragmentManagerViewModel);
                }
            }
            Map<String, b> viewModelStores = fragmentManagerNonConfig.getViewModelStores();
            if (viewModelStores != null) {
                this.mViewModelStores.putAll(viewModelStores);
            }
        }
        this.mHasSavedSnapshot = false;
    }

    public void setIsStateSaved(boolean z2) {
        this.mIsStateSaved = z2;
    }

    public boolean shouldDestroy(@NonNull Fragment fragment) {
        if (!this.mRetainedFragments.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.mStateAutomaticallySaved) {
            return this.mHasBeenCleared;
        }
        return !this.mHasSavedSnapshot;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.mRetainedFragments.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.mChildNonConfigs.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.mViewModelStores.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
