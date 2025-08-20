package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.jvm.functions.Function0;
/* compiled from: NestedScrollNode.kt */
/* loaded from: classes.dex */
public abstract class NestedScrollNodeKt {
    private static final ProvidableModifierLocal ModifierLocalNestedScroll = ModifierLocalKt.modifierLocalOf(new Function0() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt$ModifierLocalNestedScroll$1
        @Override // kotlin.jvm.functions.Function0
        public final NestedScrollNode invoke() {
            return null;
        }
    });

    public static final ProvidableModifierLocal getModifierLocalNestedScroll() {
        return ModifierLocalNestedScroll;
    }
}
