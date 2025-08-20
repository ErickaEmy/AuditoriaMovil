package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$animator;
import com.google.android.material.transformation.FabTransformationBehavior;
import hw.i4;
import java.util.HashMap;
import java.util.Map;
import y6.i9;
import y6.s;
@Deprecated
/* loaded from: classes.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public Map<View, Integer> f6149c5;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    @NonNull
    public FabTransformationBehavior.v dm(Context context, boolean z2) {
        int i;
        if (z2) {
            i = R$animator.fk;
        } else {
            i = R$animator.fb;
        }
        FabTransformationBehavior.v vVar = new FabTransformationBehavior.v();
        vVar.y = s.zn(context, i);
        vVar.f6139n3 = new i9(17, 0.0f, 0.0f);
        return vVar;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public boolean ej(@NonNull View view, @NonNull View view2, boolean z2, boolean z3) {
        o4(view2, z2);
        return super.ej(view, view2, z2, z3);
    }

    public final void o4(@NonNull View view, boolean z2) {
        boolean z3;
        ViewParent parent = view.getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z2) {
            this.f6149c5 = new HashMap(childCount);
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = coordinatorLayout.getChildAt(i);
            if ((childAt.getLayoutParams() instanceof CoordinatorLayout.a) && (((CoordinatorLayout.a) childAt.getLayoutParams()).a() instanceof FabTransformationScrimBehavior)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (childAt != view && !z3) {
                if (!z2) {
                    Map<View, Integer> map = this.f6149c5;
                    if (map != null && map.containsKey(childAt)) {
                        i4.o0(childAt, this.f6149c5.get(childAt).intValue());
                    }
                } else {
                    this.f6149c5.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    i4.o0(childAt, 4);
                }
            }
        }
        if (!z2) {
            this.f6149c5 = null;
        }
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
