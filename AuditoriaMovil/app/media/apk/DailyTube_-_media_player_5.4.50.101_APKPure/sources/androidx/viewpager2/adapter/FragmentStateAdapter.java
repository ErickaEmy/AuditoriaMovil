package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.a;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import hw.i4;
import vl.s;
import y5.co;
import z.v;
/* loaded from: classes.dex */
public abstract class FragmentStateAdapter extends RecyclerView.s<ad.y> implements ad.n3 {

    /* renamed from: co  reason: collision with root package name */
    public boolean f3613co;

    /* renamed from: fb  reason: collision with root package name */
    public final v<Fragment> f3614fb;

    /* renamed from: p  reason: collision with root package name */
    public boolean f3615p;

    /* renamed from: s  reason: collision with root package name */
    public final v<Fragment.SavedState> f3616s;

    /* renamed from: t  reason: collision with root package name */
    public final v<Integer> f3617t;

    /* renamed from: v  reason: collision with root package name */
    public final FragmentManager f3618v;

    /* renamed from: w  reason: collision with root package name */
    public FragmentMaxLifecycleEnforcer f3619w;
    public final androidx.lifecycle.v y;

    /* loaded from: classes.dex */
    public class FragmentMaxLifecycleEnforcer {

        /* renamed from: gv  reason: collision with root package name */
        public ViewPager2 f3624gv;

        /* renamed from: n3  reason: collision with root package name */
        public RecyclerView.i9 f3625n3;

        /* renamed from: v  reason: collision with root package name */
        public long f3626v = -1;
        public ViewPager2.c5 y;

        /* renamed from: zn  reason: collision with root package name */
        public a f3627zn;

        /* loaded from: classes.dex */
        public class n3 extends gv {
            public n3() {
                super(null);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter.gv, androidx.recyclerview.widget.RecyclerView.i9
            public void onChanged() {
                FragmentMaxLifecycleEnforcer.this.gv(true);
            }
        }

        /* loaded from: classes.dex */
        public class y extends ViewPager2.c5 {
            public y() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.c5
            public void onPageScrollStateChanged(int i) {
                FragmentMaxLifecycleEnforcer.this.gv(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.c5
            public void onPageSelected(int i) {
                FragmentMaxLifecycleEnforcer.this.gv(false);
            }
        }

        public FragmentMaxLifecycleEnforcer() {
        }

        public void gv(boolean z2) {
            int currentItem;
            Fragment s2;
            boolean z3;
            if (FragmentStateAdapter.this.fh() || this.f3624gv.getScrollState() != 0 || FragmentStateAdapter.this.f3614fb.f() || FragmentStateAdapter.this.getItemCount() == 0 || (currentItem = this.f3624gv.getCurrentItem()) >= FragmentStateAdapter.this.getItemCount()) {
                return;
            }
            long itemId = FragmentStateAdapter.this.getItemId(currentItem);
            if ((itemId != this.f3626v || z2) && (s2 = FragmentStateAdapter.this.f3614fb.s(itemId)) != null && s2.isAdded()) {
                this.f3626v = itemId;
                FragmentTransaction beginTransaction = FragmentStateAdapter.this.f3618v.beginTransaction();
                Fragment fragment = null;
                for (int i = 0; i < FragmentStateAdapter.this.f3614fb.w(); i++) {
                    long t2 = FragmentStateAdapter.this.f3614fb.t(i);
                    Fragment p2 = FragmentStateAdapter.this.f3614fb.p(i);
                    if (p2.isAdded()) {
                        if (t2 != this.f3626v) {
                            beginTransaction.setMaxLifecycle(p2, v.zn.STARTED);
                        } else {
                            fragment = p2;
                        }
                        if (t2 == this.f3626v) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        p2.setMenuVisibility(z3);
                    }
                }
                if (fragment != null) {
                    beginTransaction.setMaxLifecycle(fragment, v.zn.RESUMED);
                }
                if (!beginTransaction.isEmpty()) {
                    beginTransaction.commitNow();
                }
            }
        }

        public void n3(@NonNull RecyclerView recyclerView) {
            this.f3624gv = y(recyclerView);
            y yVar = new y();
            this.y = yVar;
            this.f3624gv.fb(yVar);
            n3 n3Var = new n3();
            this.f3625n3 = n3Var;
            FragmentStateAdapter.this.registerAdapterDataObserver(n3Var);
            a aVar = new a() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                @Override // androidx.lifecycle.a
                public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var2) {
                    FragmentMaxLifecycleEnforcer.this.gv(false);
                }
            };
            this.f3627zn = aVar;
            FragmentStateAdapter.this.y.y(aVar);
        }

        @NonNull
        public final ViewPager2 y(@NonNull RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public void zn(@NonNull RecyclerView recyclerView) {
            y(recyclerView).wz(this.y);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.f3625n3);
            FragmentStateAdapter.this.y.zn(this.f3627zn);
            this.f3624gv = null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class gv extends RecyclerView.i9 {
        public gv() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public final void onItemRangeChanged(int i, int i5) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public final void onItemRangeInserted(int i, int i5) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public final void onItemRangeMoved(int i, int i5, int i6) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public final void onItemRangeRemoved(int i, int i5) {
            onChanged();
        }

        public /* synthetic */ gv(y yVar) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public final void onItemRangeChanged(int i, int i5, @Nullable Object obj) {
            onChanged();
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends FragmentManager.FragmentLifecycleCallbacks {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ Fragment f3629n3;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ FrameLayout f3630zn;

        public n3(Fragment fragment, FrameLayout frameLayout) {
            this.f3629n3 = fragment;
            this.f3630zn = frameLayout;
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
            if (fragment == this.f3629n3) {
                fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                FragmentStateAdapter.this.n3(view, this.f3630zn);
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements View.OnLayoutChangeListener {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ ad.y f3632v;
        public final /* synthetic */ FrameLayout y;

        public y(FrameLayout frameLayout, ad.y yVar) {
            this.y = frameLayout;
            this.f3632v = yVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i5, int i6, int i8, int i10, int i11, int i12, int i13) {
            if (this.y.getParent() != null) {
                this.y.removeOnLayoutChangeListener(this);
                FragmentStateAdapter.this.f3(this.f3632v);
            }
        }
    }

    /* loaded from: classes.dex */
    public class zn implements Runnable {
        public zn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
            fragmentStateAdapter.f3615p = false;
            fragmentStateAdapter.t();
        }
    }

    public FragmentStateAdapter(@NonNull Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public static long i4(@NonNull String str, @NonNull String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    @NonNull
    public static String v(@NonNull String str, long j2) {
        return str + j2;
    }

    public static boolean w(@NonNull String str, @NonNull String str2) {
        if (str.startsWith(str2) && str.length() > str2.length()) {
            return true;
        }
        return false;
    }

    public final void c() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final zn znVar = new zn();
        this.y.y(new a() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.5
            @Override // androidx.lifecycle.a
            public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
                if (n3Var == v.n3.ON_DESTROY) {
                    handler.removeCallbacks(znVar);
                    coVar.getLifecycle().zn(this);
                }
            }
        });
        handler.postDelayed(znVar, 10000L);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    @NonNull
    /* renamed from: co */
    public final ad.y onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return ad.y.y(viewGroup);
    }

    public final void d0(Fragment fragment, @NonNull FrameLayout frameLayout) {
        this.f3618v.registerFragmentLifecycleCallbacks(new n3(fragment, frameLayout), false);
    }

    public void f3(@NonNull final ad.y yVar) {
        Fragment s2 = this.f3614fb.s(yVar.getItemId());
        if (s2 != null) {
            FrameLayout n32 = yVar.n3();
            View view = s2.getView();
            if (!s2.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            if (s2.isAdded() && view == null) {
                d0(s2, n32);
                return;
            } else if (s2.isAdded() && view.getParent() != null) {
                if (view.getParent() != n32) {
                    n3(view, n32);
                    return;
                }
                return;
            } else if (s2.isAdded()) {
                n3(view, n32);
                return;
            } else if (!fh()) {
                d0(s2, n32);
                FragmentTransaction beginTransaction = this.f3618v.beginTransaction();
                beginTransaction.add(s2, "f" + yVar.getItemId()).setMaxLifecycle(s2, v.zn.STARTED).commitNow();
                this.f3619w.gv(false);
                return;
            } else if (this.f3618v.isDestroyed()) {
                return;
            } else {
                this.y.y(new a() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2
                    @Override // androidx.lifecycle.a
                    public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
                        if (FragmentStateAdapter.this.fh()) {
                            return;
                        }
                        coVar.getLifecycle().zn(this);
                        if (i4.ut(yVar.n3())) {
                            FragmentStateAdapter.this.f3(yVar);
                        }
                    }
                });
                return;
            }
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public final void fb(int i) {
        long itemId = getItemId(i);
        if (!this.f3614fb.a(itemId)) {
            Fragment gv2 = gv(i);
            gv2.setInitialSavedState(this.f3616s.s(itemId));
            this.f3614fb.tl(itemId, gv2);
        }
    }

    public boolean fh() {
        return this.f3618v.isStateSaved();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    public abstract Fragment gv(int i);

    @Override // androidx.recyclerview.widget.RecyclerView.s
    /* renamed from: mt */
    public final void onBindViewHolder(@NonNull ad.y yVar, int i) {
        long itemId = yVar.getItemId();
        int id = yVar.n3().getId();
        Long p2 = p(id);
        if (p2 != null && p2.longValue() != itemId) {
            n(p2.longValue());
            this.f3617t.wz(p2.longValue());
        }
        this.f3617t.tl(itemId, Integer.valueOf(id));
        fb(i);
        FrameLayout n32 = yVar.n3();
        if (i4.ut(n32)) {
            if (n32.getParent() == null) {
                n32.addOnLayoutChangeListener(new y(n32, yVar));
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }
        t();
    }

    public final void n(long j2) {
        ViewParent parent;
        Fragment s2 = this.f3614fb.s(j2);
        if (s2 == null) {
            return;
        }
        if (s2.getView() != null && (parent = s2.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!zn(j2)) {
            this.f3616s.wz(j2);
        }
        if (!s2.isAdded()) {
            this.f3614fb.wz(j2);
        } else if (fh()) {
            this.f3613co = true;
        } else {
            if (s2.isAdded() && zn(j2)) {
                this.f3616s.tl(j2, this.f3618v.saveFragmentInstanceState(s2));
            }
            this.f3618v.beginTransaction().remove(s2).commitNow();
            this.f3614fb.wz(j2);
        }
    }

    public void n3(@NonNull View view, @NonNull FrameLayout frameLayout) {
        if (frameLayout.getChildCount() <= 1) {
            if (view.getParent() == frameLayout) {
                return;
            }
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        boolean z2;
        if (this.f3619w == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        s.y(z2);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.f3619w = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.n3(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.f3619w.zn(recyclerView);
        this.f3619w = null;
    }

    public final Long p(int i) {
        Long l2 = null;
        for (int i5 = 0; i5 < this.f3617t.w(); i5++) {
            if (this.f3617t.p(i5).intValue() == i) {
                if (l2 == null) {
                    l2 = Long.valueOf(this.f3617t.t(i5));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    /* renamed from: r */
    public final void onViewAttachedToWindow(@NonNull ad.y yVar) {
        f3(yVar);
        t();
    }

    @Override // ad.n3
    @NonNull
    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.f3614fb.w() + this.f3616s.w());
        for (int i = 0; i < this.f3614fb.w(); i++) {
            long t2 = this.f3614fb.t(i);
            Fragment s2 = this.f3614fb.s(t2);
            if (s2 != null && s2.isAdded()) {
                this.f3618v.putFragment(bundle, v("f#", t2), s2);
            }
        }
        for (int i5 = 0; i5 < this.f3616s.w(); i5++) {
            long t3 = this.f3616s.t(i5);
            if (zn(t3)) {
                bundle.putParcelable(v("s#", t3), this.f3616s.s(t3));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public final void setHasStableIds(boolean z2) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public void t() {
        if (this.f3613co && !fh()) {
            z.n3<Long> n3Var = new z.n3();
            for (int i = 0; i < this.f3614fb.w(); i++) {
                long t2 = this.f3614fb.t(i);
                if (!zn(t2)) {
                    n3Var.add(Long.valueOf(t2));
                    this.f3617t.wz(t2);
                }
            }
            if (!this.f3615p) {
                this.f3613co = false;
                for (int i5 = 0; i5 < this.f3614fb.w(); i5++) {
                    long t3 = this.f3614fb.t(i5);
                    if (!tl(t3)) {
                        n3Var.add(Long.valueOf(t3));
                    }
                }
            }
            for (Long l2 : n3Var) {
                n(l2.longValue());
            }
        }
    }

    public final boolean tl(long j2) {
        View view;
        if (this.f3617t.a(j2)) {
            return true;
        }
        Fragment s2 = this.f3614fb.s(j2);
        if (s2 != null && (view = s2.getView()) != null && view.getParent() != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    /* renamed from: x4 */
    public final void onViewRecycled(@NonNull ad.y yVar) {
        Long p2 = p(yVar.n3().getId());
        if (p2 != null) {
            n(p2.longValue());
            this.f3617t.wz(p2.longValue());
        }
    }

    @Override // ad.n3
    public final void y(@NonNull Parcelable parcelable) {
        if (this.f3616s.f() && this.f3614fb.f()) {
            Bundle bundle = (Bundle) parcelable;
            if (bundle.getClassLoader() == null) {
                bundle.setClassLoader(getClass().getClassLoader());
            }
            for (String str : bundle.keySet()) {
                if (w(str, "f#")) {
                    this.f3614fb.tl(i4(str, "f#"), this.f3618v.getFragment(bundle, str));
                } else if (w(str, "s#")) {
                    long i42 = i4(str, "s#");
                    Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                    if (zn(i42)) {
                        this.f3616s.tl(i42, savedState);
                    }
                } else {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
            }
            if (!this.f3614fb.f()) {
                this.f3613co = true;
                this.f3615p = true;
                t();
                c();
                return;
            }
            return;
        }
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    /* renamed from: z */
    public final boolean onFailedToRecycleView(@NonNull ad.y yVar) {
        return true;
    }

    public boolean zn(long j2) {
        if (j2 >= 0 && j2 < getItemCount()) {
            return true;
        }
        return false;
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull androidx.lifecycle.v vVar) {
        this.f3614fb = new z.v<>();
        this.f3616s = new z.v<>();
        this.f3617t = new z.v<>();
        this.f3615p = false;
        this.f3613co = false;
        this.f3618v = fragmentManager;
        this.y = vVar;
        super.setHasStableIds(true);
    }
}
