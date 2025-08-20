package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Vo  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1042Vo implements InterfaceC0667Gu {
    public static byte[] A07;
    public static String[] A08 = {"CpiOlZ", "ukFexlYSIMwQqH0UvFPWGqG0YthdqpHq", "2yw2Gs2GC2jxZI0Hgcr1UjVZgWf7BNvx", "7SwPVGS0jIrCQlvIcpAA6U9bhm4jPR5r", "7pQ8HXcSNS6Xqd33VYljkiTEbCcLAkDq", "kKrkJSZnynA87WgMdnYScFfJH7qszUrQ", "lo5", "kH5jcAc5XMYXCXQVRoC"};
    public long A00;
    public AssetFileDescriptor A01;
    public Uri A02;
    public InputStream A03;
    public boolean A04;
    public final Resources A05;
    public final HG<? super C1042Vo> A06;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 71);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{-9, 10, 24, 20, 26, 23, 8, 10, -59, 14, 9, 10, 19, 25, 14, 11, 14, 10, 23, -59, 18, 26, 24, 25, -59, 7, 10, -59, 6, 19, -59, 14, 19, 25, 10, 12, 10, 23, -45, 5, 2, -7, -48, 29, 37, 35, 36, -48, 37, 35, 21, -48, 35, 19, 24, 21, 29, 21, -48, 34, 17, 39, 34, 21, 35, 31, 37, 34, 19, 21, 36, 19, 41, 36, 23, 37, 33, 39, 36, 21, 23};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final long ADl(C0671Gy c0671Gy) throws HF {
        try {
            Uri uri = c0671Gy.A04;
            this.A02 = uri;
            if (TextUtils.equals(A00(70, 11, 107), uri.getScheme())) {
                try {
                    this.A01 = this.A05.openRawResourceFd(Integer.parseInt(this.A02.getLastPathSegment()));
                    FileInputStream fileInputStream = new FileInputStream(this.A01.getFileDescriptor());
                    this.A03 = fileInputStream;
                    fileInputStream.skip(this.A01.getStartOffset());
                    if (this.A03.skip(c0671Gy.A03) >= c0671Gy.A03) {
                        if (c0671Gy.A02 != -1) {
                            this.A00 = c0671Gy.A02;
                        } else {
                            long length = this.A01.getLength();
                            this.A00 = length != -1 ? length - c0671Gy.A03 : -1L;
                        }
                        this.A04 = true;
                        HG<? super C1042Vo> hg = this.A06;
                        if (hg != null) {
                            hg.ADP(this, c0671Gy);
                        }
                        return this.A00;
                    }
                    throw new EOFException();
                } catch (NumberFormatException unused) {
                    throw new HF(A00(0, 39, 94));
                }
            }
            throw new HF(A00(39, 31, 105));
        } catch (IOException e2) {
            throw new HF(e2);
        }
    }

    static {
        A01();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HG != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.RawResourceDataSource> */
    public C1042Vo(Context context, HG<? super C1042Vo> hg) {
        this.A05 = context.getResources();
        this.A06 = hg;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final Uri A8E() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final void close() throws HF {
        this.A02 = null;
        try {
            try {
                InputStream inputStream = this.A03;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.A03 = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.A01;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e2) {
                        throw new HF(e2);
                    }
                } finally {
                    this.A01 = null;
                    if (this.A04) {
                        this.A04 = false;
                        HG<? super C1042Vo> hg = this.A06;
                        if (hg != null) {
                            hg.ADO(this);
                        }
                    }
                }
            } catch (Throwable th) {
                this.A03 = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor2 = this.A01;
                        if (assetFileDescriptor2 != null) {
                            assetFileDescriptor2.close();
                        }
                        this.A01 = null;
                        if (this.A04) {
                            this.A04 = false;
                            HG<? super C1042Vo> hg2 = this.A06;
                            if (hg2 != null) {
                                hg2.ADO(this);
                            }
                        }
                        throw th;
                    } finally {
                        this.A01 = null;
                        if (this.A04) {
                            this.A04 = false;
                            HG<? super C1042Vo> hg3 = this.A06;
                            if (hg3 != null) {
                                hg3.ADO(this);
                            }
                        }
                    }
                } catch (IOException e3) {
                    throw new HF(e3);
                }
            }
        } catch (IOException e5) {
            throw new HF(e5);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final int read(byte[] bArr, int i, int i5) throws HF {
        if (i5 == 0) {
            return 0;
        }
        long j2 = this.A00;
        if (A08[3].charAt(24) != 'w') {
            A08[0] = "oumASG";
            if (j2 == 0) {
                return -1;
            }
            if (j2 != -1) {
                try {
                    i5 = (int) Math.min(j2, i5);
                } catch (IOException e2) {
                    throw new HF(e2);
                }
            }
            int read = this.A03.read(bArr, i, i5);
            if (read == -1) {
                int bytesRead = (this.A00 > (-1L) ? 1 : (this.A00 == (-1L) ? 0 : -1));
                if (bytesRead == 0) {
                    return -1;
                }
                throw new HF(new EOFException());
            }
            long j4 = this.A00;
            int bytesRead2 = (j4 > (-1L) ? 1 : (j4 == (-1L) ? 0 : -1));
            if (bytesRead2 != 0) {
                this.A00 = j4 - read;
            }
            HG<? super C1042Vo> hg = this.A06;
            if (hg != null) {
                hg.AB1(this, read);
            }
            return read;
        }
        throw new RuntimeException();
    }
}
