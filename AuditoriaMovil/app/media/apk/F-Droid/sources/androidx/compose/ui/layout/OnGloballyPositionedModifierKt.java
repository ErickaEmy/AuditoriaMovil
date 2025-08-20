package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OnGloballyPositionedModifier.kt */
/* loaded from: classes.dex */
public abstract class OnGloballyPositionedModifierKt {
    public static final Modifier onGloballyPositioned(Modifier modifier, Function1 onGloballyPositioned) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onGloballyPositioned, "onGloballyPositioned");
        return modifier.then(new OnGloballyPositionedElement(onGloballyPositioned));
    }
}
