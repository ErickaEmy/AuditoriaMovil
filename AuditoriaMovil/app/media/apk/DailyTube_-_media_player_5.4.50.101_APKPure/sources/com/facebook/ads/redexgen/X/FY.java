package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public final class FY extends AbstractC1223b9 {
    public static C04216c A0D;
    public static byte[] A0E;
    public static String[] A0F = {"YJVWhBFSVFKs7NrWmWULGh", "0GvTyPfIpVaCupDTXIuhVv", "vKmpQ0k2zgunQxdAFsx7Wlk6dmYtSCUc", "dqRYVPDeGy45RCRFCWIUPRHRtp9NBigI", "NSweCua6lZ8ChPFZ3cKnaOBscLcsrWLc", "HenZyTRrHhMHTWT00jKprDJGPW9d4C4V", "lvvcgtkpn6JHhS0LrJ19j3FN0lJsZZOv", "GmBDkEWrzwPugE8SLtTHysECIxUFQGpg"};
    public long A00;
    public AnonymousClass18 A01;
    public AnonymousClass19 A02;
    public C1F A03;
    public C1116Yn A04;
    public KB A05;
    public PB A06;
    public String A07;
    public String A08;
    public String A09;
    public String A0A;
    public final String A0B = UUID.randomUUID().toString();
    public final AtomicBoolean A0C = new AtomicBoolean();

    public static String A04(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 126);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A0E = new byte[]{56, 52, 54, 54, 48, 57, 48, 39, 58, 56, 48, 33, 48, 39, 10, 39, 58, 33, 52, 33, 60, 58, 59, 108, 99, 82, 108, 110, 121, 100, 123, 100, 121, 116, 9, 2, 11, 3, 4, 15, 14, 43, 14, 46, 11, 30, 11, 40, 31, 4, 14, 6, 15, 68, 76, 77, 64, 72, 93, 64, 70, 71, 109, 72, 93, 72, 12, 16, 29, 31, 25, 17, 25, 18, 8, 53, 24, 87, 85, 66, 67, 66, 65, 78, 73, 66, 67, 104, 85, 78, 66, 73, 83, 70, 83, 78, 72, 73, 108, 66, 94, 4, 19, 7, 3, 19, 5, 2, 34, 31, 27, 19, 104, Byte.MAX_VALUE, 109, 123, 104, 126, 73, Byte.MAX_VALUE, 104, 108, Byte.MAX_VALUE, 104, 79, 72, 86, 25, 14, 28, 10, 25, 15, 14, 15, 61, 2, 15, 14, 4, 42, 15, 47, 10, 31, 10, 41, 30, 5, 15, 7, 14, 87, 64, 82, 68, 87, 65, 64, 65, 122, 83, 76, 65, 64, 74, 124, 103, 96, 120, 124, 108, 64, 109, 83, 76, 64, 82, 113, 92, 85, 64};
    }

    static {
        A08();
    }

    private void A06() {
        C03312o A00 = C03312o.A00(this.A04);
        AnonymousClass19 anonymousClass19 = this.A02;
        A00.A06(anonymousClass19, anonymousClass19.A00());
    }

    private void A07() {
        if (this.A02 != null) {
            try {
                C03312o.A00(this.A04).A05(this.A02);
            } catch (Exception unused) {
            }
        }
    }

    private void A09(Intent intent) {
        int i = super.A00;
        String A04 = A04(77, 24, 89);
        if (i != -1) {
            ContentResolver contentResolver = this.A04.getContentResolver();
            if (A0F[3].charAt(29) != 'i') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[7] = "ryaiaZaF8EzuUPZd67FeoIG9jUALGHZG";
            strArr[6] = "XITZtpYy2wf6QHmOozCOnY6Xlkm3ca51";
            if (Settings.System.getInt(contentResolver, A04(1, 22, 43), 0) != 1) {
                int i5 = super.A00;
                if (A0F[2].charAt(2) != 'm') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0F;
                strArr2[1] = "mo2n49jFbf8CHvb7nubztA";
                strArr2[0] = "3h0LYrxRFByrgEG7Z48zJG";
                intent.putExtra(A04, i5);
                return;
            }
        }
        if (!C0705Ih.A0d(this.A04)) {
            intent.putExtra(A04, 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B(C1116Yn c1116Yn, C1217b3 c1217b3, int i) {
        if (i >= c1217b3.A0s()) {
            return;
        }
        FS fs = (FS) c1217b3.A0v(i);
        C04216c c04216c = new C04216c(c1116Yn);
        A0D = c04216c;
        c04216c.A0d(new JA(fs.A12(), c1116Yn.A09()));
        AbstractC03101t.A02(c1116Yn, A0D, fs);
        A0D.A0W(new FZ(this, i == 0, c1116Yn, fs, c1217b3, i), new C6V(fs.A0S(), A04(152, 14, 91), i));
    }

    private void A0C(boolean z2) {
        if (this.A05 == KB.A0F) {
            A0E(z2);
            return;
        }
        KB kb = this.A05;
        String[] strArr = A0F;
        if (strArr[1].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0F;
        strArr2[4] = "1yOiFacRiwJanRzqDJ6A5hJ77lYfziAe";
        strArr2[5] = "McEelBumOV7dKb1zb6BdvUT5HG6VvrgI";
        if (kb == KB.A0H) {
            A0F(z2);
        } else if (this.A05 == KB.A0G) {
            A0D(z2);
        } else {
            A0F(z2);
        }
    }

    private void A0D(boolean z2) {
        C04216c c04216c = new C04216c(this.A04);
        boolean z3 = C0705Ih.A1n(this.A04) && AnonymousClass62.A0A(this.A03.A0V());
        if (z3) {
            AnonymousClass62 unifiedAssetsLoader = new AnonymousClass62(c04216c, this.A03.A0V(), this.A03.A0P(), this.A03.A0S(), z3, new C1229bF(this));
            c04216c.A0d(new JA(((AbstractC1219b5) this.A03).A12(), this.A04.A09()));
            unifiedAssetsLoader.A0B();
            return;
        }
        AbstractC03091s.A02(this.A04, (AbstractC1219b5) this.A03, z2, new C1228bE(this));
    }

    private void A0E(boolean z2) {
        C04216c c04216c = new C04216c(this.A04);
        c04216c.A0d(new JA(((AbstractC1219b5) this.A03).A12(), this.A04.A09()));
        AbstractC03101t.A03(this.A04, c04216c, (FS) this.A03);
        c04216c.A0W(new C1233bJ(this), new C6V(this.A03.A0S(), A04(152, 14, 91)));
    }

    private void A0F(boolean z2) {
        boolean z3 = false;
        if (this.A03.A0j()) {
            C1217b3 c1217b3 = (C1217b3) this.A03;
            for (int i = 0; i < c1217b3.A0s(); i++) {
                if (TextUtils.isEmpty(c1217b3.A0v(i).A0x().A0D().A08())) {
                    this.A01.AD1(this, AdError.INTERNAL_ERROR);
                    return;
                }
            }
            A0B(this.A04, c1217b3, 0);
            return;
        }
        C04216c c04216c = new C04216c(this.A04);
        c04216c.A0d(new JA(((AbstractC1219b5) this.A03).A12(), this.A04.A09()));
        if (C0705Ih.A1n(this.A04) && AnonymousClass62.A0A(this.A03.A0V())) {
            z3 = true;
        }
        boolean A0m = this.A03.A0m();
        if (z3) {
            AnonymousClass62 unifiedAssetsLoader = new AnonymousClass62(c04216c, this.A03.A0V(), this.A03.A0P(), this.A03.A0S(), z3, new C1231bH(this, A0m));
            unifiedAssetsLoader.A0B();
            return;
        }
        FS fs = (FS) this.A03;
        if (TextUtils.isEmpty(fs.A0x().A0D().A08())) {
            this.A01.AD1(this, AdError.INTERNAL_ERROR);
            return;
        }
        AbstractC03101t.A02(this.A04, c04216c, fs);
        c04216c.A0W(new C0624Fa(this, z2, A0m, fs, this), new C6V(fs.A0S(), A04(152, 14, 91)));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1223b9
    public final int A0G() {
        C1F c1f = this.A03;
        if (c1f == null) {
            String[] strArr = A0F;
            if (strArr[4].charAt(5) != strArr[5].charAt(5)) {
                A0F[3] = "zy8kAWNFspHhc9OUOOhBHMIK4AaCMilm";
                return -1;
            }
            throw new RuntimeException();
        }
        return c1f.A0G();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1223b9
    public final C1F A0H() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1223b9
    public final boolean A0I() {
        if (this.A0C.get()) {
            this.A03.A0X(super.A01);
            String A03 = Q7.A03(super.A02, this.A0B, this.A07);
            this.A03.A0Y(super.A02);
            this.A03.A0c(A03);
            AdActivityIntent A04 = C0754Kj.A04(this.A04);
            A04.putExtra(A04(174, 8, 91), this.A05);
            A04.putExtra(A04(127, 25, 21), this.A03);
            A04.putExtra(A04(34, 19, 20), this.A03);
            String A042 = A04(166, 8, 119);
            String rewardUrl = this.A0B;
            A04.putExtra(A042, rewardUrl);
            if (A03 != null) {
                String rewardUrl2 = A04(R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, 15, 100);
                A04.putExtra(rewardUrl2, A03);
            }
            String A043 = A04(66, 11, 2);
            String rewardUrl3 = this.A0A;
            A04.putExtra(A043, rewardUrl3);
            A04.putExtra(A04(101, 11, 8), this.A00);
            String str = this.A09;
            if (str != null) {
                String rewardUrl4 = A04(53, 13, 87);
                A04.putExtra(rewardUrl4, str);
            }
            A09(A04);
            if (!ProcessUtils.isRemoteRenderingProcess()) {
                A04.setFlags(A04.getFlags() | 268435456);
            }
            ActivityUtils.A03(this.A04);
            try {
                if (ProcessUtils.isRemoteRenderingProcess()) {
                    if (!C0754Kj.A0J(this.A04, A04)) {
                        this.A04.A0E().AF0();
                        AnonymousClass18 anonymousClass18 = this.A01;
                        if (anonymousClass18 != null) {
                            anonymousClass18.AD1(this, AdError.AD_PRESENTATION_ERROR);
                        }
                        return false;
                    }
                    return true;
                }
                C0754Kj.A0A(this.A04, A04);
                return true;
            } catch (C0752Kh e2) {
                Throwable cause = e2.getCause();
                Throwable th = e2;
                if (cause != null) {
                    th = e2.getCause();
                }
                AnonymousClass89 A07 = this.A04.A07();
                int i = C8A.A01;
                C8B c8b = new C8B(th);
                String rewardUrl5 = A04(23, 11, R.styleable.AppCompatTheme_tooltipFrameBackground);
                A07.A9a(rewardUrl5, i, c8b);
                return true;
            }
        }
        return false;
    }

    public final void A0J(C1116Yn c1116Yn, AnonymousClass18 anonymousClass18, C03121v c03121v, boolean z2, String str, String str2) {
        this.A0C.set(false);
        this.A04 = c1116Yn;
        this.A01 = anonymousClass18;
        this.A0A = c03121v.A02();
        this.A00 = c03121v.A00();
        this.A09 = str2;
        String str3 = this.A0A;
        this.A07 = str3 != null ? str3.split(A04(0, 1, 25))[0] : A04(0, 0, 20);
        C1F A00 = C1F.A00(c03121v.A03(), this.A04);
        this.A03 = A00;
        A00.A0a(str);
        this.A03.A0W(c03121v.A01().A06());
        if (this.A03.A0j()) {
            this.A08 = ((C1217b3) this.A03).A0y();
        } else {
            AbstractC1219b5 abstractC1219b5 = (AbstractC1219b5) this.A03;
            String[] strArr = A0F;
            String str4 = strArr[7];
            String str5 = strArr[6];
            int experienceType = str4.charAt(31);
            if (experienceType != str5.charAt(31)) {
                String[] strArr2 = A0F;
                strArr2[7] = "FFkeuuVk1meHqgTyMiNT7tgr8739x7mc";
                strArr2[6] = "JwuXN3bqyC9CcnquHiHDyzq7R0rb3kLZ";
                this.A08 = abstractC1219b5.A12();
            } else {
                String[] strArr3 = A0F;
                strArr3[7] = "QuYSy7nqZhyT9avsyztjWhd8F7hW1wjU";
                strArr3[6] = "5b6UXiMlNaCol2aZqv4zpvCfEMtgCuxD";
                this.A08 = abstractC1219b5.A12();
            }
        }
        boolean A0m = this.A03.A0m();
        String[] strArr4 = A0F;
        if (strArr4[7].charAt(31) == strArr4[6].charAt(31)) {
            throw new RuntimeException();
        }
        String[] strArr5 = A0F;
        strArr5[7] = "T6UzDEu82kzY1KsvV3iHB7OkWnIxnMBs";
        strArr5[6] = "PWXGgNcAlDXPEXP1mMx0dPQCA8p68UI5";
        if (A0m) {
            this.A05 = KB.A08;
            if (this.A03.A0g()) {
                this.A04.A0E().AGG(EnumC02700e.A07);
            } else {
                this.A04.A0E().AGG(EnumC02700e.A09);
            }
        } else {
            switch (this.A03.A0F()) {
                case 0:
                    this.A05 = KB.A0H;
                    C0S A0E2 = this.A04.A0E();
                    int experienceType2 = A0F[3].charAt(29);
                    if (experienceType2 != 105) {
                        A0F[3] = "i1vVIMuEE2CogviWDEosGc55NgD83ibP";
                        A0E2.AGG(EnumC02700e.A0C);
                        break;
                    } else {
                        A0F[2] = "e7mQJdX4ST7JevLzoIctPRomcGPYY6Su";
                        A0E2.AGG(EnumC02700e.A0C);
                        break;
                    }
                case 1:
                    this.A05 = KB.A0G;
                    this.A04.A0E().AGG(EnumC02700e.A0B);
                    break;
                case 2:
                    this.A05 = KB.A05;
                    this.A04.A0E().AGG(EnumC02700e.A04);
                    break;
                case 3:
                    this.A05 = KB.A0F;
                    this.A04.A0E().AGG(EnumC02700e.A03);
                    break;
            }
        }
        if (C0705Ih.A0q(c1116Yn)) {
            if (this.A03.A0j()) {
                C1217b3 c1217b3 = (C1217b3) this.A03;
                for (int A0s = c1217b3.A0s() - 1; A0s >= 0; A0s--) {
                    AbstractC1219b5 A0v = c1217b3.A0v(A0s);
                    if (AbstractC02770l.A06(this.A04, AbstractC02770l.A01(c1116Yn, A0v.A0V(), A0v.A12()), c1116Yn.A09())) {
                        this.A04.A0E().A4K();
                        c1217b3.A10(A0s);
                        return;
                    }
                }
                if (c1217b3.A0s() == 0) {
                    this.A01.AD1(this, AdError.NO_FILL);
                    return;
                }
            } else if (AbstractC02770l.A06(this.A04, AbstractC02770l.A01(c1116Yn, c03121v.A03(), ((AbstractC1219b5) this.A03).A12()), c1116Yn.A09())) {
                this.A04.A0E().A4K();
                this.A01.AD1(this, AdError.NO_FILL);
                return;
            }
        }
        this.A02 = new AnonymousClass19(this.A0B, this, anonymousClass18);
        A06();
        A0C(z2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02800p
    public final String A6T() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02800p
    public final boolean AGd() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02800p
    public final void onDestroy() {
        A07();
    }
}
