package androidx.compose.ui.modifier;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ModifierLocal.kt */
/* loaded from: classes.dex */
public final class ProvidableModifierLocal extends ModifierLocal {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProvidableModifierLocal(Function0 defaultFactory) {
        super(defaultFactory, null);
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
    }
}
