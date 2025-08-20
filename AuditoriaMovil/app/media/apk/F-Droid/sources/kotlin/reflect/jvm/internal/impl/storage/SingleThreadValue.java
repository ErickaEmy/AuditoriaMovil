package kotlin.reflect.jvm.internal.impl.storage;
/* loaded from: classes2.dex */
class SingleThreadValue {
    private final Thread thread = Thread.currentThread();
    private final Object value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleThreadValue(Object obj) {
        this.value = obj;
    }

    public boolean hasValue() {
        return this.thread == Thread.currentThread();
    }

    public Object getValue() {
        if (hasValue()) {
            return this.value;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }
}
