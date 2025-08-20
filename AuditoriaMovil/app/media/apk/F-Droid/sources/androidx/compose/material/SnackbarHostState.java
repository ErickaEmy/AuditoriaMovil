package androidx.compose.material;

import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* compiled from: SnackbarHost.kt */
/* loaded from: classes.dex */
public final class SnackbarHostState {
    private final MutableState currentSnackbarData$delegate;
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    public SnackbarHostState() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentSnackbarData$delegate = mutableStateOf$default;
    }

    public final SnackbarData getCurrentSnackbarData() {
        ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(this.currentSnackbarData$delegate.getValue());
        return null;
    }
}
