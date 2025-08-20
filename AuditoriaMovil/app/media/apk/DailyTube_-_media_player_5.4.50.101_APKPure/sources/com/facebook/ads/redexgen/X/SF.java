package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class SF implements QF {
    public static byte[] A0B;
    public boolean A00;
    public boolean A01;
    public final C1116Yn A02;
    public final J2 A03;
    public final SA A04;
    public final AbstractC0893Pu A05;
    public final AbstractC0884Pl A06;
    public final AbstractC0860On A07;
    public final SY A08;
    public final String A09;
    public final Map<String, String> A0A;

    static {
        A09();
    }

    public static String A06(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 96);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A0B = new byte[]{125, 105, 122, 118, 126, 104};
    }

    public SF(C1116Yn c1116Yn, J2 j2, SA sa, String str, QS qs, Map<String, String> map) {
        AbstractC0884Pl abstractC0884Pl = new AbstractC0884Pl() { // from class: com.facebook.ads.redexgen.X.9N
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC04788s
            /* renamed from: A00 */
            public final void A03(C9F c9f) {
                boolean z2;
                String str2;
                SY sy;
                C1116Yn c1116Yn2;
                z2 = SF.this.A01;
                if (!z2) {
                    SF.this.A01 = true;
                    c1116Yn2 = SF.this.A02;
                    c1116Yn2.A0E().AFU();
                }
                str2 = SF.this.A09;
                SZ sz = new SZ(str2, c9f.A03(), c9f.A01(), c9f.A02());
                if (c9f.A00() >= 0.05d) {
                    sz.A06(c9f.A01());
                }
                sy = SF.this.A08;
                sy.A0C(sz);
            }
        };
        this.A06 = abstractC0884Pl;
        AbstractC0860On abstractC0860On = new AbstractC0860On() { // from class: com.facebook.ads.redexgen.X.9M
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC04788s
            /* renamed from: A00 */
            public final void A03(AnonymousClass98 anonymousClass98) {
                C1116Yn c1116Yn2;
                c1116Yn2 = SF.this.A02;
                c1116Yn2.A0E().AFb();
                SF.this.A0D();
            }
        };
        this.A07 = abstractC0860On;
        AbstractC0893Pu abstractC0893Pu = new AbstractC0893Pu() { // from class: com.facebook.ads.redexgen.X.9L
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC04788s
            /* renamed from: A00 */
            public final void A03(C9H c9h) {
                C1116Yn c1116Yn2;
                c1116Yn2 = SF.this.A02;
                c1116Yn2.A0E().AFZ();
                SF.this.A0D();
            }
        };
        this.A05 = abstractC0893Pu;
        this.A00 = false;
        this.A01 = false;
        this.A02 = c1116Yn;
        this.A03 = j2;
        this.A09 = str;
        this.A0A = map;
        this.A04 = sa;
        this.A08 = new SY(str);
        if (C0705Ih.A1i(c1116Yn)) {
            c1116Yn.A0E().AFW();
            qs.A0h(this);
            sa.getEventBus().A05(abstractC0884Pl);
            return;
        }
        c1116Yn.A0E().AFX();
        sa.getEventBus().A03(abstractC0884Pl, abstractC0860On, abstractC0893Pu);
    }

    private Map<String, String> A08(String str) {
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.A0A;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put(A06(0, 6, 123), str);
        return hashMap;
    }

    public final void A0C() {
        SG sg = new SG(this);
        if (this.A04.A0l()) {
            ExecutorC0777Li.A00(sg);
        } else {
            this.A04.getStateHandler().post(sg);
        }
    }

    public final synchronized void A0D() {
        String A04 = SY.A04(this.A08.A0B());
        if (A04 != null) {
            this.A02.A0E().AFc();
            J2 j2 = this.A03;
            String encodedFrameData = this.A09;
            j2.AA1(encodedFrameData, A08(A04));
        } else if (!this.A00) {
            this.A02.A0E().AFV();
            this.A03.AA1(this.A09, A08(A06(0, 0, 56)));
            this.A00 = true;
        } else {
            this.A02.A0E().AFe();
        }
    }

    @Override // com.facebook.ads.redexgen.X.QF
    public final void AC8() {
        this.A02.A0E().AFa();
        A0D();
    }
}
