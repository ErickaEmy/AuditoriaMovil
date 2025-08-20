package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class WB implements InterfaceC0636Fo {
    public static String[] A01 = {"HW2qPt5u", "AwGYl2mpYTTxi9jMk2ztyBHwHH9P0uOm", "ziApCMCdbQMQdjd0mTARuvEC3B", "RZTttmRl2v5Rh0lD63G6fj8mov5GfzUW", "CAabTzRSjKw", "MBUj6", "1ELfNFRtAis", "0tjH0VZdGvNSLcI7F3HjH1zffCsfPrCD"};
    public final List<C0635Fn> A00;

    public WB(List<C0635Fn> list) {
        this.A00 = Collections.unmodifiableList(list);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final List<C0635Fn> A6Z(long j2) {
        return j2 >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final long A70(int i) {
        AbstractC0672Ha.A03(i == 0);
        if (A01[2].length() != 12) {
            A01[2] = "5DVkB5gcIO90TUIp";
            return 0L;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final int A71() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final int A7T(long j2) {
        return j2 < 0 ? 0 : -1;
    }
}
