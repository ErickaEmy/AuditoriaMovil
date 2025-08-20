package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public abstract class W7 implements InterfaceC0653Gg {
    public static String[] A06 = {"EBmdqLWecJMvF32HHOtKZq3CgXIvE452", "BdAZUE9bv2aYbX", "p2jaFpqqtq7wiSmM9WukcsLyXw4b4dtx", "1X", "vopxokSVw1ySmQXekO1RjBQd7v2xLqd9", "VPvZphdKETm07yfZNyzcurZ6EUXJ9z1S", "", "4goZxeGj3kqt5M"};
    public int A00;
    public final long[] A01;
    public final Format[] A02;
    public final int A03;
    public final TrackGroup A04;
    public final int[] A05;

    public W7(TrackGroup trackGroup, int... iArr) {
        AbstractC0672Ha.A04(iArr.length > 0);
        this.A04 = (TrackGroup) AbstractC0672Ha.A01(trackGroup);
        int length = iArr.length;
        this.A03 = length;
        this.A02 = new Format[length];
        for (int i = 0; i < iArr.length; i++) {
            this.A02[i] = trackGroup.A01(iArr[i]);
        }
        Arrays.sort(this.A02, new GU());
        this.A05 = new int[this.A03];
        int i5 = 0;
        while (true) {
            int i6 = this.A03;
            if (i5 < i6) {
                this.A05[i5] = trackGroup.A00(this.A02[i5]);
                i5++;
            } else {
                this.A01 = new long[i6];
                return;
            }
        }
    }

    public final boolean A00(int i, long j2) {
        return this.A01[i] > j2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0653Gg
    public void A5U() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0653Gg
    public final Format A76(int i) {
        return this.A02[i];
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0653Gg
    public final int A7C(int i) {
        return this.A05[i];
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0653Gg
    public final Format A7u() {
        return this.A02[A7v()];
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0653Gg
    public final TrackGroup A8A() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0653Gg
    public void ACc(float f4) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            Class<?> cls = getClass();
            Class<?> cls2 = obj.getClass();
            if (A06[0].charAt(2) == '6') {
                throw new RuntimeException();
            }
            A06[5] = "DltTTItYFp9j4gBSYKna0NySMwUM0opE";
            if (cls == cls2) {
                W7 w7 = (W7) obj;
                return this.A04 == w7.A04 && Arrays.equals(this.A05, w7.A05);
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = (System.identityHashCode(this.A04) * 31) + Arrays.hashCode(this.A05);
        }
        int i = this.A00;
        if (A06[3].length() != 1) {
            A06[2] = "bVwK8O26HvXVwTm7sFYRRd9zYTspDJxL";
            return i;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0653Gg
    public final int length() {
        return this.A05.length;
    }
}
