package com.facebook.ads.redexgen.X;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
/* renamed from: com.facebook.ads.redexgen.X.Bq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0552Bq implements WL {
    public static String[] A06 = {"KcRMvDVLZNgc0ooVkhN4ahdKcengok4t", "7pRgSHJJ", "GNHbGuKbKosn0JAz4xkib8iBcGb5WNz5", "hJNyShuwv1tZ2cTKHVoLW9isLSOVhBhj", "H7WHQ", "6cZmXLfi2DPGYj7ZmxIdQ5A", "b2Hmg2LD", "cSsJl4a3bVOvbO76ENMD9MAL1lcw3B"};
    public long A00;
    public long A01;
    public C03844q A02;
    public final ArrayDeque<C03844q> A03 = new ArrayDeque<>();
    public final ArrayDeque<AbstractC0553Br> A04;
    public final PriorityQueue<C03844q> A05;

    public abstract WI A0N();

    public abstract void A0P(C5 c52);

    public abstract boolean A0R();

    public AbstractC0552Bq() {
        for (int i = 0; i < 10; i++) {
            this.A03.add(new C03844q());
        }
        this.A04 = new ArrayDeque<>();
        for (int i5 = 0; i5 < 2; i5++) {
            this.A04.add(new C03814n(this));
        }
        this.A05 = new PriorityQueue<>();
    }

    private void A0K(C03844q c03844q) {
        c03844q.A07();
        this.A03.add(c03844q);
    }

    @Override // com.facebook.ads.redexgen.X.BB
    /* renamed from: A0L */
    public C5 A54() throws C0637Fp {
        AbstractC0672Ha.A04(this.A02 == null);
        boolean isEmpty = this.A03.isEmpty();
        if (A06[4].length() != 5) {
            throw new RuntimeException();
        }
        A06[4] = "MSCQz";
        if (isEmpty) {
            return null;
        }
        C03844q pollFirst = this.A03.pollFirst();
        this.A02 = pollFirst;
        return pollFirst;
    }

    @Override // com.facebook.ads.redexgen.X.BB
    /* renamed from: A0M */
    public AbstractC0553Br A55() throws C0637Fp {
        if (this.A04.isEmpty()) {
            return null;
        }
        while (!this.A05.isEmpty() && ((C1094Xr) this.A05.peek()).A00 <= this.A00) {
            C03844q poll = this.A05.poll();
            if (poll.A04()) {
                AbstractC0553Br pollFirst = this.A04.pollFirst();
                pollFirst.A00(4);
                A0K(poll);
                String[] strArr = A06;
                if (strArr[1].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A06;
                strArr2[2] = "Z7l20gfPvvtRCAhrDUNIN8ivECfXDju3";
                strArr2[3] = "MHWMj6Fd4O5yELPFkyyjrniha9DdnabU";
                return pollFirst;
            }
            A0P(poll);
            if (A0R()) {
                WI A0N = A0N();
                if (!poll.A03()) {
                    AbstractC0553Br pollFirst2 = this.A04.pollFirst();
                    pollFirst2.A09(((C1094Xr) poll).A00, A0N, Long.MAX_VALUE);
                    A0K(poll);
                    return pollFirst2;
                }
            }
            A0K(poll);
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.BB
    /* renamed from: A0O */
    public void AEG(C5 c52) throws C0637Fp {
        AbstractC0672Ha.A03(c52 == this.A02);
        if (A06[0].charAt(9) != 'N') {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[7] = "h6rCbn8hi0Qg5CvGAi8vHFDPjl0uqV";
        strArr[5] = "6Me2Lvii1P8K0tFjrCRJacm";
        if (c52.A03()) {
            A0K(this.A02);
        } else {
            C03844q c03844q = this.A02;
            long j2 = this.A01;
            this.A01 = 1 + j2;
            c03844q.A00 = j2;
            this.A05.add(this.A02);
        }
        this.A02 = null;
    }

    public final void A0Q(AbstractC0553Br abstractC0553Br) {
        abstractC0553Br.A07();
        this.A04.add(abstractC0553Br);
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public void AEV() {
    }

    @Override // com.facebook.ads.redexgen.X.WL
    public void AGB(long j2) {
        this.A00 = j2;
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public void flush() {
        this.A01 = 0L;
        this.A00 = 0L;
        while (!this.A05.isEmpty()) {
            A0K(this.A05.poll());
        }
        C03844q c03844q = this.A02;
        if (c03844q != null) {
            A0K(c03844q);
            this.A02 = null;
        }
    }
}
