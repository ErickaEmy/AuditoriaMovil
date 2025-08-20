package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.foundation.text.modifiers.MinLinesConstrainer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphIntrinsicsKt;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ParagraphLayoutCache.kt */
/* loaded from: classes.dex */
public final class ParagraphLayoutCache {
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private boolean didOverflow;
    private FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private long lastDensity;
    private long layoutSize;
    private MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private Paragraph paragraph;
    private ParagraphIntrinsics paragraphIntrinsics;
    private long prevConstraints;
    private boolean softWrap;
    private TextStyle style;
    private String text;

    public /* synthetic */ ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, i, z, i2, i3);
    }

    public final boolean getDidOverflow$foundation_release() {
        return this.didOverflow;
    }

    /* renamed from: getLayoutSize-YbymL2g$foundation_release  reason: not valid java name */
    public final long m379getLayoutSizeYbymL2g$foundation_release() {
        return this.layoutSize;
    }

    public final Paragraph getParagraph$foundation_release() {
        return this.paragraph;
    }

    private ParagraphLayoutCache(String text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int i, boolean z, int i2, int i3) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.lastDensity = InlineDensity.Companion.m367getUnspecifiedL26CHvs();
        this.layoutSize = IntSizeKt.IntSize(0, 0);
        this.prevConstraints = Constraints.Companion.m1879fixedJhjzzOo(0, 0);
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
    }

    public final void setDensity$foundation_release(Density density) {
        Density density2 = this.density;
        long m365constructorimpl = density != null ? InlineDensity.m365constructorimpl(density) : InlineDensity.Companion.m367getUnspecifiedL26CHvs();
        if (density2 == null) {
            this.density = density;
            this.lastDensity = m365constructorimpl;
        } else if (density == null || !InlineDensity.m366equalsimpl0(this.lastDensity, m365constructorimpl)) {
            this.density = density;
            this.lastDensity = m365constructorimpl;
            markDirty();
        }
    }

    public final Unit getObserveFontChanges$foundation_release() {
        ParagraphIntrinsics paragraphIntrinsics = this.paragraphIntrinsics;
        if (paragraphIntrinsics != null) {
            paragraphIntrinsics.getHasStaleResolvedFonts();
        }
        return Unit.INSTANCE;
    }

    /* renamed from: layoutWithConstraints-K40F9xA  reason: not valid java name */
    public final boolean m380layoutWithConstraintsK40F9xA(long j, LayoutDirection layoutDirection) {
        long m1881constrain4WqzIAM;
        long m1881constrain4WqzIAM2;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        boolean z = true;
        if (this.minLines > 1) {
            MinLinesConstrainer.Companion companion = MinLinesConstrainer.Companion;
            MinLinesConstrainer minLinesConstrainer = this.mMinLinesConstrainer;
            TextStyle textStyle = this.style;
            Density density = this.density;
            Intrinsics.checkNotNull(density);
            MinLinesConstrainer from = companion.from(minLinesConstrainer, layoutDirection, textStyle, density, this.fontFamilyResolver);
            this.mMinLinesConstrainer = from;
            j = from.m371coerceMinLinesOh53vG4$foundation_release(j, this.minLines);
        }
        boolean z2 = false;
        if (!m378newLayoutWillBeDifferentK40F9xA(j, layoutDirection)) {
            if (!Constraints.m1865equalsimpl0(j, this.prevConstraints)) {
                Paragraph paragraph = this.paragraph;
                Intrinsics.checkNotNull(paragraph);
                this.layoutSize = ConstraintsKt.m1881constrain4WqzIAM(j, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(paragraph.getWidth()), TextDelegateKt.ceilToIntPx(paragraph.getHeight())));
                if (TextOverflow.m1854equalsimpl0(this.overflow, TextOverflow.Companion.m1859getVisiblegIe3tQ8()) || (IntSize.m1951getWidthimpl(m1881constrain4WqzIAM2) >= paragraph.getWidth() && IntSize.m1950getHeightimpl(m1881constrain4WqzIAM2) >= paragraph.getHeight())) {
                    z = false;
                }
                this.didOverflow = z;
            }
            return false;
        }
        Paragraph m377layoutTextK40F9xA = m377layoutTextK40F9xA(j, layoutDirection);
        this.prevConstraints = j;
        this.layoutSize = ConstraintsKt.m1881constrain4WqzIAM(j, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(m377layoutTextK40F9xA.getWidth()), TextDelegateKt.ceilToIntPx(m377layoutTextK40F9xA.getHeight())));
        if (!TextOverflow.m1854equalsimpl0(this.overflow, TextOverflow.Companion.m1859getVisiblegIe3tQ8()) && (IntSize.m1951getWidthimpl(m1881constrain4WqzIAM) < m377layoutTextK40F9xA.getWidth() || IntSize.m1950getHeightimpl(m1881constrain4WqzIAM) < m377layoutTextK40F9xA.getHeight())) {
            z2 = true;
        }
        this.didOverflow = z2;
        this.paragraph = m377layoutTextK40F9xA;
        return true;
    }

    public final int intrinsicHeight(int i, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int i2 = this.cachedIntrinsicHeightInputWidth;
        int i3 = this.cachedIntrinsicHeight;
        if (i != i2 || i2 == -1) {
            int ceilToIntPx = TextDelegateKt.ceilToIntPx(m377layoutTextK40F9xA(ConstraintsKt.Constraints(0, i, 0, Integer.MAX_VALUE), layoutDirection).getHeight());
            this.cachedIntrinsicHeightInputWidth = i;
            this.cachedIntrinsicHeight = ceilToIntPx;
            return ceilToIntPx;
        }
        return i3;
    }

    /* renamed from: update-L6sJoHM  reason: not valid java name */
    public final void m381updateL6sJoHM(String text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int i, boolean z, int i2, int i3) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        markDirty();
    }

    private final ParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsics = this.paragraphIntrinsics;
        if (paragraphIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || paragraphIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            String str = this.text;
            TextStyle resolveDefaults = TextStyleKt.resolveDefaults(this.style, layoutDirection);
            Density density = this.density;
            Intrinsics.checkNotNull(density);
            paragraphIntrinsics = ParagraphIntrinsicsKt.ParagraphIntrinsics$default(str, resolveDefaults, null, null, density, this.fontFamilyResolver, 12, null);
        }
        this.paragraphIntrinsics = paragraphIntrinsics;
        return paragraphIntrinsics;
    }

    /* renamed from: layoutText-K40F9xA  reason: not valid java name */
    private final Paragraph m377layoutTextK40F9xA(long j, LayoutDirection layoutDirection) {
        ParagraphIntrinsics layoutDirection2 = setLayoutDirection(layoutDirection);
        return ParagraphKt.m1533Paragraph_EkL_Y(layoutDirection2, LayoutUtilsKt.m368finalConstraintstfFHcEY(j, this.softWrap, this.overflow, layoutDirection2.getMaxIntrinsicWidth()), LayoutUtilsKt.m369finalMaxLinesxdlQI24(this.softWrap, this.overflow, this.maxLines), TextOverflow.m1854equalsimpl0(this.overflow, TextOverflow.Companion.m1858getEllipsisgIe3tQ8()));
    }

    /* renamed from: newLayoutWillBeDifferent-K40F9xA  reason: not valid java name */
    private final boolean m378newLayoutWillBeDifferentK40F9xA(long j, LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsics;
        Paragraph paragraph = this.paragraph;
        if (paragraph == null || (paragraphIntrinsics = this.paragraphIntrinsics) == null || paragraphIntrinsics.getHasStaleResolvedFonts() || layoutDirection != this.intrinsicsLayoutDirection) {
            return true;
        }
        if (Constraints.m1865equalsimpl0(j, this.prevConstraints)) {
            return false;
        }
        return Constraints.m1872getMaxWidthimpl(j) != Constraints.m1872getMaxWidthimpl(this.prevConstraints) || ((float) Constraints.m1871getMaxHeightimpl(j)) < paragraph.getHeight() || paragraph.getDidExceedMaxLines();
    }

    private final void markDirty() {
        this.paragraph = null;
        this.paragraphIntrinsics = null;
        this.intrinsicsLayoutDirection = null;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
        this.prevConstraints = Constraints.Companion.m1879fixedJhjzzOo(0, 0);
        this.layoutSize = IntSizeKt.IntSize(0, 0);
        this.didOverflow = false;
    }

    public final TextLayoutResult slowCreateTextLayoutResultOrNull() {
        Density density;
        List emptyList;
        List emptyList2;
        LayoutDirection layoutDirection = this.intrinsicsLayoutDirection;
        if (layoutDirection == null || (density = this.density) == null) {
            return null;
        }
        AnnotatedString annotatedString = new AnnotatedString(this.text, null, null, 6, null);
        if (this.paragraph == null || this.paragraphIntrinsics == null) {
            return null;
        }
        long m1863copyZbe2FdA$default = Constraints.m1863copyZbe2FdA$default(this.prevConstraints, 0, 0, 0, 0, 10, null);
        TextStyle textStyle = this.style;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        TextLayoutInput textLayoutInput = new TextLayoutInput(annotatedString, textStyle, emptyList, this.maxLines, this.softWrap, this.overflow, density, layoutDirection, this.fontFamilyResolver, m1863copyZbe2FdA$default, (DefaultConstructorMarker) null);
        TextStyle textStyle2 = this.style;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        return new TextLayoutResult(textLayoutInput, new MultiParagraph(new MultiParagraphIntrinsics(annotatedString, textStyle2, emptyList2, density, this.fontFamilyResolver), m1863copyZbe2FdA$default, this.maxLines, TextOverflow.m1854equalsimpl0(this.overflow, TextOverflow.Companion.m1858getEllipsisgIe3tQ8()), null), this.layoutSize, null);
    }

    public final int minIntrinsicWidth(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMinIntrinsicWidth());
    }

    public final int maxIntrinsicWidth(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMaxIntrinsicWidth());
    }
}
