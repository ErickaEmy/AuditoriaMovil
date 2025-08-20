package kotlin;

import java.io.Serializable;
/* compiled from: Lazy.kt */
/* loaded from: classes.dex */
public final class InitializedLazyImpl implements Lazy, Serializable {
    private final Object value;

    @Override // kotlin.Lazy
    public Object getValue() {
        return this.value;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return true;
    }

    public InitializedLazyImpl(Object obj) {
        this.value = obj;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
