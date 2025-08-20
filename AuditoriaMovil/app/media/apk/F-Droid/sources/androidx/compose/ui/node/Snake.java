package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyersDiff.kt */
/* loaded from: classes.dex */
public abstract class Snake {
    /* renamed from: constructor-impl  reason: not valid java name */
    public static int[] m1397constructorimpl(int[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data;
    }

    /* renamed from: getStartX-impl  reason: not valid java name */
    public static final int m1403getStartXimpl(int[] iArr) {
        return iArr[0];
    }

    /* renamed from: getStartY-impl  reason: not valid java name */
    public static final int m1404getStartYimpl(int[] iArr) {
        return iArr[1];
    }

    /* renamed from: getEndX-impl  reason: not valid java name */
    public static final int m1399getEndXimpl(int[] iArr) {
        return iArr[2];
    }

    /* renamed from: getEndY-impl  reason: not valid java name */
    public static final int m1400getEndYimpl(int[] iArr) {
        return iArr[3];
    }

    /* renamed from: getReverse-impl  reason: not valid java name */
    public static final boolean m1402getReverseimpl(int[] iArr) {
        return iArr[4] != 0;
    }

    /* renamed from: getDiagonalSize-impl  reason: not valid java name */
    public static final int m1398getDiagonalSizeimpl(int[] iArr) {
        return Math.min(m1399getEndXimpl(iArr) - m1403getStartXimpl(iArr), m1400getEndYimpl(iArr) - m1404getStartYimpl(iArr));
    }

    /* renamed from: getHasAdditionOrRemoval-impl  reason: not valid java name */
    private static final boolean m1401getHasAdditionOrRemovalimpl(int[] iArr) {
        return m1400getEndYimpl(iArr) - m1404getStartYimpl(iArr) != m1399getEndXimpl(iArr) - m1403getStartXimpl(iArr);
    }

    /* renamed from: isAddition-impl  reason: not valid java name */
    private static final boolean m1405isAdditionimpl(int[] iArr) {
        return m1400getEndYimpl(iArr) - m1404getStartYimpl(iArr) > m1399getEndXimpl(iArr) - m1403getStartXimpl(iArr);
    }

    /* renamed from: addDiagonalToStack-impl  reason: not valid java name */
    public static final void m1396addDiagonalToStackimpl(int[] iArr, IntStack diagonals) {
        Intrinsics.checkNotNullParameter(diagonals, "diagonals");
        if (m1401getHasAdditionOrRemovalimpl(iArr)) {
            if (m1402getReverseimpl(iArr)) {
                diagonals.pushDiagonal(m1403getStartXimpl(iArr), m1404getStartYimpl(iArr), m1398getDiagonalSizeimpl(iArr));
                return;
            } else if (m1405isAdditionimpl(iArr)) {
                diagonals.pushDiagonal(m1403getStartXimpl(iArr), m1404getStartYimpl(iArr) + 1, m1398getDiagonalSizeimpl(iArr));
                return;
            } else {
                diagonals.pushDiagonal(m1403getStartXimpl(iArr) + 1, m1404getStartYimpl(iArr), m1398getDiagonalSizeimpl(iArr));
                return;
            }
        }
        diagonals.pushDiagonal(m1403getStartXimpl(iArr), m1404getStartYimpl(iArr), m1399getEndXimpl(iArr) - m1403getStartXimpl(iArr));
    }
}
