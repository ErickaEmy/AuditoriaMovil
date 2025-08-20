package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.1i  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02991i {
    public static byte[] A05;
    public static String[] A06 = {"jJreqFAWfQsm2UlBXjWleQZy51A8w9r3", "B5vxrqY9e1pfFDILbPSJEQZe5Zep9JAF", "7hwRhDIA2xM98ucsNVPICP0872", "8yYdfjKxcW1uK5E8nS4F9bT", "cwoTvwLLOWGZrFwonmn2qn9xu", "wuc4L", "VoE60CbUCih", "1JGxuEjawtyxaKItdz1AQ1lnM"};
    public C04216c A00;
    public EnumC0833Nm A01 = EnumC0833Nm.A06;
    public ArrayList<PB> A02 = new ArrayList<>();
    public final C1F A03;
    public final InterfaceC02981h A04;

    public static String A04(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 96);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{-97, -39, -27, -34, -35, -81, -44, -38, -53, -40, -44, -57, -46, -122, -85, -40, -40, -43, -40, -122, -104, -106, -106, -100, -122, -35, -49, -38, -50, -43, -37, -38, -122, -57, -122, -36, -57, -46, -49, -54, -122, -89, -54, -81, -44, -52, -43, -108, 31, 34, 29, 34, 31, 50, 31, 29, 32, 51, 44, 34, 42, 35, -45, -30, -37, -59, -54, -61, -53, -48, -63, -46, -61, -44, -61, -49, -43, -42, -37, -44, -36, -31, -40, -41, -76, -41, -73, -44, -25, -44, -75, -24, -31, -41, -33, -40, -38, -33, -27, -42, -29, -28, -27, -38, -27, -38, -46, -35};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final void A0J(C1116Yn c1116Yn, EnumSet<CacheFlag> enumSet) {
        if (A0E() == KB.A04) {
            C1217b3 c1217b3 = (C1217b3) this.A03;
            AbstractC1219b5 A0u = c1217b3.A0u();
            if (A0C(c1116Yn, A0u) || A0u == null) {
                return;
            }
            this.A04.AES();
            A0A(c1116Yn, enumSet, c1217b3, A0u, 0, this.A04);
        } else if (A0C(c1116Yn, (AbstractC1219b5) this.A03)) {
        } else {
            this.A04.AES();
            if (A0E() == KB.A0C) {
                A08(c1116Yn, (FU) this.A03);
            } else {
                A09(c1116Yn, enumSet, (FU) this.A03, -1, this.A04);
            }
        }
    }

    static {
        A06();
    }

    public C02991i(C1116Yn c1116Yn, C03121v c03121v, InterfaceC02981h interfaceC02981h, String str) {
        JSONObject dataObject = c03121v.A03();
        this.A03 = A01(c1116Yn, c03121v, str, dataObject);
        this.A04 = interfaceC02981h;
    }

    private AdError A00(C1116Yn c1116Yn, AbstractC1219b5 abstractC1219b5) {
        if (abstractC1219b5 == null || abstractC1219b5.A14().isEmpty()) {
            c1116Yn.A07().A9a(A04(62, 3, 18), C8A.A0Z, new C8B(A04(5, 43, 6)));
            return AdError.internalError(2006);
        }
        return null;
    }

    public static C1F A01(C1116Yn c1116Yn, C03121v c03121v, String str, JSONObject jSONObject) {
        C1F c1f = null;
        if (jSONObject.has(A04(65, 12, 2))) {
            try {
                c1f = C1217b3.A03(jSONObject, c1116Yn, true);
                c1f.A0e(true);
                c1f.A0b(A04(96, 12, 17));
            } catch (JSONException unused) {
            }
        }
        if (c1f == null) {
            c1f = FU.A02(jSONObject, c1116Yn);
        }
        c1f.A0a(str);
        C8T A01 = c03121v.A01();
        if (A01 != null) {
            c1f.A0W(A01.A06());
        }
        return c1f;
    }

    private C04216c A03(C1116Yn c1116Yn) {
        C04216c c04216c = this.A00;
        return c04216c != null ? c04216c : new C04216c(c1116Yn);
    }

    private void A08(C1116Yn c1116Yn, FU fu) {
        C02931c playableData = fu.A0x().A0D().A06();
        A0B(playableData != null ? playableData.A0A() : EnumC0833Nm.A06);
        C1208au c1208au = new C1208au(this);
        C04216c c04216c = new C04216c(c1116Yn);
        boolean z2 = C0705Ih.A1n(c1116Yn) && AnonymousClass62.A0A(fu.A0V());
        if (z2) {
            AnonymousClass62 unifiedAssetsLoader = new AnonymousClass62(c04216c, fu.A0V(), fu.A0P(), fu.A0S(), z2, new C1207at(this));
            c04216c.A0d(new JA(fu.A12(), c1116Yn.A09()));
            unifiedAssetsLoader.A0B();
            return;
        }
        AbstractC03091s.A02(c1116Yn, fu, true, c1208au);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0092, code lost:
        if (r21 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0094, code lost:
        r8 = new com.facebook.ads.redexgen.X.C6Y(r27.A0M(), r27.A0S(), r1);
        r8.A04 = true;
        r8.A03 = A04(0, 5, 17);
        r13.A0X(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b0, code lost:
        r13.A0c(new com.facebook.ads.redexgen.X.C04196a(r27.A10().A01(), com.facebook.ads.redexgen.X.C0887Po.A04, com.facebook.ads.redexgen.X.C0887Po.A04, r27.A0S(), A04(96, 12, 17)));
        r12 = r26.contains(com.facebook.ads.CacheFlag.VIDEO);
        r11 = 0;
        r10 = com.facebook.ads.redexgen.X.C0705Ih.A2R(r25, com.facebook.ads.redexgen.X.C0921Qw.A03());
        r9 = r27.A14().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ef, code lost:
        if (r9.hasNext() == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00f1, code lost:
        r0 = r9.next();
        r14 = new com.facebook.ads.redexgen.X.C04196a(r0.A0D().A07(), com.facebook.ads.redexgen.X.AbstractC03051o.A00(r0.A0D()), com.facebook.ads.redexgen.X.AbstractC03051o.A01(r0.A0D()), r27.A0S(), A04(96, 12, 17));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0122, code lost:
        if (r11 != 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0124, code lost:
        r13.A0b(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0127, code lost:
        r8 = r0.A0G().A01();
        r7 = com.facebook.ads.redexgen.X.C02991i.A06;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x013f, code lost:
        if (r7[6].length() == r7[2].length()) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0141, code lost:
        r7 = com.facebook.ads.redexgen.X.C02991i.A06;
        r7[1] = "D8Za7DAeUKhUMlH0nChh1nyf5MUepOev";
        r7[0] = "YMJugZMvnGL61TcEtQKO8oN05ixDNSHw";
        r5 = r8.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0151, code lost:
        r6 = r5.hasNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0155, code lost:
        if (r6 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0157, code lost:
        r13.A0c(new com.facebook.ads.redexgen.X.C04196a(r5.next(), -1, -1, r27.A0S(), A04(96, 12, 17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0178, code lost:
        if (r12 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0186, code lost:
        if (android.text.TextUtils.isEmpty(r0.A0D().A08()) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0188, code lost:
        r14 = new com.facebook.ads.redexgen.X.C6Y(r0.A0D().A08(), r27.A0S(), A04(96, 12, 17), r0.A0D().A05());
        r14.A04 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01ad, code lost:
        if (r11 != 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01af, code lost:
        if (r21 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01b1, code lost:
        if (r10 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01b3, code lost:
        r13.A0X(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01b6, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01ba, code lost:
        r13.A0a(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01be, code lost:
        if (r21 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01c0, code lost:
        if (r10 != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01c2, code lost:
        r13.A0Y(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01c6, code lost:
        r13.A0Z(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01ca, code lost:
        r5 = r8.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01cf, code lost:
        r13.A0c(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01e0, code lost:
        if (r21 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01e4, code lost:
        r13.A0W(new com.facebook.ads.redexgen.X.C1209av(r24, r25, r21, r27, r29), new com.facebook.ads.redexgen.X.C6V(r27.A0S(), r1, r28));
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A09(com.facebook.ads.redexgen.X.C1116Yn r25, java.util.EnumSet<com.facebook.ads.CacheFlag> r26, com.facebook.ads.redexgen.X.AbstractC1219b5 r27, int r28, com.facebook.ads.redexgen.X.InterfaceC02981h r29) {
        /*
            Method dump skipped, instructions count: 521
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02991i.A09(com.facebook.ads.redexgen.X.Yn, java.util.EnumSet, com.facebook.ads.redexgen.X.b5, int, com.facebook.ads.redexgen.X.1h):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A(C1116Yn c1116Yn, EnumSet<CacheFlag> enumSet, C1217b3 c1217b3, AbstractC1219b5 abstractC1219b5, int i, InterfaceC02981h interfaceC02981h) {
        A09(c1116Yn, enumSet, abstractC1219b5, i, new C1213az(this, c1116Yn, abstractC1219b5, c1217b3, i, interfaceC02981h, enumSet));
    }

    private void A0B(EnumC0833Nm enumC0833Nm) {
        this.A01 = enumC0833Nm;
    }

    private boolean A0C(C1116Yn c1116Yn, AbstractC1219b5 abstractC1219b5) {
        AdError A00 = A00(c1116Yn, abstractC1219b5);
        if (A00 != null) {
            InterfaceC02981h interfaceC02981h = this.A04;
            String[] strArr = A06;
            if (strArr[1].charAt(24) != strArr[0].charAt(24)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[1] = "Dm6wm58uJ8qXwjtNx8Vtzbsb5Jkw9mit";
            strArr2[0] = "fLwuuFNg4tiwPdo6hP9t6x3v5l5Hcavg";
            interfaceC02981h.AAe(A00);
            return true;
        }
        return false;
    }

    public final C1F A0D() {
        return this.A03;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ab, code lost:
        if (r3 != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:
        return com.facebook.ads.redexgen.X.KB.A0D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b7, code lost:
        if (r3 != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bc, code lost:
        return com.facebook.ads.redexgen.X.KB.A0B;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.ads.redexgen.X.KB A0E() {
        /*
            r4 = this;
            com.facebook.ads.redexgen.X.1F r0 = r4.A03
            boolean r0 = r0.A0j()
            if (r0 == 0) goto Lb
            com.facebook.ads.redexgen.X.KB r0 = com.facebook.ads.redexgen.X.KB.A04
            return r0
        Lb:
            com.facebook.ads.redexgen.X.1F r3 = r4.A03
            com.facebook.ads.redexgen.X.b5 r3 = (com.facebook.ads.redexgen.X.AbstractC1219b5) r3
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C02991i.A06
            r0 = 6
            r1 = r2[r0]
            r0 = 2
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L50
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C02991i.A06
            java.lang.String r1 = "f4kXngrP8CD5dz"
            r0 = 3
            r2[r0] = r1
            boolean r0 = r3.A0m()
            if (r0 == 0) goto L31
            com.facebook.ads.redexgen.X.KB r0 = com.facebook.ads.redexgen.X.KB.A06
            return r0
        L31:
            java.util.List r0 = r3.A14()
            int r1 = r0.size()
            r0 = 1
            if (r1 <= r0) goto L5e
            com.facebook.ads.redexgen.X.KB r3 = com.facebook.ads.redexgen.X.KB.A0A
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C02991i.A06
            r0 = 7
            r1 = r2[r0]
            r0 = 4
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L56
        L50:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L56:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C02991i.A06
            java.lang.String r1 = "ny"
            r0 = 3
            r2[r0] = r1
            return r3
        L5e:
            com.facebook.ads.redexgen.X.1G r0 = r3.A0x()
            com.facebook.ads.redexgen.X.1J r0 = r0.A0D()
            com.facebook.ads.redexgen.X.1c r0 = r0.A06()
            if (r0 == 0) goto L8e
            com.facebook.ads.redexgen.X.KB r3 = com.facebook.ads.redexgen.X.KB.A0C
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C02991i.A06
            r0 = 6
            r1 = r2[r0]
            r0 = 2
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L88
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C02991i.A06
            java.lang.String r1 = "JH"
            r0 = 3
            r2[r0] = r1
            return r3
        L88:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L8e:
            boolean r3 = r4.A0L(r3)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C02991i.A06
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 32
            if (r1 == r0) goto Lb0
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C02991i.A06
            java.lang.String r1 = "93R6MUXHMTxUt8WfLt1oZ3ea5zubl3sl"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "9xXPI1nVQC4CSUB4soKlPH985bh9DAt9"
            r0 = 0
            r2[r0] = r1
            if (r3 == 0) goto Lba
        Lad:
            com.facebook.ads.redexgen.X.KB r0 = com.facebook.ads.redexgen.X.KB.A0D
            return r0
        Lb0:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C02991i.A06
            java.lang.String r1 = "ySAy4b6nQ"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto Lba
            goto Lad
        Lba:
            com.facebook.ads.redexgen.X.KB r0 = com.facebook.ads.redexgen.X.KB.A0B
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02991i.A0E():com.facebook.ads.redexgen.X.KB");
    }

    public final EnumC0833Nm A0F() {
        return this.A01;
    }

    public final String A0G() {
        if (this.A03.A0j()) {
            return ((C1217b3) this.A03).A0y();
        }
        return ((AbstractC1219b5) this.A03).A12();
    }

    public final void A0H() {
        this.A04.AGm();
    }

    public final void A0I(Intent intent, RewardData rewardData, String str) {
        this.A03.A0Y(rewardData);
        this.A03.A0c(str);
        if (A0D().A0j()) {
            intent.putExtra(A04(77, 19, 19), this.A03);
        }
        intent.putExtra(A04(48, 14, 94), this.A03);
    }

    public final boolean A0K() {
        return this.A03.A0g();
    }

    public final boolean A0L(AbstractC1219b5 abstractC1219b5) {
        return !TextUtils.isEmpty(abstractC1219b5.A0x().A0D().A08());
    }
}
