package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class VW implements C2K {
    public static VW A01;
    public static byte[] A02;
    public static String[] A03 = {"F9VPCRzHFTAYh6WHGcx0Jd90Enb3hSh2", "fH8nu2kqsRdgHbOq", "0ARAQCTuMPQjF7tJb0MjvB18yGPry4Qu", "N48QVONPfFEZdhqNPTKHT8FFB7x206Ht", "sPSH6DBrw2hyfCGwQm6LEVZ2ITL2jpSj", "gRA8laRbRDS4iSEHtkOaasMfi52gbS0", "x", "ATQcDE"};
    public static final String A04;
    public final LinkedHashMap<String, C0716Iu> A00 = new LinkedHashMap<>();

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 1);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{19, 4, 31, 21, 29, 20, 14, 20, 9, 5, 3, 16, 2, 14, 26, 20, 8, 66, 99, 117, 114, 116, 105, Byte.MAX_VALUE, 99, 98, 38, 71, 98, 38, 84, 83, 85, 88, 70, 67, 88, 78, 67, 88, 76, 66, 94};
    }

    static {
        A02();
        A04 = VW.class.getSimpleName();
    }

    public static VW A00() {
        VW vw = A01;
        if (A03[3].charAt(18) != 'K') {
            throw new RuntimeException();
        }
        A03[1] = "1qA3QfWMYYAsctqz";
        if (vw == null) {
            A01 = new VW();
        }
        VW vw2 = A01;
        String[] strArr = A03;
        if (strArr[5].length() != strArr[6].length()) {
            A03[3] = "jddXnAGVDmATkeoPPEKFEO5X5Iu6IeIG";
            return vw2;
        }
        throw new RuntimeException();
    }

    public final AnonymousClass23 A03(String str) {
        C0716Iu adRecord = this.A00.get(str);
        if (adRecord != null) {
            return adRecord.A00;
        }
        return null;
    }

    public final C0716Iu A04(String str) {
        return this.A00.get(str);
    }

    public final C0716Iu A05(String str, Messenger messenger, String str2) {
        C0716Iu c0716Iu = new C0716Iu(str, messenger, str2);
        this.A00.put(str, c0716Iu);
        return c0716Iu;
    }

    public final void A06() {
        Iterator<Map.Entry<String, C0716Iu>> it = this.A00.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, C0716Iu> next = it.next();
            if (A03[0].charAt(11) == 'O') {
                throw new RuntimeException();
            }
            A03[1] = "vlvRe5nph1i3Qvfj";
            AnonymousClass23 anonymousClass23 = next.getValue().A00;
            if (anonymousClass23 != null) {
                anonymousClass23.destroy();
            }
            it.remove();
        }
    }

    public final void A07(int i, String str, Bundle bundle, Messenger messenger) {
        try {
            Message obtain = Message.obtain((Handler) null, i);
            if (str != null) {
                obtain.getData().putString(A01(30, 13, 6), str);
            }
            if (bundle != null) {
                obtain.getData().putBundle(A01(0, 17, 80), bundle);
            }
            messenger.send(obtain);
        } catch (RemoteException unused) {
            if (str != null) {
                A08(str);
            }
        }
    }

    public final void A08(String str) {
        C0716Iu c0716Iu = this.A00.get(str);
        if (c0716Iu != null && c0716Iu.A00 != null) {
            String str2 = A01(17, 13, 7) + str;
            c0716Iu.A00.destroy();
            this.A00.remove(str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C2K
    public final void ACJ(int i, String str, Bundle bundle) {
        C0716Iu adRecord = A04(str);
        if (adRecord != null) {
            A07(i, str, bundle, adRecord.A01);
        }
        for (Map.Entry<String, C0716Iu> entry : this.A00.entrySet()) {
            C0716Iu value = entry.getValue();
            try {
                value.A01.send(Message.obtain((Handler) null, 3));
            } catch (RemoteException unused) {
                A08(value.A02);
            }
        }
    }
}
