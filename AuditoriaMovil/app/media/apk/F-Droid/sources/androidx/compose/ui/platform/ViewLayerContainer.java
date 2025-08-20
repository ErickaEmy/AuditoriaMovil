package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ViewLayerContainer.android.kt */
/* loaded from: classes.dex */
public final class ViewLayerContainer extends DrawChildContainer {
    @Override // androidx.compose.ui.platform.DrawChildContainer, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    protected final void dispatchGetDisplayList() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewLayerContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
