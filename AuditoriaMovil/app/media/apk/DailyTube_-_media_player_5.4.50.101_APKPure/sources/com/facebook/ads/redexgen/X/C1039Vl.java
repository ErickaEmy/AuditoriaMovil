package com.facebook.ads.redexgen.X;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* renamed from: com.facebook.ads.redexgen.X.Vl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1039Vl implements InterfaceC0665Gs {
    public long A00;
    public long A01;
    public C0671Gy A02;
    public I6 A03;
    public File A04;
    public FileOutputStream A05;
    public OutputStream A06;
    public final int A07;
    public final long A08;
    public final HK A09;
    public final boolean A0A;

    public C1039Vl(HK hk, long j2) {
        this(hk, j2, 20480, true);
    }

    public C1039Vl(HK hk, long j2, int i, boolean z2) {
        this.A09 = (HK) AbstractC0672Ha.A01(hk);
        this.A08 = j2;
        this.A07 = i;
        this.A0A = z2;
    }

    private void A00() throws IOException {
        OutputStream outputStream = this.A06;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            if (this.A0A) {
                this.A05.getFD().sync();
            }
            IF.A0X(this.A06);
            this.A06 = null;
            File fileToCommit = this.A04;
            this.A04 = null;
            if (1 != 0) {
                this.A09.A4N(fileToCommit);
            } else {
                fileToCommit.delete();
            }
        } catch (Throwable th) {
            IF.A0X(this.A06);
            this.A06 = null;
            File file = this.A04;
            this.A04 = null;
            if (0 != 0) {
                this.A09.A4N(file);
            } else {
                file.delete();
            }
            throw th;
        }
    }

    private void A01() throws IOException {
        long maxLength;
        if (this.A02.A02 == -1) {
            maxLength = this.A08;
        } else {
            maxLength = Math.min(this.A02.A02 - this.A00, this.A08);
        }
        this.A04 = this.A09.AGT(this.A02.A05, this.A00 + this.A02.A01, maxLength);
        FileOutputStream fileOutputStream = new FileOutputStream(this.A04);
        this.A05 = fileOutputStream;
        if (this.A07 > 0) {
            I6 i6 = this.A03;
            if (i6 == null) {
                this.A03 = new I6(this.A05, this.A07);
            } else {
                i6.A00(fileOutputStream);
            }
            this.A06 = this.A03;
        } else {
            this.A06 = fileOutputStream;
        }
        this.A01 = 0L;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0665Gs
    public final void ADn(C0671Gy c0671Gy) throws C1040Vm {
        if (c0671Gy.A02 == -1 && !c0671Gy.A02(2)) {
            this.A02 = null;
            return;
        }
        this.A02 = c0671Gy;
        this.A00 = 0L;
        try {
            A01();
        } catch (IOException e2) {
            throw new C1040Vm(e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0665Gs
    public final void close() throws C1040Vm {
        if (this.A02 == null) {
            return;
        }
        try {
            A00();
        } catch (IOException e2) {
            throw new C1040Vm(e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0665Gs
    public final void write(byte[] bArr, int i, int i5) throws C1040Vm {
        if (this.A02 == null) {
            return;
        }
        int i6 = 0;
        while (i6 < i5) {
            try {
                if (this.A01 == this.A08) {
                    A00();
                    A01();
                }
                int bytesWritten = i5 - i6;
                int min = (int) Math.min(bytesWritten, this.A08 - this.A01);
                int bytesWritten2 = i + i6;
                this.A06.write(bArr, bytesWritten2, min);
                i6 += min;
                this.A01 += min;
                this.A00 += min;
            } catch (IOException e2) {
                throw new C1040Vm(e2);
            }
        }
    }
}
