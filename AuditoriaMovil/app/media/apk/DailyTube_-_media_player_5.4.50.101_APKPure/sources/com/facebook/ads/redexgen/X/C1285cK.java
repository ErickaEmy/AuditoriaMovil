package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.Arrays;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/instagram/common/viewpoint/core/ViewpointViewNode$Companion;", "", "()V", "viewToNodeMap", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Lcom/instagram/common/viewpoint/core/ViewpointViewNode;", "forView", "view", "fbandroid.java.com.instagram.common.viewpoint.core.core_an"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* renamed from: com.facebook.ads.redexgen.X.cK  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1285cK {
    public static byte[] A00;
    public static String[] A01 = {"tM", "OPSTz", "nSVgoUnJhqchgKDvzZkuQEe6gXNDXiJa", "w6a8CUhjr9W4mo91m011A7MFgCBLOqFf", "py3rfD", "ih7XR3ofyKGNBaShrQXGXw0JFIFEgb8N", "DEOWgwil5msK", "goT19SPCP2Wcb2IATE"};

    public /* synthetic */ C1285cK(AbstractC1271bv abstractC1271bv) {
        this();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[1].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "kKLBr";
            strArr2[7] = "W5yuMnVpFJPnLtYkAS";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 31);
            i8++;
        }
    }

    public static void A01() {
        byte[] bArr = {126, 97, 109, Byte.MAX_VALUE};
        if (A01[5].charAt(10) != 'G') {
            throw new RuntimeException();
        }
        A01[5] = "dvHL5pgrLAG1IBapnMOcCgSK2VIAPJci";
        A00 = bArr;
    }

    static {
        A01();
    }

    public C1285cK() {
    }

    @JvmStatic
    public final H3 A02(View view) {
        C1270bu.A07(view, A00(0, 4, 23));
        WeakHashMap A02 = H3.A02();
        Object answer$iv = A02.get(view);
        if (answer$iv == null) {
            answer$iv = new H3(view, null);
            A02.put(view, answer$iv);
        }
        H3 h32 = (H3) answer$iv;
        String[] strArr = A01;
        if (strArr[3].charAt(5) != strArr[2].charAt(5)) {
            throw new RuntimeException();
        }
        A01[5] = "mMgRmd5SAQGSrLsKZhD49KGbIqxV0XUN";
        return h32;
    }
}
