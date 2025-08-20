package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class AB {
    public static final AB A01 = new AB(0);
    public final int A00;

    public AB(int i) {
        this.A00 = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.A00 == ((AB) obj).A00;
    }

    public final int hashCode() {
        return this.A00;
    }
}
