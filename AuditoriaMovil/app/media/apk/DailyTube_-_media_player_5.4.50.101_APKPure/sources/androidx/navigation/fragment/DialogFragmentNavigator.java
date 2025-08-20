package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.a;
import androidx.lifecycle.v;
import androidx.navigation.c5;
import androidx.navigation.gv;
import androidx.navigation.s;
import java.util.HashSet;
import lc.n3;
import y5.co;
@c5.n3("dialog")
/* loaded from: classes.dex */
public final class DialogFragmentNavigator extends c5<y> {

    /* renamed from: n3  reason: collision with root package name */
    public final FragmentManager f2751n3;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public int f2753zn;

    /* renamed from: gv  reason: collision with root package name */
    public final HashSet<String> f2750gv = new HashSet<>();

    /* renamed from: v  reason: collision with root package name */
    public a f2752v = new a() { // from class: androidx.navigation.fragment.DialogFragmentNavigator.1
        @Override // androidx.lifecycle.a
        public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
            if (n3Var == v.n3.ON_STOP) {
                DialogFragment dialogFragment = (DialogFragment) coVar;
                if (!dialogFragment.requireDialog().isShowing()) {
                    NavHostFragment.cp(dialogFragment).mt();
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public static class y extends gv implements n3 {

        /* renamed from: z  reason: collision with root package name */
        public String f2754z;

        public y(@NonNull c5<? extends y> c5Var) {
            super(c5Var);
        }

        @NonNull
        public final String r() {
            String str = this.f2754z;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("DialogFragment class was not set");
        }

        @NonNull
        public final y x4(@NonNull String str) {
            this.f2754z = str;
            return this;
        }

        @Override // androidx.navigation.gv
        public void xc(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super.xc(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.f2779zn);
            String string = obtainAttributes.getString(R$styleable.f2765gv);
            if (string != null) {
                x4(string);
            }
            obtainAttributes.recycle();
        }
    }

    public DialogFragmentNavigator(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        this.y = context;
        this.f2751n3 = fragmentManager;
    }

    @Override // androidx.navigation.c5
    @NonNull
    /* renamed from: a */
    public y y() {
        return new y(this);
    }

    @Override // androidx.navigation.c5
    @Nullable
    /* renamed from: fb */
    public gv n3(@NonNull y yVar, @Nullable Bundle bundle, @Nullable s sVar, @Nullable c5.y yVar2) {
        if (this.f2751n3.isStateSaved()) {
            return null;
        }
        String r2 = yVar.r();
        if (r2.charAt(0) == '.') {
            r2 = this.y.getPackageName() + r2;
        }
        Fragment instantiate = this.f2751n3.getFragmentFactory().instantiate(this.y.getClassLoader(), r2);
        if (DialogFragment.class.isAssignableFrom(instantiate.getClass())) {
            DialogFragment dialogFragment = (DialogFragment) instantiate;
            dialogFragment.setArguments(bundle);
            dialogFragment.getLifecycle().y(this.f2752v);
            FragmentManager fragmentManager = this.f2751n3;
            StringBuilder sb = new StringBuilder();
            sb.append("androidx-nav-fragment:navigator:dialog:");
            int i = this.f2753zn;
            this.f2753zn = i + 1;
            sb.append(i);
            dialogFragment.show(fragmentManager, sb.toString());
            return yVar;
        }
        throw new IllegalArgumentException("Dialog destination " + yVar.r() + " is not an instance of DialogFragment");
    }

    @Override // androidx.navigation.c5
    @Nullable
    public Bundle gv() {
        if (this.f2753zn == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.f2753zn);
        return bundle;
    }

    public void s(@NonNull Fragment fragment) {
        if (this.f2750gv.remove(fragment.getTag())) {
            fragment.getLifecycle().y(this.f2752v);
        }
    }

    @Override // androidx.navigation.c5
    public boolean v() {
        if (this.f2753zn == 0 || this.f2751n3.isStateSaved()) {
            return false;
        }
        FragmentManager fragmentManager = this.f2751n3;
        StringBuilder sb = new StringBuilder();
        sb.append("androidx-nav-fragment:navigator:dialog:");
        int i = this.f2753zn - 1;
        this.f2753zn = i;
        sb.append(i);
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(sb.toString());
        if (findFragmentByTag != null) {
            findFragmentByTag.getLifecycle().zn(this.f2752v);
            ((DialogFragment) findFragmentByTag).dismiss();
        }
        return true;
    }

    @Override // androidx.navigation.c5
    public void zn(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.f2753zn = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
            for (int i = 0; i < this.f2753zn; i++) {
                FragmentManager fragmentManager = this.f2751n3;
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag("androidx-nav-fragment:navigator:dialog:" + i);
                if (dialogFragment != null) {
                    dialogFragment.getLifecycle().y(this.f2752v);
                } else {
                    HashSet<String> hashSet = this.f2750gv;
                    hashSet.add("androidx-nav-fragment:navigator:dialog:" + i);
                }
            }
        }
    }
}
