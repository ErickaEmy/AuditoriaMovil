package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: AccessibilityIterators.android.kt */
/* loaded from: classes.dex */
public final class AccessibilityIterators$PageTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {
    private static AccessibilityIterators$PageTextSegmentIterator pageInstance;
    private TextLayoutResult layoutResult;
    private SemanticsNode node;
    private Rect tempRect;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;
    private static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;

    public /* synthetic */ AccessibilityIterators$PageTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AccessibilityIterators$PageTextSegmentIterator() {
        this.tempRect = new Rect();
    }

    /* compiled from: AccessibilityIterators.android.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccessibilityIterators$PageTextSegmentIterator getInstance() {
            if (AccessibilityIterators$PageTextSegmentIterator.pageInstance == null) {
                AccessibilityIterators$PageTextSegmentIterator.pageInstance = new AccessibilityIterators$PageTextSegmentIterator(null);
            }
            AccessibilityIterators$PageTextSegmentIterator accessibilityIterators$PageTextSegmentIterator = AccessibilityIterators$PageTextSegmentIterator.pageInstance;
            Intrinsics.checkNotNull(accessibilityIterators$PageTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
            return accessibilityIterators$PageTextSegmentIterator;
        }
    }

    public final void initialize(String text, TextLayoutResult layoutResult, SemanticsNode node) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(layoutResult, "layoutResult");
        Intrinsics.checkNotNullParameter(node, "node");
        setText(text);
        this.layoutResult = layoutResult;
        this.node = node;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public int[] following(int i) {
        int roundToInt;
        int coerceAtLeast;
        int lineCount;
        TextLayoutResult textLayoutResult = null;
        if (getText().length() > 0 && i < getText().length()) {
            try {
                SemanticsNode semanticsNode = this.node;
                if (semanticsNode == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("node");
                    semanticsNode = null;
                }
                roundToInt = MathKt__MathJVMKt.roundToInt(semanticsNode.getBoundsInRoot().getHeight());
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, i);
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(coerceAtLeast);
                TextLayoutResult textLayoutResult3 = this.layoutResult;
                if (textLayoutResult3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult3 = null;
                }
                float lineTop = textLayoutResult3.getLineTop(lineForOffset) + roundToInt;
                TextLayoutResult textLayoutResult4 = this.layoutResult;
                if (textLayoutResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult4 = null;
                }
                TextLayoutResult textLayoutResult5 = this.layoutResult;
                if (textLayoutResult5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult5 = null;
                }
                if (lineTop < textLayoutResult4.getLineTop(textLayoutResult5.getLineCount() - 1)) {
                    TextLayoutResult textLayoutResult6 = this.layoutResult;
                    if (textLayoutResult6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult6;
                    }
                    lineCount = textLayoutResult.getLineForVerticalPosition(lineTop);
                } else {
                    TextLayoutResult textLayoutResult7 = this.layoutResult;
                    if (textLayoutResult7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult7;
                    }
                    lineCount = textLayoutResult.getLineCount();
                }
                return getRange(coerceAtLeast, getLineEdgeIndex(lineCount - 1, DirectionEnd) + 1);
            } catch (IllegalStateException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public int[] preceding(int i) {
        int roundToInt;
        int coerceAtMost;
        int i2;
        TextLayoutResult textLayoutResult = null;
        if (getText().length() > 0 && i > 0) {
            try {
                SemanticsNode semanticsNode = this.node;
                if (semanticsNode == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("node");
                    semanticsNode = null;
                }
                roundToInt = MathKt__MathJVMKt.roundToInt(semanticsNode.getBoundsInRoot().getHeight());
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(getText().length(), i);
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(coerceAtMost);
                TextLayoutResult textLayoutResult3 = this.layoutResult;
                if (textLayoutResult3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult3 = null;
                }
                float lineTop = textLayoutResult3.getLineTop(lineForOffset) - roundToInt;
                if (lineTop > 0.0f) {
                    TextLayoutResult textLayoutResult4 = this.layoutResult;
                    if (textLayoutResult4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult4;
                    }
                    i2 = textLayoutResult.getLineForVerticalPosition(lineTop);
                } else {
                    i2 = 0;
                }
                if (coerceAtMost == getText().length() && i2 < lineForOffset) {
                    i2++;
                }
                return getRange(getLineEdgeIndex(i2, DirectionStart), coerceAtMost);
            } catch (IllegalStateException unused) {
                return null;
            }
        }
        return null;
    }

    private final int getLineEdgeIndex(int i, ResolvedTextDirection resolvedTextDirection) {
        TextLayoutResult textLayoutResult = this.layoutResult;
        TextLayoutResult textLayoutResult2 = null;
        if (textLayoutResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            textLayoutResult = null;
        }
        int lineStart = textLayoutResult.getLineStart(i);
        TextLayoutResult textLayoutResult3 = this.layoutResult;
        if (textLayoutResult3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            textLayoutResult3 = null;
        }
        if (resolvedTextDirection != textLayoutResult3.getParagraphDirection(lineStart)) {
            TextLayoutResult textLayoutResult4 = this.layoutResult;
            if (textLayoutResult4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            } else {
                textLayoutResult2 = textLayoutResult4;
            }
            return textLayoutResult2.getLineStart(i);
        }
        TextLayoutResult textLayoutResult5 = this.layoutResult;
        if (textLayoutResult5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            textLayoutResult5 = null;
        }
        return TextLayoutResult.getLineEnd$default(textLayoutResult5, i, false, 2, null) - 1;
    }
}
