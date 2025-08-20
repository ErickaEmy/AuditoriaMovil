package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.functions.Function0;
/* compiled from: ElevationOverlay.kt */
/* loaded from: classes.dex */
public abstract class ElevationOverlayKt {
    private static final ProvidableCompositionLocal LocalElevationOverlay = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material.ElevationOverlayKt$LocalElevationOverlay$1
        @Override // kotlin.jvm.functions.Function0
        public final ElevationOverlay invoke() {
            return DefaultElevationOverlay.INSTANCE;
        }
    });
    private static final ProvidableCompositionLocal LocalAbsoluteElevation = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material.ElevationOverlayKt$LocalAbsoluteElevation$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Dp.m1895boximpl(m491invokeD9Ej5fM());
        }

        /* renamed from: invoke-D9Ej5fM  reason: not valid java name */
        public final float m491invokeD9Ej5fM() {
            return Dp.m1897constructorimpl(0);
        }
    }, 1, null);

    public static final ProvidableCompositionLocal getLocalAbsoluteElevation() {
        return LocalAbsoluteElevation;
    }

    public static final ProvidableCompositionLocal getLocalElevationOverlay() {
        return LocalElevationOverlay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateForegroundColor-CLU3JFs  reason: not valid java name */
    public static final long m490calculateForegroundColorCLU3JFs(long j, float f, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1613340891, i, -1, "androidx.compose.material.calculateForegroundColor (ElevationOverlay.kt:86)");
        }
        long m849copywmQWz5c$default = Color.m849copywmQWz5c$default(ColorsKt.m468contentColorForek8zF_U(j, composer, i & 14), ((((float) Math.log(f + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m849copywmQWz5c$default;
    }
}
