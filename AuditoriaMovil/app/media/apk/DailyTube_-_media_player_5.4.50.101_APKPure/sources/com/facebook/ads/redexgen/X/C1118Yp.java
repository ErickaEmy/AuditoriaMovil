package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
/* renamed from: com.facebook.ads.redexgen.X.Yp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1118Yp implements InterfaceC0924Qz {
    public static byte[] A04;
    public static String[] A05 = {"YemVV2CAzinSYko79pvdFyiaYh6Ax0NW", "FtFCRkuseyQck6qipAKyAgz81MNc63Vq", "zQJLp3VKHBLQ3ByylDAuuS44tkTO3MMG", "42Yp5AyXW20j54q75pN0MZ83oMgNP5AR", "H6ih9Bh2z", "6YmusGfII7QcqEjcRVkg771Wm5bkMvFZ", "MrQdRQonl4dLBaJwcA8", "V6zsFfxQuHmo6VBO3CkkHMQL74uZQLm4"};
    public final /* synthetic */ long A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ C6X A02;
    public final /* synthetic */ C6Y A03;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 94);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{24, 3, 6, 3, 2, 26, 3, 62, 33, 44, 45, 39};
    }

    static {
        A01();
    }

    public C1118Yp(C6X c6x, C6Y c6y, long j2, long j4) {
        this.A02 = c6x;
        this.A03 = c6y;
        this.A00 = j2;
        this.A01 = j4;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0924Qz
    public final void ABL(boolean z2) {
        C04447f c04447f;
        BlockingQueue blockingQueue;
        C04447f c04447f2;
        Map map;
        C04447f c04447f3;
        c04447f = this.A02.A01.A04;
        if (C04246f.A06(c04447f)) {
            C04236e c04236e = new C04236e(this.A03.A06, this.A03.A07, A00(7, 5, 22), this.A03.A02, this.A03.A08);
            c04447f2 = this.A02.A01.A04;
            C04246f.A04(c04447f2, c04236e, z2);
            if (!z2) {
                c04447f3 = this.A02.A01.A04;
                C04246f.A05(c04447f3, this.A03.A06, this.A03.A07, this.A03.A08, A00(7, 5, 22), this.A03.A02, 2112, null, Long.valueOf(this.A00), Long.valueOf(System.currentTimeMillis() - this.A01), null);
            }
            map = C04216c.A0G;
            if (A05[1].charAt(13) == 'O') {
                throw new RuntimeException();
            }
            A05[1] = "tpujksKgYg5a3fdXCIDkrfoMaur1s0eW";
            map.put(c04236e.A04, c04236e);
        }
        try {
            blockingQueue = this.A02.A00;
            blockingQueue.put(true);
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0924Qz
    public final void ABT(Throwable th) {
        C04447f c04447f;
        BlockingQueue blockingQueue;
        C04447f c04447f2;
        c04447f = this.A02.A01.A04;
        if (C04246f.A06(c04447f)) {
            c04447f2 = this.A02.A01.A04;
            String str = this.A03.A06;
            String str2 = this.A03.A07;
            String str3 = this.A03.A08;
            String A00 = A00(7, 5, 22);
            String str4 = this.A03.A02;
            String th2 = th != null ? th.toString() : A00(0, 7, 51);
            Long valueOf = Long.valueOf(System.currentTimeMillis() - this.A01);
            String[] strArr = A05;
            if (strArr[3].charAt(20) == strArr[0].charAt(20)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[2] = "AayJnSlXKOYoed0ZHJ3UlPrg44Go7inE";
            strArr2[7] = "t2uUu9WqhkybHrBNVhVVT1YnAGopOKs6";
            C04246f.A05(c04447f2, str, str2, str3, A00, str4, 2119, th2, null, valueOf, null);
        }
        try {
            blockingQueue = this.A02.A00;
            blockingQueue.put(false);
        } catch (InterruptedException unused) {
        }
    }
}
