package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.view.Surface;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Qw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0921Qw {
    public static byte[] A02;
    public static String[] A03 = {"WzijvlAd9RP1HJzMxCKzeYHnMs2QP54v", "kfrqpsiELz0FvZTPYg", "hAwPDz", "OryCsPOoCbEZ1Kjw18", "JoqBI6chV", "rfkFyJ13DXugB3RLj6H", "rQvj", "kthZXjW83"};
    public final EH A00;
    public final W1 A01;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 10);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-114, -104, -116, -114, -49, -51, -31, -33, -47, -114, -116, -90, -116, -114, -96, -86, -98, -96, -16, -29, -20, -30, -29, -16, -29, -16, -57, -20, -30, -29, -10, -96, -98, -72, -98, -96, -114, -23, 111, 114, -127, -68, 99, -75, -70, -79, -90, 99, 97, 123, 97, 99};
    }

    static {
        A02();
    }

    public C0921Qw(C1116Yn c1116Yn) {
        W1 w1 = new W1();
        this.A01 = w1;
        InterfaceC0652Gf trackSelectionFactory = new W8(w1);
        this.A00 = AbstractC04899e.A00(new Y7(c1116Yn), new C0550Bo(trackSelectionFactory), new Y9());
    }

    public static String A01(C04879c c04879c) {
        return A00(41, 11, 55) + c04879c.A01 + A00(14, 22, 116) + c04879c.A00 + A00(0, 14, 98) + c04879c.getCause() + A00(36, 2, 98);
    }

    public static boolean A03() {
        if (A03[0].charAt(3) != 'z') {
            A03[6] = "p35x";
            return true;
        }
        throw new RuntimeException();
    }

    public final int A04() {
        return this.A00.A0J();
    }

    public final int A05() {
        return this.A00.A6B();
    }

    public final long A06() {
        return this.A00.A6d();
    }

    public final long A07() {
        return this.A00.A6q();
    }

    public final C0919Qu A08() {
        Format vf = this.A00.A0L();
        if (vf == null) {
            return null;
        }
        return new C0919Qu(vf.A0F, vf.A08);
    }

    public final void A09() {
        this.A00.AEV();
    }

    public final void A0A() {
        this.A00.AFk();
    }

    public final void A0B() {
        this.A00.A0M();
    }

    public final void A0C(float f4) {
        this.A00.A0N(f4);
    }

    public final void A0D(long j2) {
        this.A00.AFj(j2);
    }

    public final void A0E(Surface surface) {
        this.A00.A0O(surface);
    }

    public final void A0F(C1115Ym c1115Ym, Uri uri) {
        if (C0705Ih.A2Q(c1115Ym, A03())) {
            R0 cacheManager = R0.A05(c1115Ym);
            WR wr = new WR(cacheManager.A0F(c1115Ym));
            String A08 = R0.A08(c1115Ym, uri);
            if (A08 != null) {
                wr.A00(A08);
            }
            this.A00.A0P(wr.A01(uri));
            return;
        }
        InterfaceC0614Eq mediaSource = new WR(new C1053Vz(c1115Ym, IF.A0K(c1115Ym, A00(38, 3, 4)), this.A01)).A01(uri);
        this.A00.A0P(mediaSource);
    }

    public final void A0G(InterfaceC0918Qt interfaceC0918Qt) {
        this.A00.A3Q(new C0743Jx(this, interfaceC0918Qt));
    }

    public final void A0H(InterfaceC0920Qv interfaceC0920Qv) {
        this.A00.A0Q(new C0744Jy(this, interfaceC0920Qv));
    }

    public final void A0I(boolean z2) {
        this.A00.AG9(z2);
    }

    public final boolean A0J() {
        return this.A00.A7g();
    }

    public final boolean A0K() {
        return this.A00.A0K() != null;
    }
}
