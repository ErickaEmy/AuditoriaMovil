package com.google.android.material.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public abstract class SearchView extends FrameLayout implements CoordinatorLayout.AttachedBehavior {

    /* loaded from: classes.dex */
    public static class Behavior extends CoordinatorLayout.Behavior {
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(view);
            return onDependentViewChanged(coordinatorLayout, (SearchView) null, view2);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, SearchView searchView, View view) {
            throw null;
        }
    }
}
