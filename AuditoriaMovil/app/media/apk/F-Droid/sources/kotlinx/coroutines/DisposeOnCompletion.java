package kotlinx.coroutines;

import kotlin.Unit;
/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public final class DisposeOnCompletion extends JobNode {
    private final DisposableHandle handle;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public DisposeOnCompletion(DisposableHandle disposableHandle) {
        this.handle = disposableHandle;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void invoke(Throwable th) {
        this.handle.dispose();
    }
}
