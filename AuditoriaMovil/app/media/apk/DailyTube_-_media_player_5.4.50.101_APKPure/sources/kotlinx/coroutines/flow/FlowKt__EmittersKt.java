package kotlinx.coroutines.flow;
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__EmittersKt {
    public static final void ensureActive(FlowCollector<?> flowCollector) {
        if (!(flowCollector instanceof ThrowingCollector)) {
            return;
        }
        throw ((ThrowingCollector) flowCollector).f9986e;
    }
}
