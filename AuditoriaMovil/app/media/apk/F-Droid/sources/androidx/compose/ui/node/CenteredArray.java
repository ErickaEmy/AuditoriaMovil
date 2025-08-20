package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: MyersDiff.kt */
/* loaded from: classes.dex */
abstract class CenteredArray {
    /* renamed from: constructor-impl  reason: not valid java name */
    public static int[] m1291constructorimpl(int[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data;
    }

    /* renamed from: getMid-impl  reason: not valid java name */
    private static final int m1293getMidimpl(int[] iArr) {
        return iArr.length / 2;
    }

    /* renamed from: get-impl  reason: not valid java name */
    public static final int m1292getimpl(int[] iArr, int i) {
        return iArr[i + m1293getMidimpl(iArr)];
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final void m1294setimpl(int[] iArr, int i, int i2) {
        iArr[i + m1293getMidimpl(iArr)] = i2;
    }
}
