package androidx.compose.ui.modifier;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ModifierLocalModifierNode.kt */
/* loaded from: classes.dex */
public final class SingleLocalMap extends ModifierLocalMap {
    private final ModifierLocal key;
    private final MutableState value$delegate;

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(ModifierLocal key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return key == this.key;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleLocalMap(ModifierLocal key) {
        super(null);
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.value$delegate = mutableStateOf$default;
    }

    public void set$ui_release(ModifierLocal key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key != this.key) {
            throw new IllegalStateException("Check failed.".toString());
        }
        setValue(obj);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public Object get$ui_release(ModifierLocal key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key != this.key) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Object value = getValue();
        if (value == null) {
            return null;
        }
        return value;
    }

    private final Object getValue() {
        return this.value$delegate.getValue();
    }

    private final void setValue(Object obj) {
        this.value$delegate.setValue(obj);
    }
}
