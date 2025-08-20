package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Iterator;
import qg.f;
/* loaded from: classes.dex */
public class zn extends BaseAdapter {

    /* renamed from: t  reason: collision with root package name */
    public static final int f5699t = f.f().getMaximum(4);

    /* renamed from: f  reason: collision with root package name */
    public final CalendarConstraints f5700f;

    /* renamed from: fb  reason: collision with root package name */
    public Collection<Long> f5701fb;

    /* renamed from: s  reason: collision with root package name */
    public qg.n3 f5702s;

    /* renamed from: v  reason: collision with root package name */
    public final DateSelector<?> f5703v;
    public final Month y;

    public zn(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.y = month;
        this.f5703v = dateSelector;
        this.f5700f = calendarConstraints;
        this.f5701fb = dateSelector.ad();
    }

    public boolean a(int i) {
        if (i % this.y.f5641s == 0) {
            return true;
        }
        return false;
    }

    public int c5() {
        return (this.y.v() + this.y.f5639f) - 1;
    }

    public final void f(@Nullable TextView textView, long j2) {
        qg.y yVar;
        if (textView == null) {
            return;
        }
        if (this.f5700f.fb().b(j2)) {
            textView.setEnabled(true);
            if (s(j2)) {
                yVar = this.f5702s.f12823n3;
            } else if (f.c5().getTimeInMillis() == j2) {
                yVar = this.f5702s.f12826zn;
            } else {
                yVar = this.f5702s.y;
            }
        } else {
            textView.setEnabled(false);
            yVar = this.f5702s.f12821fb;
        }
        yVar.gv(textView);
    }

    public boolean fb(int i) {
        if ((i + 1) % this.y.f5641s == 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.y.f5639f + n3();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.y.f5641s;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    @Override // android.widget.Adapter
    @androidx.annotation.NonNull
    /* renamed from: gv */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r6, @androidx.annotation.Nullable android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            r0 = 1
            android.content.Context r1 = r8.getContext()
            r5.v(r1)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 0
            if (r7 != 0) goto L1f
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r1 = com.google.android.material.R$layout.wa
            android.view.View r7 = r7.inflate(r1, r8, r2)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
        L1f:
            int r7 = r5.n3()
            int r7 = r6 - r7
            if (r7 < 0) goto L75
            com.google.android.material.datepicker.Month r8 = r5.y
            int r3 = r8.f5639f
            if (r7 < r3) goto L2e
            goto L75
        L2e:
            int r7 = r7 + r0
            r1.setTag(r8)
            android.content.res.Resources r8 = r1.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r2] = r3
            java.lang.String r3 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r3, r4)
            r1.setText(r8)
            com.google.android.material.datepicker.Month r8 = r5.y
            long r7 = r8.a(r7)
            com.google.android.material.datepicker.Month r3 = r5.y
            int r3 = r3.f5640fb
            com.google.android.material.datepicker.Month r4 = com.google.android.material.datepicker.Month.gv()
            int r4 = r4.f5640fb
            if (r3 != r4) goto L67
            java.lang.String r7 = qg.zn.y(r7)
            r1.setContentDescription(r7)
            goto L6e
        L67:
            java.lang.String r7 = qg.zn.gv(r7)
            r1.setContentDescription(r7)
        L6e:
            r1.setVisibility(r2)
            r1.setEnabled(r0)
            goto L7d
        L75:
            r7 = 8
            r1.setVisibility(r7)
            r1.setEnabled(r2)
        L7d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L84
            return r1
        L84:
            long r6 = r6.longValue()
            r5.f(r1, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.zn.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public int i9(int i) {
        return (i - this.y.v()) + 1;
    }

    public int n3() {
        return this.y.v();
    }

    public final boolean s(long j2) {
        Iterator<Long> it = this.f5703v.ad().iterator();
        while (it.hasNext()) {
            if (f.y(j2) == f.y(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    public final void t(MaterialCalendarGridView materialCalendarGridView, long j2) {
        if (Month.zn(j2).equals(this.y)) {
            f((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter2().y(this.y.fb(j2)) - materialCalendarGridView.getFirstVisiblePosition()), j2);
        }
    }

    public void tl(MaterialCalendarGridView materialCalendarGridView) {
        for (Long l2 : this.f5701fb) {
            t(materialCalendarGridView, l2.longValue());
        }
        DateSelector<?> dateSelector = this.f5703v;
        if (dateSelector != null) {
            for (Long l3 : dateSelector.ad()) {
                t(materialCalendarGridView, l3.longValue());
            }
            this.f5701fb = this.f5703v.ad();
        }
    }

    public final void v(Context context) {
        if (this.f5702s == null) {
            this.f5702s = new qg.n3(context);
        }
    }

    public boolean wz(int i) {
        if (i >= n3() && i <= c5()) {
            return true;
        }
        return false;
    }

    public int y(int i) {
        return n3() + (i - 1);
    }

    @Override // android.widget.Adapter
    @Nullable
    /* renamed from: zn */
    public Long getItem(int i) {
        if (i >= this.y.v() && i <= c5()) {
            return Long.valueOf(this.y.a(i9(i)));
        }
        return null;
    }
}
