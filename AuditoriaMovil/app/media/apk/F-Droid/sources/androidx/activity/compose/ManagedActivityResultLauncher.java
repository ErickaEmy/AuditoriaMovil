package androidx.activity.compose;

import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.runtime.State;
import androidx.core.app.ActivityOptionsCompat;
/* compiled from: ActivityResultRegistry.kt */
/* loaded from: classes.dex */
public final class ManagedActivityResultLauncher extends ActivityResultLauncher {
    private final State contract;
    private final ActivityResultLauncherHolder launcher;

    public ManagedActivityResultLauncher(ActivityResultLauncherHolder activityResultLauncherHolder, State state) {
        this.launcher = activityResultLauncherHolder;
        this.contract = state;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        throw new UnsupportedOperationException("Registration is automatically handled by rememberLauncherForActivityResult");
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(Object obj, ActivityOptionsCompat activityOptionsCompat) {
        this.launcher.launch(obj, activityOptionsCompat);
    }
}
