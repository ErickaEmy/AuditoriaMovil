package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusChangedModifier.kt */
/* loaded from: classes.dex */
public abstract class FocusChangedModifierKt {
    public static final Modifier onFocusChanged(Modifier modifier, Function1 onFocusChanged) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onFocusChanged, "onFocusChanged");
        return modifier.then(new FocusChangedElement(onFocusChanged));
    }
}
