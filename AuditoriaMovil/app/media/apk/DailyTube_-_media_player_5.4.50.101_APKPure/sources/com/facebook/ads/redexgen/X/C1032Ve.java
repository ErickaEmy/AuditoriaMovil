package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Ve  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1032Ve implements InterfaceC0688Hq {
    public long A00;
    public long A01;
    public C05079x A02 = C05079x.A04;
    public boolean A03;
    public final InterfaceC0675Hd A04;

    public C1032Ve(InterfaceC0675Hd interfaceC0675Hd) {
        this.A04 = interfaceC0675Hd;
    }

    public final void A00() {
        if (!this.A03) {
            this.A00 = this.A04.A5T();
            this.A03 = true;
        }
    }

    public final void A01() {
        if (this.A03) {
            A02(A7k());
            this.A03 = false;
        }
    }

    public final void A02(long j2) {
        this.A01 = j2;
        if (this.A03) {
            this.A00 = this.A04.A5T();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0688Hq
    public final C05079x A7h() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0688Hq
    public final long A7k() {
        long elapsedSinceBaseMs = this.A01;
        if (this.A03) {
            long A5T = this.A04.A5T();
            long positionUs = this.A00;
            long j2 = A5T - positionUs;
            if (this.A02.A01 == 1.0f) {
                long positionUs2 = C9W.A00(j2);
                return elapsedSinceBaseMs + positionUs2;
            }
            long positionUs3 = this.A02.A00(j2);
            return elapsedSinceBaseMs + positionUs3;
        }
        return elapsedSinceBaseMs;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0688Hq
    public final C05079x AGA(C05079x c05079x) {
        if (this.A03) {
            A02(A7k());
        }
        this.A02 = c05079x;
        return c05079x;
    }
}
