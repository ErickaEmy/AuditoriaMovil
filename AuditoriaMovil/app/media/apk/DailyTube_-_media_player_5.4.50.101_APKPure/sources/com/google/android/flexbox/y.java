package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public int f5058a;

    /* renamed from: c5  reason: collision with root package name */
    public int f5059c5;

    /* renamed from: f  reason: collision with root package name */
    public float f5060f;

    /* renamed from: fb  reason: collision with root package name */
    public int f5061fb;

    /* renamed from: i9  reason: collision with root package name */
    public float f5063i9;

    /* renamed from: mt  reason: collision with root package name */
    public boolean f5064mt;

    /* renamed from: p  reason: collision with root package name */
    public boolean f5066p;

    /* renamed from: s  reason: collision with root package name */
    public int f5067s;

    /* renamed from: t  reason: collision with root package name */
    public int f5068t;

    /* renamed from: tl  reason: collision with root package name */
    public int f5069tl;

    /* renamed from: v  reason: collision with root package name */
    public int f5070v;

    /* renamed from: w  reason: collision with root package name */
    public int f5071w;

    /* renamed from: xc  reason: collision with root package name */
    public int f5073xc;
    public int y = Integer.MAX_VALUE;

    /* renamed from: n3  reason: collision with root package name */
    public int f5065n3 = Integer.MAX_VALUE;

    /* renamed from: zn  reason: collision with root package name */
    public int f5074zn = Integer.MIN_VALUE;

    /* renamed from: gv  reason: collision with root package name */
    public int f5062gv = Integer.MIN_VALUE;

    /* renamed from: wz  reason: collision with root package name */
    public List<Integer> f5072wz = new ArrayList();

    public void gv(View view, int i, int i5, int i6, int i8) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.y = Math.min(this.y, (view.getLeft() - flexItem.yc()) - i);
        this.f5065n3 = Math.min(this.f5065n3, (view.getTop() - flexItem.ta()) - i5);
        this.f5074zn = Math.max(this.f5074zn, view.getRight() + flexItem.qk() + i6);
        this.f5062gv = Math.max(this.f5062gv, view.getBottom() + flexItem.ap() + i8);
    }

    public int n3() {
        return this.f5067s;
    }

    public int y() {
        return this.f5061fb;
    }

    public int zn() {
        return this.f5067s - this.f5059c5;
    }
}
