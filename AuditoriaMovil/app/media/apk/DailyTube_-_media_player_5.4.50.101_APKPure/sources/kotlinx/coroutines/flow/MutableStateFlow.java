package kotlinx.coroutines.flow;
/* loaded from: classes.dex */
public interface MutableStateFlow<T> extends StateFlow<T>, MutableSharedFlow<T> {
    @Override // kotlinx.coroutines.flow.StateFlow
    T getValue();

    void setValue(T t2);
}
