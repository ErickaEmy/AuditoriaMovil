package androidx.compose.ui.modifier;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: ModifierLocalModifierNode.kt */
/* loaded from: classes.dex */
public final class EmptyMap extends ModifierLocalMap {
    public static final EmptyMap INSTANCE = new EmptyMap();

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(ModifierLocal key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return false;
    }

    private EmptyMap() {
        super(null);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public Object get$ui_release(ModifierLocal key) {
        Intrinsics.checkNotNullParameter(key, "key");
        throw new IllegalStateException("".toString());
    }
}
