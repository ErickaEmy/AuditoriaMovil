package x9;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import free.daily.tube.module.share_impl.R;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: x9.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0247y extends ViewPager2.c5 {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f14923n3;
        public final /* synthetic */ FragmentManager y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior<ViewGroup> f14924zn;

        public C0247y(FragmentManager fragmentManager, ViewPager2 viewPager2, BottomSheetBehavior<ViewGroup> bottomSheetBehavior) {
            this.y = fragmentManager;
            this.f14923n3 = viewPager2;
            this.f14924zn = bottomSheetBehavior;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.c5
        public void onPageSelected(int i) {
            Long l2;
            View view;
            RecyclerView recyclerView;
            FragmentManager fragmentManager = this.y;
            StringBuilder sb = new StringBuilder();
            sb.append('f');
            RecyclerView.s adapter = this.f14923n3.getAdapter();
            if (adapter != null) {
                l2 = Long.valueOf(adapter.getItemId(i));
            } else {
                l2 = null;
            }
            sb.append(l2);
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(sb.toString());
            if (findFragmentByTag != null && (view = findFragmentByTag.getView()) != null && (recyclerView = (RecyclerView) view.findViewById(R.id.v)) != null) {
                this.f14924zn.f5476ud = new WeakReference<>(recyclerView);
            }
        }
    }

    public static final void y(ViewGroup viewGroup, boolean z2, FragmentManager fm) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(fm, "fm");
        if (z2) {
            BottomSheetBehavior q92 = BottomSheetBehavior.q9(viewGroup);
            ViewPager2 viewPager2 = (ViewPager2) viewGroup.findViewById(R.id.i9);
            if (viewPager2 != null) {
                Intrinsics.checkNotNull(viewPager2);
                View childAt = viewPager2.getChildAt(0);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                ((RecyclerView) childAt).setNestedScrollingEnabled(false);
                viewPager2.fb(new C0247y(fm, viewPager2, q92));
            }
        }
    }
}
