package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StaticLayoutFactory.kt */
/* loaded from: classes.dex */
final class StaticLayoutFactory28 {
    public static final StaticLayoutFactory28 INSTANCE = new StaticLayoutFactory28();

    private StaticLayoutFactory28() {
    }

    public static final void setUseLineSpacingFromFallbacks(StaticLayout.Builder builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.setUseLineSpacingFromFallbacks(z);
    }
}
