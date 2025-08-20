package androidx.compose.ui.text.platform;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.platform.extensions.PlaceholderExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.emoji2.text.EmojiCompat;
import java.util.List;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidParagraphHelper.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidParagraphHelper_androidKt {
    private static final AndroidParagraphHelper_androidKt$NoopSpan$1 NoopSpan = new CharacterStyle() { // from class: androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt$NoopSpan$1
        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
        }
    };

    public static final CharSequence createCharSequence(String text, float f, TextStyle contextTextStyle, List spanStyles, List placeholders, Density density, Function4 resolveTypeface, boolean z) {
        Spannable spannableString;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(contextTextStyle, "contextTextStyle");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resolveTypeface, "resolveTypeface");
        if (!z || !EmojiCompat.isConfigured()) {
            Intrinsics.checkNotNullExpressionValue(text, "if (useEmojiCompat && Em…else {\n        text\n    }");
            if (spanStyles.isEmpty() && placeholders.isEmpty() && Intrinsics.areEqual(contextTextStyle.getTextIndent(), TextIndent.Companion.getNone()) && TextUnitKt.m1971isUnspecifiedR2X_6o(contextTextStyle.m1604getLineHeightXSAIIZE())) {
                return text;
            }
            if (text instanceof Spannable) {
                spannableString = (Spannable) text;
            } else {
                spannableString = new SpannableString(text);
            }
            if (Intrinsics.areEqual(contextTextStyle.getTextDecoration(), TextDecoration.Companion.getUnderline())) {
                SpannableExtensions_androidKt.setSpan(spannableString, NoopSpan, 0, text.length());
            }
            if (isIncludeFontPaddingEnabled(contextTextStyle) && contextTextStyle.getLineHeightStyle() == null) {
                SpannableExtensions_androidKt.m1738setLineHeightr9BaKPg(spannableString, contextTextStyle.m1604getLineHeightXSAIIZE(), f, density);
            } else {
                LineHeightStyle lineHeightStyle = contextTextStyle.getLineHeightStyle();
                if (lineHeightStyle == null) {
                    lineHeightStyle = LineHeightStyle.Companion.getDefault();
                }
                Spannable spannable = spannableString;
                SpannableExtensions_androidKt.m1737setLineHeightKmRG4DE(spannable, contextTextStyle.m1604getLineHeightXSAIIZE(), f, density, lineHeightStyle);
            }
            SpannableExtensions_androidKt.setTextIndent(spannableString, contextTextStyle.getTextIndent(), f, density);
            SpannableExtensions_androidKt.setSpanStyles(spannableString, contextTextStyle, spanStyles, density, resolveTypeface);
            PlaceholderExtensions_androidKt.setPlaceholders(spannableString, placeholders, density);
            return spannableString;
        }
        EmojiCompat.get();
        throw null;
    }

    public static final boolean isIncludeFontPaddingEnabled(TextStyle textStyle) {
        PlatformParagraphStyle paragraphStyle;
        Intrinsics.checkNotNullParameter(textStyle, "<this>");
        PlatformTextStyle platformStyle = textStyle.getPlatformStyle();
        if (platformStyle == null || (paragraphStyle = platformStyle.getParagraphStyle()) == null) {
            return true;
        }
        return paragraphStyle.getIncludeFontPadding();
    }
}
