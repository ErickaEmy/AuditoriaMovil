package androidx.lifecycle;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
/* compiled from: ViewModel.kt */
/* loaded from: classes.dex */
public abstract class ViewModelKt {
    public static final CoroutineScope getViewModelScope(ViewModel viewModel) {
        CoroutineScope coroutineScope = (CoroutineScope) viewModel.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        return coroutineScope != null ? coroutineScope : (CoroutineScope) viewModel.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new CloseableCoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate())));
    }
}
