package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextStyle.kt */
/* loaded from: classes.dex */
public abstract class TextStyleKt {

    /* compiled from: TextStyle.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final TextStyle lerp(TextStyle start, TextStyle stop, float f) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        return new TextStyle(SpanStyleKt.lerp(start.toSpanStyle(), stop.toSpanStyle(), f), ParagraphStyleKt.lerp(start.toParagraphStyle(), stop.toParagraphStyle(), f));
    }

    public static final TextStyle resolveDefaults(TextStyle style, LayoutDirection direction) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(direction, "direction");
        return new TextStyle(SpanStyleKt.resolveSpanStyleDefaults(style.getSpanStyle$ui_text_release()), ParagraphStyleKt.resolveParagraphStyleDefaults(style.getParagraphStyle$ui_text_release(), direction), style.getPlatformStyle());
    }

    /* renamed from: resolveTextDirection-Yj3eThk */
    public static final int m1608resolveTextDirectionYj3eThk(LayoutDirection layoutDirection, TextDirection textDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        TextDirection.Companion companion = TextDirection.Companion;
        int m1837getContents_7Xco = companion.m1837getContents_7Xco();
        if (textDirection != null && TextDirection.m1833equalsimpl0(textDirection.m1836unboximpl(), m1837getContents_7Xco)) {
            int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return companion.m1839getContentOrRtls_7Xco();
                }
                throw new NoWhenBranchMatchedException();
            }
            return companion.m1838getContentOrLtrs_7Xco();
        } else if (textDirection == null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return companion.m1841getRtls_7Xco();
                }
                throw new NoWhenBranchMatchedException();
            }
            return companion.m1840getLtrs_7Xco();
        } else {
            return textDirection.m1836unboximpl();
        }
    }

    public static final PlatformTextStyle createPlatformTextStyleInternal(PlatformSpanStyle platformSpanStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (platformSpanStyle == null && platformParagraphStyle == null) {
            return null;
        }
        return AndroidTextStyle_androidKt.createPlatformTextStyle(platformSpanStyle, platformParagraphStyle);
    }
}
