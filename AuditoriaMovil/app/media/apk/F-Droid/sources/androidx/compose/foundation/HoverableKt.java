package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Hoverable.kt */
/* loaded from: classes.dex */
public abstract class HoverableKt {
    public static final Modifier hoverable(Modifier modifier, MutableInteractionSource interactionSource, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        return modifier.then(z ? new HoverableElement(interactionSource) : Modifier.Companion);
    }
}
