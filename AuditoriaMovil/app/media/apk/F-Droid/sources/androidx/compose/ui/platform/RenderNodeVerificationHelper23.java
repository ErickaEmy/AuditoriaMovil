package androidx.compose.ui.platform;

import android.view.RenderNode;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RenderNodeApi23.android.kt */
/* loaded from: classes.dex */
final class RenderNodeVerificationHelper23 {
    public static final RenderNodeVerificationHelper23 INSTANCE = new RenderNodeVerificationHelper23();

    private RenderNodeVerificationHelper23() {
    }

    public final void destroyDisplayListData(RenderNode renderNode) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        renderNode.destroyDisplayListData();
    }
}
