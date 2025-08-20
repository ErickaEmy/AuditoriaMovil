package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidParagraphIntrinsics.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidParagraphIntrinsics_androidKt {
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
        if (r6 == null) goto L28;
     */
    /* renamed from: resolveTextDirectionHeuristics-9GRLPo0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int m1724resolveTextDirectionHeuristics9GRLPo0(androidx.compose.ui.text.style.TextDirection r6, androidx.compose.ui.text.intl.LocaleList r7) {
        /*
            if (r6 == 0) goto L7
            int r6 = r6.m1836unboximpl()
            goto Ld
        L7:
            androidx.compose.ui.text.style.TextDirection$Companion r6 = androidx.compose.ui.text.style.TextDirection.Companion
            int r6 = r6.m1837getContents_7Xco()
        Ld:
            androidx.compose.ui.text.style.TextDirection$Companion r0 = androidx.compose.ui.text.style.TextDirection.Companion
            int r1 = r0.m1838getContentOrLtrs_7Xco()
            boolean r1 = androidx.compose.ui.text.style.TextDirection.m1833equalsimpl0(r6, r1)
            r2 = 2
            if (r1 == 0) goto L1b
            goto L6f
        L1b:
            int r1 = r0.m1839getContentOrRtls_7Xco()
            boolean r1 = androidx.compose.ui.text.style.TextDirection.m1833equalsimpl0(r6, r1)
            r3 = 3
            if (r1 == 0) goto L28
        L26:
            r2 = r3
            goto L6f
        L28:
            int r1 = r0.m1840getLtrs_7Xco()
            boolean r1 = androidx.compose.ui.text.style.TextDirection.m1833equalsimpl0(r6, r1)
            r4 = 0
            if (r1 == 0) goto L35
            r2 = r4
            goto L6f
        L35:
            int r1 = r0.m1841getRtls_7Xco()
            boolean r1 = androidx.compose.ui.text.style.TextDirection.m1833equalsimpl0(r6, r1)
            r5 = 1
            if (r1 == 0) goto L42
            r2 = r5
            goto L6f
        L42:
            int r0 = r0.m1837getContents_7Xco()
            boolean r6 = androidx.compose.ui.text.style.TextDirection.m1833equalsimpl0(r6, r0)
            if (r6 == 0) goto L70
            if (r7 == 0) goto L63
            androidx.compose.ui.text.intl.Locale r6 = r7.get(r4)
            androidx.compose.ui.text.intl.PlatformLocale r6 = r6.getPlatformLocale$ui_text_release()
            java.lang.String r7 = "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            androidx.compose.ui.text.intl.AndroidLocale r6 = (androidx.compose.ui.text.intl.AndroidLocale) r6
            java.util.Locale r6 = r6.getJavaLocale()
            if (r6 != 0) goto L67
        L63:
            java.util.Locale r6 = java.util.Locale.getDefault()
        L67:
            int r6 = androidx.core.text.TextUtilsCompat.getLayoutDirectionFromLocale(r6)
            if (r6 == 0) goto L6f
            if (r6 == r5) goto L26
        L6f:
            return r2
        L70:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Invalid TextDirection."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidParagraphIntrinsics_androidKt.m1724resolveTextDirectionHeuristics9GRLPo0(androidx.compose.ui.text.style.TextDirection, androidx.compose.ui.text.intl.LocaleList):int");
    }

    public static final ParagraphIntrinsics ActualParagraphIntrinsics(String text, TextStyle style, List spanStyles, List placeholders, Density density, FontFamily.Resolver fontFamilyResolver) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        return new AndroidParagraphIntrinsics(text, style, spanStyles, placeholders, fontFamilyResolver, density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHasEmojiCompat(TextStyle textStyle) {
        PlatformParagraphStyle paragraphStyle;
        PlatformTextStyle platformStyle = textStyle.getPlatformStyle();
        EmojiSupportMatch m1512boximpl = (platformStyle == null || (paragraphStyle = platformStyle.getParagraphStyle()) == null) ? null : EmojiSupportMatch.m1512boximpl(paragraphStyle.m1545getEmojiSupportMatch_3YsG6Y());
        return !(m1512boximpl == null ? false : EmojiSupportMatch.m1515equalsimpl0(m1512boximpl.m1518unboximpl(), EmojiSupportMatch.Companion.m1520getNone_3YsG6Y()));
    }
}
