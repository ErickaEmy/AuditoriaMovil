package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.UrlAnnotation;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: AndroidAccessibilitySpannableString.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidAccessibilitySpannableString_androidKt {
    public static final SpannableString toAccessibilitySpannableString(AnnotatedString annotatedString, Density density, FontFamily.Resolver fontFamilyResolver, URLSpanCache urlSpanCache) {
        SpanStyle m1557copyGSF8kmg;
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(urlSpanCache, "urlSpanCache");
        SpannableString spannableString = new SpannableString(annotatedString.getText());
        List spanStylesOrNull$ui_text_release = annotatedString.getSpanStylesOrNull$ui_text_release();
        if (spanStylesOrNull$ui_text_release != null) {
            int size = spanStylesOrNull$ui_text_release.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range range = (AnnotatedString.Range) spanStylesOrNull$ui_text_release.get(i);
                int component2 = range.component2();
                int component3 = range.component3();
                m1557copyGSF8kmg = r15.m1557copyGSF8kmg((r38 & 1) != 0 ? r15.m1560getColor0d7_KjU() : 0L, (r38 & 2) != 0 ? r15.fontSize : 0L, (r38 & 4) != 0 ? r15.fontWeight : null, (r38 & 8) != 0 ? r15.fontStyle : null, (r38 & 16) != 0 ? r15.fontSynthesis : null, (r38 & 32) != 0 ? r15.fontFamily : null, (r38 & 64) != 0 ? r15.fontFeatureSettings : null, (r38 & 128) != 0 ? r15.letterSpacing : 0L, (r38 & 256) != 0 ? r15.baselineShift : null, (r38 & 512) != 0 ? r15.textGeometricTransform : null, (r38 & 1024) != 0 ? r15.localeList : null, (r38 & 2048) != 0 ? r15.background : 0L, (r38 & PKIFailureInfo.certConfirmed) != 0 ? r15.textDecoration : null, (r38 & 8192) != 0 ? r15.shadow : null, (r38 & 16384) != 0 ? r15.platformStyle : null, (r38 & 32768) != 0 ? ((SpanStyle) range.component1()).drawStyle : null);
                setSpanStyle(spannableString, m1557copyGSF8kmg, component2, component3, density, fontFamilyResolver);
            }
        }
        List ttsAnnotations = annotatedString.getTtsAnnotations(0, annotatedString.length());
        int size2 = ttsAnnotations.size();
        for (int i2 = 0; i2 < size2; i2++) {
            AnnotatedString.Range range2 = (AnnotatedString.Range) ttsAnnotations.get(i2);
            spannableString.setSpan(TtsAnnotationExtensions_androidKt.toSpan((TtsAnnotation) range2.component1()), range2.component2(), range2.component3(), 33);
        }
        List urlAnnotations = annotatedString.getUrlAnnotations(0, annotatedString.length());
        int size3 = urlAnnotations.size();
        for (int i3 = 0; i3 < size3; i3++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) urlAnnotations.get(i3);
            spannableString.setSpan(urlSpanCache.toURLSpan((UrlAnnotation) range3.component1()), range3.component2(), range3.component3(), 33);
        }
        return spannableString;
    }

    private static final void setSpanStyle(SpannableString spannableString, SpanStyle spanStyle, int i, int i2, Density density, FontFamily.Resolver resolver) {
        SpannableExtensions_androidKt.m1735setColorRPmYEkk(spannableString, spanStyle.m1560getColor0d7_KjU(), i, i2);
        SpannableExtensions_androidKt.m1736setFontSizeKmRG4DE(spannableString, spanStyle.m1561getFontSizeXSAIIZE(), density, i, i2);
        if (spanStyle.getFontWeight() != null || spanStyle.m1562getFontStyle4Lr2A7w() != null) {
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle m1562getFontStyle4Lr2A7w = spanStyle.m1562getFontStyle4Lr2A7w();
            spannableString.setSpan(new StyleSpan(AndroidFontUtils_androidKt.m1615getAndroidTypefaceStyleFO1MlWM(fontWeight, m1562getFontStyle4Lr2A7w != null ? m1562getFontStyle4Lr2A7w.m1644unboximpl() : FontStyle.Companion.m1646getNormal_LCdwA())), i, i2, 33);
        }
        if (spanStyle.getFontFamily() != null) {
            if (spanStyle.getFontFamily() instanceof GenericFontFamily) {
                spannableString.setSpan(new TypefaceSpan(((GenericFontFamily) spanStyle.getFontFamily()).getName()), i, i2, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontSynthesis m1563getFontSynthesisZQGJjVo = spanStyle.m1563getFontSynthesisZQGJjVo();
                Object value = FontFamily.Resolver.CC.m1627resolveDPcqOEQ$default(resolver, fontFamily, null, 0, m1563getFontSynthesisZQGJjVo != null ? m1563getFontSynthesisZQGJjVo.m1655unboximpl() : FontSynthesis.Companion.m1656getAllGVVA2EU(), 6, null).getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
                spannableString.setSpan(Api28Impl.INSTANCE.createTypefaceSpan((Typeface) value), i, i2, 33);
            }
        }
        if (spanStyle.getTextDecoration() != null) {
            TextDecoration textDecoration = spanStyle.getTextDecoration();
            TextDecoration.Companion companion = TextDecoration.Companion;
            if (textDecoration.contains(companion.getUnderline())) {
                spannableString.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (spanStyle.getTextDecoration().contains(companion.getLineThrough())) {
                spannableString.setSpan(new StrikethroughSpan(), i, i2, 33);
            }
        }
        if (spanStyle.getTextGeometricTransform() != null) {
            spannableString.setSpan(new ScaleXSpan(spanStyle.getTextGeometricTransform().getScaleX()), i, i2, 33);
        }
        SpannableExtensions_androidKt.setLocaleList(spannableString, spanStyle.getLocaleList(), i, i2);
        SpannableExtensions_androidKt.m1733setBackgroundRPmYEkk(spannableString, spanStyle.m1558getBackground0d7_KjU(), i, i2);
    }
}
