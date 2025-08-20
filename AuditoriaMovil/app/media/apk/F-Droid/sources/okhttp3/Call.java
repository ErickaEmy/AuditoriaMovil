package okhttp3;
/* compiled from: Call.kt */
/* loaded from: classes2.dex */
public interface Call extends Cloneable {
    void cancel();

    void enqueue(Callback callback);

    boolean isCanceled();
}
