package androidx.compose.ui.platform;

import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidAccessibilityManager.android.kt */
/* loaded from: classes.dex */
public final class AndroidAccessibilityManager implements AccessibilityManager {
    private static final Companion Companion = new Companion(null);
    private final android.view.accessibility.AccessibilityManager accessibilityManager;

    /* compiled from: AndroidAccessibilityManager.android.kt */
    /* loaded from: classes.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AndroidAccessibilityManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
    }
}
