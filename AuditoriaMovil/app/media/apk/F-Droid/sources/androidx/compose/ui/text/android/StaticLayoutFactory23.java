package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.StaticLayout;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StaticLayoutFactory.kt */
/* loaded from: classes.dex */
final class StaticLayoutFactory23 implements StaticLayoutFactoryImpl {
    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public StaticLayout create(StaticLayoutParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(params.getText(), params.getStart(), params.getEnd(), params.getPaint(), params.getWidth());
        obtain.setTextDirection(params.getTextDir());
        obtain.setAlignment(params.getAlignment());
        obtain.setMaxLines(params.getMaxLines());
        obtain.setEllipsize(params.getEllipsize());
        obtain.setEllipsizedWidth(params.getEllipsizedWidth());
        obtain.setLineSpacing(params.getLineSpacingExtra(), params.getLineSpacingMultiplier());
        obtain.setIncludePad(params.getIncludePadding());
        obtain.setBreakStrategy(params.getBreakStrategy());
        obtain.setHyphenationFrequency(params.getHyphenationFrequency());
        obtain.setIndents(params.getLeftIndents(), params.getRightIndents());
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            Intrinsics.checkNotNullExpressionValue(obtain, "this");
            StaticLayoutFactory26.setJustificationMode(obtain, params.getJustificationMode());
        }
        if (i >= 28) {
            Intrinsics.checkNotNullExpressionValue(obtain, "this");
            StaticLayoutFactory28.setUseLineSpacingFromFallbacks(obtain, params.getUseFallbackLineSpacing());
        }
        if (i >= 33) {
            Intrinsics.checkNotNullExpressionValue(obtain, "this");
            StaticLayoutFactory33.setLineBreakConfig(obtain, params.getLineBreakStyle(), params.getLineBreakWordStyle());
        }
        StaticLayout build = obtain.build();
        Intrinsics.checkNotNullExpressionValue(build, "obtain(params.text, para…  }\n            }.build()");
        return build;
    }

    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public boolean isFallbackLineSpacingEnabled(StaticLayout layout, boolean z) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            return StaticLayoutFactory33.isFallbackLineSpacingEnabled(layout);
        }
        if (i >= 28) {
            return z;
        }
        return false;
    }
}
