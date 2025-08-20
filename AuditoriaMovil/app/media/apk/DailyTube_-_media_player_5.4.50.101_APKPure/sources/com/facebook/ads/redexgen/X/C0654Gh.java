package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Gh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0654Gh {
    public int A00;
    public final int A01;
    public final InterfaceC0653Gg[] A02;

    public C0654Gh(InterfaceC0653Gg... interfaceC0653GgArr) {
        this.A02 = interfaceC0653GgArr;
        this.A01 = interfaceC0653GgArr.length;
    }

    public final InterfaceC0653Gg A00(int i) {
        return this.A02[i];
    }

    public final InterfaceC0653Gg[] A01() {
        return (InterfaceC0653Gg[]) this.A02.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.A02, ((C0654Gh) obj).A02);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int result = Arrays.hashCode(this.A02);
            this.A00 = (17 * 31) + result;
        }
        return this.A00;
    }
}
