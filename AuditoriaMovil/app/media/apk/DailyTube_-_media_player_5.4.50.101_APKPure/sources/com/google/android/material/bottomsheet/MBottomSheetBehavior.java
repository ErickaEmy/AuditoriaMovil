package com.google.android.material.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import db1.tl;
import free.daily.tube.base_impl.init.BaseApp;
import free.daily.tube.multipack.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import wk.a;
/* loaded from: classes.dex */
public class MBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {

    /* renamed from: o  reason: collision with root package name */
    public final Lazy f5499o;

    /* loaded from: classes.dex */
    public static final class y extends Lambda implements Function0<Integer> {
        public static final y y = new y();

        public y() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(a.zn(R.dimen.y, BaseApp.y.y()));
        }
    }

    public MBottomSheetBehavior() {
        this.f5499o = LazyKt.lazy(y.y);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void bk(View view, int i, int i5, boolean z2) {
        if (i == 4) {
            int cr2 = cr();
            if (view != null) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int i92 = iArr[1] - tl.i9(view.getResources());
                if (i5 > 0) {
                    float f4 = i92 / i5;
                    if (0.0f <= f4 && f4 <= 1.0f) {
                        cr2 = (int) ((1 - f4) * cr());
                    }
                }
            }
            super.bk(view, i, i5 - cr2, z2);
            return;
        }
        super.bk(view, i, i5, z2);
    }

    public final int cr() {
        return ((Number) this.f5499o.getValue()).intValue();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void m(View child, int i) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (!u() && i == 5) {
            return;
        }
        super.m(child, i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f5499o = LazyKt.lazy(y.y);
    }
}
