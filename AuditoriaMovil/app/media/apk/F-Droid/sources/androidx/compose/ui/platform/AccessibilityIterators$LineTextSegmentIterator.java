package androidx.compose.ui.platform;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AccessibilityIterators.android.kt */
/* loaded from: classes.dex */
public final class AccessibilityIterators$LineTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {
    private static AccessibilityIterators$LineTextSegmentIterator lineInstance;
    private TextLayoutResult layoutResult;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;
    private static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;

    public /* synthetic */ AccessibilityIterators$LineTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AccessibilityIterators$LineTextSegmentIterator() {
    }

    /* compiled from: AccessibilityIterators.android.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccessibilityIterators$LineTextSegmentIterator getInstance() {
            if (AccessibilityIterators$LineTextSegmentIterator.lineInstance == null) {
                AccessibilityIterators$LineTextSegmentIterator.lineInstance = new AccessibilityIterators$LineTextSegmentIterator(null);
            }
            AccessibilityIterators$LineTextSegmentIterator accessibilityIterators$LineTextSegmentIterator = AccessibilityIterators$LineTextSegmentIterator.lineInstance;
            Intrinsics.checkNotNull(accessibilityIterators$LineTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator");
            return accessibilityIterators$LineTextSegmentIterator;
        }
    }

    public final void initialize(String text, TextLayoutResult layoutResult) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(layoutResult, "layoutResult");
        setText(text);
        this.layoutResult = layoutResult;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public int[] following(int i) {
        int i2;
        if (getText().length() > 0 && i < getText().length()) {
            if (i < 0) {
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult = null;
                }
                i2 = textLayoutResult.getLineForOffset(0);
            } else {
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(i);
                i2 = getLineEdgeIndex(lineForOffset, DirectionStart) == i ? lineForOffset : lineForOffset + 1;
            }
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            if (i2 >= textLayoutResult3.getLineCount()) {
                return null;
            }
            return getRange(getLineEdgeIndex(i2, DirectionStart), getLineEdgeIndex(i2, DirectionEnd) + 1);
        }
        return null;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public int[] preceding(int i) {
        int i2;
        if (getText().length() > 0 && i > 0) {
            if (i > getText().length()) {
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult = null;
                }
                i2 = textLayoutResult.getLineForOffset(getText().length());
            } else {
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(i);
                i2 = getLineEdgeIndex(lineForOffset, DirectionEnd) + 1 == i ? lineForOffset : lineForOffset - 1;
            }
            if (i2 < 0) {
                return null;
            }
            return getRange(getLineEdgeIndex(i2, DirectionStart), getLineEdgeIndex(i2, DirectionEnd) + 1);
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
