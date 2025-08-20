package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidPopup.android.kt */
/* loaded from: classes.dex */
public final class PopupLayoutHelperImpl29 extends PopupLayoutHelperImpl {
    @Override // androidx.compose.ui.window.PopupLayoutHelperImpl, androidx.compose.ui.window.PopupLayoutHelper
    public void setGestureExclusionRects(View composeView, int i, int i2) {
        List mutableListOf;
        Intrinsics.checkNotNullParameter(composeView, "composeView");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new Rect(0, 0, i, i2));
        composeView.setSystemGestureExclusionRects(mutableListOf);
    }
}
