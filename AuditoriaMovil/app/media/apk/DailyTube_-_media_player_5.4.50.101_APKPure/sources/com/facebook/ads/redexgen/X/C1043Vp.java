package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
/* renamed from: com.facebook.ads.redexgen.X.Vp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1043Vp implements InterfaceC0667Gu {
    public final int A00;
    public final InterfaceC0667Gu A01;
    public final I3 A02;

    public C1043Vp(InterfaceC0667Gu interfaceC0667Gu, I3 i32, int i) {
        this.A01 = (InterfaceC0667Gu) AbstractC0672Ha.A01(interfaceC0667Gu);
        this.A02 = (I3) AbstractC0672Ha.A01(i32);
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final Uri A8E() {
        return this.A01.A8E();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final long ADl(C0671Gy c0671Gy) throws IOException {
        this.A02.A02(this.A00);
        return this.A01.ADl(c0671Gy);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final void close() throws IOException {
        this.A01.close();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final int read(byte[] bArr, int i, int i5) throws IOException {
        this.A02.A02(this.A00);
        return this.A01.read(bArr, i, i5);
    }
}
