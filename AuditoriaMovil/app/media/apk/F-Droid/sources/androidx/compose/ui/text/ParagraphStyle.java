package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ParagraphStyle.kt */
/* loaded from: classes.dex */
public final class ParagraphStyle {
    private final Hyphens hyphens;
    private final int hyphensOrDefault;
    private final LineBreak lineBreak;
    private final int lineBreakOrDefault;
    private final long lineHeight;
    private final LineHeightStyle lineHeightStyle;
    private final PlatformParagraphStyle platformStyle;
    private final TextAlign textAlign;
    private final int textAlignOrDefault;
    private final TextDirection textDirection;
    private final TextIndent textIndent;
    private final TextMotion textMotion;

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign, textDirection, j, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    /* renamed from: getHyphens-EaSxIns  reason: not valid java name */
    public final Hyphens m1536getHyphensEaSxIns() {
        return this.hyphens;
    }

    /* renamed from: getHyphensOrDefault-vmbZdU8$ui_text_release  reason: not valid java name */
    public final int m1537getHyphensOrDefaultvmbZdU8$ui_text_release() {
        return this.hyphensOrDefault;
    }

    /* renamed from: getLineBreak-LgCVezo  reason: not valid java name */
    public final LineBreak m1538getLineBreakLgCVezo() {
        return this.lineBreak;
    }

    /* renamed from: getLineBreakOrDefault-rAG3T2k$ui_text_release  reason: not valid java name */
    public final int m1539getLineBreakOrDefaultrAG3T2k$ui_text_release() {
        return this.lineBreakOrDefault;
    }

    /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
    public final long m1540getLineHeightXSAIIZE() {
        return this.lineHeight;
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.lineHeightStyle;
    }

    public final PlatformParagraphStyle getPlatformStyle() {
        return this.platformStyle;
    }

    /* renamed from: getTextAlign-buA522U  reason: not valid java name */
    public final TextAlign m1541getTextAlignbuA522U() {
        return this.textAlign;
    }

    /* renamed from: getTextAlignOrDefault-e0LSkKk$ui_text_release  reason: not valid java name */
    public final int m1542getTextAlignOrDefaulte0LSkKk$ui_text_release() {
        return this.textAlignOrDefault;
    }

    /* renamed from: getTextDirection-mmuk1to  reason: not valid java name */
    public final TextDirection m1543getTextDirectionmmuk1to() {
        return this.textDirection;
    }

    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    public final TextMotion getTextMotion() {
        return this.textMotion;
    }

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        this.textAlign = textAlign;
        this.textDirection = textDirection;
        this.lineHeight = j;
        this.textIndent = textIndent;
        this.platformStyle = platformParagraphStyle;
        this.lineHeightStyle = lineHeightStyle;
        this.lineBreak = lineBreak;
        this.hyphens = hyphens;
        this.textMotion = textMotion;
        this.textAlignOrDefault = textAlign != null ? textAlign.m1823unboximpl() : TextAlign.Companion.m1829getStarte0LSkKk();
        this.lineBreakOrDefault = lineBreak != null ? lineBreak.m1771unboximpl() : LineBreak.Companion.m1772getSimplerAG3T2k();
        this.hyphensOrDefault = hyphens != null ? hyphens.m1759unboximpl() : Hyphens.Companion.m1761getNonevmbZdU8();
        if (TextUnit.m1961equalsimpl0(j, TextUnit.Companion.m1968getUnspecifiedXSAIIZE()) || TextUnit.m1964getValueimpl(j) >= 0.0f) {
            return;
        }
        throw new IllegalStateException(("lineHeight can't be negative (" + TextUnit.m1964getValueimpl(j) + CoreConstants.RIGHT_PARENTHESIS_CHAR).toString());
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign, (i & 2) != 0 ? null : textDirection, (i & 4) != 0 ? TextUnit.Companion.m1968getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : textIndent, (i & 16) != 0 ? null : platformParagraphStyle, (i & 32) != 0 ? null : lineHeightStyle, (i & 64) != 0 ? null : lineBreak, (i & 128) != 0 ? null : hyphens, (i & 256) == 0 ? textMotion : null, null);
    }

    public final ParagraphStyle merge(ParagraphStyle paragraphStyle) {
        return paragraphStyle == null ? this : ParagraphStyleKt.m1544fastMergeHtYhynw(this, paragraphStyle.textAlign, paragraphStyle.textDirection, paragraphStyle.lineHeight, paragraphStyle.textIndent, paragraphStyle.platformStyle, paragraphStyle.lineHeightStyle, paragraphStyle.lineBreak, paragraphStyle.hyphens, paragraphStyle.textMotion);
    }

    /* renamed from: copy-NH1kkwU  reason: not valid java name */
    public final ParagraphStyle m1535copyNH1kkwU(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        return new ParagraphStyle(textAlign, textDirection, j, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens, textMotion, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParagraphStyle) {
            ParagraphStyle paragraphStyle = (ParagraphStyle) obj;
            return Intrinsics.areEqual(this.textAlign, paragraphStyle.textAlign) && Intrinsics.areEqual(this.textDirection, paragraphStyle.textDirection) && TextUnit.m1961equalsimpl0(this.lineHeight, paragraphStyle.lineHeight) && Intrinsics.areEqual(this.textIndent, paragraphStyle.textIndent) && Intrinsics.areEqual(this.platformStyle, paragraphStyle.platformStyle) && Intrinsics.areEqual(this.lineHeightStyle, paragraphStyle.lineHeightStyle) && Intrinsics.areEqual(this.lineBreak, paragraphStyle.lineBreak) && Intrinsics.areEqual(this.hyphens, paragraphStyle.hyphens) && Intrinsics.areEqual(this.textMotion, paragraphStyle.textMotion);
        }
        return false;
    }

    public int hashCode() {
        TextAlign textAlign = this.textAlign;
        int m1821hashCodeimpl = (textAlign != null ? TextAlign.m1821hashCodeimpl(textAlign.m1823unboximpl()) : 0) * 31;
        TextDirection textDirection = this.textDirection;
        int m1834hashCodeimpl = (((m1821hashCodeimpl + (textDirection != null ? TextDirection.m1834hashCodeimpl(textDirection.m1836unboximpl()) : 0)) * 31) + TextUnit.m1965hashCodeimpl(this.lineHeight)) * 31;
        TextIndent textIndent = this.textIndent;
        int hashCode = (m1834hashCodeimpl + (textIndent != null ? textIndent.hashCode() : 0)) * 31;
        PlatformParagraphStyle platformParagraphStyle = this.platformStyle;
        int hashCode2 = (hashCode + (platformParagraphStyle != null ? platformParagraphStyle.hashCode() : 0)) * 31;
        LineHeightStyle lineHeightStyle = this.lineHeightStyle;
        int hashCode3 = (hashCode2 + (lineHeightStyle != null ? lineHeightStyle.hashCode() : 0)) * 31;
        LineBreak lineBreak = this.lineBreak;
        int m1769hashCodeimpl = (hashCode3 + (lineBreak != null ? LineBreak.m1769hashCodeimpl(lineBreak.m1771unboximpl()) : 0)) * 31;
        Hyphens hyphens = this.hyphens;
        int m1757hashCodeimpl = (m1769hashCodeimpl + (hyphens != null ? Hyphens.m1757hashCodeimpl(hyphens.m1759unboximpl()) : 0)) * 31;
        TextMotion textMotion = this.textMotion;
        return m1757hashCodeimpl + (textMotion != null ? textMotion.hashCode() : 0);
    }

    public String toString() {
        return "ParagraphStyle(textAlign=" + this.textAlign + ", textDirection=" + this.textDirection + ", lineHeight=" + ((Object) TextUnit.m1966toStringimpl(this.lineHeight)) + ", textIndent=" + this.textIndent + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + this.lineHeightStyle + ", lineBreak=" + this.lineBreak + ", hyphens=" + this.hyphens + ", textMotion=" + this.textMotion + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
