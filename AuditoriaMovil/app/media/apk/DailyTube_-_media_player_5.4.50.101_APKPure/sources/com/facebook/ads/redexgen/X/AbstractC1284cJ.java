package com.facebook.ads.redexgen.X;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.cJ  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1284cJ {
    public static String[] A00 = {"TtNs1UbtruECXot", "tpaue", "s90Sw2xfipZOkULUf4YVkqTv1ri2JEFZ", "UW9U9pyLqubavRm8Co8t1ARkgbl4JN3Q", "Ubll", "jCd34Nuc8OSCD22", "PumDfveAcRoz4mAMU1oiRh2I021HXL7u", "7XnL499JY0auPeNFsvc8kwtFVWOKtFwM"};
    public static final Point A01 = new Point();

    public static boolean A00(View view, Rect rect, Rect rect2, Rect rect3) {
        if (!view.isShown()) {
            rect.setEmpty();
            rect2.setEmpty();
            return false;
        }
        Point point = A01;
        if (!view.getGlobalVisibleRect(rect, point)) {
            rect2.setEmpty();
            rect.setEmpty();
            return false;
        } else if (!rect.intersect(rect3)) {
            rect2.setEmpty();
            rect.setEmpty();
            if (A00[6].charAt(7) != 'A') {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[2] = "uPGJEhgdW6Zw1Sj0lSecSmwhOYLW8VRR";
            strArr[7] = "8DkF2pCK7gEKj1aPHzeGQpXB8g2QomLh";
            return false;
        } else {
            rect2.set(point.x, point.y, point.x + view.getWidth(), point.y + view.getHeight());
            return true;
        }
    }
}
