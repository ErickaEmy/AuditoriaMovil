package androidx.activity.result;

import androidx.core.app.ActivityOptionsCompat;
/* loaded from: classes.dex */
public abstract class ActivityResultLauncher {
    public abstract void launch(Object obj, ActivityOptionsCompat activityOptionsCompat);

    public abstract void unregister();

    public void launch(Object obj) {
        launch(obj, null);
    }
}
