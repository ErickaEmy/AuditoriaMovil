package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.c5;
import androidx.navigation.gv;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
@c5.n3("fragment")
/* loaded from: classes.dex */
public class y extends c5<C0021y> {

    /* renamed from: gv  reason: collision with root package name */
    public ArrayDeque<Integer> f2797gv = new ArrayDeque<>();

    /* renamed from: n3  reason: collision with root package name */
    public final FragmentManager f2798n3;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f2799zn;

    /* loaded from: classes.dex */
    public static final class n3 implements c5.y {
        public final LinkedHashMap<View, String> y;

        @NonNull
        public Map<View, String> y() {
            return Collections.unmodifiableMap(this.y);
        }
    }

    /* renamed from: androidx.navigation.fragment.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0021y extends gv {

        /* renamed from: z  reason: collision with root package name */
        public String f2800z;

        public C0021y(@NonNull c5<? extends C0021y> c5Var) {
            super(c5Var);
        }

        @NonNull
        public final String r() {
            String str = this.f2800z;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("Fragment class was not set");
        }

        @Override // androidx.navigation.gv
        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.f2800z;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            return sb.toString();
        }

        @NonNull
        public final C0021y x4(@NonNull String str) {
            this.f2800z = str;
            return this;
        }

        @Override // androidx.navigation.gv
        public void xc(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super.xc(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.f2761c5);
            String string = obtainAttributes.getString(R$styleable.f2766i9);
            if (string != null) {
                x4(string);
            }
            obtainAttributes.recycle();
        }
    }

    public y(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i) {
        this.y = context;
        this.f2798n3 = fragmentManager;
        this.f2799zn = i;
    }

    @Override // androidx.navigation.c5
    @NonNull
    /* renamed from: a */
    public C0021y y() {
        return new C0021y(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012d A[RETURN] */
    @Override // androidx.navigation.c5
    @androidx.annotation.Nullable
    /* renamed from: c5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.navigation.gv n3(@androidx.annotation.NonNull androidx.navigation.fragment.y.C0021y r9, @androidx.annotation.Nullable android.os.Bundle r10, @androidx.annotation.Nullable androidx.navigation.s r11, @androidx.annotation.Nullable androidx.navigation.c5.y r12) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.y.n3(androidx.navigation.fragment.y$y, android.os.Bundle, androidx.navigation.s, androidx.navigation.c5$y):androidx.navigation.gv");
    }

    @NonNull
    public final String fb(int i, int i5) {
        return i + "-" + i5;
    }

    @Override // androidx.navigation.c5
    @Nullable
    public Bundle gv() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.f2797gv.size()];
        Iterator<Integer> it = this.f2797gv.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        bundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", iArr);
        return bundle;
    }

    @NonNull
    @Deprecated
    public Fragment s(@NonNull Context context, @NonNull FragmentManager fragmentManager, @NonNull String str, @Nullable Bundle bundle) {
        return fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), str);
    }

    @Override // androidx.navigation.c5
    public boolean v() {
        if (this.f2797gv.isEmpty() || this.f2798n3.isStateSaved()) {
            return false;
        }
        this.f2798n3.popBackStack(fb(this.f2797gv.size(), this.f2797gv.peekLast().intValue()), 1);
        this.f2797gv.removeLast();
        return true;
    }

    @Override // androidx.navigation.c5
    public void zn(@Nullable Bundle bundle) {
        int[] intArray;
        if (bundle != null && (intArray = bundle.getIntArray("androidx-nav-fragment:navigator:backStackIds")) != null) {
            this.f2797gv.clear();
            for (int i : intArray) {
                this.f2797gv.add(Integer.valueOf(i));
            }
        }
    }
}
