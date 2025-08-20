package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetNode;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusModifier.kt */
/* loaded from: classes.dex */
public abstract class FocusModifierKt {
    public static final Modifier focusTarget(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then(FocusTargetNode.FocusTargetElement.INSTANCE);
    }
}
