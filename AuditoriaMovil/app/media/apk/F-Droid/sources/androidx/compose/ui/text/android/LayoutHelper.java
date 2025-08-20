package androidx.compose.ui.text.android;

import android.text.Layout;
import ch.qos.logback.core.CoreConstants;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: LayoutHelper.kt */
/* loaded from: classes.dex */
public final class LayoutHelper {
    private final boolean[] bidiProcessedParagraphs;
    private final Layout layout;
    private final List paragraphBidi;
    private final int paragraphCount;
    private final List paragraphEnds;
    private char[] tmpBuffer;

    public final boolean isLineEndSpace(char c) {
        return c == ' ' || c == '\n' || c == 5760 || (8192 <= c && c < 8203 && c != 8199) || c == 8287 || c == 12288;
    }

    public LayoutHelper(Layout layout) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.layout = layout;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        do {
            CharSequence text = this.layout.getText();
            Intrinsics.checkNotNullExpressionValue(text, "layout.text");
            indexOf$default = StringsKt__StringsKt.indexOf$default(text, '\n', i, false, 4, (Object) null);
            i = indexOf$default < 0 ? this.layout.getText().length() : indexOf$default + 1;
            arrayList.add(Integer.valueOf(i));
        } while (i < this.layout.getText().length());
        this.paragraphEnds = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(null);
        }
        this.paragraphBidi = arrayList2;
        this.bidiProcessedParagraphs = new boolean[this.paragraphEnds.size()];
        this.paragraphCount = this.paragraphEnds.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
        if (r0.getRunCount() == 1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.text.Bidi analyzeBidi(int r12) {
        /*
            r11 = this;
            boolean[] r0 = r11.bidiProcessedParagraphs
            boolean r0 = r0[r12]
            if (r0 == 0) goto Lf
            java.util.List r0 = r11.paragraphBidi
            java.lang.Object r12 = r0.get(r12)
            java.text.Bidi r12 = (java.text.Bidi) r12
            return r12
        Lf:
            r0 = 0
            if (r12 != 0) goto L14
            r1 = r0
            goto L22
        L14:
            java.util.List r1 = r11.paragraphEnds
            int r2 = r12 + (-1)
            java.lang.Object r1 = r1.get(r2)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
        L22:
            java.util.List r2 = r11.paragraphEnds
            java.lang.Object r2 = r2.get(r12)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            int r8 = r2 - r1
            char[] r3 = r11.tmpBuffer
            if (r3 == 0) goto L3a
            int r4 = r3.length
            if (r4 >= r8) goto L38
            goto L3a
        L38:
            r10 = r3
            goto L3d
        L3a:
            char[] r3 = new char[r8]
            goto L38
        L3d:
            android.text.Layout r3 = r11.layout
            java.lang.CharSequence r3 = r3.getText()
            android.text.TextUtils.getChars(r3, r1, r2, r10, r0)
            boolean r0 = java.text.Bidi.requiresBidi(r10, r0, r8)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L62
            boolean r9 = r11.isRtlParagraph(r12)
            java.text.Bidi r0 = new java.text.Bidi
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r0
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8, r9)
            int r3 = r0.getRunCount()
            if (r3 != r2) goto L63
        L62:
            r0 = r1
        L63:
            java.util.List r3 = r11.paragraphBidi
            r3.set(r12, r0)
            boolean[] r3 = r11.bidiProcessedParagraphs
            r3[r12] = r2
            if (r0 == 0) goto L75
            char[] r12 = r11.tmpBuffer
            if (r10 != r12) goto L74
            r10 = r1
            goto L75
        L74:
            r10 = r12
        L75:
            r11.tmpBuffer = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.LayoutHelper.analyzeBidi(int):java.text.Bidi");
    }

    public final int getParagraphForOffset(int i, boolean z) {
        int binarySearch$default;
        binarySearch$default = CollectionsKt__CollectionsKt.binarySearch$default(this.paragraphEnds, Integer.valueOf(i), 0, 0, 6, null);
        int i2 = binarySearch$default < 0 ? -(binarySearch$default + 1) : binarySearch$default + 1;
        if (z && i2 > 0) {
            int i3 = i2 - 1;
            if (i == ((Number) this.paragraphEnds.get(i3)).intValue()) {
                return i3;
            }
        }
        return i2;
    }

    public final int getParagraphStart(int i) {
        if (i == 0) {
            return 0;
        }
        return ((Number) this.paragraphEnds.get(i - 1)).intValue();
    }

    public final boolean isRtlParagraph(int i) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(getParagraphStart(i))) == -1;
    }

    public final float getHorizontalPosition(int i, boolean z, boolean z2) {
        int lastIndex;
        int lastIndex2;
        int i2 = i;
        if (!z2) {
            return getDownstreamHorizontal(i, z);
        }
        int lineForOffset = LayoutCompatKt.getLineForOffset(this.layout, i2, z2);
        int lineStart = this.layout.getLineStart(lineForOffset);
        int lineEnd = this.layout.getLineEnd(lineForOffset);
        if (i2 != lineStart && i2 != lineEnd) {
            return getDownstreamHorizontal(i, z);
        }
        if (i2 == 0 || i2 == this.layout.getText().length()) {
            return getDownstreamHorizontal(i, z);
        }
        int paragraphForOffset = getParagraphForOffset(i2, z2);
        boolean isRtlParagraph = isRtlParagraph(paragraphForOffset);
        int lineEndToVisibleEnd = lineEndToVisibleEnd(lineEnd);
        int paragraphStart = getParagraphStart(paragraphForOffset);
        int i3 = lineStart - paragraphStart;
        int i4 = lineEndToVisibleEnd - paragraphStart;
        Bidi analyzeBidi = analyzeBidi(paragraphForOffset);
        Bidi createLineBidi = analyzeBidi != null ? analyzeBidi.createLineBidi(i3, i4) : null;
        if (createLineBidi == null || createLineBidi.getRunCount() == 1) {
            boolean isRtlCharAt = this.layout.isRtlCharAt(lineStart);
            if (z || isRtlParagraph == isRtlCharAt) {
                isRtlParagraph = !isRtlParagraph;
            }
            return (i2 != lineStart ? isRtlParagraph : !isRtlParagraph) ? this.layout.getLineRight(lineForOffset) : this.layout.getLineLeft(lineForOffset);
        }
        int runCount = createLineBidi.getRunCount();
        BidiRun[] bidiRunArr = new BidiRun[runCount];
        for (int i5 = 0; i5 < runCount; i5++) {
            bidiRunArr[i5] = new BidiRun(createLineBidi.getRunStart(i5) + lineStart, createLineBidi.getRunLimit(i5) + lineStart, createLineBidi.getRunLevel(i5) % 2 == 1);
        }
        int runCount2 = createLineBidi.getRunCount();
        byte[] bArr = new byte[runCount2];
        for (int i6 = 0; i6 < runCount2; i6++) {
            bArr[i6] = (byte) createLineBidi.getRunLevel(i6);
        }
        Bidi.reorderVisually(bArr, 0, bidiRunArr, 0, runCount);
        int i7 = -1;
        if (i2 == lineStart) {
            int i8 = 0;
            while (true) {
                if (i8 >= runCount) {
                    break;
                } else if (bidiRunArr[i8].getStart() == i2) {
                    i7 = i8;
                    break;
                } else {
                    i8++;
                }
            }
            BidiRun bidiRun = bidiRunArr[i7];
            if (z || isRtlParagraph == bidiRun.isRtl()) {
                isRtlParagraph = !isRtlParagraph;
            }
            if (i7 == 0 && isRtlParagraph) {
                return this.layout.getLineLeft(lineForOffset);
            }
            lastIndex2 = ArraysKt___ArraysKt.getLastIndex(bidiRunArr);
            if (i7 != lastIndex2 || isRtlParagraph) {
                if (isRtlParagraph) {
                    return this.layout.getPrimaryHorizontal(bidiRunArr[i7 - 1].getStart());
                }
                return this.layout.getPrimaryHorizontal(bidiRunArr[i7 + 1].getStart());
            }
            return this.layout.getLineRight(lineForOffset);
        }
        if (i2 > lineEndToVisibleEnd) {
            i2 = lineEndToVisibleEnd(i);
        }
        int i9 = 0;
        while (true) {
            if (i9 >= runCount) {
                break;
            } else if (bidiRunArr[i9].getEnd() == i2) {
                i7 = i9;
                break;
            } else {
                i9++;
            }
        }
        BidiRun bidiRun2 = bidiRunArr[i7];
        if (!z && isRtlParagraph != bidiRun2.isRtl()) {
            isRtlParagraph = !isRtlParagraph;
        }
        if (i7 == 0 && isRtlParagraph) {
            return this.layout.getLineLeft(lineForOffset);
        }
        lastIndex = ArraysKt___ArraysKt.getLastIndex(bidiRunArr);
        if (i7 != lastIndex || isRtlParagraph) {
            if (isRtlParagraph) {
                return this.layout.getPrimaryHorizontal(bidiRunArr[i7 - 1].getEnd());
            }
            return this.layout.getPrimaryHorizontal(bidiRunArr[i7 + 1].getEnd());
        }
        return this.layout.getLineRight(lineForOffset);
    }

    private final float getDownstreamHorizontal(int i, boolean z) {
        if (z) {
            return this.layout.getPrimaryHorizontal(i);
        }
        return this.layout.getSecondaryHorizontal(i);
    }

    /* compiled from: LayoutHelper.kt */
    /* loaded from: classes.dex */
    private static final class BidiRun {
        private final int end;
        private final boolean isRtl;
        private final int start;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BidiRun) {
                BidiRun bidiRun = (BidiRun) obj;
                return this.start == bidiRun.start && this.end == bidiRun.end && this.isRtl == bidiRun.isRtl;
            }
            return false;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i = ((this.start * 31) + this.end) * 31;
            boolean z = this.isRtl;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return i + i2;
        }

        public final boolean isRtl() {
            return this.isRtl;
        }

        public String toString() {
            return "BidiRun(start=" + this.start + ", end=" + this.end + ", isRtl=" + this.isRtl + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public BidiRun(int i, int i2, boolean z) {
            this.start = i;
            this.end = i2;
            this.isRtl = z;
        }
    }

    private final int lineEndToVisibleEnd(int i) {
        while (i > 0 && isLineEndSpace(this.layout.getText().charAt(i - 1))) {
            i--;
        }
        return i;
    }
}
