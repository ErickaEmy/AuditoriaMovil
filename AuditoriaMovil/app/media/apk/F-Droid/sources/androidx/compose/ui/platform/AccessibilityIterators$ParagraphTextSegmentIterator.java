package androidx.compose.ui.platform;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AccessibilityIterators.android.kt */
/* loaded from: classes.dex */
public final class AccessibilityIterators$ParagraphTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {
    public static final Companion Companion = new Companion(null);
    private static AccessibilityIterators$ParagraphTextSegmentIterator instance;

    public /* synthetic */ AccessibilityIterators$ParagraphTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AccessibilityIterators$ParagraphTextSegmentIterator() {
    }

    /* compiled from: AccessibilityIterators.android.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccessibilityIterators$ParagraphTextSegmentIterator getInstance() {
            if (AccessibilityIterators$ParagraphTextSegmentIterator.instance == null) {
                AccessibilityIterators$ParagraphTextSegmentIterator.instance = new AccessibilityIterators$ParagraphTextSegmentIterator(null);
            }
            AccessibilityIterators$ParagraphTextSegmentIterator accessibilityIterators$ParagraphTextSegmentIterator = AccessibilityIterators$ParagraphTextSegmentIterator.instance;
            Intrinsics.checkNotNull(accessibilityIterators$ParagraphTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator");
            return accessibilityIterators$ParagraphTextSegmentIterator;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
        return null;
     */
    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int[] following(int r5) {
        /*
            r4 = this;
            java.lang.String r0 = r4.getText()
            int r0 = r0.length()
            r1 = 0
            if (r0 > 0) goto Lc
            return r1
        Lc:
            if (r5 < r0) goto Lf
            return r1
        Lf:
            if (r5 >= 0) goto L12
            r5 = 0
        L12:
            if (r5 >= r0) goto L29
            java.lang.String r2 = r4.getText()
            char r2 = r2.charAt(r5)
            r3 = 10
            if (r2 != r3) goto L29
            boolean r2 = r4.isStartBoundary(r5)
            if (r2 != 0) goto L29
            int r5 = r5 + 1
            goto L12
        L29:
            if (r5 < r0) goto L2c
            return r1
        L2c:
            int r1 = r5 + 1
        L2e:
            if (r1 >= r0) goto L39
            boolean r2 = r4.isEndBoundary(r1)
            if (r2 != 0) goto L39
            int r1 = r1 + 1
            goto L2e
        L39:
            int[] r5 = r4.getRange(r5, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AccessibilityIterators$ParagraphTextSegmentIterator.following(int):int[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        return null;
     */
    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int[] preceding(int r4) {
        /*
            r3 = this;
            java.lang.String r0 = r3.getText()
            int r0 = r0.length()
            r1 = 0
            if (r0 > 0) goto Lc
            return r1
        Lc:
            if (r4 > 0) goto Lf
            return r1
        Lf:
            if (r4 <= r0) goto L12
            r4 = r0
        L12:
            if (r4 <= 0) goto L2b
            java.lang.String r0 = r3.getText()
            int r2 = r4 + (-1)
            char r0 = r0.charAt(r2)
            r2 = 10
            if (r0 != r2) goto L2b
            boolean r0 = r3.isEndBoundary(r4)
            if (r0 != 0) goto L2b
            int r4 = r4 + (-1)
            goto L12
        L2b:
            if (r4 > 0) goto L2e
            return r1
        L2e:
            int r0 = r4 + (-1)
        L30:
            if (r0 <= 0) goto L3b
            boolean r1 = r3.isStartBoundary(r0)
            if (r1 != 0) goto L3b
            int r0 = r0 + (-1)
            goto L30
        L3b:
            int[] r4 = r3.getRange(r0, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AccessibilityIterators$ParagraphTextSegmentIterator.preceding(int):int[]");
    }

    private final boolean isStartBoundary(int i) {
        return getText().charAt(i) != '\n' && (i == 0 || getText().charAt(i - 1) == '\n');
    }

    private final boolean isEndBoundary(int i) {
        return i > 0 && getText().charAt(i + (-1)) != '\n' && (i == getText().length() || getText().charAt(i) == '\n');
    }
}
