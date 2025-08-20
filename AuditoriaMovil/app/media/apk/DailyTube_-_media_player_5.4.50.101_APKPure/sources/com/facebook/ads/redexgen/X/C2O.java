package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.ads.AdSDKNotificationListener;
import com.facebook.ads.AdSDKNotificationManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/* renamed from: com.facebook.ads.redexgen.X.2O  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C2O {
    public static void A00(final String str) {
        final ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (AdSDKNotificationManager.getNotificationListeners()) {
            arrayList = new ArrayList(AdSDKNotificationManager.getNotificationListeners());
        }
        ExecutorC0777Li.A00(new Runnable() { // from class: com.facebook.ads.redexgen.X.2N
            public static byte[] A02;
            public static String[] A03 = {"", "R2h4cPa", "8K6r33o48istIkLwCuAfGDqRYcEBFJta", "JrgImPTdAC8EkycOMZgSjkdVNJJcyT0z", "UmabyHZVDvNoGZWIzd7OnW5h8PImv1dX", "9OHeUl2dxQ9y3g7sK1669", "ejdw", "orFgTMj4gc7nxjDrulE2T1NaHiTuAbhe"};

            public static String A00(int i, int i5, int i6) {
                byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
                for (int i8 = 0; i8 < copyOfRange.length; i8++) {
                    byte b2 = (byte) ((copyOfRange[i8] - i6) - 19);
                    String[] strArr = A03;
                    if (strArr[1].length() == strArr[0].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A03;
                    strArr2[2] = "PBcjmF449O2ALurV1e1gxRld5UP64De9";
                    strArr2[7] = "bFbD54V4FV2Kx5Uvd678uCerr9Gu9fe1";
                    copyOfRange[i8] = b2;
                }
                return new String(copyOfRange);
            }

            public static void A01() {
                A02 = new byte[]{Byte.MIN_VALUE, -119, 126, -115, -108, -117, -113, Byte.MIN_VALUE, Byte.MAX_VALUE, 122, 126, -117, -120, -113, -109, -106, -104, -117, -103, -103, -113, -107, -108};
            }

            static {
                A01();
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (KL.A02(this)) {
                    return;
                }
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Bundle data = new Bundle();
                        data.putString(A00(0, 13, 8), str);
                        ((AdSDKNotificationListener) it.next()).onAdEvent(A00(13, 10, 19), data);
                    }
                } catch (Throwable th) {
                    KL.A00(th, this);
                }
            }
        });
    }
}
