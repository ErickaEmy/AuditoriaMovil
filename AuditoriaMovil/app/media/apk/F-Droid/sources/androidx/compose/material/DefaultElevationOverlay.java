package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ElevationOverlay.kt */
/* loaded from: classes.dex */
public final class DefaultElevationOverlay implements ElevationOverlay {
    public static final DefaultElevationOverlay INSTANCE = new DefaultElevationOverlay();

    private DefaultElevationOverlay() {
    }

    @Override // androidx.compose.material.ElevationOverlay
    /* renamed from: apply-7g2Lkgo  reason: not valid java name */
    public long mo479apply7g2Lkgo(long j, float f, Composer composer, int i) {
        long m490calculateForegroundColorCLU3JFs;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1687113661, i, -1, "androidx.compose.material.DefaultElevationOverlay.apply (ElevationOverlay.kt:68)");
        }
        Colors colors = MaterialTheme.INSTANCE.getColors(composer, 6);
        if (Dp.m1896compareTo0680j_4(f, Dp.m1897constructorimpl(0)) > 0 && !colors.isLight()) {
            m490calculateForegroundColorCLU3JFs = ElevationOverlayKt.m490calculateForegroundColorCLU3JFs(j, f, composer, (i & 112) | (i & 14));
            j = ColorKt.m868compositeOverOWjLjI(m490calculateForegroundColorCLU3JFs, j);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return j;
    }
}
