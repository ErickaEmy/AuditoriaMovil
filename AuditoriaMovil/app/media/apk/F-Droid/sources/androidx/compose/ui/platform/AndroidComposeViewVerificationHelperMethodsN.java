package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.input.pointer.AndroidPointerIconType;
import androidx.compose.ui.input.pointer.PointerIcon;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidComposeView.android.kt */
/* loaded from: classes.dex */
final class AndroidComposeViewVerificationHelperMethodsN {
    public static final AndroidComposeViewVerificationHelperMethodsN INSTANCE = new AndroidComposeViewVerificationHelperMethodsN();

    private AndroidComposeViewVerificationHelperMethodsN() {
    }

    public final void setPointerIcon(View view, PointerIcon pointerIcon) {
        android.view.PointerIcon systemIcon;
        android.view.PointerIcon pointerIcon2;
        Intrinsics.checkNotNullParameter(view, "view");
        if (pointerIcon instanceof AndroidPointerIconType) {
            systemIcon = android.view.PointerIcon.getSystemIcon(view.getContext(), ((AndroidPointerIconType) pointerIcon).getType());
            Intrinsics.checkNotNullExpressionValue(systemIcon, "getSystemIcon(view.context, icon.type)");
        } else {
            systemIcon = android.view.PointerIcon.getSystemIcon(view.getContext(), 1000);
            Intrinsics.checkNotNullExpressionValue(systemIcon, "getSystemIcon(\n         …DEFAULT\n                )");
        }
        pointerIcon2 = view.getPointerIcon();
        if (Intrinsics.areEqual(pointerIcon2, systemIcon)) {
            return;
        }
        view.setPointerIcon(systemIcon);
    }
}
