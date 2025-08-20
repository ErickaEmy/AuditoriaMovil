package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {
    private volatile Object _value;
    private Function0<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(Function0<? extends T> initializer, Object obj) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.initializer = initializer;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t2;
        T t3 = (T) this._value;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.INSTANCE;
        if (t3 != uninitialized_value) {
            return t3;
        }
        synchronized (this.lock) {
            t2 = (T) this._value;
            if (t2 == uninitialized_value) {
                Function0<? extends T> function0 = this.initializer;
                Intrinsics.checkNotNull(function0);
                t2 = function0.invoke();
                this._value = t2;
                this.initializer = null;
            }
        }
        return t2;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this._value != UNINITIALIZED_VALUE.INSTANCE) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? null : obj);
    }
}
