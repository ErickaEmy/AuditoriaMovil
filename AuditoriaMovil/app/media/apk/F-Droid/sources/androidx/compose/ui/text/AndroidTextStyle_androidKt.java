package androidx.compose.ui.text;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidTextStyle.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidTextStyle_androidKt {
    public static final PlatformSpanStyle lerp(PlatformSpanStyle start, PlatformSpanStyle stop, float f) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        return start;
    }

    public static final PlatformTextStyle createPlatformTextStyle(PlatformSpanStyle platformSpanStyle, PlatformParagraphStyle platformParagraphStyle) {
        return new PlatformTextStyle(platformSpanStyle, platformParagraphStyle);
    }

    public static final PlatformParagraphStyle lerp(PlatformParagraphStyle start, PlatformParagraphStyle stop, float f) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        return start.getIncludeFontPadding() == stop.getIncludeFontPadding() ? start : new PlatformParagraphStyle(((EmojiSupportMatch) SpanStyleKt.lerpDiscrete(EmojiSupportMatch.m1512boximpl(start.m1545getEmojiSupportMatch_3YsG6Y()), EmojiSupportMatch.m1512boximpl(stop.m1545getEmojiSupportMatch_3YsG6Y()), f)).m1518unboximpl(), ((Boolean) SpanStyleKt.lerpDiscrete(Boolean.valueOf(start.getIncludeFontPadding()), Boolean.valueOf(stop.getIncludeFontPadding()), f)).booleanValue(), null);
    }
}
