package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowRecomposer.android.kt */
/* loaded from: classes.dex */
public interface WindowRecomposerFactory {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: WindowRecomposer.android.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final WindowRecomposerFactory LifecycleAware = new WindowRecomposerFactory() { // from class: androidx.compose.ui.platform.WindowRecomposerFactory$Companion$LifecycleAware$1
            @Override // androidx.compose.ui.platform.WindowRecomposerFactory
            public final Recomposer createRecomposer(View rootView) {
                Intrinsics.checkNotNullParameter(rootView, "rootView");
                return WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer$default(rootView, null, null, 3, null);
            }
        };

        private Companion() {
        }

        public final WindowRecomposerFactory getLifecycleAware() {
            return LifecycleAware;
        }
    }

    Recomposer createRecomposer(View view);
}
