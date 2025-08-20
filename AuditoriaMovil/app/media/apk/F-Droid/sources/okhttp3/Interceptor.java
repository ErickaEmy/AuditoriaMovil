package okhttp3;
/* compiled from: Interceptor.kt */
/* loaded from: classes2.dex */
public interface Interceptor {

    /* compiled from: Interceptor.kt */
    /* loaded from: classes2.dex */
    public interface Chain {
        Call call();

        Response proceed(Request request);

        Request request();
    }

    Response intercept(Chain chain);
}
