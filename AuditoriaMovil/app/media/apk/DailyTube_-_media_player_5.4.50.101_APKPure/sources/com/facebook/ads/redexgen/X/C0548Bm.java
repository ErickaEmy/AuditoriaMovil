package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.uv.v7.R;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: com.facebook.ads.redexgen.X.Bm  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0548Bm implements InterfaceC1045Vr {
    public static byte[] A0G;
    public static String[] A0H = {"75NS6XWtOFaqvUAv70pmXpUOnNLqFC62", "xNyAW7YuQe6", "JhVZQGcu6MYhTGFRaY9NVeSWQV9pZEhG", "Kya4laZJ5Yz4z7ubQErhqHVe", "a5xQ9UmIIc2iWER6a0yqQZDBwnw5LxXI", "JNGHth9iM2AZaEQIUYfWNR2mTS", "R", "WvGanvqVoE"};
    public static final AtomicReference<byte[]> A0I;
    public static final Pattern A0J;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public C0671Gy A04;
    public InputStream A05;
    public HttpURLConnection A06;
    public boolean A07;
    public final int A08;
    public final int A09;
    public final H5 A0A;
    public final H5 A0B = new H5();
    public final HG<? super C0548Bm> A0C;
    public final I1<String> A0D;
    public final String A0E;
    public final boolean A0F;

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 57);
        }
        return new String(copyOfRange);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007f, code lost:
        return r4;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.HttpURLConnection A04(com.facebook.ads.redexgen.X.C0671Gy r15) throws java.io.IOException {
        /*
            r14 = this;
            android.net.Uri r0 = r15.A04
            java.lang.String r0 = r0.toString()
            java.net.URL r6 = new java.net.URL
            r6.<init>(r0)
            byte[] r7 = r15.A06
            long r8 = r15.A03
            long r10 = r15.A02
            r0 = 1
            boolean r12 = r15.A02(r0)
            r0 = r14
            boolean r0 = r0.A0F
            if (r0 != 0) goto L22
            r13 = 1
            r5 = r14
            java.net.HttpURLConnection r0 = r5.A05(r6, r7, r8, r10, r12, r13)
            return r0
        L22:
            r1 = 0
        L23:
            int r3 = r1 + 1
            r0 = 20
            if (r1 > r0) goto L80
            r13 = 0
            r5 = r14
            java.net.HttpURLConnection r4 = r5.A05(r6, r7, r8, r10, r12, r13)
            int r5 = r4.getResponseCode()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C0548Bm.A0H
            r0 = 5
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 26
            if (r1 == r0) goto L46
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L46:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0548Bm.A0H
            java.lang.String r1 = "FxIBfHo5MrM4KwNe65t8Xtniv5kx6"
            r0 = 3
            r2[r0] = r1
            r0 = 300(0x12c, float:4.2E-43)
            if (r5 == r0) goto L67
            r0 = 301(0x12d, float:4.22E-43)
            if (r5 == r0) goto L67
            r0 = 302(0x12e, float:4.23E-43)
            if (r5 == r0) goto L67
            r0 = 303(0x12f, float:4.25E-43)
            if (r5 == r0) goto L67
            if (r7 != 0) goto L7f
            r0 = 307(0x133, float:4.3E-43)
            if (r5 == r0) goto L67
            r0 = 308(0x134, float:4.32E-43)
            if (r5 != r0) goto L7f
        L67:
            r7 = 0
            r2 = 86
            r1 = 8
            r0 = 11
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.String r0 = r4.getHeaderField(r0)
            r4.disconnect()
            java.net.URL r6 = A06(r6, r0)
            r1 = r3
            goto L23
        L7f:
            return r4
        L80:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r2 = 125(0x7d, float:1.75E-43)
            r1 = 20
            r0 = 38
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r1 = r0.toString()
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0548Bm.A04(com.facebook.ads.redexgen.X.Gy):java.net.HttpURLConnection");
    }

    public static void A09() {
        A0G = new byte[]{3, 18, 48, 48, 54, 35, 39, 126, 22, 61, 48, 60, 55, 58, 61, 52, 49, 29, 28, 6, 23, 28, 6, 95, 62, 23, 28, 21, 6, 26, 58, 22, 23, 13, 28, 23, 13, 84, 43, 24, 23, 30, 28, 62, 31, 28, 27, 15, 22, 14, 50, 14, 14, 10, 62, 27, 14, 27, 41, 21, 15, 8, 25, 31, 117, 82, 95, 83, 82, 79, 85, 79, 72, 89, 82, 72, 28, 84, 89, 93, 88, 89, 78, 79, 28, 103, 126, 93, 81, 83, 70, 91, 93, 92, 73, 114, 107, 107, 39, 107, 104, 100, 102, 115, 110, 104, 105, 39, 117, 98, 99, 110, 117, 98, 100, 115, 26, 5, 25, 30, 110, 93, 82, 91, 89, 75, 112, 112, 63, 114, 126, 113, 102, 63, 109, 122, 123, 118, 109, 122, 124, 107, 108, 37, 63, 40, 19, 28, 31, 17, 24, 93, 9, 18, 93, 30, 18, 19, 19, 24, 30, 9, 93, 9, 18, 93, 82, 105, 98, Byte.MAX_VALUE, 119, 98, 100, 115, 98, 99, 39, 68, 104, 105, 115, 98, 105, 115, 42, 75, 98, 105, 96, 115, 111, 39, 92, 106, 81, 90, 71, 79, 90, 92, 75, 90, 91, 31, 124, 80, 81, 75, 90, 81, 75, 18, 109, 94, 81, 88, 90, 31, 100, 71, 124, 119, 106, 98, 119, 113, 102, 119, 118, 50, 119, 96, 96, 125, 96, 50, 101, 122, 123, 126, 119, 50, 118, 123, 97, 113, 125, 124, 124, 119, 113, 102, 123, 124, 117, 96, 91, 70, 64, 69, 69, 90, 71, 65, 80, 81, 21, 69, 71, 90, 65, 90, 86, 90, 89, 21, 71, 80, 81, 92, 71, 80, 86, 65, 15, 21, 74, 108, 122, 109, 50, 94, 120, 122, 113, 107, 86, 104, 21, 110, 118, 74, 81, 92, 77, 91, 8, 0, 116, 76, 3, 1, 5, 0, 116, 76, 3, 1, 7, 0, 116, 76, 3, 1, 12, 115, 104, 101, 116, 98, 44, 28, 16, 18, 81, 30, 17, 27, 13, 16, 22, 27, 81, 16, 20, 23, 11, 11, 15, 81, 22, 17, 11, 26, 13, 17, 30, 19, 81, 23, 11, 11, 15, 81, 55, 11, 11, 15, 43, 13, 30, 17, 12, 15, 16, 13, 11, 91, 60, 23, 10, 17, 20, 26, 27, 54, 17, 15, 10, 11, 44, 11, 13, 26, 30, 18, 77, 65, 67, 0, 79, 64, 74, 92, 65, 71, 74, 0, 65, 69, 70, 90, 90, 94, 0, 71, 64, 90, 75, 92, 64, 79, 66, 0, 70, 90, 90, 94, 0, 102, 90, 90, 94, 122, 92, 79, 64, 93, 94, 65, 92, 90, 10, 104, 71, 86, 75, 74, 98, 75, 64, 73, 90, 70, 103, 64, 94, 91, 90, 125, 90, 92, 75, 79, 67, 57, 37, 37, 33, 65, 93, 93, 89, 90, 98, 111, 110, 101, Byte.MAX_VALUE, 98, Byte.MAX_VALUE, 114, 124, 103, 108, 113, 121, 108, 106, 125, 108, 109, 76, 103, 109, 70, 111, 64, 103, 121, 124, 125};
    }

    static {
        A09();
        A0J = Pattern.compile(A03(300, 25, 17));
        A0I = new AtomicReference<>();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HG != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.DefaultHttpDataSource> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.I1 != com.facebook.ads.internal.exoplayer2.thirdparty.util.Predicate<java.lang.String> */
    public C0548Bm(String str, I1<String> i1, HG<? super C0548Bm> hg, int i, int i5, boolean z2, H5 h5) {
        this.A0E = AbstractC0672Ha.A02(str);
        this.A0D = i1;
        this.A0C = hg;
        this.A08 = i;
        this.A09 = i5;
        this.A0F = z2;
        this.A0A = h5;
    }

    private int A00(byte[] bArr, int i, int i5) throws IOException {
        if (i5 == 0) {
            return 0;
        }
        long j2 = this.A02;
        if (j2 != -1) {
            long bytesRemaining = j2 - this.A00;
            if (bytesRemaining == 0) {
                return -1;
            }
            i5 = (int) Math.min(i5, bytesRemaining);
        }
        int read = this.A05.read(bArr, i, i5);
        if (read == -1) {
            int read2 = (this.A02 > (-1L) ? 1 : (this.A02 == (-1L) ? 0 : -1));
            if (read2 == 0) {
                return -1;
            }
            throw new EOFException();
        }
        this.A00 += read;
        HG<? super C0548Bm> hg = this.A0C;
        if (hg != null) {
            hg.AB1(this, read);
        }
        return read;
    }

    private final long A01() {
        long j2 = this.A02;
        return j2 == -1 ? j2 : j2 - this.A00;
    }

    public static long A02(HttpURLConnection httpURLConnection) {
        long j2 = -1;
        String headerField = httpURLConnection.getHeaderField(A03(16, 14, 75));
        boolean isEmpty = TextUtils.isEmpty(headerField);
        String A03 = A03(296, 1, 50);
        String A032 = A03(43, 21, 67);
        if (!isEmpty) {
            try {
                j2 = Long.parseLong(headerField);
            } catch (NumberFormatException unused) {
                Log.e(A032, A03(166, 27, 62) + headerField + A03);
            }
        }
        String headerField2 = httpURLConnection.getHeaderField(A03(30, 13, 64));
        if (!TextUtils.isEmpty(headerField2)) {
            Matcher matcher = A0J.matcher(headerField2);
            if (matcher.find()) {
                try {
                    long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                    if (j2 < 0) {
                        return parseLong;
                    }
                    if (j2 != parseLong) {
                        Log.w(A032, A03(64, 22, 5) + headerField + A03(297, 3, 12) + headerField2 + A03);
                        j2 = Math.max(j2, parseLong);
                        return j2;
                    }
                    return j2;
                } catch (NumberFormatException unused2) {
                    Log.e(A032, A03(193, 26, 6) + headerField2 + A03);
                    return j2;
                }
            }
            return j2;
        }
        return j2;
    }

    private HttpURLConnection A05(URL url, byte[] bArr, long j2, long j4, boolean z2, boolean z3) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.A08);
        httpURLConnection.setReadTimeout(this.A09);
        H5 h5 = this.A0A;
        if (h5 != null) {
            for (Map.Entry<String, String> entry : h5.A00().entrySet()) {
                if (A0H[5].length() != 26) {
                    throw new RuntimeException();
                }
                A0H[2] = "kwRG9UknWr0Wgg7Rclu7tRHvEyTV8TJk";
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.A0B.A00().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j2 != 0 || j4 != -1) {
            String str = A03(325, 6, 40) + j2 + A03(0, 1, 23);
            if (j4 != -1) {
                str = str + ((j2 + j4) - 1);
            }
            httpURLConnection.setRequestProperty(A03(120, 5, 5), str);
        }
        httpURLConnection.setRequestProperty(A03(286, 10, 38), this.A0E);
        if (!z2) {
            httpURLConnection.setRequestProperty(A03(1, 15, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader), A03(474, 8, 50));
        }
        httpURLConnection.setInstanceFollowRedirects(z3);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod(A03(116, 4, R.styleable.AppCompatTheme_tooltipFrameBackground));
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    public static URL A06(URL url, String str) throws IOException {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!A03(469, 5, 16).equals(protocol)) {
                if (A0H[5].length() != 26) {
                    throw new RuntimeException();
                }
                String[] strArr = A0H;
                strArr[0] = "w50J2iwlOiToEn9H8bpLD3B1mxiX4OkW";
                strArr[4] = "U5WpLDBGoG2FZlKlieC8pMIdD1ZiOapt";
                if (!A03(465, 4, 104).equals(protocol)) {
                    String protocol2 = A03(255, 31, 12) + protocol;
                    throw new ProtocolException(protocol2);
                }
            }
            return url2;
        }
        throw new ProtocolException(A03(94, 22, 62));
    }

    private void A07() {
        HttpURLConnection httpURLConnection = this.A06;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.e(A03(43, 21, 67), A03(219, 36, 43), e2);
            }
            this.A06 = null;
        }
    }

    private void A08() throws IOException {
        if (this.A01 == this.A03) {
            return;
        }
        byte[] andSet = A0I.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j2 = this.A01;
            long j4 = this.A03;
            if (j2 != j4) {
                int readLength = (int) Math.min(j4 - j2, andSet.length);
                int read = this.A05.read(andSet, 0, readLength);
                if (!Thread.currentThread().isInterrupted()) {
                    if (read != -1) {
                        this.A01 += read;
                        HG<? super C0548Bm> hg = this.A0C;
                        if (hg != null) {
                            hg.AB1(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                } else {
                    throw new InterruptedIOException();
                }
            } else {
                A0I.set(andSet);
                return;
            }
        }
    }

    public static void A0A(HttpURLConnection httpURLConnection, long j2) {
        if (IF.A02 != 19) {
            int i = IF.A02;
            String[] strArr = A0H;
            if (strArr[6].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A0H[5] = "h9vUSf3vBaluOAcyH2LsyeRcof";
            if (i != 20) {
                return;
            }
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j2 == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j2 <= 2048) {
                return;
            }
            String name = inputStream.getClass().getName();
            if (A03(331, 65, 70).equals(name) || A03(396, 69, 23).equals(name)) {
                Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod(A03(482, 20, 48), new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final Uri A8E() {
        HttpURLConnection httpURLConnection = this.A06;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final long ADl(C0671Gy c0671Gy) throws H4 {
        String A03 = A03(145, 21, 68);
        this.A04 = c0671Gy;
        long j2 = 0;
        this.A00 = 0L;
        this.A01 = 0L;
        try {
            HttpURLConnection A04 = A04(c0671Gy);
            this.A06 = A04;
            try {
                int responseCode = A04.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = this.A06.getHeaderFields();
                    A07();
                    C1046Vs exception = new C1046Vs(responseCode, headerFields, c0671Gy);
                    if (responseCode == 416) {
                        exception.initCause(new C0668Gv(0));
                    }
                    throw exception;
                }
                String contentType = this.A06.getContentType();
                I1<String> i1 = this.A0D;
                if (i1 == null || i1.A5b(contentType)) {
                    if (responseCode == 200) {
                        int responseCode2 = (c0671Gy.A03 > 0L ? 1 : (c0671Gy.A03 == 0L ? 0 : -1));
                        if (responseCode2 != 0) {
                            j2 = c0671Gy.A03;
                        }
                    }
                    this.A03 = j2;
                    if (!c0671Gy.A02(1)) {
                        int responseCode3 = (c0671Gy.A02 > (-1L) ? 1 : (c0671Gy.A02 == (-1L) ? 0 : -1));
                        if (responseCode3 != 0) {
                            this.A02 = c0671Gy.A02;
                        } else {
                            long A02 = A02(this.A06);
                            int responseCode4 = (A02 > (-1L) ? 1 : (A02 == (-1L) ? 0 : -1));
                            this.A02 = responseCode4 != 0 ? A02 - this.A03 : -1L;
                        }
                    } else {
                        long j4 = c0671Gy.A02;
                        String[] strArr = A0H;
                        String str = strArr[6];
                        String str2 = strArr[1];
                        int length = str.length();
                        int responseCode5 = str2.length();
                        if (length == responseCode5) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A0H;
                        strArr2[0] = "g5QduXiMfcr3WVIXoNOmeCAyNU6k9qpH";
                        strArr2[4] = "C5YWXMFtOzaHxpxnw5jthW3Xp7pagYAJ";
                        this.A02 = j4;
                    }
                    try {
                        this.A05 = this.A06.getInputStream();
                        this.A07 = true;
                        HG<? super C0548Bm> hg = this.A0C;
                        if (hg != null) {
                            hg.ADP(this, c0671Gy);
                        }
                        return this.A02;
                    } catch (IOException e2) {
                        A07();
                        throw new H4(e2, c0671Gy, 1);
                    }
                }
                A07();
                throw new C1047Vt(contentType, c0671Gy);
            } catch (IOException e3) {
                A07();
                throw new H4(A03 + c0671Gy.A04.toString(), e3, c0671Gy, 1);
            }
        } catch (IOException e5) {
            throw new H4(A03 + c0671Gy.A04.toString(), e5, c0671Gy, 1);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final void close() throws H4 {
        try {
            if (this.A05 != null) {
                A0A(this.A06, A01());
                try {
                    this.A05.close();
                } catch (IOException e2) {
                    throw new H4(e2, this.A04, 3);
                }
            }
        } finally {
            this.A05 = null;
            A07();
            if (this.A07) {
                this.A07 = false;
                HG<? super C0548Bm> hg = this.A0C;
                if (hg != null) {
                    hg.ADO(this);
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final int read(byte[] bArr, int i, int i5) throws H4 {
        try {
            A08();
            return A00(bArr, i, i5);
        } catch (IOException e2) {
            throw new H4(e2, this.A04, 2);
        }
    }
}
