package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class W5 implements InterfaceC0667Gu {
    public static byte[] A06;
    public static String[] A07 = {"LZDHzUEPY8huLib8qPH1v7czaaxlCYVW", "Hfajs1uaSYD8XiY9EEWii1aSJKbCXH1k", "56ilEDtV1sbTjQDLh", "Yd2dmsZ5", "tr3yrs0rtPd5aa0L", "Zl3VJckSqinxve9JbD33GDfHo4YeuNba", "", ""};
    public long A00;
    public Uri A01;
    public InputStream A02;
    public boolean A03;
    public final AssetManager A04;
    public final HG<? super W5> A05;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A07;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A07[3] = "kcdTjQCUlglhSnU2yukjc";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 41);
            i8++;
        }
    }

    public static void A01() {
        A06 = new byte[]{100, 107, -99, -86, -96, -82, -85, -91, -96, -101, -99, -81, -81, -95, -80, 107};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final long ADl(C0671Gy c0671Gy) throws C0660Gn {
        try {
            Uri uri = c0671Gy.A04;
            this.A01 = uri;
            String path = uri.getPath();
            if (path.startsWith(A00(1, 15, 19))) {
                path = path.substring(15);
            } else if (path.startsWith(A00(0, 1, 12))) {
                path = path.substring(1);
            }
            InputStream open = this.A04.open(path, 1);
            this.A02 = open;
            if (open.skip(c0671Gy.A03) >= c0671Gy.A03) {
                if (c0671Gy.A02 != -1) {
                    this.A00 = c0671Gy.A02;
                } else {
                    long available = this.A02.available();
                    this.A00 = available;
                    if (available == 2147483647L) {
                        this.A00 = -1L;
                    }
                }
                this.A03 = true;
                HG<? super W5> hg = this.A05;
                if (hg != null) {
                    hg.ADP(this, c0671Gy);
                }
                return this.A00;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new C0660Gn(e2);
        }
    }

    static {
        A01();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HG != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.AssetDataSource> */
    public W5(Context context, HG<? super W5> hg) {
        this.A04 = context.getAssets();
        this.A05 = hg;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final Uri A8E() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final void close() throws C0660Gn {
        this.A01 = null;
        try {
            try {
                InputStream inputStream = this.A02;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e2) {
                throw new C0660Gn(e2);
            }
        } finally {
            this.A02 = null;
            if (this.A03) {
                this.A03 = false;
                HG<? super W5> hg = this.A05;
                if (hg != null) {
                    hg.ADO(this);
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final int read(byte[] bArr, int i, int i5) throws C0660Gn {
        if (i5 == 0) {
            return 0;
        }
        long j2 = this.A00;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i5 = (int) Math.min(j2, i5);
            } catch (IOException e2) {
                throw new C0660Gn(e2);
            }
        }
        int read = this.A02.read(bArr, i, i5);
        if (read == -1) {
            int bytesRead = (this.A00 > (-1L) ? 1 : (this.A00 == (-1L) ? 0 : -1));
            if (bytesRead == 0) {
                return -1;
            }
            throw new C0660Gn(new EOFException());
        }
        long j4 = this.A00;
        int bytesRead2 = (j4 > (-1L) ? 1 : (j4 == (-1L) ? 0 : -1));
        if (bytesRead2 != 0) {
            long j6 = read;
            if (A07[3].length() == 13) {
                throw new RuntimeException();
            }
            A07[4] = "Doxe12teItAf98KBLMhQOs4gzgBHzz";
            this.A00 = j4 - j6;
        }
        HG<? super W5> hg = this.A05;
        if (hg != null) {
            hg.AB1(this, read);
        }
        return read;
    }
}
