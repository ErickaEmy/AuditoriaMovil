package androidx.compose.ui.layout;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.jvm.functions.Function0;
/* compiled from: PinnableContainer.kt */
/* loaded from: classes.dex */
public abstract class PinnableContainerKt {
    private static final ProvidableCompositionLocal LocalPinnableContainer = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.ui.layout.PinnableContainerKt$LocalPinnableContainer$1
        @Override // kotlin.jvm.functions.Function0
        public final PinnableContainer invoke() {
            return null;
        }
    }, 1, null);

    public static final ProvidableCompositionLocal getLocalPinnableContainer() {
        return LocalPinnableContainer;
    }
}
