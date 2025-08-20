package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class CD implements WP, InterfaceC0556Bu, H6<WT>, H9, FA {
    public static byte[] A0c;
    public static String[] A0d = {"uM3", "HhtEoeszujhq2hqW803X6wAUFNr2yIvk", "llgRlYE2HHrDKVr9Tlv1gg4sawaKL", "gd26Zevc0BeMQVnsPvgEWj4kMHitbDqE", "B56DgxYfwXnRdFUWoxgY8ZwWxUmrPQlR", "o6X9hbG4Io42IRbcZylLcsRNIhbJFPRA", "SBfu1SOz9uKNnyoy8", "5PtJb97AhuhjIJJCziWFyl83Esr9CMYA"};
    public int A00;
    public int A01;
    public int A02;
    public long A04;
    public C1 A07;
    public WQ A08;
    public TrackGroupArray A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean[] A0L;
    public boolean[] A0M;
    public boolean[] A0N;
    public final int A0O;
    public final long A0P;
    public final Uri A0Q;
    public final C0608Ek A0S;
    public final InterfaceC0609El A0T;
    public final F1 A0U;
    public final InterfaceC0659Gm A0V;
    public final InterfaceC0667Gu A0W;
    public final String A0b;
    public final C1044Vq A0X = new C1044Vq(A07(0, 27, 27));
    public final C0678Hg A0Y = new C0678Hg();
    public final Runnable A0Z = new RunnableC0606Ei(this);
    public final Runnable A0a = new RunnableC0607Ej(this);
    public final Handler A0R = new Handler();
    public int[] A0J = new int[0];
    public WO[] A0K = new WO[0];
    public long A06 = -9223372036854775807L;
    public long A05 = -1;
    public long A03 = -9223372036854775807L;

    public static String A07(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0c, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 25);
        }
        return new String(copyOfRange);
    }

    public static void A0B() {
        A0c = new byte[]{78, 109, 99, 102, 103, 112, 56, 71, 122, 118, 112, 99, 97, 118, 109, 112, 79, 103, 102, 107, 99, 82, 103, 112, 107, 109, 102};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.WP
    public final long AFm(InterfaceC0653Gg[] interfaceC0653GgArr, boolean[] zArr, FB[] fbArr, boolean[] zArr2, long j2) {
        int i;
        AbstractC0672Ha.A04(this.A0F);
        int i5 = this.A01;
        int i6 = 0;
        while (true) {
            int i8 = 0;
            if (i6 >= interfaceC0653GgArr.length) {
                boolean z2 = !this.A0I ? j2 == 0 : i5 != 0;
                for (int i10 = 0; i10 < interfaceC0653GgArr.length; i10++) {
                    if (fbArr[i10] == null && interfaceC0653GgArr[i10] != null) {
                        InterfaceC0653Gg interfaceC0653Gg = interfaceC0653GgArr[i10];
                        AbstractC0672Ha.A04(interfaceC0653Gg.length() == 1);
                        AbstractC0672Ha.A04(interfaceC0653Gg.A7C(0) == 0);
                        int A00 = this.A09.A00(interfaceC0653Gg.A8A());
                        AbstractC0672Ha.A04(!this.A0L[A00]);
                        this.A01++;
                        this.A0L[A00] = true;
                        fbArr[i10] = new WS(this, A00);
                        zArr2[i10] = true;
                        if (!z2) {
                            WO wo = this.A0K[A00];
                            wo.A0J();
                            z2 = wo.A0D(j2, true, true) == -1 && wo.A0B() != 0;
                        }
                    }
                }
                if (this.A01 == 0) {
                    this.A0E = false;
                    this.A0D = false;
                    if (this.A0X.A08()) {
                        WO[] woArr = this.A0K;
                        int length = woArr.length;
                        while (i8 < length) {
                            woArr[i8].A0H();
                            i8++;
                        }
                        this.A0X.A05();
                    } else {
                        WO[] woArr2 = this.A0K;
                        int length2 = woArr2.length;
                        while (i8 < length2) {
                            woArr2[i8].A0I();
                            i8++;
                        }
                    }
                } else if (z2) {
                    j2 = AFl(j2);
                    for (int i11 = 0; i11 < fbArr.length; i11++) {
                        if (fbArr[i11] != null) {
                            zArr2[i11] = true;
                        }
                    }
                }
                this.A0I = true;
                return j2;
            }
            FB fb2 = fbArr[i6];
            String[] strArr = A0d;
            if (strArr[4].charAt(19) == strArr[5].charAt(19)) {
                throw new RuntimeException();
            }
            A0d[2] = "mg4ta7ka0nUwB4FGZ9fOP";
            if (fb2 != null && (interfaceC0653GgArr[i6] == null || !zArr[i6])) {
                i = ((WS) fbArr[i6]).A00;
                AbstractC0672Ha.A04(this.A0L[i]);
                this.A01--;
                this.A0L[i] = false;
                fbArr[i6] = null;
            }
            i6++;
        }
    }

    static {
        A0B();
    }

    public CD(Uri uri, InterfaceC0667Gu interfaceC0667Gu, InterfaceC0554Bs[] interfaceC0554BsArr, int i, F1 f12, InterfaceC0609El interfaceC0609El, InterfaceC0659Gm interfaceC0659Gm, String str, int i5) {
        this.A0Q = uri;
        this.A0W = interfaceC0667Gu;
        this.A0O = i;
        this.A0U = f12;
        this.A0T = interfaceC0609El;
        this.A0V = interfaceC0659Gm;
        this.A0b = str;
        this.A0P = i5;
        this.A0S = new C0608Ek(interfaceC0554BsArr, this);
        this.A00 = i == -1 ? 3 : i;
        f12.A03();
    }

    private int A00() {
        int i = 0;
        for (WO wo : this.A0K) {
            int extractedSamplesCount = wo.A0C();
            i += extractedSamplesCount;
        }
        return i;
    }

    @Override // com.facebook.ads.redexgen.X.H6
    /* renamed from: A01 */
    public final int AC2(WT wt, long j2, long j4, IOException iOException) {
        C0671Gy c0671Gy;
        long j6;
        long j7;
        boolean isErrorFatal = A0N(iOException);
        F1 f12 = this.A0U;
        c0671Gy = wt.A03;
        j6 = wt.A02;
        long j8 = this.A03;
        j7 = wt.A00;
        f12.A0H(c0671Gy, 1, -1, null, 0, null, j6, j8, j2, j4, j7, iOException, isErrorFatal);
        A0E(wt);
        if (isErrorFatal) {
            return 3;
        }
        int A00 = A00();
        boolean madeProgress = A00 > this.A02;
        if (A0L(wt, A00)) {
            return madeProgress ? 1 : 0;
        }
        return 2;
    }

    private long A02() {
        long j2 = Long.MIN_VALUE;
        for (WO wo : this.A0K) {
            long largestQueuedTimestampUs = wo.A0F();
            j2 = Math.max(j2, largestQueuedTimestampUs);
        }
        return j2;
    }

    public void A09() {
        if (this.A0G || this.A0F || this.A07 == null || !this.A0H) {
            return;
        }
        for (WO wo : this.A0K) {
            if (wo.A0G() == null) {
                return;
            }
        }
        this.A0Y.A01();
        int length = this.A0K.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        this.A0N = new boolean[length];
        this.A0L = new boolean[length];
        this.A0M = new boolean[length];
        this.A03 = this.A07.A6r();
        int i = 0;
        while (true) {
            boolean isAudioVideo = true;
            if (i >= length) {
                break;
            }
            Format A0G = this.A0K[i].A0G();
            trackGroupArr[i] = new TrackGroup(A0G);
            String str = A0G.A0O;
            if (!AbstractC0690Hs.A0B(str) && !AbstractC0690Hs.A09(str)) {
                isAudioVideo = false;
            }
            this.A0N[i] = isAudioVideo;
            this.A0A |= isAudioVideo;
            i++;
        }
        this.A09 = new TrackGroupArray(trackGroupArr);
        if (this.A0O == -1) {
            int trackCount = (this.A05 > (-1L) ? 1 : (this.A05 == (-1L) ? 0 : -1));
            if (trackCount == 0) {
                int trackCount2 = (this.A07.A6r() > (-9223372036854775807L) ? 1 : (this.A07.A6r() == (-9223372036854775807L) ? 0 : -1));
                if (trackCount2 == 0) {
                    String[] strArr = A0d;
                    String str2 = strArr[4];
                    String str3 = strArr[5];
                    int charAt = str2.charAt(19);
                    int trackCount3 = str3.charAt(19);
                    if (charAt == trackCount3) {
                        throw new RuntimeException();
                    }
                    A0d[2] = "7a3gC0RfnKvRSexgB6r2d4KLSEZ";
                    this.A00 = 6;
                }
            }
        }
        this.A0F = true;
        this.A0T.AD9(this.A03, this.A07.A9I());
        this.A08.ACj(this);
    }

    private void A0A() {
        C0671Gy c0671Gy;
        long j2;
        WT wt = new WT(this, this.A0Q, this.A0W, this.A0S, this.A0Y);
        if (this.A0F) {
            AbstractC0672Ha.A04(A0I());
            long j4 = this.A03;
            if (j4 != -9223372036854775807L && this.A06 >= j4) {
                this.A0B = true;
                this.A06 = -9223372036854775807L;
                return;
            }
            wt.A04(this.A07.A7t(this.A06).A00.A00, this.A06);
            this.A06 = -9223372036854775807L;
        }
        this.A02 = A00();
        long A04 = this.A0X.A04(wt, this, this.A00);
        F1 f12 = this.A0U;
        c0671Gy = wt.A03;
        j2 = wt.A02;
        f12.A0E(c0671Gy, 1, -1, null, 0, null, j2, this.A03, A04);
    }

    private void A0C(int i) {
        if (!this.A0M[i]) {
            Format A01 = this.A09.A01(i).A01(0);
            this.A0U.A06(AbstractC0690Hs.A01(A01.A0O), A01, 0, null, this.A04);
            boolean[] zArr = this.A0M;
            if (A0d[2].length() == 31) {
                throw new RuntimeException();
            }
            A0d[2] = "eh27oOHcwVOmHzYfi8kDTS";
            zArr[i] = true;
        }
    }

    private void A0D(int i) {
        if (this.A0E && this.A0N[i] && !this.A0K[i].A0M()) {
            String[] strArr = A0d;
            if (strArr[7].charAt(26) != strArr[1].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0d;
            strArr2[6] = "sgNFiq5UDquEcD4Be";
            strArr2[0] = "0a9";
            this.A06 = 0L;
            this.A0E = false;
            this.A0D = true;
            this.A04 = 0L;
            this.A02 = 0;
            for (WO wo : this.A0K) {
                wo.A0I();
            }
            this.A08.ABC(this);
        }
    }

    private void A0E(WT wt) {
        long j2;
        if (this.A05 != -1) {
            return;
        }
        j2 = wt.A01;
        this.A05 = j2;
    }

    @Override // com.facebook.ads.redexgen.X.H6
    /* renamed from: A0F */
    public final void AC1(WT wt, long j2, long j4) {
        C0671Gy c0671Gy;
        long j6;
        long j7;
        long j8;
        if (this.A03 == -9223372036854775807L) {
            long A02 = A02();
            if (A02 == Long.MIN_VALUE) {
                j8 = 0;
            } else {
                j8 = 10000 + A02;
            }
            this.A03 = j8;
            this.A0T.AD9(j8, this.A07.A9I());
        }
        F1 f12 = this.A0U;
        c0671Gy = wt.A03;
        j6 = wt.A02;
        long j9 = this.A03;
        j7 = wt.A00;
        f12.A0G(c0671Gy, 1, -1, null, 0, null, j6, j9, j2, j4, j7);
        A0E(wt);
        this.A0B = true;
        this.A08.ABC(this);
    }

    @Override // com.facebook.ads.redexgen.X.H6
    /* renamed from: A0G */
    public final void ABz(WT wt, long j2, long j4, boolean z2) {
        C0671Gy c0671Gy;
        long j6;
        long j7;
        F1 f12 = this.A0U;
        c0671Gy = wt.A03;
        j6 = wt.A02;
        long j8 = this.A03;
        j7 = wt.A00;
        f12.A0F(c0671Gy, 1, -1, null, 0, null, j6, j8, j2, j4, j7);
        if (!z2) {
            A0E(wt);
            for (WO wo : this.A0K) {
                wo.A0I();
            }
            if (this.A01 > 0) {
                this.A08.ABC(this);
            }
        }
    }

    private boolean A0I() {
        return this.A06 != -9223372036854775807L;
    }

    private boolean A0J() {
        return this.A0D || A0I();
    }

    private boolean A0K(long j2) {
        int length = this.A0K.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return true;
            }
            WO wo = this.A0K[i];
            wo.A0J();
            int i5 = wo.A0D(j2, true, false);
            boolean seekInsideQueue = i5 != -1;
            if (!seekInsideQueue) {
                if (this.A0N[i]) {
                    break;
                }
                boolean z2 = this.A0A;
                String[] strArr = A0d;
                String str = strArr[4];
                String str2 = strArr[5];
                int i6 = str.charAt(19);
                int trackCount = str2.charAt(19);
                if (i6 == trackCount) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0d;
                strArr2[7] = "iCn5X7g6PoYVWCe4GwpQYWYt9drfTGBT";
                strArr2[1] = "IDd3eJ2NBG0wgz78gdspZyWtrcrofueQ";
                if (!z2) {
                    break;
                }
            }
            i++;
        }
        return false;
    }

    private boolean A0L(WT wt, int i) {
        C1 c12;
        if (this.A05 != -1 || ((c12 = this.A07) != null && c12.A6r() != -9223372036854775807L)) {
            this.A02 = i;
            if (A0d[2].length() != 31) {
                String[] strArr = A0d;
                strArr[6] = "F1SGTXFlfQdsRtCv2";
                strArr[0] = "c29";
                return true;
            }
            throw new RuntimeException();
        }
        if (this.A0F && !A0J()) {
            this.A0E = true;
            return false;
        }
        this.A0D = this.A0F;
        this.A04 = 0L;
        this.A02 = 0;
        for (WO wo : this.A0K) {
            wo.A0I();
        }
        wt.A04(0L, 0L);
        return true;
    }

    public static boolean A0N(IOException iOException) {
        return iOException instanceof WM;
    }

    public final int A0O(int i, long j2) {
        int A0D;
        if (A0J()) {
            return 0;
        }
        WO wo = this.A0K[i];
        if (this.A0B && j2 > wo.A0F()) {
            A0D = wo.A0A();
        } else {
            A0D = wo.A0D(j2, true, true);
            String[] strArr = A0d;
            String str = strArr[4];
            String str2 = strArr[5];
            int skipCount = str.charAt(19);
            if (skipCount == str2.charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0d;
            strArr2[6] = "NIYG9FQCzFZSe10IE";
            strArr2[0] = "6cN";
            if (A0D == -1) {
                A0D = 0;
            }
        }
        if (A0D > 0) {
            A0C(i);
        } else {
            A0D(i);
        }
        return A0D;
    }

    public final int A0P(int i, C04999p c04999p, C1094Xr c1094Xr, boolean z2) {
        if (A0J()) {
            return -3;
        }
        int A0E = this.A0K[i].A0E(c04999p, c1094Xr, z2, this.A0B, this.A04);
        if (A0E == -4) {
            A0C(i);
        } else if (A0E == -3) {
            A0D(i);
        }
        return A0E;
    }

    public final void A0Q() throws IOException {
        this.A0X.A06(this.A00);
    }

    public final void A0R() {
        if (this.A0F) {
            for (WO wo : this.A0K) {
                wo.A0H();
            }
        }
        this.A0X.A07(this);
        this.A0R.removeCallbacksAndMessages(null);
        this.A08 = null;
        this.A0G = true;
        this.A0U.A04();
    }

    public final boolean A0S(int i) {
        return !A0J() && (this.A0B || this.A0K[i].A0M());
    }

    @Override // com.facebook.ads.redexgen.X.WP
    public final boolean A4T(long j2) {
        if (this.A0B || this.A0E) {
            return false;
        }
        if (this.A0F && this.A01 == 0) {
            return false;
        }
        boolean A02 = this.A0Y.A02();
        boolean continuedLoading = this.A0X.A08();
        if (!continuedLoading) {
            A0A();
            return true;
        }
        return A02;
    }

    @Override // com.facebook.ads.redexgen.X.WP
    public final void A5A(long j2, boolean z2) {
        int length = this.A0K.length;
        for (int i = 0; i < length; i++) {
            this.A0K[i].A0K(j2, z2, this.A0L[i]);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0556Bu
    public final void A5Y() {
        this.A0H = true;
        this.A0R.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.X.WP
    public final long A5x(long j2, AD ad2) {
        if (!this.A07.A9I()) {
            return 0L;
        }
        C0 A7t = this.A07.A7t(j2);
        return IF.A0I(j2, ad2, A7t.A00.A01, A7t.A01.A01);
    }

    @Override // com.facebook.ads.redexgen.X.WP
    public final long A6D() {
        long A02;
        if (this.A0B) {
            return Long.MIN_VALUE;
        }
        if (A0I()) {
            long j2 = this.A06;
            String[] strArr = A0d;
            if (strArr[7].charAt(26) != strArr[1].charAt(26)) {
                throw new RuntimeException();
            }
            A0d[3] = "ld4wWqv9tK9nTvU7QEEl8vpde5wWqGSi";
            return j2;
        }
        if (this.A0A) {
            A02 = Long.MAX_VALUE;
            int i = this.A0K.length;
            for (int i5 = 0; i5 < i; i5++) {
                if (this.A0N[i5]) {
                    A02 = Math.min(A02, this.A0K[i5].A0F());
                }
            }
        } else {
            A02 = A02();
        }
        int trackCount = (A02 > Long.MIN_VALUE ? 1 : (A02 == Long.MIN_VALUE ? 0 : -1));
        if (trackCount == 0) {
            return this.A04;
        }
        return A02;
    }

    @Override // com.facebook.ads.redexgen.X.WP
    public final long A7U() {
        if (this.A01 == 0) {
            return Long.MIN_VALUE;
        }
        return A6D();
    }

    @Override // com.facebook.ads.redexgen.X.WP
    public final TrackGroupArray A8B() {
        return this.A09;
    }

    @Override // com.facebook.ads.redexgen.X.WP
    public final void AAN() throws IOException {
        A0Q();
    }

    @Override // com.facebook.ads.redexgen.X.H9
    public final void AC6() {
        for (WO wo : this.A0K) {
            wo.A0I();
        }
        this.A0S.A03();
    }

    @Override // com.facebook.ads.redexgen.X.FA
    public final void ADS(Format format) {
        this.A0R.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.X.WP
    public final void AE4(WQ wq, long j2) {
        this.A08 = wq;
        this.A0Y.A02();
        A0A();
    }

    @Override // com.facebook.ads.redexgen.X.WP
    public final long AEL() {
        if (!this.A0C) {
            this.A0U.A05();
            this.A0C = true;
        }
        boolean z2 = this.A0D;
        String[] strArr = A0d;
        if (strArr[6].length() != strArr[0].length()) {
            A0d[2] = "";
            if (z2 && (this.A0B || A00() > this.A02)) {
                this.A0D = false;
                return this.A04;
            }
            String[] strArr2 = A0d;
            if (strArr2[7].charAt(26) == strArr2[1].charAt(26)) {
                String[] strArr3 = A0d;
                strArr3[4] = "a8TiTKBNhx8jXxPRrcAgh1BUcIw96G2f";
                strArr3[5] = "NHpS1UqcJuZi4hHtySMRiLK65X8yfSYb";
                return -9223372036854775807L;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.WP
    public final void AER(long j2) {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0556Bu
    public final void AFi(C1 c12) {
        this.A07 = c12;
        this.A0R.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.X.WP
    public final long AFl(long j2) {
        if (!this.A07.A9I()) {
            j2 = 0;
        }
        this.A04 = j2;
        this.A0D = false;
        if (!A0I()) {
            boolean A0K = A0K(j2);
            String[] strArr = A0d;
            if (strArr[4].charAt(19) == strArr[5].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0d;
            strArr2[4] = "4t4h1X84Q9aXzP6i3O1IFqP61fZwJyic";
            strArr2[5] = "YchhDxV7HDCpyjRy2lVbypcIuIxdt4SR";
            if (A0K) {
                return j2;
            }
        }
        this.A0E = false;
        this.A06 = j2;
        this.A0B = false;
        if (this.A0X.A08()) {
            this.A0X.A05();
        } else {
            for (WO wo : this.A0K) {
                wo.A0I();
            }
        }
        return j2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0556Bu
    public final C4 AGi(int i, int i5) {
        int length = this.A0K.length;
        for (int i6 = 0; i6 < length; i6++) {
            int trackCount = this.A0J[i6];
            if (trackCount == i) {
                return this.A0K[i6];
            }
        }
        WO wo = new WO(this.A0V);
        wo.A0L(this);
        int trackCount2 = length + 1;
        int[] copyOf = Arrays.copyOf(this.A0J, trackCount2);
        this.A0J = copyOf;
        copyOf[length] = i;
        int trackCount3 = length + 1;
        WO[] woArr = (WO[]) Arrays.copyOf(this.A0K, trackCount3);
        this.A0K = woArr;
        woArr[length] = wo;
        return wo;
    }
}
