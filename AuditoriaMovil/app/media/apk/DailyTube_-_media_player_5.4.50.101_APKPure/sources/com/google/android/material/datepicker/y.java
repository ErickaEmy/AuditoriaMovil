package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButton;
import hw.i4;
import java.util.Calendar;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class y<S> extends qg.s<S> {

    /* renamed from: co  reason: collision with root package name */
    public int f5676co;
    @Nullable

    /* renamed from: d0  reason: collision with root package name */
    public CalendarConstraints f5677d0;

    /* renamed from: ej  reason: collision with root package name */
    public f f5678ej;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public DateSelector<S> f5679f3;
    @Nullable

    /* renamed from: fh  reason: collision with root package name */
    public Month f5680fh;

    /* renamed from: j5  reason: collision with root package name */
    public qg.n3 f5681j5;

    /* renamed from: oz  reason: collision with root package name */
    public RecyclerView f5682oz;

    /* renamed from: q9  reason: collision with root package name */
    public View f5683q9;

    /* renamed from: qn  reason: collision with root package name */
    public RecyclerView f5684qn;

    /* renamed from: ut  reason: collision with root package name */
    public View f5685ut;

    /* renamed from: f7  reason: collision with root package name */
    public static final Object f5673f7 = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: en  reason: collision with root package name */
    public static final Object f5672en = "NAVIGATION_PREV_TAG";

    /* renamed from: jz  reason: collision with root package name */
    public static final Object f5674jz = "NAVIGATION_NEXT_TAG";

    /* renamed from: y5  reason: collision with root package name */
    public static final Object f5675y5 = "SELECTOR_TOGGLE_TAG";

    /* loaded from: classes.dex */
    public class a extends hw.y {
        public a() {
        }

        @Override // hw.y
        public void fb(View view, @NonNull j5.zn znVar) {
            String string;
            super.fb(view, znVar);
            if (y.this.f5683q9.getVisibility() == 0) {
                string = y.this.getString(R$string.fis);
            } else {
                string = y.this.getString(R$string.fif);
            }
            znVar.bk(string);
        }
    }

    /* loaded from: classes.dex */
    public class c5 implements View.OnClickListener {
        public final /* synthetic */ com.google.android.material.datepicker.gv y;

        public c5(com.google.android.material.datepicker.gv gvVar) {
            this.y = gvVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int e5 = y.this.r3().e5() + 1;
            if (e5 < y.this.f5682oz.getAdapter().getItemCount()) {
                y.this.g6(this.y.zn(e5));
            }
        }
    }

    /* loaded from: classes.dex */
    public enum f {
        DAY,
        YEAR
    }

    /* loaded from: classes.dex */
    public class fb extends RecyclerView.r {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ MaterialButton f5690n3;
        public final /* synthetic */ com.google.android.material.datepicker.gv y;

        public fb(com.google.android.material.datepicker.gv gvVar, MaterialButton materialButton) {
            this.y = gvVar;
            this.f5690n3 = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void n3(@NonNull RecyclerView recyclerView, int i, int i5) {
            int i1;
            if (i < 0) {
                i1 = y.this.r3().e5();
            } else {
                i1 = y.this.r3().i1();
            }
            y.this.f5680fh = this.y.zn(i1);
            this.f5690n3.setText(this.y.gv(i1));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void y(@NonNull RecyclerView recyclerView, int i) {
            if (i == 0) {
                recyclerView.announceForAccessibility(this.f5690n3.getText());
            }
        }
    }

    /* loaded from: classes.dex */
    public class gv implements t {
        public gv() {
        }

        @Override // com.google.android.material.datepicker.y.t
        public void y(long j2) {
            if (y.this.f5677d0.fb().b(j2)) {
                y.this.f5679f3.x5(j2);
                Iterator<qg.fb<S>> it = y.this.f12827fb.iterator();
                while (it.hasNext()) {
                    it.next().y((S) y.this.f5679f3.qj());
                }
                y.this.f5682oz.getAdapter().notifyDataSetChanged();
                if (y.this.f5684qn != null) {
                    y.this.f5684qn.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class i9 implements View.OnClickListener {
        public final /* synthetic */ com.google.android.material.datepicker.gv y;

        public i9(com.google.android.material.datepicker.gv gvVar) {
            this.y = gvVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i1 = y.this.r3().i1() - 1;
            if (i1 >= 0) {
                y.this.g6(this.y.zn(i1));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends hw.y {
        public n3() {
        }

        @Override // hw.y
        public void fb(View view, @NonNull j5.zn znVar) {
            super.fb(view, znVar);
            znVar.ap(null);
        }
    }

    /* loaded from: classes.dex */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            y.this.yz();
        }
    }

    /* loaded from: classes.dex */
    public interface t {
        void y(long j2);
    }

    /* loaded from: classes.dex */
    public class v extends RecyclerView.xc {
        public final Calendar y = qg.f.f();

        /* renamed from: n3  reason: collision with root package name */
        public final Calendar f5694n3 = qg.f.f();

        public v() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.xc
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.fh fhVar) {
            int i;
            int width;
            if ((recyclerView.getAdapter() instanceof com.google.android.material.datepicker.v) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                com.google.android.material.datepicker.v vVar = (com.google.android.material.datepicker.v) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (vl.gv<Long, Long> gvVar : y.this.f5679f3.o4()) {
                    Long l2 = gvVar.y;
                    if (l2 != null && gvVar.f14456n3 != null) {
                        this.y.setTimeInMillis(l2.longValue());
                        this.f5694n3.setTimeInMillis(gvVar.f14456n3.longValue());
                        int gv2 = vVar.gv(this.y.get(1));
                        int gv3 = vVar.gv(this.f5694n3.get(1));
                        View yt2 = gridLayoutManager.yt(gv2);
                        View yt3 = gridLayoutManager.yt(gv3);
                        int iv = gv2 / gridLayoutManager.iv();
                        int iv2 = gv3 / gridLayoutManager.iv();
                        for (int i5 = iv; i5 <= iv2; i5++) {
                            View yt4 = gridLayoutManager.yt(gridLayoutManager.iv() * i5);
                            if (yt4 != null) {
                                int top = yt4.getTop() + y.this.f5681j5.f12822gv.zn();
                                int bottom = yt4.getBottom() - y.this.f5681j5.f12822gv.n3();
                                if (i5 == iv) {
                                    i = yt2.getLeft() + (yt2.getWidth() / 2);
                                } else {
                                    i = 0;
                                }
                                if (i5 == iv2) {
                                    width = yt3.getLeft() + (yt3.getWidth() / 2);
                                } else {
                                    width = recyclerView.getWidth();
                                }
                                canvas.drawRect(i, top, width, bottom, y.this.f5681j5.f12824s);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0061y implements Runnable {
        public final /* synthetic */ int y;

        public RunnableC0061y(int i) {
            this.y = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.f5682oz.smoothScrollToPosition(this.y);
        }
    }

    /* loaded from: classes.dex */
    public class zn extends qg.c5 {

        /* renamed from: dm  reason: collision with root package name */
        public final /* synthetic */ int f5698dm;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public zn(Context context, int i, boolean z2, int i5) {
            super(context, i, z2);
            this.f5698dm = i5;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void ux(@NonNull RecyclerView.fh fhVar, @NonNull int[] iArr) {
            if (this.f5698dm == 0) {
                iArr[0] = y.this.f5682oz.getWidth();
                iArr[1] = y.this.f5682oz.getWidth();
                return;
            }
            iArr[0] = y.this.f5682oz.getHeight();
            iArr[1] = y.this.f5682oz.getHeight();
        }
    }

    public static int ni(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.l0);
    }

    @NonNull
    public static <T> y<T> st(@NonNull DateSelector<T> dateSelector, int i, @NonNull CalendarConstraints calendarConstraints) {
        y<T> yVar = new y<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.i9());
        yVar.setArguments(bundle);
        return yVar;
    }

    public final void el(int i) {
        this.f5682oz.post(new RunnableC0061y(i));
    }

    @Nullable
    public CalendarConstraints fm() {
        return this.f5677d0;
    }

    public void g6(Month month) {
        boolean z2;
        com.google.android.material.datepicker.gv gvVar = (com.google.android.material.datepicker.gv) this.f5682oz.getAdapter();
        int v2 = gvVar.v(month);
        int v3 = v2 - gvVar.v(this.f5680fh);
        boolean z3 = false;
        if (Math.abs(v3) > 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (v3 > 0) {
            z3 = true;
        }
        this.f5680fh = month;
        if (z2 && z3) {
            this.f5682oz.scrollToPosition(v2 - 3);
            el(v2);
        } else if (z2) {
            this.f5682oz.scrollToPosition(v2 + 3);
            el(v2);
        } else {
            el(v2);
        }
    }

    @Nullable
    public DateSelector<S> ik() {
        return this.f5679f3;
    }

    @Override // qg.s
    public boolean ja(@NonNull qg.fb<S> fbVar) {
        return super.ja(fbVar);
    }

    public final void jf(@NonNull View view, @NonNull com.google.android.material.datepicker.gv gvVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.month_navigation_fragment_toggle);
        materialButton.setTag(f5675y5);
        i4.g3(materialButton, new a());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.month_navigation_previous);
        materialButton2.setTag(f5672en);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R$id.month_navigation_next);
        materialButton3.setTag(f5674jz);
        this.f5685ut = view.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f5683q9 = view.findViewById(R$id.mtrl_calendar_day_selector_frame);
        ky(f.DAY);
        materialButton.setText(this.f5680fh.s(view.getContext()));
        this.f5682oz.addOnScrollListener(new fb(gvVar, materialButton));
        materialButton.setOnClickListener(new s());
        materialButton3.setOnClickListener(new c5(gvVar));
        materialButton2.setOnClickListener(new i9(gvVar));
    }

    public void ky(f fVar) {
        this.f5678ej = fVar;
        if (fVar == f.YEAR) {
            this.f5684qn.getLayoutManager().xq(((com.google.android.material.datepicker.v) this.f5684qn.getAdapter()).gv(this.f5680fh.f5640fb));
            this.f5685ut.setVisibility(0);
            this.f5683q9.setVisibility(8);
        } else if (fVar == f.DAY) {
            this.f5685ut.setVisibility(8);
            this.f5683q9.setVisibility(0);
            g6(this.f5680fh);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f5676co = bundle.getInt("THEME_RES_ID_KEY");
        this.f5679f3 = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f5677d0 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f5680fh = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i;
        int i5;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f5676co);
        this.f5681j5 = new qg.n3(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month f4 = this.f5677d0.f();
        if (com.google.android.material.datepicker.n3.ni(contextThemeWrapper)) {
            i = R$layout.co;
            i5 = 1;
        } else {
            i = R$layout.wj;
            i5 = 0;
        }
        View inflate = cloneInContext.inflate(i, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R$id.mtrl_calendar_days_of_week);
        i4.g3(gridView, new n3());
        gridView.setAdapter((ListAdapter) new qg.gv());
        gridView.setNumColumns(f4.f5641s);
        gridView.setEnabled(false);
        this.f5682oz = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_months);
        this.f5682oz.setLayoutManager(new zn(getContext(), i5, false, i5));
        this.f5682oz.setTag(f5673f7);
        com.google.android.material.datepicker.gv gvVar = new com.google.android.material.datepicker.gv(contextThemeWrapper, this.f5679f3, this.f5677d0, new gv());
        this.f5682oz.setAdapter(gvVar);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.n3);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f5684qn = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f5684qn.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f5684qn.setAdapter(new com.google.android.material.datepicker.v(this));
            this.f5684qn.addItemDecoration(x2());
        }
        if (inflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            jf(inflate, gvVar);
        }
        if (!com.google.android.material.datepicker.n3.ni(contextThemeWrapper)) {
            new androidx.recyclerview.widget.t().n3(this.f5682oz);
        }
        this.f5682oz.scrollToPosition(gvVar.v(this.f5680fh));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f5676co);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f5679f3);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f5677d0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f5680fh);
    }

    @Nullable
    public Month p4() {
        return this.f5680fh;
    }

    @NonNull
    public LinearLayoutManager r3() {
        return (LinearLayoutManager) this.f5682oz.getLayoutManager();
    }

    public qg.n3 w5() {
        return this.f5681j5;
    }

    @NonNull
    public final RecyclerView.xc x2() {
        return new v();
    }

    public void yz() {
        f fVar = this.f5678ej;
        f fVar2 = f.YEAR;
        if (fVar == fVar2) {
            ky(f.DAY);
        } else if (fVar == f.DAY) {
            ky(fVar2);
        }
    }
}
