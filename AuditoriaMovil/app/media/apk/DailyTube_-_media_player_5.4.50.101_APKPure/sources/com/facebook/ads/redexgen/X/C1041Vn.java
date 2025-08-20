package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
/* renamed from: com.facebook.ads.redexgen.X.Vn  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1041Vn implements InterfaceC0667Gu {
    public static String[] A04 = {"X6WlBdbGeBIUy9RcgyD1kPyvMH5gl65h", "mWixtdhRvEEOtO49Z6LrUITCnd", "19dVuEeyHaOsnSLi", "Fh0FDziHvuuc46M8RjDn", "TMNOdV", "BntQd7XboiQ5Pp5LCDj1cbVKSXS32D1x", "NrlP0Z8V9f9J6rKzzcCufZh8yiDjfbRh", "BOidXQkRBMfwkg7VYmAkrOpgeHcKVKv0"};
    public long A00;
    public boolean A01;
    public final InterfaceC0665Gs A02;
    public final InterfaceC0667Gu A03;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final long ADl(C0671Gy c0671Gy) throws IOException {
        long ADl = this.A03.ADl(c0671Gy);
        this.A00 = ADl;
        if (ADl == 0) {
            return 0L;
        }
        if (c0671Gy.A02 == -1 && this.A00 != -1) {
            c0671Gy = new C0671Gy(c0671Gy.A04, c0671Gy.A01, c0671Gy.A03, this.A00, c0671Gy.A05, c0671Gy.A00);
        }
        this.A01 = true;
        this.A02.ADn(c0671Gy);
        return this.A00;
    }

    public C1041Vn(InterfaceC0667Gu interfaceC0667Gu, InterfaceC0665Gs interfaceC0665Gs) {
        this.A03 = (InterfaceC0667Gu) AbstractC0672Ha.A01(interfaceC0667Gu);
        this.A02 = (InterfaceC0665Gs) AbstractC0672Ha.A01(interfaceC0665Gs);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final Uri A8E() {
        return this.A03.A8E();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final void close() throws IOException {
        try {
            this.A03.close();
            if (this.A01) {
                this.A01 = false;
                this.A02.close();
            }
        } catch (Throwable th) {
            boolean z2 = this.A01;
            if (A04[5].charAt(29) != 'a') {
                A04[1] = "CXpRjqYaQVmivrsYVOmY1oz";
                if (z2) {
                    this.A01 = false;
                    InterfaceC0665Gs interfaceC0665Gs = this.A02;
                    if (A04[1].length() != 2) {
                        A04[5] = "FmRI3fMemMJaQGBcEYhbAky7hUfnuUR1";
                        interfaceC0665Gs.close();
                    }
                }
                throw th;
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final int read(byte[] bArr, int i, int i5) throws IOException {
        if (this.A00 == 0) {
            return -1;
        }
        int read = this.A03.read(bArr, i, i5);
        if (read > 0) {
            this.A02.write(bArr, i, read);
            long j2 = this.A00;
            int bytesRead = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
            if (bytesRead != 0) {
                this.A00 = j2 - read;
            }
        }
        return read;
    }
}
