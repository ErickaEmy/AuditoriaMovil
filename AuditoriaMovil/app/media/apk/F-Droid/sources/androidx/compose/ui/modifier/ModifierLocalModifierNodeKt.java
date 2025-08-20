package androidx.compose.ui.modifier;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ModifierLocalModifierNode.kt */
/* loaded from: classes.dex */
public abstract class ModifierLocalModifierNodeKt {
    public static final ModifierLocalMap modifierLocalMapOf() {
        return EmptyMap.INSTANCE;
    }

    public static final ModifierLocalMap modifierLocalMapOf(Pair entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        SingleLocalMap singleLocalMap = new SingleLocalMap((ModifierLocal) entry.getFirst());
        singleLocalMap.set$ui_release((ModifierLocal) entry.getFirst(), entry.getSecond());
        return singleLocalMap;
    }
}
