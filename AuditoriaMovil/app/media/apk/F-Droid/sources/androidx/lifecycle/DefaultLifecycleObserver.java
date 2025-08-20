package androidx.lifecycle;
/* compiled from: DefaultLifecycleObserver.kt */
/* loaded from: classes.dex */
public interface DefaultLifecycleObserver extends LifecycleObserver {

    /* compiled from: DefaultLifecycleObserver.kt */
    /* renamed from: androidx.lifecycle.DefaultLifecycleObserver$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
    }

    void onCreate(LifecycleOwner lifecycleOwner);

    void onDestroy(LifecycleOwner lifecycleOwner);

    void onPause(LifecycleOwner lifecycleOwner);

    void onResume(LifecycleOwner lifecycleOwner);

    void onStart(LifecycleOwner lifecycleOwner);

    void onStop(LifecycleOwner lifecycleOwner);
}
