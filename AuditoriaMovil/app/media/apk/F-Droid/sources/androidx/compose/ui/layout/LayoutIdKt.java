package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutId.kt */
/* loaded from: classes.dex */
public abstract class LayoutIdKt {
    public static final Modifier layoutId(Modifier modifier, Object layoutId) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(layoutId, "layoutId");
        return modifier.then(new LayoutIdElement(layoutId));
    }

    public static final Object getLayoutId(Measurable measurable) {
        Intrinsics.checkNotNullParameter(measurable, "<this>");
        Object parentData = measurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }
}
