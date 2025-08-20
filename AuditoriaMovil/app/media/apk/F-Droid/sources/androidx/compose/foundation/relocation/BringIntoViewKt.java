package androidx.compose.foundation.relocation;

import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.jvm.functions.Function0;
/* compiled from: BringIntoView.kt */
/* loaded from: classes.dex */
public abstract class BringIntoViewKt {
    private static final ProvidableModifierLocal ModifierLocalBringIntoViewParent = ModifierLocalKt.modifierLocalOf(new Function0() { // from class: androidx.compose.foundation.relocation.BringIntoViewKt$ModifierLocalBringIntoViewParent$1
        @Override // kotlin.jvm.functions.Function0
        public final BringIntoViewParent invoke() {
            return null;
        }
    });

    public static final ProvidableModifierLocal getModifierLocalBringIntoViewParent() {
        return ModifierLocalBringIntoViewParent;
    }
}
