package androidx.compose.ui.platform;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ViewLayer.android.kt */
/* loaded from: classes.dex */
final class ViewLayerVerificationHelper28 {
    public static final ViewLayerVerificationHelper28 INSTANCE = new ViewLayerVerificationHelper28();

    private ViewLayerVerificationHelper28() {
    }

    public final void setOutlineAmbientShadowColor(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOutlineAmbientShadowColor(i);
    }

    public final void setOutlineSpotShadowColor(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOutlineSpotShadowColor(i);
    }
}
