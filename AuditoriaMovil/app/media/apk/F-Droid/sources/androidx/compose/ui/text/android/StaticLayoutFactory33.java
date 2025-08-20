package androidx.compose.ui.text.android;

import android.graphics.text.LineBreakConfig;
import android.text.StaticLayout;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StaticLayoutFactory.kt */
/* loaded from: classes.dex */
final class StaticLayoutFactory33 {
    public static final StaticLayoutFactory33 INSTANCE = new StaticLayoutFactory33();

    private StaticLayoutFactory33() {
    }

    public static final boolean isFallbackLineSpacingEnabled(StaticLayout layout) {
        boolean isFallbackLineSpacingEnabled;
        Intrinsics.checkNotNullParameter(layout, "layout");
        isFallbackLineSpacingEnabled = layout.isFallbackLineSpacingEnabled();
        return isFallbackLineSpacingEnabled;
    }

    public static final void setLineBreakConfig(StaticLayout.Builder builder, int i, int i2) {
        LineBreakConfig.Builder lineBreakStyle;
        LineBreakConfig.Builder lineBreakWordStyle;
        LineBreakConfig build;
        Intrinsics.checkNotNullParameter(builder, "builder");
        lineBreakStyle = StaticLayoutFactory33$$ExternalSyntheticApiModelOutline5.m().setLineBreakStyle(i);
        lineBreakWordStyle = lineBreakStyle.setLineBreakWordStyle(i2);
        build = lineBreakWordStyle.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
        builder.setLineBreakConfig(build);
    }
}
