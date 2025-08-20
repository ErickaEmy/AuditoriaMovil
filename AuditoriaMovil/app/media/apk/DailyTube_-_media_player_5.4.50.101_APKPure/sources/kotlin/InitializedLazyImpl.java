package kotlin;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class InitializedLazyImpl<T> implements Lazy<T>, Serializable {
    private final T value;

    public InitializedLazyImpl(T t2) {
        this.value = t2;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        return this.value;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
