package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class n3 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView.s<?> f5950a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public TabLayout.gv f5951c5;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f5952fb;

    /* renamed from: gv  reason: collision with root package name */
    public final boolean f5953gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public RecyclerView.i9 f5954i9;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public final ViewPager2 f5955n3;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public zn f5956s;

    /* renamed from: v  reason: collision with root package name */
    public final InterfaceC0065n3 f5957v;
    @NonNull
    public final TabLayout y;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean f5958zn;

    /* loaded from: classes.dex */
    public static class gv implements TabLayout.gv {

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f5959n3;
        public final ViewPager2 y;

        public gv(ViewPager2 viewPager2, boolean z2) {
            this.y = viewPager2;
            this.f5959n3 = z2;
        }

        @Override // com.google.android.material.tabs.TabLayout.zn
        public void n3(TabLayout.fb fbVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.zn
        public void y(@NonNull TabLayout.fb fbVar) {
            this.y.i9(fbVar.fb(), this.f5959n3);
        }

        @Override // com.google.android.material.tabs.TabLayout.zn
        public void zn(TabLayout.fb fbVar) {
        }
    }

    /* renamed from: com.google.android.material.tabs.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0065n3 {
        void y(@NonNull TabLayout.fb fbVar, int i);
    }

    /* loaded from: classes.dex */
    public class y extends RecyclerView.i9 {
        public y() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public void onChanged() {
            n3.this.n3();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public void onItemRangeChanged(int i, int i5) {
            n3.this.n3();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public void onItemRangeInserted(int i, int i5) {
            n3.this.n3();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public void onItemRangeMoved(int i, int i5, int i6) {
            n3.this.n3();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public void onItemRangeRemoved(int i, int i5) {
            n3.this.n3();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public void onItemRangeChanged(int i, int i5, @Nullable Object obj) {
            n3.this.n3();
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends ViewPager2.c5 {

        /* renamed from: n3  reason: collision with root package name */
        public int f5960n3;
        @NonNull
        public final WeakReference<TabLayout> y;

        /* renamed from: zn  reason: collision with root package name */
        public int f5961zn;

        public zn(TabLayout tabLayout) {
            this.y = new WeakReference<>(tabLayout);
            y();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.c5
        public void onPageScrollStateChanged(int i) {
            this.f5960n3 = this.f5961zn;
            this.f5961zn = i;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.c5
        public void onPageScrolled(int i, float f4, int i5) {
            boolean z2;
            TabLayout tabLayout = this.y.get();
            if (tabLayout != null) {
                int i6 = this.f5961zn;
                boolean z3 = false;
                if (i6 == 2 && this.f5960n3 != 1) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                tabLayout.x(i, f4, z2, (i6 == 2 && this.f5960n3 == 0) ? true : true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.c5
        public void onPageSelected(int i) {
            boolean z2;
            TabLayout tabLayout = this.y.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i5 = this.f5961zn;
                if (i5 != 0 && (i5 != 2 || this.f5960n3 != 0)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                tabLayout.ej(tabLayout.n(i), z2);
            }
        }

        public void y() {
            this.f5961zn = 0;
            this.f5960n3 = 0;
        }
    }

    public n3(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z2, boolean z3, @NonNull InterfaceC0065n3 interfaceC0065n3) {
        this.y = tabLayout;
        this.f5955n3 = viewPager2;
        this.f5958zn = z2;
        this.f5953gv = z3;
        this.f5957v = interfaceC0065n3;
    }

    public void n3() {
        this.y.mg();
        RecyclerView.s<?> sVar = this.f5950a;
        if (sVar != null) {
            int itemCount = sVar.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                TabLayout.fb d02 = this.y.d0();
                this.f5957v.y(d02, i);
                this.y.fb(d02, false);
            }
            if (itemCount > 0) {
                int min = Math.min(this.f5955n3.getCurrentItem(), this.y.getTabCount() - 1);
                if (min != this.y.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.y;
                    tabLayout.z6(tabLayout.n(min));
                }
            }
        }
    }

    public void y() {
        if (!this.f5952fb) {
            RecyclerView.s<?> adapter = this.f5955n3.getAdapter();
            this.f5950a = adapter;
            if (adapter != null) {
                this.f5952fb = true;
                zn znVar = new zn(this.y);
                this.f5956s = znVar;
                this.f5955n3.fb(znVar);
                gv gvVar = new gv(this.f5955n3, this.f5953gv);
                this.f5951c5 = gvVar;
                this.y.gv(gvVar);
                if (this.f5958zn) {
                    y yVar = new y();
                    this.f5954i9 = yVar;
                    this.f5950a.registerAdapterDataObserver(yVar);
                }
                n3();
                this.y.a8(this.f5955n3.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }
}
