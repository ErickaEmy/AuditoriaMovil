package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: SelectionAdjustment.kt */
/* loaded from: classes.dex */
public interface SelectionAdjustment {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: adjust-ZXO7KMw  reason: not valid java name */
    long mo394adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange);

    /* compiled from: SelectionAdjustment.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final SelectionAdjustment None = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$None$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo394adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                return j;
            }
        };
        private static final SelectionAdjustment Character = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Character$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo394adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                int lastIndex;
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                if (TextRange.m1579getCollapsedimpl(j)) {
                    boolean m1584getReversedimpl = textRange != null ? TextRange.m1584getReversedimpl(textRange.m1589unboximpl()) : false;
                    String text = textLayoutResult.getLayoutInput().getText().getText();
                    int m1585getStartimpl = TextRange.m1585getStartimpl(j);
                    lastIndex = StringsKt__StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText());
                    return SelectionAdjustmentKt.ensureAtLeastOneChar(text, m1585getStartimpl, lastIndex, z, m1584getReversedimpl);
                }
                return j;
            }
        };
        private static final SelectionAdjustment Word = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Word$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo394adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                long m396adjustByBoundaryDvylE;
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                m396adjustByBoundaryDvylE = SelectionAdjustment.Companion.$$INSTANCE.m396adjustByBoundaryDvylE(textLayoutResult, j, new SelectionAdjustment$Companion$Word$1$adjust$1(textLayoutResult));
                return m396adjustByBoundaryDvylE;
            }
        };
        private static final SelectionAdjustment Paragraph = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Paragraph$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo394adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                long m396adjustByBoundaryDvylE;
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                m396adjustByBoundaryDvylE = SelectionAdjustment.Companion.$$INSTANCE.m396adjustByBoundaryDvylE(textLayoutResult, j, new SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1(textLayoutResult.getLayoutInput().getText()));
                return m396adjustByBoundaryDvylE;
            }
        };
        private static final SelectionAdjustment CharacterWithWordAccelerate = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$CharacterWithWordAccelerate$1
            private final boolean isExpanding(int i, int i2, boolean z, boolean z2) {
                if (i2 == -1) {
                    return true;
                }
                if (i == i2) {
                    return false;
                }
                if (z ^ z2) {
                    if (i < i2) {
                        return true;
                    }
                } else if (i > i2) {
                    return true;
                }
                return false;
            }

            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo394adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                int updateSelectionBoundary;
                int i2;
                int lastIndex;
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                if (textRange == null) {
                    return SelectionAdjustment.Companion.$$INSTANCE.getWord().mo394adjustZXO7KMw(textLayoutResult, j, i, z, textRange);
                }
                if (TextRange.m1579getCollapsedimpl(j)) {
                    String text = textLayoutResult.getLayoutInput().getText().getText();
                    int m1585getStartimpl = TextRange.m1585getStartimpl(j);
                    lastIndex = StringsKt__StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText());
                    return SelectionAdjustmentKt.ensureAtLeastOneChar(text, m1585getStartimpl, lastIndex, z, TextRange.m1584getReversedimpl(textRange.m1589unboximpl()));
                }
                if (z) {
                    i2 = updateSelectionBoundary(textLayoutResult, TextRange.m1585getStartimpl(j), i, TextRange.m1585getStartimpl(textRange.m1589unboximpl()), TextRange.m1580getEndimpl(j), true, TextRange.m1584getReversedimpl(j));
                    updateSelectionBoundary = TextRange.m1580getEndimpl(j);
                } else {
                    int m1585getStartimpl2 = TextRange.m1585getStartimpl(j);
                    updateSelectionBoundary = updateSelectionBoundary(textLayoutResult, TextRange.m1580getEndimpl(j), i, TextRange.m1580getEndimpl(textRange.m1589unboximpl()), TextRange.m1585getStartimpl(j), false, TextRange.m1584getReversedimpl(j));
                    i2 = m1585getStartimpl2;
                }
                return TextRangeKt.TextRange(i2, updateSelectionBoundary);
            }

            private final int updateSelectionBoundary(TextLayoutResult textLayoutResult, int i, int i2, int i3, int i4, boolean z, boolean z2) {
                if (i == i2) {
                    return i3;
                }
                int lineForOffset = textLayoutResult.getLineForOffset(i);
                if (lineForOffset != textLayoutResult.getLineForOffset(i3)) {
                    return snapToWordBoundary(textLayoutResult, i, lineForOffset, i4, z, z2);
                }
                return (isExpanding(i, i2, z, z2) && isAtWordBoundary(textLayoutResult, i3)) ? snapToWordBoundary(textLayoutResult, i, lineForOffset, i4, z, z2) : i;
            }

            private final int snapToWordBoundary(TextLayoutResult textLayoutResult, int i, int i2, int i3, boolean z, boolean z2) {
                int lineStart;
                int lineEnd$default;
                long m1572getWordBoundaryjx7JFs = textLayoutResult.m1572getWordBoundaryjx7JFs(i);
                if (textLayoutResult.getLineForOffset(TextRange.m1585getStartimpl(m1572getWordBoundaryjx7JFs)) == i2) {
                    lineStart = TextRange.m1585getStartimpl(m1572getWordBoundaryjx7JFs);
                } else {
                    lineStart = textLayoutResult.getLineStart(i2);
                }
                if (textLayoutResult.getLineForOffset(TextRange.m1580getEndimpl(m1572getWordBoundaryjx7JFs)) == i2) {
                    lineEnd$default = TextRange.m1580getEndimpl(m1572getWordBoundaryjx7JFs);
                } else {
                    lineEnd$default = TextLayoutResult.getLineEnd$default(textLayoutResult, i2, false, 2, null);
                }
                if (lineStart == i3) {
                    return lineEnd$default;
                }
                if (lineEnd$default == i3) {
                    return lineStart;
                }
                int i4 = (lineStart + lineEnd$default) / 2;
                if (z ^ z2) {
                    if (i <= i4) {
                        return lineStart;
                    }
                } else if (i < i4) {
                    return lineStart;
                }
                return lineEnd$default;
            }

            private final boolean isAtWordBoundary(TextLayoutResult textLayoutResult, int i) {
                long m1572getWordBoundaryjx7JFs = textLayoutResult.m1572getWordBoundaryjx7JFs(i);
                return i == TextRange.m1585getStartimpl(m1572getWordBoundaryjx7JFs) || i == TextRange.m1580getEndimpl(m1572getWordBoundaryjx7JFs);
            }
        };

        private Companion() {
        }

        public final SelectionAdjustment getCharacter() {
            return Character;
        }

        public final SelectionAdjustment getNone() {
            return None;
        }

        public final SelectionAdjustment getParagraph() {
            return Paragraph;
        }

        public final SelectionAdjustment getWord() {
            return Word;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: adjustByBoundary--Dv-ylE  reason: not valid java name */
        public final long m396adjustByBoundaryDvylE(TextLayoutResult textLayoutResult, long j, Function1 function1) {
            int lastIndex;
            int coerceIn;
            int coerceIn2;
            if (textLayoutResult.getLayoutInput().getText().length() == 0) {
                return TextRange.Companion.m1590getZerod9O1mEE();
            }
            lastIndex = StringsKt__StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText());
            coerceIn = RangesKt___RangesKt.coerceIn(TextRange.m1585getStartimpl(j), 0, lastIndex);
            long m1589unboximpl = ((TextRange) function1.invoke(Integer.valueOf(coerceIn))).m1589unboximpl();
            coerceIn2 = RangesKt___RangesKt.coerceIn(TextRange.m1580getEndimpl(j), 0, lastIndex);
            long m1589unboximpl2 = ((TextRange) function1.invoke(Integer.valueOf(coerceIn2))).m1589unboximpl();
            return TextRangeKt.TextRange(TextRange.m1584getReversedimpl(j) ? TextRange.m1580getEndimpl(m1589unboximpl) : TextRange.m1585getStartimpl(m1589unboximpl), TextRange.m1584getReversedimpl(j) ? TextRange.m1585getStartimpl(m1589unboximpl2) : TextRange.m1580getEndimpl(m1589unboximpl2));
        }
    }
}
