package androidx.compose.ui.text;

import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: AndroidTextStyle.android.kt */
/* loaded from: classes.dex */
public final class PlatformParagraphStyle {
    public static final Companion Companion = new Companion(null);
    private static final PlatformParagraphStyle Default = new PlatformParagraphStyle();
    private final int emojiSupportMatch;
    private final boolean includeFontPadding;

    public /* synthetic */ PlatformParagraphStyle(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z);
    }

    /* renamed from: getEmojiSupportMatch-_3YsG6Y  reason: not valid java name */
    public final int m1545getEmojiSupportMatch_3YsG6Y() {
        return this.emojiSupportMatch;
    }

    public final boolean getIncludeFontPadding() {
        return this.includeFontPadding;
    }

    public final PlatformParagraphStyle merge(PlatformParagraphStyle platformParagraphStyle) {
        return platformParagraphStyle == null ? this : platformParagraphStyle;
    }

    /* compiled from: AndroidTextStyle.android.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlatformParagraphStyle getDefault() {
            return PlatformParagraphStyle.Default;
        }
    }

    public PlatformParagraphStyle(boolean z) {
        this.includeFontPadding = z;
        this.emojiSupportMatch = EmojiSupportMatch.Companion.m1519getDefault_3YsG6Y();
    }

    private PlatformParagraphStyle(int i, boolean z) {
        this.includeFontPadding = z;
        this.emojiSupportMatch = i;
    }

    public PlatformParagraphStyle() {
        this(EmojiSupportMatch.Companion.m1519getDefault_3YsG6Y(), true, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlatformParagraphStyle) {
            PlatformParagraphStyle platformParagraphStyle = (PlatformParagraphStyle) obj;
            return this.includeFontPadding == platformParagraphStyle.includeFontPadding && EmojiSupportMatch.m1515equalsimpl0(this.emojiSupportMatch, platformParagraphStyle.emojiSupportMatch);
        }
        return false;
    }

    public int hashCode() {
        return (ClickableElement$$ExternalSyntheticBackport0.m(this.includeFontPadding) * 31) + EmojiSupportMatch.m1516hashCodeimpl(this.emojiSupportMatch);
    }

    public String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.includeFontPadding + ", emojiSupportMatch=" + ((Object) EmojiSupportMatch.m1517toStringimpl(this.emojiSupportMatch)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
