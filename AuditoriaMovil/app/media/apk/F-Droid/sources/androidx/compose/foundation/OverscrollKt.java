package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Overscroll.kt */
/* loaded from: classes.dex */
public abstract class OverscrollKt {
    public static final Modifier overscroll(Modifier modifier, OverscrollEffect overscrollEffect) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(overscrollEffect, "overscrollEffect");
        return modifier.then(overscrollEffect.getEffectModifier());
    }
}
