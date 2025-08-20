package y5;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class xc {
    public static AtomicBoolean y = new AtomicBoolean(false);

    public static void y(Context context) {
        if (y.getAndSet(true)) {
            return;
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new y());
    }

    /* loaded from: classes.dex */
    public static class y extends i9 {
        @Override // y5.i9, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            androidx.lifecycle.f.fb(activity);
        }

        @Override // y5.i9, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // y5.i9, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
