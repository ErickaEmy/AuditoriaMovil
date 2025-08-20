package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusedBounds.kt */
/* loaded from: classes.dex */
public abstract class FocusedBoundsKt {
    private static final ProvidableModifierLocal ModifierLocalFocusedBoundsObserver = ModifierLocalKt.modifierLocalOf(new Function0() { // from class: androidx.compose.foundation.FocusedBoundsKt$ModifierLocalFocusedBoundsObserver$1
        @Override // kotlin.jvm.functions.Function0
        public final Function1 invoke() {
            return null;
        }
    });

    public static final ProvidableModifierLocal getModifierLocalFocusedBoundsObserver() {
        return ModifierLocalFocusedBoundsObserver;
    }

    public static final Modifier onFocusedBoundsChanged(Modifier modifier, Function1 onPositioned) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onPositioned, "onPositioned");
        return modifier.then(new FocusedBoundsObserverElement(onPositioned));
    }
}
