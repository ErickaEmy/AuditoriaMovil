package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState;
import com.facebook.ads.internal.util.parcelable.WrappedParcelable;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Zo  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1142Zo extends AbstractC03824o implements AnonymousClass50 {
    public static byte[] A0F;
    public static String[] A0G = {"VKH6HNPW", "5SG7ZkmA1SrYT5HpW6e3lHPIEdQjCnoY", "GUFAcNFlkHbDslOxTlAKu2zM5da70L8W", "8EarDdUd0wjX", "ogiAdIZLqFL2ODTGKcli7xbzAuQZVFku", "k0c9canuweazyFazM74f3pFcokchiBr", "yJQv9VjGutzUoxdr6", "vBYUiSK7FkagYmvZS"};
    public int A00;
    public int A01;
    public int A02;
    public LinearLayoutManager$SavedState A03;
    public C4Y A04;
    public boolean A05;
    public int A06;
    public C4T A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final C4R A0D;
    public final C4S A0E;

    public static String A0T(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 118);
        }
        return new String(copyOfRange);
    }

    public static void A0V() {
        A0F = new byte[]{30, 25, 1, 22, 27, 30, 19, 87, 24, 5, 30, 18, 25, 3, 22, 3, 30, 24, 25, 77};
    }

    static {
        A0V();
    }

    public C1142Zo(Context context) {
        this(context, 1, false);
    }

    public C1142Zo(Context context, int i, boolean z2) {
        this.A0A = false;
        this.A05 = false;
        this.A0C = false;
        this.A0B = true;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A03 = null;
        this.A0D = new C4R(this);
        this.A0E = new C4S();
        this.A06 = 2;
        A2A(i);
        A0h(z2);
        A1R(true);
    }

    private final int A04(int i, C03894w c03894w, AnonymousClass53 anonymousClass53) {
        if (A0W() == 0 || i == 0) {
            return 0;
        }
        this.A07.A0B = true;
        A29();
        int absDy = i > 0 ? 1 : -1;
        int consumed = Math.abs(i);
        A0Y(absDy, consumed, true, anonymousClass53);
        int i5 = this.A07.A07;
        int layoutDirection = A08(c03894w, this.A07, anonymousClass53, false);
        int i6 = i5 + layoutDirection;
        if (i6 < 0) {
            return 0;
        }
        int absDy2 = consumed > i6 ? absDy * i6 : i;
        int layoutDirection2 = -absDy2;
        this.A04.A0J(layoutDirection2);
        this.A07.A04 = absDy2;
        return absDy2;
    }

    private int A05(int i, C03894w c03894w, AnonymousClass53 anonymousClass53, boolean z2) {
        int gap = this.A04.A07() - i;
        if (gap > 0) {
            int i5 = -A04(-gap, c03894w, anonymousClass53);
            int i6 = i + i5;
            if (z2) {
                int gap2 = this.A04.A07();
                if (A0G[0].length() == 7) {
                    throw new RuntimeException();
                }
                A0G[0] = "DiKLRwr5Jced9h1IWYQQBSe";
                int gap3 = gap2 - i6;
                if (gap3 > 0) {
                    this.A04.A0J(gap3);
                    return gap3 + i5;
                }
            }
            return i5;
        }
        return 0;
    }

    private int A06(int i, C03894w c03894w, AnonymousClass53 anonymousClass53, boolean z2) {
        int A0A;
        int gap = i - this.A04.A0A();
        if (gap > 0) {
            int i5 = -A04(gap, c03894w, anonymousClass53);
            int i6 = i + i5;
            if (z2 && (A0A = i6 - this.A04.A0A()) > 0) {
                this.A04.A0J(-A0A);
                return i5 - A0A;
            }
            return i5;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        r0 = r11.A00;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
        return r6 - r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int A08(com.facebook.ads.redexgen.X.C03894w r10, com.facebook.ads.redexgen.X.C4T r11, com.facebook.ads.redexgen.X.AnonymousClass53 r12, boolean r13) {
        /*
            r9 = this;
            int r6 = r11.A00
            int r0 = r11.A07
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r5) goto L16
            int r0 = r11.A00
            if (r0 >= 0) goto L13
            int r1 = r11.A07
            int r0 = r11.A00
            int r1 = r1 + r0
            r11.A07 = r1
        L13:
            r9.A0e(r10, r11)
        L16:
            int r4 = r11.A00
            int r0 = r11.A02
            int r4 = r4 + r0
            com.facebook.ads.redexgen.X.4S r3 = r9.A0E
        L1d:
            boolean r0 = r11.A09
            if (r0 != 0) goto L23
            if (r4 <= 0) goto L33
        L23:
            boolean r0 = r11.A05(r12)
            if (r0 == 0) goto L33
            r3.A00()
            r9.A2D(r10, r12, r11, r3)
            boolean r0 = r3.A01
            if (r0 == 0) goto L37
        L33:
            int r0 = r11.A00
            int r6 = r6 - r0
            return r6
        L37:
            int r2 = r11.A06
            int r1 = r3.A00
            int r0 = r11.A05
            int r1 = r1 * r0
            int r2 = r2 + r1
            r11.A06 = r2
            boolean r0 = r3.A03
            if (r0 == 0) goto L51
            com.facebook.ads.redexgen.X.4T r0 = r9.A07
            java.util.List<com.facebook.ads.redexgen.X.56> r0 = r0.A08
            if (r0 != 0) goto L51
            boolean r0 = r12.A07()
            if (r0 != 0) goto L5b
        L51:
            int r1 = r11.A00
            int r0 = r3.A00
            int r1 = r1 - r0
            r11.A00 = r1
            int r0 = r3.A00
            int r4 = r4 - r0
        L5b:
            int r0 = r11.A07
            if (r0 == r5) goto L87
            int r1 = r11.A07
            int r0 = r3.A00
            int r1 = r1 + r0
            r11.A07 = r1
            int r0 = r11.A00
            if (r0 >= 0) goto L84
            int r8 = r11.A07
            int r7 = r11.A00
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1142Zo.A0G
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 7
            if (r1 == r0) goto La1
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1142Zo.A0G
            java.lang.String r1 = "4Yaap7YPoeEmBfNVznjneaOXF1T3Chf"
            r0 = 5
            r2[r0] = r1
            int r8 = r8 + r7
            r11.A07 = r8
        L84:
            r9.A0e(r10, r11)
        L87:
            if (r13 == 0) goto L1d
            boolean r7 = r3.A02
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1142Zo.A0G
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 7
            if (r1 == r0) goto La1
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1142Zo.A0G
            java.lang.String r1 = "BoRZmQ3r1kYFEVrzuprqJgVQBsgHE2ov"
            r0 = 1
            r2[r0] = r1
            if (r7 == 0) goto L1d
            goto L33
        La1:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1142Zo.A08(com.facebook.ads.redexgen.X.4w, com.facebook.ads.redexgen.X.4T, com.facebook.ads.redexgen.X.53, boolean):int");
    }

    private int A09(AnonymousClass53 anonymousClass53) {
        if (A0W() != 0) {
            A29();
            return AnonymousClass57.A00(anonymousClass53, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B);
        } else if (A0G[5].length() != 31) {
            throw new RuntimeException();
        } else {
            A0G[5] = "JS1EmTokFkofHdCiZDqGUekHou375gK";
            return 0;
        }
    }

    private int A0A(AnonymousClass53 anonymousClass53) {
        if (A0W() == 0) {
            return 0;
        }
        A29();
        return AnonymousClass57.A02(anonymousClass53, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B, this.A05);
    }

    private int A0B(AnonymousClass53 anonymousClass53) {
        if (A0W() != 0) {
            A29();
            return AnonymousClass57.A01(anonymousClass53, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B);
        }
        String[] strArr = A0G;
        if (strArr[2].charAt(4) != strArr[4].charAt(4)) {
            String[] strArr2 = A0G;
            strArr2[2] = "SnDsIEYZVkVP365fclIsQ2wSHS1GnuqA";
            strArr2[4] = "cd1sjhoNq3y2dBxKlbos6To2J3BafTHs";
            return 0;
        }
        throw new RuntimeException();
    }

    private final int A0C(AnonymousClass53 anonymousClass53) {
        if (anonymousClass53.A06()) {
            return this.A04.A0B();
        }
        return 0;
    }

    private View A0D() {
        return A0H(0, A0W());
    }

    private View A0E() {
        return A0H(A0W() - 1, -1);
    }

    private View A0F() {
        return A0t(this.A05 ? 0 : A0W() - 1);
    }

    private View A0G() {
        return A0t(this.A05 ? A0W() - 1 : 0);
    }

    private final View A0H(int i, int i5) {
        int next;
        int acceptableBoundsFlag;
        int preferredBoundsFlag;
        A29();
        if (i5 > i) {
            next = 1;
        } else {
            next = i5 < i ? -1 : 0;
        }
        if (next == 0) {
            View A0t = A0t(i);
            String[] strArr = A0G;
            String str = strArr[6];
            String str2 = strArr[7];
            int length = str.length();
            int next2 = str2.length();
            if (length != next2) {
                throw new RuntimeException();
            }
            A0G[5] = "tEP4S10y6AtQbDA9ff3H424KLTnX0k7";
            return A0t;
        }
        int preferredBoundsFlag2 = this.A04.A0F(A0t(i));
        int next3 = this.A04.A0A();
        if (preferredBoundsFlag2 < next3) {
            acceptableBoundsFlag = 16644;
            preferredBoundsFlag = 16388;
        } else {
            acceptableBoundsFlag = 4161;
            preferredBoundsFlag = 4097;
        }
        int next4 = this.A00;
        if (next4 == 0) {
            return super.A04.A00(i, i5, acceptableBoundsFlag, preferredBoundsFlag);
        }
        return super.A05.A00(i, i5, acceptableBoundsFlag, preferredBoundsFlag);
    }

    private final View A0J(int i, int i5, boolean z2, boolean z3) {
        int i6;
        A29();
        int i8 = 0;
        if (z2) {
            i6 = 24579;
        } else {
            i6 = 320;
        }
        if (z3) {
            i8 = 320;
        }
        int i10 = this.A00;
        int acceptableBoundsFlag = A0G[1].charAt(30);
        if (acceptableBoundsFlag != 111) {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[2] = "NnwW0AnvRBQDKBAe7Vp9NN4SqY6y39Zg";
        strArr[4] = "snWQRfIRwdJNOSPMdDWVpUmegwlUrdsl";
        if (i10 == 0) {
            return super.A04.A00(i, i5, i6, i8);
        }
        return super.A05.A00(i, i5, i6, i8);
    }

    private View A0K(C03894w c03894w, AnonymousClass53 anonymousClass53) {
        return A28(c03894w, anonymousClass53, 0, A0W(), anonymousClass53.A03());
    }

    private View A0L(C03894w c03894w, AnonymousClass53 anonymousClass53) {
        return A28(c03894w, anonymousClass53, A0W() - 1, -1, anonymousClass53.A03());
    }

    private View A0M(C03894w c03894w, AnonymousClass53 anonymousClass53) {
        return this.A05 ? A0D() : A0E();
    }

    private View A0N(C03894w c03894w, AnonymousClass53 anonymousClass53) {
        return this.A05 ? A0E() : A0D();
    }

    private View A0O(C03894w c03894w, AnonymousClass53 anonymousClass53) {
        return this.A05 ? A0K(c03894w, anonymousClass53) : A0L(c03894w, anonymousClass53);
    }

    private View A0P(C03894w c03894w, AnonymousClass53 anonymousClass53) {
        return this.A05 ? A0L(c03894w, anonymousClass53) : A0K(c03894w, anonymousClass53);
    }

    private View A0Q(boolean z2, boolean z3) {
        if (this.A05) {
            return A0J(0, A0W(), z2, z3);
        }
        return A0J(A0W() - 1, -1, z2, z3);
    }

    private View A0R(boolean z2, boolean z3) {
        if (this.A05) {
            return A0J(A0W() - 1, -1, z2, z3);
        }
        return A0J(0, A0W(), z2, z3);
    }

    private final C4T A0S() {
        return new C4T();
    }

    private void A0U() {
        if (this.A00 == 1 || !A2F()) {
            this.A05 = this.A0A;
            return;
        }
        boolean z2 = !this.A0A;
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[6] = "rvopS3hSB7itRsuyG";
        strArr2[7] = "9RTUShXs4ZXrU4n03";
        this.A05 = z2;
    }

    private void A0W(int i, int i5) {
        this.A07.A00 = this.A04.A07() - i5;
        this.A07.A03 = this.A05 ? -1 : 1;
        this.A07.A01 = i;
        this.A07.A05 = 1;
        this.A07.A06 = i5;
        this.A07.A07 = Integer.MIN_VALUE;
    }

    private void A0X(int i, int i5) {
        this.A07.A00 = i5 - this.A04.A0A();
        this.A07.A01 = i;
        this.A07.A03 = this.A05 ? 1 : -1;
        this.A07.A05 = -1;
        this.A07.A06 = i5;
        this.A07.A07 = Integer.MIN_VALUE;
    }

    private void A0Y(int i, int i5, boolean z2, AnonymousClass53 anonymousClass53) {
        int A0A;
        this.A07.A09 = A0i();
        this.A07.A02 = A0C(anonymousClass53);
        this.A07.A05 = i;
        if (i == 1) {
            this.A07.A02 += this.A04.A08();
            View A0F2 = A0F();
            C4T c4t = this.A07;
            if (!this.A05) {
                r4 = 1;
            }
            c4t.A03 = r4;
            this.A07.A01 = A0p(A0F2) + this.A07.A03;
            this.A07.A06 = this.A04.A0C(A0F2);
            A0A = this.A04.A0C(A0F2) - this.A04.A07();
        } else {
            View A0G2 = A0G();
            this.A07.A02 += this.A04.A0A();
            this.A07.A03 = this.A05 ? 1 : -1;
            this.A07.A01 = A0p(A0G2) + this.A07.A03;
            this.A07.A06 = this.A04.A0F(A0G2);
            A0A = (-this.A04.A0F(A0G2)) + this.A04.A0A();
        }
        this.A07.A00 = i5;
        if (z2) {
            C4T c4t2 = this.A07;
            int scrollingOffset = c4t2.A00;
            c4t2.A00 = scrollingOffset - A0A;
        }
        this.A07.A07 = A0A;
        if (A0G[0].length() == 7) {
            throw new RuntimeException();
        }
        A0G[1] = "rmKnvh8FAT7bzRdUkYGsCRYa1fX1DRoz";
    }

    private void A0Z(C4R c4r) {
        A0W(c4r.A01, c4r.A00);
    }

    private void A0a(C4R c4r) {
        A0X(c4r.A01, c4r.A00);
    }

    private void A0b(C03894w c03894w, int i) {
        int A0W = A0W();
        if (i < 0) {
            return;
        }
        int A06 = this.A04.A06() - i;
        if (this.A05) {
            for (int i5 = 0; i5 < A0W; i5++) {
                View A0t = A0t(i5);
                int childCount = this.A04.A0F(A0t);
                if (childCount >= A06) {
                    int childCount2 = this.A04.A0H(A0t);
                    if (childCount2 >= A06) {
                    }
                }
                A0d(c03894w, 0, i5);
                return;
            }
            return;
        }
        for (int i6 = A0W - 1; i6 >= 0; i6--) {
            View A0t2 = A0t(i6);
            int childCount3 = this.A04.A0F(A0t2);
            if (childCount3 >= A06) {
                int childCount4 = this.A04.A0H(A0t2);
                if (childCount4 >= A06) {
                }
            }
            int childCount5 = A0W - 1;
            A0d(c03894w, childCount5, i6);
            return;
        }
    }

    private void A0c(C03894w c03894w, int i) {
        if (i < 0) {
            return;
        }
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        A0G[0] = "66";
        int A0W = A0W();
        if (this.A05) {
            for (int i5 = A0W - 1; i5 >= 0; i5--) {
                View A0t = A0t(i5);
                int limit = this.A04.A0C(A0t);
                if (limit <= i) {
                    C4Y c4y = this.A04;
                    String[] strArr2 = A0G;
                    String str = strArr2[6];
                    String str2 = strArr2[7];
                    int childCount = str.length();
                    int limit2 = str2.length();
                    if (childCount != limit2) {
                        int limit3 = c4y.A0G(A0t);
                        if (limit3 <= i) {
                        }
                    } else {
                        A0G[3] = "uDZbJl3GZvnd0";
                        int limit4 = c4y.A0G(A0t);
                        if (limit4 <= i) {
                        }
                    }
                }
                int limit5 = A0W - 1;
                A0d(c03894w, limit5, i5);
                return;
            }
            return;
        }
        for (int i6 = 0; i6 < A0W; i6++) {
            View A0t2 = A0t(i6);
            int A0C = this.A04.A0C(A0t2);
            int childCount2 = A0G[3].length();
            if (childCount2 == 28) {
                throw new RuntimeException();
            }
            A0G[1] = "ET87P0AumYMcjI6vylu4qFXoEmTHeXod";
            if (A0C <= i) {
                int limit6 = this.A04.A0G(A0t2);
                if (limit6 <= i) {
                }
            }
            A0d(c03894w, 0, i6);
            return;
        }
    }

    private void A0d(C03894w c03894w, int i, int i5) {
        if (i == i5) {
            return;
        }
        if (i5 > i) {
            for (int i6 = i5 - 1; i6 >= i; i6--) {
                A14(i6, c03894w);
            }
            return;
        }
        while (i > i5) {
            A14(i, c03894w);
            i--;
        }
    }

    private void A0e(C03894w c03894w, C4T c4t) {
        if (!c4t.A0B || c4t.A09) {
            return;
        }
        int i = c4t.A05;
        String[] strArr = A0G;
        if (strArr[6].length() == strArr[7].length()) {
            String[] strArr2 = A0G;
            strArr2[2] = "M7iaeQoExhHh03f7x1XNzmreS2Lq1zJK";
            strArr2[4] = "3weclwG7n9RXAySrMV3Jn51LrKgutG4n";
            if (i == -1) {
                int i5 = c4t.A07;
                if (A0G[1].charAt(30) == 'o') {
                    A0G[3] = "CiNTyTfZO3PW6tP";
                    A0b(c03894w, i5);
                    return;
                }
            } else {
                A0c(c03894w, c4t.A07);
                return;
            }
        }
        throw new RuntimeException();
    }

    private void A0f(C03894w c03894w, AnonymousClass53 anonymousClass53, int scrapExtraEnd, int scrapExtraEnd2) {
        if (!anonymousClass53.A08() || A0W() == 0 || anonymousClass53.A07() || !A22()) {
            return;
        }
        int i = 0;
        int scrapExtraStart = 0;
        List<AnonymousClass56> A0J = c03894w.A0J();
        int i5 = A0J.size();
        int A0p = A0p(A0t(0));
        for (int scrapSize = 0; scrapSize < i5; scrapSize++) {
            AnonymousClass56 anonymousClass56 = A0J.get(scrapSize);
            if (!anonymousClass56.A0a()) {
                int direction = 1;
                if ((anonymousClass56.A0I() < A0p) != this.A05) {
                    direction = -1;
                }
                if (direction == -1) {
                    i += this.A04.A0D(anonymousClass56.A0H);
                } else {
                    scrapExtraStart += this.A04.A0D(anonymousClass56.A0H);
                }
            }
        }
        this.A07.A08 = A0J;
        if (i > 0) {
            A0X(A0p(A0G()), scrapExtraEnd);
            this.A07.A02 = i;
            this.A07.A00 = 0;
            this.A07.A04();
            A08(c03894w, this.A07, anonymousClass53, false);
        }
        if (scrapExtraStart > 0) {
            A0W(A0p(A0F()), scrapExtraEnd2);
            this.A07.A02 = scrapExtraStart;
            this.A07.A00 = 0;
            this.A07.A04();
            A08(c03894w, this.A07, anonymousClass53, false);
        }
        this.A07.A08 = null;
    }

    private void A0g(C03894w c03894w, AnonymousClass53 anonymousClass53, C4R c4r) {
        if (A0k(anonymousClass53, c4r)) {
            return;
        }
        boolean A0j = A0j(c03894w, anonymousClass53, c4r);
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        A0G[3] = "XDJ2jDWhUW9a7iN";
        if (A0j) {
            return;
        }
        c4r.A02();
        c4r.A01 = this.A0C ? anonymousClass53.A03() - 1 : 0;
    }

    private final void A0h(boolean z2) {
        A1y(null);
        if (z2 == this.A0A) {
            return;
        }
        this.A0A = z2;
        A0y();
    }

    private final boolean A0i() {
        return this.A04.A09() == 0 && this.A04.A06() == 0;
    }

    private boolean A0j(C03894w c03894w, AnonymousClass53 anonymousClass53, C4R c4r) {
        View A0P;
        int A0A;
        boolean z2 = false;
        if (A0W() == 0) {
            return false;
        }
        View A0s = A0s();
        if (A0s != null && c4r.A06(A0s, anonymousClass53)) {
            c4r.A05(A0s);
            return true;
        } else if (this.A08 != this.A0C) {
            return false;
        } else {
            if (c4r.A02) {
                A0P = A0O(c03894w, anonymousClass53);
            } else {
                A0P = A0P(c03894w, anonymousClass53);
            }
            if (A0P != null) {
                c4r.A04(A0P);
                if (!anonymousClass53.A07() && A22()) {
                    if ((this.A04.A0F(A0P) >= this.A04.A07() || this.A04.A0C(A0P) < this.A04.A0A()) ? true : true) {
                        if (c4r.A02) {
                            A0A = this.A04.A07();
                        } else {
                            A0A = this.A04.A0A();
                        }
                        c4r.A00 = A0A;
                    }
                }
                return true;
            }
            return false;
        }
    }

    private boolean A0k(AnonymousClass53 anonymousClass53, C4R c4r) {
        int i;
        int startGap;
        if (anonymousClass53.A07() || (i = this.A01) == -1) {
            return false;
        }
        if (i < 0 || i >= anonymousClass53.A03()) {
            this.A01 = -1;
            this.A02 = Integer.MIN_VALUE;
            return false;
        }
        c4r.A01 = this.A01;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState == null || !linearLayoutManager$SavedState.A01()) {
            if (this.A02 == Integer.MIN_VALUE) {
                View A1m = A1m(this.A01);
                if (A1m != null) {
                    if (this.A04.A0D(A1m) > this.A04.A0B()) {
                        c4r.A02();
                        return true;
                    } else if (this.A04.A0F(A1m) - this.A04.A0A() < 0) {
                        c4r.A00 = this.A04.A0A();
                        c4r.A02 = false;
                        return true;
                    } else {
                        int endGap = this.A04.A07() - this.A04.A0C(A1m);
                        if (endGap < 0) {
                            c4r.A00 = this.A04.A07();
                            c4r.A02 = true;
                            return true;
                        }
                        if (c4r.A02) {
                            int startGap2 = this.A04.A0C(A1m);
                            C4Y c4y = this.A04;
                            String[] strArr = A0G;
                            String str = strArr[2];
                            String str2 = strArr[4];
                            int endGap2 = str.charAt(4);
                            if (endGap2 == str2.charAt(4)) {
                                throw new RuntimeException();
                            }
                            A0G[3] = "ZbIhQvVoqDIGDPkO0OlvW9zioDplzu";
                            startGap = startGap2 + c4y.A05();
                        } else {
                            startGap = this.A04.A0F(A1m);
                        }
                        c4r.A00 = startGap;
                    }
                } else {
                    if (A0W() > 0) {
                        View child = A0t(0);
                        boolean z2 = this.A01 < A0p(child);
                        boolean z3 = this.A05;
                        if (A0G[1].charAt(30) != 'o') {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A0G;
                        strArr2[2] = "1tNDA9T9nSDYektAgKE77gOe81bMFJSk";
                        strArr2[4] = "TZYqXNdWGZVKxzfIQyf7YZEk7yb7IRTm";
                        c4r.A02 = z2 == z3;
                    }
                    c4r.A02();
                }
                return true;
            }
            c4r.A02 = this.A05;
            if (this.A05) {
                c4r.A00 = this.A04.A07() - this.A02;
            } else {
                c4r.A00 = this.A04.A0A() + this.A02;
            }
            return true;
        }
        c4r.A02 = this.A03.A02;
        if (c4r.A02) {
            c4r.A00 = this.A04.A07() - this.A03.A00;
        } else {
            c4r.A00 = this.A04.A0A() + this.A03.A00;
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public int A1d(int i, C03894w c03894w, AnonymousClass53 anonymousClass53) {
        if (this.A00 == 1) {
            return 0;
        }
        return A04(i, c03894w, anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public int A1e(int i, C03894w c03894w, AnonymousClass53 anonymousClass53) {
        if (this.A00 == 0) {
            return 0;
        }
        int A04 = A04(i, c03894w, anonymousClass53);
        String[] strArr = A0G;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A0G[3] = "CDnF1shpb";
        return A04;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final int A1f(AnonymousClass53 anonymousClass53) {
        return A09(anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final int A1g(AnonymousClass53 anonymousClass53) {
        return A0A(anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final int A1h(AnonymousClass53 anonymousClass53) {
        return A0B(anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final int A1i(AnonymousClass53 anonymousClass53) {
        return A09(anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final int A1j(AnonymousClass53 anonymousClass53) {
        return A0A(anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final int A1k(AnonymousClass53 anonymousClass53) {
        return A0B(anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final Parcelable A1l() {
        if (this.A03 != null) {
            return new WrappedParcelable(new LinearLayoutManager$SavedState(this.A03));
        }
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = new LinearLayoutManager$SavedState();
        if (A0W() > 0) {
            A29();
            boolean didLayoutFromEnd = this.A08 ^ this.A05;
            linearLayoutManager$SavedState.A02 = didLayoutFromEnd;
            if (didLayoutFromEnd) {
                View refChild = A0F();
                linearLayoutManager$SavedState.A00 = this.A04.A07() - this.A04.A0C(refChild);
                linearLayoutManager$SavedState.A01 = A0p(refChild);
            } else {
                View A0G2 = A0G();
                linearLayoutManager$SavedState.A01 = A0p(A0G2);
                linearLayoutManager$SavedState.A00 = this.A04.A0F(A0G2) - this.A04.A0A();
            }
        } else {
            linearLayoutManager$SavedState.A00();
        }
        return new WrappedParcelable(linearLayoutManager$SavedState);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final View A1m(int i) {
        int firstChild = A0W();
        if (firstChild == 0) {
            return null;
        }
        int childCount = i - A0p(A0t(0));
        if (childCount >= 0 && childCount < firstChild) {
            View A0t = A0t(childCount);
            if (A0p(A0t) == i) {
                return A0t;
            }
        }
        return super.A1m(i);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public View A1n(View view, int i, C03894w c03894w, AnonymousClass53 anonymousClass53) {
        int A27;
        View A0M;
        View nextCandidate;
        A0U();
        if (A0W() == 0 || (A27 = A27(i)) == Integer.MIN_VALUE) {
            return null;
        }
        A29();
        A29();
        int layoutDir = this.A04.A0B();
        A0Y(A27, (int) (layoutDir * 0.33333334f), false, anonymousClass53);
        this.A07.A07 = Integer.MIN_VALUE;
        this.A07.A0B = false;
        A08(c03894w, this.A07, anonymousClass53, true);
        if (A27 == -1) {
            A0M = A0N(c03894w, anonymousClass53);
        } else {
            A0M = A0M(c03894w, anonymousClass53);
        }
        if (A27 == -1) {
            nextCandidate = A0G();
        } else {
            nextCandidate = A0F();
        }
        boolean hasFocusable = nextCandidate.hasFocusable();
        if (A0G[0].length() != 7) {
            String[] strArr = A0G;
            strArr[2] = "JGtMOr7ZHjmwUVfbInfaZmEhr0nxGN38";
            strArr[4] = "jCrgpf8bwQbyd1C9u6FfAt5OnK6gBhSa";
            if (hasFocusable) {
                if (A0M == null) {
                    return null;
                }
                return nextCandidate;
            }
            return A0M;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public C03834p A1o() {
        return new C03834p(-2, -2);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public void A1p(int i) {
        this.A01 = i;
        this.A02 = Integer.MIN_VALUE;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.A00();
        }
        A0y();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final void A1q(int i, int i5, AnonymousClass53 anonymousClass53, InterfaceC03804m interfaceC03804m) {
        if (this.A00 != 0) {
            i = i5;
        }
        int delta = A0W();
        if (delta == 0 || i == 0) {
            return;
        }
        A29();
        int i6 = i > 0 ? 1 : -1;
        int delta2 = Math.abs(i);
        A0Y(i6, delta2, true, anonymousClass53);
        A2E(anonymousClass53, this.A07, interfaceC03804m);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final void A1r(int i, InterfaceC03804m interfaceC03804m) {
        boolean z2;
        int direction;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null && linearLayoutManager$SavedState.A01()) {
            z2 = this.A03.A02;
            direction = this.A03.A01;
        } else {
            A0U();
            z2 = this.A05;
            int i5 = this.A01;
            String[] strArr = A0G;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A0G[1] = "j12HxmlCdcFNOCf90EDMVBFIs8rsuaoM";
            if (i5 == -1) {
                direction = z2 ? i - 1 : 0;
            } else {
                direction = this.A01;
            }
        }
        int i6 = z2 ? -1 : 1;
        for (int i8 = 0; i8 < this.A06 && direction >= 0 && direction < i; i8++) {
            interfaceC03804m.A3S(direction, 0);
            direction += i6;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final void A1s(Parcelable parcelable) {
        if (!(parcelable instanceof WrappedParcelable)) {
            return;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        if (A0G[1].charAt(30) == 'o') {
            A0G[1] = "tHEWx5U9TGfOm0s3U2zrO5nR7UMaVIoI";
            if (classLoader == null) {
                return;
            }
            if (A0G[5].length() == 31) {
                A0G[3] = "tm";
                Parcelable state = ((WrappedParcelable) parcelable).unwrap(classLoader);
                if (state instanceof LinearLayoutManager$SavedState) {
                    this.A03 = (LinearLayoutManager$SavedState) state;
                    A0y();
                    return;
                }
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final void A1t(AccessibilityEvent accessibilityEvent) {
        super.A1t(accessibilityEvent);
        if (A0W() > 0) {
            accessibilityEvent.setFromIndex(A24());
            int A25 = A25();
            if (A0G[3].length() == 28) {
                throw new RuntimeException();
            }
            A0G[3] = "9E5bhv9RVKulu";
            accessibilityEvent.setToIndex(A25);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a6, code lost:
        if (r3 != (-1)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
        if (r9.A02 == Integer.MIN_VALUE) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ae, code lost:
        r1 = A1m(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b2, code lost:
        if (r1 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (r9.A05 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b8, code lost:
        r3 = r9.A04.A07() - r9.A04.A0C(r1);
        r2 = com.facebook.ads.redexgen.X.C1142Zo.A0G;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d6, code lost:
        if (r2[2].charAt(4) == r2[4].charAt(4)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d8, code lost:
        com.facebook.ads.redexgen.X.C1142Zo.A0G[5] = "r3FnQil1r32czyLALUutLd0XCkxYZ4G";
        r3 = r3 - r9.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e2, code lost:
        if (r3 <= 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e4, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0208, code lost:
        r5 = r5 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x020b, code lost:
        r2 = com.facebook.ads.redexgen.X.C1142Zo.A0G;
        r2[2] = "sdmiyO1ExKOYMO2wbr6XNnW0K6t4WoaH";
        r2[4] = "ty9AfnxQn4ghzZPCSImQPyrccPhuEwJu";
        r3 = r3 - r9.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x021c, code lost:
        r3 = r9.A02 - (r9.A04.A0F(r1) - r9.A04.A0A());
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x023a, code lost:
        if (r3 != (-1)) goto L26;
     */
    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A1u(com.facebook.ads.redexgen.X.C03894w r10, com.facebook.ads.redexgen.X.AnonymousClass53 r11) {
        /*
            Method dump skipped, instructions count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1142Zo.A1u(com.facebook.ads.redexgen.X.4w, com.facebook.ads.redexgen.X.53):void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public void A1v(AnonymousClass53 anonymousClass53) {
        super.A1v(anonymousClass53);
        this.A03 = null;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A0D.A03();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final void A1w(C0599Eb c0599Eb, C03894w c03894w) {
        super.A1w(c0599Eb, c03894w);
        if (this.A09) {
            A1I(c03894w);
            c03894w.A0P();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public void A1x(C0599Eb c0599Eb, AnonymousClass53 anonymousClass53, int i) {
        C1141Zn linearSmoothScroller = new C1141Zn(c0599Eb.getContext());
        linearSmoothScroller.A0A(i);
        A1L(linearSmoothScroller);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final void A1y(String str) {
        if (this.A03 == null) {
            super.A1y(str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final boolean A1z() {
        if (A0Y() != 1073741824 && A0i() != 1073741824) {
            boolean A1S = A1S();
            if (A0G[0].length() == 7) {
                throw new RuntimeException();
            }
            A0G[0] = "ZYU5Lu8KJdo1W8";
            if (A1S) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final boolean A20() {
        return this.A00 == 0;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final boolean A21() {
        return this.A00 == 1;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public boolean A22() {
        return this.A03 == null && this.A08 == this.A0C;
    }

    public final int A23() {
        View child = A0J(0, A0W(), true, false);
        if (child == null) {
            return -1;
        }
        return A0p(child);
    }

    public final int A24() {
        View child = A0J(0, A0W(), false, true);
        if (child == null) {
            return -1;
        }
        return A0p(child);
    }

    public final int A25() {
        View child = A0J(A0W() - 1, -1, false, true);
        if (child == null) {
            return -1;
        }
        return A0p(child);
    }

    public final int A26() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0061, code lost:
        if (r4 == 1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
        if (r4 == 1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0072, code lost:
        if (A2F() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0074, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0075, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A27(int r8) {
        /*
            r7 = this;
            r6 = -1
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1
            switch(r8) {
                case 1: goto L4d;
                case 2: goto L40;
                case 17: goto L38;
                case 33: goto L30;
                case 66: goto L2a;
                case 130: goto L8;
                default: goto L7;
            }
        L7:
            return r5
        L8:
            int r4 = r7.A00
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1142Zo.A0G
            r0 = 1
            r1 = r1[r0]
            r0 = 30
            char r1 = r1.charAt(r0)
            r0 = 111(0x6f, float:1.56E-43)
            if (r1 == r0) goto L1f
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1f:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1142Zo.A0G
            java.lang.String r1 = "6DQtaB3lJkGKNvmH8s9QQc68TsOBLDE"
            r0 = 3
            r2[r0] = r1
            if (r4 != r3) goto L29
            r5 = 1
        L29:
            return r5
        L2a:
            int r0 = r7.A00
            if (r0 != 0) goto L2f
            r5 = 1
        L2f:
            return r5
        L30:
            int r0 = r7.A00
            if (r0 != r3) goto L35
        L34:
            return r6
        L35:
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L34
        L38:
            int r0 = r7.A00
            if (r0 != 0) goto L3d
        L3c:
            return r6
        L3d:
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L3c
        L40:
            int r0 = r7.A00
            if (r0 != r3) goto L45
            return r3
        L45:
            boolean r0 = r7.A2F()
            if (r0 == 0) goto L4c
            return r6
        L4c:
            return r3
        L4d:
            int r4 = r7.A00
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1142Zo.A0G
            r0 = 6
            r1 = r2[r0]
            r0 = 7
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L64
            if (r4 != r3) goto L6e
        L63:
            return r6
        L64:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1142Zo.A0G
            java.lang.String r1 = "tdW2fzf"
            r0 = 3
            r2[r0] = r1
            if (r4 != r3) goto L6e
            goto L63
        L6e:
            boolean r0 = r7.A2F()
            if (r0 == 0) goto L75
            return r3
        L75:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1142Zo.A27(int):int");
    }

    public View A28(C03894w c03894w, AnonymousClass53 anonymousClass53, int i, int i5, int i6) {
        A29();
        View view = null;
        View view2 = null;
        int A0A = this.A04.A0A();
        int boundsEnd = this.A04.A07();
        int boundsStart = i5 > i ? 1 : -1;
        while (i != i5) {
            View outOfBoundsMatch = A0t(i);
            int A0p = A0p(outOfBoundsMatch);
            if (A0p >= 0 && A0p < i6) {
                if (((C03834p) outOfBoundsMatch.getLayoutParams()).A02()) {
                    if (view == null) {
                        view = outOfBoundsMatch;
                    }
                } else if (this.A04.A0F(outOfBoundsMatch) >= boundsEnd || this.A04.A0C(outOfBoundsMatch) < A0A) {
                    if (view2 == null) {
                        view2 = outOfBoundsMatch;
                    }
                } else {
                    return outOfBoundsMatch;
                }
            }
            i += boundsStart;
        }
        return view2 != null ? view2 : view;
    }

    public final void A29() {
        if (this.A07 == null) {
            this.A07 = A0S();
        }
        if (this.A04 == null) {
            this.A04 = C4Y.A02(this, this.A00);
        }
    }

    public final void A2A(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(A0T(0, 20, 1) + i);
        }
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        A0G[1] = "wMuOUB68W5cmyVCUMue198JFnL9Wkeot";
        A1y(null);
        if (i == this.A00) {
            return;
        }
        this.A00 = i;
        this.A04 = null;
        A0y();
    }

    public final void A2B(int i, int i5) {
        this.A01 = i;
        this.A02 = i5;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.A00();
        }
        A0y();
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        A0G[3] = "tDl3kZGUKMTs";
    }

    public void A2C(C03894w c03894w, AnonymousClass53 anonymousClass53, C4R c4r, int i) {
    }

    public void A2D(C03894w c03894w, AnonymousClass53 anonymousClass53, C4T c4t, C4S c4s) {
        int A0g;
        int right;
        int i;
        int i5;
        View A03 = c4t.A03(c03894w);
        if (A03 == null) {
            c4s.A01 = true;
            return;
        }
        C03834p c03834p = (C03834p) A03.getLayoutParams();
        if (c4t.A08 == null) {
            boolean z2 = this.A05;
            int bottom = c4t.A05 == -1 ? 1 : 0;
            if (z2 == bottom) {
                A17(A03);
            } else {
                A19(A03, 0);
            }
        } else {
            boolean z3 = this.A05;
            int bottom2 = c4t.A05;
            int bottom3 = bottom2 == -1 ? 1 : 0;
            if (z3 == bottom3) {
                A16(A03);
            } else {
                A18(A03, 0);
            }
        }
        A1A(A03, 0, 0);
        c4s.A00 = this.A04.A0D(A03);
        if (this.A00 == 1) {
            if (A2F()) {
                i5 = A0h() - A0f();
                i = i5 - this.A04.A0E(A03);
            } else {
                i = A0e();
                i5 = this.A04.A0E(A03) + i;
            }
            if (c4t.A05 == -1) {
                right = c4t.A06;
                A0g = c4t.A06 - c4s.A00;
            } else {
                A0g = c4t.A06;
                right = c4t.A06 + c4s.A00;
            }
        } else {
            A0g = A0g();
            right = this.A04.A0E(A03) + A0g;
            int bottom4 = c4t.A05;
            if (bottom4 == -1) {
                i5 = c4t.A06;
                int i6 = c4t.A06;
                int bottom5 = c4s.A00;
                i = i6 - bottom5;
            } else {
                i = c4t.A06;
                int i8 = c4t.A06;
                int bottom6 = c4s.A00;
                i5 = i8 + bottom6;
            }
        }
        A1B(A03, i, A0g, i5, right);
        if (c03834p.A02() || c03834p.A01()) {
            c4s.A03 = true;
        }
        c4s.A02 = A03.hasFocusable();
    }

    public void A2E(AnonymousClass53 anonymousClass53, C4T c4t, InterfaceC03804m interfaceC03804m) {
        int i = c4t.A01;
        if (i >= 0) {
            int pos = anonymousClass53.A03();
            if (i < pos) {
                int pos2 = c4t.A07;
                interfaceC03804m.A3S(i, Math.max(0, pos2));
            }
        }
    }

    public final boolean A2F() {
        return A0a() == 1;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final PointF A4O(int i) {
        if (A0W() == 0) {
            return null;
        }
        int firstChildPos = i < A0p(A0t(0)) ? 1 : 0;
        int i5 = firstChildPos != this.A05 ? -1 : 1;
        int i6 = this.A00;
        int firstChildPos2 = A0G[0].length();
        if (firstChildPos2 != 7) {
            A0G[5] = "5EjIyJt0kzQOvAP28HqeuGPqaebz9kN";
            if (i6 == 0) {
                return new PointF(i5, 0.0f);
            }
            return new PointF(0.0f, i5);
        }
        throw new RuntimeException();
    }
}
