package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextPaintExtensions.android.kt */
/* loaded from: classes.dex */
public abstract class TextPaintExtensions_androidKt {
    public static final float correctBlurRadius(float f) {
        if (f == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f;
    }

    public static final SpanStyle applySpanStyle(AndroidTextPaint androidTextPaint, SpanStyle style, Function4 resolveTypeface, Density density, boolean z) {
        Locale locale;
        Intrinsics.checkNotNullParameter(androidTextPaint, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(resolveTypeface, "resolveTypeface");
        Intrinsics.checkNotNullParameter(density, "density");
        long m1963getTypeUIouoOA = TextUnit.m1963getTypeUIouoOA(style.m1561getFontSizeXSAIIZE());
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1981getSpUIouoOA())) {
            androidTextPaint.setTextSize(density.mo154toPxR2X_6o(style.m1561getFontSizeXSAIIZE()));
        } else if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1980getEmUIouoOA())) {
            androidTextPaint.setTextSize(androidTextPaint.getTextSize() * TextUnit.m1964getValueimpl(style.m1561getFontSizeXSAIIZE()));
        }
        if (hasFontAttributes(style)) {
            FontFamily fontFamily = style.getFontFamily();
            FontWeight fontWeight = style.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle m1562getFontStyle4Lr2A7w = style.m1562getFontStyle4Lr2A7w();
            FontStyle m1638boximpl = FontStyle.m1638boximpl(m1562getFontStyle4Lr2A7w != null ? m1562getFontStyle4Lr2A7w.m1644unboximpl() : FontStyle.Companion.m1646getNormal_LCdwA());
            FontSynthesis m1563getFontSynthesisZQGJjVo = style.m1563getFontSynthesisZQGJjVo();
            androidTextPaint.setTypeface((Typeface) resolveTypeface.invoke(fontFamily, fontWeight, m1638boximpl, FontSynthesis.m1647boximpl(m1563getFontSynthesisZQGJjVo != null ? m1563getFontSynthesisZQGJjVo.m1655unboximpl() : FontSynthesis.Companion.m1656getAllGVVA2EU())));
        }
        if (style.getLocaleList() != null && !Intrinsics.areEqual(style.getLocaleList(), LocaleList.Companion.getCurrent())) {
            if (Build.VERSION.SDK_INT >= 24) {
                LocaleListHelperMethods.INSTANCE.setTextLocales(androidTextPaint, style.getLocaleList());
            } else {
                if (style.getLocaleList().isEmpty()) {
                    locale = Locale.Companion.getCurrent();
                } else {
                    locale = style.getLocaleList().get(0);
                }
                androidTextPaint.setTextLocale(LocaleExtensions_androidKt.toJavaLocale(locale));
            }
        }
        if (style.getFontFeatureSettings() != null && !Intrinsics.areEqual(style.getFontFeatureSettings(), "")) {
            androidTextPaint.setFontFeatureSettings(style.getFontFeatureSettings());
        }
        if (style.getTextGeometricTransform() != null && !Intrinsics.areEqual(style.getTextGeometricTransform(), TextGeometricTransform.Companion.getNone$ui_text_release())) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * style.getTextGeometricTransform().getScaleX());
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + style.getTextGeometricTransform().getSkewX());
        }
        androidTextPaint.m1730setColor8_81llA(style.m1560getColor0d7_KjU());
        androidTextPaint.m1729setBrush12SF9DM(style.getBrush(), Size.Companion.m750getUnspecifiedNHjbRc(), style.getAlpha());
        androidTextPaint.setShadow(style.getShadow());
        androidTextPaint.setTextDecoration(style.getTextDecoration());
        androidTextPaint.setDrawStyle(style.getDrawStyle());
        if (TextUnitType.m1976equalsimpl0(TextUnit.m1963getTypeUIouoOA(style.m1564getLetterSpacingXSAIIZE()), companion.m1981getSpUIouoOA()) && TextUnit.m1964getValueimpl(style.m1564getLetterSpacingXSAIIZE()) != 0.0f) {
            float textSize = androidTextPaint.getTextSize() * androidTextPaint.getTextScaleX();
            float mo154toPxR2X_6o = density.mo154toPxR2X_6o(style.m1564getLetterSpacingXSAIIZE());
            if (textSize != 0.0f) {
                androidTextPaint.setLetterSpacing(mo154toPxR2X_6o / textSize);
            }
        } else if (TextUnitType.m1976equalsimpl0(TextUnit.m1963getTypeUIouoOA(style.m1564getLetterSpacingXSAIIZE()), companion.m1980getEmUIouoOA())) {
            androidTextPaint.setLetterSpacing(TextUnit.m1964getValueimpl(style.m1564getLetterSpacingXSAIIZE()));
        }
        return m1739generateFallbackSpanStyle62GTOB8(style.m1564getLetterSpacingXSAIIZE(), z, style.m1558getBackground0d7_KjU(), style.m1559getBaselineShift5SSeXJ0());
    }

    /* renamed from: generateFallbackSpanStyle-62GTOB8  reason: not valid java name */
    private static final SpanStyle m1739generateFallbackSpanStyle62GTOB8(long j, boolean z, long j2, BaselineShift baselineShift) {
        long j3 = j2;
        boolean z2 = false;
        boolean z3 = z && TextUnitType.m1976equalsimpl0(TextUnit.m1963getTypeUIouoOA(j), TextUnitType.Companion.m1981getSpUIouoOA()) && TextUnit.m1964getValueimpl(j) != 0.0f;
        Color.Companion companion = Color.Companion;
        boolean z4 = (Color.m851equalsimpl0(j3, companion.m864getUnspecified0d7_KjU()) || Color.m851equalsimpl0(j3, companion.m863getTransparent0d7_KjU())) ? false : true;
        if (baselineShift != null) {
            if (!BaselineShift.m1746equalsimpl0(baselineShift.m1749unboximpl(), BaselineShift.Companion.m1750getNoney9eOQZs())) {
                z2 = true;
            }
        }
        if (z3 || z4 || z2) {
            long m1968getUnspecifiedXSAIIZE = z3 ? j : TextUnit.Companion.m1968getUnspecifiedXSAIIZE();
            if (!z4) {
                j3 = companion.m864getUnspecified0d7_KjU();
            }
            return new SpanStyle(0L, 0L, null, null, null, null, null, m1968getUnspecifiedXSAIIZE, z2 ? baselineShift : null, null, null, j3, null, null, null, null, 63103, null);
        }
        return null;
    }

    public static final void setTextMotion(AndroidTextPaint androidTextPaint, TextMotion textMotion) {
        int flags;
        Intrinsics.checkNotNullParameter(androidTextPaint, "<this>");
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        if (textMotion.getSubpixelTextPositioning$ui_text_release()) {
            flags = androidTextPaint.getFlags() | 128;
        } else {
            flags = androidTextPaint.getFlags() & (-129);
        }
        androidTextPaint.setFlags(flags);
        int m1846getLinearity4e0Vf04$ui_text_release = textMotion.m1846getLinearity4e0Vf04$ui_text_release();
        TextMotion.Linearity.Companion companion = TextMotion.Linearity.Companion;
        if (TextMotion.Linearity.m1848equalsimpl0(m1846getLinearity4e0Vf04$ui_text_release, companion.m1851getLinear4e0Vf04())) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (TextMotion.Linearity.m1848equalsimpl0(m1846getLinearity4e0Vf04$ui_text_release, companion.m1850getFontHinting4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (TextMotion.Linearity.m1848equalsimpl0(m1846getLinearity4e0Vf04$ui_text_release, companion.m1852getNone4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        } else {
            androidTextPaint.getFlags();
        }
    }

    public static final boolean hasFontAttributes(SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "<this>");
        return (spanStyle.getFontFamily() == null && spanStyle.m1562getFontStyle4Lr2A7w() == null && spanStyle.getFontWeight() == null) ? false : true;
    }
}
