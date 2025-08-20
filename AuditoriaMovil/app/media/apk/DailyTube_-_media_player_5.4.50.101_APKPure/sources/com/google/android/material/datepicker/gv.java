package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.y;
import hw.i4;
/* loaded from: classes.dex */
public class gv extends RecyclerView.s<n3> {

    /* renamed from: fb  reason: collision with root package name */
    public final DateSelector<?> f5645fb;

    /* renamed from: s  reason: collision with root package name */
    public final y.t f5646s;

    /* renamed from: t  reason: collision with root package name */
    public final int f5647t;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public final CalendarConstraints f5648v;
    public final Context y;

    /* loaded from: classes.dex */
    public static class n3 extends RecyclerView.ta {

        /* renamed from: n3  reason: collision with root package name */
        public final MaterialCalendarGridView f5649n3;
        public final TextView y;

        public n3(@NonNull LinearLayout linearLayout, boolean z2) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.y = textView;
            i4.m(textView, true);
            this.f5649n3 = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (!z2) {
                textView.setVisibility(8);
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements AdapterView.OnItemClickListener {
        public final /* synthetic */ MaterialCalendarGridView y;

        public y(MaterialCalendarGridView materialCalendarGridView) {
            this.y = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
            if (this.y.getAdapter2().wz(i)) {
                gv.this.f5646s.y(this.y.getAdapter2().getItem(i).longValue());
            }
        }
    }

    public gv(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, y.t tVar) {
        int i;
        Month f4 = calendarConstraints.f();
        Month s2 = calendarConstraints.s();
        Month i92 = calendarConstraints.i9();
        if (f4.compareTo(i92) <= 0) {
            if (i92.compareTo(s2) <= 0) {
                int ni = zn.f5699t * com.google.android.material.datepicker.y.ni(context);
                if (com.google.android.material.datepicker.n3.ni(context)) {
                    i = com.google.android.material.datepicker.y.ni(context);
                } else {
                    i = 0;
                }
                this.y = context;
                this.f5647t = ni + i;
                this.f5648v = calendarConstraints;
                this.f5645fb = dateSelector;
                this.f5646s = tVar;
                setHasStableIds(true);
                return;
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    /* renamed from: fb */
    public void onBindViewHolder(@NonNull n3 n3Var, int i) {
        Month f4 = this.f5648v.f().f(i);
        n3Var.y.setText(f4.s(n3Var.itemView.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) n3Var.f5649n3.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter2() != null && f4.equals(materialCalendarGridView.getAdapter2().y)) {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter2().tl(materialCalendarGridView);
        } else {
            zn znVar = new zn(f4, this.f5645fb, this.f5648v);
            materialCalendarGridView.setNumColumns(f4.f5641s);
            materialCalendarGridView.setAdapter((ListAdapter) znVar);
        }
        materialCalendarGridView.setOnItemClickListener(new y(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public int getItemCount() {
        return this.f5648v.c5();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public long getItemId(int i) {
        return this.f5648v.f().f(i).c5();
    }

    @NonNull
    public CharSequence gv(int i) {
        return zn(i).s(this.y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    @NonNull
    /* renamed from: t */
    public n3 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mt, viewGroup, false);
        if (com.google.android.material.datepicker.n3.ni(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f5647t));
            return new n3(linearLayout, true);
        }
        return new n3(linearLayout, false);
    }

    public int v(@NonNull Month month) {
        return this.f5648v.f().t(month);
    }

    @NonNull
    public Month zn(int i) {
        return this.f5648v.f().f(i);
    }
}
