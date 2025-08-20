package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StaticLayoutFactory.kt */
/* loaded from: classes.dex */
final class StaticLayoutFactory26 {
    public static final StaticLayoutFactory26 INSTANCE = new StaticLayoutFactory26();

    private StaticLayoutFactory26() {
    }

    public static final void setJustificationMode(StaticLayout.Builder builder, int i) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.setJustificationMode(i);
    }
}
