package okio.internal;

import kotlin.jvm.internal.Intrinsics;
import okio.C0043SegmentedByteString;
/* compiled from: SegmentedByteString.kt */
/* renamed from: okio.internal.-SegmentedByteString  reason: invalid class name */
/* loaded from: classes2.dex */
public abstract class SegmentedByteString {
    public static final int binarySearch(int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else if (i6 <= i) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final int segment(C0043SegmentedByteString c0043SegmentedByteString, int i) {
        Intrinsics.checkNotNullParameter(c0043SegmentedByteString, "<this>");
        int binarySearch = binarySearch(c0043SegmentedByteString.getDirectory$okio(), i + 1, 0, c0043SegmentedByteString.getSegments$okio().length);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }
}
