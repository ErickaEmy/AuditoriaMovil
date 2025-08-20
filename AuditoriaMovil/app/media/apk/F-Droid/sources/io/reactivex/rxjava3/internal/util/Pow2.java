package io.reactivex.rxjava3.internal.util;
/* loaded from: classes.dex */
public abstract class Pow2 {
    public static int roundToPowerOfTwo(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
