package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
/* compiled from: Button.kt */
/* loaded from: classes.dex */
public final class ButtonDefaults {
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ContentPadding;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;
    private static final float OutlinedBorderSize;
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;

    private ButtonDefaults() {
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m434getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: getIconSpacing-D9Ej5fM  reason: not valid java name */
    public final float m435getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m436getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m437getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    static {
        float m1897constructorimpl = Dp.m1897constructorimpl(16);
        ButtonHorizontalPadding = m1897constructorimpl;
        float f = 8;
        float m1897constructorimpl2 = Dp.m1897constructorimpl(f);
        ButtonVerticalPadding = m1897constructorimpl2;
        PaddingValues m205PaddingValuesa9UjIt4 = PaddingKt.m205PaddingValuesa9UjIt4(m1897constructorimpl, m1897constructorimpl2, m1897constructorimpl, m1897constructorimpl2);
        ContentPadding = m205PaddingValuesa9UjIt4;
        MinWidth = Dp.m1897constructorimpl(64);
        MinHeight = Dp.m1897constructorimpl(36);
        IconSize = Dp.m1897constructorimpl(18);
        IconSpacing = Dp.m1897constructorimpl(f);
        OutlinedBorderSize = Dp.m1897constructorimpl(1);
        float m1897constructorimpl3 = Dp.m1897constructorimpl(f);
        TextButtonHorizontalPadding = m1897constructorimpl3;
        TextButtonContentPadding = PaddingKt.m205PaddingValuesa9UjIt4(m1897constructorimpl3, m205PaddingValuesa9UjIt4.mo221calculateTopPaddingD9Ej5fM(), m1897constructorimpl3, m205PaddingValuesa9UjIt4.mo218calculateBottomPaddingD9Ej5fM());
    }

    /* renamed from: elevation-R_JCAzs  reason: not valid java name */
    public final ButtonElevation m433elevationR_JCAzs(float f, float f2, float f3, float f4, float f5, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-737170518);
        float m1897constructorimpl = (i2 & 1) != 0 ? Dp.m1897constructorimpl(2) : f;
        float m1897constructorimpl2 = (i2 & 2) != 0 ? Dp.m1897constructorimpl(8) : f2;
        float m1897constructorimpl3 = (i2 & 4) != 0 ? Dp.m1897constructorimpl(0) : f3;
        float m1897constructorimpl4 = (i2 & 8) != 0 ? Dp.m1897constructorimpl(4) : f4;
        float m1897constructorimpl5 = (i2 & 16) != 0 ? Dp.m1897constructorimpl(4) : f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-737170518, i, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:371)");
        }
        Object[] objArr = {Dp.m1895boximpl(m1897constructorimpl), Dp.m1895boximpl(m1897constructorimpl2), Dp.m1895boximpl(m1897constructorimpl3), Dp.m1895boximpl(m1897constructorimpl4), Dp.m1895boximpl(m1897constructorimpl5)};
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (int i3 = 0; i3 < 5; i3++) {
            z |= composer.changed(objArr[i3]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new DefaultButtonElevation(m1897constructorimpl, m1897constructorimpl2, m1897constructorimpl3, m1897constructorimpl4, m1897constructorimpl5, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultButtonElevation defaultButtonElevation = (DefaultButtonElevation) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonElevation;
    }

    /* renamed from: buttonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m432buttonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long j5;
        composer.startReplaceableGroup(1870371134);
        long m450getPrimary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m450getPrimary0d7_KjU() : j;
        long m468contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m468contentColorForek8zF_U(m450getPrimary0d7_KjU, composer, i & 14) : j2;
        if ((i2 & 4) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            j5 = ColorKt.m868compositeOverOWjLjI(Color.m849copywmQWz5c$default(materialTheme.getColors(composer, 6).m449getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m454getSurface0d7_KjU());
        } else {
            j5 = j3;
        }
        long m849copywmQWz5c$default = (i2 & 8) != 0 ? Color.m849copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m449getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1870371134, i, -1, "androidx.compose.material.ButtonDefaults.buttonColors (Button.kt:405)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(m450getPrimary0d7_KjU, m468contentColorForek8zF_U, j5, m849copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    /* renamed from: outlinedButtonColors-RGew2ao  reason: not valid java name */
    public final ButtonColors m438outlinedButtonColorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-2124406093);
        long m454getSurface0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m454getSurface0d7_KjU() : j;
        long m450getPrimary0d7_KjU = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m450getPrimary0d7_KjU() : j2;
        long m849copywmQWz5c$default = (i2 & 4) != 0 ? Color.m849copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m449getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2124406093, i, -1, "androidx.compose.material.ButtonDefaults.outlinedButtonColors (Button.kt:428)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(m454getSurface0d7_KjU, m450getPrimary0d7_KjU, m454getSurface0d7_KjU, m849copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    /* renamed from: textButtonColors-RGew2ao  reason: not valid java name */
    public final ButtonColors m439textButtonColorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(182742216);
        long m863getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.Companion.m863getTransparent0d7_KjU() : j;
        long m450getPrimary0d7_KjU = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m450getPrimary0d7_KjU() : j2;
        long m849copywmQWz5c$default = (i2 & 4) != 0 ? Color.m849copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m449getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(182742216, i, -1, "androidx.compose.material.ButtonDefaults.textButtonColors (Button.kt:449)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(m863getTransparent0d7_KjU, m450getPrimary0d7_KjU, m863getTransparent0d7_KjU, m849copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    public final BorderStroke getOutlinedBorder(Composer composer, int i) {
        composer.startReplaceableGroup(-2091313033);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2091313033, i, -1, "androidx.compose.material.ButtonDefaults.<get-outlinedBorder> (Button.kt:476)");
        }
        BorderStroke m89BorderStrokecXLIe8U = BorderStrokeKt.m89BorderStrokecXLIe8U(OutlinedBorderSize, Color.m849copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m449getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m89BorderStrokecXLIe8U;
    }
}
