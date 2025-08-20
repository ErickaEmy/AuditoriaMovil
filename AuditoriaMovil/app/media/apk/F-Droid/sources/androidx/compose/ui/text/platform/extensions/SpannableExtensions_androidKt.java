package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LocaleSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.DrawStyleSpan;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt___StringsKt;
/* compiled from: SpannableExtensions.android.kt */
/* loaded from: classes.dex */
public abstract class SpannableExtensions_androidKt {
    private static final void setFontAttributes(final Spannable spannable, TextStyle textStyle, List list, final Function4 function4) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            AnnotatedString.Range range = (AnnotatedString.Range) obj;
            if (TextPaintExtensions_androidKt.hasFontAttributes((SpanStyle) range.getItem()) || ((SpanStyle) range.getItem()).m1563getFontSynthesisZQGJjVo() != null) {
                arrayList.add(obj);
            }
        }
        flattenFontStylesAndApply(hasFontAttributes(textStyle) ? new SpanStyle(0L, 0L, textStyle.getFontWeight(), textStyle.m1599getFontStyle4Lr2A7w(), textStyle.m1600getFontSynthesisZQGJjVo(), textStyle.getFontFamily(), null, 0L, null, null, null, 0L, null, null, null, null, 65475, null) : null, arrayList, new Function3() { // from class: androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt$setFontAttributes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                invoke((SpanStyle) obj2, ((Number) obj3).intValue(), ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SpanStyle spanStyle, int i2, int i3) {
                Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
                Spannable spannable2 = spannable;
                Function4 function42 = function4;
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontWeight fontWeight = spanStyle.getFontWeight();
                if (fontWeight == null) {
                    fontWeight = FontWeight.Companion.getNormal();
                }
                FontStyle m1562getFontStyle4Lr2A7w = spanStyle.m1562getFontStyle4Lr2A7w();
                FontStyle m1638boximpl = FontStyle.m1638boximpl(m1562getFontStyle4Lr2A7w != null ? m1562getFontStyle4Lr2A7w.m1644unboximpl() : FontStyle.Companion.m1646getNormal_LCdwA());
                FontSynthesis m1563getFontSynthesisZQGJjVo = spanStyle.m1563getFontSynthesisZQGJjVo();
                spannable2.setSpan(new TypefaceSpan((Typeface) function42.invoke(fontFamily, fontWeight, m1638boximpl, FontSynthesis.m1647boximpl(m1563getFontSynthesisZQGJjVo != null ? m1563getFontSynthesisZQGJjVo.m1655unboximpl() : FontSynthesis.Companion.m1656getAllGVVA2EU()))), i2, i3, 33);
            }
        });
    }

    public static final void setSpan(Spannable spannable, Object span, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(span, "span");
        spannable.setSpan(span, i, i2, 33);
    }

    public static final void setTextIndent(Spannable spannable, TextIndent textIndent, float f, Density density) {
        float m1964getValueimpl;
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        if (textIndent != null) {
            if ((TextUnit.m1961equalsimpl0(textIndent.m1844getFirstLineXSAIIZE(), TextUnitKt.getSp(0)) && TextUnit.m1961equalsimpl0(textIndent.m1845getRestLineXSAIIZE(), TextUnitKt.getSp(0))) || TextUnitKt.m1971isUnspecifiedR2X_6o(textIndent.m1844getFirstLineXSAIIZE()) || TextUnitKt.m1971isUnspecifiedR2X_6o(textIndent.m1845getRestLineXSAIIZE())) {
                return;
            }
            long m1963getTypeUIouoOA = TextUnit.m1963getTypeUIouoOA(textIndent.m1844getFirstLineXSAIIZE());
            TextUnitType.Companion companion = TextUnitType.Companion;
            float f2 = 0.0f;
            if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1981getSpUIouoOA())) {
                m1964getValueimpl = density.mo154toPxR2X_6o(textIndent.m1844getFirstLineXSAIIZE());
            } else {
                m1964getValueimpl = TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1980getEmUIouoOA()) ? TextUnit.m1964getValueimpl(textIndent.m1844getFirstLineXSAIIZE()) * f : 0.0f;
            }
            long m1963getTypeUIouoOA2 = TextUnit.m1963getTypeUIouoOA(textIndent.m1845getRestLineXSAIIZE());
            if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA2, companion.m1981getSpUIouoOA())) {
                f2 = density.mo154toPxR2X_6o(textIndent.m1845getRestLineXSAIIZE());
            } else if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA2, companion.m1980getEmUIouoOA())) {
                f2 = TextUnit.m1964getValueimpl(textIndent.m1845getRestLineXSAIIZE()) * f;
            }
            setSpan(spannable, new LeadingMarginSpan.Standard((int) Math.ceil(m1964getValueimpl), (int) Math.ceil(f2)), 0, spannable.length());
        }
    }

    /* renamed from: setLineHeight-KmRG4DE  reason: not valid java name */
    public static final void m1737setLineHeightKmRG4DE(Spannable setLineHeight, long j, float f, Density density, LineHeightStyle lineHeightStyle) {
        int length;
        char last;
        Intrinsics.checkNotNullParameter(setLineHeight, "$this$setLineHeight");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(lineHeightStyle, "lineHeightStyle");
        float m1732resolveLineHeightInPxo2QH7mI = m1732resolveLineHeightInPxo2QH7mI(j, f, density);
        if (Float.isNaN(m1732resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        if (setLineHeight.length() != 0) {
            last = StringsKt___StringsKt.last(setLineHeight);
            if (last != '\n') {
                length = setLineHeight.length();
                setSpan(setLineHeight, new LineHeightStyleSpan(m1732resolveLineHeightInPxo2QH7mI, 0, length, LineHeightStyle.Trim.m1813isTrimFirstLineTopimpl$ui_text_release(lineHeightStyle.m1804getTrimEVpEnUU()), LineHeightStyle.Trim.m1814isTrimLastLineBottomimpl$ui_text_release(lineHeightStyle.m1804getTrimEVpEnUU()), lineHeightStyle.m1803getAlignmentPIaL0Z0()), 0, setLineHeight.length());
            }
        }
        length = setLineHeight.length() + 1;
        setSpan(setLineHeight, new LineHeightStyleSpan(m1732resolveLineHeightInPxo2QH7mI, 0, length, LineHeightStyle.Trim.m1813isTrimFirstLineTopimpl$ui_text_release(lineHeightStyle.m1804getTrimEVpEnUU()), LineHeightStyle.Trim.m1814isTrimLastLineBottomimpl$ui_text_release(lineHeightStyle.m1804getTrimEVpEnUU()), lineHeightStyle.m1803getAlignmentPIaL0Z0()), 0, setLineHeight.length());
    }

    /* renamed from: setLineHeight-r9BaKPg  reason: not valid java name */
    public static final void m1738setLineHeightr9BaKPg(Spannable setLineHeight, long j, float f, Density density) {
        Intrinsics.checkNotNullParameter(setLineHeight, "$this$setLineHeight");
        Intrinsics.checkNotNullParameter(density, "density");
        float m1732resolveLineHeightInPxo2QH7mI = m1732resolveLineHeightInPxo2QH7mI(j, f, density);
        if (Float.isNaN(m1732resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(setLineHeight, new LineHeightSpan(m1732resolveLineHeightInPxo2QH7mI), 0, setLineHeight.length());
    }

    /* renamed from: resolveLineHeightInPx-o2QH7mI  reason: not valid java name */
    private static final float m1732resolveLineHeightInPxo2QH7mI(long j, float f, Density density) {
        long m1963getTypeUIouoOA = TextUnit.m1963getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1981getSpUIouoOA())) {
            return density.mo154toPxR2X_6o(j);
        }
        if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1980getEmUIouoOA())) {
            return TextUnit.m1964getValueimpl(j) * f;
        }
        return Float.NaN;
    }

    public static final void setSpanStyles(Spannable spannable, TextStyle contextTextStyle, List spanStyles, Density density, Function4 resolveTypeface) {
        MetricAffectingSpan m1731createLetterSpacingSpaneAf_CNQ;
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(contextTextStyle, "contextTextStyle");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resolveTypeface, "resolveTypeface");
        setFontAttributes(spannable, contextTextStyle, spanStyles, resolveTypeface);
        int size = spanStyles.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range range = (AnnotatedString.Range) spanStyles.get(i);
            int start = range.getStart();
            int end = range.getEnd();
            if (start >= 0 && start < spannable.length() && end > start && end <= spannable.length()) {
                setSpanStyle(spannable, range, density);
                if (getNeedsLetterSpacingSpan((SpanStyle) range.getItem())) {
                    z = true;
                }
            }
        }
        if (z) {
            int size2 = spanStyles.size();
            for (int i2 = 0; i2 < size2; i2++) {
                AnnotatedString.Range range2 = (AnnotatedString.Range) spanStyles.get(i2);
                int start2 = range2.getStart();
                int end2 = range2.getEnd();
                SpanStyle spanStyle = (SpanStyle) range2.getItem();
                if (start2 >= 0 && start2 < spannable.length() && end2 > start2 && end2 <= spannable.length() && (m1731createLetterSpacingSpaneAf_CNQ = m1731createLetterSpacingSpaneAf_CNQ(spanStyle.m1564getLetterSpacingXSAIIZE(), density)) != null) {
                    setSpan(spannable, m1731createLetterSpacingSpaneAf_CNQ, start2, end2);
                }
            }
        }
    }

    private static final void setSpanStyle(Spannable spannable, AnnotatedString.Range range, Density density) {
        int start = range.getStart();
        int end = range.getEnd();
        SpanStyle spanStyle = (SpanStyle) range.getItem();
        m1734setBaselineShift0ocSgnM(spannable, spanStyle.m1559getBaselineShift5SSeXJ0(), start, end);
        m1735setColorRPmYEkk(spannable, spanStyle.m1560getColor0d7_KjU(), start, end);
        setBrush(spannable, spanStyle.getBrush(), spanStyle.getAlpha(), start, end);
        setTextDecoration(spannable, spanStyle.getTextDecoration(), start, end);
        m1736setFontSizeKmRG4DE(spannable, spanStyle.m1561getFontSizeXSAIIZE(), density, start, end);
        setFontFeatureSettings(spannable, spanStyle.getFontFeatureSettings(), start, end);
        setGeometricTransform(spannable, spanStyle.getTextGeometricTransform(), start, end);
        setLocaleList(spannable, spanStyle.getLocaleList(), start, end);
        m1733setBackgroundRPmYEkk(spannable, spanStyle.m1558getBackground0d7_KjU(), start, end);
        setShadow(spannable, spanStyle.getShadow(), start, end);
        setDrawStyle(spannable, spanStyle.getDrawStyle(), start, end);
    }

    public static final void flattenFontStylesAndApply(SpanStyle spanStyle, List spanStyles, Function3 block) {
        Object first;
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(block, "block");
        if (spanStyles.size() <= 1) {
            if (!spanStyles.isEmpty()) {
                block.invoke(merge(spanStyle, (SpanStyle) ((AnnotatedString.Range) spanStyles.get(0)).getItem()), Integer.valueOf(((AnnotatedString.Range) spanStyles.get(0)).getStart()), Integer.valueOf(((AnnotatedString.Range) spanStyles.get(0)).getEnd()));
                return;
            }
            return;
        }
        int size = spanStyles.size();
        int i = size * 2;
        Integer[] numArr = new Integer[i];
        for (int i2 = 0; i2 < i; i2++) {
            numArr[i2] = 0;
        }
        int size2 = spanStyles.size();
        for (int i3 = 0; i3 < size2; i3++) {
            AnnotatedString.Range range = (AnnotatedString.Range) spanStyles.get(i3);
            numArr[i3] = Integer.valueOf(range.getStart());
            numArr[i3 + size] = Integer.valueOf(range.getEnd());
        }
        ArraysKt___ArraysJvmKt.sort(numArr);
        first = ArraysKt___ArraysKt.first(numArr);
        int intValue = ((Number) first).intValue();
        for (int i4 = 0; i4 < i; i4++) {
            int intValue2 = numArr[i4].intValue();
            if (intValue2 != intValue) {
                int size3 = spanStyles.size();
                SpanStyle spanStyle2 = spanStyle;
                for (int i5 = 0; i5 < size3; i5++) {
                    AnnotatedString.Range range2 = (AnnotatedString.Range) spanStyles.get(i5);
                    if (range2.getStart() != range2.getEnd() && AnnotatedStringKt.intersect(intValue, intValue2, range2.getStart(), range2.getEnd())) {
                        spanStyle2 = merge(spanStyle2, (SpanStyle) range2.getItem());
                    }
                }
                if (spanStyle2 != null) {
                    block.invoke(spanStyle2, Integer.valueOf(intValue), Integer.valueOf(intValue2));
                }
                intValue = intValue2;
            }
        }
    }

    /* renamed from: createLetterSpacingSpan-eAf_CNQ  reason: not valid java name */
    private static final MetricAffectingSpan m1731createLetterSpacingSpaneAf_CNQ(long j, Density density) {
        long m1963getTypeUIouoOA = TextUnit.m1963getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1981getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.mo154toPxR2X_6o(j));
        }
        if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1980getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.m1964getValueimpl(j));
        }
        return null;
    }

    private static final boolean getNeedsLetterSpacingSpan(SpanStyle spanStyle) {
        long m1963getTypeUIouoOA = TextUnit.m1963getTypeUIouoOA(spanStyle.m1564getLetterSpacingXSAIIZE());
        TextUnitType.Companion companion = TextUnitType.Companion;
        return TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1981getSpUIouoOA()) || TextUnitType.m1976equalsimpl0(TextUnit.m1963getTypeUIouoOA(spanStyle.m1564getLetterSpacingXSAIIZE()), companion.m1980getEmUIouoOA());
    }

    private static final void setShadow(Spannable spannable, Shadow shadow, int i, int i2) {
        if (shadow != null) {
            setSpan(spannable, new ShadowSpan(ColorKt.m871toArgb8_81llA(shadow.m952getColor0d7_KjU()), Offset.m709getXimpl(shadow.m953getOffsetF1C5BW0()), Offset.m710getYimpl(shadow.m953getOffsetF1C5BW0()), TextPaintExtensions_androidKt.correctBlurRadius(shadow.getBlurRadius())), i, i2);
        }
    }

    private static final void setDrawStyle(Spannable spannable, DrawStyle drawStyle, int i, int i2) {
        if (drawStyle != null) {
            setSpan(spannable, new DrawStyleSpan(drawStyle), i, i2);
        }
    }

    public static final void setLocaleList(Spannable spannable, LocaleList localeList, int i, int i2) {
        Object localeSpan;
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        if (localeList != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                localeSpan = LocaleListHelperMethods.INSTANCE.localeSpan(localeList);
            } else {
                localeSpan = new LocaleSpan(LocaleExtensions_androidKt.toJavaLocale(localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0)));
            }
            setSpan(spannable, localeSpan, i, i2);
        }
    }

    private static final void setGeometricTransform(Spannable spannable, TextGeometricTransform textGeometricTransform, int i, int i2) {
        if (textGeometricTransform != null) {
            setSpan(spannable, new ScaleXSpan(textGeometricTransform.getScaleX()), i, i2);
            setSpan(spannable, new SkewXSpan(textGeometricTransform.getSkewX()), i, i2);
        }
    }

    private static final void setFontFeatureSettings(Spannable spannable, String str, int i, int i2) {
        if (str != null) {
            setSpan(spannable, new FontFeatureSpan(str), i, i2);
        }
    }

    /* renamed from: setFontSize-KmRG4DE  reason: not valid java name */
    public static final void m1736setFontSizeKmRG4DE(Spannable setFontSize, long j, Density density, int i, int i2) {
        int roundToInt;
        Intrinsics.checkNotNullParameter(setFontSize, "$this$setFontSize");
        Intrinsics.checkNotNullParameter(density, "density");
        long m1963getTypeUIouoOA = TextUnit.m1963getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1981getSpUIouoOA())) {
            roundToInt = MathKt__MathJVMKt.roundToInt(density.mo154toPxR2X_6o(j));
            setSpan(setFontSize, new AbsoluteSizeSpan(roundToInt, false), i, i2);
        } else if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1980getEmUIouoOA())) {
            setSpan(setFontSize, new RelativeSizeSpan(TextUnit.m1964getValueimpl(j)), i, i2);
        }
    }

    public static final void setTextDecoration(Spannable spannable, TextDecoration textDecoration, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        if (textDecoration != null) {
            TextDecoration.Companion companion = TextDecoration.Companion;
            setSpan(spannable, new TextDecorationSpan(textDecoration.contains(companion.getUnderline()), textDecoration.contains(companion.getLineThrough())), i, i2);
        }
    }

    /* renamed from: setBaselineShift-0ocSgnM  reason: not valid java name */
    private static final void m1734setBaselineShift0ocSgnM(Spannable spannable, BaselineShift baselineShift, int i, int i2) {
        if (baselineShift != null) {
            setSpan(spannable, new BaselineShiftSpan(baselineShift.m1749unboximpl()), i, i2);
        }
    }

    private static final void setBrush(Spannable spannable, Brush brush, float f, int i, int i2) {
        if (brush != null) {
            if (brush instanceof SolidColor) {
                m1735setColorRPmYEkk(spannable, ((SolidColor) brush).m962getValue0d7_KjU(), i, i2);
            } else if (brush instanceof ShaderBrush) {
                setSpan(spannable, new ShaderBrushSpan((ShaderBrush) brush, f), i, i2);
            }
        }
    }

    private static final boolean hasFontAttributes(TextStyle textStyle) {
        return TextPaintExtensions_androidKt.hasFontAttributes(textStyle.toSpanStyle()) || textStyle.m1600getFontSynthesisZQGJjVo() != null;
    }

    private static final SpanStyle merge(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.merge(spanStyle2);
    }

    /* renamed from: setBackground-RPmYEkk  reason: not valid java name */
    public static final void m1733setBackgroundRPmYEkk(Spannable setBackground, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(setBackground, "$this$setBackground");
        if (j != Color.Companion.m864getUnspecified0d7_KjU()) {
            setSpan(setBackground, new BackgroundColorSpan(ColorKt.m871toArgb8_81llA(j)), i, i2);
        }
    }

    /* renamed from: setColor-RPmYEkk  reason: not valid java name */
    public static final void m1735setColorRPmYEkk(Spannable setColor, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(setColor, "$this$setColor");
        if (j != Color.Companion.m864getUnspecified0d7_KjU()) {
            setSpan(setColor, new ForegroundColorSpan(ColorKt.m871toArgb8_81llA(j)), i, i2);
        }
    }
}
