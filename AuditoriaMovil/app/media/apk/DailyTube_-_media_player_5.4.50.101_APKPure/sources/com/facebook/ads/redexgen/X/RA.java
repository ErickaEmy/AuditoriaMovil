package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class RA extends AbstractC04788s<AnonymousClass93> {
    public final /* synthetic */ C9I A00;

    public RA(C9I c9i) {
        this.A00 = c9i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC04788s
    /* renamed from: A00 */
    public final void A03(AnonymousClass93 anonymousClass93) {
        SA sa;
        SA sa2;
        int A00 = anonymousClass93.A00();
        int currentPositionMS = this.A00.A00;
        if (currentPositionMS > 0) {
            sa = this.A00.A0B;
            int currentPositionMS2 = sa.getDuration();
            if (A00 == currentPositionMS2) {
                sa2 = this.A00.A0B;
                int duration = sa2.getDuration();
                int currentPositionMS3 = this.A00.A00;
                if (duration > currentPositionMS3) {
                    return;
                }
            }
        }
        this.A00.A0f(A00);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04788s
    public final Class<AnonymousClass93> A01() {
        return AnonymousClass93.class;
    }
}
