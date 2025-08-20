package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SpanStyle.kt */
/* loaded from: classes.dex */
public abstract class SpanStyleKt {
    private static final long DefaultBackgroundColor;
    private static final long DefaultColor;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);

    public static final Object lerpDiscrete(Object obj, Object obj2, float f) {
        return ((double) f) < 0.5d ? obj : obj2;
    }

    static {
        Color.Companion companion = Color.Companion;
        DefaultBackgroundColor = companion.m863getTransparent0d7_KjU();
        DefaultColor = companion.m860getBlack0d7_KjU();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
        if (androidx.compose.ui.graphics.Color.m851equalsimpl0(r22, r21.getTextForegroundStyle$ui_text_release().mo1752getColor0d7_KjU()) == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r6, r21.m1562getFontStyle4Lr2A7w()) == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5, r21.getFontWeight()) == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
        if (r31 != r21.getFontFamily()) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008e, code lost:
        if (androidx.compose.ui.unit.TextUnit.m1961equalsimpl0(r33, r21.m1564getLetterSpacingXSAIIZE()) == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0033, code lost:
        if (androidx.compose.ui.unit.TextUnit.m1961equalsimpl0(r26, r21.m1561getFontSizeXSAIIZE()) == false) goto L5;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0191  */
    /* renamed from: fastMerge-dSHsh3o  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.text.SpanStyle m1565fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle r21, long r22, androidx.compose.ui.graphics.Brush r24, float r25, long r26, androidx.compose.ui.text.font.FontWeight r28, androidx.compose.ui.text.font.FontStyle r29, androidx.compose.ui.text.font.FontSynthesis r30, androidx.compose.ui.text.font.FontFamily r31, java.lang.String r32, long r33, androidx.compose.ui.text.style.BaselineShift r35, androidx.compose.ui.text.style.TextGeometricTransform r36, androidx.compose.ui.text.intl.LocaleList r37, long r38, androidx.compose.ui.text.style.TextDecoration r40, androidx.compose.ui.graphics.Shadow r41, androidx.compose.ui.text.PlatformSpanStyle r42, androidx.compose.ui.graphics.drawscope.DrawStyle r43) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyleKt.m1565fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle, long, androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, androidx.compose.ui.graphics.drawscope.DrawStyle):androidx.compose.ui.text.SpanStyle");
    }

    /* renamed from: lerpTextUnitInheritable-C3pnCVY  reason: not valid java name */
    public static final long m1566lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        if (TextUnitKt.m1971isUnspecifiedR2X_6o(j) || TextUnitKt.m1971isUnspecifiedR2X_6o(j2)) {
            return ((TextUnit) lerpDiscrete(TextUnit.m1958boximpl(j), TextUnit.m1958boximpl(j2), f)).m1967unboximpl();
        }
        return TextUnitKt.m1972lerpC3pnCVY(j, j2, f);
    }

    public static final SpanStyle lerp(SpanStyle start, SpanStyle stop, float f) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        TextForegroundStyle lerp = TextDrawStyleKt.lerp(start.getTextForegroundStyle$ui_text_release(), stop.getTextForegroundStyle$ui_text_release(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(start.getFontFamily(), stop.getFontFamily(), f);
        long m1566lerpTextUnitInheritableC3pnCVY = m1566lerpTextUnitInheritableC3pnCVY(start.m1561getFontSizeXSAIIZE(), stop.m1561getFontSizeXSAIIZE(), f);
        FontWeight fontWeight = start.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = stop.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight lerp2 = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(start.m1562getFontStyle4Lr2A7w(), stop.m1562getFontStyle4Lr2A7w(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(start.m1563getFontSynthesisZQGJjVo(), stop.m1563getFontSynthesisZQGJjVo(), f);
        String str = (String) lerpDiscrete(start.getFontFeatureSettings(), stop.getFontFeatureSettings(), f);
        long m1566lerpTextUnitInheritableC3pnCVY2 = m1566lerpTextUnitInheritableC3pnCVY(start.m1564getLetterSpacingXSAIIZE(), stop.m1564getLetterSpacingXSAIIZE(), f);
        BaselineShift m1559getBaselineShift5SSeXJ0 = start.m1559getBaselineShift5SSeXJ0();
        float m1749unboximpl = m1559getBaselineShift5SSeXJ0 != null ? m1559getBaselineShift5SSeXJ0.m1749unboximpl() : BaselineShift.m1744constructorimpl(0.0f);
        BaselineShift m1559getBaselineShift5SSeXJ02 = stop.m1559getBaselineShift5SSeXJ0();
        float m1751lerpjWV1Mfo = BaselineShiftKt.m1751lerpjWV1Mfo(m1749unboximpl, m1559getBaselineShift5SSeXJ02 != null ? m1559getBaselineShift5SSeXJ02.m1749unboximpl() : BaselineShift.m1744constructorimpl(0.0f), f);
        TextGeometricTransform textGeometricTransform = start.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = stop.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform lerp3 = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f);
        LocaleList localeList = (LocaleList) lerpDiscrete(start.getLocaleList(), stop.getLocaleList(), f);
        long m869lerpjxsXWHM = ColorKt.m869lerpjxsXWHM(start.m1558getBackground0d7_KjU(), stop.m1558getBackground0d7_KjU(), f);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(start.getTextDecoration(), stop.getTextDecoration(), f);
        Shadow shadow = start.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        Shadow shadow2 = stop.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        return new SpanStyle(lerp, m1566lerpTextUnitInheritableC3pnCVY, lerp2, fontStyle, fontSynthesis, fontFamily, str, m1566lerpTextUnitInheritableC3pnCVY2, BaselineShift.m1743boximpl(m1751lerpjWV1Mfo), lerp3, localeList, m869lerpjxsXWHM, textDecoration, ShadowKt.lerp(shadow, shadow2, f), lerpPlatformStyle(start.getPlatformStyle(), stop.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(start.getDrawStyle(), stop.getDrawStyle(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.Companion.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        TextForegroundStyle takeOrElse = style.getTextForegroundStyle$ui_text_release().takeOrElse(new Function0() { // from class: androidx.compose.ui.text.SpanStyleKt$resolveSpanStyleDefaults$1
            @Override // kotlin.jvm.functions.Function0
            public final TextForegroundStyle invoke() {
                long j;
                TextForegroundStyle.Companion companion = TextForegroundStyle.Companion;
                j = SpanStyleKt.DefaultColor;
                return companion.m1843from8_81llA(j);
            }
        });
        long m1561getFontSizeXSAIIZE = TextUnitKt.m1971isUnspecifiedR2X_6o(style.m1561getFontSizeXSAIIZE()) ? DefaultFontSize : style.m1561getFontSizeXSAIIZE();
        FontWeight fontWeight = style.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle m1562getFontStyle4Lr2A7w = style.m1562getFontStyle4Lr2A7w();
        FontStyle m1638boximpl = FontStyle.m1638boximpl(m1562getFontStyle4Lr2A7w != null ? m1562getFontStyle4Lr2A7w.m1644unboximpl() : FontStyle.Companion.m1646getNormal_LCdwA());
        FontSynthesis m1563getFontSynthesisZQGJjVo = style.m1563getFontSynthesisZQGJjVo();
        FontSynthesis m1647boximpl = FontSynthesis.m1647boximpl(m1563getFontSynthesisZQGJjVo != null ? m1563getFontSynthesisZQGJjVo.m1655unboximpl() : FontSynthesis.Companion.m1656getAllGVVA2EU());
        FontFamily fontFamily = style.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = style.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        long m1564getLetterSpacingXSAIIZE = TextUnitKt.m1971isUnspecifiedR2X_6o(style.m1564getLetterSpacingXSAIIZE()) ? DefaultLetterSpacing : style.m1564getLetterSpacingXSAIIZE();
        BaselineShift m1559getBaselineShift5SSeXJ0 = style.m1559getBaselineShift5SSeXJ0();
        BaselineShift m1743boximpl = BaselineShift.m1743boximpl(m1559getBaselineShift5SSeXJ0 != null ? m1559getBaselineShift5SSeXJ0.m1749unboximpl() : BaselineShift.Companion.m1750getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = style.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = style.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long m1558getBackground0d7_KjU = style.m1558getBackground0d7_KjU();
        if (m1558getBackground0d7_KjU == Color.Companion.m864getUnspecified0d7_KjU()) {
            m1558getBackground0d7_KjU = DefaultBackgroundColor;
        }
        long j = m1558getBackground0d7_KjU;
        TextDecoration textDecoration = style.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = style.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = style.getPlatformStyle();
        DrawStyle drawStyle = style.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(takeOrElse, m1561getFontSizeXSAIIZE, fontWeight2, m1638boximpl, m1647boximpl, fontFamily2, str, m1564getLetterSpacingXSAIIZE, m1743boximpl, textGeometricTransform2, localeList2, j, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        if (spanStyle.getPlatformStyle() == null) {
            return platformSpanStyle;
        }
        if (platformSpanStyle == null) {
            return spanStyle.getPlatformStyle();
        }
        return spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }
}
