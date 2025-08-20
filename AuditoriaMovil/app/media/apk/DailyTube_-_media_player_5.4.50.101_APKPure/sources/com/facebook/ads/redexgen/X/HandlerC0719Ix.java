package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.facebook.ads.RewardData;
import java.util.Arrays;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Ix  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class HandlerC0719Ix extends Handler {
    public static byte[] A02;
    public static final String A03;
    public final Context A00;
    public final VW A01;

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 41);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A02 = new byte[]{101, 93, 96, 102, 93, 95, -105, -92, -92, -95, -76, -98, -88, -76, -101, -86, -93, -93, -102, -95, -76, -95, -92, -100, -100, -102, -103, -11, -10, -12, 1, -29, -26, 1, -21, -26, 1, -19, -25, -5, -118, -117, -119, -106, -118, 124, -119, -115, Byte.MIN_VALUE, 122, 124, -106, 124, -113, -117, -119, 120, -118, -59, -58, -60, -47, -59, -73, -60, -56, -69, -75, -73, -47, -59, -74, -67, -47, -56, -73, -60, -59, -69, -63, -64};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        PackageManager packageManager;
        if (KL.A02(this)) {
            return;
        }
        try {
            Messenger messenger = message.replyTo;
            if (message.what == 1) {
                if (messenger != null) {
                    VW.A00().A07(2, null, A00(), messenger);
                    return;
                }
                return;
            }
            String string = message.getData().getString(A03(27, 13, 121));
            if (string == null) {
                return;
            }
            C1116Yn A05 = C03955c.A05(this.A00, string);
            A05.A0E().AG1(message.getData().getBoolean(A03(6, 21, 44), false));
            String str = null;
            if (Build.VERSION.SDK_INT >= 21 && (packageManager = this.A00.getPackageManager()) != null) {
                str = packageManager.getNameForUid(message.sendingUid);
            }
            if (str == null) {
                if (messenger != null) {
                    VW.A00().A07(20, string, null, messenger);
                }
                A05.A0E().AEk();
                return;
            }
            switch (message.what) {
                case 1010:
                    if (messenger == null) {
                        return;
                    }
                    C0716Iu A04 = VW.A00().A04(string);
                    if (A04 == null) {
                        A04 = VW.A00().A05(string, messenger, str);
                    }
                    AnonymousClass26 A042 = C2L.A04(A05, message.getData(), str);
                    if (A04.A00 == null) {
                        A04.A00 = A01(A042, string);
                    } else if (A04.A00 instanceof C1181aT) {
                        ((C1181aT) A04.A00).A0G(A042.A0B(), A042.A07());
                    }
                    VW.A00().A07(1011, string, A00(), messenger);
                    return;
                case 1012:
                case 2002:
                    VW.A00().A08(string);
                    return;
                case 2000:
                    if (messenger == null) {
                        return;
                    }
                    C0716Iu A043 = VW.A00().A04(string);
                    if (A043 == null) {
                        A043 = VW.A00().A05(string, messenger, str);
                    }
                    C2F A052 = C2L.A05(A05, message.getData(), str);
                    if (A043.A00 == null) {
                        A043.A00 = A02(A052, string);
                    } else if (A043.A00 instanceof C1178aQ) {
                        ((C1178aQ) A043.A00).A0J(A052.A05, A052.A02, A052.A08);
                    }
                    VW.A00().A07(2001, string, A00(), messenger);
                    return;
                case 2003:
                    AnonymousClass23 A032 = VW.A00().A03(string);
                    if (A032 instanceof C1178aQ) {
                        RewardData A01 = C2M.A01(message.getData());
                        C1178aQ c1178aQ = (C1178aQ) A032;
                        if (A01 != null) {
                            c1178aQ.A0I(A01);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    static {
        A04();
        A03 = HandlerC0719Ix.class.getSimpleName();
    }

    public HandlerC0719Ix(Context context) {
        super(Looper.getMainLooper());
        this.A00 = context;
        this.A01 = VW.A00();
    }

    public static Bundle A00() {
        Bundle bundle = new Bundle();
        bundle.putString(A03(58, 23, 73), A03(0, 6, 6));
        bundle.putString(A03(40, 18, 14), new JSONObject().toString());
        return bundle;
    }

    private C1181aT A01(AnonymousClass26 anonymousClass26, String str) {
        C1181aT c1181aT = new C1181aT(anonymousClass26, this.A01, str);
        c1181aT.A0G(anonymousClass26.A0B(), anonymousClass26.A07());
        return c1181aT;
    }

    private C1178aQ A02(C2F c2f, String str) {
        C1178aQ c1178aQ = new C1178aQ(c2f, this.A01, str);
        c1178aQ.A0J(c2f.A05, c2f.A02, c2f.A08);
        return c1178aQ;
    }
}
