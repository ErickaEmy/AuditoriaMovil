package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusProperties.kt */
/* loaded from: classes.dex */
public abstract class FocusPropertiesKt {
    public static final Modifier focusProperties(Modifier modifier, Function1 scope) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return modifier.then(new FocusPropertiesElement(scope));
    }
}
