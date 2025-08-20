package androidx.compose.material;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MaterialTextSelectionColors.kt */
/* loaded from: classes.dex */
public abstract class MaterialTextSelectionColorsKt {
    public static final TextSelectionColors rememberTextSelectionColors(Colors colors, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        composer.startReplaceableGroup(-721696685);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721696685, i, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        }
        long m450getPrimary0d7_KjU = colors.m450getPrimary0d7_KjU();
        long m443getBackground0d7_KjU = colors.m443getBackground0d7_KjU();
        composer.startReplaceableGroup(35572910);
        long m467contentColorFor4WTKRHQ = ColorsKt.m467contentColorFor4WTKRHQ(colors, m443getBackground0d7_KjU);
        if (m467contentColorFor4WTKRHQ == Color.Companion.m864getUnspecified0d7_KjU()) {
            m467contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m859unboximpl();
        }
        long j = m467contentColorFor4WTKRHQ;
        composer.endReplaceableGroup();
        long m849copywmQWz5c$default = Color.m849copywmQWz5c$default(j, ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        Color m841boximpl = Color.m841boximpl(m450getPrimary0d7_KjU);
        Color m841boximpl2 = Color.m841boximpl(m443getBackground0d7_KjU);
        Color m841boximpl3 = Color.m841boximpl(m849copywmQWz5c$default);
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(m841boximpl) | composer.changed(m841boximpl2) | composer.changed(m841boximpl3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TextSelectionColors(colors.m450getPrimary0d7_KjU(), m509calculateSelectionBackgroundColorysEtTa8(m450getPrimary0d7_KjU, m849copywmQWz5c$default, m443getBackground0d7_KjU), null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        TextSelectionColors textSelectionColors = (TextSelectionColors) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSelectionColors;
    }

    /* renamed from: calculateSelectionBackgroundColor-ysEtTa8  reason: not valid java name */
    public static final long m509calculateSelectionBackgroundColorysEtTa8(long j, long j2, long j3) {
        float m506binarySearchForAccessibleSelectionColorAlphaysEtTa8;
        float m508calculateContrastRationb2GgbA = m508calculateContrastRationb2GgbA(j, 0.4f, j2, j3);
        float m508calculateContrastRationb2GgbA2 = m508calculateContrastRationb2GgbA(j, 0.2f, j2, j3);
        if (m508calculateContrastRationb2GgbA >= 4.5f) {
            m506binarySearchForAccessibleSelectionColorAlphaysEtTa8 = 0.4f;
        } else {
            m506binarySearchForAccessibleSelectionColorAlphaysEtTa8 = m508calculateContrastRationb2GgbA2 < 4.5f ? 0.2f : m506binarySearchForAccessibleSelectionColorAlphaysEtTa8(j, j2, j3);
        }
        return Color.m849copywmQWz5c$default(j, m506binarySearchForAccessibleSelectionColorAlphaysEtTa8, 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8  reason: not valid java name */
    private static final float m506binarySearchForAccessibleSelectionColorAlphaysEtTa8(long j, long j2, long j3) {
        float f = 0.2f;
        float f2 = 0.4f;
        float f3 = 0.4f;
        for (int i = 0; i < 7; i++) {
            float m508calculateContrastRationb2GgbA = (m508calculateContrastRationb2GgbA(j, f2, j2, j3) / 4.5f) - 1.0f;
            if (0.0f <= m508calculateContrastRationb2GgbA && m508calculateContrastRationb2GgbA <= 0.01f) {
                break;
            }
            if (m508calculateContrastRationb2GgbA < 0.0f) {
                f3 = f2;
            } else {
                f = f2;
            }
            f2 = (f3 + f) / 2.0f;
        }
        return f2;
    }

    /* renamed from: calculateContrastRatio-nb2GgbA  reason: not valid java name */
    private static final float m508calculateContrastRationb2GgbA(long j, float f, long j2, long j3) {
        long m868compositeOverOWjLjI = ColorKt.m868compositeOverOWjLjI(Color.m849copywmQWz5c$default(j, f, 0.0f, 0.0f, 0.0f, 14, null), j3);
        return m507calculateContrastRatioOWjLjI(ColorKt.m868compositeOverOWjLjI(j2, m868compositeOverOWjLjI), m868compositeOverOWjLjI);
    }

    /* renamed from: calculateContrastRatio--OWjLjI  reason: not valid java name */
    public static final float m507calculateContrastRatioOWjLjI(long j, long j2) {
        float m870luminance8_81llA = ColorKt.m870luminance8_81llA(j) + 0.05f;
        float m870luminance8_81llA2 = ColorKt.m870luminance8_81llA(j2) + 0.05f;
        return Math.max(m870luminance8_81llA, m870luminance8_81llA2) / Math.min(m870luminance8_81llA, m870luminance8_81llA2);
    }
}
