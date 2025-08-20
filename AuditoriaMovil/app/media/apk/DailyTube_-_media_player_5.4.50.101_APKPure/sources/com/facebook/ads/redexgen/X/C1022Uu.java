package com.facebook.ads.redexgen.X;

import android.content.pm.PackageManager;
import android.util.Base64;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Uu  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1022Uu extends KT {
    public static byte[] A02;
    public final /* synthetic */ K1 A00;
    public final /* synthetic */ K4 A01;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 119);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{10, 75, 89, 68, 71, 72, 72, 67, 84, 89, 77, 67, 95, 101, 68, 11, 69, 78, 95, 92, 68, 89, 64, 11, 72, 68, 69, 69, 78, 72, 95, 66, 68, 69};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        C1116Yn c1116Yn;
        C1116Yn c1116Yn2;
        C1116Yn c1116Yn3;
        C1116Yn c1116Yn4;
        C1116Yn c1116Yn5;
        long j2;
        C1116Yn c1116Yn6;
        String str;
        Map<? extends String, ? extends String> map;
        RL A022;
        C1116Yn c1116Yn7;
        C1116Yn c1116Yn8;
        C1116Yn c1116Yn9;
        C1116Yn c1116Yn10;
        long j4;
        c1116Yn = this.A01.A04;
        if (AbstractC0772Ld.A00(c1116Yn) == EnumC0771Lc.A07) {
            this.A01.A09();
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String A00 = A00(13, 21, 92);
            c1116Yn10 = this.A01.A04;
            C0S A0E = c1116Yn10.A0E();
            j4 = this.A01.A00;
            A0E.A2v(C0774Lf.A01(j4), adErrorType.getErrorCode(), A00, adErrorType.isPublicError());
            this.A01.A0D(new C0722Jb(adErrorType, A00));
            return;
        }
        c1116Yn2 = this.A01.A04;
        C8J.A08(c1116Yn2);
        c1116Yn3 = this.A01.A04;
        C6E.A07(c1116Yn3);
        C04718l A002 = C04718l.A00();
        c1116Yn4 = this.A01.A04;
        boolean z2 = true;
        Map<String, String> A09 = this.A00.A09(A002.A01(c1116Yn4, true).A6w(this.A00.A05()));
        this.A01.A02 = A09;
        try {
            c1116Yn7 = this.A01.A04;
            PackageManager packageManager = c1116Yn7.getPackageManager();
            if (packageManager != null) {
                String A003 = A00(1, 12, R.styleable.AppCompatTheme_toolbarStyle);
                StringBuilder sb = new StringBuilder();
                c1116Yn8 = this.A01.A04;
                StringBuilder append = sb.append(c1116Yn8.getPackageName()).append(A00(0, 1, 93));
                c1116Yn9 = this.A01.A04;
                A09.put(A003, new String(Base64.encode(append.append(packageManager.getInstallerPackageName(c1116Yn9.getPackageName())).toString().getBytes(), 2)));
            }
        } catch (Exception unused) {
        }
        try {
            if (this.A00.A06() != EnumC0726Jg.A03 && this.A00.A06() != EnumC0726Jg.A05 && this.A00.A06() != EnumC0726Jg.A04 && this.A00.A06() != null) {
                z2 = false;
            }
            c1116Yn6 = this.A01.A04;
            RK A023 = C0927Rc.A02(z2, c1116Yn6);
            str = this.A01.A06;
            RY ry = new RY();
            map = this.A01.A02;
            byte[] A08 = ry.A05(map).A08();
            A022 = this.A01.A02(C0774Lf.A00(), this.A00);
            A023.AE0(str, A08, A022);
        } catch (Exception e2) {
            AdErrorType adErrorType2 = AdErrorType.AD_REQUEST_FAILED;
            String message = e2.getMessage();
            c1116Yn5 = this.A01.A04;
            C0S A0E2 = c1116Yn5.A0E();
            j2 = this.A01.A00;
            A0E2.A2v(C0774Lf.A01(j2), adErrorType2.getErrorCode(), message, adErrorType2.isPublicError());
            this.A01.A0D(C0722Jb.A01(adErrorType2, message));
        }
    }

    public C1022Uu(K4 k4, K1 k1) {
        this.A01 = k4;
        this.A00 = k1;
    }
}
