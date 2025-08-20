package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class Y0 implements InterfaceC0533Ax {
    public final C1097Xu A00;
    public final C1096Xt A01;
    public final InterfaceC0511Ab[] A02;

    public Y0(InterfaceC0511Ab... interfaceC0511AbArr) {
        InterfaceC0511Ab[] interfaceC0511AbArr2 = (InterfaceC0511Ab[]) Arrays.copyOf(interfaceC0511AbArr, interfaceC0511AbArr.length + 2);
        this.A02 = interfaceC0511AbArr2;
        C1097Xu c1097Xu = new C1097Xu();
        this.A00 = c1097Xu;
        C1096Xt c1096Xt = new C1096Xt();
        this.A01 = c1096Xt;
        interfaceC0511AbArr2[interfaceC0511AbArr.length] = c1097Xu;
        interfaceC0511AbArr2[interfaceC0511AbArr.length + 1] = c1096Xt;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0533Ax
    public final C05079x A3b(C05079x c05079x) {
        this.A00.A0B(c05079x.A02);
        return new C05079x(this.A01.A01(c05079x.A01), this.A01.A00(c05079x.A00), c05079x.A02);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0533Ax
    public final InterfaceC0511Ab[] A64() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0533Ax
    public final long A7O(long j2) {
        return this.A01.A02(j2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0533Ax
    public final long A80() {
        return this.A00.A0A();
    }
}
