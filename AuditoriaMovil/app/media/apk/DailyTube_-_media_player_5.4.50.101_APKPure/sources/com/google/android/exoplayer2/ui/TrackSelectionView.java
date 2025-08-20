package com.google.android.exoplayer2.ui;

import af.rs;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m1.m;
import m1.v1;
import mn.xc;
import z0.x4;
import zo.f3;
/* loaded from: classes.dex */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: co  reason: collision with root package name */
    public boolean f4814co;

    /* renamed from: f  reason: collision with root package name */
    public final n3 f4815f;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f4816f3;

    /* renamed from: fb  reason: collision with root package name */
    public final CheckedTextView f4817fb;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public Comparator<zn> f4818n;

    /* renamed from: p  reason: collision with root package name */
    public boolean f4819p;

    /* renamed from: r  reason: collision with root package name */
    public CheckedTextView[][] f4820r;

    /* renamed from: s  reason: collision with root package name */
    public final CheckedTextView f4821s;

    /* renamed from: t  reason: collision with root package name */
    public final List<v1.y> f4822t;

    /* renamed from: v  reason: collision with root package name */
    public final LayoutInflater f4823v;

    /* renamed from: w  reason: collision with root package name */
    public final Map<rs, f3> f4824w;
    public final int y;

    /* renamed from: z  reason: collision with root package name */
    public xc f4825z;

    /* loaded from: classes.dex */
    public class n3 implements View.OnClickListener {
        public n3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView.this.zn(view);
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: n3  reason: collision with root package name */
        public final int f4826n3;
        public final v1.y y;

        public zn(v1.y yVar, int i) {
            this.y = yVar;
            this.f4826n3 = i;
        }

        public m y() {
            return this.y.zn(this.f4826n3);
        }
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static Map<rs, f3> n3(Map<rs, f3> map, List<v1.y> list, boolean z2) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            f3 f3Var = map.get(list.get(i).n3());
            if (f3Var != null && (z2 || hashMap.isEmpty())) {
                hashMap.put(f3Var.y, f3Var);
            }
        }
        return hashMap;
    }

    public final void a(View view) {
        boolean z2 = false;
        this.f4816f3 = false;
        zn znVar = (zn) v5.y.v(view.getTag());
        rs n32 = znVar.y.n3();
        int i = znVar.f4826n3;
        f3 f3Var = this.f4824w.get(n32);
        if (f3Var == null) {
            if (!this.f4814co && this.f4824w.size() > 0) {
                this.f4824w.clear();
            }
            this.f4824w.put(n32, new f3(n32, x4.o(Integer.valueOf(i))));
            return;
        }
        ArrayList arrayList = new ArrayList(f3Var.f15761v);
        boolean isChecked = ((CheckedTextView) view).isChecked();
        boolean fb2 = fb(znVar.y);
        z2 = (fb2 || s()) ? true : true;
        if (isChecked && z2) {
            arrayList.remove(Integer.valueOf(i));
            if (arrayList.isEmpty()) {
                this.f4824w.remove(n32);
            } else {
                this.f4824w.put(n32, new f3(n32, arrayList));
            }
        } else if (!isChecked) {
            if (fb2) {
                arrayList.add(Integer.valueOf(i));
                this.f4824w.put(n32, new f3(n32, arrayList));
                return;
            }
            this.f4824w.put(n32, new f3(n32, x4.o(Integer.valueOf(i))));
        }
    }

    public final void c5() {
        boolean z2;
        this.f4817fb.setChecked(this.f4816f3);
        CheckedTextView checkedTextView = this.f4821s;
        if (!this.f4816f3 && this.f4824w.size() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        checkedTextView.setChecked(z2);
        for (int i = 0; i < this.f4820r.length; i++) {
            f3 f3Var = this.f4824w.get(this.f4822t.get(i).n3());
            int i5 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f4820r[i];
                if (i5 < checkedTextViewArr.length) {
                    if (f3Var != null) {
                        this.f4820r[i][i5].setChecked(f3Var.f15761v.contains(Integer.valueOf(((zn) v5.y.v(checkedTextViewArr[i5].getTag())).f4826n3)));
                    } else {
                        checkedTextViewArr[i5].setChecked(false);
                    }
                    i5++;
                }
            }
        }
    }

    public final boolean fb(v1.y yVar) {
        if (this.f4819p && yVar.v()) {
            return true;
        }
        return false;
    }

    public boolean getIsDisabled() {
        return this.f4816f3;
    }

    public Map<rs, f3> getOverrides() {
        return this.f4824w;
    }

    public final void gv() {
        this.f4816f3 = false;
        this.f4824w.clear();
    }

    public final void i9() {
        int i;
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.f4822t.isEmpty()) {
            this.f4817fb.setEnabled(false);
            this.f4821s.setEnabled(false);
            return;
        }
        this.f4817fb.setEnabled(true);
        this.f4821s.setEnabled(true);
        this.f4820r = new CheckedTextView[this.f4822t.size()];
        boolean s2 = s();
        for (int i5 = 0; i5 < this.f4822t.size(); i5++) {
            v1.y yVar = this.f4822t.get(i5);
            boolean fb2 = fb(yVar);
            CheckedTextView[][] checkedTextViewArr = this.f4820r;
            int i6 = yVar.y;
            checkedTextViewArr[i5] = new CheckedTextView[i6];
            zn[] znVarArr = new zn[i6];
            for (int i8 = 0; i8 < yVar.y; i8++) {
                znVarArr[i8] = new zn(yVar, i8);
            }
            Comparator<zn> comparator = this.f4818n;
            if (comparator != null) {
                Arrays.sort(znVarArr, comparator);
            }
            for (int i10 = 0; i10 < i6; i10++) {
                if (i10 == 0) {
                    addView(this.f4823v.inflate(R$layout.bs, (ViewGroup) this, false));
                }
                if (!fb2 && !s2) {
                    i = 17367055;
                } else {
                    i = 17367056;
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.f4823v.inflate(i, (ViewGroup) this, false);
                checkedTextView.setBackgroundResource(this.y);
                checkedTextView.setText(this.f4825z.y(znVarArr[i10].y()));
                checkedTextView.setTag(znVarArr[i10]);
                if (yVar.s(i10)) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener(this.f4815f);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.f4820r[i5][i10] = checkedTextView;
                addView(checkedTextView);
            }
        }
        c5();
    }

    public final boolean s() {
        if (this.f4814co && this.f4822t.size() > 1) {
            return true;
        }
        return false;
    }

    public void setAllowAdaptiveSelections(boolean z2) {
        if (this.f4819p != z2) {
            this.f4819p = z2;
            i9();
        }
    }

    public void setAllowMultipleOverrides(boolean z2) {
        if (this.f4814co != z2) {
            this.f4814co = z2;
            if (!z2 && this.f4824w.size() > 1) {
                Map<rs, f3> n32 = n3(this.f4824w, this.f4822t, false);
                this.f4824w.clear();
                this.f4824w.putAll(n32);
            }
            i9();
        }
    }

    public void setShowDisableOption(boolean z2) {
        int i;
        CheckedTextView checkedTextView = this.f4817fb;
        if (z2) {
            i = 0;
        } else {
            i = 8;
        }
        checkedTextView.setVisibility(i);
    }

    public void setTrackNameProvider(xc xcVar) {
        this.f4825z = (xc) v5.y.v(xcVar);
        i9();
    }

    public final void v() {
        this.f4816f3 = true;
        this.f4824w.clear();
    }

    public final void zn(View view) {
        if (view == this.f4817fb) {
            v();
        } else if (view == this.f4821s) {
            gv();
        } else {
            a(view);
        }
        c5();
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.y = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f4823v = from;
        n3 n3Var = new n3();
        this.f4815f = n3Var;
        this.f4825z = new mn.v(getResources());
        this.f4822t = new ArrayList();
        this.f4824w = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(17367055, (ViewGroup) this, false);
        this.f4817fb = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R$string.zf);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(n3Var);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(R$layout.bs, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(17367055, (ViewGroup) this, false);
        this.f4821s = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R$string.p9);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(n3Var);
        addView(checkedTextView2);
    }
}
