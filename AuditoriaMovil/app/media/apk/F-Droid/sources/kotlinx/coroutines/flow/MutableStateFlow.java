package kotlinx.coroutines.flow;
/* compiled from: StateFlow.kt */
/* loaded from: classes2.dex */
public interface MutableStateFlow extends StateFlow, MutableSharedFlow {
    boolean compareAndSet(Object obj, Object obj2);

    @Override // kotlinx.coroutines.flow.StateFlow
    Object getValue();

    void setValue(Object obj);
}
