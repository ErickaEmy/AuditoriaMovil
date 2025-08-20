package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Collection;
/* renamed from: com.facebook.ads.redexgen.X.Uh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1010Uh implements LU {
    public final Collection<String> A00;

    public C1010Uh() {
        this.A00 = new ArrayList();
    }

    @Override // com.facebook.ads.redexgen.X.LU
    public final void AE8(String str) {
        this.A00.add(str);
    }

    @Override // com.facebook.ads.redexgen.X.LU
    public final void flush() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.A00) {
            sb.append(str);
            sb.append('\n');
        }
        return sb.toString();
    }
}
