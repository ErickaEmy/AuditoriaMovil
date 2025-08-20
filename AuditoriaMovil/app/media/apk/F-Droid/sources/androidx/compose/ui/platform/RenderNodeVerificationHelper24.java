package androidx.compose.ui.platform;

import android.view.RenderNode;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RenderNodeApi23.android.kt */
/* loaded from: classes.dex */
final class RenderNodeVerificationHelper24 {
    public static final RenderNodeVerificationHelper24 INSTANCE = new RenderNodeVerificationHelper24();

    private RenderNodeVerificationHelper24() {
    }

    public final void discardDisplayList(RenderNode renderNode) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        renderNode.discardDisplayList();
    }
}
