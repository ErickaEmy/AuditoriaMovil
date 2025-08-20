package org.fdroid.fdroid.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: ComposeUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
final class ComposeUtils$LifecycleEventListener$1$1 extends Lambda implements Function1 {
    final /* synthetic */ State $eventHandler;
    final /* synthetic */ State $lifecycleOwner;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeUtils$LifecycleEventListener$1$1(State state, State state2) {
        super(1);
        this.$lifecycleOwner = state;
        this.$eventHandler = state2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final Lifecycle lifecycle = ((LifecycleOwner) this.$lifecycleOwner.getValue()).getLifecycle();
        final State state = this.$eventHandler;
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: org.fdroid.fdroid.compose.ComposeUtils$LifecycleEventListener$1$1$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                ComposeUtils$LifecycleEventListener$1$1.invoke$lambda$0(State.this, lifecycleOwner, event);
            }
        };
        lifecycle.addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: org.fdroid.fdroid.compose.ComposeUtils$LifecycleEventListener$1$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Lifecycle.this.removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(State eventHandler, LifecycleOwner owner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(eventHandler, "$eventHandler");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(event, "event");
        ((Function2) eventHandler.getValue()).invoke(owner, event);
    }
}
