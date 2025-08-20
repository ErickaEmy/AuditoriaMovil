package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.c5;
import androidx.navigation.fragment.y;
import lc.i9;
import lc.t;
/* loaded from: classes.dex */
public class NavHostFragment extends Fragment {

    /* renamed from: co  reason: collision with root package name */
    public Boolean f2755co;

    /* renamed from: d0  reason: collision with root package name */
    public int f2756d0;

    /* renamed from: f3  reason: collision with root package name */
    public View f2757f3;

    /* renamed from: fb  reason: collision with root package name */
    public i9 f2758fb;

    /* renamed from: fh  reason: collision with root package name */
    public boolean f2759fh;

    @NonNull
    public static NavController cp(@NonNull Fragment fragment) {
        Dialog dialog;
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
            if (fragment2 instanceof NavHostFragment) {
                return ((NavHostFragment) fragment2).ng();
            }
            Fragment primaryNavigationFragment = fragment2.getParentFragmentManager().getPrimaryNavigationFragment();
            if (primaryNavigationFragment instanceof NavHostFragment) {
                return ((NavHostFragment) primaryNavigationFragment).ng();
            }
        }
        View view = fragment.getView();
        if (view != null) {
            return t.n3(view);
        }
        if (fragment instanceof DialogFragment) {
            dialog = ((DialogFragment) fragment).getDialog();
        } else {
            dialog = null;
        }
        if (dialog != null && dialog.getWindow() != null) {
            return t.n3(dialog.getWindow().getDecorView());
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
    }

    public final int gd() {
        int id = getId();
        if (id != 0 && id != -1) {
            return id;
        }
        return R$id.nav_host_fragment_container;
    }

    @NonNull
    @Deprecated
    public c5<? extends y.C0021y> ja() {
        return new y(requireContext(), getChildFragmentManager(), gd());
    }

    @NonNull
    public final NavController ng() {
        i9 i9Var = this.f2758fb;
        if (i9Var != null) {
            return i9Var;
        }
        throw new IllegalStateException("NavController is not available before onCreate()");
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.f2759fh) {
            getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        ((DialogFragmentNavigator) this.f2758fb.i9().gv(DialogFragmentNavigator.class)).s(fragment);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        boolean z2;
        Bundle bundle2;
        i9 i9Var = new i9(requireContext());
        this.f2758fb = i9Var;
        i9Var.d0(this);
        this.f2758fb.fh(requireActivity().getOnBackPressedDispatcher());
        i9 i9Var2 = this.f2758fb;
        Boolean bool = this.f2755co;
        int i = 0;
        if (bool != null && bool.booleanValue()) {
            z2 = true;
        } else {
            z2 = false;
        }
        i9Var2.n3(z2);
        Bundle bundle3 = null;
        this.f2755co = null;
        this.f2758fb.rz(getViewModelStore());
        y0(this.f2758fb);
        if (bundle != null) {
            bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
            if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                this.f2759fh = true;
                getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
            }
            this.f2756d0 = bundle.getInt("android-support-nav:fragment:graphId");
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            this.f2758fb.r(bundle2);
        }
        int i5 = this.f2756d0;
        if (i5 != 0) {
            this.f2758fb.i4(i5);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                i = arguments.getInt("android-support-nav:fragment:graphId");
            }
            if (arguments != null) {
                bundle3 = arguments.getBundle("android-support-nav:fragment:startDestinationArgs");
            }
            if (i != 0) {
                this.f2758fb.f3(i, bundle3);
            }
        }
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView.setId(gd());
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.f2757f3;
        if (view != null && t.n3(view) == this.f2758fb) {
            t.v(this.f2757f3, null);
        }
        this.f2757f3 = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.navigation.R$styleable.f2706w);
        int resourceId = obtainStyledAttributes.getResourceId(androidx.navigation.R$styleable.f2701p, 0);
        if (resourceId != 0) {
            this.f2756d0 = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.f2767mt);
        if (obtainStyledAttributes2.getBoolean(R$styleable.f2762co, false)) {
            this.f2759fh = true;
        }
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrimaryNavigationFragmentChanged(boolean z2) {
        i9 i9Var = this.f2758fb;
        if (i9Var != null) {
            i9Var.n3(z2);
        } else {
            this.f2755co = Boolean.valueOf(z2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle x42 = this.f2758fb.x4();
        if (x42 != null) {
            bundle.putBundle("android-support-nav:fragment:navControllerState", x42);
        }
        if (this.f2759fh) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int i = this.f2756d0;
        if (i != 0) {
            bundle.putInt("android-support-nav:fragment:graphId", i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            t.v(view, this.f2758fb);
            if (view.getParent() != null) {
                View view2 = (View) view.getParent();
                this.f2757f3 = view2;
                if (view2.getId() == getId()) {
                    t.v(this.f2757f3, this.f2758fb);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
    }

    public void y0(@NonNull NavController navController) {
        navController.i9().y(new DialogFragmentNavigator(requireContext(), getChildFragmentManager()));
        navController.i9().y(ja());
    }
}
