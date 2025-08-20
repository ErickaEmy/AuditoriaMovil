package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
/* compiled from: Snackbar.kt */
/* loaded from: classes.dex */
public final class SnackbarDefaults {
    public static final SnackbarDefaults INSTANCE = new SnackbarDefaults();

    private SnackbarDefaults() {
    }

    public final long getBackgroundColor(Composer composer, int i) {
        composer.startReplaceableGroup(1630911716);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1630911716, i, -1, "androidx.compose.material.SnackbarDefaults.<get-backgroundColor> (Snackbar.kt:200)");
        }
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        long m868compositeOverOWjLjI = ColorKt.m868compositeOverOWjLjI(Color.m849copywmQWz5c$default(materialTheme.getColors(composer, 6).m449getOnSurface0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m454getSurface0d7_KjU());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m868compositeOverOWjLjI;
    }

    public final long getPrimaryActionColor(Composer composer, int i) {
        long m451getPrimaryVariant0d7_KjU;
        composer.startReplaceableGroup(-810329402);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810329402, i, -1, "androidx.compose.material.SnackbarDefaults.<get-primaryActionColor> (Snackbar.kt:221)");
        }
        Colors colors = MaterialTheme.INSTANCE.getColors(composer, 6);
        if (colors.isLight()) {
            m451getPrimaryVariant0d7_KjU = ColorKt.m868compositeOverOWjLjI(Color.m849copywmQWz5c$default(colors.m454getSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), colors.m450getPrimary0d7_KjU());
        } else {
            m451getPrimaryVariant0d7_KjU = colors.m451getPrimaryVariant0d7_KjU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m451getPrimaryVariant0d7_KjU;
    }
}
