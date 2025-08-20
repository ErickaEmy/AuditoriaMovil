package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
/* compiled from: AndroidParagraph.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidParagraph_androidKt {
    public static final /* synthetic */ CharSequence access$attachIndentationFixSpan(CharSequence charSequence) {
        return attachIndentationFixSpan(charSequence);
    }

    public static final /* synthetic */ int access$numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        return numberOfLinesThatFitMaxHeight(textLayout, i);
    }

    public static final /* synthetic */ boolean access$shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        return shouldAttachIndentationFixSpan(textStyle, z);
    }

    /* renamed from: access$toLayoutAlign-AMY3VfE  reason: not valid java name */
    public static final /* synthetic */ int m1501access$toLayoutAlignAMY3VfE(TextAlign textAlign) {
        return m1506toLayoutAlignAMY3VfE(textAlign);
    }

    /* renamed from: access$toLayoutBreakStrategy-u6PBz3U  reason: not valid java name */
    public static final /* synthetic */ int m1502access$toLayoutBreakStrategyu6PBz3U(LineBreak.Strategy strategy) {
        return m1507toLayoutBreakStrategyu6PBz3U(strategy);
    }

    /* renamed from: access$toLayoutHyphenationFrequency-0_XeFpE  reason: not valid java name */
    public static final /* synthetic */ int m1503access$toLayoutHyphenationFrequency0_XeFpE(Hyphens hyphens) {
        return m1508toLayoutHyphenationFrequency0_XeFpE(hyphens);
    }

    /* renamed from: access$toLayoutLineBreakStyle-4a2g8L8  reason: not valid java name */
    public static final /* synthetic */ int m1504access$toLayoutLineBreakStyle4a2g8L8(LineBreak.Strictness strictness) {
        return m1509toLayoutLineBreakStyle4a2g8L8(strictness);
    }

    /* renamed from: access$toLayoutLineBreakWordStyle-gvcdTPQ  reason: not valid java name */
    public static final /* synthetic */ int m1505access$toLayoutLineBreakWordStylegvcdTPQ(LineBreak.WordBreak wordBreak) {
        return m1510toLayoutLineBreakWordStylegvcdTPQ(wordBreak);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutAlign-AMY3VfE  reason: not valid java name */
    public static final int m1506toLayoutAlignAMY3VfE(TextAlign textAlign) {
        TextAlign.Companion companion = TextAlign.Companion;
        int m1827getLefte0LSkKk = companion.m1827getLefte0LSkKk();
        if (textAlign != null && TextAlign.m1820equalsimpl0(textAlign.m1823unboximpl(), m1827getLefte0LSkKk)) {
            return 3;
        }
        int m1828getRighte0LSkKk = companion.m1828getRighte0LSkKk();
        if (textAlign != null && TextAlign.m1820equalsimpl0(textAlign.m1823unboximpl(), m1828getRighte0LSkKk)) {
            return 4;
        }
        int m1824getCentere0LSkKk = companion.m1824getCentere0LSkKk();
        if (textAlign != null && TextAlign.m1820equalsimpl0(textAlign.m1823unboximpl(), m1824getCentere0LSkKk)) {
            return 2;
        }
        int m1829getStarte0LSkKk = companion.m1829getStarte0LSkKk();
        if (textAlign == null || !TextAlign.m1820equalsimpl0(textAlign.m1823unboximpl(), m1829getStarte0LSkKk)) {
            int m1825getEnde0LSkKk = companion.m1825getEnde0LSkKk();
            if (textAlign != null && TextAlign.m1820equalsimpl0(textAlign.m1823unboximpl(), m1825getEnde0LSkKk)) {
                return 1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutHyphenationFrequency-0_XeFpE  reason: not valid java name */
    public static final int m1508toLayoutHyphenationFrequency0_XeFpE(Hyphens hyphens) {
        Hyphens.Companion companion = Hyphens.Companion;
        int m1760getAutovmbZdU8 = companion.m1760getAutovmbZdU8();
        if (hyphens != null && Hyphens.m1756equalsimpl0(hyphens.m1759unboximpl(), m1760getAutovmbZdU8)) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        int m1761getNonevmbZdU8 = companion.m1761getNonevmbZdU8();
        if (hyphens != null) {
            Hyphens.m1756equalsimpl0(hyphens.m1759unboximpl(), m1761getNonevmbZdU8);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-u6PBz3U  reason: not valid java name */
    public static final int m1507toLayoutBreakStrategyu6PBz3U(LineBreak.Strategy strategy) {
        LineBreak.Strategy.Companion companion = LineBreak.Strategy.Companion;
        int m1782getSimplefcGXIks = companion.m1782getSimplefcGXIks();
        if (strategy != null && LineBreak.Strategy.m1776equalsimpl0(strategy.m1779unboximpl(), m1782getSimplefcGXIks)) {
            return 0;
        }
        int m1781getHighQualityfcGXIks = companion.m1781getHighQualityfcGXIks();
        if (strategy != null && LineBreak.Strategy.m1776equalsimpl0(strategy.m1779unboximpl(), m1781getHighQualityfcGXIks)) {
            return 1;
        }
        return (strategy != null && LineBreak.Strategy.m1776equalsimpl0(strategy.m1779unboximpl(), companion.m1780getBalancedfcGXIks())) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-4a2g8L8  reason: not valid java name */
    public static final int m1509toLayoutLineBreakStyle4a2g8L8(LineBreak.Strictness strictness) {
        LineBreak.Strictness.Companion companion = LineBreak.Strictness.Companion;
        int m1790getDefaultusljTpc = companion.m1790getDefaultusljTpc();
        if (strictness != null && LineBreak.Strictness.m1786equalsimpl0(strictness.m1789unboximpl(), m1790getDefaultusljTpc)) {
            return 0;
        }
        int m1791getLooseusljTpc = companion.m1791getLooseusljTpc();
        if (strictness != null && LineBreak.Strictness.m1786equalsimpl0(strictness.m1789unboximpl(), m1791getLooseusljTpc)) {
            return 1;
        }
        int m1792getNormalusljTpc = companion.m1792getNormalusljTpc();
        if (strictness != null && LineBreak.Strictness.m1786equalsimpl0(strictness.m1789unboximpl(), m1792getNormalusljTpc)) {
            return 2;
        }
        return (strictness != null && LineBreak.Strictness.m1786equalsimpl0(strictness.m1789unboximpl(), companion.m1793getStrictusljTpc())) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-gvcdTPQ  reason: not valid java name */
    public static final int m1510toLayoutLineBreakWordStylegvcdTPQ(LineBreak.WordBreak wordBreak) {
        LineBreak.WordBreak.Companion companion = LineBreak.WordBreak.Companion;
        int m1801getDefaultjp8hJ3c = companion.m1801getDefaultjp8hJ3c();
        if (wordBreak != null && LineBreak.WordBreak.m1797equalsimpl0(wordBreak.m1800unboximpl(), m1801getDefaultjp8hJ3c)) {
            return 0;
        }
        return (wordBreak != null && LineBreak.WordBreak.m1797equalsimpl0(wordBreak.m1800unboximpl(), companion.m1802getPhrasejp8hJ3c())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > i) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        if (!z || TextUnit.m1961equalsimpl0(textStyle.m1602getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m1961equalsimpl0(textStyle.m1602getLetterSpacingXSAIIZE(), TextUnit.Companion.m1968getUnspecifiedXSAIIZE()) || textStyle.m1605getTextAlignbuA522U() == null) {
            return false;
        }
        TextAlign m1605getTextAlignbuA522U = textStyle.m1605getTextAlignbuA522U();
        TextAlign.Companion companion = TextAlign.Companion;
        int m1829getStarte0LSkKk = companion.m1829getStarte0LSkKk();
        if (m1605getTextAlignbuA522U != null && TextAlign.m1820equalsimpl0(m1605getTextAlignbuA522U.m1823unboximpl(), m1829getStarte0LSkKk)) {
            return false;
        }
        TextAlign m1605getTextAlignbuA522U2 = textStyle.m1605getTextAlignbuA522U();
        return m1605getTextAlignbuA522U2 == null || !TextAlign.m1820equalsimpl0(m1605getTextAlignbuA522U2.m1823unboximpl(), companion.m1826getJustifye0LSkKk());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }
}
