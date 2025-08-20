package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutModifier.kt */
/* loaded from: classes.dex */
public abstract class LayoutModifierKt {
    public static final Modifier layout(Modifier modifier, Function3 measure) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(measure, "measure");
        return modifier.then(new LayoutElement(measure));
    }
}
