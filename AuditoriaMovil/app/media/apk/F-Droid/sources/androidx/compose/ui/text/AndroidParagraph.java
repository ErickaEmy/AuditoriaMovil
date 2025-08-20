package androidx.compose.ui.text;

import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: AndroidParagraph.android.kt */
/* loaded from: classes.dex */
public final class AndroidParagraph implements Paragraph {
    private final CharSequence charSequence;
    private final long constraints;
    private final boolean ellipsis;
    private final TextLayout layout;
    private final int maxLines;
    private final AndroidParagraphIntrinsics paragraphIntrinsics;
    private final List placeholderRects;
    private final Lazy wordBoundary$delegate;

    /* compiled from: AndroidParagraph.android.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResolvedTextDirection.values().length];
            try {
                iArr[ResolvedTextDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResolvedTextDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i, boolean z, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidParagraphIntrinsics, i, z, j);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public List getPlaceholderRects() {
        return this.placeholderRects;
    }

    private AndroidParagraph(AndroidParagraphIntrinsics paragraphIntrinsics, int i, boolean z, long j) {
        CharSequence charSequence$ui_text_release;
        List list;
        Rect rect;
        float horizontalPosition;
        float lineBaseline;
        int heightPx;
        float lineTop;
        float f;
        float lineBaseline2;
        Lazy lazy;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(paragraphIntrinsics, "paragraphIntrinsics");
        this.paragraphIntrinsics = paragraphIntrinsics;
        this.maxLines = i;
        this.ellipsis = z;
        this.constraints = j;
        if (Constraints.m1873getMinHeightimpl(j) != 0 || Constraints.m1874getMinWidthimpl(j) != 0) {
            throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.".toString());
        }
        if (i < 1) {
            throw new IllegalArgumentException("maxLines should be greater than 0".toString());
        }
        TextStyle style = paragraphIntrinsics.getStyle();
        if (AndroidParagraph_androidKt.access$shouldAttachIndentationFixSpan(style, z)) {
            charSequence$ui_text_release = AndroidParagraph_androidKt.access$attachIndentationFixSpan(paragraphIntrinsics.getCharSequence$ui_text_release());
        } else {
            charSequence$ui_text_release = paragraphIntrinsics.getCharSequence$ui_text_release();
        }
        this.charSequence = charSequence$ui_text_release;
        int m1501access$toLayoutAlignAMY3VfE = AndroidParagraph_androidKt.m1501access$toLayoutAlignAMY3VfE(style.m1605getTextAlignbuA522U());
        TextAlign m1605getTextAlignbuA522U = style.m1605getTextAlignbuA522U();
        int i2 = m1605getTextAlignbuA522U == null ? 0 : TextAlign.m1820equalsimpl0(m1605getTextAlignbuA522U.m1823unboximpl(), TextAlign.Companion.m1826getJustifye0LSkKk()) ? 1 : 0;
        int m1503access$toLayoutHyphenationFrequency0_XeFpE = AndroidParagraph_androidKt.m1503access$toLayoutHyphenationFrequency0_XeFpE(style.getParagraphStyle$ui_text_release().m1536getHyphensEaSxIns());
        LineBreak m1603getLineBreakLgCVezo = style.m1603getLineBreakLgCVezo();
        int m1502access$toLayoutBreakStrategyu6PBz3U = AndroidParagraph_androidKt.m1502access$toLayoutBreakStrategyu6PBz3U(m1603getLineBreakLgCVezo != null ? LineBreak.Strategy.m1773boximpl(LineBreak.m1766getStrategyfcGXIks(m1603getLineBreakLgCVezo.m1771unboximpl())) : null);
        LineBreak m1603getLineBreakLgCVezo2 = style.m1603getLineBreakLgCVezo();
        int m1504access$toLayoutLineBreakStyle4a2g8L8 = AndroidParagraph_androidKt.m1504access$toLayoutLineBreakStyle4a2g8L8(m1603getLineBreakLgCVezo2 != null ? LineBreak.Strictness.m1783boximpl(LineBreak.m1767getStrictnessusljTpc(m1603getLineBreakLgCVezo2.m1771unboximpl())) : null);
        LineBreak m1603getLineBreakLgCVezo3 = style.m1603getLineBreakLgCVezo();
        int m1505access$toLayoutLineBreakWordStylegvcdTPQ = AndroidParagraph_androidKt.m1505access$toLayoutLineBreakWordStylegvcdTPQ(m1603getLineBreakLgCVezo3 != null ? LineBreak.WordBreak.m1794boximpl(LineBreak.m1768getWordBreakjp8hJ3c(m1603getLineBreakLgCVezo3.m1771unboximpl())) : null);
        TextUtils.TruncateAt truncateAt = z ? TextUtils.TruncateAt.END : null;
        TextLayout constructTextLayout = constructTextLayout(m1501access$toLayoutAlignAMY3VfE, i2, truncateAt, i, m1503access$toLayoutHyphenationFrequency0_XeFpE, m1502access$toLayoutBreakStrategyu6PBz3U, m1504access$toLayoutLineBreakStyle4a2g8L8, m1505access$toLayoutLineBreakWordStylegvcdTPQ);
        if (!z || constructTextLayout.getHeight() <= Constraints.m1871getMaxHeightimpl(j) || i <= 1) {
            this.layout = constructTextLayout;
        } else {
            int access$numberOfLinesThatFitMaxHeight = AndroidParagraph_androidKt.access$numberOfLinesThatFitMaxHeight(constructTextLayout, Constraints.m1871getMaxHeightimpl(j));
            if (access$numberOfLinesThatFitMaxHeight >= 0 && access$numberOfLinesThatFitMaxHeight != i) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(access$numberOfLinesThatFitMaxHeight, 1);
                constructTextLayout = constructTextLayout(m1501access$toLayoutAlignAMY3VfE, i2, truncateAt, coerceAtLeast, m1503access$toLayoutHyphenationFrequency0_XeFpE, m1502access$toLayoutBreakStrategyu6PBz3U, m1504access$toLayoutLineBreakStyle4a2g8L8, m1505access$toLayoutLineBreakWordStylegvcdTPQ);
            }
            this.layout = constructTextLayout;
        }
        getTextPaint$ui_text_release().m1729setBrush12SF9DM(style.getBrush(), SizeKt.Size(getWidth(), getHeight()), style.getAlpha());
        for (ShaderBrushSpan shaderBrushSpan : getShaderBrushSpans(this.layout)) {
            shaderBrushSpan.m1742setSizeuvyYCjk(SizeKt.Size(getWidth(), getHeight()));
        }
        CharSequence charSequence = this.charSequence;
        if (charSequence instanceof Spanned) {
            Object[] spans = ((Spanned) charSequence).getSpans(0, charSequence.length(), PlaceholderSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(0, length, PlaceholderSpan::class.java)");
            ArrayList arrayList = new ArrayList(spans.length);
            for (Object obj : spans) {
                PlaceholderSpan placeholderSpan = (PlaceholderSpan) obj;
                Spanned spanned = (Spanned) charSequence;
                int spanStart = spanned.getSpanStart(placeholderSpan);
                int spanEnd = spanned.getSpanEnd(placeholderSpan);
                int lineForOffset = this.layout.getLineForOffset(spanStart);
                Object[] objArr = lineForOffset >= this.maxLines ? 1 : null;
                Object[] objArr2 = (this.layout.getLineEllipsisCount(lineForOffset) <= 0 || spanEnd <= this.layout.getLineEllipsisOffset(lineForOffset)) ? null : 1;
                Object[] objArr3 = spanEnd > this.layout.getLineEnd(lineForOffset) ? 1 : null;
                if (objArr2 == null && objArr3 == null && objArr == null) {
                    int i3 = WhenMappings.$EnumSwitchMapping$0[getBidiRunDirection(spanStart).ordinal()];
                    if (i3 == 1) {
                        horizontalPosition = getHorizontalPosition(spanStart, true);
                    } else if (i3 != 2) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        horizontalPosition = getHorizontalPosition(spanStart, true) - placeholderSpan.getWidthPx();
                    }
                    float widthPx = placeholderSpan.getWidthPx() + horizontalPosition;
                    TextLayout textLayout = this.layout;
                    switch (placeholderSpan.getVerticalAlign()) {
                        case 0:
                            lineBaseline = textLayout.getLineBaseline(lineForOffset);
                            heightPx = placeholderSpan.getHeightPx();
                            lineTop = lineBaseline - heightPx;
                            break;
                        case 1:
                            lineTop = textLayout.getLineTop(lineForOffset);
                            break;
                        case 2:
                            lineBaseline = textLayout.getLineBottom(lineForOffset);
                            heightPx = placeholderSpan.getHeightPx();
                            lineTop = lineBaseline - heightPx;
                            break;
                        case 3:
                            lineTop = ((textLayout.getLineTop(lineForOffset) + textLayout.getLineBottom(lineForOffset)) - placeholderSpan.getHeightPx()) / 2;
                            break;
                        case 4:
                            f = placeholderSpan.getFontMetrics().ascent;
                            lineBaseline2 = textLayout.getLineBaseline(lineForOffset);
                            lineTop = f + lineBaseline2;
                            break;
                        case 5:
                            lineTop = (placeholderSpan.getFontMetrics().descent + textLayout.getLineBaseline(lineForOffset)) - placeholderSpan.getHeightPx();
                            break;
                        case 6:
                            Paint.FontMetricsInt fontMetrics = placeholderSpan.getFontMetrics();
                            f = ((fontMetrics.ascent + fontMetrics.descent) - placeholderSpan.getHeightPx()) / 2;
                            lineBaseline2 = textLayout.getLineBaseline(lineForOffset);
                            lineTop = f + lineBaseline2;
                            break;
                        default:
                            throw new IllegalStateException("unexpected verticalAlignment");
                    }
                    rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                } else {
                    rect = null;
                }
                arrayList.add(rect);
            }
            list = arrayList;
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        this.placeholderRects = list;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: androidx.compose.ui.text.AndroidParagraph$wordBoundary$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final WordBoundary invoke() {
                TextLayout textLayout2;
                Locale textLocale$ui_text_release = AndroidParagraph.this.getTextLocale$ui_text_release();
                textLayout2 = AndroidParagraph.this.layout;
                return new WordBoundary(textLocale$ui_text_release, textLayout2.getText());
            }
        });
        this.wordBoundary$delegate = lazy;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getWidth() {
        return Constraints.m1872getMaxWidthimpl(this.constraints);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHeight() {
        return this.layout.getHeight();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getMinIntrinsicWidth() {
        return this.paragraphIntrinsics.getMinIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getFirstBaseline() {
        return getLineBaseline$ui_text_release(0);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLastBaseline() {
        return getLineBaseline$ui_text_release(getLineCount() - 1);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean getDidExceedMaxLines() {
        return this.layout.getDidExceedMaxLines();
    }

    public final Locale getTextLocale$ui_text_release() {
        Locale textLocale = this.paragraphIntrinsics.getTextPaint$ui_text_release().getTextLocale();
        Intrinsics.checkNotNullExpressionValue(textLocale, "paragraphIntrinsics.textPaint.textLocale");
        return textLocale;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineCount() {
        return this.layout.getLineCount();
    }

    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint$ui_text_release();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForVerticalPosition(float f) {
        return this.layout.getLineForVertical((int) f);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getOffsetForPosition-k-4lQ0M  reason: not valid java name */
    public int mo1497getOffsetForPositionk4lQ0M(long j) {
        return this.layout.getOffsetForHorizontal(this.layout.getLineForVertical((int) Offset.m710getYimpl(j)), Offset.m709getXimpl(j));
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect getBoundingBox(int i) {
        RectF boundingBox = this.layout.getBoundingBox(i);
        return new Rect(boundingBox.left, boundingBox.top, boundingBox.right, boundingBox.bottom);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Path getPathForRange(int i, int i2) {
        if (i < 0 || i > i2 || i2 > this.charSequence.length()) {
            throw new AssertionError("Start(" + i + ") or End(" + i2 + ") is out of Range(0.." + this.charSequence.length() + "), or start > end!");
        }
        android.graphics.Path path = new android.graphics.Path();
        this.layout.getSelectionPath(i, i2, path);
        return AndroidPath_androidKt.asComposePath(path);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect getCursorRect(int i) {
        if (i < 0 || i > this.charSequence.length()) {
            throw new AssertionError("offset(" + i + ") is out of bounds (0," + this.charSequence.length());
        }
        float primaryHorizontal$default = TextLayout.getPrimaryHorizontal$default(this.layout, i, false, 2, null);
        int lineForOffset = this.layout.getLineForOffset(i);
        return new Rect(primaryHorizontal$default, this.layout.getLineTop(lineForOffset), primaryHorizontal$default, this.layout.getLineBottom(lineForOffset));
    }

    private final WordBoundary getWordBoundary() {
        return (WordBoundary) this.wordBoundary$delegate.getValue();
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getWordBoundary--jx7JFs  reason: not valid java name */
    public long mo1498getWordBoundaryjx7JFs(int i) {
        return TextRangeKt.TextRange(getWordBoundary().getWordStart(i), getWordBoundary().getWordEnd(i));
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineLeft(int i) {
        return this.layout.getLineLeft(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineRight(int i) {
        return this.layout.getLineRight(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineTop(int i) {
        return this.layout.getLineTop(i);
    }

    public final float getLineBaseline$ui_text_release(int i) {
        return this.layout.getLineBaseline(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineBottom(int i) {
        return this.layout.getLineBottom(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineStart(int i) {
        return this.layout.getLineStart(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineEnd(int i, boolean z) {
        if (z) {
            return this.layout.getLineVisibleEnd(i);
        }
        return this.layout.getLineEnd(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForOffset(int i) {
        return this.layout.getLineForOffset(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHorizontalPosition(int i, boolean z) {
        if (z) {
            return TextLayout.getPrimaryHorizontal$default(this.layout, i, false, 2, null);
        }
        return TextLayout.getSecondaryHorizontal$default(this.layout, i, false, 2, null);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection getParagraphDirection(int i) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(i)) == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection getBidiRunDirection(int i) {
        if (this.layout.isRtlCharAt(i)) {
            return ResolvedTextDirection.Rtl;
        }
        return ResolvedTextDirection.Ltr;
    }

    private final ShaderBrushSpan[] getShaderBrushSpans(TextLayout textLayout) {
        if (textLayout.getText() instanceof Spanned) {
            CharSequence text = textLayout.getText();
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
            ShaderBrushSpan[] brushSpans = (ShaderBrushSpan[]) ((Spanned) text).getSpans(0, textLayout.getText().length(), ShaderBrushSpan.class);
            Intrinsics.checkNotNullExpressionValue(brushSpans, "brushSpans");
            return brushSpans.length == 0 ? new ShaderBrushSpan[0] : brushSpans;
        }
        return new ShaderBrushSpan[0];
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-LG529CI  reason: not valid java name */
    public void mo1499paintLG529CI(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int m1727getBlendMode0nO6VwU = getTextPaint$ui_text_release().m1727getBlendMode0nO6VwU();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m1730setColor8_81llA(j);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        textPaint$ui_text_release.setDrawStyle(drawStyle);
        textPaint$ui_text_release.m1728setBlendModes9anfk8(i);
        paint(canvas);
        getTextPaint$ui_text_release().m1728setBlendModes9anfk8(m1727getBlendMode0nO6VwU);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-hn5TExg  reason: not valid java name */
    public void mo1500painthn5TExg(Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(brush, "brush");
        int m1727getBlendMode0nO6VwU = getTextPaint$ui_text_release().m1727getBlendMode0nO6VwU();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m1729setBrush12SF9DM(brush, SizeKt.Size(getWidth(), getHeight()), f);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        textPaint$ui_text_release.setDrawStyle(drawStyle);
        textPaint$ui_text_release.m1728setBlendModes9anfk8(i);
        paint(canvas);
        getTextPaint$ui_text_release().m1728setBlendModes9anfk8(m1727getBlendMode0nO6VwU);
    }

    private final void paint(Canvas canvas) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.save();
            nativeCanvas.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.layout.paint(nativeCanvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.restore();
        }
    }

    private final TextLayout constructTextLayout(int i, int i2, TextUtils.TruncateAt truncateAt, int i3, int i4, int i5, int i6, int i7) {
        return new TextLayout(this.charSequence, getWidth(), getTextPaint$ui_text_release(), i, truncateAt, this.paragraphIntrinsics.getTextDirectionHeuristic$ui_text_release(), 1.0f, 0.0f, AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(this.paragraphIntrinsics.getStyle()), true, i3, i5, i6, i7, i4, i2, null, null, this.paragraphIntrinsics.getLayoutIntrinsics$ui_text_release(), 196736, null);
    }
}
