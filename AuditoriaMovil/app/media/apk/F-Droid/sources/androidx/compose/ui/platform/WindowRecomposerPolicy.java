package androidx.compose.ui.platform;

import android.os.Handler;
import android.view.View;
import androidx.compose.runtime.Recomposer;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.android.HandlerDispatcherKt;
/* compiled from: WindowRecomposer.android.kt */
/* loaded from: classes.dex */
public final class WindowRecomposerPolicy {
    public static final WindowRecomposerPolicy INSTANCE = new WindowRecomposerPolicy();
    private static final AtomicReference factory = new AtomicReference(WindowRecomposerFactory.Companion.getLifecycleAware());
    public static final int $stable = 8;

    private WindowRecomposerPolicy() {
    }

    public final Recomposer createAndInstallWindowRecomposer$ui_release(View rootView) {
        final Job launch$default;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Recomposer createRecomposer = ((WindowRecomposerFactory) factory.get()).createRecomposer(rootView);
        WindowRecomposer_androidKt.setCompositionContext(rootView, createRecomposer);
        GlobalScope globalScope = GlobalScope.INSTANCE;
        Handler handler = rootView.getHandler();
        Intrinsics.checkNotNullExpressionValue(handler, "rootView.handler");
        launch$default = BuildersKt__Builders_commonKt.launch$default(globalScope, HandlerDispatcherKt.from(handler, "windowRecomposer cleanup").getImmediate(), null, new WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1(createRecomposer, rootView, null), 2, null);
        rootView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.WindowRecomposerPolicy$createAndInstallWindowRecomposer$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                v.removeOnAttachStateChangeListener(this);
                Job.DefaultImpls.cancel$default(Job.this, null, 1, null);
            }
        });
        return createRecomposer;
    }
}
