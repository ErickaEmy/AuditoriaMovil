package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import hw.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class n3 {
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public long[] f5052gv;

    /* renamed from: n3  reason: collision with root package name */
    public boolean[] f5053n3;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public long[] f5054v;
    public final zf.y y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public int[] f5055zn;

    /* renamed from: com.google.android.flexbox.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0056n3 {

        /* renamed from: n3  reason: collision with root package name */
        public int f5056n3;
        public List<com.google.android.flexbox.y> y;

        public void y() {
            this.y = null;
            this.f5056n3 = 0;
        }
    }

    /* loaded from: classes.dex */
    public static class zn implements Comparable<zn> {

        /* renamed from: v  reason: collision with root package name */
        public int f5057v;
        public int y;

        public zn() {
        }

        @NonNull
        public String toString() {
            return "Order{order=" + this.f5057v + ", index=" + this.y + '}';
        }

        @Override // java.lang.Comparable
        /* renamed from: y */
        public int compareTo(@NonNull zn znVar) {
            int i = this.f5057v;
            int i5 = znVar.f5057v;
            if (i != i5) {
                return i - i5;
            }
            return this.y - znVar.y;
        }
    }

    public n3(zf.y yVar) {
        this.y = yVar;
    }

    public void a(C0056n3 c0056n3, int i, int i5) {
        n3(c0056n3, i5, i, Integer.MAX_VALUE, 0, -1, null);
    }

    public final int a8(boolean z2) {
        if (z2) {
            return this.y.getPaddingTop();
        }
        return this.y.getPaddingStart();
    }

    public final int b(View view, boolean z2) {
        if (z2) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    public final int c(int i, FlexItem flexItem, int i5) {
        zf.y yVar = this.y;
        int v2 = yVar.v(i, yVar.getPaddingTop() + this.y.getPaddingBottom() + flexItem.ta() + flexItem.ap() + i5, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(v2);
        if (size > flexItem.vp()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.vp(), View.MeasureSpec.getMode(v2));
        }
        if (size < flexItem.l()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.l(), View.MeasureSpec.getMode(v2));
        }
        return v2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c5(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.x4()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.x4()
        L19:
            r3 = 1
            goto L27
        L1b:
            int r3 = r0.jz()
            if (r1 <= r3) goto L26
            int r1 = r0.jz()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.l()
            if (r2 >= r5) goto L32
            int r2 = r0.l()
            goto L3e
        L32:
            int r5 = r0.vp()
            if (r2 <= r5) goto L3d
            int r2 = r0.vp()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.en(r8, r1, r0, r7)
            zf.y r0 = r6.y
            r0.c5(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.n3.c5(android.view.View, int):void");
    }

    public void co(int i) {
        int[] iArr = this.f5055zn;
        if (iArr == null) {
            this.f5055zn = new int[Math.max(i, 10)];
        } else if (iArr.length < i) {
            this.f5055zn = Arrays.copyOf(this.f5055zn, Math.max(iArr.length * 2, i));
        }
    }

    public final int d(FlexItem flexItem, boolean z2) {
        if (z2) {
            return flexItem.getHeight();
        }
        return flexItem.getWidth();
    }

    public final int d0(int i, FlexItem flexItem, int i5) {
        zf.y yVar = this.y;
        int zn2 = yVar.zn(i, yVar.getPaddingLeft() + this.y.getPaddingRight() + flexItem.yc() + flexItem.qk() + i5, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(zn2);
        if (size > flexItem.jz()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.jz(), View.MeasureSpec.getMode(zn2));
        }
        if (size < flexItem.x4()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.x4(), View.MeasureSpec.getMode(zn2));
        }
        return zn2;
    }

    public final int ej(boolean z2) {
        if (z2) {
            return this.y.getPaddingBottom();
        }
        return this.y.getPaddingEnd();
    }

    public final void en(int i, int i5, int i6, View view) {
        long[] jArr = this.f5052gv;
        if (jArr != null) {
            jArr[i] = o(i5, i6);
        }
        long[] jArr2 = this.f5054v;
        if (jArr2 != null) {
            jArr2[i] = o(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public final List<com.google.android.flexbox.y> f(List<com.google.android.flexbox.y> list, int i, int i5) {
        ArrayList arrayList = new ArrayList();
        com.google.android.flexbox.y yVar = new com.google.android.flexbox.y();
        yVar.f5061fb = (i - i5) / 2;
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (i6 == 0) {
                arrayList.add(yVar);
            }
            arrayList.add(list.get(i6));
            if (i6 == list.size() - 1) {
                arrayList.add(yVar);
            }
        }
        return arrayList;
    }

    public int f3(long j2) {
        return (int) (j2 >> 32);
    }

    public void f7(int i) {
        int i5;
        View s2;
        if (i >= this.y.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.y.getFlexDirection();
        if (this.y.getAlignItems() == 4) {
            int[] iArr = this.f5055zn;
            if (iArr != null) {
                i5 = iArr[i];
            } else {
                i5 = 0;
            }
            List<com.google.android.flexbox.y> flexLinesInternal = this.y.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            while (i5 < size) {
                com.google.android.flexbox.y yVar = flexLinesInternal.get(i5);
                int i6 = yVar.f5067s;
                for (int i8 = 0; i8 < i6; i8++) {
                    int i10 = yVar.f5073xc + i8;
                    if (i8 < this.y.getFlexItemCount() && (s2 = this.y.s(i10)) != null && s2.getVisibility() != 8) {
                        FlexItem flexItem = (FlexItem) s2.getLayoutParams();
                        if (flexItem.p() == -1 || flexItem.p() == 4) {
                            if (flexDirection != 0 && flexDirection != 1) {
                                if (flexDirection != 2 && flexDirection != 3) {
                                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                                }
                                ut(s2, yVar.f5061fb, i10);
                            } else {
                                q9(s2, yVar.f5061fb, i10);
                            }
                        }
                    }
                }
                i5++;
            }
            return;
        }
        for (com.google.android.flexbox.y yVar2 : this.y.getFlexLinesInternal()) {
            for (Integer num : yVar2.f5072wz) {
                View s3 = this.y.s(num.intValue());
                if (flexDirection != 0 && flexDirection != 1) {
                    if (flexDirection != 2 && flexDirection != 3) {
                        throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                    }
                    ut(s3, yVar2.f5061fb, num.intValue());
                } else {
                    q9(s3, yVar2.f5061fb, num.intValue());
                }
            }
        }
    }

    public void fb(C0056n3 c0056n3, int i, int i5, int i6, int i8, @Nullable List<com.google.android.flexbox.y> list) {
        n3(c0056n3, i5, i, i6, i8, -1, list);
    }

    public final int fh(FlexItem flexItem, boolean z2) {
        if (z2) {
            return flexItem.ap();
        }
        return flexItem.qk();
    }

    public void gv(C0056n3 c0056n3, int i, int i5, int i6, int i8, @Nullable List<com.google.android.flexbox.y> list) {
        n3(c0056n3, i, i5, i6, i8, -1, list);
    }

    public final boolean hw(View view, int i, int i5, int i6, int i8, FlexItem flexItem, int i10, int i11, int i12) {
        if (this.y.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.j()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.y.getMaxLine();
        if (maxLine != -1 && maxLine <= i12 + 1) {
            return false;
        }
        int i92 = this.y.i9(view, i10, i11);
        if (i92 > 0) {
            i8 += i92;
        }
        if (i5 >= i6 + i8) {
            return false;
        }
        return true;
    }

    public final void i4(int i, int i5, com.google.android.flexbox.y yVar, int i6, int i8, boolean z2) {
        int i10;
        int i11;
        int i12;
        double d2;
        int i13;
        double d3;
        float f4 = yVar.f5063i9;
        float f6 = 0.0f;
        if (f4 > 0.0f && i6 >= (i10 = yVar.f5070v)) {
            float f9 = (i6 - i10) / f4;
            yVar.f5070v = i8 + yVar.f5058a;
            if (!z2) {
                yVar.f5061fb = Integer.MIN_VALUE;
            }
            int i14 = 0;
            boolean z3 = false;
            int i15 = 0;
            float f10 = 0.0f;
            while (i14 < yVar.f5067s) {
                int i16 = yVar.f5073xc + i14;
                View s2 = this.y.s(i16);
                if (s2 == null || s2.getVisibility() == 8) {
                    i11 = i10;
                } else {
                    FlexItem flexItem = (FlexItem) s2.getLayoutParams();
                    int flexDirection = this.y.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int i17 = i10;
                        int measuredWidth = s2.getMeasuredWidth();
                        long[] jArr = this.f5054v;
                        if (jArr != null) {
                            measuredWidth = n(jArr[i16]);
                        }
                        int measuredHeight = s2.getMeasuredHeight();
                        long[] jArr2 = this.f5054v;
                        i11 = i17;
                        if (jArr2 != null) {
                            measuredHeight = f3(jArr2[i16]);
                        }
                        if (!this.f5053n3[i16] && flexItem.ud() > 0.0f) {
                            float ud2 = measuredWidth + (flexItem.ud() * f9);
                            if (i14 == yVar.f5067s - 1) {
                                ud2 += f10;
                                f10 = 0.0f;
                            }
                            int round = Math.round(ud2);
                            if (round > flexItem.jz()) {
                                round = flexItem.jz();
                                this.f5053n3[i16] = true;
                                yVar.f5063i9 -= flexItem.ud();
                                z3 = true;
                            } else {
                                f10 += ud2 - round;
                                double d4 = f10;
                                if (d4 > 1.0d) {
                                    round++;
                                    d2 = d4 - 1.0d;
                                } else if (d4 < -1.0d) {
                                    round--;
                                    d2 = d4 + 1.0d;
                                }
                                f10 = (float) d2;
                            }
                            int c2 = c(i5, flexItem, yVar.f5069tl);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                            s2.measure(makeMeasureSpec, c2);
                            int measuredWidth2 = s2.getMeasuredWidth();
                            int measuredHeight2 = s2.getMeasuredHeight();
                            en(i16, makeMeasureSpec, c2, s2);
                            this.y.c5(i16, s2);
                            measuredWidth = measuredWidth2;
                            measuredHeight = measuredHeight2;
                        }
                        int max = Math.max(i15, measuredHeight + flexItem.ta() + flexItem.ap() + this.y.a(s2));
                        yVar.f5070v += measuredWidth + flexItem.yc() + flexItem.qk();
                        i12 = max;
                    } else {
                        int measuredHeight3 = s2.getMeasuredHeight();
                        long[] jArr3 = this.f5054v;
                        if (jArr3 != null) {
                            measuredHeight3 = f3(jArr3[i16]);
                        }
                        int measuredWidth3 = s2.getMeasuredWidth();
                        long[] jArr4 = this.f5054v;
                        if (jArr4 != null) {
                            measuredWidth3 = n(jArr4[i16]);
                        }
                        if (!this.f5053n3[i16] && flexItem.ud() > f6) {
                            float ud3 = measuredHeight3 + (flexItem.ud() * f9);
                            if (i14 == yVar.f5067s - 1) {
                                ud3 += f10;
                                f10 = 0.0f;
                            }
                            int round2 = Math.round(ud3);
                            if (round2 > flexItem.vp()) {
                                round2 = flexItem.vp();
                                this.f5053n3[i16] = true;
                                yVar.f5063i9 -= flexItem.ud();
                                i13 = i10;
                                z3 = true;
                            } else {
                                f10 += ud3 - round2;
                                i13 = i10;
                                double d5 = f10;
                                if (d5 > 1.0d) {
                                    round2++;
                                    d3 = d5 - 1.0d;
                                } else if (d5 < -1.0d) {
                                    round2--;
                                    d3 = d5 + 1.0d;
                                }
                                f10 = (float) d3;
                            }
                            int d02 = d0(i, flexItem, yVar.f5069tl);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            s2.measure(d02, makeMeasureSpec2);
                            measuredWidth3 = s2.getMeasuredWidth();
                            int measuredHeight4 = s2.getMeasuredHeight();
                            en(i16, d02, makeMeasureSpec2, s2);
                            this.y.c5(i16, s2);
                            measuredHeight3 = measuredHeight4;
                        } else {
                            i13 = i10;
                        }
                        i12 = Math.max(i15, measuredWidth3 + flexItem.yc() + flexItem.qk() + this.y.a(s2));
                        yVar.f5070v += measuredHeight3 + flexItem.ta() + flexItem.ap();
                        i11 = i13;
                    }
                    yVar.f5061fb = Math.max(yVar.f5061fb, i12);
                    i15 = i12;
                }
                i14++;
                i10 = i11;
                f6 = 0.0f;
            }
            int i18 = i10;
            if (z3 && i18 != yVar.f5070v) {
                i4(i, i5, yVar, i6, i8, true);
            }
        }
    }

    public void i9(List<com.google.android.flexbox.y> list, int i) {
        int i5 = this.f5055zn[i];
        if (i5 == -1) {
            i5 = 0;
        }
        if (list.size() > i5) {
            list.subList(i5, list.size()).clear();
        }
        int[] iArr = this.f5055zn;
        int length = iArr.length - 1;
        if (i > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.f5052gv;
        int length2 = jArr.length - 1;
        if (i > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i, length2, 0L);
        }
    }

    public final void j(int i, int i5, com.google.android.flexbox.y yVar, int i6, int i8, boolean z2) {
        int i10;
        int i11;
        int i12;
        int i13 = yVar.f5070v;
        float f4 = yVar.f5060f;
        float f6 = 0.0f;
        if (f4 > 0.0f && i6 <= i13) {
            float f9 = (i13 - i6) / f4;
            yVar.f5070v = i8 + yVar.f5058a;
            if (!z2) {
                yVar.f5061fb = Integer.MIN_VALUE;
            }
            int i14 = 0;
            boolean z3 = false;
            int i15 = 0;
            float f10 = 0.0f;
            while (i14 < yVar.f5067s) {
                int i16 = yVar.f5073xc + i14;
                View s2 = this.y.s(i16);
                if (s2 == null || s2.getVisibility() == 8) {
                    i10 = i13;
                    i11 = i14;
                } else {
                    FlexItem flexItem = (FlexItem) s2.getLayoutParams();
                    int flexDirection = this.y.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        i10 = i13;
                        int i17 = i14;
                        int measuredWidth = s2.getMeasuredWidth();
                        long[] jArr = this.f5054v;
                        if (jArr != null) {
                            measuredWidth = n(jArr[i16]);
                        }
                        int measuredHeight = s2.getMeasuredHeight();
                        long[] jArr2 = this.f5054v;
                        if (jArr2 != null) {
                            measuredHeight = f3(jArr2[i16]);
                        }
                        if (!this.f5053n3[i16] && flexItem.mt() > 0.0f) {
                            float mt2 = measuredWidth - (flexItem.mt() * f9);
                            i11 = i17;
                            if (i11 == yVar.f5067s - 1) {
                                mt2 += f10;
                                f10 = 0.0f;
                            }
                            int round = Math.round(mt2);
                            if (round < flexItem.x4()) {
                                round = flexItem.x4();
                                this.f5053n3[i16] = true;
                                yVar.f5060f -= flexItem.mt();
                                z3 = true;
                            } else {
                                f10 += mt2 - round;
                                double d2 = f10;
                                if (d2 > 1.0d) {
                                    round++;
                                    f10 -= 1.0f;
                                } else if (d2 < -1.0d) {
                                    round--;
                                    f10 += 1.0f;
                                }
                            }
                            int c2 = c(i5, flexItem, yVar.f5069tl);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                            s2.measure(makeMeasureSpec, c2);
                            int measuredWidth2 = s2.getMeasuredWidth();
                            int measuredHeight2 = s2.getMeasuredHeight();
                            en(i16, makeMeasureSpec, c2, s2);
                            this.y.c5(i16, s2);
                            measuredWidth = measuredWidth2;
                            measuredHeight = measuredHeight2;
                        } else {
                            i11 = i17;
                        }
                        int max = Math.max(i15, measuredHeight + flexItem.ta() + flexItem.ap() + this.y.a(s2));
                        yVar.f5070v += measuredWidth + flexItem.yc() + flexItem.qk();
                        i12 = max;
                    } else {
                        int measuredHeight3 = s2.getMeasuredHeight();
                        long[] jArr3 = this.f5054v;
                        if (jArr3 != null) {
                            measuredHeight3 = f3(jArr3[i16]);
                        }
                        int measuredWidth3 = s2.getMeasuredWidth();
                        long[] jArr4 = this.f5054v;
                        if (jArr4 != null) {
                            measuredWidth3 = n(jArr4[i16]);
                        }
                        if (!this.f5053n3[i16] && flexItem.mt() > f6) {
                            float mt3 = measuredHeight3 - (flexItem.mt() * f9);
                            if (i14 == yVar.f5067s - 1) {
                                mt3 += f10;
                                f10 = 0.0f;
                            }
                            int round2 = Math.round(mt3);
                            if (round2 < flexItem.l()) {
                                round2 = flexItem.l();
                                this.f5053n3[i16] = true;
                                yVar.f5060f -= flexItem.mt();
                                i10 = i13;
                                i11 = i14;
                                z3 = true;
                            } else {
                                f10 += mt3 - round2;
                                i10 = i13;
                                i11 = i14;
                                double d3 = f10;
                                if (d3 > 1.0d) {
                                    round2++;
                                    f10 -= 1.0f;
                                } else if (d3 < -1.0d) {
                                    round2--;
                                    f10 += 1.0f;
                                }
                            }
                            int d02 = d0(i, flexItem, yVar.f5069tl);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            s2.measure(d02, makeMeasureSpec2);
                            measuredWidth3 = s2.getMeasuredWidth();
                            int measuredHeight4 = s2.getMeasuredHeight();
                            en(i16, d02, makeMeasureSpec2, s2);
                            this.y.c5(i16, s2);
                            measuredHeight3 = measuredHeight4;
                        } else {
                            i10 = i13;
                            i11 = i14;
                        }
                        i12 = Math.max(i15, measuredWidth3 + flexItem.yc() + flexItem.qk() + this.y.a(s2));
                        yVar.f5070v += measuredHeight3 + flexItem.ta() + flexItem.ap();
                    }
                    yVar.f5061fb = Math.max(yVar.f5061fb, i12);
                    i15 = i12;
                }
                i14 = i11 + 1;
                i13 = i10;
                f6 = 0.0f;
            }
            int i18 = i13;
            if (z3 && i18 != yVar.f5070v) {
                j(i, i5, yVar, i6, i8, true);
            }
        }
    }

    public void j5(View view, com.google.android.flexbox.y yVar, int i, int i5, int i6, int i8) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.y.getAlignItems();
        if (flexItem.p() != -1) {
            alignItems = flexItem.p();
        }
        int i10 = yVar.f5061fb;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems != 2) {
                    if (alignItems != 3) {
                        if (alignItems != 4) {
                            return;
                        }
                    } else if (this.y.getFlexWrap() != 2) {
                        int max = Math.max(yVar.f5068t - view.getBaseline(), flexItem.ta());
                        view.layout(i, i5 + max, i6, i8 + max);
                        return;
                    } else {
                        int max2 = Math.max((yVar.f5068t - view.getMeasuredHeight()) + view.getBaseline(), flexItem.ap());
                        view.layout(i, i5 - max2, i6, i8 - max2);
                        return;
                    }
                } else {
                    int measuredHeight = (((i10 - view.getMeasuredHeight()) + flexItem.ta()) - flexItem.ap()) / 2;
                    if (this.y.getFlexWrap() != 2) {
                        int i11 = i5 + measuredHeight;
                        view.layout(i, i11, i6, view.getMeasuredHeight() + i11);
                        return;
                    }
                    int i12 = i5 - measuredHeight;
                    view.layout(i, i12, i6, view.getMeasuredHeight() + i12);
                    return;
                }
            } else if (this.y.getFlexWrap() != 2) {
                int i13 = i5 + i10;
                view.layout(i, (i13 - view.getMeasuredHeight()) - flexItem.ap(), i6, i13 - flexItem.ap());
                return;
            } else {
                view.layout(i, (i5 - i10) + view.getMeasuredHeight() + flexItem.ta(), i6, (i8 - i10) + view.getMeasuredHeight() + flexItem.ta());
                return;
            }
        }
        if (this.y.getFlexWrap() != 2) {
            view.layout(i, i5 + flexItem.ta(), i6, i8 + flexItem.ta());
        } else {
            view.layout(i, i5 - flexItem.ap(), i6, i8 - flexItem.ap());
        }
    }

    public void k() {
        f7(0);
    }

    public final int k5(View view, boolean z2) {
        if (z2) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    public final int mg(FlexItem flexItem, boolean z2) {
        if (z2) {
            return flexItem.ta();
        }
        return flexItem.yc();
    }

    public final void mt(int i) {
        boolean[] zArr = this.f5053n3;
        if (zArr == null) {
            this.f5053n3 = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.f5053n3 = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public int n(long j2) {
        return (int) j2;
    }

    public void n3(C0056n3 c0056n3, int i, int i5, int i6, int i8, int i10, @Nullable List<com.google.android.flexbox.y> list) {
        ArrayList arrayList;
        boolean z2;
        int i11;
        C0056n3 c0056n32;
        int i12;
        int i13;
        int i14;
        List<com.google.android.flexbox.y> list2;
        int i15;
        View view;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z3;
        boolean z4;
        int i21;
        int i22;
        int i23;
        com.google.android.flexbox.y yVar;
        int i24;
        int i25 = i;
        int i26 = i5;
        int i27 = i10;
        boolean f4 = this.y.f();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (list == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = list;
        }
        c0056n3.y = arrayList;
        if (i27 == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int x2 = x(f4);
        int ud2 = ud(f4);
        int a82 = a8(f4);
        int ej2 = ej(f4);
        com.google.android.flexbox.y yVar2 = new com.google.android.flexbox.y();
        int i28 = i8;
        yVar2.f5073xc = i28;
        int i29 = ud2 + x2;
        yVar2.f5070v = i29;
        int flexItemCount = this.y.getFlexItemCount();
        boolean z5 = z2;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        int i33 = Integer.MIN_VALUE;
        while (true) {
            if (i28 < flexItemCount) {
                View s2 = this.y.s(i28);
                if (s2 == null) {
                    if (yt(i28, flexItemCount, yVar2)) {
                        y(arrayList, yVar2, i28, i30);
                    }
                } else if (s2.getVisibility() == 8) {
                    yVar2.f5059c5++;
                    yVar2.f5067s++;
                    if (yt(i28, flexItemCount, yVar2)) {
                        y(arrayList, yVar2, i28, i30);
                    }
                } else {
                    if (s2 instanceof CompoundButton) {
                        x4((CompoundButton) s2);
                    }
                    FlexItem flexItem = (FlexItem) s2.getLayoutParams();
                    int i34 = flexItemCount;
                    if (flexItem.p() == 4) {
                        yVar2.f5072wz.add(Integer.valueOf(i28));
                    }
                    int z62 = z6(flexItem, f4);
                    if (flexItem.yt() != -1.0f && mode == 1073741824) {
                        z62 = Math.round(size * flexItem.yt());
                    }
                    if (f4) {
                        int zn2 = this.y.zn(i25, i29 + ta(flexItem, true) + rz(flexItem, true), z62);
                        i12 = size;
                        i13 = mode;
                        int v2 = this.y.v(i26, a82 + ej2 + mg(flexItem, true) + fh(flexItem, true) + i30, d(flexItem, true));
                        s2.measure(zn2, v2);
                        en(i28, zn2, v2, s2);
                        i14 = zn2;
                    } else {
                        i12 = size;
                        i13 = mode;
                        int zn3 = this.y.zn(i26, a82 + ej2 + mg(flexItem, false) + fh(flexItem, false) + i30, d(flexItem, false));
                        int v3 = this.y.v(i25, ta(flexItem, false) + i29 + rz(flexItem, false), z62);
                        s2.measure(zn3, v3);
                        en(i28, zn3, v3, s2);
                        i14 = v3;
                    }
                    this.y.c5(i28, s2);
                    c5(s2, i28);
                    i31 = View.combineMeasuredStates(i31, s2.getMeasuredState());
                    int i35 = i30;
                    int i36 = i29;
                    com.google.android.flexbox.y yVar3 = yVar2;
                    int i37 = i28;
                    list2 = arrayList;
                    int i38 = i14;
                    if (hw(s2, i13, i12, yVar2.f5070v, rz(flexItem, f4) + k5(s2, f4) + ta(flexItem, f4), flexItem, i37, i32, arrayList.size())) {
                        i28 = i37;
                        if (yVar3.zn() > 0) {
                            if (i28 > 0) {
                                i24 = i28 - 1;
                                yVar = yVar3;
                            } else {
                                yVar = yVar3;
                                i24 = 0;
                            }
                            y(list2, yVar, i24, i35);
                            i30 = yVar.f5061fb + i35;
                        } else {
                            i30 = i35;
                        }
                        if (f4) {
                            if (flexItem.getHeight() == -1) {
                                zf.y yVar4 = this.y;
                                i15 = i5;
                                i18 = -1;
                                view = s2;
                                view.measure(i38, yVar4.v(i15, yVar4.getPaddingTop() + this.y.getPaddingBottom() + flexItem.ta() + flexItem.ap() + i30, flexItem.getHeight()));
                                c5(view, i28);
                            } else {
                                i15 = i5;
                                view = s2;
                                i18 = -1;
                            }
                        } else {
                            i15 = i5;
                            view = s2;
                            i18 = -1;
                            if (flexItem.getWidth() == -1) {
                                zf.y yVar5 = this.y;
                                view.measure(yVar5.zn(i15, yVar5.getPaddingLeft() + this.y.getPaddingRight() + flexItem.yc() + flexItem.qk() + i30, flexItem.getWidth()), i38);
                                c5(view, i28);
                            }
                        }
                        yVar2 = new com.google.android.flexbox.y();
                        i17 = 1;
                        yVar2.f5067s = 1;
                        i16 = i36;
                        yVar2.f5070v = i16;
                        yVar2.f5073xc = i28;
                        i19 = 0;
                        i20 = Integer.MIN_VALUE;
                    } else {
                        i15 = i5;
                        i28 = i37;
                        view = s2;
                        yVar2 = yVar3;
                        i16 = i36;
                        i17 = 1;
                        i18 = -1;
                        yVar2.f5067s++;
                        i19 = i32 + 1;
                        i30 = i35;
                        i20 = i33;
                    }
                    boolean z7 = yVar2.f5066p;
                    if (flexItem.ud() != 0.0f) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    yVar2.f5066p = z7 | z3;
                    boolean z8 = yVar2.f5064mt;
                    if (flexItem.mt() != 0.0f) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    yVar2.f5064mt = z8 | z4;
                    int[] iArr = this.f5055zn;
                    if (iArr != null) {
                        iArr[i28] = list2.size();
                    }
                    yVar2.f5070v += k5(view, f4) + ta(flexItem, f4) + rz(flexItem, f4);
                    yVar2.f5063i9 += flexItem.ud();
                    yVar2.f5060f += flexItem.mt();
                    this.y.n3(view, i28, i19, yVar2);
                    int max = Math.max(i20, b(view, f4) + mg(flexItem, f4) + fh(flexItem, f4) + this.y.a(view));
                    yVar2.f5061fb = Math.max(yVar2.f5061fb, max);
                    if (f4) {
                        if (this.y.getFlexWrap() != 2) {
                            yVar2.f5068t = Math.max(yVar2.f5068t, view.getBaseline() + flexItem.ta());
                        } else {
                            yVar2.f5068t = Math.max(yVar2.f5068t, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.ap());
                        }
                    }
                    i21 = i34;
                    if (yt(i28, i21, yVar2)) {
                        y(list2, yVar2, i28, i30);
                        i30 += yVar2.f5061fb;
                    }
                    i22 = i10;
                    if (i22 != i18 && list2.size() > 0 && list2.get(list2.size() - i17).f5071w >= i22 && i28 >= i22 && !z5) {
                        i30 = -yVar2.y();
                        i23 = i6;
                        z5 = true;
                    } else {
                        i23 = i6;
                    }
                    if (i30 > i23 && z5) {
                        c0056n32 = c0056n3;
                        i11 = i31;
                        break;
                    }
                    i32 = i19;
                    i33 = max;
                    i28++;
                    i25 = i;
                    flexItemCount = i21;
                    i26 = i15;
                    i29 = i16;
                    arrayList = list2;
                    size = i12;
                    mode = i13;
                    i27 = i22;
                }
                i12 = size;
                i13 = mode;
                i15 = i26;
                i22 = i27;
                i16 = i29;
                list2 = arrayList;
                i21 = flexItemCount;
                i28++;
                i25 = i;
                flexItemCount = i21;
                i26 = i15;
                i29 = i16;
                arrayList = list2;
                size = i12;
                mode = i13;
                i27 = i22;
            } else {
                i11 = i31;
                c0056n32 = c0056n3;
                break;
            }
        }
        c0056n32.f5056n3 = i11;
    }

    public long o(int i, int i5) {
        return (i & 4294967295L) | (i5 << 32);
    }

    public final int[] oz(int i, List<zn> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i5 = 0;
        for (zn znVar : list) {
            int i6 = znVar.y;
            iArr[i5] = i6;
            sparseIntArray.append(i6, znVar.f5057v);
            i5++;
        }
        return iArr;
    }

    public void p(int i, int i5, int i6) {
        int size;
        int paddingLeft;
        int paddingRight;
        int i8;
        mt(this.y.getFlexItemCount());
        if (i6 >= this.y.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.y.getFlexDirection();
        int flexDirection2 = this.y.getFlexDirection();
        if (flexDirection2 != 0 && flexDirection2 != 1) {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode = View.MeasureSpec.getMode(i5);
            size = View.MeasureSpec.getSize(i5);
            if (mode != 1073741824) {
                size = this.y.getLargestMainSize();
            }
            paddingLeft = this.y.getPaddingTop();
            paddingRight = this.y.getPaddingBottom();
        } else {
            int mode2 = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.y.getLargestMainSize();
            if (mode2 != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.y.getPaddingLeft();
            paddingRight = this.y.getPaddingRight();
        }
        int i10 = paddingLeft + paddingRight;
        int[] iArr = this.f5055zn;
        if (iArr != null) {
            i8 = iArr[i6];
        } else {
            i8 = 0;
        }
        List<com.google.android.flexbox.y> flexLinesInternal = this.y.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        while (i8 < size2) {
            com.google.android.flexbox.y yVar = flexLinesInternal.get(i8);
            int i11 = yVar.f5070v;
            if (i11 < size && yVar.f5066p) {
                i4(i, i5, yVar, size, i10, false);
            } else if (i11 > size && yVar.f5064mt) {
                j(i, i5, yVar, size, i10, false);
            }
            i8++;
        }
    }

    public final void q9(View view, int i, int i5) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.ta()) - flexItem.ap()) - this.y.a(view), flexItem.l()), flexItem.vp());
        long[] jArr = this.f5054v;
        if (jArr != null) {
            measuredWidth = n(jArr[i5]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        en(i5, makeMeasureSpec, makeMeasureSpec2, view);
        this.y.c5(i5, view);
    }

    public void qn(View view, com.google.android.flexbox.y yVar, boolean z2, int i, int i5, int i6, int i8) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.y.getAlignItems();
        if (flexItem.p() != -1) {
            alignItems = flexItem.p();
        }
        int i10 = yVar.f5061fb;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems != 2) {
                    if (alignItems != 3 && alignItems != 4) {
                        return;
                    }
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int measuredWidth = (((i10 - view.getMeasuredWidth()) + s.n3(marginLayoutParams)) - s.y(marginLayoutParams)) / 2;
                    if (!z2) {
                        view.layout(i + measuredWidth, i5, i6 + measuredWidth, i8);
                        return;
                    } else {
                        view.layout(i - measuredWidth, i5, i6 - measuredWidth, i8);
                        return;
                    }
                }
            } else if (!z2) {
                view.layout(((i + i10) - view.getMeasuredWidth()) - flexItem.qk(), i5, ((i6 + i10) - view.getMeasuredWidth()) - flexItem.qk(), i8);
                return;
            } else {
                view.layout((i - i10) + view.getMeasuredWidth() + flexItem.yc(), i5, (i6 - i10) + view.getMeasuredWidth() + flexItem.yc(), i8);
                return;
            }
        }
        if (!z2) {
            view.layout(i + flexItem.yc(), i5, i6 + flexItem.yc(), i8);
        } else {
            view.layout(i - flexItem.qk(), i5, i6 - flexItem.qk(), i8);
        }
    }

    public void r(int i) {
        long[] jArr = this.f5054v;
        if (jArr == null) {
            this.f5054v = new long[Math.max(i, 10)];
        } else if (jArr.length < i) {
            this.f5054v = Arrays.copyOf(this.f5054v, Math.max(jArr.length * 2, i));
        }
    }

    public final int rz(FlexItem flexItem, boolean z2) {
        if (z2) {
            return flexItem.qk();
        }
        return flexItem.ap();
    }

    public void s(C0056n3 c0056n3, int i, int i5, int i6, int i8, List<com.google.android.flexbox.y> list) {
        n3(c0056n3, i5, i, i6, 0, i8, list);
    }

    @NonNull
    public final List<zn> t(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i5 = 0; i5 < i; i5++) {
            zn znVar = new zn();
            znVar.f5057v = ((FlexItem) this.y.gv(i5).getLayoutParams()).getOrder();
            znVar.y = i5;
            arrayList.add(znVar);
        }
        return arrayList;
    }

    public final int ta(FlexItem flexItem, boolean z2) {
        if (z2) {
            return flexItem.yc();
        }
        return flexItem.ta();
    }

    public int[] tl(SparseIntArray sparseIntArray) {
        int flexItemCount = this.y.getFlexItemCount();
        return oz(flexItemCount, t(flexItemCount), sparseIntArray);
    }

    public final int ud(boolean z2) {
        if (z2) {
            return this.y.getPaddingEnd();
        }
        return this.y.getPaddingBottom();
    }

    public final void ut(View view, int i, int i5) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.yc()) - flexItem.qk()) - this.y.a(view), flexItem.x4()), flexItem.jz());
        long[] jArr = this.f5054v;
        if (jArr != null) {
            measuredHeight = f3(jArr[i5]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        en(i5, makeMeasureSpec2, makeMeasureSpec, view);
        this.y.c5(i5, view);
    }

    public void v(C0056n3 c0056n3, int i, int i5, int i6, int i8, List<com.google.android.flexbox.y> list) {
        n3(c0056n3, i, i5, i6, 0, i8, list);
    }

    public boolean vl(SparseIntArray sparseIntArray) {
        int flexItemCount = this.y.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View gv2 = this.y.gv(i);
            if (gv2 != null && ((FlexItem) gv2.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    public void w(int i, int i5) {
        p(i, i5, 0);
    }

    public int[] wz(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.y.getFlexItemCount();
        List<zn> t2 = t(flexItemCount);
        zn znVar = new zn();
        if (view != null && (layoutParams instanceof FlexItem)) {
            znVar.f5057v = ((FlexItem) layoutParams).getOrder();
        } else {
            znVar.f5057v = 1;
        }
        if (i != -1 && i != flexItemCount) {
            if (i < this.y.getFlexItemCount()) {
                znVar.y = i;
                while (i < flexItemCount) {
                    t2.get(i).y++;
                    i++;
                }
            } else {
                znVar.y = flexItemCount;
            }
        } else {
            znVar.y = flexItemCount;
        }
        t2.add(znVar);
        return oz(flexItemCount + 1, t2, sparseIntArray);
    }

    public final int x(boolean z2) {
        if (z2) {
            return this.y.getPaddingStart();
        }
        return this.y.getPaddingTop();
    }

    public final void x4(CompoundButton compoundButton) {
        int minimumWidth;
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int x42 = flexItem.x4();
        int l2 = flexItem.l();
        Drawable y2 = j.zn.y(compoundButton);
        int i = 0;
        if (y2 == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = y2.getMinimumWidth();
        }
        if (y2 != null) {
            i = y2.getMinimumHeight();
        }
        if (x42 == -1) {
            x42 = minimumWidth;
        }
        flexItem.setMinWidth(x42);
        if (l2 == -1) {
            l2 = i;
        }
        flexItem.d(l2);
    }

    public void xc(int i, int i5, int i6) {
        int i8;
        int i10;
        int flexDirection = this.y.getFlexDirection();
        if (flexDirection != 0 && flexDirection != 1) {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            i8 = View.MeasureSpec.getMode(i);
            i10 = View.MeasureSpec.getSize(i);
        } else {
            int mode = View.MeasureSpec.getMode(i5);
            int size = View.MeasureSpec.getSize(i5);
            i8 = mode;
            i10 = size;
        }
        List<com.google.android.flexbox.y> flexLinesInternal = this.y.getFlexLinesInternal();
        if (i8 == 1073741824) {
            int sumOfCrossSize = this.y.getSumOfCrossSize() + i6;
            int i11 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f5061fb = i10 - i6;
            } else if (flexLinesInternal.size() >= 2) {
                int alignContent = this.y.getAlignContent();
                if (alignContent != 1) {
                    if (alignContent != 2) {
                        if (alignContent != 3) {
                            if (alignContent != 4) {
                                if (alignContent == 5 && sumOfCrossSize < i10) {
                                    float size2 = (i10 - sumOfCrossSize) / flexLinesInternal.size();
                                    int size3 = flexLinesInternal.size();
                                    float f4 = 0.0f;
                                    while (i11 < size3) {
                                        com.google.android.flexbox.y yVar = flexLinesInternal.get(i11);
                                        float f6 = yVar.f5061fb + size2;
                                        if (i11 == flexLinesInternal.size() - 1) {
                                            f6 += f4;
                                            f4 = 0.0f;
                                        }
                                        int round = Math.round(f6);
                                        f4 += f6 - round;
                                        if (f4 > 1.0f) {
                                            round++;
                                            f4 -= 1.0f;
                                        } else if (f4 < -1.0f) {
                                            round--;
                                            f4 += 1.0f;
                                        }
                                        yVar.f5061fb = round;
                                        i11++;
                                    }
                                    return;
                                }
                                return;
                            } else if (sumOfCrossSize >= i10) {
                                this.y.setFlexLines(f(flexLinesInternal, i10, sumOfCrossSize));
                                return;
                            } else {
                                int size4 = (i10 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                                ArrayList arrayList = new ArrayList();
                                com.google.android.flexbox.y yVar2 = new com.google.android.flexbox.y();
                                yVar2.f5061fb = size4;
                                for (com.google.android.flexbox.y yVar3 : flexLinesInternal) {
                                    arrayList.add(yVar2);
                                    arrayList.add(yVar3);
                                    arrayList.add(yVar2);
                                }
                                this.y.setFlexLines(arrayList);
                                return;
                            }
                        } else if (sumOfCrossSize < i10) {
                            float size5 = (i10 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                            ArrayList arrayList2 = new ArrayList();
                            int size6 = flexLinesInternal.size();
                            float f9 = 0.0f;
                            while (i11 < size6) {
                                arrayList2.add(flexLinesInternal.get(i11));
                                if (i11 != flexLinesInternal.size() - 1) {
                                    com.google.android.flexbox.y yVar4 = new com.google.android.flexbox.y();
                                    if (i11 == flexLinesInternal.size() - 2) {
                                        yVar4.f5061fb = Math.round(f9 + size5);
                                        f9 = 0.0f;
                                    } else {
                                        yVar4.f5061fb = Math.round(size5);
                                    }
                                    int i12 = yVar4.f5061fb;
                                    f9 += size5 - i12;
                                    if (f9 > 1.0f) {
                                        yVar4.f5061fb = i12 + 1;
                                        f9 -= 1.0f;
                                    } else if (f9 < -1.0f) {
                                        yVar4.f5061fb = i12 - 1;
                                        f9 += 1.0f;
                                    }
                                    arrayList2.add(yVar4);
                                }
                                i11++;
                            }
                            this.y.setFlexLines(arrayList2);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.y.setFlexLines(f(flexLinesInternal, i10, sumOfCrossSize));
                    return;
                }
                int i13 = i10 - sumOfCrossSize;
                com.google.android.flexbox.y yVar5 = new com.google.android.flexbox.y();
                yVar5.f5061fb = i13;
                flexLinesInternal.add(0, yVar5);
            }
        }
    }

    public final void y(List<com.google.android.flexbox.y> list, com.google.android.flexbox.y yVar, int i, int i5) {
        yVar.f5069tl = i5;
        this.y.fb(yVar);
        yVar.f5071w = i;
        list.add(yVar);
    }

    public final boolean yt(int i, int i5, com.google.android.flexbox.y yVar) {
        if (i == i5 - 1 && yVar.zn() != 0) {
            return true;
        }
        return false;
    }

    public void z(int i) {
        long[] jArr = this.f5052gv;
        if (jArr == null) {
            this.f5052gv = new long[Math.max(i, 10)];
        } else if (jArr.length < i) {
            this.f5052gv = Arrays.copyOf(this.f5052gv, Math.max(jArr.length * 2, i));
        }
    }

    public final int z6(FlexItem flexItem, boolean z2) {
        if (z2) {
            return flexItem.getWidth();
        }
        return flexItem.getHeight();
    }

    public void zn(C0056n3 c0056n3, int i, int i5) {
        n3(c0056n3, i, i5, Integer.MAX_VALUE, 0, -1, null);
    }
}
