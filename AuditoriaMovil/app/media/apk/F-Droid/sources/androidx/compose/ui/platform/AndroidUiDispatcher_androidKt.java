package androidx.compose.ui.platform;

import android.os.Looper;
/* compiled from: AndroidUiDispatcher.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidUiDispatcher_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
