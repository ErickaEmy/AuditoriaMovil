package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.datepicker.y;
import java.util.Calendar;
import java.util.Locale;
import qg.f;
/* loaded from: classes.dex */
public class v extends RecyclerView.s<n3> {
    public final com.google.android.material.datepicker.y<?> y;

    /* loaded from: classes.dex */
    public static class n3 extends RecyclerView.ta {
        public final TextView y;

        public n3(TextView textView) {
            super(textView);
            this.y = textView;
        }
    }

    /* loaded from: classes.dex */
    public class y implements View.OnClickListener {
        public final /* synthetic */ int y;

        public y(int i) {
            this.y = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.this.y.g6(v.this.y.fm().v(Month.n3(this.y, v.this.y.p4().f5643v)));
            v.this.y.ky(y.f.DAY);
        }
    }

    public v(com.google.android.material.datepicker.y<?> yVar) {
        this.y = yVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    /* renamed from: fb */
    public void onBindViewHolder(@NonNull n3 n3Var, int i) {
        qg.y yVar;
        int v2 = v(i);
        String string = n3Var.y.getContext().getString(R$string.flo);
        n3Var.y.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(v2)));
        n3Var.y.setContentDescription(String.format(string, Integer.valueOf(v2)));
        qg.n3 w5 = this.y.w5();
        Calendar c52 = f.c5();
        if (c52.get(1) == v2) {
            yVar = w5.f12820a;
        } else {
            yVar = w5.f12822gv;
        }
        for (Long l2 : this.y.ik().ad()) {
            c52.setTimeInMillis(l2.longValue());
            if (c52.get(1) == v2) {
                yVar = w5.f12825v;
            }
        }
        yVar.gv(n3Var.y);
        n3Var.y.setOnClickListener(zn(v2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public int getItemCount() {
        return this.y.fm().t();
    }

    public int gv(int i) {
        return i - this.y.fm().f().f5640fb;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    @NonNull
    /* renamed from: t */
    public n3 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new n3((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.wd, viewGroup, false));
    }

    public int v(int i) {
        return this.y.fm().f().f5640fb + i;
    }

    @NonNull
    public final View.OnClickListener zn(int i) {
        return new y(i);
    }
}
