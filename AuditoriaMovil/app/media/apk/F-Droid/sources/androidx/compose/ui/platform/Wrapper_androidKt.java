package androidx.compose.ui.platform;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.ui.R$id;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.WeakHashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Wrapper.android.kt */
/* loaded from: classes.dex */
public abstract class Wrapper_androidKt {
    private static final ViewGroup.LayoutParams DefaultLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    private static final String TAG = "Wrapper";

    public static final Composition createSubcomposition(LayoutNode container, CompositionContext parent) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return CompositionKt.Composition(new UiApplier(container), parent);
    }

    public static final Composition setContent(AbstractComposeView abstractComposeView, CompositionContext parent, Function2 content) {
        Intrinsics.checkNotNullParameter(abstractComposeView, "<this>");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(content, "content");
        GlobalSnapshotManager.INSTANCE.ensureStarted();
        AndroidComposeView androidComposeView = null;
        if (abstractComposeView.getChildCount() > 0) {
            View childAt = abstractComposeView.getChildAt(0);
            if (childAt instanceof AndroidComposeView) {
                androidComposeView = (AndroidComposeView) childAt;
            }
        } else {
            abstractComposeView.removeAllViews();
        }
        if (androidComposeView == null) {
            Context context = abstractComposeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            androidComposeView = new AndroidComposeView(context, parent.getEffectCoroutineContext());
            abstractComposeView.addView(androidComposeView.getView(), DefaultLayoutParams);
        }
        return doSetContent(androidComposeView, parent, content);
    }

    private static final Composition doSetContent(AndroidComposeView androidComposeView, CompositionContext compositionContext, Function2 function2) {
        if (inspectionWanted(androidComposeView)) {
            androidComposeView.setTag(R$id.inspection_slot_table_set, Collections.newSetFromMap(new WeakHashMap()));
            enableDebugInspectorInfo();
        }
        Composition Composition = CompositionKt.Composition(new UiApplier(androidComposeView.getRoot()), compositionContext);
        Object tag = androidComposeView.getView().getTag(R$id.wrapped_composition_tag);
        WrappedComposition wrappedComposition = tag instanceof WrappedComposition ? (WrappedComposition) tag : null;
        if (wrappedComposition == null) {
            wrappedComposition = new WrappedComposition(androidComposeView, Composition);
            androidComposeView.getView().setTag(R$id.wrapped_composition_tag, wrappedComposition);
        }
        wrappedComposition.setContent(function2);
        return wrappedComposition;
    }

    private static final void enableDebugInspectorInfo() {
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            return;
        }
        try {
            Field declaredField = InspectableValueKt.class.getDeclaredField("isDebugInspectorInfoEnabled");
            declaredField.setAccessible(true);
            declaredField.setBoolean(null, true);
        } catch (Exception unused) {
            Log.w(TAG, "Could not access isDebugInspectorInfoEnabled. Please set explicitly.");
        }
    }

    private static final boolean inspectionWanted(AndroidComposeView androidComposeView) {
        return Build.VERSION.SDK_INT >= 29 && (WrapperVerificationHelperMethods.INSTANCE.attributeSourceResourceMap(androidComposeView).isEmpty() ^ true);
    }
}
