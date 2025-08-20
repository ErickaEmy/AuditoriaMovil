package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
/* renamed from: com.facebook.ads.redexgen.X.bU  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1244bU extends KT {
    public static byte[] A02;
    public static String[] A03 = {"CdCLIQRd", "Gozok8EGiq89CC7S8QZsNr", "pl5lQHAXyLio1ost", "M44cRouQCRL7K0vypo2P04DU", "Y2GzUIW8g3L", "Bs9wehYqNd3BdGUVOwkaAN", "ajmsB695tQiR2xtfKUGvlSwazulcZzs7", "Sy9bhDNhoUd7kDt0yrvFBLns12VVbk64"};
    public final /* synthetic */ C02870w A00;
    public final /* synthetic */ String A01;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            int i10 = (copyOfRange[i8] - i6) - 47;
            if (A03[6].charAt(27) != 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[5] = "CuQnTMvQt2iEBPylhK7T15";
            strArr[1] = "FSZFy24WJ9CShZHmahty6u";
            copyOfRange[i8] = (byte) i10;
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        if (A03[6].charAt(27) != 'c') {
            throw new RuntimeException();
        }
        A03[3] = "LuOw";
        A02 = new byte[]{-99, -87, -100, -88, -84, -100, -91, -102, -80, -106, -102, -104, -89, -89, -96, -91, -98};
    }

    static {
        A02();
    }

    public C1244bU(C02870w c02870w, String str) {
        this.A00 = c02870w;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        C04447f c04447f;
        C04447f c04447f2;
        CountDownLatch countDownLatch;
        C02860v c02860v;
        C02860v c02860v2;
        C02860v c02860v3;
        boolean A0J;
        C02860v c02860v4;
        try {
            countDownLatch = this.A00.A06;
            countDownLatch.await();
            c02860v = this.A00.A02;
            synchronized (c02860v) {
                c02860v2 = this.A00.A02;
                Iterator<String> keys = c02860v2.A05().keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    A0J = this.A00.A0J(this.A01);
                    if (A0J) {
                        C02870w c02870w = this.A00;
                        c02860v4 = c02870w.A02;
                        c02870w.A0E((C1T) c02860v4.A05().get(next), next, next.equals(this.A01));
                    }
                }
                c02860v3 = this.A00.A02;
                c02860v3.A06();
                this.A00.A08();
            }
        } catch (InterruptedException e2) {
            c04447f2 = this.A00.A03;
            AnonymousClass89 A07 = c04447f2.A07();
            String encryptedId = A00(0, 17, 8);
            A07.A9a(encryptedId, C8A.A1B, new C8B(e2));
        } catch (JSONException e3) {
            this.A00.A0M();
            c04447f = this.A00.A03;
            AnonymousClass89 A072 = c04447f.A07();
            String encryptedId2 = A00(0, 17, 8);
            A072.A9a(encryptedId2, C8A.A1A, new C8B(e3));
        }
    }
}
