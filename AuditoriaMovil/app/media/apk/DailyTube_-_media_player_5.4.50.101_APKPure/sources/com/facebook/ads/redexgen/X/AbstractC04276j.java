package com.facebook.ads.redexgen.X;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto;
import com.uv.v7.R;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.6j  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC04276j extends EM {
    public static byte[] A0d;
    public static String[] A0e = {"el1NIdjJdnQk8rQ7yI3DLJMJGUNGpsaL", "cMnDkAErKs2M6cVzDcwdPqTaRDuVL2G6", "3Ljz1yFix4teFI07gFBJ1ZVJZ4Elk", "rfweshkfyu7YGNu9gmTN5aJbUxr0jD44", "UwDJ5OwzyxxJZbvw2og9SG", "E", "kELoxR7DFwuexd5ZjpenISH", "LMGopoJZLCWwOw1IQPtLBjMdbqq8sxxW"};
    public static final byte[] A0f;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public MediaCodec A06;
    public Format A07;
    public InterfaceC0537Bb<FrameworkMediaCrypto> A08;
    public InterfaceC0537Bb<FrameworkMediaCrypto> A09;
    public DG A0A;
    public ByteBuffer A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public boolean A0L;
    public boolean A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public ByteBuffer[] A0S;
    public ByteBuffer[] A0T;
    public BC A0U;
    public final MediaCodec.BufferInfo A0V;
    public final C04999p A0W;
    public final C1094Xr A0X;
    public final C1094Xr A0Y;
    public final InterfaceC0538Bc<FrameworkMediaCrypto> A0Z;
    public final DM A0a;
    public final List<Long> A0b;
    public final boolean A0c;

    public static String A0Z(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0d, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            int i10 = (copyOfRange[i8] ^ i6) ^ 57;
            if (A0e[5].length() == 20) {
                throw new RuntimeException();
            }
            A0e[0] = "GT4OiQXgMfCUtJ1QRZ1mZZkQ0KPtv7dD";
            copyOfRange[i8] = (byte) i10;
        }
        return new String(copyOfRange);
    }

    public static void A0j() {
        A0d = new byte[]{85, 89, 27, 12, 13, 89, 23, 22, 89, 10, 28, 26, 12, 11, 28, 89, 29, 28, 26, 22, 29, 28, 11, 89, 24, 15, 24, 16, 21, 24, 27, 21, 28, 87, 89, 45, 11, 0, 16, 23, 30, 89, 13, 22, 89, 9, 11, 22, 26, 28, 28, 29, 89, 14, 16, 13, 17, 89, 19, 106, 106, 106, 106, 106, 107, 108, 109, 110, 104, 25, 106, 106, 24, 30, 27, 104, 111, 99, 106, 106, 106, 106, 106, 106, 107, 108, 98, 25, 31, 106, 28, 107, 105, 104, 106, 106, 106, 106, 106, 106, 107, 108, 111, 98, 98, 98, 110, 106, 30, 25, 31, 109, 107, 107, 98, 27, 106, 106, 106, 104, 28, 24, 28, 107, 25, 105, 107, 25, 105, 104, 109, 111, 30, 109, 98, 107, 108, 126, 121, 3, 47, 35, 56, 45, 44, 93, 107, 116, 57, 106, 124, 106, 106, 112, 118, 119, 57, 107, 124, 104, 108, 112, 107, 124, 106, 57, 106, 124, 122, 108, 107, 124, 57, 125, 124, 122, 118, 125, 124, 107, 57, Byte.MAX_VALUE, 118, 107, 57, 27, 51, 50, 63, 55, 118, 36, 51, 39, 35, 63, 36, 51, 37, 118, 55, 118, 18, 36, 59, 5, 51, 37, 37, 63, 57, 56, 27, 55, 56, 55, 49, 51, 36, 9, 33, 32, 45, 37, 7, 43, 32, 33, 39, 22, 33, 42, 32, 33, 54, 33, 54, 69, 71, 82, 36, 79, 114, 115, 100, 101, 121, 36, 107, 124, 105, 36, 110, 111, 105, 32, 34, 55, 65, 42, 23, 22, 1, 0, 28, 65, 14, 25, 12, 65, 11, 10, 12, 65, 28, 10, 12, 26, 29, 10, 42, 40, 61, 75, 40, 49, 46, 75, 36, 48, 33, 44, 42, 75, 33, 32, 38, 42, 33, 32, 55, 75, 40, 53, 86, 80, 82, 71, 49, 82, 75, 84, 49, 73, 86, 91, 90, 80, 49, 91, 90, 92, 80, 91, 90, 77, 49, 94, 73, 92, 36, 38, 51, 69, 37, 29, 2, 15, 2, 10, 69, 3, 89, 93, 95, 69, 15, 14, 8, 4, 15, 14, 63, 61, 40, 94, 62, 6, 25, 20, 25, 17, 94, 24, 66, 70, 68, 94, 20, 21, 19, 31, 20, 21, 94, 3, 21, 19, 5, 2, 21, 14, 12, 25, 111, 18, 4, 2, 111, 32, 55, 34, 111, 37, 36, 34, 4, 6, 19, 101, 24, 14, 8, 101, 42, 61, 40, 101, 47, 46, 40, 101, 56, 46, 40, 62, 57, 46, 4, 6, 19, 101, 42, 39, 39, 60, 34, 37, 37, 46, 57, 101, 61, 34, 47, 46, 36, 101, 47, 46, 40, 36, 47, 46, 57, 101, 42, 61, 40, 75, 73, 92, 42, 101, 105, 104, 107, 99, 109, 103, 42, 101, 114, 103, 42, 96, 97, 103, 107, 96, 97, 118, 42, 101, 115, 97, 119, 107, 105, 97, 110, 108, 121, 15, 64, 76, 77, 78, 70, 72, 66, 15, 64, 87, 66, 15, 69, 68, 66, 78, 69, 68, 83, 15, 64, 86, 68, 82, 78, 76, 68, 15, 82, 68, 66, 84, 83, 68, 87, 85, 64, 54, Byte.MAX_VALUE, 119, 119, Byte.MAX_VALUE, 116, 125, 54, 121, 121, 123, 54, 124, 125, 123, 119, 124, 125, 106, 114, 112, 101, 19, 90, 82, 82, 90, 81, 88, 19, 75, 82, 79, 95, 84, 78, 19, 89, 88, 94, 82, 89, 88, 79, 123, 121, 108, 26, 70, 95, 26, 66, 93, 80, 81, 91, 107, 80, 81, 87, 91, 80, 81, 70, 26, 85, 66, 87, 67, 93, 61, 81, 37, 33, 32, 58, 36, 68, 40, 92, 91, 89, 57, 39, 71, 45, 82, 90, 90, 11, 21, 117, 18, 111, 104, 104, 105, 119, 23, 110, 15, 2, 15, 104, 106, 120, 124, 96, 123, 108, 90, 108, 122, 122, 96, 102, 103, 124, 119, 126, 113, 113, 122, 115, 50, 124, 112, 106, 113, 107, 11, 7, 6, 14, 1, 15, 29, 26, 13, 43, 7, 12, 13, 11, 4, 21, 2, 6, 19, 2, 36, 8, 3, 2, 4, 93, 122, 108, Byte.MAX_VALUE, 119, 112, 95, 112, 122, 88, 123, 123, 122, 30, 20, 23, 13, 22, 28, 29, 10, 57, 51, 48, 42, 49, 59, 58, 45, 0, 51, 43, 58, 107, 105, 120, 65, 105, 104, 101, 109, 79, 126, 117, 124, 120, 99, 1, 3, 18, 53, 18, 7, 18, 3, 79, 90, 71, 93, 88, 77, 90, 62, 52, 100, 102, 102, 102, 102, 107, 103, 105, 102, 122, 68, 83, 90, 83, 87, 69, 83, 101, 83, 69, 69, 95, 89, 88, 55, 48, 37, 54, 48, 7, 43, 32, 33, 39, 104, 117, 112, 125, 108, 117, 125, 73, 87, 90, 74, 86};
    }

    public abstract int A1B(MediaCodec mediaCodec, DG dg, Format format, Format format2);

    public abstract int A1C(DM dm2, InterfaceC0538Bc<FrameworkMediaCrypto> interfaceC0538Bc, Format format) throws DP;

    public abstract void A1L(MediaCodec mediaCodec, MediaFormat mediaFormat) throws C04879c;

    public abstract void A1N(C1094Xr c1094Xr);

    public abstract void A1O(DG dg, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws DP;

    public abstract void A1P(String str, long j2, long j4);

    public abstract boolean A1Q(long j2, long j4, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i5, long j6, boolean z2) throws C04879c;

    static {
        A0j();
        A0f = IF.A0h(A0Z(59, 76, 99));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bc != com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto> */
    public AbstractC04276j(int i, DM dm2, InterfaceC0538Bc<FrameworkMediaCrypto> interfaceC0538Bc, boolean z2) {
        super(i);
        AbstractC0672Ha.A04(IF.A02 >= 16);
        this.A0a = (DM) AbstractC0672Ha.A01(dm2);
        this.A0Z = interfaceC0538Bc;
        this.A0c = z2;
        this.A0X = new C1094Xr(0);
        this.A0Y = C1094Xr.A02();
        this.A0W = new C04999p();
        this.A0b = new ArrayList();
        this.A0V = new MediaCodec.BufferInfo();
        this.A01 = 0;
        this.A02 = 0;
    }

    private int A0W(String str) {
        if (IF.A02 <= 25 && A0Z(255, 25, 86).equals(str) && (IF.A06.startsWith(A0Z(617, 7, 3)) || IF.A06.startsWith(A0Z(589, 7, 41)) || IF.A06.startsWith(A0Z(596, 7, 80)) || IF.A06.startsWith(A0Z(610, 7, 97)))) {
            return 2;
        }
        if (IF.A02 < 24) {
            if (A0Z(330, 22, 82).equals(str) || A0Z(352, 29, 73).equals(str)) {
                if (!A0Z(689, 8, 65).equals(IF.A03)) {
                    if (!A0Z(697, 12, 102).equals(IF.A03)) {
                        if (!A0Z(731, 7, 17).equals(IF.A03)) {
                            if (A0Z(774, 7, 37).equals(IF.A03)) {
                                return 1;
                            }
                            return 0;
                        }
                        return 1;
                    }
                    return 1;
                }
                return 1;
            }
            return 0;
        }
        return 0;
    }

    private final long A0X() {
        return 0L;
    }

    public static MediaCodec.CryptoInfo A0Y(C1094Xr c1094Xr, int i) {
        MediaCodec.CryptoInfo A02 = c1094Xr.A02.A02();
        if (i == 0) {
            return A02;
        }
        if (A02.numBytesOfClearData == null) {
            A02.numBytesOfClearData = new int[1];
        }
        int[] iArr = A02.numBytesOfClearData;
        int i5 = iArr[0];
        if (A0e[2].length() != 1) {
            String[] strArr = A0e;
            strArr[7] = "NOzrMPRB76F8DdbUb3OPVPb4rTNpEGvY";
            strArr[3] = "IDmZDsJhwqXuUzopfYWLVElAjmr2DtdU";
            iArr[0] = i5 + i;
            return A02;
        }
        throw new RuntimeException();
    }

    private ByteBuffer A0a(int i) {
        if (IF.A02 >= 21) {
            return this.A06.getInputBuffer(i);
        }
        ByteBuffer byteBuffer = this.A0S[i];
        String[] strArr = A0e;
        if (strArr[4].length() != strArr[6].length()) {
            String[] strArr2 = A0e;
            strArr2[7] = "akmimywpCQzy2zgGqC6e1Zi0HtFx9MqZ";
            strArr2[3] = "4g16x1WFaX1F1Ai56lyJAgpz1Kjl0dDQ";
            return byteBuffer;
        }
        throw new RuntimeException();
    }

    private ByteBuffer A0b(int i) {
        if (IF.A02 >= 21) {
            return this.A06.getOutputBuffer(i);
        }
        return this.A0T[i];
    }

    private void A0c() {
        if (IF.A02 < 21) {
            this.A0S = this.A06.getInputBuffers();
            MediaCodec mediaCodec = this.A06;
            if (A0e[5].length() == 20) {
                throw new RuntimeException();
            }
            A0e[2] = "BQUwUvW99pDNY9ExELsrhPAvhUrne6";
            this.A0T = mediaCodec.getOutputBuffers();
        }
    }

    private void A0d() throws C04879c {
        if (this.A02 == 2) {
            A1H();
            A1J();
            return;
        }
        this.A0N = true;
        A1I();
    }

    private void A0e() {
        if (IF.A02 < 21) {
            this.A0T = this.A06.getOutputBuffers();
        }
    }

    private void A0f() throws C04879c {
        MediaFormat outputFormat = this.A06.getOutputFormat();
        if (this.A00 != 0 && outputFormat.getInteger(A0Z(781, 5, 7)) == 32 && outputFormat.getInteger(A0Z(744, 6, 55)) == 32) {
            this.A0O = true;
            return;
        }
        if (this.A0I) {
            outputFormat.setInteger(A0Z(638, 13, 38), 1);
        }
        A1L(this.A06, outputFormat);
    }

    private void A0g() {
        if (IF.A02 < 21) {
            this.A0S = null;
            this.A0T = null;
        }
    }

    private void A0h() {
        this.A03 = -1;
        this.A0X.A01 = null;
    }

    private void A0i() {
        this.A04 = -1;
        this.A0B = null;
    }

    private void A0k(DI di2) throws C04879c {
        throw C04879c.A01(di2, A0z());
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0139, code lost:
        if (r6 == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013b, code lost:
        A0d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x013e, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0146, code lost:
        if (r6 == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014b, code lost:
        if (r13.A0G == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014e, code lost:
        r13.A0K = true;
        r13.A06.queueInputBuffer(r13.A03, 0, 0, 0, 4);
        A0h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x015f, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0160, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0169, code lost:
        throw com.facebook.ads.redexgen.X.C04879c.A01(r1, A0z());
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x018a, code lost:
        if (r8.A05() == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x018c, code lost:
        r13.A0X.A07();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0193, code lost:
        if (r13.A01 != 2) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0195, code lost:
        r13.A01 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0197, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01a8, code lost:
        if (r8.A05() == false) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean A0l() throws com.facebook.ads.redexgen.X.C04879c {
        /*
            Method dump skipped, instructions count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC04276j.A0l():boolean");
    }

    private boolean A0m() {
        return this.A04 >= 0;
    }

    private boolean A0n(long j2) {
        int size = this.A0b.size();
        for (int i = 0; i < size; i++) {
            int size2 = (this.A0b.get(i).longValue() > j2 ? 1 : (this.A0b.get(i).longValue() == j2 ? 0 : -1));
            if (size2 == 0) {
                this.A0b.remove(i);
                int i5 = A0e[1].charAt(18);
                if (i5 != 119) {
                    throw new RuntimeException();
                }
                A0e[5] = "GAQPkPxILqrNxqRn";
                return true;
            }
        }
        return false;
    }

    private boolean A0o(long j2, long j4) throws C04879c {
        boolean processedOutputBuffer;
        int dequeueOutputBuffer;
        if (!A0m()) {
            if (this.A0F && this.A0K) {
                try {
                    dequeueOutputBuffer = this.A06.dequeueOutputBuffer(this.A0V, A0X());
                } catch (IllegalStateException unused) {
                    A0d();
                    if (this.A0N) {
                        A1H();
                    }
                    return false;
                }
            } else {
                dequeueOutputBuffer = this.A06.dequeueOutputBuffer(this.A0V, A0X());
            }
            if (dequeueOutputBuffer >= 0) {
                if (this.A0O) {
                    this.A0O = false;
                    this.A06.releaseOutputBuffer(dequeueOutputBuffer, false);
                    return true;
                }
                int outputIndex = this.A0V.size;
                if (outputIndex == 0) {
                    int outputIndex2 = this.A0V.flags;
                    if ((outputIndex2 & 4) != 0) {
                        A0d();
                        return false;
                    }
                }
                this.A04 = dequeueOutputBuffer;
                ByteBuffer A0b = A0b(dequeueOutputBuffer);
                this.A0B = A0b;
                if (A0b != null) {
                    int outputIndex3 = this.A0V.offset;
                    A0b.position(outputIndex3);
                    ByteBuffer byteBuffer = this.A0B;
                    int i = this.A0V.offset;
                    int outputIndex4 = this.A0V.size;
                    int i5 = i + outputIndex4;
                    if (A0e[2].length() != 1) {
                        String[] strArr = A0e;
                        strArr[4] = "FaJE2XiArfhYqeNyfkTyaQ";
                        strArr[6] = "HvmGKe0EFE5f200jghUPQNW";
                        byteBuffer.limit(i5);
                    }
                }
                this.A0P = A0n(this.A0V.presentationTimeUs);
            } else if (A0e[5].length() != 20) {
                A0e[1] = "HT1pBWWLOYy8PEf8scwcSavywhmMK5P3";
                if (dequeueOutputBuffer == -2) {
                    A0f();
                    String[] strArr2 = A0e;
                    String str = strArr2[4];
                    String str2 = strArr2[6];
                    int length = str.length();
                    int outputIndex5 = str2.length();
                    if (length != outputIndex5) {
                        A0e[5] = "todLl0dSZi0vPTtgICo1ottwNzErViL";
                        return true;
                    }
                    return true;
                } else if (A0e[0].charAt(8) != 's') {
                    A0e[5] = "4PVEqwR";
                    if (dequeueOutputBuffer == -3) {
                        A0e();
                        return true;
                    }
                    boolean z2 = this.A0G;
                    if (A0e[0].charAt(8) != 's') {
                        A0e[1] = "oPTnjsm2EBoNSW7B2QwBvulptlCCgQiW";
                        if (z2 && (this.A0M || this.A02 == 2)) {
                            A0d();
                        }
                        return false;
                    }
                    throw new RuntimeException();
                } else {
                    throw new RuntimeException();
                }
            }
            throw new RuntimeException();
        }
        if (this.A0F && this.A0K) {
            try {
                processedOutputBuffer = A1Q(j2, j4, this.A06, this.A0B, this.A04, this.A0V.flags, this.A0V.presentationTimeUs, this.A0P);
            } catch (IllegalStateException unused2) {
                A0d();
                if (this.A0N) {
                    A1H();
                }
                return false;
            }
        } else {
            processedOutputBuffer = A1Q(j2, j4, this.A06, this.A0B, this.A04, this.A0V.flags, this.A0V.presentationTimeUs, this.A0P);
        }
        if (processedOutputBuffer) {
            A1K(this.A0V.presentationTimeUs);
            boolean processedOutputBuffer2 = (this.A0V.flags & 4) != 0;
            A0i();
            if (!processedOutputBuffer2) {
                return true;
            }
            A0d();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0026, code lost:
        if (r0.equals(r3) == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A0p(com.facebook.ads.redexgen.X.DG r4) {
        /*
            java.lang.String r3 = r4.A02
            int r1 = com.facebook.ads.redexgen.X.IF.A02
            r0 = 17
            if (r1 > r0) goto L28
            r2 = 565(0x235, float:7.92E-43)
            r1 = 24
            r0 = 13
            java.lang.String r0 = A0Z(r2, r1, r0)
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L67
            r2 = 418(0x1a2, float:5.86E-43)
            r1 = 31
            r0 = 114(0x72, float:1.6E-43)
            java.lang.String r0 = A0Z(r2, r1, r0)
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L67
        L28:
            java.lang.String r3 = com.facebook.ads.redexgen.X.IF.A05
            r2 = 139(0x8b, float:1.95E-43)
            r1 = 6
            r0 = 123(0x7b, float:1.72E-43)
            java.lang.String r0 = A0Z(r2, r1, r0)
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L69
            r2 = 135(0x87, float:1.89E-43)
            r1 = 4
            r0 = 19
            java.lang.String r3 = A0Z(r2, r1, r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AbstractC04276j.A0e
            r0 = 5
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 20
            if (r1 == r0) goto L6b
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC04276j.A0e
            java.lang.String r1 = "ta8dfTbq5GbSxrQo9R7BCH"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "TLzt7USKw6C8aMs6TrECz9n"
            r0 = 6
            r2[r0] = r1
            java.lang.String r0 = com.facebook.ads.redexgen.X.IF.A06
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L69
            boolean r0 = r4.A05
            if (r0 == 0) goto L69
        L67:
            r0 = 1
        L68:
            return r0
        L69:
            r0 = 0
            goto L68
        L6b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC04276j.A0p(com.facebook.ads.redexgen.X.DG):boolean");
    }

    public static boolean A0q(String str) {
        if (IF.A02 > 23 || !A0Z(540, 25, 4).equals(str)) {
            if (IF.A02 <= 19) {
                if (!A0Z(738, 6, R.styleable.AppCompatTheme_textColorSearchUrl).equals(IF.A03) || (!A0Z(449, 31, 61).equals(str) && !A0Z(480, 38, 24).equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean A0r(String str) {
        return IF.A02 == 21 && A0Z(518, 22, 33).equals(str);
    }

    public static boolean A0s(String str) {
        return IF.A02 < 18 || (IF.A02 == 18 && (A0Z(381, 15, 120).equals(str) || A0Z(396, 22, R.styleable.AppCompatTheme_tooltipForegroundColor).equals(str))) || (IF.A02 == 19 && IF.A06.startsWith(A0Z(603, 7, 83)) && (A0Z(237, 18, 51).equals(str) || A0Z(255, 25, 86).equals(str)));
    }

    public static boolean A0t(String str, Format format) {
        return IF.A02 < 21 && format.A0P.isEmpty() && A0Z(305, 25, 38).equals(str);
    }

    public static boolean A0u(String str, Format format) {
        return IF.A02 <= 18 && format.A05 == 1 && A0Z(280, 25, 92).equals(str);
    }

    private boolean A0v(boolean z2) throws C04879c {
        if (0 == 0 || (!z2 && this.A0c)) {
            return false;
        }
        throw new NullPointerException(A0Z(723, 8, 95));
    }

    @Override // com.facebook.ads.redexgen.X.EM
    public void A13() {
    }

    @Override // com.facebook.ads.redexgen.X.EM
    public void A14() {
    }

    @Override // com.facebook.ads.redexgen.X.EM
    public void A15() {
        this.A07 = null;
        try {
            A1H();
            if (0 != 0) {
                try {
                    throw new NullPointerException(A0Z(750, 14, 15));
                } catch (Throwable th) {
                    if (0 != 0 && 0 != 0) {
                        try {
                            throw new NullPointerException(A0Z(750, 14, 15));
                        } finally {
                        }
                    }
                    throw th;
                }
            } else if (0 != 0 && 0 != 0) {
                try {
                    throw new NullPointerException(A0Z(750, 14, 15));
                } finally {
                }
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    throw new NullPointerException(A0Z(750, 14, 15));
                } catch (Throwable th3) {
                    if (0 != 0 && 0 != 0) {
                        try {
                            throw new NullPointerException(A0Z(750, 14, 15));
                        } finally {
                        }
                    }
                    throw th3;
                }
            } else if (0 != 0 && 0 != 0) {
                try {
                    throw new NullPointerException(A0Z(750, 14, 15));
                } finally {
                }
            } else {
                throw th2;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.EM
    public void A16(long j2, boolean z2) throws C04879c {
        this.A0M = false;
        this.A0N = false;
        if (this.A06 != null) {
            A1G();
        }
    }

    @Override // com.facebook.ads.redexgen.X.EM
    public void A17(boolean z2) throws C04879c {
        this.A0U = new BC();
    }

    public final MediaCodec A1D() {
        return this.A06;
    }

    public final DG A1E() {
        return this.A0A;
    }

    public DG A1F(DM dm2, Format format, boolean z2) throws DP {
        return dm2.A6m(format.A0O, z2);
    }

    public void A1G() throws C04879c {
        this.A05 = -9223372036854775807L;
        A0h();
        A0i();
        this.A0Q = true;
        this.A0R = false;
        this.A0P = false;
        this.A0b.clear();
        this.A0C = false;
        this.A0O = false;
        if (this.A0H || (this.A0E && this.A0K)) {
            A1H();
            A1J();
        } else if (this.A02 != 0) {
            A1H();
            A1J();
        } else {
            this.A06.flush();
            this.A0J = false;
        }
        if (this.A0L && this.A07 != null) {
            this.A01 = 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c8, code lost:
        if (0 != 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d2, code lost:
        if (0 != 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e3, code lost:
        throw new java.lang.NullPointerException(A0Z(750, 14, 15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e4, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e7, code lost:
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A1H() {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC04276j.A1H():void");
    }

    public void A1I() throws C04879c {
    }

    public final void A1J() throws C04879c {
        Format format;
        long j2;
        if (this.A06 != null || (format = this.A07) == null) {
            return;
        }
        this.A08 = null;
        String str = format.A0O;
        String[] strArr = A0e;
        if (strArr[7].charAt(15) == strArr[3].charAt(15)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0e;
        strArr2[7] = "pTVSxclXptnWdkcsOldSnbHbt080oNsP";
        strArr2[3] = "3A2dqVKC7anzB9bdQIqtLGHUlM9PHMrl";
        if (0 != 0) {
            throw new NullPointerException(A0Z(709, 14, 53));
        }
        if (this.A0A == null) {
            try {
                DG A1F = A1F(this.A0a, this.A07, false);
                this.A0A = A1F;
                if (A1F == null && 0 != 0) {
                    DG A1F2 = A1F(this.A0a, this.A07, false);
                    this.A0A = A1F2;
                    if (A1F2 != null) {
                        Log.w(A0Z(219, 18, 125), A0Z(145, 40, 32) + str + A0Z(0, 58, 64) + this.A0A.A02 + A0Z(58, 1, 4));
                    }
                }
                if (this.A0A == null) {
                    A0k(new DI(this.A07, (Throwable) null, false, -49999));
                    throw null;
                }
            } catch (DP e2) {
                A0k(new DI(this.A07, (Throwable) e2, false, -49998));
                throw null;
            }
        }
        if (!A1R(this.A0A)) {
            return;
        }
        String str2 = this.A0A.A02;
        this.A00 = A0W(str2);
        this.A0D = A0t(str2, this.A07);
        this.A0H = A0s(str2);
        this.A0G = A0p(this.A0A);
        this.A0E = A0q(str2);
        this.A0F = A0r(str2);
        this.A0I = A0u(str2, this.A07);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            IC.A02(A0Z(665, 12, 94) + str2);
            this.A06 = MediaCodec.createByCodecName(str2);
            IC.A00();
            IC.A02(A0Z(651, 14, 81));
            A1O(this.A0A, this.A06, this.A07, null);
            IC.A00();
            IC.A02(A0Z(764, 10, 125));
            this.A06.start();
            IC.A00();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            A1P(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
            A0c();
            if (A81() == 2) {
                j2 = SystemClock.elapsedRealtime() + 1000;
            } else {
                j2 = -9223372036854775807L;
            }
            this.A05 = j2;
            A0h();
            A0i();
            this.A0Q = true;
            this.A0U.A00++;
        } catch (Exception e3) {
            A0k(new DI(this.A07, (Throwable) e3, false, str2));
            throw null;
        }
    }

    public void A1K(long j2) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009b, code lost:
        if (r0.A08 == r4.A08) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A1M(com.facebook.ads.internal.exoplayer2.thirdparty.Format r7) throws com.facebook.ads.redexgen.X.C04879c {
        /*
            r6 = this;
            com.facebook.ads.internal.exoplayer2.thirdparty.Format r4 = r6.A07
            r6.A07 = r7
            com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData r2 = r7.A0H
            r1 = 0
            if (r4 != 0) goto L2e
            r0 = r1
        La:
            boolean r0 = com.facebook.ads.redexgen.X.IF.A0g(r2, r0)
            r3 = 1
            r0 = r0 ^ r3
            if (r0 == 0) goto L4b
            com.facebook.ads.internal.exoplayer2.thirdparty.Format r0 = r6.A07
            com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData r0 = r0.A0H
            if (r0 == 0) goto L49
            r0 = 0
            if (r0 == 0) goto L31
            android.os.Looper.myLooper()
            r2 = 624(0x270, float:8.74E-43)
            r1 = 14
            r0 = 48
            java.lang.String r1 = A0Z(r2, r1, r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r1)
            throw r0
        L2e:
            com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData r0 = r4.A0H
            goto La
        L31:
            r2 = 185(0xb9, float:2.59E-43)
            r1 = 34
            r0 = 111(0x6f, float:1.56E-43)
            java.lang.String r0 = A0Z(r2, r1, r0)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            int r0 = r6.A0z()
            com.facebook.ads.redexgen.X.9c r0 = com.facebook.ads.redexgen.X.C04879c.A01(r1, r0)
            throw r0
        L49:
            r6.A09 = r1
        L4b:
            r5 = 0
            r1 = 0
            r0 = 0
            if (r1 != r0) goto La4
            android.media.MediaCodec r2 = r6.A06
            if (r2 == 0) goto La4
            com.facebook.ads.redexgen.X.DG r1 = r6.A0A
            com.facebook.ads.internal.exoplayer2.thirdparty.Format r0 = r6.A07
            int r0 = r6.A1B(r2, r1, r4, r0)
            switch(r0) {
                case 0: goto La4;
                case 1: goto La3;
                case 2: goto L5f;
                case 3: goto L65;
                default: goto L5f;
            }
        L5f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L65:
            r5 = 1
            r6.A0L = r3
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AbstractC04276j.A0e
            r0 = 1
            r1 = r1[r0]
            r0 = 18
            char r1 = r1.charAt(r0)
            r0 = 119(0x77, float:1.67E-43)
            if (r1 == r0) goto L7d
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L7d:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC04276j.A0e
            java.lang.String r1 = "470Pj9QxuaVscsy8pk25MlpSOfE9YJj"
            r0 = 5
            r2[r0] = r1
            r6.A01 = r3
            int r1 = r6.A00
            r0 = 2
            if (r1 == r0) goto L9d
            if (r1 != r3) goto La1
            com.facebook.ads.internal.exoplayer2.thirdparty.Format r0 = r6.A07
            int r1 = r0.A0F
            int r0 = r4.A0F
            if (r1 != r0) goto La1
            com.facebook.ads.internal.exoplayer2.thirdparty.Format r0 = r6.A07
            int r1 = r0.A08
            int r0 = r4.A08
            if (r1 != r0) goto La1
        L9d:
            r0 = 1
        L9e:
            r6.A0C = r0
            goto La4
        La1:
            r0 = 0
            goto L9e
        La3:
            r5 = 1
        La4:
            if (r5 != 0) goto Lac
            boolean r0 = r6.A0J
            if (r0 == 0) goto Lad
            r6.A02 = r3
        Lac:
            return
        Lad:
            r6.A1H()
            r6.A1J()
            goto Lac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC04276j.A1M(com.facebook.ads.internal.exoplayer2.thirdparty.Format):void");
    }

    public boolean A1R(DG dg) {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.Y5
    public boolean A91() {
        return this.A0N;
    }

    @Override // com.facebook.ads.redexgen.X.Y5
    public boolean A9C() {
        return (this.A07 == null || this.A0R || (!A19() && !A0m() && (this.A05 == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.A05))) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
        if (r6.A06 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
        com.facebook.ads.redexgen.X.IC.A02(A0Z(677, 12, 39));
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0075, code lost:
        if (A0o(r7, r9) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0081, code lost:
        if (r6.A06 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
        if (A0l() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008b, code lost:
        com.facebook.ads.redexgen.X.IC.A00();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008f, code lost:
        r6.A0U.A07 += A10(r7);
        r6.A0Y.A07();
        r0 = A11(r6.A0W, r6.A0Y, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
        if (r0 != (-5)) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00aa, code lost:
        A1M(r6.A0W.A00);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b7, code lost:
        if (r0 != (-4)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b9, code lost:
        com.facebook.ads.redexgen.X.AbstractC0672Ha.A04(r6.A0Y.A04());
        r6.A0M = true;
        A0d();
     */
    @Override // com.facebook.ads.redexgen.X.Y5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AFB(long r7, long r9) throws com.facebook.ads.redexgen.X.C04879c {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC04276j.AFB(long, long):void");
    }

    @Override // com.facebook.ads.redexgen.X.AA
    public final int AGe(Format format) throws C04879c {
        try {
            return A1C(this.A0a, null, format);
        } catch (DP e2) {
            throw C04879c.A01(e2, A0z());
        }
    }

    @Override // com.facebook.ads.redexgen.X.EM, com.facebook.ads.redexgen.X.AA
    public final int AGg() {
        return 8;
    }
}
