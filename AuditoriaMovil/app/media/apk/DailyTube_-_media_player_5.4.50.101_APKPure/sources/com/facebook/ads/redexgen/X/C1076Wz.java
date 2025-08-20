package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Wz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1076Wz implements InterfaceC0580Cy {
    public static byte[] A06;
    public static String[] A07 = {"3GVDuA8wFVUyMgpUpbIewfrR9H99KrEk", "JlICi14zqaUcthBIG11pWTw91wh2yVCw", "SCc1nWfYKQsHAUfYf8T5wZndFViKre8j", "glAeXwJzdtWksZ9B0aFClAzpFAfPstjY", "", "MoUOfVVsEVomZ5Pq9PB", "UtG2kZW99inEJ5Gw9pPEuhVI3SuCWANI", "WpnQHVSEOc3lam6iocwMhSGypVEKzNDF"};
    public int A00;
    public int A01;
    public long A02;
    public C4 A03;
    public boolean A04;
    public final C0697Hz A05 = new C0697Hz(10);

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A07[3].charAt(3) == 'p') {
                throw new RuntimeException();
            }
            A07[3] = "8BWuaIrledIbOr1Vvmzlm7GxjPqtlOKX";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 54);
            i8++;
        }
    }

    public static void A01() {
        A06 = new byte[]{121, 84, 78, 94, 92, 79, 89, 84, 83, 90, 29, 84, 83, 75, 92, 81, 84, 89, 29, 116, 121, 14, 29, 73, 92, 90, 22, 59, 108, 13, 58, 62, 59, 58, 45, 43, 58, 58, 38, 35, 41, 43, 62, 35, 37, 36, 101, 35, 46, 121};
    }

    static {
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0078, code lost:
        if (51 != r7) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00af, code lost:
        if (51 != r7) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b8, code lost:
        r8.A05.A0Z(3);
        r8.A01 = r8.A05.A0D() + 10;
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A4R(com.facebook.ads.redexgen.X.C0697Hz r9) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1076Wz.A4R(com.facebook.ads.redexgen.X.Hz):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void A4p(InterfaceC0556Bu interfaceC0556Bu, DC dc) {
        dc.A05();
        C4 AGi = interfaceC0556Bu.AGi(dc.A03(), 4);
        this.A03 = AGi;
        AGi.A5n(Format.A0B(dc.A04(), A00(35, 15, 124), null, -1, null));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void ADs() {
        int i;
        if (!this.A04 || (i = this.A01) == 0 || this.A00 != i) {
            return;
        }
        this.A03.AFS(this.A02, 1, i, 0, null);
        this.A04 = false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void ADt(long j2, boolean z2) {
        if (!z2) {
            return;
        }
        this.A04 = true;
        this.A02 = j2;
        this.A01 = 0;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void AFg() {
        this.A04 = false;
    }
}
