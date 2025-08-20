package com.facebook.ads.redexgen.X;

import java.io.ByteArrayInputStream;
/* renamed from: com.facebook.ads.redexgen.X.bl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1261bl implements C0K {
    public ByteArrayInputStream A00;
    public final byte[] A01;

    public C1261bl(byte[] bArr) {
        this.A01 = bArr;
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final void ADm(int i) throws C1260bk {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.A01);
        this.A00 = byteArrayInputStream;
        byteArrayInputStream.skip(i);
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final void close() throws C1260bk {
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final int length() throws C1260bk {
        return this.A01.length;
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final int read(byte[] bArr) throws C1260bk {
        return this.A00.read(bArr, 0, bArr.length);
    }
}
