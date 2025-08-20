package he1;
/* loaded from: classes.dex */
public interface n3<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t2);

    void onSubscribe(zn znVar);
}
