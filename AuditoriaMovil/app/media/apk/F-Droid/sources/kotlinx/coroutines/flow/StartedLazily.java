package kotlinx.coroutines.flow;
/* compiled from: SharingStarted.kt */
/* loaded from: classes2.dex */
final class StartedLazily implements SharingStarted {
    public String toString() {
        return "SharingStarted.Lazily";
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow command(StateFlow stateFlow) {
        return FlowKt.flow(new StartedLazily$command$1(stateFlow, null));
    }
}
