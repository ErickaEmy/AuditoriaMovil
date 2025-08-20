package androidx.compose.ui.input.rotary;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RotaryInputModifier.kt */
/* loaded from: classes.dex */
public abstract class RotaryInputModifierKt {
    public static final Modifier onRotaryScrollEvent(Modifier modifier, Function1 onRotaryScrollEvent) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onRotaryScrollEvent, "onRotaryScrollEvent");
        return modifier.then(new RotaryInputElement(onRotaryScrollEvent, null));
    }
}
