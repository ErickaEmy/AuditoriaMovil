package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Tn  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0990Tn implements L8 {
    public static byte[] A0B;
    public static String[] A0C = {"yjxjfYdrUuNcQdEaAwocONv5EWPutnE0", "dRlwVer0DvGhJUYrc6Uo0NmXUudA179W", "0RnVmJRwwZudZEhL6bHsgo2zllxyZ4rb", "m0b7Xk04EuyV6HvP3aQ0qivYD5xsobzk", "0t24jhYDd0ZYm7OB5Pi8K72QIL3VEz", "lOzGJRW4wb6yqjR22F", "IF7HB2KmjMtnMILVYc8NomcIB26UEqSU", "4w4SFr7wcyEc7Fy4rwfiYpUJCop0r4V7"};
    public int A00;
    public int A01;
    public int A02;
    public MB A03;
    public String A04;
    public String A05;
    public View$OnClickListenerC0988Tl A06;
    public boolean A0A = false;
    public boolean A09 = false;
    public boolean A08 = false;
    public Integer A07 = null;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 44);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-69, -45, -59, -61, -45, -67, -18, 2, 1, -4, -16, -7, -10, -16, -8};
        if (A0C[5].length() == 17) {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[7] = "4rqaLE5ZbqFcULNB9c87AdfXRmFVNOuy";
        strArr[0] = "UmGixQziu9kcJVx2wygXDh2bknYXJmsp";
        A0B = bArr;
    }

    static {
        A01();
    }

    public C0990Tn(int i, int i5, int i6, String str, String str2, MB mb, View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl) {
        this.A01 = i;
        this.A00 = i5;
        this.A02 = i6;
        this.A05 = str;
        this.A04 = str2;
        this.A03 = mb;
        this.A06 = view$OnClickListenerC0988Tl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A02() {
        if (this.A08) {
            A04();
        }
    }

    public final synchronized void A04() {
        MB mb;
        if (this.A09) {
            return;
        }
        this.A09 = true;
        if (this.A01 == 1 && (mb = this.A03) != null) {
            mb.setProgressImage(null);
            this.A03.setProgressClickListener(null);
            this.A03.setToolbarActionMessage(A00(0, 0, R.styleable.AppCompatTheme_tooltipFrameBackground));
            this.A03.A04();
            Integer num = this.A07;
            if (num != null) {
                this.A03.setToolbarActionMode(num.intValue());
            }
            if (this.A06.getColorInfo() != null) {
                this.A03.A06(this.A06.getColorInfo(), false);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.L8
    public final synchronized void ABA() {
        if (!this.A09) {
            this.A06.A09(A00(6, 9, 97));
        }
        A04();
    }

    @Override // com.facebook.ads.redexgen.X.L8
    public final synchronized void ACm(float f4) {
        MB mb;
        if (!this.A09 && (mb = this.A03) != null) {
            if (this.A01 == 1) {
                if (!this.A0A) {
                    this.A07 = Integer.valueOf(mb.getToolbarActionMode());
                    this.A03.setProgressClickListener(new View$OnClickListenerC0836Np(this));
                    this.A03.A05();
                    this.A03.setToolbarListener(new C0991To(this));
                    this.A0A = true;
                    Integer num = this.A07;
                    if (num == null || num.intValue() == 4) {
                        this.A03.setToolbarActionMode(5);
                    } else {
                        this.A03.setToolbarActionMode(6);
                    }
                }
                if (f4 <= this.A02) {
                    if (!this.A08) {
                        this.A08 = true;
                        Integer num2 = this.A07;
                        if (num2 == null || num2.intValue() == 4) {
                            this.A03.setToolbarActionMode(7);
                        } else {
                            this.A03.setProgressImage(EnumC0791Lw.CROSS);
                            this.A03.setToolbarActionMode(6);
                        }
                    }
                    this.A03.setToolbarActionMessage(this.A04.replace(A00(0, 6, 52), String.valueOf((int) Math.ceil(f4))));
                } else {
                    this.A03.setToolbarActionMessage(this.A05);
                }
            }
        }
    }
}
