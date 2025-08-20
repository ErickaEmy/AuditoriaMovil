package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: KeyInputModifier.kt */
/* loaded from: classes.dex */
public abstract class KeyInputModifierKt {
    public static final Modifier onKeyEvent(Modifier modifier, Function1 onKeyEvent) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onKeyEvent, "onKeyEvent");
        return modifier.then(new KeyInputElement(onKeyEvent, null));
    }

    public static final Modifier onPreviewKeyEvent(Modifier modifier, Function1 onPreviewKeyEvent) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onPreviewKeyEvent, "onPreviewKeyEvent");
        return modifier.then(new KeyInputElement(null, onPreviewKeyEvent));
    }
}
