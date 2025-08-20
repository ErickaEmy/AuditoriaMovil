package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlin/jvm/internal/Lambda;", "R", "Lkotlin/jvm/internal/FunctionBase;", "Ljava/io/Serializable;", "arity", "", "(I)V", "getArity", "()I", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* renamed from: com.facebook.ads.redexgen.X.6o  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC04316o<R> implements GL<R>, Serializable {
    public static byte[] A01;
    public final int A00;

    static {
        A04();
    }

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 30);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A01 = new byte[]{-19, -32, -23, -33, -32, -19, -57, -36, -24, -35, -33, -36, -49, -22, -50, -17, -19, -28, -23, -30, -93, -87, -87, -87, -92};
    }

    public AbstractC04316o(int i) {
        this.A00 = i;
    }

    public final String toString() {
        String A012 = AbstractC1269bt.A01(this);
        C1270bu.A06(A012, A03(0, 25, 93));
        return A012;
    }
}
